/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.wim.bl.task;

import java.util.List;
import java.util.Map;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.wim.model.WorkInstanceInfo;
import com.deliverik.infogovernor.wim.model.condition.WorkInstanceSearchCond;
import com.deliverik.infogovernor.wim.model.entity.WorkInstanceTB;

/**
  * ����: workInstanceҵ���߼��ӿ�
  * ��������: workInstanceҵ���߼��ӿ�
  * ������¼: 2017/06/09
  * �޸ļ�¼: 
  */
public interface WorkInstanceBL extends BaseBL {

	/**
	 * workInstanceʵ��ȡ��
	 *
	 * @return workInstanceʵ��
	 */
	public WorkInstanceTB getWorkInstanceTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<WorkInstanceInfo> searchWorkInstance();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public WorkInstanceInfo searchWorkInstanceByPK(Integer pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(WorkInstanceSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<WorkInstanceInfo> searchWorkInstance(
			WorkInstanceSearchCond cond);

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
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public WorkInstanceInfo registWorkInstance(WorkInstanceInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public WorkInstanceInfo updateWorkInstance(WorkInstanceInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteWorkInstanceByPK(Integer pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteWorkInstance(WorkInstanceInfo instance)
		throws BLException;
	/**
	 * ��ѯ����
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<Map<String,String>> findWeekWorkByCond(final WorkInstanceSearchCond cond, final int start, final int count);
	
	/**
	 * @Description ����ÿ�����Ѽ�������
	 * @return ����ʵ����������
	 */
	public List<WorkInstanceInfo> findInstanceByTips();
	
	/**
	 * ������Ϣͳ�Ʋ�ѯ
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Map<String,String>> findCountSearch(final WorkInstanceSearchCond cond, final int start, final int count);
	/**
	 * ��ҳ��ѯ���չ���
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<Map<String,String>> findTodayWorkByCondForFirstPageTop5(final WorkInstanceSearchCond cond, final int start, final int count);
	
	/**
	 * ��ҳ��ѯ���չ���
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<Map<String,String>> findTodayWorkByCondForFirstPage(final WorkInstanceSearchCond cond, final int start, final int count);
	
	/**
	 * ��ѯ��ǰ�����Ѿ���ʱ����ˣ�������־����Ĵ���ʱ��֮��
	 * @param cond ֻ�õ���ʵ��id-wiid
	 * @return
	 */
	public String getTotalExcuteTime(final WorkInstanceSearchCond cond);
	
	/**
	 * ��ѯ����Ԥ�����ʱ��С�ڵ�ǰʱ�䣬�������й���������
	 * @param 
	 * @return ʱ�����ֵ�Ͷ�Ӧ������id
	 */
    public List<Map<String, String>> getExcutedMaxTime();
}