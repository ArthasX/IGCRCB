/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.model.dao;

import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.nms.model.NMS03Info;
import com.deliverik.infogovernor.nms.model.condition.NMS03SearchCond;
import com.deliverik.infogovernor.nms.model.entity.NMS03TB;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 发现任务信息实体DAO实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("deprecation")
public class NMS03DAOImpl extends BaseHibernateDAOImpl<NMS03Info> implements NMS03DAO {
	
	/**
	 * 构造方法
	 */
	public NMS03DAOImpl(){
		super(NMS03TB.class);
	}
	
	/**
	 * 最新版本检索
	 * @return 最新版本
	 */
	@SuppressWarnings("unchecked")
	public List<NMS03Info> searchNewest(final NMS03SearchCond cond){
		HibernateCallback action = new HibernateCallback() {
			@SuppressWarnings("rawtypes")
			public Object doInHibernate(Session session) throws HibernateException,
					SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();
				query.append("select * from NMS03 where deleteflag = '0'");
				query.append(" and gid =:gid and version > 0 and version = (select max(version) from NMS03 where gid=:gid) ");
				if(StringUtils.isNotEmpty(cond.getType())) {
					query.append(" and type = :type");
				}
				if(StringUtils.isNotEmpty(cond.getFromIP())) {
					query.append(" and fromIP = :fromIP");
				}
				if(StringUtils.isNotEmpty(cond.getToIP())) {
					query.append(" and toIP = :toIP");
				}
				if(StringUtils.isNotEmpty(cond.getSubNet())) {
					query.append(" and subNet = :subNet");
				}
				SQLQuery q = session.createSQLQuery(query.toString());
				q.setParameter("gid", cond.getGid());
				if(StringUtils.isNotEmpty(cond.getType())) {
					q.setParameter("type", cond.getType());
				}
				if(StringUtils.isNotEmpty(cond.getFromIP())) {
					q.setParameter("fromIP", cond.getFromIP());
				}
				if(StringUtils.isNotEmpty(cond.getToIP())) {
					q.setParameter("toIP", cond.getToIP());
				}
				if(StringUtils.isNotEmpty(cond.getSubNet())) {
					q.setParameter("subNet", cond.getSubNet());
				}
				q.addEntity(type);
				List list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<NMS03Info>) execute(action);
	}
	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(NMS03SearchCond cond){
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
	public List<NMS03Info> findByCond(NMS03SearchCond cond, int start, int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(NMS03SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//组ID
		if(cond.getGid() != null && cond.getGid() > 0){
			c.add(Expression.eq("gid", cond.getGid()));
		}
		//删除标识 
		if( !StringUtils.isEmpty(cond.getDeleteflag())){
			c.add(Expression.eq("deleteflag", cond.getDeleteflag()));
		}
		//任务类型
		if( !StringUtils.isEmpty(cond.getType())){
			c.add(Expression.eq("type", cond.getType()));
		}
		//起始IP
		if( !StringUtils.isEmpty(cond.getFromIP())){
			c.add(Expression.eq("fromIP", cond.getFromIP()));
		}
		//结束IP
		if( !StringUtils.isEmpty(cond.getToIP())){
			c.add(Expression.eq("toIP", cond.getToIP()));
		}
		//子网 
		if( !StringUtils.isEmpty(cond.getSubNet())){
			c.add(Expression.eq("subNet", cond.getSubNet()));
		}
		//版本
		if(cond.getVersion() != null){
			c.add(Expression.eq("version", cond.getVersion()));
		}
		return c;
	}
}
