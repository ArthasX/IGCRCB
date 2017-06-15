package com.deliverik.framework.soc.asset.bl.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0107VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0109VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0118VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0107VWSearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0107VWSearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0109VWSearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0107VWDAO;
import com.deliverik.framework.soc.asset.model.dao.SOC0109VWDAO;
import com.deliverik.framework.soc.asset.model.dao.SOC0129DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0107VW;
import com.deliverik.framework.soc.asset.model.entity.SOC0107VWPK;
import com.deliverik.framework.soc.asset.model.entity.SOC0118VWPK;
import com.deliverik.framework.utility.BLErrorType;

/**
 * �ʲ�����ҵ���߼�ʵ��
 * 
 */
public class SOC0107VWBLImpl extends BaseBLImpl implements SOC0107VWBL {

	/** ConfigItem DAO */
	protected SOC0107VWDAO soc0107VWDAO;
	
	/** Configuration DAO */
	protected SOC0109VWDAO soc0109VWDAO;
	
	protected SOC0118VWBL soc0118VWBL;

	protected SOC0129DAO soc0129DAO;
   

	/**
	 * @param soc0129dao the soc0129DAO to set
	 */
	public void setSoc0129DAO(SOC0129DAO soc0129dao) {
		soc0129DAO = soc0129dao;
	}

	/**
	 * @param soc0107vwdao the soc0107VWDAO to set
	 */
	public void setSoc0107VWDAO(SOC0107VWDAO soc0107vwdao) {
		soc0107VWDAO = soc0107vwdao;
	}

	/**
	 * @param soc0109vwdao the soc0109VWDAO to set
	 */
	public void setSoc0109VWDAO(SOC0109VWDAO soc0109vwdao) {
		soc0109VWDAO = soc0109vwdao;
	}

	/**
	 * @param soc0118vwbl the soc0118VWBL to set
	 */
	public void setSoc0118VWBL(SOC0118VWBL soc0118vwbl) {
		soc0118VWBL = soc0118vwbl;
	}

	/**
	 * <p>
	 * �µ��ʲ�������Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return �µ��ʲ�������Ϣ����ʵ��ȡ��
	 */

	public SOC0107VW getSOC0107VWInstance() {
		return new SOC0107VW();
	}

	/**
	 * �����ʲ�������Ϣ����ȡ���ʲ�������Ϣ
	 * 
	 * @param ciid �ʲ�������Ϣ����
	 * @return �ʲ�������Ϣ
	 * @throws BLException 
	 */
	public SOC0107VWInfo searchSOC0107VWByKey(SOC0107VWPK pk) throws BLException{
		return checkExistSOC0107VW(pk);
	}

	/**
	 * ���ݼ�������ȡ���ʲ�������Ϣ�б�ƽ̨��������ʹ��searchConfigItemVW�������м�����
	 * 
	 * @param cond �ʲ�������Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �ʲ�������Ϣ��������б�
	 */
	public List<SOC0107VWInfo> searchSOC0107VW(SOC0107VWSearchCond cond, int start, int count){
		List<SOC0107VWInfo> ret = soc0107VWDAO.findByCond(cond,0,0);
		return ret;
	}
	
