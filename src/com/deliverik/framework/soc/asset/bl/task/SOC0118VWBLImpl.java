package com.deliverik.framework.soc.asset.bl.task;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.util.MessageResources;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.soc.asset.EntityCategory;
import com.deliverik.framework.soc.asset.EntityItemKeyWords;
import com.deliverik.framework.soc.asset.TableSpaceInfo;
import com.deliverik.framework.soc.asset.model.SOC0109VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0117VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0118VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0139VW;
import com.deliverik.framework.soc.asset.model.SOC0437Info;
import com.deliverik.framework.soc.asset.model.SOC0605Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0109VWSearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0117VWSearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0118VWSearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0118VWSearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCond;
import com.deliverik.framework.soc.asset.model.condition.SOC0437SearchCond;
import com.deliverik.framework.soc.asset.model.dao.SOC0107VWDAO;
import com.deliverik.framework.soc.asset.model.dao.SOC0109VWDAO;
import com.deliverik.framework.soc.asset.model.dao.SOC0117VWDAO;
import com.deliverik.framework.soc.asset.model.dao.SOC0118VWDAO;
import com.deliverik.framework.soc.asset.model.entity.CodeDetailEntity;
import com.deliverik.framework.soc.asset.model.entity.SOC0107VW;
import com.deliverik.framework.soc.asset.model.entity.SOC0117VWPK;
import com.deliverik.framework.soc.asset.model.entity.SOC0118VW;
import com.deliverik.framework.soc.asset.model.entity.SOC0118VWPK;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.user.model.UserRoleInfo;
import com.deliverik.framework.user.model.condition.UserRoleVWSearchCondImpl;
import com.deliverik.framework.user.model.dao.UserRoleVWDAO;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.asset.model.condition.RehearseSearchCond;
import com.deliverik.infogovernor.asset.model.dao.RehearseDAO;
import com.deliverik.infogovernor.soc.cim.form.IGCIM1001Form;
import com.deliverik.infogovernor.soc.model.NetDeviceInfo;
import com.deliverik.infogovernor.soc.model.condition.NetDeviceSearchCond;



/**
 * �ʲ���Ϣҵ���߼�ʵ��
 * 
 */
public class SOC0118VWBLImpl extends BaseBLImpl implements SOC0118VWBL {

	/** ��ɫ��֯�ܹ���ϵ��DAO�ӿ� */
	protected RehearseDAO rehearseDAO;
	
	
	/** EntityItem DAO */
	protected SOC0118VWDAO soc0118VWDAO;
	
//	/** EntityItemVW DAO */
//	protected SOC0124DAO soc0124DAO;
	
	/** UserRoleVWDAO DAO */
	protected UserRoleVWDAO userRoleVWDAO;
	
	/** ConfigurationDAO */
	protected SOC0109VWDAO soc0109VWDAO;
	
	/** ConfigItemDAO */
	protected SOC0107VWDAO soc0107VWDAO;
	
	/** EntityItem DAO */
	protected SOC0117VWDAO soc0117VWDAO;
	
	
	protected MessageResources resources = MessageResources.getMessageResources("com.deliverik.infogovernor.asset.asmResources"); 


	/**
	 * @param rehearseDAO the rehearseDAO to set
	 */
	public void setRehearseDAO(RehearseDAO rehearseDAO) {
		this.rehearseDAO = rehearseDAO;
	}

	/**
	 * @param soc0118vwdao the soc0118VWDAO to set
	 */
	public void setSoc0118VWDAO(SOC0118VWDAO soc0118vwdao) {
		soc0118VWDAO = soc0118vwdao;
	}

	/**
	 * @param userRoleVWDAO the userRoleVWDAO to set
	 */
	public void setUserRoleVWDAO(UserRoleVWDAO userRoleVWDAO) {
		this.userRoleVWDAO = userRoleVWDAO;
	}

	/**
	 * @param soc0109vwdao the soc0109VWDAO to set
	 */
	public void setSoc0109VWDAO(SOC0109VWDAO soc0109vwdao) {
		soc0109VWDAO = soc0109vwdao;
	}

