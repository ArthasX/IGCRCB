/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.drm.model.DrillplanInfo;

/**
  * ����: �����ƻ�ʵ��
  * ��������: �����ƻ�ʵ��
  * ������¼: 2015/03/02
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="drillplan")
public class DrillplanTB extends BaseEntity implements Serializable,
		Cloneable, DrillplanInfo {

	/** �����ƻ�id */
	@Id
	@TableGenerator(
		name="DRILLPLAN_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="DRILLPLAN_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="DRILLPLAN_TABLE_GENERATOR")
	protected Integer did;

	/** �����ƻ��ƶ���id */
	protected String duserid;

	/** �����ƻ�ָ������ */
	protected String dusername;

	/** ����ʱ�� */
	protected String crttime;

	/** ����ʱ�� */
	protected String judgetime;

	/** �����ƻ���� */
	protected String dserial;

	/** �����ƻ����� */
	protected String dname;

	/** ����״̬ #Ϊ�༭�У�a Ϊ����t����ͨ����fΪ�������� */
	protected String judgestatus;
	
	/** ���� */
	protected String depict;
	
	/** ������� */
	protected String dopinion;
	
	/**������userid*/
	protected String judgeuserid;

	/**������username*/
	protected String judgeusername;
	
	/**�������*/
    protected String completecount;
	
	
    
    
    public String getCompletecount() {
        return completecount;
    }

    public void setCompletecount(String completecount) {
        this.completecount = completecount;
    }

    /** ������� */
	public String getDopinion() {
        return dopinion;
    }

    public void setDopinion(String dopinion) {
        this.dopinion = dopinion;
    }

    public String getJudgeuserid() {
        return judgeuserid;
    }

    public void setJudgeuserid(String judgeuserid) {
        this.judgeuserid = judgeuserid;
    }

    public String getJudgeusername() {
        return judgeusername;
    }

    public void setJudgeusername(String judgeusername) {
        this.judgeusername = judgeusername;
    }

    /**
	 * �����ƻ�idȡ��
	 *
	 * @return �����ƻ�id
	 */
	public Integer getDid() {
		return did;
	}

	/**
	 * �����ƻ�id�趨
	 *
	 * @param did �����ƻ�id
	 */
	public void setDid(Integer did) {
		this.did = did;
	}

	/**
	 * �����ƻ��ƶ���idȡ��
	 *
	 * @return �����ƻ��ƶ���id
	 */
	public String getDuserid() {
		return duserid;
	}

	/**
	 * �����ƻ��ƶ���id�趨
	 *
	 * @param duserid �����ƻ��ƶ���id
	 */
	public void setDuserid(String duserid) {
		this.duserid = duserid;
	}

	/**
	 * �����ƻ�ָ������ȡ��
	 *
	 * @return �����ƻ�ָ������
	 */
	public String getDusername() {
		return dusername;
	}

	/**
	 * �����ƻ�ָ�������趨
	 *
	 * @param dusername �����ƻ�ָ������
	 */
	public void setDusername(String dusername) {
		this.dusername = dusername;
	}

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getCrttime() {
		return crttime;
	}

	/**
	 * ����ʱ���趨
	 *
	 * @param crttime ����ʱ��
	 */
	public void setCrttime(String crttime) {
		this.crttime = crttime;
	}

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getJudgetime() {
		return judgetime;
	}

	/**
	 * ����ʱ���趨
	 *
	 * @param judgetime ����ʱ��
	 */
	public void setJudgetime(String judgetime) {
		this.judgetime = judgetime;
	}

	/**
	 * �����ƻ����ȡ��
	 *
	 * @return �����ƻ����
	 */
	public String getDserial() {
		return dserial;
	}

	/**
	 * �����ƻ�����趨
	 *
	 * @param dserial �����ƻ����
	 */
	public void setDserial(String dserial) {
		this.dserial = dserial;
	}

	/**
	 * �����ƻ�����ȡ��
	 *
	 * @return �����ƻ�����
	 */
	public String getDname() {
		return dname;
	}

	/**
	 * �����ƻ������趨
	 *
	 * @param dname �����ƻ�����
	 */
	public void setDname(String dname) {
		this.dname = dname;
	}

	/**
	 * ����״̬ a Ϊ����b�����У�c�������ȡ��
	 *
	 * @return ����״̬ a Ϊ����b�����У�c�������
	 */
	public String getJudgestatus() {
		return judgestatus;
	}

	/**
	 * ����״̬ a Ϊ����b�����У�c��������趨
	 *
	 * @param judgestatus ����״̬ a Ϊ����b�����У�c�������
	 */
	public void setJudgestatus(String judgestatus) {
		this.judgestatus = judgestatus;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getDepict() {
		return depict;
	}

	/**
	 * �����趨
	 *
	 * @param depict ����
	 */
	public void setDepict(String depict) {
		this.depict = depict;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	@Override
    public Serializable getPK() {
		return did;
	}

}