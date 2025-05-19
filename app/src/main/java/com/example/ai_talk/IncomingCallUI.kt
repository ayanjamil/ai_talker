package com.example.ai_talk

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CallScreen(number: String) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Incoming Call", color = Color.White, fontSize = 24.sp)
        Spacer(modifier = Modifier.height(16.dp))
        Text(number, color = Color.White, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(32.dp))

        Row(horizontalArrangement = Arrangement.SpaceEvenly) {
            Button(onClick = { Log.d("CallScreen", "Call Accepted") }) {
                Text("Pick")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = { Log.d("CallScreen", "Call Dropped") }) {
                Text("Drop")
            }
            Spacer(modifier = Modifier.width(16.dp))
            Button(onClick = {
                Log.d("CallScreen", "Forwarding to AI...")
                // Future: Call forwarding or SIP integration
            }) {
                Text("Let AI Talk")
            }
        }
    }
}

class IncomingCallUI : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val number = intent.getStringExtra("number") ?: "Unknown"
        setContent {
            CallScreen(number)
        }
    }
}
