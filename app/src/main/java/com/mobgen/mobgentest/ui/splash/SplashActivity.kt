package com.mobgen.mobgentest.ui.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mobgen.mobgentest.R
import com.mobgen.mobgentest.ui.main.MainActivity
import com.mobgen.mobgentest.utils.Result
import com.mobgen.mobgentest.utils.bulletList
import com.mobgen.mobgentest.utils.observe
import com.mobgen.mobgentest.utils.toBulletedList
import kotlinx.android.synthetic.main.activity_splash.*
import org.koin.android.viewmodel.ext.android.getViewModel
import org.koin.android.viewmodel.ext.android.viewModel

const val TAG = "SplashActivity"

class SplashActivity : AppCompatActivity() {

    private val viewModel: SplashViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        observe(viewModel.categories) {
            when (it) {
                is Result.Success -> {
                    Log.i(TAG, "onCreate: Result GOOD")
                    //textView.text = listOf("hola","lola","pola").toBulletedList()
                    //textView.text = listOf("hola","lola","pola").bulletList()
                    MainActivity.callMainActivity(this,it.value)
                    finish()
                }
                is Result.Error -> Log.i(TAG, "onCreate: Result BAD: ${it.message}")
                else -> Log.i(TAG, "onCreate: Result BAD: OTHER")
            }
        }

    }
}