/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sym.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.model.CodeDetail;

/**
 * ������Ϣ�ӿ�
 * 
 */

public interface ReportFileDefinition  extends BaseModel {

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public abstract Integer getRfdid();

	/**
	 * ������ʾ����ȡ��
	 * @return ������ʾ����
	 */
	public abstract String getRfdtitle();
	
	/**
	 * �������ȡ��
	 * @return �������
	 */
	public abstract String getRfdtype();

	/**
	 * ����˵��ȡ��
	 * @return ����˵��
	 */
	public abstract String getRfddesc();

	/**
	 * �����ļ���ȡ��
	 * @return �����ļ���
	 */
	public abstract String getRfdfilename();

	/**
	 * ����Ǽ���IDȡ��
	 * @return ����Ǽ���ID
	 */
	public abstract String getRfduserid();

	/**
	 * ����Ǽ�������ȡ��
	 * @return ����Ǽ�������
	 */
	public abstract String getRfdusername();

	/**
	 * ����Ǽ�ʱ��ȡ��
	 * @return ����Ǽ�ʱ��
	 */
	public abstract String getRfdinstime();
	
	/**
	 * ����汾��ȡ��
	 * @return ����汾��
	 */
	public abstract Integer getRfdversion();
	
	/**
	 * �������°汾��ȡ��
	 * @return �������°汾��
	 */
	public abstract Integer getRfdnewversion();
	
	/**
	 * ��������ʵ��ȡ��
	 * @return ��������ʵ��
	 */
	public abstract CodeDetail getCodeDetailTB();
	
	/**
	 * ��������ȡ��
	 * @return ��������ʵ��
	 */
	public abstract String getRfdpictype();
	
	
	public String getRfdparameters();
	
	public String getIsFlag();


}