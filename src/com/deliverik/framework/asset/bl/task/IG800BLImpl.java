package com.deliverik.framework.asset.bl.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.asset.model.IG002Info;
import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.asset.model.IG225Info;
import com.deliverik.framework.asset.model.IG800Info;
import com.deliverik.framework.asset.model.condition.IG002SearchCond;
import com.deliverik.framework.asset.model.condition.IG002SearchCondImpl;
import com.deliverik.framework.asset.model.condition.IG225SearchCondImpl;
import com.deliverik.framework.asset.model.condition.IG800SearchCond;
import com.deliverik.framework.asset.model.condition.IG800SearchCondImpl;
import com.deliverik.framework.asset.model.dao.IG002DAO;
import com.deliverik.framework.asset.model.dao.IG225DAO;
import com.deliverik.framework.asset.model.dao.IG800DAO;
import com.deliverik.framework.asset.model.entity.IG013TB;
import com.deliverik.framework.asset.model.entity.IG800TB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.IGStringUtils;

/**
 * �ʲ�����ҵ���߼�ʵ��
 * 
 */
public class IG800BLImpl extends BaseBLImpl implements IG800BL {

	/** ConfigItem DAO */
	protected IG800DAO ig800DAO;
	
	/** ig002 DAO */
	protected IG002DAO ig002DAO;
	
	/** Ig225 DAO */
	protected IG225DAO ig225DAO;
	
	
	protected IG013BL ig013BL;
	
	public void setIg013BL(IG013BL ig013BL) {
		this.ig013BL = ig013BL;
	}

	public void setIg225DAO(IG225DAO ig225DAO) {
		this.ig225DAO = ig225DAO;
	}

	public void setIg800DAO(IG800DAO ig800DAO) {
		this.ig800DAO = ig800DAO;
	}

	public void setIg002DAO(IG002DAO ig002DAO) {
		this.ig002DAO = ig002DAO;
	}
	
	/**
	 * <p>
	 * �µ��ʲ�������Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return �µ��ʲ�������Ϣ����ʵ��ȡ��
	 */

	public IG800TB getIG800TBInstance() {
		return new IG800TB();
	}

	/**
	 * �����ʲ�������Ϣ����ȡ���ʲ�������Ϣ
	 * 
	 * @param ciid �ʲ�������Ϣ����
	 * @return �ʲ�������Ϣ
	 * @throws BLException 
	 */
	public IG800Info searchIG800InfoByKey(Integer ciid) throws BLException{
		return checkExistConfigItem(ciid);
	}

	/**
	 * ���ݼ�������ȡ���ʲ�������Ϣ�б�ƽ̨��������ʹ��searchConfigItemVW�������м�����
	 * 
	 * @param cond �ʲ�������Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �ʲ�������Ϣ��������б�
	 */
	public List<IG800Info> searchIG800Info(IG800SearchCond cond, int start, int count){
		List<IG800Info> ret = ig800DAO.findByCond(cond,0,0);
		return ret;
	}
	
	/**
	 * ���ݼ�������ȡ���ʲ�������Ϣ�б�ƽ̨��������ʹ��searchConfigItemVW�������м�����
	 * 
	 * @param cond �ʲ�������Ϣ��������
	 * @return �ʲ�������Ϣ��������б�
	 */
	public List<IG800Info> searchIG800Info(IG800SearchCond cond) {
		List<IG800Info> ret = ig800DAO.findByCond(cond,0,0);
		return ret;
	}
	
