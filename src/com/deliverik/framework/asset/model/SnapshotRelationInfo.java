/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model;

import com.deliverik.framework.base.BaseModel;

/**
  * ����: ���չ�ϵ��ӿ�
  * ��������: ���չ�ϵ��ӿ�
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public interface SnapshotRelationInfo extends BaseModel {

	/**
	 * �߼�����ȡ��
	 *
	 * @return �߼�����
	 */
	public Integer getSrid();

	/**
	 * DomainIDȡ��
	 *
	 * @return DomainID
	 */
	public Integer getSrdomainid();

	/**
	 * ��չ�㷨����ȡ��
	 *
	 * @return ��չ�㷨����
	 */
	public String getSrarithmetictype();

	/**
	 * Domain�汾ȡ��
	 *
	 * @return Domain�汾
	 */
	public Integer getSrdomainversion();

	/**
	 * Դ�ʲ�IDȡ��
	 *
	 * @return Դ�ʲ�ID
	 */
	public Integer getSrpareiid();

	/**
	 * Դ�ʲ���汾ȡ��
	 *
	 * @return Դ�ʲ���汾
	 */
	public Integer getSrparversion();

	/**
	 * Դ�ʲ�С�汾ȡ��
	 *
	 * @return Դ�ʲ�С�汾
	 */
	public Integer getSrparsmallversion();

	/**
	 * Ŀ���ʲ�IDȡ��
	 *
	 * @return Ŀ���ʲ�ID
	 */
	public Integer getSrcldeiid();

	/**
	 * Ŀ���ʲ���汾ȡ��
	 *
	 * @return Ŀ���ʲ���汾
	 */
	public Integer getSrcldversion();

	/**
	 * Ŀ���ʲ�С�汾ȡ��
	 *
	 * @return Ŀ���ʲ�С�汾
	 */
	public Integer getSrcldsmallversion();

	/**
	 * ��ϵ���ͣ�����/�߼���ȡ��
	 *
	 * @return ��ϵ���ͣ�����/�߼���
	 */
	public String getSrtype();

	/**
	 * ��ϵ˵��ȡ��
	 *
	 * @return ��ϵ˵��
	 */
	public String getSrdes();

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getSrcreatetime();

	/**
	 * �߼�ɾ����ʶȡ��
	 *
	 * @return �߼�ɾ����ʶ
	 */
	public String getDeleteflag();

	/**
	 * ������ϵ��ȡ��
	 *
	 * @return ������ϵ��
	 */
	public String getSrraletioncode();

	/**
	 * �ʲ���ϵ��ȡ��
	 *
	 * @return �ʲ���ϵ��
	 */
	public String getSrassetrelation();
	
	/**
	 * �ʲ�(����)��Ϣȡ��
	 * @return �ʲ�(����)��Ϣ
	 */
	public IG749Info getParEntityItemVW();
	
	/**
	 * �ʲ�(����)��Ϣȡ��
	 * @return �ʲ�(����)��Ϣ
	 */
	public IG749Info getCldEntityItemVW();

}