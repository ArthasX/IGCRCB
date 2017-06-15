insert into "ig".IG259 (PTID, PTNAME, PTTYPE, PTSTARTPG, PTDETAILPG, PTCRTDATE, PTPICINFO, PTSTATUS, PTSAVEPG, PTQRTZFLAG, FINGERPRINT)
values (1, '事件', 'I', 'IGSVC0202_Disp.do', 'IGSVC0203_Disp.do?prid=', '2009/07/17', 'images/svc/pic1.gif', 'a', '', '', '');
insert into "ig".IG259 (PTID, PTNAME, PTTYPE, PTSTARTPG, PTDETAILPG, PTCRTDATE, PTPICINFO, PTSTATUS, PTSAVEPG, PTQRTZFLAG, FINGERPRINT)
values (2, '问题', 'P', 'IGSVC0302_Disp.do', 'IGSVC0303_Disp.do?prid=', '2009/07/17', 'images/svc/pic4.gif', 'a', '', '', '');
insert into "ig".IG259 (PTID, PTNAME, PTTYPE, PTSTARTPG, PTDETAILPG, PTCRTDATE, PTPICINFO, PTSTATUS, PTSAVEPG, PTQRTZFLAG, FINGERPRINT)
values (3, '变更', 'C', 'IGSVC0402_Disp.do', 'IGSVC0403_Disp.do?prid=', '2009/07/17', 'images/svc/pic2.gif', 'a', '', '', '');
insert into "ig".IG259 (PTID, PTNAME, PTTYPE, PTSTARTPG, PTDETAILPG, PTCRTDATE, PTPICINFO, PTSTATUS, PTSAVEPG, PTQRTZFLAG, FINGERPRINT)
values (5, '服务请求', 'S', 'IGSVC0802_Disp.do', 'IGSVC0803_Disp.do?prid=', '2009/07/17', 'images/svc/pic3.gif', 'a', '', '', '');
insert into "ig".IG259 (PTID, PTNAME, PTTYPE, PTSTARTPG, PTDETAILPG, PTCRTDATE, PTPICINFO, PTSTATUS, PTSAVEPG, PTQRTZFLAG, FINGERPRINT)
values (6, '个人工作', 'WB', 'IGEXTWB0102_Disp_SOC.do', 'IGEXTWB0103_Disp_SOC.do?prid=', '2009/07/17', 'images/wkm/extwb/extwb.gif', 'a', 'IGMTP0102_SOC.do,personTask.do', 'WP', '');
insert into "ig".IG259 (PTID, PTNAME, PTTYPE, PTSTARTPG, PTDETAILPG, PTCRTDATE, PTPICINFO, PTSTATUS, PTSAVEPG, PTQRTZFLAG, FINGERPRINT)
values (7, '指派工作', 'WA', 'IGEXTWA0102_Disp_SOC.do', 'IGEXTWA0103_Disp_SOC.do?prid=', '2009/07/17', 'images/wkm/extwa/extwa.gif', 'a', 'IGMTP0101_SOC.do,enterpriseTask.do', 'WE', '');
insert into "ig".IG259 (PTID, PTNAME, PTTYPE, PTSTARTPG, PTDETAILPG, PTCRTDATE, PTPICINFO, PTSTATUS, PTSAVEPG, PTQRTZFLAG, FINGERPRINT)
values (8, '自定义工作', 'WD', 'IGPRR0102_Disp.do?psdcode=Z'||'&'||'ptid=8'||'&'||'pdid=', 'IGPRR0102_Disp.do?prtype=WD'||'&'||'prid=', '2009/07/17', '', 'a', 'IGMTP0109.do', '', '');
insert into "ig".IG259 (PTID, PTNAME, PTTYPE, PTSTARTPG, PTDETAILPG, PTCRTDATE, PTPICINFO, PTSTATUS, PTSAVEPG, PTQRTZFLAG, FINGERPRINT)
values (9, '自定义事件', 'ID', 'IGPRR0102_Disp.do?psdcode=Z'||'&'||'ptid=9'||'&'||'pdid=', 'IGPRR0102_Disp.do?prtype=ID'||'&'||'prid=', '2009/07/17', '', 'a', '', '', '');
insert into "ig".IG259 (PTID, PTNAME, PTTYPE, PTSTARTPG, PTDETAILPG, PTCRTDATE, PTPICINFO, PTSTATUS, PTSAVEPG, PTQRTZFLAG, FINGERPRINT)
values (10, '自定义问题', 'PD', 'IGPRR0102_Disp.do?psdcode=Z'||'&'||'ptid=10'||'&'||'pdid=', 'IGPRR0102_Disp.do?prtype=PD'||'&'||'prid=', '2009/07/17', '', 'a', '', '', '');
insert into "ig".IG259 (PTID, PTNAME, PTTYPE, PTSTARTPG, PTDETAILPG, PTCRTDATE, PTPICINFO, PTSTATUS, PTSAVEPG, PTQRTZFLAG, FINGERPRINT)
values (11, '自定义变更', 'CD', 'IGPRR0102_Disp.do?psdcode=Z'||'&'||'ptid=11'||'&'||'pdid=', 'IGPRR0102_Disp.do?prtype=CD'||'&'||'prid=', '2009/07/17', '', 'a', '', '', '');
insert into "ig".IG259 (PTID, PTNAME, PTTYPE, PTSTARTPG, PTDETAILPG, PTCRTDATE, PTPICINFO, PTSTATUS, PTSAVEPG, PTQRTZFLAG, FINGERPRINT)
values (13, '自定义服务请求', 'SD', 'IGPRR0102_Disp.do?psdcode=Z'||'&'||'ptid=13'||'&'||'pdid=', 'IGPRR0102_Disp.do?prtype=SD'||'&'||'prid=', '2009/07/17', '', 'a', '', '', '');
commit;