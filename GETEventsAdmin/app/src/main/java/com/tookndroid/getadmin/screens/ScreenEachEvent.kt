package com.tookndroid.getadmin.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.tookndroid.getadmin.R
import com.tookndroid.getadmin.component.HeadingTextComponent
import com.tookndroid.getadmin.models.Concoursprojet
import com.tookndroid.getadmin.models.Conference
import com.tookndroid.getadmin.models.Evenement
import com.tookndroid.getadmin.models.Excursion
import com.tookndroid.getadmin.models.Reception
import com.tookndroid.getadmin.tools.TYPE_AFFICHER
import com.tookndroid.getadmin.ui.state.UiState
import com.tookndroid.getadmin.ui.theme.Blue80
import com.tookndroid.getadmin.ui.theme.Green100

@Composable
fun ScreenEachEvent(event : Any) {
    var title : String = "Titre"
    var lieu : String = "Lieu"
    var date : String = "Date"
    var heure : String = "Heure"
    var description : String = "Description"

    when(event) {
        is Conference -> {
            title = event.title
            lieu = event.lieu
            date = event.date.substring(0, 9)
            heure = event.date.substring(11, 18)
            description = event.description
        }
        is Reception -> {
            title = event.title
            lieu = event.lieu
            date = event.date.substring(0, 9)
            heure = event.date.substring(11, 18)
            description = event.description
        }
        is Excursion -> {
            title = event.title
            lieu = event.lieu
            date = event.date.substring(0, 9)
            heure = event.date.substring(11, 18)
            description = event.description
        }
        is Concoursprojet -> {
            title = event.title
            lieu = event.lieu
            date = event.date.substring(0, 9)
            heure = event.date.substring(11, 18)
            description = event.description
        }

    }
    Column(modifier = Modifier) {
        Surface(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .padding(10.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.logoget),
                contentDescription = "",
                modifier = Modifier.size(100.dp)
            )
        }
        HeadingTextComponent(values1 = "", values2 = title)
        Surface(
            modifier = Modifier
                .fillMaxWidth()
        ) {

            ElevatedCard(
                elevation = CardDefaults.cardElevation(10.dp),
                modifier = Modifier
                    .padding(20.dp, 50.dp, 20.dp, 20.dp)
                    .clip(RoundedCornerShape(30.dp))
                    .fillMaxWidth()
                    .height(350.dp)
            ) {
                Row(Modifier.padding(20.dp)) {
                    Column {
                        Row(modifier = Modifier.fillMaxWidth()) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier
                                    .weight(1F)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.DateRange,
                                    contentDescription = null,
                                    tint = Blue80
                                )
                                Text(
                                    text = "${date} à ${heure}",
                                    modifier = Modifier.padding(5.dp),
                                    color = Blue80
                                )
                            }
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                horizontalArrangement = Arrangement.End,
                                modifier = Modifier.weight(1F)
                            ) {
                                Icon(
                                    imageVector = Icons.Default.LocationOn,
                                    contentDescription = null,
                                    tint = Green100
                                )
                                Text(
                                    text = lieu,
                                    modifier = Modifier.padding(5.dp),
                                    color = Green100
                                )
                            }
                        }
                        Spacer(modifier = Modifier.padding(10.dp))
                        Text(
                            text = description,
                            modifier = Modifier.verticalScroll(rememberScrollState())
                        )
                        when(event) {
                            is Conference -> ScreenConference(event)
                            is Reception -> ScreenReception(event)
                            is Excursion -> ScreenExcursion(event)
                            is Concoursprojet -> ScreenConcoursProjet(event)

                        }
                    }
                }
            }
        }
    }
}
//@Preview
//@Composable
//fun ScreenEachEventPreview(){
//    ScreenEachEvent()
//}