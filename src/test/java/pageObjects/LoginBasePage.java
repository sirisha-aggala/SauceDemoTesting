package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginBasePage {

   WebDriver driver;

    public LoginBasePage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver, this);


    }



    @FindBy(id="user-name")
    WebElement webEle_Username;

    @FindBy(id="password")
    WebElement webEle_password;


    @FindBy(id="login-button")
    WebElement webEle_loginbutton;

    @FindBy(xpath = "//button[contains(@id,\"to-products\")]")
    public WebElement webEle_backToProducts;




  /*  private By webEle_Username = By.id("user-name");
    private By webEle_password = By.id("password");
    private By webEle_loginbutton = By.id("login-button");
    private By webELe_backToProducts = By.xpath("//button[contains(@id,\"to-products\")]");
   */
    public void getURL(String url) throws InterruptedException {
        driver.get(url);
        driver.manage().window().maximize();
        String title = driver.getTitle();
        System.out.println("title : " + title);
        System.out.println("in getURL method in Login Base Page");
        Thread.sleep(3000);
    }

    public void loginToSauceDemo(String username,String password)
    {
        webEle_Username.sendKeys(username);
        webEle_password.sendKeys(password);


    }


    public void click_on_login() {
        webEle_loginbutton.click();
    }



    public String add_to_cart() throws InterruptedException {

        //find onesie product and click on it
        WebElement sauceonesie= driver.findElement(By.xpath("//*[@id=\"item_2_title_link\"]/div"));
        Actions actions2 = new Actions(driver);
        actions2.scrollToElement(sauceonesie).perform();
        Thread.sleep(3000);
        System.out.println("Before clicking on the onesie product");
        driver.findElement(By.xpath("//*[@id=\"item_2_title_link\"]/div")).click();
        System.out.println("After clicking on the onesie product");
        Thread.sleep(3000);
        //   add to the cart and check if the count on the cart is incremented
        driver.findElement(By.name("add-to-cart")).click();
        String s3 = driver.findElement(By.xpath("//span[contains(@class,'badge')]")).getText();
        System.out.println("String S3: " +s3);
        return s3;
    }

    public void go_back_to_products() {
        webEle_backToProducts.click();
    }
}
