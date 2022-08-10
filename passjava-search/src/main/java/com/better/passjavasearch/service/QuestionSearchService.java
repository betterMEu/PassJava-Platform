package com.better.passjavasearch.service;

import com.better.passjavasearch.vo.SearchParam;
import com.better.passjavasearch.vo.SearchQuestionResponse;
/**
 * @Author: 公众号 | 悟空聊架构
 * @Date: 2021/4/6 21:31
 * @Site: www.passjava.cn
 * @Github: https://github.com/Jackson0714/PassJava-Platform
 */
public interface QuestionSearchService {

    SearchQuestionResponse search(SearchParam param);
}
