package com.example.laprimera

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.laprimera.ui.theme.LaPrimeraTheme

/**
 * miViewModel es una instancia de MyViewModel, el cual (miViewModel) se pasará como argumento cuando
 * llamemos a la función IU.
 */
@Composable
fun IU(miViewModel: MyViewModel) {
    val randomData = miViewModel.randomData.value
    Box (
        modifier = Modifier.fillMaxSize()
    ){
        Image(
            painter = painterResource(R.drawable.naturaleza),
            contentDescription = "icono",
            modifier = Modifier
                .size(210.dp)
                .offset(y = 120.dp)
                .offset(x = 70.dp)
            /* Icon(
             painter = painterResource(id = R.drawable.tick),
             contentDescription = "tick"
            )*/
        )
        Text( //Línea de texto donde aparece la lista de numero aleatorios después de pulsar el botón

            //text = "Numeros: ${miViewModel.getNumero()}",// Llama al método que me devuelve un número aleatorio
            text = "Random numeros: ${randomData.randomNumber}",// Llama al método que me devuelve la lista de números aleatorios
            fontWeight = FontWeight.Light,
            modifier = Modifier
                .offset(y = 300.dp)
                .offset(x = 30.dp)


        )

        Text(
            modifier = Modifier
                .offset(y = 350.dp)
                .offset(x = 30.dp),
            text = "Lista de números random: ${randomData.randomNumbersList.joinToString(", ")}",
            fontWeight = FontWeight.Bold,
            fontSize = 16.sp,
            textAlign = TextAlign.Center
        )
        Button(
            modifier = Modifier
                .offset(y = 400.dp)
                .offset(x = 30.dp),//Botón para generar la lista de números aleatorios
            onClick = {
                if (randomData.randomNumber != 0) {
                    miViewModel.reset()
                } else {
                    miViewModel.crearRandom()
                }
            }


        ) {// Elementos del botón (imagen y texto)
            Image(
                painter = painterResource(id = R.drawable.flor),
                contentDescription = "Generar números",
                modifier = Modifier
                    .padding(8.dp)
                    .size(20.dp)

            )
            Text(text = "Click para generar números")
        }

    }
    Login(miViewModel)

}

/**
 * Función del contador de clicks y de escribir texto en la caja
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Login(miViewModel: MyViewModel) {

    Column {

        // Texto que simula un botón (Clicks) y cuenta cuantas veces lo pulsas
        TextButton(onClick = { miViewModel.contador() }) {
            Text("CLICKS: ${miViewModel.getContador()}")
        }

        // Caja de texto para escribir
        OutlinedTextField(
            value = miViewModel.getString(), // Coge el valor de lo que escribo en de la caja de texto
            onValueChange = {// Lo actualiza y muestra a medida que voy escribiendo
                miViewModel.name.value = it
            },
            label = { Text(text = "Escribe:") } // Palabra que aparece dentro de la caja y que al escribir se pone como titulo de la misma.
        )

        // Condición para que solo me muestre el contenido de la caja si escribo más de 3 caracteres
        if (miViewModel.name.value.length > 3) {
            Text(
                text = "Nombre: ${miViewModel.getString()}",
                fontSize = 20.sp
            )
        }

    }
}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    // var msj_saludo = stringResource(id = R.string.saludo)
    // var name = remember {mutableStateOf("")}

    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.End
    ) {
        Box {
            Image(
                painter = painterResource(R.drawable.naturaleza),
                contentDescription = "icono",
                modifier = Modifier
                    .size(200.dp)
                /* Icon(
                     painter = painterResource(id = R.drawable.tick),
                     contentDescription = "tick"
                 )*/
            )
        }
        Column {
            Text(
                text = "Hola $name",
                fontSize = 50.sp,
                color = Color.Blue,
                modifier = modifier
            )
            Text(
                text = stringResource(R.string.saludo),
                fontSize = 20.sp,
                color = Color.Gray,
                modifier = modifier

            )

            Button(onClick = { Log.d("Calcular", "Click!!!") }) {
                Text(text = "Click me!", color = Color.DarkGray)
            }
        }

    }

}


/**
 * Vista previa de la app
 */
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    LaPrimeraTheme {
        IU(miViewModel = MyViewModel())
    }
}


//ESTO NO LO USAMOS, es un ejemplo
@Composable
fun InterfazUsuario() {
    login()
    texto_descriptivo("Hola texto")
    chat()
}

@Composable
fun chat() {
    TODO("Not yet implemented")
}

@Composable
fun texto_descriptivo(texto: String) {
    Text(text = texto)
}

@Composable
fun login() {
    texto_descriptivo(texto = "Fallo de login")
}




