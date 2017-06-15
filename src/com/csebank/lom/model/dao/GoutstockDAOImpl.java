/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
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
 * ��Ʒ������ϢDAOʵ��
 *
 */
@SuppressWarnings("deprecation")
public class GoutstockDAOImpl extends BaseHibernateDAOImpl<Goutstock> implements GoutstockDAO {
   
	/**
	 * ���캯��
	 */
	public GoutstockDAOImpl(){
		super(GoutstockTB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<Goutstock> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("goid"));
		List<Goutstock> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param rid ����
	 * @return �������
	 */
	public Goutstock findByPK(Serializable goid) {

		Goutstock result = super.findByPK(goid);
		if(result == null) return null;

		return result;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final GoutstockSearchCond cond){
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
	public List<Goutstock> findByCond(final GoutstockSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("goid"));
		List<Goutstock> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(GoutstockSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//��Ʒ������ϢID
		if(cond.getGoid()!=null && cond.getGoid()!=0){
			c.add(Expression.eq("goid", cond.getGoid()));
		}
		//��Ʒ����
		if(StringUtils.isNotEmpty(cond.getGocategory())){
			c.add(Expression.like("gocategory", cond.getGocategory()+"%"));
		}
		
		//��Ʒ���
		if(StringUtils.isNotEmpty(cond.getGocode())){
			c.add(Expression.eq("gocode", cond.getGocode()));
		}
		
		//��Ʒ����
		if(StringUtils.isNotEmpty(cond.getGoname())){
			c.add(Expression.like("goname", "%" +cond.getGoname()+ "%"));
		}
		
		//����������
		if(StringUtils.isNotEmpty(cond.getGorequsername())){
			c.add(Expression.like("gorequsername", "%" + cond.getGorequsername() + "%"));
		}
			
		//�ɹ����뵥����
		if(StringUtils.isNotEmpty(cond.getGoreqnum())){
			c.add(Expression.eq("goreqnum", cond.getGoreqnum()));
		}
		
		
		//�������������
		if(StringUtils.isNotEmpty(cond.getGoorg())){
			c.add(Expression.eq("goorg", cond.getGoorg()));
		}

		//���û��������
		if(StringUtils.isNotEmpty(cond.getGoreqorg())){
			c.add(Expression.like("goreqorg", cond.getGoreqorg()+"%"));
		}
		
		//����״̬
		if(StringUtils.isNotEmpty(cond.getGostatus())){
			c.add(Expression.eq("gostatus", cond.getGostatus()));
		}
		
		//����ʱ��
		if(StringUtils.isNotEmpty(cond.getGotime_f())){
			c.add(Expression.ge("gotime", cond.getGotime_f()+" 00:00"));
		}
		
		//����ʱ��
		if(StringUtils.isNotEmpty(cond.getGotime_t())){
			c.add(Expression.le("gotime", cond.getGotime_t()+" 23:59"));
		}
		
		//��������
		if(StringUtils.isNotEmpty(cond.getGotype())){
			c.add(Expression.eq("gotype", cond.getGotype()));
		}
		
		//�Ӵ�����ID
		if(cond.getRid()!=null && cond.getRid()!=0){
			c.add(Expression.eq("rid", cond.getRid()));
		}
		if(cond.isHascategory()){
			c.add(Expression.like("gocategory", IGLOMCONSTANTS.PRESENT_CODE+"%"));
		}
		
		//��������
		if(cond.getGotypeList()!=null && cond.getGotypeList().size()>0){
			c.add(Expression.in("gotype", cond.getGotypeList()));
		}
		
		return c;
	}

}
