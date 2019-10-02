import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public final class LoginController {

    static void login() throws InterruptedException {
        String name = "Tarvek";
        String password = "voyS8384567kkk";

        WebElement element;
        LogicController.driver.manage().window().maximize();
        LogicController.driver.navigate().to("https://www.voyna-plemyon.ru/");
        LogicController.getWait().until(ExpectedConditions.visibilityOf(LogicController.driver.findElement(By.className("btn-login"))));

        element = LogicController.driver.findElement(By.id("user"));
        element.sendKeys(name);

        element = LogicController.driver.findElement(By.id("password"));
        element.sendKeys(password);

        element = LogicController.driver.findElement(By.className("btn-login"));
        element.click();

        Thread.sleep(400);
        element = LogicController.driver.findElement(By.xpath("//span[contains(@class, 'world_button_active')]"));
        element.click();
    }

}
