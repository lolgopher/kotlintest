package com.example.liquibasedemo.entity

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table("bot_template")
class BotTemplateEntity(
    @Id
    val id: Int = 0,

    @Column
    var organizationId: Int = 0,

//    @Column(length = 64, nullable = false)
    @Column
    var botTemplateName: String = ""
)
