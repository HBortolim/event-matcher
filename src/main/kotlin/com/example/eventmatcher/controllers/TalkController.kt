package com.example.eventmatcher.controllers

import com.example.eventmatcher.entities.TalkEntity
import com.example.eventmatcher.services.TalkService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.net.URI

@RestController
@RequestMapping("/api/talks")
class TalkController(private val talkService: TalkService) {
    @PostMapping
    fun createTalk(@RequestBody talk: TalkEntity): ResponseEntity<TalkEntity> {
        val createdTalk = talkService.createTalk(talk)
        return ResponseEntity.created(URI.create("/api/talks/${createdTalk.id}")).body(createdTalk)
    }

    @PutMapping("/{id}")
    fun updateTalk(@PathVariable id: Long, @RequestBody talk: TalkEntity): ResponseEntity<TalkEntity> {
        val updatedTalk = talkService.updateTalk(id, talk)
        return if (updatedTalk != null) ResponseEntity.ok(updatedTalk) else ResponseEntity.notFound().build()
    }

    @DeleteMapping("/{id}")
    fun deleteTalk(@PathVariable id: Long): ResponseEntity<Void> {
        talkService.deleteTalk(id)
        return ResponseEntity.noContent().build()
    }

    @GetMapping("/{id}")
    fun getTalkById(@PathVariable id: Long): ResponseEntity<TalkEntity> {
        val talk = talkService.getTalkById(id)
        return if (talk != null) ResponseEntity.ok(talk) else ResponseEntity.notFound().build()
    }

    @GetMapping
    fun getAllTalks(): ResponseEntity<List<TalkEntity>> {
        return ResponseEntity.ok(talkService.getAllTalks())
    }
}
