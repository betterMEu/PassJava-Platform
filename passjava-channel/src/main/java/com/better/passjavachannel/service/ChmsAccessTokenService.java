package com.better.passjavachannel.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.better.common.utils.PageUtils;
import com.better.passjavachannel.entity.ChmsAccessTokenEntity;

import java.util.Map;

/**
 * 渠道-认证表
 *
 * @author sangyu
 * @email yls912@qq.com
 * @date 2022-08-02 15:29:47
 */
public interface ChmsAccessTokenService extends IService<ChmsAccessTokenEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

