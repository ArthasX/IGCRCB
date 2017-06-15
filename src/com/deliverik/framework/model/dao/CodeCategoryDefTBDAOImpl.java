package com.deliverik.framework.model.dao;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.framework.model.CodeCategoryDefInfo;
import com.deliverik.framework.model.condition.CodeCategoryDefSearchCond;
import com.deliverik.framework.model.entity.CodeCategoryDefTB;

/**
 * ���ݷ�����ϢDAOʵ��
 * 
 */
@SuppressWarnings("deprecation")
public class CodeCategoryDefTBDAOImpl extends BaseHibernateDAOImpl<CodeCategoryDefInfo> implements CodeCategoryDefTBDAO {

	/**
	 * ���캯��
	 */
	public CodeCategoryDefTBDAOImpl(){
		super(CodeCategoryDefTB.class);
	}

	/**
	 * ȫ������
	 * @return ���������
	 */
	public List<CodeCategoryDefInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		c.addOrder(Order.asc("ccid"));
		List<CodeCategoryDefInfo> ret = findByCriteria(c);

		return ret;
	}

	/**
	 * ������������
	 * @param pid ����
	 * @return �������
	 */
	public CodeCategoryDefInfo findByPK(Serializable pk) {

		CodeCategoryDefInfo codeDetail = super.findByPK(pk);
		if(codeDetail == null) return null;

		return codeDetail;
	}

	/**
	 * ���������������ȡ��
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final CodeCategoryDefSearchCond cond){
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
	public List<CodeCategoryDefInfo> findByCond(final CodeCategoryDefSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.asc("ccid"));
		List<CodeCategoryDefInfo> ret = findByCriteria(c, start, count);
		return ret;
	}
	
	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<CodeCategoryDefInfo> findByCondDescCiid(final CodeCategoryDefSearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		c.addOrder(Order.desc("ccid"));
		List<CodeCategoryDefInfo> ret = findByCriteria(c, start, count);
		return ret;
	}
	
	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(CodeCategoryDefSearchCond cond){
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
