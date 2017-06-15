/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.workflow.prr.model.IG485Info;
import com.deliverik.framework.workflow.prr.model.condition.IG485SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG224VW;
import com.deliverik.framework.workflow.prr.model.entity.IG485PK;
import com.deliverik.framework.workflow.prr.model.entity.IG485TB;
import com.deliverik.framework.workflow.prr.model.entity.IG485VW;

/**
  * ����: �����������ϵʵ����ҵ���߼��ӿ�
  * ��������: �����������ϵʵ����ҵ���߼��ӿ�
  * ������¼: 2015/02/03
  * �޸ļ�¼: 
  */
public interface IG485BL extends BaseBL {

	/**
	 * �����������ϵʵ����ʵ��ȡ��
	 *
	 * @return �����������ϵʵ����ʵ��
	 */
	public IG485TB getIG485TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG485Info> searchIG485();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG485Info searchIG485ByPK(IG485PK pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG485SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG485Info> searchIG485(
			IG485SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG485Info> searchIG485(
			IG485SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG485Info registIG485(IG485Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG485Info updateIG485(IG485Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG485ByPK(IG485PK pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG485(IG485Info instance)
		throws BLException;
	
	/**
	 * �ж�ָ��״̬�Ƿ���Ҫ����
	 * @param prid Ӱ������ID
	 * @param pgrid ������ʵ��ID
	 * @param pgdid �����鶨��ID
	 * @param ipsdid Ӱ��״̬ID
	 * @return �Ƿ���Ҫ����
	 */
	public boolean checkPend(Integer pgrid, String pgdid, String ipsdid);
	
	/**
	 * �ж�ָ���ο�״̬�������ʱ�����Ӧ��Ӱ��״̬��������Ƿ�ԾǨ
	 * @param prid Ӱ������ID
	 * @param pgrid ������ʵ��ID
	 * @param pgdid �����鶨��ID
	 * @param rpsdid �ο�״̬ID
	 * @param rtpsdid �ο�����Ŀ��״̬ID����
	 * @return ԾǨ����ID����
	 */
	public List<IG224VW> searchTriggerPrid(Integer prid, Integer pgrid,
			String pgdid, String rpsdid, List<String> rtpsdids);
	
	/**
	 * ��ѯ������ϵʵ��δ�����¼
	 * @param prid �ο�����ID
	 * @param rpsdid �ο�����״̬ID
	 * @return δ�����¼
	 */
	public List<IG485VW> searchNotDone(Integer prid, String rpsdid);

}