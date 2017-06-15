/*
 * 沈阳递蓝科信息技术有限公司版权所有，保留所有权利。
 * Copyright 2009 Deliverik Co. Ltd.， All rights reserved.
 */

package com.deliverik.framework.soc.asset;


/**
 * 资产属性关键字常量类
 */
public final class EntityItemKeyWords {
	
	/** 关键字起始编号 */
	public final static String COMMON_CONFIG_LABEL_MIN = "IG_0001";
	
	/** 关键字终了编号 */
	public final static String COMMON_CONFIG_LABEL_MAX = "IG_9999";
	
	
	/**
	 * 设备（模型标识：001）关键字
	 * 
	 */
	//设备状态
	public static final String ENTITY_DEFAULT_PROPERTY_STATUS = "IG_0001";
	//操作人ID
	public static final String ENTITY_DEFAULT_PROPERTY_OPERATORID = "IG_0002";
	//操作人姓名
	public static final String ENTITY_DEFAULT_PROPERTY_OPERATORNAME = "IG_0003";
	//接收人姓名
	public static final String ENTITY_DEFAULT_PROPERTY_RECIVENAME = "IG_0004";
	//接收人所属机构名称
	public static final String ENTITY_DEFAULT_PROPERTY_RECIVEORGNAME = "IG_0005";
	//接收人所属机构层次码
	public static final String ENTITY_DEFAULT_PROPERTY_RECIVEORGCODE = "IG_0006";
	//资产ID
	public static final String ENTITY_DEFAULT_DEVICE_EIID = "IG_0007";
	//资产名称
	public static final String ENTITY_DEFAULT_DEVICE_ENAME = "IG_0008";
	//资产模型ID
	public static final String ENTITY_DEFAULT_DEVICE_EID = "IG_0009";
	//资产模型标识
	public static final String ENTITY_DEFAULT_DEVICE_ECATEGORY = "IG_0010";
	//服务商ID
	public static final String ENTITY_DEFAULT_SERVICE_EIID = "IG_0011";
	//服务商名称
	public static final String ENTITY_DEFAULT_SERVICE_ENAME = "IG_0012";
	//服务商模型ID
	public static final String ENTITY_DEFAULT_SERVICE_EID = "IG_0013";
	//服务商模型标识
	public static final String ENTITY_DEFAULT_SERVICE_ECATEGORY = "IG_0014";
	//设备位置
	public static final String CLABEL_U_VALUE = "IG_0015";
	//设备高度
    public static final String CLABEL_U_WIDTH = "IG_0016";
    //型号
    public static final String ENTITY_DEFAULT_MODEL = "IG_0026";
    //序列号
    public static final String ENTITY_DEFAULT_SERIAL_NUMBER = "IG_0027";
    //购买日期
    public static final String ENTITY_DEFAULT_PURCHASE_DATE = "IG_0028";
    //维保日期
	public static final String ENTITY_DEFAULT_MAINTAIN_DATE = "IG_0029";
	
	/**
	 * 机房（模型标识：007）关键字
	 * 
	 */
	//横向宽度
	public static final String CLABEL_X_TOTAL = "IG_0017";
	//纵向宽度
	public static final String CLABEL_Y_TOTAL = "IG_0018";
	//负责人
	public static final String CLABEL_MANANGER = "IG_0019";
	//联系电话
	public static final String CLABEL_TEL = "IG_0020";
	
	/**
	 * 机柜（模型标识：008）关键字
	 * 
	 */
	//机柜位置X
	public static final String CLABEL_X_VALUE = "IG_0021";
	//机柜位置Y
	public static final String CLABEL_Y_VALUE = "IG_0022";
	//机柜高度(U)
	public static final String CLABEL_U_TOTAL = "IG_0023";
	//机柜横向宽
	public static final String CLABEL_X_WIDTH = "IG_0024";
	//机柜纵向宽
	public static final String CLABEL_Y_WIDTH = "IG_0025";
	
	
	/** 资产编号位数*/
	public static final int LABEL_LENGTH = 6;
	
	/** 资产编号其余位数*/
	public static final int LABEL_LEFT_LENGTH = 6;
	
	/** 资产编号最小值*/
	public static final String LABEL_MIN_ID = "000001";
	
	/** 资产编号最小值*/
	public static final String CHECK_LABEL_MIN_ID = "0101-001";
	
	/** 资产编号最大值*/
	public static final String LABEL_MAX_ID = "999999";
	
	/** 资产编号最大值*/
	public static final String CHECK_LABEL_MAX_ID = "0909-999";

	/** 资产编号位数 唐晓娜 修改于2010-7-2*/
	public static final int LABEL_LENGTH_FX = 3;
	
	/** 资产编号其余位数  唐晓娜 修改于2010-7-2*/
	public static final int LABEL_LEFT_LENGTH_FX = 13;
	
