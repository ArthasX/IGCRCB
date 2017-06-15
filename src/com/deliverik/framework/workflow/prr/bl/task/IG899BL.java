/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.IG899Info;
import com.deliverik.framework.workflow.prr.model.condition.IG899SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG899TB;

/**
  * ����: ����˽�б�����ҵ���߼��ӿ�
  * ��������: ����˽�б�����ҵ���߼��ӿ�
  * ������¼: 2012/03/27
  * �޸ļ�¼: 
  */
public interface IG899BL extends BaseBL {

	/**
	 * ����˽�б�����ʵ��ȡ��
	 *
	 * @return ����˽�б�����ʵ��
	 */
	public IG899TB getIG899TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG899Info> searchIG899Info();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG899Info searchIG899InfoByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG899SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG899Info> searchIG899Info(
			IG899SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG899Info> searchIG899Info(
			IG899SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param ig899Info ����ʵ��
	 * @return ����ʵ��
	 */
	public IG899Info registIG899Info(IG899Info ig899Info)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param ig899Info �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG899Info updateIG899Info(IG899Info ig899Info)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG899InfoByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param ig899Info ɾ��ʵ��
	 */
	public void deleteIG899Info(IG899Info ig899Info)
		throws BLException;
	
	/**
	 * ����˽�б�������
	 * 
	 * @param ig899InfoList ����������
	 * @param roleid ��ɫID
	 * @param userid �û�ID
	 * @throws BLException 
	 */
	public void registIG899Info(List<IG599Info> ig899InfoList, Integer roleid, String userid,String orgid)
		throws BLException;

}