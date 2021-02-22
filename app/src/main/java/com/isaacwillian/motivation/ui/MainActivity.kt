package com.isaacwillian.motivation.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.isaacwillian.motivation.R
import com.isaacwillian.motivation.infra.MotivationConstants
import com.isaacwillian.motivation.infra.SecurityPreferences
import com.isaacwillian.motivation.repository.Mock
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() , View.OnClickListener {
    private lateinit var mSecurityPreferences: SecurityPreferences
    private var mPhraseFilter:Int = MotivationConstants.PHRASEFILTER.ALL

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        if(supportActionBar != null){
            supportActionBar!!.hide()
        }

        mSecurityPreferences = SecurityPreferences(this)
        val name = mSecurityPreferences.getString(MotivationConstants.KEY.PERSON_NAME)
        textName.text = "Olá, ${name}"

        //Logica inicial
        imageAll.setColorFilter( resources.getColor(R.color.teal_200))
        handleNewPhrase()

        BtnNewPhrase.setOnClickListener(this)
        imageAll.setOnClickListener(this)
        imageHappy.setOnClickListener(this)
        imageMorning.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        val id = view.id
        val listFilter  = listOf(R.id.imageAll,R.id.imageHappy,R.id.imageMorning)

        if (id == R.id.BtnNewPhrase){
            handleNewPhrase()
        }else if (id in listFilter){
            handleFilter(id)
        }
}
    private fun handleFilter(id:Int){

        imageAll.setColorFilter( resources.getColor(R.color.white))
        imageHappy.setColorFilter( resources.getColor(R.color.white))
        imageMorning.setColorFilter( resources.getColor(R.color.white))

        when(id){

            R.id.imageAll -> {
                imageAll.setColorFilter( resources.getColor(R.color.teal_200))
                mPhraseFilter = MotivationConstants.PHRASEFILTER.ALL

            }
            R.id.imageHappy -> {
                imageHappy.setColorFilter( resources.getColor(R.color.teal_200))
                mPhraseFilter = MotivationConstants.PHRASEFILTER.HAPPY
            }
            R.id.imageMorning -> {
                imageMorning.setColorFilter( resources.getColor(R.color.teal_200))
                mPhraseFilter = MotivationConstants.PHRASEFILTER.MORNING
            }

        }

    }
    private fun handleNewPhrase(){
        phrase.text = Mock().getPhrase(mPhraseFilter)


    }


}
