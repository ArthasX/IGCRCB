package com.deliverik.framework.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.model.CodeCategoryInfo;
import com.deliverik.framework.model.condition.CodeCategorySearchCond;
import com.deliverik.framework.model.entity.CodeCategoryTB;

/**
 * ���ݷ�����ϢDAOʵ��
 * 
 */
@SuppressWarnings("deprecation")
public class CodeCategoryTBDAOImpl extends BaseHibernateDAOImpl<CodeCategoryInfo> implements CodeCategoryTBDAO {

	/**
	 * ���캯��
	 */
	public CodeCategoryTBDAOImpl(){
		super(CodeCategoryTB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<CodeCategoryInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("ccid"));
		List<CodeCategoryInfo> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param pid ����
	 * @return �������
	 */
	public CodeCategoryInfo findByPK(Serializable pk) {

		CodeCategoryInfo codeDetail = super.findByPK(pk);
		if(codeDetail == null) return null;

		return codeDetail;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CodeCategorySearchCond cond){
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
	public List<CodeCategoryInfo> findByCond(final CodeCategorySearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("ccid"));
		List<CodeCategoryInfo> ret = findByCriteria(c, start, count);
		return ret;
	}


	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(CodeCategorySearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		
		//����CD
		if( !StringUtils.isEmpty(cond.getCcid())){
			c.add(Expression.eq("ccid", cond.getCcid()));
		}	
		//�ϼ�����CD
		if( !StringUtils.isEmpty(cond.getPccid())){
			c.add(Expression.eq("pccid", cond.getPccid()));
		}	
		//���ݱ༭��ʶ
		if( !StringUtils.isEmpty(cond.getCceditable())){
			c.add(Expression.eq("cceditable", cond.getCceditable()));
		}	
		//�Ƿ�������
		if( cond.isTree()){
			c.add(Expression.gt("pcflag", "0"));
			c.add(Expression.or(Expression.eq("pccid", ""),Expression.isNull("pccid")));
		}	
		return c;
	}
}
