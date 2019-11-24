package lw;

public class T1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grade =77;
		if(grade==100) {
			System.out.println("奖励一辆BMW");
		}else if(grade>80 && grade<=99) {
			System.out.println("奖励一台iPhone5");
		}else if(grade>60 && grade<=80) {
			System.out.println("奖励一本参考书");
		}else {
			System.out.println("什么奖励都没有");
		}
	}

}
