insert into IG.ROLE (ROLEID, ROLENAME, ROLEDESC, ROLEINFO, ROLETYPE, ROLEDOMAIN, ASSETDOMAIN, FINGERPRINT)
values (1, '系统管理员', null, null, 'IGAM01', '0002', null, null);
insert into IG.ROLE (ROLEID, ROLENAME, ROLEDESC, ROLEINFO, ROLETYPE, ROLEDOMAIN, ASSETDOMAIN, FINGERPRINT)
values (2, '流程管理员', null, null, 'IGBP01', '0002', null, null);
insert into IG.ROLE (ROLEID, ROLENAME, ROLEDESC, ROLEINFO, ROLETYPE, ROLEDOMAIN, ASSETDOMAIN, FINGERPRINT)
values (3, '流程分派者', null, null, 'IGBP04', '0002', null, null);
insert into IG.ROLE (ROLEID, ROLENAME, ROLEDESC, ROLEINFO, ROLETYPE, ROLEDOMAIN, ASSETDOMAIN, FINGERPRINT)
values (4, '配置管理', null, null, 'IGCI01', '0002', '999001', null);
insert into IG.ROLE (ROLEID, ROLENAME, ROLEDESC, ROLEINFO, ROLETYPE, ROLEDOMAIN, ASSETDOMAIN, FINGERPRINT)
values (5, '应用管理', null, null, 'IGCI01', '0002', '999003', null);

--SOC服务管理流程参与
insert into IG.ROLE (ROLEID, ROLENAME, ROLEDESC, ROLEINFO, ROLETYPE, ROLEDOMAIN, ASSETDOMAIN, FINGERPRINT)
values (1000, '客户运维人员', null, null, 'IGBP02', '0002', null, null);
insert into IG.ROLE (ROLEID, ROLENAME, ROLEDESC, ROLEINFO, ROLETYPE, ROLEDOMAIN, ASSETDOMAIN, FINGERPRINT)
values (1001, '现场工程师', null, null, 'IGBP03', '0002', null, null);

commit;