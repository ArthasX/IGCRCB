package com.deliverik.framework.utility;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.time.FastDateFormat;


/**
 * ��������
 *
 * @author 
 *
 */
public final class CommonDefineUtils {

	/** ���ڸ�ʽ���� */
	public final static FastDateFormat DATETIME_FORMAT = FastDateFormat.getInstance("yyyy/MM/dd HH:mm");
	
	/** ���ڸ�ʽ���� */
	public final static FastDateFormat DATETIME_SECOND_FORMAT = FastDateFormat.getInstance("yyyy/MM/dd HH:mm:ss");

	public final static FastDateFormat DATE_FORMAT = FastDateFormat.getInstance("yyyy/MM/dd");

	public final static FastDateFormat YEAR_FORMAT = FastDateFormat.getInstance("yyyy");

	/** �ʲ����ͷ��ඨ�� */
	
	/** �ʲ�ģ�Ͳ����ÿ����λ�� */
	public final static int ESYSCODING_NODE_LENGTH = 6;
	
	/** SOC�ʲ�ģ�Ͳ����ÿ����λ�� */
	public final static int SOC_ESYSCODING_NODE_LENGTH = 3;

	/** �ʲ�ģ�Ͳ����ÿ��������� */
	public final static String ESYSCODING_NODE_MAX_NUM = StringUtils.leftPad("9", ESYSCODING_NODE_LENGTH, "9");
	
	/** �ʲ�ģ�Ͳ��������� */
	public final static int ESYSCODING_MAX_LEVEL = 20;
	
	/** �ʲ����ͷ��ࣨ�豸�� */
	public final static String ENTIY_CATEGORY_DEVICE = "001";
	
	/** �ʲ����Ͳ���루�豸�� */
	public final static String ENTIY_CATEGORY_DEVICE_SYSCODING = "999001";
	
	/** �ʲ����ͷ����ʶ���豸�� */
	public final static String ENTIY_CATEGORY_DEVICE_KEY = "SBZC";

	/** �ʲ����ͷ����ʶ���豸��  Ϊ�����������޸�   �޸�ʱ��2010-7-2  ������ */
	public final static String ENTIY_CATEGORY_DEVICE_KEY_FX = "BOFX-KJ-IT";

	/** �ʲ����ͷ��ࣨ����� */
	public final static String ENTIY_CATEGORY_SOFTWARE = "002";
	
	/** �ʲ����Ͳ���루����� */
	public final static String ENTIY_CATEGORY_SOFTWARE_SYSCODING = "999002";
	
	/** �ʲ����ͷ����ʶ������� */
	public final static String ENTIY_CATEGORY_SOFTWARE_KEY = "RJZC";
	
	/** �ʲ����ͷ��ࣨӦ�ã� */
	public final static String ENTIY_CATEGORY_APPLICATION = "003";
	
	/** �ʲ����Ͳ���루Ӧ�ã� */
	public final static String ENTIY_CATEGORY_APPLICATION_SYSCODING = "999003";
	
	/** �ʲ����ͷ����ʶ��Ӧ�ã� */
	public final static String ENTIY_CATEGORY_APPLICATION_KEY = "YYZC";
	
	/** �ʲ����ͷ��ࣨ���ݣ� */
	public final static String ENTIY_CATEGORY_DATA = "004";
	
	/** �ʲ����Ͳ���루���ݣ� */
	public final static String ENTIY_CATEGORY_DATA_SYSCODING = "999004";
	
	/** �ʲ����ͷ����ʶ�����ݣ� */
	public final static String ENTIY_CATEGORY_DATA_KEY = "SJZC";

	/** �ʲ����ͷ��ࣨ�����̣� */
	public final static String ENTIY_CATEGORY_SERVICE = "005";
	
	/** �ʲ����Ͳ���루�����̣� */
	public final static String ENTIY_CATEGORY_SERVICE_SYSCODING = "999005";
	
