import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SeleniumWebSignupTest {

    //import the selenium WebDriver


    private WebDriver driver;

    @BeforeTest
    public void start() throws InterruptedException {
        //locate where the chrome driver is
        System.setProperty("webDriver.chrome.driver", "resources/chromedriver.exe");
        //STEP 1.open your chrome driver
        driver = new ChromeDriver();
        //STEP 2. input your Selenium Demo Page URL (https://selenium-blog.herokuapp.com)
        driver.get("https://selenium-blog.herokuapp.com");


        //Test 1 Verify the User input the right URL and currently on the right page
        if(driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com"))
            //pass
            System.out.println("Correct Webpage");
        else
            //fail
            System.out.print("Wrong Webpage");
        //wait time for the page to load
        Thread.sleep(5000);


        //STEP 3 maximize the browser
        driver.manage().window().maximize();
        //STEP 4. Click on Signup button to open the SignUp page
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
    }


    //Change UserNames for Every Run

    @Test (priority = 0)
    public void positiveSignup() throws InterruptedException {
        //Test 3. Verify that Username cannot be less than 3 characters
        //Inputting our UserName on the username field
        driver.findElement(By.id("user_username")).sendKeys("adam55");
        //Input Email on email field
        driver.findElement(By.id("user_email")).sendKeys("adam55@mailinator.com");
        //Input Password
        driver.findElement(By.id("user_password")).sendKeys("passkey");
        //Click on the signup Button
        driver.findElement(By.id("submit")).click();

        String loginPage = "https://selenium-blog.herokuapp.com/signup";
        if(driver.getCurrentUrl().contains("https://selenium-blog.herokuapp.com/signup"))
            //pass
            System.out.println("Correct Loginpage");
        else
            //fail
            System.out.print("Wrong Loginpage");
        Thread.sleep(5000);
    }

    //Test 2 Verify that User clicks on Signup Button
    @Test (priority = 1)
    public void clickUser1Item() throws InterruptedException {

        // Click on the  item user1
        driver.findElement(By.xpath("/html/body/div[2]/div[1]/ul/div/div/li[1]/a")).click();
        //Test 2 Verify that User clicks on Signup Button
        String expectedUrl = "https://selenium-blog.herokuapp.com/signup";
        String actualUrl = driver.getCurrentUrl();
                if(actualUrl.contains(expectedUrl))
                    //pass
                    System.out.println("User1 Item Verified");
                else
                    //fail
                    System.out.print("User1 Item Not Verified");

        Thread.sleep(5000);
    }

    // Test 8 Verify that User1 Item is present on the list page
    @Test (priority = 2)
    public void verifyItem() throws InterruptedException {
        //

        String expectedPageUrl = "https://selenium-blog.herokuapp.com/users.11282";
        String actualPageUrl = driver.getCurrentUrl();
        //Test
        if (actualPageUrl.contains(expectedPageUrl))
            //pass
            System.out.println("Correct ListItemPage");
        else
            //fail
            System.out.print("Wrong ItemListPage");
        Thread.sleep(5000);
    }

    //Test 9 Verify that Item Searched for is present on User 1 Page
    @Test (priority = 3)
    public void verifyUserItem() throws InterruptedException {
        //Find Path
        driver.findElement(By.xpath("/html/body/div[2]/div[35]/div/div/div[1]/a")).click();
        String expectedPageUrl = "/users/1";
        String actualPageUrl = driver.getCurrentUrl();
        if (actualPageUrl.contains(expectedPageUrl))
            //pass
            System.out.println("Correct User1Page");
        else
            //fail
            System.out.print("Wrong User1Page");
        Thread.sleep(5000);
    }


      @Test (priority =4)
    public void logoutSuccesfully(){
        //click logout
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        //Test 10. When User Logout redirected to Home Page
        String expectedTitle ="AlphaBlog";
        String actualTitle = driver.getCurrentUrl();
        if(expectedTitle.contains(actualTitle))
            //pass
            System.out.println("Correct LogoutPage");
        else
            //fail
            System.out.print("Wrong LogoutPage");
    }

    //Test 3. Verify that user cannot SignUp with Username less than 3 characters
    @Test (priority = 5)
    public void negativeSignup() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/div/a[2]")).click();
        Thread.sleep(5000);
        //Test 3. Verify that Username cannot be less than 3 characters
        //Inputting our UserName on the username field
        driver.findElement(By.id("user_username")).sendKeys("hh");
        //Input Email on email field
        driver.findElement(By.id("user_email")).sendKeys("goal@mailinator.com");
        //Input Password
        driver.findElement(By.id("user_password")).sendKeys("happy");
        //Click on the signup Button
        driver.findElement(By.id("submit")).click();


        Thread.sleep(5000);
    }
    //Test 4. User cannot SignUp with Invalid Email Address
    @Test (priority = 6)
    public void invalidEmail_SignUp() throws InterruptedException {
        //Test 3. Verify that Username cannot be less than 3 characters
        //Inputting our UserName on the username field
        driver.findElement(By.id("user_username")).sendKeys("amos866");
        //Input Email on email field
        driver.findElement(By.id("user_email")).sendKeys("james666mailinator.com");
        //Input Password
        driver.findElement(By.id("user_password")).sendKeys("passkey");
        //Click on the signup Button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }

    //Test 10 Verify that when the User Logout, he/she is directed back to the Homepage
    @Test (priority = 7)
    public void logoutSuccesfully1(){
        //click logout
        driver.findElement(By.xpath("//*[@id=\"bs-example-navbar-collapse-1\"]/ul/li[3]/a")).click();
        //Test 10. When User Logout redirected to Home Page
        String expectedTitle ="AlphaBlog";
        String actualTitle = driver.getCurrentUrl();
        if(expectedTitle.contains(actualTitle))
            //pass
            System.out.println("Correct User1Page");
        else
            //fail
            System.out.print("Wrong Webpage");
    }

    //Test. 5 Verify User cannot login with password less than or equal to one character
    @Test (priority = 8)
    public void negativeSignIn() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/div[2]/div/a[1]")).click();
        Thread.sleep(5000);
        //Test 5. Verify that User cannot login with password less than or equal to one character
        //Inputting our UserName on the username field
        driver.findElement(By.id("session_email")).sendKeys("bless08@mailinator.com");
        //Input Email on email field
        driver.findElement(By.id("session_password")).sendKeys("o");
        //Click on the signIn Button
        driver.findElement(By.xpath("/html/body/div[2]/form/div[3]/div/input")).click();
        Thread.sleep(5000);
    }


    //Test 6 Verify Username cannot signUp with Blank fields
    @Test (priority = 9)
    public void negative_BlankSignup() throws InterruptedException {
        driver.findElement(By.xpath("/html/body/nav/div/div[2]/ul/li[2]/a")).click();
        Thread.sleep(5000);
        //Test 3. Verify that Username cannot be less than 3 characters
        //Inputting our UserName on the username field
        driver.findElement(By.id("user_username")).sendKeys("");
        //Input Email on email field
        driver.findElement(By.id("user_email")).sendKeys("");
        //Input Password
        driver.findElement(By.id("user_password")).sendKeys("");
        //Click on the signup Button
        driver.findElement(By.id("submit")).click();
        Thread.sleep(5000);
    }
        @AfterTest
        public void closeBrowser(){
        //Quit the browser
        driver.quit();

    }

}
