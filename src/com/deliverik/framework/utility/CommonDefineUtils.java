package com.deliverik.framework.utility;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.FastDateFormat;


/**
 * 常量定义
 *
 * @author 
 *
 */
public final class CommonDefineUtils {

	/** 日期格式定义 */
	public final static FastDateFormat DATETIME_FORMAT = FastDateFormat.getInstance("yyyy/MM/dd HH:mm");
	
	/** 日期格式定义 */
	public final static FastDateFormat DATETIME_SECOND_FORMAT = FastDateFormat.getInstance("yyyy/MM/dd HH:mm:ss");

	public final static FastDateFormat DATE_FORMAT = FastDateFormat.getInstance("yyyy/MM/dd");

	public final static FastDateFormat YEAR_FORMAT = FastDateFormat.getInstance("yyyy");

	/** 资产类型分类定义 */
	
	/** 资产模型层次码每级的位数 */
	public final static int ESYSCODING_NODE_LENGTH = 6;
	
	/** SOC资产模型层次码每级的位数 */
	public final static int SOC_ESYSCODING_NODE_LENGTH = 3;

	/** 资产模型层次码每级的最大数 */
	public final static String ESYSCODING_NODE_MAX_NUM = StringUtils.leftPad("9", ESYSCODING_NODE_LENGTH, "9");
	
	/** 资产模型层次码最大级数 */
	public final static int ESYSCODING_MAX_LEVEL = 20;
	
	/** 资产类型分类（设备） */
	public final static String ENTIY_CATEGORY_DEVICE = "001";
	
	/** 资产类型层次码（设备） */
	public final static String ENTIY_CATEGORY_DEVICE_SYSCODING = "999001";
	
	/** 资产类型分类标识（设备） */
	public final static String ENTIY_CATEGORY_DEVICE_KEY = "SBZC";

	/** 资产类型分类标识（设备）  为阜新银行做修改   修改时间2010-7-2  唐晓娜 */
	public final static String ENTIY_CATEGORY_DEVICE_KEY_FX = "BOFX-KJ-IT";

	/** 资产类型分类（软件） */
	public final static String ENTIY_CATEGORY_SOFTWARE = "002";
	
	/** 资产类型层次码（软件） */
	public final static String ENTIY_CATEGORY_SOFTWARE_SYSCODING = "999002";
	
	/** 资产类型分类标识（软件） */
	public final static String ENTIY_CATEGORY_SOFTWARE_KEY = "RJZC";
	
	/** 资产类型分类（应用） */
	public final static String ENTIY_CATEGORY_APPLICATION = "003";
	
	/** 资产类型层次码（应用） */
	public final static String ENTIY_CATEGORY_APPLICATION_SYSCODING = "999003";
	
	/** 资产类型分类标识（应用） */
	public final static String ENTIY_CATEGORY_APPLICATION_KEY = "YYZC";
	
	/** 资产类型分类（数据） */
	public final static String ENTIY_CATEGORY_DATA = "004";
	
	/** 资产类型层次码（数据） */
	public final static String ENTIY_CATEGORY_DATA_SYSCODING = "999004";
	
	/** 资产类型分类标识（数据） */
	public final static String ENTIY_CATEGORY_DATA_KEY = "SJZC";

	/** 资产类型分类（服务商） */
	public final static String ENTIY_CATEGORY_SERVICE = "005";
	
	/** 资产类型层次码（服务商） */
	public final static String ENTIY_CATEGORY_SERVICE_SYSCODING = "999005";
	
	/** 资产类型分类标识（服务商） */
	public final static String ENTIY_CATEGORY_SERVICE_KEY = "FWSZ";
	
	/** 资产类型分类（系统） */
	public final static String ENTIY_CATEGORY_SYSTEM = "006";
	
	/** 资产类型层次码（系统） */
	public final static String ENTIY_CATEGORY_SYSTEM_SYSCODING = "999006";
	
	/** 资产类型分类标识（系统） */
	public final static String ENTIY_CATEGORY_SYSTEM_KEY = "XTZC";

	/** 资产类型分类（机房） */
	public final static String ENTIY_CATEGORY_COMPUTER_ROOM = "007";
	
