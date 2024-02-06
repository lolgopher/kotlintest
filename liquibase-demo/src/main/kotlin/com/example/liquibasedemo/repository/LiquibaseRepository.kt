package com.example.liquibasedemo.repository

import liquibase.Liquibase
import liquibase.database.jvm.JdbcConnection
import liquibase.resource.ClassLoaderResourceAccessor
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement

class LiquibaseRepository {

}

fun LiquibaseBaseInitalize() {
    val databaseUrl = "jdbc:mysql://localhost:3306/ccaas_bot"
    val databaseUser = "botuser"
    val databasePassword = "botpw"

    val connection = DriverManager.getConnection(databaseUrl, databaseUser, databasePassword)
    val liquibase = Liquibase(
        "db/changelog/changelog-root.sql",
        ClassLoaderResourceAccessor(),
        JdbcConnection(connection)
    )

    liquibase.update("")

    var statement: Statement? = null
    var resultSet: ResultSet? = null

    try {
        // SQL 쿼리 실행
        statement = connection.createStatement()
        var sqlQuery = "SELECT * FROM organization"
        resultSet = statement.executeQuery(sqlQuery)

        // 결과 처리
        while (resultSet.next()) {
            val id = resultSet.getInt("id")
            val organizationName = resultSet.getString("organization_name")

            println("id: $id, organization_name: $organizationName")
        }

        // SQL 쿼리 실행
        statement = connection.createStatement()
        sqlQuery = "SELECT * FROM bot_template"
        resultSet = statement.executeQuery(sqlQuery)

        // 결과 처리
        while (resultSet.next()) {
            val id = resultSet.getInt("id")
            val organizationId = resultSet.getInt("organization_id")
            val botTemplateName = resultSet.getString("bot_template_name")

            println("id: $id, organization_id: $organizationId, bot_template_name: $botTemplateName")
        }
    } catch (e: Exception) {
        e.printStackTrace()
    } finally {
        // 리소스 정리
        resultSet?.close()
        statement?.close()
        connection?.close()
    }
}