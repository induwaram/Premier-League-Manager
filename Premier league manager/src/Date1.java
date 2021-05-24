import java.io.Serializable;

public class Date1 implements Serializable {
    private int day;
    private int month;
    private int year;

    @Override
    public String toString() {
        return day + " / " + month + " / " + year ;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {

        if (day<31){
            this.day = day;
        }else {
            System.out.println("Enter a valid date");

        }
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {

        if (month < 13) {
            this.month = month;

        } else {
            throw new IllegalArgumentException("Enter a valid Month");
        }
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {this.year = year;}

    //setting the constructor
    public Date1(int day, int month, int year) {
        super();
        setDay(day);
        setMonth(month);
        this.year = year;
    }

}
