package com.better.passjavamember.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.better.common.utils.PageUtils;
import com.better.passjavamember.entity.Member;

import java.util.Map;

/**
 * 会员-会员表
 *
 * @author sangyu
 * @email yls912@qq.com
 * @date 2022-08-02 16:02:26
 */
public interface UmsMemberService extends IService<Member> {

    PageUtils queryPage(Map<String, Object> params);
}

