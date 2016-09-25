package csc207;

import java.util.HashMap;
import java.util.Scanner;

public class JShell {

	/**
	 * The purpose of this method is to continually ask the user for input, to
	 * check that the input is valid, to add the input to the history stack and
	 * to initialize the execution of the inputed command. As an input parameter
	 * the method takes in a list of arguments.
	 * 
	 * @param args
	 *            The list of arguments
	 */

	public static void main(String[] args) {

		Command[] commands = prepareCommands();
		FileSystem fs = new FileSystem();

		boolean exitProgram = false;

		String raw; // exact input user enters
		String clean; // input with extra spaces removed

		Scanner in = new Scanner(System.in);

		// program will continuously ask user for input until user wants to exit
		do {

			System.out.print("<" + fs.getWd() + "> ");
			raw = in.nextLine();
			clean = raw.trim().replaceAll("\\s+", " ");

			// input is not empty
			if (clean.length() > 0) {

				fs.addToHistory(raw);

				// user wishes to exit
				if (clean.matches("exit")) {
					exitProgram = true;
				} else {

					// invalid command
					if (getCmdNumber(clean) == -1) {
						System.out.println(
								getCmd(clean) + ": Command not found.");
					}

					// valid command - calls command and prints out the output
					else {
						fs = commands[getCmdNumber(clean)].executeCommand(fs,
								getArg(clean));

						if (fs.getOutput().length() > 0) {
							System.out.print(fs.getOutput());
						}
					}
				}
			}

		} while (!exitProgram);

		in.close();

	}

	private static int getCmdNumber(String cleanedInput) {

		HashMap<String, Integer> commandMap = prepareCommandMap();
		String command = getCmd(cleanedInput);
		int commandNumber = -1;

		// finds which of the commands the entered command matches with
		for (String c : commandMap.keySet()) {
			if (command.equals(c)) {
				commandNumber = commandMap.get(c);
				break;
			}
		}

		return commandNumber;
	}

	private static String getCmd(String cleanedInput) {

		int locationOfSpace = cleanedInput.indexOf(" ");

		if (locationOfSpace == -1) {
			return cleanedInput;
		} else {
			return cleanedInput.substring(0, locationOfSpace);
		}
	}

	private static String getArg(String cleanedInput) {
		int locationOfSpace = cleanedInput.indexOf(" ");

		if (locationOfSpace == -1) {
			return "";
		} else {
			return cleanedInput.substring(locationOfSpace + 1);
		}
	}

	// prepares the command objects
	private static Command[] prepareCommands() {

		Command[] commands = new Command[10];

		commands[0] = new PrintHistory();
		commands[1] = new PrintWorkingDirectory();
		commands[2] = new PopDirectory();
		commands[3] = new PushDirectory();
		commands[4] = new Manual();
		commands[5] = new MakeDirectory();
		commands[6] = new ChangeDirectory();
		commands[7] = new ListContents();
		commands[8] = new DisplayContents();
		commands[9] = new Echo();

		return commands;
	}

	private static HashMap<String, Integer> prepareCommandMap() {

		HashMap<String, Integer> commandMap = new HashMap<String, Integer>();

		commandMap.put("history", 0);
		commandMap.put("pwd", 1);
		commandMap.put("popd", 2);
		commandMap.put("pushd", 3);
		commandMap.put("man", 4);
		commandMap.put("mkdir", 5);
		commandMap.put("cd", 6);
		commandMap.put("ls", 7);
		commandMap.put("cat", 8);
		commandMap.put("echo", 9);

		return commandMap;
	}

}
