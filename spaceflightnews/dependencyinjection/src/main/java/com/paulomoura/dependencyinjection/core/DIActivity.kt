package com.paulomoura.dependencyinjection.core

import android.os.Bundle
import androidx.activity.ComponentActivity

/**
 * Dependency Injection base Activity. Responsible for setting the Application Context.
 * Must be the super class of the project's Main Activity.
 */
open class DIActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        Context = applicationContext
        super.onCreate(savedInstanceState)
    }

    override fun onDestroy() {
        Context = null
        super.onDestroy()
    }
}