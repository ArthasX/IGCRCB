/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.ven.model.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.TableGenerator;
import javax.persistence.Transient;

import com.deliverik.framework.base.BaseEntity;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.infogovernor.asset.bl.task.RiskIndexSearchVWBL;
import com.deliverik.infogovernor.asset.model.RiskIndexSearchVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RiskIndexSearchVWSearchCondImpl;
import com.deliverik.infogovernor.asset.model.entity.RiskIndexSearchVW;
import com.deliverik.infogovernor.ven.model.MonitoringWorkInfo;

/**
  * ����: ��⹤�����ʵ��
  * ��������: ��⹤�����ʵ��
  * ������¼: 2014/12/01
  * �޸ļ�¼: 
  */
@SuppressWarnings("serial")
@Entity
@Table(name="MonitoringWork")
public class MonitoringWorkTB extends BaseEntity implements Serializable,
		Cloneable, MonitoringWorkInfo {

	/** ���� */
	@Id
	@TableGenerator(
		name="MONITORINGWORK_TABLE_GENERATOR", table="SEQUENCE_GENERATOR_TABLE",
		pkColumnName="SEQUENCE_NAME", valueColumnName="SEQUENCE_VALUE",
		pkColumnValue="MONITORINGWORK_SEQUENCE", initialValue=1, allocationSize=1
	)
	@GeneratedValue(strategy = GenerationType.TABLE, generator="MONITORINGWORK_TABLE_GENERATOR")
	protected Integer mwid;

	/** ���ռ������id */
	protected Integer rmid;

	/** ����ָ��id */
	protected Integer riid;

	/** ����ָ����Ϣ  */	
	@Transient
	protected RiskIndexSearchVWInfo riskIndexSearchVWInfo;
	
	/** ����� */
	protected String result;

	/** ���˵�� */
	protected String resultdesc;

	/** ���� */
	protected String mwattachkey;
	
	/** ָ�ɹ�������id*/
	protected Integer assignprid;

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Integer getMwid() {
		return mwid;
	}

	/**
	 * �����趨
	 *
	 * @param mwid ����
	 */
	public void setMwid(Integer mwid) {
		this.mwid = mwid;
	}

	/**
	 * ���ռ������idȡ��
	 *
	 * @return ���ռ������id
	 */
	public Integer getRmid() {
		return rmid;
	}

	/**
	 * ���ռ������id�趨
	 *
	 * @param rmid ���ռ������id
	 */
	public void setRmid(Integer rmid) {
		this.rmid = rmid;
	}

	/**
	 * ����ָ��idȡ��
	 *
	 * @return ����ָ��id
	 */
	public Integer getRiid() {
		return riid;
	}

	/**
	 * ����ָ��id�趨
	 *
	 * @param riid ����ָ��id
	 */
	public void setRiid(Integer riid) {
		this.riid = riid;
	}

	/**
	 * �����ȡ��
	 *
	 * @return �����
	 */
	public String getResult() {
		return result;
	}

	/**
	 * ������趨
	 *
	 * @param result �����
	 */
	public void setResult(String result) {
		this.result = result;
	}

	/**
	 * ���˵��ȡ��
	 *
	 * @return ���˵��
	 */
	public String getResultdesc() {
		return resultdesc;
	}

	/**
	 * ���˵���趨
	 *
	 * @param resultdesc ���˵��
	 */
	public void setResultdesc(String resultdesc) {
		this.resultdesc = resultdesc;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public String getMwattachkey() {
		return mwattachkey;
	}

	/**
	 * �����趨
	 *
	 * @param mwattachkey ����
	 */
	public void setMwattachkey(String mwattachkey) {
		this.mwattachkey = mwattachkey;
	}

	/**
	 * ����ȡ��
	 *
	 * @return ����
	 */
	public Serializable getPK() {
		return mwid;
	}


	/**
	 * ����ָ����Ϣȡ��
	 * @return riskIndexSearchVWInfo  ����ָ����Ϣ
	 */
	public RiskIndexSearchVWInfo getRiskIndexSearchVWInfo() {
		if(null == riskIndexSearchVWInfo){
			RiskIndexSearchVWBL bl = (RiskIndexSearchVWBL) WebApplicationSupport.getBean("riskIndexSearchVWBL");
			RiskIndexSearchVWSearchCondImpl cond = new RiskIndexSearchVWSearchCondImpl();
			cond.setSyscoding("");
			cond.setEiid(this.riid.toString());
			List<RiskIndexSearchVWInfo> list = bl.searchRiskIndexSearchVW(cond);
			if(list != null && list.size() > 0){
				riskIndexSearchVWInfo = list.get(0);
			}else{
				riskIndexSearchVWInfo = new RiskIndexSearchVW();
			}
		}
		return riskIndexSearchVWInfo;
	}

	
	/**
	 * ָ�ɹ�������idȡ��
	 * @return the assignprid
	 */
	public Integer getAssignprid() {
		return assignprid;
	}

	/**
	 * ָ�ɹ�������id�趨
	 * @param assignprid the ָ�ɹ�������id
	 */
	public void setAssignprid(Integer assignprid) {
		this.assignprid = assignprid;
	}

	/**
	 * ����ָ����Ϣ�趨
	 * @param riskIndexSearchVWInfo  ����ָ����Ϣ
	 */
	public void setRiskIndexSearchVWInfo(RiskIndexSearchVWInfo riskIndexSearchVWInfo) {
		this.riskIndexSearchVWInfo = riskIndexSearchVWInfo;
	}

}