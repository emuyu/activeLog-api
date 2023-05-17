package com.example.activeLog

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class ActiveLogApplication

fun main(args: Array<String>) {
	runApplication<ActiveLogApplication>(*args)
}

@RestController
@RequestMapping("/api")
class IndexController {
    @GetMapping
    fun get(): String? = "Hello World!"
    @PostMapping
    fun post(@RequestParam("value") value: String?): String? = value
}
