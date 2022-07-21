package tv.codely.mooc.api.Ui.Api.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tv.codely.mooc.api.Domain.Course;
import tv.codely.mooc.api.Domain.CourseRepository;

import java.io.Serializable;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

@RestController
public class CoursesPutController {
    private final CourseRepository repository;

    CoursesPutController(CourseRepository repository) {
        this.repository = repository;
    }

    @PutMapping(value = "/courses/{id}")
    public ResponseEntity<HashMap<String, Serializable>> index(
        @PathVariable String id,
        @RequestBody CoursePutControllerRequestBody body
    ) {
        var course = new Course(id, body.name(), body.duration());
        repository.save(course);
        Logger.getAnonymousLogger().log(new LogRecord(Level.INFO, "Course created: " + id));

        return ResponseEntity.status(HttpStatus.CREATED).body(new HashMap<>());
    }
}

