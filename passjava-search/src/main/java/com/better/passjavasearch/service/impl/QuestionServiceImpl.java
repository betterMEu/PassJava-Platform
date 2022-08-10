package com.better.passjavasearch.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.better.common.es.QuestionEsModel;
import com.better.passjavasearch.config.EsConstant;
import com.better.passjavasearch.service.QuestionService;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author yls91
 */
@Service("questionService")
public class QuestionServiceImpl implements QuestionService {

    @Autowired
    RestHighLevelClient restHighLevelClient;

    @Override
    public boolean save(QuestionEsModel questionEsModel) throws IOException {
        // 创建数据到 ES 中
        //索引
        IndexRequest indexRequest = new IndexRequest(EsConstant.QUESTION_INDEX);
        //索引/类型/文档
        //文档id就是question的id
        indexRequest.id(questionEsModel.getId().toString());
        //对象转json
        String s = JSONObject.toJSONString(questionEsModel);
        //json放入 request 中
        indexRequest.source(s, XContentType.JSON);
        //执行插入
        IndexResponse response = restHighLevelClient.index(indexRequest, RequestOptions.DEFAULT);
        System.out.println(response);
        return true;
    }
}
