import { CourseReviewsSnapshot } from "./CourseReviewsSnapshot";

export type CourseSnapshot = {
  id: string;
  reviews: CourseReviewsSnapshot;
  date: Date;
};
