package com.better.passjavacontent.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.better.common.utils.PageUtils;
import com.better.passjavacontent.entity.CmsBannerEntity;

import java.util.Map;

/**
 * 内容-横幅广告表
 *
 * @author sangyu
 * @email yls912@qq.com
 * @date 2022-08-02 15:48:27
 */
public interface CmsBannerService extends IService<CmsBannerEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

