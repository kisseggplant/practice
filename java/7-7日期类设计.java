/**
7-7 日期类设计
分数 20
作者 段喜龙
单位 南昌航空大学
参考题目3和日期相关的程序，设计一个类DateUtil，该类有三个私有属性year、month、day（均为整型数），其中，year∈[1820,2020] ,month∈[1,12] ,day∈[1,31] ,  除了创建该类的构造方法、属性的getter及setter方法外，需要编写如下方法：

public boolean checkInputValidity();//检测输入的年、月、日是否合法
public boolean isLeapYear(int year);//判断year是否为闰年
public DateUtil getNextNDays(int n);//取得year-month-day的下n天日期
public DateUtil getPreviousNDays(int n);//取得year-month-day的前n天日期
public boolean compareDates(DateUtil date);//比较当前日期与date的大小（先后）
public boolean equalTwoDates(DateUtil date);//判断两个日期是否相等
public int getDaysofDates(DateUtil date);//求当前日期与date之间相差的天数
public String showDate();//以“year-month-day”格式返回日期值
应用程序共测试三个功能：

求下n天
求前n天
求两个日期相差的天数
注意：严禁使用Java中提供的任何与日期相关的类与方法，并提交完整源码，包括主类及方法（已提供，不需修改）
*/
import java.util.Scanner;

class DateUtil {
    private int year;
    private int month;
    private int day;

    DateUtil() {
    }

    DateUtil(int y, int m, int d) {
        year = y;
        month = m;
        day = d;
    }

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public void setYear(int y) {
        year = y;
    }

    public void setMonth(int m) {
        month = m;
    }

    public void setDay(int d) {
        day = d;
    }

    public boolean checkInputValidity() {
        return ((year >= 1820 && year <= 2020) && (month >= 1 && month <= 12) && (day >= 1 && day <= 31));
    }

