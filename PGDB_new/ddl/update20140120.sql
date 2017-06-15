alter table ig.nms17 add rotation VARCHAR(32);
ALTER TABLE ig.nms17 ALTER x TYPE varchar(32);
ALTER TABLE ig.nms17 ALTER y TYPE varchar(32);
ALTER TABLE ig.nms17 ALTER width TYPE varchar(32);
ALTER TABLE ig.nms17 ALTER height TYPE varchar(32);

delete from "ig".codedetail where ccid = '171';
insert into "ig".codedetail(ccid, cid, cvalue, cdinfo, updtime) values ('171', '0', 'assets/monitor/AIX.png', 'AIX主机', '2013/12/25 15:36');
insert into "ig".codedetail(ccid, cid, cvalue, cdinfo, updtime) values ('171', '1', 'assets/monitor/Linux.png', 'Linux主机', '2013/12/25 15:36');
insert into "ig".codedetail(ccid, cid, cvalue, cdinfo, updtime) values ('171', '2', 'assets/monitor/Win32.png', 'Windows主机', '2013/12/25 15:36');
insert into "ig".codedetail(ccid, cid, cvalue, cdinfo, updtime) values ('171', '3', 'assets/monitor/multi_switch.png', '多层交换机', '2013/12/25 15:36');
insert into "ig".codedetail(ccid, cid, cvalue, cdinfo, updtime) values ('171', '4', 'assets/monitor/nor_switch.png', '交换机', '2013/12/25 15:36');
insert into "ig".codedetail(ccid, cid, cvalue, cdinfo, updtime) values ('171', '5', 'assets/monitor/route.png', '路由器', '2013/12/25 15:36');
insert into "ig".codedetail(ccid, cid, cvalue, cdinfo, updtime) values ('171', '6', 'assets/monitor/FireWall.png', '防火墙', '2013/01/08 15:47');
insert into "ig".codedetail(ccid, cid, cvalue, cdinfo, updtime) values ('171', '7', 'assets/monitor/pc.png', '计算机', '2013/01/17 15:44');
