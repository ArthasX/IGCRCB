/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.smr.model.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import com.deliverik.infogovernor.smr.model.AnnualReportVWInfo;

/**
 * ����:�걨��ͼ
 * �����������걨��ͼ
 * �����ˣ�����͢
 * ������¼�� 2013-07-29
 * �޸ļ�¼��
 */
@Entity
public class AnnualReportVW implements AnnualReportVWInfo{
	
	@Id
	protected Integer prid;

	protected Integer instanceID;

	/** ������ */
	protected String prtype;

	/** ���ʶ */
	protected String key;

	/** �����ʱ�� */
	protected String inittime;

	/** �����ʱ�� */
	protected String endtime;

	/** �����ʱ�� */
	protected String limittime;

	/** ��ע */
	protected String remark;

	/** ״̬��0������1�رգ�2��ֹ */
	protected String status;
	
	/** ������ID */
	protected String userid;
	
	/** ���������� */
	protected String username;
	
	/** �걨˵�� */
	protected String reportdesc;
	
	/** ������ */
	protected String prtitle;
	
	/** ����״̬�� */
	protected String psdname;
	
	/** ��ǰ״̬ */
	protected String prstatus;
	
	/** �Ƿ��Ϳձ��ʶ */
	protected String flag;
	
	/** �ϱ�������� */
	protected String year;
	
	/** �ϱ������� */
	protected String quarter;
	
		
	public Integer getPrid() {
		return prid;
	}

	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	/**
	 * ����IDȡ��
	 *
	 * @return ����ID
	 */
	public Integer getInstanceID() {
		return instanceID;
	}

	/**
	 * ����ID�趨
	 *
	 * @param instanceID ����ID
	 */
	public void setInstanceID(Integer instanceID) {
		this.instanceID = instanceID;
	}

	/**
	 * ������ȡ��
	 *
	 * @return ������
	 */
	public String getPrtype() {
		return prtype;
	}

	/**
	 * �������趨
	 *
	 * @param prtype ������
	 */
	public void setPrtype(String prtype) {
		this.prtype = prtype;
	}

	/**
	 * ���ʶȡ��
	 *
	 * @return ���ʶ
	 */
	public String getKey() {
		return key;
	}

	/**
	 * ���ʶ�趨
	 *
	 * @param key ���ʶ
	 */
	public void setKey(String key) {
		this.key = key;
	}

	/**
	 * �����ʱ��ȡ��
	 *
	 * @return �����ʱ��
	 */
	public String getInittime() {
		return inittime;
	}

	/**
	 * �����ʱ���趨
	 *
	 * @param inittime �����ʱ��
	 */
	public void setInittime(String inittime) {
		this.inittime = inittime;
	}

	/**
	 * �����ʱ��ȡ��
	 *
	 * @return �����ʱ��
	 */
	public String getEndtime() {
		return endtime;
	}

	/**
	 * �����ʱ���趨
	 *
	 * @param endtime �����ʱ��
	 */
	public void setEndtime(String endtime) {
		this.endtime = endtime;
	}

	/**
	 * �����ʱ��ȡ��
	 *
	 * @return �����ʱ��
	 */
	public String getLimittime() {
		return limittime;
	}

	/**
	 * �����ʱ���趨
	 *
	 * @param limittime �����ʱ��
	 */
	public void setLimittime(String limittime) {
		this.limittime = limittime;
	}

	/**
	 * ��עȡ��
	 *
	 * @return ��ע
	 */
	public String getRemark() {
		return remark;
	}

	/**
	 * ��ע�趨
	 *
	 * @param remark ��ע
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}

	/**
	 * ״̬ȡ��
	 *
	 * @return ״̬
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * ״̬�趨
	 *
	 * @param status ״̬
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	
	/**
	 * ������ID
	 * 
	 * @return ������ID
	 */
	public String getUserid() {
		return userid;
	}

	/**
	 * ������ID
	 * @param userid ������ID
	 */
	public void setUserid(String userid) {
		this.userid = userid;
	}

	/**
	 * ����������
	 * @return ����������
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * ����������
	 * @param username ����������
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	
	/**
	 * �걨˵��
	 * @return �걨˵��
	 */
	public String getReportdesc() {
		return reportdesc;
	}
	/**
	 * �걨˵��
	 * @param reportdesc �걨˵��
	 */
	public void setReportdesc(String reportdesc) {
		this.reportdesc = reportdesc;
	}
	
	/**
	 * ������
	 * @return ������
	 */
	public String getPrtitle() {
		return prtitle;
	}
	
	/**
	 * ������
	 * @param prtitle ������
	 */
	public void setPrtitle(String prtitle) {
		this.prtitle = prtitle;
	}

	/**
	 * ����״̬��ȡ��
	 *
	 * @return psdname ����״̬��
	 */
	public String getPsdname() {
		return psdname;
	}

	/**
	 * ����״̬���趨
	 *
	 * @param psdname ����״̬��
	 */
	public void setPsdname(String psdname) {
		this.psdname = psdname;
	}

	/**
	 * ��ǰ״̬ȡ��
	 *
	 * @return prstatus ��ǰ״̬
	 */
	public String getPrstatus() {
		return prstatus;
	}

	/**
	 * ��ǰ״̬�趨
	 *
	 * @param prstatus ��ǰ״̬
	 */
	public void setPrstatus(String prstatus) {
		this.prstatus = prstatus;
	}

	/**
	 * �Ƿ��Ϳձ��ʶȡ��
	 *
	 * @return flag �Ƿ��Ϳձ��ʶ
	 */
	public String getFlag() {
		return flag;
	}

	/**
	 * �Ƿ��Ϳձ��ʶ�趨
	 *
	 * @param flag �Ƿ��Ϳձ��ʶ
	 */
	public void setFlag(String flag) {
		this.flag = flag;
	}

	/**
	 * �ϱ��������ȡ��
	 *
	 * @return year �ϱ��������
	 */
	public String getYear() {
		return year;
	}

	/**
	 * �ϱ���������趨
	 *
	 * @param year �ϱ��������
	 */
	public void setYear(String year) {
		this.year = year;
	}

	/**
	 * �ϱ�������ȡ��
	 *
	 * @return quarter �ϱ�������
	 */
	public String getQuarter() {
		return quarter;
	}

	/**
	 * �ϱ��������趨
	 *
	 * @param quarter �ϱ�������
	 */
	public void setQuarter(String quarter) {
		this.quarter = quarter;
	}

}
