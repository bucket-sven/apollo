package com.sven.game.dao.entity

//import org.springframework.data.elasticsearch.annotations.Document
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

//@Document(indexName = "game", type = "user")
@Entity(name = "users")
class User {
    @Id
    @GeneratedValue
    var id: Long? = null

    @Column(name = "user_name", unique = true, nullable = false)
    var userName: String? = null
    @Column
    val nickName: String? = null
    @Column(name = "create_date")
    var createTime: Date? = null
    @Column(name = "update_time")
    var updateTime: Date? = null
}