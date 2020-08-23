package Annotation.CustomAnno;

@CustomAnnotation
public class CustomAnnoEx {

    @CustomAnnotation
    private String myField = null;

    @CustomAnnotation
    public CustomAnnoEx(){};

    @CustomAnnotation
    public void doIt(@CustomAnnotation String message){
        System.out.println();
    }

}
