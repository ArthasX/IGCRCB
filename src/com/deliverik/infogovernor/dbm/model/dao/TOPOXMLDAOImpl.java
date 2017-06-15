/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.dbm.model.dao;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.HibernateException;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.springframework.orm.hibernate3.HibernateCallback;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.dbm.model.TOPOXMLInfo;
import com.deliverik.infogovernor.dbm.model.condition.TOPOXMLSearchCond;
import com.deliverik.infogovernor.dbm.model.entity.TOPOXMLTB;

/**
  * ����: TOPOXMLDAOʵ��
  * ��������: TOPOXMLDAOʵ��
  * ������¼: 2012/10/31
  * �޸ļ�¼: 
  */
public class TOPOXMLDAOImpl extends
		BaseHibernateDAOImpl<TOPOXMLInfo> implements TOPOXMLDAO {

	/**
	 * ���캯��
	 */
	public TOPOXMLDAOImpl(){
		super(TOPOXMLTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<TOPOXMLInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public TOPOXMLInfo findByPK(Serializable pk) {
		TOPOXMLInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final TOPOXMLSearchCond cond){
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
	public List<TOPOXMLInfo> findByCond(final TOPOXMLSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(TOPOXMLSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();

		if(StringUtils.isNotEmpty(cond.getUserid())){
			c.add(Expression.eq("userid", cond.getUserid() ));
		}
		if(StringUtils.isNotEmpty(cond.getIsellipsis())){
			c.add(Expression.eq("isellipsis", cond.getIsellipsis() ));
		}
		return c;
	}
	/**
	 * �����û�ɾ������
	 * @param userid �û�ID
	 * */
	public boolean deleteTOPOXMLByUserid(final String userid){
		HibernateCallback action=new HibernateCallback(){
			public Object doInHibernate(Session session) throws HibernateException,SQLException{
				session.flush();
				StringBuffer sb=new StringBuffer();
				sb.append("delete from topoxml where userid='"+userid+"'");
				SQLQuery q=session.createSQLQuery(sb.toString());
				q.executeUpdate();
				return true;
			}
		};
		
		return (Boolean)execute(action);
	}

}