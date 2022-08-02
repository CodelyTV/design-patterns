import { AchivementStrategy } from "./AchivementStrategy";

export class AchivementDealer {
  constructor(private strategy: AchivementStrategy) {}

  dealAchievements(learnerId: string, earnedPoints: number): void {
    this.strategy.dealAchievements(learnerId, earnedPoints);
  }

  changeStrategy(strategy: AchivementStrategy): void {
    this.strategy = strategy;
  }
}
