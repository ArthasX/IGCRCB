/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.dut.model.condition;

/**
 * ֵ�������ݲ�ѯ�����ӿ�ʵ��
 */
public class DutyResultSearchCondImpl implements DutyResultSearchCond{
	
	/** ֵ��ƻ�ID */
	protected Integer dpid;
	
	/** ֵ������ID */
	protected Integer dadid;
	
	protected String dattime;
	
	public String getDattime() {
		return dattime;
	}

	public void setDattime(String dattime) {
		this.dattime = dattime;
	}

	/**
	 * ֵ��ƻ�IDȡ��
	 * @return ֵ��ƻ�ID
	 */
	public Integer getDpid() {
		return dpid;
	}

	/**
	 * ֵ��ƻ�ID�趨
	 *
	 * @param dpid ֵ��ƻ�ID
	 */
	public void setDpid(Integer dpid) {
		this.dpid = dpid;
	}
	
	/**
	 * ֵ������
	 */
	public String dptime;
	
	/**
	 * ֵ�࿪ʼ����
	 */
	public String dptime_ge;
	
	/**
	 * ֵ���������
	 */
	public String dptime_le;
	
	/**
	 * ���������ƥ�䣩
	 */
	public String isNullDrcontent;
	
	public String dadcategory;

	/**
	 * ֵ������ȡ��
	 * @return ֵ������
	 */
	public String getDptime() {
		return dptime;
	}
	
	/**
	 * �������
	 */
	public String dadname;

	/**
	 * �������ȡ��
	 * @return
	 */
	public String getDadname(){
		return dadname;
	}
	/**
	 * ��ʼʱ��
	 */
	public String dopentime;
	
	/**
	 * ����ʱ��
	 */
	public String dclosetime;
	
	/**
	 * ��ʼʱ��ȡ��
	 * @return ��ʼʱ��
	 */
	public String getDopentime(){
		return dopentime;
	}
	
	/**
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getDclosetime(){
		return dclosetime;
	}

	public String getDptime_ge() {
		return dptime_ge;
	}

	public void setDptime_ge(String dptime_ge) {
		this.dptime_ge = dptime_ge;
	}

	public String getDptime_le() {
		return dptime_le;
	}

	public void setDptime_le(String dptime_le) {
		this.dptime_le = dptime_le;
	}

	public String getDadcategory() {
		return dadcategory;
	}

	public void setDadcategory(String dadcategory) {
		this.dadcategory = dadcategory;
	}

	/**
	 * ���������ƥ�䣩ȡ��
	 * @return ���������ƥ�䣩
	 */
	public String getIsNullDrcontent() {
		return isNullDrcontent;
	}
	
	/**
	 * ���������ƥ�䣩ȡ��
	 * @return ���������ƥ�䣩
	 */
	public void setIsNullDrcontent(String isNullDrcontent) {
		this.isNullDrcontent = isNullDrcontent;
	}
	
	/**
	 * ֵ������IDȡ��
	 * @return ֵ������ID
	 */
	public Integer getDadid() {
		return dadid;
	}

	/**
	 * ֵ������IDȡ��
	 * @return ֵ������ID
	 */
	public void setDadid(Integer dadid) {
		this.dadid = dadid;
	}
	
}
