/**
 *
 * 异常
 */

import java.util.Scanner;

class UserNameException extends Exception {
    public UserNameException(String message) {
        super(message);
    }
}

class PasswardException extends Exception {
    public PasswardException(String message) {
        super(message);
    }
}

public class Test {

    private static final String name = "listen";
    private static final String admiPassward = "123456";

    public static void begin(String userName, String passward) throws UserNameException, PasswardException {
        if( ! userName.equals(name)) {
            throw new UserNameException("用户名错误");
        }
        if( ! passward.equals(admiPassward)) {
            throw new PasswardException("密码错误");
        }
        System.out.println("登录成功!!!");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入用户名：》");
        String userName = scanner.next();
        System.out.println("输入密码");
        String passward = scanner.next();
        try {
            begin(userName, passward);
        }catch (UserNameException | PasswardException e) {
            System.out.println(e.getMessage());
        }

    }
}
