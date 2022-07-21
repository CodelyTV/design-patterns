package tv.codely.mooc.api.Ui.Console;

import tv.codely.mooc.api.Domain.Course;
import tv.codely.mooc.api.Infrastructure.Persistence.InMemoryCourseRepository;

import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class CreateCourseConsoleCommand {
    public static void main(String[] args) {
        var repository = new InMemoryCourseRepository();

        var id = "38cd5df7-f687-4077-8cf2-7739396b2d22";
        var name = "Course name";
        var duration = "Course duration";
        var course = new Course(id, name, duration);

        repository.save(course);
        Logger.getAnonymousLogger().log(new LogRecord(Level.INFO, "Course created with " + id));
    }
}
