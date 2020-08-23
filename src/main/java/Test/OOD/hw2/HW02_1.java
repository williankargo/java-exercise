package Test.OOD.hw2;

class Schedule {

    private int[] data_array = new int[31];

    public void setSchedule(int date1) {
        int numdate1 = date1 - 1;
        if (!(date1 < 32 & date1 > 0)) {
            System.out.println("Errr...error!");
            return;
        }
        if (data_array[numdate1] == 0) {
            data_array[numdate1] = 1;
        } else {
            System.out.println("Errr...error!");
        }
    }

    public void setSchedule(int date1, int date2) {
        int number = date1 - date2;
        int numdate1 = date1 - 1;
        int numdate2 = date2 - 1;
        if (!((date1 < 32 & date1 > 0) & (date2 < 32 & date2 > 0))) {  //if只接受單一true/false
            System.out.println("Errr...error!");
            return;
        }
        if ((Math.abs(number) == 1) & (data_array[numdate1] == 0 & data_array[numdate2] == 0)) {
            data_array[numdate1] = 1;
            data_array[numdate2] = 1;
        } else {
            System.out.println("Errr...error!");
        }
    }

    public void setSchedule(int date1, int date2, int date3) {

        //determine 3 non-continuous numbers
        int min = Math.min(date1, Math.min(date2, date3));
        int max = Math.max(date1, Math.max(date2, date3));
        boolean wow = (max - min == 2) & (date1 != date2 & date1 != date3 & date2 != date3);

        int numdate1 = date1 - 1;
        int numdate2 = date2 - 1;
        int numdate3 = date2 - 1;
        if ((!(date1 < 32 & date1 > 0) & (date2 < 32 & date2 > 0) & (date3 < 32
                & date3 > 0))) {
            System.out.println("Errr...error!");
            return;
        }

        if (!(wow) & (data_array[numdate1] == 0 & data_array[numdate2] == 0
                & data_array[numdate2] == 0)) {
            data_array[numdate1] = 1;
            data_array[numdate2] = 1;
            data_array[numdate3] = 1;
        } else {
            System.out.println("Errr...error!");
        }
    }

    public void removeSchedule(int date1) {
        int numdate1 = date1 - 1;
        if ((data_array[numdate1] == 1) & (numdate1 < 32 & numdate1 > 0)) {
            data_array[numdate1] = 0;
        } else {
            System.out.println("Errr...error!");
        }
    }
}


public class HW02_1 {

    public static void main(String[] args) {
        Schedule schedule = new Schedule();

        schedule.removeSchedule(5); //error
        schedule.setSchedule(-1); //error
        schedule.setSchedule(32); //error
        schedule.setSchedule(1);
        schedule.setSchedule(1, 7); //error
        schedule.setSchedule(7);
        schedule.setSchedule(2, -4);  //error
        schedule.setSchedule(2, 3);
        schedule.setSchedule(2, 6);   //error
        schedule.setSchedule(-1, 8, 9); //error
        schedule.setSchedule(1, 2, 3);  //error
        schedule.setSchedule(3, 5, 8);  //error
        schedule.setSchedule(3, 4, 5);  //error
        schedule.removeSchedule(3);
        schedule.removeSchedule(3);  //error

    }

}
