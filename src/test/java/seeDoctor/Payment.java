package seeDoctor;

public class Payment implements SeeDoctorInter {

	public Payment(){
		System.out.println("看完病该付钱了！");
	}
	@Override
	public void behavior() {
		// TODO Auto-generated method stub
		System.out.println("哇，看病好贵，下个月要吃土了！");
	}

}
