/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.iam.model.condition;

/**
  * ����: ������Ŀ��������ʵ��
  * ��������: ������Ŀ��������ʵ��
  * ������¼: 2012/07/19
  * �޸ļ�¼: 
  */
public class InternalauditprjSearchCondImpl implements
		InternalauditprjSearchCond {
	
	/** ��� */
	private String iapYear_eq;
	
	/** ������Ŀ���� */
	private String iapName_like;
	
	/** ״̬ */
	private String iapStatus_eq;
	
	/** ��ƿ�ʼ���ڴ� */
	private String iapOpenTimeFrom_ge;
	
	/** ��ƿ�ʼ���ڵ� */
	private String iapOpenTimeTo_le;
	
	/** ������� */
	private String iapType_eq;

	/**
	 * iapYear_eqȡ��
	 *
	 * @return iapYear_eq iapYear_eq
	 */
	public String getIapYear_eq() {
		return iapYear_eq;
	}

	/**
	 * iapYear_eq�趨
	 *
	 * @param iapYear_eq iapYear_eq
	 */
	public void setIapYear_eq(String iapYear_eq) {
		this.iapYear_eq = iapYear_eq;
	}

	/**
	 * iapName_likeȡ��
	 *
	 * @return iapName_like iapName_like
	 */
	public String getIapName_like() {
		return iapName_like;
	}

	/**
	 * iapName_like�趨
	 *
	 * @param iapName_like iapName_like
	 */
	public void setIapName_like(String iapName_like) {
		this.iapName_like = iapName_like;
	}

	/**
	 * iapStatus_eqȡ��
	 *
	 * @return iapStatus_eq iapStatus_eq
	 */
	public String getIapStatus_eq() {
		return iapStatus_eq;
	}

	/**
	 * iapStatus_eq�趨
	 *
	 * @param iapStatus_eq iapStatus_eq
	 */
	public void setIapStatus_eq(String iapStatus_eq) {
		this.iapStatus_eq = iapStatus_eq;
	}

	/**
	 * iapOpenTimeFrom_geȡ��
	 *
	 * @return iapOpenTimeFrom_ge iapOpenTimeFrom_ge
	 */
	public String getIapOpenTimeFrom_ge() {
		return iapOpenTimeFrom_ge;
	}

	/**
	 * iapOpenTimeFrom_ge�趨
	 *
	 * @param iapOpenTimeFrom_ge iapOpenTimeFrom_ge
	 */
	public void setIapOpenTimeFrom_ge(String iapOpenTimeFrom_ge) {
		this.iapOpenTimeFrom_ge = iapOpenTimeFrom_ge;
	}

	/**
	 * iapOpenTimeTo_leȡ��
	 *
	 * @return iapOpenTimeTo_le iapOpenTimeTo_le
	 */
	public String getIapOpenTimeTo_le() {
		return iapOpenTimeTo_le;
	}

	/**
	 * iapOpenTimeTo_le�趨
	 *
	 * @param iapOpenTimeTo_le iapOpenTimeTo_le
	 */
	public void setIapOpenTimeTo_le(String iapOpenTimeTo_le) {
		this.iapOpenTimeTo_le = iapOpenTimeTo_le;
	}

	/**
	 * iapType_eqȡ��
	 *
	 * @return iapType_eq iapType_eq
	 */
	public String getIapType_eq() {
		return iapType_eq;
	}

	/**
	 * iapType_eq�趨
	 *
	 * @param iapType_eq iapType_eq
	 */
	public void setIapType_eq(String iapType_eq) {
		this.iapType_eq = iapType_eq;
	}

	
}