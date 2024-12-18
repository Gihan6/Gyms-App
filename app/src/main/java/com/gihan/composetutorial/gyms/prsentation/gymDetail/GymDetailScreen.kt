package com.gihan.composetutorial.gyms.prsentation.gymDetail


import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Place
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.gihan.composetutorial.gyms.prsentation.SemanticDescription
import com.gihan.composetutorial.gyms.prsentation.gymsList.GymDetail
import com.gihan.composetutorial.gyms.prsentation.gymsList.GymIcon

@Composable
fun GymDetailScreen(gymDetailScreenState: GymDetailScreenState) {

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            gymDetailScreenState.gym?.let {
                GymIcon(
                    imageVector = Icons.Filled.Place,
                    modifier = Modifier.padding(top = 52.dp, bottom = 52.dp),
                    ""
                )
                GymDetail(
                    modifier = Modifier.padding(bottom = 52.dp),
                    gym = it,
                    horizontalAlignment = Alignment.CenterHorizontally
                )
                Text(
                    text = if (it.isOpen) "Gym is Open" else "Gym is Close",
                    color = if (it.isOpen) Color.Green else Color.Red
                )
            }

        }

        if (gymDetailScreenState.isLoading) androidx.compose.material3.CircularProgressIndicator(
            modifier = Modifier.semantics {
                this.contentDescription = SemanticDescription.GYMS_LIST_LOADING

            })

        gymDetailScreenState.error?.let {
            Text(text = it, textAlign = TextAlign.Center)
        }
    }

}