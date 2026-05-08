public class CalendarEvents {
    private int date;
    private String day;
    private String month;
    private String semester;
    private String event;

    public CalendarEvents(int date, String day, String month, String semester, String event) {
        this.date = date;
        this.day = day;
        this.month = month;
        this.semester = semester;
        this.event = event;
    }

    public int getDate() {
        return date;
    }

    public String getDay() {
        return day;
    }

    public String getMonth() {
        return month;
    }

    public String getSemester() {
        return semester;
    }

    public String getEvent() {
        return event;
    }
}