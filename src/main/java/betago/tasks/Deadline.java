package betago.tasks;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import betago.DukeException;

/**
 * Deadline class is a type of task where users can store their task description
 * and additional date/time information.
 */
public class Deadline extends Task {

    private String byDate;

    /**
     * Constructor for Deadline task.
     * Converts input date from the following format: "yyyy-MM-dd", "dd-MMM-yyyy", "dd/MM/yyyy"
     * into "MMM d yyyy" to be stored in the byDateTime variable.
     *
     * @param description Description of the task.
     * @param by Due date for the task.
     * @throws DukeException If date is given in the wrong format.
     */
    public Deadline(String description, String by) throws DukeException {
        super(description);
        String[] formatPatterns = {"yyyy-MM-dd", "dd-MMM-yyyy", "dd/MM/yyyy"};
        for (int i = 0; i < formatPatterns.length; i++) {
            try {
                LocalDate d = LocalDate.parse(by, DateTimeFormatter.ofPattern(formatPatterns[i]));
                this.byDate = d.format(DateTimeFormatter.ofPattern("MMM d yyyy"));
                break;
            } catch (DateTimeParseException e) {
                if (i == formatPatterns.length - 1) {
                    throw new DukeException("Please enter the date in this format:\n"
                            + "yyyy-MM-dd, dd-MMM-yyyy, dd/MM/yyyy\n");
                }
            }
        }
    }

    /**
     * Returns string representation for deadline task with due date and time.
     *
     * @return String representation for deadline task.
     */
    @Override
    public String toString() {
        return "[D][" + this.getStatusIcon() + "] " + this.getTaskDescription() + " (by: " + byDate + ")";
    }

    /**
     * Returns corresponding string representation of the deadline task that is saved in the data file.
     *
     * @return String representation for deadline task to be saved in data file.
     */
    @Override
    public String saveTask() {
        String icon;
        if (this.getStatusIcon() == "X") {
            icon = "1";
        } else {
            icon = "0";
        }
        return "D , " + icon + " , " + this.description + " , " + this.byDate + "\n";
    }
}
