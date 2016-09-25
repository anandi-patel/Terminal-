package csc207;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Directory {

	String name;
	ArrayList<Directory> directories;
	ArrayList<File> files;

	// constructor
	public Directory(String name) {
		this.directories = new ArrayList<Directory>();
		this.files = new ArrayList<File>();
		this.name = name;
	}

	public void makeDirectory(List<String> path) {
		if (path.size() == 1) {
			directories.add(new Directory(path.get(0)));
			// System.out.println("yay");
			// System.out.println(this.directories.size());
		} else {
			// System.out.println("yay");
			int child = -1;
			for (int i = 0; i < this.directories.size(); i++) {
				if (path.get(0)
						.equalsIgnoreCase(this.directories.get(i).getName())) {
					// System.out.println(this.directories.get(i).getName());
					child = i;
					break;
				}
			}
			if (child == -1) {
				System.out.println("invalid path");
			} else {
				List<String> newPath = path.subList(1, path.size());
				this.directories.get(child).makeDirectory(newPath);
			}
		}
	}

	public boolean pathExists(List<String> path) {

		int childIndex = this.determineChildDirectoryIndex(path.get(0));
		if (path.size() == 1) {
			if (childIndex == -1) {
				return false;
			} else {
				return true;
			}
		} else {
			if (childIndex == -1) {
				return false;
			} else {
				List<String> newPath = path.subList(1, path.size());
				return this.directories.get(childIndex).pathExists(newPath);
			}
		}
	}

	private int determineChildDirectoryIndex(String name) {
		int childIndex = -1;
		for (int i = 0; i < this.directories.size(); i++) {
			if (name.equalsIgnoreCase(this.directories.get(i).getName())) {
				// System.out.println(this.directories.get(i).getName());
				childIndex = i;
				break;
			}
		}
		return childIndex;
	}

	public void list(List<String> path) {
		for (int i = 0; i < this.directories.size(); i++) {
			System.out.println(this.directories.get(i).getName());
			this.directories.get(i).list(path);
		}
		/*
		 * if (path.size() == 0){ for (int i = 0; i
		 * <this.directories.size();i++){
		 * System.out.println(this.directories.get(i).getName()); } for (int i =
		 * 0; i <this.files.size();i++){ System.out.println(this.files.get(i));
		 * } } else{ int child = 0; for (int i = 0; i<this.directories.size();
		 * i++){ if
		 * (path.get(0).equalsIgnoreCase(this.directories.get(i).getName())){
		 * System.out.println(this.directories.get(i).getName()); child = i;
		 * break; } } List<String> newPath = path.subList(1, path.size());
		 * this.directories.get(child).list(newPath); }
		 */

	}

	public String getName() {
		return this.name;
	}

	public void makeFile(String name) {

	}

}
