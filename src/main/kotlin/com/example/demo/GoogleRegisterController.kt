package com.example.demo

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

import java.time.LocalDateTime
import java.util.UUID

@RestController
class GoogleRegisterController @Autowired constructor(
        private val profileRepository: ProfileRepository
) {
    @GetMapping("/google-register")
    fun hello(): String {
        return "Hello"
    }

    @PostMapping("/google-register")
    fun register(@RequestBody request: GoogleRegisterRequest): ResponseEntity<String> {
        // 检查是否存在相同email的用户
        val existingUser = profileRepository.findByEmail(request.email)
        return if (existingUser != null) {
            // 更新last_login为当前时间
            existingUser.lastLogin = LocalDateTime.now()
            profileRepository.save(existingUser)
            ResponseEntity.ok("登录成功")
        } else {
            // 创建新用户
            val newUser = Profile(
                    id = request.id,
                    email = request.email,
                    userName = request.userName,
                    birthday = request.birthday,
                    gender = request.gender,
                    role = "user",
                    isPlus = false,
                    latestFavor = request.latestFavor,
                    createdAt = LocalDateTime.now(),
                    updatedAt = LocalDateTime.now(),
                    lastLogin = LocalDateTime.now(),
                    accountSegment = "google",
                    countryCode = null,
                    deleted = false,
                    endTime = null,
                    handle = null,
                    job = null,
                    password = null,
                    phone = null,
                    profileMessage = null
            )
            profileRepository.save(newUser)
            ResponseEntity.status(HttpStatus.CREATED).body("新用户已创建")
        }
    }
}

data class GoogleRegisterRequest(
        val id: UUID,
        val userName: String,
        val email: String,
        val birthday: LocalDateTime,
        val gender: Short,
        val latestFavor: String
)
