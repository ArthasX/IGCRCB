/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.model.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.nms.model.NMS10Info;
import com.deliverik.infogovernor.nms.model.condition.NMS10SearchCond;
import com.deliverik.infogovernor.nms.model.entity.NMS10TB;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 链路黑名单DAO实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("deprecation")
public class NMS10DAOImpl extends BaseHibernateDAOImpl<NMS10Info> implements NMS10DAO {
	/**
	 * 构造方法
	 */
	public NMS10DAOImpl(){
		super(NMS10TB.class);
	}
	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(NMS10SearchCond cond){
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
	public List<NMS10Info> findByCond(NMS10SearchCond cond, int start, int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(NMS10SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getGid() != null && cond.getGid() > 0){
			c.add(Expression.eq("gid", cond.getGid()));
		}
		if(cond.getGversion() != null && cond.getGversion() > 0){
			c.add(Expression.eq("gversion", cond.getGversion()));
		}
		return c;
	}
}
