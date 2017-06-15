/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.sym.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.sym.model.MSGFILTERInfo;
import com.deliverik.infogovernor.sym.model.condition.MSGFILTERSearchCond;
import com.deliverik.infogovernor.sym.model.entity.MSGFILTERTB;

/**
  * ����: MSGFILTERҵ���߼��ӿ�
  * ��������: MSGFILTERҵ���߼��ӿ�
  * ������¼: 2013/08/21
  * �޸ļ�¼: 
  */
public interface MSGFILTERBL extends BaseBL {

	/**
	 * MSGFILTERʵ��ȡ��
	 *
	 * @return MSGFILTERʵ��
	 */
	public MSGFILTERTB getMSGFILTERTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<MSGFILTERInfo> searchMSGFILTER();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public MSGFILTERInfo searchMSGFILTERByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(MSGFILTERSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<MSGFILTERInfo> searchMSGFILTER(
			MSGFILTERSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<MSGFILTERInfo> searchMSGFILTER(
			MSGFILTERSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public MSGFILTERInfo registMSGFILTER(MSGFILTERInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public MSGFILTERInfo updateMSGFILTER(MSGFILTERInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteMSGFILTERByPK( Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteMSGFILTER(MSGFILTERInfo instance)
		throws BLException;

}