	/** �ʲ����ͷ����ʶ�������̣� */
	public final static String ENTIY_CATEGORY_SERVICE_KEY = "FWSZ";
	
	/** �ʲ����ͷ��ࣨϵͳ�� */
	public final static String ENTIY_CATEGORY_SYSTEM = "006";
	
	/** �ʲ����Ͳ���루ϵͳ�� */
	public final static String ENTIY_CATEGORY_SYSTEM_SYSCODING = "999006";
	
	/** �ʲ����ͷ����ʶ��ϵͳ�� */
	public final static String ENTIY_CATEGORY_SYSTEM_KEY = "XTZC";

	/** �ʲ����ͷ��ࣨ������ */
	public final static String ENTIY_CATEGORY_COMPUTER_ROOM = "007";
	
	/** �ʲ����Ͳ���루������ */
	public final static String ENTIY_CATEGORY_COMPUTER_ROOM_SYSCODING = "999007";
	
	/** �ʲ����ͷ��ࣨ���� */
	public final static String ENTIY_CATEGORY_COMPUTER_CONTAINER = "008";
	
	/** �ʲ����ͷ���EID������ */
	public final static Integer ENTIY_CATEGORY_COMPUTER_CONTAINER_EID = 8;
	
	/** �ʲ����Ͳ���루���� */
	public final static String ENTIY_CATEGORY_COMPUTER_CONTAINER_SYSCODING = "999008";
	
	/** �ʲ����ͷ��ࣨ�����¼�� */
	public final static String ENTIY_CATEGORY_SERVICE_RECORD = "009";
	
	/** �ʲ����Ͳ���루�����¼�� */
	public final static String ENTIY_CATEGORY_SERVICE_RECORD_SYSCODING = "999009";
	
	/** �ʲ����ͷ����ʶ�������¼�� */
	public final static String ENTIY_CATEGORY_SERVICE_RECORD_KEY = "FWJL";
	
	/** �ʲ����ͷ��ࣨ��Ա�� */
	public final static String ENTIY_CATEGORY_PERSON = "010";
	
	/** �ʲ����Ͳ���루��Ա�� */
	public final static String ENTIY_CATEGORY_PERSON_SYSCODING = "999010";
	
	/** �ʲ����ͷ����ʶ����Ա�� */
	public final static String ENTIY_CATEGORY_PERSON_KEY = "RYZC";
	
	/** �ʲ����ͷ��ࣨ��ͬ�� */
	public final static String ENTIY_CATEGORY_CONTRACT = "011";
	
	/** �ʲ����Ͳ���루��ͬ�� */
	public final static String ENTIY_CATEGORY_CONTRACT_SYSCODING = "999011";
	
	/** �ʲ����ͷ����ʶ����ͬ�� */
	public final static String ENTIY_CATEGORY_CONTRACT_KEY = "HTZC";

	/** �ʲ����ͷ��ࣨ����� */
	public final static String ENTIY_CATEGORY_MODULE = "012";
	
	/** �ʲ����Ͳ���루����� */
	public final static String ENTIY_CATEGORY_MODULE_SYSCODING = "999012";
	
	/** �ʲ����ͷ����ʶ������� */
	public final static String ENTIY_CATEGORY_MODULE_KEY = "ZJZC";
	
	/** �ʲ����ͷ��ࣨ�ĵ��� */
	public final static String ENTIY_CATEGORY_DOCUMENT = "013";
	
	/** �ʲ����Ͳ���루�ĵ��� */
	public final static String ENTIY_CATEGORY_DOCUMENT_SYSCODING = "999013";
	
	/** �ʲ����ͷ����ʶ���ĵ��� */
	public final static String ENTIY_CATEGORY_DOCUMENT_KEY = "WDZC";
	
	/** �ʲ����Ͳ���루�ĵ�-Ӧ���ƶȣ� */
	public final static String ENTIY_CATEGORY_DOCUMENT_SYSCODING_SYSTEM = "999013002";
	
