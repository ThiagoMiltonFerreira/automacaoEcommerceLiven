package LivenEcommercePage;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import Base.Propriedades;
import Utils.Utils;


public class CarrinhoPage {
	private static String mensagemEsperadaCarrinhoVazio = "Sem produtos no carrinho :(";
	
	public static void validaAcessoTelaCarrinho(){
		System.out.println("Validando acesso a tela carrinho.");
		try {
			
			WebElement elemento = Utils.aguardarExibicaoComponente("//section[@class='section']//*[contains(text(), 'Carrinho')]", 10);
			if(elemento instanceof WebElement)
				Assert.assertEquals(Propriedades.getUrl()+"/cart",Utils.getDriver().getCurrentUrl());
			
		} catch (Exception e) {
			
			System.out.println("NAO FOI POSSIVEL VALIDAR ACESSO A PAGINA CARRINHO: " + e.getMessage());
			throw new RuntimeException("NAO FOI POSSIVEL VALIDAR ACESSO A PAGINA CARRINHO.");
			
		}
	}
	
	public static void validaValorDaUnidadeDoProdutoCardCarrinho(String valorDoProduto) {
		System.out.println("Validando valor da unidade do produto no card do carrinho.");
		 String text = Utils.getDriver().findElement(By.xpath("//*[@class='content']/p")).getText();
		    
	        // Separar o texto na parte antes e depois de "x"
	        String[] beforeAndAfterX = text.split(" x ");
	        
	        // Separar a parte após "x" na parte antes e depois de "R$"
	        String[] beforeAndAfterRS = beforeAndAfterX[1].split("\nR\\$ ");
	        
	        Assert.assertEquals(valorDoProduto, beforeAndAfterRS[1]);
	
	}
	public static void validaQuantidadeDoProdutoCardCarrinho(String qtdProduto) {
		System.out.println("Validando quantidade de produto no card do carrinho.");
		 String text = Utils.getDriver().findElement(By.xpath("//*[@class='content']/p")).getText();
		    
	        // Separar o texto na parte antes e depois de "x"
	        String[] beforeAndAfterX = text.split(" x ");
	        
	        // Separar a parte após "x" na parte antes e depois de "R$"
	        String[] beforeAndAfterRS = beforeAndAfterX[1].split("\nR\\$ ");
	        
	        Assert.assertEquals(qtdProduto, beforeAndAfterRS[0]);
	}
	public static void validaValorTotalDoProdutoCardCarrinho(String valorTotal) {
		 System.out.println("Validando valor total do produto produto no card do carrinho.");
		 String valorTela = Utils.getDriver().findElement(By.xpath("//div[@class='level-item']//*[contains(text(), 'R$ ')]")).getText();
	     Assert.assertEquals("R$ "+valorTotal, valorTela);
	}
	public static void clicarBtnFecharPedido() {
		 Utils.getDriver().findElement(By.xpath("//button[@class='button is-success']")).click();  
	}
	public static void clicarBtnMaisPrimeiroProdutoDoCarrinho() {
		 Utils.getDriver().findElement(By.xpath("//div[@class='box'][1]/ul/li/article/div[@class='media-right']/div/div[1]")).click();    
	}
	public static void clicarBtnMenosPrimeiroProdutoDoCarrinho() {
		 Utils.getDriver().findElement(By.xpath("//div[@class='box'][1]/ul/li/article/div[@class='media-right']/div/div[2]")).click();    
	}
	
	public static void validarMensagemSemProdutos() {
		System.out.println("Validando mensagem da tela carrinho quando nao existem produtos.");
		 String mensagemTela = Utils.getDriver().findElement(By.xpath("//*[@class=\"notification is-info\"]")).getText();
	     Assert.assertEquals(mensagemEsperadaCarrinhoVazio, mensagemTela);   
	}
}
