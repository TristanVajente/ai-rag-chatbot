package com.tvajente.airagchat.chat

import org.slf4j.LoggerFactory
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("api/v1/chat")
@CrossOrigin(origins = ["*"])
class ChatController(
    private val chatService: ChatService
) {

    private val log = LoggerFactory.getLogger(this::class.java)

    @PostMapping
    fun chat(@RequestBody chatRequest: UserChatRequest): ResponseEntity<UserChatResponse> {
        log.info("Received request to chat: {}", chatRequest)
        val response = chatService.chat(chatRequest)
        log.info("Return response for chat: {}", response)
        return ResponseEntity.ok(response)
    }
}

data class UserChatRequest(
    val historyId: String? = null,
    val userPrompt: String,
)

data class UserChatResponse(
    val historyId: String,
    val response: String,
)
