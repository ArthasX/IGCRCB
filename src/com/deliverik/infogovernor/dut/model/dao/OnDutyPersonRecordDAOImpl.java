/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * ����: �ճ�ά��DAOʵ��
 * ��������: �ճ�ά��DAOʵ��
 * ������¼: 2012/04/01
 * �޸ļ�¼: 
 */
public class OnDutyPersonRecordDAOImpl extends BaseHibernateDAOImpl<OnDutyPersonRecordInfo> implements OnDutyPersonRecordDAO{

    /**
     * ���캯��
     */
    public OnDutyPersonRecordDAOImpl(){
        super(OnDutyPersonRecordTB.class);
    }
    
    /**
     * ȫ������
     * @return ���������
     */
    public List<OnDutyPersonRecordInfo> findAll() {
        DetachedCriteria c = getDetachedCriteria();
        c.addOrder(Order.asc("odprid"));
        List<OnDutyPersonRecordInfo> ret = findByCriteria(c);
        return ret;
    }

    /**
     * ������������
     * @param Odprid ����
     * @return �������
     */
    public OnDutyPersonRecordInfo findByPK(Serializable Odprid) {

        OnDutyPersonRecordInfo result = super.findByPK(Odprid);
        if(result == null) return null;

        return result;
    }

    /**
     * ���������������ȡ��
     * @param cond ��������
     * @return �����������
     */
    public int getSearchCount(final OnDutyPersonRecordSearchCond cond){
        DetachedCriteria c = getCriteria(cond);
        return getCount(c);
    }

    /**
     * ������������
     * @param cond ��������
     * @param start ������¼��ʼ�к�
     * @param count ������¼����
     * @return ��������б�
     */
    public List<OnDutyPersonRecordInfo> findByCond(final OnDutyPersonRecordSearchCond cond, final int start, final int count){
        DetachedCriteria c = getCriteria(cond);
        c.addOrder(Order.asc("odprid"));
        List<OnDutyPersonRecordInfo> ret = findByCriteria(c, start, count);
        return ret;
    }
    
    /**
     * ������������
     * 
     * @param cond ��������
     * @return �����ü���������
     */
    @SuppressWarnings("deprecation")
	protected DetachedCriteria getCriteria(OnDutyPersonRecordSearchCond cond){
        DetachedCriteria c = getDetachedCriteria();
        if(cond.getOdprid_eq()!=null){
            c.add(Expression.eq("odprid", cond.getOdprid_eq()));
        }
        
        //��ѯ������ʼʱ��
        if(!StringUtils.isEmpty(cond.getOdprctime_ge())){
            c.add(Expression.ge("odprctime", cond.getOdprctime_ge()));
        }
        //��ѯ��������ʱ��
        if(!StringUtils.isEmpty(cond.getOdprctime_le())){
            c.add(Expression.le("odprctime", cond.getOdprctime_le()));
        }
        
        return c;
    }

}
