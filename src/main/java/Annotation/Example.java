package Annotation;

import java.lang.annotation.*;

//annotation一般作为说明信息，与程序的业务逻辑无关。

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface Programmer{
    String value() default "Peter";
}


@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface ProgrammerType{
    public enum CoderType{MONKEYS,LION,CHHOK};
    CoderType type();
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@interface ProgrammerProducer{
    public int id() default -1;
    public String name() default "shit";
    public String address() default "Taipei";
}

class Coder{
    @Programmer("Peter")
    private String coderName;

    @ProgrammerType(type = ProgrammerType.CoderType.MONKEYS)
    private String coderType;

    @ProgrammerProducer(id=1,name="程序猿乐园",address="荣乐东路")
    private String coderProducer;

    public String getCoderName() {
        return coderName;
    }

    public void setCoderName(String coderName) {
        this.coderName = coderName;
    }

    public String getCoderType() {
        return coderType;
    }

    public void setCoderType(String coderType) {
        this.coderType = coderType;
    }

    public String getCoderProducer() {
        return coderProducer;
    }

    public void setCoderProducer(String coderProducer) {
        this.coderProducer = coderProducer;
    }
}


public class Example {
    public static void main(String[] args) {
        Coder demo = new Coder();
        demo.getCoderType();
        demo.getCoderProducer();
    }
}
