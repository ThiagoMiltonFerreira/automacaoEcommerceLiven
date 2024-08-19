package LivenEcommercePage;

import org.junit.Assert;
import org.openqa.selenium.By;
import Utils.Utils;

public class ListaDeProdutosPage {
	public static void validaAcessoLoja(String nomeDaLoja){
		//Pesquisar pelo titulo, validar nome da loja
		
		String xpatchTitle = "//*[@class='header-color']/header/div[@class='v-toolbar__content']/div[@class='v-toolbar__title']";
		
        Utils.aguardarExibicaoComponente(xpatchTitle, 10); 
        String nomeDalojaChrome = Utils.getDriver().findElement(By.xpath(xpatchTitle)).getText();
		
		Assert.assertEquals(nomeDaLoja, nomeDalojaChrome);
		
	}
	public static void adicionaProdutoSemExtraAoCarrinho() {
		try {
			Utils.getDriver().findElement(By.xpath("//p[contains(text(), 'sem extra')][1]/../..//*[contains(text(), 'Adicionar')][1]")).click();
		} catch (Exception e) {
			 System.out.println("1 - NAO FOI POSSIVEL CLICAR NO BOTAO ADICIONAR \n2 - VERIFICAR EXISTENCIA DE PRODUTO COM NOME 'produto sem extra' NO CARDAPIO: " + e.getMessage());
			 throw new RuntimeException("1 - NAO FOI POSSIVEL CLICAR NO BOTAO ADICIONAR 2 - VERIFICAR EXISTENCIA DE PRODUTO COM NOME 'produto sem extra' NO CARDAPIO");
		}
	}
	public static void procurarContadorDeProdutoNoBtnAdcionar() {
		try {
			Utils.getDriver().findElement(By.xpath("//p[contains(text(), 'sem extra')][1]/../..//*[contains(text(), 'Adicionar')][1]/../span[2]"));	
		} catch (Exception e) {
			 System.out.println("CONTADOR NO BOTAO ADICIONAR NAO ENCONTRADO,  POSSIVELMENTE O PRODUTO NAO FOI ADICIONADO AO CARRINHO: " + e.getMessage());
			 throw new RuntimeException("CONTADOR NO BOTAO ADICIONAR NAO ENCONTRADO:, POSSIVELMENTE O PRODUTO NAO FOI ADICIONADO AO CARRINHO");
		}
	}
	public static void procurarBtnVerProdutos() {
		try {
			Utils.getDriver().findElement(By.xpath("//div[@class='buttonSeeOrds d-flex']"));
		} catch (Exception e) {
			 System.out.println("BOTÃO VER PRODUTOS NAO ENCONTRADO,  POSSIVELMENTE NAO HA PRODUTO ADICIONADO AO CARRINHO: " + e.getMessage());
			 throw new RuntimeException("BOTÃO VER PRODUTOS NAO ENCONTRADO,  POSSIVELMENTE NAO HA PRODUTO ADICIONADO AO CARRINHO");
		}
	}
	public static void validarValorTotalBtnVerProdutos(double valor) {
		String valorTotal = Utils.getDriver().findElement(By.xpath("//div[@class='buttonSeeOrds d-flex']/button/span[@class='v-btn__content']//span[contains(text(), 'R$')]")).getText();
		valorTotal = valorTotal.replace("R$", "").trim();
		valorTotal = valorTotal.replace(",", ".").trim();
		Double valorTotalFomatado = Double.parseDouble(valorTotal);
		if (valorTotalFomatado!=valor) {
			System.out.println("VALOR TOTAL INFORMADO DIFERENTE DO VALOR TOTAL PRESENTE NO BOTÃO VER PRODUTOS");
			throw new RuntimeException("VALOR TOTAL INFORMADO DIFERENTE DO VALOR TOTAL PRESENTE NO BOTÃO VER PRODUTOS");
		}else {
			Assert.assertTrue(true);
		}
	}
	public static void clicarBtnVerProdutos() {
		try {
			Utils.getDriver().findElement(By.xpath("//div[@class='buttonSeeOrds d-flex']/button")).click();
		} catch (Exception e) {
			 System.out.println("1 - NAO FOI POSSIVEL CLICAR NO BOTAO VER PRODUTOS \n2 - VERIFICAR VERIFICAR SE HA PRODUTO ADICIONADO AO CARRINHO: " + e.getMessage());
			 throw new RuntimeException("1 -  NAO FOI POSSIVEL CLICAR NO BOTAO VER PRODUTOS \\n2 - VERIFICAR VERIFICAR SE HA PRODUTO ADICIONADO AO CARRINHO.");
		}
		
	}
	

	
}
