package LivenEcommercePage;

import java.util.List;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.Propriedades;
import Utils.Utils;

public class PedidoPage{
	public static void validaAcessoTelaPedido(){
		try {
			
			WebElement elemento = Utils.aguardarExibicaoComponente("//div[@class='order-section-container']", 10);
			if(elemento instanceof WebElement)
				Assert.assertEquals(Propriedades.getUrl()+"Pedido",Utils.getDriver().getCurrentUrl());
			
		} catch (Exception e) {
			
			System.out.println("NAO FOI POSSIVEL VALIDAR ACESSO A PAGINA PEDIDO, NAO FOI POSSIVEL VALIDAR UM ELEMENTO UNICO NA TELA OU SUA URL: " + e.getMessage());
			throw new RuntimeException("NAO FOI POSSIVEL VALIDAR ACESSO A PAGINA PEDIDO, NAO FOI POSSIVEL VALIDAR UM ELEMENTO UNICO NA TELA OU SUA URL");
			
		}
	}
	
	public static void validaEndrecoDeEntrega(String endereco) {
		endereco = endereco.replaceAll(" ", "");
		String enderecoTela = Utils.getDriver().findElement(By.xpath("//div[@class='deliver-location-container']/div/div[2]")).getText().replaceAll(" ", "");
		Assert.assertEquals(endereco,enderecoTela);
	}
	public static void validaProdutoAdicionados(String qtdProduto,String nomeProduto) {
		String produto = qtdProduto+"x "+nomeProduto;		
		boolean ProdEncontrado = false;
		
		List<WebElement> prods = Utils.getDriver().findElements(By.xpath("//div[@class='orderItem']/div[@class='esquerda']/span[1]"));
		
		for (WebElement prod :prods) {			 
			 if(prod.getText().equals(produto)) {				 
				 ProdEncontrado = true;
				 Assert.assertEquals(produto, prod.getText());				 
			 }
	    }
		
		 if(ProdEncontrado == false) {
				System.out.println("PRODUTO " +produto+ " NAO ENCONTRADO NA LISTAGEM DE PRODUTOS ADICIONADOS NA TELA PEDIDO.");
				throw new RuntimeException("PRODUTO " +produto+ " NAO ENCONTRADO NA LISTAGEM DE PRODUTOS ADICIONADOS NA TELA PEDIDO.");
		 }				
	}
	public static void validarValorTotalDaCompra(String valorTotalDaCompra) {	
		String valorTotal = Utils.getDriver().findElement(By.xpath("//span[@class='value']")).getText().substring(3);	
		Assert.assertEquals(valorTotalDaCompra, valorTotal);		
	}
	public static void clicarBotaoEscolher() {
		Utils.getDriver().findElement(By.xpath("//*[contains(text(), 'Selecione a forma de pagamento')]/../../div[2]/span")).click();
	}
	public static void validarFormaDePagamentoSelecionada(String formaDePagamento) {
		Assert.assertEquals(formaDePagamento.toUpperCase(),Utils.getDriver().findElement(By.xpath("//*[contains(text(), '"+formaDePagamento+"')]")).getText().toUpperCase());
	}
	public static void clicarBotaoFinalizarPedido() {
		Utils.getDriver().findElement(By.xpath("//*[contains(text(), 'Finalizar Pedido')]")).click();
	}
	public static void clicarBotaoNaoDesejaTroco() {		
		Utils.aguardar(3000);
		Utils.getDriver().findElement(By.xpath("//div[@id='modal']/div[@class='display-flex SIM']/div")).click();
	}
	
}
