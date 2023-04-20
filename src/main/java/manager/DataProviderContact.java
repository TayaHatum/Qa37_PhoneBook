package manager;

import models.Contact;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DataProviderContact {

    @DataProvider
    public Iterator<Object[]> example(){
        List<Object[]> list= new ArrayList<>();

        return list.iterator();
    }



    @DataProvider
    public Iterator<Object[]> contactSuccess(){
        List<Object[]> list= new ArrayList<>();

        list.add(new Object[]{Contact.builder()
                .name("Tony")
                .lastName("Stark")
                .address("NY")
                .phone("34343434789")
                .email("stark@gmail.com")
                .description("all fields")
                .build()});
        list.add(new Object[]{Contact.builder()
                .name("TonyReq")
                .lastName("Stark")
                .address("NY")
                .phone("3434343445")
                .email("stark1@gmail.com")
                .build()});

        return list.iterator();
    }
}
