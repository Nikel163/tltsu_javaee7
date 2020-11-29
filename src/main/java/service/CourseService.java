package service;

import entity.Course;

public class CourseService extends EntityService<Course> {

    public CourseService() {
        init(Course.class);
    }
}
