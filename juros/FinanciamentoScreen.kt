package br.com.fiap.calculodejuros.juros

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.calculodejuros.calculos.calcularRenda
import br.com.fiap.calculodejuros.calculos.primeiraPrestacao
import br.com.fiap.calculodejuros.components.CaixaDeEntrada
import br.com.fiap.calculodejuros.components.CardResultado
import br.com.fiap.calculodejuros.components.CardResultadoFinanciamento

@Composable
fun FinanciamentoScreen(financiamentoScreenViewModel: FinanciamentoScreenViewModel) {


    val capital by financiamentoScreenViewModel.capital.observeAsState(initial = "")
    val taxa by financiamentoScreenViewModel.taxa.observeAsState(initial = "")
    val tempo by financiamentoScreenViewModel.tempo.observeAsState(initial = "")


    val primeiraPrestacao by financiamentoScreenViewModel.primeiraPrestacao.observeAsState(initial = 0.0)
    val ultimaPrestacao by financiamentoScreenViewModel.ultimaPrestacao.observeAsState(initial = 0.0)
    val rendaNecessaria by financiamentoScreenViewModel.renda.observeAsState(initial = 0.0)
    val prestacaoPrice by financiamentoScreenViewModel.prestacaoPrice.observeAsState(initial = 0.0)
    val rendaPrice by financiamentoScreenViewModel.rendaPrice.observeAsState(initial = 0.0)


    Box(
        modifier = Modifier.padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Row( modifier = Modifier
            .fillMaxWidth()
            .height(60.dp)) {
            Column (modifier = Modifier
                .weight(0.5f)
                .background(Color.Cyan)){
            }
            Column (modifier = Modifier
                .weight(0.5f)
                .background(Color.Blue)){
            }



        }
        Column() {
            Text(
                text = "Cálculo de Financiamento",
                modifier = Modifier.fillMaxWidth(),
                fontSize = 20.sp,
                color = Color.Red,
                fontWeight = FontWeight.Bold,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(32.dp))
            // Formulário para entrada de dados
            Card(
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(
                        text = "Dados do Financiamento",
                        fontWeight = FontWeight.Bold
                    )

                    CaixaDeEntrada(
                        label = "Valor do Financiamento",
                        placeholder = "Quanto deseja financiar?",
                        value = capital,
                        keyboardType = KeyboardType.Decimal,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        atualizarValor = {financiamentoScreenViewModel.onCapitalChanged(it)}

                    )

                    CaixaDeEntrada(
                        label = "Taxa de juros anual",
                        placeholder = "Qual a taxa de juros anual?",
                        value = taxa,
                        keyboardType = KeyboardType.Decimal,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        atualizarValor = {financiamentoScreenViewModel.onTaxaChanged(it)}
                    )

                    CaixaDeEntrada(
                        label = "Período em meses",
                        placeholder = "Qual o tempo em meses?",
                        value = tempo,
                        keyboardType = KeyboardType.Decimal,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        atualizarValor = {financiamentoScreenViewModel.onTempoChanged(it)}
                    )
                    Button(
                        onClick = {
                            financiamentoScreenViewModel.calcularPrimeiraPrestacaoViewModel()
                            financiamentoScreenViewModel.calcularUltimaPrestacaoViewModel()
                            financiamentoScreenViewModel.calcularRendaViewModel()
                            financiamentoScreenViewModel.calcularPrestacaoPriceViewModel()
                            financiamentoScreenViewModel.calcularRendaPriceViewModel()
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 32.dp)
                    ) {
                        Text(text = "CALCULAR")
                    }
                }
            }
            Spacer(modifier = Modifier.height(16.dp))
            // Resultado da aplicação

           CardResultadoFinanciamento(
               primeiraPrestacao = primeiraPrestacao,
               ultimaPrestacao = ultimaPrestacao,
               renda = rendaNecessaria,
               prestacaoPrice = prestacaoPrice,
               rendaPrice = rendaPrice
           )
        }
    }
}

