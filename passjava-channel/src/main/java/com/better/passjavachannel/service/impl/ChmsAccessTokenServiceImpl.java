package com.better.passjavachannel.service.impl;

import com.better.passjavachannel.dao.ChmsAccessTokenDao;
import com.better.passjavachannel.entity.ChmsAccessTokenEntity;
import com.better.passjavachannel.service.ChmsAccessTokenService;
import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.better.common.utils.PageUtils;
import com.better.common.utils.Query;



@Service("chmsAccessTokenService")
public class ChmsAccessTokenServiceImpl extends ServiceImpl<ChmsAccessTokenDao, ChmsAccessTokenEntity> implements ChmsAccessTokenService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<ChmsAccessTokenEntity> page = this.page(
                new Query<ChmsAccessTokenEntity>().getPage(params),
                new QueryWrapper<ChmsAccessTokenEntity>()
        );

        return new PageUtils(page);
    }

}
