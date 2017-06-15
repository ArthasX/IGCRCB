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
import com.deliverik.infogovernor.dwp.model.IGDWP0002Info;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �ճ������ƻ�������Ϣ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("serial")
@Entity
@Table(name="IGDWP0002")
public class IGDWP0002TB extends BaseEntity implements IGDWP0002Info{
	
	/** ���� */
	@Id
	@TableGenerator(
		    name="IGDWP0002_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE", 
		    pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE", 
		    pkColumnValue="IGDWP0002_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="IGDWP0002_TABLE_GENERATOR")
	protected Integer id;
	
	/** �ƻ����� */
	protected Integer planid;
	
	/** ���̱��� */
	protected String prtitle;
	
	/** �������� */
	protected String prdesc;
	
	/** ��ϵ��ʽ */
	protected String prinfo;
	
	/** �����˽�ɫID */
	protected Integer prroleid;

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
	 * �ƻ�����ȡ��
	 * @return planid �ƻ�����
	 */
	public Integer getPlanid() {
		return planid;
	}

	/**
	 * �ƻ������趨
	 * @param planid �ƻ�����
	 */
	public void setPlanid(Integer planid) {
		this.planid = planid;
	}

	/**
	 * ���̱���ȡ��
	 * @return prtitle ���̱���
	 */
	public String getPrtitle() {
		return prtitle;
	}

	/**
	 * ���̱����趨
	 * @param prtitle ���̱���
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * ��������ȡ��
	 * @return prdesc ��������
	 */
	public String getPrdesc() {
		return prdesc;
	}

	/**
	 * ���������趨
	 * @param prdesc ��������
	 */
	public void setPrdesc(String prdesc) {
		this.prdesc = prdesc;
	}

	/**
	 * ��ϵ��ʽȡ��
	 * @return prinfo ��ϵ��ʽ
	 */
	public String getPrinfo() {
		return prinfo;
	}

	/**
	 * ��ϵ��ʽ�趨
	 * @param prinfo ��ϵ��ʽ
	 */
	public void setPrinfo(String prinfo) {
		this.prinfo = prinfo;
	}

	/**
	 * �����˽�ɫIDȡ��
	 * @return prroleid �����˽�ɫID
	 */
	public Integer getPrroleid() {
		return prroleid;
	}

	/**
	 * �����˽�ɫID�趨
	 * @param prroleid �����˽�ɫID
	 */
	public void setPrroleid(Integer prroleid) {
		this.prroleid = prroleid;
	}

	/**
	 * ����ȡ��
	 * @return ����
	 */
	public Serializable getPK() {
		return this.id;
	}

}
