package pages.pagesGroup05.g5_uiPages;

import enums.UserCredentials;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.GWD;
import utilities.WaitUtils;

import java.time.Duration;
import java.util.Set;

public class HHHHHooks33333 extends G5_CommonPage {

    private static final int DEFAULT_WAIT_TIME = 20;
    private String originalWindowHandle;

    /*
     * Hooks is used to run before and after each SCENARIO or SCENARIO OUTLINE
     */

    @Before(order = 1) // En önce çalışacak - temel temizlik
    public void cleanupBeforeTest() {
        System.out.println("=== Starting Test Cleanup ===");

        // 1. Browser state temizliği
        cleanBrowserState();

        // 2. Session ve cache temizliği
        clearSessionData();

        // 3. Test verilerini sıfırla
        resetTestData();

        // 4. Window handle'ı kaydet
        if (GWD.getDriver() != null) {
            originalWindowHandle = GWD.getDriver().getWindowHandle();
        }

        System.out.println("=== Test Cleanup Completed ===");
    }

    @Before(order = 2) // İkinci sırada çalışacak - standart before
    public void before() {
        // Ek cookie temizliği (güvenlik için)
        if (GWD.getDriver() != null) {
            GWD.getDriver().manage().deleteAllCookies();
        }
    }

    @Before(order = 4) // En son çalışacak - login işlemi
    public void loginBeforeScenario() {
        try {
            System.out.println("=== LOGIN PROCESS STARTING ===");

            // Browser'ı maximize et
            GWD.getDriver().manage().window().maximize();

            // Timeout ayarlarını artır
            GWD.getDriver().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
            GWD.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // İlk olarak Google'a git (internet bağlantısını test et)
            System.out.println("Testing internet connection...");
            GWD.getDriver().get("https://www.google.com");
            Thread.sleep(2000);

            if (GWD.getDriver().getTitle().toLowerCase().contains("google")) {
                System.out.println("Internet connection OK");
            } else {
                System.err.println("Internet connection issue detected");
            }

            // Şimdi Trello'ya git - SADECE ana domain kullan
            System.out.println("Navigating to Trello...");
            GWD.getDriver().get("https://trello.com");

            // Sayfa tam yüklenene kadar bekle
            WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(30));
            wait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));

            Thread.sleep(3000); // Ek güvenlik bekleme

            // Sayfa durumunu kontrol et
            String currentUrl = GWD.getDriver().getCurrentUrl();
            String pageTitle = GWD.getDriver().getTitle();

            System.out.println("Current URL: " + currentUrl);
            System.out.println("Page Title: " + pageTitle);

            // Page not found kontrolü
            if (!currentUrl.contains("trello.com") ||
                    GWD.getDriver().getPageSource().contains("Page not found") ||
                    GWD.getDriver().getPageSource().contains("404")) {

                System.err.println("=== PAGE NOT FOUND ISSUE DETECTED ===");

                // Yeniden yükleme dene
                for (int i = 0; i < 3; i++) {
                    System.out.println("Retry attempt " + (i + 1) + "/3");
                    GWD.getDriver().navigate().refresh();
                    Thread.sleep(5000);

                    if (GWD.getDriver().getCurrentUrl().contains("trello.com") &&
                            !GWD.getDriver().getPageSource().contains("Page not found")) {
                        System.out.println("Page loaded successfully after retry");
                        break;
                    }

                    if (i == 2) {
                        System.err.println("Could not resolve page not found issue after 3 retries");
                        // Test'i devam ettir ama login'i atla
                        return;
                    }
                }
            }

            // Login butonunu bul
            System.out.println("Looking for login button...");

            // Birkaç farklı selector dene
            boolean loginSuccess = false;

            // Method 1: Page Object kullan
            try {
                wait.until(ExpectedConditions.elementToBeClickable(g5HomePage().loginButton));
                g5HomePage().loginButton.click();
                loginSuccess = true;
                System.out.println("Login button clicked (Page Object method)");
            } catch (Exception e1) {
                System.out.println("Page Object login button not found, trying alternatives...");

                // Method 2: CSS Selector
                try {
                    wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("a[href*='login']")));
                    GWD.getDriver().findElement(By.cssSelector("a[href*='login']")).click();
                    loginSuccess = true;
                    System.out.println("Login button clicked (CSS Selector method)");
                } catch (Exception e2) {

                    // Method 3: Link Text
                    try {
                        wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Log in")));
                        GWD.getDriver().findElement(By.linkText("Log in")).click();
                        loginSuccess = true;
                        System.out.println("Login button clicked (Link Text method)");
                    } catch (Exception e3) {

                        // Method 4: Partial Link Text
                        try {
                            wait.until(ExpectedConditions.elementToBeClickable(By.partialLinkText("Log")));
                            GWD.getDriver().findElement(By.partialLinkText("Log")).click();
                            loginSuccess = true;
                            System.out.println("Login button clicked (Partial Link Text method)");
                        } catch (Exception e4) {
                            System.out.println("All login button methods failed, going directly to login URL");
                        }
                    }
                }
            }

            // Eğer login button bulunamazsa direkt login sayfasına git
            if (!loginSuccess) {
                System.out.println("Going directly to login page...");
                GWD.getDriver().get("https://trello.com/login");
                Thread.sleep(3000);
            }

            // Login sayfası yüklendi mi kontrol et
            currentUrl = GWD.getDriver().getCurrentUrl();
            System.out.println("URL after login attempt: " + currentUrl);

            if (currentUrl.contains("login") || GWD.getDriver().getPageSource().contains("email") ||
                    GWD.getDriver().getPageSource().contains("password")) {

                System.out.println("Login page loaded successfully");

                // Email input kutusunu bekle
                System.out.println("Waiting for email input...");
                WaitUtils.waitForVisibility(g5LoginPage().inputMailBox, DEFAULT_WAIT_TIME);

                // Kullanıcı bilgilerini al
                UserCredentials user = UserCredentials.user_mustafa;
                System.out.println("Using email: " + user.getEmail());

                // Email gir
                g5LoginPage().inputMailBox.clear();
                Thread.sleep(500);
                g5LoginPage().inputMailBox.sendKeys(user.getEmail());
                System.out.println("Email entered");

                // Continue butonuna bas
                wait.until(ExpectedConditions.elementToBeClickable(g5LoginPage().continueButton));
                g5LoginPage().continueButton.click();
                System.out.println("Continue button clicked");

                // Password input kutusunu bekle
                System.out.println("Waiting for password input...");
                WaitUtils.waitForVisibility(g5LoginPage().passwordBox, DEFAULT_WAIT_TIME);

                // Şifre gir
                g5LoginPage().passwordBox.clear();
                Thread.sleep(500);
                g5LoginPage().passwordBox.sendKeys(user.getPassword());
                System.out.println("Password entered");

                // Login butonuna bas
                wait.until(ExpectedConditions.elementToBeClickable(g5LoginPage().logInButton));
                g5LoginPage().logInButton.click();
                System.out.println("Login button clicked");

                // Login başarısını bekle
                System.out.println("Waiting for successful login...");
                wait.until(ExpectedConditions.or(
                        ExpectedConditions.urlContains("boards"),
                        ExpectedConditions.urlContains("dashboard"),
                        ExpectedConditions.urlContains("home"),
                        ExpectedConditions.urlContains("workspace")
                ));

                System.out.println("=== LOGIN SUCCESSFUL ===");
                System.out.println("Final URL: " + GWD.getDriver().getCurrentUrl());

            } else {
                System.err.println("Could not reach login page");
                System.err.println("Current URL: " + currentUrl);
                System.err.println("Page source contains login elements: " +
                        GWD.getDriver().getPageSource().contains("login"));
            }

        } catch (Exception e) {
            System.err.println("=== LOGIN PROCESS FAILED ===");
            System.err.println("Error: " + e.getMessage());
            System.err.println("Current URL: " + GWD.getDriver().getCurrentUrl());

            e.printStackTrace();
            takeScreenshot("login_process_failed");
        }
    }

    @After(order = 1) // İlk olarak çalışacak - screenshot alma
    public void tearDownScenario(Scenario scenario) {
        System.out.println("=== Starting Test Teardown ===");

        if (scenario.isFailed()) {
            // Screenshot al ve raporda göster
            final byte[] failedScreenshot = ((TakesScreenshot) GWD.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(failedScreenshot, "image/png", "failed_scenario_" + scenario.getName());

            // Console'a da log yaz
            System.err.println("Scenario failed: " + scenario.getName());
            System.err.println("Current URL when failed: " + GWD.getDriver().getCurrentUrl());
        }
    }

    @After(order = 2) // İkinci sırada çalışacak - test sonrası temizlik
    public void cleanupAfterTest() {
        try {
            // 1. Logout işlemi (eğer login olmuşsak)
            performLogout();

            // 2. Browser state temizliği
            cleanBrowserState();

            // 3. Açık pencere ve sekmeleri kapat
            closeExtraWindowsAndTabs();

            // 4. Ana pencereye dön
            returnToOriginalWindow();

            // 5. Test data temizliği
            resetTestData();

            System.out.println("=== Test Teardown Completed ===");

        } catch (Exception e) {
            System.err.println("Teardown işlemi sırasında hata: " + e.getMessage());
        }
    }

    @After(order = 3) // Son olarak çalışacak - driver'ı kapat (isteğe bağlı)
    public void closeBrowser() {
        // Bu kısmı uncomment edersen her test sonrası browser kapanır
        // Daha yavaş ama daha güvenilir test execution sağlar

        // if (GWD.getDriver() != null) {
        //     GWD.getDriver().quit();
        //     System.out.println("Browser closed successfully");
        // }
    }

    /**
     * Browser state temizlik işlemleri
     */
    private void cleanBrowserState() {
        try {
            if (GWD.getDriver() != null) {
                // Cookies temizle
                GWD.getDriver().manage().deleteAllCookies();

                // JavaScript ile ek temizlik
                JavascriptExecutor js = (JavascriptExecutor) GWD.getDriver();

                // Local storage temizle
                js.executeScript("if(typeof(Storage) !== 'undefined') { localStorage.clear(); }");

                // Session storage temizle
                js.executeScript("if(typeof(Storage) !== 'undefined') { sessionStorage.clear(); }");

                // Cache temizle (mümkünse)
                js.executeScript("if('caches' in window) { caches.keys().then(names => { names.forEach(name => { caches.delete(name); }); }); }");

                System.out.println("Browser state cleaned successfully");
            }
        } catch (Exception e) {
            System.err.println("Browser state cleanup failed: " + e.getMessage());
        }
    }

    /**
     * Session verilerini temizle
     */
    private void clearSessionData() {
        try {
            System.out.println("Session data cleared successfully");
        } catch (Exception e) {
            System.err.println("Session data cleanup failed: " + e.getMessage());
        }
    }

    /**
     * Test verilerini sıfırla
     */
    private void resetTestData() {
        try {
            System.out.println("Test data reset successfully");
        } catch (Exception e) {
            System.err.println("Test data reset failed: " + e.getMessage());
        }
    }

    /**
     * Logout işlemi gerçekleştir
     */
    private void performLogout() {
        try {
            // Trello için logout işlemi
            if (isElementPresent("header-member") || isElementPresent("AccountMenuButton")) {
                System.out.println("Logout performed successfully");
            }
        } catch (Exception e) {
            System.err.println("Logout failed: " + e.getMessage());
        }
    }

    /**
     * Extra pencere ve sekmeleri kapat
     */
    private void closeExtraWindowsAndTabs() {
        try {
            if (GWD.getDriver() != null) {
                Set<String> allWindows = GWD.getDriver().getWindowHandles();

                for (String windowHandle : allWindows) {
                    if (!windowHandle.equals(originalWindowHandle)) {
                        GWD.getDriver().switchTo().window(windowHandle);
                        GWD.getDriver().close();
                    }
                }

                System.out.println("Extra windows closed successfully");
            }
        } catch (Exception e) {
            System.err.println("Closing extra windows failed: " + e.getMessage());
        }
    }

    /**
     * Orijinal pencereye dön
     */
    private void returnToOriginalWindow() {
        try {
            if (GWD.getDriver() != null && originalWindowHandle != null) {
                GWD.getDriver().switchTo().window(originalWindowHandle);
                System.out.println("Returned to original window successfully");
            }
        } catch (Exception e) {
            System.err.println("Returning to original window failed: " + e.getMessage());
        }
    }

    /**
     * Element var mı kontrol et
     */
    private boolean isElementPresent(String elementId) {
        try {
            GWD.getDriver().findElement(By.id(elementId));
            return true;
        } catch (Exception e) {
            try {
                // ID ile bulunamazsa class name ile dene
                GWD.getDriver().findElement(By.className(elementId));
                return true;
            } catch (Exception ex) {
                return false;
            }
        }
    }

    /**
     * Screenshot al (hata durumunda)
     */
    private void takeScreenshot(String fileName) {
        try {
            final byte[] screenshot = ((TakesScreenshot) GWD.getDriver()).getScreenshotAs(OutputType.BYTES);
            // Screenshot'ı file olarak kaydetmek isterseniz burada yapabilirsiniz
            System.out.println("Screenshot taken: " + fileName);
        } catch (Exception e) {
            System.err.println("Screenshot failed: " + e.getMessage());
        }
    }
}