package com.tvajente.airagchat.chat

import org.springframework.stereotype.Service
import java.util.*

@Service
class ChatHistory {

    private val history: MutableMap<String, MutableList<HistoryEntry>> = HashMap()

    fun get(historyId: String?): Pair<String, List<HistoryEntry>> {
        val id = historyId ?: UUID.randomUUID().toString()
        return id to (history[id] ?: emptyList())
    }

    fun save(historyId: String, historyEntry: HistoryEntry) {
        val conversation = history[historyId] ?: mutableListOf(historyEntry)
        conversation.add(historyEntry)
        history[historyId] = conversation
    }
}