	/** 资产类型层次码（机房） */
	public final static String ENTIY_CATEGORY_COMPUTER_ROOM_SYSCODING = "999007";
	
	/** 资产类型分类（机柜） */
	public final static String ENTIY_CATEGORY_COMPUTER_CONTAINER = "008";
	
	/** 资产类型分类EID（机柜） */
	public final static Integer ENTIY_CATEGORY_COMPUTER_CONTAINER_EID = 8;
	
	/** 资产类型层次码（机柜） */
	public final static String ENTIY_CATEGORY_COMPUTER_CONTAINER_SYSCODING = "999008";
	
	/** 资产类型分类（服务记录） */
	public final static String ENTIY_CATEGORY_SERVICE_RECORD = "009";
	
	/** 资产类型层次码（服务记录） */
	public final static String ENTIY_CATEGORY_SERVICE_RECORD_SYSCODING = "999009";
	
	/** 资产类型分类标识（服务记录） */
	public final static String ENTIY_CATEGORY_SERVICE_RECORD_KEY = "FWJL";
	
	/** 资产类型分类（人员） */
	public final static String ENTIY_CATEGORY_PERSON = "010";
	
	/** 资产类型层次码（人员） */
	public final static String ENTIY_CATEGORY_PERSON_SYSCODING = "999010";
	
	/** 资产类型分类标识（人员） */
	public final static String ENTIY_CATEGORY_PERSON_KEY = "RYZC";
	
	/** 资产类型分类（合同） */
	public final static String ENTIY_CATEGORY_CONTRACT = "011";
	
	/** 资产类型层次码（合同） */
	public final static String ENTIY_CATEGORY_CONTRACT_SYSCODING = "999011";
	
	/** 资产类型分类标识（合同） */
	public final static String ENTIY_CATEGORY_CONTRACT_KEY = "HTZC";

	/** 资产类型分类（组件） */
	public final static String ENTIY_CATEGORY_MODULE = "012";
	
	/** 资产类型层次码（组件） */
	public final static String ENTIY_CATEGORY_MODULE_SYSCODING = "999012";
	
	/** 资产类型分类标识（组件） */
	public final static String ENTIY_CATEGORY_MODULE_KEY = "ZJZC";
	
	/** 资产类型分类（文档） */
	public final static String ENTIY_CATEGORY_DOCUMENT = "013";
	
	/** 资产类型层次码（文档） */
	public final static String ENTIY_CATEGORY_DOCUMENT_SYSCODING = "999013";
	
	/** 资产类型分类标识（文档） */
	public final static String ENTIY_CATEGORY_DOCUMENT_KEY = "WDZC";
	
	/** 资产类型层次码（文档-应急制度） */
	public final static String ENTIY_CATEGORY_DOCUMENT_SYSCODING_SYSTEM = "999013002";
	
	/** 资产类型分类（发票） */
	public final static String ENTIY_CATEGORY_INVOICE = "014";
	
	/** 资产类型层次码（发票） */
	public final static String ENTIY_CATEGORY_INVOICE_SYSCODING = "999014";
	
	/** 资产类型分类标识（发票） */
	public final static String ENTIY_CATEGORY_INVOICE_KEY = "FPGL";
	
	/** 资产类型分类（外包人员） */
    public final static String ENTIY_CATEGORY_EPI_PERSON = "016";
    
    /** 资产类型层次码（外包人员） */
    public final static String ENTIY_CATEGORY_EPI_PERSON_SYSCODING = "999016";
    
    /** 资产类型分类标识（外包人员） */
    public final static String ENTIY_CATEGORY_EPI_PERSON_KEY = "WBRY";
	
	/** 资产类型分类（风险点） */
    public final static String ENTIY_CATEGORY_RISK = "017";
    
    /** 资产类型层次码（风险点） */
    public final static String ENTIY_CATEGORY_RISK_SYSCODING = "999017";
    
    /** 资产类型分类标识（风险点） */
    public final static String ENTIY_CATEGORY_RISK_KEY = "FXZC";
    
	/** 资产类型分类（检查项） */
    public final static String ENTIY_CATEGORY_CHECKITEMS = "018";
    
    /** 资产类型层次码（检查项） */
    public final static String ENTIY_CATEGORY_CHECKITEMS_SYSCODING = "999018";
    
