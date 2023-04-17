package manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.events.WebDriverListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class ListenerWD implements WebDriverListener {
    Logger logger = LoggerFactory.getLogger(ListenerWD.class);

    @Override
    public void onError(Object target, Method method, Object[] args, InvocationTargetException e) {
        WebDriverListener.super.onError(target, method, args, e);
        logger.info("Huston we have a problem!");
        logger.info("Object target  --->" +target.toString());
        logger.info("*************");
        logger.info(method.getName());
        logger.info("*************");
        logger.info("InvocationTargetException1" +e.toString());
        logger.info("*************");
        logger.info("InvocationTargetException2" +e.getMessage());
        logger.info("*************");
        logger.info("InvocationTargetException3" +e.fillInStackTrace());
        logger.info("*************");
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
