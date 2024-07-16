create table emp(
    id int primary key auto_increment comment 'ID, 唯一标识',
    username varchar(20) comment '用户名',
    password varchar(20) comment '密码'
) comment '员工表';

insert into emp values (null,'aaa','123456'),(null,'bbb','123456'),(null,'ccc','123456');

create table dinetable(
    dinetableid int primary key auto_increment comment 'ID, 唯一标识',
    tablestate varchar(20) default '空' comment '状态'
) comment '餐桌状态';

insert into dinetable(dinetableid) values (null),(null),(null);
update dinetable set tablestate  = '已预定' where dinetableid = 3;


create table foodmenu(
    foodid int primary key auto_increment comment 'ID, 唯一标识',
    foodname varchar(20) comment '菜名',
    foodclass varchar(20) comment '菜系',
    foodprice int comment '价格',
    foodstorenum int comment '库存数量'
) comment '餐桌状态';

insert into foodmenu values (null,'青椒炒肉','川菜',20,10),(null,'炒蛋','川菜',21,12)
	,(null,'回锅肉','湘菜',31,18),(null,'鸡蛋汤','浙菜',16,30),(null,'麻婆豆腐','川菜',18,30),
	(null,'油条','浙菜',21,19),(null,'豆腐包','浙菜',26,15),(null,'卤蛋','浙菜',5,100);