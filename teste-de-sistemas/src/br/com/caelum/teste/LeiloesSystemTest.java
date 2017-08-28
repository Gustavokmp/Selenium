package br.com.caelum.teste;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LeiloesSystemTest {
	
	private WebDriver driver;
	private LeiloesPage leiloes;
	
	@Before
	public void inicializa(){
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gustavo\\Downloads\\chromedriver_win32\\chromedriver.exe");
		this.driver = new ChromeDriver();
		leiloes = new LeiloesPage(driver);
		UsuariosPage usuarios = new UsuariosPage(driver);
		usuarios.visita();
		usuarios.novo().cadastra("Paulo Henrique", "pauloHenrique@gmail.com");
	}
	@Test
	public void deveCadastraUmLeilao(){
		leiloes.visita();
		NovoLeilaoPage novoLeilao = leiloes.novo();
		novoLeilao.preenche("Geladeira", 123, "Paulo Henrique", true);
		assertTrue(leiloes.existe("Geladeira", 123, "Paulo Henrique", true));
	}
	@After
	public void finaliza(){
		driver.close();
	}

}
