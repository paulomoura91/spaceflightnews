package com.paulomoura.dependencyinjection.core

import android.annotation.SuppressLint
import android.content.Context

/**
 * Whenever the App is finished, its reference gets null in the [com.paulomoura.dependencyinjection.core.DIActivity] to be garbage collected.
 */
@SuppressLint("StaticFieldLeak")
internal var Context: Context? = null

/**
 * Provides the Application Context.
 */
fun appContext(): Context = Context ?: throw DINullApplicationContextException()