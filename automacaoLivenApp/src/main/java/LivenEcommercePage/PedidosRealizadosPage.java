package LivenEcommercePage;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Base.Propriedades;
import Utils.Utils;


public class PedidosRealizadosPage {
	public static void validaAcessoTelaPedidosRealizados(){
		try {
			
			WebElement elemento = Utils.aguardarExibicaoComponente("//div[@class='v-toolbar__title'][contains(text(), 'Pedidos')]", 10);
			if(elemento instanceof WebElement)
				Assert.assertEquals(Propriedades.getUrl()+"PedidosRealizados",Utils.getDriver().getCurrentUrl());
			
		} catch (Exception e) {
			
			System.out.println("NAO FOI POSSIVEL VALIDAR ACESSO A PAGINA PEDIDOS REALIZADOS, NAO FOI POSSIVEL VALIDAR UM ELEMENTO UNICO NA TELA OU SUA URL: " + e.getMessage());
			throw new RuntimeException("NAO FOI POSSIVEL VALIDAR ACESSO A PAGINA PEDIDOS REALIZADOS, NAO FOI POSSIVEL VALIDAR UM ELEMENTO UNICO NA TELA OU SUA URL");
			
		}
	}
	public static void validaMensagemPedidoRealizadoSucesso(){
		try {			
			
			Utils.aguardarExibicaoComponente("//div[@class='Vue-Toastification__toast-body'][contains(text(), 'Pedido Realizado com sucesso')]", 5);
		
		} catch (Exception e) {
			
			System.out.println("NAO FOI POSSIVEL VALIDAR EXIBIÇÃO DA MENSAGEM DE SUCESSO NA TELA PEDIDO REALIZADOS" + e.getMessage());
			throw new RuntimeException("NAO FOI POSSIVEL VALIDAR EXIBIÇÃO DA MENSAGEM DE SUCESSO NA TELA PEDIDO REALIZADOS");
			
		}
	}
	public static void validarDataDoPedidoCardNovoPedido(){
		//Utils.getDriver().findElement(By.xpath("//*[@class='row orders-container waves-effect my-2'][1]//*[@class='title-header']/span[contains(text(), 'Novo Pedido')]"));
		String dataEhoraTela= Utils.getDriver().findElement(By.xpath("//*[@class='row orders-container waves-effect my-2'][1]//div[@class='order-item'][2]")).getText().replaceAll("[\r\n]+", " ");
		String horaAtual = Utils.DataEhoraAtual();
		
		if(dataEhoraTela.equals(horaAtual)) {
			assertTrue(true);
		} else {
			throw new RuntimeException("DATA OU HORA DO PRIMEIRO CARD DE PEDIDO NA TELA PEDIDO REALIZADO DIFERENTES DA DATA ATUAL. /n" + "Hora tela: " + dataEhoraTela + "Hora atual: " + horaAtual);
		}			
	}
	public static void validarNomeNomeDoProdutoCardNovoPedido(String nomeDoProduto) {
		
		assertEquals(nomeDoProduto, Utils.getDriver().findElement(By.xpath("//*[@class='row orders-container waves-effect my-2'][1]//div[@class='order-item'][3]//*[@class='meio pedido']")).getText());
	
	}
	public static void validaQuantidadeDoProdutoCardNovoPedido(String qtdProduto) {
		
		assertEquals(qtdProduto + "x", Utils.getDriver().findElement(By.xpath("//*[@class='row orders-container waves-effect my-2'][1]//div[@class='order-item'][3]//*[@class='esquerda']")).getText() );
	
	}
	public static void validaStatusDoPedidoCardNovoPedido(String statusDoPedido) {
		
		assertEquals(statusDoPedido, Utils.getDriver().findElement(By.xpath("//*[@class='row orders-container waves-effect my-2'][1]/div/div[5]//span[contains(text(), '"+statusDoPedido+"')]")).getText() );
	
	}
	public static void validaValorTotalDoPedidoCardNovoPedido(String valorTotalDaCompra) {
		//*[@class='row orders-container waves-effect my-2'][1]//span[contains(text(), '"+valorTotalDaCompra+"')]
		
		assertEquals("R$ "+valorTotalDaCompra, Utils.getDriver().findElement(By.xpath("//*[@class='row orders-container waves-effect my-2'][1]//span[contains(text(), '"+valorTotalDaCompra+"')]")).getText());
		
	}
	public static void validarPedidoIntegradoStatusDoPedidoCardNovoPedido(String statusDoPedido) {
		
		//Utils.aguardar(3);
		validaStatusDoPedidoCardNovoPedido(statusDoPedido);
	
	}
	
	
}
