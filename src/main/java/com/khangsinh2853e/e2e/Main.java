package com.khangsinh2853e.e2e;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main() throws InterruptedException {
        ChromeOptions opt = new ChromeOptions();
        opt.addArguments("--incognito"); //In private
        opt.addArguments("--lang-en");

        WebDriver myBrowser = new ChromeDriver(opt); //lệnh mở trình duyệt
        myBrowser.get("https://www.google.com");

        Thread.sleep(5000); //ép CPU ngừng 5 giây trước khi chạy lệnh phía dưới
        myBrowser.quit(); //tắt trình duyệt
    }
}
