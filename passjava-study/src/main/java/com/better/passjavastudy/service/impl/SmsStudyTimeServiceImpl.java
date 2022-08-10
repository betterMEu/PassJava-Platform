package com.better.passjavastudy.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.better.common.utils.PageUtils;
import com.better.common.utils.Query;

import com.better.passjavastudy.dao.SmsStudyTimeDao;
import com.better.passjavastudy.entity.SmsStudyTimeEntity;
import com.better.passjavastudy.service.SmsStudyTimeService;


@Service("smsStudyTimeService")
public class SmsStudyTimeServiceImpl extends ServiceImpl<SmsStudyTimeDao, SmsStudyTimeEntity> implements SmsStudyTimeService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SmsStudyTimeEntity> page = this.page(
                new Query<SmsStudyTimeEntity>().getPage(params),
                new QueryWrapper<SmsStudyTimeEntity>()
        );

        return new PageUtils(page);
    }

}
