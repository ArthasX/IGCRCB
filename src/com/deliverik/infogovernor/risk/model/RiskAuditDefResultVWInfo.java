/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.model;


/**
 * ��������������������ͼʵ��ӿ�
 * 
 * @author lipeng@deliverik.com
 */
public interface RiskAuditDefResultVWInfo {
	/**
	 * ���������IDȡ��
	 * @return ���������ID
	 */
	public Integer getRadid();

	/**
	 * �������IDȡ��
	 * @return �������ID
	 */
	public Integer getRaid();

	/**
	 * �������������ȡ��
	 * @return �������������
	 */
	public String getRadname();

	/**
	 * �������������ȡ��
	 * @return �������������
	 */
	public String getRadcode();

	/**
	 * ����������ϼ������ȡ��
	 * @return ����������ϼ������
	 */
	public String getRadparcode();

	/**
	 * ���������״̬ȡ��
	 * @return ���������״̬
	 */
	public String getRadstatus();

	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public String getRadlevel();

	/**
	 * ��������������IDȡ��
	 * @return ��������������ID
	 */
	public Integer getRarid();

	/**
	 * ������Ʒ���IDȡ��
	 * @return ������Ʒ���ID
	 */
	public Integer getRaiid();

	/**
	 * �������������IDȡ��
	 * @return �������������ID
	 */
	public String getRaruserid();

	/**
	 * �����������������ȡ��
	 * @return �����������������
	 */
	public String getRarusername();

	/**
	 * ��������ƶȽ�������ȡ��
	 * @return ��������ƶȽ�������
	 */
	public String getRarplanscore();

	/**
	 * ��������ƶȽ�������ȡ��
	 * @return ��������ƶȽ�������
	 */
	public String getRarplandesc();

	/**
	 * ��������ƶ�ִ������ȡ��
	 * @return ��������ƶ�ִ������
	 */
	public String getRarexecscore();

	/**
	 * ��������ƶ�ִ������ȡ��
	 * @return ��������ƶ�ִ������
	 */
	public String getRarexecdesc();

	/**
	 * ���������������ȡ��
	 * @return ���������������
	 */
	public String getRaroverallscore();
	/**
	 * ���������������ȡ��
	 * @return ���������������
	 */
	public String getRaroveralldesc();

	/**
	 * �������������ֶ�ȡ��
	 * @return �������������ֶ�
	 */
	public String getRadmode();

	/**
	 * ����������������ȡ��
	 * @return ����������������
	 */
	public String getRadtype();

	/**
	 * ������������Ƶ��ȡ��
	 * @return ������������Ƶ��
	 */
	public String getRadfrequency();

	/**
	 * �����������ճ̶�ȡ��
	 * @return �����������ճ̶�
	 */
	public String getRadrisklevel();
	
	/**
	 * �������������������ȡ��
	 * @return �������������������
	 */
	public String getRadusername();

	/**
	 * ������������β���ȡ��
	 * @return ������������β���
	 */
	public String getRadorg();
	
	/**
	 * �������������ȡ��
	 * @return �������������
	 */
	public String getRaddesc();
}