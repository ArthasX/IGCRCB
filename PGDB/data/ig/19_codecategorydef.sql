insert into IG.CODECATEGORYDEF (CCID, CCNAME, CCINFO, CCEDITABLE, PCCID, PCFLAG, FINGERPRINT)
values ('100', '业务故障', '', '3', '', '4', '');
insert into IG.CODECATEGORYDEF (CCID, CCNAME, CCINFO, CCEDITABLE, PCCID, PCFLAG, FINGERPRINT)
values ('101', '普通报修', '', '3', '', '4', '');
commit;

--SOC自定义流程使用的树定义目前是固定的请勿随意更改
insert into IG.CODECATEGORYDEF (CCID, CCNAME, CCINFO, CCEDITABLE, PCCID, PCFLAG, FINGERPRINT)
values ('102', '故障分类', 'SOC故障分类', '3', '', '4', '');
insert into IG.CODECATEGORYDEF (CCID, CCNAME, CCINFO, CCEDITABLE, PCCID, PCFLAG, FINGERPRINT)
values ('103', '一级分类', '一级分类', '3', '102', '4', '');
insert into IG.CODECATEGORYDEF (CCID, CCNAME, CCINFO, CCEDITABLE, PCCID, PCFLAG, FINGERPRINT)
values ('104', '二级分类', '二级分类', '3', '103', '4', '');
insert into IG.CODECATEGORYDEF (CCID, CCNAME, CCINFO, CCEDITABLE, PCCID, PCFLAG, FINGERPRINT)
values ('105', '三级分类', '三级分类', '3', '104', '4', '');
insert into IG.CODECATEGORYDEF (CCID, CCNAME, CCINFO, CCEDITABLE, PCCID, PCFLAG, FINGERPRINT)
values ('106', '变更分类', 'SOC变更分类', '3', '', '4', '');
insert into IG.CODECATEGORYDEF (CCID, CCNAME, CCINFO, CCEDITABLE, PCCID, PCFLAG, FINGERPRINT)
values ('107', '一级分类', '一级分类', '3', '106', '4', '');
insert into IG.CODECATEGORYDEF (CCID, CCNAME, CCINFO, CCEDITABLE, PCCID, PCFLAG, FINGERPRINT)
values ('108', '二级分类', '二级分类', '3', '107', '4', '');
insert into IG.CODECATEGORYDEF (CCID, CCNAME, CCINFO, CCEDITABLE, PCCID, PCFLAG, FINGERPRINT)
values ('109', '三级分类', '三级分类', '3', '108', '4', '');
commit;