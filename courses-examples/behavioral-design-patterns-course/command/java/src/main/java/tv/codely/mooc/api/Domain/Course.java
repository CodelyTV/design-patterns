package tv.codely.mooc.api.Domain;

public class Course {
    private final CourseId id;
    private final CourseName name;
    private final CourseDuration duration;

    public Course(String id, String name, String duration) {
        this.id       = new CourseId(id);
        this.name     = new CourseName(name);
        this.duration = new CourseDuration(duration);
    }

    public String id() {
        return id.value();
    }

    public String name() {
        return name.value();
    }

    public String duration() {
        return duration.value();
    }
}
