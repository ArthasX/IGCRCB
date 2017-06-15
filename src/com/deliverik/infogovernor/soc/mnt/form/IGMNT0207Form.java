/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.soc.mnt.form;

import com.deliverik.framework.base.BaseForm;
import com.deliverik.infogovernor.soc.mnt.model.condition.SOC0306SearchCond;

/**
 * ����: �洢ά������FORM
 * ��������: �洢ά������FORM
 * ������¼: 2011/11/18
 * �޸ļ�¼: 
 */
public class IGMNT0207Form extends BaseForm implements SOC0306SearchCond{
	private static final long serialVersionUID = 1L;
	

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

	/**
	 *����ʱ���
	 */
	protected String dataitmes_f;
	
	/**
	 *����ʱ�䵽
	 */
	protected String dataitmes_t;

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
