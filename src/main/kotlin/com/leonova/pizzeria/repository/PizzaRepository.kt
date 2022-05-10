package com.leonova.pizzeria.repository

import com.leonova.pizzeria.model.Pizza
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

interface PizzaRepository : JpaRepository<Pizza, Int>{
}