package com.tvajente.airagchat.chat

data class HistoryEntry(
    val prompt: String,
    val response: String
) {

    override fun toString(): String {
        return String.format(
            """
            `history_entry`:
                `prompt`: %s
            
                `response`: %s
            -----------------
            
            """.trimIndent(), prompt, response
        )
    }
}