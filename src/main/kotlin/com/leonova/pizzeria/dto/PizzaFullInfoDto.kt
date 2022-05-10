package com.leonova.pizzeria.dto

data class PizzaFullInfoDto(
    val name: String,
    val cost: Int,
    val ingredients: List<String>
)
