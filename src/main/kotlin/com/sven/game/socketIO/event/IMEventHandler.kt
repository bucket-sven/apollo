package com.sven.game.socketIO.event

import com.corundumstudio.socketio.AckRequest
import com.corundumstudio.socketio.SocketIOClient
import com.corundumstudio.socketio.SocketIOServer
import com.corundumstudio.socketio.annotation.OnEvent
import com.corundumstudio.socketio.protocol.PacketType
import com.sven.game.dao.repository.UserRepository
import com.sven.game.socketIO.message.BaseResMsg
import com.sven.game.socketIO.message.MessageInfo
import com.sven.game.socketIO.message.RoomReqMsg
import com.sven.game.socketIO.message.RoomResMsg
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class IMEventHandler {
    private val logger = LoggerFactory.getLogger(IMEventHandler::class.java)

    @Autowired
    private lateinit var server: SocketIOServer

    @Autowired
    private lateinit var userRepository: UserRepository

    @OnEvent(value = "/chat/message")
    fun onEvent(client: SocketIOClient, req: AckRequest, data: MessageInfo) {
        val userName = data.userId
        logger.info("onEvent: {}", data.toJSONString())
        if (userName != null) {
//            val user = userRepository.findByUserName(userName)
            val resp = BaseResMsg(PacketType.MESSAGE)
            val data = "You Happy JIU OK!"
            logger.info("SEND DATA: {}", data)
            resp.setData(data)
            client.sendEvent("onChatMessage", resp)
//            client.sendEvent("/test/hehe", resp)
        }
    }

    @OnEvent(value = "/chat/joinRoom")
    fun onJoinRoom(client: SocketIOClient, req: AckRequest, data: RoomReqMsg) {
        val roomId = data.roomId.toString()
        server.addNamespace(roomId)
        client.joinRoom(roomId)
        val resMsg = RoomResMsg(roomId = roomId.toLong(), userId = data.userId, msgType = 1)
        server.broadcastOperations.sendEvent("/test/hehe", resMsg)
    }
}