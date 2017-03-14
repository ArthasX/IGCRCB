package com.deliverik.infogovernor.asset.bl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;
import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.asset.bl.task.IG611BL;
import com.deliverik.framework.asset.model.IG612Info;
import com.deliverik.framework.asset.model.condition.IG611SearchCondImpl;
import com.deliverik.framework.asset.model.entity.IG611TB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.soc.asset.bl.task.SOC0109BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0151BL;
import com.deliverik.framework.soc.asset.model.ConfigurationCodeDetailBean;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0151Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0109SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0151SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0109TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0117TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0151TB;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.infogovernor.asset.dto.IGASM01DTO;
import com.deliverik.infogovernor.asset.form.IGASM0101Form;
import com.deliverik.infogovernor.asset.form.IGASM0102Form;
import com.deliverik.infogovernor.asset.form.IGASM0104Form;
import com.deliverik.infogovernor.asset.form.IGASM0108Form;
import com.deliverik.infogovernor.asset.form.IGASM0111Form;
import com.deliverik.infogovernor.asset.form.IGASM0114Form;
import com.deliverik.infogovernor.sym.bl.IGSYM01BL;
import com.deliverik.infogovernor.sym.bl.IGSYM02BL;
import com.deliverik.infogovernor.sym.dto.IGSYM01DTO;
import com.deliverik.infogovernor.sym.dto.IGSYM02DTO;

/**
 * �ʲ�����ģ�͹���ҵ���߼�ʵ��
 * @Author  
 * @History 2009-8-17     �½�
 * @History 2010-5-07     0000428: ���ӻ������Թ���
 * @Version V2.0
 */
public class IGASM01BLImpl extends BaseBLImpl implements IGASM01BL {

	static Log log = LogFactory.getLog(IGASM01BLImpl.class);

	/** �ʲ���ϢBL */
	protected SOC0117BL soc0117BL;
	
	/** �ʲ�������ϢBL */
	protected SOC0109BL soc0109BL;

	/** �ʲ�����������ϢBL */
//	protected IG545BL ig545BL;
	protected SOC0151BL soc0151BL;
	
	/** �ʲ�ģ������ȱʡֵBL */
	protected IG611BL ig611BL;
	
	/** �ļ��ϴ�BL */
	protected FileUploadBL fileUploadBL;

