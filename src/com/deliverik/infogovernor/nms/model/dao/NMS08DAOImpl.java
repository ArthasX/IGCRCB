/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.model.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Expression;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.nms.model.NMS08Info;
import com.deliverik.infogovernor.nms.model.condition.NMS08SearchCond;
import com.deliverik.infogovernor.nms.model.entity.NMS08TB;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �豸��������Ϣʵ��DAOʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
@SuppressWarnings("deprecation")
public class NMS08DAOImpl extends BaseHibernateDAOImpl<NMS08Info> implements NMS08DAO {
	/**
	 * ���췽��
	 */
	public NMS08DAOImpl(){
		super(NMS08TB.class);
	}
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(NMS08SearchCond cond){
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
	public List<NMS08Info> findByCond(NMS08SearchCond cond, int start, int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(NMS08SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getGid() != null && cond.getGid() > 0){
			c.add(Expression.eq("gid", cond.getGid()));
		}
		if(cond.getGversion() != null && cond.getGversion() > 0){
			c.add(Expression.eq("gversion", cond.getGversion()));
		}
		// �豸id
		if (null != cond.getDid()) {
		    c.add(Expression.eq("did", cond.getDid()));
		}
		// �û�id
		if(StringUtils.isNotEmpty(cond.getUserid())){
		    c.add(Expression.eq("userid", cond.getUserid()));
		}
		// �û�idΪ��
		if(cond.isUseridEmpty()){
			c.add(Expression.or(Expression.eq("userid", ""), Expression.isNull("userid")));
		}
		return c;
	}
}