    /** 资产类型分类标识（检查项） */
    public final static String ENTIY_CATEGORY_CHECKITEMS_KEY = "JCZC";
    
    /** 资产类型分类标识（检查项） */
    public final static String ENTIY_CHECK_CHECKITEMS_KEY = "IG-X";
    
    
    /** 资产类型分类标识（风险点） */
    public final static String ENTIY_CHECK_RISK_ITEMS_KEY = "IG-D";
    
    /** 资产类型分类（风险指标） */
    public final static String ENTIY_CATEGORY_RISK_TARGET = "019";
    
    /** 资产类型层次码（风险指标） */
    public final static String ENTIY_CATEGORY_RISK_TARGET_SYSCODING = "999019";
    
    /** 资产类型分类标识（风险指标） */
    public final static String ENTIY_CATEGORY_RISK_TARGET_KEY = "IG-R";
    
    /** 资产类型分类（风险事件） */
    public final static String ENTIY_CATEGORY_RISK_CASE = "020";
    
    /** 资产类型层次码（风险事件） */
    public final static String ENTIY_CATEGORY_RISK_CASE_SYSCODING = "999020";
    
    /** 资产类型分类标识（风险事件） */
    public final static String ENTIY_CATEGORY_RISK_CASE_KEY = "SJZC";
    
    /** 资产类型分类（信息安全 检查项） */
    public final static String ENTIY_CATEGORY_SAFETY_CHECKITEMS = "021";
    
    /** 资产类型层次码（信息安全 检查项） */
    public final static String ENTIY_CATEGORY_SAFETY_CHECKITEMS_SYSCODING = "999021";
    
    /** 资产类型分类标识（信息安全 检查项） */
    public final static String ENTIY_CATEGORY_SAFETY_CHECKITEMS_KEY = "IG-S";
    
    
	/** 组件所属设备关系id */
	public final static String MODULE_RELATION_ENTIY_ID = "37";
	
	/** 组件所属设备关系code */
	public final static String MODULE_RELATION_ENTIY_CODE = "012-001";
	
	/** 组件与组件关系id */
	public final static String MODULE_RELATION_MODULE_ID = "41";
	
	/** 组件所属组件关系code */
	public final static String MODULE_RELATION_MODULE_CODE = "012-012";
	
	/** 机房和分区的所属关系ID */
	public final static String ROOM_PART_ASSIGN_RELATION = "B";
	
	/** 机房和机柜的所属关系ID */
	public final static String ROOM_CONTAINER_ASSIGN_RELATION = "A";
	
	public final static String ROOM_CONTAINER_ASSIGN_RELATION_CODE = "007-008";
	
	/** 机房和分区的所属关系ID */
	public final static String PART_DEVICE_ASSIGN_RELATION_CODE = "007-007";
	
	/** 机房、分区和设备的所属关系ID */
	public final static String ROOM_EQUIPMENT_RELATION_CODE = "007-001";
	
	/** 分区和机柜的所属关系ID */
	public final static String PART_CONTAINER_ASSIGN_RELATION = "C";
	
	/** 机柜和设备的所属关系ID */
	public final static String CONTAINER_DEVICE_ASSIGN_RELATION = "B";
	
	public final static String CONTAINER_DEVICE_ASSIGN_RELATION_CODE = "001-008";
	
	/** 缺省共通配置信息表示 */
	public final static String DEFAULT_COMMON_CONFIG_INFO = "0";
	
	/** 可选共通配置信息表示 */
	public final static String SELECT_COMMON_CONFIG_INFO = "1";
	
	/** 数据信息排序方法 */
	public final static int CODE_DETAIL_ORDER_BY_MODE_0 = 0;

	/** 数据信息排序方法 */
	public final static int CODE_DETAIL_ORDER_BY_MODE_1 = 1;
	
	/** 数据信息树排序方法 */
	public final static int CODE_DETAIL_ORDER_BY_MODE_2 = 2;
	
	public final static int CODE_DETAIL_ORDER_BY_MODE_3 = 3;
	
	/** 数据信息排序方法 */
	public final static int TREE_LEVEL_CODE = 3;

