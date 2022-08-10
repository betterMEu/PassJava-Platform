package com.better.common.es;

import lombok.Data;

/**
 * @author yls91
 */
@Data
public class QuestionEsModel {
    private Long id;
    private String title;
    private String answer;
    private String typeName;
}
