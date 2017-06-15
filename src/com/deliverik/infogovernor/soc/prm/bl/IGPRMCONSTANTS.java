/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.infogovernor.soc.prm.bl;

import com.deliverik.infogovernor.svc.bl.IGPROCESSType;

/**
 * ��ݷ�����س�����
 * 
 */
public class IGPRMCONSTANTS {

	/** �¼����Կ�ݷ�����������ͱ�ʶ�����⣬����� */
	public static final String[] QUICK_PROCESS_RELATION_TYPE_I = {
			IGPROCESSType.PROBLEM_PRTYPE, IGPROCESSType.CHANGE_PRTYPE};
			
	/** ������Կ�ݷ�����������ͱ�ʶ������� */
	public static final String[] QUICK_PROCESS_RELATION_TYPE_P = {
		IGPROCESSType.CHANGE_PRTYPE};
	
	/** ���ͨ����ݷ���������������ͱ�ʶ���¼������⣩ */
	public static final String[] QUICK_PROCESS_RELATION_TYPE_C = {
		IGPROCESSType.INCIDENT_PRTYPE, IGPROCESSType.PROBLEM_PRTYPE};
	
	/** �����鿴ҳ���ã���ʾ������̣��¼������⣬����� */
	public static final String[] PROCESSDISP_ALL = {
		IGPROCESSType.INCIDENT_PRTYPE, IGPROCESSType.PROBLEM_PRTYPE,IGPROCESSType.CHANGE_PRTYPE};
	
	/** ���񹤵�ͨ����ݷ���������������ͱ�ʶ���¼������⣬���� */
	public static final String[] QUICK_PROCESS_RELATION_TYPE_SF = {
		IGPROCESSType.INCIDENT_PRTYPE, IGPROCESSType.PROBLEM_PRTYPE, IGPROCESSType.SERVICE_PRTYPE};
	
	/** �¼��鿴ҳ����ʾ������̣����⣬����� */
	public static final String[] PROCESSDISP_I = {
		IGPROCESSType.PROBLEM_PRTYPE,IGPROCESSType.CHANGE_PRTYPE};
	
	/** ����鿴ҳ����ʾ������̣��¼�������� */
	public static final String[] PROCESSDISP_P = {
		IGPROCESSType.INCIDENT_PRTYPE, IGPROCESSType.CHANGE_PRTYPE};
	
	/** ����鿴ҳ����ʾ������̣��¼������⣩ */
	public static final String[] PROCESSDISP_C = {
		IGPROCESSType.INCIDENT_PRTYPE, IGPROCESSType.PROBLEM_PRTYPE};
	
	/** ���񹤵��鿴ҳ����ʾ������̣��¼������⣬���� */
	public static final String[] PROCESSDISP_SF = {
		IGPROCESSType.INCIDENT_PRTYPE, IGPROCESSType.PROBLEM_PRTYPE, IGPROCESSType.SERVICE_PRTYPE};
	
	
	/** �����ݷ���ҳ��URL */
	public static final String QUICK_PROCESS_INIT_PAGE_P = "/IGSVC0315_Disp.do";
	
	/** �����ݷ���ҳ��URL */
	public static final String QUICK_PROCESS_INIT_PAGE_C = "/IGSVC0422_Disp.do";
		
	/** ���񹤵���ݷ����¼�ҳ��URL */
	public static final String QUICK_PROCESS_INIT_PAGE_SF_I = "/IGSVC0217_Disp.do";
	
	/** ���񹤵���ݷ�������ҳ��URL */
	public static final String QUICK_PROCESS_INIT_PAGE_SF_P = "/IGSVC0317_Disp.do";
	
	/** ���񹤵���ݷ������ҳ��URL */
	public static final String QUICK_PROCESS_INIT_PAGE_SF_S = "/IGSVC0822_Disp.do";
	
	/** ���񹤵���ݷ����Զ����¼�ҳ��URL */
	public static final String QUICK_PROCESS_INIT_PAGE_SF_W = "/IGPRR0113_Disp.do";
}
