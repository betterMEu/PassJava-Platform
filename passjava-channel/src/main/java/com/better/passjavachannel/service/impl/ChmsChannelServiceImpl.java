package com.better.passjavachannel.service.impl;

import com.better.passjavachannel.dao.ChmsChannelDao;
import com.better.passjavachannel.entity.ChmsChannelEntity;
import com.better.passjavachannel.service.ChmsChannelService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.better.common.utils.PageUtils;
import com.better.common.utils.Query;



@Service("chmsChannelService")
public class ChmsChannelServiceImpl extends ServiceImpl<ChmsChannelDao, ChmsChannelEntity> implements ChmsChannelService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ChmsChannelEntity> page = this.page(
                new Query<ChmsChannelEntity>().getPage(params),
                new QueryWrapper<ChmsChannelEntity>()
        );

        return new PageUtils(page);
    }

}
