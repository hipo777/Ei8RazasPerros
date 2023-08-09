package org.demre.ei8razasperros.presentation

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import org.demre.ei8razasperros.data.Repositorio
import org.demre.ei8razasperros.data.local.RazaDatabase
import org.demre.ei8razasperros.data.remote.PerrosRetrofit

class RazaViewModel(application: Application): AndroidViewModel(application) {

    private val repositorio: Repositorio

    fun razaLiveData() = repositorio.obtenerRazaEntentity()

    init {
        val api = PerrosRetrofit.gesRetroFitAves()
        val razaDatabase = RazaDatabase.getDatabase(application).getRazaDao()
        repositorio = Repositorio(api,razaDatabase)
    }

    fun getAllRazas() = viewModelScope.launch {
        repositorio.getRazas()
    }


}