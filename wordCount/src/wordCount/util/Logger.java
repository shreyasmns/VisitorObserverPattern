package wordCount.util;

public class Logger {

	public static enum debugLevels {
		CONSTRUCTOR, CLONING_TREE, UPDATING_BACKUP_TREE, RESULT
	}

	private static debugLevels level;

	/**
	 * @return the level
	 */
	public static debugLevels getDebugLevel() {
		return level;
	}

	/**
	 * @param debuglevel
	 */
	public static void setDebugLevel(int levelIn) {

		switch (levelIn) {
		case 4:
			level = debugLevels.CONSTRUCTOR;
			break;
		case 3:
			level = debugLevels.CLONING_TREE;
			break;
		case 2:
			level = debugLevels.UPDATING_BACKUP_TREE;
			break;
		case 1:
			level = debugLevels.RESULT;
			break;
		}
	}

	/**
	 * To Print the output, based on the Debug Level
	 * 
	 */
	public static void writeOutput(debugLevels levelIn, String output) {
		if (levelIn == level)
			System.out.print(output);
	}

	public static void writeOutput(String output) {
		System.out.print(output);
	}

	/**
	 * @Override toStrinng()
	 * @return String
	 */
	public String toString() {
		return "" + level;
	}
}
