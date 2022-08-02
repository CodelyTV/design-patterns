import fs from "fs";
import * as readline from "readline";

import { Course } from "./Course";
import { CourseRepository } from "./CourseRepository";
import { CourseReviews } from "./CourseReviews";
import { ReviewAdded } from "./ReviewAdded";

export class FileEventSourcedCourseRepository implements CourseRepository {
  find(id: string): Course {
    // TODO: Optimize reads
    const events = fs
      .readFileSync(`events-${id}.txt`, { flag: "r" })
      .toString()
      .trim()
      .split("\n")
      .map((e) => JSON.parse(e));

    const course = new Course(id, new CourseReviews([]));
    events.forEach((event) => course.handle(event));

    return course;
  }

  save(course: Course): void {
    course
      .pullDomainEvents()
      .map((domainEvent) =>
        fs.writeFileSync(
          `events-${course.id}.txt`,
          JSON.stringify(domainEvent) + "\n",
          { flag: "a" }
        )
      );
  }

  remove(id: string): void {
    const path = `events-${id}.txt`;
    if (fs.existsSync(path)) {
      fs.unlinkSync(path);
    }
  }

  async *stream(id: string): AsyncIterableIterator<ReviewAdded> {
    const path = `events-${id}.txt`;
    const readInterface = readline.createInterface(fs.createReadStream(path));

    for await (const line of readInterface) {
      if (line.trim() === "") {
        continue;
      }

      yield JSON.parse(line);
    }
  }
}
