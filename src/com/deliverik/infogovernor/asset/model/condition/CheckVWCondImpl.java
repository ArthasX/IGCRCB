/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.asset.model.condition;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���ռ��ͳ�ƣ�������ѯ��������ʵ��
 * </p>
 * 
 * @author shenbing@deliverik.com
 * @version 1.0
 */
public class CheckVWCondImpl implements CheckVWCond {
	
	/** syscoding */
	protected String syscoding;

	/** ��鷽�� */
	protected String checkMethod;
	
	/**������Ƶ��*/
	protected String checkfrequency;

	/**
	 * ��鷽��ȡ��
	 * @return checkMethod ��鷽��
	 */
	public String getCheckMethod() {
		return checkMethod;
	}

	/**
	 * ��鷽���趨
	 * @param checkMethod ��鷽��
	 */
	public void setCheckMethod(String checkMethod) {
		this.checkMethod = checkMethod;
	}

	/**
	 * ������Ƶ��ȡ��
	 * @return checkfrequency ������Ƶ��
	 */
	public String getCheckfrequency() {
		return checkfrequency;
	}

	/**
	 * ������Ƶ���趨
	 * @param checkfrequency ������Ƶ��
	 */
	public void setCheckfrequency(String checkfrequency) {
		this.checkfrequency = checkfrequency;
	}

	/**
	 * syscodingȡ��
	 * @return syscoding syscoding
	 */
	public String getSyscoding() {
		return syscoding;
	}

	/**
	 * syscoding�趨
	 * @param syscoding syscoding
	 */
	public void setSyscoding(String syscoding) {
		this.syscoding = syscoding;
	}

}
