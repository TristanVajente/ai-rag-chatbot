package com.tvajente.airagchat.config

import io.zonky.test.db.postgres.embedded.EmbeddedPostgres
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.sql.DataSource

@Configuration
class DatabaseConfig {

    @Bean
    fun datasource(): DataSource? {
        return EmbeddedPostgres.builder()
            .setPort(5432)
            .start()
            .postgresDatabase
    }
}