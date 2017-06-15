/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.List;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0121Info;
import com.deliverik.framework.soc.asset.model.SOC0132VW;
import com.deliverik.framework.soc.asset.model.SOC0133VW;
import com.deliverik.framework.soc.asset.model.condition.SOC0121SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0121DAO;
import com.deliverik.framework.soc.asset.model.dao.SOC0141DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0121TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0140VW;
import com.deliverik.framework.soc.asset.model.entity.SOC0141VW;

/**
  * ����: ���չ�ϵ��ҵ���߼�ʵ��
  * ��������: ���չ�ϵ��ҵ���߼�ʵ��
  * ������¼: 2011/04/20
  * �޸ļ�¼��2011/7/13 ����IBM�߼�ͼ��ʾ ������
  * �޸ļ�¼: 
  */
public class SOC0121BLImpl extends BaseBLImpl implements
		SOC0121BL {

	/** ���չ�ϵ��DAO�ӿ� */
	protected SOC0121DAO soc0121DAO;
	
	/** ���չ�ϵ��DAO��ͼ�ӿ� */
	protected SOC0141DAO soc0141DAO;
	
	/**
	 * ���չ�ϵ��DAO�ӿ��趨
	 *
	 * @param snapshotRelationDAO���չ�ϵ��DAO�ӿ�
	 */
	public void setSoc0121DAO(SOC0121DAO soc0121DAO) {
		this.soc0121DAO = soc0121DAO;
	}

	/**
	 * ���չ�ϵ��ʵ��ȡ��
	 *
	 * @return ���չ�ϵ��ʵ��
	 */
	public SOC0121TB getSnapshotRelationTBInstance() {
		return new SOC0121TB();
	}

	/**
	 * ȫ������
	 *
	 * @return ���������
	 */
	public List<SOC0121Info> searchSnapshotRelation() {
		return soc0121DAO.findAll();
	}

	/**
	 * ������������
	 *
	 * @param pk����
	 * @return �������
	 */
	public SOC0121Info searchSnapshotRelationByPK(Integer pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * ���������������ȡ��
	 *
	 * @param cond��������
	 * @return �����������
	 */
	public int getSearchCount(SOC0121SearchCond cond) {
		return soc0121DAO.getSearchCount(cond);
	}

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @return ��������б�
	 */
	public List<SOC0121Info> searchSnapshotRelation(
			SOC0121SearchCond cond) {
		return soc0121DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<SOC0121Info> searchSnapshotRelation(
			SOC0121SearchCond cond, int start,
			int count) {
		return soc0121DAO.findByCond(cond, start, count);
	}
	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<SOC0141VW> searchSnapshotEntityVW(SOC0121SearchCond cond) {
		return soc0141DAO.findByCond(cond);
	}
	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<SOC0140VW> searchDiskFromSnapshotEntityVW(SOC0121SearchCond cond) {
		return soc0141DAO.findDiskByCond(cond);
	}
	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<String> searchDaFromSnapshotEntityVW(SOC0121SearchCond cond) {
		return soc0141DAO.findDaByCond(cond);
	}
	/**
	 * ������������
	 *
	 * @param cond��������
	 * @param start������¼��ʼ�к�
	 * @param count������¼����
	 * @return ��������б�
	 */
	public List<String> searchFaFromSnapshotEntityVW(SOC0121SearchCond cond,String strStorageEilabel) {
		return soc0141DAO.findFaByCond(cond,strStorageEilabel);
	}
	
	/**
	 * ��������
	 *
	 * @param instance����ʵ��
	 * @return ����ʵ��
	 */
	public SOC0121Info registSnapshotRelation(SOC0121Info instance)
		throws BLException {
		return soc0121DAO.save(instance);
	}

	/**
	 * �޸Ĵ���
	 *
	 * @param instance�޸�ʵ��
	 * @return �޸�ʵ��
	 */
	public SOC0121Info updateSnapshotRelation(SOC0121Info instance)
		throws BLException {
		checkExistInstance(instance.getSrid());
		return soc0121DAO.save(instance);
	}

	/**
	 * ɾ������
	 *
	 * @param pk����
	 */
	public void deleteSnapshotRelationByPK(Integer pk)
		throws BLException {
		soc0121DAO.delete(checkExistInstance(pk));
	}

	/**
	 * ɾ������
	 *
	 * @param instanceɾ��ʵ��
	 */
	public void deleteSnapshotRelation(SOC0121Info instance)
		throws BLException {
		soc0121DAO.delete(instance);
	}

	/**
	 * ʵ�����ڼ�鴦��
	 *
	 * @param pk����
	 * @return ʵ��
	 */
	public SOC0121Info checkExistInstance(Integer pk)
		throws BLException {
		SOC0121Info instance = soc0121DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "ʵ������");
		}
		return instance;
	}

	public void setSoc0141DAO(SOC0141DAO soc0141DAO) {
		this.soc0141DAO = soc0141DAO;
	}

	public List<SOC0132VW> searchSwitchPortByCond(
			SOC0121SearchCond cond) {
		
		return soc0141DAO.findSwitchPortByCond(cond);
	}

	public List<SOC0133VW> searchSwitchZoneByCond(
			SOC0121SearchCond cond) {
		
		return soc0141DAO.findSwitchZoneByCond(cond);
	}
	 /**
	 * ������������
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0121TB> searchSwitchRelationByCond(SOC0121SearchCond cond1,SOC0121SearchCond cond2){
		return soc0141DAO.findSwitchRelationByCond(cond1, cond2);
	}

	/**
	 * 
	 * <p>[��������]</p>
	 *
	 * @comment	[��ѯIBM FA PORT����]
	 * @author	wanglongyu@deliverik.com, 2011-7-13
	 * @param cond
	 * @return faport����ʾ����
	 */
	public List<SOC0140VW> searchIBMFaPortFromSnapshotEntityVW(SOC0121SearchCond cond,String strStorageEilabel) {
		return soc0141DAO.findIBMFaportByCond(cond,strStorageEilabel);
	}
	/**
	 * 
	 * <p>[��������]</p>
	 *
	 * @comment	[��ѯIBM DISK SERIAL����]
	 * @author	wanglongyu@deliverik.com, 2011-7-13
	 * @param cond
	 * @return  disk serial���Ե���ʾ����
	 */
	public List<SOC0140VW> searchIBMDiskSerialFromSnapshotEntityVW(SOC0121SearchCond cond) {
		return soc0141DAO.findIBMDiskSerialByCond(cond);
	}
	/**
	 * 
	 * <p>[��������]</p>
	 *
	 * @comment	[��ѯIBM DISK PACK����]
	 * @author	wanglongyu@deliverik.com, 2011-7-13
	 * @param cond
	 * @return Disk pack���Ե���ʾ����
	 */
	public List<SOC0140VW> searchIBMDiskPackFromSnapshotEntityVW(SOC0121SearchCond cond) {
		return soc0141DAO.findIBMDiskPackByCond(cond);
	}
	/**
	 * 
	 * <p>[��������]</p>
	 *
	 * @comment	[��ѯIBM fa����]
	 * @author	wanglongyu@deliverik.com, 2011-7-13
	 * @param cond
	 * @return fa���Ե���ʾ����
	 */
	public List<SOC0140VW> searchIBMFaFromSnapshotEntityVW(SOC0121SearchCond cond) {
		return soc0141DAO.findIBMFaByCond(cond);
	}
	/**
	 * 
	 * <p>[��������]</p>
	 *
	 * @comment	[��ѯIBM da loc����]
	 * @author	wanglongyu@deliverik.com, 2011-7-13
	 * @param cond disk-da ��ϵ
	 * @return DA loc���Ե���ʾ����
	 */
	public List<SOC0140VW> searchIBMDaLocFromSnapshotEntityVW(SOC0121SearchCond cond) {
		return soc0141DAO.findIBMDaLocByCond(cond);
	}
	/**
	 * 
	 * <p>[��������]</p>
	 *
	 * @comment	[��ѯIBM da pair����]
	 * @author	wanglongyu@deliverik.com, 2011-7-13
	 * @param cond
	 * @return DA pair���Ե���ʾ����
	 */
	public List<SOC0140VW> searchIBMDaPairFromSnapshotEntityVW(SOC0121SearchCond cond) {
		return soc0141DAO.findIBMDaPairByCond(cond);
	}
	/**
	 * 
	 * <p>[��������]</p>
	 *
	 * @comment	[��ѯIBM da interface����]
	 * @author	wanglongyu@deliverik.com, 2011-7-13
	 * @param cond
	 * @return DA interface���Ե���ʾ����
	 */
	public List<SOC0140VW> searchIBMDaInterfaceFromSnapshotEntityVW(SOC0121SearchCond cond) {
		return soc0141DAO.findIBMDaInterfaceByCond(cond);
	}

	/**
	 * ��ͼ�����˹�ϵ
	 * @return
	 */
	public List<SOC0121Info> searchShowStorageIOSnapshotRelation() {
		return soc0121DAO.searchShowStorageIOSnapshotRelation();
	}
}