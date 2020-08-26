package sparkles.task;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represent an Event object.
 */
public class Event extends Task{

    protected LocalDate date;
    protected String at;

    public Event(String description, String at) {
        super(description);
        this.date = parseDate(at);
        this.at = at;
    }

    private LocalDate parseDate(String at) {
        return LocalDate.parse(at);
    }

    private String printDate() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MMM dd yyyy");
        return date.format(dateTimeFormatter);
    }

    /**
     * Package the deadline to a format used to store in the task.txt.
     * A file in the local disk to store tasks.
     * @return
     */
    @Override
    public String diskFormat() {
        return "     E | " + super.diskFormat() + " | " + at;
    }

    @Override
    public String toString() {
        return "[E]" + super.toString() + " (at: " + printDate() + ")";
    }
}
