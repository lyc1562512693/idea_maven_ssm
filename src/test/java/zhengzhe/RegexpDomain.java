package zhengzhe;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexpDomain {
    //仅匹配一个url,该正则对matchers()不生效，需要使用find()
    //private static final Pattern TOP_DOMAIN = Pattern.compile("(\\w*\\.?){1}\\.(com.cn|net.cn|gov.cn|org\\.nz|org.cn|com|net|org|gov|cc|biz|info|cn|co)\\b()*", Pattern.CASE_INSENSITIVE);
    //可一匹配多个,该正则对matchers()不生效，需要使用find()
    private static final Pattern TOP_DOMAIN_ALL = Pattern.compile("(\\w*\\.?){1}\\.(com.cn|net.cn|gov.cn|org\\.nz|org.cn|com|net|org|gov|cc|biz|info|cn|co)", Pattern.CASE_INSENSITIVE);
    private static final Pattern WORD = Pattern.compile("[a-z]+", Pattern.CASE_INSENSITIVE);

    /**
     * 必须全匹配
     * @param domain
     * @return
     */
    public static boolean isTopDomain(String domain){
        return TOP_DOMAIN_ALL.matcher(domain).matches();
    }

    /**
     * 部分匹配
     * @param domain
     * @return
     */
    public static boolean isContainTopDomain(String domain){
        return TOP_DOMAIN_ALL.matcher(domain).find();
    }
    public static boolean isWord(String name){
        return WORD.matcher(name).matches();
    }

    /**
     * 切割匹配项第一个
     * @param domain
     * @return
     */
    public static String splitTopDomain(String domain){
        Matcher matcher = TOP_DOMAIN_ALL.matcher(domain);
        if(matcher.find()){
            return matcher.group();//group之前，必须要用对应的matcher进行find
        }
        throw new IllegalStateException();
    }

    /**
     * 切割所有
     * @param domain
     * @return
     */
    public static List<String> splitTopDomainAll(String domain){
        Matcher matcher = TOP_DOMAIN_ALL.matcher(domain);
        if (matcher.find()) {
            List<String> domains = new ArrayList<>();
            while(matcher.find()){
                domains.add(matcher.group());
            }
            return domains;
        }
        throw new IllegalStateException();
    }


}
