/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.infogovernor.soc.mnt.model.Object_ListInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.Object_ListSearchCond;
import com.deliverik.infogovernor.soc.mnt.model.dao.Object_ListDAO;
import com.deliverik.infogovernor.soc.mnt.model.entity.Object_ListTB;

/**
  * ����: ���󼯺ϱ�ҵ���߼�ʵ��
  * ��������: ���󼯺ϱ�ҵ���߼�ʵ��
  * ������¼: 2012/05/11
  * �޸ļ�¼: 
  */
public class Object_ListBLImpl extends BaseBLImpl implements
		Object_ListBL {

	/** ���󼯺ϱ�DAO�ӿ� */
	protected Object_ListDAO object_ListDAO;
	
	/**
	 * ���󼯺ϱ�DAO�ӿ��趨
	 *
	 * @param object_ListDAO ���󼯺ϱ�DAO�ӿ�
	 */
	public void setObject_ListDAO(Object_ListDAO object_ListDAO) {
		this.object_ListDAO = object_ListDAO;
	}

	/**
	 * ���󼯺ϱ�ʵ��ȡ��
	 *
	 * @return ���󼯺ϱ�ʵ��
	 */
	public Object_ListTB getObject_ListTBInstance() {
		return new Object_ListTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Object_ListInfo> searchObject_List() {
		return object_ListDAO.findAll();
	}


	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(Object_ListSearchCond cond) {
		return object_ListDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<Object_ListInfo> searchObject_List(
			Object_ListSearchCond cond) {
		return object_ListDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<Object_ListInfo> searchObject_List(
			Object_ListSearchCond cond, int start,
			int count) {
		return object_ListDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public Object_ListInfo registObject_List(Object_ListInfo instance)
		throws BLException {
		return object_ListDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public Object_ListInfo updateObject_List(Object_ListInfo instance)
		throws BLException {
		return object_ListDAO.save(instance);
	}


	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteObject_List(Object_ListInfo instance)
		throws BLException {
		object_ListDAO.delete(instance);
	}


}