import objects.OffenceProgram;
import objects.PlayerVillage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.IOException;


public class LogicController {
    static
    {
        System.setProperty("webdriver.chrome.driver", "src/test/drv/chromedriver.exe");
    }

    public static WebDriver driver = new ChromeDriver();;
    public static PlayerVillage currentVillage;
    private static Wait<WebDriver> wait = new WebDriverWait(driver, 5, 1000);

    public static Wait<WebDriver> getWait() {
        return wait;
    }



    public static void main(String[] args) throws InterruptedException, IOException {
        VillageDownloaderClass.getFile();

        LoginController.login();

        VillagesController.getVillages();

        while (true) {
            FarmController.sendFarm(true);

            BuilderController.buildNext(OffenceProgram.program, LogicController.driver);

            Thread.sleep(120000);
        }
    }
}
