package guru.qa;

import com.codeborne.selenide.Condition;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaStepTest {
    private static final String REPOSITORY = "Antonina19/qa_guru_home_6";

    @Test
    public void testRepositoryIssue(){
        step("Открываем главную страницу", ()->{
            open("https://github.com");
        });
        step("Ищем репозиторий " + REPOSITORY, ()->{
            $(".header-search-input").setValue(REPOSITORY).submit();
        });
        step("Переходим в репозиторий", ()->
            $(linkText("Antonina19/qa_guru_home_6")).click());
        step("Переходим в раздел Issues", ()->
            $$(".js-repo-nav li").findBy(text("Issues")).click());
        step("Проверяем что мы в разделе Issues", ()->
            $(byText("Issues")).should(Condition.exist));
    }
}
