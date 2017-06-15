/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.dbs.bl.task;

import java.util.Date;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Symmetrix_Monitor_Rt;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Symmetrix_Monitor_RtVWInfo;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_Symmetrix_Monitor_RtSearchCond;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_Symmetrix_Monitor_RtVWSearchCond;

/**
 * 
 * @Description:�洢ʵʱ��ϢBL�ӿ�
 * @Author
 * @History
 * @Version V1.0
 */
public interface Collect_Symmetrix_Monitor_RtBL extends BaseBL {
	/**
	 * �־û�����
	 * 
	 * @param Collect_Symmetrix_Monitor_Rtʵ����
	 * @return Collect_Symmetrix_Monitor_Rtʵ����
	 */
	public Collect_Symmetrix_Monitor_Rt saveCollect_Symmetrix_Monitor_Rt(
			Collect_Symmetrix_Monitor_Rt collect_Symmetrix_Monitor_Rt)
			throws BLException;

	/**
	 * ������������
	 * 
	 * @param id
	 *            ����
	 * @return �������
	 */
	public Collect_Symmetrix_Monitor_Rt findCollect_Symmetrix_Monitor_RtByPK(
			Integer id) throws BLException;

	/**
	 * ȫ������
	 * 
	 * @return ���������
	 */
	public List<Collect_Symmetrix_Monitor_Rt> findAllCollect_Symmetrix_Monitor_Rt()
			throws BLException;

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond
	 *            ��������
	 * @return �����������
	 */
	public int getSearchCount(Collect_Symmetrix_Monitor_RtSearchCond cond)
			throws BLException;

	/**
	 * ������������
	 * 
	 * @param cond
	 *            ��������
	 * @param start
	 *            ������¼��ʼ�к�
	 * @param count
	 *            ������¼����
	 * @return ��������б�
	 */
	public List<Collect_Symmetrix_Monitor_Rt> findCollect_Symmetrix_Monitor_RtByCond(
			Collect_Symmetrix_Monitor_RtSearchCond cond, int start, int count)
			throws BLException;

	/**
	 * ɾ������
	 * 
	 * @param Collect_Symmetrix_Monitor_Rtʵ����
	 */
	public void deleteCollect_Symmetrix_Monitor_Rt(
			Collect_Symmetrix_Monitor_Rt collect_Symmetrix_Monitor_Rt)
			throws BLException;

	/**
	 * ��ͼ������������
	 * 
	 * @param cond
	 *            ��������
	 * @return ��������б�
	 */
	public List<Collect_Symmetrix_Monitor_RtVWInfo> findVWByCond(
			final Collect_Symmetrix_Monitor_RtVWSearchCond cond);

	/**
	 * ��ȡ���ʱ��
	 * 
	 * @return
	 */
	public Date getMaxSaveTime(Collect_Symmetrix_Monitor_RtVWSearchCond cond);
	
	/**
	 * ��ȡ���ʱ��
	 * 
	 * @return
	 */
	public Date getMaxSaveTimeRT(Collect_Symmetrix_Monitor_RtSearchCond cond);
	/**
	 * ��ͼ������������
	 * 
	 * @param cond
	 *            ��������
	 * @return ��������б�
	 */
	public List<Collect_Symmetrix_Monitor_Rt> findByCond(
			final Collect_Symmetrix_Monitor_RtSearchCond cond);
}
