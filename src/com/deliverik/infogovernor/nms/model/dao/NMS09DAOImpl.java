/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.model.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.nms.model.NMS09Info;
import com.deliverik.infogovernor.nms.model.condition.NMS09SearchCond;
import com.deliverik.infogovernor.nms.model.entity.NMS09TB;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 用户拓扑视图信息实体DAO实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMS09DAOImpl extends BaseHibernateDAOImpl<NMS09Info> implements NMS09DAO {
	/**
	 * 构造方法
	 */
	public NMS09DAOImpl(){
		super(NMS09TB.class);
	}
	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(NMS09SearchCond cond){
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
	public List<NMS09Info> findByCond(NMS09SearchCond cond, int start, int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(NMS09SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		// 组ID
		if(null != cond.getGid_eq()){
		    c.add(Restrictions.eq("gid", cond.getGid_eq()));
		}
		
		// 组版本
		if(null != cond.getGversion_eq()){
		    c.add(Restrictions.eq("gversion", cond.getGversion_eq()));
		}
		
		// 用户ID
		if(StringUtils.isNotEmpty(cond.getUserid_eq())){
		    c.add(Restrictions.eq("userid", cond.getUserid_eq()));
		}
		
		// 用户ID为空
		if(true == cond.isUseridEmpty()){
		    c.add(Restrictions.or(Restrictions.eq("userid", ""), Restrictions.isNull("userid")));
		}
		
		if (StringUtils.isNotEmpty(cond.getShowtype())) {
		    if("1".equals(cond.getShowtype())){
		        c.add(Restrictions.sqlRestriction(" (showtype = '1' or showtype = '' or showtype is null) "));
		    } else {
		        c.add(Restrictions.eq("showtype", "2"));
		    }
		}
		return c;
	}
}
