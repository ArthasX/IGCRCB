/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.model.dao;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.infogovernor.nms.model.NMS16Info;
import com.deliverik.infogovernor.nms.model.condition.NMS16SearchCond;
import com.deliverik.infogovernor.nms.model.entity.NMS16TB;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���豸������Ϣʵ��DAOʵ��
 * </p>
 * 
 * @version 1.0
 */
public class NMS16DAOImpl extends NMSBaseDAOImpl<NMS16Info> implements NMS16DAO {
	
	/**
	 * ���췽��
	 */
	public NMS16DAOImpl(){
		super(NMS16TB.class);
	}
	
	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(NMS16SearchCond cond){
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
	public List<NMS16Info> findByCond(NMS16SearchCond cond, int start, int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(NMS16SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		// ��id
		if (null != cond.getGid()) {
		    c.add(Restrictions.eq("gid", cond.getGid()));
		}
		// ��汾
		if (null != cond.getGversion()) {
		    c.add(Restrictions.eq("gversion", cond.getGversion()));
		}
		// �豸id
		if (null != cond.getDid()) {
//		    c.add(Restrictions.eq("did", cond.getDid()));
		    c.add(Restrictions.sqlRestriction("did = '" + cond.getDid() + "' "));
		}
		// �û�id
		if(StringUtils.isNotEmpty(cond.getUserid())){
//		    c.add(Restrictions.eq("userid", cond.getUserid()));
		    c.add(Restrictions.sqlRestriction("userid = '" + cond.getUserid() + "' "));
		}
		// �û�idΪ��
		if(cond.isUseridEmpty()){
		    c.add(Restrictions.sqlRestriction("id=this_.id and (userid = '' or userid is null) "));
		}
		
		// ����չ������
		if(StringUtils.isNotEmpty(cond.getType())){
		    c.add(Restrictions.eq("showtype", "'" + cond.getType() + "'"));
		}
		return c;
	}
}
