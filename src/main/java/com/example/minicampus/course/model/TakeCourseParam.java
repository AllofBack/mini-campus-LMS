package com.example.minicampus.course.model;

import com.example.minicampus.admin.model.CommonParam;
import lombok.Data;

@Data
public class TakeCourseParam extends CommonParam {

    long id;
    String status;
    
    String userId;
    
    long searchCourseId;
}
