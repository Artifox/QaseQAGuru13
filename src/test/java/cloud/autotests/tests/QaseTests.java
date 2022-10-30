package cloud.autotests.tests;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Description;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.title;
import static io.qameta.allure.Allure.step;
import static org.assertj.core.api.Assertions.assertThat;


public class QaseTests extends TestBase {
    @Test
    @Description("Test verify that page title is displayed on main page")
    @DisplayName("Page title should have header text")
    void verifyPageTitleTest() {
        step("Open url 'https://qase.io/'", () ->
                open("https://qase.io/"));

        step("Page title should have text 'Test case management software'", () -> {
            String expectedTitle = "Test case management software";
            String actualTitle = title();
            assertThat(actualTitle).contains(expectedTitle);
        });
    }

    @Test
    @DisplayName("Unauthorized user should have the ability to open login page")
    @Description("Unauthorized user can navigate to login page from main page")
    void verifyAbilityToOpenLoginPageForUnauthorizedUserTest() {
        step("Open url 'https://qase.io/'", () ->
                open("https://qase.io/"));

        step("Click on Login button", () -> {
            $("a#signin").click();
        });

        step("Check that login page is opened", () -> {
            $("a.logo").shouldBe(Condition.visible);
        });
    }

    @Test
    @DisplayName("Unauthorized user should have the ability to open price page")
    @Description("Unauthorized user can navigate to price page from main page")
    void verifyAbilityToOpenPricePageForUnauthorizedUserTest() {
        step("Open url 'https://qase.io/'", () ->
                open("https://qase.io/"));

        step("Click on Login button", () -> {
            $(byText("Pricing")).click();
        });

        step("Check that price page is opened", () -> {
            $(".flexible-plans").shouldHave(Condition.text("Flexible plans for any team"));
        });
    }

    @Test
    @DisplayName("Unauthorized user should have the ability to open blog page")
    @Description("Unauthorized user can navigate to blog page from main page")
    void verifyAbilityToOpenBlogPageForUnauthorizedUserTest() {
        step("Open url 'https://qase.io/'", () ->
                open("https://qase.io/"));

        step("Click on Login button", () -> {
            $(byText("Blog")).click();
        });

        step("Check that blog page is opened", () -> {
            $(".site-logo").shouldBe(Condition.visible);
        });
    }

    @Test
    @DisplayName("Unauthorized user should have the ability to open documentation page")
    @Description("Unauthorized user can navigate to documentation page from main page")
    void verifyAbilityToOpenDocumentationPageForUnauthorizedUserTest() {
        step("Open url 'https://qase.io/'", () ->
                open("https://qase.io/"));

        step("Click on Login button", () -> {
            $(byText("Developers")).click();
        });

        step("Check that blog page is opened", () -> {
            $(byText("Documentation")).shouldBe(Condition.visible);
        });
    }
}