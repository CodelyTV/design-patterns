import { CourseReview } from "./CourseReview";
import { Stars } from "./Stars";

export class CourseReviews {
  constructor(private reviews: CourseReview[]) {}

  meanStars(): number {
    const totalStars = this.reviews
      .map((review) => review.stars.value)
      .reduce((stars: number, total: number) => stars + total, 0);

    const totalReviews = this.reviews.length;
    return totalStars / totalReviews;
  }

  add(stars: Stars) {
    this.reviews.push(new CourseReview(stars));
  }
}
