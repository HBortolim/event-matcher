package com.example.eventmatcher.entities

import com.example.eventmatcher.enums.EventType
import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.EnumType
import jakarta.persistence.Enumerated
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table
import jakarta.persistence.Temporal
import jakarta.persistence.TemporalType
import org.hibernate.Hibernate
import java.util.Date


@Entity
@Table(name = "events")
data class EventEntity(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "name")
    var name: String,

    @Column(name = "description")
    var description: String,

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "start_time")
    var startTime: Date,

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "end_time")
    var endTime: Date,

    @Column(name = "location")
    var location: String,

    @Enumerated(EnumType.STRING)
    @Column(name = "category")
    var category: EventType,

    @Column(name = "image_url")
    var imageUrl: String,
) {

    // Constructor without ID
    constructor(name: String, description: String, startTime: Date, endTime: Date, location: String, category: EventType, imageUrl: String)
            : this(null, name, description, startTime, endTime, location, category, imageUrl)

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || Hibernate.getClass(this) != Hibernate.getClass(other)) return false
        other as EventEntity

        return id != null && id == other.id
    }

    override fun hashCode(): Int = javaClass.hashCode()

    @Override
    override fun toString(): String {
        return this::class.simpleName + "(id = $id )"
    }
}