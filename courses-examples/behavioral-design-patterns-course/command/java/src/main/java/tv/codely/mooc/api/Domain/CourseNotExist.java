package tv.codely.mooc.api.Domain;

public final class CourseNotExist extends DomainError {
    public CourseNotExist(CourseId id) {
        super("course_not_exist", String.format("The course <%s> doesn't exist", id.value()));
    }
}
