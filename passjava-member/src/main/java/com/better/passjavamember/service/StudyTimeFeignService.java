package com.better.passjavamember.service;

import com.better.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Component
@FeignClient(value = "passjava-study")
public interface StudyTimeFeignService {


    @RequestMapping(value = "study/smsstudytime/member/list/test", method = RequestMethod.GET)
    public R memberStudyTimeListTest();

    @RequestMapping("study/smsstudytime/member/list/test/{id}")
    public R getMemberStudyTimeListTest(@PathVariable("id") Long id);
}
