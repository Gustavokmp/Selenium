package br.com.caelum.teste;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;

public class UsuariosSystemTest {
	private ChromeDriver driver;
	private UsuariosPage usuarios;

	@Before
	public void start() {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gustavo\\Downloads\\chromedriver_win32\\chromedriver.exe");
		this.driver = new ChromeDriver();
		this.usuarios= new UsuariosPage(driver);
	}

	@Test
	public void deveAdicionarUmUsuario() {

		usuarios.visita();
		usuarios.novo().cadastra("Gustavo Maciel Pires", "gustavomp@gmail.com");
		
		assertTrue(usuarios.existeNaListagem("Gustavo Maciel Pires", "gustavomp@gmail.com"));
		}
	@Test
	public void deveRemoverUmUsuario(){
		usuarios.visita();
		usuarios.novo().cadastra("Carinha", "carinha@gmail.com");
		assertTrue(usuarios.existeNaListagem("Carinha", "carinha@gmail.com"));
		usuarios.excluitUsuario(2);
		assertFalse(usuarios.existeNaListagem("Carinha", "carinha@gmail.com"));
	}

	@After
	public void close() {
		driver.close();

	}
		

}
