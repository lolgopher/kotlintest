package com.example.liquibasedemo.controller

import com.example.liquibasedemo.dto.BotTemplateDto
import com.example.liquibasedemo.service.BotTemplateService
import org.openqa.selenium.NotFoundException
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class BotTemplateController (
    private var botTemplateService: BotTemplateService
) {

    @GetMapping("/bottemplate/{id}", produces = ["application/json"])
    fun getBotTemplate(@PathVariable id:Int) = ResponseEntity
        .ok()
        .body(botTemplateService.getBotTemplate(id))

    @PostMapping("/bottemplate", produces = ["application/json"])
    fun createBotTemplate(@RequestBody botTemplateDto:BotTemplateDto): ResponseEntity<Any> {
        botTemplateService.createBotTemplate(botTemplateDto.toEntity())
        return ResponseEntity
            .ok()
            .body(true)
    }

    @DeleteMapping("/bottemplate/{id}")
    fun deleteBotTemplate(@PathVariable id:Int): ResponseEntity<Any> {
        if (botTemplateService.getBotTemplate(id) != null) {
            botTemplateService.deleteBotTemplate(id)
            return ResponseEntity
                .ok()
                .build()
        }
        throw NotFoundException("bottemplate id: $id")
    }

    @PutMapping("/bottemplate/{id}")
    fun updateBotTemplate(
        @PathVariable id:Int,
        @RequestBody botTemplateDto:BotTemplateDto
    ): ResponseEntity<Any> {
        if (botTemplateService.getBotTemplate(id) != null) {
            botTemplateService.updateBotTemplate(id, botTemplateDto.toEntity())
            return ResponseEntity
                .ok()
                .body(true)
        }
        throw NotFoundException("bottemplate id: $botTemplateDto.id")
    }
}