package manager;

import models.Contact;
import org.testng.annotations.DataProvider;

import java.io.*;
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
    public Iterator<Object[]> contactWrongPhone(){
        List<Object[]> list= new ArrayList<>();
        list.add(new Object[]{Contact.builder()
                .name("John")
                .lastName("Wick")
                .email("john@gmail.com")
                .address("NY")
                .phone("123")
                .description("The best John").build()});
        list.add(new Object[]{Contact.builder()
                .name("John")
                .lastName("Wick")
                .email("john@gmail.com")
                .address("NY")
                .phone("12345678910111213141516")
                .description("The best John").build()});
        list.add(new Object[]{Contact.builder()
                .name("John")
                .lastName("Wick")
                .email("john@gmail.com")
                .address("NY")
                .phone("wwwwwwwwwww")
                .description("The best John").build()});
        list.add(new Object[]{Contact.builder()
                .name("John")
                .lastName("Wick")
                .email("john@gmail.com")
                .address("NY")
                .phone("")
                .description("The best John").build()});

        return list.iterator();
    }


    @DataProvider
    public Iterator<Object[]> contactCSV() throws IOException {
        List<Object[]> list= new ArrayList<>();
        BufferedReader reader =new BufferedReader(new FileReader(new File("src/test/resources/contact.csv")));
        String line = reader.readLine();
        while (line!=null){
            String[] all= line.split(",");
            list.add(new Object[]{Contact.builder()
                    .name(all[0])
                    .lastName(all[1])
                    .email(all[2])
                    .phone(all[3])
                    .address(all[4])
                    .description(all[5])
                    .build()});
            line=reader.readLine();
        }



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
