/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.soc.srv.bl;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̹���_�������ͳ����ࣨ��󳤶�Ϊ3λ������������W��ͷ��
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @History 2010-7-13     0000000: ���ӷ��񹤵���ݷ����������
 * @version 1.0
 */

public class IGPROCESSType {
	/*------------------��������------------------*/
	
	/** �¼� */
	public static final String INCIDENT_PRTYPE = "I";
	/** ��� */
	public static final String CHANGE_PRTYPE = "C";
	/** ���� */
	public static final String PROBLEM_PRTYPE = "P";
	/** ���� */
	public static final String DEPLOYMENT_PRTYPE = "D";	
	/** �������� */
	public static final String SERVICE_PRTYPE = "S";
	//update by 0000000 begin
	/** �������� */
	public static final String SERVICE_FORM = "SF";
	//update by 0000000 end
	/** �Զ����¼� */
	public static final String INCIDENT_PRTYPE_D = "ID";
	/** �Զ������� */
	public static final String PROBLEM_PRTYPE_D = "PD";
	/** �Զ����� */
	public static final String CHANGE_PRTYPE_D = "CD";
	/** �Զ��巢�� */
	public static final String DEPLOYMENT_PRTYPE_D = "DD";
	/** �Զ���������� */
	public static final String SERVICE_PRTYPE_D = "SD";
	
	/** ����������ʼ��ĸ */
	public static final String WORK_PRTYPE = "W";
	/** ָ�ɹ��� */
	public static final String NEW_WORK_PRTYPE_1 = "WA";
	/** ���˹��� */
	public static final String NEW_WORK_PRTYPE_2 = "WB";
	/** �Զ��幤�� */
	public static final String SELF_DEFINING_WORK_PRTYPE = "WD";
	
	/** 
	 * �����������ͷ����������Ͷ�Ӧ�����ƣ���ͼ�λ�ͳ����������ʹ�ã�������������ʱ��ͬʱ���Ӷ�Ӧ����������
	 */
	public static String getTypeName(String type){
		String name = "";
		if(INCIDENT_PRTYPE.equals(type)){
			name = "�¼�";
		}else if(CHANGE_PRTYPE.equals(type)){
			name = "���";
		}else if(PROBLEM_PRTYPE.equals(type)){
			name = "����";
		}else if(DEPLOYMENT_PRTYPE.equals(type)){
			name = "����";
		}else if(SERVICE_PRTYPE.equals(type)){
			name = "��������";
		}else if(NEW_WORK_PRTYPE_1.equals(type)){
			name = "ָ�ɹ���";
		}else if(NEW_WORK_PRTYPE_2.equals(type)){
			name = "���˹���";
		}else if(SELF_DEFINING_WORK_PRTYPE.equals(type)){
			name = "�Զ��幤��";
		}
		return name;
	}
}
