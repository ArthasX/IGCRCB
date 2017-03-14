package com.deliverik.framework.soc.asset.bl.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCondImpl;
import com.deliverik.framework.soc.asset.model.dao.SOC0117DAO;
import com.deliverik.framework.soc.asset.model.entity.SOC0117TB;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.ResourceUtility;


/**
 * �ʲ�ģ��ҵ���߼�ʵ��
 * 
 */
public class SOC0117BLImpl extends BaseBLImpl implements SOC0117BL {

	/** Entity DAO */
	protected SOC0117DAO soc0117DAO;

	public void setSoc0117DAO(SOC0117DAO soc0117DAO) {
		this.soc0117DAO = soc0117DAO;
	}
	
	/**
	 * <p>
	 * �µ��ʲ�ģ����Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return �µ��ʲ�ģ����Ϣ����ʵ��ȡ��
	 */

	public SOC0117TB getEntityTBInstance() {
		return new SOC0117TB();
	}

	/**
	 * ���ݼ�������ȡ���ʲ�ģ����Ϣ�������
	 * 
	 * @param cond �ʲ�ģ����Ϣ��������
	 * @return �ʲ�ģ����Ϣ�������
	 */
	public int getEntitySearchCount(SOC0117SearchCond cond){

		return soc0117DAO.getSearchCount(cond);
	}

	/**
	 * �����ʲ�ģ����Ϣ����ȡ���ʲ�ģ����Ϣ
	 * 
	 * @param eid �ʲ�ģ����Ϣ����
	 * @return �ʲ�ģ����Ϣ
	 * @throws BLException 
	 */
	public SOC0117Info searchEntityByKey(String eid) throws BLException{

		return checkExistEntity(eid);
	}

	/**
	 * ���ݼ�������ȡ���ʲ�ģ����Ϣ�б�
	 * 
	 * @param cond �ʲ�ģ����Ϣ��������
	 * @return �ʲ�ģ����Ϣ��������б�
	 */
	public List<SOC0117Info> searchEntity(SOC0117SearchCond cond){

		List<SOC0117Info> ret = soc0117DAO.findByCond(cond,0,0);
		return ret;
	}
	
	/**
	 * ���ݼ�������ȡ���ʲ�ģ����Ϣ�б�
	 * 
	 * @param cond �ʲ�ģ����Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �ʲ�ģ����Ϣ��������б�
	 */
	public List<SOC0117Info> searchEntity(SOC0117SearchCond cond, int start, int count){

		List<SOC0117Info> ret = soc0117DAO.findByCond(cond,start,count);
		return ret;
	}

