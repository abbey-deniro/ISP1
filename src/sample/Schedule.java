package sample;

import java.io.*;
import java.util.ArrayList;

public class Schedule implements Serializable {
    ArrayList<Schedule> employeeSchedule = new ArrayList<>();
    public ArrayList<Schedule> getSchedule() {return employeeSchedule;}
    String empName;
    String day1;
    String day2;
    String day3;
    String day4;
    String day5;
    String day6;
    String day7;
    public Schedule(String empName, String day1, String day2, String day3, String day4, String day5,
                    String day6,
                    String day7) {
       this.empName = empName;
        this.day1 = day1;
        this.day2 = day2;
        this.day3 = day3;
        this.day4 = day4;
        this.day5 = day5;
        this.day6 = day6;
        this.day7 = day7;
    }
    public Schedule() {

    }

    public String getDay1() {
        return day1;
    }

    public String getDay2() {
        return day2;
    }

    public String getDay3() {
        return day3;
    }

    public String getDay4() {
        return day4;
    }

    public String getDay5() {
        return day5;
    }

    public String getDay6() {
        return day6;
    }

    public String getDay7() {
        return day7;
    }

    public void setEmployeeSchedule(ArrayList<Schedule> employeeSchedule) {
        this.employeeSchedule = employeeSchedule;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public void setDay1(String day1) {
        this.day1 = day1;
    }

    public void setDay2(String day2) {
        this.day2 = day2;
    }

    public void setDay3(String day3) {
        this.day3 = day3;
    }

    public void setDay4(String day4) {
        this.day4 = day4;
    }

    public void setDay5(String day5) {
        this.day5 = day5;
    }

    public void setDay6(String day6) {
        this.day6 = day6;
    }

    public void setDay7(String day7) {
        this.day7 = day7;
    }

    public void AddEmployee(String empName, String day1, String day2, String day3, String day4,
                            String day5, String day6, String day7){
        employeeSchedule.add(new Schedule(empName, day1, day2, day3, day4, day5, day6, day7));
    }

    // Dont delete these methods, for whatever reason it breaks read()
    public static void Delete(){

    }

    public static void Modify(){

    }

    public void write() {
        System.out.println(employeeSchedule);
        try {
            FileOutputStream fos = new FileOutputStream("Schedule.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fos);

            oos.writeObject(this.employeeSchedule);

            oos.close();
            fos.close();
        }
        catch(Exception e)
        {

        }
    }

    public void read() {
        try {
            FileInputStream fis = new FileInputStream("Schedule.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);

            this.employeeSchedule = (ArrayList<Schedule>) ois.readObject();

            ois.close();
            fis.close();
        }
        catch (Exception e) {
        }
    }
}
