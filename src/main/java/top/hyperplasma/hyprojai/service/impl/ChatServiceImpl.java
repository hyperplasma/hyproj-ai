package top.hyperplasma.hyprojai.service.impl;

import org.springframework.stereotype.Service;
import top.hyperplasma.hyprojai.service.IChatService;

import java.util.UUID;

@Service
public class ChatServiceImpl implements IChatService {

    /**
     * 生成一个唯一的会话ID
     * @return 会话ID
     */
    @Override
    public String generateChatId() {
        return UUID.randomUUID().toString();
    }
}
