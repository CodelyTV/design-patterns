package tv.codely.mooc.api.Application.Create;

import org.springframework.stereotype.Service;
import tv.codely.mooc.api.Application.CommandHandler;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

@Service
public class CreateCourseCommandHandler extends CommandHandler<CreateCourseCommand> {
    private final CourseCreator courseCreator;

    public CreateCourseCommandHandler(CourseCreator courseCreator) {
        this.courseCreator = courseCreator;
    }

    @Override
    protected void log(CreateCourseCommand command) {
        Logger.getAnonymousLogger().log(new LogRecord(Level.INFO, "Course created: " + command.id()));

    }

    @Override
    protected void run(CreateCourseCommand command) {
        courseCreator.create(
            command.id(),
            command.name(),
            command.duration()
        );
    }
}
