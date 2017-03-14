package com.deliverik.framework.workflow;

import com.deliverik.framework.utility.ResourceUtility;

public abstract class WorkFlowConstDefine {

	/*------------------����ϵͳ����------------------*/

	/** ���̽�ɫ��ʶ */
	public static final String PROCESS_ROLE_MARK = "IGBP";
	
	/** ���̹����ɫ���� */
	public static final String PROCESSADMIN_ROLE_TYPE = "IGBP01";
	
	/** ����������ɫ���� */
	public static final String APPROVE_ROLE_TYPE = "IGBP02";
	
	/** ���̲����ɫ���� */
	public static final String PARTICIPATE_ROLE_TYPE = "IGBP03";
	
	/** ���̷��ɽ�ɫ���� */
	public static final String DISPATCH_ROLE_TYPE = "IGBP04";
	
	/** ��ά�Զ����ɫ���� */
	public static final String DEFINED_ROLE_TYPE = "IGBP05";
	
	/** ���̲����ϱ��˽�ɫ���� */
	public static final String STRATEGY_REPORTER_ROLE_TYPE = "IGBP06";
	
	/** ֪ʶ�����˽�ɫ */
	public static final String KNOW_APPROVER_ROLE = "IGKG02";
	
	/** ��������-��ɫ */
	public static final String PPTYPE_ASSIGN_TO_ROLE = "R";
	
	/** ��������-��Ա */
	public static final String PPTYPE_ASSIGN_TO_PERSON = "P";
	
	/** ��־δָ�������ɫʱ��ʾ�Ľ�ɫ���� */
	public static final String UnspecifiedRoleName = "δָ��";
	
	/*** һ�������˽�ɫID */
	public static final String DEFAULT_APPROVOR_ROLEID_ONE = "ROLEID_ONE";
	
	/** һ�������˽�ɫ���� */
	public static final String DEFAULT_APPROVOR_ROLENAME_ONE = "ROLENAME_ONE";
	
	/** һ���������û�ID */
	public static final String DEFAULT_APPROVOR_USERID_ONE = "USERID_ONE";
	
	/** һ���������û����� */
	public static final String DEFAULT_APPROVOR_USERNAME_ONE = "USERNAME_ONE";
	
	/** һ�������˻�������� */
	public static final String DEFAULT_APPROVOR_ORGSYSCODING_ONE = "ORGSYSCODING_ONE";
	
	/** һ�������˻������� */
	public static final String DEFAULT_APPROVOR_ORGNAME_ONE = "ORGNAME_ONE";
	
	/** һ�������� */
	public static final String DEFAULT_APPROVOR_ONE = "_ONE";
	
	/** ���������˽�ɫID */
	public static final String DEFAULT_APPROVOR_ROLEID_TWO = "ROLEID_TWO";
	
	/** ���������˽�ɫ���� */
	public static final String DEFAULT_APPROVOR_ROLENAME_TWO = "ROLENAME_TWO";
	
	/** �����������û�ID */
	public static final String DEFAULT_APPROVOR_USERID_TWO = "USERID_TWO";
	
	/** �����������û����� */
	public static final String DEFAULT_APPROVOR_USERNAME_TWO = "USERNAME_TWO";
	
	/** ���������˻�������� */
	public static final String DEFAULT_APPROVOR_ORGSYSCODING_TWO = "ORGSYSCODING_TWO";
	
	/** ���������˻������� */
	public static final String DEFAULT_APPROVOR_ORGNAME_TWO = "ORGNAME_TWO";
	
	/** ���������� */
	public static final String DEFAULT_APPROVOR_TWO = "_TWO";
	
	/** ���������˽�ɫID */
	public static final String DEFAULT_APPROVOR_ROLEID_THREE = "ROLEID_THREE";
	
	/** ���������˽�ɫ���� */
	public static final String DEFAULT_APPROVOR_ROLENAME_THREE = "ROLENAME_THREE";
	
	/** �����������û�ID */
	public static final String DEFAULT_APPROVOR_USERID_THREE = "USERID_THREE";
	
	/** �����������û����� */
	public static final String DEFAULT_APPROVOR_USERNAME_THREE = "USERNAME_THREE";
	
	/** ���������˻�������� */
	public static final String DEFAULT_APPROVOR_ORGSYSCODING_THREE = "ORGSYSCODING_THREE";
	
	/** ���������˻������� */
	public static final String DEFAULT_APPROVOR_ORGNAME_THREE = "ORGNAME_THREE";
	
	/** ���������� */
	public static final String DEFAULT_APPROVOR_THREE = "_THREE";
	
	/** ȱʡ��������,ҳ�治��ʾ */
	public static final String DEFAULT_PID_TYPE = "S";
	
	/**�������������е��������͵ĳ�ʼ���������ڼ�¼����Ĭ�ϵ�������������
	 * IG007��piddesc�и�ʽ��
	 * roleid!##!rolename!##!userid!##!username!##!orgsyscoding!##!orgname!##!...
	 * */
	public static final String DEFAULT_APPROVEDISPATCHER = "DEFAULT_APPROVEDISPATCHER";
	
