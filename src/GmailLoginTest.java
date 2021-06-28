import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GmailLoginTest {
    public static void test() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files\\Google\\Chrome\\Application\\chromeDriver.exe");
        int i;

        WebDriver driver = new ChromeDriver();
        driver.get("https://accounts.google.com/signin/v2/identifier?flowName=GlifWebSignIn&flowEntry=ServiceLogin");

        WebElement userName, password,nextBtn, submitBtn;
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

            userName = driver.findElement(By.name("identifier"));
            userName.sendKeys(name+"@gmail.com");
            nextBtn = driver.findElement(By.className("qIypjc"));
            Thread.sleep(1000);
            nextBtn.click();
            Thread.sleep(4000);
            password = driver.findElement(By.name("password"));
            submitBtn = driver.findElement(By.className("qIypjc"));
            password.sendKeys(passwords[i]);
            Thread.sleep(2000);
            submitBtn.click();
            i++;
            Thread.sleep(2000);
            userName.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
            password.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));

        }
    }
}
