package com.deliverik.framework.asset.bl.task;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.asset.model.IG117Info;
import com.deliverik.framework.asset.model.condition.IG117SearchCond;
import com.deliverik.framework.asset.model.condition.IG117SearchCondImpl;
import com.deliverik.framework.asset.model.dao.IG117DAO;
import com.deliverik.framework.asset.model.entity.IG117TB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.ResourceUtility;


/**
 * �ʲ�ģ��ҵ���߼�ʵ��
 * 
 */
public class IG117BLImpl extends BaseBLImpl implements IG117BL {

	/** Entity DAO */
	protected IG117DAO ig117DAO;

	public void setIg117DAO(IG117DAO ig117DAO) {
		this.ig117DAO = ig117DAO;
	}
	
	/**
	 * <p>
	 * �µ��ʲ�ģ����Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return �µ��ʲ�ģ����Ϣ����ʵ��ȡ��
	 */

	public IG117TB getIG117TBInstance() {
		return new IG117TB();
	}

	/**
	 * ���ݼ�������ȡ���ʲ�ģ����Ϣ�������
	 * 
	 * @param cond �ʲ�ģ����Ϣ��������
	 * @return �ʲ�ģ����Ϣ�������
	 */
	public int getIG117InfoSearchCount(IG117SearchCond cond){

		return ig117DAO.getSearchCount(cond);
	}

	/**
	 * �����ʲ�ģ����Ϣ����ȡ���ʲ�ģ����Ϣ
	 * 
	 * @param eid �ʲ�ģ����Ϣ����
	 * @return �ʲ�ģ����Ϣ
	 * @throws BLException 
	 */
	public IG117Info searchIG117InfoByKey(Integer eid) throws BLException{

		return checkExistEntity(eid);
	}

