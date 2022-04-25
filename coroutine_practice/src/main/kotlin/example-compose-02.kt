/*
 * Copyright 2016-2020 JetBrains s.r.o. Use of this source code is governed by the Apache 2.0 license.
 */

// This file was automatically generated from composing-suspending-functions.md by Knit tool. Do not edit.

import kotlinx.coroutines.*
import kotlin.system.*

fun main() = runBlocking<Unit> {
    val time = measureTimeMillis {
        val one = async { doSomethingUsefulOne() }
        val two = async { doSomethingUsefulTwo() }
        println("The answer is ${one.await() + two.await()}")

        /*
        * async로 실행한 뒤에 await에서 기다려서 값을 받는다.
        * one.awaite + two.await
        * async로 값을 받기 때문에 one이 끝날떄까지 대기하지 않고 two로 넘어간다.
        * two 역시 기다리지 않고 실행한 뒤에 await 구문에서 대기한다.
        * 값을 동시에 받기 떄문에 약 1초 뒤에 거의 동시에 값이 반환되어 속도가 1예제보다 훨씬 빠르다.
        * async로 받는 값은 job이기 때문에 cancel이 가능하다.
        * */
    }
    println("Completed in $time ms")
}
