package top.hyperplasma.hyprojai.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.memory.ChatMemory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import top.hyperplasma.hyprojai.entity.dto.UserPromptDTO;

@RequiredArgsConstructor
@RestController
@RequestMapping("/ai")
public class GameController {

    private final ChatClient gameChatClient;

    /**
     * Teresa游戏
     */
    @PostMapping(value = "/game", produces = "text/html;charset=utf-8")
    public Flux<String> chat(@RequestBody UserPromptDTO userPromptDTO) {
        String prompt = userPromptDTO.getPrompt();
        String chatId = userPromptDTO.getChatId();
        // 请求模型
        return gameChatClient.prompt()
                .user(prompt)
                .advisors(a -> a.param(ChatMemory.CONVERSATION_ID, chatId))
                .stream()
                .content();
    }
}
