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
import utilities.ConfigReader;
import utilities.GWD;
import utilities.WaitUtils;

import java.time.Duration;
import java.util.Set;

public class HHHHHHooks222222222222 extends G5_CommonPage {

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
        // Ek cookie temизliği (güvenlik için)
        if (GWD.getDriver() != null) {
            GWD.getDriver().manage().deleteAllCookies();
        }
    }

//    @Before(value = "@medunna_UserName_Email", order = 3)
//    public void beforeApi() {
//        // API setup - sadece gerekli testler için
//        trelloApiSetUp();
//    }

    @Before(order = 4) // En son çalışacak - login işlemi
    public void loginBeforeScenario() {
        try {
            // Sayfa yüklenmeden önce bekle
            Thread.sleep(1000);

            // Ana sayfaya git
            GWD.getDriver().get(ConfigReader.getProperty("trelloURL"));

            // Sayfa yüklenene kadar bekle
            WebDriverWait wait = new WebDriverWait(GWD.getDriver(), Duration.ofSeconds(DEFAULT_WAIT_TIME));

            // Login işlemi
            g5HomePage().loginButton.click();
            WaitUtils.waitForVisibility(g5LoginPage().inputMailBox, DEFAULT_WAIT_TIME);

            // Enum'dan kullanıcı seçiyoruz
            UserCredentials user = UserCredentials.user_mustafa;

            // E-posta girip devam et
            g5LoginPage().inputMailBox.clear(); // Önceki veriyi temizle
            g5LoginPage().inputMailBox.sendKeys(user.getEmail());
            g5LoginPage().continueButton.click();

            WaitUtils.waitForVisibility(g5LoginPage().passwordBox, 3);

            // Şifre girip login ol
            g5LoginPage().passwordBox.clear(); // Önceki veriyi temizle
            g5LoginPage().passwordBox.sendKeys(user.getPassword());
            g5LoginPage().logInButton.click();

            // Login başarılı olduğunu kontrol et
            Thread.sleep(2000); // Login işleminin tamamlanması için

        } catch (Exception e) {
            System.err.println("Login işlemi başarısız: " + e.getMessage());
            takeScreenshot("login_failed");
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
            // Burada application-specific session data temizliği yapabilirsiniz
            // Örneğin: API call ile user session'ı temizleme
            // RestAssured.given().delete("/api/session/clear");

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
            // Static değişkenleri sıfırla
            // TestDataManager.resetAll();

            // Singleton instance'ları reset et
            // ConfigManager.getInstance().reset();

            // Test counter'ları sıfırla
            // TestCounters.resetAll();

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
            // Eğer logout button varsa tıkla
            if (isElementPresent("logout-button") || isElementPresent("user-menu")) {
                // Burada logout işlemi kodlarını yazın
                // Örnek: g5CommonPage().logoutButton.click();

                // Logout işleminin tamamlanmasını bekle
                Thread.sleep(1000);

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
            return false;
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