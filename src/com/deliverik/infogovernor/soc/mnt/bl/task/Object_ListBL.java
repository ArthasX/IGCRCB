/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.infogovernor.soc.mnt.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.infogovernor.soc.mnt.model.Object_ListInfo;
import com.deliverik.infogovernor.soc.mnt.model.condition.Object_ListSearchCond;
import com.deliverik.infogovernor.soc.mnt.model.entity.Object_ListTB;

/**
  * ����: ���󼯺ϱ�ҵ���߼��ӿ�
  * ��������: ���󼯺ϱ�ҵ���߼��ӿ�
  * ������¼: 2012/05/11
  * �޸ļ�¼: 
  */
public interface Object_ListBL extends BaseBL {

	/**
	 * ���󼯺ϱ�ʵ��ȡ��
	 *
	 * @return ���󼯺ϱ�ʵ��
	 */
	public Object_ListTB getObject_ListTBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<Object_ListInfo> searchObject_List();


	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(Object_ListSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<Object_ListInfo> searchObject_List(
			Object_ListSearchCond cond);

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
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public Object_ListInfo registObject_List(Object_ListInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public Object_ListInfo updateObject_List(Object_ListInfo instance)
		throws BLException;


	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteObject_List(Object_ListInfo instance)
		throws BLException;

}