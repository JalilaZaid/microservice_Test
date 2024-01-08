package com.ensa.course.client;

import com.ensa.course.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "student-service", url = "${application.config.students-url}")
public interface CourseStudentClient {

    @GetMapping("/course/{course-id}")
    List<Student> findAllStudentsByCourse(@PathVariable("course-id") Long courseId);
}
