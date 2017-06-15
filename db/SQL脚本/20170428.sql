insert into codecategory (CCID, CCNAME, CCINFO, CCEDITABLE, PCCID, PCFLAG, FINGERPRINT)
VALUES (160,'微信通知设定',null,3,null,0,null);

insert into CODEDETAIL (ccid,cid,CVALUE,CDINFO,CDSTATUS) values (160,1,'http://127.0.0.1:9999/SendService','微信发送服务地址',1);
insert into CODEDETAIL (ccid,cid,CVALUE,CDINFO,CDSTATUS) values (160,2,'1','是否发送',1);