	/** 服务记录指定关系id*/
	public final static String SERVICE_RECORD_EIRRELATION_CID = "10";
	
	/** 预案类型分类（设备） */
	public final static String ENTIY_CATEGORY_PLAN = "801";
	
	/** 预案类型层次码（设备） */
	public final static String ENTIY_CATEGORY_PLAN_SYSCODING = "888001";
	
	/** 预案类型分类标识（设备） */
	public final static String ENTIY_CATEGORY_PLAN_KEY = "YABH";
	
	//************************* 资产状态************************************
	
	/** 资产状态：入库 */
	public final static String ENTITYITEM_STARUS_NEW = "N";
	
	/** 资产状态：下发 */
	public final static String ENTITYITEM_STARUS_USE = "U";
	
	/** 资产状态：上缴 */
	public final static String ENTITYITEM_STARUS_RENEW = "R";
	
	/** 资产状态：预报废 */
	public final static String ENTITYITEM_STARUS_PRESCRAP = "P";
	
	/** 资产状态：报废 */
	public final static String ENTITYITEM_STARUS_SCRAP = "S";

	public final static int CCID_LENGTH = 3;
	
	public final static int CID_LENGTH = 4;

	/** 流程附件保存目录名称 */
	public static final String APPLICATIONNAME = "svc";

	private CommonDefineUtils(){}
	
	/** 关联机房属性 */
	public final static String PART_ROOM = "IG_0101";
	
	/** 关联地板X */
	public final static String PART_X = "IG_0102";
	
	/** 关联地板Y */
	public final static String PART_Y = "IG_0103";

	//************************* 机构树排序方式************************************
	
	/** 按照ORGUSERCODING升序排序 */
	public final static String SORT_BY_ORGSYSCODING = "BYSYSCODING";
	
	public final static String ENTIY_CATEGORY_ORGANIZATION = "0419001";
	
	//************************* 合同付款信息 ************************************
	
	/** 项目名称 */
	public final static String ENTIY_COMPACT_PROJECTNAME="IG_0110";
	
	/** 第一笔付款额 */
	public final static String ENTIY_COMPACT_ACTUALMONEY1="IG_0117";
	
	/** 第一笔应付日 */
	public final static String ENTIY_COMPACT_EXPECTDAY1="IG_0118";
	
	/** 第一笔实付日 */
	public final static String ENTIY_COMPACT_ACTUALDAY1="IG_0119";
	
	/** 发票说明 */
	public final static String ENTIY_COMPACT_INVOICEEXPLAIN1="IG_0120";
	
	/** 第二笔付款额 */
	public final static String ENTIY_COMPACT_ACTUALMONEY2="IG_0121";
	
	/** 第二笔应付日 */
	public final static String ENTIY_COMPACT_EXPECTDAY2="IG_0122";
	
	/** 第二笔实付日 */
	public final static String ENTIY_COMPACT_ACTUALDAY2="IG_0123";
	
	/** 发票说明 */
	public final static String ENTIY_COMPACT_INVOICEEXPLAIN2="IG_0124";
	
	/** 第三笔付款额 */
	public final static String ENTIY_COMPACT_ACTUALMONEY3="IG_0125";
	
	/** 第三笔应付日 */
	public final static String ENTIY_COMPACT_EXPECTDAY3="IG_0126";
	
	/** 第三笔实付日 */
	public final static String ENTIY_COMPACT_ACTUALDAY3="IG_0127";
	
	/** 发票说明 */
	public final static String ENTIY_COMPACT_INVOICEEXPLAIN3="IG_0128";
	
	/** 第四笔付款额 */
	public final static String ENTIY_COMPACT_ACTUALMONEY4="IG_0129";
	
	/** 第四笔应付日 */
	public final static String ENTIY_COMPACT_EXPECTDAY4="IG_0130";
	
	/** 第四笔实付日 */
	public final static String ENTIY_COMPACT_ACTUALDAY4="IG_0131";
	
	/** 发票说明 */
	public final static String ENTIY_COMPACT_INVOICEEXPLAIN4="IG_0132";
	
	/** 第五笔付款额 */
	public final static String ENTIY_COMPACT_ACTUALMONEY5="IG_0133";
	
