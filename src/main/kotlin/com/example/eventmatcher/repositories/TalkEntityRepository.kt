package com.example.eventmatcher.repositories;

import com.example.eventmatcher.entities.TalkEntity
import org.springframework.data.jpa.repository.JpaRepository

interface TalkEntityRepository : JpaRepository<TalkEntity, Long> {
}