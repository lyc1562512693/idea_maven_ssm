package applet.algorithm.stack;

/**
 * 数组实现栈
 */
public class MyArrayStack {
    private String[] strings;//栈元素数组
    private int count;//栈现存元素个数
    private int n;//栈大小（容量）

    public MyArrayStack(int n){//构函初始化一个大小为n的空栈
        this.strings = new String[n];
        this.count = 0;
        this.n = n;
    }
    //入栈（入到数组末尾）
    public void push(String str){
        if(count == n)
            return;
        this.strings[count++] = str;
    }
    //出栈（从末尾取出）
    public String pop(){
        if(count == 0)
            return null;
        return this.strings[--count];
    }
    public int intFunc(){
        throw new NullPointerException();
    }
}
