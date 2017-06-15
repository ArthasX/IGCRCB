/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.infogovernor.risk.model.entity.RiskAuditDefTB;
import com.deliverik.infogovernor.risk.model.entity.RiskAuditInsTB;

/**
 * ������ƽ��ʵ��ӿ�
 * 
 * @author lipeng@deliverik.com
 */
public interface RiskAuditResult  extends BaseModel {
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
	 * ���������IDȡ��
	 * @return ���������ID
	 */
	public Integer getRadid();

	/**
	 * ���������������ȡ��
	 * @return ���������������
	 */
	public String getRardate();

	/**
	 * �������������idȡ��
	 * @return �������������id
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
	public String getRarcomment();
	
	/**
	 * ���������������ȡ��
	 * @return ���������������
	 */
	public String getRaroverallscore();
	
	/**
	 * �����������˵��ȡ��
	 * @return �����������˵��
	 */
	public String getRaroveralldesc();
	
	/**
	 * �����ʵ��ȡ��
	 * @return �����ʵ��
	 */
	public RiskAuditDefTB getRiskAuditDefTB();
	
	/**
	 * ��Ʒ���ʵ��ȡ��
	 * @return ��Ʒ���ʵ��
	 */
	public RiskAuditInsTB getRiskAuditInsTB();
	
	/**
	 * �������������ȡ��
	 * @return �������������
	 */
	public String getRadcode();
	
}