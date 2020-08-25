package sparkles.command.addcommand;

import sparkles.SparklesException;
import sparkles.command.Command;
import sparkles.task.Task;
import sparkles.task.TaskList;
import sparkles.task.Todo;
import sparkles.util.Storage;
import sparkles.util.Ui;

public class AddTodoCommand extends Command {

    public AddTodoCommand(String command) {
        super(command);
    }

    @Override
    public void execute(TaskList taskList, Ui ui, Storage storage) throws SparklesException {
        String desc;
        Task task;
        try {
            desc = command.substring(5).trim();
            task = new Todo(desc);
            ui.print("     Got it. I've added this task");
            task.printTask();

            taskList.add(task);
            ui.printListSize(taskList.listSize());
        } catch (Exception ex) {
            throw new SparklesException("     OOPS!! The description of a todo cannot be empty!");
        } finally {
            storage.updateFile(taskList.getStorage());
        }
    }
}