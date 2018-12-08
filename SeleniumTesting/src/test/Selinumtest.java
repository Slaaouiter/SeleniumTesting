package test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.beust.jcommander.internal.Console;

public class Selinumtest {

	public static void main(String[] args) {
	//---------------------Préparation avant-test---------------------------------------------------//
		//Commande pour connecter le driver au programme 
		//Dans mon cas je vais travailler avec le driver du browser GoogleChrome
		System.setProperty("webdriver.chrome.driver","drivers/chromedriver_win32/chromedriver.exe");
		//
		WebDriver driver= new ChromeDriver();
		//Ouvrir la page de facebook
		driver.get("http://www.facebook.com/");
		//Maximiser l'ecran 
		driver.manage().window().maximize();
	//-----------------------------------------------------------------------------------------------//
	//--------------------Testing--------------------------------------------------------------------//
		//Test 0 Verification de la disponibilité des champs nécessaire a la connection 
			//Email or Phone
			System.out.println("Emaile/Phone field is enabled :"+driver.findElement(By.id("email")).isEnabled());
			//Password
			System.out.println("Emaile/Phone field is enabled :"+driver.findElement(By.id("pass")).isEnabled());
			//Log In button
			System.out.println("Emaile/Phone field is enabled :"+driver.findElement(By.id("loginbutton")).isEnabled());
		//Test1 Verification de la validité du lien hypertext 
			driver.findElement(By.xpath("//*[@id=\"login_form\"]/table/tbody/tr[3]/td[2]/div/a")).click();
			if(driver.getCurrentUrl().contains("https://www.facebook.com/login/identify?")){
				System.out.println("forgotten account href is working ");
			}
			else
				System.out.println("forgotten account href is not working ");
			//revenire en arriérre 
			driver.navigate().back();
		
		//Test 2 Verifier si l'élement password est masqué 
			if(driver.findElement(By.id("pass")).getAttribute("data-testid").equals("royal_pass")){
				System.out.println("le champ de mot de passe est masqué ");
			}
			else
				System.out.println("le champ de mot de passe n'est pas masqué");
		//Test 3  verification de l'authentification avec des données erronées
			driver.findElement(By.id("email")).sendKeys("test@gmail.com");
			driver.findElement(By.id("pass")).sendKeys("test");
			driver.findElement(By.id("loginbutton")).click();
			if(driver.getCurrentUrl().contains("https://www.facebook.com/login/device-based/")){
				System.out.println("Verification de la validité des inputs : réussite  ");
			}
			else
				System.out.println("non vérification des inputs valide ");
			//revenire en arriérre 
			driver.navigate().back();
			driver.navigate().refresh();
		//Test 4 Verifier que le champ email/phone ne doit pas rester vide 
			driver.findElement(By.id("pass")).sendKeys("test");
			driver.findElement(By.id("loginbutton")).click();
			if(driver.getCurrentUrl().contains("https://www.facebook.com/login/device-based/")){
				System.out.println("Verification du champ email/phone non vide : réussite ");
			}
			else
				System.out.println("non vérification du champ email/phone non vide ");
			//revenire en arriérre 
			driver.navigate().back();
			driver.navigate().refresh();
		//Test 5 Verifier que le champ password ne doit pas rester vide 
			driver.findElement(By.id("email")).sendKeys("test@test.com");
			driver.findElement(By.id("loginbutton")).click();
			if(driver.getCurrentUrl().contains("https://www.facebook.com/login/device-based/")){
				System.out.println("Verification du champ password non vide : réussite ");
			}
			else
				System.out.println("non vérification du champ password non vide ");
			//revenire en arriérre 
			driver.navigate().back();
			driver.navigate().refresh();
			//Test 6 Verifier que le champ password et phone/email ne doivent pas etre vide 
			driver.findElement(By.id("loginbutton")).click();
			if(driver.getCurrentUrl().contains("https://www.facebook.com/login/device-based/")){
				System.out.println("Verification du champ phone/email et password non vide :réussite ");
			}
			else
				System.out.println("non vérification du champ email/phone et password non vide ");
			//revenire en arriérre 
			driver.navigate().back();
			driver.navigate().refresh();
		//Test 7 verification de l'authentification réussite :
			//Remplissage par des informations valables
			driver.findElement(By.id("email")).sendKeys("pca.pfetesting@gmail.com");
			driver.findElement(By.id("pass")).sendKeys("pcatesting538");
			//Recherche du button & submit
			driver.findElement(By.id("loginbutton")).click();
			if(!driver.getCurrentUrl().contains("https://www.facebook.com/login/device-based/")){
				System.out.println("Verification de l'authentification  réussite : réussite");
			}
			else
				System.out.println("non vérification de l'authentification réussite ");
			
			//the end 
			driver.close();
			//Merci pour votre attention ! cordialement Oualid Slaaouiter

	//----------------------------------------------------------------------------------------------------//
	}
	
}
