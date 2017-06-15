/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * 
 */

package com.deliverik.infogovernor.sdl.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.sdl.model.SdlDefineInfo;


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
@Table(name="SdlDefineInfo")
public class SdlDefineInfoTB extends BaseEntity implements Serializable, Cloneable, SdlDefineInfo {

	@Id
	@TableGenerator(
		    name="SDLDEFINEINFO_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="SDLDEFINEINFO_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="SDLDEFINEINFO_TABLE_GENERATOR")
	/**����*/
	protected Integer sdiid;

	/**���*/
	protected String sdiyear;

	/**����ʲ�ID*/
	protected Integer sdieiid;

	/**�ʲ����� */
	protected String sdieiname;

	/**���ж�ʱ�� */
	protected Integer sdibreakm;

	/**���ж�ʱ��*/
	protected Integer sdibreaky;

	/** ������ʱ��ٷֱ�*/
	protected Double sdicontinuousm;

	/**������ʱ��ٷֱ�*/
	protected Double sdicontinuousy;

	/**��Ӱ��ʱ��*/
	protected Integer sdiimpactm;

	/**��Ӱ��ʱ��*/
	protected Integer sdiimpacty;

	/** ���ȶ�ʱ��ٷֱ�*/
	protected Double sdisteadym;

	/**���ȶ�ʱ��ٷֱ�*/
	protected Double sdisteadyy;

	/**�°�ȫ�¼�����*/
	protected Integer sdisafecasem;

	/**�갲ȫ�¼�����*/
	protected Integer sdisafecasey;

	/**�°�ȫ�¼�����*/
	protected Integer sdisafemarkm;

	/**�갲ȫ�¼�����*/
	protected Integer sdisafemarky;

	/** �·��ռ������*/
	protected Integer sdiriskmarkm;

	/**����ռ������*/
	protected Integer sdiriskmarky;

	/**�������¼����� */
	protected Integer sdicapacitycasem;

	/**�������¼�����*/
	protected Integer sdicapacitycasey;

	/**�������¼�����*/
	protected Integer sdicapacitymarkm;

	/** �������¼�����*/
	protected Integer sdicapacitymarky;

	/**
	 * ��ȡ����
	 * @return 
	 */
	public Serializable getPK() {
		return sdiid;
	}

	/**
	 * �Ƚ�
	 * @return 
	 */
	public boolean equals(Object obj) {
		if (!(obj instanceof SdlDefineInfoTB))
			return false;
		SdlDefineInfo target = (SdlDefineInfo) obj;
		if (!(getSdiid()==target.getSdiid()))
			return false;

		return true;
	}

	/**
	 * ��ȡ����
	 * @return ����
	 */
	public Integer getSdiid() {
		return sdiid;
	}

	/**
	 * ��������
	 * @param sdiid ����
	 */
	public void setSdiid(Integer sdiid) {
		this.sdiid = sdiid;
	}
	
	/**
	 * ��ȡ���
	 * @return ���
	 */
	public String getSdiyear() {
		return sdiyear;
	}

	/**
	 * �������
	 * @param sdiyear ���
	 */
	public void setSdiyear(String sdiyear) {
		this.sdiyear = sdiyear;
	}

	/**
	 * ��ȡ����ʲ�ID
	 * @return ����ʲ�ID
	 */
	public Integer getSdieiid() {
		return sdieiid;
	}

	/**
	 * ��������ʲ�ID
	 * @param sdieiid ����ʲ�ID
	 */
	public void setSdieiid(Integer sdieiid) {
		this.sdieiid = sdieiid;
	}

	/**
	 * ��ȡ����ʲ�����
	 * @return ����ʲ�����
	 */
	public String getSdieiname() {
		return sdieiname;
	}

	/**
	 * ��������ʲ�����
	 * @param sdieiname ����ʲ�����
	 */
	public void setSdieiname(String sdieiname) {
		this.sdieiname = sdieiname;
	}

