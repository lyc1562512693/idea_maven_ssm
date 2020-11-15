package applet.algorithm.stack;


import java.util.Stack;

public class StackUtils {
    public static void main(String[] args) {
        Boolean isBrackets = checkBrackets("{[[(q{qw})]dd]}");
        System.out.println("该括号是否合法：" + isBrackets);
    }

    /**
     * 校验括号是否匹配
     * @param brackets
     * @return
     */
    public static Boolean checkBrackets(String brackets){
        char[] arr = brackets.toCharArray();
        MyArrayStack stack = new MyArrayStack(100);
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == '{' || arr[i] == '[' || arr[i] == '('){//遇到左括号直接压入栈顶
                stack.push(String.valueOf(arr[i]));
            }
            if(arr[i] == '}' || arr[i] == ']' || arr[i] == ')'){//遇到右括号，如果栈为空，则直接不合法，不为空则取出栈顶元素，不能匹配则直接不合法，否则继续下一个字符判断
                String ceil = stack.pop();
                if(ceil == null){//如果此时栈为空，则返回false
                    return false;
                }
                if(arr[i] == '}'){
                   if(!"{".equals(ceil))
                       return false;
                }else if(arr[i] == ']'){
                    if(!"[".equals(ceil))
                        return false;
                }else{
                    if(!"(".equals(ceil))
                        return false;
                }
            }
        }
        if(stack.pop() != null){//如果遍历完成栈不为空，则直接不合法
            return false;
        }
        return true;//走到这，说明字符串遍历完了，栈也为空，则合法
    }
}
