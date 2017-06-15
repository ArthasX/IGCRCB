/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.prm.bl;

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

	/** ����������Կ�ݷ�����������ͱ�ʶ���¼������⣬������������� */
	public static final String[] QUICK_PROCESS_RELATION_TYPE_S = {
		IGPROCESSType.INCIDENT_PRTYPE, IGPROCESSType.PROBLEM_PRTYPE, IGPROCESSType.CHANGE_PRTYPE, IGPROCESSType.SERVICE_PRTYPE};
	
	/** �Զ��幤�������Զ��幤���� */
	public static final String[] QUICK_PROCESS_RELATION_TYPE_WD = {
		IGPROCESSType.SELF_DEFINING_WORK_PRTYPE};
	
	/** �����鿴ҳ���ã���ʾ������̣��¼������⣬����� */
	public static final String[] PROCESSDISP_ALL = {
		IGPROCESSType.INCIDENT_PRTYPE, IGPROCESSType.PROBLEM_PRTYPE,IGPROCESSType.CHANGE_PRTYPE,IGPROCESSType.SELF_DEFINING_WORK_PRTYPE};
	
	/** ���񹤵�ͨ����ݷ���������������ͱ�ʶ���¼������⣬���񣬼���֧�֣� */
	public static final String[] QUICK_PROCESS_RELATION_TYPE_SF = {
		IGPROCESSType.INCIDENT_PRTYPE, IGPROCESSType.PROBLEM_PRTYPE, IGPROCESSType.SERVICE_PRTYPE, IGPROCESSType.CHANGE_PRTYPE};
	
	/** �¼��鿴ҳ����ʾ������̣����⣬����� */
	public static final String[] PROCESSDISP_I = {
		IGPROCESSType.PROBLEM_PRTYPE,IGPROCESSType.CHANGE_PRTYPE,IGPROCESSType.SERVICE_PRTYPE};
	
	/** ����鿴ҳ����ʾ������̣��¼�������� */
	public static final String[] PROCESSDISP_P = {
		IGPROCESSType.INCIDENT_PRTYPE, IGPROCESSType.CHANGE_PRTYPE,IGPROCESSType.SERVICE_PRTYPE};
	
	/** ����鿴ҳ����ʾ������̣��¼������⣩ */
	public static final String[] PROCESSDISP_C = {
		IGPROCESSType.INCIDENT_PRTYPE, IGPROCESSType.PROBLEM_PRTYPE,IGPROCESSType.SERVICE_PRTYPE};
	
	/** ��������鿴ҳ����ʾ������̣��¼������⣬������������� */
	public static final String[] PROCESSDISP_S = {
		IGPROCESSType.INCIDENT_PRTYPE, IGPROCESSType.PROBLEM_PRTYPE, IGPROCESSType.CHANGE_PRTYPE, IGPROCESSType.SERVICE_PRTYPE};
	
	/** �����鿴ҳ����ʾ������̣��¼������⣬���� */
	public static final String[] PROCESSDISP_SF = {
		IGPROCESSType.INCIDENT_PRTYPE, IGPROCESSType.PROBLEM_PRTYPE, IGPROCESSType.SERVICE_PRTYPE, IGPROCESSType.CHANGE_PRTYPE};
	
	
	/** �¼���ݷ���ҳ��URL */
	public static final String QUICK_PROCESS_INIT_PAGE_I = "/IGSVC0217_Disp.do";
	
	/** �����ݷ���ҳ��URL */
	public static final String QUICK_PROCESS_INIT_PAGE_P = "/IGSVC0320_Disp.do";
	
	/** �����ݷ���ҳ��URL */
	public static final String QUICK_PROCESS_INIT_PAGE_C = "/IGSVC0422_Disp.do";
	
	/** �����ݷ���ҳ��URL */
	public static final String QUICK_PROCESS_INIT_PAGE_S = "/IGSVC0822_Disp.do";
		
	/** ���񹤵���ݷ����¼�ҳ��URL */
	public static final String QUICK_PROCESS_INIT_PAGE_SF_I = "/IGSVC0217_Disp.do";
	
	/** ���񹤵���ݷ�������ҳ��URL */
	public static final String QUICK_PROCESS_INIT_PAGE_SF_P = "/IGSVC0320_Disp.do";
	
	/** ���񹤵���ݷ�����ҳ��URL */
	public static final String QUICK_PROCESS_INIT_PAGE_SF_C = "/IGSVC0422_Disp.do";
	
	/** ���񹤵���ݷ������ҳ��URL */
	public static final String QUICK_PROCESS_INIT_PAGE_SF_S = "/IGSVC0822_Disp.do";
	
	/** ���񹤵���ݷ�����֧��ҳ��URL */
	public static final String QUICK_PROCESS_INIT_PAGE_SF_WS = "/IGSVC1120_Disp.do";
	
	/** ���񹤵���ݷ����Զ�������ҳ��URL */
	public static final String QUICK_PROCESS_INIT_PAGE_SF_W = "/IGPRR0116_Disp.do";

	/** ����֧�ֿ�ݷ���ҳ��URL */
	public static final String QUICK_PROCESS_INIT_PAGE_WS = "/IGSVC1120_Disp.do";
	
	/** �Զ��幤����ݷ����Զ�������ҳ��URL */
	public static final String QUICK_PROCESS_INIT_PAGE_WD = "/IGPRR0116_Disp.do";
	
	public static final String SOC_PROCESS_INIT_PAGE="/IGEXTWA0102_Disp_SOC.do";
	
	public static final String SOC_PROCESS_INIT_0110="/IGSDL0110_SOC.do";
	
	public static final String SOC_PROCESS_INIT_0103="/IGMTP0103_Disp_SOC.do";
}
