package top.hyperplasma.hyprojai.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import top.hyperplasma.hyprojai.constants.ServiceType;
import top.hyperplasma.hyprojai.repository.ChatHistoryRepository;
import top.hyperplasma.hyprojai.service.IChatService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ai")
public class ChatController {

    private final IChatService chatService;

    private final ChatClient chatClient;

    private final ChatHistoryRepository chatHistoryRepository;

    // 新建任意类型会话时，生成会话ID并返回
    @GetMapping("/connect")
    public String connect() {
        // 生成会话ID
        String chatId = chatService.generateChatId();
        // 保存会话ID
        chatHistoryRepository.save(ServiceType.CHAT, chatId);
        return chatId;
    }

    @RequestMapping(value = "/chat", produces = "text/html;charset=utf-8")
    public Flux<String> chat(String prompt, String chatId) {
        // Depicted - 保存会话ID
        // chatHistoryRepository.save(ServiceType.CHAT, chatId);
        // 请求模型
        return chatClient.prompt()
                .user(prompt)
                .advisors(a -> a.param(ChatMemory.CONVERSATION_ID, chatId))
                .stream()
                .content();
    }
}
