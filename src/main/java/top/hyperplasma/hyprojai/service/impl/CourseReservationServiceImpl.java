package top.hyperplasma.hyprojai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.hyperplasma.hyprojai.entity.po.CourseReservation;
import top.hyperplasma.hyprojai.mapper.CourseReservationMapper;
import top.hyperplasma.hyprojai.service.ICourseReservationService;

@Service
public class CourseReservationServiceImpl extends ServiceImpl<CourseReservationMapper, CourseReservation> implements ICourseReservationService {
}