	/**
	 * @param soc0107vwdao the soc0107VWDAO to set
	 */
	public void setSoc0107VWDAO(SOC0107VWDAO soc0107vwdao) {
		soc0107VWDAO = soc0107vwdao;
	}

	/**
	 * @param soc0117vwdao the soc0117VWDAO to set
	 */
	public void setSoc0117VWDAO(SOC0117VWDAO soc0117vwdao) {
		soc0117VWDAO = soc0117vwdao;
	}

	/**
	 * <p>
	 * �µ��ʲ���Ϣ����ʵ��ȡ��
	 * <p>
	 * 
	 * @return �µ��ʲ���Ϣ����ʵ��ȡ��
	 */

	public SOC0118VW getEntityItemTBInstance() {
		return new SOC0118VW();
	}

	/**
	 * ���ݼ�������ȡ���ʲ���Ϣ�������
	 * 
	 * @param cond �ʲ���Ϣ��������
	 * @return �ʲ���Ϣ�������
	 */
	public int getEntityItemSearchCount(SOC0118VWSearchCond cond){

		return soc0118VWDAO.getSearchCount(cond);
	}

	/**
	 * �����ʲ���Ϣ����ȡ���ʲ���Ϣ
	 * 
	 * @param eiid �ʲ���Ϣ����
	 * @return �ʲ���Ϣ
	 * @throws BLException 
	 */
	public SOC0118VWInfo searchEntityItemByKey(SOC0118VWPK pk) throws BLException{

		return checkExistEntityItem(pk);
	}
	
