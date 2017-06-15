/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.workflow.prd.model.entity.IG380TB;

/**
 * <p>����:������ʵ��ӿ�</p>
 * <p>����������</p>
 * <p>������¼��</p>
 */
public interface IG286Info  extends BaseModel {
	
	/**
	 * ���ܣ�����ID
	 * @return ����ID
	 */
	public String getPlid() ;

	/**
	 * ���ܣ�����id
	 * @return ����id
	 */
	public String getInitiativepidid() ;

	/**
	 * ���ܣ�����id
	 * @return ����id
	 */
	public String getPassivitypidid() ;

	/**
	 * ���ܣ���������
	 * @return ��������
	 */
	public String getPldesc();

	/**
	 * ���ܣ�bl����
	 * @return bl����
	 */
	public String getPlblname();

	/**
	 * ���ܣ�js�¼�����
	 * @return js�¼�����
	 */
	public String getPljsevent();

	/**
	 * ���ܣ�����������
	 * @return ����������
	 */
	public String getPljtype();
	
	/**
	 * ���ܣ����̶���id
	 * @return ���̶���id
	 */
	public String getPldpdid();
	
	/**
	 * ���ܣ�����ťid
	 * @return ����ťid
	 */
	public String getPldactionid();
	
	/**
	 * ���ܣ�����������
	 * @return ����������
	 */
	public String getInitiativepidname();

	/**
	 * ���ܣ�����������
	 * @return ����������
	 */
	public String getPassivitypidname();
	
	/**
	 * ���ܣ����̶���
	 * @return processDefinitionTB
	 */
	public IG380TB getProcessDefinitionTB();

}