	/** 资产编号最小值    唐晓娜 修改于2010-7-2*/
	public static final String LABEL_MIN_ID_FX = "001";
	
	/** 资产编号最大值    唐晓娜 修改于2010-7-2*/
	public static final String LABEL_MAX_ID_FX = "999999";
	
	/** 资产编号填充符*/
	public static final String LABEL_LEFT_PAD = "0";
	
	/** 资产模型类别（配置资产模型） */
	public static final String EMODELTYPE_CONFIGURATION = "1";
	
	/**
	 * 
	 * 存储管理 常量
	 * 
	 */
	/** 存储树形关系CCID */
	public static final String SYMM_RELATION_CCID = "998";
	
	/** CODEDETAIL表中存储类型的CCID */
	public static final String SYMM_SUPERIOR_CCID = "913";
	
	/** CODEDETAIL表中存储的CCID */
	public static final String SYMM_CCID = "914";
	
	/** 存储报表登记人员id */
	public static final String SYMM_USERID="admin";
	
	/** 存储报表登记人员名称 */
	public static final String SYMM_USERNAME="系统管理员";
	
	/** 报表url */
	public static final String REDPARAMETERS="&dataid=";
	
	/** DMX存储 */
	public static final String SYMM_DMX="DMX";
	
	/** DMX存储CCID */
	public static final String SYMM_DMX_CCID="827";
	
	/** IBM存储 */
	public static final String SYMM_IBM="IBM";
	
	/** IBM存储CCID */
	public static final String SYMM_IBM_CCID="828";
	
	/** CX存储 */
	public static final String SYMM_CX="CX";
	
	/** CX存储CCID */
	public static final String SYMM_CX_CCID="829";
	
	/** Brocade交换机 */
	public static final String SYMM_BROCADE="Brocade";
	
	/** Brocade交换机CCID */
	public static final String SYMM_BROCADE_CCID="830";
	
	/** Mcdata交换机 */
	public static final String SYMM_MCDATA="Mcdata";
	
	/** Mcdata交换机CCID */
	public static final String SYMM_MCDATA_CCID="831";
	
	/** HDS存储 */
	public static final String SYMM_HDS="HDS";
	
	/** HDS存储CCID */
	public static final String SYMM_HDS_CCID="833";
	
	/** 自动报表URL */
	public static final String REPORTCONFIGURATION_URl="dataid:";
	
	/** 自动报表生成类型 对应的是年季月周日*/
	public static final String REPORTCONFIGURATION_TYPE="&&TYPE=11100";
	
	/** FS关系EID */
	public static final String FS_EID="CM01020016";
	
	/** 应用 EID */
	public static final String APP_EID="CM03010001";
	
	/** 应用 FS 关系*/
	public static final String APP_FS_Relation="CR030100010002";

	/** 应用 FS code*/
	public static final String APP_FS_RelationCODE="014-001";
	
	/** ORACLE实例EID */
	public static final int ORA_EID=153;
	
	/** ORACLE用户EID */
	public static final int ORA_USER_EID=154;
	
	/** ORACLE表空间EID */
	public static final int ORA_TABLESPACE_EID=155;
	
	/** 控制模型在资产树上显示和隐藏，使用entity表中预留字段EKEY1，0代表显示，1代表隐藏 */
	public static final String ENTITY_EKEY1_0="0";
	
	/** 是否可继承标识，使用entity表中预留字段EKEY2, 0代表继承，1代表不继承 */
	public static final String ENTITY_EKEY2_0="0";
	
	/** 主机eid */
	public static final String HOST_EID="CM01010001";
	
	/** 交换机eid */
	public static final String SWITCH_EID="CM01010006";
	
	/** 存储eid */
	public static final String STORAGE_EID="CM01010009";
	
	/** IBM主机eid */
	public static final String HOST_IBM_EID="CM01010020";
	/** HP主机eid */
	public static final String HOST_HP_EID="CM01010022";
	/** SUN主机eid */
	public static final String HOST_SUN_EID="CM01010031";
	/** VMWARE ESX主机eid */
	public static final String HOST_VMWARE_EID="CM01010032";
	/** VM主机eid */
	public static final String HOST_VM_EID="CM01010033";
	/** Linux主机eid */
	public static final String HOST_LINUX_EID="CM01010034";
	
