--服务商
insert into ig.soc0109 values('CI040000000001', 'CM04000000', '简称', null, '企业名称简称', null, '1', 0, '001', null, '0', '999005', null, null);
insert into ig.soc0109 values('CI040000000002', 'CM04000000', '组织机构代码', null, null, null, '1', 0, '001', null, '0', '999005', null, null);
insert into ig.soc0109 values('CI040000000003', 'CM04000000', '法人代表', null, null, null, '1', 0, '001', null, '0', '999005', null, null);
insert into ig.soc0109 values('CI040000000004', 'CM04000000', '公司类型', null, null, null, '1', 0, '001', null, '0', '999005', null, null);
insert into ig.soc0109 values('CI040000000005', 'CM04000000', '公司资质', null, null, null, '1', 0, '001', null, '0', '999005', null, null);
insert into ig.soc0109 values('CI040000000006', 'CM04000000', '注册资金', null, null, null, '1', 0, '001', null, '0', '999005', null, null);
insert into ig.soc0109 values('CI040000000007', 'CM04000000', '注册地址', null, null, null, '1', 0, '001', null, '0', '999005', null, null);
insert into ig.soc0109 values('CI040000000008', 'CM04000000', '联系地址', 'IG_0261', null, null, '1', 0, '001', null, '0', '999005', null, null);
insert into ig.soc0109 values('CI040000000009', 'CM04000000', '联系人', 'IG_0262', null, null, '1', 0, '001', null, '0', '999005', null, null);
insert into ig.soc0109 values('CI040000000010', 'CM04000000', '联系电话', 'IG_0263', null, null, '1', 0, '001', null, '0', '999005', null, null);
insert into ig.soc0109 values('CI040000000011', 'CM04000000', '传真', null, null, null, '1', 0, '001', null, '0', '999005', null, null);
insert into ig.soc0109 values('CI040000000012', 'CM04000000', '邮政编码', null, null, null, '1', 0, '001', null, '0', '999005', null, null);
insert into ig.soc0109 values('CI040000000013', 'CM04000000', '成功案例', null, null, '1', '1', 2, '001', null, '6', '999005', null, '0');
insert into ig.soc0109 values('CI040000000014', 'CM04000000', '开户行', 'IG_0163', null, null, '1', 0, '001', null, '0', '999005', null, null);
insert into ig.soc0109 values('CI040000000015', 'CM04000000', '开户帐号', 'IG_0164', null, null, '1', 0, '001', null, '0', '999005', null, null);
insert into ig.soc0109 values('CI040000000016', 'CM04000000', '开户名称', 'IG_0165', null, null, '1', 0, '001', null, '0', '999005', null, null);
insert into ig.soc0109 values('CI040000000017', 'CM04000000', '是否为我行服务商', 'IG_1908', null, null, '1', 2, '001', '011', '2', '999005', null, '1');
--供应商
insert into ig.soc0109 values('CI040000010001', 'CM04000001', '联系人邮箱', null, null, null, '1', 0, '001', null, '0', '999005', null, null);
--维保商
insert into ig.soc0109 values('CI040000020001', 'CM04000002', '销售联系人姓名', null, null, null, '1', 0, '001', null, '0', '999005', null, null);
insert into ig.soc0109 values('CI040000020002', 'CM04000002', '销售联系人手机', null, null, null, '1', 0, '001', null, '0', '999005', null, null);
insert into ig.soc0109 values('CI040000020003', 'CM04000002', '技术支持人员姓名', null, null, null, '1', 0, '001', null, '0', '999005', null, '1');
insert into ig.soc0109 values('CI040000020004', 'CM04000002', '技术支持人员手机', null, null, null, '1', 0, '001', null, '0', '999005', null, '1');
insert into ig.soc0109 values('CI040000020005', 'CM04000002', '技术支持人员邮箱', null, null, null, '1', 0, '001', null, '0', '999005', null, null);
insert into ig.soc0109 values('CI040000020006', 'CM04000002', '技术支持人员地址', null, null, null, '1', 0, '001', null, '0', '999005', null, null);

