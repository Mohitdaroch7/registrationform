package com.example.registrationform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.doOnTextChanged

class MainActivity : AppCompatActivity() {
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var forget: TextView
    private lateinit var login: Button
    private lateinit var create: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        email=findViewById(R.id.etEmail)
        password=findViewById(R.id.etPassword)
        forget=findViewById(R.id.tforget)
        login=findViewById(R.id.btn_login)
        create=findViewById(R.id.textView)
        forget.setOnClickListener {
            var intent = Intent(this, ForgetPasswordActivity::class.java)
            startActivity(intent)
            this.finish()
        }
        create.setOnClickListener {
            var intent = Intent(this, RegistrationActivity::class.java)
            startActivity(intent)
            this.finish()
        }
        login.setOnClickListener {
            var enteredemail=email.text.toString()
            var enteredpassword=password.text.toString()
            if (TextUtils.isEmpty(enteredemail) || enteredemail.contains("@gmail")){
               email.error=("email is empty or incorrect")
                return@setOnClickListener
            }
            else if (TextUtils.isEmpty(enteredpassword) || enteredpassword.length<6){
                password.error=("password is empty or less than 6 digits")
                return@setOnClickListener
            }else{
                var intent=Intent(this, ScreenActivity::class.java)
                startActivity(intent)
                this.finish()
            }
        }


    }
}