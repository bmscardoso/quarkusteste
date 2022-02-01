package pt.softinsa.com.testequarkus.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pt.softinsa.com.testequarkus.exceptionHandler.worker.WorkerErrorMessages;
import pt.softinsa.com.testequarkus.exceptionHandler.worker.WorkerException;
import pt.softinsa.com.testequarkus.model.Worker;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class WorkerService{

    private static final Logger LOGGER = LoggerFactory.getLogger(WorkerService.class);

    public Worker raiseSalary(Worker worker,int howMuch) {

        if(worker.getId()==10){
            throw new WorkerException(WorkerErrorMessages.NOT_AN_EMPLOYEE);
        }

        worker.setSalary(worker.getSalary()+howMuch);

        return worker;
    }

}
