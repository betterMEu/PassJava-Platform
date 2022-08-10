package com.better.passjavasearch.controller;

import com.better.common.Exception.BizCodeEnum;
import com.better.common.es.QuestionEsModel;
import com.better.common.utils.R;
import com.better.passjavasearch.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("search")
@RestController
public class QuestionController {

    @Autowired
    QuestionService questionService;

    // 保存题目到 ES。
    @PostMapping("/question/save")
    public R saveQuestion(@RequestBody QuestionEsModel questionEsModel) {
        System.out.println(questionEsModel);
        boolean result =false;
        try {
            result = questionService.save(questionEsModel);
        } catch (Exception e) {
            result =false;
        }

        if (!result) {
            return R.error(BizCodeEnum.QUESTION_SAVE_EXCEPTION.getCode(), BizCodeEnum.QUESTION_SAVE_EXCEPTION.getMsg());
        }

        return R.ok();
    }
}
