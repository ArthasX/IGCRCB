/*
g * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.wim.model.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.wim.model.WorkInstanceInfo;
import com.deliverik.infogovernor.wim.model.condition.WorkInstanceSearchCond;

/**
  * ����: ����ʵ��DAO�ӿ�
  * ��������: ����ʵ��DAO�ӿ�
  * ������¼: 2017/06/09
  * �޸ļ�¼: 
  */
public interface WorkInstanceDAO extends BaseHibernateDAO<WorkInstanceInfo> {

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<WorkInstanceInfo> findAll();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public WorkInstanceInfo findByPK(Serializable pk);

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final WorkInstanceSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<WorkInstanceInfo> findByCond(
			final WorkInstanceSearchCond cond, final int start,
			final int count);
	/**
	 * ��ѯ����
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<Map<String,String>> findWeekWorkByCond(final WorkInstanceSearchCond cond, final int start, final int count);
	
	/**
	 * @Description ��������ʵ���������ݼ�
	 * @author WangLiang
	 * @return ����ʵ����Ϣ����
	 */
	public List<WorkInstanceInfo> findInstanceTips();
	
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