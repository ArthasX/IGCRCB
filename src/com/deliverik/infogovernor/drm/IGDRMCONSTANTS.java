/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.drm;

import java.util.LinkedList;

/**
 * drm������1
 *
 */
public final class IGDRMCONSTANTS {
	
	/**�ճ�������֯�ܹ���Ӧ����֯�ܹ���ӦCCID*/
	public final static LinkedList<String> ORGSTRU_CCID = new LinkedList<String>();
	static {
		ORGSTRU_CCID.add("240");// �ճ�������֯�ܹ�CCID
		ORGSTRU_CCID.add("230");// Ӧ����֯�ܹ�CCID
	}
	
    /**Ӧ����ɫ����*/
    public static final String DRMROLETYPE="IGBP50";

    /**Ӧ������������ <��������>������*/
    public static final String DRILL_FORM_DRCONTENT = "��������";
    
    /**Ӧ��ָ�������� <�¼�����>������*/
    public static final String EC_FORM_ECNAME = "�¼�����";
    /**Ӧ��ָ�������� <�¼�����>������*/
    public static final String EC_FORM_ECDESC = "�¼�����";
    
   
    
	/** ר��Ԥ���ͳ��� */
	public final static String ENTIY_CATEGORY_DOCUMENT = "050";
	
    /**Ӧ��ָ�������г����ʲ�������*/
    public static final String SCENE_ITEM_NAME = "Ӧ������";
    
    /**Ӧ��ָ��������Ա�ʲ�������*/
    public  static final String PLAN_NAME = "ר��Ԥ��";
    
    /**Ӧ��ָ�������� ҵ��ϵͳ������ */
	public static final String ITEM_SYSTEM_FORM_NAME = "ҵ��ϵͳ";
	
    
    /**Ӧ�������й������̶���id��������*/
    public static final String PROCESS_DEF_ID = "����Ӧ�����ò���";
    
    /**Ӧ��ָ�������� -Ӧ����������prid ����*/
    public static final String PRACTISE_PRID_LABEL = "Ӧ������prid";
    
    
    /**Ӧ��������������������������*/
    public static final String EMERGENCY_SCENE_NAME = "��������";
     
    /**Ӧ������������ר��Ԥ��������*/
    public static final String SPECIAL_PLAN_NAME = "ר��Ԥ��";
    
    /**Ӧ������������ ҵ��ϵͳ������ */
	public static final String DRILL_SYSTEM_FORM_NAME = "ҵ��ϵͳ";
	
    /**�����ʲ����Զ��峡������ID*/
    public static final String DEFINE_SCENE_PDID = "����Ӧ�����ò���";
    
    /** ҵ�������Խ�ɫ���� */
    public final static String SP_ROLE_TYPE = "IGBP50";
    
    /** Ӧ��ָ��PDID */
	public final static String EMER_PROCESS_PDID = "0138601";
    
    
    
    /** �ƻ�����ID������*/
    public final static String PLAN_JOB_NAME = "�ƻ�����id";
    /** �����ƻ����Ʊ�*/
    public final static String PLAN_JOB_FORM_NAME = "�����ƻ�����";
    /**�������̶���ID*/
    public final static String DRILL_PROCESS_DEF_ID = "01385";
    
    /**Ӧ��ָ�����̶���ID*/
    public final static String DIRECT_PROCESS_DEF_ID = "01386";
    
    /**����������ָ�����̵�prid ����*/
    public final static String DRILL_FROM_NAME_DIRECT_PRID = "ָ������prid";
    /**���������г���prid ����*/
    public final static String DRILL_FROM_NAME_SCENE_PRID = "�����������prid";
   
    /**���������� �����˵��������� */
    public static final String DRILL_PARTICIPANT_ADJUST_FORM_NAME = "����������";
	
    /**ָ�������г������̵�prid ����*/
    public final static String DIRECT_FROM_NAME_SCENE_PRID = "����prid";
    
    /**ָ������   �����˵��������� */
    public static final String DIRECT_PARTICIPANT_ADJUST_FORM_NAME = "����������";
    
    /**�������̱�������ָ���Ƿ���ɡ�*/
    public final static String DRILL_PROCESS_FORM_NAME_DIRECTSTATUS = "����ָ���Ƿ����";
    
    /**�����ʲ����ԡ��Ƿ���������*/
    public final static String DRILL_FINISED_FORM_NAME = "�Ƿ�������";
    
    /**�����ʲ����ԡ��Ƿ���������CID*/
    public final static String DRILL_FINISED_FORM_NAME_CID = "CI600000001006";
    
