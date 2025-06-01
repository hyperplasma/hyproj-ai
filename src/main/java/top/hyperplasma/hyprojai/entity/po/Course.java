package top.hyperplasma.hyprojai.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("course")
public class Course implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String description;

    private String teacherName;

    private String schoolName;

    private String courseCode;

    private String semester;

    private Integer credits;

    private String schedule; // e.g., "Mon 10:00-12:00, Wed 10:00-12:00"
}
