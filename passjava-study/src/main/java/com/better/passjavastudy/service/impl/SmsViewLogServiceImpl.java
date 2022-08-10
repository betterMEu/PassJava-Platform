package com.better.passjavastudy.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.better.common.utils.PageUtils;
import com.better.common.utils.Query;

import com.better.passjavastudy.dao.SmsViewLogDao;
import com.better.passjavastudy.entity.SmsViewLogEntity;
import com.better.passjavastudy.service.SmsViewLogService;


@Service("smsViewLogService")
public class SmsViewLogServiceImpl extends ServiceImpl<SmsViewLogDao, SmsViewLogEntity> implements SmsViewLogService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<SmsViewLogEntity> page = this.page(
                new Query<SmsViewLogEntity>().getPage(params),
                new QueryWrapper<SmsViewLogEntity>()
        );

        return new PageUtils(page);
    }

}
