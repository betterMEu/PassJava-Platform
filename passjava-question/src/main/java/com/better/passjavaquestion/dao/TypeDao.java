package com.better.passjavaquestion.dao;

import com.better.passjavaquestion.entity.TypeEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 题目-题目类型表
 *
 * @author sangyu
 * @email yls912@qq.com
 * @date 2022-08-02 14:07:48
 */
@Mapper
public interface TypeDao extends BaseMapper<TypeEntity> {

}
