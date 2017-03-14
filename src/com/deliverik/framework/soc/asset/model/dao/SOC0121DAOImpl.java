/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.model.dao;

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
import com.deliverik.framework.soc.asset.model.SOC0121Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0121SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0121TB;

/**
  * ����: ���չ�ϵ��DAOʵ��
  * ��������: ���չ�ϵ��DAOʵ��
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class SOC0121DAOImpl extends
		BaseHibernateDAOImpl<SOC0121Info> implements SOC0121DAO {

	/**
	 * ���캯��
	 */
	public SOC0121DAOImpl(){
		super(SOC0121TB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0121Info> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0121Info findByPK(Serializable pk) {
		SOC0121Info result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SOC0121SearchCond cond){
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
	public List<SOC0121Info> findByCond(final SOC0121SearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SOC0121SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//��ID
		if (StringUtils.isNotEmpty(cond.getSrdomainid_eq())) {
			c.add(Expression.eq("srdomainid", Integer.parseInt(cond.getSrdomainid_eq())));
		}
		//��汾
		if (StringUtils.isNotEmpty(cond.getSrdomainversion_eq())) {
			c.add(Expression.eq("srdomainversion", Integer.parseInt(cond.getSrdomainversion_eq())));
		}
		//ɾ����־
		if (StringUtils.isNotEmpty(cond.getDeleteflag_eq())) {
			c.add(Expression.eq("deleteflag", cond.getDeleteflag_eq()));
		}
		//Դ�ʲ�ID
		if(StringUtils.isNotEmpty(cond.getSrpareiid_eq())){
			c.add(Expression.eq("srpareiid", Integer.parseInt(cond.getSrpareiid_eq())));
		}
		//Դ�ʲ���汾
		if(StringUtils.isNotEmpty(cond.getSrparversion_eq())){
			c.add(Expression.eq("srparversion", Integer.parseInt(cond.getSrparversion_eq())));
		}
		//Դ�ʲ�С�汾
		if(StringUtils.isNotEmpty(cond.getSrparsmallversion_eq())){
			c.add(Expression.eq("srparsmallversion", Integer.parseInt(cond.getSrparsmallversion_eq())));
		}
		//Ŀ���ʲ�ID
		if(StringUtils.isNotEmpty(cond.getSrcldeiid_eq())){
			c.add(Expression.eq("srcldeiid", Integer.parseInt(cond.getSrcldeiid_eq())));
		}
		//Ŀ���ʲ���汾
		if(StringUtils.isNotEmpty(cond.getSrcldversion_eq())){
			c.add(Expression.eq("srcldversion", Integer.parseInt(cond.getSrcldversion_eq())));
		}
		//Ŀ���ʲ�С�汾
		if(StringUtils.isNotEmpty(cond.getSrcldsmallversion_eq())){
			c.add(Expression.eq("srcldsmallversion", Integer.parseInt(cond.getSrcldsmallversion_eq())));
		}
		//����ʱ��
		if(StringUtils.isNotEmpty(cond.getSrcreatetime_eq())){
			c.add(Expression.eq("srcreatetime", cond.getSrcreatetime_eq()));
		}
		//��ϵ����
		if(StringUtils.isNotEmpty(cond.getSrassetrelation_eq())){
			c.add(Expression.eq("srassetrelation", cond.getSrassetrelation_eq()));
		}
		//��չ�㷨����
		if(StringUtils.isNotEmpty(cond.getSrarithmetictype_eq())){
			c.add(Expression.eq("srarithmetictype", cond.getSrarithmetictype_eq()));
		}
		
		if(cond.getSrpareiids()!=null&&cond.getSrpareiids().length>0){
			c.add(Expression.in("srpareiid", cond.getSrpareiids()));
		}
		
		if(cond.getSrcldeiids()!=null&&cond.getSrcldeiids().length>0){
			c.add(Expression.in("srcldeiid", cond.getSrcldeiids()));
		}
		return c;
	}
	
	/**
	 * ��ͼ�����˹�ϵ
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public List<SOC0121Info> searchShowStorageIOSnapshotRelation() {
		HibernateCallback action = new HibernateCallback(){  
			public Object doInHibernate(Session session) throws HibernateException, SQLException {
				session.flush();
				StringBuffer query = new StringBuffer();		
				query.append(session.getNamedQuery("SnapshotRelationDAO.searchShowStorageIOSnapshotRelation").getQueryString());
				SQLQuery q = session.createSQLQuery(query.toString());
				q.addEntity(SOC0121TB.class);
				List<SOC0121Info> list = q.list();
				session.clear();
				return list;
			}
		};
		return (List<SOC0121Info>) execute(action);
	}


}