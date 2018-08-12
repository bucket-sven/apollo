package com.sven.game.socketIO

import com.corundumstudio.socketio.Configuration
import com.corundumstudio.socketio.SocketIOServer
import com.corundumstudio.socketio.annotation.SpringAnnotationScanner
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class NettySocketContext {
    @Value("\${wss.server.host}")
    private var host: String = "127.0.0.1"
    @Value("\${wss.server.port}")
    private var port: Int = 8081

    @Bean
    fun socketIOServer(): SocketIOServer {
        val config = Configuration()
        config.hostname = host
        config.port = port
//        config.bossThreads = 4
//        config.workerThreads = 10
        config.setAuthorizationListener { true }
        return SocketIOServer(config)
    }

    @Bean
    fun springAnnotationScanner(socketIOServer: SocketIOServer): SpringAnnotationScanner {
        return SpringAnnotationScanner(socketIOServer)
    }
}