package com.mobgen.mobgentest.utils

import android.app.Activity
import android.widget.ImageView
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import androidx.core.graphics.drawable.TintAwareDrawable
import androidx.core.text.HtmlCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.*
import com.bumptech.glide.Glide
import com.bumptech.glide.Priority

internal fun Activity.attachFragment(manager: FragmentManager, containerId: Int, view: Fragment, tag: String) {
    manager.beginTransaction()
        .replace(containerId, view, tag)
        .commitNowAllowingStateLoss()
}

inline fun <reified T> Result<T>.doIfFailure(callback: (error: String?, throwable: Throwable?) -> Unit) {
    if (this is Result.Error) {
        callback(message, throwable)
    }
}

inline fun <reified T> Result<T>.doIfSuccess(callback: (value: T) -> Unit) {
    if (this is Result.Success) {
        callback(value)
    }
}

inline fun <reified T, reified R> Result<T>.convertIfSuccess(convert: (value: T) -> R): Result<R> {
    return when (this) {
        is Result.Success -> {
            val result = convert(value)
            Result.build { result }
        }
        is Result.Error -> Result.Error(message,throwable)
        else -> Result.Error("Undefined",null)
    }
}

// ----------- Handler LifeCycle Extensions ----------- //

inline fun<reified MODEL : ViewModel> FragmentActivity.getViewModel(crossinline factory: () -> MODEL): MODEL {
    val viewModelFactory = object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T = factory() as T
    }

    return ViewModelProvider(this, viewModelFactory)[MODEL::class.java]
}

inline fun<reified MODEL : ViewModel> Fragment.getViewModel(crossinline factory: () -> MODEL): MODEL {
    val viewModelFactory = object : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T = factory() as T
    }

    return ViewModelProvider(this, viewModelFactory)[MODEL::class.java]
}

//LIVEDATA
/**
 * Extension para subscribir el observer de [LiveData]
 */
fun <T : Any, L : LiveData<T>> LifecycleOwner.observe(liveData: L, body: (T?) -> Unit) {
    liveData.observe(this, Observer(body))
}


// Handler images

fun ImageView.loadUrl(url: String, width: Int = this.width, height: Int = this.height) {
    Glide.with(context).load(url).placeholder(android.R.drawable.ic_menu_report_image)
        .skipMemoryCache(true).priority(Priority.IMMEDIATE)
            .dontAnimate().override(width,height).into(this)
}

/**
 * Metodo extendido del ImageView para realizar el cambio de color a la imagen que se
 * muestra dentro del widget
 *
 * @param colorRes color que se quiere tintar
 */
fun ImageView.tintSrc(@ColorRes colorRes: Int) {
    val drawable = DrawableCompat.wrap(drawable)
    DrawableCompat.setTint(drawable, ContextCompat.getColor(context, colorRes))
    setImageDrawable(drawable)
    if (drawable is TintAwareDrawable) invalidate()
}

fun Collection<String>.bulletList(): String {
    return "\n" + this.joinToString(separator = "\n") {
        HtmlCompat.fromHtml("&#8226 $it",HtmlCompat.FROM_HTML_MODE_LEGACY)
    }
}