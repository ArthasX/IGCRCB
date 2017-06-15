package com.deliverik.framework.asset.bl.task;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang.SerializationUtils;

import com.deliverik.framework.asset.EntityItemKeyWords;
import com.deliverik.framework.asset.model.IG601Info;
import com.deliverik.framework.asset.model.IG225Info;
import com.deliverik.framework.asset.model.IG117Info;
import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.asset.model.condition.IG601SearchCond;
import com.deliverik.framework.asset.model.condition.IG225SearchCondImpl;
import com.deliverik.framework.asset.model.condition.IG117SearchCondImpl;
import com.deliverik.framework.asset.model.dao.IG601DAO;
import com.deliverik.framework.asset.model.dao.IG800DAO;
import com.deliverik.framework.asset.model.dao.IG225DAO;
import com.deliverik.framework.asset.model.dao.IG117DAO;
import com.deliverik.framework.asset.model.dao.IG013DAO;
import com.deliverik.framework.asset.model.entity.IG800TB;
import com.deliverik.framework.asset.model.entity.IG013TB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.IGStringUtils;



/**
 * ������Ϣҵ���߼�ʵ��
 * 
 */
public class IG601BLImpl extends BaseBLImpl implements IG601BL {

	/** ComputerRoomVW DAO */
	protected IG601DAO ig601DAO;
	
	/** EntityItem DAO */
	protected IG013DAO ig013DAO;
	
	/** Ig225 DAO */
	protected IG225DAO ig225DAO;
	
	/** ConfigItemDAO */
	protected IG800DAO ig800DAO;
	
	/** Entity DAO */
	protected IG117DAO ig117DAO;

	public void setIg601DAO(IG601DAO ig601DAO) {
		this.ig601DAO = ig601DAO;
	}
	
	public void setIg013DAO(IG013DAO ig013DAO) {
		this.ig013DAO = ig013DAO;
	}
	
	public void setIg225DAO(IG225DAO ig225DAO) {
		this.ig225DAO = ig225DAO;
	}
	
	public void setIg800DAO(IG800DAO ig800DAO) {
		this.ig800DAO = ig800DAO;
	}
	
	public void setIg117DAO(IG117DAO ig117DAO) {
		this.ig117DAO = ig117DAO;
	}

	/**
	 * ���ݻ�����Ϣ����ȡ�û�����Ϣ
	 * 
	 * @param eiid ������Ϣ����
	 * @return ������Ϣ
	 */
	public IG601Info searchIG601InfoByKey(Integer eiid){

		IG601Info ret = ig601DAO.findByPK(eiid);
		return ret;
	}
	
	/**
	 * ���ݼ�������ȡ�û�����Ϣ�������
	 * 
	 * @param cond ������Ϣ��������
	 * @return ������Ϣ�������
	 */
	public int getIG601InfoSearchCount(IG601SearchCond cond){

		return ig601DAO.getSearchCount(cond);
	}

	/**
	 * ���ݼ�������ȡ�û�����Ϣ�б�
	 * 
	 * @param cond ������Ϣ��������
	 * @return ������Ϣ��������б�
	 */
	public List<IG601Info> searchIG601Info(IG601SearchCond cond){

		List<IG601Info> ret = ig601DAO.findByCond(cond,0,0);
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
	public List<IG601Info> searchIG601Info(IG601SearchCond cond, int start, int count){
		List<IG601Info> ret = ig601DAO.findByCond(cond,start,count);
		return ret;
	}
	
	/**
	 * ���������Ϣ����
	 * 
	 * @param ig601Info ������Ϣ
	 * @return �������ɵĻ���ID
	 * @throws BLException
	 */
	public Integer registIG601Info(IG601Info ig601Info) throws BLException{
		//����������Ϣ����
		IG013TB entityItemTB = new IG013TB();
		
		//����ģ��IDȡ��
		IG117SearchCondImpl cond = new IG117SearchCondImpl();
		cond.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM);
		
		//�ǼǴ���ǰ�Ļ�����Ϣȷ��
		List<IG117Info> entityList = ig117DAO.findByCond(cond, 0, 0);
		
		if ( entityList == null || entityList.size() ==0 ) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","����ģ�ͻ���");
		}
		
