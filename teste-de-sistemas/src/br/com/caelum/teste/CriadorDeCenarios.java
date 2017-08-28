package br.com.caelum.teste;

import org.openqa.selenium.WebDriver;

public class CriadorDeCenarios {

	private WebDriver driver;

    public CriadorDeCenarios(WebDriver driver) {
        this.driver = driver;
    }

    public CriadorDeCenarios umUsuario(String nome, String email) {
        UsuariosPage usuarios = new UsuariosPage(driver);

        URLDaAplicacao urlDaAplicacao = new URLDaAplicacao();
        driver.get(urlDaAplicacao.getUrlUsuarios());
        
        usuarios.novo().cadastra(nome, email);;

        return this;
    }

    public CriadorDeCenarios umLeilao(String usuario, 
                String produto, 
                double valor, 
                boolean usado) {
    	
        LeiloesPage leiloes = new LeiloesPage(driver);
        
        URLDaAplicacao url = new URLDaAplicacao();
        driver.get(url.getUrlLeiloes());

        leiloes.novo().preenche(produto, valor, usuario, usado);

        return this;
    }

}