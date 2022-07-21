package tv.codely.mooc.api.Ui.Api.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tv.codely.mooc.api.Application.Create.CreateCourseCommand;

import java.io.Serializable;
import java.util.HashMap;

@RestController
public class CoursesPutController {
    private final CreateCourseCommand command;

    public CoursesPutController(CreateCourseCommand command) {
        this.command = command;
    }

    @PutMapping(value = "/courses/{id}")
    public ResponseEntity<HashMap<String, Serializable>> index(
        @PathVariable String id,
        @RequestBody CoursePutControllerRequestBody body
    ) {
        command.setParams(id, body.name(), body.duration());
        command.execute();

        return ResponseEntity.status(HttpStatus.CREATED).body(new HashMap<>());
    }
}