	/**��������ϵͳ��ǰʱ��*/
	public final static String DB_TYPE_REPUSH_SYSMTIME = "6";
	/**������������ʱ*/
	public final static String DB_TYPE_REPUSH_USEDTIME = "7";
	/**����֪ͨ��־��Ϣ����*/
	public final static String DB_TYPE_NOTICE = "1";
	/**������Ϣ����*/
	public final static String DB_TYPE_PROCESS = "2";
	/**��Ա��λ����*/
	public final static String DB_TYPE_INPLACE = "3";
	/**Ӧ�������¼���Ϣ����*/
	public final static String DB_TYPE_EMCINFO = "4";
	/**Ӧ���������Ԥ����Ϣ����*/
	public final static String DB_TYPE_RELPLAN = "5";
	/**��Ϣ����*/
	public final static String DB_TYPE_MESSAGE = "6";
	/**��ȡ���Ȱٷֱ�*/
	public final static String DB_TYPE_PERCENT = "7";
	/**���̿�ʼʱ��*/
	public final static String DB_TYPE_PROCESS_START = "8";
	/**��������ʱ*/
	public final static String DB_TYPE_USED_TIME = "9";
	/**���̽ڵ�״̬*/
	public final static String DB_TYPE_PROCESS_STATUS = "10";
	/**ʵʩ���ٽڵ㰴ť*/
	public final static String DB_TYPE_PROCESS_BUTTON = "11";
	
	/**�����̿�ʼʱ��*/
	public final static String DB_TYPE_GROUP_PROCESS_START = "14";
	/**�����̽ڵ�״̬*/
	public final static String DB_TYPE_GROUP_PROCESS_STATUS = "15";
	/**����������ʱ*/
	public final static String DB_TYPE_GROUP_USED_TIME = "16";
	/**��������Ϣ����*/
	public final static String DB_TYPE_GROUP_MESSAGE = "17";
	/**������ʵʱ׷��*/
	public final static String DB_TYPE_GROUP_NOTICE = "18";
	/**������-ʵʩ���ٽڵ㰴ť*/
	public final static String DB_TYPE_GROUP_PROCESS_BUTTON = "19";
	/**������--�������� ʵ����Ϣ*/
	public final static String DB_TYPE_GROUP_PROCESS_RECORD = "20";
	/**�ر����̺ͽڵ���Ϣ*/
	public final static String DB_TYPE_GROUP_TERMINATE_MSG = "21";
	/**Ӧ����Դ*/
	public final static String DB_TYPE_SOC_MSG = "22";
	
	/**Ӧ������ dashboard ��ȡʵʱ������־��Ϣ*/
	public final static String EME_SENCE_NOTICE ="S1";
	
	/**ָ������ͼDashBoard"������"�ڵ�������ʾ����*/
	public final static String EMC_PROCESS_START_STATUS_LABEL = "�¼��ϱ�";
	/**ָ������Ĭ�ϵ�ǰ�ڵ�bysequenceΪ"01"��"������"�ڵ����*/
	public final static String EMC_PROCESS_START_STATUS_SEQ = "01";
	/**"�¼��ϱ�ʱ��"��Ӧ�ı�ֵ*/
	public final static String EMCPRO_OTIME = "�¼��ϱ�ʱ��";
	/**"�¼������ص�"��Ӧ�ı�ֵ*/
	public final static String EMCPRO_PLACE = "�����ص�";
	/**"�¼��ϱ���Ա"��Ӧ�ı�ֵ*/
	public final static String EMCPRO_REUSER = "�¼��ϱ���";
	/**�ϱ�����ϵ�绰*/
	public final static String EMCPRO_REUSERPHONE = "��ϵ�绰";
	/**"Ӱ�췶Χ"��Ӧ�ı�ֵ*/
	public final static String EMCPRO_REACH = "Ӱ�췶Χ";
	/**"�¼��������"��Ӧ�ı�ֵ*/
	public final static String EMCPRO_DESC = "�¼�����";
	/**"���Ԥ��"�ʲ�������*/
	public final static String EMCPRO_RELPLAN = "ר��Ԥ��";
	/**��Ӧ���߲��Ӧ����֯��������*/
	public final static String ORGSTRU_LAYS = "520";
	/**Ӧ����Ա��λ��ʶ_δ��λ*/
	public final static Integer EMP_NO_INPLACE = 0;
	/**Ӧ����Ա��λ��ʶ_�Ѿ�λ*/
	public final static Integer EMP_IS_INPLACE = 1;
	/** ����Ĭ�Ͽ�ʼ״̬��ʾ����*/
	public static final String PROCESS_START_STATUS_LABEL = "������";
	/**ָ�����̽ڵ�-Ӧ������*/
	public static final String PROCESS_DRICT_DISPOSE = "Ӧ������";
	/**ָ�����̽ڵ�-Ԥ������*/
	public static final String PROCESS_DRICT_PLANTRANSFER = "Ԥ������";
	/**ָ�����̽ڵ�-��ԴЭ��*/
	public static final String PROCESS_RESOURCE_COORDINATION = "��ԴЭ��";
	/**ָ�����̽ڵ�-Ӧ������psdid*/
	public static final String PROCESS_DRICT_DISPOSE_PSDID = "0138601007";
	/**ָ�����̽ڵ�-�¼�����*/
	public static final String PROCESS_CASE_UPGRADE = "�¼�����";
	/**ָ�����̽ڵ�-�¼�����psdid*/
	public static final String PROCESS_CASE_UPGRADE_PSDID = "0138601009";
	/** ����Ĭ�Ͽ�ʼ״̬*/
	public static final String PROCESS_START_STATUS = "Z";
	/** ����Ĭ�Ͻ���״̬*/
	public static final String PROCESS_END_STATUS = "C";
	/** ���̽ڵ�����-�ϲ��ڵ�*/
	public static final String PROCESS_NODE_TYPE_MERGE = "5";
	/**Ԥ����ѯ����  --��ѯ����*/
	public static final String PLAN_SEARCH_TYPE_ALL = "A";
	/**Ԥ����ѯ����  --��ѯ�����*/
	public static final String PLAN_SEARCH_TYPE_UPGRADE = "U";
	/**Ԥ����ѯ����  --��ѯ������*/
	public static final String PLAN_SEARCH_TYPE_DIRLL = "D";
	/**�����ʲ�����_�������� */
	public static final String SCENE_ENTITY_ITEM_SCENETYPE = "��������";
	/** �����ʲ�cid-��������pdid */
	public static final String SCENE_MODEL_CID = "CI600000001004";
	/** ����esyscoding */
	public static final String SCENE_ESYSCODING = "999060";
	/** �����޶����̶���idǰ��λ */
	public static final String SCENE_DEFINE_FIVE = "01441";
	