	/**
	 * �����ʲ�ģ����Ϣ����
	 * 
	 * @param entity ������ʲ�ģ����Ϣ����
	 * @param pareid �ϼ��ʲ�ģ��ID��0�����ϼ��ʲ�ģ��Ϊ����㣩
	 * @return �ʲ�ģ����Ϣ
	 * @throws BLException
	 */
	public SOC0117Info registEntity(SOC0117Info entity,String pareid) throws BLException{
		if(StringUtils.isNotEmpty(entity.getElabel())) {
			checkNotExistEntity(entity.getElabel());
		}
		
		SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
		
		SOC0117TB etb = getEntityTBInstance();
		this.copyProperties(etb,entity);
		//EntityTB etb = (EntityTB)SerializationUtils.clone(entity);//ȡ��EntityTB
//		if("root".equals(pareid)){ //**********************
//			//�ϼ�Ϊ�����
//			cond.setEparcoding("999");
//			etb.setEparcoding("999");
//			etb.setEid(getNextEid(pareid));
//		}else{
//			checkExistEntity(pareid);
//			SOC0117Info ent = soc0117DAO.findByPK(pareid);
//			cond.setEparcoding(ent.getEsyscoding());
//		}
//		
//		// �趨�ʲ�ģ��ID
//		String eid = getNextEid(pareid);
		String eid="";
		if("root".equals(pareid)){ //**********************
			//�ϼ�Ϊ�����
			cond.setEparcoding("999");
			etb.setEparcoding("999");
			
			
			if(pareid.contains("CM")){
				// �趨�ʲ�ģ��ID
				eid = getNextEid(pareid);
				}else {
					Integer a = soc0117DAO.findMaxEidByCondNotLikeCM();
						eid=(a+1)+"";
				}
			
			etb.setEid(eid);
		}else{
			checkExistEntity(pareid);
			SOC0117Info ent = soc0117DAO.findByPK(pareid);
			cond.setEparcoding(ent.getEsyscoding());
		}
		if(pareid.contains("CM")){
		// �趨�ʲ�ģ��ID
		eid = getNextEid(pareid);
		}else {
			Integer a = soc0117DAO.findMaxEidByCondNotLikeCM();
				eid=(a+1)+"";
		}
		if (eid == null) {
			throw new BLException("IGASM0101.E008","ģ�ͻ�����Ϣ");
		} else {
			etb.setEid(eid);
		}
		
		List<SOC0117Info> list = getMaxCodingEntitys(cond);
		String esyscoding = "";
		
		String entitynum = ResourceUtility.getString("ENTITY_NUM");//�ʲ�ģ�ͱ���ļ���
		if(entitynum == null || "".equals(entitynum)){
			entitynum = "6";
		}
		int entity_num = Integer.valueOf(entitynum);
		int entity_sys_len = 18;//�ʲ�ģ�ͱ����Ĭ�ϳ���
		if(entity_num>1 && entity_num<10){
			entity_sys_len = 3+3*(entity_num-1);
		}
		if(list.size()>0){//�����¼�����
			SOC0117Info entity1 = list.get(0);
			esyscoding = entity1.getEsyscoding();
			String temp = esyscoding.substring(esyscoding.length()-3);
			if("999".equals(etb.getEparcoding())){
				String ecategory = entity1.getEcategory();
				ecategory = StringUtils.leftPad(Integer.parseInt(ecategory)+1+"", 3, "0");
				if(ecategory.equals("999")){
					throw new BLException("IGASM0101.E003","ģ�ͻ�����Ϣ");
				}
				etb.setEcategory(ecategory);
			}
			if(temp.substring(temp.length()-3).equals("999")){
				throw new BLException("IGASM0101.E004","ģ�ͻ�����Ϣ");
			}
			if("0".equals(temp.substring(0, 1))){//0**
				String tmp = String.valueOf(Integer.valueOf(temp)+1);
				if(tmp.length()==1){
					temp = "00"+tmp;
				}else if(tmp.length()==2){
					temp = "0"+tmp;
				}else{
					temp = tmp;
				}
				esyscoding = esyscoding.substring(0,esyscoding.length()-3)+temp;
			}else{//***
				esyscoding = esyscoding.substring(0,esyscoding.length()-3)+String.valueOf(Integer.valueOf(temp)+1);
			}
			etb.setEsyscoding(esyscoding);
		}else{
			
			String syscode = etb.getEparcoding();
			
			//�ж��Ƿ��Ѿ��ﵽ�涨�Ĳ����
			if(syscode!=null && syscode.length()>=entity_sys_len){
				throw new BLException("IGASM0101.E005","ģ�ͻ�����Ϣ");
			}
			
			etb.setEsyscoding(etb.getEparcoding()+"001");
		}
		etb.setEstatus("1");

		//�ʲ���Ϣ�ǼǴ���
		SOC0117Info ret = soc0117DAO.save(etb);
		return ret;
	}

