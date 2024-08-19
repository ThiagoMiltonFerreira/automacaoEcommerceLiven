package LivenEcommercePage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import Utils.Utils;

public class PaymentMethodPage {
	public static void validaAcessoTelaPaymentMethod() {
		Utils.aguardarExibicaoComponente("//*[@class='v-toolbar__title']", 20);		
	}
	public static void selecionarPagamentoNaEntrega() {
		try {
			Utils.getDriver().findElement(By.xpath("//div[@class='v-slide-group__content v-tabs-bar__content']//*[contains(text(), 'Pagamento na entrega')]")).click();
		} catch (Exception e) {
			System.out.println("NAO FOI POSSIVEL CLICAR NO TIPO DE PAGAMENTO NA TELA PAYMENTMETHOD: " + e.getMessage());
			throw new RuntimeException("NAO FOI POSSIVEL CLICAR NO TIPO DE PAGAMENTO NA TELA PAYMENTMETHOD.");
		}
	}
	public static void selecionarPagamentoDinheiro() {
		WebElement elemento = Utils.aguardarExibicaoComponente("//*[contains(text(), 'Dinheiro')]", 10);
		if(elemento != null) {
			try {
				Utils.getDriver().findElement(By.xpath("//*[contains(text(), 'Dinheiro')]")).click();
			} catch (Exception e) {
				System.out.println("NAO FOI POSSIVEL CLICAR NO TIPO DE PAGAMENTO DINHEIRO NA TELA PAYMENTMETHOD: " + e.getMessage());
				throw new RuntimeException("NAO FOI POSSIVEL CLICAR NO TIPO DE PAGAMENTO DINHEIRO NA TELA PAYMENTMETHOD.");
			}
		}
	}
}
