package automacaoLivenEcommerce;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.slf4j.helpers.Util;

import Base.BaseConfigsDriver;
import LivenEcommercePage.CarrinhoPage;
import LivenEcommercePage.ProdutosPage;
import Utils.Utils;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PontaApontaCompraLivenEcommerce extends BaseConfigsDriver {
	@Test
	public void A_RealizarCompraDeProduto(){
		System.out.println("Teste 01: Compra de produto");
		String valotTotalUnidadeDoProduto = "289.00";
		String qtdUnidadeDoProdutoCarrinho = "1";
		String valorTotalUnidadeDoProdutoCarrinho = "289.00";
		
		ProdutosPage.validaAcessoProdutos();
		ProdutosPage.clicarBtnCarrinho();
		ProdutosPage.clicarBtnMenu();
		ProdutosPage.clicarBtnCarrinhoDoMenu();
		CarrinhoPage.validaAcessoTelaCarrinho();
		CarrinhoPage.validaValorDaUnidadeDoProdutoCardCarrinho(valotTotalUnidadeDoProduto);
		CarrinhoPage.validaQuantidadeDoProdutoCardCarrinho(qtdUnidadeDoProdutoCarrinho);
		CarrinhoPage.validaValorTotalDoProdutoCardCarrinho(valorTotalUnidadeDoProdutoCarrinho);
		CarrinhoPage.clicarBtnFecharPedido();
	}
	@Test
	public void B_AdicionarUnidadesDoProdutoNoCarrinho(){
		System.out.println("Teste 02: Adicionar unidades do produto no carrinho.");
		String valotTotalUnidadeDoProduto = "289.00";
		String qtdUnidadeDoProdutoCarrinho = "3";
		String valorTotalUnidadeDoProdutoCarrinho = "867.00";
		
		ProdutosPage.validaAcessoProdutos();
		ProdutosPage.clicarBtnCarrinho();
		ProdutosPage.clicarBtnMenu();
		ProdutosPage.clicarBtnCarrinhoDoMenu();
		CarrinhoPage.clicarBtnMaisPrimeiroProdutoDoCarrinho();
		System.out.println("Adicionado produto ao carrinho.");
		Utils.aguardar(1000);
		CarrinhoPage.validaValorDaUnidadeDoProdutoCardCarrinho(valotTotalUnidadeDoProduto);
		CarrinhoPage.validaQuantidadeDoProdutoCardCarrinho(qtdUnidadeDoProdutoCarrinho);
		CarrinhoPage.validaValorTotalDoProdutoCardCarrinho(valorTotalUnidadeDoProdutoCarrinho);
		CarrinhoPage.clicarBtnFecharPedido();
	}

	@Test
	public void C_RemoverUnidadesDoProdutoNoCarrinho(){
		System.out.println("Teste 03: Adicionar unidades do produto no carrinho.");
		String valotTotalUnidadeDoProduto = "289.00";
		String qtdUnidadeDoProdutoCarrinho = "5";
		String valorTotalUnidadeDoProdutoCarrinho = "1445.00";
		
		ProdutosPage.validaAcessoProdutos();
		ProdutosPage.clicarBtnCarrinho();
		ProdutosPage.clicarBtnMenu();
		ProdutosPage.clicarBtnCarrinhoDoMenu();
		CarrinhoPage.validaValorDaUnidadeDoProdutoCardCarrinho(valotTotalUnidadeDoProduto);
		CarrinhoPage.clicarBtnMaisPrimeiroProdutoDoCarrinho();
		CarrinhoPage.clicarBtnMaisPrimeiroProdutoDoCarrinho();
		CarrinhoPage.clicarBtnMenosPrimeiroProdutoDoCarrinho();
		System.out.println("Adicionado mais produtos ao carrinho pela tela carrinho.");
		CarrinhoPage.validaQuantidadeDoProdutoCardCarrinho(qtdUnidadeDoProdutoCarrinho);
		CarrinhoPage.validaValorTotalDoProdutoCardCarrinho(valorTotalUnidadeDoProdutoCarrinho);
		CarrinhoPage.clicarBtnFecharPedido();
	}
	
	@Test
	public void D_RemoverTodasUnidadesDoProdutoNoCarrinho(){
		System.out.println("Teste 04: Remover todas unidades do produto no carrinho.");
		ProdutosPage.validaAcessoProdutos();
		ProdutosPage.clicarBtnCarrinho();
		ProdutosPage.clicarBtnMenu();
		ProdutosPage.clicarBtnCarrinhoDoMenu();
		CarrinhoPage.clicarBtnMenosPrimeiroProdutoDoCarrinho();
		CarrinhoPage.clicarBtnMenosPrimeiroProdutoDoCarrinho();
		CarrinhoPage.clicarBtnMenosPrimeiroProdutoDoCarrinho();
		CarrinhoPage.clicarBtnMenosPrimeiroProdutoDoCarrinho();
		CarrinhoPage.clicarBtnMenosPrimeiroProdutoDoCarrinho();
		CarrinhoPage.clicarBtnMenosPrimeiroProdutoDoCarrinho();
		System.out.println("Removido todos os produtos do carrinho.");
		CarrinhoPage.validarMensagemSemProdutos();
		Utils.getDriver().quit();
	
	}

	
}
