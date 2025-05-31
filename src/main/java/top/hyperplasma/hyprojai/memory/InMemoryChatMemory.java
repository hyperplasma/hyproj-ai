package top.hyperplasma.hyprojai.memory;

import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.chat.messages.Message;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InMemoryChatMemory implements ChatMemory {
    private final Map<String, List<Message>> memory = new HashMap<>();

    @Override
    public void add(String conversationId, List<Message> messages) {
        memory.computeIfAbsent(conversationId, k -> new ArrayList<>()).addAll(messages);
    }

    @Override
    public List<Message> get(String conversationId) {
        return memory.getOrDefault(conversationId, new ArrayList<>());
    }

    @Override
    public void clear(String conversationId) {
        memory.remove(conversationId);
    }
}