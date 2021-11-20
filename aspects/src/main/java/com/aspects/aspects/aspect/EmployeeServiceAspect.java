package com.aspects.aspects.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class EmployeeServiceAspect {

    @Order(Ordered.HIGHEST_PRECEDENCE)
    @Before(value = "execution(* com.aspects.aspects.service.EmployeeService.*(..)) ")
    public void initEmployeeServiceMethod() {
        log.info("**** INITIATING EMPLOYEE SERVICE METHOD ****");
    }

    @After(value = "execution(* com.aspects.aspects.service.EmployeeService.*(..)) and args(name,empId)")
    public void afterAdvice(JoinPoint joinPoint, String name, String empId) {
        log.info(joinPoint.getSignature() + " : Successfully created Employee with name - " + name + " and id - " + empId);
    }

    @After(value = "execution(* com.aspects.aspects.service.EmployeeService.*(..)) and args(empId)")
    public void afterAdvice(JoinPoint joinPoint,  String empId) {
        log.info(joinPoint.getSignature() + " : Successfully deleted  Employee with id - " + empId);
    }

    @After(value = "execution(* com.aspects.aspects.service.EmployeeService.*(..)) and args()")
    public void afterGetAllEmployees(JoinPoint joinPoint) {
        log.info(joinPoint.getSignature() + " : Served employees");
    }


    @Order(Ordered.LOWEST_PRECEDENCE)
    @After(value = "execution(* com.aspects.aspects.service.EmployeeService.*(..)) ")
    public void finishEmployeeServiceMethod() {
        log.info("**** FINISHIG EMPLOYEE SERVICE METHOD ****");
    }

}
