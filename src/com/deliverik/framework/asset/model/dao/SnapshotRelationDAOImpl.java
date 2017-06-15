/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.asset.model.SnapshotRelationInfo;
import com.deliverik.framework.asset.model.condition.SnapshotRelationSearchCond;
import com.deliverik.framework.asset.model.entity.SnapshotRelationTB;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;

/**
  * ����: ���չ�ϵ��DAOʵ��
  * ��������: ���չ�ϵ��DAOʵ��
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class SnapshotRelationDAOImpl extends
		BaseHibernateDAOImpl<SnapshotRelationInfo> implements SnapshotRelationDAO {

	/**
	 * ���캯��
	 */
	public SnapshotRelationDAOImpl(){
		super(SnapshotRelationTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SnapshotRelationInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SnapshotRelationInfo findByPK(Serializable pk) {
		SnapshotRelationInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final SnapshotRelationSearchCond cond){
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
	public List<SnapshotRelationInfo> findByCond(final SnapshotRelationSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(SnapshotRelationSearchCond cond){
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
		return c;
	}

}