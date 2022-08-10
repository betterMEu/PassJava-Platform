package com.better.passjavamember.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.better.common.utils.PageUtils;
import com.better.passjavamember.entity.UmsGrowthChangeHistoryEntity;

import java.util.Map;

/**
 * 会员-积分值变化历史记录表
 *
 * @author sangyu
 * @email yls912@qq.com
 * @date 2022-08-02 16:02:26
 */
public interface UmsGrowthChangeHistoryService extends IService<UmsGrowthChangeHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

