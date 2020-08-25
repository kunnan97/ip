package sparkles.task;

public class Todo extends Task {

    public Todo(String description) {
        super(description);
    }

    @Override
    public String diskFormat() {
        return "     T | " + super.diskFormat();
    }

    @Override
    public String toString() {
        return "[T]" + super.toString();
    }
}