import java.io.*;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class EventReader {
    private List<CalendarEvents> events = new ArrayList<>();

    public EventReader(String filename) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            String line;
            br.readLine(); // skip header line
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    int date = Integer.parseInt(parts[0].trim());
                    String day = parts[1].trim();
                    String month = parts[2].trim();
                    String semester = parts[3].trim();
                    String event = parts[4].trim();
                    events.add(new CalendarEvents(date, day, month, semester, event));
                }
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    public void showAllEvents() {
        System.out.println("\n--- ALL EVENTS ---");
        for (CalendarEvents e : events) {
            printEvent(e);
        }
    }

    public void showEventsByMonth(String month) {
        System.out.println("\n--- EVENTS IN " + month + " ---");
        boolean found = false;
        for (CalendarEvents e : events) {
            if (e.getMonth().equalsIgnoreCase(month)) {
                printEvent(e);
                found = true;
            }
        }
        if (!found)
            System.out.println("No events found for " + month);
    }

    public void showEventsBySemester(String semester) {
        System.out.println("\n--- EVENTS FOR " + semester.toUpperCase() + " SEMESTER ---");
        for (CalendarEvents e : events) {
            if (e.getSemester().equalsIgnoreCase(semester) || e.getSemester().equalsIgnoreCase("both")) {
                printEvent(e);
            }
        }
    }

    public void showNextEvent() {
        LocalDate today = LocalDate.now();
        System.out.println("\n--- NEXT UPCOMING EVENT ---");
        System.out.println("Today is: " + today);

        CalendarEvents nearest = null;
        long minDays = Long.MAX_VALUE;

        for (CalendarEvents e : events) {
            try {
                int monthNum = Month.valueOf(e.getMonth().toUpperCase()).getValue();
                int year = (monthNum >= 6) ? 2025 : 2026;
                LocalDate eventDate = LocalDate.of(year, monthNum, e.getDate());

                if (!eventDate.isBefore(today)) {
                    long diff = java.time.temporal.ChronoUnit.DAYS.between(today, eventDate);
                    if (diff < minDays) {
                        minDays = diff;
                        nearest = e;
                    }
                }
            } catch (Exception ex) {
                // skip bad rows
            }
        }

        if (nearest != null) {
            System.out.println("Next event in " + minDays + " day(s):");
            printEvent(nearest);
        } else {
            System.out.println("No upcoming events found.");
        }
    }

    public void showHolidays() {
        System.out.println("\n--- ALL HOLIDAYS ---");
        for (CalendarEvents e : events) {
            if (e.getEvent().toLowerCase().contains("holiday") ||
                    e.getEvent().toLowerCase().contains("vacation")) {
                printEvent(e);
            }
        }
    }

    private void printEvent(CalendarEvents e) {
        System.out.println("[" + e.getMonth() + " " + e.getDate() + " - " + e.getDay() + "] " +
                "| Sem: " + e.getSemester().toUpperCase() + " | " + e.getEvent());
    }
}