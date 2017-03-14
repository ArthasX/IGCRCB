/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.mnt.model.Object_ListInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.Object_ListSearchCond;
import com.deliverik.infogovernor.soc.mnt.model.entity.Object_ListTB;

/**
  * ����: ���󼯺ϱ�DAOʵ��
  * ��������: ���󼯺ϱ�DAOʵ��
  * ������¼: 2012/05/11
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class Object_ListDAOImpl extends
		BaseHibernateDAOImpl<Object_ListInfo> implements Object_ListDAO {

	/**
	 * ���캯��
	 */
	public Object_ListDAOImpl(){
		super(Object_ListTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Object_ListInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public Object_ListInfo findByPK(Serializable pk) {
		Object_ListInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final Object_ListSearchCond cond){
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
	public List<Object_ListInfo> findByCond(final Object_ListSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(Object_ListSearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		//���кŵ���
		if(StringUtils.isNotEmpty(cond.getDataId())){
			c.add(Expression.eq("dataId", cond.getDataId()));
		}
		//������
		//�������systemΪ""�޶�������������������ѯ����
		if(cond.getObject_Type()!=null){
			if("".equals(cond.getObject_Type())){
				c.add(Expression.eq("object_Type",cond.getObject_Type()));
			}else{
				String[] nameArr=cond.getObject_Type().split(",");
				c.add(Expression.in("object_Type", nameArr));
			}
		}
		return c;
	}

}