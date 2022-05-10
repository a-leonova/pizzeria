package com.leonova.pizzeria.model

import javax.persistence.*

@Entity
class Ingredient(
    @Id
    @SequenceGenerator(name = "seq_ingredient_generator", sequenceName = "seq_ingredient", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_ingredient_generator")
    val id: Int = 0,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false, name = "is_sauce")
    val isSauce: Boolean
)