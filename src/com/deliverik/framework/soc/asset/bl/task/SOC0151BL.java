/*
 * ������������Ϣ�������޹�˾��Ȩ���У���������Ȩ����
 * Copyright 2009 Deliverik Co. Ltd.�� All rights reserved.
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;
import com.deliverik.framework.soc.asset.model.SOC0151Info;
import com.deliverik.framework.soc.asset.model.ConfigurationCodeDetailBean;
import com.deliverik.framework.soc.asset.model.condition.SOC0151SearchCond;
import com.deliverik.framework.soc.asset.model.entity.SOC0151TB;

/**
 * <p>
 * �ʲ�����ȡֵ��Χ����ҵ���߼�
 * </p>
 */
public interface SOC0151BL extends BaseBL{
	
	/**
	 * <p>
	 * �ʲ�����ȡֵ��Χ������Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return �ʲ�����ȡֵ��Χ������Ϣ����ʵ��
	 */

	public SOC0151TB getConfigurationCodeDetailTBInstance();

	/**
	 * �����ʲ�����ȡֵ��Χ��Ϣ����ȡ���ʲ�����ȡֵ��Χ��Ϣ
	 * 
	 * @param ccdid �ʲ�����ȡֵ��Χ��Ϣ����
	 * @return �ʲ�����ȡֵ��Χ��Ϣ
	 */
	public SOC0151Info searchConfigurationCodeDetailByKey(Integer ccdid) throws BLException;

	/**
	 * �����ʲ�����ȡֵ��Χ��Ϣ���ݱ�ʶȡ���ʲ�����ȡֵ��Χ��Ϣ
	 * 
	 * @param ccdcategory �ʲ�����ȡֵ��Χ���ݱ�ʶ
	 * @return �ʲ�����ȡֵ��Χ��Ϣ
	 */
	public SOC0151Info searchConfigurationCodeDetailByKey(String ccdcategory);
	
	/**
	 * ���ݼ�������ȡ���ʲ�����ȡֵ��Χ��Ϣ�б�(��ҳ��ѯ��)
	 * 
	 * @param cond �ʲ�����ȡֵ��Χ��Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �ʲ�����ȡֵ��Χ��Ϣ�б�
	 */
	public List<SOC0151Info> searchConfigurationCodeDetail(SOC0151SearchCond cond, int start, int count);
	
	/**
	 * ���ݼ�������ȡ���ʲ�����ȡֵ��Χ��ʶ�����б�
	 * 
	 * @param cond �ʲ�����ȡֵ��Χ��Ϣ��������
	 * @return �ʲ�����ȡֵ��Χ��ʶ���Ƽ�������б�
	 */
	public List<ConfigurationCodeDetailBean> searchConfigurationCodeDetailBean(SOC0151SearchCond cond);
	
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
	public SOC0151Info registConfigurationCodeDetail(SOC0151Info configurationcodedetail) throws BLException;
	
	/**
	 * ���ݼ�������ȡ���ʲ�����ȡֵ��Χ��Ϣ����
	 * 
	 * @param cond �ʲ�����ȡֵ��Χ��Ϣ��������
	 * @return �ʲ�����ȡֵ��Χ��Ϣ����
	 */
	public int getConfigurationCodeDetailSearchCount(SOC0151SearchCond cond);
	
	/**
	 * ���ݼ�������ȡ���ʲ�����ȡֵ��Χ��Ϣ�б�
	 * 
	 * @param cond �ʲ�����ȡֵ��Χ��Ϣ��������
	 * @return �ʲ�����ȡֵ��Χ��Ϣ�б�
	 */
	public List<SOC0151Info> searchConfigurationCodeDetail(SOC0151SearchCond cond);
	
	/**
	 * ɾ���ʲ�����ȡֵ��Χ��Ϣ����
	 * 
	 * @param configurationCodeDetail �ʲ�����ȡֵ��Χ��Ϣ
	 * @return
	 * @throws BLException
	 */
	public void deleteConfigurationCodeDetail(SOC0151Info configurationCodeDetail) throws BLException;//������

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
	public SOC0151Info updateConfigurationCodeDetail(SOC0151Info configurationCodeDetail) throws BLException;//������
}
