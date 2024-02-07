package com.example.liquibasedemo.repository

import com.example.liquibasedemo.entity.BotTemplateEntity
import org.springframework.data.r2dbc.repository.R2dbcRepository

interface BotTemplateRepository: R2dbcRepository<BotTemplateEntity, Int> {
}