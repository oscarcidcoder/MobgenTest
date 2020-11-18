package com.mobgen.mobgentest.ui.main

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.mobgen.mobgentest.R
import com.mobgen.mobgentest.domain.Category
import java.io.Serializable

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val categories = intent.getSerializableExtra(CATEGORIES_PARAM)

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

}