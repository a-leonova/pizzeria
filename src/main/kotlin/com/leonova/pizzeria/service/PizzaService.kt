package com.leonova.pizzeria.service

import com.leonova.pizzeria.model.Ingredient
import com.leonova.pizzeria.repository.IngredientRepository
import com.leonova.pizzeria.repository.PizzaRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PizzaService {
    @Autowired
    private lateinit var pizzaRepository: PizzaRepository

    @Autowired
    private lateinit var ingredientRepository: IngredientRepository

    fun showPizzaData() {
        val pizzas = pizzaRepository.findAll()
        pizzas.forEach {
            println("${it.name} costs ${it.cost}.")
            println("Composition: ${it.ingredients.map { it.name }.joinToString(", ")}")
        }
    }

    fun substituteIngredient(oldIngredientName: String, newIngredientName: String) {
        val oldIngredient = ingredientRepository.findByName(oldIngredientName)
        val newIngredient = Ingredient(name = newIngredientName, isSauce = oldIngredient.isSauce)
        ingredientRepository.save(newIngredient)

        val pizzas = pizzaRepository.findAll()

        pizzas.forEach {
            if (it.ingredients.contains(oldIngredient)) {
                it.ingredients.remove(oldIngredient)
                it.ingredients.add(newIngredient)
            }
        }
        pizzaRepository.saveAll(pizzas)
        ingredientRepository.delete(oldIngredient)
    }
}