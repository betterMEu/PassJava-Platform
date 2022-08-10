package com.better.passjavachannel.controller;

import java.util.Arrays;
import java.util.Map;

import com.better.passjavachannel.entity.ChmsAccessTokenEntity;
import com.better.passjavachannel.service.ChmsAccessTokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.better.common.utils.PageUtils;
import com.better.common.utils.R;



/**
 * 渠道-认证表
 *
 * @author sangyu
 * @email yls912@qq.com
 * @date 2022-08-02 15:29:47
 */
@RestController
@RequestMapping("channel/chmsaccesstoken")
public class ChmsAccessTokenController {
    @Autowired
    private ChmsAccessTokenService chmsAccessTokenService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = chmsAccessTokenService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		ChmsAccessTokenEntity chmsAccessToken = chmsAccessTokenService.getById(id);

        return R.ok().put("chmsAccessToken", chmsAccessToken);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ChmsAccessTokenEntity chmsAccessToken){
		chmsAccessTokenService.save(chmsAccessToken);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody ChmsAccessTokenEntity chmsAccessToken){
		chmsAccessTokenService.updateById(chmsAccessToken);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		chmsAccessTokenService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
