/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * <p>����:���̼�¼��ͼDAOʵ��</p>
 * <p>����������1.ȫ������</p>
 * <p>          2.������������</p>
 * <p>          3.������������</p>
 * <p>          4.������������</p>
 * <p>          5.���������������ȡ��</p>
 * <p>������¼��</p>
 */
public class IG677DAOImpl extends BaseHibernateDAOImpl<IG677Info> implements IG677DAO {

	/**
	 * ���캯��
	 */
	public IG677DAOImpl(){
		super(IG677VW.class);
	}

	/**
	 * ���ܣ�ȫ������
	 * @return ���������
	 */
	public List<IG677Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.desc("prclosetime"));
		c.addOrder(Order.asc("propentime"));
		List<IG677Info> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ���ܣ�������������
	 * @param processRecordVWPK ����
	 * @return �������
	 */
	public IG677Info findByPK(Serializable processRecordVWPK) {

		IG677Info pr = super.findByPK(processRecordVWPK);
		if(pr == null) return null;

		return pr;
	}

	/**
	 * ���ܣ�������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG677Info> findByCond(final IG677SearchCond cond, final int start, final int count) {
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("prclosetime"));
		c.addOrder(Order.desc("propentime"));
		List<IG677Info> ret = findByCriteria(c, start, count);
		return ret;
	}

	/**
	 * ���ܣ�������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
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
		//����ʱ���(���̹���˵�����ͼ��ʾ����)
		if( !StringUtils.isEmpty(cond.getPrplantime())&& !"wkm".equals(cond.getSelectMode())){
			c.add(Restrictions.ge("prplantime", cond.getPrplantime()));
		}
		//����ʱ����(���̹���˵�����ͼ��ʾ����)
		if( !StringUtils.isEmpty(cond.getPrduration())&& !"wkm".equals(cond.getSelectMode())){
			c.add(Restrictions.le("prplantime", cond.getPrduration()));
		}
		//������ʼʱ���(��������˵�����ͼ��ʾ����)
		if( !StringUtils.isEmpty(cond.getPrplantime()) && "wkm".equals(cond.getSelectMode())){
			c.add(Restrictions.ge("propentime", cond.getPrplantime()));
		}
		//������ʼʱ����(��������˵�����ͼ��ʾ����)
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
	 * ���ܣ����������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final IG677SearchCond cond){
		DetachedCriteria c = getCriteria(cond);
		return getCount(c);
	}
}
