/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model;

import com.deliverik.framework.asset.model.entity.IG749VW;

/**
  * ����: ����������ϵ��ͼ�ӿ�
  * ��������: ����������ϵ��ͼ�ӿ�
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public interface EiBelongRelationVWInfo {

	/**
	 * Դ�ʲ�IDȡ��
	 *
	 * @return Դ�ʲ�ID
	 */
	public Integer getBrpareiid();

	/**
	 * Դ�ʲ���汾ȡ��
	 *
	 * @return Դ�ʲ���汾
	 */
	public Integer getBrparversion();

	/**
	 * Դ�ʲ�С�汾ȡ��
	 *
	 * @return Դ�ʲ�С�汾
	 */
	public Integer getBrparsmallversion();

	/**
	 * Ŀ���ʲ�IDȡ��
	 *
	 * @return Ŀ���ʲ�ID
	 */
	public Integer getBrcldeiid();

	/**
	 * Ŀ���ʲ���汾ȡ��
	 *
	 * @return Ŀ���ʲ���汾
	 */
	public Integer getBrcldversion();

	/**
	 * Ŀ���ʲ�С�汾ȡ��
	 *
	 * @return Ŀ���ʲ�С�汾
	 */
	public Integer getBrcldsmallversion();

	/**
	 * Դ�ʲ�ȡ��
	 *
	 * @return Դ�ʲ�
	 */
	public IG749VW getParEntityItemVW();
	
	/**
	 * Ŀ���ʲ�ȡ��
	 *
	 * @return Ŀ���ʲ�
	 */
	public IG749VW getCldEntityItemVW();
	
}