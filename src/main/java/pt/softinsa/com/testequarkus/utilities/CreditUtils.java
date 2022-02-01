package pt.softinsa.com.testequarkus.utilities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pt.softinsa.com.testequarkus.exceptionHandler.credit.CreditErrorMessages;
import pt.softinsa.com.testequarkus.exceptionHandler.credit.CreditException;
import pt.softinsa.com.testequarkus.model.CreditResponse;

/**
 * Class containg all methods necessary to Credit services
 */
public class CreditUtils {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreditUtils.class);


    /**
     * Simulate the existence of a client
     * Use id abobe 10 to get a valid client
     * @param clientId
     * @return
     */
    public static boolean checkClientExistence(int clientId){

        LOGGER.debug("Validating client {}", clientId);

        boolean isValid = clientId > 10;

        LOGGER.debug("Client validation is {}", isValid);

        return isValid;

    }


    /**
     * Check credit viability by confirming if customer salary is abobe 5% por his desired quantity
     * @param desireQuantity
     * @param customerSalary
     * @return
     */
    public static boolean checkCreditViability(int desireQuantity, int customerSalary){

        LOGGER.debug("Validating credit viability");

        boolean isViable =  customerSalary > desireQuantity*0.05;

        LOGGER.debug("Credit viability is {}", isViable);

        return isViable;

    }


    /**
     * Simula as condições de crédito propostas.
     * Retorna o pagamento mensal com as condições inseridas
     * @param desireQuantity
     * @param payingMonths
     * @return
     */
    public static double paymentProposal(int desireQuantity, int payingMonths){

        LOGGER.debug("Check payment proposal. Calculating monthly credit payment.");

        if(payingMonths>96){
            LOGGER.error(CreditErrorMessages.CREDIT_ABOBE_96_MONTHS);
            throw new CreditException(CreditErrorMessages.CREDIT_ABOBE_96_MONTHS);
        }

        LOGGER.debug("Monthly credit payment calculation successfully. Returning results.");

        return desireQuantity / payingMonths;
    }

    /**
     * Check customer effort rate by checking if rent mensal payment is abobe 20% of his salary
     */
    public static boolean validateClientEffortRate(double mensalPayment, int customerSalary){

        LOGGER.debug("Calculating client effort rate.");

        boolean isEffortable = mensalPayment < customerSalary*0.20;

        LOGGER.debug("Client effort rate validatio is {}", isEffortable);

        return isEffortable;
    }

    public static CreditResponse mountingCreditResponse(String clientName, boolean isEffortable, int amountBorrowed, double monthlyCreditPayment, int creditDuration ){

        LOGGER.info("Mounting the proposal response object");

        CreditResponse creditResponse = new CreditResponse();
        creditResponse.setClientName(clientName);
        creditResponse.setCreditAproved(isEffortable);
        creditResponse.setAmountBorrowed(amountBorrowed);
        creditResponse.setMonthlyPayment(monthlyCreditPayment);
        creditResponse.setCreditDuration(creditDuration);

        return creditResponse;
    }

}
