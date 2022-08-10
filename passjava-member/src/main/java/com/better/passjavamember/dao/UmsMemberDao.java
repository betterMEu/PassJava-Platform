package com.better.passjavamember.dao;

import com.better.passjavamember.entity.Member;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员-会员表
 *
 * @author sangyu
 * @email yls912@qq.com
 * @date 2022-08-02 16:02:26
 */
@Mapper
public interface UmsMemberDao extends BaseMapper<Member> {

}
