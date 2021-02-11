import java.io.*;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will be a loser.
 * User: Listen-Y.
 * Date: 2021-02-07
 * Time: 17:25
 */
public class DemoSerialVersionUID {

    /**
     * 序列化
     * @param user
     * @throws Exception
     */
    private static void serialize(User user) throws Exception {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("D:\\test\\111.txt")));
        oos.writeObject(user);
        oos.close();
    }

    /**
     * 反序列化
     * @return
     * @throws Exception
     */
    private static User deserialize() throws Exception{
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("D:\\test\\111.txt")));
        return (User) ois.readObject();
    }


    public static void main(String[] args) throws Exception {
        User user = new User();
        user.setName("Listen");
        user.setAge(22);
        System.out.println("序列化前的结果: " + user);

        serialize(user);

        User dUser = deserialize();
        System.out.println("反序列化后的结果: "+ dUser);
    }

}
