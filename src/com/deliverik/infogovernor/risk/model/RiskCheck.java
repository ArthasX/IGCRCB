/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.model;

import com.deliverik.framework.base.BaseModel;

/**
 * ���ռ��ʵ��ӿ�
 * 
 * @author lipeng@deliverik.com
 */
public interface RiskCheck  extends BaseModel {
	/**
	 * ���ռ��IDȡ��
	 * @return ���ռ��ID
	 */
	public Integer getRcid(); 
	
	/**
	 * ���ռ������ȡ��
	 * @return ���ռ������
	 */
	public String getRcname();

	/**
	 * ���ռ������ȡ��
	 * @return ���ռ������
	 */
	public String getRcdesc();

	/**
	 * ��Ҫ��ȡ��
	 * @return ��Ҫ��
	 */
	public String getRctype();

	/**
	 * ���ռ��״̬ȡ��
	 * @return ���ռ��״̬
	 */
	public String getRcstatus(); 

	/**
	 * ���ռ����ʼʱ��ȡ��
	 * @return ���ռ����ʼʱ��
	 */
	public String getRcstartdate();

	/**
	 * ���ռ�����ʱ��ȡ��
	 * @return ���ռ�����ʱ��
	 */
	public String getRcenddate();

	/**
	 * ���ռ��Ƶ��ȡ��
	 * @return ���ռ��Ƶ��
	 */
	public String getRcfrequency();
	
	/**
	 * ���ռ��Ƶ������ȡ��
	 * @return ���ռ��Ƶ������
	 */
	public String getRcfrequencydesc();

	/**
	 * ���ռ��������IDȡ��
	 * @return ���ռ��������ID
	 */
	public String getRcuserid();

	/**
	 * ���ռ������������ȡ��
	 * @return ���ռ������������
	 */
	public String getRcusername();

	/**
	 * ���ռ���������ɫIDȡ��
	 * @return ���ռ���������ɫID
	 */
	public Integer getRcroleid();

	/**
	 * ���ռ���������ɫ��ȡ��
	 * @return ���ռ���������ɫ��
	 */
	public String getRcrolename();

	/**
	 * ���ռ������ʲ�IDȡ��
	 * @return ���ռ������ʲ�ID
	 */
	public Integer getRcasset();

	/**
	 * ���ռ�鸽��IDȡ��
	 * @return ���ռ�鸽��ID
	 */
	public String getRcattch();

	/**
	 * ���ռ��ѡ��ȡ��
	 * @return ���ռ��ѡ��
	 */
	public String getRcoption();
	
	/**
	 * ���ռ�����ִ�б��ʽȡ��
	 * @return ���ռ�����ִ�б��ʽ
	 */
	public String getRccron();
	
	/**
	 * ���ռ������ʲ�����
	 * @return ���ռ������ʲ�����
	 */
	public String getRcassetname();
	
	/**
	 * ���ռ�������ȡ��
	 * @return ���ռ�������
	 */
	public String getRccategory();
	
	/**
	 * ���ռ�����������ȡ��
	 * @return ���ռ�����������
	 */
	public String getRccategoryname();
	
	/**
	 * ���ռ��Ǽ�ʱ��ȡ��
	 * @return ���ռ��Ǽ�ʱ��
	 */
	public String getRccreatetime();
	
	/**
	 * ���ռ������ʱ��ȡ��
	 * @return ���ռ������ʱ��
	 */
	public String getRcapprovetime();
	
	/**
	 * ���ռ��������ȡ��
	 * @return ���ռ��������
	 */
	public String getRcapprover();
	
	/**
	 * ���ռ��Ƶ��(ÿ�����һ��)ȡ��
	 * @return ���ռ��Ƶ��(ÿ�����һ��)
	 */
	public String getRcfrequencymonthlastday();
	
	/**
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getRcupdatetime();
	
	/**
	 * ����ȡ��
	 * @return ����ʱ��
	 */
	public String getRcclass();

	/**
	 * ��鷽��ȡ��
	 * @return ��鷽��
	 */
	public String getRccommon();
	/**
	 * ����ִ����ȡ��
	 * @return ����ִ����
	 */
	public String getCog();
	/**
	 * ����ִ����ȡ��
	 * @return ����ִ����
	 */
	public String getCiiop();
	/**
	 * ����ִ������ȡ��
	 * @return ����ִ������
	 */
	public Integer getWtip();
	/**
	 * ����ִ����IDȡ��
	 * @return ����ִ����ID
	 */
	public String getCogid();
	/**
	 * ����ִ����IDȡ��
	 * @return ����ִ����ID
	 */
	public String getCiiopid();
	public String getRcrtestmode();
	
	/**
	 * ���ռ������ʲ��汾��ȡ��
	 * @return the rcassetversion
	 */
	public Integer getRcassetversion();
}