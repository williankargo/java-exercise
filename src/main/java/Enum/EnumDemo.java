package Enum;


interface AlertAble2 {
    void alert();
}

public enum EnumDemo implements AlertAble2 {
    OFF("The power is off.") {
        public void alert() {
            System.out.println("OFF alert.");
        }
    },
    ON("The power is high"),
    SUSPEND("The power is low");

    public void alert() {
        System.out.println("default alert");
    }
    private String description;
    private EnumDemo(String d) {
        description = d;
    }
    public String getDescription(){
        return description;
    }
    public void changeDesc(String d){
        description = d;
    }
}

class demo{
    public static void main(String[] args) {
        System.out.println(EnumDemo.OFF.ordinal());
        System.out.println(EnumDemo.ON.ordinal());
        System.out.println(EnumDemo.SUSPEND.ordinal());
        System.out.println(EnumDemo.OFF.getDescription());
        System.out.println(EnumDemo.ON.getDescription());
        System.out.println(EnumDemo.SUSPEND.getDescription());

        EnumDemo.OFF.changeDesc("the power is shut down");
        System.out.println(EnumDemo.OFF.getDescription());

        EnumDemo.OFF.alert();
        EnumDemo.ON.alert();
        EnumDemo.SUSPEND.alert();


    }
}



