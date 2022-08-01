import { AggregateRoot } from "./AggregateRoot";
import { CourseReviews } from "./CourseReviews";
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
}