	/** �ʲ����ͷ��ࣨ��Ʊ�� */
	public final static String ENTIY_CATEGORY_INVOICE = "014";
	
	/** �ʲ����Ͳ���루��Ʊ�� */
	public final static String ENTIY_CATEGORY_INVOICE_SYSCODING = "999014";
	
	/** �ʲ����ͷ����ʶ����Ʊ�� */
	public final static String ENTIY_CATEGORY_INVOICE_KEY = "FPGL";
	
	/** �ʲ����ͷ��ࣨ�����Ա�� */
    public final static String ENTIY_CATEGORY_EPI_PERSON = "016";
    
    /** �ʲ����Ͳ���루�����Ա�� */
    public final static String ENTIY_CATEGORY_EPI_PERSON_SYSCODING = "999016";
    
    /** �ʲ����ͷ����ʶ�������Ա�� */
    public final static String ENTIY_CATEGORY_EPI_PERSON_KEY = "WBRY";
	
	/** �ʲ����ͷ��ࣨ���յ㣩 */
    public final static String ENTIY_CATEGORY_RISK = "017";
    
    /** �ʲ����Ͳ���루���յ㣩 */
    public final static String ENTIY_CATEGORY_RISK_SYSCODING = "999017";
    
    /** �ʲ����ͷ����ʶ�����յ㣩 */
    public final static String ENTIY_CATEGORY_RISK_KEY = "FXZC";
    
	/** �ʲ����ͷ��ࣨ���� */
    public final static String ENTIY_CATEGORY_CHECKITEMS = "018";
    
    /** �ʲ����Ͳ���루���� */
    public final static String ENTIY_CATEGORY_CHECKITEMS_SYSCODING = "999018";
    
    /** �ʲ����ͷ����ʶ������ */
    public final static String ENTIY_CATEGORY_CHECKITEMS_KEY = "JCZC";
    
    /** �ʲ����ͷ����ʶ������ */
    public final static String ENTIY_CHECK_CHECKITEMS_KEY = "IG-X";
    
    
    /** �ʲ����ͷ����ʶ�����յ㣩 */
    public final static String ENTIY_CHECK_RISK_ITEMS_KEY = "IG-D";
    
    /** �ʲ����ͷ��ࣨ����ָ�꣩ */
    public final static String ENTIY_CATEGORY_RISK_TARGET = "019";
    
    /** �ʲ����Ͳ���루����ָ�꣩ */
    public final static String ENTIY_CATEGORY_RISK_TARGET_SYSCODING = "999019";
    
    /** �ʲ����ͷ����ʶ������ָ�꣩ */
    public final static String ENTIY_CATEGORY_RISK_TARGET_KEY = "IG-R";
    
    /** �ʲ����ͷ��ࣨ�����¼��� */
    public final static String ENTIY_CATEGORY_RISK_CASE = "020";
    
    /** �ʲ����Ͳ���루�����¼��� */
    public final static String ENTIY_CATEGORY_RISK_CASE_SYSCODING = "999020";
    
    /** �ʲ����ͷ����ʶ�������¼��� */
    public final static String ENTIY_CATEGORY_RISK_CASE_KEY = "SJZC";
    
    /** �ʲ����ͷ��ࣨ��Ϣ��ȫ ���� */
    public final static String ENTIY_CATEGORY_SAFETY_CHECKITEMS = "021";
    
    /** �ʲ����Ͳ���루��Ϣ��ȫ ���� */
    public final static String ENTIY_CATEGORY_SAFETY_CHECKITEMS_SYSCODING = "999021";
    
    /** �ʲ����ͷ����ʶ����Ϣ��ȫ ���� */
    public final static String ENTIY_CATEGORY_SAFETY_CHECKITEMS_KEY = "IG-S";
    
    
	/** ��������豸��ϵid */
	public final static String MODULE_RELATION_ENTIY_ID = "37";
	
