/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.model.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.nms.model.NMS10Info;
import com.deliverik.infogovernor.nms.model.condition.NMS10SearchCond;
import com.deliverik.infogovernor.nms.model.entity.NMS10TB;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��·������DAOʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("deprecation")
public class NMS10DAOImpl extends BaseHibernateDAOImpl<NMS10Info> implements NMS10DAO {
	/**
	 * ���췽��
	 */
	public NMS10DAOImpl(){
		super(NMS10TB.class);
	}
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(NMS10SearchCond cond){
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
	public List<NMS10Info> findByCond(NMS10SearchCond cond, int start, int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(NMS10SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getGid() != null && cond.getGid() > 0){
			c.add(Expression.eq("gid", cond.getGid()));
		}
		if(cond.getGversion() != null && cond.getGversion() > 0){
			c.add(Expression.eq("gversion", cond.getGversion()));
		}
		return c;
	}
}
