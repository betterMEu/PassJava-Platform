package com.better.passjavaquestion.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.better.common.utils.PageUtils;
import com.better.passjavaquestion.entity.TypeEntity;

import java.util.Map;

/**
 * 题目-题目类型表
 *
 * @author sangyu
 * @email yls912@qq.com
 * @date 2022-08-02 14:07:48
 */
public interface TypeService extends IService<TypeEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

