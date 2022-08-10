package com.better.passjavachannel.controller;

import java.util.Arrays;
import java.util.Map;

import com.better.passjavachannel.entity.ChmsChannelEntity;
import com.better.passjavachannel.service.ChmsChannelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.better.common.utils.PageUtils;
import com.better.common.utils.R;



/**
 * 渠道-渠道表
 *
 * @author sangyu
 * @email yls912@qq.com
 * @date 2022-08-02 15:29:47
 */
@RefreshScope
@RestController
@RequestMapping("channel")
public class ChmsChannelController {
    @Autowired
    private ChmsChannelService chmsChannelService;

    @Value("${channel.name}")
    private  String name;

    @Value("${channel.size}")
    private  Integer size;

    @RequestMapping("/properties")
    public R testLocalConfig() {
        return R.ok().put("name", name).put("age", size);
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = chmsChannelService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		ChmsChannelEntity chmsChannel = chmsChannelService.getById(id);

        return R.ok().put("chmsChannel", chmsChannel);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChmsChannelEntity chmsChannel){
		chmsChannelService.save(chmsChannel);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ChmsChannelEntity chmsChannel){
		chmsChannelService.updateById(chmsChannel);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		chmsChannelService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
