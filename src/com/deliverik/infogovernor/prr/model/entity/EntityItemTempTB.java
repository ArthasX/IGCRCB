/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.prr.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.prr.model.EntityItemTempInfo;

/**
  * ����: ������ʱ�豸��Ϣ��ʵ��
  * ��������: ������ʱ�豸��Ϣ��ʵ��
  * ������¼: 2013/08/29
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="entityItemTemp")
public class EntityItemTempTB extends BaseEntity implements Serializable,
		Cloneable, EntityItemTempInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="ENTITYITEMTEMP_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="ENTITYITEMTEMP_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="ENTITYITEMTEMP_TABLE_GENERATOR")
	protected Integer eitid;

	/** ��Ӧ�Ĳɹ���� */
	protected String eitConNum;
	
	/** ��Ӧ�Ĳɹ�Eiid */
	protected String eitConEiid;
	
	/** ��Ӧ�ķ����̱�� */
	protected String eitSupNum;
	
	/** ��Ӧ�ķ�����Eiid */
	protected String eitSupEiid;

	/** �豸���� */
	protected String eitBClass;

	/** �豸С�� */
	protected String eitSClass;

	/** �豸Ʒ�� */
	protected String eitBrand;

	/** �豸�ͺ� */
	protected String eitModelNum;

	/** �豸��Ȩ���� */
	protected String eitSyscoding;

	/** ԭʼ�۸� */
	protected String eitPrice;

	/** ά������ */
	protected String eitFYear;

	/** �豸���� */
	protected Integer eitNum;

	/** ���޿�ʼ���� */
	protected String eitWarFrom;

	/** ���޽������� */
	protected String eitWarTo;

	/** ��ע */
	protected String eitDesc;

	/** δ�����豸���� */
	protected Integer eitUncheckNum;

	/** �������豸���� */
	protected Integer EitCheckedNum;
	
	/** �ɹ�ʱ�� */
	protected String eitPurchaseDate;
	
	/** ����id */
	protected Integer prid;
	
	/** ��� */
	protected String type;
	
	/** ��� -�����豸��������Ĳģ�����*/
	public  String getType() {
		return type;
	}
	/** ���-�����豸��������Ĳģ����� */
	public  void setType(String type) {
		this.type = type;
	}

	/**
	 * ��Ӧ�Ĳɹ�Eiidȡ��
	 *
	 * @return eitConEiid ��Ӧ�Ĳɹ�Eiid
	 */
	public String getEitConEiid() {
		return eitConEiid;
	}

	/**
	 * ��Ӧ�Ĳɹ�Eiid�趨
	 *
	 * @param eitConEiid ��Ӧ�Ĳɹ�Eiid
	 */
	public void setEitConEiid(String eitConEiid) {
		this.eitConEiid = eitConEiid;
	}

	/**
	 * ��Ӧ�ķ����̱��ȡ��
	 *
	 * @return eitSupNum ��Ӧ�ķ����̱��
	 */
	public String getEitSupNum() {
		return eitSupNum;
	}

	/**
	 * ��Ӧ�ķ����̱���趨
	 *
	 * @param eitSupNum ��Ӧ�ķ����̱��
	 */
	public void setEitSupNum(String eitSupNum) {
		this.eitSupNum = eitSupNum;
	}

	/**
	 * ��Ӧ�ķ�����Eiidȡ��
	 *
	 * @return eitSupEiid ��Ӧ�ķ�����Eiid
	 */
	public String getEitSupEiid() {
		return eitSupEiid;
	}

	/**
	 * ��Ӧ�ķ�����Eiid�趨
	 *
	 * @param eitSupEiid ��Ӧ�ķ�����Eiid
	 */
	public void setEitSupEiid(String eitSupEiid) {
		this.eitSupEiid = eitSupEiid;
	}

	/**
	 * ����idȡ��
	 *
	 * @return prid ����id
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ����id�趨
	 *
	 * @param prid ����id
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * �ɹ�ʱ��ȡ��
	 *
	 * @return eitPurchaseDate �ɹ�ʱ��
	 */
	public String getEitPurchaseDate() {
		return eitPurchaseDate;
	}

	/**
	 * �ɹ�ʱ���趨
	 *
	 * @param eitPurchaseDate �ɹ�ʱ��
	 */
	public void setEitPurchaseDate(String eitPurchaseDate) {
		this.eitPurchaseDate = eitPurchaseDate;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getEitid() {
		return eitid;
	}

	/**
	 * �����趨
	 *
	 * @param eitid ����
	 */
	public void setEitid(Integer eitid) {
		this.eitid = eitid;
	}

	/**
	 * ��Ӧ�Ĳɹ����ȡ��
	 *
	 * @return ��Ӧ�Ĳɹ����
	 */
	public String getEitConNum() {
		return eitConNum;
	}

	/**
	 * ��Ӧ�Ĳɹ�����趨
	 *
	 * @param eitConNum ��Ӧ�Ĳɹ����
	 */
	public void setEitConNum(String eitConNum) {
		this.eitConNum = eitConNum;
	}

	/**
	 * �豸����ȡ��
	 *
	 * @return �豸����
	 */
	public String getEitBClass() {
		return eitBClass;
	}

	/**
	 * �豸�����趨
	 *
	 * @param eitBClass �豸����
	 */
	public void setEitBClass(String eitBClass) {
		this.eitBClass = eitBClass;
	}

	/**
	 * �豸С��ȡ��
	 *
	 * @return �豸С��
	 */
	public String getEitSClass() {
		return eitSClass;
	}

	/**
	 * �豸С���趨
	 *
	 * @param eitSClass �豸С��
	 */
	public void setEitSClass(String eitSClass) {
		this.eitSClass = eitSClass;
	}

	/**
	 * �豸Ʒ��ȡ��
	 *
	 * @return �豸Ʒ��
	 */
	public String getEitBrand() {
		return eitBrand;
	}

	/**
	 * �豸Ʒ���趨
	 *
	 * @param eitBrand �豸Ʒ��
	 */
	public void setEitBrand(String eitBrand) {
		this.eitBrand = eitBrand;
	}

	/**
	 * �豸�ͺ�ȡ��
	 *
	 * @return �豸�ͺ�
	 */
	public String getEitModelNum() {
		return eitModelNum;
	}

	/**
	 * �豸�ͺ��趨
	 *
	 * @param eitModelNum �豸�ͺ�
	 */
	public void setEitModelNum(String eitModelNum) {
		this.eitModelNum = eitModelNum;
	}

	/**
	 * �豸��Ȩ����ȡ��
	 *
	 * @return �豸��Ȩ����
	 */
	public String getEitSyscoding() {
		return eitSyscoding;
	}

	/**
	 * �豸��Ȩ�����趨
	 *
	 * @param eitSyscoding �豸��Ȩ����
	 */
	public void setEitSyscoding(String eitSyscoding) {
		this.eitSyscoding = eitSyscoding;
	}

	/**
	 * ԭʼ�۸�ȡ��
	 *
	 * @return ԭʼ�۸�
	 */
	public String getEitPrice() {
		return eitPrice;
	}

	/**
	 * ԭʼ�۸��趨
	 *
	 * @param eitPrice ԭʼ�۸�
	 */
	public void setEitPrice(String eitPrice) {
		this.eitPrice = eitPrice;
	}

	/**
	 * ά������ȡ��
	 *
	 * @return ά������
	 */
	public String getEitFYear() {
		return eitFYear;
	}

	/**
	 * ά�������趨
	 *
	 * @param eitFYear ά������
	 */
	public void setEitFYear(String eitFYear) {
		this.eitFYear = eitFYear;
	}

	/**
	 * �豸����ȡ��
	 *
	 * @return �豸����
	 */
	public Integer getEitNum() {
		return eitNum;
	}

	/**
	 * �豸�����趨
	 *
	 * @param eitNum �豸����
	 */
	public void setEitNum(Integer eitNum) {
		this.eitNum = eitNum;
	}

	/**
	 * ���޿�ʼ����ȡ��
	 *
	 * @return ���޿�ʼ����
	 */
	public String getEitWarFrom() {
		return eitWarFrom;
	}

	/**
	 * ���޿�ʼ�����趨
	 *
	 * @param eitWarFrom ���޿�ʼ����
	 */
	public void setEitWarFrom(String eitWarFrom) {
		this.eitWarFrom = eitWarFrom;
	}

	/**
	 * ���޽�������ȡ��
	 *
	 * @return ���޽�������
	 */
	public String getEitWarTo() {
		return eitWarTo;
	}

	/**
	 * ���޽��������趨
	 *
	 * @param eitWarTo ���޽�������
	 */
	public void setEitWarTo(String eitWarTo) {
		this.eitWarTo = eitWarTo;
	}

	/**
	 * ��עȡ��
	 *
	 * @return ��ע
	 */
	public String getEitDesc() {
		return eitDesc;
	}

	/**
	 * ��ע�趨
	 *
	 * @param eitDesc ��ע
	 */
	public void setEitDesc(String eitDesc) {
		this.eitDesc = eitDesc;
	}

	/**
	 * δ�����豸����ȡ��
	 *
	 * @return δ�����豸����
	 */
	public Integer getEitUncheckNum() {
		return eitUncheckNum;
	}

	/**
	 * δ�����豸�����趨
	 *
	 * @param eitUncheckNum δ�����豸����
	 */
	public void setEitUncheckNum(Integer eitUncheckNum) {
		this.eitUncheckNum = eitUncheckNum;
	}

	/**
	 * �������豸����ȡ��
	 *
	 * @return �������豸����
	 */
	public Integer getEitCheckedNum() {
		return EitCheckedNum;
	}

	/**
	 * �������豸�����趨
	 *
	 * @param EitCheckedNum �������豸����
	 */
	public void setEitCheckedNum(Integer EitCheckedNum) {
		this.EitCheckedNum = EitCheckedNum;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return eitid;
	}

}