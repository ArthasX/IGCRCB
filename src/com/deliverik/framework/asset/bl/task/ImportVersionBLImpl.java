/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.asset.bl.task;

import java.io.Serializable;
import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.asset.model.ImportVersionInfo;
import com.deliverik.framework.asset.model.condition.ImportVersionSearchCond;
import com.deliverik.framework.asset.model.condition.ImportVersionSearchCondImpl;
import com.deliverik.framework.asset.model.dao.ImportVersionDAO;
import com.deliverik.framework.asset.model.entity.ImportVersionPK;
import com.deliverik.framework.asset.model.entity.ImportVersionTB;

/**
  * ����: �������ݰ汾�����ҵ���߼�ʵ��
  * ��������: �������ݰ汾�����ҵ���߼�ʵ��
  * ������¼: 2011/04/20
  * �޸ļ�¼: 
  */
public class ImportVersionBLImpl extends BaseBLImpl implements
		ImportVersionBL {

	/** �������ݰ汾�����DAO�ӿ� */
	protected ImportVersionDAO importVersionDAO;
	
	/**
	 * �������ݰ汾�����DAO�ӿ��趨
	 *
	 * @param importVersionDAO�������ݰ汾�����DAO�ӿ�
	 */
	public void setImportVersionDAO(ImportVersionDAO importVersionDAO) {
		this.importVersionDAO = importVersionDAO;
	}

	/**
	 * �������ݰ汾�����ʵ��ȡ��
	 *
	 * @return �������ݰ汾�����ʵ��
	 */
	public ImportVersionTB getImportVersionTBInstance() {
		return new ImportVersionTB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<ImportVersionInfo> searchImportVersion() {
		return importVersionDAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk����
	 * @return �������
	 */
	public ImportVersionInfo searchImportVersionByPK(Serializable pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(ImportVersionSearchCond cond) {
		return importVersionDAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<ImportVersionInfo> searchImportVersion(
			ImportVersionSearchCond cond) {
		return importVersionDAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<ImportVersionInfo> searchImportVersion(
			ImportVersionSearchCond cond, int start,
			int count) {
		return importVersionDAO.findByCond(cond, start, count);
	}

	/**
	 * ��������
	 *
	 * @param instance����ʵ��
	 * @return ����ʵ��
	 */
	public ImportVersionInfo registImportVersion(ImportVersionInfo instance)
		throws BLException {
		checkNotImportVersion(instance.getImpeiname());
		return importVersionDAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance�޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public ImportVersionInfo updateImportVersion(ImportVersionInfo instance)
		throws BLException {
		checkExistInstance(new ImportVersionPK(instance.getImpversion(),instance.getImpeiname()));
		return importVersionDAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk����
	 */
	public void deleteImportVersionByPK(Serializable pk)
		throws BLException {
		importVersionDAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instanceɾ��ʵ��
	 */
	public void deleteImportVersion(ImportVersionInfo instance)
		throws BLException {
		importVersionDAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk����
	 * @return ʵ��
	 */
	public ImportVersionInfo checkExistInstance(Serializable pk)
		throws BLException {
		ImportVersionInfo instance = importVersionDAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}
	
	/**
	 * �������汾����
	 */
	public List<ImportVersionInfo> searchImportVersionByPK(
			String impeiname,Integer impversion) throws BLException{
		return importVersionDAO.searchImportVersionByImpname(impeiname,impversion);
	}

	/**
	 * ������󲻴��ڼ��
	 * 
	 * @param impeinameʵ����
	 * @return
	 * @throws BLException 
	 */
	public void checkNotImportVersion(String impeiname) throws BLException {
		ImportVersionSearchCondImpl cond = new ImportVersionSearchCondImpl();
		cond.setImpeiname(impeiname);
		List<ImportVersionInfo> infoList = importVersionDAO.findByImpeiname(cond);
		if( infoList != null && infoList.size()>0 ) {
			throw new BLException(BLErrorType.ENTITY_ITEM_ALREADY_EXISTS,
					"IGCO00000.E027","�������ʵ����");
		}
	}

}