	/**
	 * ��ȡ����
	 * @param pareid
	 */
	private String getNextEid(String pareid) {

		String eidstr = "";
		
		// ���ϼ�EID������
		if ("root".equals(pareid)) {
			// ��ѯģ����Ϣ
			List<SOC0117Info> eList = soc0117DAO.findMaxEidByCond(new SOC0117SearchCondImpl());
			
			// �����ڻ�ȡ���EID���������+1
			if (eList != null && eList.size() > 0) {
				String lastEid = eList.get(0).getEid();
				String serinum = lastEid.substring(2, 4);
				if (serinum.equals("99")) {
					return null;
				}
				String nextnum = String.valueOf(Integer.parseInt(serinum) + 1);
				eidstr = "CM" + StringUtils.leftPad(nextnum, 2, "0") + "001000";
			} 
			// ������
			else {
				eidstr = "CM01001000";
			}
		} 
		// ������
		else {
			// ��ȡģ�ʹ����
			String headstr = pareid.substring(0, 3);//����ϰ�
			//String headstr = pareid.substring(0, 4);
			SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
			cond.setEidStr_like(headstr + "001");
			List<SOC0117Info> eList = soc0117DAO.findMaxEidByCond(cond);
			
			// �����ڽ����к�+1
			if (eList != null && eList.size() > 0) {
				String lastEid = eList.get(0).getEid();
				String serinum = lastEid.substring(7);
				if (serinum.equals("999")) {
					return null;
				}
				String nextnum = String.valueOf(Integer.parseInt(serinum) + 1);
				eidstr = headstr + "001" + StringUtils.leftPad(nextnum, 3, "0");
			} 
			// ���������к���Ϊ001
			else {
				eidstr = headstr + "001" + "001";
			}
		}
		
		return eidstr;
	}

	/**
	 * ɾ���ʲ�ģ����Ϣ����
	 * 
	 * @param entity ɾ�����ʲ�ģ����Ϣ����
	 * @return
	 * @throws BLException
	 */
	public void deleteEntity(SOC0117Info entity) throws BLException{
		checkExistEntity(entity.getEid());
		soc0117DAO.delete(entity);
	}

	/**
	 * �����ʲ�ģ����Ϣ����ɾ���ʲ�ģ����Ϣ����
	 * 
	 * @param eid ɾ���ʲ�ģ����Ϣ����
	 * @return
	 * @throws BLException
	 */
	public void deleteEntityByKey(String eid) throws BLException{
		SOC0117Info entity = checkExistEntity(eid);
		soc0117DAO.delete(entity);
	}

	/**
	 * ����ʲ�ģ����Ϣ����
	 * 
	 * @param entity ������ʲ�ģ����Ϣ����
	 * @return �ʲ�ģ����Ϣ
	 * @throws BLException
	 */
	public SOC0117Info updateEntity(SOC0117Info entity) throws BLException{
		checkExistEntity(entity.getEid());
		SOC0117Info ret = soc0117DAO.save(entity);
		return ret;
	}

	/**
	 * �ʲ�ģ����Ϣ�����ڼ��
	 * 
	 * @param elabel �ʲ����
	 * @return
	 * @throws BLException 
	 */
	protected void checkNotExistEntity(String elabel) throws BLException{
		SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
		
		cond.setElabel(elabel);
		
		List<SOC0117Info> infoList = soc0117DAO.findByCond(cond, 0, 0);
		if( infoList != null && infoList.size()>0 ) {
			throw new BLException(BLErrorType.ENTITY_ALREADY_EXISTS,
					"IGCO10000.E003","�ʲ�ģ�ͻ���");
		}
	}
	
	/**
	 * �ʲ�ģ����Ϣ���ڼ��
	 * 
	 * @param eid �ʲ�ID
	 * @return �ʲ�ģ����Ϣ
	 * @throws BLException 
	 */
	protected SOC0117Info checkExistEntity(String eid) throws BLException{
		SOC0117Info info = soc0117DAO.findByPK(eid);
		if( info == null) {
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","�ʲ�ģ�ͻ���");
		}
		
		return info;
	}
	
