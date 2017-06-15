package com.deliverik.framework.workflow.prd.model;

import com.deliverik.framework.base.BaseModel;

/**
 * �������Ͷ�����Ϣ
 *
 */
public interface IG380Info  extends BaseModel {

	/**
	 * �������Ͷ���IDȡ��
	 * @return �������Ͷ���ID
	 */
	public String getPdid();


	/**
	 * ����ģ��IDȡ��
	 * @return ����ģ��ID
	 */
	public Integer getPtid();

	/**
	 * �������Ͷ�������ȡ��
	 * @return �������Ͷ�������
	 */
	public String getPdname();


	/**
	 * �������Ͷ�������ȡ��
	 * @return �������Ͷ�������
	 */
	public String getPddesc();

	/**
	 * �������Ͷ��崴��ʱ��ȡ��
	 * @return �������Ͷ��崴��ʱ��
	 */
	public String getPdcrtdate();

	/**
	 * �������Ͷ���״̬ȡ��
	 * @return �������Ͷ���״̬
	 */
	public String getPdstatus();


	/**
	 * ����ͼxml��Ϣȡ��
	 * @return ����ͼxml��Ϣ
	 */
	public String getPdxml();
	
	/**
	 * ������־Ȩ��ȡ��
	 * @return ������־Ȩ��
	 */
	public String getPermission();

	/**
	 * ������������ȡ��
	 * 
	 * @return ������������
	 */
	public String getSerialgenerator();
	
	/**
     * �˵�IDȡ��
     * 
     * @return �˵�ID
     */
    public String getPdactname();
    
    /**
	 * ��ܱ����˵��ȡ��
	 * @return reportdesc ��ܱ����˵��
	 */
	public String getReportdesc();
	
	/**
	 * ������Ϣ������ȡ��
	 * @return messagegenerator ������Ϣ������
	 */
	public String getMessagegenerator();
	

	/**
	 * ����Ŀ¼ȡ��
	 * @return pdservicecatalog ����Ŀ¼
	 */
	public String getPdservicecatalog();


	/**
	 * ���̱��ȡ��
	 * @return pdserialnumber ���̱��
	 */
	public String getPdserialnumber();
	
	/**
	 * ����Ŀ¼��ʾ����ȡ��
	 * @return pdservicecatalogname ����Ŀ¼��ʾ����
	 */
	public String getPdservicecatalogname();
	
}