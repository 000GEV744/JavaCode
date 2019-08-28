package saveFileDataIntoDb;

public class DbMain {

	public static void main(String[] args) {
		SaveTODb save=new SaveTODb();
		save.save("db.txt");
	}

}
