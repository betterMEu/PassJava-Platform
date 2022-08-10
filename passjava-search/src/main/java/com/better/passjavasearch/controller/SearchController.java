package com.better.passjavasearch.controller;


import com.better.passjavasearch.service.QuestionSearchService;
import com.better.passjavasearch.vo.SearchParam;
import com.better.passjavasearch.vo.SearchQuestionResponse;
import org.elasticsearch.action.search.SearchResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequestMapping("search")
@RestController
public class SearchController {

    @Autowired
    QuestionSearchService questionSearchService;

    @PostMapping("/question/list")
    public SearchQuestionResponse list(SearchParam param) {

        return questionSearchService.search(param);

    }
}
