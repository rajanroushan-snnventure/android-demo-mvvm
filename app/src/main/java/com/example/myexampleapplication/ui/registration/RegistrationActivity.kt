package com.example.myexampleapplication.ui.registration

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import androidx.lifecycle.ViewModelProvider
import com.example.myexampleapplication.R
import com.example.myexampleapplication.db.Note
import com.example.myexampleapplication.ui.LoginActivty
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.registration_activity.*
import java.util.*
import java.util.stream.Collector.of

class RegistrationActivity:AppCompatActivity(){

    private lateinit var registrationViewModel : RegistrationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registration_activity)

        // Get input text

//        input_Name.editText?.doOnTextChanged { inputText, _, _, _ ->
//            // Respond to input text change
//
//        }


        registrationViewModel = ViewModelProvider(this@RegistrationActivity).get(RegistrationViewModel::class.java)

        btn_submit.setOnClickListener(View.OnClickListener {
            val inputName = input_Name.editText?.text.toString()
            val inputPass = input_password.editText?.text.toString()
            val inputPhone = input_phone.editText?.text.toString()
            val inputQualification = input_qualification.editText?.text.toString()


            if(inputName.isBlank()){
                input_Name?.error = "Please enter name."
                input_Name.isFocusable = true
            }else if(inputPass.isBlank() && inputPass.length > 4){
                input_password?.error = "Please enter correctly password."
                input_password.isFocusable = true
            }else if(inputPhone.isBlank() && inputPhone.length == 10){
                input_password?.error = "Please enter correctly phone."
                input_password.isFocusable = true
            }else if(inputQualification.isBlank()){
                input_qualification?.error = "Please enter qualification."
                input_qualification.isFocusable = true
            }else{
                val id:String = UUID.randomUUID().toString()
                val user = Note(id,inputName,inputPass,inputPhone,inputQualification)
                registrationViewModel.insert(user)
                val intent_login = Intent(this,LoginActivty::class.java)
                startActivity(intent_login)
                Toast.makeText(this , "Registration Data Saved." , Toast.LENGTH_LONG).show()
            }
        })


    }
}