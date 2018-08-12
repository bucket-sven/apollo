package com.sven.game

import com.sven.game.socketIO.ApolloGameContext
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.statemachine.config.EnableStateMachine

@SpringBootApplication
@EnableStateMachine
class ApolloApplication

fun main(args: Array<String>) {
    val app = runApplication<ApolloApplication>(*args)
    ApolloGameContext.context = app
}