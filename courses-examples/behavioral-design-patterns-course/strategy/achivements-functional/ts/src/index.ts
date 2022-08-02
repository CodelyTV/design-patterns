import { AchivementDealer } from "./AchivementDealer";
import { BackendGuruAchivement } from "./BackendGuruAchivement";
import { FrontendGuruAchivement } from "./FrontendGuruAchivement";
import { FullstackGuruAchivement } from "./FullstackGuruAchivement";

const learnerId = "36596ac0-ebe9-4bc0-a067-f0e4fb229dc0";
const dealer = new AchivementDealer(new BackendGuruAchivement());

dealer.dealAchievements(learnerId, 100);

dealer.changeStrategy(new FrontendGuruAchivement());
dealer.dealAchievements(learnerId, 200);

dealer.changeStrategy(new FullstackGuruAchivement());
dealer.dealAchievements(learnerId, 300);
