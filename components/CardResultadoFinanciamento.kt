package br.com.fiap.calculodejuros.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.fiap.calculodejuros.calculos.prestacaoPrice

@Composable

fun CardResultadoFinanciamento(
    primeiraPrestacao: Double,
    ultimaPrestacao: Double,
    renda: Double,
    prestacaoPrice: Double,
    rendaPrice: Double){

    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF4CAF50)
        )
    ) {
        Column(
            modifier = Modifier
                //.fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Resultado",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Primeira Prestação (SAC)",
                    modifier = Modifier.padding(end = 8.dp),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                   //text = primeiraPrestacao.toString(),
                    text = "R$ ${"%.2f".format(primeiraPrestacao)}",
                    modifier = Modifier.padding(end = 8.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Última Prestação (SAC)",
                    modifier = Modifier.padding(end = 8.dp),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    //text = ultimaPrestacao.toString(),
                    text = "R$ ${"%.2f".format(ultimaPrestacao)}",
                    modifier = Modifier.padding(end = 8.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Renda Necessária (SAC)",
                    modifier = Modifier.padding(end = 8.dp),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    // text = renda.toString(),
                    text = "R$ ${"%.2f".format(renda)}",
                    modifier = Modifier.padding(end = 8.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Prestação (PRICE)",
                    modifier = Modifier.padding(end = 8.dp),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "R$ ${"%.2f".format(prestacaoPrice)}",
                    modifier = Modifier.padding(end = 8.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(modifier = Modifier.fillMaxWidth()) {
                Text(
                    text = "Renda Necessária (PRICE)",
                    modifier = Modifier.padding(end = 8.dp),
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "R$ ${"%.2f".format(rendaPrice)}",
                    modifier = Modifier.padding(end = 8.dp),
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }
        }
    }


}