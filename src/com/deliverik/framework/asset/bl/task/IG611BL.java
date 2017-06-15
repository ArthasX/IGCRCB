/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.asset.model.IG611Info;
import com.deliverik.framework.asset.model.IG612Info;
import com.deliverik.framework.asset.model.condition.IG611SearchCond;
import com.deliverik.framework.asset.model.entity.IG611PK;
import com.deliverik.framework.asset.model.entity.IG611TB;

/**
  * ����: �ʲ�ģ������ȱʡֵҵ���߼��ӿ�
  * ��������: �ʲ�ģ������ȱʡֵҵ���߼��ӿ�
  * ������¼: 2012/07/20
  * �޸ļ�¼: 
  */
public interface IG611BL extends BaseBL {

	/**
	 * �ʲ�ģ������ȱʡֵʵ��ȡ��
	 *
	 * @return �ʲ�ģ������ȱʡֵʵ��
	 */
	public IG611TB getIG611TBInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<IG611Info> searchIG611Info();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public IG611Info searchIG611InfoByPK(IG611PK pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(IG611SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<IG611Info> searchIG611Info(
			IG611SearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG611Info> searchIG611Info(
			IG611SearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public IG611Info registIG611Info(IG611Info instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public IG611Info updateIG611Info(IG611Info instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteIG611InfoByPK(IG611PK pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteIG611Info(IG611Info instance)
		throws BLException;
	
	/**
	 * �ʲ�����Ĭ��ֵȡ��
	 * 
	 * @param cond ��������
	 * @return �ʲ�����Ĭ��ֵ
	 */
	public  List<IG612Info> searchDefaultValue(IG611SearchCond cond);
	
	/**
	 * �ʲ����Գ��ڻ���ѯ
	 * 
	 * @param cond ��������
	 * @return �ʲ�����
	 */
	public  List<IG612Info> searchDefaultLabel(IG611SearchCond cond);

}