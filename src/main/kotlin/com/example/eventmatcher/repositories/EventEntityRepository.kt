package com.example.eventmatcher.repositories;

import com.example.eventmatcher.entities.EventEntity
import jdk.jfr.EventType
import org.springframework.data.jpa.repository.JpaRepository

interface EventEntityRepository : JpaRepository<EventEntity, Long> {
    fun findByCategory(category: com.example.eventmatcher.enums.EventType): List<EventEntity>
}