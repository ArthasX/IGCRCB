/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.dut.model.OnDutyPersonRecordInfo;
import com.deliverik.infogovernor.dut.model.condition.OnDutyPersonRecordSearchCond;
import com.deliverik.infogovernor.dut.model.entity.OnDutyPersonRecordTB;

/**
 * 概述: 日常维护DAO实现
 * 功能描述: 日常维护DAO实现
 * 创建记录: 2012/04/01
 * 修改记录: 
 */
public class OnDutyPersonRecordDAOImpl extends BaseHibernateDAOImpl<OnDutyPersonRecordInfo> implements OnDutyPersonRecordDAO{

    /**
     * 构造函数
     */
    public OnDutyPersonRecordDAOImpl(){
        super(OnDutyPersonRecordTB.class);
    }
    
    /**
     * 全件检索
     * @return 检索结果集
     */
    public List<OnDutyPersonRecordInfo> findAll() {
        DetachedCriteria c = getDetachedCriteria();
        c.addOrder(Order.asc("odprid"));
        List<OnDutyPersonRecordInfo> ret = findByCriteria(c);
        return ret;
    }

    /**
     * 主键检索处理
     * @param Odprid 主键
     * @return 检索结果
     */
    public OnDutyPersonRecordInfo findByPK(Serializable Odprid) {

        OnDutyPersonRecordInfo result = super.findByPK(Odprid);
        if(result == null) return null;

        return result;
    }

    /**
     * 条件检索结果件数取得
     * @param cond 检索条件
     * @return 检索结果件数
     */
    public int getSearchCount(final OnDutyPersonRecordSearchCond cond){
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
    public List<OnDutyPersonRecordInfo> findByCond(final OnDutyPersonRecordSearchCond cond, final int start, final int count){
        DetachedCriteria c = getCriteria(cond);
        c.addOrder(Order.asc("odprid"));
        List<OnDutyPersonRecordInfo> ret = findByCriteria(c, start, count);
        return ret;
    }
    
    /**
     * 检索条件生成
     * 
     * @param cond 检索条件
     * @return 检索用检索条件类
     */
    @SuppressWarnings("deprecation")
	protected DetachedCriteria getCriteria(OnDutyPersonRecordSearchCond cond){
        DetachedCriteria c = getDetachedCriteria();
        if(cond.getOdprid_eq()!=null){
            c.add(Expression.eq("odprid", cond.getOdprid_eq()));
        }
        
        //查询条件开始时间
        if(!StringUtils.isEmpty(cond.getOdprctime_ge())){
            c.add(Expression.ge("odprctime", cond.getOdprctime_ge()));
        }
        //查询条件结束时间
        if(!StringUtils.isEmpty(cond.getOdprctime_le())){
            c.add(Expression.le("odprctime", cond.getOdprctime_le()));
        }
        
        return c;
    }

}
