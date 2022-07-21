package tv.codely.mooc.api.Application.Create;

import org.springframework.stereotype.Service;
import tv.codely.mooc.api.Application.Command;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

@Service
public class CreateCourseCommand extends Command {
    private final CourseCreator courseCreator;
    private String id;
    private String name;
    private String duration;

    public CreateCourseCommand(CourseCreator courseCreator) {
        this.courseCreator = courseCreator;
    }

    @Override
    protected void log() {
        Logger.getAnonymousLogger().log(new LogRecord(Level.INFO, "Course created: " + id));
    }

    @Override
    protected void run() {
        courseCreator.create(id, name, duration);
    }

    public void setParams(String id, String name, String duration) {

        this.id = id;
        this.name = name;
        this.duration = duration;
    }
}