	/** 主机接口卡eid */
	public static final String HBA_EID="CM01010002";
	/** HBA端口eid */
	public static final String HBA_PORT_EID="CM01010003";
	/** SAN端口eid */
	public static final String SAN_PORT_EID="CM01010008";
	/** 网络交换机端口eid */
	public static final String NETSAN_PORT_EID="CM01010036";
	/** 交换机模块eid */
	public static final String SAN_MODULE_EID="CM01010007";
	/** Borcade交换机eid */
	public static final String SAN_BROCADE_EID="CM01010021";
	/** CISCO交换机eid */
	public static final String SAN_CISCO_EID="CM01010029";
	/** MCDATA交换机eid */
	public static final String SAN_MCDATA_EID="CM01010030";
	/** 网络交换机eid */
	public static final String NETSAN_EID="CM01010035";
	/** 前端口eid */
	public static final String FA_PORT_EID="CM01010011";
	/** FAeid */
	public static final String FA_EID="CM01010010";
	/** 磁盘控制卡eid */
	public static final String DA_EID="CM01010012";
	/** LVeid */
	public static final String LV_EID="CM01020005";
	/** VGeid */
	public static final String VG_EID="CM01020004";
	/** Metaeid */
	public static final String META_EID="CM01020015";
	/** Hypereid */
	public static final String HYPER_EID="CM01020014";
	
	/** 业务系统eid */
	public static final String BUSINESS_EID="CM03010001";
	/** 服务提供者eid */
	public static final String SERVICE_PROVIDER_EID="CM03010002";
	/** "服务调用者"eid */
	public static final String SERVICE_INVOKER_EID="CM03010003";
	
	/** 数据中心eid */
	public static final String DATACENTER_EID="CM01010055";
	
	/** 集群eid */
	public static final String CLUSTER_EID="CM01010056";
	
	/** Esx主机eid */
	public static final String ESXHOST_EID="CM01010051";
	
	/** 数据存储eid */
	public static final String DATASTORE_EID="CM01010054";
	
	/** 网络eid */
	public static final String NETWORK_EID="CM01010053";
	
	/** 虚拟机eid */
	public static final String VM_EID="CM01010052";
	
	/** 应用-软件 code*/
	public static final String APP_SW_RelationCODE="003-002";
	
	/** 应用-VM code*/
	public static final String APP_VM_RelationCODE="003-001";
	
	/** 应用-服务 code*/
	public static final String APP_SERVICE_RelationCODE="003-003";
	
	/** 业务系统-服务提供者 关系*/
	public static final String BUSINESS_SP_Relation="CR030100010008";
	
	/** 业务系统-服务调用者 关系*/
	public static final String BUSINESS_SI_Relation="CR030100010009";
	
	/** 业务系统-业务系统 关系*/
	public static final String BUSINESS_BUSINESS_Relation="CR030100010017";
	
	/** 业务系统-外联系统 关系*/
	public static final String BUSINESS_OTHER_Relation="CR030100010018";
	
	/** 业务系统-应用模块 关系*/
	public static final String BUSINESS_MODULE_Relation="CR030100010019";
	
	/** 业务系统-主机 关系*/
	public static final String BUSINESS_HOST_Relation="CR030100010001";
	
	/** 服务提供者-服务调用者 关系*/
	public static final String SP_SI_Relation="CR030100010010";
	
	/**数据中心-集群*/
	public static final  String DATACENTER_CLUSTER_Relation="CR010100550001";
	
	/**数据中心-主机*/
	public static final  String DATACENTER_ESXHOST_Relation="CR010100550002";
	
	/**数据中心-网络*/
	public static final  String DATACENTER_NETWORK_Relation="CR010100550003";
	
	/**数据中心-数据存储*/
	public static final  String DATACENTER_DATASTORE_Relation="CR010100550004";
	
	/**集群-主机*/
	public static final  String CLUSTER_ESXHOST_Relation="CR010100560001";
	
	/**主机-虚拟机*/
	public static final  String ESXHOST_VM_Relation="CR010100510001";
	
	/**主机-HBA卡*/
	public static final  String ESXHOST_HBA_Relation="CR010100510004";
	
	/**HBA卡-LUN*/
	public static final  String HBA_LUN_Relation="CR010100020002";
	
	public static final  String APP_Relation="CR021000010001";
	
	public static final  String Relation_In ="'CR010100550001','CR010100550003','CR010100550004'";
		
