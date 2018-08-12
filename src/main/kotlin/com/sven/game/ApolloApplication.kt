package com.sven.game

import com.sven.game.socketIO.ApolloGameContext
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ApolloApplication

fun main(args: Array<String>) {
    val app = runApplication<ApolloApplication>(*args)
    ApolloGameContext.context = app
}