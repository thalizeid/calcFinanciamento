package br.com.fiap.calculodejuros.calculos

//import androidx.compose.runtime.rememberUpdatedState
//import androidx.lifecycle.LiveData
//import kotlin.math.pow


fun primeiraPrestacao (capital: Double, tempo: Double, taxaAnual: Double): Double {

    val taxaAnualDecimal:  Double = taxaAnual/100
    val taxaMensal = Math.pow(1 + taxaAnualDecimal, 1.0 / 12) - 1
    val amortizacao = capital/tempo
    val valorJuros = capital*taxaMensal

    return amortizacao + valorJuros

}

fun ultimaPrestacao (capital: Double, tempo: Double): Double{
    return capital/tempo
}

fun calcularRenda (primeiraPrestacao: Double): Double{
    return primeiraPrestacao*3.3
}

fun prestacaoPrice (capital: Double, tempo: Double, taxaAnual: Double): Double{
    val taxaAnualDecimal:  Double = taxaAnual/100
    val taxaMensal = Math.pow(1 + taxaAnualDecimal, 1.0 / 12) - 1
    val prestacao = capital * taxaMensal * Math.pow(1 + taxaMensal, tempo) / (Math.pow(1 + taxaMensal, tempo) - 1)
    return prestacao
}

fun calcularRendaPrice (prestacaoPrice: Double): Double{
    return prestacaoPrice*3.3
}