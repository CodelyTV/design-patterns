package tv.codely.mooc.api.Infrastructure.Persistence;

import org.springframework.stereotype.Service;
import tv.codely.mooc.api.Domain.Course;
import tv.codely.mooc.api.Domain.CourseId;
import tv.codely.mooc.api.Domain.CourseRepository;

import java.util.HashMap;
import java.util.Optional;

@Service
public class InMemoryCourseRepository implements CourseRepository {
    private final HashMap<String, Course> courses = new HashMap<>();

    public void save(Course course) {
        courses.put(course.id(), course);
    }

    public Optional<Course> search(CourseId id) {
        return Optional.ofNullable(courses.get(id.value()));
    }
}
