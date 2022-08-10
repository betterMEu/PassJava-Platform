package com.better.passjavacontent.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.better.common.utils.PageUtils;
import com.better.passjavacontent.entity.CmsNewsEntity;

import java.util.Map;

/**
 * 内容-资讯表
 *
 * @author sangyu
 * @email yls912@qq.com
 * @date 2022-08-02 15:48:27
 */
public interface CmsNewsService extends IService<CmsNewsEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

