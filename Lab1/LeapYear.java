public class LeapYear {
	public static boolean isLeapYear(int year){
		if((year % 400 == 0) || (year % 4 == 0 && year % 100 != 0)){
			return true;
		}else{
			return false;
		}
	}

	public static void main(String[] args){
		if(isLeapYear(Integer.valueOf(args[0]))){
			System.out.println(args[0] + " is a leap year");
		}else{
			System.out.println(args[0] + "is not a leap year");
		}
	}
}