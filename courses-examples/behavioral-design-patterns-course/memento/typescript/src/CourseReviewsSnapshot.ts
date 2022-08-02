export type CourseReviewSnapshot = { stars: number };

export type CourseReviewsSnapshot = {
  reviews: Array<CourseReviewSnapshot>;
};
