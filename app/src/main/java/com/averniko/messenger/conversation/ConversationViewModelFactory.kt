package com.averniko.messenger.conversation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.averniko.messenger.data.conversations.ConversationsDataSource
import com.averniko.messenger.data.conversations.ConversationsRepository

class ConversationViewModelFactory(
    private val interlocutor: String
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ConversationViewModel::class.java)) {
            return ConversationViewModel(
                interlocutor = interlocutor,
                conversationsRepository = ConversationsRepository.getInstance(
                    dataSource = ConversationsDataSource()
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}