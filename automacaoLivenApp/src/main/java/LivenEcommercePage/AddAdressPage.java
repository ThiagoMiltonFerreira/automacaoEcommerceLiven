package LivenEcommercePage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.Propriedades;
import Utils.Utils;

public class AddAdressPage{
	
	public static void validaAcessoAddAdress() {
		
		try {
			
			WebElement elemento = Utils.aguardarExibicaoComponente("//*[@class='v-sheet theme--dark v-toolbar v-toolbar--dense v-app-bar v-app-bar--fixed']/div//*[contains(text(), 'Endereço de Entrega')][1]", 20);
			if(elemento instanceof WebElement)
				Assert.assertEquals(Propriedades.getUrl()+"AddAddress",Utils.getDriver().getCurrentUrl());
			
		} catch (Exception e) {
			
			System.out.println("NAO FOI POSSIVEL VALIDAR ACESSO A PAGINA ADDADDRESS, NAO FOI POSSIVEL VALIDAR TEXTO 'Endereço de entrega' no cabeçalho da pagina OU URL: " + e.getMessage());
			throw new RuntimeException("NAO FOI POSSIVEL VALIDAR ACESSO A PAGINA ADDADDRESS, NAO FOI POSSIVEL VALIDAR TEXTO 'Endereço de entrega' no cabeçalho da pagina OU URL.");
			
		}				    
	}
	public static void escreverNoCampoEndereco(String enderecoCompleto) {
		//Caso endereço seja em branco seta por padrao o endereço da teknisa
		if (enderecoCompleto == "") {
			enderecoCompleto = "R. Sergipe, 1014 - 7º e 8º andar - Savassi, Belo Horizonte - MG, 30130-171, Brasi";
		}

		try {
			Utils.getDriver().findElement(By.id("searchTextField")).sendKeys(enderecoCompleto);
		} catch (Exception e) {
			 System.out.println("NÃO FOI POSSIVEL ESCREVE O ENDEREÇO NO INPUT NA TELA ADDADRESS " + e.getMessage());
			 throw new RuntimeException("NÃO FOI POSSIVEL ESCREVER O ENDEREÇO NO INPUT NA TELA ADDADRESS");
		}	

		try {
			Utils.getDriver().findElement(By.xpath("//div[@class='pac-container pac-logo hdpi']")).click();
		} catch (Exception e) {
			 System.out.println("NÃO FOI POSSIVEL CLICAR NO ENDEREÇO NA CAIXA DE OPÇOES DO GOOGLE NA TELA ADDADRESS " + e.getMessage());
			 throw new RuntimeException("NÃO FOI POSSIVEL CLICAR NO ENDEREÇO NA CAIXA DE OPÇOES DO GOOGLE NA TELA ADDADRESS");
		}
		Utils.aguardar(500);
		

	}
	public static void clicarNoBotaoContinuar() {
		try {
			Utils.getDriver().findElement(By.xpath("//div[@class='display-flex SIM']//button[contains(text(), 'Continuar')]")).click();
		} catch (Exception e) {
			 System.out.println("NÃO FOI POSSIVEL CLICAR NO BOTÃO CONTINUAR TELA ADDADRESS " + e.getMessage());
			 throw new RuntimeException("NÃO FOI POSSIVEL CLICAR NO BOTÃO CONTINUAR TELA ADDADRESS.");
		}
	}
	public static void clicarNoBotaoCancelar() {
		try {
			Utils.getDriver().findElement(By.xpath("//div[@class='display-flex SIM']//span[contains(text(), 'Cancelar')]")).click();
		} catch (Exception e) {
			 System.out.println("NÃO FOI POSSIVEL CLICAR NO BOTÃO VOLTAR TELA ADDADRESS " + e.getMessage());
			 throw new RuntimeException("NÃO FOI POSSIVEL CLICAR NO BOTÃO VOLTAR TELA ADDADRESS.");
		}
	}
	public static void clicarNoBotaoVoltar() {
        //Criar click no botao voltar na tela addAdress
	}

}
