package com.deliverik.infogovernor.risk.model.condition;



/**
 * �ʲ���Ϣ��ѯ�����ӿ�
 * 
 */
public interface RiskCheckSearchCond {
	/**
	 * ���ռ��id
	 * @return ���ռ��id
	 */
	public Integer getRcid(); 
	
	public Integer[] getRcid_in(); 
	
	/**
	 * ���ռ������
	 * @return ���ռ������
	 */
	public String getRcname();

	/**
	 * ���ռ������
	 * @return ���ռ������
	 */
	public String getRcdesc();

	/**
	 * ���ռ����Ҫ��
	 * @return ���ռ����Ҫ��
	 */
	public String getRctype();

	/**
	 * ���ռ��״̬
	 * @return ���ռ��״̬
	 */
	public String getRcstatus(); 

	/**
	 * ���ռ����ʼʱ��
	 * @return ���ռ����ʼʱ��
	 */
	public String getRcstartdate();

	/**
	 * ���ռ�����ʱ��
	 * @return ���ռ�����ʱ��
	 */
	public String getRcenddate();

	/**
	 * ���ռ��Ƶ��
	 * @return ���ռ��Ƶ��
	 */
	public String getRcfrequency();

	/**
	 * ���ռ��������id
	 * @return ���ռ��������id
	 */
	public String getRcuserid();

	/**
	 * ���ռ������������
	 * @return ���ռ������������
	 */
	public String getRcusername();

	/**
	 * ���ռ���������ɫid
	 * @return ���ռ���������ɫid
	 */
	public String getRcroleid();

	/**
	 * ���ռ���������ɫ��
	 * @return ���ռ���������ɫ��
	 */
	public String getRcrolename();

	/**
	 * ���ռ������ʲ�id
	 * @return ���ռ������ʲ�id
	 */
	public Integer getRcasset();

	/**
	 * ���ռ�鸽��id
	 * @return ���ռ�鸽��id
	 */
	public String getRcattch();

	/**
	 * ���ռ��ѡ��
	 * @return ���ռ��ѡ��
	 */
	public String getRcoption();
	
	/**
	 * ���ռ�����Ʋ�ѯ����
	 * @return ���ռ�����Ʋ�ѯ����
	 */
	public String getRcname_q();
	
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
	 * ���ռ������ȡ��
	 * @return ���ռ��������
	 */
	public String getRcclass();
	public String getYearMonth() ;
	public String getYear();
	public String getMonth();
	public String getEndDate() ;
	public String getStartDate() ;
	
	/**
	 * ����ʱ��ȡ��
	 * @return rcCreateTime_like ����ʱ��
	 */
	public String getRcCreateTime_like();
}
