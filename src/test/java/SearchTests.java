import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchTests {
    @Test
    void successfulSearchTest() {
        Configuration.holdBrowserOpen = true;

        open("https://www.google.com/");
        $("[name=q]").setValue("selenide").pressEnter();
        $("[id=search]").shouldHave(text("selenide"));
    }

    @Test
    void successfulSearchTestYandex() {
        open("https://ya.ru");
        $("[id=text]").setValue("selenide").pressEnter();
        $("[id=search-result]").shouldHave(text("selenide.org"));
    }
}
