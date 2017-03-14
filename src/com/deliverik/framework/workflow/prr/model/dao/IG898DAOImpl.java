/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.workflow.prr.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.workflow.prr.model.IG898Info;
import com.deliverik.framework.workflow.prr.model.condition.IG898SearchCond;
import com.deliverik.framework.workflow.prr.model.entity.IG898TB;

/**
  * ����: ������ֵ��DAOʵ��
  * ��������: ������ֵ��DAOʵ��
  * ������¼: 2013/06/25
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class IG898DAOImpl extends
		BaseHibernateDAOImpl<IG898Info> implements IG898DAO {

	/**
	 * ���캯��
	 */
	public IG898DAOImpl(){
		super(IG898TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG898Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG898Info findByPK(Serializable pk) {
		IG898Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG898SearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG898Info> findByCond(final IG898SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("pvrownumber"));
		return findByCriteria(c, start, count);
	}

	/**
     * ȡ�ñ�����ͱ�������
     *
     * @param cond ��������
     * @return ��������
     */
    @SuppressWarnings("rawtypes")
	public int getTableRowCount(final IG898SearchCond cond){
        String sql =  "select max(pvrownumber) from IG898TB where prid=:prid and pidname=:pidname";
        NamedParamMap paramMap = getNamedParamMap();
        paramMap.setInteger("prid", cond.getPrid());
        paramMap.setString("pidname", cond.getPidname());
        List resultList = findByNamedParamMap(sql, paramMap);
        if (resultList.size() == 0) 
            return 0;
        return Integer.parseInt((String)resultList.get(0));
    }
    
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(IG898SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getPrid() != null && cond.getPrid() > 0){
			c.add(Expression.eq("prid", cond.getPrid()));
		}
		if(StringUtils.isNotEmpty(cond.getPidid())){
			c.add(Expression.eq("pidid", cond.getPidid()));
		}
		if(StringUtils.isNotEmpty(cond.getRownumber())){
			c.add(Expression.eq("pvrownumber", cond.getRownumber()));
		}
		if(StringUtils.isNotEmpty(cond.getPvcolname())){
			c.add(Restrictions.eq("pvcolname", cond.getPvcolname()));
		}
		return c;
	}

}