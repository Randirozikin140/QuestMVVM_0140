
package com.example.pam8

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import com.example.pam8.ui.theme.PAM8Theme
import com.example.pam8.View.uiControler.SiswaApp

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        setContent {
            PAM8Theme {
                SiswaApp(
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}
