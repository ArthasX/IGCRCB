/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model;

import java.util.List;

import com.deliverik.framework.model.entity.AttachmentTB;

/**
 * ����:��������ʵ��TB��
 * ���������������������ʵ��ӿ�
 *           
 * ������¼���κ���    2010/11/26
 */
public interface IG433Info {
	/**
	 *����
	 */
	public Integer getPaid();

	/**
	 *����ID
	 */
	public Integer getPaprid();

	/**
	 *������
	 */
	public String getPaprname();

	/**
	 *������id
	 */
	public String getPauserid();

	/**
	 *����˵��1
	 */
	public String getPaassessmentdes();

	/**
	 *����ʱ��
	 */
	public String getPaassessmentdate();
	
	/**
	 * �¼����code
	 */
	public String getPaeventtypecode();
	
	/**
	 * ���󸽼�Key
	 */
	public String getPaattkey();
	
	/**
	 * ����List
	 */
	public List<AttachmentTB> getAttachmentList();
	
	/**
	 * ����״̬
	 */
	public String getPastatus();

}
