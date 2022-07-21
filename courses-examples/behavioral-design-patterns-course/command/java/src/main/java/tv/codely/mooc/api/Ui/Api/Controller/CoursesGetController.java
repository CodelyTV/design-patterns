package tv.codely.mooc.api.Ui.Api.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import tv.codely.mooc.api.Domain.CourseId;
import tv.codely.mooc.api.Domain.CourseNotExist;
import tv.codely.mooc.api.Domain.CourseRepository;

import java.io.Serializable;
import java.util.HashMap;

@RestController
public class CoursesGetController {
    private final CourseRepository repository;

    public CoursesGetController(CourseRepository repository) {
        this.repository = repository;
    }

    @GetMapping(value = "/courses/{id}")
    public ResponseEntity<HashMap<String, Serializable>> index(
        @PathVariable String id
    ) {
        CourseId courseId = new CourseId(id);
        var course = repository.search(courseId)
            .orElseThrow(() -> new CourseNotExist(courseId));

        return ResponseEntity.status(HttpStatus.OK)
            .body(new HashMap<>() {{
                put("id", course.id());
                put("name", course.name());
                put("duration", course.duration());
            }});
    }
}
