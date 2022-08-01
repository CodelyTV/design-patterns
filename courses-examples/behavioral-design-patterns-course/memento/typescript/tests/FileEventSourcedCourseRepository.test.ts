import { Course } from "../src/Course";
import { CourseReviews } from "../src/CourseReviews";
import { FileEventSourcedCourseRepository } from "../src/FileEventSourcedCourseRepository";
import { Stars } from "../src/Stars";

const repository = new FileEventSourcedCourseRepository();

afterEach(() => {
  repository.remove("id");
});

describe("Event Sourced should", () => {
  it("saves and restores a Course", () => {
    const course = new Course("id", new CourseReviews([]));
    course.addReview(new Stars(1));
    course.addReview(new Stars(2));
    course.addReview(new Stars(3));
    course.addReview(new Stars(4));
    course.addReview(new Stars(5));

    repository.save(course);

    const foundCourse = repository.find("id");

    expect(foundCourse).toMatchObject(course);
  });
});
