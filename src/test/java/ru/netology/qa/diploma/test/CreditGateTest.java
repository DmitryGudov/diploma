package ru.netology.qa.diploma.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.qa.diploma.page.CreditGatePage;
import ru.netology.qa.diploma.page.HomePage;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Credit Gate Tests")
public class CreditGateTest {

    private CreditGatePage creditGatePage = new CreditGatePage();
    private HomePage homePage = new HomePage();

    @BeforeEach
    public void setUp() {
        open("http://localhost:8080");
        homePage.homePage();
        homePage.credit();
        creditGatePage.creditGatePage();
    }

    @Test
    @DisplayName("Should be open the page for buying a tour on credit")
    void shouldBeOpenThePageForBuyingATourOnCredit() {
        // No need for test steps here since it's just checking if the page is open
    }

    @Test
    @DisplayName("Should be displayed error notification when the bank declines the transaction with invalid card details")
    void shouldDisplayErrorNotificationWhenBankDeclinesTransactionWithInvalidCardDetails() {
        creditGatePage.fillCardData("4444444444444442", "11", "28", "Roman Kozlov", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Ошибка", creditGatePage.getBankDeclinedOperationTitleText());
        assertEquals("Ошибка! Банк отказал в проведении операции.", creditGatePage.getBankDeclinedOperationContentText());
    }

    @Test
    @DisplayName("Should be entered 17 random numeric characters when entering credit card number")
    void shouldBeEntered17RandomNumericCharactersWhenEnteringCreditCardNumber() {
        creditGatePage.fillCardData("22000000000000001", "11", "28", "Roman Kozlov", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Ошибка", creditGatePage.getBankDeclinedOperationTitleText());
        assertEquals("Ошибка! Банк отказал в проведении операции.", creditGatePage.getBankDeclinedOperationContentText());
    }

    @Test
    @DisplayName("Should be entered 15 random numeric characters when entering credit card number")
    void shouldBeEntered15RandomNumericCharactersWhenEnteringCreditCardNumber() {
        creditGatePage.fillCardData("220000000000001", "11", "28", "Roman Kozlov", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Неверный формат", creditGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 40 random numeric characters when entering credit card number")
    void shouldBeEntered40RandomNumericCharactersWhenEnteringCreditCardNumber() {
        creditGatePage.fillCardData("2200000000000000000122000000000000000001", "11", "28", "Roman Kozlov", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Ошибка", creditGatePage.getBankDeclinedOperationTitleText());
        assertEquals("Ошибка! Банк отказал в проведении операции.", creditGatePage.getBankDeclinedOperationContentText());
    }

    @Test
    @DisplayName("Should be empty input field when entering credit card number")
    void shouldBeEmptyInputFieldWhenEnteringCreditCardNumber() {
        creditGatePage.fillCardData("", "11", "28", "Roman Kozlov", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Поле обязательно для заполнения", creditGatePage.getEmptyFieldText());
    }

    @Test
    @DisplayName("Should be entered 16 numeric characters with space in the middle when entering credit card number")
    void shouldBeEntered16NumericCharactersWithSpaceInMiddleWhenEnteringCreditCardNumber() {
        creditGatePage.fillCardData("22000000 00000001", "11", "28", "Roman Kozlov", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Ошибка", creditGatePage.getBankDeclinedOperationTitleText());
        assertEquals("Ошибка! Банк отказал в проведении операции.", creditGatePage.getBankDeclinedOperationContentText());
    }

    @Test
    @DisplayName("Should be entered 16 random special characters when entering credit card number")
    void shouldBeEntered16RandomSpecialCharactersWhenEnteringCreditCardNumber() {
        creditGatePage.fillCardData("!.№;%:?*()/}{[]'", "11", "28", "Roman Kozlov", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Неверный формат", creditGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 16 random Cyrillic characters when entering credit card number")
    void shouldBeEntered16RandomCyrillicCharactersWhenEnteringCreditCardNumber() {
        creditGatePage.fillCardData("ааббввггддеежжзз", "11", "28", "Roman Kozlov", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Неверный формат", creditGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 16 random Latin characters when entering credit card number")
    void shouldBeEntered16RandomLatinCharactersWhenEnteringCreditCardNumber() {
        creditGatePage.fillCardData("aabbccddeeffgghh", "11", "28", "Roman Kozlov", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Неверный формат", creditGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 16 spaces when entering credit card number")
    void shouldBeEntered16SpacesWhenEnteringCreditCardNumber() {
        creditGatePage.fillCardData("                ", "11", "28", "Roman Kozlov", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Поле обязательно для заполнения", creditGatePage.getEmptyFieldText());
    }

    @Test
    @DisplayName("Should be entered 3 numeric characters in month field when making credit purchase")
    void shouldBeEntered3NumericCharactersInMonthFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData("4444444444444442", "512", "28", "Roman Kozlov", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Неверно указан срок действия карты", creditGatePage.getErrorCardTermValidityText());
    }

    @Test
    @DisplayName("Should be entered 1 numeric character in month field when making credit purchase")
    void shouldBeEntered1NumericCharacterInMonthFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData("4444444444444442", "7", "28", "Roman Kozlov", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Неверный формат", creditGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 10 numeric characters in month field when making credit purchase")
    void shouldBeEntered10NumericCharactersInMonthFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData("4444444444444442", "9876543210", "28", "Roman Kozlov", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Неверно указан срок действия карты", creditGatePage.getErrorCardTermValidityText());
    }

    @Test
    @DisplayName("Should be empty input field in month field when making credit purchase")
    void shouldBeEmptyInputFieldInMonthFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData("4444444444444442", "", "28", "Roman Kozlov", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Поле обязательно для заполнения", creditGatePage.getEmptyFieldText());
    }

    @Test
    @DisplayName("Should be entered 2 numeric characters with space in the middle in month field when making credit purchase")
    void shouldBeEntered2NumericCharactersWithSpaceInMiddleInMonthFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData("4444444444444442", "0 2", "28", "Roman Kozlov", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Ошибка", creditGatePage.getBankDeclinedOperationTitleText());
        assertEquals("Ошибка! Банк отказал в проведении операции.", creditGatePage.getBankDeclinedOperationContentText());
    }

    @Test
    @DisplayName("Should be entered 2 random special characters in month field when making credit purchase")
    void shouldBeEntered2RandomSpecialCharactersInMonthFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData("4444444444444442", "!.", "28", "Roman Kozlov", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Неверный формат", creditGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 2 random Cyrillic characters in month field when making credit purchase")
    void shouldBeEntered2RandomCyrillicCharactersInMonthFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData("4444444444444442", "аб", "28", "Roman Kozlov", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Неверный формат", creditGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 2 random Latin characters in Month field when making credit purchase")
    void shouldBeEntered2RandomLatinCharactersInMonthFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData("4444444444444442", "ab", "28", "Roman Kozlov", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Неверный формат", creditGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 2 spaces in Month field when making credit purchase")
    void shouldBeEntered2SpacesInMonthFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData("4444444444444442", "  ", "28", "Roman Kozlov", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Поле обязательно для заполнения", creditGatePage.getEmptyFieldText());
    }

    @Test
    @DisplayName("Should be entered invalid month greater than 12 when making credit purchase")
    void shouldBeEnteredInvalidMonthGreaterThan12WhenMakingCreditPurchase() {
        creditGatePage.fillCardData("4444444444444442", "52", "28", "Roman Kozlov", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Неверно указан срок действия карты", creditGatePage.getErrorCardTermValidityText());
    }

    @Test
    @DisplayName("Should be entered invalid month less than 1 when making credit purchase")
    void shouldBeEnteredInvalidMonthLessThan1WhenMakingCreditPurchase() {
        creditGatePage.fillCardData("4444444444444442", "00", "28", "Roman Kozlov", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Неверно указан срок действия карты", creditGatePage.getErrorCardTermValidityText());
    }

    @Test
    @DisplayName("Should be entered 3 numeric characters in Year field when making credit purchase")
    void shouldBeEntered3NumericCharactersInYearFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData("4444444444444442", "11", "512", "Roman Kozlov", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Неверно указан срок действия карты", creditGatePage.getErrorCardTermValidityText());
    }

    @Test
    @DisplayName("Should be entered 29 in Year field when making credit purchasee")
    void shouldBeEntered29InYearFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData("4444444444444442", "11", "29", "Roman Kozlov", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Ошибка", creditGatePage.getBankDeclinedOperationTitleText());
        assertEquals("Ошибка! Банк отказал в проведении операции.", creditGatePage.getBankDeclinedOperationContentText());
    }

    @Test
    @DisplayName("Should be entered 1 numeric character in Year field when making credit purchase")
    void shouldBeEntered1NumericCharacterInYearFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData("4444444444444442", "11", "7", "Roman Kozlov", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Неверный формат", creditGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 10 numeric characters in Year field when making credit purchase")
    void shouldBeEntered10NumericCharactersInYearFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData("4444444444444442", "11", "9876543210", "Roman Kozlov", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Неверно указан срок действия карты", creditGatePage.getErrorCardTermValidityText());
    }

    @Test
    @DisplayName("Should be empty input field in Year field when making credit purchase")
    void shouldBeEmptyInputFieldInYearFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData("4444444444444442", "11", "", "Roman Kozlov", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Поле обязательно для заполнения", creditGatePage.getEmptyFieldText());
    }

    @Test
    @DisplayName("Should be entered 2 numeric characters with space in the middle in Year field when making credit purchase")
    void shouldBeEntered2NumericCharactersWithSpaceInMiddleInYearFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData("4444444444444442", "11", "0 2", "Roman Kozlov", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Истёк срок действия карты", creditGatePage.getTermValidityExpiredText());
    }

    @Test
    @DisplayName("Should be entered 2 random special characters in year field when making a credit purchase")
    void shouldBeEntered2RandomSpecialCharactersInYearFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData("4444444444444442", "11", "!.", "Roman Kozlov", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Неверный формат", creditGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 2 random Cyrillic characters in year field when making a credit purchase")
    void shouldBeEntered2RandomCyrillicCharactersInYearFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData("4444444444444442", "11", "аб", "Roman Kozlov", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Неверный формат", creditGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 2 random Latin characters in year field when making a credit purchase")
    void shouldBeEntered2RandomLatinCharactersInYearFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData("4444444444444442", "11", "ab", "Roman Kozlov", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Неверный формат", creditGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 2 spaces in year field when making a credit purchase")
    void shouldBeEntered2SpacesInYearFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData("4444444444444442", "11", "  ", "Roman Kozlov", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Поле обязательно для заполнения", creditGatePage.getEmptyFieldText());
    }

    @Test
    @DisplayName("Should be entered an invalid year less than 24 when making a credit purchase")
    void shouldBeEnteredInvalidYearLessThan24WhenMakingCreditPurchase() {
        creditGatePage.fillCardData("4444444444444442", "11", "21", "Roman Kozlov", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Истёк срок действия карты", creditGatePage.getTermValidityExpiredText());
    }

    @Test
    @DisplayName("Should be entered an invalid year less than 1 when making a credit purchase")
    void shouldBeEnteredInvalidYearLessThan1WhenMakingCreditPayment() {
        creditGatePage.fillCardData("4444444444444442", "11", "00", "Roman Kozlov", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Истёк срок действия карты", creditGatePage.getTermValidityExpiredText());
    }

    @Test
    @DisplayName("Should be entered Cyrillic name in the owner field when making a credit purchase")
    void shouldBeEnteredCyrillicNameInOwnerFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData("4444444444444442", "11", "28", "Родион Авдеев", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Неверный формат", creditGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered uppercase Cyrillic name in the owner field when making a credit purchase")
    void shouldBeEnteredUppercaseCyrillicNameInOwnerFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData("4444444444444442", "11", "28", "РОДИОН АВДЕЕВ", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Неверный формат", creditGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered lowercase Cyrillic name in the owner field when making a credit purchase")
    void shouldBeEnteredLowercaseCyrillicNameInOwnerFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData("4444444444444442", "11", "28", "родион авдеев", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Неверный формат", creditGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered uppercase Latin name in the owner field when making a credit purchase")
    void shouldBeEnteredUppercaseLatinNameInOwnerFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData("4444444444444442", "11", "28", "RODION AVDEEV", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Ошибка", creditGatePage.getBankDeclinedOperationTitleText());
        assertEquals("Ошибка! Банк отказал в проведении операции.", creditGatePage.getBankDeclinedOperationContentText());
    }

    @Test
    @DisplayName("Should be entered lowercase Latin name in the owner field when making a credit purchase")
    void shouldBeEnteredLowercaseLatinNameInOwnerFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData("4444444444444442", "11", "28", "rodion avdeev", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Ошибка", creditGatePage.getBankDeclinedOperationTitleText());
        assertEquals("Ошибка! Банк отказал в проведении операции.", creditGatePage.getBankDeclinedOperationContentText());
    }

    @Test
    @DisplayName("Should be an empty input field in the owner field when making a credit purchase")
    void shouldBeEmptyInputFieldInOwnerFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData("4444444444444442", "11", "28", "", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Поле обязательно для заполнения", creditGatePage.getEmptyFieldText());
    }

    @Test
    @DisplayName("Should be entered 10 spaces in the owner field when making a credit purchase")
    void shouldBeEntered10SpacesInOwnerFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData("4444444444444442", "11", "28", "          ", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Поле обязательно для заполнения", creditGatePage.getEmptyFieldText());
    }

    @Test
    @DisplayName("Should be entered 15 numeric characters in owner field when making a credit purchase")
    void shouldBeEntered15NumericCharactersInOwnerFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData("4444444444444442", "11", "28", "123456789098765", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Неверный формат", creditGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 12 special characters in owner field when making a credit purchase")
    void shouldBeEntered12SpecialCharactersInOwnerFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData("4444444444444442", "11", "28", "!.№;%:?*()_+", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Неверный формат", creditGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 500 characters in owner field when making a credit purchase")
    void shouldBeEntered500CharactersInOwnerFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData("4444444444444442", "11", "28",
                "Разнообразный и богатый опыт, консультация с широким активом представляет собой интересный эксперимент проверки существенных финансовых и административных условий. Идейные соображения высшего порядка, а также новая модель организационной деятельности влечет за собой процесс внедрения и модернизации нестандартных решений. Идейные соображения высшего порядка, а также внедрение не современных подходов представляет собой интересный эксперимент проверки системы, массового участия. Задача организации.", "627");
        creditGatePage.clickContinueButton();
        assertEquals("Неверный формат", creditGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 4 numeric characters in CVC field when making a credit purchase")
    void shouldBeEntered4NumericCharactersInCVCFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData("4444444444444442", "11", "28", "Roman Kozlov", "6243");
        creditGatePage.clickContinueButton();
        assertEquals("Ошибка", creditGatePage.getBankDeclinedOperationTitleText());
        assertEquals("Ошибка! Банк отказал в проведении операции.", creditGatePage.getBankDeclinedOperationContentText());
    }

    @Test
    @DisplayName("Should be entered 2 numeric characters in CVC field when making a credit purchase")
    void shouldBeEntered2NumericCharactersInCVCFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData("4444444444444442", "11", "28", "Roman Kozlov", "92");
        creditGatePage.clickContinueButton();
        assertEquals("Неверный формат", creditGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 10 numeric characters in CVC field when making a credit purchase")
    void shouldBeEntered10NumericCharactersInCVCFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData("4444444444444442", "11", "28", "Roman Kozlov", "1234567890");
        creditGatePage.clickContinueButton();
        assertEquals("Ошибка", creditGatePage.getBankDeclinedOperationTitleText());
        assertEquals("Ошибка! Банк отказал в проведении операции.", creditGatePage.getBankDeclinedOperationContentText());
    }

    @Test
    @DisplayName("Should be an empty input field in CVC field when making a credit purchase")
    void shouldBeEmptyInputFieldInCVCFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData("4444444444444442", "11", "28", "Roman Kozlov", "");
        creditGatePage.clickContinueButton();
        assertEquals("Поле обязательно для заполнения", creditGatePage.getEmptyFieldText());
    }

    @Test
    @DisplayName("Should be entered 3 numeric characters with space in CVC field when making a credit purchase")
    void shouldBeEntered3NumericCharactersWithSpaceInCVCFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData("4444444444444442", "11", "28", "Roman Kozlov", "4 62");
        creditGatePage.clickContinueButton();
        assertEquals("Ошибка", creditGatePage.getBankDeclinedOperationTitleText());
        assertEquals("Ошибка! Банк отказал в проведении операции.", creditGatePage.getBankDeclinedOperationContentText());
    }

    @Test
    @DisplayName("Should be entered 3 random special characters in CVC field when making a credit purchase")
    void shouldBeEntered3RandomSpecialCharactersInCVCFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData("4444444444444442", "11", "28", "Roman Kozlov", "!.№");
        creditGatePage.clickContinueButton();
        assertEquals("Неверный формат", creditGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 3 random Cyrillic characters in CVC field when making a credit purchase")
    void shouldBeEntered3RandomCyrillicCharactersInCVCFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData("4444444444444442", "11", "28", "Roman Kozlov", "абв");
        creditGatePage.clickContinueButton();
        assertEquals("Неверный формат", creditGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 3 random Latin characters in CVC field when making a credit purchase")
    void shouldBeEntered3RandomLatinCharactersInCVCFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData("4444444444444442", "11", "28", "Roman Kozlov", "abc");
        creditGatePage.clickContinueButton();
        assertEquals("Неверный формат", creditGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 3 spaces in CVC field when making a credit purchase")
    void shouldBeEntered3SpacesInCVCFieldWhenMakingCreditPurchase() {
        creditGatePage.fillCardData("4444444444444442", "11", "28", "Roman Kozlov", "   ");
        creditGatePage.clickContinueButton();
        assertEquals("Поле обязательно для заполнения", creditGatePage.getEmptyFieldText());
    }

}