	/**
	 * ���ݼ�������ȡ���ʲ�������Ϣ�б�
	 * 
	 * @param eiid �ʲ�ID
	 * @param civersion �ʲ����Դ�汾�� 
	 * 			<br>civersion:null�����ʲ��������а汾��������Ϣ��
	 * 			<br>civersion:-1�����ʲ��������°汾��������Ϣ��
	 * 			<br>civersion:����ֵ�����ʲ����Զ�Ӧ�汾��������Ϣ��
	 * @param cismallversion �ʲ�����С�汾��
	 * @param cname �ʲ���������(ģ����ѯ����)
	 * @return �ʲ�������Ϣ��������б�
	 */
	public List<IG800Info> searchIG800InfoHistoryByEiid(Integer eiid, Integer civersion, Integer cismallversion, String cname) throws BLException {
		//ȡ���ʲ�idΪeiid���ʲ��İ汾��
		IG013Info entityItem = ig013BL.searchIG013InfoByKey(eiid);
		if(entityItem==null){
			throw new BLException(BLErrorType.ENTITY_ITEM_ALREADY_EXISTS,
					"IGCO10000.E003","�ʲ�");
		}

		List<IG800Info> itemlist = new ArrayList<IG800Info>();		
		if(StringUtils.isNotEmpty(cname)){
			//ȡ�����������а���cnameֵ�����Լ���
			IG225SearchCondImpl cond = new IG225SearchCondImpl();
			cond.setCname(cname);
			List<IG225Info> list = ig225DAO.findByCond(cond, 0, 0);
			for(IG225Info config:list){
				List<IG800Info> ret = new ArrayList<IG800Info>(); 
				IG800SearchCondImpl cond1 = new IG800SearchCondImpl();
				if(civersion==null){
					//�������а汾��������Ϣ
					cond1.setEiid(eiid);
					cond1.setCid(config.getCid());
					ret = ig800DAO.findByCond(cond1,0,0);
				}else if(civersion==-1){
					//�������°汾��������Ϣ
					cond1.setEiid(eiid);
					cond1.setCid(config.getCid());
					cond1.setCiversion(String.valueOf(entityItem.getEiversion()));
					cond1.setCismallversion(entityItem.getEismallversion().toString());
					ret = ig800DAO.findByCond(cond1,0,0);
				}else{
					//���ݴ���İ汾�ż�����Ӧ�汾��������Ϣ
					cond1.setEiid(eiid);
					cond1.setCid(config.getCid());
					cond1.setCiversion(String.valueOf(civersion));
					cond1.setCismallversion(cismallversion.toString());
					ret = ig800DAO.findByCond(cond1,0,0);
				}
				
				itemlist.addAll(ret);
			}
		}else{
			List<IG800Info> ret = new ArrayList<IG800Info>(); 
			IG800SearchCondImpl cond1 = new IG800SearchCondImpl();
			if(civersion==null){
				//�������а汾��������Ϣ
				cond1.setEiid(eiid);
				ret = ig800DAO.findByCond(cond1,0,0);
			}else if(civersion==-1){
				//�������°汾��������Ϣ
				cond1.setEiid(eiid);
				cond1.setCiversion(String.valueOf(entityItem.getEiversion()));
				ret = ig800DAO.findByCond(cond1,0,0);
			}else{
				//���ݴ���İ汾�ż�����Ӧ�汾��������Ϣ
				cond1.setEiid(eiid);
				cond1.setCiversion(String.valueOf(civersion));
				ret = ig800DAO.findByCond(cond1,0,0);
			}
			
			itemlist.addAll(ret);
		}
		

		return itemlist;
	}
	
	/**
	 * �����ʲ�������Ϣ������������ͳһ����һ���汾<br>
	 * ConfigItemʵ�����������eiid,cid��civalueֵ����
	 * 
	 * @param currentEiversion ��ǰ�ʲ��汾��(����ǰ)
	 * @param ig800Info �ʲ�������Ϣ
	 * @return �������ʲ�������Ϣ
	 */
	public void saveIG800Info(int currentEiversion, IG800Info ig800Info) throws BLException {
		//У��
		if(ig800Info == null) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","�ʲ����Ի���");
		} else if(ig800Info.getEiid() == null || ig800Info.getEiid() <= 0){
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","�ʲ�����");
		} else if(ig800Info.getCid() == null || ig800Info.getCid() <= 0){
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","�ʲ�ģ�����Ի���");
		}
		//��ѯ�����ʲ�
		IG013Info entityItem = ig013BL.searchIG013InfoByKey(ig800Info.getEiid());
		
		if(currentEiversion != entityItem.getEiversion()) {
			throw new BLException("IGCO00000.E004");
		}
		
