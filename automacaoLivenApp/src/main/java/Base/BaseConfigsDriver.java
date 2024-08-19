package Base;

import java.time.Duration;
import org.junit.After;
import org.junit.Before;
import Utils.Utils;

public class BaseConfigsDriver {
	
	private String linkDaLoja = "https://liven-store-prd.web.app";
	private String webDriverChorme = "webdriver.chrome.driver";
	private String caminhoWebDriver = System.getProperty("user.dir")+"\\src\\main\\resources\\Drivers\\chromedriver.exe";
	
	@Before
	public void configsDriver() {
		// Espera por elemento qualquer elemento na pagina ate 10 segundos para dar timeout enquanto a instancia do chorme estiver aberta
		Utils.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		System.setProperty(webDriverChorme,caminhoWebDriver);	
		Utils.getDriver().get(linkDaLoja);		
	}
	
	@After
	public void matarDriver() {
		//A cada teste finaliza o driver com quit entao setar o valor do driver para null
		//Utils.getDriver().close();
		//Utils.matarDriver();
	}

}
