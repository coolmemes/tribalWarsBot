import objects.FarmVillage;

import java.util.ArrayList;
import java.util.stream.Collectors;

final class FarmTargetsController {
    static int maxPoints = 100;
    static int maxDistance = 10;
    static ArrayList<FarmVillage> farmVillages;

    static ArrayList<String> filterVillages() {
        farmVillages = new ArrayList<>();

        for (int i = 0; i < VillageDownloaderClass.getFarmVillageList().size(); i++) {
            FarmVillage village = VillageDownloaderClass.getFarmVillageList().get(i);
            if (village.getPoints() < maxPoints && distanceBetween(LogicController.currentVillage.getX(), village.getX(), LogicController.currentVillage.getY(), village.getY()) < maxDistance) {
                village.setDistance(distanceBetween(LogicController.currentVillage.getX(), village.getX(), LogicController.currentVillage.getY(), village.getY()));
                farmVillages.add(village);
            }
        }

        farmVillages = (ArrayList<FarmVillage>) farmVillages.stream().sorted().collect(Collectors.toList());
        ArrayList<String> targetStrings = new ArrayList<>();
        for (FarmVillage village: farmVillages) {
            targetStrings.add(village.getX() + "|" + village.getY());
        }
        return targetStrings;
    }

    static int distanceBetween (int x1, int x2, int y1, int y2) {
        return Double.valueOf(Math.sqrt((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1))).intValue();
    }

    public static CharSequence getNextTarget() { //Возвращает следующую цель из массива координат целей.
        LogicController.currentVillage.setTargetList(filterVillages());
        return LogicController.currentVillage.getTargetList().get(LogicController.currentVillage.getOutcomingAttackCounter());
        // То есть создаем массив целей для деревни,
        // потом берем из текущей деревни текущее количество атак и отправляем.
    }
}
