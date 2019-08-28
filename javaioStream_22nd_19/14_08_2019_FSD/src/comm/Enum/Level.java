package comm.Enum;

public enum Level {

	HIGH(3),
	LOW(2),
	MEDIUM(1);
	private int levelCode;
	private Level(int levelCode) {
		this.levelCode=levelCode;
	}
	private int getLevelCode() {
		return levelCode;
	}
	
	
}
