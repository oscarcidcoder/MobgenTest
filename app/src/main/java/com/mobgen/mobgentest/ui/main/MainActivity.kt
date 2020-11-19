package com.mobgen.mobgentest.ui.main

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.LinearLayoutManager
import com.mobgen.mobgentest.R
import com.mobgen.mobgentest.domain.Category
import com.mobgen.mobgentest.ui.detail.DetailActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.io.Serializable

class MainActivity : AppCompatActivity(), CategoryClickListener {

    private val adapter: CategoryAdapter by lazy { CategoryAdapter(this) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val categories = intent.getSerializableExtra(CATEGORIES_PARAM) as List<Category>
        initViews(categories = categories)
    }

    fun initViews(categories: List<Category>) {
        rv_category.layoutManager = LinearLayoutManager(this)
        rv_category.setHasFixedSize(true)
        rv_category.adapter = adapter
        adapter.submitList(categories)
    }


    companion object {

        private const val CATEGORIES_PARAM = "categories_list_param"

        fun callMainActivity(context: Context, categories: List<Category>) {
            val intent = Intent(context,MainActivity::class.java).apply {
                putExtra(CATEGORIES_PARAM,categories as Serializable)
            }
            context.startActivity(intent)
        }

    }

    override fun onCategoryClick(category: Category, position: Int) {
        DetailActivity.callDetailActivity(this,category)
    }

}