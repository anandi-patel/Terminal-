package csc207;

import java.util.List;
import java.util.ArrayList;

public class MakeDirectory extends Command {

	public MakeDirectory() {
	}

	/**
	 * The purpose of this method is to display the actions that the user has
	 * made. As input parameters the function takes in a FileSystem object and
	 * the arguments. It returns the FileSystem object.
	 * 
	 * @param fs
	 *            The FilseSystem object
	 * @param arguments
	 *            The number of arguments a user has entered
	 */

	public FileSystem executeCommand(FileSystem fs, String arguments) {

		String output = "";

		// no arguments given
		if (getArgumentNumber(arguments) == 0) {
			output = this.getErrorMessage(arguments, 0);
		} else {
			String[] paths = this.getArgs(arguments);
			for (String path : paths) {

				// paths uses valid characters
				if (path.matches(this.validChar)) {
					List<String> pathParts = PathParser.parsePath(path,
							fs.getWd());
					if (fs.pathExists(pathParts.subList(0, pathParts.size()))) {
						fs.mkdir(pathParts);
					}
				}

				// invalid characters used
				else {
					output += this.getErrorMessage(path, 1);
				}
			}

		}
		
		fs.list(PathParser.parsePath("/blah", ""));

		fs.setOutput(output);
		return fs;
	}

	/**
	 * The purpose of this method is to determine the number of arguments that
	 * the user has given. The input parameter it takes in is the arguments the
	 * user has entered. The function returns the number of arguments that the
	 * user has entered.
	 * 
	 * @param arguments
	 *            The number of arguments a user has entered
	 */

	protected String getErrorMessage(String arguments, int errorNumber) {

		ArrayList<String> errors = new ArrayList<String>();
		errors.add(
				"Error: The 'mkdir' command needs atleast 1 argument. You've entered "
						+ getArgumentNumber(arguments) + " arguments.\n");
		errors.add("Error: '" + arguments
				+ "' is an invalid path. Characters including"
				+ " \"!@$&*()?:[]\"<>'`|={}\\/\" are not allowed in paths.\n");

		return errors.get(errorNumber);
	}

}
