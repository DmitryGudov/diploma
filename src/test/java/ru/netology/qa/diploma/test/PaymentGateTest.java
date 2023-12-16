package ru.netology.qa.diploma.test;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ru.netology.qa.diploma.page.HomePage;
import ru.netology.qa.diploma.page.PaymentGatePage;
import ru.netology.qa.diploma.data.DataHelper;
import ru.netology.qa.diploma.data.SQLHelper;

import static com.codeborne.selenide.Selenide.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Payment Gate Tests")
public class PaymentGateTest {

    private PaymentGatePage paymentGatePage = new PaymentGatePage();
    private HomePage homePage = new HomePage();

    String approvedCardNumber = DataHelper.getCardApproved().getCardNumber();
    String approvedCardStatus = DataHelper.getCardApproved().getCardStatus();
    String randomCardNumber17Digits = DataHelper.getRandomCardNumber17Digits();
    String randomCardNumber15Digits = DataHelper.getRandomCardNumber15Digits();
    String randomCardNumber40Digits = DataHelper.getRandomCardNumber40Digits();
    String cardNumberWithSpace = DataHelper.getCardNumberWithSpace();
    String random16SpecialCharacters = DataHelper.getRandom16SpecialCharacters();
    String random16CyrillicString = DataHelper.getRandom16CyrillicString();
    String random16LatinString = DataHelper.getRandom16LatinString();
    String sixteenSpaces = DataHelper.get16Spaces();
    String emptyField = DataHelper.getEmptyField();
    String validExpiryMonth = DataHelper.getValidExpiryMonth();
    String validExpiryYear = DataHelper.getValidExpiryYear();
    String random3Digits = DataHelper.getRandom3Digits();
    String random1Digits = DataHelper.getRandom1Digits();
    String random10Digits = DataHelper.getRandom10Digits();
    String monthWithSpaceInTheMiddle = DataHelper.getMonthWithSpaceInTheMiddle();
    String yearWithSpaceInTheMiddle = DataHelper.getYearWithSpaceInTheMiddle();
    String random2SpecialCharacters = DataHelper.getRandom2SpecialCharacters();
    String random2CyrillicString = DataHelper.getRandom2CyrillicString();
    String random2LatinString = DataHelper.getRandom2LatinString();
    String twoSpaces = DataHelper.get2Spaces();
    String randomValueGreater12 = DataHelper.getRandomValueGreater12();
    String randomValueLess23 = DataHelper.getRandomValueLess23();
    String OO = DataHelper.get00();
    String validOwner = DataHelper.getValidOwner();
    String uppercaseValidOwner = DataHelper.getUppercaseValidOwner();
    String lowercaseValidOwner = DataHelper.getLowercaseValidOwner();
    String invalidOwner = DataHelper.getInvalidOwner();
    String uppercaseInvalidOwner = DataHelper.getUppercaseInvalidOwner();
    String lowercaseInvalidOwner = DataHelper.getLowercaseInvalidOwner();
    String randomText500Symbols = DataHelper.getRandomText500Symbols();
    String random2Digits = DataHelper.getRandom2Digits();
    String random4Digits = DataHelper.getRandom4Digits();
    String random3DigitNumberWithSpace = DataHelper.getRandom3DigitNumberWithSpace();
    String random3SpecialCharacters = DataHelper.getRandom3SpecialCharacters();
    String random3CyrillicString = DataHelper.getRandom3CyrillicString();
    String random3LatinString = DataHelper.getRandom3LatinString();
    String threeSpaces = DataHelper.get3Spaces();

    @BeforeEach
    public void setUp() {
        open("http://localhost:8080");
        homePage.homePage();
        homePage.payment();
        paymentGatePage.paymentGatePage();
    }

    @AfterAll
    public static void shouldCleanBase() {
        SQLHelper.cleanBase();
    }

    @Test
    @DisplayName("Should be open the page for buying a tour on card payment")
    void shouldBeOpenThePageForBuyingATourOnCardPayment() {
        // No need for test steps here since it's just checking if the page is open
    }

