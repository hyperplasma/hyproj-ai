package top.hyperplasma.hyprojai.entity.dto;

import lombok.Data;
import org.springframework.lang.Nullable;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
public class MultiModalityUserPromptDTO {
    private String prompt;

    private String chatId;

    @Nullable   // 可以不传入文件
    List<MultipartFile> files;
}
