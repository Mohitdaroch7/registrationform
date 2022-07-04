package com.example.registrationform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText

class PhoneActivity : AppCompatActivity() {
    lateinit var etphone:EditText
    lateinit var btn_verify: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_phone)
        etphone=findViewById(R.id.etPhone)
        btn_verify=findViewById(R.id.btn_verify)
        btn_verify.setOnClickListener {
            var enteredetphone=etphone.text.toString()
            var enteredbtn_verify=btn_verify.text.toString()
            if (TextUtils.isEmpty(enteredetphone)|| enteredetphone.length<10){
                etphone.error=("PHONE NUMBER IS EMPTY OR LESS THAN 10 DIGITS")
                return@setOnClickListener
            }
            else{
                var intent= Intent(this,OtpActivity::class.java)
                intent.putExtra("phone", etphone.text.toString())
                startActivity(intent)
            }
        }
    }
}