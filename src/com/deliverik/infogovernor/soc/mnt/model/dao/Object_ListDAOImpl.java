/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.infogovernor.soc.mnt.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.mnt.model.Object_ListInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.Object_ListSearchCond;
import com.deliverik.infogovernor.soc.mnt.model.entity.Object_ListTB;

/**
  * 概述: 对象集合表DAO实现
  * 功能描述: 对象集合表DAO实现
  * 创建记录: 2012/05/11
  * 修改记录: 
  */
@SuppressWarnings("deprecation")
public class Object_ListDAOImpl extends
		BaseHibernateDAOImpl<Object_ListInfo> implements Object_ListDAO {

	/**
	 * 构造函数
	 */
	public Object_ListDAOImpl(){
		super(Object_ListTB.class);
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<Object_ListInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public Object_ListInfo findByPK(Serializable pk) {
		Object_ListInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final Object_ListSearchCond cond){
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
	public List<Object_ListInfo> findByCond(final Object_ListSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(Object_ListSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//序列号等于
		if(StringUtils.isNotEmpty(cond.getDataId())){
			c.add(Expression.eq("dataId", cond.getDataId()));
		}
		//组件类比
		//如果等于system为""无对象，如果等于其他，则查询数组
		if(cond.getObject_Type()!=null){
			if("".equals(cond.getObject_Type())){
				c.add(Expression.eq("object_Type",cond.getObject_Type()));
			}else{
				String[] nameArr=cond.getObject_Type().split(",");
				c.add(Expression.in("object_Type", nameArr));
			}
		}
		return c;
	}

}