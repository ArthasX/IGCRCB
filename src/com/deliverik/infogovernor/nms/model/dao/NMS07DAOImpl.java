/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.model.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.infogovernor.nms.model.NMS07Info;
import com.deliverik.infogovernor.nms.model.condition.NMS07SearchCond;
import com.deliverik.infogovernor.nms.model.entity.NMS07TB;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMS07DAOImpl extends NMSBaseDAOImpl<NMS07Info> implements NMS07DAO {
	/**
	 * 构造方法
	 */
	public NMS07DAOImpl(){
		super(NMS07TB.class);
	}
	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(NMS07SearchCond cond){
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
	public List<NMS07Info> findByCond(NMS07SearchCond cond, int start, int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}
	
    /**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(NMS07SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if (null != cond.getGid()) {
		    c.add(Restrictions.eq("gid", cond.getGid()));
		}
		if(null != cond.getGversion()){
		    c.add(Restrictions.eq("gversion", cond.getGversion()));
		}
		
		// 过滤黑名单
		if (cond.isFilterBlacklist()) {
		    StringBuffer where_user = new StringBuffer();
		    where_user.append("id=this_.id and NOT EXISTS")
		    .append("(SELECT * FROM nms10 n10 where n10.gid = this_.gid AND n10.gversion = this_.gversion AND n10.fromdid = this_.fromdid AND n10.todid = this_.todid ");
		    
		    if (StringUtils.isNotEmpty(cond.getUserid())) {
		        where_user.append(" and (userid ='" + cond.getUserid() + "' or userid is null or userid = '' )");
		    } else {
		        where_user.append(" and (userid is null or userid = '')");
		    }
		    where_user.append(" ) ");
		    c.add(Restrictions.sqlRestriction(where_user.toString()));
		}
		
		// 合并白名单
		if(cond.isMergeWhitelist()){
		    StringBuffer unionquery = new StringBuffer();
		    unionquery.append("id=this_.id union (select * from nms13 n13 where 1=1 ");
		    if (null != cond.getGid()) {
		        unionquery.append(" and gid = " + cond.getGid() + " ");
	        }
	        if(null != cond.getGversion()){
	            unionquery.append(" and gversion = " + cond.getGversion() + " ");
	        }
	        unionquery.append(") "); 
	        c.add(Restrictions.sqlRestriction(unionquery.toString()));
		}
		return c;
	}
}
