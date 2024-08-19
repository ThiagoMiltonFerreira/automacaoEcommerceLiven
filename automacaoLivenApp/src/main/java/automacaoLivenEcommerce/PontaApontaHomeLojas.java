package automacaoLivenEcommerce;

import org.junit.Test;
import Base.BaseConfigsDriver;
import Utils.Utils;
import LivenEcommercePage.*;

public class PontaApontaHomeLojas extends BaseConfigsDriver {
	// Classe para testes
	    
		@Test
		public void CompraOrganizacaoMaisDeUmaLojaEntregaDinheiro(){
			
			//Dados para login
			String cpf = "361.133.890-73";
			String senha= "428971";
			
			String nomeDaLoja = "Automacao Eattake App";
			int valorTotalBtnProdutos = 10;
			String escreverNoCampoEndereco = "";
			String enderecoDeEntrega = "R. Sergipe, 1014, Savassi";
			String qtdProdAdicionado = "1";
			String nomeDoProdutoSemExtra = "Produto sem extra";
			String totalDaCompra = "10,00";
			String formaDePagamento = "Dinheiro";
						
			HomeLojasPage.validaAcessoHomeLojas();
			HomeLojasPage.clicaNaLoja("//*[@class='card card-store']/div/div[1]");
			
			ListaDeProdutosPage.validaAcessoLoja(nomeDaLoja);
			ListaDeProdutosPage.adicionaProdutoSemExtraAoCarrinho();
			
			//Validações de adição de produto ao carrinho
			ListaDeProdutosPage.procurarContadorDeProdutoNoBtnAdcionar();
			ListaDeProdutosPage.procurarBtnVerProdutos();			
			ListaDeProdutosPage.validarValorTotalBtnVerProdutos(valorTotalBtnProdutos);			
			ListaDeProdutosPage.clicarBtnVerProdutos();
			
			AddAdressPage.validaAcessoAddAdress();
			AddAdressPage.escreverNoCampoEndereco(escreverNoCampoEndereco);			
			AddAdressPage.clicarNoBotaoContinuar();
			
			PedidoPage.validaAcessoTelaPedido();
			PedidoPage.validaEndrecoDeEntrega(enderecoDeEntrega);
			PedidoPage.validaProdutoAdicionados(qtdProdAdicionado,nomeDoProdutoSemExtra);
			PedidoPage.validarValorTotalDaCompra(totalDaCompra);
			PedidoPage.clicarBotaoEscolher();
			
			LoginPage.escreverCpf(cpf);
			LoginPage.escreverSenha(senha);
			LoginPage.clicarBotaoLogar();
			
			PaymentMethodPage.validaAcessoTelaPaymentMethod();
			PaymentMethodPage.selecionarPagamentoNaEntrega();
			PaymentMethodPage.selecionarPagamentoDinheiro();

			PedidoPage.validaAcessoTelaPedido();
			PedidoPage.validarFormaDePagamentoSelecionada(formaDePagamento);
			
			Utils.RolarParaFimDaTela();
			PedidoPage.clicarBotaoFinalizarPedido();
			PedidoPage.clicarBotaoNaoDesejaTroco();
		
			PedidosRealizadosPage.validaAcessoTelaPedidosRealizados();
			PedidosRealizadosPage.validaMensagemPedidoRealizadoSucesso();
			PedidosRealizadosPage.validarDataDoPedidoCardNovoPedido();
			PedidosRealizadosPage.validarNomeNomeDoProdutoCardNovoPedido(nomeDoProdutoSemExtra);
			PedidosRealizadosPage.validaQuantidadeDoProdutoCardNovoPedido(qtdProdAdicionado);
			PedidosRealizadosPage.validaValorTotalDoPedidoCardNovoPedido(totalDaCompra);
			PedidosRealizadosPage.validarPedidoIntegradoStatusDoPedidoCardNovoPedido("Produzindo");
					
		}
}
