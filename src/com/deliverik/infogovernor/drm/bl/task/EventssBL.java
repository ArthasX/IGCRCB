/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.drm.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.drm.model.EventssInfo;
import com.deliverik.infogovernor.drm.model.condition.EventssSearchCond;
import com.deliverik.infogovernor.drm.model.entity.EventssTB;

/**
  * ����: �¼������ҵ���߼��ӿ�
  * ��������: �¼������ҵ���߼��ӿ�
  * ������¼: 2015/03/18
  * �޸ļ�¼: 
  */
public interface EventssBL extends BaseBL {

	/**
	 * �¼������ʵ��ȡ��
	 *
	 * @return �¼������ʵ��
	 */
	public EventssTB getEventssTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<EventssInfo> searchEventss();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public EventssInfo searchEventssByPK(Integer pk)
		throws BLException;

	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(EventssSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<EventssInfo> searchEventss(
			EventssSearchCond cond);

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
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public EventssInfo registEventss(EventssInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public EventssInfo updateEventss(EventssInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteEventssByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteEventss(EventssInfo instance)
		throws BLException;

}