		//��ѯ�ʲ�����
		IG002SearchCondImpl cond = new IG002SearchCondImpl();
		cond.setEiid(entityItem.getEiid());
		List<IG002Info> ciList = searchIG002Info(cond);
		//���°汾
		int version = entityItem.getEiversion() + 1;
		//�޸�ʱ��
		String ciupdtime = IGStringUtils.getCurrentDateTime();
		//�����ʲ�������Ϣ
		for(IG002Info ci : ciList) {
			IG800TB configItemTB = new IG800TB();
			//�ʲ�ID
			configItemTB.setEiid(Integer.parseInt(ci.getEiid()));
			//ģ������ID
			configItemTB.setCid(Integer.parseInt(ci.getCid()));
			//ģ��ID
			configItemTB.setEid(Integer.parseInt(ci.getEid()));
			//ģ�Ͳ����
			configItemTB.setEsyscoding(ci.getEsyscoding());
			//�汾��
			configItemTB.setCiversion(version);
			//����ʱ��
			configItemTB.setCiupdtime(ciupdtime);
			//������ID������滻����ֵ
			if(ci.getCid().equals(ig800Info.getCid().toString())) {
				configItemTB.setCivalue(ig800Info.getCivalue());
			} else {
				configItemTB.setCivalue(ci.getCivalue());
			}
			ig800DAO.save(configItemTB);
		}
		
		//�޸��ʲ�������Ϣ
		IG013TB entityItemTB = (IG013TB)SerializationUtils.clone(entityItem);
		
		entityItemTB.setEiversion(version);
		
		entityItemTB.setEiupdtime(ciupdtime);
		
