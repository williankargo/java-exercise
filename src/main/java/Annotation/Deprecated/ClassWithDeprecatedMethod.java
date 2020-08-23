package Annotation.Deprecated;

public class ClassWithDeprecatedMethod {

    @Deprecated //代表此方法已經不建議使用
    public void doIt(){
        System.out.println("Doing it.");
    }
}
