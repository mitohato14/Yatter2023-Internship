package com.dmm.bootcamp.yatter2023.ui.profile

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.dmm.bootcamp.yatter2023.ui.theme.Yatter2023Theme
import org.koin.androidx.viewmodel.ext.android.viewModel

class ProfileActivity : ComponentActivity() {
    companion object {
        fun newIntent(context: Context): Intent = Intent(
            context,
            ProfileActivity::class.java,
        )
    }

    private val viewModel: ProfileViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            Yatter2023Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    ProfilePage(viewModel)
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.onResume()
    }
}