	/**
	 * ���ݼ�������ȡ���ʲ�������Ϣ�б�ƽ̨��������ʹ��searchConfigItemVW�������м�����
	 * 
	 * @param cond �ʲ�������Ϣ��������
	 * @return �ʲ�������Ϣ��������б�
	 */
	public List<SOC0107VWInfo> searchSOC0107VW(SOC0107VWSearchCond cond) {
		List<SOC0107VWInfo> ret = soc0107VWDAO.findByCond(cond,0,0);
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
	public List<SOC0107VWInfo> searchSOC0107VWHistoryByEiid(Integer eiid, Integer civersion, Integer cismallversion, String cname) throws BLException {
		//ȡ���ʲ�idΪeiid���ʲ��İ汾��
//		SOC0118VWInfo entityItem = soc0118VWBL.searchEntityItemByKey(new SOC0118VWPK(1, eiid));
//		if(entityItem==null){
//			throw new BLException(BLErrorType.ENTITY_ITEM_ALREADY_EXISTS,
//					"IGCO10000.E003","�ʲ�");
//		}

		List<SOC0107VWInfo> itemlist = new ArrayList<SOC0107VWInfo>();		
//		if(StringUtils.isNotEmpty(cname)){
//			//ȡ�����������а���cnameֵ�����Լ���
//			SOC0109SearchCondImpl cond = new SOC0109SearchCondImpl();
//			cond.setCname(cname);
//			List<SOC0109Info> list = soc0109VWDAO.findByCond(cond, 0, 0);
//			for(SOC0109Info config:list){
//				List<SOC0107VWInfo> ret = new ArrayList<SOC0107VWInfo>(); 
//				SOC0107VWSearchCondImpl cond1 = new SOC0107VWSearchCondImpl();
//				if(civersion==null){
//					//�������а汾��������Ϣ
//					cond1.setEiid(eiid.toString());
//					cond1.setCid(config.getCid());
//					ret = soc0107VWDAO.findByCond(cond1,0,0);
//				}else if(civersion==-1){
//					//�������°汾��������Ϣ
//					cond1.setEiid(eiid.toString());
//					cond1.setCid(config.getCid());
//					cond1.setCiversion(String.valueOf(entityItem.getEiversion()));
//					cond1.setCismallversion(entityItem.getEismallversion().toString());
//					ret = soc0107VWDAO.findByCond(cond1,0,0);
//				}else{
//					//���ݴ���İ汾�ż�����Ӧ�汾��������Ϣ
//					cond1.setEiid(eiid.toString());
//					cond1.setCid(config.getCid());
//					cond1.setCiversion(String.valueOf(civersion));
//					cond1.setCismallversion(cismallversion.toString());
//					ret = soc0107VWDAO.findByCond(cond1,0,0);
//				}
//				
//				itemlist.addAll(ret);
//			}
//		}else{
//			List<SOC0107VWInfo> ret = new ArrayList<SOC0107VWInfo>(); 
//			SOC0107VWSearchCondImpl cond1 = new SOC0107VWSearchCondImpl();
//			if(civersion==null){
//				//�������а汾��������Ϣ
//				cond1.setEiid(eiid.toString());
//				ret = soc0107VWDAO.findByCond(cond1,0,0);
//			}else if(civersion==-1){
//				//�������°汾��������Ϣ
//				cond1.setEiid(eiid.toString());
//				cond1.setCiversion(String.valueOf(entityItem.getEiversion()));
//				ret = soc0107VWDAO.findByCond(cond1,0,0);
//			}else{
//				//���ݴ���İ汾�ż�����Ӧ�汾��������Ϣ
//				cond1.setEiid(eiid.toString());
//				cond1.setCiversion(String.valueOf(civersion));
//				ret = soc0107VWDAO.findByCond(cond1,0,0);
//			}
			
//			itemlist.addAll(ret);
//		}
		

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
//	public List<SOC0107VWInfo> searchSOC0107VWHistoryByEiid(Integer eiid, Integer civersion, String cname) throws BLException {
//		//ȡ���ʲ�idΪeiid���ʲ��İ汾��
//		SOC0118VWInfo entityItem = soc0118VWBL.searchEntityItemByKey(eiid);
//		if(entityItem==null){
//			throw new BLException(BLErrorType.ENTITY_ITEM_ALREADY_EXISTS,
//					"IGCO10000.E003","�ʲ�");
//		}
//
//		List<SOC0107VWInfo> itemlist = new ArrayList<SOC0107VWInfo>();		
//		if(StringUtils.isNotEmpty(cname)){
//			//ȡ�����������а���cnameֵ�����Լ���
//			SOC0109SearchCondImpl cond = new SOC0109SearchCondImpl();
//			cond.setCname(cname);
//			List<SOC0109Info> list = soc0109VWDAO.findByCond(cond, 0, 0);
//			for(SOC0109Info config:list){
//				List<SOC0107VWInfo> ret = new ArrayList<SOC0107VWInfo>(); 
//				SOC0107VWSearchCondImpl cond1 = new SOC0107VWSearchCondImpl();
//				if(civersion==null){
//					//�������а汾��������Ϣ
//					cond1.setEiid(String.valueOf(eiid));
//					cond1.setCid(config.getCid());
//					ret = soc0107VWDAO.findByCond(cond1,0,0);
//				}else if(civersion==-1){
//					//�������°汾��������Ϣ
//					cond1.setEiid(String.valueOf(eiid));
//					cond1.setCid(config.getCid());
//					cond1.setCiversion(String.valueOf(entityItem.getEiversion()));
//					ret = soc0107VWDAO.findByCond(cond1,0,0);
//				}else{
//					//���ݴ���İ汾�ż�����Ӧ�汾��������Ϣ
//					cond1.setEiid(String.valueOf(eiid));
//					cond1.setCid(config.getCid());
//					cond1.setCiversion(String.valueOf(civersion));
//					ret = soc0107VWDAO.findByCond(cond1,0,0);
//				}
//				
//				itemlist.addAll(ret);
//			}
//		}else{
//			List<SOC0107VWInfo> ret = new ArrayList<SOC0107VWInfo>(); 
//			SOC0107VWSearchCondImpl cond1 = new SOC0107VWSearchCondImpl();
//			if(civersion==null){
//				//�������а汾��������Ϣ
//				cond1.setEiid(String.valueOf(eiid));
//				ret = soc0107VWDAO.findByCond(cond1,0,0);
//			}else if(civersion==-1){
//				//�������°汾��������Ϣ
//				cond1.setEiid(String.valueOf(eiid));
//				cond1.setCiversion(String.valueOf(entityItem.getEiversion()));
//				ret = soc0107VWDAO.findByCond(cond1,0,0);
//			}else{
//				//���ݴ���İ汾�ż�����Ӧ�汾��������Ϣ
//				cond1.setEiid(String.valueOf(eiid));
//				cond1.setCiversion(String.valueOf(civersion));
//				ret = soc0107VWDAO.findByCond(cond1,0,0);
//			}
//			
//			itemlist.addAll(ret);
//		}
//		
//
//		return itemlist;
//	}
	
	/**
	 * �����ʲ�������Ϣ������������ͳһ����һ���汾<br>
	 * ConfigItemʵ�����������eiid,cid��civalueֵ����
	 * 
	 * @param currentEiversion ��ǰ�ʲ��汾��(����ǰ)
	 * @param configItem �ʲ�������Ϣ
	 * @return �������ʲ�������Ϣ
	 */
//	public void saveSOC0107VW(int currentEiversion, SOC0107VWInfo SOC0107VWInfo) throws BLException {
//		//У��
//		if(SOC0107VWInfo == null) {
//			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
//					"IGCO10000.E004","�ʲ����Ի���");
//		} else if(SOC0107VWInfo.getEiid() == null || SOC0107VWInfo.getEiid() <= 0){
//			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
//					"IGCO10000.E004","�ʲ�����");
//		} else if(SOC0107VWInfo.getCid() == null || SOC0107VWInfo.getCid() == ""){
//			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
//					"IGCO10000.E004","�ʲ�ģ�����Ի���");
//		}
//		//��ѯ�����ʲ�
//		SOC0118VWInfo entityItem = soc0118VWBL.searchEntityItemByKey(SOC0107VWInfo.getEiid());
//		
//		if(currentEiversion != Integer.parseInt(entityItem.getEiversion())) {
//			throw new BLException("IGCO00000.E004");
//		}
//		
//		//��ѯ�ʲ�����
//		SOC0129SearchCondImpl cond = new SOC0129SearchCondImpl();
//		cond.setEiid(entityItem.getEiid().toString());
////		List<SOC0129Info> ciList = searchConfigItemVW(cond);
//		//���°汾
//		int version = Integer.parseInt(entityItem.getEiversion()) + 1;
//		//�޸�ʱ��
//		String ciupdtime = IGStringUtils.getCurrentDateTime();
//		//�����ʲ�������Ϣ
////		for(SOC0129Info ci : ciList) {
////			SOC0107VW configItemTB = new SOC0107VW();
////			//�ʲ�ID
////			configItemTB.setEiid(Integer.parseInt(ci.getEiid()));
////			//ģ������ID
////			configItemTB.setCid(ci.getCid());
////			//ģ��ID
////			configItemTB.setEid(ci.getEid());
////			//ģ�Ͳ����
////			configItemTB.setEsyscoding(ci.getEsyscoding());
////			//�汾��
////			configItemTB.setCiversion(version+"");
////			//����ʱ��
////			configItemTB.setCiupdtime(ciupdtime);
////			//������ID������滻����ֵ
////			if(ci.getCid().equals(SOC0107VWInfo.getCid().toString())) {
////				configItemTB.setCivalue(SOC0107VWInfo.getCivalue());
////			} else {
////				configItemTB.setCivalue(ci.getCivalue());
////			}
////			soc0107VWDAO.save(configItemTB);
////		}
//		
//		//�޸��ʲ�������Ϣ
//		SOC0118VW entityItemTB = (SOC0118VW)SerializationUtils.clone(entityItem);
//		
//		entityItemTB.setEiversion(version+"");
//		
//		entityItemTB.setEiupdtime(ciupdtime);
//		
//		soc0118VWBL.updateEntityItem(entityItemTB);
//		
//	}
	
	/**
	 * ����ͬһ�ʲ����������Ϣ������������ͳһ����һ���汾<br>
	 * ConfigItemʵ�����������cid��civalueֵ����
	 * 
	 * @param eiid �ʲ�ID
	 * @param currentEiversion ��ǰ�ʲ��汾��(����ǰ)
	 * @param configItemList ������ʲ�������Ϣ���ݼ���
	 */
//	public void saveSOC0107VW(Integer eiid, int currentEiversion, List<SOC0107VWInfo> SOC0107VWInfoList) throws BLException {
//		if(eiid == null || eiid <= 0){
//			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
//					"IGCO10000.E004","�ʲ�����");
//		} else if(SOC0107VWInfoList == null || SOC0107VWInfoList.size() == 0) {
//			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
//					"IGCO10000.E004","�ʲ����Ի���");
//		}
//		//��ѯ�����ʲ�
//		SOC0118VWInfo entityItem = soc0118VWBL.searchEntityItemByKey(eiid);
//		
//		if(currentEiversion != Integer.parseInt(entityItem.getEiversion())) {
//			throw new BLException("IGCO00000.E004");
//		}
//		
//		//���°汾
//		int version = Integer.parseInt(entityItem.getEiversion()) + 1;
//		//�޸�ʱ��
//		String ciupdtime = IGStringUtils.getCurrentDateTime();
//		//��ѯ�ʲ�����
//		SOC0129SearchCondImpl cond = new SOC0129SearchCondImpl();
//		cond.setEiid(eiid.toString());
//		//2014��8.29���-Ϊ�ɹ�����
//		cond.setEsyscoding_q(entityItem.getEsyscoding());
////		List<SOC0129Info> ciList = searchConfigItemVW(cond);
//		//�����ʲ�������Ϣ
////		for(SOC0129Info ci : ciList) {
////			SOC0107VW configItemTB = new SOC0107VW();
////			//�ʲ�ID
////			configItemTB.setEiid(Integer.parseInt(ci.getEiid()));
////			//ģ������ID
////			configItemTB.setCid(ci.getCid());
////			//ģ��ID
////			configItemTB.setEid(ci.getEid());
////			//ģ�Ͳ����
////			configItemTB.setEsyscoding(ci.getEsyscoding());
////			//�汾��
////			configItemTB.setCiversion(version+"");
////			//����ʱ��
////			configItemTB.setCiupdtime(ciupdtime);
////			
////			configItemTB.setCivalue(ci.getCivalue());
////			
////			for(SOC0107VWInfo SOC0107VWInfo : SOC0107VWInfoList) {
////				//У��
////				if(SOC0107VWInfo.getCid() == null || SOC0107VWInfo.getCid() == ""){
////					throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
////							"IGCO10000.E004","�ʲ�ģ�����Ի���");
////				}
////				//������ID������滻����ֵ
////				if(ci.getCid().equals(SOC0107VWInfo.getCid().toString())) {
////					configItemTB.setCivalue(SOC0107VWInfo.getCivalue());
////					continue;
////				}
////			}
////			soc0107VWDAO.save(configItemTB);
////		}
//		
//		//�޸��ʲ�������Ϣ
//		SOC0118VW entityItemTB = (SOC0118VW)SerializationUtils.clone(entityItem);
//		
//		entityItemTB.setEiversion(version+"");
//		
//		entityItemTB.setEiupdtime(ciupdtime);
//		
//		soc0118VWBL.updateEntityItem(entityItemTB);
//		
//	}
	
	
	/**
	 * �����ʲ�������Ϣ����ƽ̨������
	 * 
	 * @param configItem ������ʲ�������Ϣ����
	 * @return �ʲ�������Ϣ
	 */
	public SOC0107VWInfo registSOC0107VW(SOC0107VWInfo configItem) throws BLException {
		SOC0107VWInfo ret = soc0107VWDAO.save(configItem);
		return ret;
	}

	/**
	 * ���ݼ�������ȡ���ʲ�������Ϣ���������ƽ̨��������ʹ��getConfigItemVWSearchCount�������м�����
	 * 
	 * @param cond �ʲ�������Ϣ��������
	 * @return �ʲ�������Ϣ�������
	 */
	public int getSOC0107VWSearchCount(SOC0107VWSearchCond cond) {
		return soc0107VWDAO.getSearchCount(cond);
	}

	

	/**
	 * ����ʲ�������Ϣ����ƽ̨������
	 * 
	 * @param configItem ������ʲ�������Ϣ����
	 * @return �ʲ�������Ϣ
	 */
//	public SOC0107VWInfo updateSOC0107VW(SOC0107VWInfo SOC0107VWInfo) throws BLException {
//		checkExistSOC0107VW(SOC0107VWInfo.getCiid());
//		SOC0107VWInfo ret = soc0107VWDAO.save(SOC0107VWInfo);
//		return ret;
//	}
	
	/**
	 * �ʲ�������Ϣ���ڼ��
	 * 
	 * @param ciid �ʲ�����ID
	 * @return �ʲ�������Ϣ
	 * @throws BLException 
	 */
	protected SOC0107VWInfo checkExistSOC0107VW(SOC0107VWPK pk) throws BLException{//������
		SOC0107VWInfo info = soc0107VWDAO.findByPK(pk);
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
		return this.soc0107VWDAO.searchEiMaxSmallVersion(eiid, civersion);
	}

	public String getHostEiid(SOC0107VWSearchCondImpl cond) throws BLException {
		return this.soc0107VWDAO.getHostEiid(cond);
	}
	public List<SOC0107VWInfo> getConfigItemByEid(SOC0107VWSearchCondImpl cond){
		return this.soc0107VWDAO.getConfigItemByEid(cond);
	}

	/**
	 * ���ݼ�������ȡ���ʲ�������Ϣ�������
	 * 
	 * @param cond �ʲ�������Ϣ��������
	 * @return �ʲ�������Ϣ�������
	 */
//	public int getSOC0606InfoSearchCount(SOC0606SearchCond cond){
//
//		return soc0606DAO.getSearchCount(cond);
//	}
	
	/**
	 * ���ݼ�������ȡ���ʲ�������Ϣ�б�
	 * 
	 * @param cond �ʲ�������Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �ʲ�������Ϣ��������б�
	 */
//	public List<SOC0606Info> searchSOC0606Info(SOC0606SearchCond cond, int start, int count){
//
//		List<SOC0606Info> ret = soc0606DAO.findByCond(cond,start,count);
//		return ret;
//	}
	
	/**
	 * �������Ի�ȡ�ʲ���Ϣ
	 * @param value ���Լ���
	 * @return �ʲ���Ϣ����
	 * @throws BLException
	 */
	public List<Integer> searchEiByCname(Map<String, String> value) throws BLException {
		return this.soc0107VWDAO.searchEiByCname(value);
	}

	/**
	 * ���ݼ�������ȡ���ʲ�������Ϣ�б�
	 * 
	 * @param id �ʲ�ID
	 * @param eiid �ʲ�ID
	 * @param civersion �ʲ����Դ�汾�� 
	 * 			<br>civersion:null�����ʲ��������а汾��������Ϣ��
	 * 			<br>civersion:-1�����ʲ��������°汾��������Ϣ��
	 * 			<br>civersion:����ֵ�����ʲ����Զ�Ӧ�汾��������Ϣ��
	 * @param cismallversion �ʲ�����С�汾��
	 * @param cname �ʲ���������(ģ����ѯ����)
	 * @return �ʲ�������Ϣ��������б�
	 */
	public List<SOC0107VWInfo> searchSOC0107VWHistoryByEiid(Integer id ,Integer eiid, Integer civersion, Integer cismallversion, String cname) throws BLException {
		//ȡ���ʲ�idΪeiid���ʲ��İ汾��
		SOC0118VWInfo entityItem = soc0118VWBL.searchEntityItemByKey(new SOC0118VWPK(id, eiid));
		if(entityItem==null){
			throw new BLException(BLErrorType.ENTITY_ITEM_ALREADY_EXISTS,
					"IGCO10000.E003","�ʲ�");
		}
		
		List<SOC0107VWInfo> itemlist = new ArrayList<SOC0107VWInfo>();		
		if(StringUtils.isNotEmpty(cname)){
			//ȡ�����������а���cnameֵ�����Լ���
			SOC0109VWSearchCondImpl cond = new SOC0109VWSearchCondImpl();
			cond.setId(id);
			cond.setCname(cname);
			List<SOC0109VWInfo> list = soc0109VWDAO.findByCond(cond, 0, 0);
			for(SOC0109VWInfo config:list){
				List<SOC0107VWInfo> ret = new ArrayList<SOC0107VWInfo>(); 
				SOC0107VWSearchCondImpl cond1 = new SOC0107VWSearchCondImpl();
				cond1.setId(id);
				if(civersion==null){
					//�������а汾��������Ϣ
					cond1.setEiid(eiid.toString());
					cond1.setCid(config.getCid());
					ret = soc0107VWDAO.findByCond(cond1,0,0);
				}else if(civersion==-1){
					//�������°汾��������Ϣ
					cond1.setEiid(eiid.toString());
					cond1.setCid(config.getCid());
					cond1.setCiversion(entityItem.getEiversion());
					cond1.setCismallversion(entityItem.getEismallversion().toString());
					ret = soc0107VWDAO.findByCond(cond1,0,0);
				}else{
					//���ݴ���İ汾�ż�����Ӧ�汾��������Ϣ
					cond1.setEiid(eiid.toString());
					cond1.setCid(config.getCid());
					cond1.setCiversion(String.valueOf(civersion));
					cond1.setCismallversion(cismallversion.toString());
					ret = soc0107VWDAO.findByCond(cond1,0,0);
				}
				
				itemlist.addAll(ret);
			}
		}else{
			List<SOC0107VWInfo> ret = new ArrayList<SOC0107VWInfo>(); 
			SOC0107VWSearchCondImpl cond1 = new SOC0107VWSearchCondImpl();
			cond1.setId(id);
			if(civersion==null){
				//�������а汾��������Ϣ
				cond1.setEiid(eiid.toString());
				ret = soc0107VWDAO.findByCond(cond1,0,0);
			}else if(civersion==-1){
				//�������°汾��������Ϣ
				cond1.setEiid(eiid.toString());
				cond1.setCiversion(entityItem.getEiversion());
				ret = soc0107VWDAO.findByCond(cond1,0,0);
			}else{
				//���ݴ���İ汾�ż�����Ӧ�汾��������Ϣ
				cond1.setEiid(eiid.toString());
				cond1.setCiversion(String.valueOf(civersion));
				ret = soc0107VWDAO.findByCond(cond1,0,0);
			}
			
			itemlist.addAll(ret);
		}
		
		
		return itemlist;
	}

//	public void saveSOC0107VW(int currentEiversion, SOC0107VWInfo SOC0107VWInfo)
//			throws BLException {
//		// TODO Auto-generated method stub
//		
//	}

//	public void saveSOC0107VW(Integer eiid, int currentEiversion,
//			List<SOC0107VWInfo> SOC0107VWInfoList) throws BLException {
//		// TODO Auto-generated method stub
//		
//	}

//	public SOC0107VWInfo updateSOC0107VW(SOC0107VWInfo SOC0107VWInfo)
//			throws BLException {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
	/**
	 * ���ݼ�������ȡ���ʲ�������Ϣ�б� �������ʲ�ר��
	 * 
	 * @param cond �ʲ�������Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �ʲ�������Ϣ��������б�
	 */
//	public List<SOC0129Info> searchConfigItemSoc0109VW(SOC0129SearchCond cond, int start, int count){
//
//		List<SOC0129Info> ret = soc0129DAO.findByCondSoc0109(cond,start,count);
//		return ret;
//	}
}
