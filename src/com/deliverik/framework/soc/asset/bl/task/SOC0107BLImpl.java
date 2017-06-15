package com.deliverik.framework.soc.asset.bl.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.SOC0606Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0109SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0606SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0107DAO;
import com.deliverik.framework.soc.asset.model.dao.SOC0109DAO;
import com.deliverik.framework.soc.asset.model.dao.SOC0129DAO;
import com.deliverik.framework.soc.asset.model.dao.SOC0606DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0107TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0118TB;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.IGStringUtils;

/**
 * �ʲ�����ҵ���߼�ʵ��
 * 
 */
public class SOC0107BLImpl extends BaseBLImpl implements SOC0107BL {

	/** ConfigItem DAO */
	protected SOC0107DAO soc0107DAO;
	
	/** ConfigItemVW DAO */
	protected SOC0129DAO soc0129DAO;
	
	/** Configuration DAO */
	protected SOC0109DAO soc0109DAO;
	
	
	protected SOC0118BL soc0118BL;
	
	/** soc0606 DAO */
	protected SOC0606DAO soc0606DAO;

	
	/**
	 * ConfigItemDAO�趨
	 *
	 * @param soc0107DAO ConfigItemDAO
	 */
	public void setSoc0107DAO(SOC0107DAO soc0107DAO) {
		this.soc0107DAO = soc0107DAO;
	}

	/**
	 * ConfigItemVWDAO�趨
	 *
	 * @param soc0129DAO ConfigItemVWDAO
	 */
	public void setSoc0129DAO(SOC0129DAO soc0129DAO) {
		this.soc0129DAO = soc0129DAO;
	}

	/**
	 * ConfigurationDAO�趨
	 *
	 * @param soc0109DAO ConfigurationDAO
	 */
	public void setSoc0109DAO(SOC0109DAO soc0109DAO) {
		this.soc0109DAO = soc0109DAO;
	}

	/**
	 * SOC0606DAO�趨
	 *
	 * @param SOC0606DAO SOC0606DAO
	 */
	public void setSoc0606DAO(SOC0606DAO soc0606dao) {
		soc0606DAO = soc0606dao;
	}
	
	/**
	 * soc0118BL�趨
	 *
	 * @param soc0118BL soc0118BL
	 */
	public void setSoc0118BL(SOC0118BL soc0118BL) {
		this.soc0118BL = soc0118BL;
	}

	/**
	 * <p>
	 * �µ��ʲ�������Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return �µ��ʲ�������Ϣ����ʵ��ȡ��
	 */

	public SOC0107TB getSOC0107Instance() {
		return new SOC0107TB();
	}

	/**
	 * �����ʲ�������Ϣ����ȡ���ʲ�������Ϣ
	 * 
	 * @param ciid �ʲ�������Ϣ����
	 * @return �ʲ�������Ϣ
	 * @throws BLException 
	 */
	public SOC0107Info searchSOC0107ByKey(Integer ciid) throws BLException{
		return checkExistSOC0107(ciid);
	}

	/**
	 * ���ݼ�������ȡ���ʲ�������Ϣ�б�ƽ̨��������ʹ��searchConfigItemVW�������м�����
	 * 
	 * @param cond �ʲ�������Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �ʲ�������Ϣ��������б�
	 */
	public List<SOC0107Info> searchSOC0107(SOC0107SearchCond cond, int start, int count){
		List<SOC0107Info> ret = soc0107DAO.findByCond(cond,0,0);
		return ret;
	}
	
