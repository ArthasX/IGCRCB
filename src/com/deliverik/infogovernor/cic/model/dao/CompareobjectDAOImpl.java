/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.cic.model.dao;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.cic.model.CompareobjectInfo;
import com.deliverik.infogovernor.cic.model.condition.CompareobjectSearchCond;
import com.deliverik.infogovernor.cic.model.entity.CompareobjectTB;

/**
  * ����: �Աȶ���DAOʵ��
  * ��������: �Աȶ���DAOʵ��
  * ������¼: 2014/04/22
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class CompareobjectDAOImpl extends
		BaseHibernateDAOImpl<CompareobjectInfo> implements CompareobjectDAO {

	/**
	 * ���캯��
	 */
	public CompareobjectDAOImpl(){
		super(CompareobjectTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	@Override
	public List<CompareobjectInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	@Override
	public CompareobjectInfo findByPK(Serializable pk) {
		CompareobjectInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CompareobjectSearchCond cond){
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
	public List<CompareobjectInfo> findByCond(final CompareobjectSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(CompareobjectSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		// ���������
		if (null != cond.getFkCrid_eq()) {
		    c.add(Restrictions.eq("fkCrid", cond.getFkCrid_eq()));
		}
		
		// �����汾
		if (null != cond.getCrversion_eq()) {
		    c.add(Restrictions.eq("crversion", cond.getCrversion_eq()));
		}
		return c;
	}
	
	/**
	 * ת�ƶԱȶ��� ��ʷ����
	 * @param crid
	 * @return
	 */
	public boolean toHistory(Integer crid){
		getSession().flush();
		String sql="insert into compareobject_h(cohid,coid,fkcrid,coname,cotarget,cosource,sourceip,targetip,crversion,fingerprint) " +
				"select nextval ('compareobject_h_seq') ,coid,fkcrid,coname,cotarget,cosource,sourceip,targetip,crversion,fingerprint from compareobject where fkcrid= "+crid +";" ;
						
		Query q = getSession().createSQLQuery(sql);
		
		return q.executeUpdate()>0;
	}
	
	/**
	 * ���ݹ���ɾ���Աȶ���
	 * @param crid
	 * @return
	 */
	public boolean delByCrid(Integer crid){
		String sql="delete from compareobject where fkcrid="+crid;
		Query q = getSession().createSQLQuery(sql);
		
		return q.executeUpdate()>0;
	}

}