package com.deliverik.infogovernor.drm.model.dao;




import java.io.Serializable;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.drm.model.ResponseStrategyInfo;
import com.deliverik.infogovernor.drm.model.condition.ResponseStrategySearchCond;
import com.deliverik.infogovernor.drm.model.entity.ResponseStrategyTB;

/**
  * ����: ������Ӧ����DAOʵ��
  * ��������: ������Ӧ����DAOʵ��
  * ������¼: 2016/09/20
  * �޸ļ�¼: 
  */
@SuppressWarnings("deprecation")
public class ResponseStrategyDAOImpl extends
		BaseHibernateDAOImpl<ResponseStrategyInfo> implements ResponseStrategyDAO {

	/**
	 * ���캯��
	 */
	public ResponseStrategyDAOImpl(){
		super(ResponseStrategyTB.class);
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ResponseStrategyInfo> findAll() {
		DetachedCriteria c = getDetachedCriteria();
		return findByCriteria(c);
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public ResponseStrategyInfo findByPK(Serializable pk) {
		ResponseStrategyInfo result = super.findByPK(pk);
		if(result == null) return null;
		return result;
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(final ResponseStrategySearchCond cond){
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
	public List<ResponseStrategyInfo> findByCond(final ResponseStrategySearchCond cond, final int start, final int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(ResponseStrategySearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getSenceid()!=null&&cond.getSenceid()>0){
			c.add(Restrictions.eq("senceid", cond.getSenceid()));
		}
		return c;
	}

}