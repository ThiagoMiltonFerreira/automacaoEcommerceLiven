package LivenEcommercePage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.Propriedades;
import Utils.Utils;

public class HomeLojasPage {
	
	// Classe para testes
	
	public static void validaAcessoHomeLojas() {
		
		try {
			
			WebElement elemento = Utils.aguardarExibicaoComponente("//*[@class='card card-store']/div/div[1]", 20);
			if(elemento instanceof WebElement)
				Assert.assertEquals(Propriedades.getUrl()+"HomeLojas",Utils.getDriver().getCurrentUrl());
			
		} catch (Exception e) {
			
			System.out.println("NAO FOI POSSIVEL VALIDAR ACESSO A PAGINA HOME LOJAS, NAO FOI POSSIVEL VALIDAR TEXTO COM NOME DA LOJA OU SUA URL: " + e.getMessage());
			throw new RuntimeException("NAO FOI POSSIVEL VALIDAR ACESSO A PAGINA HOME LOJAS, NAO FOI POSSIVEL VALIDAR TEXTO COM NOME DA LOJA OU SUA URL.");
			
		}
				    
	}
	
	public static void clicaNaLoja(String xpath) {
		try {
			Utils.aguardar(1000);
			Utils.getDriver().findElement(By.xpath(xpath)).click();
		} catch (Exception e) {
			 System.out.println("NAO FOI POSSIVEL CLICAR NA LOJA TELA HOME LOJAS: " + e.getMessage());
			 throw new RuntimeException("NAO FOI POSSIVEL CLICAR NA LOJA TELA HOME LOJAS.");
		}

	}
	
}

