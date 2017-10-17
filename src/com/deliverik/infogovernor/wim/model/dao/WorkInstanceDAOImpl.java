/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
  * 概述: 工作实例DAO实现
  * 功能描述: 工作实例DAO实现
  * 创建记录: 2017/06/09
  * 修改记录: 
  */
public class WorkInstanceDAOImpl extends
		BaseHibernateDAOImpl<WorkInstanceInfo> implements WorkInstanceDAO {

	/**
	 * 构造函数
	 */
	public WorkInstanceDAOImpl(){
		super(WorkInstanceTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<WorkInstanceInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public WorkInstanceInfo findByPK(Serializable pk) {
		WorkInstanceInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final WorkInstanceSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<WorkInstanceInfo> findByCond(final WorkInstanceSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}
	/**
	 * 查询工作
	 * @param cond
	 * @param start
	 * @param count
	 * @return
	 */
	@SuppressWarnings({ "unchecked"})
	public List<Map<String,String>> findWeekWorkByCond(final WorkInstanceSearchCond cond, final int start, final int count){
		
		Session session = getSession();
		String sql = "";
		if(StringUtils.isNotEmpty(cond.getUserid())){
			sql = session.getNamedQuery("WorkInstanceDAO.findWeekWorkByCond").getQueryString();
		}else{
			sql = session.getNamedQuery("WorkInstanceDAO.findWeekWorkByCondAll").getQueryString();
		}
		
		SQLQuery q = session.createSQLQuery(sql);
		//工作日期查询条件 必填
		String workDate = cond.getWorkDate();
		// 定义输出日期格式
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
		List<Date> days = IGDateUtils.dateToWeek(workDate);
		for (int i= 0; i< days.size();i++) {
			q.setParameter("week"+(i+1), sdf.format(days.get(i)));
		}
		if(StringUtils.isNotEmpty(cond.getUserid())){
			q.setParameter("leaderid", cond.getUserid()+"%");
			q.setParameter("userid",cond.getUserid());
			q.setParameter("excutorid","%"+ cond.getUserid()+"%");
		}else{
			q.setParameter("curruserid", cond.getLogin_userid());
			q.setParameter("orgid", cond.getOrgsyscoding());
		}
		
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
	 * @Description 检索工作实例提醒数据集
	 * @author WangLiang
	 * @return 工作实例信息集合
	 */
	@SuppressWarnings({"unchecked" })
	public List<WorkInstanceInfo> findInstanceTips(){
		HibernateCallback action = new HibernateCallback() {

			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();

				StringBuffer query = new StringBuffer();
				
				query.append("SELECT * FROM WORKINSTANCE WHERE WISTATUS ='未执行' OR WISTATUS = '执行中'");
				
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
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(WorkInstanceSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//工作项定义id
		if(cond.getWdid()!=null && cond.getWdid()!=0){
			c.add(Restrictions.eq("wdid", cond.getWdid()));
		}
		
		//工作实例名称
		if(StringUtils.isNotEmpty(cond.getWiname())){
			c.add(Restrictions.like("winame", ""+cond.getWiname()+""));
		}
		
		//工作状态（0，未执行；1，执行中，2，已执行；3，结束；4，中止；）
		if(StringUtils.isNotEmpty(cond.getWistatus())){
			c.add(Restrictions.eq("wistatus", ""+cond.getWistatus()+""));
		}
		
		
		//发起类型（1，自动发起；2，手动发起）
		if(StringUtils.isNotEmpty(cond.getWiLunchType())){
			c.add(Restrictions.eq("wiLunchType", cond.getWiLunchType()));
		}
		
		//执行需所时间（小时）
		if(StringUtils.isNotEmpty(cond.getExcuteTime())){
			c.add(Restrictions.eq("excuteTime", cond.getExcuteTime()));
		}
		
		//开始日期
		if(StringUtils.isNotEmpty(cond.getBeginDate())){
			c.add(Restrictions.like("beginDate", cond.getBeginDate()+"%"));
		}
		
		//工作确认日期
		if(StringUtils.isNotEmpty(cond.getConfirmDate())){
			c.add(Restrictions.like("confirmDate", cond.getConfirmDate()+"%"));
		}
		
		//日期栏日期
		if(StringUtils.isNotEmpty(cond.getTitleDate())){
			c.add(Restrictions.like("titleDate", cond.getTitleDate()+"%"));
		}
		
		//表记录创建
		if(StringUtils.isNotEmpty(cond.getCrtDate())){
			c.add(Restrictions.like("crtDate", cond.getCrtDate()+"%"));
		}
		
		return c;
	}
	
	
	/**
	 * 工作信息统计查询
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings({ "unchecked"})
	public List<Map<String,String>> findCountSearch(final WorkInstanceSearchCond cond, final int start, final int count){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session)
					throws HibernateException, SQLException {
				
				session.flush();
				StringBuffer sql = new StringBuffer(); 
				sql.append(session.getNamedQuery("WorkInstanceDAO.countSearch").getQueryString());
				//组合查询条件
				getSQL(cond,sql);
				//加入排序 按发起时间倒叙 后 按日期栏日期正序
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
	 * 检索条件生成
	 * 
	 * @param cond检索条件
	 * @return 检索用检索条件类
	 */
	protected void getSQL(WorkInstanceSearchCond cond,StringBuffer sql) {
		
		//工作名称
		if(StringUtils.isNotEmpty(cond.getWdname())) {
			sql.append(" AND WDNAME like '%"+cond.getWdname()+"%' ");
		}
		
		//周期
		if(StringUtils.isNotEmpty(cond.getCycle())) {
			sql.append(" AND CYCLE = '"+cond.getCycle()+"' ");
		}
		
		//工作状态
		if(StringUtils.isNotEmpty(cond.getWistatus())) {
			sql.append(" AND WISTATUS = '"+cond.getWistatus()+"' ");
		}
		
		//发起人
		if(StringUtils.isNotEmpty(cond.getInitiatorId())) {
			sql.append(" AND INITIATORID like '%"+cond.getInitiatorId()+"%' ");
		}
		
		//负责人
		if(StringUtils.isNotEmpty(cond.getLeaderName())) {
			sql.append(" AND LEADERNAME like '%"+cond.getLeaderName()+"%' ");
		}
		
		//执行人
		if(StringUtils.isNotEmpty(cond.getExcutorName())) {
			sql.append(" AND win.EXCUTORNAME like '%"+cond.getExcutorName()+"%' ");
		}

		//工作开始日期从
		if(StringUtils.isNotEmpty(cond.getBegindate_from())) {
			sql.append(" AND BEGINDATE >= '"+cond.getBegindate_from()+" 00:00'");
		}
		
		//工作开始日期到
		if(StringUtils.isNotEmpty(cond.getBegindate_to())) {
			sql.append(" AND BEGINDATE <= '"+cond.getBegindate_to()+" 99:99'");
		}
	}
	/**
	 * 首页查询当日之前没有处理的工作
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
		//执行人为自己
		q.setParameter("excutorid", "%"+cond.getUserid()+"%");
		q.setParameter("leaderid", cond.getUserid());
		//当日工作，时间为today
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
	 * 查询当日之前没有处理的工作
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
		//执行人为自己
		q.setParameter("excutorid", "%"+cond.getUserid()+"%");
		//当日工作，时间为today
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
	 * 查询当前工作已经用时多久了，所有日志里填的处理时间之和
	 * @param cond 只用到了实例id-wiid
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
	 * 查询所有预计完成时间小于当前时间，并且所有工作都结束
	 * @param 
	 * @return 时间最大值和对应工作项id
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