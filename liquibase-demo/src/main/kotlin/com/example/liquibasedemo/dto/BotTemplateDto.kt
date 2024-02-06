package com.example.liquibasedemo.dto

import com.example.liquibasedemo.entity.BotTemplateEntity


class BotTemplateDto {
    val id: Int = 0
    var organizationId: Int = 0
    var botTemplateName: String = ""

    fun toEntity(): BotTemplateEntity {
        return BotTemplateEntity(id, organizationId, botTemplateName)
    }
}