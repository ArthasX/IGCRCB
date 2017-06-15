/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.risk.form;

import java.io.Serializable;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.risk.model.RiskAuditResult;
import com.deliverik.infogovernor.risk.model.entity.RiskAuditDefTB;
import com.deliverik.infogovernor.risk.model.entity.RiskAuditInsTB;


/**
 * ���������ϢForm
 *
 * @author maozhipeng@deliverik.com
 */
@SuppressWarnings("serial")
public class IGRIS0114Form extends BaseForm implements RiskAuditResult {
	
	/** ��������������ID */
	protected Integer rarid;

	/** ������Ʒ���ID */
	protected Integer raiid;
	
	/** ���������ID */
	protected Integer radid;
	
	/** ��������������� */
	protected String rardate;

	/** �������������ID */
	protected String raruserid;
	
	/** ����������������� */
	protected String rarusername;
	
	/** ��������ƶȽ������� */
	protected String rarplanscore;
	
	/** ��������ƶȽ������� */
	protected String rarplandesc;
	
	/** ��������ƶ�ִ������ */
	protected String rarexecscore;
	
	/** ��������ƶ�ִ������ */
	protected String rarexecdesc;
	
	/** ��������������� */
	protected String raroverallscore;
	
	/** ��������������� */
	protected String raroveralldesc;
	
	/** �����������˵�� */
	protected String rarcomment;
	
	/** ������������� */
	protected String radcode;
	
	/** �����ʵ�� */

	protected RiskAuditDefTB riskAuditDefTB;
	
	/** ��Ʒ���ʵ�� */

	protected RiskAuditInsTB riskAuditInsTB;
	
	/**
	 * ����ȡ��
	 * @return 
	 */
	public Serializable getPK() {
		return rarid;
	}

	/**
	 * ��������������IDȡ��
	 * @return ��������������ID
	 */
	public Integer getRarid() {
		return rarid;
	}

	/**
	 * ��������������ID�趨
	 * @param rarid ��������������ID
	 */
	public void setRarid(Integer rarid) {
		this.rarid = rarid;
	}

	/**
	 * ������Ʒ���IDȡ��
	 * @return ������Ʒ���ID
	 */
	public Integer getRaiid() {
		return raiid;
	}

	/**
	 * ������Ʒ���ID�趨
	 * @param raiid ������Ʒ���ID
	 */
	public void setRaiid(Integer raiid) {
		this.raiid = raiid;
	}

	/**
	 * ���������������ȡ��
	 * @return ���������������
	 */
	public String getRardate() {
		return rardate;
	}

	/**
	 * ����������������趨
	 * @param rardate ���������������
	 */
	public void setRardate(String rardate) {
		this.rardate = rardate;
	}

	/**
	 * ���������IDȡ��
	 * @return ���������ID
	 */
	public Integer getRadid() {
		return radid;
	}

	/**
	 * ���������ID�趨
	 * @param radid ���������ID
	 */
	public void setRadid(Integer radid) {
		this.radid = radid;
	}

	/**
	 * �������������IDȡ��
	 * @return �������������ID
	 */
	public String getRaruserid() {
		return raruserid;
	}

	/**
	 * �������������ID�趨
	 * @param raruserid �������������ID
	 */
	public void setRaruserid(String raruserid) {
		this.raruserid = raruserid;
	}

	/**
	 * �����������������ȡ��
	 * @return �����������������
	 */
	public String getRarusername() {
		return rarusername;
	}

	/**
	 * ������������������趨
	 * @param rarusername �����������������
	 */
	public void setRarusername(String rarusername) {
		this.rarusername = rarusername;
	}

	/**
	 * ��������ƶȽ�������ȡ��
	 * @return ��������ƶȽ�������
	 */
	public String getRarplanscore() {
		return rarplanscore;
	}

	/**
	 * ��������ƶȽ��������趨
	 * @param rarplanscore ��������ƶȽ�������
	 */
	public void setRarplanscore(String rarplanscore) {
		this.rarplanscore = rarplanscore;
	}

	/**
	 * ��������ƶȽ�������ȡ��
	 * @return ��������ƶȽ�������
	 */
	public String getRarplandesc() {
		return rarplandesc;
	}

	/**
	 * ��������ƶȽ��������趨
	 * @param rarplandesc ��������ƶȽ�������
	 */
	public void setRarplandesc(String rarplandesc) {
		this.rarplandesc = rarplandesc;
	}

	/**
	 * ��������ƶ�ִ������ȡ��
	 * @return ��������ƶ�ִ������
	 */
	public String getRarexecscore() {
		return rarexecscore;
	}

	/**
	 * ��������ƶ�ִ�������趨
	 * @param rarexecscore ��������ƶ�ִ������
	 */
	public void setRarexecscore(String rarexecscore) {
		this.rarexecscore = rarexecscore;
	}

	/**
	 * ��������ƶ�ִ������ȡ��
	 * @return ��������ƶ�ִ������
	 */
	public String getRarexecdesc() {
		return rarexecdesc;
	}

	/**
	 * ��������ƶ�ִ�������趨
	 * @param rarexecdesc ��������ƶ�ִ������
	 */
	public void setRarexecdesc(String rarexecdesc) {
		this.rarexecdesc = rarexecdesc;
	}

	/**
	 * ���������������ȡ��
	 * @return ���������������
	 */
	public String getRaroverallscore() {
		return raroverallscore;
	}

	/**
	 * ����������������趨
	 * @param raroverallscore ���������������
	 */
	public void setRaroverallscore(String raroverallscore) {
		this.raroverallscore = raroverallscore;
	}

	/**
	 * ���������������ȡ��
	 * @return ���������������
	 */
	public String getRaroveralldesc() {
		return raroveralldesc;
	}

	/**
	 * ����������������趨
	 * @param raroveralldesc ���������������
	 */
	public void setRaroveralldesc(String raroveralldesc) {
		this.raroveralldesc = raroveralldesc;
	}

	/**
	 * �����������˵��ȡ��
	 * @return �����������˵��
	 */
	public String getRarcomment() {
		return rarcomment;
	}

	/**
	 * �����������˵���趨
	 * @param rarcomment �����������˵��
	 */
	public void setRarcomment(String rarcomment) {
		this.rarcomment = rarcomment;
	}

	/**
	 * �����ʵ��ȡ��
	 * @return �����ʵ��
	 */
	public RiskAuditDefTB getRiskAuditDefTB() {
		return riskAuditDefTB;
	}

	/**
	 * �����ʵ���趨
	 * @param riskAuditDefTB �����ʵ��
	 */
	public void setRiskAuditDefTB(RiskAuditDefTB riskAuditDefTB) {
		this.riskAuditDefTB = riskAuditDefTB;
	}

	/**
	 * ��Ʒ���ʵ��ȡ��
	 * @return ��Ʒ���ʵ��
	 */
	public RiskAuditInsTB getRiskAuditInsTB() {
		return riskAuditInsTB;
	}

	/**
	 * ��Ʒ���ʵ���趨
	 * @param riskAuditInsTB ��Ʒ���ʵ��
	 */
	public void setRiskAuditInsTB(RiskAuditInsTB riskAuditInsTB) {
		this.riskAuditInsTB = riskAuditInsTB;
	}

	public String getFingerPrint() {
		// TODO Auto-generated method stub
		return null;
	}
	
	/**
	 * �������������ȡ��
	 * @return �������������
	 */
	public String getRadcode() {
		return radcode;
	}

	/**
	 * ��������������趨
	 * @param radcode �������������
	 */
	public void setRadcode(String radcode) {
		this.radcode = radcode;
	}

}
