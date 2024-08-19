package LivenEcommercePage;

import org.openqa.selenium.By;

import Utils.Utils;

public class LoginPage {
	public static void escreverCpf(String cpf) {
		try {
			Utils.getDriver().findElement(By.xpath("//input[@id='userInput']")).sendKeys(cpf);
		} catch (Exception e) {
			 System.out.println("NÃO FOI POSSIVEL ESCREVER O CPF NO MODAL DE LOGIN " + e.getMessage());
			 throw new RuntimeException("NÃO FOI POSSIVEL ESCREVER O CPF NO MODAL DE LOGIN");
		}			
	}
	public static void escreverSenha(String senha) {
		try {
			Utils.getDriver().findElement(By.xpath("//input[@id='passwordInput']")).sendKeys(senha);
		} catch (Exception e) {
			System.out.println("NÃO FOI POSSIVEL ESCREVER A SENHA NO MODAL DE LOGIN " + e.getMessage());
			throw new RuntimeException("NÃO FOI POSSIVEL ESCREVER A SENHA NO MODAL DE LOGIN");
		}	
	}
	public static void clicarBotaoLogar() {
		Utils.aguardar(2000);
		try {
			Utils.getDriver().findElement(By.xpath("//div[@id='login-button']//*[contains(text(), 'LOGAR')]")).click();
		} catch (Exception e) {
			 System.out.println("NÃO FOI POSSIVEL CLICAR NO BOTÃO LOGAR NA TELA DE LOGIN " + e.getMessage());
			 throw new RuntimeException("NÃO FOI POSSIVEL CLICAR NO BOTÃO LOGAR NA TELA DE LOGIN");
		}			
	}
	
}
