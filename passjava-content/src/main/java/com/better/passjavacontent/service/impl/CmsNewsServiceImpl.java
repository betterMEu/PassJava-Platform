package com.better.passjavacontent.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.better.common.utils.PageUtils;
import com.better.common.utils.Query;

import com.better.passjavacontent.dao.CmsNewsDao;
import com.better.passjavacontent.entity.CmsNewsEntity;
import com.better.passjavacontent.service.CmsNewsService;


@Service("cmsNewsService")
public class CmsNewsServiceImpl extends ServiceImpl<CmsNewsDao, CmsNewsEntity> implements CmsNewsService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        IPage<CmsNewsEntity> page = this.page(
                new Query<CmsNewsEntity>().getPage(params),
                new QueryWrapper<CmsNewsEntity>()
        );

        return new PageUtils(page);
    }

}
