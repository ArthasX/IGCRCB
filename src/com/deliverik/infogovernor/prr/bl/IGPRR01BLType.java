/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prr.bl;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �����������SVC����������ҵ���߼����賣��
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */

public class IGPRR01BLType {
	/**�����ִ���ˡ���ťʱ�ı�ʶ*/
	public static final String PROCESS_PEOPLE="people";
	/**OAģʽ*/
	public static final String PROCESSMODE_OA="2";
	/**��ͨģʽ*/
	public static final String PROCESSMODE_MO="1";
	//====Ŀ�깤�������ó���ֵBegin
	/**  ��������״̬�������� */
	public static final String PROCESSINFODEF_PIDNAME_TIME_FINISHED="Ԥ�ư��ʱ��";
	/**  ��������״̬�������� */
	public static final String PROCESSINFODEF_PIDNAME_STATUS="����״̬";
	/**  ��������״̬����ֵ���׶δ������ */
	public static final String PROCESSINFODEF_PIDNAME_STATUS_STAGE="�׶δ������";
	/**  ��������״̬����ֵ��ȫ��������� */
	public static final String PROCESSINFODEF_PIDNAME_STATUS_WHOLE="ȫ���������";
	/** Ŀ�깤������ */
	public static final String TARGETWORK_START_STATUS = "Z";
	/** Ŀ�깤������ */
	public static final String TARGETWORK_END_STATUS = "C";
	/** Ŀ�깤������ */
	public static final String TARGETWORK_ALLOT_STATUS = "Y";
	/** Ŀ�깤��ʵʩ���� */
	public static final String TARGETWORK_DISPOSAL_STATUS = "X";
	/** Ŀ�깤������ȷ�� */
	public static final String TARGETWORK_VALIDATE_STATUS = "W";
	/** Ŀ�깤����ֹ */
	public static final String TARGETWORK_CUTOFF_STATUS = "F";
	/** Ŀ�깤������ */
	public static final String TARGETWORK_WORK_TYPE = "��������";
	/** Ŀ�깤����ɫ���ͣ���ҳ�ɼ�Ŀ�깤���Ľ�ɫ���ͣ� */
	public static final String TARGETWORK_ROLE_TYPE = "IGTW01";
	//====Ŀ�깤�������ó���ֵEnd
	
	//====���������ó���ֵBegin
	/**  ���������С�������顱�������֣�pivarname�� */
	public static final String PROCESSINFO_OPINION="�������";
	/**  ���������С����������ܡ��������֣�pivarname�� */
	public static final String PROCESSINFO_OPINION_COLLECT="�����������_collect";
	/**  ���������С������������ڵ��״̬ */
	public static final String PROCESS_PRSTATUS_CREATIVE_V="V";
	/**  ���������С��ύ��ȷ�ϡ��ڵ��״̬ */
	public static final String PROCESS_PRSTATUS_CREATIVE_Y="Y";
	/**  ���������С�����ʱ��ʾ�г����ڵ��״̬ */
	public static final String PROCESS_PRSTATUS_CREATIVE_W="W";
	/**  ���������С�����ʱ��ʾ�г����ڵ��״̬ */
	public static final String PROCESS_PRSTATUS_CREATIVE_T="T";
	//====���������ó���ֵEnd
	
	//====ƾ֤����ó���ֵBegin
	/**  ƾ֤��Ᵽ��Ա����״̬ */
	public static final String PROCESS_VOUCHER_INTO_NAME="����״̬";
	/**  ƾ֤��Ᵽ��Ա����ͨ�� */
	public static final String PROCESS_VOUCHER_INTO_YES="ͨ��";
	/**  ƾ֤��Ᵽ��Ա����δͨ�� */
	public static final String PROCESS_VOUCHER_INTO_NO="��ͨ��";
	/**  ƾ֤���⡢��������м�¼ƾ֤������Ϣ���ֶ� */
	public static final String PROCESS_VOUCHER_NAME="ƾ֤������Ϣ";
	//====ƾ֤����ó���ֵEnd
	
	//====ƾ֤�����ó���ֵBegin
	/**  ƾ֤��Ᵽ��Ա����״̬ */
	public static final String PROCESS_VOUCHER_OUT_NAME="����״̬";
	/**  ƾ֤��Ᵽ��Ա����ͨ�� */
	public static final String PROCESS_VOUCHER_OUT_YES="ͨ��";
	/**  ƾ֤��Ᵽ��Ա����δͨ�� */
	public static final String PROCESS_VOUCHER_OUT_NO="��ͨ��";
	//====ƾ֤�����ó���ֵEnd
	
	//====���ӽ��ӳ���ֵBegin
	public static final String PROCESS_DZJJ_PDID="1015";
	public static final String PROCESS_YXSF_PDID="1016";
	public static final String PROCESS_DZJJ_QYZH="��ҵ�˺�";
	public static final String PROCESS_DZJJ_JSBMBM="���ղ��ű���";
	public static final String PROCESS_DZJJ_JSBM="���ղ���";
	public static final String STATES_WJS = "W";//δ����
	public static final String STATES_DQR = "D";//��ȷ��
	public static final String STATES_YJS = "Y";	//�ѽ���
	public static final String STATES_JS = "����";
	//====���ӽ��ӳ���ֵEnd
	
	/** ��ȫ�ֿ��Ʊ���ʶ */
	public static final String FORM_GLOBAL_CONTROL_Y = "Y";
	/** ����ȫ�ֿ��Ʊ���ʶ */
	public static final String FORM_GLOBAL_CONTROL_N = "N";
	
	public static final String PROCESS_FWPR_PRPDID="01004";
	
	public static final String PROCESS_INFO_ISOPEN ="��Ϣ�Ƿ񹫿�";
	
	public static final String PROCESS_INFO_CLOSE ="��";
	
	
	/** �����˽�ɫ���ͱ�ʶ */
	public static final String COPYUSER_TYPE ="IGCR01";
	
	/** ��ɫ���ͱ�ʶ */
	public static final String ROLE_TYPE ="100";
	

	
}
