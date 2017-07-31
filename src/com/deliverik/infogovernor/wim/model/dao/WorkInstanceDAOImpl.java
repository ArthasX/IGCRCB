/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.wim.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.wim.model.WorkInstanceInfo;
import com.deliverik.infogovernor.wim.model.condition.WorkInstanceSearchCond;
import com.deliverik.infogovernor.wim.model.entity.WorkInstanceTB;
import com.deliverik.infogovernor.wim.utils.IGDateUtils;

/**
  * ����: ����ʵ��DAOʵ��
  * ��������: ����ʵ��DAOʵ��
  * ������¼: 2017/06/09
  * �޸ļ�¼: 
  */
public class WorkInstanceDAOImpl extends
		BaseHibernateDAOImpl<WorkInstanceInfo> implements WorkInstanceDAO {

	/**
	 * ���캯��
	 */
	public WorkInstanceDAOImpl(){
		super(WorkInstanceTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<WorkInstanceInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public WorkInstanceInfo findByPK(Serializable pk) {
		WorkInstanceInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final WorkInstanceSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<WorkInstanceInfo> findByCond(final WorkInstanceSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}
	/**
	 * ��ѯ����
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	@SuppressWarnings({ "unchecked"})
	public List<Map<String,String>> findWeekWorkByCond(final WorkInstanceSearchCond cond, final int start, final int count){
		
		Session session = getSession();
		
		String sql = session.getNamedQuery("WorkInstanceDAO.findWeekWorkByCond").getQueryString();
		SQLQuery q = session.createSQLQuery(sql);
		//�������ڲ�ѯ���� ����
		String workDate = cond.getWorkDate();
		// ����������ڸ�ʽ
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		List<Date> days = IGDateUtils.dateToWeek(workDate);
		for (int i= 0; i< days.size();i++) {
			q.setParameter("week"+(i+1), sdf.format(days.get(i)));
		}
		q.setParameter("leaderid", cond.getUserid()+"%");
		q.setParameter("userid",cond.getUserid());
		q.setParameter("excutorid","%"+ cond.getUserid()+"%");
		
		q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		q.addScalar("wiid",Hibernate.STRING) ;
		q.addScalar("wdname",Hibernate.STRING) ;
		q.addScalar("leaderid",Hibernate.STRING) ;
		q.addScalar("excutorid",Hibernate.STRING) ;
		q.addScalar("wistatus",Hibernate.STRING) ;
		q.addScalar("begindate",Hibernate.STRING) ;
		q.addScalar("crtDate",Hibernate.STRING) ;
		q.addScalar("overtime",Hibernate.STRING) ;
		q.addScalar("confirmdate",Hibernate.STRING) ;
		q.addScalar("week1",Hibernate.STRING) ;
		q.addScalar("week2",Hibernate.STRING) ;
		q.addScalar("week3",Hibernate.STRING) ;
		q.addScalar("week4",Hibernate.STRING) ;
		q.addScalar("week5",Hibernate.STRING) ;
		q.addScalar("week6",Hibernate.STRING) ;
		q.addScalar("week7",Hibernate.STRING) ;
        setFetchPoint(q, start, count);
		List<Map<String, String>> result  = q.list();
		
		return result;
	}
	
	/**
	 * @Description ��������ʵ���������ݼ�
	 * @author WangLiang
	 * @return ����ʵ����Ϣ����
	 */
	@SuppressWarnings({"unchecked" })
	public List<WorkInstanceInfo> findInstanceTips(){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append("SELECT * FROM WORKINSTANCE WHERE WISTATUS ='δִ��' OR WISTATUS = 'ִ����'");
				
				SQLQuery q = session.createSQLQuery(query.toString());

				q.addEntity(WorkInstanceTB.class);

				List<WorkInstanceInfo> list = q.list();
				
				session.clear();
				
				return list;
			}
		};
		return (List<WorkInstanceInfo>) execute(action);
		
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(WorkInstanceSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//�������id
		if(cond.getWdid()!=null && cond.getWdid()!=0){
			c.add(Restrictions.eq("wdid", cond.getWdid()));
		}
		
		//����ʵ������
		if(StringUtils.isNotEmpty(cond.getWiname())){
			c.add(Restrictions.like("winame", ""+cond.getWiname()+""));
		}
		
		//����״̬��0��δִ�У�1��ִ���У�2����ִ�У�3��������4����ֹ����
		if(StringUtils.isNotEmpty(cond.getWistatus())){
			c.add(Restrictions.eq("wistatus", ""+cond.getWistatus()+""));
		}
		
		
		//�������ͣ�1���Զ�����2���ֶ�����
		if(StringUtils.isNotEmpty(cond.getWiLunchType())){
			c.add(Restrictions.eq("wiLunchType", cond.getWiLunchType()));
		}
		
		//ִ������ʱ�䣨Сʱ��
		if(StringUtils.isNotEmpty(cond.getExcuteTime())){
			c.add(Restrictions.eq("excuteTime", cond.getExcuteTime()));
		}
		
		//��ʼ����
		if(StringUtils.isNotEmpty(cond.getBeginDate())){
			c.add(Restrictions.like("beginDate", cond.getBeginDate()+"%"));
		}
		
		//����ȷ������
		if(StringUtils.isNotEmpty(cond.getConfirmDate())){
			c.add(Restrictions.like("confirmDate", cond.getConfirmDate()+"%"));
		}
		
		//����������
		if(StringUtils.isNotEmpty(cond.getTitleDate())){
			c.add(Restrictions.like("titleDate", cond.getTitleDate()+"%"));
		}
		
		//���¼����
		if(StringUtils.isNotEmpty(cond.getCrtDate())){
			c.add(Restrictions.like("crtDate", cond.getCrtDate()+"%"));
		}
		
		return c;
	}
	
	
	/**
	 * ������Ϣͳ�Ʋ�ѯ
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	@SuppressWarnings({ "unchecked"})
	public List<Map<String,String>> findCountSearch(final WorkInstanceSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				
				session.flush();
				StringBuffer sql = new StringBuffer(); 
				sql.append(session.getNamedQuery("WorkInstanceDAO.countSearch").getQueryString());
				//��ϲ�ѯ����
				getSQL(cond,sql);
				//�������� ������ʱ�䵹�� �� ����������������
				sql.append(" ORDER BY win.crtDate desc,wlo.titledate asc ");
				SQLQuery q = session.createSQLQuery(sql.toString());
				q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		        setFetchPoint(q, start, count);
				List<Map<String, String>> result  = q.list();
				return result;
			}
		};
		return (List<Map<String,String>>) execute(action);
		
		
	}
	
	/**
	 * ������������
	 * 
	 * @param cond��������
	 * @return �����ü���������
	 */
	protected void getSQL(WorkInstanceSearchCond cond,StringBuffer sql) {
		
		//��������
		if(StringUtils.isNotEmpty(cond.getWdname())) {
			sql.append(" AND WDNAME like '%"+cond.getWdname()+"%' ");
		}
		
		//����
		if(StringUtils.isNotEmpty(cond.getCycle())) {
			sql.append(" AND CYCLE = '"+cond.getCycle()+"' ");
		}
		
		//����״̬
		if(StringUtils.isNotEmpty(cond.getWistatus())) {
			sql.append(" AND WISTATUS = '"+cond.getWistatus()+"' ");
		}
		
		//������
		if(StringUtils.isNotEmpty(cond.getInitiatorId())) {
			sql.append(" AND INITIATORID like '%"+cond.getInitiatorId()+"%' ");
		}
		
		//������
		if(StringUtils.isNotEmpty(cond.getLeaderName())) {
			sql.append(" AND LEADERNAME like '%"+cond.getLeaderName()+"%' ");
		}
		
		//ִ����
		if(StringUtils.isNotEmpty(cond.getExcutorName())) {
			sql.append(" AND win.EXCUTORNAME like '%"+cond.getExcutorName()+"%' ");
		}

		//������ʼ���ڴ�
		if(StringUtils.isNotEmpty(cond.getBegindate_from())) {
			sql.append(" AND BEGINDATE >= '"+cond.getBegindate_from()+" 00:00'");
		}
		
		//������ʼ���ڵ�
		if(StringUtils.isNotEmpty(cond.getBegindate_to())) {
			sql.append(" AND BEGINDATE <= '"+cond.getBegindate_to()+" 99:99'");
		}
	}
	/**
	 * ��ҳ��ѯ����֮ǰû�д���Ĺ���
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	@SuppressWarnings({ "unchecked"})
	public List<Map<String,String>> findTodayWorkByCondForFirstPageTop5(final WorkInstanceSearchCond cond, final int start, final int count){
		
		Session session = getSession();
		
		String sql = session.getNamedQuery("WorkInstanceDAO.findTodayWorkByCondForFirstPageTop5").getQueryString();
		SQLQuery q = session.createSQLQuery(sql);
		//ִ����Ϊ�Լ�
		q.setParameter("excutorid", "%"+cond.getUserid()+"%");
		q.setParameter("leaderid", cond.getUserid());
		//���չ�����ʱ��Ϊtoday
//		q.setParameter("titledate", IGStringUtils.getCurrentDate());
		q.setParameter("userid", cond.getUserid());
		
		q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		q.addScalar("wiid",Hibernate.STRING) ;
		q.addScalar("wistatus",Hibernate.STRING) ;
		q.addScalar("wdname",Hibernate.STRING) ;
		q.addScalar("initiatorid",Hibernate.STRING) ;
		q.addScalar("cycle",Hibernate.STRING) ;
		q.addScalar("leaderid",Hibernate.STRING) ;
		q.addScalar("excutorid",Hibernate.STRING) ;
		q.addScalar("leadername",Hibernate.STRING) ;
		q.addScalar("excutorname",Hibernate.STRING) ;
		q.addScalar("crtdate",Hibernate.STRING) ;
		q.addScalar("overtime",Hibernate.STRING) ;
        setFetchPoint(q, start, count);
		List<Map<String, String>> result  = q.list();
		
		return result;
	}
	
	/**
	 * ��ѯ����֮ǰû�д���Ĺ���
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	@SuppressWarnings({ "unchecked"})
	public List<Map<String,String>> findTodayWorkByCondForFirstPage(final WorkInstanceSearchCond cond, final int start, final int count){
		
		Session session = getSession();
		
		String sql = session.getNamedQuery("WorkInstanceDAO.findTodayWorkByCondForFirstPage").getQueryString();
		SQLQuery q = session.createSQLQuery(sql);
		//ִ����Ϊ�Լ�
		q.setParameter("excutorid", "%"+cond.getUserid()+"%");
		//���չ�����ʱ��Ϊtoday
//		q.setParameter("titledate", IGStringUtils.getCurrentDate());
		q.setParameter("userid", cond.getUserid());
		
		q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		q.addScalar("wiid",Hibernate.STRING) ;
		q.addScalar("wistatus",Hibernate.STRING) ;
		q.addScalar("wdname",Hibernate.STRING) ;
		q.addScalar("initiatorid",Hibernate.STRING) ;
		q.addScalar("cycle",Hibernate.STRING) ;
		q.addScalar("leaderid",Hibernate.STRING) ;
		q.addScalar("excutorid",Hibernate.STRING) ;
		q.addScalar("leadername",Hibernate.STRING) ;
		q.addScalar("excutorname",Hibernate.STRING) ;
		q.addScalar("crtdate",Hibernate.STRING) ;
		q.addScalar("overtime",Hibernate.STRING) ;
        setFetchPoint(q, start, count);
		List<Map<String, String>> result  = q.list();
		
		return result;
	}
	
	/**
	 * ��ѯ��ǰ�����Ѿ���ʱ����ˣ�������־����Ĵ���ʱ��֮��
	 * @param cond ֻ�õ���ʵ��id-wiid
	 * @return
	 */
	public String getTotalExcuteTime(final WorkInstanceSearchCond cond){
		
		Session session = getSession();
		
		String sql = session.getNamedQuery("WorkInstanceDAO.getTotalExcuteTime").getQueryString();
		SQLQuery q = session.createSQLQuery(sql);
		q.setParameter("wiid", cond.getWiid());
		q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		q.addScalar("totaltime",Hibernate.STRING) ;
		List<Map<String, String>> resultMap= q.list();
		String result  = resultMap.get(0).get("totaltime");
		
		return result;
	}
	
	/**
	 * ��ѯ����Ԥ�����ʱ��С�ڵ�ǰʱ�䣬�������й���������
	 * @param 
	 * @return ʱ�����ֵ�Ͷ�Ӧ������id
	 */
    public List<Map<String, String>> getExcutedMaxTime(){
		
		Session session = getSession();
		
		String sql = session.getNamedQuery("WorkInstanceDAO.getExcutedMaxTime").getQueryString();
		SQLQuery q = session.createSQLQuery(sql);
		q.setParameter("currenttime", IGStringUtils.getCurrentDateTime());		
		q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		q.addScalar("wdid",Hibernate.STRING) ;
		q.addScalar("maxovertime",Hibernate.STRING) ;
		List<Map<String, String>> result  = q.list();
		return result;
	}
	
}