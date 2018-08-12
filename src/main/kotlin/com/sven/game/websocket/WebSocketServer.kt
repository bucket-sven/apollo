//package com.sven.game.websocket
//
//import org.slf4j.LoggerFactory
//import org.springframework.stereotype.Component
//import java.nio.Buffer
//import java.nio.ByteBuffer
//import java.nio.charset.Charset
//import java.util.concurrent.CopyOnWriteArraySet
//import javax.websocket.*
//import javax.websocket.server.ServerEndpoint
//
//@ServerEndpoint(value = "/websocket")
//@Component
//class WebSocketServer {
//    private var logger = LoggerFactory.getLogger(WebSocketServer::class.java)
//
//    companion object {
//        var onlineCount = 0
//        var webSocketSet = CopyOnWriteArraySet<WebSocketServer>()
//    }
//
//    private lateinit var session: Session
//
//    @Synchronized
//    fun addOnlineCount() {
//        onlineCount++
//    }
//
//    @Synchronized
//    fun getOnlineCount(): Int {
//        return onlineCount
//    }
//
//    @Synchronized
//    fun subOnlineCount() {
//        onlineCount--
//    }
//
//    @OnOpen
//    fun onOpen(session: Session) {
//        this.session = session
//        webSocketSet.add(this)
//        addOnlineCount()
//        logger.info("有新连接加入！当前在线人数: " + getOnlineCount())
//    }
//
//    @OnClose
//    fun onClose() {
//        subOnlineCount()
//        logger.info("有连接关闭，当前在线人数: " + getOnlineCount())
//        webSocketSet.remove(this)
//    }
//
//    @OnError
//    fun onError(session: Session, error: Throwable) {
//        logger.error("发生错误: $error")
//    }
//
//    @OnMessage
//    fun onMessage(message: ByteBuffer, session: Session) {
//        logger.info("来自客户端的二进制消息：$message")
//        sendBroadcastBinaryMessage(message)
//    }
//
//    @OnMessage
//    fun onMessage(message: String, session: Session) {
//        logger.info("来自客户端的文本消息: $message")
//        sendBroadcastTextMessage(message)
//    }
//
//    fun sendBinaryMessage(message: ByteBuffer) {
//        this.session.basicRemote.sendBinary(message)
//    }
//
//    fun sendTextMessage(message: String) {
//        this.session.basicRemote.sendText(message)
//    }
//
//    fun sendBroadcastTextMessage(message: String) {
//        webSocketSet.forEach {
//            try {
//                it.sendTextMessage(message)
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//        }
//    }
//
//    fun sendBroadcastBinaryMessage(buffer: ByteBuffer) {
//        webSocketSet.forEach {
//            try {
//                it.sendBinaryMessage(buffer)
//            } catch (e: Exception) {
//                e.printStackTrace()
//            }
//        }
//    }
//}
