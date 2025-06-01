package top.hyperplasma.hyprojai.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("school")
public class School implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String address;

    private String phoneNumber;

    private String email;

    private String website;

    private String description;

    private String logoUrl;

    private Integer status; // 0: inactive, 1: active

    private Integer sortOrder; // Sort order for display
}
