/**
 * 
 */
package com.deliverik.infogovernor.crc.model;

import com.deliverik.framework.base.BaseModel;

/**
 * ���ܣ�
 * @author ʷ����   2014-7-22
 */
public interface IGCRC1303VWInfo extends BaseModel{
	/**
	 * �ĵ����ȡ��
	 * @return eiNumber �ĵ����
	 */
	public String getEiNumber();

	/**
	 * �ĵ�����ȡ��
	 * @return eiName �ĵ�����
	 */
	public String getEiName();

	/**
	 * �ĵ�����ȡ��
	 * @return eiType �ĵ�����
	 */
	public String getEiType();

	/**
	 * �ĵ�����ȡ��
	 * @return eiSort �ĵ�����
	 */
	public String getEiSort();

	/**
	 * �ĵ��ܼ�ȡ��
	 * @return eiDense �ĵ��ܼ�
	 */
	public String getEiDense();

	/**
	 * ����ȡ��
	 * @return department ����
	 */
	public String getDepartment();

	/**
	 * ������ȡ��
	 * @return managermentPerson ������
	 */
	public String getManagermentPerson();

	/**
	 * ����ȡ��
	 * @return content ����
	 */
	public String getContent();
	
	/**
	 * �洢��ʽȡ��
	 * @return storageWay �洢��ʽ
	 */
	public String getStorageWay();

	/**
	 * ���λ��ȡ��
	 * @return storageLocation ���λ��
	 */
	public String getStorageLocation();
	
	/**
	 * ������ȡ��
	 * @return userName ������
	 */
	public String getUserName();
	
	/**
	 * eiidȡ��
	 * @return eiid eiid
	 */
	public String getEiid();
	
	/**
	 * eidȡ��
	 * @return eid eid
	 */
	public String getEid();

	/**
	 * eLabelȡ��
	 * @return eLabel eLabel
	 */
	public String geteLabel();

	/**
	 * eiLabelȡ��
	 * @return eiLabel eiLabel
	 */
	public String getEiLabel();

	/**
	 * eCategoryȡ��
	 * @return eCategory eCategory
	 */
	public String geteCategory();

	/**
	 * �汾��ȡ��
	 * @return eiVersion �汾��
	 */
	public String getEiVersion();
	
	/**
	 * eNameȡ��
	 * @return eName eName
	 */
	public String geteName();
	
	/**
	 * �Ƿ������ȡ��
	 * @return isDownload �Ƿ������
	 */
	public String getIsDownload();
}
