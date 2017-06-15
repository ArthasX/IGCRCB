/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.model.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.nms.model.NMS09Info;
import com.deliverik.infogovernor.nms.model.condition.NMS09SearchCond;
import com.deliverik.infogovernor.nms.model.entity.NMS09TB;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �û�������ͼ��Ϣʵ��DAOʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class NMS09DAOImpl extends BaseHibernateDAOImpl<NMS09Info> implements NMS09DAO {
	/**
	 * ���췽��
	 */
	public NMS09DAOImpl(){
		super(NMS09TB.class);
	}
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(NMS09SearchCond cond){
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
	public List<NMS09Info> findByCond(NMS09SearchCond cond, int start, int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(NMS09SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		// ��ID
		if(null != cond.getGid_eq()){
		    c.add(Restrictions.eq("gid", cond.getGid_eq()));
		}
		
		// ��汾
		if(null != cond.getGversion_eq()){
		    c.add(Restrictions.eq("gversion", cond.getGversion_eq()));
		}
		
		// �û�ID
		if(StringUtils.isNotEmpty(cond.getUserid_eq())){
		    c.add(Restrictions.eq("userid", cond.getUserid_eq()));
		}
		
		// �û�IDΪ��
		if(true == cond.isUseridEmpty()){
		    c.add(Restrictions.or(Restrictions.eq("userid", ""), Restrictions.isNull("userid")));
		}
		
		if (StringUtils.isNotEmpty(cond.getShowtype())) {
		    if("1".equals(cond.getShowtype())){
		        c.add(Restrictions.sqlRestriction(" (showtype = '1' or showtype = '' or showtype is null) "));
		    } else {
		        c.add(Restrictions.eq("showtype", "2"));
		    }
		}
		return c;
	}
}
