/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.ArrayList;
import java.util.List;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.ConfigurationCodeDetailBean;
import com.deliverik.framework.soc.asset.model.SOC0151Info;
import com.deliverik.framework.soc.asset.model.SOC0151VWInfo;
import com.deliverik.framework.soc.asset.model.condition.SOC0151SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0151VWSearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0151VWSearchCondImpl;
import com.deliverik.framework.soc.asset.model.dao.SOC0151VWDAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0151TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0151VW;
import com.deliverik.framework.soc.asset.model.entity.SOC0151VWPK;
import com.deliverik.framework.utility.BLErrorType;

/**
  * ����: SOC0151VWҵ���߼�ʵ��
  * ��������: SOC0151VWҵ���߼�ʵ��
  * ������¼: 2016/06/23
  * �޸ļ�¼: 
  */
public class SOC0151VWBLImpl extends BaseBLImpl implements
		SOC0151VWBL {

	/** soc0151VWDAO�ӿ� */
	protected SOC0151VWDAO soc0151VWDAO;
	
	

	/**
	 * @return the soc0151VWDAO
	 */
	public SOC0151VWDAO getSoc0151VWDAO() {
		return soc0151VWDAO;
	}

	/**
	 * @param soc0151vwdao the soc0151VWDAO to set
	 */
	public void setSoc0151VWDAO(SOC0151VWDAO soc0151vwdao) {
		soc0151VWDAO = soc0151vwdao;
	}

	/**
	 * SOC0151VWʵ��ȡ��
	 *
	 * @return SOC0151VWʵ��
	 */
	public SOC0151VW getSOC0151VWInstance() {
		return new SOC0151VW();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0151VWInfo> searchSOC0151VW() {
		return soc0151VWDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk ����
	 * @return �������
	 */
	public SOC0151VWInfo searchSOC0151VWByPK(SOC0151VWPK pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond ��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0151VWSearchCond cond) {
		return soc0151VWDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond ��������
	 * @return ��������б�
	 */
	public List<SOC0151VWInfo> searchSOC0151VW(
			SOC0151VWSearchCond cond) {
		return soc0151VWDAO.findByCond(cond, 0, 0);
	}

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
			int count) {
		return soc0151VWDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance ����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0151VWInfo registSOC0151VW(SOC0151VWInfo instance)
		throws BLException {
		return soc0151VWDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance �޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0151VWInfo updateSOC0151VW(SOC0151VWInfo instance)
		throws BLException {
		checkExistInstance(new SOC0151VWPK(instance.getId(), instance.getCcdid()));
		return soc0151VWDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk ����
	 */
	public void deleteSOC0151VWByPK(SOC0151VWPK pk)
		throws BLException {
		soc0151VWDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instance ɾ��ʵ��
	 */
	public void deleteSOC0151VW(SOC0151VWInfo instance)
		throws BLException {
		soc0151VWDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk ����
	 * @return ʵ��
	 */
	public SOC0151VWInfo checkExistInstance(SOC0151VWPK pk)
		throws BLException {
		SOC0151VWInfo instance = soc0151VWDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
	/**
	 * ���ݼ�������ȡ���ʲ�����ȡֵ��Χ��ʶ�����б�
	 * 
	 * @param cond �ʲ�����ȡֵ��Χ��Ϣ��������
	 * @return �ʲ�����ȡֵ��Χ��ʶ���Ƽ�������б�
	 */
	public List<ConfigurationCodeDetailBean> searchConfigurationCodeDetailBean(SOC0151VWSearchCond cond){
		List<ConfigurationCodeDetailBean> ret = soc0151VWDAO.findConfigurationCodeDetailBean(cond);
		return ret;
	}
	
	/**
	 * �������ݱ�ʶȡ���ʲ�����ȡֵ��Χ��ǩ����
	 * 
	 * @param ccdcategory �ʲ�����ȡֵ��Χ���ݱ�ʶ
	 * @return �ʲ�����ȡֵ��Χ��ǩ�����������б�
	 */
	public List<LabelValueBean> searchLabelValueBeanList(String ccdcategory , Integer id){
		SOC0151VWSearchCondImpl cond = new SOC0151VWSearchCondImpl();
		cond.setId(id);
		cond.setCcdcategory(ccdcategory);
		cond.setCcdstatus("1");
		List<SOC0151VWInfo> ret = this.searchConfigurationCodeDetail(cond, 0, 0);
		List<LabelValueBean> list = new ArrayList<LabelValueBean>();
		list.add(new LabelValueBean("", ""));
		for(SOC0151VWInfo ccd : ret){
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
	public SOC0151VWInfo registConfigurationCodeDetail(SOC0151VWInfo configurationCodeDetail) throws BLException{
		SOC0151VWInfo ret = soc0151VWDAO.save(configurationCodeDetail);
		return ret;
	}

	/**
	 * ɾ���ʲ�����ȡֵ��Χ������Ϣ����
	 * 
	 * @param configurationCodeDetail ɾ�����ʲ�����ȡֵ��Χ������Ϣ����
	 * @return
	 */
	public void deleteConfigurationCodeDetail(SOC0151VWInfo configurationCodeDetail) throws BLException {
		checkExistConfigurationCodeDetail(new SOC0151VWPK(configurationCodeDetail.getId(),configurationCodeDetail.getCcdid()));
		soc0151VWDAO.delete(configurationCodeDetail);
	}


	/**
	 * ���ݼ�������ȡ���ʲ�����ȡֵ��Χ������Ϣ�������
	 * 
	 * @param cond �ʲ�����ȡֵ��Χ������Ϣ��������
	 * @return �ʲ�����ȡֵ��Χ������Ϣ�������
	 */
	public int getConfigurationCodeDetailSearchCount(SOC0151VWSearchCond cond) {
		return soc0151VWDAO.getSearchCount(cond);
	}

	/**
	 * ���ݼ�������ȡ���ʲ�����ȡֵ��Χ������Ϣ�б�
	 * 
	 * @param cond �ʲ�����ȡֵ��Χ������Ϣ��������
	 * @return �ʲ�����ȡֵ��Χ������Ϣ��������б�
	 */
	public List<SOC0151VWInfo> searchConfigurationCodeDetail(SOC0151VWSearchCond cond) {
		List<SOC0151VWInfo> ret = soc0151VWDAO.findByCond(cond,0,0);
		return ret;
	}

	/**
	 * �����ʲ�����ȡֵ��Χ������Ϣ����ȡ���ʲ�����ȡֵ��Χ������Ϣ
	 * 
	 * @param ccdid �ʲ�����ȡֵ��Χ������Ϣ����
	 * @return �ʲ�����ȡֵ��Χ������Ϣ
	 * @throws BLException 
	 */
	public SOC0151VWInfo searchConfigurationCodeDetailByKey(Integer id , Integer ccdid) throws BLException {
		return checkExistConfigurationCodeDetail(new SOC0151VWPK(id, ccdid));
	}

	/**
	 * ����ʲ�����ȡֵ��Χ������Ϣ����
	 * 
	 * @param configurationCodeDetail ������ʲ�����ȡֵ��Χ������Ϣ����
	 * @return �ʲ�����ȡֵ��Χ������Ϣ
	 */
	public SOC0151VWInfo updateConfigurationCodeDetail(SOC0151VWInfo configurationCodeDetail) throws BLException {
		checkExistConfigurationCodeDetail(new SOC0151VWPK(configurationCodeDetail.getId(),configurationCodeDetail.getCcdid()));
		SOC0151VWInfo ret = soc0151VWDAO.save(configurationCodeDetail);
		return ret;
	}

	
	/**
	 * �ʲ�����ȡֵ��Χ������Ϣ���ڼ��
	 * 
	 * @param ccdid �ʲ�ID
	 * @return �ʲ�����ȡֵ��Χ������Ϣ
	 * @throws BLException 
	 */
	protected SOC0151VWInfo checkExistConfigurationCodeDetail(SOC0151VWPK pk) throws BLException{
		SOC0151VWInfo info = soc0151VWDAO.findByPK(pk);
		return info;
	}
	/**
	 * <p>
	 * �µ��ʲ�����ȡֵ��Χ������Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return �µ��ʲ�����ȡֵ��Χ������Ϣ����ʵ��ȡ��
	 */

	public SOC0151VW getConfigurationCodeDetailTBInstance() {
		return new SOC0151VW();
	}

/**
 * ���ݼ�������ȡ���ʲ�����ȡֵ��Χ������Ϣ�б�
 * 
 * @param cond �ʲ�����ȡֵ��Χ������Ϣ��������
 * @param start ������¼��ʼ����
 * @param count ������¼����
 * @return �ʲ�����ȡֵ��Χ������Ϣ��������б�
 */
public List<SOC0151VWInfo> searchConfigurationCodeDetail(SOC0151VWSearchCond cond, int start, int count){
	List<SOC0151VWInfo> ret = soc0151VWDAO.findByCond(cond,start,count);
	return ret;
}
}