	/**
	 * ��ȡ���ж�ʱ��
	 * @return ���ж�ʱ��
	 */
	public Integer getSdibreakm() {
		return sdibreakm;
	}

	/**
	 * �������ж�ʱ��
	 * @param sdibreakm ���ж�ʱ��
	 */
	public void setSdibreakm(Integer sdibreakm) {
		this.sdibreakm = sdibreakm;
	}

	/**
	 * ��ȡ���ж�ʱ��
	 * @return ���ж�ʱ��
	 */
	public Integer getSdibreaky() {
		return sdibreaky;
	}

	/**
	 * �������ж�ʱ��
	 * @param sdibreaky ���ж�ʱ��
	 */
	public void setSdibreaky(Integer sdibreaky) {
		this.sdibreaky = sdibreaky;
	}

	/**
	 * ��ȡ������ʱ��ٷֱ�
	 * @return ������ʱ��ٷֱ�
	 */
	public Double getSdicontinuousm() {
		return sdicontinuousm;
	}

	/**
	 * ����������ʱ��ٷֱ�
	 * @param sdicontinuousm ������ʱ��ٷֱ�
	 */
	public void setSdicontinuousm(Double sdicontinuousm) {
		this.sdicontinuousm = sdicontinuousm;
	}

	/**
	 * ��ȡ������ʱ��ٷֱ�
	 * @return ������ʱ��ٷֱ�
	 */
	public Double getSdicontinuousy() {
		return sdicontinuousy;
	}

	/**
	 * ����������ʱ��ٷֱ�
	 * @param sdicontinuousy ������ʱ��ٷֱ�
	 */
	public void setSdicontinuousy(Double sdicontinuousy) {
		this.sdicontinuousy = sdicontinuousy;
	}

	/**
	 * ��ȡ��Ӱ��ʱ��
	 * @return ��Ӱ��ʱ��
	 */
	public Integer getSdiimpactm() {
		return sdiimpactm;
	}

	/**
	 * ������Ӱ��ʱ��
	 * @param sdiimpactm ��Ӱ��ʱ��
	 */
	public void setSdiimpactm(Integer sdiimpactm) {
		this.sdiimpactm = sdiimpactm;
	}

	/**
	 * ��ȡ��Ӱ��ʱ��
	 * @return ��Ӱ��ʱ��
	 */
	public Integer getSdiimpacty() {
		return sdiimpacty;
	}

	/**
	 * ������Ӱ��ʱ��
	 * @param sdiimpacty ��Ӱ��ʱ��
	 */
	public void setSdiimpacty(Integer sdiimpacty) {
		this.sdiimpacty = sdiimpacty;
	}

	/**
	 * ��ȡ���ȶ�ʱ��ٷֱ�
	 * @return ���ȶ�ʱ��ٷֱ�
	 */
	public Double getSdisteadym() {
		return sdisteadym;
	}

	/**
	 * �������ȶ�ʱ��ٷֱ�
	 * @param sdisteadym ���ȶ�ʱ��ٷֱ�
	 */
	public void setSdisteadym(Double sdisteadym) {
		this.sdisteadym = sdisteadym;
	}

	/**
	 * ��ȡ���ȶ�ʱ��ٷֱ�
	 * @return ���ȶ�ʱ��ٷֱ�
	 */
	public Double getSdisteadyy() {
		return sdisteadyy;
	}

	/**
	 * �������ȶ�ʱ��ٷֱ�
	 * @param sdisteadyy ���ȶ�ʱ��ٷֱ�
	 */
	public void setSdisteadyy(Double sdisteadyy) {
		this.sdisteadyy = sdisteadyy;
	}

	/**
	 * ��ȡ�°�ȫ�¼�����
	 * @return �°�ȫ�¼�����
	 */
	public Integer getSdisafecasem() {
		return sdisafecasem;
	}

	/**
	 * �����°�ȫ�¼�����
	 * @param sdisafecasem �°�ȫ�¼�����
	 */
	public void setSdisafecasem(Integer sdisafecasem) {
		this.sdisafecasem = sdisafecasem;
	}

