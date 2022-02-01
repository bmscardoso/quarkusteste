package pt.softinsa.com.testequarkus.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pt.softinsa.com.testequarkus.exceptionHandler.credit.CreditErrorMessages;
import pt.softinsa.com.testequarkus.exceptionHandler.credit.CreditException;
import pt.softinsa.com.testequarkus.model.CreditRequest;
import pt.softinsa.com.testequarkus.model.CreditResponse;
import pt.softinsa.com.testequarkus.utilities.CreditUtils;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CreditService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CreditService.class);

    public CreditResponse validateRentRequest(CreditRequest creditRequest){



        LOGGER.info("Start credit proposal of customer {}", creditRequest.getClientName());


        if( !CreditUtils.checkClientExistence(creditRequest.getClientId()) ){
            throw new CreditException(CreditErrorMessages.CLIENT_DOS_NOT_EXIST);
        }



        if(creditRequest.getClientYearsWorking() < 2){
            throw new CreditException(CreditErrorMessages.CLIENT_HAS_NOT_TWO_YEARS_IN_ACTUAL_COMPANY);
        }



        if( !CreditUtils.checkCreditViability(creditRequest.getDesireQuantity(), creditRequest.getClientSalary())){
            throw new CreditException(CreditErrorMessages.TOO_MUCH_DESIRED_QUANTITY);
        }



        double monthlyCreditPayment = CreditUtils.paymentProposal(creditRequest.getDesireQuantity(), creditRequest.getNumberOfPayingMonths());



        boolean isEffortable = CreditUtils.validateClientEffortRate(monthlyCreditPayment, creditRequest.getClientSalary());

        CreditResponse result = CreditUtils.mountingCreditResponse(creditRequest.getClientName(), isEffortable, creditRequest.getDesireQuantity(), monthlyCreditPayment, creditRequest.getNumberOfPayingMonths() );

        LOGGER.info("Credit proposal completed. Returning the proposal response ");

        return result;
    }



}
