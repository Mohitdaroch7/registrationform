package com.example.registrationform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doOnTextChanged


class RegistrationActivity : AppCompatActivity() {
    private lateinit var fullname: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var cpassword: EditText
    private lateinit var button: Button
    private lateinit var login: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)
        fullname = findViewById(R.id.etName)
        email = findViewById(R.id.etEmailAddress)
        password = findViewById(R.id.etPassword)
        password.doOnTextChanged { text, start, before, count ->
            if ((text?.length ?: 0) < 6) {
                password.requestFocus()
                password.error = ("PASSWORD MUST BE 6 DIGITS")
            }
        }

        cpassword = findViewById(R.id.etconfirmpassword)
        button = findViewById(R.id.btn_register)
        login = findViewById(R.id.login)
        login.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        button.setOnClickListener {
            var enteredfullname = fullname.text.toString()
            var enteredemail = email.text.toString()
            var enteredpassword = password.text.toString()
            var enteredcpass = cpassword.text.toString()
            if (TextUtils.isEmpty(enteredfullname) || enteredfullname.length < 3) {
                fullname.error = ("NAME IS EMPTY OR INCORRECT")
                return@setOnClickListener
            } else if (!enteredemail.contains("@")) {
                email.error = ("EMAIL IS EMPTY OR INVALID")
                return@setOnClickListener
            } else if ( enteredpassword.length < 6) {
                password.error = ("PASSWORD IS EMPTY OR LESS THAN 6 DIGITS")
                return@setOnClickListener
            } else if ( !enteredpassword.equals(enteredcpass)) {
                cpassword.error = ("PASSWORD DOES NOT MATCH")
                return@setOnClickListener
            }
            else{
                var intent = Intent(this, PhoneActivity::class.java)
                startActivity(intent)
            }
        }
    }
}