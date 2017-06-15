package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
 * �ʲ���ϵ��Ϣ
 *
 */
public interface SOC0119Info  extends BaseModel {

	/**
	 * �ʲ���ϵIDȡ��
	 * @return �ʲ���ϵID
	 */
	public Integer getEirid();

	/**
	 * �ʲ�ID������ȡ��
	 * @return �ʲ�ID������
	 */
	public Integer getPareiid();

	/**
	 * �ʲ�ģ��ID������ȡ��
	 * @return �ʲ�ģ��ID������
	 */
	public String getPareid();

	/**
	 * �ʲ�ID������ȡ��
	 * @return �ʲ�ID������
	 */
	public Integer getCldeiid();

	/**
	 * �ʲ�ID������ȡ��
	 * @return �ʲ�ID������
	 */
	public String getCldeid();

	/**
	 * �ʲ���ϵ����ʱ��ȡ��
	 * @return �ʲ���ϵ����ʱ��
	 */
	public String getEirupdtime();

	/**
	 * �ʲ���ϵ�Ƿ����ɾ����ʶȡ��
	 * @return �ʲ���ϵ�Ƿ����ɾ����ʶ
	 */
	public String getEirstatus();

	/**
	 * �ʲ���ϵIDȡ��
	 * @return �ʲ���ϵID
	 */
	public String getEirrelation();
	
	/**
	 * �ʲ���ϵ����ȡ��
	 * @return �ʲ���ϵ����
	 */
	public String getEirrelationcode();

	/**
	 * �ʲ���ϵ˵��ȡ��
	 * @return �ʲ���ϵ˵��
	 */
	public String getEirdesc();

	/**
	 * �ʲ���������Ϣȡ��
	 * @return �ʲ���������Ϣ
	 */
	public SOC0123Info getParEntityItemVW();
	
	/**
	 * �ʲ�(����)��Ϣȡ��
	 * @return �ʲ���������Ϣ
	 */
	public SOC0123Info getCldEntityItemVW();
	
	/**
	 * �ʲ���ϵ����0����1����ȡ��
	 * @return �ʲ���ϵ����
	 */
	public String getParflag();
	
	/**
	 * �����ʲ���汾ȡ��
	 * @return �����ʲ���汾
	 */
	public Integer getParversion();
	
	/**
	 * �����ʲ�С�汾ȡ��
	 * @return �����ʲ�С�汾
	 */
	public Integer getParsmallversion();
	
	/**
	 * �����ʲ���汾ȡ��
	 * @return �����ʲ���汾
	 */
	public Integer getCldversion();
	
	/**
	 * �����ʲ�С�汾ȡ��
	 * @return �����ʲ�С�汾
	 */
	public Integer getCldsmallversion();
	
	/**
	 * �߼�ɾ����ʶȡ��
	 * @return �߼�ɾ����ʶ
	 */
	public String getDeleteflag();
	
	/**
	 * ͨ���ʲ����������Զ����ɵĹ�ϵ��Ϣȡ��
	 * @return ͨ���ʲ����������Զ����ɵĹ�ϵ��Ϣ
	 */
	public String getEirinfo();
	
}