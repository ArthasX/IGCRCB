package com.deliverik.infogovernor.crc.model.condition;

/**
 * ����: �¼�ƽ�����ʱ���������ʵ��
 *       �޸ļ�¼ 2014-12-25 ����sign��ʶ
 *       zhangq@deliverik.com
 */
public class IGCRC2401CondImpl implements IGCRC2401Cond{

	/** ��� */
	protected String year;
	/** �·� */
	protected String month;
	/** ���� */
	protected String dept;
	
	/** 1.�¼�   2.�澯*/
	protected String sign;
	
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	

	
	
}
