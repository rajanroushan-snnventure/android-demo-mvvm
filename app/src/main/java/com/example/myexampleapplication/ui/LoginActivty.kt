package com.example.myexampleapplication.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.*
import com.example.myexampleapplication.R
import com.example.myexampleapplication.ui.registration.RegistrationActivity
import com.example.myexampleapplication.ui.registration.RegistrationModel
import com.example.myexampleapplication.ui.registration.RegistrationViewModel
import kotlinx.android.synthetic.main.login_activity.*
import kotlinx.android.synthetic.main.login_activity.input_password
import kotlinx.android.synthetic.main.login_activity.input_phone
import kotlinx.android.synthetic.main.registration_activity.*


//when we will go from one activity to another activity that time onstop of the 1st activity will called
//at that time activty will not observing the live data but viewmodel having the updated data.

class LoginActivty: AppCompatActivity() {

    private lateinit var loginViewModel: RegistrationViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.login_activity)

        loginViewModel = ViewModelProvider(this@LoginActivty).get(RegistrationViewModel::class.java)

        btn_login.setOnClickListener(View.OnClickListener {
            var phone = input_phone.editText?.text.toString()
            var password = input_password.editText?.text.toString()
            if(phone.isBlank()){

                input_phone.editText?.error = "Please enter phone number"

            }else if(password.isBlank()){

                input_password.editText?.error = "Please enter password"

            }else{
                //Here we can move to the next activity.

                loginViewModel.phoneAvl.observe(this, androidx.lifecycle.Observer {

                    Log.e("Login Activity", it)
                })



            }
        })

    }
}