	/** 第五笔应付日 */
	public final static String ENTIY_COMPACT_EXPECTDAY5="IG_0134";
	
	/** 第五笔实付日 */
	public final static String ENTIY_COMPACT_ACTUALDAY5="IG_0135";
	
	/** 发票说明 */
	public final static String ENTIY_COMPACT_INVOICEEXPLAIN5="IG_0136";
	
	/** 第6笔付款额 */
    public final static String ENTIY_COMPACT_ACTUALMONEY6="IG_0191";
    
    /** 第6笔应付日 */
    public final static String ENTIY_COMPACT_EXPECTDAY6="IG_0194";
    
    /** 第6笔实付日 */
    public final static String ENTIY_COMPACT_ACTUALDAY6="IG_0196";
    
    /** 发票说明 */
    public final static String ENTIY_COMPACT_INVOICEEXPLAIN6="IG_0197";
    
    /** 第7笔付款额 */
    public final static String ENTIY_COMPACT_ACTUALMONEY7="IG_0198";
    
    /** 第7笔应付日 */
    public final static String ENTIY_COMPACT_EXPECTDAY7="IG_0201";
    
    /** 第7笔实付日 */
    public final static String ENTIY_COMPACT_ACTUALDAY7="IG_0203";
    
    /** 发票说明 */
    public final static String ENTIY_COMPACT_INVOICEEXPLAIN7="IG_0204";
    
    /** 第8笔付款额 */
    public final static String ENTIY_COMPACT_ACTUALMONEY8="IG_0205";
    
    /** 第8笔应付日 */
    public final static String ENTIY_COMPACT_EXPECTDAY8="IG_0208";
    
    /** 第8笔实付日 */
    public final static String ENTIY_COMPACT_ACTUALDAY8="IG_0210";
    
    /** 发票说明 */
    public final static String ENTIY_COMPACT_INVOICEEXPLAIN8="IG_0211";
    
    /** 第9笔付款额 */
    public final static String ENTIY_COMPACT_ACTUALMONEY9="IG_0212";
    
    /** 第9笔应付日 */
    public final static String ENTIY_COMPACT_EXPECTDAY9="IG_0215";
    
    /** 第9笔实付日 */
    public final static String ENTIY_COMPACT_ACTUALDAY9="IG_0217";
    
    /** 发票说明 */
    public final static String ENTIY_COMPACT_INVOICEEXPLAIN9="IG_0218";
    
    /** 第10笔付款额 */
    public final static String ENTIY_COMPACT_ACTUALMONEY10="IG_0219";
    
    /** 第10笔应付日 */
    public final static String ENTIY_COMPACT_EXPECTDAY10="IG_0222";
    
    /** 第10笔实付日 */
    public final static String ENTIY_COMPACT_ACTUALDAY10="IG_0224";
    
    /** 发票说明 */
    public final static String ENTIY_COMPACT_INVOICEEXPLAIN10="IG_0225";
    
    /** 第11笔付款额 */
    public final static String ENTIY_COMPACT_ACTUALMONEY11="IG_0226";
    
    /** 第11笔应付日 */
    public final static String ENTIY_COMPACT_EXPECTDAY11="IG_0229";
    
    /** 第11笔实付日 */
    public final static String ENTIY_COMPACT_ACTUALDAY11="IG_0231";
    
    /** 发票说明 */
    public final static String ENTIY_COMPACT_INVOICEEXPLAIN11="IG_0232";
    
    /** 第12笔付款额 */
    public final static String ENTIY_COMPACT_ACTUALMONEY12="IG_0233";
    
    /** 第12笔应付日 */
    public final static String ENTIY_COMPACT_EXPECTDAY12="IG_0236";
    
    /** 第12笔实付日 */
    public final static String ENTIY_COMPACT_ACTUALDAY12="IG_0238";
    
    /** 发票说明 */
    public final static String ENTIY_COMPACT_INVOICEEXPLAIN12="IG_0239";
    
    /** 第13笔付款额 */
    public final static String ENTIY_COMPACT_ACTUALMONEY13="IG_0240";
    
    /** 第13笔应付日 */
    public final static String ENTIY_COMPACT_EXPECTDAY13="IG_0243";
    
