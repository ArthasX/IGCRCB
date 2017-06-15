/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */

package com.deliverik.framework.soc.asset.bl.task;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;

import com.deliverik.framework.asset.EntityItemKeyWords;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;

import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0603Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0109SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0603SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0118DAO;
import com.deliverik.framework.soc.asset.model.dao.SOC0603DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0107TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0118TB;
import com.deliverik.framework.soc.asset.model.dao.SOC0109DAO;
import com.deliverik.framework.soc.asset.model.dao.SOC0107DAO;
import com.deliverik.framework.soc.asset.model.dao.SOC0117DAO;


/**
 * ����ҵ���߼�ʵ��
 * 
 */
public class SOC0603BLImpl extends BaseBLImpl implements SOC0603BL {

	/** ComputerContainerVW DAO */
	protected SOC0603DAO soc0603DAO;
	
	/** EntityItem DAO */
	protected SOC0118DAO soc0118DAO;
	
	/** SOC0109 DAO */
	protected SOC0109DAO soc0109DAO;
	
	/** ConfigItemDAO */
	protected SOC0107DAO soc0107DAO;
	
	/** Entity DAO */
	protected SOC0117DAO soc0117DAO;

	public void setSOC0603DAO(SOC0603DAO soc0603DAO) {
		this.soc0603DAO = soc0603DAO;
	}
	

	public void setSoc0603DAO(SOC0603DAO soc0603dao) {
		soc0603DAO = soc0603dao;
	}


	public void setSoc0118DAO(SOC0118DAO soc0118dao) {
		soc0118DAO = soc0118dao;
	}


	public void setSoc0109DAO(SOC0109DAO soc0109dao) {
		soc0109DAO = soc0109dao;
	}


	public void setSoc0107DAO(SOC0107DAO soc0107dao) {
		soc0107DAO = soc0107dao;
	}


	public void setSoc0117DAO(SOC0117DAO soc0117dao) {
		soc0117DAO = soc0117dao;
	}


	/**
	 * ���ݻ�����Ϣ����ȡ�û�����Ϣ
	 * 
	 * @param eiid ����ID
	 * @return ������Ϣ
	 */
	public SOC0603Info searchSOC0603InfoByKey(String eiid){

		SOC0603Info ret = soc0603DAO.findByPK(Integer.parseInt(eiid));
		return ret;
	}
	
	/**
	 * ���ݼ�������ȡ�û�����Ϣ�������
	 * 
	 * @param cond ������Ϣ��������
	 * @return ������Ϣ�������
	 */
	public int getSOC0603InfoSearchCount(SOC0603SearchCond cond){

		return soc0603DAO.getSearchCount(cond);
	}

	/**
	 * ���ݼ�������ȡ�û�����Ϣ�б�
	 * 
	 * @param cond ������Ϣ��������
	 * @return ������Ϣ��������б�
	 */
	public List<SOC0603Info> searchSOC0603Info(SOC0603SearchCond cond){
		
		List<SOC0603Info> ret = soc0603DAO.findByCond(cond,0,0);
		return ret;
	}
	
	/**
	 * ���ݼ�������ȡ�û�����Ϣ�б�
	 * 
	 * @param cond ������Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return ������Ϣ��������б�
	 */
	public List<SOC0603Info> searchSOC0603Info(SOC0603SearchCond cond, int start, int count){
		
		List<SOC0603Info> ret = soc0603DAO.findByCond(cond,start,count);
		return ret;
	}
	
	/**
	 * ���������Ϣ����
	 * 
	 * @param SOC0603Info ������Ϣ
	 * @return �������ɵĻ���ID
	 * @throws BLException
	 */
	public Integer registSOC0603Info(SOC0603Info SOC0603Info) throws BLException{
		//���������Ϣ����
		SOC0118TB entityItemTB = new SOC0118TB();
		
		//����ģ��IDȡ��
		SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
		cond.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_CONTAINER);
		
		//�ǼǴ���ǰ�Ļ�����Ϣȷ��
		List<SOC0117Info> entityList = soc0117DAO.findByCond(cond, 0, 0);
		
