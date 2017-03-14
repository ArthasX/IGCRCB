package com.deliverik.framework.asset.bl.task;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;

import com.deliverik.framework.asset.EntityCategory;
import com.deliverik.framework.asset.EntityItemKeyWords;
import com.deliverik.framework.asset.model.IG887Info;
import com.deliverik.framework.asset.model.IG225Info;
import com.deliverik.framework.asset.model.IG117Info;
import com.deliverik.framework.asset.model.IG013Info;
import com.deliverik.framework.asset.model.IG499Info;
import com.deliverik.framework.asset.model.IG749Info;
import com.deliverik.framework.asset.model.IG688Info;
import com.deliverik.framework.asset.model.SwitchConfigItemVW;
import com.deliverik.framework.asset.model.condition.IG225SearchCondImpl;
import com.deliverik.framework.asset.model.condition.IG013SearchCond;
import com.deliverik.framework.asset.model.condition.IG013SearchCondImpl;
import com.deliverik.framework.asset.model.condition.IG688SearchCond;
import com.deliverik.framework.asset.model.condition.IG117SearchCondImpl;
import com.deliverik.framework.asset.model.dao.IG800DAO;
import com.deliverik.framework.asset.model.dao.IG887DAO;
import com.deliverik.framework.asset.model.dao.IG225DAO;
import com.deliverik.framework.asset.model.dao.IG117DAO;
import com.deliverik.framework.asset.model.dao.IG013DAO;
import com.deliverik.framework.asset.model.dao.IG749DAO;
import com.deliverik.framework.asset.model.dao.IG688DAO;
import com.deliverik.framework.asset.model.entity.IG800TB;
import com.deliverik.framework.asset.model.entity.IG013TB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.user.model.dao.UserRoleVWDAO;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.ResourceUtility;



/**
 * �ʲ���Ϣҵ���߼�ʵ��
 * 
 */
public class IG013BLImpl extends BaseBLImpl implements IG013BL {

	/** EntityItem DAO */
	protected IG013DAO ig013DAO;
	
	/** ig688 DAO */
	protected IG688DAO ig688DAO;
	
	/** UserRoleVWDAO DAO */
	protected UserRoleVWDAO userRoleVWDAO;
	
	/** Ig225DAO */
	protected IG225DAO ig225DAO;
	
	/** ConfigItemDAO */
	protected IG800DAO ig800DAO;
	
	/** EntityItem DAO */
	protected IG117DAO ig117DAO;
	
	/** ig887DAO DAO */
	protected IG887DAO ig887DAO;
	
	/** EntityItemEntityVW DAO */
	protected IG749DAO ig749DAO;
	

	public void setIg117DAO(IG117DAO ig117DAO) {
		this.ig117DAO = ig117DAO;
	}

	public void setIg013DAO(IG013DAO ig013DAO) {
		this.ig013DAO = ig013DAO;
	}
	
	public void setIg688DAO(IG688DAO ig688DAO) {
		this.ig688DAO = ig688DAO;
	}
	
	public void setUserRoleVWDAO(UserRoleVWDAO userRoleVWDAO) {
		this.userRoleVWDAO = userRoleVWDAO;
	}

	public void setIg225DAO(IG225DAO ig225DAO) {
		this.ig225DAO = ig225DAO;
	}

	public void setIg800DAO(IG800DAO ig800DAO) {
		this.ig800DAO = ig800DAO;
	}
	
	public void setIg887DAO(
			IG887DAO ig887DAO) {
		this.ig887DAO = ig887DAO;
	}
	
	public void setIg749DAO(IG749DAO ig749DAO) {
		this.ig749DAO = ig749DAO;
	}

	/**
	 * <p>
	 * �µ��ʲ���Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return �µ��ʲ���Ϣ����ʵ��ȡ��
	 */

	public IG013TB geIG013TBInstance() {
		return new IG013TB();
	}

	/**
	 * ���ݼ�������ȡ���ʲ���Ϣ�������
	 * 
	 * @param cond �ʲ���Ϣ��������
	 * @return �ʲ���Ϣ�������
	 */
	public int getIG013InfoSearchCount(IG013SearchCond cond){

		return ig013DAO.getSearchCount(cond);
	}