	/**
	 * ���ݼ�������ȡ���ʲ�������Ϣ�б�ƽ̨��������ʹ��searchConfigItemVW�������м�����
	 * 
	 * @param cond �ʲ�������Ϣ��������
	 * @return �ʲ�������Ϣ��������б�
	 */
	public List<SOC0107Info> searchSOC0107(SOC0107SearchCond cond) {
		List<SOC0107Info> ret = soc0107DAO.findByCond(cond,0,0);
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
	public List<SOC0107Info> searchSOC0107HistoryByEiid(Integer eiid, Integer civersion, Integer cismallversion, String cname) throws BLException {
		//ȡ���ʲ�idΪeiid���ʲ��İ汾��
		SOC0118Info entityItem = soc0118BL.searchEntityItemByKey(eiid);
		if(entityItem==null){
			throw new BLException(BLErrorType.ENTITY_ITEM_ALREADY_EXISTS,
					"IGCO10000.E003","�ʲ�");
		}

		List<SOC0107Info> itemlist = new ArrayList<SOC0107Info>();		
		if(StringUtils.isNotEmpty(cname)){
			//ȡ�����������а���cnameֵ�����Լ���
			SOC0109SearchCondImpl cond = new SOC0109SearchCondImpl();
			cond.setCname(cname);
			List<SOC0109Info> list = soc0109DAO.findByCond(cond, 0, 0);
			for(SOC0109Info config:list){
				List<SOC0107Info> ret = new ArrayList<SOC0107Info>(); 
				SOC0107SearchCondImpl cond1 = new SOC0107SearchCondImpl();
				if(civersion==null){
					//�������а汾��������Ϣ
					cond1.setEiid(eiid.toString());
					cond1.setCid(config.getCid());
					ret = soc0107DAO.findByCond(cond1,0,0);
				}else if(civersion==-1){
					//�������°汾��������Ϣ
					cond1.setEiid(eiid.toString());
					cond1.setCid(config.getCid());
					cond1.setCiversion(String.valueOf(entityItem.getEiversion()));
					cond1.setCismallversion(entityItem.getEismallversion().toString());
					ret = soc0107DAO.findByCond(cond1,0,0);
				}else{
					//���ݴ���İ汾�ż�����Ӧ�汾��������Ϣ
					cond1.setEiid(eiid.toString());
					cond1.setCid(config.getCid());
					cond1.setCiversion(String.valueOf(civersion));
					cond1.setCismallversion(cismallversion.toString());
					ret = soc0107DAO.findByCond(cond1,0,0);
				}
				
				itemlist.addAll(ret);
			}
		}else{
			List<SOC0107Info> ret = new ArrayList<SOC0107Info>(); 
			SOC0107SearchCondImpl cond1 = new SOC0107SearchCondImpl();
			if(civersion==null){
				//�������а汾��������Ϣ
				cond1.setEiid(eiid.toString());
				ret = soc0107DAO.findByCond(cond1,0,0);
			}else if(civersion==-1){
				//�������°汾��������Ϣ
				cond1.setEiid(eiid.toString());
				cond1.setCiversion(String.valueOf(entityItem.getEiversion()));
				ret = soc0107DAO.findByCond(cond1,0,0);
			}else{
				//���ݴ���İ汾�ż�����Ӧ�汾��������Ϣ
				cond1.setEiid(eiid.toString());
				cond1.setCiversion(String.valueOf(civersion));
				ret = soc0107DAO.findByCond(cond1,0,0);
			}
			
			itemlist.addAll(ret);
		}
		

		return itemlist;
	}
	
	/**
	 * ���ݼ�������ȡ���ʲ�������Ϣ�б�
	 * 
	 * @param eiid �ʲ�ID
	 * @param civersion �ʲ����԰汾�� 
	 * 			<br>civersion:null�����ʲ��������а汾��������Ϣ��
	 * 			<br>civersion:-1�����ʲ��������°汾��������Ϣ��
	 * 			<br>civersion:����ֵ�����ʲ����Զ�Ӧ�汾��������Ϣ��
	 * @param cname �ʲ���������
	 * @return �ʲ�������Ϣ��������б�
	 */
	public List<SOC0107Info> searchSOC0107HistoryByEiid(Integer eiid, Integer civersion, String cname) throws BLException {
		//ȡ���ʲ�idΪeiid���ʲ��İ汾��
		SOC0118Info entityItem = soc0118BL.searchEntityItemByKey(eiid);
		if(entityItem==null){
			throw new BLException(BLErrorType.ENTITY_ITEM_ALREADY_EXISTS,
					"IGCO10000.E003","�ʲ�");
		}

		List<SOC0107Info> itemlist = new ArrayList<SOC0107Info>();		
		if(StringUtils.isNotEmpty(cname)){
			//ȡ�����������а���cnameֵ�����Լ���
			SOC0109SearchCondImpl cond = new SOC0109SearchCondImpl();
			cond.setCname(cname);
			List<SOC0109Info> list = soc0109DAO.findByCond(cond, 0, 0);
			for(SOC0109Info config:list){
				List<SOC0107Info> ret = new ArrayList<SOC0107Info>(); 
				SOC0107SearchCondImpl cond1 = new SOC0107SearchCondImpl();
				if(civersion==null){
					//�������а汾��������Ϣ
					cond1.setEiid(String.valueOf(eiid));
					cond1.setCid(config.getCid());
					ret = soc0107DAO.findByCond(cond1,0,0);
				}else if(civersion==-1){
					//�������°汾��������Ϣ
					cond1.setEiid(String.valueOf(eiid));
					cond1.setCid(config.getCid());
					cond1.setCiversion(String.valueOf(entityItem.getEiversion()));
					ret = soc0107DAO.findByCond(cond1,0,0);
				}else{
					//���ݴ���İ汾�ż�����Ӧ�汾��������Ϣ
					cond1.setEiid(String.valueOf(eiid));
					cond1.setCid(config.getCid());
					cond1.setCiversion(String.valueOf(civersion));
					ret = soc0107DAO.findByCond(cond1,0,0);
				}
				
				itemlist.addAll(ret);
			}
		}else{
			List<SOC0107Info> ret = new ArrayList<SOC0107Info>(); 
			SOC0107SearchCondImpl cond1 = new SOC0107SearchCondImpl();
			if(civersion==null){
				//�������а汾��������Ϣ
				cond1.setEiid(String.valueOf(eiid));
				ret = soc0107DAO.findByCond(cond1,0,0);
			}else if(civersion==-1){
				//�������°汾��������Ϣ
				cond1.setEiid(String.valueOf(eiid));
				cond1.setCiversion(String.valueOf(entityItem.getEiversion()));
				ret = soc0107DAO.findByCond(cond1,0,0);
			}else{
				//���ݴ���İ汾�ż�����Ӧ�汾��������Ϣ
				cond1.setEiid(String.valueOf(eiid));
				cond1.setCiversion(String.valueOf(civersion));
				ret = soc0107DAO.findByCond(cond1,0,0);
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
	 * @param configItem �ʲ�������Ϣ
	 * @return �������ʲ�������Ϣ
	 */
	public void saveSOC0107(int currentEiversion, SOC0107Info soc0107Info) throws BLException {
		//У��
		if(soc0107Info == null) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","�ʲ����Ի���");
		} else if(soc0107Info.getEiid() == null || soc0107Info.getEiid() <= 0){
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","�ʲ�����");
		} else if(soc0107Info.getCid() == null || soc0107Info.getCid() == ""){
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","�ʲ�ģ�����Ի���");
		}
		//��ѯ�����ʲ�
		SOC0118Info entityItem = soc0118BL.searchEntityItemByKey(soc0107Info.getEiid());
		
		if(currentEiversion != entityItem.getEiversion()) {
			throw new BLException("IGCO00000.E004");
		}
		
		//��ѯ�ʲ�����
		SOC0129SearchCondImpl cond = new SOC0129SearchCondImpl();
		cond.setEiid(entityItem.getEiid().toString());
		List<SOC0129Info> ciList = searchConfigItemVW(cond);
		//���°汾
		int version = entityItem.getEiversion() + 1;
		//�޸�ʱ��
		String ciupdtime = IGStringUtils.getCurrentDateTime();
		//�����ʲ�������Ϣ
		for(SOC0129Info ci : ciList) {
			SOC0107TB configItemTB = new SOC0107TB();
			//�ʲ�ID
			configItemTB.setEiid(Integer.parseInt(ci.getEiid()));
			//ģ������ID
			configItemTB.setCid(ci.getCid());
			//ģ��ID
			configItemTB.setEid(ci.getEid());
			//ģ�Ͳ����
			configItemTB.setEsyscoding(ci.getEsyscoding());
			//�汾��
			configItemTB.setCiversion(version);
			//����ʱ��
			configItemTB.setCiupdtime(ciupdtime);
			//������ID������滻����ֵ
			if(ci.getCid().equals(soc0107Info.getCid().toString())) {
				configItemTB.setCivalue(soc0107Info.getCivalue());
			} else {
				configItemTB.setCivalue(ci.getCivalue());
			}
			soc0107DAO.save(configItemTB);
		}
		
		//�޸��ʲ�������Ϣ
		SOC0118TB entityItemTB = (SOC0118TB)SerializationUtils.clone(entityItem);
		
		entityItemTB.setEiversion(version);
		
		entityItemTB.setEiupdtime(ciupdtime);
		
		soc0118BL.updateEntityItem(entityItemTB);
		
	}
	
	/**
	 * ����ͬһ�ʲ����������Ϣ������������ͳһ����һ���汾<br>
	 * ConfigItemʵ�����������cid��civalueֵ����
	 * 
	 * @param eiid �ʲ�ID
	 * @param currentEiversion ��ǰ�ʲ��汾��(����ǰ)
	 * @param configItemList ������ʲ�������Ϣ���ݼ���
	 */
	public void saveSOC0107(Integer eiid, int currentEiversion, List<SOC0107Info> soc0107InfoList) throws BLException {
		if(eiid == null || eiid <= 0){
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","�ʲ�����");
		} else if(soc0107InfoList == null || soc0107InfoList.size() == 0) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","�ʲ����Ի���");
		}
		//��ѯ�����ʲ�
		SOC0118Info entityItem = soc0118BL.searchEntityItemByKey(eiid);
		
		if(currentEiversion != entityItem.getEiversion()) {
			throw new BLException("IGCO00000.E004");
		}
		
		//���°汾
		int version = entityItem.getEiversion() + 1;
		//�޸�ʱ��
		String ciupdtime = IGStringUtils.getCurrentDateTime();
		//��ѯ�ʲ�����
		SOC0129SearchCondImpl cond = new SOC0129SearchCondImpl();
		cond.setEiid(eiid.toString());
		//2014��8.29���-Ϊ�ɹ�����
		cond.setEsyscoding_q(entityItem.getEsyscoding());
		List<SOC0129Info> ciList = searchConfigItemVW(cond);
		//�����ʲ�������Ϣ
		for(SOC0129Info ci : ciList) {
			SOC0107TB configItemTB = new SOC0107TB();
			//�ʲ�ID
			configItemTB.setEiid(Integer.parseInt(ci.getEiid()));
			//ģ������ID
			configItemTB.setCid(ci.getCid());
			//ģ��ID
			configItemTB.setEid(ci.getEid());
			//ģ�Ͳ����
			configItemTB.setEsyscoding(ci.getEsyscoding());
			//�汾��
			configItemTB.setCiversion(version);
			//����ʱ��
			configItemTB.setCiupdtime(ciupdtime);
			
			configItemTB.setCivalue(ci.getCivalue());
			//�ʲ����� - С�汾����ΪNULL
			configItemTB.setCismallversion(ci.getCismallversion());
			for(SOC0107Info soc0107Info : soc0107InfoList) {
				//У��
				if(soc0107Info.getCid() == null || soc0107Info.getCid() == ""){
					throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
							"IGCO10000.E004","�ʲ�ģ�����Ի���");
				}
				//������ID������滻����ֵ
				if(ci.getCid().equals(soc0107Info.getCid().toString())) {
					configItemTB.setCivalue(soc0107Info.getCivalue());
					continue;
				}
			}
			soc0107DAO.save(configItemTB);
		}
		
		//�޸��ʲ�������Ϣ
		SOC0118TB entityItemTB = (SOC0118TB)SerializationUtils.clone(entityItem);
		
		entityItemTB.setEiversion(version);
		
		entityItemTB.setEiupdtime(ciupdtime);
		
		soc0118BL.updateEntityItem(entityItemTB);
		
	}
	
	
	/**
	 * �����ʲ�������Ϣ����ƽ̨������
	 * 
	 * @param configItem ������ʲ�������Ϣ����
	 * @return �ʲ�������Ϣ
	 */
	public SOC0107Info registSOC0107(SOC0107Info configItem) throws BLException {
		SOC0107Info ret = soc0107DAO.save(configItem);
		return ret;
	}

	/**
	 * ���ݼ�������ȡ���ʲ�������Ϣ���������ƽ̨��������ʹ��getConfigItemVWSearchCount�������м�����
	 * 
	 * @param cond �ʲ�������Ϣ��������
	 * @return �ʲ�������Ϣ�������
	 */
	public int getSOC0107SearchCount(SOC0107SearchCond cond) {
		return soc0107DAO.getSearchCount(cond);
	}

	

	/**
	 * ����ʲ�������Ϣ����ƽ̨������
	 * 
	 * @param configItem ������ʲ�������Ϣ����
	 * @return �ʲ�������Ϣ
	 */
	public SOC0107Info updateSOC0107(SOC0107Info soc0107Info) throws BLException {
		checkExistSOC0107(soc0107Info.getCiid());
		SOC0107Info ret = soc0107DAO.save(soc0107Info);
		return ret;
	}
	
	/**
	 * �ʲ�������Ϣ���ڼ��
	 * 
	 * @param ciid �ʲ�����ID
	 * @return �ʲ�������Ϣ
	 * @throws BLException 
	 */
	protected SOC0107Info checkExistSOC0107(Integer ciid) throws BLException{//������
		SOC0107Info info = soc0107DAO.findByPK(ciid);
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
	public int getConfigItemVWSearchCount(SOC0129SearchCond cond){

		return soc0129DAO.getSearchCount(cond);
	}

	/**
	 * ���ݼ�������ȡ���ʲ�������Ϣ�б�
	 * 
	 * @param cond �ʲ�������Ϣ��������
	 * @return �ʲ�������Ϣ��������б�
	 */
	public List<SOC0129Info> searchConfigItemVW(SOC0129SearchCond cond){
		List<SOC0129Info> ret = soc0129DAO.findByCond(cond,0,0);
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
	public List<SOC0129Info> searchConfigItemVW(SOC0129SearchCond cond, int start, int count){

		List<SOC0129Info> ret = soc0129DAO.findByCond(cond,start,count);
		return ret;
	}
	
	/**
	 * ���ݴ�汾��ȡ�ʲ����С�汾
	 * @param eiid �ʲ�ID
	 * @param civersion �ʲ���汾��
	 * @return ���С�汾
	 */
	public Integer searchEiMaxSmallVersion(Integer eiid, Integer civersion) {
		return this.soc0107DAO.searchEiMaxSmallVersion(eiid, civersion);
	}

	public String getHostEiid(SOC0107SearchCondImpl cond) throws BLException {
		return this.soc0107DAO.getHostEiid(cond);
	}
	public List<SOC0107Info> getConfigItemByEid(SOC0107SearchCondImpl cond){
		return this.soc0107DAO.getConfigItemByEid(cond);
	}

	/**
	 * ���ݼ�������ȡ���ʲ�������Ϣ�������
	 * 
	 * @param cond �ʲ�������Ϣ��������
	 * @return �ʲ�������Ϣ�������
	 */
	public int getSOC0606InfoSearchCount(SOC0606SearchCond cond){

		return soc0606DAO.getSearchCount(cond);
	}
	
	/**
	 * ���ݼ�������ȡ���ʲ�������Ϣ�б�
	 * 
	 * @param cond �ʲ�������Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �ʲ�������Ϣ��������б�
	 */
	public List<SOC0606Info> searchSOC0606Info(SOC0606SearchCond cond, int start, int count){

		List<SOC0606Info> ret = soc0606DAO.findByCond(cond,start,count);
		return ret;
	}
	
	/**
	 * �������Ի�ȡ�ʲ���Ϣ
	 * @param value ���Լ���
	 * @return �ʲ���Ϣ����
	 * @throws BLException
	 */
	public List<Integer> searchEiByCname(Map<String, String> value) throws BLException {
		return this.soc0107DAO.searchEiByCname(value);
	}
	
	/**
	 * ���ݼ�������ȡ���ʲ�������Ϣ�б� �������ʲ�ר��
	 * 
	 * @param cond �ʲ�������Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �ʲ�������Ϣ��������б�
	 */
	public List<SOC0129Info> searchConfigItemSoc0109VW(SOC0129SearchCond cond, int start, int count){

		List<SOC0129Info> ret = soc0129DAO.findByCondSoc0109(cond,start,count);
		return ret;
	}


	/**
	 * �����ʲ�id��config id ��ѯ�����������̽ڵ���ڵ��������Ϣ
	 * @param cid config id
	 * @param eiid �ʲ�id
	 * @return
	 * @throws BLException
	 */
	public List<Map<String, Object>> searchProcessDefineUserByEiidInfo(String cid, Integer eiid) throws BLException {
		return soc0107DAO.searchProcessDefineUserByEiidInfo(cid,eiid);
	}
}
