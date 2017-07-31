/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.wim.bl.task;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.wim.model.WorkInstanceInfo;
import com.deliverik.infogovernor.wim.model.condition.WorkInstanceSearchCond;
import com.deliverik.infogovernor.wim.model.dao.WorkInstanceDAO;
import com.deliverik.infogovernor.wim.model.entity.WorkInstanceTB;

/**
  * ����: workInstanceҵ���߼�ʵ��
  * ��������: workInstanceҵ���߼�ʵ��
  * ������¼: 2017/06/09
  * �޸ļ�¼: 
  */
public class WorkInstanceBLImpl extends BaseBLImpl implements
		WorkInstanceBL {

	/** workInstanceDAO�ӿ� */
	protected WorkInstanceDAO workInstanceDAO;
	
	/**
	 * workInstanceDAO�ӿ��趨
	 *
	 * @param workInstanceDAO workInstanceDAO�ӿ�
	 */
	public void setWorkInstanceDAO(WorkInstanceDAO workInstanceDAO) {
		this.workInstanceDAO = workInstanceDAO;
	}

	/**
	 * workInstanceʵ��ȡ��
	 *
	 * @return workInstanceʵ��
	 */
	public WorkInstanceTB getWorkInstanceTBInstance() {
		return new WorkInstanceTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<WorkInstanceInfo> searchWorkInstance() {
		return workInstanceDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public WorkInstanceInfo searchWorkInstanceByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(WorkInstanceSearchCond cond) {
		return workInstanceDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<WorkInstanceInfo> searchWorkInstance(
			WorkInstanceSearchCond cond) {
		return workInstanceDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<WorkInstanceInfo> searchWorkInstance(
			WorkInstanceSearchCond cond, int start,
			int count) {
		return workInstanceDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public WorkInstanceInfo registWorkInstance(WorkInstanceInfo instance)
		throws BLException {
		return workInstanceDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public WorkInstanceInfo updateWorkInstance(WorkInstanceInfo instance)
		throws BLException {
		checkExistInstance(instance.getWiid());
		return workInstanceDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteWorkInstanceByPK(Integer pk)
		throws BLException {
		workInstanceDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteWorkInstance(WorkInstanceInfo instance)
		throws BLException {
		workInstanceDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public WorkInstanceInfo checkExistInstance(Integer pk)
		throws BLException {
		WorkInstanceInfo instance = workInstanceDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
	/**
	 * ��ѯ����
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<Map<String,String>> findWeekWorkByCond(final WorkInstanceSearchCond cond, final int start, final int count){
		return workInstanceDAO.findWeekWorkByCond(cond, start, count);
	}
	
	/**
	 * @Description ����ÿ�����Ѽ�������
	 * @return ����ʵ����������
	 */
	public List<WorkInstanceInfo> findInstanceByTips(){
		return workInstanceDAO.findInstanceTips();
	}
	
	/**
	 * ������Ϣͳ�Ʋ�ѯ
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Map<String,String>> findCountSearch(final WorkInstanceSearchCond cond, final int start, final int count){
		return workInstanceDAO.findCountSearch(cond, start, count);
	}
	/**
	 * ��ҳ��ѯ���չ���
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<Map<String,String>> findTodayWorkByCondForFirstPageTop5(final WorkInstanceSearchCond cond, final int start, final int count){
		return workInstanceDAO.findTodayWorkByCondForFirstPageTop5(cond, start, count);
	}
	
	/**
	 * ��ѯ���չ���
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<Map<String,String>> findTodayWorkByCondForFirstPage(final WorkInstanceSearchCond cond, final int start, final int count){
		return workInstanceDAO.findTodayWorkByCondForFirstPage(cond, start, count);
	}
	/**
	 * ��ѯ��ǰ�����Ѿ���ʱ����ˣ�������־����Ĵ���ʱ��֮��
	 * @param cond ֻ�õ���ʵ��id-wiid
	 * @return
	 */
	public String getTotalExcuteTime(final WorkInstanceSearchCond cond){
		return workInstanceDAO.getTotalExcuteTime(cond);
	}
	/**
	 * ��ѯ����Ԥ�����ʱ��С�ڵ�ǰʱ�䣬�������й���������
	 * @param 
	 * @return ʱ�����ֵ�Ͷ�Ӧ������id
	 */
	public List<Map<String, String>> getExcutedMaxTime() {
		
		return workInstanceDAO.getExcutedMaxTime();
	}
}