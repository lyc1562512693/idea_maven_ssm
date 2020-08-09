package seeDoctor;

public class Drugstore implements SeeDoctorInter {

	public Drugstore(){
		System.out.println("该去付钱了！");
	}
	@Override
	public void behavior() {
		// TODO Auto-generated method stub
		System.out.println("抓药的医生态度很好！");
	}
}
