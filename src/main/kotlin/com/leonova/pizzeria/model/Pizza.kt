package com.leonova.pizzeria.model

import javax.persistence.*

@Entity
public class Pizza (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val cost: Int,

    @ManyToMany
    @JoinTable(
        name = "pizza_ingredient",
        joinColumns = [JoinColumn(name = "pizza_id")],
        inverseJoinColumns = [JoinColumn(name = "ingredient_id")])
    val ingredients: Set<Ingredient>
)
