package com.sven.game.dao.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Transient

@Entity(name = "players")
class Player {
    @Id
    @GeneratedValue
    var id: Long? = null

    @Column
    var userId: Long? = null
    @Column
    var avatar: String? = null
    @Column
    var gold: Long? = null
    @Column
    var sex: Int? = null
    @Column
    var isSuper: Boolean? = null

    var status: Int? = null
}