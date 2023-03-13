package com.example.eventmatcher.controllers

import com.example.eventmatcher.entities.EventEntity
import com.example.eventmatcher.services.EventService
import jdk.jfr.EventType
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/events")
class EventController(private val eventService: EventService) {

    @PostMapping
    fun createEvent(@RequestBody event: EventEntity): ResponseEntity<EventEntity> {
        val createdEvent = eventService.createEvent(event)
        return ResponseEntity(createdEvent, HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun getEvent(@PathVariable id: Long): ResponseEntity<EventEntity> {
        val event = eventService.getEvent(id)
        return if (event.isPresent) {
            ResponseEntity(event.get(), HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @GetMapping
    fun getAllEvents(): ResponseEntity<List<EventEntity>> {
        val events = eventService.getAllEvents()
        return ResponseEntity(events, HttpStatus.OK)
    }

    @PutMapping("/{id}")
    fun updateEvent(@PathVariable id: Long, @RequestBody event: EventEntity): ResponseEntity<EventEntity> {
        val updatedEvent = eventService.updateEvent(id, event)
        return if (updatedEvent.isPresent) {
            ResponseEntity(updatedEvent.get(), HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @DeleteMapping("/{id}")
    fun deleteEvent(@PathVariable id: Long): ResponseEntity<EventEntity> {
        val deletedEvent = eventService.deleteEvent(id)
        return if (deletedEvent.isPresent) {
            ResponseEntity(deletedEvent.get(), HttpStatus.OK)
        } else {
            ResponseEntity(HttpStatus.NOT_FOUND)
        }
    }

    @GetMapping("/category/{category}")
    fun getEventsByCategory(@PathVariable category: com.example.eventmatcher.enums.EventType): ResponseEntity<List<EventEntity>> {
        val events = eventService.getEventsByCategory(category)
        return if (events.isNotEmpty()) ResponseEntity.ok(events) else ResponseEntity.notFound().build()
    }
}
