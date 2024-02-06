package com.example.liquibasedemo.repository

import com.example.liquibasedemo.entity.BotTemplateEntity
import org.springframework.data.jpa.repository.JpaRepository

interface BotTemplateRepository: JpaRepository<BotTemplateEntity, Int> {
}