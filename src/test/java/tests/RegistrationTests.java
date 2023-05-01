package tests;

import models.User;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Random;

public class RegistrationTests extends TestBase{

    @BeforeMethod(alwaysRun = true)
    public void preCondition() {

        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
        }
    }

    @Test
    public void registrationSuccess(){
        Random random = new Random();
        int i = random.nextInt(1000)+1000;
        User user = new User().withEmail("don"+i+"@gmail.com").withPassword("Don12345$");
        logger.info("Tests run with data: --->"+user.toString());
         app.getHelperUser().openLoginRegistrationForm();
         app.getHelperUser().fillLoginRegistrationForm(user);
         app.getHelperUser().submitRegistration();

     // Assert.assertTrue(app.getHelperUser().isLogged());
        Assert.assertTrue(app.getHelperUser().isLogged(),"check is sing out present");
        Assert.assertTrue(app.getHelperUser().isNoContactsHereDisplayed());
        Assert.assertEquals(app.getHelperUser().getMessage(),"No Contacts here!");


    }

    @Test(description = "Bug  report N23467 Fixed",groups = {"smoke"})
    public void registrationWrongEmail(){

        User user = new User().withEmail("dongmail.com").withPassword("Don12345$");
        logger.info("Tests run with data: --->"+user.toString());
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format\n" +
                "            Email must contains one @ and minimum 2 symbols after last dot\n" +
                "            Password must contain at least one uppercase letter!\n" +
                "            Password must contain at least one lowercase letter!\n" +
                "            Password must contain at least one digit!\n" +
                "            Password must contain at least one special symbol from [‘$’,’~’,’-‘,’_’]!"));

       // Assert.assertTrue(app.getHelperUser().isAlertPresent2("Wrong email or password format"));


    }
    @Test
    public void registrationWrongPassword(){

        User user = new User().withEmail("don@gmail.com").withPassword("Don12");
        logger.info("Tests run with data: --->"+user.toString());
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format\n" +
                "            Email must contains one @ and minimum 2 symbols after last dot\n" +
                "            Password must contain at least one uppercase letter!\n" +
                "            Password must contain at least one lowercase letter!\n" +
                "            Password must contain at least one digit!\n" +
                "            Password must contain at least one special symbol from [‘$’,’~’,’-‘,’_’]!"));

        // Assert.assertTrue(app.getHelperUser().isAlertPresent2("Wrong email or password format"));


    }
    @Test
    public void registrationNeValidPasswordExistUser(){

        User user = new User().withEmail("don@gmail.com").withPassword("Don12");
        logger.info("Tests run with data: --->"+user.toString());
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password format\n" +
                "            Email must contains one @ and minimum 2 symbols after last dot\n" +
                "            Password must contain at least one uppercase letter!\n" +
                "            Password must contain at least one lowercase letter!\n" +
                "            Password must contain at least one digit!\n" +
                "            Password must contain at least one special symbol from [‘$’,’~’,’-‘,’_’]!"));

        // Assert.assertTrue(app.getHelperUser().isAlertPresent2("Wrong email or password format"));


    }

    @Test
    public void registrationExistsUser(){

        User user = new User().withEmail("noa@gmail.com").withPassword("Nnoa12345$");
        logger.info("Tests run with data: --->"+user.toString());
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm(user);
        app.getHelperUser().submitRegistration();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("User already exist"));



    }

}
