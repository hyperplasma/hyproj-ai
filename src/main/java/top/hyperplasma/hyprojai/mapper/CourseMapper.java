package top.hyperplasma.hyprojai.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.hyperplasma.hyprojai.entity.po.Course;

@Mapper
public interface CourseMapper extends BaseMapper<Course> {
}
