package com.example.minicampus.admin.course.model;

import com.example.minicampus.common.model.CommonParam;
import lombok.Data;

@Data
public class TakeCourseParam extends CommonParam {

    long id;
    String status;
    
    String userId;
    
    long searchCourseId;
}
