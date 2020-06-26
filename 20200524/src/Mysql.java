
create table exam (
        id int,
        name varchar(20),
        chinese decimal(3,1),
        math decimal(3,1),
        english decimal(3,1)
        );

        insert into exam values
        (1, '刘备', 90.1, 70.3, 40.9),
        (2, '关于', 90.1, 60.3, 30.8),
        (3, '大乔', 99, 70.3, 30.8),
        (4, '吕布', 80.5, 50.3, 70.2),
        (5, '貂蝉', 80.5, 87.6, 90.3),
        (6, '孙尚香', 99, 12.1, 10),
        (7, '小乔', 98, 99, 4.3);

        select * from exam where chinese > english;

        select * from exam where english < 60;

        select * from exam where chinese <=> null;

        mysql> select name, chinese + math + english as totle from exam;

        mysql> select * from exam where chinese > 80 or english > 80;

        mysql> select * from exam where chinese > 80 and english > 80;

        mysql> select * from exam where chinese between 80 and 90;

        mysql> select name, chinese + math + english as totle from exam;

        mysql> select name, chinese + math + english as totle from exam where chinese + math + english < 200;

        mysql> select * from exam where math in (50.3, 87.6, 99);

        mysql> select * from exam where math = 50.3 or math = 87.6 or math = 99;

        mysql> select * from exam where chinese is null;

        mysql> select * from exam order by chinese desc;

        mysql> select * from exam order by chinese desc, math desc, english desc;

        mysql> select * from exam order by chinese desc, math asc, english desc;

        mysql> select name, chinese + math + english as totle from exam order by totle desc;

        mysql> select * from exam where name like '大_';

        mysql> select * from exam where name like '大%';

        mysql> select * from exam where chinese like '9%';

        mysql> select name, chinese + math + english as totle from exam order by totle desc limit 3;

        mysql> select name, chinese + math + english as totle from exam order by totle limit 3;

        mysql> select name, chinese + math + english as totle from exam order by totle desc limit 3 offset 3;

        mysql> select name, chinese + math + english as totle from exam order by totle desc limit 100 offset 100;

        mysql> select * from exam where chinese like '9%'and name like '大%';

        mysql> update exam set chinese = chinese - 10;

        mysql> update exam set math = 50, chinese = 95 where name = '大乔';

        mysql> update exam set math = math + 10 order by chinese + math + english asc limit 3;