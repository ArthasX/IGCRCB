/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.condition;

/**
  * ����: ���չ�ϵ���������ʵ��
  * ��������: ���չ�ϵ���������ʵ��
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public class SnapshotRelationSearchCondImpl implements
		SnapshotRelationSearchCond {
	
	/** ��ID */
	protected String srdomainid_eq;
	
	/** ��汾 */
	protected String srdomainversion_eq;
	
	/** �߼�ɾ����ʶ */
	protected String deleteflag_eq;
	
	/**Դ�ʲ�ID*/
	protected String srpareiid_eq;
	
	/**Դ�ʲ���汾*/
	protected String srparversion_eq;
	
	/**Դ�ʲ�С�汾*/
	protected String srparsmallversion_eq;
	
	/**����ʱ��*/
	protected String srcreatetime_eq;
	
	/** ��ϵ��ת��ַ*/
	private String forword;
	
	/**��ϵ����*/
	protected String srassetrelation_eq;
	
	/** ��չ�㷨����*/
	protected String srarithmetictype_eq;
	
	/** Ŀ���ʲ�ID */
	protected String srcldeiid_eq;

	/** Ŀ���ʲ���汾 */
	protected String srcldversion_eq;

	/** Ŀ���ʲ�С�汾 */
	protected String srcldsmallversion_eq;
	
	/**�洢EIname*/
	private String srcStorageEiname;
	/**
	 * ��ϵ��ת��ַȡ��
	 * @return ��ϵ��ת��ַ
	 */
	public String getForword() {
		return forword;
	}

	/**
	 * ��ϵ��ת��ַ�趨
	 * @param forword��ϵ��ת��ַ
	 */
	public void setForword(String forword) {
		this.forword = forword;
	}
	
	/**
	 * Դ�ʲ�IDȡ��
	 * @return Դ�ʲ�ID
	 */
	public String getSrpareiid_eq() {
		return srpareiid_eq;
	}

	/**
	 * Դ�ʲ�ID�趨
	 * @param srpareiidԴ�ʲ�ID
	 */
	public void setSrpareiid_eq(String srpareiid_eq) {
		this.srpareiid_eq = srpareiid_eq;
	}

	/**
	 * Դ�ʲ���汾ȡ��
	 * @return Դ�ʲ���汾
	 */
	public String getSrparversion_eq() {
		return srparversion_eq;
	}

	/**
	 * Դ�ʲ���汾�趨
	 * @param srparversionԴ�ʲ���汾
	 */
	public void setSrparversion_eq(String srparversion_eq) {
		this.srparversion_eq = srparversion_eq;
	}

	/**
	 * Դ�ʲ�С�汾ȡ��
	 * @return Դ�ʲ�С�汾
	 */
	public String getSrparsmallversion_eq() {
		return srparsmallversion_eq;
	}

	/**
	 * Դ�ʲ�С�汾�趨
	 * @param srparsmallversionԴ�ʲ�С�汾
	 */
	public void setSrparsmallversion_eq(String srparsmallversion_eq) {
		this.srparsmallversion_eq = srparsmallversion_eq;
	}

	/**
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getSrcreatetime_eq() {
		return srcreatetime_eq;
	}

	/**
	 * ����ʱ���趨
	 * @param srcreatetime����ʱ��
	 */
	public void setSrcreatetime_eq(String srcreatetime_eq) {
		this.srcreatetime_eq = srcreatetime_eq;
	}
	/**
	 * ��ϵ���ͻ�ȡ
	 * @param srcreatetime��ϵ����
	 */
	public String getSrassetrelation_eq() {
		return srassetrelation_eq;
	}
	/**
	 * ��ϵ�����趨
	 * @param srcreatetime��ϵ����
	 */
	public void setSrassetrelation_eq(String srassetrelation_eq) {
		this.srassetrelation_eq = srassetrelation_eq;
	}
	/**
	 * ��IDȡ��
	 * 
	 * @return ��ID
	 */
	public String getSrdomainid_eq() {
		return srdomainid_eq;
	}

	/**
	 * ��ID�趨
	 * 
	 * @param srdomainid_eq ��ID
	 */
	public void setSrdomainid_eq(String srdomainid_eq) {
		this.srdomainid_eq = srdomainid_eq;
	}

	/**
	 * ��汾ȡ��
	 * 
	 * @return ��汾
	 */
	public String getSrdomainversion_eq() {
		return srdomainversion_eq;
	}

	/**
	 * ��汾�趨
	 * 
	 * @param srdomainversion_eq ��汾
	 */
	public void setSrdomainversion_eq(String srdomainversion_eq) {
		this.srdomainversion_eq = srdomainversion_eq;
	}
	
	/**
	 * �߼�ɾ����ʶȡ��
	 *
	 * @return �߼�ɾ����ʶ
	 */
	public String getDeleteflag_eq() {
		return deleteflag_eq;
	}

	/**
	 * �߼�ɾ����ʶ�趨
	 *
	 * @param brdeleteflag_eq�߼�ɾ����ʶ
	 */
	public void setDeleteflag_eq(String deleteflag_eq) {
		this.deleteflag_eq = deleteflag_eq;
	}
	/**
	 *  ��չ�㷨����ȡ��
	 * @return ��չ�㷨���� srarithmetictype_eq
	 */
	public String getSrarithmetictype_eq() {
		return srarithmetictype_eq;
	}
	/**
	 *  ��չ�㷨�����趨
	 * @param srarithmetictype_eq ��չ�㷨����
	 */
	public void setSrarithmetictype_eq(String srarithmetictype_eq) {
		this.srarithmetictype_eq = srarithmetictype_eq;
	}
	/**
	 *  Ŀ���ʲ�IDȡ��
	 * @return Ŀ���ʲ�ID srcldeiid_eq
	 */
	public String getSrcldeiid_eq() {
		return srcldeiid_eq;
	}
	/**
	 *  Ŀ���ʲ�ID�趨
	 * @param srcldeiid_eq Ŀ���ʲ�ID
	 */
	public void setSrcldeiid_eq(String srcldeiid_eq) {
		this.srcldeiid_eq = srcldeiid_eq;
	}
	/**
	 *  Ŀ���ʲ���汾ȡ��
	 * @return Ŀ���ʲ���汾 srcldversion_eq
	 */
	public String getSrcldversion_eq() {
		return srcldversion_eq;
	}
	/**
	 *  Ŀ���ʲ���汾�趨
	 * @param srcldversion_eq Ŀ���ʲ���汾
	 */
	public void setSrcldversion_eq(String srcldversion_eq) {
		this.srcldversion_eq = srcldversion_eq;
	}
	/**
	 *  Ŀ���ʲ�С�汾ȡ��
	 * @return Ŀ���ʲ�С�汾 srcldsmallversion_eq
	 */
	public String getSrcldsmallversion_eq() {
		return srcldsmallversion_eq;
	}
	/**
	 *  Ŀ���ʲ�С�汾�趨
	 * @param srcldsmallversion_eq Ŀ���ʲ�С�汾
	 */
	public void setSrcldsmallversion_eq(String srcldsmallversion_eq) {
		this.srcldsmallversion_eq = srcldsmallversion_eq;
	}
    /**
     * ��ȡ��ѯ�õĴ洢einame
     * @return
     */
	public String getSrcStorageEiname() {
		return srcStorageEiname;
	}

	public void setSrcStorageEiname(String srcStorageEiname) {
		this.srcStorageEiname = srcStorageEiname;
	}	
}