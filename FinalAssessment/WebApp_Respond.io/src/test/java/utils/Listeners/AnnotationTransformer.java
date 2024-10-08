package utils.Listeners;

import org.testng.*;
import org.testng.annotations.*;

import java.lang.reflect.*;

public class AnnotationTransformer implements IAnnotationTransformer {

    @Override
    public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
        annotation.setRetryAnalyzer(Retry.class);
    }
}