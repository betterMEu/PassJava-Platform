package com.better.passjavasearch.vo;

import lombok.Data;

@Data
public class SearchParam {
    private String keyword;
    // 题目 id
    private String id;
    private Integer pageNum;
}
