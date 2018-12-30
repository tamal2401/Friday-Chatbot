package com.java.Friday;

import java.io.File;

public class main {

	private static final boolean TRACE_MODE = false;
	static String botName = "super";

	private static String getResourcesPath() {
		File currDir = new File(".");
		String path = currDir.getAbsolutePath();
		path = path.substring(0, path.length() - 2);
		System.out.println(path);
		String resourcesPath = path + File.separator + "src" + File.separator + "main" + File.separator + "resources";
		return resourcesPath;
	}

	public static void main(String[] args) {
		helper help = new helper();
		help.bot();
	}

}
