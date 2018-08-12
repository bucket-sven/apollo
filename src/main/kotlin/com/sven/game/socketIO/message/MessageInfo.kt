package com.sven.game.socketIO.message

class MessageInfo (var userId: String? = null,
                  var receivedId: String? = null,
                  var msgType: String? = null,
                  var content: String? = null
                  ) : BaseReqMsg()
