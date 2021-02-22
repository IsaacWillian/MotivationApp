package com.isaacwillian.motivation.repository

import com.isaacwillian.motivation.infra.MotivationConstants
import kotlin.random.Random

data class Phrase(val description:String,val category:Int)

class Mock {

    private  val ALL =  MotivationConstants.PHRASEFILTER.ALL
    private  val HAPPY =  MotivationConstants.PHRASEFILTER.HAPPY
    private  val MORNING =  MotivationConstants.PHRASEFILTER.MORNING


    private val mListPhrase:List<Phrase> = listOf(
            Phrase("FRASEHAPPY1",HAPPY),
            Phrase("FRASEHAPPY2",HAPPY),
            Phrase("FRASEHAPPY3",HAPPY),
            Phrase("FRASEMORNING1",MORNING),
            Phrase("FRASEMORNING2",MORNING),
            Phrase("FRASEMORNING3",MORNING)
    )

    fun getPhrase(categoryId:Int):String{
        val filtered = mListPhrase.filter{ it.category == categoryId || categoryId == ALL}
        val rand = Random.nextInt(filtered.size)

        return filtered[rand].description

    }
}