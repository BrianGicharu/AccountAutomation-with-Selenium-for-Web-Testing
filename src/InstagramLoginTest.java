import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

abstract class InstagramLoginTest {
    public static void test() throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chromeDriver.exe");
        int i;

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.instagram.com/accounts/login/");

        WebElement userName, password, submitBtn;
        String user = "Jamooh", pass = "%J0m7oh-&#mb=t";
        String[] names = new String[10];
        String[] passwords = new String[10];

        for (i = 0; i < 10; i++) {
            names[i] = user + String.format("%d", 5290+i);
            passwords[i] = pass + String.format("%d", i);
        }
        i=0;
        for (String name : names) {
            if (i == 0)Thread.sleep(3000);

            userName = driver.findElement(By.name("username"));
            password = driver.findElement(By.name("password"));
            submitBtn = driver.findElement(By.className("L3NKy"));

            userName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
            password.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

            userName.sendKeys(name);
            password.sendKeys(passwords[i]);

            Thread.sleep(2000);
            submitBtn.click();
            i++;
            Thread.sleep(5000);
        }
    }
}
