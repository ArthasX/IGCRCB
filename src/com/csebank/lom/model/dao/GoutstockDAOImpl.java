/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.csebank.lom.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.csebank.lom.bl.IGLOMCONSTANTS;
import com.csebank.lom.model.Goutstock;
import com.csebank.lom.model.condition.GoutstockSearchCond;
import com.csebank.lom.model.entity.GoutstockTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
 * 
 * 物品出库信息DAO实现
 *
 */
@SuppressWarnings("deprecation")
public class GoutstockDAOImpl extends BaseHibernateDAOImpl<Goutstock> implements GoutstockDAO {
   
	/**
	 * 构造函数
	 */
	public GoutstockDAOImpl(){
		super(GoutstockTB.class);
	}

	/**
	 * 全件检索
	 * @return 检索结果集
	 */
	public List<Goutstock> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("goid"));
		List<Goutstock> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * 主键检索处理
	 * @param rid 主键
	 * @return 检索结果
	 */
	public Goutstock findByPK(Serializable goid) {

		Goutstock result = super.findByPK(goid);
		if(result == null) return null;

		return result;
	}

	/**
	 * 条件检索结果件数取得
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(final GoutstockSearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * 条件检索处理
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<Goutstock> findByCond(final GoutstockSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("goid"));
		List<Goutstock> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * 检索条件生成
	 * 
	 * @param cond 检索条件
	 * @return 检索用检索条件类
	 */
	protected DetachedCriteria getCriteria(GoutstockSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//物品出库信息ID
		if(cond.getGoid()!=null && cond.getGoid()!=0){
			c.add(Expression.eq("goid", cond.getGoid()));
		}
		//物品种类
		if(StringUtils.isNotEmpty(cond.getGocategory())){
			c.add(Expression.like("gocategory", cond.getGocategory()+"%"));
		}
		
		//物品编号
		if(StringUtils.isNotEmpty(cond.getGocode())){
			c.add(Expression.eq("gocode", cond.getGocode()));
		}
		
		//物品名称
		if(StringUtils.isNotEmpty(cond.getGoname())){
			c.add(Expression.like("goname", "%" +cond.getGoname()+ "%"));
		}
		
		//领用人姓名
		if(StringUtils.isNotEmpty(cond.getGorequsername())){
			c.add(Expression.like("gorequsername", "%" + cond.getGorequsername() + "%"));
		}
			
		//采购申请单批号
		if(StringUtils.isNotEmpty(cond.getGoreqnum())){
			c.add(Expression.eq("goreqnum", cond.getGoreqnum()));
		}
		
		
		//所属机构层次码
		if(StringUtils.isNotEmpty(cond.getGoorg())){
			c.add(Expression.eq("goorg", cond.getGoorg()));
		}

		//领用机构层次码
		if(StringUtils.isNotEmpty(cond.getGoreqorg())){
			c.add(Expression.like("goreqorg", cond.getGoreqorg()+"%"));
		}
		
		//出库状态
		if(StringUtils.isNotEmpty(cond.getGostatus())){
			c.add(Expression.eq("gostatus", cond.getGostatus()));
		}
		
		//出库时间
		if(StringUtils.isNotEmpty(cond.getGotime_f())){
			c.add(Expression.ge("gotime", cond.getGotime_f()+" 00:00"));
		}
		
		//出库时间
		if(StringUtils.isNotEmpty(cond.getGotime_t())){
			c.add(Expression.le("gotime", cond.getGotime_t()+" 23:59"));
		}
		
		//出库类型
		if(StringUtils.isNotEmpty(cond.getGotype())){
			c.add(Expression.eq("gotype", cond.getGotype()));
		}
		
		//接待工作ID
		if(cond.getRid()!=null && cond.getRid()!=0){
			c.add(Expression.eq("rid", cond.getRid()));
		}
		if(cond.isHascategory()){
			c.add(Expression.like("gocategory", IGLOMCONSTANTS.PRESENT_CODE+"%"));
		}
		
		//出库类型
		if(cond.getGotypeList()!=null && cond.getGotypeList().size()>0){
			c.add(Expression.in("gotype", cond.getGotypeList()));
		}
		
		return c;
	}

}
