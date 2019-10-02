import objects.PlayerVillage;

import java.util.ArrayList;

final class VillagesController {
    private static ArrayList<PlayerVillage> playerVillages;

    static ArrayList<PlayerVillage> getPlayerVillages() {
        return playerVillages;
    }

    private static boolean isOnlyVillage() {
        return true;
    }

    static void getVillages() {
        playerVillages  = new ArrayList<>();
        if (isOnlyVillage()) {
            PlayerVillage village = new PlayerVillage();
            playerVillages.add(village);
            playerVillages.get(0).setID(4191);//TODO
            playerVillages.get(0).setX(492);
            playerVillages.get(0).setY(563);
        } else {
            //TODO
            //LogicController.driver.navigate().to("https://ru62.voyna-plemyon.ru/game.php?village=4191&screen=main");
            //LogicController.getWait().until(ExpectedConditions.elementToBeClickable(By.xpath("//tr[@id = 'main_buildrow_main']//span[contains(text(), 'Уровень')]")));
        }
    }
}
