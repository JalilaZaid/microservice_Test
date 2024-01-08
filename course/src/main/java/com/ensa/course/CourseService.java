package com.ensa.course;

import com.ensa.course.client.CourseStudentClient;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import lombok.Builder;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository repository;
    private final CourseStudentClient courseStudentClient;

    public void saveCourse(Course course) {
        repository.save(course);
    }

    public List<Course> findAllCourses() {
        return repository.findAll();
    }

    public FullCourseResponse findCoursesWithStudents(Long courseId) {
        var course = repository.findById(courseId)
                .orElse(
                        Course.builder()
                                .courseName("NOT_FOUND")
                                .instructorEmail("NOT_FOUND")
                                .build()
                );
        var students = courseStudentClient.findAllStudentsByCourse(courseId);
        return FullCourseResponse.builder()
                .courseName(course.getCourseName())
                .instructorEmail(course.getInstructorEmail())
                .students(students)
                .build();
    }
}