--服务记录
--删除原有垃圾数据
delete from ig.soc0109 where cid in ('110', '111');
insert into ig.soc0109 values('CI120000000001', 'CM12000000', '资产ID', 'IG_0007', null, null, '1', 1, '001', null, '0', '999009', null, null);
insert into ig.soc0109 values('CI120000000002', 'CM12000000', '资产名称', 'IG_0008', null, null, '1', 0, '001', null, '0', '999009', null, '1');
insert into ig.soc0109 values('CI120000000003', 'CM12000000', '资产模型ID', 'IG_0009', null, null, '1', 1, '001', null, '0', '999009', null, null);
insert into ig.soc0109 values('CI120000000004', 'CM12000000', '资产模型标识', 'IG_0010', null, null, '1', 1, '001', null, '0', '999009', null, null);
insert into ig.soc0109 values('CI120000000005', 'CM12000000', '服务商ID', 'IG_0011', null, null, '1', 1, '001', null, '0', '999009', null, null);
insert into ig.soc0109 values('CI120000000006', 'CM12000000', '服务商名称', 'IG_0012', null, null, '1', 0, '001', null, '0', '999009', null, '1');
insert into ig.soc0109 values('CI120000000007', 'CM12000000', '服务商模型ID', 'IG_0013', null, null, '1', 1, '001', null, '0', '999009', null, null);
insert into ig.soc0109 values('CI120000000008', 'CM12000000', '服务商模型标识', 'IG_0014', null, null, '1', 1, '001', null, '0', '999009', null, null);
insert into ig.soc0109 values('CI120000000009', 'CM12000000', '服务性质', null, null, null, '1', 0, '001', '036', '2', '999009', null, null);
--软/硬件服务记录
insert into ig.soc0109 values('CI120000010001', 'CM12000001', '服务工程师', null, null, null, '1', 0, '001', null, '0', '999009001', null, null);
insert into ig.soc0109 values('CI120000010002', 'CM12000001', '配合人员', null, null, null, '1', 0, '001', '999010', '4', '999009001', null, null);
insert into ig.soc0109 values('CI120000010003', 'CM12000001', '服务内容描述', null, null, null, '1', 0, '001', null, '0', '999009001', null, null);
insert into ig.soc0109 values('CI120000010004', 'CM12000001', '服务结果描述', null, null, null, '1', 0, '001', null, '1', '999009001', null, null);
insert into ig.soc0109 values('CI120000010005', 'CM12000001', '服务评价', null, null, null, '1', 0, '001', '037', '2', '999009001', null, '1');
insert into ig.soc0109 values('CI120000010006', 'CM12000001', '客户报修时间', null, null, null, '1', 0, '004', null, '3', '999009001', null, null);
insert into ig.soc0109 values('CI120000010007', 'CM12000001', '服务开始时间', null, null, null, '1', 0, '004', null, '3', '999009001', null, '1');
insert into ig.soc0109 values('CI120000010008', 'CM12000001', '服务时间段', null, null, null, '1', 0, '004', null, '0', '999009001', null, null);
insert into ig.soc0109 values('CI120000010009', 'CM12000001', '服务结束时间', null, null, null, '1', 0, '004', null, '3', '999009001', null, '1');
insert into ig.soc0109 values('CI120000010010', 'CM12000001', '服务类型', null, null, null, '1', 0, '004', '038', '2', '999009001', null, null);
--员工培训记录
insert into ig.soc0109 values('CI120000020001', 'CM12000002', '培训方式', null, null, null, '1', 0, '001', null, '0', '999009002', null, null);
insert into ig.soc0109 values('CI120000020002', 'CM12000002', '开始日期', null, null, null, '1', 0, '001', null, '3', '999009002', null, null);
insert into ig.soc0109 values('CI120000020003', 'CM12000002', '结束日期', null, null, null, '1', 0, '001', null, '3', '999009002', null, null);
insert into ig.soc0109 values('CI120000020004', 'CM12000002', '培训教育程度', null, null, null, '1', 0, '001', null, '0', '999009002', null, null);
insert into ig.soc0109 values('CI120000020005', 'CM12000002', '培训内容', null, null, null, '1', 0, '001', null, '0', '999009002', null, null);

--系统资产
insert into ig.soc0109 values('CI050000000001', 'CM05000000', '软件名称', null, null, null, '1', 0, '003', '999002', '4', '999006', null, null);
insert into ig.soc0109 values('CI050000000002', 'CM05000000', '超级管理员账号', null, null, null, '1', 0, '003', null, '0', '999006', null, null);
insert into ig.soc0109 values('CI050000000003', 'CM05000000', '运行主机', null, null, null, '1', 0, '003', '999001', '4', '999006', null, null);
insert into ig.soc0109 values('CI050000000004', 'CM05000000', '负责人(A角色)', null, null, null, '1', 0, '003', '999010', '4', '999006', null, null);
insert into ig.soc0109 values('CI050000000005', 'CM05000000', '负责人(B角色)', null, null, null, '1', 0, '003', '999010', '4', '999006', null, null);
--操作系统
insert into ig.soc0109 values('CI050000010001', 'CM05000001', '环境变量', null, null, null, '1', 0, '001', null, '1', '999006001', null, null);
insert into ig.soc0109 values('CI050000010002', 'CM05000001', 'IP地址', null, null, null, '1', 0, '001', null, '0', '999006001', null, null);
--AIX
insert into ig.soc0109 values('CI050000020001', 'CM05000002', '卷组信息', null, null, null, '1', 0, '001', null, '1', '999006001001', null, null);
insert into ig.soc0109 values('CI050000020002', 'CM05000002', 'VG信息', null, null, null, '1', 0, '001', null, '1', '999006001001', null, null);
insert into ig.soc0109 values('CI050000020003', 'CM05000002', '主机名', null, null, null, '1', 0, '001', null, '0', '999006001001', null, null);
--Windows
insert into ig.soc0109 values('CI050000030001', 'CM05000003', '分区信息', null, null, null, '1', 0, '001', null, '1', '999006001002', null, null);
--数据库
insert into ig.soc0109 values('CI050000070001', 'CM05000007', '运行的操作系统', null, null, null, '1', 0, '001', '999006001', '4', '999006002', null, null);
insert into ig.soc0109 values('CI050000070002', 'CM05000007', '数据库代码集', null, null, null, '1', 0, '001', null, '0', '999006002', null, '0');
insert into ig.soc0109 values('CI050000070003', 'CM05000007', '数据库地区设置', null, null, null, '1', 0, '001', null, '0', '999006002', null, '0');
--DB2
insert into ig.soc0109 values('CI050000080001', 'CM05000008', '数据库实例名', null, null, null, '1', 0, '001', null, '0', '999006002001', null, null);
insert into ig.soc0109 values('CI050000080002', 'CM05000008', '表空间信息', null, null, null, '1', 0, '001', null, '0', '999006002001', null, '0');
insert into ig.soc0109 values('CI050000080003', 'CM05000008', '建库脚本', null, null, null, '1', 0, '001', null, '1', '999006002001', null, null);
insert into ig.soc0109 values('CI050000080004', 'CM05000008', '数据库应用信息', null, null, null, '1', 0, '001', null, '0', '999006002001', null, '0');
insert into ig.soc0109 values('CI050000080005', 'CM05000008', '数据库配置', null, null, null, '1', 0, '001', null, '1', '999006002001', null, '0');
--中间件
insert into ig.soc0109 values('CI050000150001', 'CM05000015', '运行的操作系统', null, null, null, '1', 0, '001', '999006001', '4', '999006003', null, null);
--WebLogic
insert into ig.soc0109 values('CI050000160001', 'CM05000016', '集群配置', null, null, null, '1', 0, '001', null, '0', '999006003001', null, null);
insert into ig.soc0109 values('CI050000160002', 'CM05000016', '管理信息', null, null, null, '1', 0, '001', null, '0', '999006003001', null, null);
insert into ig.soc0109 values('CI050000160003', 'CM05000016', '管理URL', null, null, null, '1', 0, '001', null, '0', '999006003001', null, null);
insert into ig.soc0109 values('CI050000160004', 'CM05000016', '服务URL', null, null, null, '1', 0, '001', null, '0', '999006003001', null, null);
--MQSeries
insert into ig.soc0109 values('CI050000180001', 'CM05000018', '队列管理器信息', null, null, null, '1', 0, '001', null, '0', '999006003003', null, null);
insert into ig.soc0109 values('CI050000180002', 'CM05000018', '队列信息', null, null, null, '1', 0, '001', null, '0', '999006003003', null, null);
insert into ig.soc0109 values('CI050000180003', 'CM05000018', '通道信息', null, null, null, '1', 0, '001', null, '0', '999006003003', null, null);
insert into ig.soc0109 values('CI050000180004', 'CM05000018', '侦听器信息', null, null, null, '1', 0, '001', null, '0', '999006003003', null, null);
insert into ig.soc0109 values('CI050000180005', 'CM05000018', '日志信息', null, null, null, '1', 0, '001', null, '0', '999006003003', null, null);
insert into ig.soc0109 values('CI050000180006', 'CM05000018', '队列管理员用户名', null, null, null, '1', 0, '001', null, '0', '999006003003', null, null);