    @Test
    @DisplayName("Should be displayed success notification when the bank approves the transaction with valid card details during card payment")
    void shouldDisplaySuccessNotificationWhenBankApprovesTransactionWithValidCardDetailsDuringCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, validExpiryYear, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Успешно", paymentGatePage.getBankApprovedOperationTitleText());
        assertEquals("Операция одобрена Банком.", paymentGatePage.getBankApprovedOperationContentText());
    }

    @Test
    @DisplayName("Should be entered 17 random numeric characters when entering card number")
    void shouldBeEntered17RandomNumericCharactersWhenEnteringCardNumber() {
        paymentGatePage.fillCardData(randomCardNumber17Digits, validExpiryMonth, validExpiryYear, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Ошибка", paymentGatePage.getBankDeclinedOperationTitleText());
        assertEquals("Ошибка! Банк отказал в проведении операции.", paymentGatePage.getBankDeclinedOperationContentText());
    }

    @Test
    @DisplayName("Should be entered 15 random numeric characters when entering card number")
    void shouldBeEntered15RandomNumericCharactersWhenEnteringCardNumber() {
        paymentGatePage.fillCardData(randomCardNumber15Digits, validExpiryMonth, validExpiryYear, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 40 random numeric characters when entering card number")
    void shouldBeEntered40RandomNumericCharactersWhenEnteringCardNumber() {
        paymentGatePage.fillCardData(randomCardNumber40Digits, validExpiryMonth, validExpiryYear, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Ошибка", paymentGatePage.getBankDeclinedOperationTitleText());
        assertEquals("Ошибка! Банк отказал в проведении операции.", paymentGatePage.getBankDeclinedOperationContentText());
    }

    @Test
    @DisplayName("Should be empty input field when entering card number")
    void shouldBeEmptyInputFieldWhenEnteringCardNumber() {
        paymentGatePage.fillCardData(emptyField, validExpiryMonth, validExpiryYear, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Поле обязательно для заполнения", paymentGatePage.getEmptyFieldText());
    }

    @Test
    @DisplayName("Should be entered 16 numeric characters with space in middle when entering card number")
    void shouldBeEntered16NumericCharactersWithSpaceInMiddleWhenEnteringCardNumber() {
        paymentGatePage.fillCardData(cardNumberWithSpace, validExpiryMonth, validExpiryYear, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Ошибка", paymentGatePage.getBankDeclinedOperationTitleText());
        assertEquals("Ошибка! Банк отказал в проведении операции.", paymentGatePage.getBankDeclinedOperationContentText());
    }

    @Test
    @DisplayName("Should be entered 16 random special characters when entering card number")
    void shouldBeEntered16RandomSpecialCharactersWhenEnteringCardNumber() {
        paymentGatePage.fillCardData(random16SpecialCharacters, validExpiryMonth, validExpiryYear, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 16 random Cyrillic characters when entering card number")
    void shouldBeEntered16RandomCyrillicCharactersWhenEnteringCardNumber() {
        paymentGatePage.fillCardData(random16CyrillicString, validExpiryMonth, validExpiryYear, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 16 random Latin characters when entering card number")
    void shouldBeEntered16RandomLatinCharactersWhenEnteringCardNumber() {
        paymentGatePage.fillCardData(random16LatinString, validExpiryMonth, validExpiryYear, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 16 spaces when entering card number")
    void shouldBeEntered16SpacesWhenEnteringCardNumber() {
        paymentGatePage.fillCardData(sixteenSpaces, validExpiryMonth, validExpiryYear, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Поле обязательно для заполнения", paymentGatePage.getEmptyFieldText());
    }

    @Test
    @DisplayName("Should be entered 3 numeric characters in month field when making card payment")
    void shouldBeEntered3NumericCharactersInMonthFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, random3Digits, validExpiryYear, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверно указан срок действия карты", paymentGatePage.getErrorCardTermValidityText());
    }

    @Test
    @DisplayName("Should be entered 1 numeric character in month field when making card payment")
    void shouldBeEntered1NumericCharacterInMonthFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, random1Digits, validExpiryYear, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 10 numeric characters in month field when making card payment")
    void shouldBeEntered10NumericCharactersInMonthFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, random10Digits, validExpiryYear, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверно указан срок действия карты", paymentGatePage.getErrorCardTermValidityText());
    }

    @Test
    @DisplayName("Should be empty input field in month field when making card payment")
    void shouldBeEmptyInputFieldInMonthFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, emptyField, validExpiryYear, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Поле обязательно для заполнения", paymentGatePage.getEmptyFieldText());
    }

    @Test
    @DisplayName("Should be entered 2 numeric characters with space in middle in month field when making card payment")
    void shouldBeEntered2NumericCharactersWithSpaceInMiddleInMonthFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, monthWithSpaceInTheMiddle, validExpiryYear, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Успешно", paymentGatePage.getBankApprovedOperationTitleText());
        assertEquals("Операция одобрена Банком.", paymentGatePage.getBankApprovedOperationContentText());
    }

    @Test
    @DisplayName("Should be entered 2 random special characters in month field when making card payment")
    void shouldBeEntered2RandomSpecialCharactersInMonthFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, random2SpecialCharacters, validExpiryYear, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 2 random Cyrillic characters in month field when making card payment")
    void shouldBeEntered2RandomCyrillicCharactersInMonthFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, random2CyrillicString, validExpiryYear, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 2 random Latin characters in month field when making card payment")
    void shouldBeEntered2RandomLatinCharactersInMonthFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, random2LatinString, validExpiryYear, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 2 spaces in month field when making card payment")
    void shouldBeEntered2SpacesInMonthFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, twoSpaces, validExpiryYear, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Поле обязательно для заполнения", paymentGatePage.getEmptyFieldText());
    }

    @Test
    @DisplayName("Should be entered invalid month greater than 12 when making card payment")
    void shouldBeEnteredInvalidMonthGreaterThan12WhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, randomValueGreater12, validExpiryYear, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверно указан срок действия карты", paymentGatePage.getErrorCardTermValidityText());
    }

    @Test
    @DisplayName("Should be entered invalid month less than 1 when making card payment")
    void shouldBeEnteredInvalidMonthLessThan1WhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, OO, validExpiryYear, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверно указан срок действия карты", paymentGatePage.getErrorCardTermValidityText());
    }

    @Test
    @DisplayName("Should be entered 3 numeric characters in year field when making card payment")
    void shouldBeEntered3NumericCharactersInYearFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, random3Digits, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверно указан срок действия карты", paymentGatePage.getErrorCardTermValidityText());
    }

    @Test
    @DisplayName("Should be entered 1 numeric character in year field when making card payment")
    void shouldBeEntered1NumericCharacterInYearFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, random1Digits, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 10 numeric characters in year field when making card payment")
    void shouldBeEntered10NumericCharactersInYearFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, random10Digits, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверно указан срок действия карты", paymentGatePage.getErrorCardTermValidityText());
    }

    @Test
    @DisplayName("Should be empty input field in year field when making card payment")
    void shouldBeEmptyInputFieldInYearFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, emptyField, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Поле обязательно для заполнения", paymentGatePage.getEmptyFieldText());
    }

    @Test
    @DisplayName("Should be entered 2 numeric characters with space in middle in year field when making card payment")
    void shouldBeEntered2NumericCharactersWithSpaceInMiddleInYearFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, yearWithSpaceInTheMiddle, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Истёк срок действия карты", paymentGatePage.getTermValidityExpiredText());
    }

    @Test
    @DisplayName("Should be entered 2 random special characters in year field when making card payment")
    void shouldBeEntered2RandomSpecialCharactersInYearFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, random2SpecialCharacters, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 2 random Cyrillic characters in year field when making card payment")
    void shouldBeEntered2RandomCyrillicCharactersInYearFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, random2CyrillicString, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 2 random Latin characters in year field when making card payment")
    void shouldBeEntered2RandomLatinCharactersInYearFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, random2LatinString, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 2 spaces in year field when making card payment")
    void shouldBeEntered2SpacesInYearFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, twoSpaces, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Поле обязательно для заполнения", paymentGatePage.getEmptyFieldText());
    }

    @Test
    @DisplayName("Should be entered invalid year less than 24 when making card payment")
    void shouldBeEnteredInvalidYearLessThan24WhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, randomValueLess23, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Истёк срок действия карты", paymentGatePage.getTermValidityExpiredText());
    }

    @Test
    @DisplayName("Should be entered invalid year less than 1 when making card payment")
    void shouldBeEnteredInvalidYearLessThan1WhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, OO, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Истёк срок действия карты", paymentGatePage.getTermValidityExpiredText());
    }

    @Test
    @DisplayName("Should be entered Cyrillic name in owner field when making card payment")
    void shouldBeEnteredCyrillicNameInOwnerFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, validExpiryYear, invalidOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered uppercase Cyrillic name in owner field when making card payment")
    void shouldBeEnteredUppercaseCyrillicNameInOwnerFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, validExpiryYear, uppercaseInvalidOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered lowercase Cyrillic name in owner field when making card payment")
    void shouldBeEnteredLowercaseCyrillicNameInOwnerFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, validExpiryYear, lowercaseInvalidOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered uppercase Latin name in owner field when making card payment")
    void shouldBeEnteredUppercaseLatinNameInOwnerFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, validExpiryYear, uppercaseValidOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Успешно", paymentGatePage.getBankApprovedOperationTitleText());
        assertEquals("Операция одобрена Банком.", paymentGatePage.getBankApprovedOperationContentText());
    }

    @Test
    @DisplayName("Should be entered lowercase Latin name in owner field when making card payment")
    void shouldBeEnteredLowercaseLatinNameInOwnerFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, validExpiryYear, lowercaseValidOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Успешно", paymentGatePage.getBankApprovedOperationTitleText());
        assertEquals("Операция одобрена Банком.", paymentGatePage.getBankApprovedOperationContentText());
    }

    @Test
    @DisplayName("Should be empty input field in owner field when making card payment")
    void shouldBeEmptyInputFieldInOwnerFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, validExpiryYear, emptyField, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Поле обязательно для заполнения", paymentGatePage.getEmptyFieldText());
    }

    @Test
    @DisplayName("Should be entered 16 spaces in owner field when making card payment")
    void shouldBeEntered16SpacesInOwnerFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, validExpiryYear, sixteenSpaces, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Поле обязательно для заполнения", paymentGatePage.getEmptyFieldText());
    }

    @Test
    @DisplayName("Should be entered 10 numeric characters in owner field when making card payment")
    void shouldBeEntered10NumericCharactersInOwnerFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, validExpiryYear, random10Digits, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 16 special characters in owner field when making card payment")
    void shouldBeEntered16SpecialCharactersInOwnerFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, validExpiryYear, random16SpecialCharacters, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 500 characters in owner field when making card payment")
    void shouldBeEntered500CharactersInOwnerFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, validExpiryYear, randomText500Symbols, random3Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 4 numeric characters in CVC field when making card payment")
    void shouldBeEntered4NumericCharactersInCVCFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, validExpiryYear, validOwner, random4Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Успешно", paymentGatePage.getBankApprovedOperationTitleText());
        assertEquals("Операция одобрена Банком.", paymentGatePage.getBankApprovedOperationContentText());
    }

    @Test
    @DisplayName("Should be entered 2 numeric characters in CVC field when making card payment")
    void shouldBeEntered2NumericCharactersInCVCFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, validExpiryYear, validOwner, random2Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 10 numeric characters in CVC field when making card payment")
    void shouldBeEntered10NumericCharactersInCVCFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, validExpiryYear, validOwner, random10Digits);
        paymentGatePage.clickContinueButton();
        assertEquals("Успешно", paymentGatePage.getBankApprovedOperationTitleText());
        assertEquals("Операция одобрена Банком.", paymentGatePage.getBankApprovedOperationContentText());
    }

    @Test
    @DisplayName("Should be empty input field in CVC field when making card payment")
    void shouldBeEmptyInputFieldInCVCFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, validExpiryYear, validOwner, emptyField);
        paymentGatePage.clickContinueButton();
        assertEquals("Поле обязательно для заполнения", paymentGatePage.getEmptyFieldText());
    }

    @Test
    @DisplayName("Should be entered 3 numeric characters with space in CVC field when making card payment")
    void shouldBeEntered3NumericCharactersWithSpaceInCVCFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, validExpiryYear, validOwner, random3DigitNumberWithSpace);
        paymentGatePage.clickContinueButton();
        assertEquals("Успешно", paymentGatePage.getBankApprovedOperationTitleText());
        assertEquals("Операция одобрена Банком.", paymentGatePage.getBankApprovedOperationContentText());
    }

    @Test
    @DisplayName("Should be entered 3 random special characters in CVC field when making card payment")
    void shouldBeEntered3RandomSpecialCharactersInCVCFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, validExpiryYear, validOwner, random3SpecialCharacters);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 3 random Cyrillic characters in CVC field when making card payment")
    void shouldBeEntered3RandomCyrillicCharactersInCVCFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, validExpiryYear, validOwner, random3CyrillicString);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 3 random Latin characters in CVC field when making card payment")
    void shouldBeEntered3RandomLatinCharactersInCVCFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, validExpiryYear, validOwner, random3LatinString);
        paymentGatePage.clickContinueButton();
        assertEquals("Неверный формат", paymentGatePage.getErrorFormatText());
    }

    @Test
    @DisplayName("Should be entered 3 spaces in CVC field when making card payment")
    void shouldBeEntered3SpacesInCVCFieldWhenMakingCardPayment() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, validExpiryYear, validOwner, threeSpaces);
        paymentGatePage.clickContinueButton();
        assertEquals("Поле обязательно для заполнения", paymentGatePage.getEmptyFieldText());
    }

    @Test
    @DisplayName("Should be displayed the card approved status in the database")
    void shouldBeDisplayedTheCardApprovedStatusInTheDatabase() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, validExpiryYear, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        paymentGatePage.getBankApprovedOperationTitleText();
        paymentGatePage.getBankApprovedOperationContentText();
        assertEquals(approvedCardStatus, SQLHelper.getCardStatus("payment_entity"));
    }

    @Test
    @DisplayName("Should be amount pay is 45_000")
    void shouldBeAmountPayIs45_000() {
        paymentGatePage.fillCardData(approvedCardNumber, validExpiryMonth, validExpiryYear, validOwner, random3Digits);
        paymentGatePage.clickContinueButton();
        paymentGatePage.getBankApprovedOperationTitleText();
        paymentGatePage.getBankApprovedOperationContentText();
        assertEquals(45_000, SQLHelper.getAmountPay());
    }

}