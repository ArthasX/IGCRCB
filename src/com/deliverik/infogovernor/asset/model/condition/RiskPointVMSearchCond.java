/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.condition;

/**
  * ����: ���յ��ѯ���������ӿ�
  * ��������: ���յ��ѯ���������ӿ�
  * ������¼: 2014/06/30
  * �޸ļ�¼: 
  */
public interface RiskPointVMSearchCond {
	/**
	 * ��������ȡ��
	 */
	public String getEiname();

	/**
	 * ���ռ���ȡ��
	 */
	public String getLevels();

	/**
	 * ���յȼ�ȡ��*/
	public String getGrad() ;



	/**
	 * �����ȡ��
	 */
	public String getSyscoding();
	
	/**
	 * ������ȡ��
	 * @return mguserid ������
	 */
	public String getMguserid();
	/**
	 * �Ǽǿ�ʼȡ��
	 * @return startdate �Ǽǿ�ʼ
	 */
	public String getStartdate();

	/**
	 * �ȼ�����ȡ��
	 * @return enddate �ȼ�����
	 */
	public String getEnddate();
	/**
	 * ���ձ�־ȡ��
	 * @return risksign ���ձ�־
	 */
	public String getRisksign();
	/**
	 * ���ձ��ȡ��
	 * @return eilabel ���ձ��
	 */
	public String getEilabel();
	/**
	 * ���շ�������ȡ��
	 * @return poss ���շ�������
	 */
	public String getPoss();
	/**
	 * ��������EIIDȡ��
	 * @return eiid ��������EIID
	 */
	public String getEiid();
}