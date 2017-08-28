package br.com.caelum.teste;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LanceSystemTest {
	
	private WebDriver driver;
	private LeiloesPage leiloes;
	
	@Before
	public void inicializa(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gustavo\\Downloads\\chromedriver_win32\\chromedriver.exe");
		this.driver = new ChromeDriver();
		
		driver.get("http://localhost:8080/apenas-teste/limpa");
		leiloes = new LeiloesPage(driver);
		
leiloes = new LeiloesPage(driver);
		
		URLDaAplicacao url = new URLDaAplicacao();
		driver.get(url.getUrlLimpaBase());
		
		CriadorDeCenarios criaCenario = new CriadorDeCenarios(driver);
		criaCenario.umUsuario("Paulo Henrique", "paulo@henrique.com");
		criaCenario.umUsuario("José Eduardo", "jose@eduardo.com");
		
		criaCenario.umLeilao("Paulo Henrique", "Paulo Henrique", 100, false);
		
		
	}
	
	@Test
	public void deveFazerUmLance(){
		DetalhesDoLeilaoPage lances =  leiloes.detalhes(1);
		lances.lance("José Eduardo",150);
		assertTrue(lances.existeLance("José Eduardo",150));
	}
	@After
	public void finaliza() {
		driver.close();
	}
	

}
