/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.model.IG545Info;
import com.deliverik.framework.asset.model.IG545Bean;
import com.deliverik.framework.asset.model.condition.IG545SearchCond;
import com.deliverik.framework.asset.model.entity.IG545TB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBL;

/**
 * <p>
 * �ʲ�����ȡֵ��Χ����ҵ���߼�
 * </p>
 */
public interface IG545BL extends BaseBL{
	
	/**
	 * <p>
	 * �ʲ�����ȡֵ��Χ������Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return �ʲ�����ȡֵ��Χ������Ϣ����ʵ��
	 */

	public IG545TB getIG545TBInstance();

	/**
	 * �����ʲ�����ȡֵ��Χ��Ϣ����ȡ���ʲ�����ȡֵ��Χ��Ϣ
	 * 
	 * @param ccdid �ʲ�����ȡֵ��Χ��Ϣ����
	 * @return �ʲ�����ȡֵ��Χ��Ϣ
	 */
	public IG545Info searchIG545InfoByKey(Integer ccdid) throws BLException;

	/**
	 * �����ʲ�����ȡֵ��Χ��Ϣ���ݱ�ʶȡ���ʲ�����ȡֵ��Χ��Ϣ
	 * 
	 * @param ccdcategory �ʲ�����ȡֵ��Χ���ݱ�ʶ
	 * @return �ʲ�����ȡֵ��Χ��Ϣ
	 */
	public IG545Info searchIG545InfoByKey(String ccdcategory);
	
	/**
	 * ���ݼ�������ȡ���ʲ�����ȡֵ��Χ��Ϣ�б�(��ҳ��ѯ��)
	 * 
	 * @param cond �ʲ�����ȡֵ��Χ��Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �ʲ�����ȡֵ��Χ��Ϣ�б�
	 */
	public List<IG545Info> searchIG545Info(IG545SearchCond cond, int start, int count);
	
	/**
	 * ���ݼ�������ȡ���ʲ�����ȡֵ��Χ��ʶ�����б�
	 * 
	 * @param cond �ʲ�����ȡֵ��Χ��Ϣ��������
	 * @return �ʲ�����ȡֵ��Χ��ʶ���Ƽ�������б�
	 */
	public List<IG545Bean> searchIG545Bean(IG545SearchCond cond);
	
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
	 * @param ig545Info ������ʲ�����ȡֵ��Χ��Ϣ
	 * @return �ʲ�����ȡֵ��Χ��Ϣ
	 * @throws BLException
	 */
	public IG545Info registIG545Info(IG545Info ig545Info) throws BLException;
	
	/**
	 * ���ݼ�������ȡ���ʲ�����ȡֵ��Χ��Ϣ����
	 * 
	 * @param cond �ʲ�����ȡֵ��Χ��Ϣ��������
	 * @return �ʲ�����ȡֵ��Χ��Ϣ����
	 */
	public int getIG545InfoSearchCount(IG545SearchCond cond);
	
	/**
	 * ���ݼ�������ȡ���ʲ�����ȡֵ��Χ��Ϣ�б�
	 * 
	 * @param cond �ʲ�����ȡֵ��Χ��Ϣ��������
	 * @return �ʲ�����ȡֵ��Χ��Ϣ�б�
	 */
	public List<IG545Info> searchIG545Info(IG545SearchCond cond);
	
	/**
	 * ɾ���ʲ�����ȡֵ��Χ��Ϣ����
	 * 
	 * @param ig545Info �ʲ�����ȡֵ��Χ��Ϣ
	 * @return
	 * @throws BLException
	 */
	public void deleteIG545Info(IG545Info ig545Info) throws BLException;//������

	/**
	 * �����ʲ�����ȡֵ��Χ��Ϣ����ɾ���ʲ�����ȡֵ��Χ��Ϣ����
	 * 
	 * @param ccdid �ʲ�����ȡֵ��Χ��Ϣ����
	 * @return
	 * @throws BLException
	 */
	public void deleteIG545InfoByKey(Integer ccdid) throws BLException;//������

	/**
	 * ����ʲ�����ȡֵ��Χ��Ϣ����
	 * 
	 * @param ig545Info �ʲ�����ȡֵ��Χ��Ϣ
	 * @return �ʲ�����ȡֵ��Χ��Ϣ
	 * @throws BLException
	 */
	public IG545Info updateIG545Info(IG545Info ig545Info) throws BLException;//������
}
