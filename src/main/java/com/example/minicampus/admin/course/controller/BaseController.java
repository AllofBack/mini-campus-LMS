package com.example.minicampus.admin.course.controller;

import com.example.minicampus.util.PageUtil;

public class BaseController {

    // 페이징 처리
    public String getPaperHtml(long totalCount, long pageSize, long pageIndex, String queryString) {
        PageUtil pageUtil = new PageUtil(totalCount, pageSize, pageIndex, queryString);
        return pageUtil.pager();
    }

}
