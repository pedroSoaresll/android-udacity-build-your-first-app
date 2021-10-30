package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val myName: MyName = MyName(name = "Caroline Bicouv")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.myName = myName

        binding.apply {
            doneButton.setOnClickListener { addNickname(it) }
        }
    }

    private fun addNickname(view: View) {
        binding.apply {
            invalidateAll()
            doneButton.visibility = View.INVISIBLE
            nicknameShow.visibility = View.VISIBLE
            nicknameEdit.visibility = View.INVISIBLE
            myName?.nickname = nicknameEdit.text.toString()
        }

        val inputMethodManager =
            getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
    }
}