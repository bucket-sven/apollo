package com.sven.game.socketIO.message

import com.fasterxml.jackson.databind.ObjectMapper

open class BaseReqMsg {
    fun toJSONString(): String {
        return ObjectMapper().writeValueAsString(this)
    }
}