package csc207;

import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * modifies a fileSystem object by modifying its output into the last n commands
 * the user has entered into jShell. Returns an error if there is an incorrect
 * argument.
 */
public class PrintHistory extends Command {

	Pattern p;

	/**
	 * Class constructor.
	 */
	public PrintHistory() {
		p = Pattern.compile("\\d+");
	}

	/**
	 * Modifies the filesystem output into a listing of the last n commands or
	 * an error if needed.
	 * 
	 * @param fs
	 *            The FileSystem object that is being modified
	 * @param arguments
	 *            The arguments for the command that were entered.
	 * @return Returns the modified filesystem.
	 */
	public FileSystem executeCommand(FileSystem fs, String arguments) {

		String output = "";

		// optional argument not entered
		if (getArgumentNumber(arguments) == 0) {
			List<String> history = fs.getHistory(fs.getHistorySize());
			for (int i = history.size() - 1; i >= 0; i--) {
				output = output.concat(history.get(i) + "\n");
			}
		}

		// optional argument entered
		else if (getArgumentNumber(arguments) == 1) {

			output = this.optionalArgEntered(fs, arguments);
		}

		// more than 1 argument entered
		else {
			output = this.getErrorMessage(arguments, 0);
		}

		fs.setOutput(output);
		return fs;
	}

	// executes the command when the user enters in an argument
	private String optionalArgEntered(FileSystem fs, String arguments) {

		String output = "";

		// correct optional argument
		if (arguments.matches("\\d+")) {

			// finds the n value (the number of commands the user wants to see)
			Matcher m = p.matcher(arguments);
			m.find();
			int number = Math.min(Integer.parseInt(m.group(0)),
					fs.getHistorySize());

			// determines the output
			List<String> history = fs.getHistory(number);
			for (int i = number - 1; i >= 0; i--) {
				output = output.concat(history.get(i) + "\n");
			}
		}

		// incorrect optional argument
		else {
			output = this.getErrorMessage(arguments, 1);
		}

		return output;
	}

	// returns an appropriate error
	private String getErrorMessage(String arguments, int errorNumber) {

		ArrayList<String> errors = new ArrayList<String>();
		errors.add("Error: The 'history' command only accepts a maximum of 1 "
				+ "argument. You've entered " + getArgumentNumber(arguments)
				+ " arguments. \n");
		errors.add("Error: The 'history' command only accepts one optional "
				+ "argument "
				+ "of the form 'x', where x is some number. You've entered '"
				+ arguments + "'.\n");

		return errors.get(errorNumber);
	}

}