	/**
	 * ���ݼ�������ȡ���ʲ�ģ����Ϣ�б�
	 * 
	 * @param cond �ʲ�ģ����Ϣ��������
	 * @return �ʲ�ģ����Ϣ��������б�
	 */
	public List<IG117Info> searchIG117Info(IG117SearchCond cond){

		List<IG117Info> ret = ig117DAO.findByCond(cond,0,0);
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
	public List<IG117Info> searchIG117Info(IG117SearchCond cond, int start, int count){

		List<IG117Info> ret = ig117DAO.findByCond(cond,start,count);
		return ret;
	}

	/**
	 * �����ʲ�ģ����Ϣ����
	 * 
	 * @param ig117Info ������ʲ�ģ����Ϣ����
	 * @param pareid �ϼ��ʲ�ģ��ID��0�����ϼ��ʲ�ģ��Ϊ����㣩
	 * @return �ʲ�ģ����Ϣ
	 * @throws BLException
	 */
	public IG117Info registIG117Info(IG117Info ig117Info,int pareid) throws BLException{
		if(StringUtils.isNotEmpty(ig117Info.getElabel())) {
			checkNotExistEntity(ig117Info.getElabel());
		}
		
		IG117SearchCondImpl cond = new IG117SearchCondImpl();
		
		IG117TB etb = getIG117TBInstance();
		this.copyProperties(etb,ig117Info);
		//EntityTB etb = (EntityTB)SerializationUtils.clone(entity);//ȡ��EntityTB
		if(pareid<=0){
			//�ϼ�Ϊ�����
			cond.setEparcoding("999");
			etb.setEparcoding("999");
		}else{
			checkExistEntity(pareid);
			IG117Info ent = ig117DAO.findByPK(pareid);
			cond.setEparcoding(ent.getEsyscoding());
		}
		List<IG117Info> list = getMaxCodingEntitys(cond);
		String esyscoding = "";
		String entitynum = ResourceUtility.getString("ENTITY_NUM");//�ʲ�ģ�ͱ���ļ���
		if(StringUtils.isEmpty(entitynum)){
			throw new BLException("IGCO10000.E004","�ʲ�ģ�ͼ���");
		}
		int entity_num = Integer.valueOf(entitynum);
		if(CommonDefineUtils.ESYSCODING_MAX_LEVEL < entity_num){
			throw new BLException("IGASM0101.E005","ģ�ͻ�����Ϣ");
		}
		if(list.size()>0){//�����¼�����
			IG117Info entity1 = list.get(0);
			esyscoding = entity1.getEsyscoding();
			String temp = esyscoding.substring(esyscoding.length() - CommonDefineUtils.ESYSCODING_NODE_LENGTH);
			if(temp.equals(CommonDefineUtils.ESYSCODING_NODE_MAX_NUM)){
				throw new BLException("IGSYM1101.E002","����");
			}
			etb.setEsyscoding(esyscoding.substring(0, esyscoding.length() - CommonDefineUtils.ESYSCODING_NODE_LENGTH)
					+ StringUtils.leftPad((Integer.valueOf(temp) + 1) + "", CommonDefineUtils.ESYSCODING_NODE_LENGTH , "0"));
		}else{
			String syscode = etb.getEparcoding();
			//�ж��Ƿ��Ѿ��ﵽ�涨�Ĳ����
			if(syscode != null && (syscode.length()/CommonDefineUtils.ESYSCODING_NODE_LENGTH >= CommonDefineUtils.ESYSCODING_MAX_LEVEL)){
				throw new BLException("IGASM0101.E005","ģ�ͻ�����Ϣ");
			}
			etb.setEsyscoding(etb.getEparcoding() + StringUtils.leftPad("1", CommonDefineUtils.ESYSCODING_NODE_LENGTH, "0"));
		}
		etb.setEstatus("1");
		//�ʲ���Ϣ�ǼǴ���
		IG117Info ret = ig117DAO.save(etb);
		return ret;
	}

	/**
	 * ɾ���ʲ�ģ����Ϣ����
	 * 
	 * @param ig117Info ɾ�����ʲ�ģ����Ϣ����
	 * @return
	 * @throws BLException
	 */
	public void deleteIG117Info(IG117Info ig117Info) throws BLException{
		checkExistEntity(ig117Info.getEid());
		ig117DAO.delete(ig117Info);
	}

	/**
	 * �����ʲ�ģ����Ϣ����ɾ���ʲ�ģ����Ϣ����
	 * 
	 * @param eid ɾ���ʲ�ģ����Ϣ����
	 * @return
	 * @throws BLException
	 */
	public void deleteIG117InfoByKey(Integer eid) throws BLException{
		IG117Info entity = checkExistEntity(eid);
		ig117DAO.delete(entity);
	}

	/**
	 * ����ʲ�ģ����Ϣ����
	 * 
	 * @param ig117Info ������ʲ�ģ����Ϣ����
	 * @return �ʲ�ģ����Ϣ
	 * @throws BLException
	 */
	public IG117Info updateIG117Info(IG117Info ig117Info) throws BLException{
		checkExistEntity(ig117Info.getEid());
		IG117Info ret = ig117DAO.save(ig117Info);
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
		IG117SearchCondImpl cond = new IG117SearchCondImpl();
		
		cond.setElabel(elabel);
		
		List<IG117Info> infoList = ig117DAO.findByCond(cond, 0, 0);
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
	protected IG117Info checkExistEntity(Integer eid) throws BLException{
		IG117Info info = ig117DAO.findByPK(eid);
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
	public List<IG117Info> getParentNodes(Integer eid) throws BLException{
		checkExistEntity(eid);
		IG117Info entity = ig117DAO.findByPK(eid);
		String esyscoding = entity.getEsyscoding();
		int level = CommonDefineUtils.TREE_LEVEL_CODE;
		int ccid = CommonDefineUtils.CCID_LENGTH + level;
		List<String> list = new ArrayList<String>();
		list.add(esyscoding.substring(0,ccid));
		while(esyscoding.length()>ccid){
			ccid=ccid+CommonDefineUtils.CCID_LENGTH;
			list.add(esyscoding.substring(0,ccid));
		}
		IG117SearchCondImpl cond = new IG117SearchCondImpl();
		cond.setEsyscodingList(list);
		return ig117DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * �����ʲ�ģ����Ϣ������ȡ��ȫ�����ϼ��ʲ�ģ����Ϣ
	 * 
	 * @param esyscoding �ʲ�ģ����Ϣ�����
	 * @return �ϼ��ʲ�ģ����Ϣ����б�
	 * @throws BLException
	 */
	public List<IG117Info> getParentNodes(String esyscoding){
		
		int level = CommonDefineUtils.TREE_LEVEL_CODE;
		int ccid = CommonDefineUtils.CCID_LENGTH + level;
		List<String> list = new ArrayList<String>();
		list.add(esyscoding.substring(0,ccid));
		while(esyscoding.length()>ccid){
			ccid=ccid+CommonDefineUtils.CCID_LENGTH;
			list.add(esyscoding.substring(0,ccid));
		}
		IG117SearchCondImpl cond = new IG117SearchCondImpl();
		cond.setEsyscodingList(list);
		if("999007".equals(esyscoding)){
			cond.setEcategory(CommonDefineUtils.ENTIY_CATEGORY_COMPUTER_ROOM);
		}
		return ig117DAO.findByCond(cond, 0, 0);
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
	public List<IG117Info> searchIG117Info(IG117SearchCond cond, String orderType) {
		List<IG117Info> ret = ig117DAO.findByCond(cond, orderType);
		return ret;
	}
	
	/**
	 * ���ݼ������������ʲ�ģ����Ϣ����뵹������ʽȡ���ʲ�ģ����Ϣ�б�
	 * 
	 * @param cond �ʲ�ģ����Ϣ��������
	 * @return �ʲ�ģ����Ϣ�б�
	 */
	private List<IG117Info> getMaxCodingEntitys(IG117SearchCond cond)
	{
		List<IG117Info> ret = ig117DAO.findByCondCoding(cond);
		return ret;
	}
}
