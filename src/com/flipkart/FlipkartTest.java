package com.flipkart;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.android.AndroidDriver;

public class FlipkartTest {

	private static AndroidDriver driver;

	public static void main(String[] args) throws Exception {

		File classpathRoot = new File(System.getProperty("user.dir"));
		File appDir = new File(classpathRoot, "/apps");
		File app = new File(appDir, "Flipkart_v4.6_apkpure.com.apk");

		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "");
		capabilities.setCapability("deviceName", "TA93309P13");
		capabilities.setCapability("platformVersion", "5.1.1");
		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("apps", app.getAbsolutePath());
		capabilities.setCapability("appPackage", "com.flipkart.android");
		capabilities.setCapability("appActivity", "com.flipkart.android.SplashActivity");

		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		goToLogin(driver);

		// goToLogin(driver);
		checkUIElements();
		// checkSearchWidget();
		addToCart();
		checkSearch();
		teardown();

	}

	public static void goToLogin(AndroidDriver driver) throws FileNotFoundException, InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.flipkart.android:id/overflowIcon")));
		driver.findElement(By.id("com.flipkart.android:id/overflowIcon")).click();
		driver.findElement(By.id("com.flipkart.android:id/menu_dropdown_list_item_text_id")).click();

		Scanner scan = new Scanner(new File("input.txt"));
		while (scan.hasNextLine()) {
			wait.until(ExpectedConditions
					.visibilityOfElementLocated(By.id("com.flipkart.android:id/mobile_login_signup_edit_text")));
			driver.findElement(By.id("com.flipkart.android:id/mobile_login_signup_edit_text")).click();
			driver.findElement(By.id("com.flipkart.android:id/mobile_login_signup_edit_text")).clear();
			driver.findElement(By.id("com.flipkart.android:id/mobile_login_signup_edit_text"))
					.sendKeys(scan.nextLine());
			driver.findElement(By.id("com.flipkart.android:id/etPass")).click();
			driver.findElement(By.id("com.flipkart.android:id/etPass")).clear();
			driver.findElement(By.id("com.flipkart.android:id/etPass")).sendKeys("asd-123");
			driver.findElement(By.id("com.flipkart.android:id/btn_mlogin")).click();
			Thread.sleep(3000);
		}

		// driver.findElement(By.id("com.flipkart.android:id/mobile_login_signup_edit_text")).clear();
		// driver.findElement(By.id("com.flipkart.android:id/mobile_login_signup_edit_text"))
		// .sendKeys("anshuman.tripathi305@gmail.com");
		// driver.findElement(By.id("com.flipkart.android:id/etPass")).click();
		// driver.findElement(By.id("com.flipkart.android:id/etPass")).clear();
		// // Thread.sleep(1000);
		// driver.findElement(By.id("com.flipkart.android:id/etPass")).sendKeys("asd-123");
		// driver.findElement(By.id("com.flipkart.android:id/btn_mlogin")).click();
		// Thread.sleep(3000);

		// String input[] =
		// {"abish","brother","chaitanya","_id","anshuman.tripathi305@gmail.com"};
		//
		// for(int i=0;i<input.length;i++){
		// Thread.sleep(1000);
		// driver.findElement(By.id("com.flipkart.android:id/mobile_login_signup_edit_text")).clear();
		// driver.findElement(By.id("com.flipkart.android:id/mobile_login_signup_edit_text")).sendKeys(input[i]);
		// Thread.sleep(1000);
		// driver.findElement(By.id("com.flipkart.android:id/etPass")).clear();
		// // Thread.sleep(1000);
		// driver.findElement(By.id("com.flipkart.android:id/etPass")).sendKeys("asd-123");
		// driver.findElement(By.id("com.flipkart.android:id/btn_mlogin")).click();
		// Thread.sleep(3000);
		// }
	}

	public static void checkSearch() {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("com.flipkart.android:id/search_widget_textbox")));
		driver.findElement(By.id("com.flipkart.android:id/search_widget_textbox")).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("com.flipkart.android:id/search_autoCompleteTextView")));
		driver.findElement(By.id("com.flipkart.android:id/search_autoCompleteTextView")).sendKeys("samsung");
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id("com.flipkart.android:id/incorrect_login_text")));
		driver.findElement(By.id("com.flipkart.android:id/incorrect_login_text")).click();
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id("com.flipkart.android:id/product_list_product_item_layout")));
		driver.findElement(By.className("android.widget.ImageButton")).click();
		driver.findElement(By.className("android.widget.ImageButton")).click();

	}

	public static void addToCart() throws Exception {
		WebDriverWait wait = new WebDriverWait(driver, 100);
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("Deny")));
		// driver.findElement(By.name("Deny")).click();
		// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("com.flipkart.android:id/btn_skip")));
		// driver.findElement(By.id("com.flipkart.android:id/btn_skip")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className(("android.widget.ImageButton"))));
		driver.findElement(By.className(("android.widget.ImageButton"))).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(("SmartWatches & Wearables"))));
		driver.findElement(By.name(("SmartWatches & Wearables"))).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(("Smart Watch"))));
		driver.findElement(By.name(("Smart Watch"))).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(("Portronics Yogg Black Smartwatch"))));
		driver.findElement(By.name(("Portronics Yogg Black Smartwatch"))).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name(("BUY NOW"))));
		driver.findElement(By.name(("BUY NOW"))).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(("com.flipkart.android:id/logo_icon"))));
		driver.findElement(By.id("com.flipkart.android:id/logo_icon")).click();

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(("com.flipkart.android:id/cart_count"))));
		String count = driver.findElement(By.id("com.flipkart.android:id/cart_count")).getText();

		System.out.println("Items in the cart are:" + count);
		if (Integer.parseInt(count) >= 1)
			System.out.println("Test case Passed");
		else
			System.out.println("Test Case Failed");
	}

	public static void checkUIElements() throws Exception {
		checkSearchWidget();
		 checkHorizontalScroll();
		 checkTopAppNotification();
	}

	public static void checkSearchWidget() {

		System.out.println("**** checkSearchWidget ****");

		// Check text search
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(
				ExpectedConditions.visibilityOfElementLocated(By.id(("com.flipkart.android:id/search_widget_layout"))));
		WebElement element = driver.findElement(By.id(("com.flipkart.android:id/search_widget_layout")));
		if (element.isEnabled()) {
			System.out.println("Search Element Enabled!");
		} else {
			System.out.println("Search Element disabled");
		}
		if (element.getAttribute("clickable") != null) {
			System.out.println("Search Element is Clickable");
		} else {
			System.out.println("Search Element is not clickable");
		}

		// Check Camera
		element = driver.findElement(By.id(("com.flipkart.android:id/search_widget_image")));
		if (element.isEnabled()) {
			System.out.println("Image Enabled");
		}
		if (element.getAttribute("clickable") != null) {
			System.out.println("Image Clickable");
		} else {
			System.out.println("Image Not Clickable");
		}

	}

	public static void checkHorizontalScroll() throws Exception {
		System.out.println("**** checkHorizontalScroll ****");
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(("com.flipkart.android:id/drawer_layout"))));

		WebElement element = driver.findElement(By.id("com.flipkart.android:id/drawer_layout"));

		List<WebElement> scrollableElements = element
				.findElements(By.className("android.support.v7.widget.RecyclerView"));
		System.out.println(">>>># of scrollable elements: " + scrollableElements.size());

		for (WebElement scrollableElement : scrollableElements) {
			if (scrollableElement.isEnabled()) {
				System.out.println("Scrollable Element Enabled");
				if (scrollableElement.getAttribute("focusable") != null) {
					System.out.println("Scrollable Element Focusable");
					if(scrollableElement.getAttribute("scrollable") != null){
						System.out.println("Scrollable Element Scrollable");
					}else{
						System.out.println("Scrollable Element not scrollable");
					}
				} else {
					System.out.println("Scrollable Element not Focusable");
				}
			} else

			{
				System.out.println("Scrollable Element Disabled");
			}
			// Assert.assertTrue(scrollableElement.isEnabled());
			// Assert.assertEquals(scrollableElement.getAttribute("focusable"),
			// "true");
			// Assert.assertEquals(scrollableElement.getAttribute("scrollable"),
			// "true");

		}
	}

	public static void checkTopAppNotification() throws Exception {
		System.out.println("**** checkTopAppNotification ****");
		WebDriverWait wait = new WebDriverWait(driver, 100);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.id(("com.flipkart.android:id/inappnotification_icon"))));

		WebElement element = driver.findElement(By.id("com.flipkart.android:id/inappnotification_icon"));
		if (element.isEnabled()) {
			System.out.println("In App notifications Enabled!");
		} else {
			System.out.println("In App Notifications Disabled");
		}
		// Assert.assertTrue(element.isEnabled());
		// Assert.assertEquals(element.getAttribute("clickable"), "true");
	}

	public static void teardown() {
		// close the app
		System.out.println("Closing App!");
		driver.quit();
	}

}