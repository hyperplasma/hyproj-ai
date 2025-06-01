package top.hyperplasma.hyprojai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.hyperplasma.hyprojai.entity.po.Course;
import top.hyperplasma.hyprojai.mapper.CourseMapper;
import top.hyperplasma.hyprojai.service.ICourseService;

@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements ICourseService {
}
