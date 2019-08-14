package num.example;

public class Test {

	private Day day;

	public Test(Day day) {
		this.day = day;
	}
	
	public void dayIsLike() {
		switch(day) {
		case MONDAY:
			System.out.println("Mondays are bad");
			break;
		case FRIDAY:
			System.out.println("Fridays are better");
			break;
		case SATURDAY:
		case SUNDAY:	
			System.out.println("weekends are best");
			break;
			default:
				System.out.println("weekdays are so and so");
		}
	}
}
