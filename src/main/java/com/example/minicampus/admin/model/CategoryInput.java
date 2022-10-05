package com.example.minicampus.admin.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class CategoryInput {
    long id;
    String categoryName;
    int sortValue;
    boolean usingYn;
}
