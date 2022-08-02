import { Course } from "../src/Course";
import { CourseReviews } from "../src/CourseReviews";
import { FileSnapshotCourseRepository } from "../src/FileSnapshotCourseRepository";
import { Stars } from "../src/Stars";

const repository = new FileSnapshotCourseRepository();

afterEach(() => {
  repository.remove("id");
});

describe("FileSnapshotCourseRepository should", () => {
  it("saves and restores a Course", () => {
    const course = new Course("id", new CourseReviews([]));
    course.addReview(new Stars(1));
    course.addReview(new Stars(2));
    course.addReview(new Stars(3));
    course.addReview(new Stars(4));
    course.addReview(new Stars(5));
    course.pullDomainEvents();

    const courseSnapshot = course.createSnapshot();
    repository.save(courseSnapshot);

    const foundCourseSnapshot = repository.findLastSnapshot("id");
    const courseFromSnapshot = Course.fromSnapshot(foundCourseSnapshot);

    expect(course).toMatchObject(courseFromSnapshot);
  });
});
