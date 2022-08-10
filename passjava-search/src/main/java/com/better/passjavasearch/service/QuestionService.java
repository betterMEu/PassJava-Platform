package com.better.passjavasearch.service;

import com.better.common.es.QuestionEsModel;

import java.io.IOException;

public interface QuestionService {
    boolean save(QuestionEsModel questionEsModel) throws IOException;
}
