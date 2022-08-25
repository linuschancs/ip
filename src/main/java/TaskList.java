
import java.util.ArrayList;

public class TaskList {
    protected ArrayList<Task> list;

    public TaskList() {
        this.list = new ArrayList<>();
    }

    public void listItems() throws EmptyListException {
        if (list.size() == 0) {
            throw new EmptyListException("There are no items in the list.");
        }
        System.out.print("Here are the tasks in your list:\n");
        for (int i = 0; i < this.list.size(); i++) {
            System.out.print(i+1);
            System.out.println(". " + this.list.get(i).toString());
        }
        System.out.print("\n");
    }

    public void markUnmarkItems(String str) throws InvalidCommandException {
        String[] inputs = str.split(" ", 2);
        if (inputs.length != 2) {
            throw new InvalidCommandException("No task number indicated.");
        } else {
            try{
                int marker = Integer.valueOf(inputs[1]);
                if (marker < 1 || marker > this.list.size()) {
                    System.out.println("Please indicate a valid task number!\n");
                } else if (inputs[0].equalsIgnoreCase("mark")){
                    this.list.get(marker - 1).markAsDone();
                } else {
                    this.list.get(marker - 1).markAsNotDone();
                }
            }
            catch (NumberFormatException ex){
                throw new InvalidCommandException("Invalid item to be marked.");
            }
        }
    }

    public void addTodo(String str) throws InvalidCommandException{
        String[] inputs = str.split(" ", 2);
        if (inputs.length != 2) {
            throw new InvalidCommandException("No description stated.");
        } else {
            Todo temp = new Todo(inputs[1]);
            this.list.add(temp);
            System.out.println("Got it. I've added this Todo task:\n" + temp.toString());
            System.out.println("Now you have " + this.list.size() + " tasks in the list.\n");
        }
    }

    public void addDeadline(String str) throws InvalidCommandException {
        String[] inputs = str.split(" ", 2);
        if (inputs.length != 2) {
            throw new InvalidCommandException("No description stated.");
        } else {
            String[] when = inputs[1].split(" /by ", 2);
            if (when.length != 2) {
                throw new InvalidCommandException("No deadline stated.");
            } else {
                try {
                    Deadline temp = new Deadline(when[0], when[1]);
                    this.list.add(temp);
                    System.out.println("Got it. I've added this Deadline task:\n" + temp.toString());
                    System.out.println("Now you have " + this.list.size() + " tasks in the list.\n");
                } catch (InvalidCommandException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    }

    public void addEvent(String str) throws InvalidCommandException {
        String[] inputs = str.split(" ", 2);
        if (inputs.length != 2) {
            throw new InvalidCommandException("No description stated.");
        } else {
            String[] where = inputs[1].split(" /at ", 2);
            if (where.length != 2) {
                throw new InvalidCommandException("No location of event stated.");
            } else {
                Event temp = new Event(where[0], where[1]);
                this.list.add(temp);
                System.out.println("Got it. I've added this Event task:\n" + temp.toString());
                System.out.println("Now you have " + this.list.size() + " tasks in the list.\n");
            }
        }
    }

    public void deleteItems(String str) throws InvalidCommandException {
        String[] inputs = str.split(" ", 2);
        if (inputs.length != 2) {
            throw new InvalidCommandException("No task number indicated.");
        } else {
            try{
                int marker = Integer.valueOf(inputs[1]);
                if (marker < 1 || marker > this.list.size()) {
                    System.out.println("Please indicate a valid task number!\n");
                }  else {
                    System.out.println("Noted. I have removed this task:\n" + this.list.get(marker - 1).toString());
                    this.list.remove(marker - 1);
                    System.out.println("Now you have " + this.list.size() + " tasks in the list.\n");
                }
            }
            catch (NumberFormatException ex){
                throw new InvalidCommandException("Invalid item to be marked.");
            }
        }
    }
}
