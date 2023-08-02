package reflex;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class toAnnotationTest {

    Class<User> clazz = User.class;
    @Test
    public void annotationTest() throws NoSuchFieldException, NoSuchMethodException {
        Annotation[] annotations = clazz.getAnnotations();
        MyAnnotation annotation = clazz.getAnnotation(MyAnnotation.class);// 反射拿到注解
        System.out.println(annotation.name());

        Field name = clazz.getDeclaredField("name");
        Annotation[] annotations1;
        annotations1 = name.getAnnotations();

        Method getName = clazz.getDeclaredMethod("getName");
        Annotation[] annotations2 = getName.getAnnotations();

    }
}
