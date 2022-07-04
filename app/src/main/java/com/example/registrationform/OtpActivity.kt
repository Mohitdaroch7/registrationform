package com.example.registrationform

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.widget.Button
import android.widget.EditText
import androidx.core.widget.doOnTextChanged

class OtpActivity : AppCompatActivity() {
    lateinit var etnumber1: EditText
    lateinit var etnumber2: EditText
    lateinit var etnumber3: EditText
    lateinit var etnumber4: EditText
    lateinit var btn_verifyotp: Button
    lateinit var phoneNumber: String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otp)
        etnumber1=findViewById(R.id.etnumber1)
        etnumber2=findViewById(R.id.etnumber2)
        etnumber3=findViewById(R.id.etnumber3)
        etnumber4=findViewById(R.id.etnumber4)
        btn_verifyotp=findViewById(R.id.btn_verifyotp)
        intent?.let {yourVariable->
            phoneNumber = yourVariable.getStringExtra("phone").toString()
            System.out.println(phoneNumber)
        }?:kotlin.run {
            System.out.println("in error")
        }
        etnumber1.doOnTextChanged { text, start, before, count ->  }

        btn_verifyotp.setOnClickListener {
            var enteredetnumber1=etnumber1.text.toString()
            var enteredetnumber2=etnumber2.text.toString()
            var enteredetnumber3=etnumber3.text.toString()
            var enteredetnumber4=etnumber4.text.toString()
            if (TextUtils.isEmpty(enteredetnumber1)){
                this.etnumber2.requestFocus()
            etnumber1.error=("FILL")
            return@setOnClickListener
        } else if (TextUtils.isEmpty(enteredetnumber2)){
            this.etnumber2.requestFocus()
                etnumber2.error=("FILL")
            return@setOnClickListener
        }else if (TextUtils.isEmpty(enteredetnumber3)){
            this.etnumber3.requestFocus()
                etnumber3.error=("FILL")
            return@setOnClickListener
        }else if (TextUtils.isEmpty(enteredetnumber4)){
            this.etnumber4.requestFocus()
                etnumber4.error=("FILL")
            return@setOnClickListener
        }else{
            var intent= Intent(this, ScreenActivity::class.java)
                startActivity(intent)
        }

        }
    }
}