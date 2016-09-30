package testsrunner;

import Biz_1.AbstractTest;
import org.junit.*;
import org.reflections.Reflections;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

/**
 * Created by egolub on 9/30/2016.
 */
public class TestsRunner implements Runnable {
    private final String TESTS_PACKAGE_NAME = "Biz_1";
    private Reflections reflectionsObject = new Reflections(TESTS_PACKAGE_NAME);

    @Override
    public void run() {
        for (Class<? extends AbstractTest> currentTestClass: reflectionsObject.getSubTypesOf(AbstractTest.class)) {
            try {
                AbstractTest currentTest = currentTestClass.newInstance();
                beforeTests(currentTest);
                for (Method method : currentTestClass.getDeclaredMethods()) {
                    if(method.getName().contains("logInTest")) {
                        if (method.isAnnotationPresent(Test.class)) {
                            runTestMethod(method, currentTest);
                        }
                    }
                }
                afterTests(currentTest);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    private void beforeTests(AbstractTest currentTest) throws InvocationTargetException, IllegalAccessException {
        Class abstractTestClass = AbstractTest.class;
        for (Method method : abstractTestClass.getDeclaredMethods()) {
            if(method.isAnnotationPresent(BeforeClass.class)) {
                method.invoke(currentTest);
            }
        }
    }

    private void afterTests(AbstractTest currentTest) throws InvocationTargetException, IllegalAccessException {
        Class abstractTestClass = AbstractTest.class;
        for (Method method : abstractTestClass.getDeclaredMethods()) {
            if(method.isAnnotationPresent(AfterClass.class)) {
                method.invoke(currentTest);
            }
        }
    }

    private void runTestMethod(Method method, AbstractTest test) throws InvocationTargetException, IllegalAccessException {
        getBeforeMethod().invoke(test);
        try {
            method.invoke(test);
        } catch (AssertionError error) {
            System.out.println(method.getName() + "failed");
        }
        getAfterMethod().invoke(test);
    }

    private Method getBeforeMethod() {
        for (Method currentMethod : AbstractTest.class.getDeclaredMethods()) {
            if(currentMethod.isAnnotationPresent(Before.class)) {
                return currentMethod;
            }
        }
        return null;
    }

    private Method getAfterMethod() {
        for (Method currentMethod : AbstractTest.class.getDeclaredMethods()) {
            if(currentMethod.isAnnotationPresent(After.class)) {
                return currentMethod;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        new TestsRunner().run();
    }
}

