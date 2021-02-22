package com.isaacwillian.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.isaacwillian.motivation.R
import com.isaacwillian.motivation.infra.MotivationConstants
import com.isaacwillian.motivation.infra.SecurityPreferences
import kotlinx.android.synthetic.main.activity_splash.*

class SplashActivity : AppCompatActivity() , View.OnClickListener{

    private lateinit var mSecurityPreferences: SecurityPreferences


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        mSecurityPreferences = SecurityPreferences(this)

        if (supportActionBar != null){
            supportActionBar!!.hide()
        }
        BtnSave.setOnClickListener(this)
        verifyName()
    }

    override fun onClick(v: View) {
        val id = v.id
        if (id == R.id.BtnSave){
            handleSave()
        }
    }

    private fun verifyName(){
        val name = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
        if (name != ""){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

    }

    private fun handleSave(){
        val name = EditName.text.toString()
        if(name != ""){
            mSecurityPreferences.storeString(MotivationConstants.KEY.PERSON_NAME,name)
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
        else{
            Toast.makeText(this,"Insira seu nome",Toast.LENGTH_SHORT).show()
        }
    }
}