		if ( entityList == null || entityList.size() ==0 ) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","����ģ�ͻ���");
		}
		
		SOC0117Info entity = entityList.get(0);
		entityItemTB.setEid(entity.getEid());
		entityItemTB.setEiname(SOC0603Info.getEiname());
		entityItemTB.setEilabel(SOC0603Info.getEilabel());
		entityItemTB.setEidesc(SOC0603Info.getEidesc());
		entityItemTB.setEiversion(1);
		entityItemTB.setEiinsdate(IGStringUtils.getCurrentDate());
		entityItemTB.setEiupdtime(IGStringUtils.getCurrentDateTime());
		entityItemTB.setEsyscoding("999007");
		SOC0118Info entityItem = soc0118DAO.save(entityItemTB);
		//����λ�ã�X����������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_X_VALUE,
				SOC0603Info.getX_value(),"����","����λ�ã�X��",1);
		
		//����λ�ã�Y����������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_Y_VALUE,
				SOC0603Info.getY_value(),"����","����λ�ã�Y��",1);
		
		//����߶ȣ�U����������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_U_TOTAL,
				SOC0603Info.getU_total(),"����","����߶ȣ�U��",1);
		
		//����������������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_X_WIDTH,
				SOC0603Info.getX_width(),"����","��������",1);

		//�����������������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_Y_WIDTH,
				SOC0603Info.getY_width(),"����","���������",1);
		return entityItem.getEiid();
	}
	
	/**
	 * ������Ϣ��Ӵ���
	 *
	 * @param entityItem EntityItem �ʲ�
	 * @param clabel String ���Ա��
	 * @param civalue String ����ֵ
	 * @param sErrParam0 String ������Ϣ����0
	 * @param sErrParam1 String ������Ϣ����1 
	 * @param civersion Integer ���԰汾
	 * @return
	 */
	protected void insertConfigItem(SOC0118Info entityItem,
			String clabel,String civalue,String sErrParam0,String sErrParam1,
			Integer civersion) throws BLException {
		//1.��ѯ��������
		SOC0109SearchCondImpl configCond = new SOC0109SearchCondImpl();
		configCond.setClabel(clabel);
		
		//2.���Բ�ѯ
		List<SOC0109Info> configList = soc0109DAO.findByCond(configCond, 0, 0);
		
		if ( configList == null || configList.size()==0 ) {
			throw new BLException("IGCO10000.E013",sErrParam0,sErrParam1);
		}
		
		//2.������������
		SOC0107TB configItemTB = new SOC0107TB();
		
		//�ʲ�ID
		configItemTB.setEiid(entityItem.getEiid());
		//�ʲ�ģ��ID
		configItemTB.setEid(entityItem.getEid());
		//�ʲ�����ID
		configItemTB.setCid(configList.get(0).getCid());
		//�ʲ�����ֵ
		configItemTB.setCivalue(civalue);
		
		//�ʲ����԰汾
		configItemTB.setCiversion(civersion);
		
		//�ʲ����Ը���ʱ��
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		
		configItemTB.setCiupdtime(datetime);
		
		//3.������Ϣ�Ǽ�
		soc0107DAO.save(configItemTB);
		
	}

	/**
	 * ɾ��������Ϣ����
	 * 
	 * @param SOC0603Info ɾ���Ļ�����Ϣ
	 * @return
	 * @throws BLException
	 */
	public void deleteSOC0603Info(SOC0603Info SOC0603Info) throws BLException{
		SOC0118Info ret = checkExistComputerContainer(SOC0603Info.getEiid());
		soc0118DAO.delete(ret);
	}

	/**
	 * ���ݻ�������ɾ��������Ϣ����
	 * 
	 * @param eiid ɾ��������Ϣ������
	 * @return
	 * @throws BLException
	 */
	public void deleteSOC0603InfoByKey(Integer eiid) throws BLException{
		SOC0118Info ret = checkExistComputerContainer(eiid);
		soc0118DAO.delete(ret);
	}

	/**
	 * ���������Ϣ����
	 * 
	 * @param SOC0603Info ���ǰ�Ļ�����Ϣ
	 * @throws BLException
	 */
	public void updateSOC0603Info(SOC0603Info SOC0603Info) throws BLException{
		SOC0118Info entityItem = checkExistComputerContainer(SOC0603Info.getEiid());
		
		//���������Ϣ����
		SOC0118TB entityItemTB = (SOC0118TB)SerializationUtils.clone(entityItem);
		int cur_version = entityItem.getEiversion() + 1;
		entityItemTB.setEiname(SOC0603Info.getEiname());
		entityItemTB.setEilabel(SOC0603Info.getEilabel());
		entityItemTB.setEidesc(SOC0603Info.getEidesc());
		entityItemTB.setEiversion(cur_version);
		entityItemTB.setEiupdtime(IGStringUtils.getCurrentDateTime());
		soc0118DAO.save(entityItemTB);
		//�������������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_U_TOTAL,
				SOC0603Info.getU_total(),"����","�����",cur_version);
		
		//����λ�ã�X����������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_X_VALUE,
				SOC0603Info.getX_value(),"����","����λ�ã�X��",cur_version);
		
		//��������������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_Y_VALUE,
				SOC0603Info.getY_value(),"����","����λ�ã�Y��",cur_version);
		
		//����������������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_X_WIDTH,
				SOC0603Info.getX_width(),"����","��������",cur_version);
		
		//�����������������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_Y_WIDTH,
				SOC0603Info.getY_width(),"����","���������",cur_version);
		
	}
	
	/**
	 * ������Ϣ���ڼ��
	 * 
	 * @param eiid ����ID
	 * @return ���������Ϣ
	 * @throws BLException 
	 */
	protected  SOC0118Info checkExistComputerContainer(Integer eiid) throws BLException{
		SOC0118Info info = soc0118DAO.findByPK(eiid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","����");
		}
		
		return info;
	}

	/**
	 * �����������������յ���UPS
	 * 
	 * @param cond
	 * @return
	 */
	public List<SOC0603Info> searchUpsAndAirSOC0603Info(SOC0603SearchCond cond) {
		return soc0603DAO.findBySOC0603Info(cond);
	}
}
