package manager;

import com.google.common.io.Files;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Random;

public class ListenerWD implements WebDriverListener {
    Logger logger = LoggerFactory.getLogger(ListenerWD.class);

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        WebDriverListener.super.onError(target, method, args, e);
        logger.info("Huston we have a problem!");
        logger.info("Object target  --->" +target.toString());
        logger.info("*************");
        logger.info("Method name --->" + method.getName());
        logger.info("*************");
        //logger.info("InvocationTargetException1" +e.toString());
        logger.info("*************");
       // logger.info("InvocationTargetException2" +e.getMessage());
        logger.info("*************");
        logger.info("InvocationTargetException & getTargetException -->" +e.getTargetException());
        logger.info("*************");
        int i = new Random().nextInt(1000)+1000;
        String link = "src/test/screenshots/screen_"+i+".png";
        logger.info("Screen with error  is --->"+link);
        WebDriver wd =(ChromeDriver)target;
        TakesScreenshot takesScreenshot=(TakesScreenshot) wd;
        File tmp =takesScreenshot.getScreenshotAs(OutputType.FILE);
        try {
            Files.copy(tmp,new File(link));
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        WebDriverListener.super.beforeFindElement(driver, locator);
        logger.info("Before Find Element --->"+locator);

    }

    @Override
    public void afterFindElement(WebDriver driver, By locator, WebElement result) {
        WebDriverListener.super.afterFindElement(driver, locator, result);
        logger.info("After Find Element --->"+locator);
        logger.info("Location of element " +result.getLocation());
    }

    @Override
    public void beforeFindElements(WebDriver driver, By locator) {
        WebDriverListener.super.beforeFindElements(driver, locator);
        logger.info("Before Find ElementS --->"+locator);
    }

    @Override
    public void afterFindElements(WebDriver driver, By locator, List<WebElement> result) {
        WebDriverListener.super.afterFindElements(driver, locator, result);
        logger.info("After Find ElementS --->"+locator);
        logger.info("list of elements is -->" +result.size());
    }
}
