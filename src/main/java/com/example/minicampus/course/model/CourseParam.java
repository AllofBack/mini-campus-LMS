package com.example.minicampus.course.model;

import com.example.minicampus.admin.model.CommonParam;
import lombok.Data;

@Data
public class CourseParam extends CommonParam {

    long id; //course.id
    long categoryId;

}
