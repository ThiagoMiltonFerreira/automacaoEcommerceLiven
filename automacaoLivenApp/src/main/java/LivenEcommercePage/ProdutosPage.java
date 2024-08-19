package LivenEcommercePage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.Propriedades;
import Utils.Utils;

public class ProdutosPage {
	
	private static String caminhoBtnCarrinho = "//footer[@class='card-footer']/a";
	private static String caminhoBtnMenu = "//*[@id='root']/nav/div[1]/a[2]";
	private static String caminhoBtnCarrinhoMenu = "//div[@class='navbar-start']/a[@class='navbar-item'][2]";
	
	public static void validaAcessoProdutos() {
		System.out.println("Validando acesso a tela produtos.");		
		try {
			
			WebElement elemento = Utils.aguardarExibicaoComponente("//section[@class='section']//*[contains(text(), 'Produtos')]", 10);
			if(elemento instanceof WebElement)
				Assert.assertEquals(Propriedades.getUrl()+'/',Utils.getDriver().getCurrentUrl());
			
		} catch (Exception e) {
			
			System.out.println("NAO FOI POSSIVEL VALIDAR ACESSO A PAGINA PRODUTOS: " + e.getMessage());
			throw new RuntimeException("NAO FOI POSSIVEL VALIDAR ACESSO A PAGINA PRODUTOS.");
			
		}
				    
	}
	
	public static void clicarBtnCarrinho() {
		try {
			Utils.aguardar(1000);
			Utils.getDriver().findElement(By.xpath(caminhoBtnCarrinho)).click();
		} catch (Exception e) {
			 System.out.println("NAO FOI POSSIVEL CLICAR NO BOTAO +CARRINHO: " + e.getMessage());
			 throw new RuntimeException("NAO FOI POSSIVEL CLICAR NO BOTÃO +CARRINHO.");
		}

	}
	
	public static void clicarBtnMenu() {
		try {
			Utils.aguardar(1000);
			Utils.getDriver().findElement(By.xpath(caminhoBtnMenu)).click();
		} catch (Exception e) {
			 System.out.println("NAO FOI POSSIVEL CLICAR NO MENU: " + e.getMessage());
			 throw new RuntimeException("NAO FOI POSSIVEL CLICAR NO MENU.");
		}

	}
	public static void clicarBtnCarrinhoDoMenu() {
		try {
			Utils.getDriver().findElement(By.xpath(caminhoBtnCarrinhoMenu)).click();
		} catch (Exception e) {
			 System.out.println("NAO FOI POSSIVEL CLICAR NO ICONE CARRINHO DENTRO DO MENU: " + e.getMessage());
			 throw new RuntimeException("NAO FOI POSSIVEL NO ICONE CARRINHO DENTRO DO MENU");
		}

	}
	
	
}

