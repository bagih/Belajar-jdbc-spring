package com.bagih.belajar.jdbc.spring

import com.bagih.belajar.jdbc.spring.data.PlayerDao
import com.bagih.belajar.jdbc.spring.model.Player
import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import java.sql.Timestamp
import java.time.Instant
import java.time.LocalDateTime
import java.util.Date
import kotlin.jvm.Throws

@SpringBootApplication
@Slf4j
class BelajarJdbcSpringApplication(
	@Autowired
	val playerDao: PlayerDao
): CommandLineRunner{

	private val logger: Logger = LoggerFactory.getLogger(this::class.java)

	@Throws(Exception::class)
	override fun run(vararg args: String?) {
//		try {
//			logger.info("get all players: ${playerDao.getAllPlayers()}")
//		} catch (e: Exception){
//			e.printStackTrace()
//		}
//		logger.info("get all players: ${playerDao.getAllPlayers()}")
//		println("commandline runner is called")
//		println("get player: ${playerDao.getAllPlayers()}")
		logger.info("get all players: ${playerDao.getAllPlayers()}")
		logger.info("get player by id: ${playerDao.getPlayerById(2)}")
		playerDao.insertPlayer(Player(id = 4, name = "simbur", nationality = "JAWA", birthDate = Date(System.currentTimeMillis()), titles = 20))
		logger.info("players after insert: ${playerDao.getAllPlayers()}")
	}
}

fun main(args: Array<String>) {
	runApplication<BelajarJdbcSpringApplication>(*args)
}