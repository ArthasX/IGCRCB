/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.io.Serializable;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.util.MessageResources;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0120Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0120SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0120SearchCondImpl;
import com.deliverik.framework.soc.asset.model.dao.SOC0120DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0120PK;
import com.deliverik.framework.soc.asset.model.entity.SOC0120TB;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.IniReader;

/**
  * ����: �������ݰ汾�����ҵ���߼�ʵ��
  * ��������: �������ݰ汾�����ҵ���߼�ʵ��
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public class SOC0120BLImpl extends BaseBLImpl implements
		SOC0120BL {
	
	static Log log = LogFactory.getLog(SOC0120BLImpl.class);

	
	protected MessageResources resources = MessageResources.getMessageResources("com.deliverik.infogovernor.asset.asmResources"); 

	/** �������ݰ汾�����DAO�ӿ� */
	protected SOC0120DAO soc0120DAO;
	

	/**
	 * �������ݰ汾�����DAO�ӿ��趨
	 *
	 * @param soc0120DAO �������ݰ汾�����DAO�ӿ�
	 */
	public void setSoc0120DAO(SOC0120DAO soc0120DAO) {
		this.soc0120DAO = soc0120DAO;
	}

	/**
	 * �������ݰ汾�����ʵ��ȡ��
	 *
	 * @return �������ݰ汾�����ʵ��
	 */
	public SOC0120TB getImportVersionTBInstance() {
		return new SOC0120TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0120Info> searchImportVersion() {
		return soc0120DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk����
	 * @return �������
	 */
	public SOC0120Info searchImportVersionByPK(Serializable pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0120SearchCond cond) {
		return soc0120DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<SOC0120Info> searchImportVersion(
			SOC0120SearchCond cond) {
		return soc0120DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<SOC0120Info> searchImportVersion(
			SOC0120SearchCond cond, int start,
			int count) {
		return soc0120DAO.findByCond(cond, start, count);
	}
	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<SOC0120Info> searchImportVersionAutoCollect(
			SOC0120SearchCond cond, int start,
			int count) {
		return soc0120DAO.findByCondAutoCollect(cond, start, count);
	}
	
	/**
	 * ��������
	 *
	 * @param instance����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0120Info registImportVersion(SOC0120Info instance)
		throws BLException {
		checkNotImportVersion(instance.getImpeiname());
		return soc0120DAO.save(instance);
	}
	/**
	 * �޸Ĵ���
	 *
	 * @param instance�޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0120Info updateImportVersion(SOC0120Info instance)
		throws BLException {
		checkExistInstance(new SOC0120PK(instance.getImpversion(),instance.getImpeiname()));
		return soc0120DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk����
	 */
	public void deleteImportVersionByPK(Serializable pk)
		throws BLException {
		soc0120DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instanceɾ��ʵ��
	 */
	public void deleteImportVersion(SOC0120Info instance)
		throws BLException {
		soc0120DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk����
	 * @return ʵ��
	 */
	public SOC0120Info checkExistInstance(Serializable pk)
		throws BLException {
		SOC0120Info instance = soc0120DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
	
	/**
	 * �������汾����
	 */
	public List<SOC0120Info> searchImportVersionByPK(
			String impeiname,Integer impversion) throws BLException{
		return soc0120DAO.searchImportVersionByImpname(impeiname,impversion);
	}

	/**
	 * ������󲻴��ڼ��
	 * 
	 * @param impeinameʵ����
	 * @return
	 * @throws BLException 
	 */
	public void checkNotImportVersion(String impeiname) throws BLException {
		SOC0120SearchCondImpl cond = new SOC0120SearchCondImpl();
		cond.setImpeiname(impeiname);
		List<SOC0120Info> infoList = soc0120DAO.findByImpeiname(cond);
		if( infoList != null && infoList.size()>0 ) {
			throw new BLException(BLErrorType.ENTITY_ITEM_ALREADY_EXISTS,
					"IGCO00000.E027",getValueFromResources("message.ImportVersionBLImpl.001"));
		}
	}
	
	/**
	 * <p>
	 * ���������ļ���ֵ���ж�ʹ���������Ե���Դ
	 * </p>
	 * 
	 * @param key ��Դ�ļ��е�key
	 * @return ��Դ�ļ��е�value
	 * @throws BLException
	 *
	 */
	private String getValueFromResources(String key){
		String value = "";
		String reourceLanguage = IniReader.getValue("LANGUAGE");
		if("EN".equals(reourceLanguage)){
			resources = MessageResources.getMessageResources("com.deliverik.infogovernor.asset.asmResources_en_US"); 
		} else{
			resources = MessageResources.getMessageResources("com.deliverik.infogovernor.asset.asmResources_zh_CN");
		}
		value = resources.getMessage(key);
		return value;
	}
}