	/**
	 * �����ʲ���Ϣ����ȡ���ʲ���Ϣ
	 * 
	 * @param eiid �ʲ���Ϣ����
	 * @return �ʲ���Ϣ
	 * @throws BLException 
	 */
	public IG013Info searchIG013InfoByKey(Integer eiid) throws BLException{

		return checkExistEntityItem(eiid);
	}
	
	/**
	 * ���ݼ�������ȡ���ʲ���Ϣ�б�
	 * 
	 * @param cond �ʲ���Ϣ��������
	 * @return �ʲ���Ϣ��������б�
	 */
	public List<IG013Info> searchIG013Info(IG013SearchCond cond){

		List<IG013Info> ret = ig013DAO.findByCond(cond,0,0);
		return ret;
	}

	/**
	 * ���ݼ�������ȡ���ʲ���Ϣ�б�
	 * 
	 * @param cond �ʲ���Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �ʲ���Ϣ��������б�
	 */
	public List<IG013Info> searchIG013Info(IG013SearchCond cond, int start, int count){

		List<IG013Info> ret = ig013DAO.findByCond(cond,0,0);
		return ret;
	}
	
	/**
	 * �����ʲ���Ϣ����ƽ̨������
	 * 
	 * @param entityItem ������ʲ���Ϣ����
	 * @return �ʲ���Ϣ
	 * @throws BLException 
	 */
	public IG013Info registIG013Info(IG013Info entityItem) throws BLException{
		checkNotExistEntityItem(entityItem.getEilabel(),String.valueOf(entityItem.getEid()));
		IG013Info ret = ig013DAO.save(entityItem);
		return ret;
	}
	
