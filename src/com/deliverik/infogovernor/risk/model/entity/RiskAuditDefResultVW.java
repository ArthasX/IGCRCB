package com.deliverik.infogovernor.risk.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.deliverik.infogovernor.risk.model.RiskAuditDefResultVWInfo;


/**
 * ��������������������ͼʵ��
 *
 */
@Entity
@org.hibernate.annotations.Entity(mutable=false)
@Table(name = "RiskAuditDefResultVW")
@SuppressWarnings("serial")
public class RiskAuditDefResultVW implements Serializable, Cloneable, RiskAuditDefResultVWInfo {

	/** ���������ID */
	@Id
	protected Integer radid;
	
	/** �������ID */
	protected Integer raid;
	
	/** ������������� */
	protected String radname;
	
	/** ������������� */
	protected String radcode;
	
	/** ����������ϼ������ */
	protected String radparcode;
	
	/** ���������״̬ */
	protected String radstatus;
	
	/** ���������� */
	protected String radlevel;
	
	/** ��������������ID */
	protected Integer rarid;

	/** ������Ʒ���ID */
	protected Integer raiid;
	
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
	
	/** �����������ճ̶� */
	protected String radrisklevel;
	
	/** �������������ֶ� */
	protected String radmode;
	
	/** ���������������� */
	protected String radtype;
	
	/** ������������Ƶ�� */
	protected String radfrequency;
	
	/** ������������������� */
	protected String radusername;
	
	/** ������������β��� */
	protected String radorg;
	
	/** ������������� */
	protected String raddesc;
	
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
	 * �������IDȡ��
	 * @return �������ID
	 */
	public Integer getRaid() {
		return raid;
	}

	/**
	 * �������ID�趨
	 * @param raid �������ID
	 */
	public void setRaid(Integer raid) {
		this.raid = raid;
	}
	
	/**
	 * �������������ȡ��
	 * @return �������������
	 */
	public String getRadname() {
		return radname;
	}

	/**
	 * ��������������趨
	 * @param radname �������������
	 */
	public void setRadname(String radname) {
		this.radname = radname;
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
	
	/**
	 * ����������ϼ������ȡ��
	 * @return ����������ϼ������
	 */
	public String getRadparcode() {
		return radparcode;
	}

	/**
	 * ����������ϼ�������趨
	 * @param radparcode ����������ϼ������
	 */
	public void setRadparcode(String radparcode) {
		this.radparcode = radparcode;
	}
	
	/**
	 * ���������״̬ȡ��
	 * @return ���������״̬
	 */
	public String getRadstatus() {
		return radstatus;
	}

	/**
	 * ���������״̬�趨
	 * @param radstatus ���������״̬
	 */
	public void setRadstatus(String radstatus) {
		this.radstatus = radstatus;
	}
	
	/**
	 * ����������ȡ��
	 * @return ����������
	 */
	public String getRadlevel() {
		return radlevel;
	}

	/**
	 * �����������趨
	 * @param radlevel ����������
	 */
	public void setRadlevel(String radlevel) {
		this.radlevel = radlevel;
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
	 * �������������ֶ�ȡ��
	 * @return �������������ֶ�
	 */
	public String getRadmode() {
		return radmode;
	}

	/**
	 * �������������ֶ��趨
	 * @param radmode �������������ֶ�
	 */
	public void setRadmode(String radmode) {
		this.radmode = radmode;
	}

	/**
	 * ����������������ȡ��
	 * @return ����������������
	 */
	public String getRadtype() {
		return radtype;
	}

	/**
	 * �����������������趨
	 * @param radtype ����������������
	 */
	public void setRadtype(String radtype) {
		this.radtype = radtype;
	}

	/**
	 * ������������Ƶ��ȡ��
	 * @return ������������Ƶ��
	 */
	public String getRadfrequency() {
		return radfrequency;
	}

	/**
	 * ������������Ƶ���趨
	 * @param radfrequency ������������Ƶ��
	 */
	public void setRadfrequency(String radfrequency) {
		this.radfrequency = radfrequency;
	}
	

	/**
	 * �����������ճ̶�ȡ��
	 * @return �����������ճ̶�
	 */
	public String getRadrisklevel() {
		return radrisklevel;
	}

	/**
	 * �����������ճ̶��趨
	 * @param radrisklevel �����������ճ̶�
	 */
	public void setRadrisklevel(String radrisklevel) {
		this.radrisklevel = radrisklevel;
	}
	
	/**
	 * �������������������ȡ��
	 * @return �������������������
	 */
	public String getRadusername() {
		return radusername;
	}

	/**
	 * ��������������������趨
	 * @param radusername �������������������
	 */
	public void setRadusername(String radusername) {
		this.radusername = radusername;
	}

	/**
	 * ������������β���ȡ��
	 * @return ������������β���
	 */
	public String getRadorg() {
		return radorg;
	}

	/**
	 * ������������β����趨
	 * @param radorg ������������β���
	 */
	public void setRadorg(String radorg) {
		this.radorg = radorg;
	}
	
	/**
	 * �������������ȡ��
	 * @return �������������
	 */
	public String getRaddesc() {
		return raddesc;
	}

	/**
	 * ��������������趨
	 * @param raddesc �������������
	 */
	public void setRaddesc(String raddesc) {
		this.raddesc = raddesc;
	}

}
