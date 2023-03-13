package com.example.eventmatcher.entities

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.Temporal
import jakarta.persistence.TemporalType
import java.util.Date

@Entity
@Table(name = "talks")
class TalkEntity() {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null

    @Column(name = "name")
    var name: String = ""

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_time")
    var startTime: Date = Date()

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_time")
    var endTime: Date = Date()

    @Column(name = "img_url")
    var imgUrl: String = ""

    @Column(name = "location")
    var location: String = ""

    constructor(name: String, startTime: Date, endTime: Date, imgUrl: String, location: String) : this() {
        this.name = name
        this.startTime = startTime
        this.endTime = endTime
        this.imgUrl = imgUrl
        this.location = location
    }
}