	/**
	 * �ʲ�ģ����Ϣ���ڼ��
	 * 
	 * @param eid �ʲ�ID
	 * @return �ʲ�ģ����Ϣ
	 * @throws BLException 
	 */
	private IG117Info checkExistEntity(Integer eid) throws BLException{
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
	private List<IG117Info> getParentNodes(Integer eid) throws BLException{
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
	 * �����ʲ�ģ��IDȡ�������м̳�������Ϣ��������б�
	 * 
	 * @param eid ģ������ID
	 * @return �ʲ�ģ��������Ϣ��������б�
	 * @throws BLException 
	 */
	private List<IG225Info> searchConfigurationByEid(Integer eid) throws BLException{
		List<IG117Info> list = getParentNodes(eid);
		List<IG225Info> configlist = new ArrayList<IG225Info>();
		IG225SearchCondImpl cond = new IG225SearchCondImpl();
		cond.setCstatus("1");//1����
		//�ʲ�������Ϣ�ֲ�β�ѯ
		for(IG117Info e : list){
			cond.setEid(e.getEid().toString());
			List<IG225Info> configurationList = ig225DAO.findByCond(cond, 0, 0);
			configlist.addAll(configurationList);
		}

		return configlist;
	}
	/**
	 * �����ʲ���Ϣ����
	 * 
	 * @param entityItem ������ʲ���Ϣ����
	 * @return �ʲ���Ϣ
	 * @throws BLException 
	 */
	public IG013Info registEntityItemAndConfigItem(IG013Info entityItem) throws BLException{
		checkNotExistIG013Info(entityItem.getEilabel());
		IG013Info ret = ig013DAO.save(entityItem);
		
		List<IG225Info> configurationList = searchConfigurationByEid(ret.getEid());
		for(IG225Info configuration : configurationList) {
			IG800TB configItem = new IG800TB();
			//�豸ID
			configItem.setEiid(ret.getEiid());
			//ģ������ID
			configItem.setCid(configuration.getCid());
			//ģ��ID
			configItem.setEid(ret.getEid());
			//ģ�Ͳ����
			configItem.setEsyscoding(ret.getEsyscoding());
			
			//Ĭ�����ԣ��豸״̬
			if(EntityItemKeyWords.ENTITY_DEFAULT_PROPERTY_STATUS.equals(configuration.getClabel())){
				configItem.setCivalue(CommonDefineUtils.ENTITYITEM_STARUS_NEW);
			}
			//��汾��
			configItem.setCiversion(0);
			//С�汾��
			configItem.setCismallversion(0);
			
			//����ʱ��
			configItem.setCiupdtime(ret.getEiupdtime());
			
			ig800DAO.save(configItem);
		}
		return ret;
	}

	/**
	 * ����ʲ���Ϣ����
	 * 
	 * @param ig013Info ������ʲ���Ϣ����
	 * @return �ʲ���Ϣ
	 * @throws BLException 
	 */
	public IG013Info updateIG013Info(IG013Info ig013Info) throws BLException{
		checkExistEntityItem(ig013Info.getEiid());
		IG013Info ret = ig013DAO.save(ig013Info);
		return ret;
	}

	/**
	 * ɾ���ʲ���Ϣ����
	 * 
	 * @param ig013Info ɾ�����ʲ���Ϣ����
	 * @return
	 * @throws BLException
	 */
	public void deleteIG013Info(IG013Info ig013Info) throws BLException{
		checkExistEntityItem(ig013Info.getEiid());
		ig013DAO.delete(ig013Info);
	}
	
	/**
	 * �����ʲ���Ϣ����ɾ���ʲ���Ϣ����
	 * 
	 * @param eiid ɾ���ʲ���Ϣ������
	 * @return
	 * @throws BLException
	 */
	public void deleteIG013InfoByKey(Integer eiid) throws BLException{
		IG013Info entityItem = checkExistEntityItem(eiid);
		ig013DAO.delete(entityItem);
	}

	/**
	 * �ʲ���Ϣ�����ڼ��
	 * 
	 * @param elabel �ʲ����
	 * @return
	 * @throws BLException 
	 */
	public void checkNotExistIG013Info(String eilabel) throws BLException{
		IG013SearchCondImpl cond = new IG013SearchCondImpl();
		
		cond.setEilabel(eilabel);
		
		List<IG013Info> infoList = ig013DAO.findByCond(cond, 0, 0);
		if( infoList != null && infoList.size()>0 ) {
			throw new BLException(BLErrorType.ENTITY_ITEM_ALREADY_EXISTS,
					"IGCO10000.E003","�ʲ�");
		}
	}
	
	/**
	 * �ʲ���Ϣ�����ڼ��
	 * 
	 * @param elabel �ʲ����
	 * @return
	 * @throws BLException 
	 */
	public void checkNotExistEntityItem(String eilabel,String eid) throws BLException{
		IG013SearchCondImpl cond = new IG013SearchCondImpl();
		cond.setEid(eid);
		cond.setEilabel(eilabel);
		
		List<IG013Info> infoList = ig013DAO.findByCond(cond, 0, 0);
		if( infoList != null && infoList.size()>0 ) {
			throw new BLException(BLErrorType.ENTITY_ITEM_ALREADY_EXISTS,
					"IGCO10000.E003","�ʲ�");
		}
	}
	
	/**
	 * �ʲ���Ϣ���ڼ��
	 * 
	 * @param eiid �ʲ�ID
	 * @return �ʲ���Ϣ
	 * @throws BLException 
	 */
	protected IG013Info checkExistEntityItem(Integer eiid) throws BLException{
		IG013Info info = ig013DAO.findByPK(eiid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","�ʲ�����");
		}
		
		return info;
	}
	
	/**
	 * �����ʲ���Ϣ����ȡ���ʲ���������ģ����Ϣ
	 * 
	 * @param eiid �ʲ���Ϣ����
	 * @return �����ʲ���Ϣ����ȡ���ʲ���������ģ����Ϣ
	 * @throws BLException 
	 */
	public IG688Info searchIG688InfoByKey(Integer eiid) throws BLException{
		checkExistEntityItem(eiid);
		IG688Info ret = this.ig688DAO.findByPK(eiid);
		return ret;
	}

	/**
	 * �ʲ���������ģ����Ϣ���������������ȡ��
	 * 
	 * @param cond �ʲ���������ģ����Ϣ��������
	 * @return �ʲ���������ģ����Ϣ���������������
	 */
	public int getIG688InfoSearchCount(IG688SearchCond cond){

		return ig688DAO.getSearchCount(cond);
	}

	/**
	 * ���ݼ�������ȡ���ʲ���������ģ����Ϣ�б�
	 * 
	 * @param cond �ʲ���������ģ����Ϣ��������
	 * @return �ʲ���������ģ����Ϣ��������б�
	 */
	public List<IG688Info> searchIG688Info(IG688SearchCond cond){
		
		List<IG688Info> ret = ig688DAO.findByCond(cond, 0, 0);
		return ret;
	}
	
	/**
	 * ���ݼ�������ȡ���ʲ���������ģ����Ϣ�б�
	 * 
	 * @param cond �ʲ���������ģ����Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �ʲ���������ģ����Ϣ��������б�
	 */
	public List<IG688Info> searchIG688Info(IG688SearchCond cond, int start, int count){

		List<IG688Info> ret = ig688DAO.findByCond(cond,start,count);
		return ret;
	}
	
	/**
	 * �жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
	 * 
	 * @param user �û���Ϣ
	 * @param ig688Info �ʲ���������ģ����Ϣ
	 * @return boolean
	 * @throws BLException 
	 */
	public boolean checkIG688InfoDomain(User user,IG688Info ig688Info) throws BLException{
		
		//��ƥ���ɫ�������ʾû��Ȩ�޿���
		String roleType = EntityCategory.getRoleType(ig688Info.getEcategory());
		if(StringUtils.isEmpty(roleType)) {
			return true;
		}
		
		String mode = ResourceUtility.getString(EntityCategory.ENTITYITEM_PERMISSION_MODE);
		
		//��Ȩ�޿��� 
		if(EntityCategory.ENTITYITEM_PERMISSION_MODE_NO.equals(mode)) {
			return true;
		} else if(EntityCategory.ENTITYITEM_PERMISSION_MODE_A.equals(mode)) {
			if(user.getUserid().equals(ig688Info.getEiuserid())) {
				return true;
			} else {
				//�ʲ��Ǽ��˿ɼ����ʲ�����ģ�Ͷ�Ӧ�Ĺ����ɫ�����˿ɼ�
				UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
				//�����ѯ����
				cond.setUserid(user.getUserid());//�û�ID
				cond.setRoletype(roleType);//��ɫ����
				cond.setRolemanager(true);//��ɫ������
				List<UserRoleInfo> userRoleInfoList = userRoleVWDAO.findByCond(cond, 0, 0);
				if(userRoleInfoList.isEmpty()) {
					return false;
				} else {
					return true;
				}
			}
		} else if(EntityCategory.ENTITYITEM_PERMISSION_MODE_B.equals(mode)) {
			UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
			//�����ѯ����
			cond.setUserid(user.getUserid());//�û�ID
			cond.setRoletype(roleType);//��ɫ����
			List<UserRoleInfo> userRoleInfoList = userRoleVWDAO.findByCond(cond, 0, 0);
			//���userRoleInfoList�ĳ��ȴ���0����ʾ���û������ʲ������ɫ
			if (userRoleInfoList.size() > 0) {		
				for (UserRoleInfo userRoleInfo : userRoleInfoList) {
					if (StringUtils.isNotEmpty(userRoleInfo.getAssetdomain()) && StringUtils.isNotEmpty(userRoleInfo.getRoledomain())) {							
						if (ig688Info.getEcategory().equals(CommonDefineUtils.ENTIY_CATEGORY_MODULE)||ig688Info.getEcategory().equals(CommonDefineUtils.ENTIY_CATEGORY_SERVICE_RECORD)) {
							if(StringUtils.isNotEmpty(ig688Info.getEsyscoding())){
								//�����������߷����¼ֻ������������ݾͱ�ʾ���û����в鿴�ʲ�������Ϣ��Ȩ��
								if (ig688Info.getEsyscoding().startsWith(userRoleInfo.getAssetdomain())) {
									return true;
								}				
							}
						}else{
							if(StringUtils.isNotEmpty(ig688Info.getEsyscoding())&&StringUtils.isNotEmpty(ig688Info.getEiorgsyscoding())){
								//�����������ͷ����¼��ͬʱ�����������������ݲű�ʾ���û����в鿴�ʲ�������Ϣ��Ȩ��
								if (ig688Info.getEsyscoding().startsWith(userRoleInfo.getAssetdomain())&& ig688Info.getEiorgsyscoding().startsWith(userRoleInfo.getRoledomain())) {
									return true;
								}				
							}
						}
					}
				}
			}
			return false;
		} else {
			//���ɼ�
			return false;
		}
		
	}
	
	/**
	 * �жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
	 * 
	 * @param user �û���Ϣ
	 * @param entityItemVWInfo �ʲ���������ģ����Ϣ
	 * @return boolean
	 * @throws BLException 
	 */
	public boolean checkIG499InfoDomain(User user,IG499Info ig499Info) throws BLException{
		
		//��ƥ���ɫ�������ʾû��Ȩ�޿���
		String roleType = EntityCategory.getRoleType(ig499Info.getEcategory());
		if(StringUtils.isEmpty(roleType)) {
			return true;
		}
		
		String mode = ResourceUtility.getString(EntityCategory.ENTITYITEM_PERMISSION_MODE);
		
		//��Ȩ�޿��� 
		if(EntityCategory.ENTITYITEM_PERMISSION_MODE_NO.equals(mode)) {
			return true;
		} else if(EntityCategory.ENTITYITEM_PERMISSION_MODE_A.equals(mode)) {
			if(user.getUserid().equals(ig499Info.getEiuserid())) {
				return true;
			} else {
				//�ʲ��Ǽ��˿ɼ����ʲ�����ģ�Ͷ�Ӧ�Ĺ����ɫ�����˿ɼ�
				UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
				//�����ѯ����
				cond.setUserid(user.getUserid());//�û�ID
				cond.setRoletype(roleType);//��ɫ����
				cond.setRolemanager(true);//��ɫ������
				List<UserRoleInfo> userRoleInfoList = userRoleVWDAO.findByCond(cond, 0, 0);
				if(userRoleInfoList.isEmpty()) {
					return false;
				} else {
					return true;
				}
			}
		} else if(EntityCategory.ENTITYITEM_PERMISSION_MODE_B.equals(mode)) {
			UserRoleVWSearchCondImpl cond = new UserRoleVWSearchCondImpl();
			//�����ѯ����
			cond.setUserid(user.getUserid());//�û�ID
			cond.setRoletype(roleType);//��ɫ����
			List<UserRoleInfo> userRoleInfoList = userRoleVWDAO.findByCond(cond, 0, 0);
			//���userRoleInfoList�ĳ��ȴ���0����ʾ���û������ʲ������ɫ
			if (userRoleInfoList.size() > 0) {		
				for (UserRoleInfo userRoleInfo : userRoleInfoList) {
					if (StringUtils.isNotEmpty(userRoleInfo.getAssetdomain()) && StringUtils.isNotEmpty(userRoleInfo.getRoledomain())) {							
						if (ig499Info.getEcategory().equals(CommonDefineUtils.ENTIY_CATEGORY_MODULE)||ig499Info.getEcategory().equals(CommonDefineUtils.ENTIY_CATEGORY_SERVICE_RECORD)) {
							if(StringUtils.isNotEmpty(ig499Info.getEsyscoding())){
								//�����������߷����¼ֻ������������ݾͱ�ʾ���û����в鿴�ʲ�������Ϣ��Ȩ��
								if (ig499Info.getEsyscoding().startsWith(userRoleInfo.getAssetdomain())) {
									return true;
								}				
							}
						}else{
							if(StringUtils.isNotEmpty(ig499Info.getEsyscoding())&&StringUtils.isNotEmpty(ig499Info.getEiorgsyscoding())){
								//�����������ͷ����¼��ͬʱ�����������������ݲű�ʾ���û����в鿴�ʲ�������Ϣ��Ȩ��
								if (ig499Info.getEsyscoding().startsWith(userRoleInfo.getAssetdomain())&& ig499Info.getEiorgsyscoding().startsWith(userRoleInfo.getRoledomain())) {
									return true;
								}				
							}
						}
					}
				}
			}
			return false;
		} else {
			//���ɼ�
			return false;
		}
		
	}
	
	/**
	 * ��ȡ��ǰ�����ʲ���� �ʲ�key+��+��� ��λ����4+2+6��
	 * 
	 * @param cond �ʲ���Ϣ��������
	 * @return �ʲ���ţ�ƽ̨������
	 */
	public String searchNextIG013InfoLable(IG013SearchCond cond) throws BLException{
		String eiLabel = ig013DAO.searchMaxIG013InfoLable(cond);
		if(StringUtils.isEmpty(eiLabel)) {
			eiLabel = cond.getEilabel() + EntityItemKeyWords.LABEL_MIN_ID;
		} else {
			Integer label = new Integer(eiLabel.substring(EntityItemKeyWords.LABEL_LEFT_LENGTH));
			if(EntityItemKeyWords.LABEL_MAX_ID.equals(label.toString())) {
				throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
						"IGASM0000.E001");
			} else {
				eiLabel = cond.getEilabel() + StringUtils.leftPad(String.valueOf(label + 1) , EntityItemKeyWords.LABEL_LENGTH, EntityItemKeyWords.LABEL_LEFT_PAD);
			}
		}
		
		return eiLabel;
	}

	/**
	 * ��ȡ��ǰ�����ʲ���� �ʲ�key+�豸����code+��� ��λ����10+2+7����������ר��
	 * 
	 * @param cond �ʲ���Ϣ��������
	 * @return �ʲ���ţ�ƽ̨������
	 */
	public String searchNextIG013InfoLableFX(IG013SearchCond cond) throws BLException{
		String eiLabel = ig013DAO.searchMaxIG013InfoLable(cond);
		// ������ �޸���2010-7-2
		if(StringUtils.isEmpty(eiLabel)) {
			eiLabel = cond.getEilabel() + EntityItemKeyWords.LABEL_MIN_ID_FX;
		} else {
			Integer label = new Integer(eiLabel.substring(EntityItemKeyWords.LABEL_LEFT_LENGTH_FX));
			if(EntityItemKeyWords.LABEL_MAX_ID_FX.equals(label.toString())) {
				throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
						"IGASM0000.E001");
			} else {
				if(String.valueOf(label + 1).length()>3){
					eiLabel=cond.getEilabel()+String.valueOf(label + 1);
				}else {
					eiLabel = cond.getEilabel() + StringUtils.leftPad(String.valueOf(label + 1) , EntityItemKeyWords.LABEL_LENGTH_FX, EntityItemKeyWords.LABEL_LEFT_PAD);
				}
			}
		}
		// ������ �޸���2010-7-2
		return eiLabel;
	}
	
