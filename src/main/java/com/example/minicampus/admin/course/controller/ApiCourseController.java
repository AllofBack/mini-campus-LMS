package com.example.minicampus.admin.course.controller;

import com.example.minicampus.admin.course.model.ServiceResult;
import com.example.minicampus.admin.course.model.TakeCourseInput;
import com.example.minicampus.admin.course.service.CourseService;
import com.example.minicampus.admin.service.CategoryService;
import com.example.minicampus.common.model.ResponseResult;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RequiredArgsConstructor
@RestController // json return
public class ApiCourseController extends BaseController {

    private final CourseService courseService;
    private final CategoryService categoryService;

    @PostMapping("/api/course/req.api")
    public ResponseEntity<?> courseReq(Model model
            , @RequestBody TakeCourseInput parameter
            , Principal principal) { // principal - 로그인 정보 주입

        parameter.setUserId(principal.getName());

        ServiceResult result = courseService.req(parameter);
        if (!result.isResult()) {
            ResponseResult responseResult = new ResponseResult(false, result.getMessage());
            return ResponseEntity.ok().body(responseResult);
        }

        ResponseResult responseResult = new ResponseResult(true);
        return ResponseEntity.ok().body(responseResult);
    }


}