	/**
	 * ��ȡ�갲ȫ�¼�����
	 * @return �갲ȫ�¼�����
	 */
	public Integer getSdisafecasey() {
		return sdisafecasey;
	}

	/**
	 * �����갲ȫ�¼�����
	 * @param sdisafecasey �갲ȫ�¼�����
	 */
	public void setSdisafecasey(Integer sdisafecasey) {
		this.sdisafecasey = sdisafecasey;
	}

	/**
	 * ��ȡ�°�ȫ�¼�����
	 * @return �°�ȫ�¼�����
	 */
	public Integer getSdisafemarkm() {
		return sdisafemarkm;
	}

	/**
	 * �����°�ȫ�¼�����
	 * @param sdisafemarkm �°�ȫ�¼�����
	 */
	public void setSdisafemarkm(Integer sdisafemarkm) {
		this.sdisafemarkm = sdisafemarkm;
	}

	/**
	 * ��ȡ�갲ȫ�¼�����
	 * @return �갲ȫ�¼�����
	 */
	public Integer getSdisafemarky() {
		return sdisafemarky;
	}

	/**
	 * �����갲ȫ�¼�����
	 * @param sdisafemarky �갲ȫ�¼�����
	 */
	public void setSdisafemarky(Integer sdisafemarky) {
		this.sdisafemarky = sdisafemarky;
	}

	/**
	 * ��ȡ�·��ռ������
	 * @return �·��ռ������
	 */
	public Integer getSdiriskmarkm() {
		return sdiriskmarkm;
	}

	/**
	 * �����·��ռ������
	 * @param sdiriskmarkm �·��ռ������
	 */
	public void setSdiriskmarkm(Integer sdiriskmarkm) {
		this.sdiriskmarkm = sdiriskmarkm;
	}

	/**
	 * ��ȡ����ռ������
	 * @return ����ռ������
	 */
	public Integer getSdiriskmarky() {
		return sdiriskmarky;
	}

	/**
	 * ��������ռ������
	 * @param sdiriskmarky ����ռ������
	 */
	public void setSdiriskmarky(Integer sdiriskmarky) {
		this.sdiriskmarky = sdiriskmarky;
	}

	/**
	 * ��ȡ�������¼�����
	 * @return �������¼�����
	 */
	public Integer getSdicapacitycasem() {
		return sdicapacitycasem;
	}

	/**
	 * �����������¼�����
	 * @param sdicapacitycasem �������¼�����
	 */
	public void setSdicapacitycasem(Integer sdicapacitycasem) {
		this.sdicapacitycasem = sdicapacitycasem;
	}

	/**
	 * ��ȡ�������¼�����
	 * @return �������¼�����
	 */
	public Integer getSdicapacitycasey() {
		return sdicapacitycasey;
	}

	/**
	 * �����������¼�����
	 * @param sdicapacitycasey �������¼�����
	 */
	public void setSdicapacitycasey(Integer sdicapacitycasey) {
		this.sdicapacitycasey = sdicapacitycasey;
	}

	/**
	 * ��ȡ�������¼�����
	 * @return �������¼�����
	 */
	public Integer getSdicapacitymarkm() {
		return sdicapacitymarkm;
	}

	/**
	 * �����������¼�����
	 * @param sdicapacitymarkm �������¼�����
	 */
	public void setSdicapacitymarkm(Integer sdicapacitymarkm) {
		this.sdicapacitymarkm = sdicapacitymarkm;
	}

	/**
	 * ��ȡ�������¼�����
	 * @return �������¼�����
	 */
	public Integer getSdicapacitymarky() {
		return sdicapacitymarky;
	}

	/**
	 * �����������¼�����
	 * @param sdicapacitymarky �������¼�����
	 */
	public void setSdicapacitymarky(Integer sdicapacitymarky) {
		this.sdicapacitymarky = sdicapacitymarky;
	}
	
}
