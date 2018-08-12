package com.sven.game.dao.repository

import com.sven.game.dao.entity.Player
import org.springframework.data.jpa.repository.JpaRepository

interface PlayerRepository : JpaRepository<Player, Long>