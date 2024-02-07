package com.example.liquibasedemo.service

import com.example.liquibasedemo.entity.BotTemplateEntity
import com.example.liquibasedemo.repository.BotTemplateRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class BotTemplateService @Autowired constructor(val botTemplateRepository: BotTemplateRepository) {
    fun createBotTemplate(botTemplateEntity: BotTemplateEntity): Int? {
        return botTemplateRepository.save(botTemplateEntity).block()?.id
    }

    fun deleteBotTemplate(id: Int) {
        botTemplateRepository.deleteById(id)
    }

    fun getBotTemplate(id: Int): BotTemplateEntity? {
        return botTemplateRepository.findById(id).block()
    }

    fun updateBotTemplate(id: Int, botTemplateEntity: BotTemplateEntity): Int? {
        val targetBotTemplate = botTemplateRepository.findById(id).block()
        targetBotTemplate?.botTemplateName = botTemplateEntity.botTemplateName
        targetBotTemplate?.organizationId = botTemplateEntity.organizationId
        botTemplateRepository.save(botTemplateEntity)
        return targetBotTemplate?.id
    }
}