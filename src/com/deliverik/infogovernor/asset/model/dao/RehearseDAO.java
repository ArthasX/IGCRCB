/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.asset.model.dao;

import java.util.HashMap;
import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.framework.workflow.prr.model.IG500Info;
import com.deliverik.infogovernor.asset.model.RehearseVWInfo;
import com.deliverik.infogovernor.asset.model.condition.RehearseSearchCond;



/**
  * ����: ��ɫ��֯�ܹ���ϵ��DAO�ӿ�
  * ��������: ��ɫ��֯�ܹ���ϵ��DAO�ӿ�
  * ������¼: 2014/06/16
  * �޸ļ�¼: 
  */
public interface RehearseDAO extends BaseHibernateDAO<RehearseVWInfo> {

	/**
	 * ����ͳ�� ������ѯ ��ҳ
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<HashMap<String, Object>> searchAssessRisk(final RehearseSearchCond cond, final int start, final int count);
	/**
	 * ����ͳ�� ������ѯ ��ҳ
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<HashMap<String, Object>> searchRiskInfo(final RehearseSearchCond cond, final int start, final int count);
	/**
	 * ����ͳ�� ������ѯ ��ҳ
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<HashMap<String, Object>> searchIssueCorrectiveInfo(final RehearseSearchCond cond, final int start, final int count);
	/**
	 * ����ͳ�� ������ѯ ��ҳ
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	public List<IG500Info> searchIssueCorrectiveByField(final RehearseSearchCond cond, final int start, final int count);
	
	
}