	/** ��������豸��ϵcode */
	public final static String MODULE_RELATION_ENTIY_CODE = "012-001";
	
	/** ����������ϵid */
	public final static String MODULE_RELATION_MODULE_ID = "41";
	
	/** ������������ϵcode */
	public final static String MODULE_RELATION_MODULE_CODE = "012-012";
	
	/** �����ͷ�����������ϵID */
	public final static String ROOM_PART_ASSIGN_RELATION = "B";
	
	/** �����ͻ����������ϵID */
	public final static String ROOM_CONTAINER_ASSIGN_RELATION = "A";
	
	public final static String ROOM_CONTAINER_ASSIGN_RELATION_CODE = "007-008";
	
	/** �����ͷ�����������ϵID */
	public final static String PART_DEVICE_ASSIGN_RELATION_CODE = "007-007";
	
	/** �������������豸��������ϵID */
	public final static String ROOM_EQUIPMENT_RELATION_CODE = "007-001";
	
	/** �����ͻ����������ϵID */
	public final static String PART_CONTAINER_ASSIGN_RELATION = "C";
	
	/** ������豸��������ϵID */
	public final static String CONTAINER_DEVICE_ASSIGN_RELATION = "B";
	
	public final static String CONTAINER_DEVICE_ASSIGN_RELATION_CODE = "001-008";
	
	/** ȱʡ��ͨ������Ϣ��ʾ */
	public final static String DEFAULT_COMMON_CONFIG_INFO = "0";
	
	/** ��ѡ��ͨ������Ϣ��ʾ */
	public final static String SELECT_COMMON_CONFIG_INFO = "1";
	
	/** ������Ϣ���򷽷� */
	public final static int CODE_DETAIL_ORDER_BY_MODE_0 = 0;

	/** ������Ϣ���򷽷� */
	public final static int CODE_DETAIL_ORDER_BY_MODE_1 = 1;
	
	/** ������Ϣ�����򷽷� */
	public final static int CODE_DETAIL_ORDER_BY_MODE_2 = 2;
	
	public final static int CODE_DETAIL_ORDER_BY_MODE_3 = 3;
	
	/** ������Ϣ���򷽷� */
	public final static int TREE_LEVEL_CODE = 3;

	/** �����¼ָ����ϵid*/
	public final static String SERVICE_RECORD_EIRRELATION_CID = "10";
	
	/** Ԥ�����ͷ��ࣨ�豸�� */
	public final static String ENTIY_CATEGORY_PLAN = "801";
	
	/** Ԥ�����Ͳ���루�豸�� */
	public final static String ENTIY_CATEGORY_PLAN_SYSCODING = "888001";
	
	/** Ԥ�����ͷ����ʶ���豸�� */
	public final static String ENTIY_CATEGORY_PLAN_KEY = "YABH";
	
	//************************* �ʲ�״̬************************************
	
	/** �ʲ�״̬����� */
	public final static String ENTITYITEM_STARUS_NEW = "N";
	
	/** �ʲ�״̬���·� */
	public final static String ENTITYITEM_STARUS_USE = "U";
	
	/** �ʲ�״̬���Ͻ� */
	public final static String ENTITYITEM_STARUS_RENEW = "R";
	
	/** �ʲ�״̬��Ԥ���� */
	public final static String ENTITYITEM_STARUS_PRESCRAP = "P";
	
	/** �ʲ�״̬������ */
	public final static String ENTITYITEM_STARUS_SCRAP = "S";

	public final static int CCID_LENGTH = 3;
	
	public final static int CID_LENGTH = 4;

	/** ���̸�������Ŀ¼���� */
	public static final String APPLICATIONNAME = "svc";

	private CommonDefineUtils(){}
	
	/** ������������ */
	public final static String PART_ROOM = "IG_0101";
	
	/** �����ذ�X */
	public final static String PART_X = "IG_0102";
	
	/** �����ذ�Y */
	public final static String PART_Y = "IG_0103";

