package com.mobgen.mobgentest.ui.detail

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobgen.mobgentest.R
import com.mobgen.mobgentest.domain.Category
import com.mobgen.mobgentest.utils.Result
import com.mobgen.mobgentest.utils.observe
import kotlinx.android.synthetic.main.activity_detail.*
import org.koin.android.viewmodel.ext.android.viewModel
import org.koin.core.parameter.parametersOf
import java.io.Serializable

class DetailActivity : AppCompatActivity() {

    private val category by lazy { intent.getSerializableExtra(CATEGORY_PARAM) as Category }
    private val viewModel: DetailViewModel by viewModel { parametersOf(category.type) }
    private val adapter: DetailsAdapter by lazy { DetailsAdapter(category) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        initViews()
        setupObserver()
    }

    fun initViews() {
        supportActionBar?.apply {
            setDisplayHomeAsUpEnabled(true)
            title = category.name
        }
        rv_detail.layoutManager = LinearLayoutManager(this)
        rv_detail.setHasFixedSize(true)
        rv_detail.adapter = adapter
    }

    fun setupObserver() {
        observe(viewModel.details) {
            progressBar.visibility = View.GONE
            when (it) {
                is Result.Success -> adapter.submitData(it.value)
                is Result.Error -> Log.i(com.mobgen.mobgentest.ui.splash.TAG, "onCreate: Result BAD: ${it.message}")
                else -> Log.i(com.mobgen.mobgentest.ui.splash.TAG, "onCreate: Result BAD: OTHER")
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home)
            finish()
        return super.onOptionsItemSelected(item)
    }

    companion object {

        private const val CATEGORY_PARAM = "category_param"

        fun callDetailActivity(context: Context, category: Category) {
            val intent = Intent(context, DetailActivity::class.java).apply {
                putExtra(CATEGORY_PARAM,category as Serializable)
            }
            context.startActivity(intent)
        }

    }
}