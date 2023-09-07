package com.paulomoura.spaceflightnews.model.apiservice

import com.paulomoura.dependencyinjection.RetrofitInstance

inline fun <reified T> apiService(): T = RetrofitInstance.create(T::class.java)