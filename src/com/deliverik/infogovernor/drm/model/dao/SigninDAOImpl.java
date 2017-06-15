/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.drm.model.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.hibernate.Hibernate;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.hibernate.transform.Transformers;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.drm.model.SigninInfo;
import com.deliverik.infogovernor.drm.model.condition.SigninSearchCond;
import com.deliverik.infogovernor.drm.model.entity.SigninTB;

/**
  * 概述: 签到表DAO实现
  * 功能描述: 签到表DAO实现
  * 创建记录: 2015/03/12
  * 修改记录: 
  */
public class SigninDAOImpl extends
		BaseHibernateDAOImpl<SigninInfo> implements SigninDAO {

	/**
	 * 构造函数
	 */
	public SigninDAOImpl(){
		super(SigninTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	@Override
	public List<SigninInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	@Override
	public SigninInfo findByPK(Serializable pk) {
		SigninInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final SigninSearchCond cond){
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
	public List<SigninInfo> findByCond(final SigninSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		
		c.addOrder(Order.asc("siroleid"));
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(SigninSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if (StringUtils.isNotEmpty(cond.getSiuserid())) {
	        c.add(Restrictions.eq("siuserid", cond.getSiuserid()));
	    }
		if (StringUtils.isNotEmpty(cond.getSiusername())) {
			c.add(Restrictions.eq("siusername", cond.getSiusername()));
		}
		if (StringUtils.isNotEmpty(cond.getSitime())) {
			c.add(Restrictions.eq("sitime", cond.getSitime()));
		}
	    if (cond.getDrillprid()!=null&& !(0 ==cond.getDrillprid().intValue())) {
	        c.add(Restrictions.eq("drillprid", cond.getDrillprid()));
	    }
	    if (cond.getEcprid()!=null&& !(0 ==cond.getEcprid().intValue())) {
	    	c.add(Restrictions.eq("ecprid", cond.getEcprid()));
	    }
	    if (cond.getSceneprid()!=null&& !(0 ==cond.getSceneprid().intValue())) {
	    	c.add(Restrictions.eq("sceneprid", cond.getSceneprid()));
	    }
	    if (cond.getSiid()!=null&& !(0 ==cond.getSiid().intValue())) {
	    	c.add(Restrictions.eq("siid", cond.getSiid()));
	    }
	    if (cond.getSiroleid()!=null&& !(0 ==cond.getSiroleid().intValue())) {
	    	c.add(Restrictions.eq("siroleid", cond.getSiroleid()));
	    }
	    if (cond.getWdc()!=null&& !(0 ==cond.getWdc().intValue())) {
	    	c.add(Restrictions.eq("wdc", cond.getWdc()));
	    }
	    if (cond.getWdp()!=null&& !(0 ==cond.getWdp().intValue())) {
	    	c.add(Restrictions.eq("wdp", cond.getWdp()));
	    }
	    if(cond.getRoleidin()!=null&&cond.getRoleidin().length>0){
			c.add(Restrictions.in("siroleid", cond.getRoleidin()));
		}
		return c;
	}
	/**
	 * 签到信息查询
	 * @param 用户id
	 * @param 流程prid
	 * @param 是否是演练 true 是
	 */
		@SuppressWarnings("unchecked")
		public List<Map<String,Object>> searchSignInList(String userid,Integer prid,boolean isDrill) {
			
			Session session = getSession();
			
			
			String sql = "";
			if(isDrill){
				sql = session.getNamedQuery("signinDAO.searchSigninListForDrill").getQueryString();
			}else{
				sql = session.getNamedQuery("signinDAO.searchSigninListForDirect").getQueryString();
			}
			if(StringUtils.isNotEmpty(userid)){
				
				sql+= "  AND T.SIUSERID = '"+userid+"' ";
			}
			
			if(prid!=null && prid>0){
				sql+= " AND I5.PRID = "+prid;
			}
			
			sql+= " ORDER BY I5.PROPENTIME DESC";
			SQLQuery q = session.createSQLQuery(sql);
			q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			if(isDrill){
				q.addScalar("DRILLPRID", Hibernate.STRING);
			}else{
				q.addScalar("ECPRID", Hibernate.STRING);
			}
			q.addScalar("SIUSERID", Hibernate.STRING);
			q.addScalar("PRID", Hibernate.STRING);
			q.addScalar("PRSTATUS", Hibernate.STRING);
			q.addScalar("PRSUBSTATUS", Hibernate.STRING);
			q.addScalar("PRTITLE", Hibernate.STRING);
			q.addScalar("PROPENTIME", Hibernate.STRING);
			q.addScalar("PRCLOSETIME", Hibernate.STRING);
			q.addScalar("USERNAME", Hibernate.STRING);
			q.addScalar("SIGNINED", Hibernate.STRING);
			q.addScalar("PRSERIALNUM", Hibernate.STRING);
			q.addScalar("PRTYPE", Hibernate.STRING);
			q.addScalar("SITIME", Hibernate.STRING);
			q.addScalar("PRDESC", Hibernate.STRING);
			q.addScalar("PROPENTIME", Hibernate.STRING);
			return q.list();
		}
		/**
		 * dashboard 人员信息初始化信息
		 */
		@SuppressWarnings("unchecked")
		public List<Map<String,Object>> searchSigninInitData(Integer ecprid) {
			
			Session session = getSession();
			
			String sql = "";
			sql = session.getNamedQuery("SigninDAO.searchSigninInitDataByCond").getQueryString();
			
			SQLQuery q = session.createSQLQuery(sql);
			q.setInteger("ECPRID", ecprid);
			
			q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			q.addScalar("SNAME", Hibernate.STRING);
			q.addScalar("TOTALCOUNT", Hibernate.STRING);
			q.addScalar("INCOUNT", Hibernate.STRING);
			return q.list();
		}
		/**
		 * 查询参与人
		 * @param ecprid
		 * @return
		 */
		public List<Map<String,Object>> searchSigninPeopleDataByCond(Integer ecprid){
			Session session = getSession();
			String sql = "";
			sql = session.getNamedQuery("SigninDAO.searchSigninPeopleDataByCond").getQueryString();
			SQLQuery q = session.createSQLQuery(sql);
			q.setInteger("ECPRID", ecprid);
			
			q.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
			q.addScalar("SNAME", Hibernate.STRING);
			q.addScalar("SIGNINED", Hibernate.INTEGER);
			return q.list();
			
		}
		/**
		 * 更新签到表中应急指挥流程prid
		 * @param drillPrid 演练流程id
		 * @param directPrid 应急指挥流程prid
		 * @return
		 */
		public int setDirectPrid(Integer drillPrid,Integer directPrid){
			Session session = getSession();
			String sql = session.getNamedQuery("signinDAO.setDirectPrid").getQueryString();
			SQLQuery q = session.createSQLQuery(sql);
			q.setInteger("ecprid", directPrid);
			q.setInteger("drillprid", drillPrid);
			return q.executeUpdate();
			
		}

		/**
		 * 更新签到表中场景流程prid
		 * @param directPrid 指挥流程prid
		 * @param scenePrid 场景流程prid
		 * @return
		 */
		public int setScenePrid(Integer directPrid,Integer scenePrid){
			
			Session session = getSession();
			String sql = session.getNamedQuery("signinDAO.setScenePrid").getQueryString();
			SQLQuery q = session.createSQLQuery(sql);
			q.setInteger("ecprid", directPrid);
			q.setInteger("sceneprid", scenePrid);
			return q.executeUpdate();
		}

	/**
	 * 更新签到表中场景流程prid
	 * 
	 * @param drillPrid
	 *            演练流程id
	 * @param scenePrid
	 *            场景流程prid
	 * @return
	 */
	public int setScenePridFormDrill(Integer drillPrid, Integer scenePrid) {

		Session session = getSession();
		String sql = session.getNamedQuery("signinDAO.setScenePridFormDrill").getQueryString();
		SQLQuery q = session.createSQLQuery(sql);
		q.setInteger("drillprid", drillPrid);
		q.setInteger("sceneprid", scenePrid);
		return q.executeUpdate();
	}
		
		/**
		 * 还原场景人员信息  删除
		 * @param ecprid
		 */
		public void delWDP (Integer ecprid){
			String sql = " delete from signin where ecprid = :ecprid and WDC is null and WDP is not null";
			Session session = getSession();
			SQLQuery q = session.createSQLQuery(sql);
			q.setInteger("ecprid", ecprid);
			q.executeUpdate();
		}
		/**
		 * 还原场景人员信息  修改
		 * @param ecprid
		 */
		public void updWDP (Integer ecprid){
			String sql = "  update signin set WDP  = null where ecprid = :ecprid and WDC is not null and WDP is not null";
			Session session = getSession();
			SQLQuery q = session.createSQLQuery(sql);
			q.setInteger("ecprid", ecprid);
			q.executeUpdate();
		}
}