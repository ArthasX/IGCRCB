package com.deliverik.framework.soc.asset.bl.task;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.soc.asset.bl.task.SOC0151BL;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0151Info;
import com.deliverik.framework.soc.asset.model.ConfigurationCodeDetailBean;
import com.deliverik.framework.soc.asset.model.condition.SOC0151SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0151SearchCondImpl;
import com.deliverik.framework.soc.asset.model.dao.SOC0151DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0151TB;
import com.deliverik.framework.utility.BLErrorType;

/**
 * �ʲ�����ȡֵ��Χ����ҵ���߼�ʵ��
 * 
 */
public class SOC0151BLImpl extends BaseBLImpl implements SOC0151BL {

	/** ConfigurationCodeDetail DAO */
	protected SOC0151DAO soc0151DAO;

	
	public void setSoc0151DAO(SOC0151DAO soc0151DAO) {
		this.soc0151DAO = soc0151DAO;
	}

	/**
	 * <p>
	 * �µ��ʲ�����ȡֵ��Χ������Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return �µ��ʲ�����ȡֵ��Χ������Ϣ����ʵ��ȡ��
	 */

	public SOC0151TB getConfigurationCodeDetailTBInstance() {
		return new SOC0151TB();
	}

	/**
	 * ���ݼ�������ȡ���ʲ�����ȡֵ��Χ������Ϣ�б�
	 * 
	 * @param cond �ʲ�����ȡֵ��Χ������Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �ʲ�����ȡֵ��Χ������Ϣ��������б�
	 */
	public List<SOC0151Info> searchConfigurationCodeDetail(SOC0151SearchCond cond, int start, int count){
		List<SOC0151Info> ret = soc0151DAO.findByCond(cond,start,count);
		return ret;
	}
	
	/**
	 * ���ݼ�������ȡ���ʲ�����ȡֵ��Χ��ʶ�����б�
	 * 
	 * @param cond �ʲ�����ȡֵ��Χ��Ϣ��������
	 * @return �ʲ�����ȡֵ��Χ��ʶ���Ƽ�������б�
	 */
	public List<ConfigurationCodeDetailBean> searchConfigurationCodeDetailBean(SOC0151SearchCond cond){
		List<ConfigurationCodeDetailBean> ret = soc0151DAO.findConfigurationCodeDetailBean(cond);
		return ret;
	}
	
	/**
	 * �������ݱ�ʶȡ���ʲ�����ȡֵ��Χ��ǩ����
	 * 
	 * @param ccdcategory �ʲ�����ȡֵ��Χ���ݱ�ʶ
	 * @return �ʲ�����ȡֵ��Χ��ǩ�����������б�
	 */
	public List<LabelValueBean> searchLabelValueBeanList(String ccdcategory){
		SOC0151SearchCondImpl cond = new SOC0151SearchCondImpl();
		cond.setCcdcategory(ccdcategory);
		cond.setCcdstatus("1");
		List<SOC0151Info> ret = this.searchConfigurationCodeDetail(cond, 0, 0);
		List<LabelValueBean> list = new ArrayList<LabelValueBean>();
		list.add(new LabelValueBean("", ""));
		for(SOC0151Info ccd : ret){
			list.add(new LabelValueBean(ccd.getCcdvalue(), ccd.getCcdvalue()));
		}
		return list;
	}
	
	/**
	 * �����ʲ�����ȡֵ��Χ������Ϣ����
	 * 
	 * @param configurationCodeDetail ������ʲ�����ȡֵ��Χ������Ϣ����
	 * @return �ʲ�����ȡֵ��Χ������Ϣ
	 */
	public SOC0151Info registConfigurationCodeDetail(SOC0151Info configurationCodeDetail) throws BLException{
		SOC0151Info ret = soc0151DAO.save(configurationCodeDetail);
		return ret;
	}

