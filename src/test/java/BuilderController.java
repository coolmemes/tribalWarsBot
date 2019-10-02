import objects.OffenceProgram;
import objects.PlayerVillage;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public final class BuilderController {

    public static void buildNext(ArrayList<OffenceProgram> program, WebDriver driver) {
        for (PlayerVillage village : VillagesController.getPlayerVillages()) {
            driver.navigate().to("https://ru62.voyna-plemyon.ru/game.php?village=" + village.getID() + "&screen=main");
            LogicController.getWait().until(ExpectedConditions.visibilityOf(LogicController.driver.findElement(By.id("buildings"))));
            fillTheVillageData(village);
            if (!isAlreadyBuilding()) {
                for (OffenceProgram offenceProgram : program) {//TODO Дописать выбор програм по имени деревни;
                    if (comparator(village, offenceProgram.getLevel(), offenceProgram.getBuildingName())) {
                        WebElement element = driver.findElement(By.id(offenceProgram.getNextBuilding()));
                        if (element.isDisplayed()) {
                            element.click();
                        }
                        break;
                    }
                }
            } else {
                System.out.println("We already build");
            }
        }
    }

    private static PlayerVillage fillTheVillageData(PlayerVillage village) {
        WebElement element;
        try {
            element = LogicController.driver.findElement(By.xpath("//tr[@id = 'main_buildrow_main']//span[contains(text(), 'Уровень')]"));
            village.setTownHallLevel(returnLevel(element.getText()));
        } catch (NoSuchElementException e) {
            village.setTownHallLevel(0);
        }

        try {
            element = LogicController.driver.findElement(By.xpath("//tr[@id = 'main_buildrow_barracks']//span[contains(text(), 'Уровень')]"));
            village.setBarracksLevel(returnLevel(element.getText()));
        } catch (NoSuchElementException e) {
            village.setBarracksLevel(0);
        }

        try {
            element = LogicController.driver.findElement(By.xpath("//tr[@id = 'main_buildrow_church_f']//span[contains(text(), 'Уровень')]"));
            village.setCathedralLevel(returnLevel(element.getText()));
        } catch (NoSuchElementException e) {
            village.setCathedralLevel(0);
        }

        try {
            element = LogicController.driver.findElement(By.xpath("//tr[@id = 'main_buildrow_place']//span[contains(text(), 'Уровень')]"));
            village.setAreaLevel(returnLevel(element.getText()));
        } catch (NoSuchElementException e) {
            village.setAreaLevel(0);
        }

        try {
            element = LogicController.driver.findElement(By.xpath("//tr[@id = 'main_buildrow_statue']//span[contains(text(), 'Уровень')]"));
            village.setStatueLevel(returnLevel(element.getText()));
        } catch (NoSuchElementException e) {
            village.setStatueLevel(0);
        }

        try {
            element = LogicController.driver.findElement(By.xpath("//tr[@id = 'main_buildrow_market']//span[contains(text(), 'Уровень')]"));
            village.setMarketLevel(returnLevel(element.getText()));
        } catch (NoSuchElementException e) {
            village.setMarketLevel(0);
        }

        try {
            element = LogicController.driver.findElement(By.xpath("//tr[@id = 'main_buildrow_wood']//span[contains(text(), 'Уровень')]"));
            village.setSawmillLevel(returnLevel(element.getText()));
        } catch (NoSuchElementException e) {
            village.setSawmillLevel(0);
        }

        try {
            element = LogicController.driver.findElement(By.xpath("//tr[@id = 'main_buildrow_stone']//span[contains(text(), 'Уровень')]"));
            village.setClayquarryLevel(returnLevel(element.getText()));
        } catch (NoSuchElementException e) {
            village.setClayquarryLevel(0);
        }

        try {
            element = LogicController.driver.findElement(By.xpath("//tr[@id = 'main_buildrow_iron']//span[contains(text(), 'Уровень')]"));
            village.setIronMineLevel(returnLevel(element.getText()));
        } catch (NoSuchElementException e) {
            village.setIronMineLevel(0);
        }

        try {
            element = LogicController.driver.findElement(By.xpath("//tr[@id = 'main_buildrow_farm']//span[contains(text(), 'Уровень')]"));
            village.setHomesteadLevel(returnLevel(element.getText()));
        } catch (NoSuchElementException e) {
            village.setHomesteadLevel(0);
        }

        try {
            element = LogicController.driver.findElement(By.xpath("//tr[@id = 'main_buildrow_storage']//span[contains(text(), 'Уровень')]"));
            village.setWarehouseLevel(returnLevel(element.getText()));
        } catch (NoSuchElementException e) {
            village.setWarehouseLevel(0);
        }

        try {
            element = LogicController.driver.findElement(By.xpath("//tr[@id = 'main_buildrow_hide']//span[contains(text(), 'Уровень')]"));
            village.setCacheLevel(returnLevel(element.getText()));
        } catch (NoSuchElementException e) {
            village.setCacheLevel(0);
        }

        try {
            element = LogicController.driver.findElement(By.xpath("//tr[@id = 'main_buildrow_stable']//span[contains(text(), 'Уровень')]"));
            village.setStableLevel(returnLevel(element.getText()));
        } catch (NoSuchElementException e) {
            village.setStableLevel(0);
        }

        try {
            element = LogicController.driver.findElement(By.xpath("//tr[@id = 'main_buildrow_garage']//span[contains(text(), 'Уровень')]"));
            village.setGarageLevel(returnLevel(element.getText()));
        } catch (NoSuchElementException e) {
            village.setGarageLevel(0);
        }

        try {
            element = LogicController.driver.findElement(By.xpath("//tr[@id = 'main_buildrow_snob']//span[contains(text(), 'Уровень')]"));
            village.setSnobLevel(returnLevel(element.getText()));
        } catch (NoSuchElementException e) {
            village.setSnobLevel(0);
        }

        try {
            element = LogicController.driver.findElement(By.xpath("//tr[@id = 'main_buildrow_smith']//span[contains(text(), 'Уровень')]"));
            village.setWallLevel(returnLevel(element.getText()));
        } catch (NoSuchElementException e) {
            village.setWallLevel(0);
        }

        try {
            element = LogicController.driver.findElement(By.xpath("//tr[@id = 'main_buildrow_wall']//span[contains(text(), 'Уровень')]"));
            village.setWallLevel(returnLevel(element.getText()));
        } catch (NoSuchElementException e) {
            village.setWallLevel(0);
        }

        /*element = driver.findElement(By.xpath("//*[contains(@title, 'Собор')]/following::span [contains(text(), 'Уровень')][1]"));

        element = driver.findElement(By.xpath("//*[contains(@title, 'Площадь')]/following::span [contains(text(), 'Уровень')][1]"));
        System.out.println(element.getText());
        element = driver.findElement(By.xpath("//*[contains(@title, 'Лесопилка')]/following::span [contains(text(), 'Уровень')][1]"));
        System.out.println(element.getText());
        element = driver.findElement(By.xpath("//*[contains(@title, 'Глиняный карьер')]/following::span [contains(text(), 'Уровень')][1]"));
        System.out.println(element.getText());
        element = driver.findElement(By.xpath("//*[contains(@title, 'Железная шахта')]/following::span [contains(text(), 'Уровень')][1]"));
        System.out.println(element.getText());
        element = driver.findElement(By.xpath("//*[contains(@title, 'Усадьба')]/following::span [contains(text(), 'Уровень')][1]"));
        System.out.println(element.getText());
        element = driver.findElement(By.xpath("//*[contains(@title, 'Склад')]/following::span [contains(text(), 'Уровень')][1]"));
        System.out.println(element.getText());
        element = driver.findElement(By.xpath("//*[contains(@title, 'Тайник')]/following::span [contains(text(), 'Уровень')][1]"));
        System.out.println(element.getText());*/
        return village;
    }

    private static int returnLevel(String data) {
        return Integer.parseInt(data.substring(data.length()-1));
    }

    private static boolean isAlreadyBuilding () {
        try {
            WebElement element = LogicController.driver.findElement(By.id("buildqueue"));
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    static boolean comparator(PlayerVillage village, int levelOfBuild, String nextBuilding) {
        switch (nextBuilding) {
            case ("main") : { return levelOfBuild > village.getTownHallLevel();}
            case ("barrack") : { return levelOfBuild > village.getBarracksLevel();}
            case ("cathedral") : { return levelOfBuild > village.getCathedralLevel();}
            case ("area") : { return levelOfBuild > village.getAreaLevel();}
            case ("statue") : { return levelOfBuild > village.getStatueLevel();}
            case ("market") : { return levelOfBuild > village.getMarketLevel();}
            case ("wood") : { return levelOfBuild > village.getSawmillLevel();}
            case ("stone") : { return levelOfBuild > village.getClayquarryLevel();}
            case ("iron") : { return levelOfBuild > village.getIronMineLevel();}
            case ("homesteadLevel") : { return levelOfBuild > village.getHomesteadLevel();}
            case ("warehouse") : { return levelOfBuild > village.getWarehouseLevel();}
            case ("cache") : { return levelOfBuild > village.getCacheLevel();}
            case ("stable") : { return levelOfBuild > village.getStableLevel();}
            case ("garage") : { return levelOfBuild > village.getGarageLevel();}
            case ("snob") : { return levelOfBuild > village.getSnobLevel();}
            case ("smith") : { return levelOfBuild > village.getSmithLevel();}
            case ("wall") : { return levelOfBuild > village.getWallLevel();}
            default : return false;
        }
    }
}
