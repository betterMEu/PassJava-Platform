package com.better.passjavaquestion.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.better.common.utils.PageUtils;
import com.better.passjavaquestion.entity.QuestionEntity;

import java.util.Map;

/**
 *
 *
 * @author sangyu
 * @email yls912@qq.com
 * @date 2022-08-02 14:07:48
 */
public interface QuestionService extends IService<QuestionEntity> {

    PageUtils queryPage(Map<String, Object> params);
}

