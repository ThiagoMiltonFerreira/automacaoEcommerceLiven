package Utils;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
	
	private static WebDriver driver;
	public static WebDriver getDriver() {
		// Se ja existir uma instancia de driver retorna ela, se nao cria uma nova
		if(driver == null) {
			driver = new ChromeDriver(configsChorme());
			return driver;
		}else {
			return driver;
		}
		
	}
	
	public static void matarDriver(){
		//Finaliza o driver atual
		if(driver != null) {
			driver.quit();
		}
			
			
	}
	
	public static WebElement aguardarExibicaoComponente(String xpath, int i) {
		Duration timeout = Duration.ofSeconds(i);
	    WebDriverWait wait = new WebDriverWait(driver, timeout);
	    By seletor = By.xpath(xpath);
	    WebElement elemento = wait.until(ExpectedConditions.visibilityOfElementLocated(seletor));
		return elemento;
	}
	
	public static WebElement aguardarElementoClicavel(String xpath, int i) {
		Duration timeout = Duration.ofSeconds(i);
	    WebDriverWait wait = new WebDriverWait(driver, timeout);
	    By seletor = By.xpath(xpath);
	    WebElement elemento = wait.until(ExpectedConditions.elementToBeClickable(seletor));
		return elemento;
	}
	
	public static ChromeOptions configsChorme() {
		// Deve limar o cache do navegador
	    ChromeOptions chromeOptions = new ChromeOptions();
	    chromeOptions.addArguments("--disable-application-cache");
	    chromeOptions.addArguments("--incognito");
	    chromeOptions.addArguments("--disable-extensions"); //Deve desabilitar extençoes do chorme 
	    chromeOptions.addArguments("--start-maximized");  // Abrir o navegador maximizado
	    
        // Configurar as opções do Chrome para emular um dispositivo móvel
        Map<String, Object> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPhone 12 Pro");	    
	    chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation); 

	    return chromeOptions;
	}
	public static void aguardar(int tempo) {
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	public static String DataEhoraAtual() {
        LocalDateTime dataHoraAtual = LocalDateTime.now(); 
        // Define o formato desejado para o padrão brasileiro
        DateTimeFormatter formatoBrasileiro = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");

        // Formata a data e hora conforme o padrão brasileiro
        String dataHoraFormatada = dataHoraAtual.format(formatoBrasileiro);
        return dataHoraFormatada;
	}
	public static void RolarParaFimDaTela() {
		// Rolar para baixo usando JavascriptExecutor
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Utils.aguardar(3000);
	}
}