	//************************* ����������ʽ************************************
	
	/** ����ORGUSERCODING�������� */
	public final static String SORT_BY_ORGSYSCODING = "BYSYSCODING";
	
	public final static String ENTIY_CATEGORY_ORGANIZATION = "0419001";
	
	//************************* ��ͬ������Ϣ ************************************
	
	/** ��Ŀ���� */
	public final static String ENTIY_COMPACT_PROJECTNAME="IG_0110";
	
	/** ��һ�ʸ���� */
	public final static String ENTIY_COMPACT_ACTUALMONEY1="IG_0117";
	
	/** ��һ��Ӧ���� */
	public final static String ENTIY_COMPACT_EXPECTDAY1="IG_0118";
	
	/** ��һ��ʵ���� */
	public final static String ENTIY_COMPACT_ACTUALDAY1="IG_0119";
	
	/** ��Ʊ˵�� */
	public final static String ENTIY_COMPACT_INVOICEEXPLAIN1="IG_0120";
	
	/** �ڶ��ʸ���� */
	public final static String ENTIY_COMPACT_ACTUALMONEY2="IG_0121";
	
	/** �ڶ���Ӧ���� */
	public final static String ENTIY_COMPACT_EXPECTDAY2="IG_0122";
	
	/** �ڶ���ʵ���� */
	public final static String ENTIY_COMPACT_ACTUALDAY2="IG_0123";
	
	/** ��Ʊ˵�� */
	public final static String ENTIY_COMPACT_INVOICEEXPLAIN2="IG_0124";
	
	/** �����ʸ���� */
	public final static String ENTIY_COMPACT_ACTUALMONEY3="IG_0125";
	
	/** ������Ӧ���� */
	public final static String ENTIY_COMPACT_EXPECTDAY3="IG_0126";
	
	/** ������ʵ���� */
	public final static String ENTIY_COMPACT_ACTUALDAY3="IG_0127";
	
	/** ��Ʊ˵�� */
	public final static String ENTIY_COMPACT_INVOICEEXPLAIN3="IG_0128";
	
	/** ���ıʸ���� */
	public final static String ENTIY_COMPACT_ACTUALMONEY4="IG_0129";
	
	/** ���ı�Ӧ���� */
	public final static String ENTIY_COMPACT_EXPECTDAY4="IG_0130";
	
	/** ���ı�ʵ���� */
	public final static String ENTIY_COMPACT_ACTUALDAY4="IG_0131";
	
	/** ��Ʊ˵�� */
	public final static String ENTIY_COMPACT_INVOICEEXPLAIN4="IG_0132";
	
	/** ����ʸ���� */
	public final static String ENTIY_COMPACT_ACTUALMONEY5="IG_0133";
	
	/** �����Ӧ���� */
	public final static String ENTIY_COMPACT_EXPECTDAY5="IG_0134";
	
	/** �����ʵ���� */
	public final static String ENTIY_COMPACT_ACTUALDAY5="IG_0135";
	
	/** ��Ʊ˵�� */
	public final static String ENTIY_COMPACT_INVOICEEXPLAIN5="IG_0136";
	
	/** ��6�ʸ���� */
    public final static String ENTIY_COMPACT_ACTUALMONEY6="IG_0191";
    
    /** ��6��Ӧ���� */
    public final static String ENTIY_COMPACT_EXPECTDAY6="IG_0194";
    
    /** ��6��ʵ���� */
    public final static String ENTIY_COMPACT_ACTUALDAY6="IG_0196";
    
    /** ��Ʊ˵�� */
    public final static String ENTIY_COMPACT_INVOICEEXPLAIN6="IG_0197";
    
    /** ��7�ʸ���� */
    public final static String ENTIY_COMPACT_ACTUALMONEY7="IG_0198";
    
    /** ��7��Ӧ���� */
    public final static String ENTIY_COMPACT_EXPECTDAY7="IG_0201";
    
