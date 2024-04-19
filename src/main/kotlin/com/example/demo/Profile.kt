package com.example.demo

import java.time.LocalDateTime
import java.util.UUID
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "public.profile") // 指定对应的数据库表名
data class Profile(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: UUID? = null,
        val email: String? = null,
        val phone: String? = null,
        val password: String? = null,
        val job: String? = null,
        val createdAt: LocalDateTime? = null,
        val updatedAt: LocalDateTime? = null,
        val role: String? = null,
        val birthday: LocalDateTime? = null,
        val gender: Short? = null,
        val countryCode: String? = null,
        val accountSegment: String? = null,
        val deleted: Boolean? = null,
        val profileMessage: String? = null,
        val isPlus: Boolean? = null,
        val endTime: LocalDateTime? = null,
        val handle: String? = null,
        val userName: String? = null,
        val latestFavor: String? = null,
        var lastLogin: LocalDateTime? = null
)
