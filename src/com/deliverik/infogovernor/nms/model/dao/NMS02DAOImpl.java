/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.nms.model.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.nms.model.NMS02Info;
import com.deliverik.infogovernor.nms.model.condition.NMS02SearchCond;
import com.deliverik.infogovernor.nms.model.entity.NMS02TB;

/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description: SNMP参数信息DAO实现
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("deprecation")
public class NMS02DAOImpl extends BaseHibernateDAOImpl<NMS02Info> implements NMS02DAO {
	/**
	 * 构造方法
	 */
	public NMS02DAOImpl(){
		super(NMS02TB.class);
	}
	
	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(NMS02SearchCond cond){
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
	public List<NMS02Info> findByCond(NMS02SearchCond cond, int start, int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(NMS02SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//删除标识 
		if( !StringUtils.isEmpty(cond.getDeleteflag())){
			c.add(Expression.eq("deleteflag", cond.getDeleteflag()));
		}
		//SNMP版本
		if(cond.getSnmpVersion() != null && cond.getSnmpVersion() > 0){
			c.add(Expression.eq("snmpVersion", cond.getSnmpVersion()));
		}
		//端口
		if(cond.getSnmpPort() != null && cond.getSnmpPort() > 0){
			c.add(Expression.eq("snmpPort", cond.getSnmpPort()));
		}
		//读取团体字
		if( !StringUtils.isEmpty(cond.getReadCommit())){
			c.add(Expression.eq("readCommit", cond.getReadCommit()));
		}
		//V3安全用户
		if( !StringUtils.isEmpty(cond.getSnmpUser())){
			c.add(Expression.eq("snmpUser", cond.getSnmpUser()));
		}
		//V3身份验证密码
		if( !StringUtils.isEmpty(cond.getSnmpPassword())){
			c.add(Expression.eq("snmpPassword", cond.getSnmpPassword()));
		}
		return c;
	}
}
