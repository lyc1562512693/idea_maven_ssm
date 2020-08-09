package seeDoctor;

public class Facade {

	//private String action;
	
	public void goToHospital(String action){
		SeeDoctorInter sDI ;
		switch(action){
			case "注册": sDI=new Register();
			break;
			case "门诊": sDI=new Treatment();
			break;
			case "抓药": sDI=new Drugstore();
			break;
			case "付钱": sDI=new Payment();
			break;
			default: sDI=null;
		}
		if(sDI!=null){
			sDI.behavior();
		}else{
			System.out.println("不看病来医院干什么");
		}
		//return sDI;
	}
}
