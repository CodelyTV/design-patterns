export interface AchivementStrategy {
  dealAchievements(learnerId: string, earnedPoints: number): void;
}