	/**
	 * �����ʲ�ģ��ID��ȡ��ȫ�����ϼ��ʲ�ģ����Ϣ
	 * 
	 * @param eid �ʲ�ģ��ID
	 * @return �ϼ��ʲ�ģ����Ϣ����б�
	 * @throws BLException
	 */
	public List<SOC0117Info> getParentNodes(String eid) throws BLException{
		checkExistEntity(eid);
		SOC0117Info entity = soc0117DAO.findByPK(eid);
		String esyscoding = entity.getEsyscoding();
		int level = CommonDefineUtils.TREE_LEVEL_CODE;
		int ccid = CommonDefineUtils.CCID_LENGTH + level;
		List<String> list = new ArrayList<String>();
		list.add(esyscoding.substring(0,ccid));
		while(esyscoding.length()>ccid){
			ccid=ccid+CommonDefineUtils.CCID_LENGTH;
			list.add(esyscoding.substring(0,ccid));
		}
		SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
		cond.setEsyscodingList(list);
		return soc0117DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * �����ʲ�ģ����Ϣ������ȡ��ȫ�����ϼ��ʲ�ģ����Ϣ
	 * 
	 * @param esyscoding �ʲ�ģ����Ϣ�����
	 * @return �ϼ��ʲ�ģ����Ϣ����б�
	 * @throws BLException
	 */
	public List<SOC0117Info> getParentNodesByEsyscoding(String esyscoding){
		
		int level = CommonDefineUtils.TREE_LEVEL_CODE;
		int ccid = CommonDefineUtils.CCID_LENGTH + level;
		List<String> list = new ArrayList<String>();
		list.add(esyscoding.substring(0,ccid));
		while(esyscoding.length()>ccid){
			ccid=ccid+CommonDefineUtils.CCID_LENGTH;
			list.add(esyscoding.substring(0,ccid));
		}
		SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
		cond.setEsyscodingList(list);
		if("999007".equals(esyscoding)){
			cond.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM);
		}
		return soc0117DAO.findByCond(cond, 0, 0);
	}

	/**
	 * ���ݼ�������ȡ���ʲ�ģ����Ϣ�б�
	 *  (�����ʲ�ģ����Ϣ���������)
	 * 
	 * @param cond �ʲ�ģ����Ϣ��������
	 * @param orderType ��������б�����ʽ
	 * 		  "assetdomain" : �����ʲ�ģ����Ϣ�������������
	 * 
	 * @return �ʲ�ģ����Ϣ�б�
	 */
	public List<SOC0117Info> searchEntity(SOC0117SearchCond cond, String orderType) {
		List<SOC0117Info> ret = soc0117DAO.findByCond(cond, orderType);
		return ret;
	}
	
	/**
	 * ���ݼ������������ʲ�ģ����Ϣ����뵹������ʽȡ���ʲ�ģ����Ϣ�б�
	 * 
	 * @param cond �ʲ�ģ����Ϣ��������
	 * @return �ʲ�ģ����Ϣ�б�
	 */
	private List<SOC0117Info> getMaxCodingEntitys(SOC0117SearchCond cond)
	{
		List<SOC0117Info> ret = soc0117DAO.findByCondCoding(cond);
		return ret;
	}
	
	/**
	 * ��ѯģ�����ʲ�������ר��Ԥ����Ӧ����Դר�ã�
	 * @param esyscoding
	 * @return
	 */
	public List<Map<String, Object>> getEntityNum(String rootEsyscoding){
		return soc0117DAO.getEntityNum(rootEsyscoding);
	}
	
	/**
	 * ��ѯģ�����ʲ��������°�Ӧ����Դר�ã�
	 * @param esyscoding
	 * @return
	 */
	public List<Map<String, Object>> getEntityNumNEW(String rootErcode){
		return soc0117DAO.getEntityNumNEW(rootErcode);
	}
	
	/**
	 *  ��ȡ�ɵ���һ���ʲ��б�
	 *
	 * @param cond ��ѯ����
	 */
	public List<SOC0117Info> searchEntityForExport(SOC0117SearchCond cond) {
		return soc0117DAO.searchEntityForExport(cond);
	}
}
