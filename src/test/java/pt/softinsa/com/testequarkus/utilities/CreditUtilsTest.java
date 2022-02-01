package pt.softinsa.com.testequarkus.utilities;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.wildfly.common.Assert;
import pt.softinsa.com.testequarkus.exceptionHandler.credit.CreditErrorMessages;
import pt.softinsa.com.testequarkus.exceptionHandler.credit.CreditException;
import pt.softinsa.com.testequarkus.model.CreditRequest;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class CreditUtilsTest {

    CreditRequest creditRequest;

    @BeforeAll
    void setUp() {

        creditRequest = new CreditRequest();
        creditRequest.setClientId(15);
        creditRequest.setClientName("Manel");
        creditRequest.setClientYearsWorking(2);
        creditRequest.setDesireQuantity(26000);
        creditRequest.setNumberOfPayingMonths(86);
        creditRequest.setClientSalary(1600);
    }


    @Test
    void checkClientExistenceSuccess() {
        boolean clientExists = CreditUtils.checkClientExistence(creditRequest.getClientId());
        Assert.assertTrue(clientExists);
    }

    @Test
    void checkClientExistenceFail() {
        creditRequest.setClientId(10);
        boolean clientExists = CreditUtils.checkClientExistence(5);
        Assert.assertFalse(clientExists);
    }

    @Test
    void checkCreditViability() {
    }


    @Test()
    void paymentProposalSuccess() {
        double monthlyPaymentValue = CreditUtils.paymentProposal(9600, 96);
        assertTrue(monthlyPaymentValue == 100);
    }


    @Test()
    void paymentProposalMoreThan96Months() {

        CreditException thrown = assertThrows(
                CreditException.class,() -> CreditUtils.paymentProposal(20000, 300));

        assertTrue(thrown.getMessage().contains(CreditErrorMessages.CREDIT_ABOBE_96_MONTHS));

    }

    @Test
    void validateClientEffortRate() {
    }

    @Test
    void mountingCreditResponse() {
    }

    @AfterAll
    void tearDown() {

    }
}