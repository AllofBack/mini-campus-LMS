package com.example.minicampus.admin.course.model;

import com.example.minicampus.common.model.CommonParam;
import lombok.Data;

@Data
public class CourseParam extends CommonParam {

    long id; //course.id
    long categoryId;

}
