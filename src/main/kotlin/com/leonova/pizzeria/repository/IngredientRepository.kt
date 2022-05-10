package com.leonova.pizzeria.repository

import com.leonova.pizzeria.model.Ingredient
import org.springframework.data.jpa.repository.JpaRepository

interface IngredientRepository : JpaRepository<Ingredient, Int> {
    fun findByName(name:String): Ingredient
}