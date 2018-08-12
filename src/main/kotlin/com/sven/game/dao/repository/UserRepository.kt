package com.sven.game.dao.repository

import com.sven.game.dao.entity.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long> {
    fun findByUserName(userName: String): Array<User>
}