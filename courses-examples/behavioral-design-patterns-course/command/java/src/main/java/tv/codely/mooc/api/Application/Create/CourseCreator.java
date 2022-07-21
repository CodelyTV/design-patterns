package tv.codely.mooc.api.Application.Create;

import org.springframework.stereotype.Service;
import tv.codely.mooc.api.Domain.Course;
import tv.codely.mooc.api.Domain.CourseRepository;

@Service
public class CourseCreator {
    private final CourseRepository repository;

    public CourseCreator(CourseRepository repository) {
        this.repository = repository;
    }

    public void create(String id, String name, String duration) {
        var course = new Course(id, name, duration);
        repository.save(course);
    }
}
