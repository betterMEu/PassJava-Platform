package com.better.passjavaquestion.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.better.common.es.QuestionEsModel;
import com.better.common.utils.PageUtils;
import com.better.common.utils.R;
import com.better.passjavaquestion.feign.SearchFeignService;
import com.better.passjavaquestion.service.TypeService;
import io.netty.util.internal.StringUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.better.passjavaquestion.entity.QuestionEntity;
import com.better.passjavaquestion.service.QuestionService;

import javax.annotation.Resource;
import javax.validation.Valid;


/**
 *
 *
 * @author sangyu
 * @email yls912@qq.com
 * @date 2022-08-02 14:07:48
 */
@RestController
@RequestMapping("question/question")
public class QuestionController {

    @Resource
    private QuestionService questionService;

    @Resource
    private SearchFeignService searchFeignService;

    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @Resource
    private TypeService typeService;

    /**
     * 保存
     */
    @RequestMapping("/es/save")
    public R save(@RequestBody QuestionEsModel questionEsModel){


        searchFeignService.saveQuestion(questionEsModel);
        return R.ok();
    }

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params){
        PageUtils page = questionService.queryPage(params);
        return R.ok().put("page", page);
    }

    @RequestMapping("/lists")
    public List<QuestionEntity> getLists(){
        ValueOperations<String,String> ops = stringRedisTemplate.opsForValue();
        String questionList = ops.get("questionList");
        if (StringUtil.isNullOrEmpty(questionList)) {
            System.out.println("questionList is null");
            List<QuestionEntity> questionListFromDB = questionService.list();
            questionList = JSON.toJSONString(questionListFromDB);
            ops.set("questionList", questionList);
            return questionListFromDB;
        }

        return JSON.parseObject(questionList,new TypeReference<List<QuestionEntity>>(){});
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
		QuestionEntity question = questionService.getById(id);

        return R.ok().put("question", question);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@Valid @RequestBody QuestionEntity question){
        System.out.println(question.toString());
        questionService.save(question);

        //创建esmodel
        QuestionEsModel esModel = new QuestionEsModel();
        //复制属性
        BeanUtils.copyProperties(question,esModel);
        //questionEntity的问题类型是type(long类型)，esmodel是typeName（string），需要额外复制
        esModel.setTypeName(typeService.getById(question.getType()).getType());

        //执行
        searchFeignService.saveQuestion(esModel);
        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody QuestionEntity question){
		questionService.updateById(question);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
		questionService.removeByIds(Arrays.asList(ids));

        return R.ok();
    }

}