	public static final String AIX_ESYSCODING="999001001001";//0
	public static final String APACHE_ESYSCODING="999002002007";//1
	public static final String DB2_ESYSCODING="999002001008";//2
	public static final String HPUX_ESYSCODING="999001001002";//3
	public static final String INFORMIX_ESYSCODING="999002001002";//4
	public static final String JBOSSSERVER_ESYSCODING="999002002004001";//5
	public static final String LINUX_ESYSCODING="999001001005";//6
	//public static final String MYSQL_ESYSCODING="999001001005";//7
	public static final String ORACLE_ESYSCODING="999002001001";//8
	//public static final String POSTGRESQL_ESYSCODING="999001001005";//9
	public static final String SCOUNIX_ESYSCODING="999001001007";//10
	public static final String SOLARIS_ESYSCODING="999001006002";//11
	public static final String SQLSERVER_ESYSCODING="999002001007";//12
	public static final String SYBASE_ESYSCODING="999002001006";//13
	public static final String TOMCAT_ESYSCODING="999002002008";//14
	public static final String TUXEDO_ESYSCODING="999002002003";//15
	public static final String WEBLOGIC_ESYSCODING="999002002001";//16
	public static final String WEBSPHERE_ESYSCODING="999002002005001001001001";//17
	public static final String WINDOWS_ESYSCODING="999001001006";//18
	public static final String BUSS_ESYSCODING="999003001";//99
	public static final String APP_ESYSCODING="999003005";//100
	
	
	public static final String BUSINESS_ESYSCODING="999003001";
	public static final String MACHINE_ESYSCODING="999002002003004";
	public static final String JBOSSWEBAPP_ESYSCODING="999002002004001001";
	public static final String APPSERVER_ESYSCODING="999002003";
	public static final String WEBAPP_ESYSCODING="999002002001001";
	public static final String INFORMIXSERVER_ESYSCODING="999002001002001";
	public static final String INSTANCE_ESYSCODING="999002001001";
	public static final String MODULE_ESYSCODING="999003005";
	public static final String DATABASE_ESYSCODING="999002001";
	public static final String HOST_ESYSCODING="999001001";
	public static final String NETWORKCI_ESYSCODING="999001028";
	public static final String APPCOURSE="999002003001";
	
	/** 主机——应用模块 关系*/
	public static final String HOST_APPMODULE_Relation="CR030100010001";
	
	/** Tuxedo Machine——INSTANCE 关系*/
	public static final String Machine_INSTANCE_Relation="CR020400050003";
	
	/** Tuxedo Machine——Informix Server 关系*/
	public static final String Machine_Informix_Server_Relation="CR020400050002";
	
	/** Jboss Webapp——INSTANCE 关系*/
	public static final String JbossWebapp_INSTANCE_Relation="CR020500030002";
	
	/** Jboss Webapp——Informix Server 关系*/
	public static final String JbossWebapp_Informix_Server_Relation="CR020500030001";
	
	/** Webligc Webapp——INSTANCE 关系*/
	public static final String WEBAPP_INSTANCE_Relation="CR020200020001";
	
	/** Webligc Webapp——Informix Server 关系*/
	public static final String WEBAPP_Informix_Server_Relation="";
	
	public static final String APPCOURSE_INSTANCE_Relation="CR021000010001";
	
	//密码关系
	public static final String PASSWORD_Relation="CR990100010001";
	
	/**业务管理员角色id*/
	public static final Integer ROLE_BUSINESS_MANAGER = 1014;
	
	//机架宽度(W)
	public static final String CLABEL_W_TOTAL = "IG_0104";
	//容器类型
	public static final String CLABEL_L_TOTAL = "IG_0105";
	//机架位置
	public static final String CLABEL_WZ_VALUE = "IG_0106";
	//层
	public static final String CLABEL_GRAPHINDEX = "IG_0030";
	//是否已设置
	public static final String CLABEL_GRAPHSTATUS = "IG_0031";
	//类型标识
	public static final String CLABEL_GRAPHTYPEID = "IG_0032";
	//类型名称
	public static final String CLABEL_GRAPHTYPENAME = "IG_0033";
	//额定电压
	public static final String CLABEL_VOLTAGE = "IG_0034";
	//机柜重量
	public static final String CLABEL_WEIGHT = "IG_0035";
	//机柜规格
	public static final String CLABEL_STANDARD = "IG_0036";
	//机柜最大负载
	public static final String CLABEL_MAXLOAD = "IG_0201";
	//机柜最大电力
	public static final String CLABEL_MAXPOWER = "IG_0202";
	//是否为我行服务商
	public static final String CLABEL_ISMYSERVICE = "IG_1908";
	
	/** 容器类型机柜编号*/
	public static final String CLABEL_PULLDOWN="0" ;
	
	/** 容器类型机架编号*/
	public static final String VALUE_PULLDOWN="1" ;
	
	/** 容器GRAPHSTATUS值 */
	public static final String graphstatusN = "0";
	
	/** 容器GRAPHSTATUS值 */
	public static final String graphstatusY = "1";
	
	/** 容器类型UPS编号前缀*/
	public static final String VALUE_UPS = "999001024001";
	
	/** 容器类型空调编号前缀*/
	public static final String VALUE_AIR_CONDITION = "999001024002";
	
	/** 机房类型编号 */
	public static final String COMPUTER_ROOM_ESYSCODING = "999007";
	
	/** 机柜类型编号 */
	public static final String CONTAINER = "999008";
	
	/** 容器GRAPHSTATUS属性ID*/
	public static final String GRAPHSTATUS_ID = "CI110000000007";
	
	/** 容器类型编号*/
	public static final String LABEL_PULLDOWN = "CI110000000019";
	
	private EntityItemKeyWords() {
	}
}