	/**
	 * ɾ���ʲ�����ȡֵ��Χ������Ϣ����
	 * 
	 * @param configurationCodeDetail ɾ�����ʲ�����ȡֵ��Χ������Ϣ����
	 * @return
	 */
	public void deleteConfigurationCodeDetail(SOC0151Info configurationCodeDetail) throws BLException {
		checkExistConfigurationCodeDetail(configurationCodeDetail.getCcdid());
		soc0151DAO.delete(configurationCodeDetail);
	}

	/**
	 * �����ʲ�����ȡֵ��Χ������Ϣ����ɾ���ʲ�����ȡֵ��Χ������Ϣ����
	 * 
	 * @param ccdid ɾ���ʲ�����ȡֵ��Χ������Ϣ������
	 * @return
	 */
	public void deleteConfigurationCodeDetailByKey(Integer ccdid) throws BLException {
		SOC0151Info configurationCodeDetail = checkExistConfigurationCodeDetail(ccdid);
		soc0151DAO.delete(configurationCodeDetail);
	}

	/**
	 * ���ݼ�������ȡ���ʲ�����ȡֵ��Χ������Ϣ�������
	 * 
	 * @param cond �ʲ�����ȡֵ��Χ������Ϣ��������
	 * @return �ʲ�����ȡֵ��Χ������Ϣ�������
	 */
	public int getConfigurationCodeDetailSearchCount(SOC0151SearchCond cond) {
		return soc0151DAO.getSearchCount(cond);
	}

	/**
	 * ���ݼ�������ȡ���ʲ�����ȡֵ��Χ������Ϣ�б�
	 * 
	 * @param cond �ʲ�����ȡֵ��Χ������Ϣ��������
	 * @return �ʲ�����ȡֵ��Χ������Ϣ��������б�
	 */
	public List<SOC0151Info> searchConfigurationCodeDetail(SOC0151SearchCond cond) {
		List<SOC0151Info> ret = soc0151DAO.findByCond(cond,0,0);
		return ret;
	}

	/**
	 * �����ʲ�����ȡֵ��Χ������Ϣ����ȡ���ʲ�����ȡֵ��Χ������Ϣ
	 * 
	 * @param ccdid �ʲ�����ȡֵ��Χ������Ϣ����
	 * @return �ʲ�����ȡֵ��Χ������Ϣ
	 * @throws BLException 
	 */
	public SOC0151Info searchConfigurationCodeDetailByKey(Integer ccdid) throws BLException {
		return checkExistConfigurationCodeDetail(ccdid);
	}

	/**
	 * ����ʲ�����ȡֵ��Χ������Ϣ����
	 * 
	 * @param configurationCodeDetail ������ʲ�����ȡֵ��Χ������Ϣ����
	 * @return �ʲ�����ȡֵ��Χ������Ϣ
	 */
	public SOC0151Info updateConfigurationCodeDetail(SOC0151Info configurationCodeDetail) throws BLException {
		checkExistConfigurationCodeDetail(configurationCodeDetail.getCcdid());
		SOC0151Info ret = soc0151DAO.save(configurationCodeDetail);
		return ret;
	}

	/**
	 * �����ʲ�����ȡֵ��Χ��Ϣ���ݱ�ʶȡ���ʲ�����ȡֵ��Χ��Ϣ
	 * 
	 * @param ccdcategory �ʲ�����ȡֵ��Χ���ݱ�ʶ
	 * @return �ʲ�����ȡֵ��Χ��Ϣ
	 */
	public SOC0151Info searchConfigurationCodeDetailByKey(String ccdcategory) {
		SOC0151Info ret = soc0151DAO.findByPK(ccdcategory);
		return ret;
	}
	
	/**
	 * �ʲ�����ȡֵ��Χ������Ϣ���ڼ��
	 * 
	 * @param ccdid �ʲ�ID
	 * @return �ʲ�����ȡֵ��Χ������Ϣ
	 * @throws BLException 
	 */
	protected SOC0151Info checkExistConfigurationCodeDetail(Integer ccdid) throws BLException{
		SOC0151Info info = soc0151DAO.findByPK(ccdid);
		if(info == null) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","�ʲ�����ȡֵ��Χ���ݻ���");
		}
		return info;
	}
}
