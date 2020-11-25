package zhengzhe;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TopDomainUtil {

	private Pattern pattern;

    private static final String RE_TOP = "(\\w*\\.?){1}\\.(com.cn|net.cn|gov.cn|org\\.nz|org.cn|com|net|org|gov|cc|biz|info|cn|co)\\b()*";

    public TopDomainUtil() {
        pattern = Pattern.compile(RE_TOP , Pattern.CASE_INSENSITIVE);
    }
 
 
    public String getTopDomain(String url) {
        String result = url;
        try {
            Matcher matcher = this.pattern.matcher(url);
            matcher.find();
            result = matcher.group();
        } catch (Exception e) {
            System.out.println("[getTopDomain ERROR]====>");
            e.printStackTrace();
        }
        return result;
    }
 
 
    public static void main(String[] args) {
        TopDomainUtil obj = new TopDomainUtil();
 
        // ʾ��
        String url = "www.baidu.cc";
        String res1 = obj.getTopDomain(url);
        System.out.println(url + " ==> " + res1);
 
        url = "ac.asd.c.sina.com.cn";
        String res2 = obj.getTopDomain(url);
        System.out.println(url + " ==> " + res2);
 
        url = "whois.chinaz.com/reverse?ddlSearchMode=1www.huya.com213www.tx.com";
        String res3 = obj.getTopDomain(url);
        System.out.println(url + " ==> " + res3);
 
        url = "http://write.blog.csdn.net/";
        String res4 = obj.getTopDomain(url);
        System.out.println(url + " ==> " + res4);
 
        url = "http://write.test.org.nz/";
        String res5 = obj.getTopDomain(url);
        System.out.println(url + " ==> " + res5);
        
        url = "";
        String res6 = obj.getTopDomain(url);
        System.out.println(url + " ==> " + res6);
        
    } 
}
