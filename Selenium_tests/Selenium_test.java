import java.util.Scanner;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

public class Selenium_test {
    public static void main(String[] args) throws InterruptedException {
    	String proxyAdress = "127.0.0.1:8080"; //proxy options. Optional. If used like this, it wont open any site
    	Proxy proxy = new Proxy(); //create proxy
    	proxy.setHttpProxy(proxyAdress);
    	proxy.setSslProxy(proxyAdress);
        // Set the path to the Microsoft Edge WebDriver executable
        System.setProperty("webdriver.edge.driver", "C:\\Users\\Administrator\\Documents\\java_libs\\msedgedriver.exe"); //path to drive
        // Create an instance of EdgeDriver
        EdgeOptions options = new EdgeOptions(); //create EdgeOptions obj
        options.setCapability("proxy", proxy); //add proxy to Edge options
        WebDriver driver = new EdgeDriver(options); //add options to driver
        // Navigate to the given url
        Scanner scan = new Scanner(System.in); 
        while(true) {
        	System.out.println("enter the desired url: "); //gets url
	        String url = scan.nextLine();
	        driver.get(url); //get site
	        try {
	        	Thread.sleep(4000); //wait site to load. Sleep for 4 seconds
	        } catch(InterruptedException e ) {
	        	e.printStackTrace();
	        }
	        String source = driver.getPageSource(); //gets page source
	        System.out.println(source); //print source
	        System.out.println(driver.getTitle()); //print site name
	        System.out.println(driver.getCurrentUrl()); //prints current url
	        // Wait for a few seconds (optional)
	        try {
	            Thread.sleep(5000); // Sleep for 5 seconds
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	        // Close the browser
	        driver.quit();
        }
    }
}
