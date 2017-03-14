/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG561Info;
import com.deliverik.framework.workflow.prr.model.IG561VWInfo;
import com.deliverik.framework.workflow.prr.model.condition.IG561SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG561TB;

/**
  * ����: ״̬��˽�б�ֵ��¼��ҵ���߼��ӿ�
  * ��������: ״̬��˽�б�ֵ��¼��ҵ���߼��ӿ�
  * ������¼: 2015/02/07
  * �޸ļ�¼: 
  */
public interface IG561BL extends BaseBL {

	/**
	 * ״̬��˽�б�ֵ��¼��ʵ��ȡ��
	 *
	 * @return ״̬��˽�б�ֵ��¼��ʵ��
	 */
	public IG561TB getIG561TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG561Info> searchIG561();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG561Info searchIG561ByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG561SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG561Info> searchIG561(
			IG561SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG561Info> searchIG561(
			IG561SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG561Info registIG561(IG561Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG561Info updateIG561(IG561Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG561ByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG561(IG561Info instance)
		throws BLException;
	
	/**
     * ���̹رսڵ� ״̬˽�б���ʾ��ѯ������������ʾ��״̬��˽�б�����ʾ����
     * @Title: searchIG561VW
     * @Description: ���̹رսڵ� ״̬˽�б���ʾ��ѯ������������ʾ��״̬��˽�б�����ʾ����
     * @param 
     * prid ����id 
     * ppuserid ������id
     * isAdmin �Ƿ������̹���Ա
     * @return list561VW
     * @throws
     */
    public List<IG561VWInfo> searchIG561VW( String prid , String ppuserid, boolean isAdmin)throws BLException;


}