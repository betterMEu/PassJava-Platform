package com.better.passjavastudy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.better.common.utils.PageUtils;
import com.better.passjavastudy.entity.SmsViewLogEntity;

import java.util.Map;

/**
 * 学习-用户学习浏览记录表
 *
 * @author sangyu
 * @email yls912@qq.com
 * @date 2022-08-02 16:10:41
 */
public interface SmsViewLogService extends IService<SmsViewLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

