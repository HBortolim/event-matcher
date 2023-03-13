package com.example.eventmatcher.services

import com.example.eventmatcher.entities.TalkEntity
import com.example.eventmatcher.repositories.TalkEntityRepository
import org.springframework.stereotype.Service

@Service
class TalkService(private val talkRepository: TalkEntityRepository) {
    fun createTalk(talk: TalkEntity): TalkEntity {
        return talkRepository.save(talk)
    }

    fun updateTalk(id: Long, talk: TalkEntity): TalkEntity? {
        val existingTalk = talkRepository.findById(id)
        if (existingTalk.isPresent) {
            talk.id = id
            return talkRepository.save(talk)
        }
        return null
    }

    fun deleteTalk(id: Long) {
        talkRepository.deleteById(id)
    }

    fun getTalkById(id: Long): TalkEntity? {
        return talkRepository.findById(id).orElse(null)
    }

    fun getAllTalks(): List<TalkEntity> {
        return talkRepository.findAll()
    }
}
