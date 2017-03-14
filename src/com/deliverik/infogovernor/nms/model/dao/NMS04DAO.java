/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.nms.model.dao;

import java.util.List;

import com.deliverik.framework.dao.hibernate.BaseHibernateDAO;
import com.deliverik.infogovernor.nms.model.NMS04Info;
import com.deliverik.infogovernor.nms.model.NMS04VWInfo;
import com.deliverik.infogovernor.nms.model.condition.NMS04SearchCond;
import com.deliverik.infogovernor.nms.model.condition.NMS04VWSearchCond;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: �豸��Ϣʵ��DAO�ӿ�
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public interface NMS04DAO extends BaseHibernateDAO<NMS04Info> {

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(NMS04SearchCond cond);
	
	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<NMS04Info> findByCond(NMS04SearchCond cond, int start, int count);
	
	/**
     * ������汾��ѯ�豸��Ϣ
     * 
     * @param cond ��������
     * @param version �汾
     * @return ��������б�
     */
    public List<NMS04VWInfo> searchDeviceByGroup(final NMS04VWSearchCond cond, final Integer version);
}