    /** ��7��ʵ���� */
    public final static String ENTIY_COMPACT_ACTUALDAY7="IG_0203";
    
    /** ��Ʊ˵�� */
    public final static String ENTIY_COMPACT_INVOICEEXPLAIN7="IG_0204";
    
    /** ��8�ʸ���� */
    public final static String ENTIY_COMPACT_ACTUALMONEY8="IG_0205";
    
    /** ��8��Ӧ���� */
    public final static String ENTIY_COMPACT_EXPECTDAY8="IG_0208";
    
    /** ��8��ʵ���� */
    public final static String ENTIY_COMPACT_ACTUALDAY8="IG_0210";
    
    /** ��Ʊ˵�� */
    public final static String ENTIY_COMPACT_INVOICEEXPLAIN8="IG_0211";
    
    /** ��9�ʸ���� */
    public final static String ENTIY_COMPACT_ACTUALMONEY9="IG_0212";
    
    /** ��9��Ӧ���� */
    public final static String ENTIY_COMPACT_EXPECTDAY9="IG_0215";
    
    /** ��9��ʵ���� */
    public final static String ENTIY_COMPACT_ACTUALDAY9="IG_0217";
    
    /** ��Ʊ˵�� */
    public final static String ENTIY_COMPACT_INVOICEEXPLAIN9="IG_0218";
    
    /** ��10�ʸ���� */
    public final static String ENTIY_COMPACT_ACTUALMONEY10="IG_0219";
    
    /** ��10��Ӧ���� */
    public final static String ENTIY_COMPACT_EXPECTDAY10="IG_0222";
    
    /** ��10��ʵ���� */
    public final static String ENTIY_COMPACT_ACTUALDAY10="IG_0224";
    
    /** ��Ʊ˵�� */
    public final static String ENTIY_COMPACT_INVOICEEXPLAIN10="IG_0225";
    
    /** ��11�ʸ���� */
    public final static String ENTIY_COMPACT_ACTUALMONEY11="IG_0226";
    
    /** ��11��Ӧ���� */
    public final static String ENTIY_COMPACT_EXPECTDAY11="IG_0229";
    
    /** ��11��ʵ���� */
    public final static String ENTIY_COMPACT_ACTUALDAY11="IG_0231";
    
    /** ��Ʊ˵�� */
    public final static String ENTIY_COMPACT_INVOICEEXPLAIN11="IG_0232";
    
    /** ��12�ʸ���� */
    public final static String ENTIY_COMPACT_ACTUALMONEY12="IG_0233";
    
    /** ��12��Ӧ���� */
    public final static String ENTIY_COMPACT_EXPECTDAY12="IG_0236";
    
    /** ��12��ʵ���� */
    public final static String ENTIY_COMPACT_ACTUALDAY12="IG_0238";
    
    /** ��Ʊ˵�� */
    public final static String ENTIY_COMPACT_INVOICEEXPLAIN12="IG_0239";
    
    /** ��13�ʸ���� */
    public final static String ENTIY_COMPACT_ACTUALMONEY13="IG_0240";
    
    /** ��13��Ӧ���� */
    public final static String ENTIY_COMPACT_EXPECTDAY13="IG_0243";
    
    /** ��13��ʵ���� */
    public final static String ENTIY_COMPACT_ACTUALDAY13="IG_0245";
    
    /** ��Ʊ˵�� */
    public final static String ENTIY_COMPACT_INVOICEEXPLAIN13="IG_0246";
    
    /** ��14�ʸ���� */
    public final static String ENTIY_COMPACT_ACTUALMONEY14="IG_0247";
    
    /** ��14��Ӧ���� */
    public final static String ENTIY_COMPACT_EXPECTDAY14="IG_0250";
    
    /** ��14��ʵ���� */
    public final static String ENTIY_COMPACT_ACTUALDAY14="IG_0252";
    
    /** ��Ʊ˵�� */
    public final static String ENTIY_COMPACT_INVOICEEXPLAIN14="IG_0253";
    
