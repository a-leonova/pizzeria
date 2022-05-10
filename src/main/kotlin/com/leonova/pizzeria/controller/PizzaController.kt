package com.leonova.pizzeria.controller

import com.leonova.pizzeria.dto.PizzaFullInfoDto
import com.leonova.pizzeria.model.Pizza
import com.leonova.pizzeria.service.PizzaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pizza")
class PizzaController {
    @Autowired
    private lateinit var pizzaService: PizzaService

    @GetMapping("/show")
    fun showAllPizzaData(): List<PizzaFullInfoDto> {
        val pizzas = pizzaService.showPizzaData()
        return convertPizzaToPizzaFullInfoDto(pizzas)
    }

    @PostMapping("/substitute")
    fun substituteIngredients(@RequestParam oldIngredient : String, @RequestParam newIngredient: String) {
        pizzaService.substituteIngredient(oldIngredient, newIngredient)
    }

    private fun convertPizzaToPizzaFullInfoDto(pizzas: List<Pizza>): List<PizzaFullInfoDto> {
        return pizzas.map { PizzaFullInfoDto(it.name, it.cost, it.ingredients.map { it.name }) }
    }
}