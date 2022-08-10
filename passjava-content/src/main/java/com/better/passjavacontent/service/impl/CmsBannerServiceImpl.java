package com.better.passjavacontent.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.better.common.utils.PageUtils;
import com.better.common.utils.Query;

import com.better.passjavacontent.dao.CmsBannerDao;
import com.better.passjavacontent.entity.CmsBannerEntity;
import com.better.passjavacontent.service.CmsBannerService;


@Service("cmsBannerService")
public class CmsBannerServiceImpl extends ServiceImpl<CmsBannerDao, CmsBannerEntity> implements CmsBannerService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CmsBannerEntity> page = this.page(
                new Query<CmsBannerEntity>().getPage(params),
                new QueryWrapper<CmsBannerEntity>()
        );

        return new PageUtils(page);
    }

}
