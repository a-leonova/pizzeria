package com.leonova.pizzeria.model

import javax.persistence.*

@Entity
public class Pizza (
    @Id
    @SequenceGenerator(name = "seq_pizza_generator", sequenceName = "seq_pizza", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_pizza_generator")
    val id: Int = 0,

    @Column(nullable = false)
    val name: String,

    @Column(nullable = false)
    val cost: Int,

    @ManyToMany
    @JoinTable(
        name = "pizza_ingredient",
        joinColumns = [JoinColumn(name = "pizza_id")],
        inverseJoinColumns = [JoinColumn(name = "ingredient_id")])
    val ingredients: MutableSet<Ingredient>
)
