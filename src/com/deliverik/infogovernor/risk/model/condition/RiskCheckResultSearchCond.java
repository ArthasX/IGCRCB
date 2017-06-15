package com.deliverik.infogovernor.risk.model.condition;



/**
 * ���ռ����ʵ���ѯ�����ӿ�
 * 
 */
public interface RiskCheckResultSearchCond {
	/**
	 * ���ռ����id
	 * @return ���ռ����id
	 */
	public Integer getRcrid();

	/**
	 * ���ռ��id
	 * @return ���ռ��id
	 */
	public Integer getRcid();

	/**
	 * ���ռ��ƻ����ʱ��
	 * @return ���ռ��ƻ����ʱ��
	 */
	public String getRcrplandate();

	/**
	 * ���ռ��ʵ�ʼ��ʱ��
	 * @return ���ռ��ʵ�ʼ��ʱ��
	 */
	public String getRcrrealtime();

	/**
	 * ���ռ�����ύ��id
	 * @return ���ռ�����ύ��id
	 */
	public String getRcruserid();

	/**
	 * ���ռ�����ύ������
	 * @return ���ռ�����ύ������
	 */
	public String getRcrusername();

	/**
	 * ���ռ����
	 * @return ���ռ����
	 */
	public String getRcrresult();

	/**
	 * ���ռ����˵��
	 * @return ���ռ����˵��
	 */
	public String getRcrcomment();
	
	/**
	 * ���ռ�������ȡ��
	 * @return ���ռ�������
	 */
	public String getRccategory();
	
	public String getRcruserid_isNull();
	
	public String getStartdate();

	public String getEnddate();
	
	public String getRcname();
	
	public String getRcusername_like();
	
	public String getRcname_like();
	
	public String getNtime_from();
	
	public String getNtime_to();
	
	/**
	 * δ��鹤����ʶȡ��
	 * @return δ��鹤����ʶ
	 */
	public String getChtype();
	
	/**
	 * ���ռ��ʵ�ʼ��ʱ��ȡ��
	 * @return ���ռ��ʵ�ʼ��ʱ��
	 */
	public String getRcrrealtime_isNull();
	
	/**
	 * ���ռ��״̬ȡ��
	 * @return ���ռ��״̬
	 */
	public String getRcrstatic();
	
	/**
	 * ���ռ��ɼ���ɫȡ��
	 * @return ���ռ��ɼ���ɫ
	 */
	public Integer[] getRcroleid();
	
	/**
	 * ���ռ�鲻������������IDȡ��
	 * @return ���ռ�鲻������������ID
	 */
	public String getRcuserid_ne();

	/**
	 * ��Ҫ�̶Ȼ�ȡ
	 * 
	 * @return ��Ҫ�̶�
	 */
	public String getRctype_eq() ;
	
	/**
	 * ���ռ��������IDȡ��
	 * @return ���ռ��������ID
	 */
	public String getRcuserid();
	
	/**
	 * ���ռ�������Ա��ȡ
	 * @return ���ռ�������Ա
	 */
	public String getRcrelateduser();
	
	/**
	 * ���ռ��������
	 * @return ���ռ��������
	 */
	public String getRcclass();
	public String getYear();

	public String getRcrplandate_from();

	public String getRcrplandate_to();
	
	
	/**
	 * ���ռ��ʵ�ʼ��ʱ��ȡ��
	 * @return rcrrealtime_like ���ռ��ʵ�ʼ��ʱ��
	 */
	public String getRcrrealtime_like();
	
	public Integer[] getRcrid_in();
	
	/**
	 * ��鷽ʽȡ��
	 * @return rcrtestmode ��鷽ʽ
	 */
	public String getRcrtestmode();
	public String getRcusername();
	public String getCiiop();
	public String getRcapprovetime();
}
