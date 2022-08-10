package com.better.passjavacontent.controller;


import java.util.Arrays;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.better.passjavacontent.entity.CmsBannerEntity;
import com.better.passjavacontent.service.CmsBannerService;
import com.better.common.utils.PageUtils;
import com.better.common.utils.R;



/**
 * 内容-横幅广告表
 *
 * @author sangyu
 * @email yls912@qq.com
 * @date 2022-08-02 15:48:27
 */
@RestController
@RequestMapping("content/cmsbanner")
public class CmsBannerController {
    @Autowired
    private CmsBannerService cmsBannerService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = cmsBannerService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		CmsBannerEntity cmsBanner = cmsBannerService.getById(id);

        return R.ok().put("cmsBanner", cmsBanner);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody CmsBannerEntity cmsBanner){
		cmsBannerService.save(cmsBanner);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody CmsBannerEntity cmsBanner){
		cmsBannerService.updateById(cmsBanner);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		cmsBannerService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
