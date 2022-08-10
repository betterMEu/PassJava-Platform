package com.better.passjavachannel.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.better.passjavachannel.entity.ChmsAccessTokenEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 渠道-认证表
 *
 * @author sangyu
 * @email yls912@qq.com
 * @date 2022-08-02 15:29:47
 */
@Mapper
public interface ChmsAccessTokenDao extends BaseMapper<ChmsAccessTokenEntity> {

}
