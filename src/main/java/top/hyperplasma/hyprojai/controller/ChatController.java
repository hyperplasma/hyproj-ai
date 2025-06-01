package top.hyperplasma.hyprojai.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import top.hyperplasma.hyprojai.constants.ServiceType;
import top.hyperplasma.hyprojai.repository.ChatHistoryRepository;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ai")
public class ChatController {

    private final ChatClient chatClient;

    private final ChatHistoryRepository chatHistoryRepository;

    // 首次开启会话，生成会话ID并返回
    @GetMapping("/chat/connect")
    public String connect() {
        // 生成会话ID
        String chatId = "chat-" + System.currentTimeMillis();
        // 保存会话ID
        chatHistoryRepository.save(ServiceType.CHAT, chatId);
        return chatId;
    }

    @RequestMapping(value = "/chat", produces = "text/html;charset=utf-8")
    public Flux<String> chat(String prompt, String chatId) {
        // 保存会话ID
        chatHistoryRepository.save(ServiceType.CHAT, chatId);
        // 请求模型
        return chatClient.prompt()
                .user(prompt)
                .advisors(a -> a.param(ChatMemory.CONVERSATION_ID, chatId))
                .stream()
                .content();
    }
}
