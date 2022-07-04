package com.example.registrationform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.doOnTextChanged

class ForgetPasswordActivity : AppCompatActivity() {
    lateinit var password: EditText
    lateinit var cpassword:EditText
    lateinit var button: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forget_password)
        button=findViewById(R.id.btn_done)
        password=findViewById(R.id.etnewpassword)
        cpassword=findViewById(R.id.etconfirmpassword)

        button.setOnClickListener {
          var enteredpassword=password.text.toString()
            var enteredcpassword=cpassword.text.toString()
            if (TextUtils.isEmpty(enteredpassword) || enteredpassword.length<6){
                password.error=("PASSWORD IS LESS THAN 6")
                return@setOnClickListener
            }else if (TextUtils.isEmpty(enteredcpassword) || !enteredpassword.equals(enteredcpassword)){
            cpassword.error=("PASSWORD DOES NOT MATCH")
                return@setOnClickListener
        }else{
            var intent=Intent(this, ScreenActivity::class.java)
                startActivity(intent)
        }
        }
    }
}