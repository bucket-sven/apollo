package com.sven.game.socketIO

import com.corundumstudio.socketio.SocketIOServer
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class ServerRunner : CommandLineRunner {
    @Autowired
    private lateinit var socketIOServer: SocketIOServer

//    @Autowired
//    constructor(socketIOServer: SocketIOServer) {
//        this.socketIOServer = socketIOServer
//    }

    override fun run(vararg args: String?) {
        socketIOServer.start()
    }
}