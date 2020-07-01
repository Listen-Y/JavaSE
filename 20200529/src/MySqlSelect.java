create table test (
        id int primary key auto_increment,
        name varchar(20) unique
        );

        create table test (
        id int primary key,
        name varchar(20) unique
        );

        create table test (
        id int not null,
        name varchar(20) unique
        );

        create table test (
        id int not null,
        name varchar(20) default 'unknow'
        );

        create table class (
        id int primary key auto_increment,
        name varchar(20)
        );

        create table student (
        id int primary key auto_increment,
        name varchar(20),
        classId int, foreign key (classId) references class(id)
        );

        mysql> insert into exam (id) select id from class;

create table class (
        id int primary key,
        name varchar(20) not null
        );

        create table student (
        id int primary key,
        name varchar(20) not null,
        email varchar(20) default 'unknow',
        QQ varchar(20) unique,
        classId int ,
        foreign key (classId) references class(id)
        );


        create table test_student (
        id int primary key,
        name varchar(10) default 'unknow'
        );

        create table test_course (
        id int primary key,
        name varchar(20) default 'unknow'
        );

        create table test_score (
        studentId int,
        courseId int,
        score int,
        foreign key (studentId) references test_student(id),
        foreign key (courseId) references test_course(id)
        );

        select score from test_score, test_student, test_course where studentId = select id from test_student where name = 'listen' and courseId = select id from test_course where name = '语文' ;

        select score from test_score, test_student, test_course where test_student.name =


        create table test (
        id int,
        name varchar(20) default 'null'
        );


        create table test (
        id int,
        name varchar(20)
        );


        create table emp (
        id int primary key auto_increment,
        name varchar(20),
        role varchar(20),
        salary decimal(7, 2)
        );



        mysql> select student.id, student.name, score.student_id, sum(score.score) as totle from student, score where student.id = score.student_id group by student.id;


        mysql> select student.id as student_id, student.name, course.id as course_id, course.name, score.student_id, score.course_id, score.score from student, course, score where student.id = score.student_id and course.id = score.course_id;


        select student.id, student.name, coure.name, score.score as score from student, course,


        select student.id, student.name, course.name, sum(score.score) as totle from student, course, score where student.id = score.student_id and course.id = score.course_id group by student.name;

        1.看要查的数据需要那些表
        2.将表连接起来,用连接条件去掉废物数据
        3.再按需求进行处理



        mysql> select student.id, student.name, score.score from student left join score on student.id = score.student_id left join course on course.id = score.course_id where score > 60;

        mysql> select student.id, student.name, sum(score.score) from student left join score on student.id = score.student_id left join course on course.id = score.course_id where score > 60 group by student.id order by sum(score.score) desc;
