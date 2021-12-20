package com.example.kotlinspringdemo01b

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.*

val animais = mutableListOf<Animal>() // (linha 38) transportado para acima do class do main

@SpringBootApplication
class KotlinSpringDemo01bApplication

fun main(args: Array<String>) {
//	animais.add(Animal("Lex",Especie.CACHORRO, peso =10.50)) //Animal pré cadastrado (Postmam OK)

	runApplication<KotlinSpringDemo01bApplication>(*args)
}

@RestController
@RequestMapping("Ola")
class OlaMundoController { //Controller; identifica o tipo de classe
//	@GetMapping("Ola")
	@GetMapping
	fun Ola(): String {
		return "Olá Mundo Sampa!"
	}

//	@GetMapping("Ola/2")
	@GetMapping("2")
	fun Ola2():String {
		return "Olá Mundão do sertão!"
	}
}
enum class Especie { CACHORRO, GATO, PASSARO }
data class Animal (val nome: String, val especie: Especie, val peso: Double)

//val animais = mutableListOf<Animal>() // (linha 38) transportado para acima do class do main

@RestController
@RequestMapping("animais") //rota principal
class AnimalController{
//	fun index(): MutableList<Animal>{
//		return animais
//	}

	@GetMapping
	fun index() = animais //simplifica a fun index() anterior

	@PostMapping //aceita inserção de dados
	fun create(@RequestBody animal: Animal): Animal{  //recebe dados da Rest passa a Body;
		animais.add(animal) //adiciona em animais;
		return animal //retorna a animal;
	}

}