	/**
	 * ���ݼ�������ȡ���ʲ���Ϣ�б�
	 * 
	 * @param cond �ʲ���Ϣ��������
	 * @return �ʲ���Ϣ��������б�
	 */
	public List<SOC0118VWInfo> searchEntityItem(SOC0118VWSearchCond cond){

		List<SOC0118VWInfo> ret = soc0118VWDAO.findByCond(cond,0,0);
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
	public List<SOC0118VWInfo> searchEntityItem(SOC0118VWSearchCond cond, int start, int count){

		List<SOC0118VWInfo> ret = soc0118VWDAO.findByCond(cond,start,count);
		return ret;
	}
	
	/**
	 * �����ʲ���Ϣ����ƽ̨������
	 * 
	 * @param entityItem ������ʲ���Ϣ����
	 * @return �ʲ���Ϣ
	 * @throws BLException 
	 */
	public SOC0118VWInfo registEntityItem(SOC0118VWInfo entityItem) throws BLException{
		checkNotExistEntityItem(entityItem.getEilabel());
		SOC0118VWInfo ret = soc0118VWDAO.save(entityItem);
		return ret;
	}
	
	/**
	 * �����¼��Ǽ�
	 * 
	 * @param entityItem ������ʲ���Ϣ����
	 * @return �ʲ���Ϣ
	 * @throws BLException 
	 */
	public SOC0118VWInfo registRiskCase(SOC0118VWInfo entityItem) throws BLException{
		SOC0118VWInfo ret = soc0118VWDAO.save(entityItem);
		return ret;
	}
	
	/**
	 * �ʲ�ģ����Ϣ���ڼ��
	 * 
	 * @param eid �ʲ�ID
	 * @return �ʲ�ģ����Ϣ
	 * @throws BLException 
	 */
	private SOC0117VWInfo checkExistEntity(String eid) throws BLException{
		SOC0117VWInfo info = soc0117VWDAO.findByPK(eid);
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
	private List<SOC0117VWInfo> getParentNodes(String eid) throws BLException{
		checkExistEntity(eid);
		SOC0117VWInfo entity = soc0117VWDAO.findByPK(eid);
		String esyscoding = entity.getEsyscoding();
		int level = CommonDefineUtils.TREE_LEVEL_CODE;
		int ccid = CommonDefineUtils.CCID_LENGTH + level;
		List<String> list = new ArrayList<String>();
		list.add(esyscoding.substring(0,ccid));
		while(esyscoding.length()>ccid){
			ccid=ccid+CommonDefineUtils.CCID_LENGTH;
			list.add(esyscoding.substring(0,ccid));
		}
		SOC0117VWSearchCondImpl cond = new SOC0117VWSearchCondImpl();
		cond.setEsyscodingList(list);
		return soc0117VWDAO.findByCond(cond, 0, 0);
	}
	
	
	/**
	 * �����ʲ�ģ��IDȡ�������м̳�������Ϣ��������б�
	 * 
	 * @param eid ģ������ID
	 * @return �ʲ�ģ��������Ϣ��������б�
	 * @throws BLException 
	 */
	private List<SOC0109VWInfo> searchConfigurationByEid(String eid) throws BLException{
		List<SOC0117VWInfo> list = getParentNodes(eid);
		List<SOC0109VWInfo> configlist = new ArrayList<SOC0109VWInfo>();
		SOC0109VWSearchCondImpl cond = new SOC0109VWSearchCondImpl();
		cond.setCstatus("1");//1����
		//�ʲ�������Ϣ�ֲ�β�ѯ
		for(SOC0117VWInfo e : list){
			cond.setEid(e.getEid().toString());
			List<SOC0109VWInfo> configurationList = soc0109VWDAO.findByCond(cond, 0, 0);
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
	public SOC0118VWInfo registEntityItemAndConfigItem(SOC0118VWInfo entityItem) throws BLException{
		checkNotExistEntityItem(entityItem.getEilabel());
		SOC0118VWInfo ret = soc0118VWDAO.save(entityItem);
		
		List<SOC0109VWInfo> configurationList = searchConfigurationByEid(ret.getEid());
		for(SOC0109VWInfo configuration : configurationList) {
			SOC0107VW configItem = new SOC0107VW();
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
			configItem.setCiversion("0");
			//С�汾��
			configItem.setCismallversion(0);
			
			//����ʱ��
			configItem.setCiupdtime(ret.getEiupdtime());
			
			soc0107VWDAO.save(configItem);
		}
		return ret;
	}

	/**
	 * ����ʲ���Ϣ����
	 * 
	 * @param entityItem ������ʲ���Ϣ����
	 * @return �ʲ���Ϣ
	 * @throws BLException 
	 */
	public SOC0118VWInfo updateEntityItem(SOC0118VWInfo entityItem) throws BLException{
		checkExistEntityItem(new SOC0118VWPK(entityItem.getId(),entityItem.getEiid()));
		SOC0118VWInfo ret = soc0118VWDAO.save(entityItem);
		return ret;
	}

	/**
	 * ɾ���ʲ���Ϣ����
	 * 
	 * @param entityItem ɾ�����ʲ���Ϣ����
	 * @return
	 * @throws BLException
	 */
	public void deleteEntityItem(SOC0118VWInfo entityItem) throws BLException{
		checkExistEntityItem(new SOC0118VWPK(entityItem.getId(),entityItem.getEiid()));
		
		soc0118VWDAO.delete(entityItem);
	}
	
	/**
	 * �����ʲ���Ϣ����ɾ���ʲ���Ϣ����
	 * 
	 * @param eiid ɾ���ʲ���Ϣ������
	 * @return
	 * @throws BLException
	 */
	public void deleteEntityItemByKey(SOC0118VWPK pk) throws BLException{
		SOC0118VWInfo entityItem = checkExistEntityItem(pk);
		soc0118VWDAO.delete(entityItem);
	}

	/**
	 * �ʲ���Ϣ�����ڼ��
	 * 
	 * @param elabel �ʲ����
	 * @return
	 * @throws BLException 
	 */
	public void checkNotExistEntityItem(String eilabel) throws BLException{
		SOC0118VWSearchCondImpl cond = new SOC0118VWSearchCondImpl();
		
		cond.setEilabel(eilabel);
		
		List<SOC0118VWInfo> infoList = soc0118VWDAO.findByCond(cond, 0, 0);
		if( infoList != null && infoList.size()>0 ) {
			throw new BLException(BLErrorType.ENTITY_ITEM_ALREADY_EXISTS, "IGCO10000.E003","�ʲ�");
		}
	}
	
	/**
	 * �ʲ���Ϣ���ڼ��
	 * 
	 * @param eiid �ʲ�ID
	 * @return �ʲ���Ϣ
	 * @throws BLException 
	 */
	protected SOC0118VWInfo checkExistEntityItem(SOC0118VWPK pk) throws BLException{
		SOC0118VWInfo info = soc0118VWDAO.findByPK(pk);
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
//	public SOC0124Info searchEntityItemVWByKey(Integer eiid) throws BLException{
//		checkExistEntityItem(eiid);
//		SOC0124Info ret = this.soc0124DAO.findByPK(eiid);
//		return ret;
//	}

	/**
	 * �ʲ���������ģ����Ϣ���������������ȡ��
	 * 
	 * @param cond �ʲ���������ģ����Ϣ��������
	 * @return �ʲ���������ģ����Ϣ���������������
	 */
//	public int getEntityItemVWSearchCount(SOC0124SearchCond cond){
//
//		return soc0124DAO.getSearchCount(cond);
//	}

	/**
	 * ���ݼ�������ȡ���ʲ���������ģ����Ϣ�б�
	 * 
	 * @param cond �ʲ���������ģ����Ϣ��������
	 * @return �ʲ���������ģ����Ϣ��������б�
	 */
//	public List<SOC0124Info> searchEntityItemVW(SOC0124SearchCond cond){
//		
//		List<SOC0124Info> ret = soc0124DAO.findByCond(cond, 0, 0);
//		return ret;
//	}
	
	/**
	 * ���ݼ�������ȡ���ʲ���������ģ����Ϣ�б�
	 * 
	 * @param cond �ʲ���������ģ����Ϣ��������
	 * @param start ������¼��ʼ����
	 * @param count ������¼����
	 * @return �ʲ���������ģ����Ϣ��������б�
	 */
//	public List<SOC0124Info> searchEntityItemVW(SOC0124SearchCond cond, int start, int count){
//
//		List<SOC0124Info> ret = soc0124DAO.findByCond(cond,start,count);
//		return ret;
//	}
	
	/**
	 * �жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
	 * 
	 * @param user �û���Ϣ
	 * @param entityItemVWInfo �ʲ���������ģ����Ϣ
	 * @return boolean
	 * @throws BLException 
	 */
	public boolean checkEntityItemDomain(User user,SOC0118VWInfo entityItemVWInfo) throws BLException{
		Integer id = entityItemVWInfo.getId();
		String eid = entityItemVWInfo.getEid();
		SOC0117VWInfo info = soc0117VWDAO.findByPK(new SOC0117VWPK(id,eid));
		//��ƥ���ɫ�������ʾû��Ȩ�޿���
		String roleType = EntityCategory.getRoleType(info.getEcategory());
		if(StringUtils.isEmpty(roleType)) {
			return true;
		}
		
		String mode = ResourceUtility.getString(EntityCategory.ENTITYITEM_PERMISSION_MODE);
		
		//��Ȩ�޿��� 
		if(EntityCategory.ENTITYITEM_PERMISSION_MODE_NO.equals(mode)) {
			return true;
		} else if(EntityCategory.ENTITYITEM_PERMISSION_MODE_A.equals(mode)) {
			if(user.getUserid().equals(entityItemVWInfo.getEiuserid())) {
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
						if (info.getEcategory().equals(CommonDefineUtils.ENTIY_CATEGORY_MODULE)||info.getEcategory().equals(CommonDefineUtils.ENTIY_CATEGORY_SERVICE_RECORD)) {
							if(StringUtils.isNotEmpty(entityItemVWInfo.getEsyscoding())){
								//�����������߷����¼ֻ������������ݾͱ�ʾ���û����в鿴�ʲ�������Ϣ��Ȩ��
								if (entityItemVWInfo.getEsyscoding().startsWith(userRoleInfo.getAssetdomain())) {
									return true;
								}				
							}
						}else{
							if(StringUtils.isNotEmpty(entityItemVWInfo.getEsyscoding())&&StringUtils.isNotEmpty(entityItemVWInfo.getEiorgsyscoding())){
								//�����������ͷ����¼��ͬʱ�����������������ݲű�ʾ���û����в鿴�ʲ�������Ϣ��Ȩ��
								if (entityItemVWInfo.getEsyscoding().startsWith(userRoleInfo.getAssetdomain())&& entityItemVWInfo.getEiorgsyscoding().startsWith(userRoleInfo.getRoledomain())) {
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
	public String searchNextEntityItemLable(SOC0118VWSearchCond cond) throws BLException{
		String eiLabel = soc0118VWDAO.searchMaxEntityItemLable(cond);
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
	public String searchNextEntityItemLableFX(SOC0118VWSearchCond cond) throws BLException{
		String eiLabel = soc0118VWDAO.searchMaxEntityItemLable(cond);
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
//	public List<SOC0128Info> searchVersionUpdateTime(Integer eiid) throws BLException {
//		checkExistEntityItem(eiid);
//		return this.soc0128DAO.searchVersionUpdateTime(eiid);
//	}
	
	/**
	 * �豸��ط����¼����
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0118VWInfo> searchDeviceService(final SOC0124SearchCond cond, final int start, final int count) {
		return this.soc0118VWDAO.searchDeviceService(cond, start, count);
	}
	
	/**
	 * �����ʲ���Ϣ����ȡ���ʲ���������ģ����Ϣ
	 * 
	 * @param eiid �ʲ���Ϣ����
	 * @return �����ʲ���Ϣ����ȡ���ʲ���������ģ����Ϣ
	 * @throws BLException 
	 */
//	public SOC0123Info searchEntityItemEntityVWByKey(Integer eiid) throws BLException {
//		checkExistEntityItem(eiid);
//		SOC0123Info ret = this.soc0123DAO.findByPK(eiid);
//		return ret;
//	}
	
	/**
	 * �豸��ط����¼����
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<SOC0139VW> searchSwitchService(final String eiid,final String version,final String smallversion){
		return soc0118VWDAO.searchSwitchService(eiid, version, smallversion);	
	}
	
	public String searchEntityESyscoding(String strEilabel){
		return soc0118VWDAO.searchEntityESyscoding(strEilabel);
	}
	
	public List<CodeDetailEntity> searchCodeDetailSQL(SOC0118VWSearchCond cond){
		return soc0118VWDAO.findByCondSQL(cond, 0, 0);
	}

	public List<TableSpaceInfo> searchTableRelationInfo(
			SOC0118VWSearchCondImpl soc0118VWCond, int start, int count) {
		return soc0118VWDAO.searchTableRelationInfo(soc0118VWCond,start,count);
	}

	public void updateCutValue(IGCIM1001Form igcim1001Form) {
		this.soc0118VWDAO.updateCutValue(igcim1001Form);
	}

	public List<SOC0437Info> searchCutItem(SOC0437SearchCond cond, int start, int count) {
		return soc0118VWDAO.searchCutItem(cond,start,count);
	}
	public Integer searchCutItemCount(SOC0437SearchCond cond) {
		return soc0118VWDAO.searchCutItemCount(cond);
	}
	/**
	 * ����ʲ���˵��
	 * @param cond
	 * @return
	 */
	public Integer clearEidesc(final SOC0118VWSearchCond cond) throws BLException{
		return soc0118VWDAO.clearEidesc(cond);
	}

	/**
	 * ��������
	 * @param soc0118VWList
	 * @throws Exception
	 */
	public void saveEntityItems(List<SOC0118VW> soc0118VWList)throws Exception{
			soc0118VWDAO.saveEntityItems(soc0118VWList);
		
	}
	
	/**
	 * ִ��sql
	 * @param sql
	 * @return
	 */
	public Integer executeSQL(String sql)throws BLException{
		return  soc0118VWDAO.executeSQL(sql);
	}
	public int getNetDeviceInfoListCount(NetDeviceSearchCond cond){
		return soc0118VWDAO.getNetDeviceCount(cond);
	}
	
	public List<NetDeviceInfo> searchNetDeviceInfoList(NetDeviceSearchCond cond, int start, int count){
		return soc0118VWDAO.searchNetDeviceListByCond(cond, start, count);
	}
	
	/**
	 * ���ָ��eiid���ʲ���˵��
	 * @param cond
	 * @return
	 */
	public Integer clearEidescByEiid(SOC0118VWSearchCond cond)throws BLException{
		return soc0118VWDAO.clearEidescByEiid(cond);
	}
	
	/**
	 * ɾ��eiid��eirootmark�� ������Χ�ڵ��ʲ�
	 * @param eiids
	 * @return
	 */
	public int delByEiid(Integer[] eiids)throws BLException{
		return soc0118VWDAO.delByEiid(eiids);
	}
	
	/**
	 * �����ʲ���Ϣ����ȡ���ʲ���������ģ����Ϣ
	 * 
	 * @param eiid �ʲ���Ϣ����
	 * @return �����ʲ���Ϣ����ȡ���ʲ���������ģ����Ϣ
	 * @throws BLException 
	 */
//	public SOC0605Info searchSOC0605InfoByKey(Integer eiid) throws BLException{
//		checkExistEntityItem(eiid);
//		SOC0605Info ret = this.soc0605DAO.findByPK(eiid);
//		return ret;
//	}
	
	/**
	 * �жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
	 * 
	 * @param user �û���Ϣ
	 * @param SOC0605Info �ʲ���������ģ����Ϣ
	 * @return boolean
	 * @throws BLException 
	 */
	public boolean checkSOC0605InfoDomain(User user,SOC0605Info soc0605Info) throws BLException{
		
		//��ƥ���ɫ�������ʾû��Ȩ�޿���
		String roleType = EntityCategory.getRoleType(soc0605Info.getEcategory());
		if(StringUtils.isEmpty(roleType)) {
			return true;
		}
		
		String mode = ResourceUtility.getString(EntityCategory.ENTITYITEM_PERMISSION_MODE);
		
		//��Ȩ�޿��� 
		if(EntityCategory.ENTITYITEM_PERMISSION_MODE_NO.equals(mode)) {
			return true;
		} else if(EntityCategory.ENTITYITEM_PERMISSION_MODE_A.equals(mode)) {
			if(user.getUserid().equals(soc0605Info.getEiuserid())) {
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
						if (soc0605Info.getEcategory().equals(CommonDefineUtils.ENTIY_CATEGORY_MODULE)||soc0605Info.getEcategory().equals(CommonDefineUtils.ENTIY_CATEGORY_SERVICE_RECORD)) {
							if(StringUtils.isNotEmpty(soc0605Info.getEsyscoding())){
								//�����������߷����¼ֻ������������ݾͱ�ʾ���û����в鿴�ʲ�������Ϣ��Ȩ��
								if (soc0605Info.getEsyscoding().startsWith(userRoleInfo.getAssetdomain())) {
									return true;
								}				
							}
						}else{
							if(StringUtils.isNotEmpty(soc0605Info.getEsyscoding())&&StringUtils.isNotEmpty(soc0605Info.getEiorgsyscoding())){
								//�����������ͷ����¼��ͬʱ�����������������ݲű�ʾ���û����в鿴�ʲ�������Ϣ��Ȩ��
								if (soc0605Info.getEsyscoding().startsWith(userRoleInfo.getAssetdomain())&& soc0605Info.getEiorgsyscoding().startsWith(userRoleInfo.getRoledomain())) {
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
	 * ��ȡ������Ϣ
	 * ����һ���ԶԱ� �� ����ҵ��ϵͳ ��ѯ����ʱ ʹ��
	 * @param cond
	 * @return
	 */
	public List<Map<String,String>> searchHostList(SOC0118VWSearchCond cond)throws BLException{
		return soc0118VWDAO.searchHostList(cond);
	}
	
	public void deleteEntityItemByEilabel(String eilabel) throws BLException {
		soc0118VWDAO.deleteEntityItemByEilabel(eilabel);
	}
	
	public int getEntityItemSearchCountByHost(SOC0118VWSearchCondImpl cond)
		throws BLException {
		return soc0118VWDAO.getEntityItemSearchCountByHost(cond);
	}

	public List<SOC0118VWInfo> searchEntityItemByHost(SOC0118VWSearchCondImpl cond,
		int fromCount, int pageDispCount) throws BLException {
	return soc0118VWDAO.searchEntityItemByHost(cond,fromCount,pageDispCount);
	}

	/**
	 * �����µı�����ɹ���
	 * ����������д+X+�����������+�����������+���ռ�������
	 * ����λ����λ�� X     ����λ��         ����λ��      ����λ�� IG-X0101-001
	 * @param cond �ʲ���Ϣ��������
	 * @date 2014/07/20
	 * @author zhangqiang
	 * @return �ʲ���ţ�ƽ̨������
	 * 
	 */
	public String searchNewNextEntityItemLable(SOC0118VWSearchCond cond) throws BLException{
		//SOC0118VWSearchCondImpl searchCond = new SOC0118VWSearchCondImpl();
		//String eiLabel = soc0118VWDAO.searchMaxEntityItemLable(cond);
		// ����cond��������
		//searchCond.setEilabel("IG-X");
		String eiLabel = soc0118VWDAO.searchMaxEntityItemLable(cond);
		if(StringUtils.isEmpty(eiLabel)) {
			eiLabel = cond.getEilabel() + "-001";
		} else {
			
//			IG-X0101-001
			Integer lastThree = Integer.parseInt(eiLabel.substring(eiLabel.length()-3));
			if(lastThree<999){
				lastThree+=1;
			}
			int length = lastThree.toString().length();
			if(length>2){
				eiLabel = cond.getEilabel()+"-"+lastThree;
			}else if(length==2){
				eiLabel = cond.getEilabel()+"-0"+lastThree;
			}else if(length==1){
				eiLabel = cond.getEilabel()+"-00"+lastThree;
			}
		}
		
		return eiLabel;
	}
	
	/**
	 * ��ѯ���տ�ֲ����
	 * @return map key:{riskcont:���յ�����,riskesyscoding:���յ�����(6λ),inspectcont:�����,inspectesyscoding:���������(6λ),����}
	 */
	public List<Map> getRiskRepository()throws BLException{
		return soc0118VWDAO.getRiskRepository();
	}
	
	/**
	 * ��ȡ ���յ�+�����  ������ѯ ��ҳ
	 * @param cond
	 * @param start
	 * @param count
	 * @return key:ename riskcount riskesyscoding inspectcount inspectesyscoding
	 */
	public List<HashMap<String, Object>> searchAssessRisk(RehearseSearchCond cond, int start, int count) throws BLException{
		return rehearseDAO.searchAssessRisk(cond, start, count);
	}
	/**
	 * ��ȡ ��������ѡ��ı���ȷ��յ�+�����  ������ѯ ��ҳ
	 * @param cond
	 * @param start
	 * @param count
	 * @return key:ename riskcount riskesyscoding inspectcount inspectesyscoding
	 */
	public List<HashMap<String, Object>> searchRiskInfo(RehearseSearchCond cond, int start, int count) throws BLException{
		return rehearseDAO.searchRiskInfo(cond, start, count);
	}
	/**
	 * ������������
	 * @param pk����
	 * @return �������
	 */
	public List<SOC0118VWInfo> findByPKs(List<SOC0118VWPK> PKs){
		return soc0118VWDAO.findByPKs(PKs);
	}
	/**
	 * ��ѯӦ����Դ�������ʲ�����
	 * @return List<SOC0118VWInfo>
	 */
	public List<SOC0118VWInfo> getEmergencyRelationList(SOC0118VWSearchCond cond, final int start, final int count){
		return soc0118VWDAO.getEmergencyRelationList(cond, start, count);
	}
	/**
	 * ��ѯӦ����Դ�������ʲ�����
	 * @return List<SOC0118VWInfo>
	 */
	public Integer getEmergencyRelationCount(SOC0118VWSearchCond cond){
		return soc0118VWDAO.getEmergencyRelationCount(cond);
	}
}
