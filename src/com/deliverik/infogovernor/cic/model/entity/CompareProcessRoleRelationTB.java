/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.cic.model.CompareProcessRoleRelationInfo;

/**
  * ����: ��ϵ��ʵ��
  * ��������: ��ϵ��ʵ��
  * ������¼: 2014/04/24
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="compareprocessrolerelation")
public class CompareProcessRoleRelationTB extends BaseEntity implements Serializable,
		Cloneable, CompareProcessRoleRelationInfo {

	/** ���� */
	@Id
	@GeneratedValue(generator = "id")
    @GenericGenerator(name = "id", strategy = "sequence", 
            parameters = { @Parameter(name = "sequence", 
                        value = "compareprocessrolerelation_seq") })
	protected Integer id;

	/** �ȶ���������� */
	protected Integer cpid;

	/** �Աȹ�������� */
	protected Integer crid;

	/** �ȶԹ����汾 */
	protected Integer crversion;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * �����趨
	 *
	 * @param id ����
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * �ȶ����������ȡ��
	 *
	 * @return �ȶ����������
	 */
	public Integer getCpid() {
		return cpid;
	}

	/**
	 * �ȶ�����������趨
	 *
	 * @param cpid �ȶ����������
	 */
	public void setCpid(Integer cpid) {
		this.cpid = cpid;
	}

	/**
	 * �Աȹ��������ȡ��
	 *
	 * @return �Աȹ��������
	 */
	public Integer getCrid() {
		return crid;
	}

	/**
	 * �Աȹ���������趨
	 *
	 * @param crid �Աȹ��������
	 */
	public void setCrid(Integer crid) {
		this.crid = crid;
	}

	/**
	 * �ȶԹ����汾ȡ��
	 *
	 * @return �ȶԹ����汾
	 */
	public Integer getCrversion() {
		return crversion;
	}

	/**
	 * �ȶԹ����汾�趨
	 *
	 * @param crversion �ȶԹ����汾
	 */
	public void setCrversion(Integer crversion) {
		this.crversion = crversion;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return id;
	}

}