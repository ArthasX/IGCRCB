/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0163Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0163SearchCond;

/**
  * ����: �û��ʲ�BL
  * ��������: �û��ʲ�BL
  * ������¼: 2011/04/21
  * �޸ļ�¼: 
  */
public interface SOC0163BL extends BaseBL {


	

	/**
	 * ������������
	 *
	 * @param pk����
	 * @return �������
	 */
	public SOC0163Info searchEntityItemEntityVWByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0163SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<SOC0163Info> searchEntityItemEntityVW(
			SOC0163SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<SOC0163Info> searchEntityItemEntityVW(
			SOC0163SearchCond cond, int start,
			int count);
	
	/**
	 * �������������豸�������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCountForNetAsset(SOC0163SearchCond cond);
	
	
	/**
	 * �������������豸����
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0163Info> findByCondForNetAsset(SOC0163SearchCond cond, int start,  int count);
	

}