    /** ��15�ʸ���� */
    public final static String ENTIY_COMPACT_ACTUALMONEY15="IG_0254";
    
    /** ��15��Ӧ���� */
    public final static String ENTIY_COMPACT_EXPECTDAY15="IG_0257";
    
    /** ��15��ʵ���� */
    public final static String ENTIY_COMPACT_ACTUALDAY15="IG_0259";
    
    /** ��Ʊ˵�� */
    public final static String ENTIY_COMPACT_INVOICEEXPLAIN15="IG_0260";
	
	/** �Ѹ��� */
	public final static String ENTIY_COMPACT_ACCOUNTMONEY="IG_0137";
	
	/** ��󸶿��� */
	public final static String ENTIY_COMPACT_LASTDATETIME="IG_0138";
	
	/** ��һ���Ƶ��� */
	public final static String ENTIY_COMPACT_ZHIDANDAY1="IG_0158";
	
	/** ��һ��Ӧ������� */
	public final static String ENTIY_COMPACT_YINGFUMONEYRATIO1="IG_0166";
	
	/** ��һ��ʵ����� */
	public final static String ENTIY_COMPACT_SHIFUMONEY1="IG_0153";
	
	/** �ڶ����Ƶ��� */
	public final static String ENTIY_COMPACT_ZHIDANDAY2="IG_0159";
	
	/** �ڶ���Ӧ������� */
	public final static String ENTIY_COMPACT_YINGFUMONEYRATIO2="IG_0167";
	
	/** �ڶ���ʵ����� */
	public final static String ENTIY_COMPACT_SHIFUMONEY2="IG_0154";
	
	/** �������Ƶ��� */
	public final static String ENTIY_COMPACT_ZHIDANDAY3="IG_0160";
	
	/** ������Ӧ������� */
	public final static String ENTIY_COMPACT_YINGFUMONEYRATIO3="IG_0168";
	
	/** ������ʵ����� */
	public final static String ENTIY_COMPACT_SHIFUMONEY3="IG_0155";
	
	/** ���ı��Ƶ��� */
	public final static String ENTIY_COMPACT_ZHIDANDAY4="IG_0161";
	
	/** ���ı�Ӧ������� */
	public final static String ENTIY_COMPACT_YINGFUMONEYRATIO4="IG_0169";
	
	/** ���ı�ʵ����� */
	public final static String ENTIY_COMPACT_SHIFUMONEY4="IG_0156";
	
	/** ������Ƶ��� */
	public final static String ENTIY_COMPACT_ZHIDANDAY5="IG_0162";
	
	/** �����Ӧ������� */
	public final static String ENTIY_COMPACT_YINGFUMONEYRATIO5="IG_0170";
	
	/** �����ʵ����� */
	public final static String ENTIY_COMPACT_SHIFUMONEY5="IG_0157";
	
	/** ��6���Ƶ��� */
    public final static String ENTIY_COMPACT_ZHIDANDAY6="IG_0195";
    
    /** ��6��Ӧ������� */
    public final static String ENTIY_COMPACT_YINGFUMONEYRATIO6="IG_0192";
    
    /** ��6��ʵ����� */
    public final static String ENTIY_COMPACT_SHIFUMONEY6="IG_0193";
    
    /** ��7���Ƶ��� */
    public final static String ENTIY_COMPACT_ZHIDANDAY7="IG_0202";
    
    /** ��7��Ӧ������� */
    public final static String ENTIY_COMPACT_YINGFUMONEYRATIO7="IG_0199";
    
    /** ��7��ʵ����� */
    public final static String ENTIY_COMPACT_SHIFUMONEY7="IG_0200";
    
    /** ��8���Ƶ��� */
    public final static String ENTIY_COMPACT_ZHIDANDAY8="IG_0209";
    
    /** ��8��Ӧ������� */
    public final static String ENTIY_COMPACT_YINGFUMONEYRATIO8="IG_0206";
    
