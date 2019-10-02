import objects.PlayerVillage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public final class FarmController {

    static void sendFarm (boolean isSendKnight) {
        for (PlayerVillage village : VillagesController.getPlayerVillages()){
            LogicController.currentVillage = village;
            LogicController.driver.navigate().to("https://ru62.voyna-plemyon.ru/game.php?village=" + village.getID() + "&screen=place");
            LogicController.getWait().until(ExpectedConditions.visibilityOf(LogicController.driver.findElement(By.id("target_attack"))));
            for (int i = 0; i < getArmy().size(); i++) {
                if (armyPortions().get(i) != 0) {
                    if (getArmy().get(i) / armyPortions().get(i) >= 1) {
                        while (getArmy().get(i) / armyPortions().get(i) >= 1) {
                            if (i != 11 && isSendKnight) {
                                FarmController.sendArmy(listOfID().get(i), armyPortions().get(i));
                            }
                        }
                    }
                }
            }
        }
    }

    private static void sendArmy(String id, int portion) {
        WebElement element;
        element = LogicController.driver.findElement(By.id(id));
        element.sendKeys(String.valueOf(portion));
        element = LogicController.driver.findElement(By.name("input"));
        element.sendKeys(FarmTargetsController.getNextTarget());
        element = LogicController.driver.findElement(By.id("target_attack"));
        element.click();

        try {
            element = LogicController.driver.findElement(By.xpath("//div [contains(text(), 'Игрок находится под защитой')]"));
            System.out.println("Игрок находится под защитой");
            element = LogicController.driver.findElement(By.xpath("//img [@class = 'village-delete']"));
            element.click();
            LogicController.currentVillage.increaseOutComeAttacks();
            element = LogicController.driver.findElement(By.id(id));
            element.clear();
        } catch (NoSuchElementException e) {
            System.out.println("Защита не светит");
            LogicController.currentVillage.increaseOutComeAttacks();
            LogicController.getWait().until(ExpectedConditions.visibilityOf(LogicController.driver.findElement(By.id("troop_confirm_go"))));
            element = LogicController.driver.findElement(By.id("troop_confirm_go"));
            element.click();
            LogicController.getWait().until(ExpectedConditions.visibilityOf(LogicController.driver.findElement(By.id("target_attack"))));
        }
    }

    static ArrayList<Integer> getArmy() {
        ArrayList<Integer> armyList = new ArrayList<>();
        armyList.add(Integer.parseInt(deleteEnd(LogicController.driver.findElement(By.id("units_entry_all_spear")).getText()))); //spears
        armyList.add(Integer.parseInt(deleteEnd(LogicController.driver.findElement(By.id("units_entry_all_sword")).getText()))); //swords
        armyList.add(Integer.parseInt(deleteEnd(LogicController.driver.findElement(By.id("units_entry_all_axe")).getText()))); //axes
        armyList.add(Integer.parseInt(deleteEnd(LogicController.driver.findElement(By.id("units_entry_all_archer")).getText()))); //archer
        armyList.add(Integer.parseInt(deleteEnd(LogicController.driver.findElement(By.id("units_entry_all_spy")).getText()))); //spy
        armyList.add(Integer.parseInt(deleteEnd(LogicController.driver.findElement(By.id("units_entry_all_light")).getText()))); //light cavalery
        armyList.add(Integer.parseInt(deleteEnd(LogicController.driver.findElement(By.id("units_entry_all_marcher")).getText()))); //marcher
        armyList.add(Integer.parseInt(deleteEnd(LogicController.driver.findElement(By.id("units_entry_all_heavy")).getText()))); //heavy
        armyList.add(Integer.parseInt(deleteEnd(LogicController.driver.findElement(By.id("units_entry_all_ram")).getText()))); //ram
        armyList.add(Integer.parseInt(deleteEnd(LogicController.driver.findElement(By.id("units_entry_all_catapult")).getText()))); //catapult
        armyList.add(Integer.parseInt(deleteEnd(LogicController.driver.findElement(By.id("units_entry_all_knight")).getText()))); //knight
        return armyList;
    }

    static ArrayList<Integer> armyPortions() {
        ArrayList<Integer> portionOfArmy = new ArrayList<>();
            portionOfArmy.add(10);
            portionOfArmy.add(10);
            portionOfArmy.add(100);
            portionOfArmy.add(100);
            portionOfArmy.add(0);
            portionOfArmy.add(10);
            portionOfArmy.add(15);
            portionOfArmy.add(15);
            portionOfArmy.add(0);
            portionOfArmy.add(0);
            portionOfArmy.add(1);
        return portionOfArmy;
    }

    static ArrayList<String> listOfID() {
        ArrayList<String> IDs= new ArrayList<>();
        IDs.add("unit_input_spear");
        IDs.add("unit_input_sword");
        IDs.add("unit_input_axe");
        IDs.add("unit_input_archer");
        IDs.add("unit_input_spy");
        IDs.add("unit_input_light");
        IDs.add("unit_input_marcher");
        IDs.add("unit_input_heavy");
        IDs.add("unit_input_ram");
        IDs.add("unit_input_catapult");
        IDs.add("unit_input_knight");
        return IDs;
    }

    static String deleteEnd(String string) {
        char[] data = string.toCharArray();
        return new String(data, 1, data.length-2);
    }
}
