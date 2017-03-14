insert into CODECATEGORY (CCID, CCNAME, CCINFO, CCEDITABLE, PCCID, PCFLAG, FINGERPRINT)
values ('216', '后勤物品种类', '后勤物品种类', '1', null, '4', null);
insert into CODECATEGORY (CCID, CCNAME, CCINFO, CCEDITABLE, PCCID, PCFLAG, FINGERPRINT)
values ('910', '一级物品种类', '一级物品种类', '1', '216', '4', null);
insert into CODECATEGORY (CCID, CCNAME, CCINFO, CCEDITABLE, PCCID, PCFLAG, FINGERPRINT)
values ('911', '二级物品种类', '二级物品种类', '1', '910', '4', null);
insert into CODECATEGORY (CCID, CCNAME, CCINFO, CCEDITABLE, PCCID, PCFLAG, FINGERPRINT)
values ('912', '三级物品种类', '三级物品种类', '1', '911', '4', null);

commit;