import kotlinx.coroutines.*

fun main() = runBlocking { // this: CoroutineScope
    launch { doHello() }
    launch { doWorld() }
    launch { doGetTheDragonball() }
    Unit
}

// this is your first suspending function
suspend fun doWorld() {
    delay(1000L)
    println("World!")
}

suspend fun doHello() {
    delay(2000L)
    println("Hello!")
}

suspend fun doGetTheDragonball() {
    delay(3000L)
    println("Dragonball!")
}