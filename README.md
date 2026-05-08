# Parul University Academic Reminder
### Java CLI Application

A functional command-line tool built to navigate Parul University's academic schedule without digging through PDFs. This application parses real-world calendar data from a CSV and provides an interactive interface to track exams, holidays, and deadlines in real-time.

---

## Features
* **Full Schedule Access**: View every academic event for the current term in a single list.
* **Smart Filtering**: Sort events by specific months or toggle between odd and even semesters.
* **Real-Time Countdown**: Calculates exactly how many days remain until your next upcoming event based on today's date.
* **Holiday Tracker**: Quickly isolate public holidays and vacation periods like Raksha Bandhan, Dusshera, and Diwali.
* **Persistent Interface**: An interactive menu loop that allows for multiple queries without needing to restart the app.

---

## Project Architecture
The application is built using three core Java classes to ensure clean, maintainable code:
* **`CalendarEvents.java`**: The data model/container that represents a single event entry.
* **`EventReader.java`**: The logic engine that handles CSV file parsing, memory management, and all filtering algorithms.
* **`Main.java`**: The entry point that manages the user interface and the interactive menu loop.
* **`events.csv`**: The data source containing verified dates for the 2026-27 academic cycle.

---

## Tech Stack
* **Language**: Java (Core)
* **API**: Java `LocalDate` for real-time date calculations and comparisons.
* **I/O**: `BufferedReader` for efficient CSV file handling.

---

## Setup & Execution

### Running on your Machine (Terminal)
1. Clone this repository to your local system.
2. Open your terminal and navigate to the project folder.
3. **Compile the source files**:
   ```bash
   javac Main.java EventReader.java CalendarEvents.java
