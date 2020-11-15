package myThread.singleTon;

public class SingleEnum {
    enum singtonClass{
        singleTon;
        private  SingleEnum singleEnum;
            private singtonClass(){
            singleEnum = new SingleEnum();
        }
        public SingleEnum getSingleEnum(){
            return singleEnum;
        }
    }
    public static SingleEnum getSingleEnum(){
        return singtonClass.singleTon.getSingleEnum();
    }
}
