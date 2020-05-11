import java.io.*;

import java.util.ArrayList;

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


public class TeacherDeal {
    //获取所有教师链表
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
    }
    //覆盖式读入
    private void writeToTxT(ArrayList<Teacher> newAllTeacher) throws IOException{
        if(newAllTeacher == null) {
            return;
        }
        FileWriter fW = new FileWriter("E:\\teacher.txt");
        BufferedWriter bW = new BufferedWriter(fW);
        for (Teacher teacher: newAllTeacher ) {
            String str = teacher.toString();
            bW.write(str);
            bW.newLine();
        }
        bW.close();
        fW.close();
    }
    //通过教室编号查询代课教师
    public Teacher findTeacherByCalssID(String classID)throws IOException {
        ArrayList<Teacher> allTeacher = findAllTeacher();
        for(Teacher temp : allTeacher) {
            if(temp.classID.equals(classID)) {
                return temp;
            }
        }
        return null;
    }
    //通过名字查询教师
    public Teacher findTeacherByName(String name)throws IOException {
        ArrayList<Teacher> allTeacher = findAllTeacher();
        for(Teacher temp : allTeacher) {
            if(temp.name.equals(name)) {
                return temp;
            }
        }
        return null;
    }
    //通过性别查询教师
    public Teacher[] findTeacherBySex(String sex) throws IOException {
        ArrayList<Teacher> allTeacher = findAllTeacher();
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
        ArrayList<Teacher> allTeacher = findAllTeacher();
        for(Teacher temp : allTeacher) {
            if(temp.major.equals(major)) {
                return temp;
            }
        }
        return null;
    }
    //通过教师编号查询教师
    public Teacher findTeacherByTeacherID(String teacherID) throws IOException{
        ArrayList<Teacher> allTeacher = findAllTeacher();
        for(Teacher temp : allTeacher) {
            if(temp.teacherID.equals(teacherID)) {
                return temp;
            }
        }
        return null;
    }
    //通过教师编号找打这个教师然后修改这个教师信息
    public void reviseTeacherInfor(Teacher teacher) throws IOException {
        if(teacher == null) {
            return;
        }
        ArrayList<Teacher> allTeacher = findAllTeacher();
        Teacher oldTeacher = findTeacherByTeacherID(teacher.teacherID);
        if(oldTeacher == null) {
            return;
        }
        allTeacher.set(allTeacher.indexOf(oldTeacher), teacher);
        writeToTxT(allTeacher);
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
        ArrayList<Teacher> allTeacher = findAllTeacher();
        Teacher oldTeacher = findTeacherByTeacherID(teacherID);
        if(oldTeacher == null) {
            return;
        }
        allTeacher.remove(oldTeacher);
        writeToTxT(allTeacher);
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