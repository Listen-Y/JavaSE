import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

class Teacher {
    public String classID;//班级编号
    public String name;//姓名
    public String sex;//性别
    public String major;//主修专业
    public String teacherID;//教师编号

    public Teacher(String classID, String name, String sex, String major, String teacherID) {
        this.classID = classID;
        this.name = name;
        this.sex = sex;
        this.major = major;
        this.teacherID = teacherID;
    }

    @Override
    public String toString() {
        return classID +"," + name + "," + sex + "," + major + "," + teacherID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teacher teacher = (Teacher) o;
        return Objects.equals(classID, teacher.classID) &&
                Objects.equals(name, teacher.name) &&
                Objects.equals(sex, teacher.sex) &&
                Objects.equals(major, teacher.major) &&
                Objects.equals(teacherID, teacher.teacherID);
    }
}


class TeacherDeal {
    //通过教室编号查询代课教师
    public Teacher findTeacherByCalssID(String classID)throws IOException {
        ArrayList<Teacher> allTeacher = new ArrayList<>();
        FileReader fR = new FileReader("E:\\teacher.txt");
        BufferedReader bR = new BufferedReader(fR);
        String str = bR.readLine();
        while(str != null) {
            String[] strs = str.split(",");
            allTeacher.add(new Teacher(strs[0], strs[1],strs[2], strs[3], strs[4]));
            str = bR.readLine();
        }
        bR.close();
        fR.close();
        for(Teacher temp : allTeacher) {
            if(temp.classID.equals(classID)) {
                return temp;
            }
        }
        return null;
    }
    //通过名字查询教师
    public Teacher findTeacherByName(String name)throws IOException {
        ArrayList<Teacher> allTeacher = new ArrayList<>();
        FileReader fR = new FileReader("E:\\teacher.txt");
        BufferedReader bR = new BufferedReader(fR);
        String str = bR.readLine();
        while(str != null) {
            String[] strs = str.split(",");
            allTeacher.add(new Teacher(strs[0], strs[1],strs[2], strs[3], strs[4]));
            str = bR.readLine();
        }
        bR.close();
        fR.close();
        for(Teacher temp : allTeacher) {
            if(temp.name.equals(name)) {
                return temp;
            }
        }
        return null;
    }
    //通过性别查询教师
    public Teacher[] findTeacherBySex(String sex) throws IOException {
        ArrayList<Teacher> allTeacher = new ArrayList<>();
        FileReader fR = new FileReader("E:\\teacher.txt");
        BufferedReader bR = new BufferedReader(fR);
        String str = bR.readLine();
        while(str != null) {
            String[] strs = str.split(",");
            allTeacher.add(new Teacher(strs[0], strs[1],strs[2], strs[3], strs[4]));
            str = bR.readLine();
        }
        bR.close();
        fR.close();
        ArrayList<Teacher> result = new ArrayList<>();
        for(Teacher temp : allTeacher) {
            if(temp.sex.equals(sex)) {
                result.add(temp);
            }
        }
        return result.toArray(new Teacher[0]);
    }
    //通过主修专业查询代课教师
    public Teacher findTeacherByMajor(String major)throws IOException {
        ArrayList<Teacher> allTeacher = new ArrayList<>();
        FileReader fR = new FileReader("E:\\teacher.txt");
        BufferedReader bR = new BufferedReader(fR);
        String str = bR.readLine();
        while(str != null) {
            String[] strs = str.split(",");
            allTeacher.add(new Teacher(strs[0], strs[1],strs[2], strs[3], strs[4]));
            str = bR.readLine();
        }
        bR.close();
        fR.close();
        for(Teacher temp : allTeacher) {
            if(temp.major.equals(major)) {
                return temp;
            }
        }
        return null;
    }
    //通过教师编号查询教师
    public Teacher findTeacherByTeacherID(String teacherID) throws IOException{
        ArrayList<Teacher> allTeacher = new ArrayList<>();
        FileReader fR = new FileReader("E:\\teacher.txt");
        BufferedReader bR = new BufferedReader(fR);
        String str = bR.readLine();
        while(str != null) {
            String[] strs = str.split(",");
            allTeacher.add(new Teacher(strs[0], strs[1],strs[2], strs[3], strs[4]));
            str = bR.readLine();
        }
        bR.close();
        fR.close();
        for(Teacher temp : allTeacher) {
            if(temp.teacherID.equals(teacherID)) {
                return temp;
            }
        }
        return null;
    }
    /*//获取所有教师链表
    public ArrayList<Teacher> findAllTeacher() throws IOException{
        ArrayList<Teacher> allTeacher = new ArrayList<>();
        FileReader fR = new FileReader("E:\\teacher.txt");
        BufferedReader bR = new BufferedReader(fR);
        String str = bR.readLine();
        while(str != null) {
            String[] strs = str.split(",");
            allTeacher.add(new Teacher(strs[0], strs[1],strs[2], strs[3], strs[4]));
            str = bR.readLine();
        }
        bR.close();
        fR.close();
        return allTeacher;
    }*/
    //覆盖式读入
    /*private void writeToTXT(ArrayList<Teacher> newAllTeacher) throws IOException{
        if(newAllTeacher == null) {
            return;
        }
        FileWriter fW = new FileWriter("E:\\teacher.txt");
        BufferedWriter bW = new BufferedWriter(fW);
        for (Teacher teacher: allTeacher ) {
            String str = teacher.toString();
            bW.write(str);
            bW.newLine();
        }
        bW.close();
        fW.close();
    }*/
    //通过教师编号找打这个教师然后修改这个教师信息
    public void reviseTeacherInfor(Teacher teacher) throws IOException {
        if(teacher == null) {
            return;
        }
        ArrayList<Teacher> allTeacher = new ArrayList<>();
        FileReader fR = new FileReader("E:\\teacher.txt");
        BufferedReader bR = new BufferedReader(fR);
        String str = bR.readLine();
        while(str != null) {
            String[] strs = str.split(",");
            allTeacher.add(new Teacher(strs[0], strs[1],strs[2], strs[3], strs[4]));
            str = bR.readLine();
        }
        bR.close();
        fR.close();
        Teacher oldTeacher = findTeacherByTeacherID(teacher.teacherID);
        if(oldTeacher == null) {
            return;
        }
        /*System.out.println(allTeacher.get(0).toString());
        System.out.println(oldTeacher.toString());
        System.out.println(allTeacher);
        System.out.println(allTeacher.contains(oldTeacher));
        allTeacher.remove(oldTeacher);
        allTeacher.add(teacher);*/
        allTeacher.set(allTeacher.indexOf(oldTeacher), teacher);
        FileWriter fW = new FileWriter("E:\\teacher.txt");
        BufferedWriter bW = new BufferedWriter(fW);
        for (Teacher teacher1: allTeacher ) {
            String str1 = teacher1.toString();
            bW.write(str1);
            bW.newLine();
        }
        bW.close();
        fW.close();
    }
    //批量修改教师信息
    public void reviseTeachersInfors(Teacher[] teachers) throws IOException {
        if(teachers == null) {
            return;
        }
        for(Teacher teacher : teachers) {
            reviseTeacherInfor(teacher);
        }
    }
    //新增加教师
    public void addTeacher(Teacher teacher) throws IOException {
        if(teacher == null) {
            return;
        }
        Teacher oldTeacher = findTeacherByTeacherID(teacher.teacherID);
        if(oldTeacher != null) {
            return;
        }
        FileWriter fW = new FileWriter("E:\\teacher.txt", true);
        BufferedWriter bW = new BufferedWriter(fW);
        String str = teacher.toString();
        bW.newLine();
        bW.write(str);
        bW.close();
        fW.close();
    }
    //批量增加教师
    public void addTeachers(Teacher[] teachers) throws IOException {
        if(teachers == null) {
            return;
        }
        for(Teacher teacher : teachers) {
            addTeacher(teacher);
        }
    }
    //删除教师
    public void deleteTeacher(String teacherID) throws IOException {
        if(teacherID == null) {
            return;
        }
        ArrayList<Teacher> allTeacher = new ArrayList<>();
        FileReader fR = new FileReader("E:\\teacher.txt");
        BufferedReader bR = new BufferedReader(fR);
        String str = bR.readLine();
        while(str != null) {
            String[] strs = str.split(",");
            allTeacher.add(new Teacher(strs[0], strs[1],strs[2], strs[3], strs[4]));
            str = bR.readLine();
        }
        bR.close();
        fR.close();
        Teacher oldTeacher = findTeacherByTeacherID(teacherID);
        if(oldTeacher == null) {
            return;
        }
        //System.out.println(allTeacher.get(1).equals(oldTeacher));
        //System.out.println(allTeacher.contains(oldTeacher));
        allTeacher.remove(oldTeacher);
        FileWriter fW = new FileWriter("E:\\teacher.txt");
        BufferedWriter bW = new BufferedWriter(fW);
        for (Teacher teacher1: allTeacher ) {
            String str1 = teacher1.toString();
            bW.write(str1);
            bW.newLine();
        }
        bW.close();
        fW.close();
    }
    //批量删除教师
    public void deleteTeachers(Teacher[] teachers) throws IOException {
        if(teachers == null) {
            return;
        }
        for(Teacher teacher : teachers) {
            deleteTeacher(teacher.teacherID);
        }
    }
}


