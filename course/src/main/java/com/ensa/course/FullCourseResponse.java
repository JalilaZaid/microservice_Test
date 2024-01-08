package com.ensa.course;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class FullCourseResponse {

    private String courseName;
    private String instructorEmail;
    private List<Student> students;
}
