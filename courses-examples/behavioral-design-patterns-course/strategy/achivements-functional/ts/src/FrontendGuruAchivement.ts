import { AchivementStrategy } from "./AchivementStrategy";

export class FrontendGuruAchivement implements AchivementStrategy {
  dealAchievements(learnerId: string, earnedPoints: number): void {
    if (earnedPoints > 200) {
      throw Error(learnerId);
    }
  }
}
