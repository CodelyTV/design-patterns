import { AggregateRoot } from "./AggregateRoot";
import { CourseReview } from "./CourseReview";
import { CourseReviews } from "./CourseReviews";
import { CourseReviewSnapshot } from "./CourseReviewsSnapshot";
import { CourseSnapshot } from "./CourseSnapshot";
import { ReviewAdded } from "./ReviewAdded";
import { Stars } from "./Stars";

export class Course extends AggregateRoot {
  constructor(public readonly id: string, private reviews: CourseReviews) {
    super();
  }

  addReview(stars: Stars) {
    this.reviews.add(stars);
    this.record(new ReviewAdded(this.id, stars.value));
  }

  meanStars(): number {
    return this.reviews.meanStars();
  }

  handle(reviewAdded: ReviewAdded) {
    this.reviews.add(new Stars(reviewAdded.stars));
  }

  createSnapshot(): CourseSnapshot {
    return {
      id: this.id,
      reviews: this.reviews.createSnapshot(),
      date: new Date(),
    };
  }

  static fromSnapshot(snapshot: CourseSnapshot): Course {
    return new Course(
      snapshot.id,
      new CourseReviews(
        snapshot.reviews.reviews.map(
          (s) => new CourseReview(new Stars(s.stars))
        )
      )
    );
  }
}