		IG117Info entity = entityList.get(0);
		entityItemTB.setEid(entity.getEid());
		entityItemTB.setEiname(ig601Info.getEiname());
		entityItemTB.setEilabel(ig601Info.getEilabel());
		entityItemTB.setEidesc(ig601Info.getEidesc());
		entityItemTB.setEiversion(1);
		entityItemTB.setEiinsdate(IGStringUtils.getCurrentDate());
		entityItemTB.setEiupdtime(IGStringUtils.getCurrentDateTime());
		entityItemTB.setEsyscoding("999007");
		IG013Info entityItem = ig013DAO.save(entityItemTB);
		//�����������������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_X_TOTAL,
				ig601Info.getX_total(),"����","���������",1);
		
		//�����������������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_Y_TOTAL,
				ig601Info.getY_total(),"����","���������",1);
		
		//��������������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_MANANGER,
				ig601Info.getManager(),"����","������",1);
		
		//��ϵ�绰��������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_TEL,
				ig601Info.getTel(),"����","��ϵ�绰",1);
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
	protected void insertConfigItem(IG013Info entityItem,
			String clabel,String civalue,String sErrParam0,String sErrParam1,
			Integer civersion) throws BLException {
		//1.��ѯ��������
		IG225SearchCondImpl configCond = new IG225SearchCondImpl();
		configCond.setClabel(clabel);
		
		//2.���Բ�ѯ
		List<IG225Info> configList = ig225DAO.findByCond(configCond, 0, 0);
		
		if ( configList == null || configList.size()==0 ) {
			throw new BLException("IGCO10000.E013",sErrParam0,sErrParam1);
		}
		
		//2.������������
		IG800TB configItemTB = new IG800TB();
		
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
		ig800DAO.save(configItemTB);
		
	}

	/**
	 * ɾ��������Ϣ����
	 * 
	 * @param ig601Info ɾ���Ļ�����Ϣ
	 * @return
	 * @throws BLException
	 */
	public void deleteIG601Info(IG601Info ig601Info) throws BLException{
		IG013Info ret = checkExistComputerRoom(ig601Info.getEiid());
		ig013DAO.delete(ret);
	}

	/**
	 * ���ݻ�������ɾ��������Ϣ����
	 * 
	 * @param eiid ɾ��������Ϣ������
	 * @return
	 * @throws BLException
	 */
	public void deleteIG601InfoByKey(Integer eiid) throws BLException{
		IG013Info ret = checkExistComputerRoom(eiid);
		ig013DAO.delete(ret);
	}

	/**
	 * ���������Ϣ����
	 * 
	 * @param ig601Info ���ǰ�Ļ�����Ϣ
	 * @throws BLException
	 */
	public void updateIG601Info(IG601Info ig601Info) throws BLException{
		IG013Info entityItem = checkExistComputerRoom(ig601Info.getEiid());
		
		//����������Ϣ����
		IG013TB entityItemTB = (IG013TB)SerializationUtils.clone(entityItem);
		int cur_version = entityItem.getEiversion() + 1;
		entityItemTB.setEiname(ig601Info.getEiname());
		entityItemTB.setEilabel(ig601Info.getEilabel());
		entityItemTB.setEidesc(ig601Info.getEidesc());
		entityItemTB.setEiversion(cur_version);
		entityItemTB.setEiupdtime(IGStringUtils.getCurrentDateTime());
		ig013DAO.save(entityItemTB);
		//�������������������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_X_TOTAL,
				ig601Info.getX_total(),"����","���������",cur_version);
		
		//�������������������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_Y_TOTAL,
				ig601Info.getY_total(),"����","���������",cur_version);
		
		//����������������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_MANANGER,
				ig601Info.getManager(),"����","������",cur_version);
		
		//��ϵ�绰����������
		insertConfigItem(entityItem,EntityItemKeyWords.CLABEL_TEL,
				ig601Info.getTel(),"����","��ϵ�绰",cur_version);
		
	}
	
	/**
	 * ������Ϣ���ڼ��
	 * 
	 * @param eiid ����ID
	 * @return ����������Ϣ
	 * @throws BLException 
	 */
	protected  IG013Info checkExistComputerRoom(Integer eiid) throws BLException{
		IG013Info info = ig013DAO.findByPK(eiid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","����");
		}
		
		return info;
	}



}
