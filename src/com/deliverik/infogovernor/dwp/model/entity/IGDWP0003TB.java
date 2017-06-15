/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dwp.model.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.infogovernor.dwp.model.IGDWP0003Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ճ������ƻ�����Ϣʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name="IGDWP0003")
public class IGDWP0003TB extends BaseEntity implements IGDWP0003Info{
	
	/** ���� */
	@Id
	@TableGenerator(
		    name="IGDWP0003_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IGDWP0003_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IGDWP0003_TABLE_GENERATOR")
	protected Integer id;
	
	/** ������Ϣ���� */
	protected Integer prid;
	
	/** ������ID */
	protected String pidid;
	
	/** ��ֵ */
	protected String pivarvalue;
	
	/** ����key */
	protected String attkey;

	/**
	 * ����ȡ��
	 * @return id ����
	 */
	public Integer getId() {
		return id;
	}

	/**
	 * �����趨
	 * @param id ����
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * ������Ϣ����ȡ��
	 * @return prid ������Ϣ����
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ������Ϣ�����趨
	 * @param prid ������Ϣ����
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ������IDȡ��
	 * @return pidid ������ID
	 */
	public String getPidid() {
		return pidid;
	}

	/**
	 * ������ID�趨
	 * @param pidid ������ID
	 */
	public void setPidid(String pidid) {
		this.pidid = pidid;
	}

	/**
	 * ��ֵȡ��
	 * @return pivarvalue ��ֵ
	 */
	public String getPivarvalue() {
		return pivarvalue;
	}

	/**
	 * ��ֵ�趨
	 * @param pivarvalue ��ֵ
	 */
	public void setPivarvalue(String pivarvalue) {
		this.pivarvalue = pivarvalue;
	}

	/**
	 * ����keyȡ��
	 * @return attkey ����key
	 */
	public String getAttkey() {
		return attkey;
	}

	/**
	 * ����key�趨
	 * @param attkey ����key
	 */
	public void setAttkey(String attkey) {
		this.attkey = attkey;
	}

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public Serializable getPK() {
		return this.id;
	}
}