	/**
	 *  ��ȡ�ʲ���ʷ�汾����ʱ��
	 * 
	 * @param eiid �ʲ�ID
	 * @return ���汾����ʱ��
	 * @throws BLException 
	 */
	public List<IG887Info> searchVersionUpdateTime(Integer eiid) throws BLException {
		checkExistEntityItem(eiid);
		return this.ig887DAO.searchVersionUpdateTime(eiid);
	}
	
	/**
	 * �豸��ط����¼����
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG013Info> searchDeviceService(final IG688SearchCond cond, final int start, final int count) {
		return this.ig013DAO.searchDeviceService(cond, start, count);
	}
	
	/**
	 * �����ʲ���Ϣ����ȡ���ʲ���������ģ����Ϣ
	 * 
	 * @param eiid �ʲ���Ϣ����
	 * @return �����ʲ���Ϣ����ȡ���ʲ���������ģ����Ϣ
	 * @throws BLException 
	 */
	public IG749Info searchIG749InfoByKey(Integer eiid) throws BLException {
		checkExistEntityItem(eiid);
		IG749Info ret = this.ig749DAO.findByPK(eiid);
		return ret;
	}
	
	/**
	 * �豸��ط����¼����
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SwitchConfigItemVW> searchSwitchService(final String eiid,final String version,final String smallversion){
		return ig013DAO.searchSwitchService(eiid, version, smallversion);	
	}
}
