package com.deliverik.framework.soc.asset.model;
/**
 * �ʲ�������Ϣ��ͼ
 * 
 * @author
 */
public interface SOC0606Info {

	/**
	 * �ʲ�����IDȡ��
	 * @return �ʲ�����ID
	 */
	public String getCiid();

	/**
	 * �ʲ�IDȡ��
	 * @return �ʲ�ID
	 */
	public String getEiid();

	/**
	 * �ʲ�ģ������IDȡ��
	 * @return �ʲ�ģ������ID
	 */
	public String getCid();

	/**
	 * �ʲ�ģ��IDȡ��
	 * @return �ʲ�ģ��ID
	 */
	public String getEid();

	/**
	 * �ʲ�ģ����������ȡ��
	 * @return �ʲ�ģ����������
	 */
	public String getCname();

	/**
	 * �ʲ�ģ������˵��ȡ��
	 * @return �ʲ�ģ������˵��
	 */
	public String getCdesc();

	/**
	 * �ʲ�ģ�����Ե�λȡ��
	 * @return �ʲ�ģ�����Ե�λ
	 */
	public String getCunit();

	/**
	 * �ʲ�ģ������״̬ȡ��
	 * @return �ʲ�ģ������״̬
	 */
	public String getCstatus();

	/**
	 * �ʲ�ģ����������ȡ��
	 * @return �ʲ�ģ���������� 
	 */
	public String getCcategory();

	/**
	 * �ʲ�ģ�������Ƿ���ʾ��ʶȡ��
	 * @return �ʲ�ģ�������Ƿ���ʾ��ʶ
	 */
	public String getCseq();

	/**
	 * �ʲ�ģ�����Ա��ȡ��
	 * @return �ʲ�ģ�����Ա��
	 */
	public String getClabel();

	/**
	 * �ʲ�ģ������ȡֵ��Χȡ��
	 * @return �ʲ�ģ������ȡֵ��Χ
	 */
	public String getCoption();

	/**
	 * �ʲ�ģ�����Ը�����ʶȡ��
	 * @return �ʲ�ģ�����Ը�����ʶ
	 */
	public String getCattach();

	/**
	 * �ʲ�����ֵȡ��
	 * @return �ʲ�����ֵ
	 */
	public String getCivalue();

	/**
	 * �ʲ����Ը���ʱ��ȡ��
	 * @return �ʲ����Ը���ʱ��
	 */
	public String getCiupdtime();

	/**
	 * �ʲ����Թ���ʱ��ȡ��
	 * @return �ʲ����Թ���ʱ��
	 */
	public String getCiexpire();

	/**
	 * �ʲ�����״̬ȡ��
	 * @return �ʲ�����״̬
	 */
	public String getCistatus();

	/**
	 * �ʲ����Դ�汾��ȡ��
	 * @return �ʲ����Դ�汾��
	 */
	public Integer getCiversion();

	/**
	 * �ʲ����԰汾��Ϣȡ��
	 * @return �ʲ����԰汾��Ϣ
	 */
	public String getCiverinfo();
	/**
	 * �ʲ�ģ�Ͳ����ȡ��
	 * @return �ʲ�ģ�Ͳ����
	 */
	public String getEsyscoding();
	
	public String getEilabel();
	
	public String getEiname();
	
	public String getSrename();
	
	public String getCicurver();
	
	 /**
	 * �ʲ�����С�汾��ȡ��
	 * @return �ʲ�����С�汾��
	 */
	public Integer getCismallversion();
	
	/**
	 * 
	 * �����ʶ
	 * @return
	 */
	public Integer getCorder();
	
}