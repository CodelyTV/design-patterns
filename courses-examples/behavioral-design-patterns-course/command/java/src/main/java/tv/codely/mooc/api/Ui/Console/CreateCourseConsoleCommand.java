package tv.codely.mooc.api.Ui.Console;

import tv.codely.mooc.api.Application.Create.CourseCreator;
import tv.codely.mooc.api.Application.Create.CreateCourseCommand;
import tv.codely.mooc.api.Application.Create.CreateCourseCommandHandler;
import tv.codely.mooc.api.Infrastructure.Persistence.InMemoryCourseRepository;

public class CreateCourseConsoleCommand {
    public static void main(String[] args) {
        var repository = new InMemoryCourseRepository();
        var courseCreator = new CourseCreator(repository);
        var commandHandler = new CreateCourseCommandHandler(courseCreator);

        var id = "38cd5df7-f687-4077-8cf2-7739396b2d22";
        var name = "Course name";
        var duration = "Course duration";

        var command = new CreateCourseCommand(id, name, duration);
        commandHandler.execute(command);
    }
}
