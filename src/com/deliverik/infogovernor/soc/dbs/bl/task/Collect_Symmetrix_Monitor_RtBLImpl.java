/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.dbs.bl.task;

import java.util.Date;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Symmetrix_Monitor_Rt;
import com.deliverik.infogovernor.soc.dbs.model.Collect_Symmetrix_Monitor_RtVWInfo;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_Symmetrix_Monitor_RtSearchCond;
import com.deliverik.infogovernor.soc.dbs.model.condition.Collect_Symmetrix_Monitor_RtVWSearchCond;
import com.deliverik.infogovernor.soc.dbs.model.dao.Collect_Symmetrix_Monitor_RtDAO;
import com.deliverik.infogovernor.soc.dbs.model.dao.Collect_Symmetrix_Monitor_RtVWDAO;

/**
 * 
 * @Description:�洢ʵʱ��ϢBLʵ����
 * @Author
 * @History
 * @Version V1.0
 */
public class Collect_Symmetrix_Monitor_RtBLImpl extends BaseBLImpl implements
		Collect_Symmetrix_Monitor_RtBL {

	protected Collect_Symmetrix_Monitor_RtDAO collect_Symmetrix_Monitor_RtDAO;

	protected Collect_Symmetrix_Monitor_RtVWDAO collect_Symmetrix_Monitor_RtVWDAO;

	public void setCollect_Symmetrix_Monitor_RtDAO(
			Collect_Symmetrix_Monitor_RtDAO collect_Symmetrix_Monitor_RtDAO) {
		this.collect_Symmetrix_Monitor_RtDAO = collect_Symmetrix_Monitor_RtDAO;
	}

	public void setCollect_Symmetrix_Monitor_RtVWDAO(
			Collect_Symmetrix_Monitor_RtVWDAO collect_Symmetrix_Monitor_RtVWDAO) {
		this.collect_Symmetrix_Monitor_RtVWDAO = collect_Symmetrix_Monitor_RtVWDAO;
	}

	/**
	 * �־û�����
	 * 
	 * @param Collect_Symmetrix_Monitor_Rtʵ����
	 * @return Collect_Symmetrix_Monitor_Rtʵ����
	 */
	public Collect_Symmetrix_Monitor_Rt saveCollect_Symmetrix_Monitor_Rt(
			Collect_Symmetrix_Monitor_Rt collect_Symmetrix_Monitor_Rt)
			throws BLException {
		return collect_Symmetrix_Monitor_RtDAO
				.save(collect_Symmetrix_Monitor_Rt);
	}

	/**
	 * ������������
	 * 
	 * @param id
	 *            ����
	 * @return �������
	 */
	public Collect_Symmetrix_Monitor_Rt findCollect_Symmetrix_Monitor_RtByPK(
			Integer id) throws BLException {
		return collect_Symmetrix_Monitor_RtDAO.findByPK(id);
	}

	/**
	 * ȫ������
	 * 
	 * @return ���������
	 */
	public List<Collect_Symmetrix_Monitor_Rt> findAllCollect_Symmetrix_Monitor_Rt()
			throws BLException {
		return collect_Symmetrix_Monitor_RtDAO.findAll();
	}

	/**
	 * ���������������ȡ��
	 * 
	 * @param cond
	 *            ��������
	 * @return �����������
	 */
	public int getSearchCount(Collect_Symmetrix_Monitor_RtSearchCond cond)
			throws BLException {
		return collect_Symmetrix_Monitor_RtDAO.getSearchCount(cond);
	}

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
			throws BLException {
		return collect_Symmetrix_Monitor_RtDAO.findByCond(cond, start, count);
	}

	/**
	 * ɾ������
	 * 
	 * @param Collect_Symmetrix_Monitor_Rtʵ����
	 */
	public void deleteCollect_Symmetrix_Monitor_Rt(
			Collect_Symmetrix_Monitor_Rt collect_Symmetrix_Monitor_Rt)
			throws BLException {
		collect_Symmetrix_Monitor_RtDAO.delete(collect_Symmetrix_Monitor_Rt);
	}

	/**
	 * ��ͼ������������
	 * 
	 * @param cond
	 *            ��������
	 * @return ��������б�
	 */
	public List<Collect_Symmetrix_Monitor_RtVWInfo> findVWByCond(
			final Collect_Symmetrix_Monitor_RtVWSearchCond cond) {
		return collect_Symmetrix_Monitor_RtVWDAO.findByCond(cond);
	}

	/**
	 * ��ȡ���ʱ��
	 * 
	 * @return
	 */
	public Date getMaxSaveTime(Collect_Symmetrix_Monitor_RtVWSearchCond cond) {
		return collect_Symmetrix_Monitor_RtVWDAO.getMaxSaveTime(cond);
	}

	/**
	 * ��ȡ���ʱ��
	 * 
	 * @return
	 */
	public Date getMaxSaveTimeRT(Collect_Symmetrix_Monitor_RtSearchCond cond) {
		return collect_Symmetrix_Monitor_RtDAO.getMaxSaveTime(cond);
	}
	
	/**
	 * ��ͼ������������
	 * 
	 * @param cond
	 *            ��������
	 * @return ��������б�
	 */
	public List<Collect_Symmetrix_Monitor_Rt> findByCond(
			final Collect_Symmetrix_Monitor_RtSearchCond cond) {
		return collect_Symmetrix_Monitor_RtDAO.findByCond(cond,0 ,10000);
	}
}