--合同
insert into ig.soc0109 values('CI060000000001', 'CM06000000', '财审委意见', 'IG_0264', null, null, '1', 0, '001', null, '0', '999011', null, null);             
insert into ig.soc0109 values('CI060000000002', 'CM06000000', '会议纪要编号', 'IG_0265', null, null, '1', 0, '001', null, '0', '999011', null, null);           
insert into ig.soc0109 values('CI060000000003', 'CM06000000', '审批日期', 'IG_0266', null, null, '1', 0, '001', null, '3', '999011', null, null);               
insert into ig.soc0109 values('CI060000000004', 'CM06000000', '合同类别', 'IG_0109', null, null, '1', 0, '001', '039', '2', '999011', null, '1');           
insert into ig.soc0109 values('CI060000000005', 'CM06000000', '项目名称', 'IG_0110', null, null, '1', 0, '001', null, '0', '999011', null, '1');              
insert into ig.soc0109 values('CI060000000006', 'CM06000000', '签订日期', 'IG_0111', null, null, '1', 0, '001', null, '3', '999011', null, '1');              
insert into ig.soc0109 values('CI060000000007', 'CM06000000', '经手人', 'IG_0112', null, null, '1', 0, '001', null, '0', '999011', null, '1');                
insert into ig.soc0109 values('CI060000000008', 'CM06000000', '服务商', 'IG_0113', null, null, '1', 0, '001', '999005', '4', '999011', null, '1');          
insert into ig.soc0109 values('CI060000000009', 'CM06000000', '合同文本1', 'IG_0114', null, null, '1', 0, '001', null, '1', '999011', null, null);              
insert into ig.soc0109 values('CI060000000010', 'CM06000000', '保密协议号', 'IG_0115', null, null, '1', 0, '001', null, '0', '999011', null, null);             
insert into ig.soc0109 values('CI060000000011', 'CM06000000', '合同总价款', 'IG_0116', null, null, '1', 0, '002', null, '7', '999011', null, '1');            
insert into ig.soc0109 values('CI060000000012', 'CM06000000', '第一笔应付款额', 'IG_0117', null, null, '1', 0, '002', null, '7', '999011', null, '1');        
insert into ig.soc0109 values('CI060000000013', 'CM06000000', '第一笔应付款比例', 'IG_0166', null, null, '1', 0, '002', null, '0', '999011', null, '1');      
insert into ig.soc0109 values('CI060000000014', 'CM06000000', '第一笔实付款额', 'IG_0153', null, null, '1', 0, '002', null, '7', '999011', null, null);         
insert into ig.soc0109 values('CI060000000015', 'CM06000000', '第一笔应付日', 'IG_0118', null, null, '1', 0, '002', null, '3', '999011', null, '1');          
insert into ig.soc0109 values('CI060000000016', 'CM06000000', '第一笔制单日', 'IG_0158', null, null, '1', 0, '002', null, '3', '999011', null, null);           
insert into ig.soc0109 values('CI060000000017', 'CM06000000', '第一笔实付日', 'IG_0119', null, null, '1', 0, '002', null, '3', '999011', null, null);           
insert into ig.soc0109 values('CI060000000018', 'CM06000000', '发票说明', 'IG_0120', null, null, '1', 0, '002', null, '0', '999011', null, null);               
insert into ig.soc0109 values('CI060000000019', 'CM06000000', '第二笔应付款额', 'IG_0121', null, null, '1', 0, '002', null, '7', '999011', null, null);         
insert into ig.soc0109 values('CI060000000020', 'CM06000000', '第二笔应付款比例', 'IG_0167', null, null, '1', 0, '002', null, '0', '999011', null, null);       
insert into ig.soc0109 values('CI060000000021', 'CM06000000', '第二笔实付款额', 'IG_0154', null, null, '1', 0, '002', null, '7', '999011', null, null);         
insert into ig.soc0109 values('CI060000000022', 'CM06000000', '第二笔应付日', 'IG_0122', null, null, '1', 0, '002', null, '3', '999011', null, null);           
insert into ig.soc0109 values('CI060000000023', 'CM06000000', '第二笔制单日', 'IG_0159', null, null, '1', 0, '002', null, '3', '999011', null, null);           
insert into ig.soc0109 values('CI060000000024', 'CM06000000', '第二笔实付日', 'IG_0123', null, null, '1', 0, '002', null, '3', '999011', null, null);           
insert into ig.soc0109 values('CI060000000025', 'CM06000000', '发票说明', 'IG_0124', null, null, '1', 0, '002', null, '0', '999011', null, null);               
insert into ig.soc0109 values('CI060000000026', 'CM06000000', '第三笔应付款额', 'IG_0125', null, null, '1', 0, '002', null, '7', '999011', null, null);         
insert into ig.soc0109 values('CI060000000027', 'CM06000000', '第三笔应付款比例', 'IG_0168', null, null, '1', 0, '002', null, '0', '999011', null, null);       
insert into ig.soc0109 values('CI060000000028', 'CM06000000', '第三笔实付款额', 'IG_0155', null, null, '1', 0, '002', null, '7', '999011', null, null);         
insert into ig.soc0109 values('CI060000000029', 'CM06000000', '第三笔应付日', 'IG_0126', null, null, '1', 0, '002', null, '3', '999011', null, null);           
insert into ig.soc0109 values('CI060000000030', 'CM06000000', '第三笔制单日', 'IG_0160', null, null, '1', 0, '002', null, '3', '999011', null, null);           
insert into ig.soc0109 values('CI060000000031', 'CM06000000', '第三笔实付日', 'IG_0127', null, null, '1', 0, '002', null, '3', '999011', null, null);           
insert into ig.soc0109 values('CI060000000032', 'CM06000000', '发票说明', 'IG_0128', null, null, '1', 0, '002', null, '0', '999011', null, null);               
insert into ig.soc0109 values('CI060000000033', 'CM06000000', '第四笔应付款额', 'IG_0129', null, null, '1', 0, '002', null, '7', '999011', null, null);         
insert into ig.soc0109 values('CI060000000034', 'CM06000000', '第四笔应付款比例', 'IG_0169', null, null, '1', 0, '002', null, '0', '999011', null, null);       
insert into ig.soc0109 values('CI060000000035', 'CM06000000', '第四笔实付款额', 'IG_0156', null, null, '1', 0, '002', null, '7', '999011', null, null);         
insert into ig.soc0109 values('CI060000000036', 'CM06000000', '第四笔应付日', 'IG_0130', null, null, '1', 0, '002', null, '3', '999011', null, null);           
insert into ig.soc0109 values('CI060000000037', 'CM06000000', '第四笔制单日', 'IG_0161', null, null, '1', 0, '002', null, '3', '999011', null, null);           
insert into ig.soc0109 values('CI060000000038', 'CM06000000', '第四笔实付日', 'IG_0131', null, null, '1', 0, '002', null, '3', '999011', null, null);           
insert into ig.soc0109 values('CI060000000039', 'CM06000000', '发票说明', 'IG_0132', null, null, '1', 0, '002', null, '0', '999011', null, null);               
insert into ig.soc0109 values('CI060000000040', 'CM06000000', '第五笔应付款额', 'IG_0133', null, null, '1', 0, '002', null, '7', '999011', null, null);         
insert into ig.soc0109 values('CI060000000041', 'CM06000000', '第五笔应付款比例', 'IG_0170', null, null, '1', 0, '002', null, '0', '999011', null, null);       
insert into ig.soc0109 values('CI060000000042', 'CM06000000', '第五笔实付款额', 'IG_0157', null, null, '1', 0, '002', null, '7', '999011', null, null);         
insert into ig.soc0109 values('CI060000000043', 'CM06000000', '第五笔应付日', 'IG_0134', null, null, '1', 0, '002', null, '3', '999011', null, null);           
insert into ig.soc0109 values('CI060000000044', 'CM06000000', '第五笔制单日', 'IG_0162', null, null, '1', 0, '002', null, '3', '999011', null, null);           
insert into ig.soc0109 values('CI060000000045', 'CM06000000', '第五笔实付日', 'IG_0135', null, null, '1', 0, '002', null, '3', '999011', null, null);           
insert into ig.soc0109 values('CI060000000046', 'CM06000000', '发票说明', 'IG_0136', null, null, '1', 0, '002', null, '0', '999011', null, null);               
insert into ig.soc0109 values('CI060000000047', 'CM06000000', '已付款', 'IG_0137', null, null, '1', 0, '002', null, '0', '999011', null, null);                 
insert into ig.soc0109 values('CI060000000048', 'CM06000000', '最后付款日', 'IG_0138', null, null, '1', 0, '002', null, '0', '999011', null, null);             
insert into ig.soc0109 values('CI060000000049', 'CM06000000', '质保开始日', 'IG_0139', null, null, '1', 0, '004', null, '3', '999011', null, null);             
insert into ig.soc0109 values('CI060000000050', 'CM06000000', '质保到期日', 'IG_0140', null, null, '1', 0, '004', null, '3', '999011', null, null);             
insert into ig.soc0109 values('CI060000000051', 'CM06000000', '子项目1', 'IG_0141', null, null, '1', 0, '001', null, '0', '999011', null, null);                
insert into ig.soc0109 values('CI060000000052', 'CM06000000', '子项目2', 'IG_0142', null, null, '1', 0, '001', null, '0', '999011', null, null);                
insert into ig.soc0109 values('CI060000000053', 'CM06000000', '子项目3', 'IG_0143', null, null, '1', 0, '001', null, '0', '999011', null, null);                
insert into ig.soc0109 values('CI060000000054', 'CM06000000', '子项目4', 'IG_0144', null, null, '1', 0, '001', null, '0', '999011', null, null);                
insert into ig.soc0109 values('CI060000000055', 'CM06000000', '子项目5', 'IG_0145', null, null, '1', 0, '001', null, '0', '999011', null, null);                
insert into ig.soc0109 values('CI060000000056', 'CM06000000', '子项目6', 'IG_0146', null, null, '1', 0, '001', null, '0', '999011', null, null);                
insert into ig.soc0109 values('CI060000000057', 'CM06000000', '子项目7', 'IG_0147', null, null, '1', 0, '001', null, '0', '999011', null, null);                
insert into ig.soc0109 values('CI060000000058', 'CM06000000', '子项目8', 'IG_0148', null, null, '1', 0, '001', null, '0', '999011', null, null);                
insert into ig.soc0109 values('CI060000000059', 'CM06000000', '子项目9', 'IG_0149', null, null, '1', 0, '001', null, '0', '999011', null, null);                
insert into ig.soc0109 values('CI060000000060', 'CM06000000', '子项目10', 'IG_0150', null, null, '1', 0, '001', null, '0', '999011', null, null);               
insert into ig.soc0109 values('CI060000000061', 'CM06000000', '维保说明', 'IG_1743', null, null, '1', 0, '004', null, '6', '999011', null, null);               
insert into ig.soc0109 values('CI060000000062', 'CM06000000', '第六笔应付款额', 'IG_0191', null, null, '1', 0, '002', null, '7', '999011', null, null);         
insert into ig.soc0109 values('CI060000000063', 'CM06000000', '第六笔应付款比例', 'IG_0192', null, null, '1', 0, '002', null, '0', '999011', null, null);       
insert into ig.soc0109 values('CI060000000064', 'CM06000000', '第六笔实付款额', 'IG_0193', null, null, '1', 0, '002', null, '7', '999011', null, null);         
insert into ig.soc0109 values('CI060000000065', 'CM06000000', '第六笔应付日', 'IG_0194', null, null, '1', 0, '002', null, '3', '999011', null, null);           
insert into ig.soc0109 values('CI060000000066', 'CM06000000', '第六笔制单日', 'IG_0195', null, null, '1', 0, '002', null, '3', '999011', null, null);           
insert into ig.soc0109 values('CI060000000067', 'CM06000000', '第六笔实付日', 'IG_0196', null, null, '1', 0, '002', null, '3', '999011', null, null);           
insert into ig.soc0109 values('CI060000000068', 'CM06000000', '发票说明', 'IG_0197', null, null, '1', 0, '002', null, '0', '999011', null, null);               
insert into ig.soc0109 values('CI060000000069', 'CM06000000', '第七笔应付款额', 'IG_0198', null, null, '1', 0, '002', null, '7', '999011', null, null);         
insert into ig.soc0109 values('CI060000000070', 'CM06000000', '第七笔应付款比例', 'IG_0199', null, null, '1', 0, '002', null, '0', '999011', null, null);       
insert into ig.soc0109 values('CI060000000071', 'CM06000000', '第七笔实付款额', 'IG_0200', null, null, '1', 0, '002', null, '7', '999011', null, null);         
insert into ig.soc0109 values('CI060000000072', 'CM06000000', '第七笔应付日', 'IG_0201', null, null, '1', 0, '002', null, '3', '999011', null, null);           
insert into ig.soc0109 values('CI060000000073', 'CM06000000', '第七笔制单日', 'IG_0202', null, null, '1', 0, '002', null, '3', '999011', null, null);           
insert into ig.soc0109 values('CI060000000074', 'CM06000000', '第七笔实付日', 'IG_0203', null, null, '1', 0, '002', null, '3', '999011', null, null);           
insert into ig.soc0109 values('CI060000000075', 'CM06000000', '发票说明', 'IG_0204', null, null, '1', 0, '002', null, '0', '999011', null, null);               
insert into ig.soc0109 values('CI060000000076', 'CM06000000', '第八笔应付款额', 'IG_0205', null, null, '1', 0, '002', null, '7', '999011', null, null);         
insert into ig.soc0109 values('CI060000000077', 'CM06000000', '第八笔应付款比例', 'IG_0206', null, null, '1', 0, '002', null, '0', '999011', null, null);       
insert into ig.soc0109 values('CI060000000078', 'CM06000000', '第八笔实付款额', 'IG_0207', null, null, '1', 0, '002', null, '7', '999011', null, null);         
insert into ig.soc0109 values('CI060000000079', 'CM06000000', '第八笔应付日', 'IG_0208', null, null, '1', 0, '002', null, '3', '999011', null, null);           
insert into ig.soc0109 values('CI060000000080', 'CM06000000', '第八笔制单日', 'IG_0209', null, null, '1', 0, '002', null, '3', '999011', null, null);           
insert into ig.soc0109 values('CI060000000081', 'CM06000000', '第八笔实付日', 'IG_0210', null, null, '1', 0, '002', null, '3', '999011', null, null);           
insert into ig.soc0109 values('CI060000000082', 'CM06000000', '发票说明', 'IG_0211', null, null, '1', 0, '002', null, '0', '999011', null, null);               
insert into ig.soc0109 values('CI060000000083', 'CM06000000', '第九笔应付款额', 'IG_0212', null, null, '1', 0, '002', null, '7', '999011', null, null);         
insert into ig.soc0109 values('CI060000000084', 'CM06000000', '第九笔应付款比例', 'IG_0213', null, null, '1', 0, '002', null, '0', '999011', null, null);       
insert into ig.soc0109 values('CI060000000085', 'CM06000000', '第九笔实付款额', 'IG_0214', null, null, '1', 0, '002', null, '7', '999011', null, null);         
insert into ig.soc0109 values('CI060000000086', 'CM06000000', '第九笔应付日', 'IG_0215', null, null, '1', 0, '002', null, '3', '999011', null, null);           
insert into ig.soc0109 values('CI060000000087', 'CM06000000', '第九笔制单日', 'IG_0216', null, null, '1', 0, '002', null, '3', '999011', null, null);           
insert into ig.soc0109 values('CI060000000088', 'CM06000000', '第九笔实付日', 'IG_0217', null, null, '1', 0, '002', null, '3', '999011', null, null);           
insert into ig.soc0109 values('CI060000000089', 'CM06000000', '发票说明', 'IG_0218', null, null, '1', 0, '002', null, '0', '999011', null, null);               
insert into ig.soc0109 values('CI060000000090', 'CM06000000', '第十笔应付款额', 'IG_0219', null, null, '1', 0, '002', null, '7', '999011', null, null);         
insert into ig.soc0109 values('CI060000000091', 'CM06000000', '第十笔应付款比例', 'IG_0220', null, null, '1', 0, '002', null, '0', '999011', null, null);       
insert into ig.soc0109 values('CI060000000092', 'CM06000000', '第十笔实付款额', 'IG_0221', null, null, '1', 0, '002', null, '7', '999011', null, null);         
insert into ig.soc0109 values('CI060000000093', 'CM06000000', '第十笔应付日', 'IG_0222', null, null, '1', 0, '002', null, '3', '999011', null, null);           
insert into ig.soc0109 values('CI060000000094', 'CM06000000', '第十笔制单日', 'IG_0223', null, null, '1', 0, '002', null, '3', '999011', null, null);           
insert into ig.soc0109 values('CI060000000095', 'CM06000000', '第十笔实付日', 'IG_0224', null, null, '1', 0, '002', null, '3', '999011', null, null);           
insert into ig.soc0109 values('CI060000000096', 'CM06000000', '发票说明', 'IG_0225', null, null, '1', 0, '002', null, '0', '999011', null, null);               
insert into ig.soc0109 values('CI060000000097', 'CM06000000', '第十一笔应付款额', 'IG_0226', null, null, '1', 0, '002', null, '7', '999011', null, null);       
insert into ig.soc0109 values('CI060000000098', 'CM06000000', '第十一笔应付款比例', 'IG_0227', null, null, '1', 0, '002', null, '0', '999011', null, null);     
insert into ig.soc0109 values('CI060000000099', 'CM06000000', '第十一笔实付款额', 'IG_0228', null, null, '1', 0, '002', null, '7', '999011', null, null);       
insert into ig.soc0109 values('CI060000000100', 'CM06000000', '第十一笔应付日', 'IG_0229', null, null, '1', 0, '002', null, '3', '999011', null, null);         
insert into ig.soc0109 values('CI060000000101', 'CM06000000', '第十一笔制单日', 'IG_0230', null, null, '1', 0, '002', null, '3', '999011', null, null);         
insert into ig.soc0109 values('CI060000000102', 'CM06000000', '第十一笔实付日', 'IG_0231', null, null, '1', 0, '002', null, '3', '999011', null, null);         
insert into ig.soc0109 values('CI060000000103', 'CM06000000', '发票说明', 'IG_0232', null, null, '1', 0, '002', null, '0', '999011', null, null);               
insert into ig.soc0109 values('CI060000000104', 'CM06000000', '第十二笔应付款额', 'IG_0233', null, null, '1', 0, '002', null, '7', '999011', null, null);       
insert into ig.soc0109 values('CI060000000105', 'CM06000000', '第十二笔应付款比例', 'IG_0234', null, null, '1', 0, '002', null, '0', '999011', null, null);     
insert into ig.soc0109 values('CI060000000106', 'CM06000000', '第十二笔实付款额', 'IG_0235', null, null, '1', 0, '002', null, '7', '999011', null, null);       
insert into ig.soc0109 values('CI060000000107', 'CM06000000', '第十二笔应付日', 'IG_0236', null, null, '1', 0, '002', null, '3', '999011', null, null);         
insert into ig.soc0109 values('CI060000000108', 'CM06000000', '第十二笔制单日', 'IG_0237', null, null, '1', 0, '002', null, '3', '999011', null, null);         
insert into ig.soc0109 values('CI060000000109', 'CM06000000', '第十二笔实付日', 'IG_0238', null, null, '1', 0, '002', null, '3', '999011', null, null);         
insert into ig.soc0109 values('CI060000000110', 'CM06000000', '发票说明', 'IG_0239', null, null, '1', 0, '002', null, '0', '999011', null, null);               
insert into ig.soc0109 values('CI060000000111', 'CM06000000', '第十三笔应付款额', 'IG_0240', null, null, '1', 0, '002', null, '7', '999011', null, null);       
insert into ig.soc0109 values('CI060000000112', 'CM06000000', '第十三笔应付款比例', 'IG_0241', null, null, '1', 0, '002', null, '0', '999011', null, null);     
insert into ig.soc0109 values('CI060000000113', 'CM06000000', '第十三笔实付款额', 'IG_0242', null, null, '1', 0, '002', null, '7', '999011', null, null);       
insert into ig.soc0109 values('CI060000000114', 'CM06000000', '第十三笔应付日', 'IG_0243', null, null, '1', 0, '002', null, '3', '999011', null, null);         
insert into ig.soc0109 values('CI060000000115', 'CM06000000', '第十三笔制单日', 'IG_0244', null, null, '1', 0, '002', null, '3', '999011', null, null);         
insert into ig.soc0109 values('CI060000000116', 'CM06000000', '第十三笔实付日', 'IG_0245', null, null, '1', 0, '002', null, '3', '999011', null, null);         
insert into ig.soc0109 values('CI060000000117', 'CM06000000', '发票说明', 'IG_0246', null, null, '1', 0, '002', null, '0', '999011', null, null);               
insert into ig.soc0109 values('CI060000000118', 'CM06000000', '第十四笔应付款额', 'IG_0247', null, null, '1', 0, '002', null, '7', '999011', null, null);       
insert into ig.soc0109 values('CI060000000119', 'CM06000000', '第十四笔应付款比例', 'IG_0248', null, null, '1', 0, '002', null, '0', '999011', null, null);     
insert into ig.soc0109 values('CI060000000120', 'CM06000000', '第十四笔实付款额', 'IG_0249', null, null, '1', 0, '002', null, '7', '999011', null, null);       
insert into ig.soc0109 values('CI060000000121', 'CM06000000', '第十四笔应付日', 'IG_0250', null, null, '1', 0, '002', null, '3', '999011', null, null);         
insert into ig.soc0109 values('CI060000000122', 'CM06000000', '第十四笔制单日', 'IG_0251', null, null, '1', 0, '002', null, '3', '999011', null, null);         
insert into ig.soc0109 values('CI060000000123', 'CM06000000', '第十四笔实付日', 'IG_0252', null, null, '1', 0, '002', null, '3', '999011', null, null);         
insert into ig.soc0109 values('CI060000000124', 'CM06000000', '发票说明', 'IG_0253', null, null, '1', 0, '002', null, '0', '999011', null, null);               
insert into ig.soc0109 values('CI060000000125', 'CM06000000', '第十五笔应付款额', 'IG_0254', null, null, '1', 0, '002', null, '7', '999011', null, null);       
insert into ig.soc0109 values('CI060000000126', 'CM06000000', '第十五笔应付款比例', 'IG_0255', null, null, '1', 0, '002', null, '0', '999011', null, null);     
insert into ig.soc0109 values('CI060000000127', 'CM06000000', '第十五笔实付款额', 'IG_0256', null, null, '1', 0, '002', null, '7', '999011', null, null);       
insert into ig.soc0109 values('CI060000000128', 'CM06000000', '第十五笔应付日', 'IG_0257', null, null, '1', 0, '002', null, '3', '999011', null, null);         
insert into ig.soc0109 values('CI060000000129', 'CM06000000', '第十五笔制单日', 'IG_0258', null, null, '1', 0, '002', null, '3', '999011', null, null);         
insert into ig.soc0109 values('CI060000000130', 'CM06000000', '第十五笔实付日', 'IG_0259', null, null, '1', 0, '002', null, '3', '999011', null, null);         
insert into ig.soc0109 values('CI060000000131', 'CM06000000', '发票说明', 'IG_0260', null, null, '1', 0, '002', null, '0', '999011', null, null);               
insert into ig.soc0109 values('CI060000000132', 'CM06000000', '财审委意见', null, null, null, '1', 2, '002', null, '0', '999011', null, '0');                   
insert into ig.soc0109 values('CI060000000133', 'CM06000000', '财审会会议纪要编号', null, null, null, '1', 2, '002', null, '0', '999011', null, '0');           
insert into ig.soc0109 values('CI060000000134', 'CM06000000', '合同存放柜号', null, null, null, '1', 2, '001', null, '0', '999011', null, '1');                 
insert into ig.soc0109 values('CI060000000135', 'CM06000000', '合同存放盒号', null, null, null, '1', 2, '001', null, '0', '999011', null, '1');                 
insert into ig.soc0109 values('CI060000000136', 'CM06000000', '合同存放文件号', null, null, null, '1', 2, '001', null, '0', '999011', null, '1');               
         
