package com.dll.annotations.service;

import com.dll.annotations.annotations.DLLIzable;
import com.dll.annotations.model.DLLIzablePerson;
import com.dll.annotations.model.Person;
import org.springframework.stereotype.Service;

import java.lang.reflect.Method;

@Service
public class InvitationService {

    public static void DLLInvitationSender(DLLIzablePerson person) {

        Method m = null;
        try {
            m = person.getClass().getMethod("DLLIzablePerson");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        Person personAnnotation = (Person) m.getAnnotation(DLLIzable.class);

        if(!person.getName().equals("DLL")){
            person.setName(personAnnotation.getName());
            System.out.println("Person name changes to : " + person.getName() );
        }
    }
}
