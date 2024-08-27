package com.jetbrains.greeting

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.time.Duration.Companion.seconds
import kotlin.random.Random

import com.rickclephas.kmp.nativecoroutines.NativeCoroutines

class Greeting {
    private val platform = getPlatform()
    private val rocketComponent = RocketComponent()

    @NativeCoroutines
    fun greet(): Flow<String> = flow {
        emit(if (Random.nextBoolean()) "Hi!" else "Hello!")
        delay(1.seconds)
        emit("Guess what this is! > ${platform.name.reversed()}!")
        delay(1.seconds)
        emit(daysPhrase())
        emit(rocketComponent.launchPhrase())
    }
}