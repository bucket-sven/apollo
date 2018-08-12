package com.sven.game.socketIO.message

import com.corundumstudio.socketio.protocol.Packet
import com.corundumstudio.socketio.protocol.PacketType

open class BaseResMsg(packetType: PacketType) : Packet(packetType)