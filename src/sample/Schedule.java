package sample;

public class Schedule extends Person{

    //int hours;
    //int biweeklyHours;
    String day1;
    String day2;
    String day3;
    String day4;
    String day5;
    String day6;
    String day7;

    public Schedule(String name, String day1, String day2, String day3, String day4, String day5, String day6, String day7) {
       super.name = name;
        this.day1 = day1;
        this.day2 = day2;
        this.day3 = day3;
        this.day4 = day4;
        this.day5 = day5;
        this.day6 = day6;
        this.day7 = day7;
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

    public static void Add(){

    }

    public static void Delete(){

    }

    public static void Modify(){

    }

}