--文档
insert into ig.soc0109 values('CI070000000001', 'CM07000000', '保密性要求', null, null, null, '1', '2', '001', '054', '2', '999013', null, '0'); 
insert into ig.soc0109 values('CI070000000002', 'CM07000000', '可用性要求', null, null, null, '1', '2', '001', '055', '2', '999013', null, '0'); 
insert into ig.soc0109 values('CI070000000003', 'CM07000000', '完整性要求', null, null, null, '1', '2', '001', '056', '2', '999013', null, '0'); 
insert into ig.soc0109 values('CI070000000004', 'CM07000000', '存放介质', null, null, null, '1', '2', '001', '035', '2', '999013', null, '0'); 
insert into ig.soc0109 values('CI070000000005', 'CM07000000', '存储方式', null, null, null, '1', '2', '001', '041', '2', '999013', null, '0'); 
insert into ig.soc0109 values('CI070000000006', 'CM07000000', '保管人', null, null, null, '1', '2', '001', '999010', '4', '999013', null, '0'); 
insert into ig.soc0109 values('CI070000000007', 'CM07000000', '适用对象及发放范围', null, null, null, '1', '2', '001', '', '0', '999013', null, '0'); 
insert into ig.soc0109 values('CI070000000008', 'CM07000000', '文件内容简述', null, null, null, '1', '2', '001', '', '6', '999013', null, '0'); 
insert into ig.soc0109 values('CI070000000009', 'CM07000000', '附件上传', null, null, null, '1', '2', '001', '', '1', '999013', null, '0'); 
insert into ig.soc0109 values('CI070000000010', 'CM07000000', '归档部门', null, null, null, '1', '2', '001', '', '0', '999013', null, '0'); 
insert into ig.soc0109 values('CI070000000011', 'CM07000000', '保管期限', null, null, null, '1', '2', '001', '048', '2', '999013', null, '1'); 
insert into ig.soc0109 values('CI070000000012', 'CM07000000', '归档年度', null, null, null, '1', '2', '001', '049', '2', '999013', null, '1'); 
insert into ig.soc0109 values('CI070000000013', 'CM07000000', '文件编号', null, null, null, '1', '2', '001', '', '0', '999013', null, '0'); 
insert into ig.soc0109 values('CI070000000014', 'CM07000000', '密级', null, null, null, '1', '2', '001', '050', '2', '999013', null, '1'); 
insert into ig.soc0109 values('CI070000000015', 'CM07000000', '存放柜号', null, null, null, '2', '2', '001', '', '0', '999013', null, '1'); 
insert into ig.soc0109 values('CI070000000016', 'CM07000000', '存放盒号', null, null, null, '2', '2', '001', '', '0', '999013', null, '1'); 
insert into ig.soc0109 values('CI070000000017', 'CM07000000', '存放文件号', null, null, null, '2', '2', '001', '', '0', '999013', null, '1'); 
--技术文档
insert into ig.soc0109 values('CI070000000018', 'CM07000001', '需求说明书', null, null, null, '1', '2', '001', '', '1', '999013001', null, '0'); 
insert into ig.soc0109 values('CI070000000019', 'CM07000001', '详细设计书', null, null, null, '1', '2', '001', '', '1', '999013001', null, '0'); 
insert into ig.soc0109 values('CI070000000020', 'CM07000001', '操作手册', null, null, null, '1', '2', '001', '', '1', '999013001', null, '0'); 
--应急预案
insert into ig.soc0109 values('CI070000000021', 'CM07000003', '启用决策者', null, null, null, '1', '2', '001', '', '0', '999013003', null, '0'); 
insert into ig.soc0109 values('CI070000000022', 'CM07000003', '涉及人员范围', null, null, null, '1', '2', '001', '', '0', '999013003', null, '0'); 
insert into ig.soc0109 values('CI070000000023', 'CM07000003', '联系人信息', null, null, null, '1', '2', '001', '', '0', '999013003', null, '0'); 
insert into ig.soc0109 values('CI070000000024', 'CM07000003', '替补联系人信息', null, null, null, '1', '2', '001', '', '0', '999013003', null, '0'); 
insert into ig.soc0109 values('CI070000000025', 'CM07000003', '内容简述', null, null, null, '1', '2', '001', '', '0', '999013003', null, '0'); 
--文档模板
insert into ig.soc0109 values('CI070000000026', 'CM07000004', '模板文件', null, null, null, '1', '2', '001', '', '1', '999013004', null, '0'); 
insert into ig.soc0109 values('CI070000000027', 'CM07000004', '模板类型', null, null, null, '1', '2', '001', '057', '2', '999013004', null, '0'); 
insert into ig.soc0109 values('CI070000000028', 'CM07000004', '模板填写要求', null, null, null, '1', '2', '001', '', '6', '999013004', null, '0'); 
insert into ig.soc0109 values('CI070000000029', 'CM07000004', '填写要求附件', null, null, null, '1', '2', '001', '', '1', '999013004', null, '0'); 
--项目文档
insert into ig.soc0109 values('CI070000000030', 'CM07000005', '项目名称', null, null, null, '1', '2', '001', '', '0', '999013005', null, '0'); 

