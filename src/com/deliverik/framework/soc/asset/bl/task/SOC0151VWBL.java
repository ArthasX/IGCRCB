/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.ConfigurationCodeDetailBean;
import com.deliverik.framework.soc.asset.model.SOC0151VWInfo;
import com.deliverik.framework.soc.asset.model.condition.SOC0151VWSearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0151TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0151VW;
import com.deliverik.framework.soc.asset.model.entity.SOC0151VWPK;

/**
  * ����: SOC0151VWҵ���߼��ӿ�
  * ��������: SOC0151VWҵ���߼��ӿ�
  * ������¼: 2016/06/23
  * �޸ļ�¼: 
  */
public interface SOC0151VWBL extends BaseBL {

	/**
	 * SOC0151VWʵ��ȡ��
	 *
	 * @return SOC0151VWʵ��
	 */
	public SOC0151VW getSOC0151VWInstance();

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0151VWInfo> searchSOC0151VW();

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0151VWInfo searchSOC0151VWByPK(SOC0151VWPK pk)
		throws BLException;

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0151VWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0151VWInfo> searchSOC0151VW(
			SOC0151VWSearchCond cond);

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0151VWInfo> searchSOC0151VW(
			SOC0151VWSearchCond cond, int start,
			int count);

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0151VWInfo registSOC0151VW(SOC0151VWInfo instance)
		throws BLException;

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0151VWInfo updateSOC0151VW(SOC0151VWInfo instance)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSOC0151VWByPK(SOC0151VWPK pk)
		throws BLException;

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSOC0151VW(SOC0151VWInfo instance)
		throws BLException;
	/**
	 * <p>
	 * �ʲ�����ȡֵ��Χ������Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return �ʲ�����ȡֵ��Χ������Ϣ����ʵ��
	 */

	public SOC0151VW getConfigurationCodeDetailTBInstance();

	/**
	 * �����ʲ�����ȡֵ��Χ��Ϣ����ȡ���ʲ�����ȡֵ��Χ��Ϣ
	 * 
	 * @param ccdid �ʲ�����ȡֵ��Χ��Ϣ����
	 * @return �ʲ�����ȡֵ��Χ��Ϣ
	 */
//	public SOC0151VWInfo searchConfigurationCodeDetailByKey(Integer ccdid) throws BLException;

	/**
	 * �����ʲ�����ȡֵ��Χ��Ϣ���ݱ�ʶȡ���ʲ�����ȡֵ��Χ��Ϣ
	 * 
	 * @param ccdcategory �ʲ�����ȡֵ��Χ���ݱ�ʶ
	 * @return �ʲ�����ȡֵ��Χ��Ϣ
	 */
//	public SOC0151VWInfo searchConfigurationCodeDetailByKey(String ccdcategory);
	
	/**
	 * ���ݼ�������ȡ���ʲ�����ȡֵ��Χ��Ϣ�б�(��ҳ��ѯ��)
	 * 
	 * @param cond �ʲ�����ȡֵ��Χ��Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �ʲ�����ȡֵ��Χ��Ϣ�б�
	 */
	public List<SOC0151VWInfo> searchConfigurationCodeDetail(SOC0151VWSearchCond cond, int start, int count);
	
	/**
	 * ���ݼ�������ȡ���ʲ�����ȡֵ��Χ��ʶ�����б�
	 * 
	 * @param cond �ʲ�����ȡֵ��Χ��Ϣ��������
	 * @return �ʲ�����ȡֵ��Χ��ʶ���Ƽ�������б�
	 */
	public List<ConfigurationCodeDetailBean> searchConfigurationCodeDetailBean(SOC0151VWSearchCond cond);
	
	/**
	 * �������ݱ�ʶȡ���ʲ�����ȡֵ��Χ��ǩ����
	 * 
	 * @param ccdcategory �ʲ�����ȡֵ��Χ���ݱ�ʶ
	 * @return �ʲ�����ȡֵ��Χ��ǩ�����б�
	 */
	public List<LabelValueBean> searchLabelValueBeanList(String ccdcategory, Integer id);

	/**
	 * �����ʲ�����ȡֵ��Χ��Ϣ����
	 * 
	 * @param configurationcodedetail ������ʲ�����ȡֵ��Χ��Ϣ
	 * @return �ʲ�����ȡֵ��Χ��Ϣ
	 * @throws BLException
	 */
	public SOC0151VWInfo registConfigurationCodeDetail(SOC0151VWInfo configurationcodedetail) throws BLException;
	
	/**
	 * ���ݼ�������ȡ���ʲ�����ȡֵ��Χ��Ϣ����
	 * 
	 * @param cond �ʲ�����ȡֵ��Χ��Ϣ��������
	 * @return �ʲ�����ȡֵ��Χ��Ϣ����
	 */
	public int getConfigurationCodeDetailSearchCount(SOC0151VWSearchCond cond);
	
	/**
	 * ���ݼ�������ȡ���ʲ�����ȡֵ��Χ��Ϣ�б�
	 * 
	 * @param cond �ʲ�����ȡֵ��Χ��Ϣ��������
	 * @return �ʲ�����ȡֵ��Χ��Ϣ�б�
	 */
	public List<SOC0151VWInfo> searchConfigurationCodeDetail(SOC0151VWSearchCond cond);
	
	/**
	 * ɾ���ʲ�����ȡֵ��Χ��Ϣ����
	 * 
	 * @param configurationCodeDetail �ʲ�����ȡֵ��Χ��Ϣ
	 * @return
	 * @throws BLException
	 */
	public void deleteConfigurationCodeDetail(SOC0151VWInfo configurationCodeDetail) throws BLException;//������

}