	/**
	 * �ļ��ϴ�BL�趨
	 *
	 * @param fileUploadBL �ļ��ϴ�BL
	 */
	
	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}

	public void setSoc0117BL(SOC0117BL soc0117bl) {
		soc0117BL = soc0117bl;
	}

	public void setSoc0109BL(SOC0109BL soc0109bl) {
		soc0109BL = soc0109bl;
	}

	public void setSoc0151BL(
			SOC0151BL soc0151BL) {
		this.soc0151BL = soc0151BL;
	}
	
	/**
	 * �ʲ�ģ������ȱʡֵBL�趨
	 * 
	 * @param ig611BL �ʲ�ģ������ȱʡֵBL
	 */
	public void setIg611BL(IG611BL ig611BL) {
		this.ig611BL = ig611BL;
	}

	/**
	 * <p>
	 * �ж�ÿ���ʲ�ģ���Ƿ����ͣ��
	 * </p>
	 * @param �ʲ�ģ��esyscoding
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	private boolean isCouldStop(String syscode) {
		IGASM0101Form form = new IGASM0101Form();
		IGASM01DTO dto = new IGASM01DTO();
		boolean flag = true;
		
		form.setEparcoding_status(syscode);
		form.setEstatus("1");
		dto.setEntitySearchCond(form);
		List<SOC0117Info> ret = soc0117BL.searchEntity(dto.getEntitySearchCond(), 0, 0);//���ģ���Ƿ����ʹ���е��¼�ģ��
		if(ret.size()>0){
			flag = false;
		}
		return flag;
	}
	
	/**
	 * <p>
	 * Description: ȷ���Ƿ���ʾ'ͣ��'��ť
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public Map<String,String> getButtonNameList(List<SOC0117Info> entityList) throws BLException {
		Map<String,String> org = new HashMap<String,String>();
		for(SOC0117Info ret:entityList){
			String flag = "0";//0����ʾ 1��ʾ
			
			if(isCouldStop(ret.getEsyscoding())){
				flag = "1";
			}
			
			org.put(ret.getEid(), flag);
		}
		
		return org;
	}
	
	/**
	 * <p>
	 * �ж�ÿ�������Ƿ��������
	 * </p>
	 * @param �ʲ�ģ��esyscoding
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	private boolean isCouldStart(String syscode) {
		IGASM0101Form form = new IGASM0101Form();
		IGASM01DTO dto = new IGASM01DTO();
		boolean flag = true;
		
		form.setEparcoding_status_start(syscode);
		dto.setEntitySearchCond(form);
		List<SOC0117Info> ret = soc0117BL.searchEntity(dto.getEntitySearchCond(), 0, 0);//����ʲ�ģ���Ƿ����ͣ�õ��ϼ�ģ��

		if(ret.size()>0&&ret.get(0).getEstatus().equals("2")){//�����ǰ�����ϼ���ͣ��״̬��ǰ��㲻������
			flag = false;
		}
		return flag;
	}
	
	/**
	 * <p>
	 * Description: ȷ���Ƿ���ʾ'����'��ť
	 * </p>
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	
	public Map<String,String> getStartButtonNameList(List<SOC0117Info> entityList) throws BLException {
		Map<String,String> org = new HashMap<String,String>();
		for(SOC0117Info ret:entityList){
			String flag = "0";//0����ʾ 1��ʾ
			String syscode = ret.getEsyscoding();
			String parcode = ret.getEparcoding();
			if(parcode.equals("999")){//����Ϊ1��ģ�ͣ���ֱ������flagΪ1
				flag = "1";
			}else{
				if(isCouldStart(syscode.substring(0,syscode.length()-3))){
					flag = "1";
				}
				
			}

			org.put(ret.getEid(), flag);
		}
		
		return org;
	}
	
	/**
	 * <p>
	 * Description: �ʲ�ģ������״̬�仯
	 * </p>
	 * 
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 * @throws BLException
	 * @author duchong@deliverik.com
	 * @update
	 */
	public void changeConfigStatus(IGASM01DTO dto) throws BLException {
		log.debug("========�ʲ�ģ������״̬�仯������ʼ========");

		SOC0109Info configuration = soc0109BL.searchConfigurationByKey(dto.getCid());
		String status = "";
		if(configuration == null){
			throw new BLException("IGCO10000.E004","�ʲ�ģ������״̬���");
		}
		//1Ϊ���� 2Ϊͣ��
		if("1".equals(dto.getCstatus())){
			status="2";
		}else if("2".equals(dto.getCstatus())){
			status="1";
		}
		SOC0109TB cfr = new SOC0109TB();
		//������ʾ�趨
		cfr.setCattach(configuration.getCattach());
		cfr.setCcategory(configuration.getCcategory());
		cfr.setCdesc(configuration.getCdesc());
		cfr.setCid(configuration.getCid());
		cfr.setClabel(configuration.getClabel());
		cfr.setCname(configuration.getCname());
		cfr.setCoption(configuration.getCoption());
		cfr.setCseq(configuration.getCseq());
		cfr.setCstatus(status);
		cfr.setEsyscoding(configuration.getEsyscoding());
		cfr.setCunit(configuration.getCunit());
		cfr.setEid(configuration.getEid());
		cfr.setCrequired(configuration.getCrequired());

		soc0109BL.updateConfiguration(cfr);

		log.debug("========�ʲ�ģ������״̬�仯��������========");
		
	}
	
	/**
	 * <p>
	 * Description: �ʲ�ģ��״̬�仯
	 * </p>
	 * 
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 * @throws BLException
	 * @author duchong@deliverik.com
	 * @update
	 */
	public void changeEntityStatus(IGASM01DTO dto) throws BLException {
		log.debug("========�ʲ�ģ��״̬�仯������ʼ========");
		IGASM0101Form form = dto.getIgasm0101Form();
		SOC0117Info entity = soc0117BL.searchEntityByKey(form.getEid());
		String status = "";
		if(entity == null){
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","�ʲ�ģ��״̬���");
		}
		//1Ϊ���� 2Ϊͣ��
		if("1".equals(dto.getEstatus())){
			status="2";
		}else if("2".equals(dto.getEstatus())){
			status="1";
		}
		IGASM0102Form form0102 = new IGASM0102Form();
		//������ʾ�趨
		form0102.setEcategory(entity.getEcategory());
		form0102.setEid(entity.getEid());
		form0102.setEkey1(entity.getEkey1());
		form0102.setEkey2(entity.getEkey2());
		form0102.setEkey3(entity.getEkey3());
		form0102.setElabel(entity.getElabel());
		form0102.setEname(entity.getEname());
		form0102.setEstatus(status);//�����ʲ�ģ��״̬
		form0102.setEsyscoding(entity.getEsyscoding());
		form0102.setEparcoding(entity.getEparcoding());
		form0102.setEdesc(entity.getEdesc());
		if("999".equals(entity.getEparcoding())){
			form0102.setEparname("�ʲ�ģ��");
		}
		else{
			SOC0117SearchCondImpl ret = new SOC0117SearchCondImpl();
			ret.setEsyscoding(entity.getEparcoding());
			List<SOC0117Info> list = this.soc0117BL.searchEntity(ret, 0, 0);
			for (int i = 0; i < list.size(); i++) {
				form0102.setEparname(list.get(0).getEname());
			}
		}
		form0102.setEidStr(String.valueOf(form.getEid()));
		
		soc0117BL.updateEntity(form0102);

		log.debug("========�ʲ�ģ��״̬�仯��������========");
		
	}
	
	/**
	 * ��ѯ���������������񼰷����¼��һ��ģ�ͣ�����EXCELģ��ʹ�ã�
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO searchEntityActionForExportExcelModel(IGASM01DTO dto) throws BLException {

		log.debug("========һ��ģ�Ͳ�ѯ������ʼ========");
		
		//�ʲ���Ϣ��ѯ����ȡ�� 
		
		int totalCount = this.soc0117BL.getEntitySearchCount(dto.getEntitySearchCond());
		
		if (totalCount == 0) {
			log.debug("========�ʲ���Ϣ��ѯ���ݲ�����========");
			//�ʲ���Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�ʲ���Ϣ��ѯ���ݼ�������========");
			//�ʲ���Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ҳ����Ϣȡ��
		//��ǰҳ�ʲ���Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		List<SOC0117Info> entityList = this.soc0117BL.searchEntity(dto.getEntitySearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
//		List<Entity> newList = new ArrayList<Entity>();
//		for(Entity e:entityList){
//			if(!CommonDefineUtils.ENTIY_CATEGORY_SERVICE_RECORD_SYSCODING.equals(e.getEsyscoding())){
//				newList.add(e);
//			}
//		}
//		if(newList==null){
//			throw new BLException("IGASM0101.E006");
//		}
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityList(entityList);
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========һ��ģ�Ͳ�ѯ��������========");
		return dto;
	}
	
	
	/**
	 * ȡ�øý����ʲ�ģ��ȫ��
	 * @param syscoding
	 * @return
	 */
	private String getCompleteEntityName(String syscoding) {
		StringBuffer ename = new StringBuffer();
		try{
			ArrayList<String> codelist = new ArrayList<String>();
			if(syscoding.length()==6){
				codelist.add(syscoding);
			}else{
				String pcode = syscoding.substring(0, 6);
				codelist.add(pcode);
				String childs = syscoding.substring(6);
				int j = childs.length()/3;
				for(int i=1;i<=j;i++){
					codelist.add(pcode+childs.substring(0, 3*i));
				}
				
			}
			SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
			cond.setSelectList(codelist);
			List<SOC0117Info> ret = soc0117BL.searchEntity(cond, 0, 0);
			
			for(int i=0,j=ret.size();i<j;i++){
				String syscode = ret.get(i).getEsyscoding();
				if(syscoding.contains(syscode)){
					if(i>0){
						ename.append("-");
					}
					ename.append(ret.get(i).getEname());
				}
				
			}

		}catch(Exception e){
			e.printStackTrace();
		}
		return ename.toString();
	}
	
	
	/**
	 * ����Excelģ��
	 * @throws Exception
	 */
	public IGASM01DTO searchInfoForExportExcel(String esyscode) throws BLException{

		try
		{
			IGASM01DTO dto = new IGASM01DTO();
			//��ѯ�ʲ�ģ�ͣ������������񡢷����¼��
//			List<String> selectList = new ArrayList<String>();
//			selectList.add("999001");
//			selectList.add("999002");
//			selectList.add("999003");
//			selectList.add("999005");
//			selectList.add("999006");
//			selectList.add("999010");
//			selectList.add("999011");
//			selectList.add("999012");
//			selectList.add("999013");
			SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
			//cond.setSelectList(selectList);
			cond.setEsyscoding(esyscode);
			List<SOC0117Info> list = soc0117BL.searchEntity(cond, 0, 0);
			dto.setTopEntityList(list);
			
			
			//��ѯ�ʲ�ģ�ͣ������������񡢷����¼,����Ϊ��ǰ������ʲ�ģ�ͱ����Ӧ���ʲ�ģ�ͼ��ϣ�
			List<String> delList = new ArrayList<String>();
			delList.add("999007");
			delList.add("999008");
			delList.add("999009");
			SOC0117SearchCondImpl cond1 = new SOC0117SearchCondImpl();
			cond1.setDelList(delList);
			cond1.setSyscoding_q(esyscode);
			List<SOC0117Info> elist = soc0117BL.searchEntity(cond1, 0, 0);
			List<SOC0117Info> entitylist = new ArrayList<SOC0117Info>();
			for(SOC0117Info entity:elist){
				SOC0117TB etb = (SOC0117TB)SerializationUtils.clone(entity);
				etb.setEname(getCompleteEntityName(etb.getEsyscoding()));
				entitylist.add(etb);
			}
			dto.setEntityList(entitylist);
			
			//��ȡֵ��Χ
			SOC0151SearchCondImpl ccdcond = new SOC0151SearchCondImpl();
			ccdcond.setCcdstatus("1");//��ѯ״̬Ϊ���õ�����
			List<SOC0151Info> ccdlist  = soc0151BL.searchConfigurationCodeDetail(ccdcond, 0, 0);
			dto.setCcdList(ccdlist);
			
			//��ѯ����
			IGSYM01BL sym01BL = (IGSYM01BL) WebApplicationSupport.getBean("igsym01BL");
			IGSYM01DTO sym01dto = sym01BL.searchOrganizationForIGASM0101();
			List<Organization> orglist = sym01dto.getOrganizationCondList();
			dto.setOrglist(orglist);
			
			//��ѯ���ʲ�������
			List<Map<String,List<SOC0109Info>>> maplist = new ArrayList<Map<String,List<SOC0109Info>>>();
			for(SOC0117Info entity:list){
				List<String> cattachList = new ArrayList<String>();
				Map<String,List<SOC0109Info>> map = new LinkedHashMap<String,List<SOC0109Info>>();
				//codedetail����CCIDΪ012�ļ�¼�����ʲ����������ͣ�CIDΪ�ʲ����������͵�ֵ
				cattachList.add("0");//�ʲ�����������Ϊ�ı���
				cattachList.add("2");//�ʲ�����������Ϊ������
				cattachList.add("3");//�ʲ�����������Ϊ����
				
				//�ʲ�������Ϣ�ֲ�β�ѯ
				List<SOC0117Info> parentlist = this.soc0117BL.getParentNodes(entity.getEid());
				for(SOC0117Info e : parentlist){
					SOC0109SearchCondImpl cond2 = new SOC0109SearchCondImpl();
					cond2.setCseq(1);//ֻ��ѯҳ����ʾ������
					cond2.setEid(e.getEid().toString());
					cond2.setCattachList(cattachList);
					List<SOC0109Info> configurationList = this.soc0109BL.searchConfiguration(cond2, 0, 0);
					map.put(e.getEsyscoding(), configurationList);
				}
				maplist.add(map);
			}
			dto.setConfigurationMapList(maplist);

			
			//��ѯ�û�
			IGSYM02BL sym02BL = (IGSYM02BL) WebApplicationSupport.getBean("igsym02BL");
			IGSYM02DTO sym02dto = sym02BL.searchUserActionForIGASM0101();
			List<User> userlist = sym02dto.getUserList();
			dto.setUserlist(userlist);
			
			
			return dto;
		}catch (Exception e){
			e.printStackTrace();
			log.debug("=============����һ���ʲ�ģ��ģ�������==============");
			log.debug(e.getMessage());
			throw new BLException("IGASM0101.E007");
		}
		
	}

	/**
	 * �ʲ���Ϣ��ѯ����
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO searchEntityAction(IGASM01DTO dto) throws BLException {

		log.debug("========�ʲ���Ϣ��ѯ������ʼ========");
		
		//�ʲ���Ϣ��ѯ����ȡ�� 
		int totalCount = this.soc0117BL.getEntitySearchCount(dto.getEntitySearchCond());
		
		if (totalCount == 0) {
			log.debug("========�ʲ���Ϣ��ѯ���ݲ�����========");
			//�ʲ���Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�ʲ���Ϣ��ѯ���ݼ�������========");
			//�ʲ���Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();

		//��ǰҳ�ʲ���Ϣȡ��
		List<SOC0117Info> entityList = this.soc0117BL.searchEntity(dto.getEntitySearchCond(), pDto.getFromCount(), pDto.getPageDispCount());
		//int num = 0;
//		for(int i=0;i<entityList.size();i++){
//			Entity en = entityList.get(i);
//			if("007".equals(en.getElabel())){//ȥ������
//				//num++;
//				entityList.remove(i);
//				i--;
//			}else if("008".equals(en.getElabel())){//ȥ������
//				//num++;
//				entityList.remove(i);
//				i--;
//			}
//		}
//		
//		if("999".equals(dto.getEntitySearchCond().getEsyscoding_q())){
//			totalCount = totalCount - 2;
//		}
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityList(entityList);
		
		dto.setStopbuttonMap(getButtonNameList(entityList));
		dto.setStartbuttonMap(getStartButtonNameList(entityList));
		dto.addMessage(new ActionMessage("IGCO10000.I002",totalCount));
		
		log.debug("========�ʲ���Ϣ��ѯ��������========");
		return dto;
	}
	
	/**
	 * �ʲ���Ϣ�ǼǴ���
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO insertEntityAction(IGASM01DTO dto) throws BLException {
		log.debug("========�ʲ���Ϣ�ǼǴ�����ʼ========");
		
		
		
//		EntitySearchCondImpl cond = new EntitySearchCondImpl();
//		
//		cond.setEparcoding(form.getEparcoding());
//		
//		List<Entity> list = this.ig117BL.getMaxCodingEntitys(cond);
//		String esyscoding = "";
//		
//		String entitynum = ResourceUtility.getString("ENTITY_NUM");//�ʲ�ģ�ͱ���ļ���
//		if(entitynum == null || "".equals(entitynum)){
//			entitynum = "6";
//		}
//		int entity_num = Integer.valueOf(entitynum);
//		int entity_sys_len = 18;//�ʲ�ģ�ͱ����Ĭ�ϳ���
//		if(entity_num>1 && entity_num<10){
//			entity_sys_len = 3+3*(entity_num-1);
//		}
//		if(list.size()>0){//�����¼�����
//			Entity entity = list.get(0);
//			esyscoding = entity.getEsyscoding();
//			String temp = esyscoding.substring(esyscoding.length()-3);
//			if("999".equals(form.getEparcoding())){
//				String ecategory = entity.getEcategory();
//				ecategory = StringUtils.leftPad(Integer.parseInt(ecategory)+1+"", 3, "0");
//				if(ecategory.equals("999")){
//					throw new BLException(BLErrorType.ORGANIZATION_INSERT_ERROR,
//							"IGASM0101.E003","ģ�ͻ�����Ϣ");
//				}
//				form.setEcategory(ecategory);
//			}
//			if(temp.substring(temp.length()-3).equals("999")){
//				throw new BLException(BLErrorType.ORGANIZATION_INSERT_ERROR,
//						"IGASM0101.E004","ģ�ͻ�����Ϣ");
//			}
//			if("0".equals(temp.substring(0, 1))){//0**
//				String tmp = String.valueOf(Integer.valueOf(temp)+1);
//				if(tmp.length()==1){
//					temp = "00"+tmp;
//				}else if(tmp.length()==2){
//					temp = "0"+tmp;
//				}else{
//					temp = tmp;
//				}
//				esyscoding = esyscoding.substring(0,esyscoding.length()-3)+temp;
//			}else{//***
//				esyscoding = esyscoding.substring(0,esyscoding.length()-3)+String.valueOf(Integer.valueOf(temp)+1);
//			}
//			form.setEsyscoding(esyscoding);
//		}else{
//			
//			String syscode = form.getEparcoding();
//			
//			//�ж��Ƿ��Ѿ��ﵽ�涨�Ĳ����
//			if(syscode!=null && syscode.length()>=entity_sys_len){
//				throw new BLException(BLErrorType.ORGANIZATION_INSERT_ERROR,
//						"IGASM0101.E005","ģ�ͻ�����Ϣ");
//			}
//			
//			form.setEsyscoding(form.getEparcoding()+"001");
//		}
//		form.setEstatus("1");
		IGASM0102Form form = dto.getIgasm0102Form();
		dto.setEntity(form);
		SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
		cond.setEsyscoding(form.getEparcoding());
		List<SOC0117Info> entityList = this.soc0117BL.searchEntity(cond);
		if(entityList!=null && entityList.size()>0){
			//�ʲ���Ϣ�ǼǴ���
			SOC0117Info entity = this.soc0117BL.registEntity(dto.getEntity(),entityList.get(0).getEid());			
			dto.setEntity(entity);
		}else{
			//�ʲ���Ϣ�ǼǴ���
			SOC0117Info entity = this.soc0117BL.registEntity(dto.getEntity(),"");		
			dto.setEntity(entity);
		}

		dto.addMessage(new ActionMessage( "IGCO10000.I004", "ģ�ͻ�����Ϣ") );

		log.debug("========�ʲ���Ϣ�ǼǴ�������========");
		return dto;
	}

	/**
	 * �ʲ���Ϣ�༭���������ʾ����
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO initIGASM0102Action(IGASM01DTO dto) throws BLException {

		log.debug("========�ʲ���Ϣ�༭���������ʾ������ʼ========");
		
		IGASM0102Form form = dto.getIgasm0102Form();
		
		String eidStr = form.getEidStr();
		
		String eid = form.getEidStr();
		
		//��ʾ���ʲ���Ϣȡ��
		SOC0117Info entity = this.soc0117BL.searchEntityByKey(eid);
		
		if ( entity == null ){
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E004","��������ʲ�����");
		}
		
		//������ʾ�趨
		form.setEcategory(entity.getEcategory());
		form.setEdesc(entity.getEdesc());
		form.setEid(entity.getEid());
		form.setEkey1(entity.getEkey1());
		form.setEkey2(entity.getEkey2());
		form.setEkey3(entity.getEkey3());
		form.setElabel(entity.getElabel());
		form.setEname(entity.getEname());
		form.setEstatus(entity.getEstatus());
		form.setEsyscoding(entity.getEsyscoding());
		form.setEparcoding(entity.getEparcoding());
		form.setEmodeltype(entity.getEmodeltype());
		if("999".equals(entity.getEparcoding()))
		{
			form.setEparname("�ʲ�ģ��");
		}
		else{
			SOC0117SearchCondImpl ret = new SOC0117SearchCondImpl();
			ret.setEsyscoding(entity.getEparcoding());
			List<SOC0117Info> list = this.soc0117BL.searchEntity(ret, 0, 0);
			for (int i = 0; i < list.size(); i++) {
				form.setEparname(list.get(0).getEname());
			}
		}
		form.setEidStr(eidStr);
		
		//�༭ģʽ�趨
		form.setMode("1");
		
		dto.setIgasm0102Form(form);
		
		dto.addMessage(new ActionMessage("IGCO10000.I001","ģ�ͻ�����Ϣ"));
		
		log.debug("========�ʲ���Ϣ�༭���������ʾ��������========");
		return dto;
	}

	/**
	 * �ʲ���Ϣ���´���
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO updateEntityAction(IGASM01DTO dto) throws BLException {
		log.debug("========�ʲ���Ϣ���´�����ʼ========");
		
		//�ʲ���Ϣ���´���
		this.soc0117BL.updateEntity(dto.getEntity());
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "ģ�ͻ�����Ϣ") );
		log.debug("========�ʲ���Ϣ���´�������========");
		return dto;
	}
	
	/**
	 * �ʲ�������Ϣ�ǼǴ���
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO insertConfigurationAction(IGASM01DTO dto) throws BLException {
		log.debug("========�ʲ�������Ϣ�ǼǴ�����ʼ========");
		
	/*	//������Ϣ��ż��
		if (dto.getConfiguration().getClabel().compareTo(
				CommonDefineUtils.COMMON_CONFIG_LABEL_MIN) >=0 &&
				dto.getConfiguration().getClabel().compareTo(
						CommonDefineUtils.COMMON_CONFIG_LABEL_MAX) <=0 ) {
			throw new BLException(BLErrorType.CONFIGURATION_ALREADY_EXISTS,
			"IGCOM0102.E001");
			
		}*/

		//�ʲ�������Ϣ�ǼǴ���
		SOC0109Info configuration = this.soc0109BL.registConfiguration(dto.getConfiguration());
		
		dto.setConfiguration(configuration);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "ģ��������Ϣ") );

		log.debug("========�ʲ�������Ϣ�ǼǴ�������========");
		return dto;
	}

	/**
	 * �ʲ���ϸ��Ϣ���������ʾ����
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO initIGASM0106Action(IGASM01DTO dto) throws BLException {

		log.debug("========�ʲ���ϸ��Ϣ���������ʾ������ʼ========");
		//�ʲ�������Ϣ��ѯ
		SOC0117Info entity = this.soc0117BL.searchEntityByKey(dto.getConfigurationSearchCond().getEid());
		
		if (entity == null) {
			//�ʲ�����������Ϣ������
			throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
					"IGCO10000.E001");
		}
		
		dto.setEntity(entity);
		
		//�ʲ�������Ϣ��ѯ����ȡ�� 
		int totalCount = 0;
		List<SOC0117Info> list = this.soc0117BL.getParentNodes(entity.getEid());
		Map<String,List<SOC0109Info>> map = new LinkedHashMap<String,List<SOC0109Info>>();
		SOC0109SearchCondImpl cond = new SOC0109SearchCondImpl();
		cond.setCseq(1);
		//�ʲ�������Ϣ�ֲ�β�ѯ
		for(SOC0117Info e : list){
			cond.setEid(e.getEid().toString());
			List<SOC0109Info> configurationList = this.soc0109BL.searchConfiguration(cond, 0, 0);
			map.put(e.getEname(), configurationList);
			totalCount+=configurationList.size();
		}
		if (totalCount == 0) {
			log.debug("========�ʲ�������Ϣ��ѯ���ݲ�����========");
			//�ʲ�������Ϣ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I007",0));
			return dto;
		} 
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========�ʲ�������Ϣ��ѯ���ݼ�������========");
			//�ʲ�������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}
		dto.setConfigurationMap(map);

		dto.addMessage(new ActionMessage("IGCO10000.I007",totalCount));
		
		log.debug("========�ʲ���ϸ��Ϣ���������ʾ��������========");
		return dto;
	}

	/**
	 * �ʲ�������Ϣ���´���
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO updateConfigurationAction(IGASM01DTO dto) throws BLException {
		log.debug("========�ʲ�������Ϣ���´�����ʼ========");
		
		//�ʲ�������Ϣ���´���
		this.soc0109BL.updateConfiguration(dto.getConfiguration());
		
		dto.addMessage(new ActionMessage( "IGCO10000.I005", "ģ��������Ϣ") );
		log.debug("========�ʲ�������Ϣ���´�������========");
		return dto;
	}
	
	/**
	 * �ʲ�������Ϣ�༭���������ʾ����
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO initIGASM0104Action(IGASM01DTO dto) throws BLException {

		log.debug("========������ʲ�������Ϣ�༭���������ʾ������ʼ========");
		IGASM0104Form form = dto.getIgasm0104Form();
		
		String cid = form.getCidStr();
		
		//��ʾ���ʲ�������Ϣ��ѯ
		SOC0109Info configuration = this.soc0109BL.searchConfigurationByKey(cid);
		
		if ( configuration == null ){
			throw new BLException("IGCO10000.E004","��������ʲ�����");
		}
		
		//��ʾ���趨
		//KEY
		form.setEid(configuration.getEid());
		form.setCid(configuration.getCid());
		//���
		form.setClabel(configuration.getClabel());
		//����
		form.setCname(configuration.getCname());
		//��λ
		form.setCunit(configuration.getCunit());
		//����
		form.setCrequired(configuration.getCrequired());
		//״̬
		form.setCstatus(configuration.getCstatus());
		//˵��
		form.setCdesc(configuration.getCdesc());
		//���
		form.setCcategory(configuration.getCcategory());
		//ȡֵ��Χ
		form.setCoption(configuration.getCoption());
		//ȡֵ��Χ
		if("2".equals(configuration.getCattach())){
			SOC0151SearchCondImpl cond = new SOC0151SearchCondImpl();
			cond.setCcdcategory(configuration.getCoption());
			cond.setCcdstatus("1");
			List<SOC0151Info> list = soc0151BL.searchConfigurationCodeDetail(cond, 0, 0);
			if(!list.isEmpty()){
				form.setRangename(list.get(0).getCcdlabel());
			}
		}else if ("4".equals(configuration.getCattach())){//����ֵ����ģ��
			SOC0117SearchCondImpl cond = new SOC0117SearchCondImpl();
			cond.setEsyscoding(configuration.getCoption());
			List<SOC0117Info> list = soc0117BL.searchEntity(cond, 0, 0);
			if(list.size() == 1){
				form.setCename(list.get(0).getEname());
			}else{
				throw new BLException("IGASM0104.E001",dto.getEntitySearchCond().getEsyscoding());
			}
			form.setCesyscoding(configuration.getCoption());
			form.setCoption(null);
		}
		
		//˳��
		form.setCseq(configuration.getCseq());
		
		//������ʶ
		form.setCattach(configuration.getCattach());
		
		form.setCstatus(configuration.getCstatus());
		
		//�༭ģʽ�趨
		form.setMode("1");
		
		dto.setIgasm0104Form(form);
		
		dto.addMessage(new ActionMessage("IGCO10000.I001","ģ��������Ϣ"));
		
		log.debug("========������ʲ�������Ϣ�༭���������ʾ��������========");
		return dto;
	}

	/**
	 * �ʲ���Ϣɾ������
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO deleteEntityAction(IGASM01DTO dto) throws BLException {
		log.debug("========�ʲ���Ϣɾ��������ʼ========");
		
		for( int i=0;i<dto.getDeleteEntity().length;i++ ){
			String eid = dto.getDeleteEntity()[i];
			
			//�ʲ���Ϣ��ѯ����
			SOC0117Info entity = this.soc0117BL.searchEntityByKey(eid);
			
			if (entity == null){
				throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
						"IGCO10000.E004","ɾ�������ʲ�����");
			}

			//�ʲ���Ϣɾ������
			this.soc0117BL.deleteEntity(entity);
		}
		
		log.debug("========�ʲ���Ϣɾ����������========");
		return dto;
	}
	
	/**
	 * �ʲ�������Ϣɾ������
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO deleteConfigurationAction(IGASM01DTO dto) throws BLException {
		log.debug("========�ʲ�������Ϣɾ��������ʼ========");
		
		for( int i=0;i<dto.getDeleteConfiguration().length;i++ ){
			String cid = dto.getDeleteConfiguration()[i];
			
			//�ʲ�������Ϣ��ѯ
			SOC0109Info configuration = 
				this.soc0109BL.searchConfigurationByKey(cid);
			
			if (configuration == null){
				throw new BLException("IGCO10000.E004","ɾ�������ʲ�����");
			}
			
			//�ʲ�������Ϣɾ��
			this.soc0109BL.deleteConfiguration(configuration);
		}
		
		log.debug("========�ʲ�������Ϣɾ����������========");
		return dto;
	}
	
	/**
	 * �ʲ��������ݱ�ʶ��ѯ
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO searchConfigurationCodeDetailBean(IGASM01DTO dto) throws BLException {
		log.debug("========�ʲ��������ݲ�ѯ������ʼ========");
		SOC0151SearchCondImpl cond = new SOC0151SearchCondImpl();
		cond.setCcdtype("A");
		cond.setCcdstatus("1");
		List<ConfigurationCodeDetailBean> list = this.soc0151BL.searchConfigurationCodeDetailBean(cond);
		dto.setConfigurationCodeDetailBeanList(list);
		log.debug("========�ʲ��������ݲ�ѯ��������========");
		return dto;
	}
	
	/**
	 * �ʲ��������ݱ�ʶ��ѯ
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO searchConfigurationCodeDetail(IGASM01DTO dto) throws BLException {
		log.debug("========�ʲ��������ݲ�ѯ������ʼ========");
		if(dto.getIgasm0109Form() != null){
			this.changeCfgCodeDetailLabel(dto);
		}
		SOC0151SearchCondImpl cond = new SOC0151SearchCondImpl();
		cond.setCcdtype("A");
		List<String> tempList = new ArrayList<String>();
		List<SOC0151Info> retList = new ArrayList<SOC0151Info>();
		List<SOC0151Info> list = this.soc0151BL.searchConfigurationCodeDetail(cond, 0, 0);
		for (SOC0151Info configurationCodeDetail : list) {
			String ccdcategory = configurationCodeDetail.getCcdcategory();
			if(!tempList.contains(ccdcategory)){
				tempList.add(ccdcategory);
				retList.add(configurationCodeDetail);
			}
		}
		dto.setConfigurationCodeDetailList(retList);
		log.debug("========�ʲ��������ݲ�ѯ��������========");
		return dto;
	}
	
	protected void changeCfgCodeDetailLabel(IGASM01DTO dto) throws BLException{
		SOC0151SearchCondImpl cond = new SOC0151SearchCondImpl();
		cond.setCcdcategory(dto.getIgasm0109Form().getCcdcategory());
		List<SOC0151Info> list = this.soc0151BL.searchConfigurationCodeDetail(cond, 0, 0);
		for (SOC0151Info configurationCodeDetail : list) {
			SOC0151TB ccdTB = (SOC0151TB) configurationCodeDetail;
			ccdTB.setCcdlabel(dto.getIgasm0109Form().getCcdlabel());
			this.soc0151BL.registConfigurationCodeDetail(ccdTB);
		}
	}
	
	public IGASM01DTO searchCfgCodeDetailByCategory(IGASM01DTO dto) throws BLException {
		log.debug("========�ʲ��������ݲ�ѯ������ʼ========");
		if("changeValue".equals(dto.getFlag())){
			this.changeCfgCodeDetailValue(dto);
		} else if ("status".equals(dto.getFlag())){
			this.changeCfgCodeDetailStatus(dto);
		}
		SOC0151SearchCondImpl cond = new SOC0151SearchCondImpl();
		cond.setCcdtype("A");
		cond.setCcdcategory(dto.getIgasm0110Form().getCcdcategory());
		List<SOC0151Info> list = this.soc0151BL.searchConfigurationCodeDetail(cond, 0, 0);
		dto.setConfigurationCodeDetailList(list);
		log.debug("========�ʲ��������ݲ�ѯ��������========");
		return dto;
	}
	
	protected void changeCfgCodeDetailValue(IGASM01DTO dto) throws BLException{
		Integer ccdid = Integer.valueOf(dto.getIgasm0110Form().getCcdid());
		SOC0151Info configurationCodeDetail = soc0151BL.searchConfigurationCodeDetailByKey(ccdid);
		SOC0151TB ccdTB = (SOC0151TB) configurationCodeDetail;
		ccdTB.setCcdvalue(dto.getIgasm0110Form().getCcdvalue());
		this.soc0151BL.registConfigurationCodeDetail(ccdTB);
	}
	
	protected void changeCfgCodeDetailStatus(IGASM01DTO dto) throws BLException{
		Integer ccdid = Integer.valueOf(dto.getIgasm0110Form().getCcdid());
		SOC0151Info configurationCodeDetail = soc0151BL.searchConfigurationCodeDetailByKey(ccdid);
		SOC0151TB ccdTB = (SOC0151TB) configurationCodeDetail;
		if("1".equals(ccdTB.getCcdstatus())){
			ccdTB.setCcdstatus("0");
		}else if ("0".equals(ccdTB.getCcdstatus())){
			ccdTB.setCcdstatus("1");
		}
		this.soc0151BL.registConfigurationCodeDetail(ccdTB);
	}
	
	/**
	 * �ʲ��������ݵǼǴ���
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 */
	public IGASM01DTO insertConfigurationCodeDetailAction(IGASM01DTO dto) throws BLException {
		log.debug("========�ʲ���Ϣ�ǼǴ�����ʼ========");
		
		IGASM0108Form igasm0108form = dto.getIgasm0108Form();
		String[] values = igasm0108form.getCcdvalues();
		igasm0108form.setCcdtype("A");
		igasm0108form.setCcdstatus("1");
		String ccdcategory = "";
		SOC0151SearchCondImpl cond = new SOC0151SearchCondImpl();
		List<SOC0151Info> list = this.soc0151BL.searchConfigurationCodeDetail(cond, 0, 0);
		if(list.size()>0){//�����¼�����
			SOC0151Info ConfigurationCodeDetail = list.get(list.size() - 1);
			ccdcategory = ConfigurationCodeDetail.getCcdcategory();
			
			if(ConfigurationCodeDetail.equals("999")){
				throw new BLException("IGSYM0101.E004","���ݻ�����Ϣ");
			}
			if("0".equals(ccdcategory.substring(0, 1))){//0**
				String tmp = String.valueOf(Integer.valueOf(ccdcategory)+1);
				if(tmp.length()==1){
					ccdcategory = "00"+tmp;
				}else if(tmp.length()==2){
					ccdcategory = "0"+tmp;
				}else{
					ccdcategory = tmp;
				}
				
			}
			igasm0108form.setCcdcategory(ccdcategory);
		}else{
			igasm0108form.setCcdcategory("001");
		}
		if (values!=null && values.length>0) {
			for (int i = 0; i < values.length; i++) {
				igasm0108form.setCcdvalue(values[i]);
				dto.setIgasm0108Form(igasm0108form);
				dto.setConfigurationcodedetail(igasm0108form);
				SOC0151Info configurationcodedetail = this.soc0151BL.registConfigurationCodeDetail(dto.getConfigurationcodedetail());
				dto.setConfigurationcodedetail(configurationcodedetail);
			}
		}else{
			dto.setIgasm0108Form(igasm0108form);
			dto.setConfigurationcodedetail(igasm0108form);
			SOC0151Info configurationcodedetail = this.soc0151BL.registConfigurationCodeDetail(dto.getConfigurationcodedetail());
			dto.setConfigurationcodedetail(configurationcodedetail);
		}
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "���ݻ�����Ϣ") );

		log.debug("========�ʲ���Ϣ�ǼǴ�������========");
		return dto;
	}
	
	public IGASM01DTO getCfgCodeDetailByCategory(IGASM01DTO dto) throws BLException {
		log.debug("========�ʲ��������ݲ�ѯ������ʼ========");
		SOC0151SearchCondImpl cond = new SOC0151SearchCondImpl();
		cond.setCcdtype("A");
		cond.setCcdcategory(dto.getIgasm0111Form().getCcdcategory());
		List<SOC0151Info> list = this.soc0151BL.searchConfigurationCodeDetail(cond, 0, 0);
		dto.setConfigurationcodedetail(list.get(0));
		log.debug("========�ʲ��������ݲ�ѯ��������========");
		return dto;
	}
	
	public IGASM01DTO insertCfgCodeDetailAction(IGASM01DTO dto) throws BLException {
		log.debug("========�ʲ���Ϣ�ǼǴ�����ʼ========");
		IGASM0111Form igasm0111form = dto.getIgasm0111Form();
		String[] values = igasm0111form.getCcdvalues();
		igasm0111form.setCcdtype("A");
		igasm0111form.setCcdstatus("1");
		for (int i = 0; i < values.length; i++) {
			igasm0111form.setCcdvalue(values[i]);
			dto.setConfigurationcodedetail(igasm0111form);
			this.soc0151BL.registConfigurationCodeDetail(dto.getConfigurationcodedetail());
		}
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "���ݻ�����Ϣ") );

		log.debug("========�ʲ���Ϣ�ǼǴ�������========");
		return dto;
	}
	
	/**
	 * �ʲ�����Ĭ��ֵ�༭������ڻ�����
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 * @throws BLException
	 */
	public IGASM01DTO initIGASM0114Action(IGASM01DTO dto) throws BLException {
		log.debug("========�ʲ�����Ĭ��ֵ�༭������ڻ�������ʼ========");
		IGASM0114Form form = dto.getIgASM0114Form();
		IG611SearchCondImpl cond = new IG611SearchCondImpl();
		cond.setEsyscoding(form.getEsyscoding());
		cond.setEid(form.getEid());
		//������������Ϣȫ����ѯ
		List<IG612Info> lst_IG612Info = this.ig611BL.searchDefaultValue(cond);
		//��ѯģ����Ϣ
		SOC0117Info ig117info = soc0117BL.searchEntityByKey(form.getEid());
		if(ig117info != null){
			//Ϊģ��������ģ��˵����ֵ
			form.setEname(ig117info.getEname());
			form.setEdesc(ig117info.getEdesc());
		}
		int totalCount = lst_IG612Info.size();
		String[] Cvalue = new String[totalCount];
		String[] entityItemCvalue = new String[totalCount];
		Map<String,List<IG612Info>> map = new LinkedHashMap<String,List<IG612Info>>();
		int i = 0;
		int j = 0;
		List<String> strlist = new ArrayList<String>();
		for(IG612Info e : lst_IG612Info){
			if(!map.containsKey(e.getCcategory())){
				map.put(e.getCcategory(), new ArrayList<IG612Info>());
				strlist.add(e.getCcategory());
			}
			map.get(e.getCcategory()).add(e);
			if("2".equals(e.getCattach())){
				List<LabelValueBean> list = soc0151BL.searchLabelValueBeanList(e.getCoption());
				form.setSelectedListMap(j++, list);
			}
			if ("5".equals(e.getCattach())) {
				List<LabelValueBean> list =soc0151BL.searchLabelValueBeanList(e
						.getCoption());
				if (list.size() > 0) {
					list.remove(0);
				}
				form.setSelectedListMap(j++, list);
			}
		}
		for(String str : strlist){
			for(IG612Info e : map.get(str)){
				//��ʾ���ʲ����ƣ�ʵ�ʴ�ֵ���ʲ�����(�ʲ�ID)
				if("4".equals(e.getCattach()) && StringUtils.isNotEmpty(e.getCvalue())){
					Cvalue[i] = e.getCvalue().substring(0, e.getCvalue().lastIndexOf("("));
					entityItemCvalue[i] = e.getCvalue();
				} else {
					Cvalue[i] = e.getCvalue();
				}
				i++;
			}
		}
		form.setCvalue(Cvalue);
		form.setEntityItemCvalue(entityItemCvalue);
		dto.setMap_IG612Info(map);
		log.debug("========�ʲ�����Ĭ��ֵ�༭������ڻ���������========");
		return dto;
	}
	
	/**
	 * �ʲ�����Ĭ��ֵ�༭����
	 *
	 * @param dto IGASM01DTO
	 * @return IGASM01DTO
	 * @throws BLException 
	 */
	public IGASM01DTO editIGASM0114Action(IGASM01DTO dto) throws BLException, FileNotFoundException, IOException {
		log.debug("========�ʲ�����Ĭ��ֵ�༭������ʼ========");
		IGASM0114Form form = dto.getIgASM0114Form();
		//��ѯģ����Ϣ
		SOC0117Info entity = this.soc0117BL.searchEntityByKey(form.getEid());
		SOC0117TB etb = (SOC0117TB)SerializationUtils.clone(entity);
		etb.setEdesc(form.getEdesc());
		etb.setEname(form.getEname());
		//����ģ����Ϣ
		this.soc0117BL.updateEntity(etb);
		for( int i=0 ; i < form.getCid().length; i++ ){
			IG611TB ig611 = new IG611TB();
			//����ID
			ig611.setEid(Integer.parseInt(form.getEid()));
			//�ʲ�����ID
			ig611.setCid(Integer.parseInt(form.getCid()[i]));
			//����
			ig611.setCvalue(form.getCvalue()[i]);
			//��ʾ���ʲ����ƣ�ʵ�ʴ�ֵ���ʲ�����(�ʲ�ID)
			if("4".equals(form.getCiattach()[i]) && StringUtils.isNotEmpty(form.getEntityItemCvalue()[i])){
				ig611.setCvalue(form.getEntityItemCvalue()[i]);
			}
			//����ɾ��
			if("1".equals(form.getCiattach()[i]) && "1".equals(form.getDelfile()[i])){
				ig611.setCvalue("");
			}
			//�ϴ��ļ����
			if (form.getCiattach()[i].toUpperCase().equals("1")) {
				FormFile file = form.getAttachFile(i);
				if ( file != null && file.getFileSize() > 0) {
					//�ϴ��ļ����ڵ����
					//�ϴ��ļ�·��
					String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
					StringBuffer pathBuf = new StringBuffer();
					
					//��Ŀ¼
					pathBuf.append(rootPath);
					//����ID
					pathBuf.append("asm"+File.separator);
					//����ID
					pathBuf.append("model");
					pathBuf.append(File.separator);
					
					StringBuffer fileName = new StringBuffer();
					
					//��չ��ȡ��
					String fileType = "";
					String sFileName = file.getFileName();
					int point = sFileName.lastIndexOf(".");
					if (point != -1) {
						fileType = sFileName.substring(point);
						fileName.append(sFileName.substring(0, point));
					}
					
					//�ļ���
					fileName.append("_");
					fileName.append(form.getEid());
					fileName.append("&");
					fileName.append(form.getCid()[i]);
					//�ļ���չ��
					fileName.append(fileType);

					//�ļ��ϴ�����
					this.fileUploadBL.saveFile(file, pathBuf.toString(), fileName.toString());
					
					//����
					//�ϴ��ļ�������
					ig611.setCvalue(fileName.toString());
				}
			}
			this.ig611BL.registIG611Info(ig611);
		}
		dto.addMessage(new ActionMessage("IGCO10000.I005","����ģ�ͼ���������Ϣ"));
		log.debug("========�ʲ�����Ĭ��ֵ�༭��������========");
		return dto;
	}
}