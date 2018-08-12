package com.sven.game.socketIO.message

import com.corundumstudio.socketio.protocol.PacketType

class RoomResMsg(var userId: Long? = null, var roomId: Long? = null, var msgType: Int? = null, packetType: PacketType = PacketType.MESSAGE) : BaseResMsg(packetType)