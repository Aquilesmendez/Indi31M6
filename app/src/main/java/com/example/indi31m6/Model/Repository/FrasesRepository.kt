package com.example.indi31m6.Model.Repository

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import com.example.indi31m6.Model.Frases
import com.example.indi31m6.Model.FrasesDao

class FrasesRepository(private val frasesDao: FrasesDao) {

    val allDatos: LiveData<List<Frases>> = frasesDao.getAllDatos()

    @WorkerThread
    suspend fun insert(frase: Frases) {
        frasesDao.insert(frase)
    }
    @WorkerThread
    suspend fun deleteAll() {
        frasesDao.deleteAll()
    }
    @WorkerThread
    suspend fun deleteUno(id:Int) {
        frasesDao.deleteUno(id)
    }

    @WorkerThread
    suspend fun updateFrase(idFrase:Int,nuevaFrase:String) {
        frasesDao.updateFrase(idFrase,nuevaFrase)
    }
}