	/**������������������������ȱʡ������*/
	public static final String DEFAULT_PROCESS_APPROVOR_TYPE = "DEFAULT_PROCESS_APPROVOR_TYPE";
	
	/**������������������������ȱʡ����������*/
	public static final String DEFAULT_PROCESS_APPROVEDISPATCH_TYPE = "DEFAULT_PROCESS_APPROVEDISPATCH_TYPE";
	
	/** �Ƿ��ж� */
	public static final String YES = "Y";
	
	/** �Ƿ��ж� */
	public static final String NO = "N";
	
	/** ȱʡһ���������������� */
	public static final String DEFAULT_APPROVOR_LEVEL_ONE = "A";
	
	/** ׷��һ���������������� */
	public static final String ADD_APPROVOR_LEVEL_ONE = "a";
	
	/** ȱʡ������������������ */
	public static final String DEFAULT_APPROVOR_LEVEL_TWO = "B";
	
	/** ׷�Ӷ����������������� */
	public static final String ADD_APPROVOR_LEVEL_TWO = "b";
	
	/** ȱʡ������������������ */
	public static final String DEFAULT_APPROVOR_LEVEL_THREE = "C";
	
	/** ׷�������������������� */
	public static final String ADD_APPROVOR_LEVEL_THREE = "c";
	
	/** ȱʡ�ļ��������������� */
	public static final String DEFAULT_APPROVOR_LEVEL_FOUR = "D";
	
	/** ׷���ļ��������������� */
	public static final String ADD_APPROVOR_LEVEL_FOUR = "d";

	/** �����˷ָ��� */
	public static final String SPILT_APPROVORS = "!##!";
	
	/** ����״̬����-��ʼ*/
	public static final int STATUSTYPE_BEGIN = 0;
	
	/** ����״̬����-��ͨ*/
	public static final int STATUSTYPE_NORMAL = 1;
	
	/** ����״̬���͡�������*/
	public static final int STATUSTYPE_END = 2;
	
	/** ����״̬���͡�����ֹ*/
	public static final int STATUSTYPE_END_TERMINATE = 3;
	
	/** ��������ʲ� */
	public static final String PROCESS_PIVRLABEL = "����ʲ�";
	
	/** �Զ�����������ʲ� */
	public static final String PROCESS_PIVRLABEL_PRD = "�ʲ�";
	
	/** ��������ʲ������ʶ */
	public static final String PROCESS_PIVRNAME = "����ʲ�";
	
	/** ��������ʲ������� */
	public static final String PROCESS_PIVRTYPE = "4";
	

	/** ������ؿɹ����ʲ� */
	public static final String PROCESS_ASSET_PIVRTYPE = "W";

	/*------------------������־�����ʶ------------------*/

	/** ���� */
	public static final String RECORDLOG_ORDER_DESC = "DESC";
	
	/** ���� */
	public static final String RECORDLOG_ORDER_ASC = "ASC";
	
	/** ����״̬��־����ʱ */
	public static final String RECORDSTATUSLOG_EXPECT_YES = "1";
	
	/** ����״̬��־����δ��ʱ */
	public static final String RECORDSTATUSLOG_EXPECT_NO = "0";
	
	//=====================������ʶ====================================
	/** ������ʶ */
	public static final String PROCESS_ANONYMOUS = "***";
	
	//=====================�������̱�ű�ʶ====================================
	/** ����ԭ��ʽ���̱�ű�ʶ */
	public static final String FLOW_NUMBER_0 = "0";
	/** �����¸�ʽ���̱�ű�ʶ */
	public static final String FLOW_NUMBER_1 = "1";
	/** �����¸�ʽ���̱�ű�ʶ */
	public static final String WORKFLOW_SERIALNUM_MODE = ResourceUtility.getString("WORKFLOW_SERIALNUM_MODE");
	
	/*---------------------������ʶ---------------------*/
	/** ���ʽ����ֵ���ϲ�����ʶ */
	public static final String PARAMS_TABLE_COLUMN_VALUE = "column_value";
	/** ���ʽ���ж��弯�ϲ�����ʶ */
	public static final String PARAMS_TABLE_COLUMN_PIDID = "column_pidid";
	/** ���ʽ�����кű�ʶ���ϲ������� */
	public static final String PARAMS_TABLE_COLUMN_ROWNUMBER = "column_rownumber";
	/** ���ʽ��������Ϣ������ʶ */
	public static final String PARAMS_TABLE_COLUMN_FILE = "tableFormFile";
	/** ���ʽ�����Ӹ���������ʶ */
	public static final String PARAMS_TABLE_COLUMN_FILE_ADD_FLAG = "tableFormFileAddFlag";
	/** ���ʽ��ɾ������������ʶ */
	public static final String PARAMS_TABLE_COLUMN_FILE_DELETE_FLAG = "tableFormFileDeleteFlag";
	
}
