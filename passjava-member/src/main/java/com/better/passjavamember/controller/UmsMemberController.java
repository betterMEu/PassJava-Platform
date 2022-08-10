package com.better.passjavamember.controller;

import java.util.Arrays;
import java.util.Map;

import com.better.passjavamember.service.StudyTimeFeignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.better.passjavamember.entity.Member;
import com.better.passjavamember.service.UmsMemberService;
import com.better.common.utils.PageUtils;
import com.better.common.utils.R;

import javax.annotation.Resource;


/**
 * 会员-会员表
 *
 * @author sangyu
 * @email yls912@qq.com
 * @date 2022-08-02 16:02:26
 */
@RefreshScope
@RestController
@RequestMapping("member")
public class UmsMemberController {
    @Resource
    private UmsMemberService umsMemberService;

    @Resource
    private StudyTimeFeignService studyTimeFeignService;

    @Value("${member.name}")
    private  String name;

    @Value("${member.age}")
    private  Integer age;

    @RequestMapping("/properties")
    public R testLocalConfig() {
        return R.ok().put("name", name).put("age", age);
    }


    @RequestMapping("/studytime")
    public R getStudyTime() {
        return studyTimeFeignService.memberStudyTimeListTest();
    }

    @RequestMapping("/studytime/list/test/{id}")
    public R getMemberStudyTimeListTest(@PathVariable("id") Long id) {
        //mock数据库查到的会员信息
        Member memberEntity = new Member();
        memberEntity.setId(id);
        memberEntity.setNickname("悟空聊架构");

        //远程调用拿到该用户的学习时长（学习时长是mock数据）
        R memberStudyTimeList = studyTimeFeignService.getMemberStudyTimeListTest(id);
        return R.ok().put("member", memberEntity).put("studytime", memberStudyTimeList.get("studytime"));
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = umsMemberService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		Member umsMember = umsMemberService.getById(id);

        return R.ok().put("umsMember", umsMember);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody Member umsMember){
		umsMemberService.save(umsMember);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody Member umsMember){
		umsMemberService.updateById(umsMember);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		umsMemberService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
