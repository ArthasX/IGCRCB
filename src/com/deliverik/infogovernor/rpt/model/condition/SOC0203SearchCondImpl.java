/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

 package com.deliverik.infogovernor.rpt.model.condition;


/**
 * 
 * @Description:�Զ����������б�Cond��
 * @Author
 * @History
 * @Version V1.0
 * �޸ļ�¼��2012/08/09 ��ReportConfigurationSearchCondImpl������ΪSOC0203SearchCondImpl
 */
public class SOC0203SearchCondImpl implements SOC0203SearchCond{
	/**
	 *�����ļ�������
	 */
	protected String r_path;

	/**
	 *�����ļ�������ȡ��
	 * 
	 * @return �����ļ�������
	 */
	public String getR_path() {
		return r_path;
	}

	/**
	 *�����ļ��������趨
	 * 
	 * @param r_path�����ļ�������
	 */
	public void setR_path(String r_path) {
		this.r_path = r_path;
	}

	/**
	 *�����ļ������ĺ���
	 */
	protected String r_title;

	/**
	 *�����ļ������ĺ���ȡ��
	 * 
	 * @return �����ļ������ĺ���
	 */
	public String getR_title() {
		return r_title;
	}

	/**
	 *�����ļ������ĺ����趨
	 * 
	 * @param r_title�����ļ������ĺ���
	 */
	public void setR_title(String r_title) {
		this.r_title = r_title;
	}

	/**
	 *��������ʱ���õĲ���
	 */
	protected String para;

	/**
	 *��������ʱ���õĲ���ȡ��
	 * 
	 * @return ��������ʱ���õĲ���
	 */
	public String getPara() {
		return para;
	}

	/**
	 *��������ʱ���õĲ����趨
	 * 
	 * @param para��������ʱ���õĲ���
	 */
	public void setPara(String para) {
		this.para = para;
	}
	
	/** ����ID */
	protected String dataid;

	/**
	 * ����ID
	 * @return ����ID
	 */
	public String getDataid() {
		return dataid;
	}

	/**
	 * ����ID
	 * @param dataid����ID
	 */
	public void setDataid(String dataid) {
		this.dataid = dataid;
	}
	
	

}

