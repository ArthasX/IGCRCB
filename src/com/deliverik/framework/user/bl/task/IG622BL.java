/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.user.bl.task;

import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.user.model.IG622Info;
import com.deliverik.framework.user.model.condition.IG622SearchCond;
import com.deliverik.framework.user.model.entity.IG622TB;

/**
  * ����: ��ҳ��תURL����ҵ���߼��ӿ�
  * ��������: ��ҳ��תURL����ҵ���߼��ӿ�
  * ������¼: 2012/07/18
  * �޸ļ�¼: 
  */
public interface IG622BL extends BaseBL {

	/**
	 * ��ҳ��תURL����ʵ��ȡ��
	 *
	 * @return ��ҳ��תURL����ʵ��
	 */
	public IG622TB getIG622TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG622Info> searchIG622Info();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG622Info searchIG622InfoByPK(String pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG622SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG622Info> searchIG622Info(
			IG622SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG622Info> searchIG622Info(
			IG622SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG622Info registIG622Info(IG622Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG622Info updateIG622Info(IG622Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG622InfoByPK(String pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG622Info(IG622Info instance)
		throws BLException;
	
	/**
	 * �û���ҳ�����б�ȡ��
	 *
	 * @return �û���ҳ�����б�
	 */
	public List<LabelValueBean> getComboBox();
	
	/**
	 * ��ҳ��תURLȡ��
	 *
	 * @param hpid ����ID
	 * @return ��ҳ��תURL
	 * @throws BLException 
	 */
	public String getUrl(String hpid) throws BLException;
	
	/**
	 * ��ҳ��ʾ����ȡ��
	 *
	 * @param hpid ����ID
	 * @return ��ҳ��ʾ����
	 * @throws BLException 
	 */
	public String getTitle(String hpid) throws BLException;

}