/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.orl.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.orl.model.OrealPMVWInfo;
import com.deliverik.orl.model.condition.OrealPMVWSearchCond;
import com.deliverik.orl.model.entity.OrealPMVW;

/**
 * ������ŷ���ż��ָ����ͼDAOʵ��
 * ����������ŷ���ż��ָ����ͼDAOʵ��
 * �����ˣ�Lu Jiayuan
 * ������¼�� 2014/02/26
 * �޸ļ�¼��
 */
@SuppressWarnings("deprecation")
public class OrealPMVWDAOImpl extends BaseHibernateDAOImpl<OrealPMVWInfo> implements OrealPMVWDAO {

	/**
	 * ���캯��
	 */
	public OrealPMVWDAOImpl(){
		super(OrealPMVW.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<OrealPMVWInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public OrealPMVWInfo findByPK(Serializable pk) {
		OrealPMVWInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 * @throws BLException 
	 */
	public int getSearchCount(final OrealPMVWSearchCond cond) throws BLException{
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
	 * @throws BLException 
	 */
	public List<OrealPMVWInfo> findByCond(final OrealPMVWSearchCond cond, final int start, final int count) throws BLException{
		DetachedCriteria c = getCriteria(cond);
		
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 * @throws BLException 
	 */
	protected DetachedCriteria getCriteria(OrealPMVWSearchCond cond) throws BLException{
		DetachedCriteria c = getDetachedCriteria();
		
		//���Ƿ���(��ʶ)��Ϊ��ʱ
		if(StringUtils.isNotEmpty(cond.getEnabled_eq())){
			c.add(Expression.eq("enabled", new Integer(cond.getEnabled_eq())));
		}
		//��ƽ̨���Ʋ�Ϊ��ʱ
		if(StringUtils.isNotEmpty(cond.getPlatform_name_like())){
			c.add(Expression.like("platform_name", "%"+cond.getPlatform_name_like()+"%"));
		}
		//��ƽ̨����(in)��Ϊ��ʱ
		if(cond.getPlatform_name_in() != null){
			c.add(Expression.in("platform_name", cond.getPlatform_name_in()));
		}
		
		return c;
	}
}