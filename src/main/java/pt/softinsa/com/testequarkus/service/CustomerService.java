package pt.softinsa.com.testequarkus.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pt.softinsa.com.testequarkus.exceptionHandler.customer.CustomerErrorMessages;
import pt.softinsa.com.testequarkus.exceptionHandler.customer.CustomerException;
import pt.softinsa.com.testequarkus.model.Customer;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerService.class);

    public Customer changeSex(Customer customer) throws CustomerException{

        LOGGER.info("Starting change gender process");

        //Simulation of getting customer registration
        /*
        if (customer.getFile(customer.getId()) == null){
            throw new CustomerException(CustomerErrorMessages.NOT_FOUND);
        }
         */

        if(customer.getGender().equals("male")){

            LOGGER.debug("Changing gender from male to female");
            customer.setGender("female");

        }else if(customer.getGender().equals("female")){

            LOGGER.debug("Changing gender from female to male");
            customer.setGender("male");

        }else{

            LOGGER.error("Nonexistent or Unknown gender");
            throw new CustomerException(CustomerErrorMessages.IT_IS_AN_ALIEN);

        }

        LOGGER.info("Change gender process successfully");
        return customer;

    }

    public Customer changeEyes(Customer customer, String newColor) throws CustomerException{

        //Simulation of getting customer registration
        /*
        if (customer.getFile(customer.getId()) == null){
            throw new CustomerException(CustomerErrorMessages.NOT_FOUND);
        }
         */

        if(customer.getEyesColor() == null){
            throw new CustomerException(CustomerErrorMessages.HAS_NO_EYES);
        }

        customer.setEyesColor(newColor);

        return customer;

    }

}
