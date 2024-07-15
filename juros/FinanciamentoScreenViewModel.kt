package br.com.fiap.calculodejuros.juros

import android.provider.MediaStore.DownloadColumns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fiap.calculodejuros.calculos.calcularRenda
import br.com.fiap.calculodejuros.calculos.calcularRendaPrice
import br.com.fiap.calculodejuros.calculos.prestacaoPrice
import br.com.fiap.calculodejuros.calculos.primeiraPrestacao
import br.com.fiap.calculodejuros.calculos.ultimaPrestacao

class FinanciamentoScreenViewModel: ViewModel() {

    private val _capital = MutableLiveData<String>()
    val capital: LiveData<String> = _capital

    private val _taxa = MutableLiveData<String>()
    val taxa: LiveData<String> = _taxa

    private val _tempo = MutableLiveData<String>()
    val tempo: LiveData<String> = _tempo

    private val _primeiraPrestacao = MutableLiveData<Double>()
    val primeiraPrestacao: LiveData<Double> = _primeiraPrestacao

    private val _ultimaPrestacao = MutableLiveData<Double>()
    val ultimaPrestacao: LiveData<Double> = _ultimaPrestacao

    private val _renda = MutableLiveData<Double>()
    val renda: LiveData<Double> = _renda

    private val _rendaPrice = MutableLiveData<Double>()
    val rendaPrice: LiveData<Double> = _rendaPrice

    private val _prestacaoPrice = MutableLiveData<Double>()
    val prestacaoPrice: LiveData<Double> = _prestacaoPrice


    fun onCapitalChanged(novoCapital: String){
        _capital.value = novoCapital
    }

    fun onTaxaChanged(novaTaxa: String){
        _taxa.value = novaTaxa
    }

    fun onTempoChanged(novoTempo: String){
        _tempo.value = novoTempo
    }

    fun calcularPrimeiraPrestacaoViewModel(){
        _primeiraPrestacao.value = primeiraPrestacao(
            _capital.value!!.toDouble(),
            _tempo.value!!.toDouble(),
            _taxa.value!!.toDouble()
        )
    }

    fun calcularUltimaPrestacaoViewModel(){
        _ultimaPrestacao.value = ultimaPrestacao(
            _capital.value!!.toDouble(),
            _tempo.value!!.toDouble()
        )
    }

    fun calcularRendaViewModel(){
        _renda.value = calcularRenda(primeiraPrestacao.value!!.toDouble())
    }

    fun calcularRendaPriceViewModel(){
        _rendaPrice.value = calcularRendaPrice(prestacaoPrice.value!!.toDouble())
    }

    fun calcularPrestacaoPriceViewModel(){
        _prestacaoPrice.value = prestacaoPrice(
            _capital.value!!.toDouble(),
            _tempo.value!!.toDouble(),
            _taxa.value!!.toDouble()
        )
    }

}