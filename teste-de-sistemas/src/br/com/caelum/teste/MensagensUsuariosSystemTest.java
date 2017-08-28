package br.com.caelum.teste;

import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MensagensUsuariosSystemTest {
	
	private WebDriver driver;
	private URLDaAplicacao urlDaAplicacao;
	
    @Before
    public void inicializa() {
    	System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gustavo\\Downloads\\chromedriver_win32\\chromedriver.exe");
		this.driver = new ChromeDriver();
    }

    @After
    public void finaliza() {
    	driver.close();
    }
    
	@Test
	public void mensagemCampoNomeNaoFoiPreenchido() {

		driver.get(urlDaAplicacao.getUrlUsuarios());
		
		WebElement linkNovoUsuario = driver.findElement(By.linkText("Novo Usuário"));
		linkNovoUsuario.click();
		
		WebElement nome = driver.findElement(By.name("usuario.nome"));
		nome.sendKeys("");
		
		nome.submit();
		
		boolean isCampoNomeNaoPreenchido = driver.getPageSource().contains("Nome obrigatorio!");
	
		assertTrue(isCampoNomeNaoPreenchido);
		
	}
	
	@Test
	public void mensagemCampoEmailENomeNaoFoiPreenchido() {

		driver.get(urlDaAplicacao.getUrlUsuarios());
		
		WebElement linkNovoUsuario = driver.findElement(By.linkText("Novo Usuário"));
		linkNovoUsuario.click();
		
		WebElement nome = driver.findElement(By.name("usuario.nome"));
		WebElement email = driver.findElement(By.name("usuario.email"));
		nome.sendKeys("");
		email.sendKeys("");
		
		nome.submit();
		
		boolean isCampoNomeNaoPreenchido = driver.getPageSource().contains("Nome obrigatorio!");
		boolean isCampoEmailNaoPreenchido = driver.getPageSource().contains("E-mail obrigatorio!");
		
		assertTrue(isCampoNomeNaoPreenchido);
		assertTrue(isCampoEmailNaoPreenchido);
		
	}
	
}
