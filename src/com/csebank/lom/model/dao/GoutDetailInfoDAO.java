/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 */
package com.csebank.lom.model.dao;
import java.util.List;

import com.csebank.lom.model.GoutDetailInfo;
import com.csebank.lom.model.condition.GoutDetailSearchCond;
import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;

/**
 * ģ�飺���ڹ���-ʳ�ù���
 * ˵����ʳ����Ʒ������ϸDAO�ӿ�
 * ���ߣ�������
 */
public interface GoutDetailInfoDAO extends BaseHibernateDAO<GoutDetailInfo> {


	/**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<GoutDetailInfo> findByCond(final GoutDetailSearchCond cond, final int start, final int count);
	
	
	

}
