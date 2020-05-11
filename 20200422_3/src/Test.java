import java.io.IOException;
import java.util.Arrays;

public class Test {
    public static void main(String[] args) throws IOException, IOException {
        TeacherDeal teacherDeal = new TeacherDeal();
        System.out.println("===通过班级编号查询老师===");
        System.out.println(teacherDeal.findTeacherByCalssID("t02"));
        System.out.println("===通过名字查询老师===");
        System.out.println(teacherDeal.findTeacherByName("张三"));
        System.out.println("===通过性别查询老师===");
        System.out.println(Arrays.toString(teacherDeal.findTeacherBySex("男")));
        System.out.println("===通过主修专业查询老师===");
        System.out.println(teacherDeal.findTeacherByMajor("计算机科学与技术"));
        System.out.println("===通过教师编号查询老师===");
        System.out.println(teacherDeal.findTeacherByTeacherID("19850401"));
        System.out.println("===增加教师王五===");
        teacherDeal.addTeacher(new Teacher("t03", "王五", "女", "物联网", "19800112"));
        System.out.println(teacherDeal.findTeacherByName("王五"));
        System.out.println("===删除教师李四===");
        teacherDeal.deleteTeacher("19820317");
        System.out.println(teacherDeal.findTeacherByName("李四"));
        System.out.println("===修改教师信息 将张三改为 女 物联网专业===");
        teacherDeal.reviseTeacherInfor(new Teacher("t01", "张三", "女", "物联网", "19850401"));
        System.out.println(teacherDeal.findTeacherByName("张三"));
        System.out.println("===通过性别查询老师===");
        System.out.println(Arrays.toString(teacherDeal.findTeacherBySex("女")));

    }
}

