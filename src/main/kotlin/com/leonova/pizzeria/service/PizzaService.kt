package com.leonova.pizzeria.service

import com.leonova.pizzeria.repository.PizzaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PizzaService {
    @Autowired
    private lateinit var pizzaRepository: PizzaRepository;

    public fun showPizzaData() {
        val pizzas = pizzaRepository.findAll()
        pizzas.forEach {
            println("${it.name} costs ${it.cost}.")
            println("Composition: ${it.ingredients.map { it.name }.joinToString(", ")}")
        }
    }
}