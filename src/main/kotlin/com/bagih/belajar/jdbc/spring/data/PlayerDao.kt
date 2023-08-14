package com.bagih.belajar.jdbc.spring.data

import com.bagih.belajar.jdbc.spring.model.Player
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository
import java.util.Objects
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

@Repository
class PlayerDao(
    @Autowired
    val jdbcTemplate: JdbcTemplate
){
    fun getAllPlayers(): List<Player>{
        val sql: String = "SELECT * FROM PLAYER"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper<Player>(Player::class.java))
    }

    fun getPlayerById(id: Int): Player?{
        val sql: String = "SELECT * FROM PLAYER WHERE ID = ?"
        return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper<Player>(Player::class.java))
    }

    fun insertPlayer(player: Player){
        val sql = "INSERT INTO PLAYER (ID, Name, Nationality, Birth_date, Titles) VALUES (?, ?, ?, ?, ?)"
        jdbcTemplate.update(sql, player.id, player.name, player.nationality, player.birthDate, player.titles)
    }
}