package top.hyperplasma.hyprojai.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.ai.content.Media;
import org.springframework.util.MimeType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import reactor.core.publisher.Flux;
import top.hyperplasma.hyprojai.entity.dto.MultiModalityUserPromptDTO;
import top.hyperplasma.hyprojai.repository.ChatHistoryRepository;
import top.hyperplasma.hyprojai.service.IChatService;

import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ai")
public class ChatController {

    private final IChatService chatService;

    private final ChatClient chatClient;

    private final ChatHistoryRepository chatHistoryRepository;

    // 新建任意类型会话时，生成会话ID并返回
    @GetMapping("/connect")
    public String connect(String type) {
        // 生成会话ID
        String chatId = chatService.generateChatId();
        // 保存会话ID
        chatHistoryRepository.save(type, chatId);
        return chatId;
    }

    @PostMapping(value = "/chat", produces = "text/html;charset=utf-8")
    public Flux<String> chat(@RequestBody MultiModalityUserPromptDTO userPromptDTO) {
        String prompt = userPromptDTO.getPrompt();
        String chatId = userPromptDTO.getChatId();
        List<MultipartFile> files = userPromptDTO.getFiles();

        // Depicted - 保存会话ID
        // chatHistoryRepository.save(ServiceType.CHAT, chatId);
        // 请求模型
        if (files == null || files.isEmpty()) {
            // 纯文本要求
            return textChat(prompt, chatId);
        } else {
            // 多模态要求
            return multiModalityChat(prompt, chatId, files);
        }
    }

    private Flux<String> textChat(String prompt, String chatId) {
        return chatClient.prompt()
                .user(prompt)
                .advisors(a -> a.param(ChatMemory.CONVERSATION_ID, chatId))
                .stream()
                .content();
    }

    private Flux<String> multiModalityChat(String prompt, String chatId, List<MultipartFile> files) {
        // 解析多媒体
        List<Media> medias = files.stream()
                .map(file -> new Media(
                                MimeType.valueOf(Objects.requireNonNull(file.getContentType())),
                                file.getResource()
                        )
                )
                .toList();
        // 请求模型
        return chatClient.prompt()
                .user(p -> p.text(prompt).media(medias.toArray(Media[]::new)))
                .advisors(a -> a.param(ChatMemory.CONVERSATION_ID, chatId))
                .stream()
                .content();
    }
}
