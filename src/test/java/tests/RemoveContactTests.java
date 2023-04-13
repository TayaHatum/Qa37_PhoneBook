package tests;

import models.User;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class RemoveContactTests extends TestBase{

    @BeforeMethod
    public void preCondition(){
        if (!app.getHelperUser().isLogged()) {
            app.getHelperUser().login(new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$"));
        }
       // app.helperContact().provideContacts(); /// if list <3 ===> add 3 contacts

    }


    @Test
    public void removeFirstContact(){
        // Assert size list less when one

    }
    @Test
    public void removeAllContacts(){
        // "No contacts Here"

    }
}
