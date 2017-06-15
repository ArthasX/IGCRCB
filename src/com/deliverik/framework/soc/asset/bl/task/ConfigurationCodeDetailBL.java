/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.ConfigurationCodeDetail;
import com.deliverik.framework.soc.asset.model.ConfigurationCodeDetailBean;
import com.deliverik.framework.soc.asset.model.condition.ConfigurationCodeDetailSearchCond;
import com.deliverik.framework.soc.asset.model.entity.ConfigurationCodeDetailTB;

/**
 * <p>
 * �ʲ�����ȡֵ��Χ����ҵ���߼�
 * </p>
 */
public interface ConfigurationCodeDetailBL extends BaseBL{
	
	/**
	 * <p>
	 * �ʲ�����ȡֵ��Χ������Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return �ʲ�����ȡֵ��Χ������Ϣ����ʵ��
	 */

	public ConfigurationCodeDetailTB getConfigurationCodeDetailTBInstance();

	/**
	 * �����ʲ�����ȡֵ��Χ��Ϣ����ȡ���ʲ�����ȡֵ��Χ��Ϣ
	 * 
	 * @param ccdid �ʲ�����ȡֵ��Χ��Ϣ����
	 * @return �ʲ�����ȡֵ��Χ��Ϣ
	 */
	public ConfigurationCodeDetail searchConfigurationCodeDetailByKey(Integer ccdid) throws BLException;

	/**
	 * �����ʲ�����ȡֵ��Χ��Ϣ���ݱ�ʶȡ���ʲ�����ȡֵ��Χ��Ϣ
	 * 
	 * @param ccdcategory �ʲ�����ȡֵ��Χ���ݱ�ʶ
	 * @return �ʲ�����ȡֵ��Χ��Ϣ
	 */
	public ConfigurationCodeDetail searchConfigurationCodeDetailByKey(String ccdcategory);
	
	/**
	 * ���ݼ�������ȡ���ʲ�����ȡֵ��Χ��Ϣ�б�(��ҳ��ѯ��)
	 * 
	 * @param cond �ʲ�����ȡֵ��Χ��Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �ʲ�����ȡֵ��Χ��Ϣ�б�
	 */
	public List<ConfigurationCodeDetail> searchConfigurationCodeDetail(ConfigurationCodeDetailSearchCond cond, int start, int count);
	
	/**
	 * ���ݼ�������ȡ���ʲ�����ȡֵ��Χ��ʶ�����б�
	 * 
	 * @param cond �ʲ�����ȡֵ��Χ��Ϣ��������
	 * @return �ʲ�����ȡֵ��Χ��ʶ���Ƽ�������б�
	 */
	public List<ConfigurationCodeDetailBean> searchConfigurationCodeDetailBean(ConfigurationCodeDetailSearchCond cond);
	
	/**
	 * �������ݱ�ʶȡ���ʲ�����ȡֵ��Χ��ǩ����
	 * 
	 * @param ccdcategory �ʲ�����ȡֵ��Χ���ݱ�ʶ
	 * @return �ʲ�����ȡֵ��Χ��ǩ�����б�
	 */
	public List<LabelValueBean> searchLabelValueBeanList(String ccdcategory);

	/**
	 * �����ʲ�����ȡֵ��Χ��Ϣ����
	 * 
	 * @param configurationcodedetail ������ʲ�����ȡֵ��Χ��Ϣ
	 * @return �ʲ�����ȡֵ��Χ��Ϣ
	 * @throws BLException
	 */
	public ConfigurationCodeDetail registConfigurationCodeDetail(ConfigurationCodeDetail configurationcodedetail) throws BLException;
	
	/**
	 * ���ݼ�������ȡ���ʲ�����ȡֵ��Χ��Ϣ����
	 * 
	 * @param cond �ʲ�����ȡֵ��Χ��Ϣ��������
	 * @return �ʲ�����ȡֵ��Χ��Ϣ����
	 */
	public int getConfigurationCodeDetailSearchCount(ConfigurationCodeDetailSearchCond cond);
	
	/**
	 * ���ݼ�������ȡ���ʲ�����ȡֵ��Χ��Ϣ�б�
	 * 
	 * @param cond �ʲ�����ȡֵ��Χ��Ϣ��������
	 * @return �ʲ�����ȡֵ��Χ��Ϣ�б�
	 */
	public List<ConfigurationCodeDetail> searchConfigurationCodeDetail(ConfigurationCodeDetailSearchCond cond);
	
	/**
	 * ɾ���ʲ�����ȡֵ��Χ��Ϣ����
	 * 
	 * @param configurationCodeDetail �ʲ�����ȡֵ��Χ��Ϣ
	 * @return
	 * @throws BLException
	 */
	public void deleteConfigurationCodeDetail(ConfigurationCodeDetail configurationCodeDetail) throws BLException;//������

	/**
	 * �����ʲ�����ȡֵ��Χ��Ϣ����ɾ���ʲ�����ȡֵ��Χ��Ϣ����
	 * 
	 * @param ccdid �ʲ�����ȡֵ��Χ��Ϣ����
	 * @return
	 * @throws BLException
	 */
	public void deleteConfigurationCodeDetailByKey(Integer ccdid) throws BLException;//������

	/**
	 * ����ʲ�����ȡֵ��Χ��Ϣ����
	 * 
	 * @param configurationCodeDetail �ʲ�����ȡֵ��Χ��Ϣ
	 * @return �ʲ�����ȡֵ��Χ��Ϣ
	 * @throws BLException
	 */
	public ConfigurationCodeDetail updateConfigurationCodeDetail(ConfigurationCodeDetail configurationCodeDetail) throws BLException;//������
}
