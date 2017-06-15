/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sdl.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Transient;

import com.deliverik.infogovernor.sdl.model.SdlDefineInfo;
import com.deliverik.infogovernor.sdl.model.SdlYearSummary;


/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �������_����ˮƽ����_����ˮƽ��׼��ϢMODEL
 * </p>
 * 
 * @author liupeng@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
//public class SdlYearSummaryVW extends BaseEntity implements Serializable, Cloneable, SdlYearSummary {
public class SdlYearSummaryVW implements Serializable, Cloneable, SdlYearSummary {

	@Id
	/**�ʲ�id */
	protected Integer sieiid;
	
	/**�ʲ����� */
	protected String sieiname;
	
	/**���ж�ʱ�� */
	protected Integer breakm;

	@Transient
	/** ������ʱ��ٷֱ�*/
	protected Double continuousm;

	/**��Ӱ��ʱ��*/
	protected Integer impactm;

	@Transient
	/** ���ȶ�ʱ��ٷֱ�*/
	protected Double steadym;
	
	/**�°�ȫ�¼�����*/
	protected Integer safecasem;
	
	/**�°�ȫ�¼�����*/
	protected Integer safemarkm;
	
	/** �·��ռ������*/
	protected Integer riskmarkm;
	
	/**�������¼����� */
	protected Integer capacitycasem;
	
	/**�������¼�����*/
	protected Integer capacitymarkm;
	
	@Transient
	protected SdlDefineInfo sdlDefineInfo;
	
	/**
	 * ��ȡ���ж�ʱ��
	 * @return ���ж�ʱ��
	 */
	public Integer getBreakm() {
		return breakm;
	}

	/**
	 * �������ж�ʱ��
	 * @param breakm ���ж�ʱ��
	 */
	public void setBreakm(Integer breakm) {
		this.breakm = breakm;
	}

	/**
	 * ��ȡ������ʱ��ٷֱ�
	 * @return ������ʱ��ٷֱ�
	 */
	public Double getContinuousm() {
		return continuousm;
	}

	/**
	 * ����������ʱ��ٷֱ�
	 * @param continuousm ������ʱ��ٷֱ�
	 */
	public void setContinuousm(Double continuousm) {
		this.continuousm = continuousm;
	}

	/**
	 * ��ȡ��Ӱ��ʱ��
	 * @return ��Ӱ��ʱ��
	 */
	public Integer getImpactm() {
		return impactm;
	}

	/**
	 * ������Ӱ��ʱ��
	 * @param impactm ��Ӱ��ʱ��
	 */
	public void setImpactm(Integer impactm) {
		this.impactm = impactm;
	}

	/**
	 * ��ȡ���ȶ�ʱ��ٷֱ�
	 * @return ���ȶ�ʱ��ٷֱ�
	 */
	public Double getSteadym() {
		return steadym;
	}

	/**
	 * �������ȶ�ʱ��ٷֱ�
	 * @param steadym ���ȶ�ʱ��ٷֱ�
	 */
	public void setSteadym(Double steadym) {
		this.steadym = steadym;
	}

	/**
	 * ��ȡ�°�ȫ�¼�����
	 * @return �°�ȫ�¼�����
	 */
	public Integer getSafecasem() {
		return safecasem;
	}

	/**
	 * �����°�ȫ�¼�����
	 * @param safecasem �°�ȫ�¼�����
	 */
	public void setSafecasem(Integer safecasem) {
		this.safecasem = safecasem;
	}

	/**
	 * ��ȡ�°�ȫ�¼�����
	 * @return �°�ȫ�¼�����
	 */
	public Integer getSafemarkm() {
		return safemarkm;
	}

	/**
	 * �����°�ȫ�¼�����
	 * @param safemarkm �°�ȫ�¼�����
	 */
	public void setSafemarkm(Integer safemarkm) {
		this.safemarkm = safemarkm;
	}

	/**
	 * ��ȡ�·��ռ������
	 * @return �·��ռ������
	 */
	public Integer getRiskmarkm() {
		return riskmarkm;
	}

	/**
	 * �����·��ռ������
	 * @param riskmarkm �·��ռ������
	 */
	public void setRiskmarkm(Integer riskmarkm) {
		this.riskmarkm = riskmarkm;
	}

	/**
	 * ��ȡ�������¼�����
	 * @return �������¼�����
	 */
	public Integer getCapacitycasem() {
		return capacitycasem;
	}

	/**
	 * �����������¼�����
	 * @param capacitycasem �������¼�����
	 */
	public void setCapacitycasem(Integer capacitycasem) {
		this.capacitycasem = capacitycasem;
	}

	/**
	 * ��ȡ�������¼�����
	 * @return �������¼�����
	 */
	public Integer getCapacitymarkm() {
		return capacitymarkm;
	}

	/**
	 * �����������¼�����
	 * @param capacitymarkm �������¼�����
	 */
	public void setCapacitymarkm(Integer capacitymarkm) {
		this.capacitymarkm = capacitymarkm;
	}

	public Serializable getPK() {
		return sieiid;
	}

	public Integer getSieiid() {
		return sieiid;
	}

	public void setSieiid(Integer sieiid) {
		this.sieiid = sieiid;
	}

	public String getSieiname() {
		return sieiname;
	}

	public void setSieiname(String sieiname) {
		this.sieiname = sieiname;
	}

	public SdlDefineInfo getSdlDefineInfo() {
		return sdlDefineInfo;
	}

	public void setSdlDefineInfo(SdlDefineInfo sdlDefineInfo) {
		this.sdlDefineInfo = sdlDefineInfo;
	}
	
}
