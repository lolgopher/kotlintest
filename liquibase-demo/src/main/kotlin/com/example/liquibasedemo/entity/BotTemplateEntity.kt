package com.example.liquibasedemo.entity

import jakarta.persistence.*

@Entity
@Table(name = "bot_template", schema = "ccaas_bot")
class BotTemplateEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @Column
    var organizationId: Int = 0,

    @Column(length = 64, nullable = false)
    var botTemplateName: String = ""
)