		ig013BL.updateIG013Info(entityItemTB);
		
	}
	
	/**
	 * ����ͬһ�ʲ����������Ϣ������������ͳһ����һ���汾<br>
	 * ConfigItemʵ�����������cid��civalueֵ����
	 * 
	 * @param eiid �ʲ�ID
	 * @param currentEiversion ��ǰ�ʲ��汾��(����ǰ)
	 * @param ig800InfoList ������ʲ�������Ϣ���ݼ���
	 */
	public void saveIG800Info(Integer eiid, int currentEiversion, List<IG800Info> ig800InfoList) throws BLException {
		if(eiid == null || eiid <= 0){
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","�ʲ�����");
		} else if(ig800InfoList == null || ig800InfoList.size() == 0) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","�ʲ����Ի���");
		}
		//��ѯ�����ʲ�
		IG013Info entityItem = ig013BL.searchIG013InfoByKey(eiid);
		
		if(currentEiversion != entityItem.getEiversion()) {
			throw new BLException("IGCO00000.E004");
		}
		
		//���°汾
		int version = entityItem.getEiversion() + 1;
		//�޸�ʱ��
		String ciupdtime = IGStringUtils.getCurrentDateTime();
		//��ѯ�ʲ�����
		IG002SearchCondImpl cond = new IG002SearchCondImpl();
		cond.setEiid(eiid);
		List<IG002Info> ciList = searchIG002Info(cond);
		//�����ʲ�������Ϣ
		for(IG002Info ci : ciList) {
			IG800TB configItemTB = new IG800TB();
			//�ʲ�ID
			configItemTB.setEiid(Integer.parseInt(ci.getEiid()));
			//ģ������ID
			configItemTB.setCid(Integer.parseInt(ci.getCid()));
			//ģ��ID
			configItemTB.setEid(Integer.parseInt(ci.getEid()));
			//ģ�Ͳ����
			configItemTB.setEsyscoding(ci.getEsyscoding());
			//�汾��
			configItemTB.setCiversion(version);
			//����ʱ��
			configItemTB.setCiupdtime(ciupdtime);
			
			configItemTB.setCivalue(ci.getCivalue());
			
			for(IG800Info configItem : ig800InfoList) {
				//У��
				if(configItem.getCid() == null || configItem.getCid() <= 0){
					throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
							"IGCO10000.E004","�ʲ�ģ�����Ի���");
				}
				//������ID������滻����ֵ
				if(ci.getCid().equals(configItem.getCid().toString())) {
					configItemTB.setCivalue(configItem.getCivalue());
					continue;
				}
			}
			ig800DAO.save(configItemTB);
		}
		
		//�޸��ʲ�������Ϣ
		IG013TB entityItemTB = (IG013TB)SerializationUtils.clone(entityItem);
		
		entityItemTB.setEiversion(version);
		
		entityItemTB.setEiupdtime(ciupdtime);
		
		ig013BL.updateIG013Info(entityItemTB);
		
	}
	
	
	/**
	 * �����ʲ�������Ϣ����ƽ̨������
	 * 
	 * @param ig800Info ������ʲ�������Ϣ����
	 * @return �ʲ�������Ϣ
	 */
	public IG800Info registIG800Info(IG800Info ig800Info) throws BLException {
		IG800Info ret = ig800DAO.save(ig800Info);
		return ret;
	}

	/**
	 * ���ݼ�������ȡ���ʲ�������Ϣ���������ƽ̨��������ʹ��getConfigItemVWSearchCount�������м�����
	 * 
	 * @param cond �ʲ�������Ϣ��������
	 * @return �ʲ�������Ϣ�������
	 */
	public int getIG800InfoSearchCount(IG800SearchCond cond) {
		return ig800DAO.getSearchCount(cond);
	}

	

	/**
	 * ����ʲ�������Ϣ����ƽ̨������
	 * 
	 * @param ig800Info ������ʲ�������Ϣ����
	 * @return �ʲ�������Ϣ
	 */
	public IG800Info updateIG800Info(IG800Info ig800Info) throws BLException {
		checkExistConfigItem(ig800Info.getCiid());
		IG800Info ret = ig800DAO.save(ig800Info);
		return ret;
	}
	
	/**
	 * �ʲ�������Ϣ���ڼ��
	 * 
	 * @param ciid �ʲ�����ID
	 * @return �ʲ�������Ϣ
	 * @throws BLException 
	 */
	protected IG800Info checkExistConfigItem(Integer ciid) throws BLException{//������
		IG800Info info = ig800DAO.findByPK(ciid);
		if(info == null) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","�ʲ����Ի���");
		}
		return info;
	}
	
	/**
	 * ���ݼ�������ȡ���ʲ�������Ϣ�������
	 * 
	 * @param cond �ʲ�������Ϣ��������
	 * @return �ʲ�������Ϣ�������
	 */
	public int getIG002InfoSearchCount(IG002SearchCond cond){

		return ig002DAO.getSearchCount(cond);
	}

	/**
	 * ���ݼ�������ȡ���ʲ�������Ϣ�б�
	 * 
	 * @param cond �ʲ�������Ϣ��������
	 * @return �ʲ�������Ϣ��������б�
	 */
	public List<IG002Info> searchIG002Info(IG002SearchCond cond){
		List<IG002Info> ret = ig002DAO.findByCond(cond,0,0);
		return ret;
	}
	
	/**
	 * ���ݼ�������ȡ���ʲ�������Ϣ�б�
	 * 
	 * @param cond �ʲ�������Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �ʲ�������Ϣ��������б�
	 */
	public List<IG002Info> searchIG002Info(IG002SearchCond cond, int start, int count){

		List<IG002Info> ret = ig002DAO.findByCond(cond,start,count);
		return ret;
	}

	/**
	 * �Ǽǳ�ʼ��ʱ���ݼ�������ȡ���ʲ�������Ϣ�б�
	 * 
	 * @param cond �ʲ�������Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �ʲ�������Ϣ��������б�
	 */
	public List<IG002Info> initSearchIG002Info(IG002SearchCond cond, int start, int count){
		
		List<IG002Info> ret = ig002DAO.initFindByCond(cond);
		return ret;
	}
	
	/**
	 * ���ݴ�汾��ȡ�ʲ����С�汾
	 * @param eiid �ʲ�ID
	 * @param civersion �ʲ���汾��
	 * @return ���С�汾
	 */
	public Integer searchEiMaxSmallVersion(Integer eiid, Integer civersion) {
		return this.ig800DAO.searchEiMaxSmallVersion(eiid, civersion);
	}

	/**
	 * �������Ի�ȡ�ʲ���Ϣ
	 * @param value ���Լ���
	 * @return �ʲ���Ϣ����
	 * @throws BLException
	 */
	public List<Integer> searchEiByCname(Map<String, String> value) throws BLException {
		return this.ig800DAO.searchEiByCname(value);
	}
}
