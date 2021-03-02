import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class EncodeTest {

    public static void main(String[] args) throws UnsupportedEncodingException {
        /**
         * encode就是将特殊字符转换为%XY形式， XY表示16进制， 特殊字符就是除了26个英文字母和 . 之外
         *
         * decode就与encode相反， 他将%XY形式的转换为特殊字符
         */
        System.out.println(URLEncoder.encode("This string has spaces","UTF-8"));
        System.out.println(URLEncoder.encode("This*string*has*哈哈","UTF-8"));
        System.out.println(URLEncoder.encode("This%string%has%percent%signs", "UTF-8"));
        System.out.println(URLEncoder.encode("This+string+has+pluses","UTF-8"));
        System.out.println(URLEncoder.encode("This/string/has/slashes","UTF-8"));
        System.out.println(URLEncoder.encode("This"+"has"+"marks", "UTF-8"));
        System.out.println(URLEncoder.encode("This:string:has:colons","UTF-8"));
        System.out.println(URLEncoder.encode("This~string~has~tildes","UTF-8"));
        System.out.println(URLEncoder.encode("This(string)has(parentheses)", "UTF-8"));
        System.out.println(URLEncoder.encode("This.string.has.periods","UTF-8"));
        System.out.println(URLEncoder.encode("This=string=has=equals=signs", "UTF-8"));
        System.out.println(URLEncoder.encode("This&string&has&ersands","UTF-8"));
        System.out.println(URLEncoder.encode("Thiséstringéhasé non-ASCII characters",
                "UTF-8"));

    }
}
