/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.condition;

/**
  * ����: ���չ�ϵ����������ӿ�
  * ��������: ���չ�ϵ����������ӿ�
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public interface SnapshotRelationSearchCond {
	
	/**
	 * ��IDȡ��
	 * 
	 * @return ��ID
	 */
	public String getSrdomainid_eq();

	/**
	 * ��汾ȡ��
	 * 
	 * @return ��汾
	 */
	public String getSrdomainversion_eq();
	
	/**
	 * �߼�ɾ����ʶȡ��
	 *
	 * @return �߼�ɾ����ʶ
	 */
	public String getDeleteflag_eq();
	
	/**
	 * Դ�ʲ�IDȡ��
	 * @return Դ�ʲ�ID
	 */
	public String getSrpareiid_eq() ;
	
	
	/**
	 * Դ�ʲ���汾ȡ��
	 * @return Դ�ʲ���汾
	 */
	public String getSrparversion_eq();
	
	/**
	 * Դ�ʲ�С�汾ȡ��
	 * @return Դ�ʲ�С�汾
	 */
	public String getSrparsmallversion_eq() ;
	
	/**
	 * ����ʱ��ȡ��
	 * @return ����ʱ��
	 */
	public String getSrcreatetime_eq();
	
	/**
	 * ��ϵ���ͻ�ȡ
	 * @param srcreatetime��ϵ����
	 */
	public String getSrassetrelation_eq();
	
	/**
	 *  ��չ�㷨����ȡ��
	 * @return ��չ�㷨���� srarithmetictype_eq
	 */
	public String getSrarithmetictype_eq();
	
	/**
	 *  Ŀ���ʲ�IDȡ��
	 * @return Ŀ���ʲ�ID srcldeiid_eq
	 */
	public String getSrcldeiid_eq();
	
	/**
	 *  Ŀ���ʲ���汾ȡ��
	 * @return Ŀ���ʲ���汾 srcldversion_eq
	 */
	public String getSrcldversion_eq();
	
	/**
	 *  Ŀ���ʲ�С�汾ȡ��
	 * @return Ŀ���ʲ�С�汾 srcldsmallversion_eq
	 */
	public String getSrcldsmallversion_eq();
	
	 /**
     * ��ȡ��ѯ�õĴ洢einame
     * @return
     */
	public String getSrcStorageEiname();
}