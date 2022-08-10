package com.better.passjavacontent.dao;


import com.better.passjavacontent.entity.CmsNewsEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 内容-资讯表
 *
 * @author sangyu
 * @email yls912@qq.com
 * @date 2022-08-02 15:48:27
 */
@Mapper
public interface CmsNewsDao extends BaseMapper<CmsNewsEntity> {

}
