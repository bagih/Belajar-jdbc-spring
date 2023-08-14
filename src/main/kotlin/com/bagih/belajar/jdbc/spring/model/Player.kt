package com.bagih.belajar.jdbc.spring.model

import java.util.Date

data class Player(
    val id: Int,
    val name: String,
    val nationality: String,
    val birthDate: Date,
    val titles: Int
)
