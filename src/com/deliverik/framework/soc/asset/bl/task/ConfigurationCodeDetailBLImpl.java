package com.deliverik.framework.soc.asset.bl.task;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.soc.asset.bl.task.ConfigurationCodeDetailBL;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.ConfigurationCodeDetail;
import com.deliverik.framework.soc.asset.model.ConfigurationCodeDetailBean;
import com.deliverik.framework.soc.asset.model.condition.ConfigurationCodeDetailSearchCond;
import com.deliverik.framework.soc.asset.model.condition.ConfigurationCodeDetailSearchCondImpl;
import com.deliverik.framework.soc.asset.model.dao.ConfigurationCodeDetailDAO;
import com.deliverik.framework.soc.asset.model.entity.ConfigurationCodeDetailTB;
import com.deliverik.framework.utility.BLErrorType;

/**
 * �ʲ�����ȡֵ��Χ����ҵ���߼�ʵ��
 * 
 */
public class ConfigurationCodeDetailBLImpl extends BaseBLImpl implements ConfigurationCodeDetailBL {

	/** ConfigurationCodeDetail DAO */
	protected ConfigurationCodeDetailDAO configurationCodeDetailDAO;

	public void setConfigurationCodeDetailDAO(ConfigurationCodeDetailDAO configurationCodeDetailDAO) {
		this.configurationCodeDetailDAO = configurationCodeDetailDAO;
	}
	
	/**
	 * <p>
	 * �µ��ʲ�����ȡֵ��Χ������Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return �µ��ʲ�����ȡֵ��Χ������Ϣ����ʵ��ȡ��
	 */

	public ConfigurationCodeDetailTB getConfigurationCodeDetailTBInstance() {
		return new ConfigurationCodeDetailTB();
	}

	/**
	 * ���ݼ�������ȡ���ʲ�����ȡֵ��Χ������Ϣ�б�
	 * 
	 * @param cond �ʲ�����ȡֵ��Χ������Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �ʲ�����ȡֵ��Χ������Ϣ��������б�
	 */
	public List<ConfigurationCodeDetail> searchConfigurationCodeDetail(ConfigurationCodeDetailSearchCond cond, int start, int count){
		List<ConfigurationCodeDetail> ret = configurationCodeDetailDAO.findByCond(cond,start,count);
		return ret;
	}
	
	/**
	 * ���ݼ�������ȡ���ʲ�����ȡֵ��Χ��ʶ�����б�
	 * 
	 * @param cond �ʲ�����ȡֵ��Χ��Ϣ��������
	 * @return �ʲ�����ȡֵ��Χ��ʶ���Ƽ�������б�
	 */
	public List<ConfigurationCodeDetailBean> searchConfigurationCodeDetailBean(ConfigurationCodeDetailSearchCond cond){
		List<ConfigurationCodeDetailBean> ret = configurationCodeDetailDAO.findConfigurationCodeDetailBean(cond);
		return ret;
	}
	
