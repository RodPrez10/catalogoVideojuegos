package com.example.catalogojuegos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.LaunchedEffect
import kotlinx.coroutines.delay
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.ui.text.style.TextAlign
 
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme{
				CatalogoJuegos()
            }
        }
    }
}

data class Juego(
    val titulo: String,
    val plataforma: String,
    val imagen: Int
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CatalogoJuegos() {

    var carga by remember {
        mutableStateOf(true)
    }

    LaunchedEffect(Unit) {

        delay(2000)

        carga = false
    }

    if (carga) {

        Box(

            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFF0E3FA9)),

            contentAlignment = Alignment.Center

        ) {

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                CircularProgressIndicator(
                    color = Color(0xFFFFA903)
                )

                Spacer(
                    modifier = Modifier.height(20.dp)
                )

                Text(
                    text = "Cargando juegos...",
                    color = Color.White,
                    style = MaterialTheme.typography.titleMedium
                )
            }
        }

    } else {

    Scaffold(

    topBar = {

        CenterAlignedTopAppBar(

            title = {

                Text(
                    text = "Catálogo Juegos",
                    color = Color(0xFFFFA903)
                )
            },

            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color(0xFF0E3FA9)
            )
        )
    }

)	{ padding ->
	
 val juegos = listOf(

        Juego(
            "God of War Ragnarok",
            "PlayStation 5",
            R.drawable.gowr
        ),

        Juego(
            "Halo Infinite",
            "Xbox Series X",
            R.drawable.halo
        ),

        Juego(
            "The Legend of Zelda",
            "Nintendo Switch",
            R.drawable.tloz
        ),

        Juego(
            "Cyberpunk 2077",
            "PC",
             R.drawable.cyberpunk
        ),

        Juego(
            "Minecraft",
            "Multiplataforma",
            R.drawable.minecraft
        ),

        Juego(
            "Resident Evil 4",
            "PlayStation 5",
            R.drawable.re4
        ),

        Juego(
            "Spider-Man 2",
            "PlayStation 5",
            R.drawable.spiderman
        ),

        Juego(
            "Forza Horizon 5",
            "Xbox",
            R.drawable.fh5
        ),

        Juego(
            "Elden Ring",
            "PC",
            R.drawable.eldenring
        ),

        Juego(
            "Call of Duty MW3",
            "Multiplataforma",
            R.drawable.mw3
        )
    )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
		)
         {

            LazyVerticalGrid(
				columns = GridCells.Fixed(2),
				modifier = Modifier.padding(8.dp),
				contentPadding = PaddingValues(12.dp),
				horizontalArrangement = Arrangement.spacedBy(12.dp),
				verticalArrangement = Arrangement.spacedBy(12.dp)
			) {

                items(juegos) { juego ->

                    CardJuego(juego)
                }
            }
        }
    }
}
}


@Composable
fun CardJuego(juego: Juego) {

    Card(

        shape = RoundedCornerShape(20.dp),

        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF123C8C)
        ),

        modifier = Modifier
            .fillMaxWidth().height(250.dp)
    ) {

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
			modifier = Modifier.padding(8.dp)

        ) {

            Image(
                painter = painterResource(id = juego.imagen),
                contentDescription = juego.titulo,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                     .fillMaxWidth().height(140.dp)
                    .clip(RoundedCornerShape(16.dp))
            )

            Spacer(
                modifier = Modifier.height(16.dp)
            )

            Column(
			modifier = Modifier.fillMaxWidth(),
			horizontalAlignment = Alignment.CenterHorizontally
		){

                Text(
                    text = juego.titulo,
                    style = MaterialTheme.typography.titleMedium,
                    color = Color(0xFFFFA903),
					textAlign = TextAlign.Center
                )

                Spacer(
                    modifier = Modifier.height(6.dp)
                )

                Text(
                    text = juego.plataforma,
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.White,
					textAlign = TextAlign.Center
                        
                )
            }
        }
    }
}