    /** 第13笔实付日 */
    public final static String ENTIY_COMPACT_ACTUALDAY13="IG_0245";
    
    /** 发票说明 */
    public final static String ENTIY_COMPACT_INVOICEEXPLAIN13="IG_0246";
    
    /** 第14笔付款额 */
    public final static String ENTIY_COMPACT_ACTUALMONEY14="IG_0247";
    
    /** 第14笔应付日 */
    public final static String ENTIY_COMPACT_EXPECTDAY14="IG_0250";
    
    /** 第14笔实付日 */
    public final static String ENTIY_COMPACT_ACTUALDAY14="IG_0252";
    
    /** 发票说明 */
    public final static String ENTIY_COMPACT_INVOICEEXPLAIN14="IG_0253";
    
    /** 第15笔付款额 */
    public final static String ENTIY_COMPACT_ACTUALMONEY15="IG_0254";
    
    /** 第15笔应付日 */
    public final static String ENTIY_COMPACT_EXPECTDAY15="IG_0257";
    
    /** 第15笔实付日 */
    public final static String ENTIY_COMPACT_ACTUALDAY15="IG_0259";
    
    /** 发票说明 */
    public final static String ENTIY_COMPACT_INVOICEEXPLAIN15="IG_0260";
	
	/** 已付款 */
	public final static String ENTIY_COMPACT_ACCOUNTMONEY="IG_0137";
	
	/** 最后付款日 */
	public final static String ENTIY_COMPACT_LASTDATETIME="IG_0138";
	
	/** 第一笔制单日 */
	public final static String ENTIY_COMPACT_ZHIDANDAY1="IG_0158";
	
	/** 第一笔应付款比例 */
	public final static String ENTIY_COMPACT_YINGFUMONEYRATIO1="IG_0166";
	
	/** 第一笔实付款额 */
	public final static String ENTIY_COMPACT_SHIFUMONEY1="IG_0153";
	
	/** 第二笔制单日 */
	public final static String ENTIY_COMPACT_ZHIDANDAY2="IG_0159";
	
	/** 第二笔应付款比例 */
	public final static String ENTIY_COMPACT_YINGFUMONEYRATIO2="IG_0167";
	
	/** 第二笔实付款额 */
	public final static String ENTIY_COMPACT_SHIFUMONEY2="IG_0154";
	
	/** 第三笔制单日 */
	public final static String ENTIY_COMPACT_ZHIDANDAY3="IG_0160";
	
	/** 第三笔应付款比例 */
	public final static String ENTIY_COMPACT_YINGFUMONEYRATIO3="IG_0168";
	
	/** 第三笔实付款额 */
	public final static String ENTIY_COMPACT_SHIFUMONEY3="IG_0155";
	
	/** 第四笔制单日 */
	public final static String ENTIY_COMPACT_ZHIDANDAY4="IG_0161";
	
	/** 第四笔应付款比例 */
	public final static String ENTIY_COMPACT_YINGFUMONEYRATIO4="IG_0169";
	
	/** 第四笔实付款额 */
	public final static String ENTIY_COMPACT_SHIFUMONEY4="IG_0156";
	
	/** 第五笔制单日 */
	public final static String ENTIY_COMPACT_ZHIDANDAY5="IG_0162";
	
	/** 第五笔应付款比例 */
	public final static String ENTIY_COMPACT_YINGFUMONEYRATIO5="IG_0170";
	
	/** 第五笔实付款额 */
	public final static String ENTIY_COMPACT_SHIFUMONEY5="IG_0157";
	
	/** 第6笔制单日 */
    public final static String ENTIY_COMPACT_ZHIDANDAY6="IG_0195";
    
    /** 第6笔应付款比例 */
    public final static String ENTIY_COMPACT_YINGFUMONEYRATIO6="IG_0192";
    
    /** 第6笔实付款额 */
    public final static String ENTIY_COMPACT_SHIFUMONEY6="IG_0193";
    
    /** 第7笔制单日 */
    public final static String ENTIY_COMPACT_ZHIDANDAY7="IG_0202";
    
    /** 第7笔应付款比例 */
    public final static String ENTIY_COMPACT_YINGFUMONEYRATIO7="IG_0199";
    
