package tv.codely.mooc.api.Application.Create;

import tv.codely.mooc.api.Application.Command;

public record CreateCourseCommand(String id, String name, String duration) implements Command {
}
