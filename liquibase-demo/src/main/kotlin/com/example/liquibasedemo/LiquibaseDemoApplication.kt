package com.example.liquibasedemo

import com.example.liquibasedemo.repository.LiquibaseBaseInitalize
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class LiquibaseDemoApplication

fun main(args: Array<String>) {
    LiquibaseBaseInitalize()

    runApplication<LiquibaseDemoApplication>(*args)
}
