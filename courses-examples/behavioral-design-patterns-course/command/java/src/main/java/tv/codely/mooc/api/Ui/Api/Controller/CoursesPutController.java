package tv.codely.mooc.api.Ui.Api.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import tv.codely.mooc.api.Application.Create.CreateCourseCommand;
import tv.codely.mooc.api.Application.Create.CreateCourseCommandHandler;

import java.io.Serializable;
import java.util.HashMap;

@RestController
public class CoursesPutController {
    private final CreateCourseCommandHandler commandHandler;

    public CoursesPutController(CreateCourseCommandHandler commandHandler) {
        this.commandHandler = commandHandler;
    }

    @PutMapping(value = "/courses/{id}")
    public ResponseEntity<HashMap<String, Serializable>> index(
        @PathVariable String id,
        @RequestBody CoursePutControllerRequestBody body
    ) {
        var command = new CreateCourseCommand(id, body.name(), body.duration());
        commandHandler.execute(command);

        return ResponseEntity.status(HttpStatus.CREATED).body(new HashMap<>());
    }
 }

