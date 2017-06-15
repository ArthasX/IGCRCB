/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowConstDefine;
import com.deliverik.framework.workflow.prd.model.IG007Info;
import com.deliverik.framework.workflow.prd.model.condition.IG007SearchCond;
import com.deliverik.framework.workflow.prd.model.entity.IG007TB;

/**
 * <p>概述:流程变量定义信息DAO实现</p>
 * <p>功能描述：1.全件检索</p>
 * <p>          2.主键检索处理</p>
 * <p>          3.条件检索处理</p>
 * <p>          4.检索条件生成</p>
 * <p>          5.条件检索结果件数取得</p>
 * <p>创建记录：</p>
 */
@SuppressWarnings("deprecation")
public class IG007DAOImpl extends
		BaseHibernateDAOImpl<IG007Info> implements IG007DAO {

	/**
	 * 功能：构造函数
	 */
	public IG007DAOImpl() {
		super(IG007TB.class);
	}

	/**
	 * 功能：全件检索
	 * @return 检索结果集
	 */
	public List<IG007Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("pidsortid"));
		c.addOrder(Order.asc("pidid"));
		List<IG007Info> ret = findByCriteria(c);
		return ret;
	}

	/**
	 * 功能：主键检索处理
	 * @param prid 主键
	 * @return 检索结果
	 */
	public IG007Info findByPK(Serializable prid) {

		IG007Info pr = super.findByPK(prid);
		if (pr == null)
			return null;

		return pr;
	}

	/**
	 * 功能：条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG007Info> findByCond(final IG007SearchCond cond,
			final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		if(StringUtils.isNotEmpty(cond.getIsExport())){
			c.addOrder(Order.asc("pidid"));
			c.addOrder(Order.asc("pidsortid"));
		}else{
			c.addOrder(Order.asc("pidsortid"));
			c.addOrder(Order.asc("pidid"));
		}
		List<IG007Info> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 功能：检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG007SearchCond cond) {
		DetachedCriteria c = getDetachedCriteria();
		if(StringUtils.isNotEmpty(cond.getPidid())){
			c.add(Expression.eq("pidid", cond.getPidid()));
		}
		if (cond.getPidgid() != null && cond.getPidgid() != 0) {
			c.add(Expression.eq("pidgid", cond.getPidgid()));
		}
		if(StringUtils.isNotEmpty(cond.getPdid())){
			c.add(Expression.eq("pdid", cond.getPdid()));
		}
		if(StringUtils.isNotBlank(cond.getPpdid_like())){
			c.add(Expression.like("pdid" , cond.getPpdid_like()+"%"));
		}
		if (!StringUtils.isEmpty(cond.getPidlabel())) {
			c.add(Expression.eq("pidlabel", cond.getPidlabel()));
		}
		if (!StringUtils.isEmpty(cond.getPidname())) {
			c.add(Expression.eq("pidname", cond.getPidname()));
		}
		if (!StringUtils.isEmpty(cond.getPidtype())) {
			c.add(Expression.eq("pidtype", cond.getPidtype()));
		}
		if (!StringUtils.isEmpty(cond.getPidrequired())) {
			c.add(Expression.eq("pidrequired", cond.getPidrequired()));
		}
		if (!StringUtils.isEmpty(cond.getPidname_like())) {
			c.add(Expression.like("pidname", "%"+cond.getPidname_like()+"%"));
		}
		if (!StringUtils.isEmpty(cond.getPidmode())) {
			c.add(Expression.eq("pidmode", cond.getPidmode()));
		}
		if (!StringUtils.isEmpty(cond.getIsDefault())) {
			if(WorkFlowConstDefine.YES.equals(cond.getIsDefault())) {
				c.add(Expression.eq("pidtype", WorkFlowConstDefine.DEFAULT_PID_TYPE));
			}else if(WorkFlowConstDefine.NO.equals(cond.getIsDefault())) {
				c.add(Expression.ne("pidtype", WorkFlowConstDefine.DEFAULT_PID_TYPE));
			}
		}
		if(StringUtils.isNotEmpty(cond.getPidid_notlike())){
			c.add(Expression.ne("pidid", cond.getPidid_notlike()));
		}
		if(StringUtils.isNotEmpty(cond.getPidid_like())){
			c.add(Expression.like("pidid", cond.getPidid_like() + "%"));
		}
		
		if(cond.getPidtypes()!=null&&cond.getPidtypes().length>0){
			c.add(Expression.in("pidtype", cond.getPidtypes()));
		}
		
		if(StringUtils.isNotEmpty(cond.getTableColumn())){
			if("Y".equals(cond.getTableColumn())){
				c.add(Expression.isNotNull("ppidid"));
			}else{
				c.add(Expression.isNull("ppidid"));
			}
		}
		if (StringUtils.isNotEmpty(cond.getPpidid())) {
			c.add(Expression.eq("ppidid", cond.getPpidid()));
		}
		if (StringUtils.isNotEmpty(cond.getPiduse())) {
			c.add(Expression.eq("piduse", cond.getPiduse()));
		}
		return c;
	}

	/**
	 * 功能：条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG007SearchCond cond) {
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}
	
	/**
	 * PIDID主键值取得
	 * 
	 * @param 流程定义ID
	 * @return PIDID主键值
	 */
	@SuppressWarnings("rawtypes")
	public String getPididSequenceNextValue(String pdid) {
		String sql =  "SELECT MAX(pid.pidid) FROM IG007TB pid WHERE pid.pidid LIKE :pdid";
		NamedParamMap p = getNamedParamMap();
		p.setString("pdid", pdid + "%");
		List l = findByNamedParamMap(sql, p);
		if( l.size() == 0 || StringUtils.isEmpty((String)l.get(0))) {
			return pdid + StringUtils.leftPad("1", IGPRDCONSTANTS.ID_SUFFIX_LENGTH, "0");
		} else {
			String id = (String)l.get(0);
			return pdid + StringUtils.leftPad((Integer.parseInt(id.replaceFirst(pdid, "")) + 1) + "", IGPRDCONSTANTS.ID_SUFFIX_LENGTH, "0"); 
		}
	}

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	@SuppressWarnings("unchecked")
	public List<IG007Info> findByCondRun(final IG007SearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append(session.getNamedQuery("IG007DAO.findByCondRun1").getQueryString());
				query.append(" ").append(cond.getPsdid_like()).append(" ");
				query.append(session.getNamedQuery("IG007DAO.findByCondRun2").getQueryString());
				query.append(" ").append(cond.getPsdid_like()).append(" ");
				query.append(session.getNamedQuery("IG007DAO.findByCondRun3").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setString("pdid", cond.getPdid());
				setFetchPoint(q, 0, 0);
				q.addEntity("pi", IG007TB.class);
				List<IG007Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<IG007Info>) execute(action);
	}
}
