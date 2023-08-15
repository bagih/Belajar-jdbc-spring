package com.bagih.belajar.jdbc.spring.data

import com.bagih.belajar.jdbc.spring.model.Player
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.jdbc.core.RowMapper
import org.springframework.stereotype.Repository
import java.sql.ResultSet
import java.sql.Timestamp
import java.util.Objects
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

@Repository
class PlayerDao(
    @Autowired
    val jdbcTemplate: JdbcTemplate
) {

    val rowMapper: RowMapper<Player> = RowMapper<Player> { rs: ResultSet, rowNum: Int ->
        Player(
            rs.getInt("id"),
            rs.getString("name"),
            rs.getString("nationality"),
            rs.getDate("birth_date"),
            rs.getInt("titles")
        )

    }

    fun getAllPlayers(): List<Player> {
        val sql: String = "SELECT * FROM Player"
        return jdbcTemplate.query(sql, rowMapper)
    }

    fun getPlayerById(id: Int): Player? {
        val sql: String = "SELECT * FROM PLAYER WHERE ID = ?"
        return jdbcTemplate.queryForObject(sql, rowMapper, id)
    }

    fun insertPlayer(player: Player) {
        val sql = "INSERT INTO PLAYER (ID, Name, Nationality, Birth_date, Titles) VALUES (?, ?, ?, ?, ?)"
        jdbcTemplate.update(sql, arrayOf(player.id, player.name, player.nationality, Timestamp(player.birthDate.time), player.titles))
    }
}