    /** ��8��ʵ����� */
    public final static String ENTIY_COMPACT_SHIFUMONEY8="IG_0207";
    
    /** ��9���Ƶ��� */
    public final static String ENTIY_COMPACT_ZHIDANDAY9="IG_0216";
    
    /** ��9��Ӧ������� */
    public final static String ENTIY_COMPACT_YINGFUMONEYRATIO9="IG_0213";
    
    /** ��9��ʵ����� */
    public final static String ENTIY_COMPACT_SHIFUMONEY9="IG_0214";
    
    /** ��10���Ƶ��� */
    public final static String ENTIY_COMPACT_ZHIDANDAY10="IG_0223";
    
    /** ��10��Ӧ������� */
    public final static String ENTIY_COMPACT_YINGFUMONEYRATIO10="IG_0220";
    
    /** ��10��ʵ����� */
    public final static String ENTIY_COMPACT_SHIFUMONEY10="IG_0221";
    
    /** ��11���Ƶ��� */
    public final static String ENTIY_COMPACT_ZHIDANDAY11="IG_0230";
    
    /** ��11��Ӧ������� */
    public final static String ENTIY_COMPACT_YINGFUMONEYRATIO11="IG_0227";
    
    /** ��11��ʵ����� */
    public final static String ENTIY_COMPACT_SHIFUMONEY11="IG_0228";
    
    /** ��12���Ƶ��� */
    public final static String ENTIY_COMPACT_ZHIDANDAY12="IG_0237";
    
    /** ��12��Ӧ������� */
    public final static String ENTIY_COMPACT_YINGFUMONEYRATIO12="IG_0234";
    
    /** ��12��ʵ����� */
    public final static String ENTIY_COMPACT_SHIFUMONEY12="IG_0235";
    
    /** ��13���Ƶ��� */
    public final static String ENTIY_COMPACT_ZHIDANDAY13="IG_0244";
    
    /** ��13��Ӧ������� */
    public final static String ENTIY_COMPACT_YINGFUMONEYRATIO13="IG_0241";
    
    /** ��13��ʵ����� */
    public final static String ENTIY_COMPACT_SHIFUMONEY13="IG_0242";
    
    /** ��14���Ƶ��� */
    public final static String ENTIY_COMPACT_ZHIDANDAY14="IG_0251";
    
    /** ��14��Ӧ������� */
    public final static String ENTIY_COMPACT_YINGFUMONEYRATIO14="IG_0248";
    
    /** ��14��ʵ����� */
    public final static String ENTIY_COMPACT_SHIFUMONEY14="IG_0249";
    
    /** ��15���Ƶ��� */
    public final static String ENTIY_COMPACT_ZHIDANDAY15="IG_0258";
    
    /** ��15��Ӧ������� */
    public final static String ENTIY_COMPACT_YINGFUMONEYRATIO15="IG_0255";
    
    /** ��15��ʵ����� */
    public final static String ENTIY_COMPACT_SHIFUMONEY15="IG_0256";
	
	/** ������ */
	public final static String ENTIY_COMPACT_FUWUSHANG="IG_0113";
	
	/** ������*/
	public final static String HOST_ESYSCODING="999001001";
	
	/** ��������*/
	public final static String SWITCH_ESYSCODING="999001006";
	
	/** �洢��*/
	public final static String STORAGE_ESYSCODING="999001009";
	
	/** ORACLE��*/
	public final static String ORACLE_ESYSCODING="999002001001";
	
	/** WEBLOGIC��*/
	public final static String WEBLOGIC_ESYSCODING="999002002001";
	
	/** Tuxedo��*/
	public final static String Tuxedo_ESYSCODING="999002002003";
	
	/** Jboss Server��*/
	public final static String Jboss_Server_ESYSCODING="999002002004001";
	
	/** Ĭ��������*/
	public final static String DOMAIN_NAME="SOC��";
}
