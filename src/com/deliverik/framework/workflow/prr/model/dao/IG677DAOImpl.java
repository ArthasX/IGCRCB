/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG677Info;
import com.deliverik.framework.workflow.prr.model.condition.IG677SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG677VW;

/**
 * <p>概述:流程记录视图DAO实现</p>
 * <p>功能描述：1.全件检索</p>
 * <p>          2.主键检索处理</p>
 * <p>          3.条件检索处理</p>
 * <p>          4.检索条件生成</p>
 * <p>          5.条件检索结果件数取得</p>
 * <p>创建记录：</p>
 */
public class IG677DAOImpl extends BaseHibernateDAOImpl<IG677Info> implements IG677DAO {

	/**
	 * 构造函数
	 */
	public IG677DAOImpl(){
		super(IG677VW.class);
	}

	/**
	 * 功能：全件检索
	 * @return 检索结果集
	 */
	public List<IG677Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.desc("prclosetime"));
		c.addOrder(Order.asc("propentime"));
		List<IG677Info> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 功能：主键检索处理
	 * @param processRecordVWPK 主键
	 * @return 检索结果
	 */
	public IG677Info findByPK(Serializable processRecordVWPK) {

		IG677Info pr = super.findByPK(processRecordVWPK);
		if(pr == null) return null;

		return pr;
	}

	/**
	 * 功能：条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG677Info> findByCond(final IG677SearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("prclosetime"));
		c.addOrder(Order.desc("propentime"));
		List<IG677Info> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 功能：检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(IG677SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(!StringUtils.isEmpty(cond.getPrActive()) && cond.getPrActive().equals("Y")){
			//c.add(Restrictions.ne("prstatus", "C"));
			c.add(Restrictions.isNull("prclosetime"));
		}
		if( !StringUtils.isEmpty(cond.getPrtype())){
			if(cond.getPrtype().equals("P_I")){
				c.add(Restrictions.or(Restrictions.eq("prtype", "I"),Restrictions.eq("prtype", "P")));
			}else{
				c.add(Restrictions.eq("prtype", cond.getPrtype()));
			}
		}
		if(cond.getPrtypes()!=null&&cond.getPrtypes().length>0){
            c.add(Restrictions.in("prtype", cond.getPrtypes()));
        }
		if( !StringUtils.isEmpty(cond.getPrstatus())){
			c.add(Restrictions.eq("prstatus", cond.getPrstatus()));
		}
		
		if( !StringUtils.isEmpty(cond.getPrtype())){
			c.add(Restrictions.eq("prtype", cond.getPrtype()));
		}
		if( !StringUtils.isEmpty(cond.getPpuserid())){
			c.add(Restrictions.eq("ppuserid", cond.getPpuserid()));
		}
		if( !StringUtils.isEmpty(cond.getPpstatus())){
			String status = cond.getPpstatus();
			if(status.length() > 3) {
				if (status.indexOf("_") > -1) {
					c.add(Restrictions.eq("psdid", status.split("_")[0]));
					c.add(Restrictions.eq("psdnum", new Integer(status.split("_")[1])));
				} else {
					c.add(Restrictions.eq("psdid", status));
				}
			} else {
				c.add(Restrictions.eq("ppstatus", status));
			}
		}
		if( cond.getPproleid()!=null&&cond.getPproleid()!=0){
		c.add(Restrictions.eq("pproleid", cond.getPproleid()));
		}
		if(cond.isTodo()){
			c.add(Restrictions.isNull("ppproctime"));
			c.add(Restrictions.eqProperty("prstatus", "ppstatus"));
		}
		if(cond.isToImplement()){
			c.add(Restrictions.isNull("ppproctime"));
		}
		if( !StringUtils.isEmpty(cond.getPropentime())){
			c.add(Restrictions.ge("propentime", cond.getPropentime()));
		}
		if( !StringUtils.isEmpty(cond.getPrclosetime())){
			c.add(Restrictions.le("propentime", cond.getPrclosetime()));
		}
		//发生时间从(流程管理菜单柱形图显示条件)
		if( !StringUtils.isEmpty(cond.getPrplantime())&& !"wkm".equals(cond.getSelectMode())){
			c.add(Restrictions.ge("prplantime", cond.getPrplantime()));
		}
		//发生时间至(流程管理菜单柱形图显示条件)
		if( !StringUtils.isEmpty(cond.getPrduration())&& !"wkm".equals(cond.getSelectMode())){
			c.add(Restrictions.le("prplantime", cond.getPrduration()));
		}
		//工作起始时间从(工作管理菜单柱形图显示条件)
		if( !StringUtils.isEmpty(cond.getPrplantime()) && "wkm".equals(cond.getSelectMode())){
			c.add(Restrictions.ge("propentime", cond.getPrplantime()));
		}
		//工作起始时间至(工作管理菜单柱形图显示条件)
		if( !StringUtils.isEmpty(cond.getPrduration()) && "wkm".equals(cond.getSelectMode())){
			c.add(Restrictions.le("propentime", cond.getPrduration()));
		}
		if (cond.getIsWork()==1) {
			c.add(Restrictions.like("prtype", "W%"));
		}
		if( !StringUtils.isEmpty(cond.getPcode())){
			c.add(Restrictions.eq("pcode", cond.getPcode()));
		}
		if(cond.getPrassetid() != null && cond.getPrassetid() > 0){
			c.add(Restrictions.eq("prassetid", cond.getPrassetid()));
		}
		if( !StringUtils.isEmpty(cond.getPrassetcategory())){
			c.add(Restrictions.eq("prassetcategory", cond.getPrassetcategory()));
		}
		if( !StringUtils.isEmpty(cond.getPpproctime())){
			if("not".equals(cond.getPpproctime())){
				c.add(Restrictions.isNotNull("ppproctime"));
			}else{
				c.add(Restrictions.eq("ppproctime", cond.getPpproctime()));
			}
		}
		if( !StringUtils.isEmpty(cond.getPrserialnum())){
			c.add(Restrictions.eq("prserialnum", cond.getPrserialnum()));
		}
		if( !StringUtils.isEmpty(cond.getPrsubstatus())){
			c.add(Restrictions.eq("prsubstatus", cond.getPrsubstatus()));
		}
		if( !StringUtils.isEmpty(cond.getPrpdid())){
		    c.add(Restrictions.like("prpdid", cond.getPrpdid()+"%"));
		}
		
		if(!StringUtils.isEmpty(cond.getPsdid_eq())){
		    c.add(Restrictions.eq("psdid", cond.getPsdid_eq()));
		}
		if(!StringUtils.isEmpty(cond.getPporgid_eq())){
		    c.add(Restrictions.eq("pporgid", cond.getPporgid_eq()));
		}
		return c;
	}
	
	/**
	 * 功能：条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final IG677SearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}
}
