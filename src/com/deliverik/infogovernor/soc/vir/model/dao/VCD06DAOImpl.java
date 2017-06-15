/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.vir.model.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAOImpl;
import com.deliverik.infogovernor.soc.vir.model.VCD06Info;
import com.deliverik.infogovernor.soc.vir.model.condition.VCD06SearchCond;
import com.deliverik.infogovernor.soc.vir.model.entity.VCD06TB;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: vCloud��֯��ƽ̨��������ʵ��daoʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class VCD06DAOImpl extends BaseHibernateDAOImpl<VCD06Info> implements VCD06DAO {

	/**
	 * ���캯��
	 */
	public VCD06DAOImpl(){
		super(VCD06TB.class);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(VCD06SearchCond cond){
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
	public List<VCD06Info> findByCond(VCD06SearchCond cond, int start, int count){
		DetachedCriteria c = getCriteria(cond);
		return findByCriteria(c, start, count);
	}

	/**
	 * ������������
	 * 
	 * @param cond ��������
	 * @return �����ü���������
	 */
	protected DetachedCriteria getCriteria(VCD06SearchCond cond){
		DetachedCriteria c = getDetachedCriteria();
		if(cond.getVorgs() != null && cond.getVorgs().size() > 0){
			c.add(Restrictions.in("vorg", cond.getVorgs()));
		}
		return c;
	}

}