const learnerId = "36596ac0-ebe9-4bc0-a067-f0e4fb229dc0";

const backendGuruAchievement = (
  learnerId: string,
  earnedPoints: number
): void => {
  if (earnedPoints > 200) {
    throw Error(learnerId);
  }
};

const frontendGuruAchievement = (
  learnerId: string,
  earnedPoints: number
): void => {
  if (earnedPoints > 200) {
    throw Error(learnerId);
  }
};

const fullstackGuruAchievement = (
  learnerId: string,
  earnedPoints: number
): void => {
  if (earnedPoints > 200) {
    throw Error(learnerId);
  }
};

function achievementChecker(
  checker: (learnerId: string, earnedPoints: number) => void,
  learnerId: string,
  earnedPoints: number
) {
  checker(learnerId, earnedPoints);
}

achievementChecker(backendGuruAchievement, learnerId, 100);

achievementChecker(frontendGuruAchievement, learnerId, 200);

achievementChecker(fullstackGuruAchievement, learnerId, 300);