--数据资产
insert into ig.soc0109 values('CI090000000001', 'CM09000000', '保密性要求', null, null, null, '1', '2', '001', '020', '2', '999004', null, '0'); 
insert into ig.soc0109 values('CI090000000002', 'CM09000000', '可用性要求', null, null, null, '1', '2', '001', '136', '2', '999004', null, '0'); 
insert into ig.soc0109 values('CI090000000003', 'CM09000000', '完整性要求', null, null, null, '1', '2', '001', '135', '2', '999004', null, '0'); 
--数据备份
insert into ig.soc0109 values('CI090000000004', 'CM09000001', '信息系统名称', null, null, null, '1', '2', '001', '999003', '4', '999004001', null, '0'); 
insert into ig.soc0109 values('CI090000000005', 'CM09000001', '数据备份频率', null, null, null, '1', '2', '001', '', '0', '999004001', null, '0'); 
insert into ig.soc0109 values('CI090000000006', 'CM09000001', '备份时间窗口', null, null, null, '1', '2', '001', '', '0', '999004001', null, '0'); 
insert into ig.soc0109 values('CI090000000007', 'CM09000001', '保留周期', null, null, null, '1', '2', '001', '', '0', '999004001', null, '0'); 
insert into ig.soc0109 values('CI090000000008', 'CM09000001', '备份类型', null, null, null, '1', '2', '001', '044', '5', '999004001', null, '0'); 
insert into ig.soc0109 values('CI090000000009', 'CM09000001', '备份介质', null, null, null, '1', '2', '001', '045', '5', '999004001', null, '0'); 
insert into ig.soc0109 values('CI090000000010', 'CM09000001', '异地备份', null, null, null, '1', '2', '001', '011', '2', '999004001', null, '0'); 
insert into ig.soc0109 values('CI090000000011', 'CM09000001', 'HA', null, null, null, '1', '2', '001', '011', '2', '999004001', null, '0'); 
insert into ig.soc0109 values('CI090000000012', 'CM09000001', '数据主管部门', null, null, null, '1', '2', '001', '', '0', '999004001', null, '0'); 
insert into ig.soc0109 values('CI090000000013', 'CM09000001', '验证方式', null, null, null, '1', '2', '001', '', '0', '999004001', null, '0'); 
insert into ig.soc0109 values('CI090000000014', 'CM09000001', '验证周期', null, null, null, '1', '2', '001', '', '0', '999004001', null, '0'); 
--数据清理
insert into ig.soc0109 values('CI090000000015', 'CM09000006', '清理时间', null, null, null, '1', '2', '001', '', '0', '999004002', null, '0'); 
insert into ig.soc0109 values('CI090000000016', 'CM09000006', '清理周期', null, null, null, '1', '2', '001', '', '0', '999004002', null, '0'); 
insert into ig.soc0109 values('CI090000000017', 'CM09000006', '存储介质', null, null, null, '1', '2', '001', '102', '5', '999004002', null, '0'); 