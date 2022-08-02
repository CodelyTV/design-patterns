import { AchivementStrategy } from "./AchivementStrategy";

export class FullstackGuruAchivement implements AchivementStrategy {
  dealAchievements(learnerId: string, earnedPoints: number): void {
    if (earnedPoints > 200) {
      throw Error(learnerId);
    }
  }
}
