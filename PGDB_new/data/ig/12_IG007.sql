insert into "ig".IG007 (PIDID, PDID, PIDNAME, PIDLABEL, PIDDESC, PIDTYPE, PIDOPTION, PIDDEFAULT, PIDREQUIRED, FINGERPRINT, PIDSORTID, CCID, PIDGID, PIDMODE, PRIVATESCOPE, ROWWIDTH)
values ('0000101001', '0000101', '影响范围', '影响范围', '', '2', ' #信贷#柜面#网银#全行', '', '0', '', '99', '', null, '0', '', '1');
insert into "ig".IG007 (PIDID, PDID, PIDNAME, PIDLABEL, PIDDESC, PIDTYPE, PIDOPTION, PIDDEFAULT, PIDREQUIRED, FINGERPRINT, PIDSORTID, CCID, PIDGID, PIDMODE, PRIVATESCOPE, ROWWIDTH)
values ('0000101002', '0000101', 'IGSVC_0001', '事件分类', '', 'T', '', '', '0', '', '99', '100_tree_事件分类', null, '0', '', '1');
insert into "ig".IG007 (PIDID, PDID, PIDNAME, PIDLABEL, PIDDESC, PIDTYPE, PIDOPTION, PIDDEFAULT, PIDREQUIRED, FINGERPRINT, PIDSORTID, CCID, PIDGID, PIDMODE, PRIVATESCOPE, ROWWIDTH)
values ('0000201001', '0000201', '影响范围', '影响范围', '', '2', ' #网点#支行#机关#全行', '', '0', '', '99', '', null, '0', '', '1');
insert into "ig".IG007 (PIDID, PDID, PIDNAME, PIDLABEL, PIDDESC, PIDTYPE, PIDOPTION, PIDDEFAULT, PIDREQUIRED, FINGERPRINT, PIDSORTID, CCID, PIDGID, PIDMODE, PRIVATESCOPE, ROWWIDTH)
values ('0000201002', '0000201', 'IGSVC_0001', '事件分类', '', 'T', '', '', '0', '', '99', '101_tree_事件分类', null, '0', '', '1');

commit;