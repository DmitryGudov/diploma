package ru.netology.qa.diploma;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class creditGateService {
    @BeforeEach
    public void setUp() {
        open("http://localhost:8080");
    }

    @Test
    void case2() {
        $$("button").find(exactText("Купить в кредит")).click();
    }

    @Test
    void case54() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("11");
        $(by("placeholder", "22")).sendKeys("28");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Roman Kozlov");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".notification__title").shouldHave(text("Успешно"));
        $(".notification__content").shouldHave(text("Операция одобрена Банком."));
        Duration.ofSeconds(30);
    }

    @Test
    void case55() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("22000000000000001");
        $(by("placeholder", "08")).sendKeys("11");
        $(by("placeholder", "22")).sendKeys("28");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Roman Kozlov");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".notification__title").shouldHave(text("Ошибка"));
        $(".notification__content").shouldHave(text("Ошибка! Банк отказал в проведении операции."));
        Duration.ofSeconds(30);
    }

    @Test
    void case56() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("220000000000001");
        $(by("placeholder", "08")).sendKeys("11");
        $(by("placeholder", "22")).sendKeys("28");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Roman Kozlov");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case57() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("2200000000000000000122000000000000000001");
        $(by("placeholder", "08")).sendKeys("11");
        $(by("placeholder", "22")).sendKeys("28");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Roman Kozlov");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".notification__title").shouldHave(text("Ошибка"));
        $(".notification__content").shouldHave(text("Ошибка! Банк отказал в проведении операции."));
        Duration.ofSeconds(30);
    }

    @Test
    void case58() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("");
        $(by("placeholder", "08")).sendKeys("11");
        $(by("placeholder", "22")).sendKeys("28");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Roman Kozlov");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case59() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("22000000 00000001");
        $(by("placeholder", "08")).sendKeys("11");
        $(by("placeholder", "22")).sendKeys("28");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Roman Kozlov");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".notification__title").shouldHave(text("Ошибка"));
        $(".notification__content").shouldHave(text("Ошибка! Банк отказал в проведении операции."));
        Duration.ofSeconds(30);
    }

    @Test
    void case60() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("!.№;%:?*()/}{[]'");
        $(by("placeholder", "08")).sendKeys("11");
        $(by("placeholder", "22")).sendKeys("28");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Roman Kozlov");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case61() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("ааббввггддеежжзз");
        $(by("placeholder", "08")).sendKeys("11");
        $(by("placeholder", "22")).sendKeys("28");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Roman Kozlov");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case62() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("aabbccddeeffgghh");
        $(by("placeholder", "08")).sendKeys("11");
        $(by("placeholder", "22")).sendKeys("28");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Roman Kozlov");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case63() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("                ");
        $(by("placeholder", "08")).sendKeys("11");
        $(by("placeholder", "22")).sendKeys("28");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Roman Kozlov");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case64() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("512");
        $(by("placeholder", "22")).sendKeys("28");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Roman Kozlov");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверно указан срок действия карты"));
    }

    @Test
    void case65() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("7");
        $(by("placeholder", "22")).sendKeys("28");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Roman Kozlov");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case66() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("9876543210");
        $(by("placeholder", "22")).sendKeys("28");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Roman Kozlov");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверно указан срок действия карты"));
    }

    @Test
    void case67() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("");
        $(by("placeholder", "22")).sendKeys("28");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Roman Kozlov");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case68() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("0 2");
        $(by("placeholder", "22")).sendKeys("28");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Roman Kozlov");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".notification__title").shouldHave(text("Успешно"));
        $(".notification__content").shouldHave(text("Операция одобрена Банком."));
        Duration.ofSeconds(30);
    }

    @Test
    void case69() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("!.");
        $(by("placeholder", "22")).sendKeys("28");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Roman Kozlov");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case70() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("аб");
        $(by("placeholder", "22")).sendKeys("28");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Roman Kozlov");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case71() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("ab");
        $(by("placeholder", "22")).sendKeys("28");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Roman Kozlov");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case72() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("  ");
        $(by("placeholder", "22")).sendKeys("28");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Roman Kozlov");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case73() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("52");
        $(by("placeholder", "22")).sendKeys("28");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Roman Kozlov");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверно указан срок действия карты"));
    }

    @Test
    void case74() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("00");
        $(by("placeholder", "22")).sendKeys("28");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Roman Kozlov");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверно указан срок действия карты"));
    }

    @Test
    void case75() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("11");
        $(by("placeholder", "22")).sendKeys("512");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Roman Kozlov");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверно указан срок действия карты"));
    }

    @Test
    void case76() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("11");
        $(by("placeholder", "22")).sendKeys("7");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Roman Kozlov");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case77() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("11");
        $(by("placeholder", "22")).sendKeys("9876543210");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Roman Kozlov");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверно указан срок действия карты"));
    }

    @Test
    void case78() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("11");
        $(by("placeholder", "22")).sendKeys("");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Roman Kozlov");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case79() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("11");
        $(by("placeholder", "22")).sendKeys("0 2");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Roman Kozlov");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Истёк срок действия карты"));
    }

    @Test
    void case80() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("11");
        $(by("placeholder", "22")).sendKeys("!.");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Roman Kozlov");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case81() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("11");
        $(by("placeholder", "22")).sendKeys("аб");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Roman Kozlov");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case82() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("11");
        $(by("placeholder", "22")).sendKeys("ab");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Roman Kozlov");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case83() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("11");
        $(by("placeholder", "22")).sendKeys("  ");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Roman Kozlov");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case84() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("11");
        $(by("placeholder", "22")).sendKeys("21");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Roman Kozlov");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Истёк срок действия карты"));
    }

    @Test
    void case85() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("11");
        $(by("placeholder", "22")).sendKeys("00");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Roman Kozlov");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Истёк срок действия карты"));
    }

    @Test
    void case86() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("11");
        $(by("placeholder", "22")).sendKeys("28");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Родион Авдеев");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case87() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("11");
        $(by("placeholder", "22")).sendKeys("28");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("РОДИОН АВДЕЕВ");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case88() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("11");
        $(by("placeholder", "22")).sendKeys("28");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("родион авдеев");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case89() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("11");
        $(by("placeholder", "22")).sendKeys("28");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("RODION AVDEEV");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".notification__title").shouldHave(text("Успешно"));
        $(".notification__content").shouldHave(text("Операция одобрена Банком."));
        Duration.ofSeconds(30);
    }

    @Test
    void case90() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("11");
        $(by("placeholder", "22")).sendKeys("28");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("rodion avdeev");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".notification__title").shouldHave(text("Успешно"));
        $(".notification__content").shouldHave(text("Операция одобрена Банком."));
        Duration.ofSeconds(30);
    }

    @Test
    void case91() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("11");
        $(by("placeholder", "22")).sendKeys("28");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Поле обязательно для заполнения"));
    }

    @Test
    void case92() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("11");
        $(by("placeholder", "22")).sendKeys("28");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("          ");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Поле обязательно для заполнения"));
    }

    @Test
    void case93() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("11");
        $(by("placeholder", "22")).sendKeys("28");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("123456789098765");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case94() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("11");
        $(by("placeholder", "22")).sendKeys("28");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("!.№;%:?*()_+");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case95() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("11");
        $(by("placeholder", "22")).sendKeys("28");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Разнообразный и богатый опыт, консультация с широким активом представляет собой интересный эксперимент проверки существенных финансовых и административных условий. Идейные соображения высшего порядка, а также новая модель организационной деятельности влечет за собой процесс внедрения и модернизации нестандартных решений. Идейные соображения высшего порядка, а также внедрение не современных подходов представляет собой интересный эксперимент проверки системы, массового участия. Задача организации.");
        $(by("placeholder", "999")).sendKeys("627");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case96() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("11");
        $(by("placeholder", "22")).sendKeys("28");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Roman Kozlov");
        $(by("placeholder", "999")).sendKeys("6243");
        $$("button").find(exactText("Продолжить")).click();
        $(".notification__title").shouldHave(text("Успешно"));
        $(".notification__content").shouldHave(text("Операция одобрена Банком."));
        Duration.ofSeconds(30);
    }

    @Test
    void case97() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("11");
        $(by("placeholder", "22")).sendKeys("28");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Roman Kozlov");
        $(by("placeholder", "999")).sendKeys("92");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case98() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("11");
        $(by("placeholder", "22")).sendKeys("28");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Roman Kozlov");
        $(by("placeholder", "999")).sendKeys("1234567890");
        $$("button").find(exactText("Продолжить")).click();
        $(".notification__title").shouldHave(text("Успешно"));
        $(".notification__content").shouldHave(text("Операция одобрена Банком."));
        Duration.ofSeconds(30);
    }

    @Test
    void case99() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("11");
        $(by("placeholder", "22")).sendKeys("28");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Roman Kozlov");
        $(by("placeholder", "999")).sendKeys("");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case100() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("11");
        $(by("placeholder", "22")).sendKeys("28");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Roman Kozlov");
        $(by("placeholder", "999")).sendKeys("4 62");
        $$("button").find(exactText("Продолжить")).click();
        $(".notification__title").shouldHave(text("Успешно"));
        $(".notification__content").shouldHave(text("Операция одобрена Банком."));
        Duration.ofSeconds(30);
    }

    @Test
    void case101() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("11");
        $(by("placeholder", "22")).sendKeys("28");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Roman Kozlov");
        $(by("placeholder", "999")).sendKeys("!.№");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case102() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("11");
        $(by("placeholder", "22")).sendKeys("28");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Roman Kozlov");
        $(by("placeholder", "999")).sendKeys("абв");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case103() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("11");
        $(by("placeholder", "22")).sendKeys("28");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Roman Kozlov");
        $(by("placeholder", "999")).sendKeys("abc");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case104() {
        $$("button").find(exactText("Купить в кредит")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444442");
        $(by("placeholder", "08")).sendKeys("11");
        $(by("placeholder", "22")).sendKeys("28");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Roman Kozlov");
        $(by("placeholder", "999")).sendKeys("   ");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }
}