package com.leonova.pizzeria.model

import javax.persistence.*

@Entity
class Ingredient(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false, name = "is_sauce")
    val isSauce: Boolean
)