    public boolean isLeapYear(int year) {
        return ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0));
    }

    public boolean compareDates(DateUtil date) {
        if (year > date.year)
            return true;
        else if (year == date.year) {
            if (month > date.month)
                return true;
            else if (month == date.month && day > date.day)
                return true;
        }
        return false;
    }

    public boolean equalTwoDates(DateUtil date) {
        return (year == date.year && month == date.month && day == date.day);
    }

    int[][] standard = { { 0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 },
            { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 } };

    public DateUtil getNextNDays(int m) {
        DateUtil d = new DateUtil(this.year, this.month, this.day);
        long n = (long) m;
        n += (d.getDay() - 1);
        d.setDay(1);
        int flag = 0;
        if (isLeapYear(d.getYear())) {
            flag = 1;
        }
        while (n >= standard[flag][d.getMonth()]) {
            n -= standard[flag][d.getMonth()];
            if (d.getMonth() == 12) {
                d.setYear(d.getYear() + 1);
                d.setMonth(1);
                if (isLeapYear(d.getYear())) {
                    flag = 1;
                } else {
                    flag = 0;
                }
            } else {
                d.setMonth(d.getMonth() + 1);
            }
        }

        d.setDay((int) (n + 1));
        return d;

    }

    public DateUtil getPreviousNDays(int n) {
        DateUtil d = new DateUtil(this.year, this.month, this.day);
        if (n < d.getDay())
            return new DateUtil(this.year, this.month, this.day - n);
        n -= d.getDay() - 1;
        d.setDay(1);
        int flag = 0;
        if (isLeapYear(d.getYear())) {
            flag = 1;
        }

        while (n >= standard[flag][d.getMonth() - 1]) {
            n -= standard[flag][d.getMonth() - 1];
            if (d.getMonth() == 1) {
                if (n >= 31) {
                    d.setYear(d.getYear() - 1);
                    d.setMonth(12);
                    n -= 31;
                    if (isLeapYear(d.getYear())) {
                        flag = 1;
                    } else {
                        flag = 0;
                    }
                } else {
                    // 这里跳出，说明一定是前一年十二月的某日
                    // 或者本年1月1号（n==0）
                    break;
                }
            } else {
                d.setMonth(d.getMonth() - 1);
            }
        }

        if (n != 0) {
            if (d.getMonth() == 1) {
                d.setYear(d.getYear() - 1);
                d.setMonth(12);
                d.setDay(31 - n + 1);
            } else {
                // 这两句位置不能对调
                d.setDay(standard[flag][d.getMonth() - 1] - n + 1);
                d.setMonth(d.getMonth() - 1);
            }
        } else {
            return d;
        }
        return d;
    }

    public int getDaysofDates(DateUtil date) {
        if (this.equalTwoDates(date))
            return 0;
        DateUtil d1, d2;

        // test
        // System.out.println("进函数了");

        // d1是小的那个
        if (this.compareDates(date)) {
            d1 = new DateUtil(date.year, date.month, date.day);
            d2 = new DateUtil(this.year, this.month, this.day);
        } else {
            d1 = new DateUtil(this.year, this.month, this.day);
            d2 = new DateUtil(date.year, date.month, date.day);
        }
        /*
         * System.out.println("如果我出现了说明赋值没问题");
         * System.out.println(d1.showDate());
         * System.out.println(d2.showDate());
         * System.out.println();
         */
        // 化零为整
        int gap = 0;
        // 对齐日，回退到每月1号
        gap -= d1.getDay() - 1;
        d1.setDay(1);
        gap += d2.getDay() - 1;
        d2.setDay(1);

        /*
         * System.out.println("对齐日之后，gap = " + gap);
         * System.out.println("d1 = " + d1.showDate());
         * System.out.println("d2 = " + d2.showDate());
         */
        // 对齐月，回退到每年1月
        int flag1 = 0;
        if (isLeapYear(d1.getYear()))
            flag1 = 1;
        for (int i = 1; i < d1.getMonth(); i++) {
            gap -= standard[flag1][i];
        }
        d1.setMonth(1);

        int flag2 = 0;
        if (isLeapYear(d2.getYear()))
            flag2 = 1;
        for (int i = 1; i < d2.getMonth(); i++) {
            gap += standard[flag2][i];
        }
        d2.setMonth(1);
        /*
         * System.out.println("对齐月之后，gap = " + gap);
         * System.out.println("d1 = " + d1.showDate());
         * System.out.println("d2 = " + d2.showDate());
         */
        // 逐步跨年
        while (d1.getYear() < d2.getYear()) {
            if (isLeapYear(d1.getYear()))
                gap += 366;
            else
                gap += 365;
            // 最开始忘了修改这个↓，导致陷入死循环
            d1.setYear(d1.getYear() + 1);
        }
        return gap;
    }

    public String showDate() {
        return String.format("%d-%d-%d", year, month, day);
    }

}

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int year = 0;
        int month = 0;
        int day = 0;

        int choice = input.nextInt();

        if (choice == 1) { // test getNextNDays method
            int m = 0;
            year = Integer.parseInt(input.next());
            month = Integer.parseInt(input.next());
            day = Integer.parseInt(input.next());

            DateUtil date = new DateUtil(year, month, day);

            if (!date.checkInputValidity()) {
                System.out.println("Wrong Format");
                System.exit(0);
            }

            m = input.nextInt();

            if (m < 0) {
                System.out.println("Wrong Format");
                System.exit(0);
            }

            System.out.print(date.getYear() + "-" + date.getMonth() + "-" + date.getDay() + " next " + m + " days is:");
            System.out.println(date.getNextNDays(m).showDate());
        } else if (choice == 2) { // test getPreviousNDays method
            int n = 0;
            year = Integer.parseInt(input.next());
            month = Integer.parseInt(input.next());
            day = Integer.parseInt(input.next());

            DateUtil date = new DateUtil(year, month, day);

            if (!date.checkInputValidity()) {
                System.out.println("Wrong Format");
                System.exit(0);
            }

            n = input.nextInt();

            if (n < 0) {
                System.out.println("Wrong Format");
                System.exit(0);
            }

            System.out.print(
                    date.getYear() + "-" + date.getMonth() + "-" + date.getDay() + " previous " + n + " days is:");
            System.out.println(date.getPreviousNDays(n).showDate());
        } else if (choice == 3) { // test getDaysofDates method
            year = Integer.parseInt(input.next());
            month = Integer.parseInt(input.next());
            day = Integer.parseInt(input.next());

            int anotherYear = Integer.parseInt(input.next());
            int anotherMonth = Integer.parseInt(input.next());
            int anotherDay = Integer.parseInt(input.next());

            DateUtil fromDate = new DateUtil(year, month, day);
            DateUtil toDate = new DateUtil(anotherYear, anotherMonth, anotherDay);

            if (fromDate.checkInputValidity() && toDate.checkInputValidity()) {
                System.out.println("The days between " + fromDate.showDate() +
                        " and " + toDate.showDate() + " are:"
                        + fromDate.getDaysofDates(toDate));
            } else {
                System.out.println("Wrong Format");
                System.exit(0);
            }
        } else {
            System.out.println("Wrong Format");
            System.exit(0);
        }
        input.close();
    }
}
