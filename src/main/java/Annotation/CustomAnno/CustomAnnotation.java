package Annotation.CustomAnno;


import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//@Target(ElementType.METHOD)  //只有method能用annotation
@Inherited //子會自動繼承父
@Documented  //被描述的注解在什么范围内有效
@Retention(RetentionPolicy.RUNTIME)  //被描述的注解在什么范围内有效
public @interface CustomAnnotation {
    String name() default "Jack";

    int count() default 999;

    String[] tags() default {"Java", "Annotation"};
}

//javadoc 是一套java程式碼文件產工具。它透過在程式碼註解置入javadoc專用的tag，讓自動產出的文件內容提供更詳細的資訊和美觀的呈現方式。
//而@Documented 會協助讓javadoc將其文檔化成sdk中的api
//SDK相當於開發集成工具環境，API就是數據接口，SDK包含API