package seeDoctor;

public class Treatment implements SeeDoctorInter {

	public Treatment(){
		System.out.println("去门诊看病治疗！");
	}
	@Override
	public void behavior() {
		// TODO Auto-generated method stub
		System.out.println("来门诊看病的人真是奇葩！");
	}
}
