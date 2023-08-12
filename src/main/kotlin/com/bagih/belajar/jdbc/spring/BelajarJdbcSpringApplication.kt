package com.bagih.belajar.jdbc.spring

import com.bagih.belajar.jdbc.spring.data.PlayerDao
import lombok.extern.slf4j.Slf4j
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
@Slf4j
class BelajarJdbcSpringApplication(
	@Autowired
	val playerDao: PlayerDao
): CommandLineRunner{

	private val logger: Logger = LoggerFactory.getLogger(this::class.java)

	override fun run(vararg args: String?) {
//		try {
//			logger.info("get all players: ${playerDao.getAllPlayers()}")
//		} catch (e: Exception){
//			e.printStackTrace()
//		}
	}
}

fun main(args: Array<String>) {
	runApplication<BelajarJdbcSpringApplication>(*args)
}