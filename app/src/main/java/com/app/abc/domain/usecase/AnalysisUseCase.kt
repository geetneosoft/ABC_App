package com.app.abc.domain.usecase

import android.util.Log
import com.app.abc.data.model.News
import com.app.abc.domain.model.Occurrence
import javax.inject.Inject

class AnalysisUseCase @Inject constructor(){

    fun execute(data: News?) : Occurrence {
        if(data ==null){
            return Occurrence(0, emptyMap())
        }

        val occurrence = hashMapOf<Char, Int>()
        for (item in data.articles) {
            for (i in item.title.lowercase()) {
                Log.d("TAG", "execute: $i")
                if(i != ' ') {
                    occurrence[i] = (occurrence[i] ?: 0) + 1
                }
            }
        }
        Log.d("TAG", "execute: $occurrence")
        val sortedMap = occurrence.toList().sortedByDescending { (_, value) -> value }
                .take(3).toMap()

        return Occurrence(itemCount = 3, characterOccurrences = sortedMap)
        }
    }