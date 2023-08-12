package com.bagih.belajar.jdbc.spring.model

import java.util.Date

data class Player(
    private val id: Int,
    private val name: String,
    private val nationality: String,
    private val birthDate: Date,
    private val titles: Int
)
