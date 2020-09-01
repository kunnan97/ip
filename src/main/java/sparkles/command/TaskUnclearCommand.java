package sparkles.command;

import sparkles.task.TaskList;
import sparkles.util.Storage;
import sparkles.util.Ui;

/**
 * Represent an unclear command.
 */
public class TaskUnclearCommand extends Command {

    public TaskUnclearCommand(String command) {
        super(command);
    }

    /**
     * Deals with user's command.
     * Executed when user input an unknown command.
     *
     * @param taskList TaskList object containing list
     *                  of tasks
     * @param ui       Ui Object that interacts with user
     * @param storage  storage object dealing with
     *                  local disk file
     * @return response to the command
     */
    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) {
        ui.print("     Task need to be more specific!");
        return "Task need to be more specific!";
    }

}
