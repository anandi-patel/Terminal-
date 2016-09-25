package csc207;

import java.util.ArrayList;

/**
 * Modifies a filesystem's current working directory with whatever is on the top
 * of the directory stack
 */
public class PopDirectory extends Command {

	/**
	 * Class constructor
	 */
	public PopDirectory() {

	}

	/**
	 * Modifies the current working directory to whatever is on the top of the
	 * directory stack.
	 * 
	 * @param fs
	 *            The fileSystem to be modified.
	 * @param arguments
	 *            The arguments entered in by the user.
	 * @return The modified fileSystem.
	 */
	public FileSystem executeCommand(FileSystem fs, String arguments) {

		String output = "";

		// correct number of arguments
		if (getArgumentNumber(arguments) == 0) {

			// directory stack is empty - raises error
			if (fs.getStackSize() == 0) {
				output = this.getErrorMessage(arguments, 1);
			} else {
				fs.setWd(fs.getFromStack());
			}
		}

		// incorrect number of arguments - raises error
		else {
			output = this.getErrorMessage(arguments, 0);
		}

		fs.setOutput(output);
		return fs;
	}
	
	//returns requested error message.
	private String getErrorMessage(String arguments, int errorNumber) {
		
		ArrayList<String> errors = new ArrayList<String>();
		
		errors.add("Error: The 'popd' command does not accept any commands. "
				+ "You've entered " + getArgumentNumber(arguments)
				+ " argument(s).\n");
		errors.add(
				"Error: The directory stack is empty so nothing can be "
				+ "popped.\n");

		return errors.get(errorNumber);
	}
}
