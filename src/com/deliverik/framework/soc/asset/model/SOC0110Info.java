/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model;

import com.deliverik.framework.base.BaseModel;
import com.deliverik.framework.soc.asset.model.entity.SOC0123VW;
import com.deliverik.framework.soc.asset.model.entity.SOC0152TB;

/**
  * ����: ����������ϵ��ӿ�
  * ��������: ����������ϵ��ӿ�
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public interface SOC0110Info extends BaseModel {

	/**
	 * �߼�����ȡ��
	 *
	 * @return �߼�����
	 */
	public Integer getBrid();

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
	 * ��ϵ���ͣ�����/�߼���ȡ��
	 *
	 * @return ��ϵ���ͣ�����/�߼���
	 */
	public String getBrtype();

	/**
	 * ��ϵ˵��ȡ��
	 *
	 * @return ��ϵ˵��
	 */
	public String getBrdes();

	/**
	 * ����ʱ��ȡ��
	 *
	 * @return ����ʱ��
	 */
	public String getBrcreatetime();

	/**
	 * �߼�ɾ����ʶȡ��
	 *
	 * @return �߼�ɾ����ʶ
	 */
	public String getDeleteflag();
	
	/**
	 * Դ�ʲ�ȡ��
	 *
	 * @return Դ�ʲ�
	 */
	public SOC0123VW getParEntityItemVW();
	
	/**
	 * Ŀ���ʲ�ȡ��
	 *
	 * @return Ŀ���ʲ�
	 */
	public SOC0123VW getCldEntityItemVW();
	
	/**
	 * ������ϵ��ȡ��
	 *
	 * @return ������ϵ��
	 */
	public String getBrraletioncode();
	
	/**
	 * �ʲ���ϵ��ȡ��
	 *
	 * @return �ʲ���ϵ��
	 */
	public String getBrassetrelation();
	
	/**
	 * �ʲ����������ڵ�ʵ���ʶȡ��
	 * @return �ʲ����������ڵ�ʵ���ʶ
	 */
	public Integer getEirootmark();
	
}