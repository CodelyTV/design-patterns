package tv.codely.mooc.api.Domain;

import java.util.Optional;

public interface CourseRepository {
    void save(Course course);

    Optional<Course> search(CourseId id);
}
