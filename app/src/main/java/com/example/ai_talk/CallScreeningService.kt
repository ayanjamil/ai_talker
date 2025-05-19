package com.example.ai_talk

import android.content.Intent
import android.telecom.Call
import android.telecom.CallScreeningService
import android.util.Log

class CallScreeningServiceImpl : CallScreeningService() {
    override fun onScreenCall(callDetails: Call.Details) {
        Log.d("CallScreeningService", "Incoming call from: ${callDetails.handle.schemeSpecificPart}")
        val incomingNumber = callDetails.handle.schemeSpecificPart
        Log.d("CallScreening", "Incoming call from: $incomingNumber")

        // Launch the custom UI
        val intent = Intent(this, IncomingCallUI::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
            putExtra("number", incomingNumber)
        }
        Log.d("CallScreening", "Attempting to launch IncomingCallUI")
        startActivity(intent)

        // Let the system continue routing the call normally
        respondToCall(callDetails, CallResponse.Builder().build())
    }
}
