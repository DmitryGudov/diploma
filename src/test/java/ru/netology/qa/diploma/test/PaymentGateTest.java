package ru.netology.qa.diploma.test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.netology.qa.diploma.page.PaymentGatePage;
import ru.netology.qa.diploma.page.HomePage;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Payment Gate Tests")
public class PaymentGateTest {

    private PaymentGatePage paymentGatePage = new PaymentGatePage();
    private HomePage homePage = new HomePage();

    @BeforeEach
    public void setUp() {
        open("http://localhost:8080");
        homePage.homePage();
        homePage.payment();
        paymentGatePage.paymentGatePage();
    }

    @Test
    @DisplayName("Should be open the page for buying a tour on card payment")
    void shouldBeOpenThePageForBuyingATourOnCardPayment() {
        // No need for test steps here since it's just checking if the page is open
    }

    @Test
    @DisplayName("Should be displayed success notification when the bank approves the transaction with valid card details during card payment")
    void shouldDisplaySuccessNotificationWhenBankApprovesTransactionWithValidCardDetailsDuringCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "02", "25", "Ivan Petrov", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Успешно", paymentGatePage.getBankApprovedOperationTitleText());
        assertEquals("Операция одобрена Банком.", paymentGatePage.getBankApprovedOperationContentText());
    }

    @Test
    @DisplayName("Should be entered 17 random numeric characters when entering card number")
    void shouldBeEntered17RandomNumericCharactersWhenEnteringCardNumber() {
        paymentGatePage.fillCardData("22000000000000001", "02", "25", "Ivan Petrov", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Ошибка", paymentGatePage.getBankDeclinedOperationTitleText());
        assertEquals("Ошибка! Банк отказал в проведении операции.", paymentGatePage.getBankDeclinedOperationContentText());
    }

    @Test
    @DisplayName("Should be entered 15 random numeric characters when entering card number")
    void shouldBeEntered15RandomNumericCharactersWhenEnteringCardNumber() {
        paymentGatePage.fillCardData("220000000000001", "02", "25", "Ivan Petrov", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 40 random numeric characters when entering card number")
    void shouldBeEntered40RandomNumericCharactersWhenEnteringCardNumber() {
        paymentGatePage.fillCardData("2200000000000000000122000000000000000001", "02", "25", "Ivan Petrov", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Ошибка", paymentGatePage.getBankDeclinedOperationTitleText());
        assertEquals("Ошибка! Банк отказал в проведении операции.", paymentGatePage.getBankDeclinedOperationContentText());
    }

    @Test
    @DisplayName("Should be empty input field when entering card number")
    void shouldBeEmptyInputFieldWhenEnteringCardNumber() {
        paymentGatePage.fillCardData("", "02", "25", "Ivan Petrov", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Поле обязательно для заполнения", paymentGatePage.getEmptyFieldText());
    }

    @Test
    @DisplayName("Should be entered 16 numeric characters with space in middle when entering card number")
    void shouldBeEntered16NumericCharactersWithSpaceInMiddleWhenEnteringCardNumber() {
        paymentGatePage.fillCardData("22000000 00000001", "02", "25", "Ivan Petrov", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Ошибка", paymentGatePage.getBankDeclinedOperationTitleText());
        assertEquals("Ошибка! Банк отказал в проведении операции.", paymentGatePage.getBankDeclinedOperationContentText());
    }

    @Test
    @DisplayName("Should be entered 16 random special characters when entering card number")
    void shouldBeEntered16RandomSpecialCharactersWhenEnteringCardNumber() {
        paymentGatePage.fillCardData("!.№;%:?*()/}{[]'", "02", "25", "Ivan Petrov", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 16 random Cyrillic characters when entering card number")
    void shouldBeEntered16RandomCyrillicCharactersWhenEnteringCardNumber() {
        paymentGatePage.fillCardData("ааббввггддеежжзз", "02", "25", "Ivan Petrov", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 16 random Latin characters when entering card number")
    void shouldBeEntered16RandomLatinCharactersWhenEnteringCardNumber() {
        paymentGatePage.fillCardData("aabbccddeeffgghh", "02", "25", "Ivan Petrov", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 16 spaces when entering card number")
    void shouldBeEntered16SpacesWhenEnteringCardNumber() {
        paymentGatePage.fillCardData("                ", "02", "25", "Ivan Petrov", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Поле обязательно для заполнения", paymentGatePage.getEmptyFieldText());
    }

    @Test
    @DisplayName("Should be entered 3 numeric characters in month field when making card payment")
    void shouldBeEntered3NumericCharactersInMonthFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "512", "25", "Ivan Petrov", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Неверно указан срок действия карты", paymentGatePage.getErrorCardTermValidityText());
    }

    @Test
    @DisplayName("Should be entered 1 numeric character in month field when making card payment")
    void shouldBeEntered1NumericCharacterInMonthFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "7", "25", "Ivan Petrov", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 10 numeric characters in month field when making card payment")
    void shouldBeEntered10NumericCharactersInMonthFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "9876543210", "25", "Ivan Petrov", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Неверно указан срок действия карты", paymentGatePage.getErrorCardTermValidityText());
    }

    @Test
    @DisplayName("Should be empty input field in month field when making card payment")
    void shouldBeEmptyInputFieldInMonthFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "", "25", "Ivan Petrov", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Поле обязательно для заполнения", paymentGatePage.getEmptyFieldText());
    }

    @Test
    @DisplayName("Should be entered 2 numeric characters with space in middle in month field when making card payment")
    void shouldBeEntered2NumericCharactersWithSpaceInMiddleInMonthFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "0 2", "25", "Ivan Petrov", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Успешно", paymentGatePage.getBankApprovedOperationTitleText());
        assertEquals("Операция одобрена Банком.", paymentGatePage.getBankApprovedOperationContentText());
    }

    @Test
    @DisplayName("Should be entered 2 random special characters in month field when making card payment")
    void shouldBeEntered2RandomSpecialCharactersInMonthFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "!.", "25", "Ivan Petrov", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 2 random Cyrillic characters in month field when making card payment")
    void shouldBeEntered2RandomCyrillicCharactersInMonthFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "аб", "25", "Ivan Petrov", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 2 random Latin characters in month field when making card payment")
    void shouldBeEntered2RandomLatinCharactersInMonthFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "ab", "25", "Ivan Petrov", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 2 spaces in month field when making card payment")
    void shouldBeEntered2SpacesInMonthFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "  ", "25", "Ivan Petrov", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Поле обязательно для заполнения", paymentGatePage.getEmptyFieldText());
    }

    @Test
    @DisplayName("Should be entered invalid month greater than 12 when making card payment")
    void shouldBeEnteredInvalidMonthGreaterThan12WhenMakingCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "52", "25", "Ivan Petrov", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Неверно указан срок действия карты", paymentGatePage.getErrorCardTermValidityText());
    }

    @Test
    @DisplayName("Should be entered invalid month less than 1 when making card payment")
    void shouldBeEnteredInvalidMonthLessThan1WhenMakingCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "00", "25", "Ivan Petrov", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Неверно указан срок действия карты", paymentGatePage.getErrorCardTermValidityText());
    }

    @Test
    @DisplayName("Should be entered 3 numeric characters in year field when making card payment")
    void shouldBeEntered3NumericCharactersInYearFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "02", "512", "Ivan Petrov", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Неверно указан срок действия карты", paymentGatePage.getErrorCardTermValidityText());
    }

    @Test
    @DisplayName("Should be entered 29 in year field when making card payment")
    void shouldBeEntered29InYearFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "02", "29", "Ivan Petrov", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Успешно", paymentGatePage.getBankApprovedOperationTitleText());
        assertEquals("Операция одобрена Банком.", paymentGatePage.getBankApprovedOperationContentText());
    }

    @Test
    @DisplayName("Should be entered 1 numeric character in year field when making card payment")
    void shouldBeEntered1NumericCharacterInYearFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "02", "7", "Ivan Petrov", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 10 numeric characters in year field when making card payment")
    void shouldBeEntered10NumericCharactersInYearFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "02", "9876543210", "Ivan Petrov", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Неверно указан срок действия карты", paymentGatePage.getErrorCardTermValidityText());
    }

    @Test
    @DisplayName("Should be empty input field in year field when making card payment")
    void shouldBeEmptyInputFieldInYearFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "02", "", "Ivan Petrov", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Поле обязательно для заполнения", paymentGatePage.getEmptyFieldText());
    }

    @Test
    @DisplayName("Should be entered 2 numeric characters with space in middle in year field when making card payment")
    void shouldBeEntered2NumericCharactersWithSpaceInMiddleInYearFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "02", "0 2", "Ivan Petrov", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Истёк срок действия карты", paymentGatePage.getTermValidityExpiredText());
    }

    @Test
    @DisplayName("Should be entered 2 random special characters in year field when making card payment")
    void shouldBeEntered2RandomSpecialCharactersInYearFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "02", "!.", "Ivan Petrov", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 2 random Cyrillic characters in year field when making card payment")
    void shouldBeEntered2RandomCyrillicCharactersInYearFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "02", "аб", "Ivan Petrov", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 2 random Latin characters in year field when making card payment")
    void shouldBeEntered2RandomLatinCharactersInYearFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "02", "ab", "Ivan Petrov", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 2 spaces in year field when making card payment")
    void shouldBeEntered2SpacesInYearFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "02", "  ", "Ivan Petrov", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Поле обязательно для заполнения", paymentGatePage.getEmptyFieldText());
    }

    @Test
    @DisplayName("Should be entered invalid year less than 24 when making card payment")
    void shouldBeEnteredInvalidYearLessThan24WhenMakingCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "02", "21", "Ivan Petrov", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Истёк срок действия карты", paymentGatePage.getTermValidityExpiredText());
    }

    @Test
    @DisplayName("Should be entered invalid year less than 1 when making card payment")
    void shouldBeEnteredInvalidYearLessThan1WhenMakingCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "02", "00", "Ivan Petrov", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Истёк срок действия карты", paymentGatePage.getTermValidityExpiredText());
    }

    @Test
    @DisplayName("Should be entered Cyrillic name in owner field when making card payment")
    void shouldBeEnteredCyrillicNameInOwnerFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "02", "25", "Родион Авдеев", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered uppercase Cyrillic name in owner field when making card payment")
    void shouldBeEnteredUppercaseCyrillicNameInOwnerFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "02", "25", "РОДИОН АВДЕЕВ", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered lowercase Cyrillic name in owner field when making card payment")
    void shouldBeEnteredLowercaseCyrillicNameInOwnerFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "02", "25", "родион авдеев", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered uppercase Latin name in owner field when making card payment")
    void shouldBeEnteredUppercaseLatinNameInOwnerFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "02", "25", "RODION AVDEEV", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Успешно", paymentGatePage.getBankApprovedOperationTitleText());
        assertEquals("Операция одобрена Банком.", paymentGatePage.getBankApprovedOperationContentText());
    }

    @Test
    @DisplayName("Should be entered lowercase Latin name in owner field when making card payment")
    void shouldBeEnteredLowercaseLatinNameInOwnerFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "02", "25", "rodion avdeev", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Успешно", paymentGatePage.getBankApprovedOperationTitleText());
        assertEquals("Операция одобрена Банком.", paymentGatePage.getBankApprovedOperationContentText());
    }

    @Test
    @DisplayName("Should be empty input field in owner field when making card payment")
    void shouldBeEmptyInputFieldInOwnerFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "02", "25", "", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Поле обязательно для заполнения", paymentGatePage.getEmptyFieldText());
    }

    @Test
    @DisplayName("Should be entered 10 spaces in owner field when making card payment")
    void shouldBeEntered10SpacesInOwnerFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "02", "25", "          ", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Поле обязательно для заполнения", paymentGatePage.getEmptyFieldText());
    }

    @Test
    @DisplayName("Should be entered 15 numeric characters in owner field when making card payment")
    void shouldBeEntered15NumericCharactersInOwnerFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "02", "25", "123456789098765", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 12 special characters in owner field when making card payment")
    void shouldBeEntered12SpecialCharactersInOwnerFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "02", "25", "!.№;%:?*()_+", "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 500 characters in owner field when making card payment")
    void shouldBeEntered500CharactersInOwnerFieldWhenMakingCardPayment() {
        String longText = "Разнообразный и богатый опыт, консультация с широким активом представляет собой интересный эксперимент проверки существенных финансовых и административных условий. Идейные соображения высшего порядка, а также новая модель организационной деятельности влечет за собой процесс внедрения и модернизации нестандартных решений. Идейные соображения высшего порядка, а также внедрение не современных подходов представляет собой интересный эксперимент проверки системы, массового участия. Задача организации.";
        paymentGatePage.fillCardData("4444444444444441", "02", "25", longText, "441");
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 4 numeric characters in CVC field when making card payment")
    void shouldBeEntered4NumericCharactersInCVCFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "02", "25", "Ivan Petrov", "6243");
        paymentGatePage.clickContinueButton();
        assertEquals("Успешно", paymentGatePage.getBankApprovedOperationTitleText());
        assertEquals("Операция одобрена Банком.", paymentGatePage.getBankApprovedOperationContentText());
    }

    @Test
    @DisplayName("Should be entered 2 numeric characters in CVC field when making card payment")
    void shouldBeEntered2NumericCharactersInCVCFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "02", "25", "Ivan Petrov", "92");
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 10 numeric characters in CVC field when making card payment")
    void shouldBeEntered10NumericCharactersInCVCFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "02", "25", "Ivan Petrov", "1234567890");
        paymentGatePage.clickContinueButton();
        assertEquals("Успешно", paymentGatePage.getBankApprovedOperationTitleText());
        assertEquals("Операция одобрена Банком.", paymentGatePage.getBankApprovedOperationContentText());
    }

    @Test
    @DisplayName("Should be empty input field in CVC field when making card payment")
    void shouldBeEmptyInputFieldInCVCFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "02", "25", "Ivan Petrov", "");
        paymentGatePage.clickContinueButton();
        assertEquals("Поле обязательно для заполнения", paymentGatePage.getEmptyFieldText());
    }

    @Test
    @DisplayName("Should be entered 3 numeric characters with space in CVC field when making card payment")
    void shouldBeEntered3NumericCharactersWithSpaceInCVCFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "02", "25", "Ivan Petrov", "4 62");
        paymentGatePage.clickContinueButton();
        assertEquals("Успешно", paymentGatePage.getBankApprovedOperationTitleText());
        assertEquals("Операция одобрена Банком.", paymentGatePage.getBankApprovedOperationContentText());
    }

    @Test
    @DisplayName("Should be entered 3 random special characters in CVC field when making card payment")
    void shouldBeEntered3RandomSpecialCharactersInCVCFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "02", "25", "Ivan Petrov", "!.№");
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 3 random Cyrillic characters in CVC field when making card payment")
    void shouldBeEntered3RandomCyrillicCharactersInCVCFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "02", "25", "Ivan Petrov", "абв");
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 3 random Latin characters in CVC field when making card payment")
    void shouldBeEntered3RandomLatinCharactersInCVCFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "02", "25", "Ivan Petrov", "abc");
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 3 spaces in CVC field when making card payment")
    void shouldBeEntered3SpacesInCVCFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData("4444444444444441", "02", "25", "Ivan Petrov", "   ");
        paymentGatePage.clickContinueButton();
        assertEquals("Поле обязательно для заполнения", paymentGatePage.getEmptyFieldText());
    }

}