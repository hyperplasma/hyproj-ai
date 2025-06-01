package top.hyperplasma.hyprojai.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import top.hyperplasma.hyprojai.entity.po.School;
import top.hyperplasma.hyprojai.mapper.SchoolMapper;
import top.hyperplasma.hyprojai.service.ISchoolService;

@Service
public class SchoolServiceImpl extends ServiceImpl<SchoolMapper, School> implements ISchoolService {
}