public class SchoolWork {
    public static void main(String[] args) throws IOException {
        TeacherDeal teacherDeal = new TeacherDeal();
        System.out.println("通过班级编号查询老师");
        System.out.println(teacherDeal.findTeacherByCalssID("t02"));
        System.out.println("通过名字查询老师");
        System.out.println(teacherDeal.findTeacherByName("张三"));
        System.out.println("通过性别查询老师");
        System.out.println(Arrays.toString(teacherDeal.findTeacherBySex("男")));
        System.out.println("通过主修专业查询老师");
        System.out.println(teacherDeal.findTeacherByMajor("计算机科学与技术"));
        System.out.println("通过教师编号查询老师");
        System.out.println(teacherDeal.findTeacherByTeacherID("19850401"));
        System.out.println("增加教师王五");
        teacherDeal.addTeacher(new Teacher("t03", "王五", "女", "物联网", "19800112"));
        System.out.println(teacherDeal.findTeacherByName("王五"));
        System.out.println("删除教师李四");
        teacherDeal.deleteTeacher("19820317");
        System.out.println(teacherDeal.findTeacherByName("李四"));
        System.out.println("修改教师信息 将张三改为 女 物联网专业");
        teacherDeal.reviseTeacherInfor(new Teacher("t01", "张三", "女",
                "物联网", "19850401"));
        System.out.println(teacherDeal.findTeacherByName("张三"));

    }
}

