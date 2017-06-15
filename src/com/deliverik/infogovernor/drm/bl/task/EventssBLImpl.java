/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.drm.model.EventssInfo;
import com.deliverik.infogovernor.drm.model.condition.EventssSearchCond;
import com.deliverik.infogovernor.drm.model.dao.EventssDAO;
import com.deliverik.infogovernor.drm.model.entity.EventssTB;

/**
  * ����: �¼������ҵ���߼�ʵ��
  * ��������: �¼������ҵ���߼�ʵ��
  * ������¼: 2015/03/18
  * �޸ļ�¼: 
  */
public class EventssBLImpl extends BaseBLImpl implements
		EventssBL {

	/** �¼������DAO�ӿ� */
	protected EventssDAO eventssDAO;
	
	/**
	 * �¼������DAO�ӿ��趨
	 *
	 * @param eventssDAO �¼������DAO�ӿ�
	 */
	public void setEventssDAO(EventssDAO eventssDAO) {
		this.eventssDAO = eventssDAO;
	}

	/**
	 * �¼������ʵ��ȡ��
	 *
	 * @return �¼������ʵ��
	 */
	public EventssTB getEventssTBInstance() {
		return new EventssTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EventssInfo> searchEventss() {
		return eventssDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public EventssInfo searchEventssByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(EventssSearchCond cond) {
		return eventssDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<EventssInfo> searchEventss(
			EventssSearchCond cond) {
		return eventssDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<EventssInfo> searchEventss(
			EventssSearchCond cond, int start,
			int count) {
		return eventssDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public EventssInfo registEventss(EventssInfo instance)
		throws BLException {
		return eventssDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public EventssInfo updateEventss(EventssInfo instance)
		throws BLException {
		checkExistInstance(instance.getEventid());
		return eventssDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteEventssByPK(Integer pk)
		throws BLException {
		eventssDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteEventss(EventssInfo instance)
		throws BLException {
		eventssDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public EventssInfo checkExistInstance(Integer pk)
		throws BLException {
		EventssInfo instance = eventssDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

}