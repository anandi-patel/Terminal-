package csc207;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Modifies a filesystem's output with documentation for a command.
 */
public class Manual extends Command {

	private HashMap<String, String> manual;

	/**
	 * Class constructor
	 */
	public Manual() {
		manual = new HashMap<String, String>();
		this.prepareManual();
	}

	/**
	 * Modifies the filesystem's output with the documentation for a command or
	 * an error if needed.
	 * 
	 * @param fs
	 *            The FileSystem to be modified.
	 * @param arguments
	 *            The arguments entered by the user.
	 * @return The modified filesystem object.
	 */
	public FileSystem executeCommand(FileSystem fs, String arguments) {
		String output = "";

		// correct number of arguments
		if (getArgumentNumber(arguments) == 1) {
			output = this.manual.get(arguments);

			// command not found in manual
			if (output == null) {
				output = this.getErrorMessage(arguments, 1);
			} else {
				output += "\n";
			}
		}

		// incorrect number of arguments
		else {
			output = this.getErrorMessage(arguments, 0);
		}

		fs.setOutput(output);
		return fs;
	}

	// provides appropriate error messages
	private String getErrorMessage(String arguments, int errorNumber) {
		ArrayList<String> errors = new ArrayList<String>();
		errors.add(
				"Error: The 'manual' command needs 1 argument. You've entered "
						+ getArgumentNumber(arguments) + " arguments. \n");
		errors.add("Error: The '" + arguments
				+ "' command could not be found in the manual.\n");

		return errors.get(errorNumber);
	}

	// Description of the commands
	private void prepareManual() {
		this.manual.put("exit", "Quits the program.");
		this.manual.put("mkdir", "Creates a directory");
		this.manual.put("cd",
				"Changes the current working directory to the given directory"
				+ " name.");
		this.manual.put("ls",
				"If there is no path given, then a list of the contents of the "
				+ "current working directory is given."
						+ "If there is a path given, then it prints a list of "
						+ "the contents of the specified directory.");
		this.manual.put("pwd", "Print current directory path;");
		this.manual.put("pushd", "Saves the current directory specified;");
		this.manual.put("popd", "Deletes the latest saved directory.");
		this.manual.put("history", "Prints out the previous commands entered."
				+ "The number specified is the number of previous commands "
				+ "printed started from the latest command entered.");
		this.manual.put("cat",
				"Displays the contents of the file on the shell.");
		this.manual.put("echo",
				"If there is no file name given, then the string given is "
				+ "printed on the shell."
						+ "The file consists the given string.");
		this.manual.put("man",
				"Formats and displays the annual pages on the given command.");

	}

}
