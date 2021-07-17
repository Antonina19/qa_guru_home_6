package guru.qa;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static org.openqa.selenium.By.linkText;

public class SelenideTest {
    @Test
    public void testRepositoryIssue(){
        open("https://github.com");
        $(".header-search-input").setValue("Antonina19/qa_guru_home_6").submit();

        $(linkText("Antonina19/qa_guru_home_6")).click();
        $$(".js-repo-nav li").findBy(text("Issues")).click();
        $(byText("Issues")).should(Condition.exist);
    }
}