	/**���� ����������̱�����*/
	public static final String DRILL_RELATE_PROCESS_FORM_NAME = "���������趨";
	/**���� ����������� Ӧ��ָ������*/
	public static final String DRILL_RELATE_PROCESS_FORM_DIRECT = "����ָ������";
	/**���� ����������� ��������*/
	public static final String DRILL_RELATE_PROCESS_FORM_SCENE = "������������";
	
	/**Ӧ���ƶȲ����*/
	public static final String EMERGENCY_INSTITUTION_ESYSCODING = "999070";
	
	
	/** ��ϵ���� 0������-���� */
	public static final String DRILL_RELATE_SCENE ="0";
	/** ��ϵ���� 1 Ӧ��ָ��-���� */
	public static final String DIRECT_RELATE_SCENE ="1";
	/** ��ϵ���� 2 ����-Ӧ��ָ�� */
	public static final String DRILL_RELATE_DIRECT ="2";
	
	/** �����������̵Ĳ�������Ϣ */
	public static final String DIRECT_ADJUST_PARTIC = "�����˵Ľ�ɫ�û���Ϣ";
	/** �����������̵� ���̽ڵ����� */
	public static final String DIRECT_PROCESS_PSDNAME = "���̽ڵ�����";
	/** �����������̵� ���̽ڵ����� */
	public static final String DIRECT_PROCESS_PSDID = "���̽ڵ�id";
	
	/**Ӧ������ ����ʱ��*/
	public static final String DB_TYPE_STOP_TIME = "stopTime";
	
	/**Ӧ������ ������Ϣ*/
	public static final String DB_TYPE_BASE_MSG = "baseMsg";
	
	/**Ӧ������ ����ͼ*/
	public static final String DB_TYPE_FLOW_MSG = "flowMsg";
	
	/** ר��Ԥ��Ŀ¼���� - ���ı� */
	public static final String PLAN_DIR_TYPE_TEXT = "0";

	/** ר��Ԥ��Ŀ¼���� - ���� */
	public static final String PLAN_DIR_TYPE_SCENE = "1";

	/** ר��Ԥ��Ŀ¼���� - ��֯�ܹ� */
	public static final String PLAN_DIR_TYPE_ORG = "2";

	/** ר��Ԥ��Ŀ¼���� - Ӧ����Դ */
	public static final String PLAN_DIR_TYPE_RESOURCE = "4";

	/** Ӧ��ָ���������� */
	public static final String EME_DIRECT_PRTYPE = "WDC";
	/** Ӧ���ָ��������� */
	public static final String EME_RECOVER_PRTYPE = "WDP";
	/** Ӧ����������-���� */
	public static final String DWP_TYPE_DRILL = "DRILL";
	/** Ӧ����������-Ӧ�� */
	public static final String DWP_TYPE_DIRECT = "DTRECT";

	/** �洢�豸����� */
	public static final String CUNCU_ESYSCODING = "999001005";
	/** �����豸����� */
	public static final String WANGLUO_ESYSCODING = "999001002";

}
