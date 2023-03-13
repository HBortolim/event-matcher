package com.example.eventmatcher.services

import com.example.eventmatcher.entities.EventEntity
import com.example.eventmatcher.repositories.EventEntityRepository
import jdk.jfr.EventType
import org.springframework.stereotype.Service
import java.util.*

@Service
class EventService(private val eventRepository: EventEntityRepository) {

    fun createEvent(event: EventEntity): EventEntity {
        return eventRepository.save(event)
    }

    fun getEvent(id: Long): Optional<EventEntity> {
        return eventRepository.findById(id)
    }

    fun getAllEvents(): List<EventEntity> {
        return eventRepository.findAll()
    }

    fun updateEvent(id: Long, event: EventEntity): Optional<EventEntity> {
        val existingEvent = eventRepository.findById(id)
        if (existingEvent.isPresent) {
            val updatedEvent = event.copy(id = existingEvent.get().id)
            return Optional.of(eventRepository.save(updatedEvent))
        } else {
            return Optional.empty()
        }
    }

    fun deleteEvent(id: Long): Optional<EventEntity> {
        val existingEvent = eventRepository.findById(id)
        if (existingEvent.isPresent) {
            eventRepository.deleteById(id)
            return existingEvent
        } else {
            return Optional.empty()
        }
    }

    fun getEventsByCategory(category: com.example.eventmatcher.enums.EventType): List<EventEntity> {
        return eventRepository.findByCategory(category)
    }

}
