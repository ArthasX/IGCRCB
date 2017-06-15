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
import com.deliverik.infogovernor.dwp.model.IGDWP0004Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ճ������ƻ���������Ϣʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name="IGDWP0004")
public class IGDWP0004TB extends BaseEntity implements IGDWP0004Info{

	/** ���� */
	@Id
	@TableGenerator(
		    name="IGDWP0004_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IGDWP0004_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IGDWP0004_TABLE_GENERATOR")
	protected Integer id;
	
	/** �ƻ�ID */
	protected Integer planid;
	
	/** ������ϢID */
	protected Integer prid;
	
	/** ״̬ID */
	protected String psdid;
	
	/** �û�ID */
	protected String userid;
	
	/** �����ɫID */
	protected Integer roleid;
	
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
	 * �ƻ�IDȡ��
	 * @return planid �ƻ�ID
	 */
	public Integer getPlanid() {
		return planid;
	}

	/**
	 * �ƻ�ID�趨
	 * @param planid �ƻ�ID
	 */
	public void setPlanid(Integer planid) {
		this.planid = planid;
	}

	/**
	 * ������ϢIDȡ��
	 * @return prid ������ϢID
	 */
	public Integer getPrid() {
		return prid;
	}

	/**
	 * ������ϢID�趨
	 * @param prid ������ϢID
	 */
	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ״̬IDȡ��
	 * @return psdid ״̬ID
	 */
	public String getPsdid() {
		return psdid;
	}

	/**
	 * ״̬ID�趨
	 * @param psdid ״̬ID
	 */
	public void setPsdid(String psdid) {
		this.psdid = psdid;
	}

	/**
	 * �û�IDȡ��
	 * @return usersid �û�ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * �û�ID�趨
	 * @param usersid �û�ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * �����ɫIDȡ��
	 * @return roleid �����ɫID
	 */
	public Integer getRoleid() {
		return roleid;
	}

	/**
	 * �����ɫID�趨
	 * @param roleid �����ɫID
	 */
	public void setRoleid(Integer roleid) {
		this.roleid = roleid;
	}

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public Serializable getPK() {
		return this.id;
	}

}
