/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */


package com.csebank.lom.model;
import com.deliverik.framework.user.model.entity.OrganizationTB;

/**
 * 
 *  �Ӵ����˲�ѯʵ��ӿ�
 * 
 * @author piaow@deliverik.com
 * 
 */

public interface RecptionGuestInfo {
	/**
	 * �Ӵ����˲�ѯRIDȡ��
	 * 
	 * @return �Ӵ����˲�ѯRID
	 */
	public Integer getRid();

	/**
	 * �Ӵ����˲�ѯRNAMEȡ��
	 * 
	 * @return �Ӵ���������
	 */
	public String getRname();
	
	/**
	 * �Ӵ����˲�ѯRAPPORGIDȡ��
	 * 
	 * @return ��Ҫ���벿��
	 */
	public String getRapporgId();
	
	/**
	 * �Ӵ����˲�ѯRSTIMEȡ��
	 * 
	 * @return �Ӵ���ʼ����
	 */
	public String getRstime();
	
	/**
	 * �Ӵ����˲�ѯRETIMEȡ��
	 * 
	 * @return �Ӵ���������
	 */
	public String getRetime();

	/**
	 * �Ӵ����˲�ѯRPPORGȡ��
	 * 
	 * @return �������벿��
	 */
	public String getRpporg();

	/**
	 * �Ӵ����˲�ѯRDESCRIPTIONȡ��
	 * 
	 * @return �Ӵ���������
	 */
	public String getRdescription();
	
	public OrganizationTB getOrganizationTB();

}