package sparkles.command.addcommand;

import sparkles.SparklesException;
import sparkles.command.Command;
import sparkles.task.Event;
import sparkles.task.Task;
import sparkles.task.TaskList;
import sparkles.util.Storage;
import sparkles.util.Ui;

/**
 * Represents an AddEventCommand.
 */
public class AddEventCommand extends Command {

    public AddEventCommand(String command) {
        super(command);
    }

    /**
     * Deals with user's command
     * Add the event to the TaskList and
     * local disk file.
     *
     * @param taskList TaskList object containing list
     *                  of tasks
     * @param ui       Ui Object that interacts with user
     * @param storage  storage object dealing with
     *                  local disk file
     * @return response to the command
     * @throws SparklesException that handles exception of Sparkles
     *                           such as StringIndexOutOfBoundsException
     *                           or ArrayIndexOutOfBoundsException
     */
    @Override
    public String execute(TaskList taskList, Ui ui, Storage storage) throws SparklesException {
        String[] arr = command.split(" /at ");

        String desc;
        String at;
        String response;
        Task task;

        try {
            desc = arr[0].substring(6).trim();
            at = arr[1];
            task = new Event(desc, at);
            ui.print("     Got it. I've added this task");
            response = "Got it. I've added this task\n";
            response += task.printTask().trim() + "\n";

            taskList.add(task);
            response += ui.showListSize(taskList.getListSize());
        } catch (Exception ex) {
            throw new SparklesException("     OOPS!! The description and time of an Event cannot be empty!");
        } finally {
            storage.updateFile(taskList.getStorage());
        }
        return response;
    }
}
