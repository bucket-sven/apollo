package com.sven.game.socketIO.event

import com.corundumstudio.socketio.SocketIOClient
import com.corundumstudio.socketio.annotation.OnConnect
import com.corundumstudio.socketio.annotation.OnDisconnect
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component

@Component
class NetEventHandler {
    private val logger: Logger = LoggerFactory.getLogger(NetEventHandler::class.java)
    @OnConnect
    fun onConnect(client: SocketIOClient) {
        logger.info("Client: ${client.sessionId} Connected! ...")
    }

    @OnDisconnect
    fun onDisconnect(client: SocketIOClient) {
        logger.info("Client: ${client.sessionId} Disconnected! ...")
    }
}