	/**
	 * �������ݱ�ʶȡ���ʲ�����ȡֵ��Χ��ǩ����
	 * 
	 * @param ccdcategory �ʲ�����ȡֵ��Χ���ݱ�ʶ
	 * @return �ʲ�����ȡֵ��Χ��ǩ�����������б�
	 */
	public List<LabelValueBean> searchLabelValueBeanList(String ccdcategory){
		ConfigurationCodeDetailSearchCondImpl cond = new ConfigurationCodeDetailSearchCondImpl();
		cond.setCcdcategory(ccdcategory);
		cond.setCcdstatus("1");
		List<ConfigurationCodeDetail> ret = this.searchConfigurationCodeDetail(cond, 0, 0);
		List<LabelValueBean> list = new ArrayList<LabelValueBean>();
		list.add(new LabelValueBean("", ""));
		for(ConfigurationCodeDetail ccd : ret){
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
	public ConfigurationCodeDetail registConfigurationCodeDetail(ConfigurationCodeDetail configurationCodeDetail) throws BLException{
		ConfigurationCodeDetail ret = configurationCodeDetailDAO.save(configurationCodeDetail);
		return ret;
	}

	/**
	 * ɾ���ʲ�����ȡֵ��Χ������Ϣ����
	 * 
	 * @param configurationCodeDetail ɾ�����ʲ�����ȡֵ��Χ������Ϣ����
	 * @return
	 */
	public void deleteConfigurationCodeDetail(ConfigurationCodeDetail configurationCodeDetail) throws BLException {
		checkExistConfigurationCodeDetail(configurationCodeDetail.getCcdid());
		configurationCodeDetailDAO.delete(configurationCodeDetail);
	}

	/**
	 * �����ʲ�����ȡֵ��Χ������Ϣ����ɾ���ʲ�����ȡֵ��Χ������Ϣ����
	 * 
	 * @param ccdid ɾ���ʲ�����ȡֵ��Χ������Ϣ������
	 * @return
	 */
	public void deleteConfigurationCodeDetailByKey(Integer ccdid) throws BLException {
		ConfigurationCodeDetail configurationCodeDetail = checkExistConfigurationCodeDetail(ccdid);
		configurationCodeDetailDAO.delete(configurationCodeDetail);
	}

	/**
	 * ���ݼ�������ȡ���ʲ�����ȡֵ��Χ������Ϣ�������
	 * 
	 * @param cond �ʲ�����ȡֵ��Χ������Ϣ��������
	 * @return �ʲ�����ȡֵ��Χ������Ϣ�������
	 */
	public int getConfigurationCodeDetailSearchCount(ConfigurationCodeDetailSearchCond cond) {
		return configurationCodeDetailDAO.getSearchCount(cond);
	}

	/**
	 * ���ݼ�������ȡ���ʲ�����ȡֵ��Χ������Ϣ�б�
	 * 
	 * @param cond �ʲ�����ȡֵ��Χ������Ϣ��������
	 * @return �ʲ�����ȡֵ��Χ������Ϣ��������б�
	 */
	public List<ConfigurationCodeDetail> searchConfigurationCodeDetail(ConfigurationCodeDetailSearchCond cond) {
		List<ConfigurationCodeDetail> ret = configurationCodeDetailDAO.findByCond(cond,0,0);
		return ret;
	}

	/**
	 * �����ʲ�����ȡֵ��Χ������Ϣ����ȡ���ʲ�����ȡֵ��Χ������Ϣ
	 * 
	 * @param ccdid �ʲ�����ȡֵ��Χ������Ϣ����
	 * @return �ʲ�����ȡֵ��Χ������Ϣ
	 * @throws BLException 
	 */
	public ConfigurationCodeDetail searchConfigurationCodeDetailByKey(Integer ccdid) throws BLException {
		return checkExistConfigurationCodeDetail(ccdid);
	}

	/**
	 * ����ʲ�����ȡֵ��Χ������Ϣ����
	 * 
	 * @param configurationCodeDetail ������ʲ�����ȡֵ��Χ������Ϣ����
	 * @return �ʲ�����ȡֵ��Χ������Ϣ
	 */
	public ConfigurationCodeDetail updateConfigurationCodeDetail(ConfigurationCodeDetail configurationCodeDetail) throws BLException {
		checkExistConfigurationCodeDetail(configurationCodeDetail.getCcdid());
		ConfigurationCodeDetail ret = configurationCodeDetailDAO.save(configurationCodeDetail);
		return ret;
	}

	/**
	 * �����ʲ�����ȡֵ��Χ��Ϣ���ݱ�ʶȡ���ʲ�����ȡֵ��Χ��Ϣ
	 * 
	 * @param ccdcategory �ʲ�����ȡֵ��Χ���ݱ�ʶ
	 * @return �ʲ�����ȡֵ��Χ��Ϣ
	 */
	public ConfigurationCodeDetail searchConfigurationCodeDetailByKey(String ccdcategory) {
		ConfigurationCodeDetail ret = configurationCodeDetailDAO.findByPK(ccdcategory);
		return ret;
	}
	
	/**
	 * �ʲ�����ȡֵ��Χ������Ϣ���ڼ��
	 * 
	 * @param ccdid �ʲ�ID
	 * @return �ʲ�����ȡֵ��Χ������Ϣ
	 * @throws BLException 
	 */
	protected ConfigurationCodeDetail checkExistConfigurationCodeDetail(Integer ccdid) throws BLException{
		ConfigurationCodeDetail info = configurationCodeDetailDAO.findByPK(ccdid);
		if(info == null) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","�ʲ�����ȡֵ��Χ���ݻ���");
		}
		return info;
	}
}