    /** 第7笔实付款额 */
    public final static String ENTIY_COMPACT_SHIFUMONEY7="IG_0200";
    
    /** 第8笔制单日 */
    public final static String ENTIY_COMPACT_ZHIDANDAY8="IG_0209";
    
    /** 第8笔应付款比例 */
    public final static String ENTIY_COMPACT_YINGFUMONEYRATIO8="IG_0206";
    
    /** 第8笔实付款额 */
    public final static String ENTIY_COMPACT_SHIFUMONEY8="IG_0207";
    
    /** 第9笔制单日 */
    public final static String ENTIY_COMPACT_ZHIDANDAY9="IG_0216";
    
    /** 第9笔应付款比例 */
    public final static String ENTIY_COMPACT_YINGFUMONEYRATIO9="IG_0213";
    
    /** 第9笔实付款额 */
    public final static String ENTIY_COMPACT_SHIFUMONEY9="IG_0214";
    
    /** 第10笔制单日 */
    public final static String ENTIY_COMPACT_ZHIDANDAY10="IG_0223";
    
    /** 第10笔应付款比例 */
    public final static String ENTIY_COMPACT_YINGFUMONEYRATIO10="IG_0220";
    
    /** 第10笔实付款额 */
    public final static String ENTIY_COMPACT_SHIFUMONEY10="IG_0221";
    
    /** 第11笔制单日 */
    public final static String ENTIY_COMPACT_ZHIDANDAY11="IG_0230";
    
    /** 第11笔应付款比例 */
    public final static String ENTIY_COMPACT_YINGFUMONEYRATIO11="IG_0227";
    
    /** 第11笔实付款额 */
    public final static String ENTIY_COMPACT_SHIFUMONEY11="IG_0228";
    
    /** 第12笔制单日 */
    public final static String ENTIY_COMPACT_ZHIDANDAY12="IG_0237";
    
    /** 第12笔应付款比例 */
    public final static String ENTIY_COMPACT_YINGFUMONEYRATIO12="IG_0234";
    
    /** 第12笔实付款额 */
    public final static String ENTIY_COMPACT_SHIFUMONEY12="IG_0235";
    
    /** 第13笔制单日 */
    public final static String ENTIY_COMPACT_ZHIDANDAY13="IG_0244";
    
    /** 第13笔应付款比例 */
    public final static String ENTIY_COMPACT_YINGFUMONEYRATIO13="IG_0241";
    
    /** 第13笔实付款额 */
    public final static String ENTIY_COMPACT_SHIFUMONEY13="IG_0242";
    
    /** 第14笔制单日 */
    public final static String ENTIY_COMPACT_ZHIDANDAY14="IG_0251";
    
    /** 第14笔应付款比例 */
    public final static String ENTIY_COMPACT_YINGFUMONEYRATIO14="IG_0248";
    
    /** 第14笔实付款额 */
    public final static String ENTIY_COMPACT_SHIFUMONEY14="IG_0249";
    
    /** 第15笔制单日 */
    public final static String ENTIY_COMPACT_ZHIDANDAY15="IG_0258";
    
    /** 第15笔应付款比例 */
    public final static String ENTIY_COMPACT_YINGFUMONEYRATIO15="IG_0255";
    
    /** 第15笔实付款额 */
    public final static String ENTIY_COMPACT_SHIFUMONEY15="IG_0256";
	
	/** 服务商 */
	public final static String ENTIY_COMPACT_FUWUSHANG="IG_0113";
	
	/** 主机码*/
	public final static String HOST_ESYSCODING="999001001";
	
	/** 交换机码*/
	public final static String SWITCH_ESYSCODING="999001006";
	
	/** 存储码*/
	public final static String STORAGE_ESYSCODING="999001009";
	
	/** ORACLE码*/
	public final static String ORACLE_ESYSCODING="999002001001";
	
	/** WEBLOGIC码*/
	public final static String WEBLOGIC_ESYSCODING="999002002001";
	
	/** Tuxedo码*/
	public final static String Tuxedo_ESYSCODING="999002002003";
	
	/** Jboss Server码*/
	public final static String Jboss_Server_ESYSCODING="999002002004001";
	
	/** 默认域名字*/
	public final static String DOMAIN_NAME="SOC域";
}
