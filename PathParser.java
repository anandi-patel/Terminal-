package csc207;

import java.util.ArrayList;
import java.util.List;

public class PathParser {

	public static List<String> parsePath(String path, String wd) {
		// user entered absolute path
		if (path.substring(0, 1).equalsIgnoreCase("/")) {
			System.out.println("yay, absolute path");
			return absolutePath(path);
		}

		// user entered relative path
		else {
			//System.out.println("yay, relative path");
			String[] parts = wd.split("/");

		}
		return null;

	}

	// parses an absolute path
	private static List<String> absolutePath(String path) {

		ArrayList<String> finalPath = new ArrayList<String>();

		String[] parts = path.substring(1).split("/");

		// loops over the parts of the path individually
		for (int i = 0; i < parts.length; i++) {
			
			//responds to the .. command
			if (parts[i] == "..") {
				if (!finalPath.isEmpty()) {
					finalPath.remove(finalPath.size() - 1);
				}
			} else {
				finalPath.add(parts[i]);
			}
		}
		
		return finalPath;
	}

	private static List<String> relativePath(String path, String current) {
		return absolutePath(current + "/" + path);
	}
}
