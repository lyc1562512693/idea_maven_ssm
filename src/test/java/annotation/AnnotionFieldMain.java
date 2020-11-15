package annotation;

import annotation.action.Perform;
import annotation.model.Item;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class AnnotionFieldMain {
    public static void main(String[] args) {
        System.out.println(getAnnotationField(Item.class));
        getAnnotationMethod(Perform.class);
    }
    public  static String getAnnotationField(Class<?> clazz){
        String result = "";
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields){
            if(field.isAnnotationPresent(Name.class)){
                Name name = field.getAnnotation(Name.class);
                result += field.getName() + ":" + name.value() + "," + field.getType() + "\n";
            }
            if(field.isAnnotationPresent(Type.class)){
                Type type = field.getAnnotation(Type.class);
                result += field.getName() + ":" + type.value() + "," + field.getType() + "\n";
            }
        }
        return result;
    }
    public static void getAnnotationMethod(Class<?> clazz){
        try {
            Method[] methods = clazz.getDeclaredMethods();
            for(Method method : methods){
                if(method.isAnnotationPresent(Before.class)){
                    Before before = method.getAnnotation(Before.class);
                    System.out.println(before.value());
                    method.invoke(clazz.newInstance(),null);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
