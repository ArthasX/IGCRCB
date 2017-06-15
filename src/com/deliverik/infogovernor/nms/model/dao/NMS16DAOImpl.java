/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.model.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.infogovernor.nms.model.NMS16Info;
import com.deliverik.infogovernor.nms.model.condition.NMS16SearchCond;
import com.deliverik.infogovernor.nms.model.entity.NMS16TB;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: 组设备坐标信息实体DAO实现
 * </p>
 * 
 * @version 1.0
 */
public class NMS16DAOImpl extends NMSBaseDAOImpl<NMS16Info> implements NMS16DAO {
	
	/**
	 * 构造方法
	 */
	public NMS16DAOImpl(){
		super(NMS16TB.class);
	}
	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(NMS16SearchCond cond){
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
	public List<NMS16Info> findByCond(NMS16SearchCond cond, int start, int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(NMS16SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		// 组id
		if (null != cond.getGid()) {
		    c.add(Restrictions.eq("gid", cond.getGid()));
		}
		// 组版本
		if (null != cond.getGversion()) {
		    c.add(Restrictions.eq("gversion", cond.getGversion()));
		}
		// 设备id
		if (null != cond.getDid()) {
//		    c.add(Restrictions.eq("did", cond.getDid()));
		    c.add(Restrictions.sqlRestriction("did = '" + cond.getDid() + "' "));
		}
		// 用户id
		if(StringUtils.isNotEmpty(cond.getUserid())){
//		    c.add(Restrictions.eq("userid", cond.getUserid()));
		    c.add(Restrictions.sqlRestriction("userid = '" + cond.getUserid() + "' "));
		}
		// 用户id为空
		if(cond.isUseridEmpty()){
		    c.add(Restrictions.sqlRestriction("id=this_.id and (userid = '' or userid is null) "));
		}
		
		// 拓扑展现类型
		if(StringUtils.isNotEmpty(cond.getType())){
		    c.add(Restrictions.eq("showtype", "'" + cond.getType() + "'"));
		}
		return c;
	}
}
