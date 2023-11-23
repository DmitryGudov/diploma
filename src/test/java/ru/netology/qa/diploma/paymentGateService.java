package ru.netology.qa.diploma;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.codeborne.selenide.Configuration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class paymentGateService {

    @BeforeEach
    public void setUp() {
        open("http://localhost:8080");
    }

    @Test
    void case1() {
        $$("button").find(exactText("Купить")).click();
    }

    @Test
    void case3() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("02");
        $(by("placeholder", "22")).sendKeys("25");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Ivan Petrov");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        Configuration.timeout = 10000;
        $(".notification__title").shouldHave(text("Успешно"));
        $(".notification__content").shouldHave(text("Операция одобрена Банком."));
    }

    @Test
    void case4() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("22000000000000001");
        $(by("placeholder", "08")).sendKeys("02");
        $(by("placeholder", "22")).sendKeys("25");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Ivan Petrov");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        Configuration.timeout = 10000;
        $(".notification__title").shouldHave(text("Ошибка"));
        $(".notification__content").shouldHave(text("Ошибка! Банк отказал в проведении операции."));
    }

    @Test
    void case5() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("220000000000001");
        $(by("placeholder", "08")).sendKeys("02");
        $(by("placeholder", "22")).sendKeys("25");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Ivan Petrov");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case6() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("2200000000000000000122000000000000000001");
        $(by("placeholder", "08")).sendKeys("02");
        $(by("placeholder", "22")).sendKeys("25");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Ivan Petrov");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        Configuration.timeout = 10000;
        $(".notification__title").shouldHave(text("Ошибка"));
        $(".notification__content").shouldHave(text("Ошибка! Банк отказал в проведении операции."));
    }

    @Test
    void case7() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("");
        $(by("placeholder", "08")).sendKeys("02");
        $(by("placeholder", "22")).sendKeys("25");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Ivan Petrov");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Поле обязательно для заполнения"));
    }

    @Test
    void case8() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("22000000 00000001");
        $(by("placeholder", "08")).sendKeys("02");
        $(by("placeholder", "22")).sendKeys("25");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Ivan Petrov");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        Configuration.timeout = 10000;
        $(".notification__title").shouldHave(text("Успешно"));
        $(".notification__content").shouldHave(text("Операция одобрена Банком."));
    }

    @Test
    void case9() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("!.№;%:?*()/}{[]'");
        $(by("placeholder", "08")).sendKeys("02");
        $(by("placeholder", "22")).sendKeys("25");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Ivan Petrov");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case10() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("ааббввггддеежжзз");
        $(by("placeholder", "08")).sendKeys("02");
        $(by("placeholder", "22")).sendKeys("25");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Ivan Petrov");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case11() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("aabbccddeeffgghh");
        $(by("placeholder", "08")).sendKeys("02");
        $(by("placeholder", "22")).sendKeys("25");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Ivan Petrov");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case12() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("                ");
        $(by("placeholder", "08")).sendKeys("02");
        $(by("placeholder", "22")).sendKeys("25");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Ivan Petrov");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Поле обязательно для заполнения"));
    }

    @Test
    void case13() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("512");
        $(by("placeholder", "22")).sendKeys("25");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Ivan Petrov");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверно указан срок действия карты"));
    }

    @Test
    void case14() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("7");
        $(by("placeholder", "22")).sendKeys("25");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Ivan Petrov");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case15() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("9876543210");
        $(by("placeholder", "22")).sendKeys("25");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Ivan Petrov");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверно указан срок действия карты"));
    }

    @Test
    void case16() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("");
        $(by("placeholder", "22")).sendKeys("25");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Ivan Petrov");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Поле обязательно для заполнения"));
    }

    @Test
    void case17() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("0 2");
        $(by("placeholder", "22")).sendKeys("25");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Ivan Petrov");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        Configuration.timeout = 10000;
        $(".notification__title").shouldHave(text("Успешно"));
        $(".notification__content").shouldHave(text("Операция одобрена Банком."));
    }

    @Test
    void case18() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("!.");
        $(by("placeholder", "22")).sendKeys("25");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Ivan Petrov");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case19() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("аб");
        $(by("placeholder", "22")).sendKeys("25");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Ivan Petrov");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case20() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("ab");
        $(by("placeholder", "22")).sendKeys("25");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Ivan Petrov");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case21() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("  ");
        $(by("placeholder", "22")).sendKeys("25");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Ivan Petrov");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Поле обязательно для заполнения"));
    }

    @Test
    void case22() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("52");
        $(by("placeholder", "22")).sendKeys("25");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Ivan Petrov");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверно указан срок действия карты"));
    }

    @Test
    void case23() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("00");
        $(by("placeholder", "22")).sendKeys("25");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Ivan Petrov");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверно указан срок действия карты"));
    }

    @Test
    void case24() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("02");
        $(by("placeholder", "22")).sendKeys("512");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Ivan Petrov");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверно указан срок действия карты"));
    }

    @Test
    void case25() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("02");
        $(by("placeholder", "22")).sendKeys("7");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Ivan Petrov");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case26() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("02");
        $(by("placeholder", "22")).sendKeys("9876543210");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Ivan Petrov");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверно указан срок действия карты"));
    }

    @Test
    void case27() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("02");
        $(by("placeholder", "22")).sendKeys("");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Ivan Petrov");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Поле обязательно для заполнения"));
    }

    @Test
    void case28() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("02");
        $(by("placeholder", "22")).sendKeys("0 2");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Ivan Petrov");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Истёк срок действия карты"));
    }

    @Test
    void case29() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("02");
        $(by("placeholder", "22")).sendKeys("!.");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Ivan Petrov");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case30() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("02");
        $(by("placeholder", "22")).sendKeys("аб");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Ivan Petrov");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case31() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("02");
        $(by("placeholder", "22")).sendKeys("ab");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Ivan Petrov");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case32() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("02");
        $(by("placeholder", "22")).sendKeys("  ");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Ivan Petrov");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Поле обязательно для заполнения"));
    }

    @Test
    void case33() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("02");
        $(by("placeholder", "22")).sendKeys("21");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Ivan Petrov");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Истёк срок действия карты"));
    }

    @Test
    void case34() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("02");
        $(by("placeholder", "22")).sendKeys("00");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Ivan Petrov");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Истёк срок действия карты"));
    }

    @Test
    void case35() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("02");
        $(by("placeholder", "22")).sendKeys("25");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Родион Авдеев");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case36() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("02");
        $(by("placeholder", "22")).sendKeys("25");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("РОДИОН АВДЕЕВ");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case37() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("02");
        $(by("placeholder", "22")).sendKeys("25");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("родион авдеев");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case38() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("02");
        $(by("placeholder", "22")).sendKeys("25");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("RODION AVDEEV");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        Configuration.timeout = 10000;
        $(".notification__title").shouldHave(text("Успешно"));
        $(".notification__content").shouldHave(text("Операция одобрена Банком."));
    }

    @Test
    void case39() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("02");
        $(by("placeholder", "22")).sendKeys("25");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("rodion avdeev");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        Configuration.timeout = 10000;
        $(".notification__title").shouldHave(text("Успешно"));
        $(".notification__content").shouldHave(text("Операция одобрена Банком."));
    }

    @Test
    void case40() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("02");
        $(by("placeholder", "22")).sendKeys("25");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Поле обязательно для заполнения"));
    }

    @Test
    void case41() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("02");
        $(by("placeholder", "22")).sendKeys("25");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("          ");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Поле обязательно для заполнения"));
    }

    @Test
    void case42() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("02");
        $(by("placeholder", "22")).sendKeys("25");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("123456789098765");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case43() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("02");
        $(by("placeholder", "22")).sendKeys("25");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("!.№;%:?*()_+");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case44() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("02");
        $(by("placeholder", "22")).sendKeys("25");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Разнообразный и богатый опыт, консультация с широким активом представляет собой интересный эксперимент проверки существенных финансовых и административных условий. Идейные соображения высшего порядка, а также новая модель организационной деятельности влечет за собой процесс внедрения и модернизации нестандартных решений. Идейные соображения высшего порядка, а также внедрение не современных подходов представляет собой интересный эксперимент проверки системы, массового участия. Задача организации.");
        $(by("placeholder", "999")).sendKeys("441");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case45() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("02");
        $(by("placeholder", "22")).sendKeys("25");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Ivan Petrov");
        $(by("placeholder", "999")).sendKeys("6243");
        $$("button").find(exactText("Продолжить")).click();
        Configuration.timeout = 10000;
        $(".notification__title").shouldHave(text("Успешно"));
        $(".notification__content").shouldHave(text("Операция одобрена Банком."));
    }

    @Test
    void case46() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("02");
        $(by("placeholder", "22")).sendKeys("25");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Ivan Petrov");
        $(by("placeholder", "999")).sendKeys("92");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case47() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("02");
        $(by("placeholder", "22")).sendKeys("25");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Ivan Petrov");
        $(by("placeholder", "999")).sendKeys("1234567890");
        $$("button").find(exactText("Продолжить")).click();
        Configuration.timeout = 10000;
        $(".notification__title").shouldHave(text("Успешно"));
        $(".notification__content").shouldHave(text("Операция одобрена Банком."));
    }

    @Test
    void case48() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("02");
        $(by("placeholder", "22")).sendKeys("25");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Ivan Petrov");
        $(by("placeholder", "999")).sendKeys("");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Поле обязательно для заполнения"));
    }

    @Test
    void case49() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("02");
        $(by("placeholder", "22")).sendKeys("25");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Ivan Petrov");
        $(by("placeholder", "999")).sendKeys("4 62");
        $$("button").find(exactText("Продолжить")).click();
        Configuration.timeout = 10000;
        $(".notification__title").shouldHave(text("Успешно"));
        $(".notification__content").shouldHave(text("Операция одобрена Банком."));
    }

    @Test
    void case50() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("02");
        $(by("placeholder", "22")).sendKeys("25");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Ivan Petrov");
        $(by("placeholder", "999")).sendKeys("!.№");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case51() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("02");
        $(by("placeholder", "22")).sendKeys("25");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Ivan Petrov");
        $(by("placeholder", "999")).sendKeys("абв");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case52() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("02");
        $(by("placeholder", "22")).sendKeys("25");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Ivan Petrov");
        $(by("placeholder", "999")).sendKeys("abc");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Неверный формат"));
    }

    @Test
    void case53() {
        $$("button").find(exactText("Купить")).click();
        $(by("placeholder", "0000 0000 0000 0000")).sendKeys("4444444444444441");
        $(by("placeholder", "08")).sendKeys("02");
        $(by("placeholder", "22")).sendKeys("25");
        $$(".input__inner").findBy(text("Владелец")).$(".input__control").setValue("Ivan Petrov");
        $(by("placeholder", "999")).sendKeys("   ");
        $$("button").find(exactText("Продолжить")).click();
        $(".input__sub").shouldHave(text("Поле обязательно для заполнения"));
    }
}