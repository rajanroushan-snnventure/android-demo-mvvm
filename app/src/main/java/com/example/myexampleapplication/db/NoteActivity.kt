package com.example.myexampleapplication.db

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.myexampleapplication.R
import java.util.*

class NoteActivity:AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val noteviewmodel:NoteViewModel? = ViewModelProvider(this).get(NoteViewModel::class.java)

        val editText_phone:EditText = findViewById(R.id.phone_editText)
        val editText_pass : EditText = findViewById(R.id.pass_editText)
        val button:Button = findViewById(R.id.click_button)
        button.setOnClickListener(View.OnClickListener {
                val id:String = UUID.randomUUID().toString()
                val phone:String = editText_phone.text.toString()
                val pass:String = editText_pass.text.toString()
                val note = Note(id,"rajan",pass,phone,"b.tech")
                //noteviewmodel.insert(note)
                print("$id  $phone  $pass" )
        })
        //working fine
//        noteviewmodel?.fetch()?.observe(this, androidx.lifecycle.Observer {
//            Log.i("Tag",it.get(0).password)
//        })
    }
}