package com.khangsinh2853e.e2e;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

class HerokuLoginTest {

    public static WebDriver myBrowser;




    @Test
    //KHI TRONG CODE TEST RUN CỦA MÌNH CÓ HOẠT ĐỘNG CHUYỂN SANG TRANG KHÁC
    //THÌ K NÊN TÌM ELEMENT/TAG Ở TRANG MỚI NGAY, CHO ĐẾN KHI TRANG MỚI ĐÃ TẢI XONG
    //PHẢI NHỚ, CỰC KÌ QUAN TRỌNG TRONG CODE AUTOMATION: WAIT, LỆNH CHỜ TRANG TẢI XONG
    public void testHerokuLoginGivenValidAdminAcountRunsWellWait(){
        //steps 2:
        myBrowser.get("https://the-internet.herokuapp.com/login");
        //CÓ THỂ BỊ LAG KHI LẦN ĐẦU TẢI TRANG LOGIN, CẦN WAIT tối đa 10 giây
        //nếu trang tải xong sớm trước 10 giây thì cứ đi tiếp
        WebDriverWait wait = new WebDriverWait(myBrowser, Duration.ofSeconds(10));

        //steps 3:
        //đi bắt cái ô nhập username về đây để chuẩn bị đưa tomsmiths vào
        //mỗi tag trong trang web được xem là 1 object thuộc về class WebElement
        //bắt 1 tag trong trang web thì khai báo biến hứng nó, thì biến này phải thuộc về WebElement

//        WebElement username = myBrowser.findElement(By.id("username"));
//        WebElement password = myBrowser.findElement(By.id("password"));

        //chờ tối đa 10 giây để thấy ô nhập username xuất hiện, cho phép nhập, clickable - có thể click vào để nhập; hoặc k xuất hiện do mạng lag
        WebElement username = wait.until(ExpectedConditions.elementToBeClickable(By.id("username")));

        WebElement password = myBrowser.findElement(By.id("password"));

        //        WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.id("password")));

        //những lệnh tìm tag sau thằng đầu tiên có thể k cần wait do 2 ô nhập + nút bấm cùng form
        //tải thẻ form và thằng ô nhập đầu tiên được rồi, chắc chắn mấy thằng tag còn lại trong form okie

        //nhập dữ liệu vào 2 ô
        username.sendKeys("tomsmith"); //giả hành động gõ của con người
        password.sendKeys("SuperSecretPassword!");

        //steps 4:
        WebElement loginButton = myBrowser.findElement(By.cssSelector("#login > button"));
        loginButton.click();

        //SO SÁNH KẾT QUẢ TRẢ VỀ SAU LOGIN CÓ ĐÚNG KÌ VỌNG HAY K
        //TA PHẢI ĐI BẮT CÁI Ô FLASH MESSAGE

        //TRANG SAU LOGIN ĐƯỢC TẢI VỀ, ĐỪNG TÌM TAG MESSAGE NGAY, VÌ CHỜ CHUYỂN TRANG, NÊN WAIT 1 CÁI


//        WebElement flashMessageTag = myBrowser.findElement(By.cssSelector("#content > div > h2"));
        WebElement flashMessageTag = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#content > div > h2")));

        String flashMessage = flashMessageTag.getText(); //lấy dòng text có trong tag
        //<h1>Xin chào Selenium</h>                            <------ biến flash
        //h1 gọi là tag, WebElement
        //Xin chào Selenium -> gọi là text của tag             <------ flashMessageTag.getText()

        //JUnit nhảy vào, so sánh hoy
        assertEquals("Secure Area", flashMessage);
        System.out.println("Message sau login nè (nếu thành công): " + flashMessage);
    }




    //@Test
    //test case #1: test the heroku login page with a valid account
    //              data: a valid account, e.g: tomsmith/SuperSecretPassword!
    //              steps: 1. Open a certain browser
    //                     2. Type the following url: https://the-internet.herokuapp.com/login
    //                     3. Type a valid account into username & password textboxes
    //                          e.g: tomsmith/SuperSecretPassword!
    //                     4. Hit login button

    //              Expected result:
    //                  The welcome/main menu/dashboard is displayed with a noti message/flash message
    //                  "Secure Area"

    //              Status: passed hay failed tùy màn hình sau login có ra chữ Secure Area
    //              Nhờ JUNIT giúp xanh đỏ, muốn có xanh đỏ thì phải có expected == actual?
    //                                                                  có rồi              chờ trang web sau login
    //                                                                  Secure Area         hiện ra!!!!!




//    public void testHerokuLoginGivenValidAdminAcountRunsWell(){
//        //steps 2:
//        myBrowser.get("https://the-internet.herokuapp.com/login");
//
//        //steps 3:
//        //đi bắt cái ô nhập username về đây để chuẩn bị đưa tomsmiths vào
//        //mỗi tag trong trang web được xem là 1 object thuộc về class WebElement
//        //bắt 1 tag trong trang web thì khai báo biến hứng nó, thì biến này phải thuộc về WebElement
//        WebElement username = myBrowser.findElement(By.id("username"));
//        WebElement password = myBrowser.findElement(By.id("password"));
//
//        //nhập dữ liệu vào 2 ô
//        username.sendKeys("tomsmith"); //giả hành động gõ của con người
//        password.sendKeys("SuperSecretPassword!");
//
//        //steps 4:
//        WebElement loginButton = myBrowser.findElement(By.cssSelector("#login > button"));
//        loginButton.click();
//
//        //SO SÁNH KẾT QUẢ TRẢ VỀ SAU LOGIN CÓ ĐÚNG KÌ VỌNG HAY K
//        //TA PHẢI ĐI BẮT CÁI Ô FLASH MESSAGE
//        WebElement flashMessageTag = myBrowser.findElement(By.cssSelector("#content > div > h2"));
//        String flashMessage = flashMessageTag.getText(); //lấy dòng text có trong tag
//        //<h1>Xin chào Selenium</h>                            <------ biến flash
//        //h1 gọi là tag, WebElement
//        //Xin chào Selenium -> gọi là text của tag             <------ flashMessageTag.getText()
//
//        //JUnit nhảy vào, so sánh hoy
//        assertEquals(flashMessage, "Secure Area");
//        System.out.println("Message sau login nè (nếu thành công): " + flashMessage);
//    }




    @BeforeAll        //hàm nào có @BeforeAll, chỉ có 1 hàm có từ khóa này
    //thì hàm này được chạy trước tất cả các hàm @Test khác
    //mỗi @Test là 1 test case (bộ data, steps, expected result, actual result, status)
    //thì @BeforeAll chạy 1 lần duy nhất, trước tất cả các test case khác
    //để làm gì? khởi động các biến, các bộ data dùng chung cho mọi test case
    static void beforeAll() {

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless=true");

        myBrowser = new ChromeDriver(chromeOptions);
        //BUNG RỘNG FULL MÀN HÌNH
        myBrowser.manage().window().maximize();
    }




    @AfterAll
    //sau khi tất cả cc test case đã chạy xong, thì hàm @AfterAll sẽ đuợc chạy
    //2 hàm này k quan tâm vị trí nó ở đâu trong test class, ở đâu cũng được, thứ tự thực thi của nó sẽ theo @ hơn là theo thứ tự viết code
    //hàm này dọn dẹp các biến, restore database nếu cần vì các test case làm db bị rác
    //k để lại rác sau quá trình kiểm thử, do server kiểm thử được sài cho nhiều lần test
    static void afterAll() throws InterruptedException {
        Thread.sleep(5000);
        myBrowser.quit();
    }
}