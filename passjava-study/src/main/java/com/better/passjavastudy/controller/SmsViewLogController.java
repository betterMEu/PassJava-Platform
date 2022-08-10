package com.better.passjavastudy.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.better.passjavastudy.entity.SmsViewLogEntity;
import com.better.passjavastudy.service.SmsViewLogService;
import com.better.common.utils.PageUtils;
import com.better.common.utils.R;



/**
 * 学习-用户学习浏览记录表
 *
 * @author sangyu
 * @email yls912@qq.com
 * @date 2022-08-02 16:10:41
 */
@RestController
@RequestMapping("study/smsviewlog")
public class SmsViewLogController {
    @Autowired
    private SmsViewLogService smsViewLogService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = smsViewLogService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		SmsViewLogEntity smsViewLog = smsViewLogService.getById(id);

        return R.ok().put("smsViewLog", smsViewLog);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody SmsViewLogEntity smsViewLog){
		smsViewLogService.save(smsViewLog);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody SmsViewLogEntity smsViewLog){
		smsViewLogService.updateById(smsViewLog);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		smsViewLogService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
