/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.sym.model.condition;

/**
 * ����:���ȼ���ѯʵ����
 * ����������1.Ӱ���ֵȡ��
 * 			2.���ȼ�ֵȡ��
 * 			3.������ֵȡ��
 * 			4.��������ȡ��
 * ������¼��fangyunlong@deliverik.com    2010/12/14
 */

public class PrioritySearchCondImpl implements PrioritySearchCond {

	/**Ӱ���ֵ*/
	protected String ivalue;
	/**��������*/
	protected String pprtype;
	/**���ȼ�ֵ*/
	protected String pvalue;
	/**������ֵ*/
	protected String uvalue;

	/**
	 *Ӱ���ֵȡ��
	 * 
	 * @return Ӱ���ֵ
	 */
	public String getIvalue() {
		return ivalue;
	}
	/**
	 *Ӱ���ֵ�趨
	 * 
	 * @param Ӱ���ֵ
	 */
	public void setIvalue(String ivalue) {
		this.ivalue = ivalue;
	}
	/**
	 *���ȼ�ֵȡ��
	 * 
	 * @return ���ȼ�ֵ
	 */
	public String getPvalue() {
		return pvalue;
	}
	/**
	 *���ȼ�ֵ�趨
	 * 
	 * @param ���ȼ�ֵ
	 */
	public void setPvalue(String pvalue) {
		this.pvalue = pvalue;
	}
	/**
	 *������ֵȡ��
	 * 
	 * @return ������ֵ
	 */
	public String getUvalue() {
		return uvalue;
	}
	/**
	 *������ֵ�趨
	 * 
	 * @param ������ֵ
	 */
	public void setUvalue(String uvalue) {
		this.uvalue = uvalue;
	}
	/**
	 *��������ȡ��
	 * 
	 * @return ��������
	 */
	public String getPprtype() {
		return pprtype;
	}
	/**
	 *���������趨
	 * 
	 * @param ��������
	 */
	public void setPprtype(String pprtype) {
		this.pprtype = pprtype;
	}

}
