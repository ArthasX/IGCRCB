/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

 package com.deliverik.infogovernor.soc.mnt.model.condition;


/**
 * 
 * @Description:�������ݱ�����ͼCond��
 * @Author
 * @History
 * @Version V1.0
 */
public class SOC0306SearchCondImpl implements
		SOC0306SearchCond {
	/**
	 *symmid
	 */
	protected String symmid;

	/**
	 *symmidȡ��
	 * 
	 * @return symmid
	 */
	public String getSymmid() {
		return symmid;
	}

	/**
	 *symmid�趨
	 * 
	 * @param symmidsymmid
	 */
	public void setSymmid(String symmid) {
		this.symmid = symmid;
	}

	/**
	 *����ʱ��
	 */
	protected String dataitmes;
	
	/**
	 *����ʱ���
	 */
	protected String dataitmes_f;
	
	/**
	 *����ʱ�䵽
	 */
	protected String dataitmes_t;

	/**
	 *����ʱ��ȡ��
	 * 
	 * @return ����ʱ��
	 */
	public String getDataitmes() {
		return dataitmes;
	}

	/**
	 *����ʱ���趨
	 * 
	 * @param dataitmes����ʱ��
	 */
	public void setDataitmes(String dataitmes) {
		this.dataitmes = dataitmes;
	}

	/**
	 *����
	 */
	protected String symtype;

	/**
	 *����ȡ��
	 * 
	 * @return ����
	 */
	public String getSymtype() {
		return symtype;
	}

	/**
	 *�����趨
	 * 
	 * @param symtype����
	 */
	public void setSymtype(String symtype) {
		this.symtype = symtype;
	}

	/**
	 *�Ƿ����Ķ�
	 */
	protected String readdate;

	/**
	 *�Ƿ����Ķ�ȡ��
	 * 
	 * @return �Ƿ����Ķ�
	 */
	public String getReaddate() {
		return readdate;
	}

	/**
	 *�Ƿ����Ķ��趨
	 * 
	 * @param readdate�Ƿ����Ķ�
	 */
	public void setReaddate(String readdate) {
		this.readdate = readdate;
	}

	public String getDataitmes_f() {
		return dataitmes_f;
	}

	public void setDataitmes_f(String dataitmes_f) {
		this.dataitmes_f = dataitmes_f;
	}

	public String getDataitmes_t() {
		return dataitmes_t;
	}

	public void setDataitmes_t(String dataitmes_t) {
		this.dataitmes_t = dataitmes_t;
	}
	
}

