package top.hyperplasma.hyprojai.entity.po;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("course_reservation")
public class CourseReservation implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id;

    private Long courseId; // Foreign key to Course

    private String studentName; // Name of the student making the reservation

    private String reservationDate; // Date of the reservation

    private String status; // e.g., "reserved", "cancelled", "completed"

    private String notes; // Additional notes or comments about the reservation
}
