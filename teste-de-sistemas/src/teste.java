import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class teste {
	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\Gustavo\\Downloads\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();

		driver.get("http://localhost:8100/");
	

		WebElement produto = driver.findElement(By.name("nome"));
		WebElement quantidade = driver.findElement(By.name("qtde"));
		produto.sendKeys("Macarao");
		quantidade.sendKeys("10");
		
		
	}

}
