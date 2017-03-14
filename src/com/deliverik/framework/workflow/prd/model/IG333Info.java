/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */
package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/** 
 * ����״̬����
 *
 */
public interface IG333Info  extends BaseModel {
	/**
	 * ����״̬IDȡ��
	 * @return ����״̬ID
	 */
	public String getPsdid();
	
	/**
	 * ��������IDȡ��
	 * @return ��������ID
	 */
	public String getPdid();

	/**
	 * ����״̬����ȡ��
	 * @return ����״̬����
	 */
	public String getPsdname();
	
	/**
	 * ����״̬����ȡ��
	 * @return ����״̬����
	 */
	public String getPsddesc();
	
	/**
	 * ����״̬��ʶȡ��
	 * @return ����״̬��ʶ
	 */
	public String getPsdcode();
	
	/**
	 * ���̽ڵ�����ȡ��
	 * @return ���̽ڵ�����
	 */
	public String getPsdtype();
	
	/**
	 * ���̽ڵ�ģʽȡ��
	 * @return ���̽ڵ�ģʽ
	 */
	public String getPsdmode();
	
	/**
	 * ���̽ڵ㶯̬�����߱�ʶȡ��
	 * @return ���̽ڵ㶯̬�����߱�ʶ
	 */
	public String getPsdflag();
	
	/**
	 * ���ɲ���������ȡ��
	 * 
	 * @return ���ɲ���������
	 */
	public String getPsdassign();

	/**
	 * �Ƿ��������ȡ��
	 * 
	 * @return �Ƿ��������
	 */
	public String getPsdorg();
	
	/**
	 * ����ȷ�ϲ���ȡ��
	 * 
	 * @return ����ȷ�ϲ���
	 */
	public String getPsdconfirm();
	
	/**
	 * ���ɽڵ�IDȡ��
	 * 
	 * @return ���ɽڵ�ID
	 */
	public String getAssignpsdid();

	/**
	 * ���ɰ�ťIDȡ��
	 * 
	 * @return ���ɰ�ťID
	 */
	public String getAssignpbdid();
	
	public String getParticipantchange();
	
	/**
	 * �Ƿ������ɱ�ʶȡ��
	 * 
	 * @return �Ƿ������ɱ�ʶ
	 */
	public String getAssignflag();
	
	public String getIsSelected();

	/**
     * @return the ����ҳ������
     */
    public String getAssignPageType() ;
    
    /**
     * ��ȫ�ֿ��Ʊ�ʶȡ��
     * @return ��ȫ�ֿ��Ʊ�ʶ
     */
	public String getFormGlobalControl();
	
	/**
	 * js����ȡ��
	 * @return jsfunction js����
	 */
	public String getJsfunction();

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public String getBysequence();
	

	/**
	 * �ϼ�״̬IDȡ��
	 * @return �ϼ�״̬ID
	 */
	public String getPpsdid();

	/**
	 * ����������ͼȡ��
	 * @return ����������ͼ
	 */
	public String getPsdxml();

	/**
	 * ��̬��֧����ȡ��
	 * @return ��̬��֧����
	 */
	public String getBranchcond();
	
	/**
	 * �Ƿ�ɴ��洦��ȡ��
	 * @return replaceDispose �Ƿ�ɴ��洦��
	 */
	public String getReplaceDispose();
}
