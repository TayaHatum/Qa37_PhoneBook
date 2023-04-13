package tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void preCondition() {

        if (app.getHelperUser().isLogged()) {
            app.getHelperUser().logout();
            logger.info("Before method finish logout");
        }
    }


    @Test
    public void loginSuccess() {

        logger.info("Start test with name 'loginSuccess'");
        logger.info("Test data ---> email: 'noa@gmail.com' & password : 'Nnoa12345$'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("noa@gmail.com", "Nnoa12345$");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button 'Sign out' present");

    }

    @Test
    public void loginSuccessModel() {
        logger.info("Test data ---> email: 'noa@gmail.com' & password : 'Nnoa12345$'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("noa@gmail.com", "Nnoa12345$");
        app.getHelperUser().submitLogin();

        Assert.assertTrue(app.getHelperUser().isLogged());
        logger.info("Assert check is Element button 'Sign out' present");
    }

    @Test
    public void loginWrongEmail(){
        logger.info("Test data ---> email: 'noagmail.com' & password : 'Nnoa12345$'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("noagmail.com", "Nnoa12345$");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");
    }

    @Test
    public void loginWrongPassword(){
        logger.info("Test data ---> email: 'noa@gmail.com' & password : 'Nnoa12'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("noa@gmail.com", "Nnoa12");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");
    }
    @Test
    public void loginUnregisteredUser(){
        logger.info("Test data ---> email: 'pop@gmail.com' & password : 'Pop12345$'");
        app.getHelperUser().openLoginRegistrationForm();
        app.getHelperUser().fillLoginRegistrationForm("pop@gmail.com", "Pop12345$");
        app.getHelperUser().submitLogin();
        Assert.assertTrue(app.getHelperUser().isAlertPresent("Wrong email or password"));
        logger.info("Assert check is alert present with error text 'Wrong email or password'");

    }
}
