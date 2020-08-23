package Test.OOD.quiz0602;

class Weapon {
    private double ATK;

    public void setATK(double ATK) throws WeaponATKException {
        if (ATK < 0 || ATK > 999) {
            throw new WeaponATKException();
        }
        this.ATK = ATK;
    }
}

class WeaponATKException extends Exception {
}

public class MyClass {

    public static void main(String[] args) {
        Weapon weapon = new Weapon();
        try {
            weapon.setATK(-1);
        } catch (WeaponATKException e) {
            System.out.println(e + "throwed!!");
        }
    }
}
