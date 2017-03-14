/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.bl;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Hashtable;
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
import org.eclipse.birt.report.model.api.util.StringUtil;
import org.springframework.beans.BeanUtils;

import com.deliverik.framework.asset.model.entity.IG013TB;
import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.soc.asset.bl.task.SOC0107BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0109BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118VWBL;
import com.deliverik.framework.soc.asset.bl.task.SOC0119BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0151BL;
import com.deliverik.framework.soc.asset.model.SOC0107Info;
import com.deliverik.framework.soc.asset.model.SOC0109Info;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0118VWInfo;
import com.deliverik.framework.soc.asset.model.SOC0119Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.SOC0129Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0107SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0109SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0118SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0118VWSearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0119SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0129SearchCondImpl;
import com.deliverik.framework.soc.asset.model.entity.SOC0107TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0118TB;
import com.deliverik.framework.soc.asset.model.entity.SOC0119TB;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.bl.task.UserBL;
import com.deliverik.framework.user.bl.task.UserRoleBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.UserInfo;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.user.model.condition.UserInfoSearchCondImpl;
import com.deliverik.framework.user.model.entity.UserInfoVW;
import com.deliverik.framework.user.model.entity.UserTB;
import com.deliverik.framework.utility.BLErrorType;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.utility.ResourceUtility;
import com.deliverik.framework.workflow.prd.bl.task.IG222BL;
import com.deliverik.framework.workflow.prd.bl.task.IG333BL;
import com.deliverik.framework.workflow.prd.bl.task.IG560BL;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.IG560Info;
import com.deliverik.framework.workflow.prd.model.condition.IG222SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.condition.IG560SearchCondImpl;
import com.deliverik.infogovernor.asset.bl.IGASM05BLImpl;
import com.deliverik.infogovernor.drm.IGDRMCONSTANTS;
import com.deliverik.infogovernor.drm.dto.IGDRM05DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0501Form;
import com.deliverik.infogovernor.drm.form.IGDRM0502Form;
import com.deliverik.infogovernor.drm.form.IGDRM0504Form;
import com.deliverik.infogovernor.drm.form.IGDRM0507Form;
import com.deliverik.infogovernor.drm.util.ComputingTime;
import com.deliverik.infogovernor.drm.util.FlowDetail;
import com.deliverik.infogovernor.util.CodeDefine;
import com.deliverik.infogovernor.util.DateUtils;
import com.deliverik.infogovernor.util.MapKeySort;
/**
 * ר��Ԥ������BLʵ��
 * 
 * @author zyl
 *
 * 2015-2-27 09:40:14
 */
public class IGDRM05BLImpl implements IGDRM05BL {
	
	static Log log = LogFactory.getLog(IGDRM05BLImpl.class);
	
	/** �ʲ�ʵ��BL */
	protected SOC0118BL soc0118BL;
	/** �ʲ�ģ��BL */
	protected SOC0117BL soc0117BL;
	/** �ʲ�ģ������BL */
	protected SOC0109BL soc0109BL;
	/** �ʲ�����BL */
	protected SOC0107BL soc0107BL;
	/** �ļ��ϴ�BL */
	protected FileUploadBL fileUploadBL;
	/** ����BL */
	protected OrganizationBL organizationBL;
	/** �û���ɫ��Ȩ��ϢBL */
	protected UserRoleBL userRoleBL;
	/** �ʲ���ϵBL */
	protected SOC0119BL soc0119BL;
	/** �ʲ���ϵBL */
	protected SOC0151BL soc0151BL;
	/** ��������BL */
	protected CodeDetailBL codeDetailBL;
	/**
	 * ��ʼ��ר��Ԥ���ʲ�����ҳ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM05DTO init0501Action(IGDRM05DTO dto) throws BLException{
		
		log.info("==========ר��Ԥ���ʲ��Ǽǳ�ʼ����ʼ============");
		Integer eiid = dto.getIgdrm0501Form().getEiid();
		if(eiid!=null && eiid>0){
			SOC0124Info soc0124 = soc0118BL.searchEntityItemVWByKey(eiid);
			SOC0129SearchCondImpl cond = new SOC0129SearchCondImpl();
			cond.setEiid(String.valueOf(eiid));
			cond.setEsyscoding_q(soc0124.getEsyscoding());
			List<SOC0129Info> soc0129List = soc0107BL.searchConfigItemVW(cond);
			dto.setConfigItemList(soc0129List);
			dto.setEntityItemVW(soc0124);
		}else{
			SOC0109SearchCondImpl cond = new SOC0109SearchCondImpl();
			cond.setEsyscoding_like("999050");
			List<SOC0109Info> soc0109List = soc0109BL.searchConfiguration(cond);
			dto.setConfigurationList(soc0109List);
			
		}
		log.info("==========ר��Ԥ���ʲ��Ǽǳ�ʼ������============");
		
		return dto;
	}
	

	
	
	/**
	 * ר��Ԥ�������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM05DTO getSpecialPlanMaxNumber(IGDRM05DTO dto)throws BLException{
		IGDRM0501Form form = dto.getIgdrm0501Form();
		if(form!=null&&form.getEid()!=null&&!"".equals(form.getEid())){
			
		SOC0117Info soc0117Info = soc0117BL.searchEntityByKey(form.getEid());
		if(soc0117Info!=null&&soc0117Info.getElabel()!=null){
			
			SOC0118SearchCondImpl s118cond = new SOC0118SearchCondImpl();
			s118cond.setEilabel_like(soc0117Info.getElabel());
			List<SOC0118Info> s118InfoList = soc0118BL.searchEntityItem(s118cond);
			
			// ����Ŀǰ���ݿ�Ԥ���������ı��
			Integer maxcid = 0;
			if(s118InfoList.size()==0){
				
				dto.setMaxSPNumber(soc0117Info.getElabel()+"-0001");
				return dto;
				
			}
			for(SOC0118Info s118Info : s118InfoList){
				if (null != s118Info.getEilabel()&& Integer.parseInt(s118Info.getEilabel().split("-")[1]) > maxcid) {
						maxcid = Integer.parseInt(s118Info.getEilabel().split("-")[1]);
					}
					String MaxNumber = "0000".substring(String.valueOf(maxcid + 1).length()) + (maxcid + 1);
					dto.setMaxSPNumber(soc0117Info.getElabel()+"-"+MaxNumber);
			}
		}
			
		}
		return dto;
	}
	
	/**
	 * ר��Ԥ���ʲ���ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM05DTO searchSpeicalPlanResource(IGDRM05DTO dto)throws BLException{
		
		log.info("============ר��Ԥ���ʲ��б��ѯ��ʼ==============");
		
		IGDRM0502Form form = dto.getIgdrm0502Form();
		
		SOC0118SearchCondImpl cond = new SOC0118SearchCondImpl();
		
		BeanUtils.copyProperties(form, cond);
		if(!StringUtil.isEmpty(form.getEiinsdate())){
			cond.setEiinsdate_like(form.getEiinsdate());
		}
		if(form!=null&&form.getEsyscoding()!=null&&!"".equals(form.getEsyscoding())){
			cond.setEsyscoding_eq(form.getEsyscoding());
		}else{
			cond.setEsyscoding_like("999050");
			
		}
		if(!StringUtil.isEmpty(form.getPropentime())){
			cond.setPropentime(form.getPropentime());
		}
		if(!StringUtil.isEmpty(form.getPrclosetime())){
			cond.setPrclosetime(form.getPrclosetime());
		}
		cond.setEistatus("ISNULL");
		dto.setRootEsyscoding("999050");
		this.initNodeMap(dto);
		// ר��Ԥ���ʲ���ѯ����ȡ��
		int totalCount = this.soc0118BL.getEntityItemSearchCount(cond);
		
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ר��Ԥ���ʲ���ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========�ʲ�������Ϣ��ѯ���ݼ�������========");
			// ר��Ԥ���ʲ���ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		
		// ��ҳ����Ϣȡ��
		PagingDTO pDto = dto.getPagingDto();
		
		// ר��Ԥ���ʲ�ȡ��
		List<SOC0118Info> entitys = this.soc0118BL.searchEntityItem(cond, pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemList(entitys);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		
		log.info("============ר��Ԥ���ʲ��б��ѯ����==============");
		return dto;
		
	}
	
	/**
	 * ��ʼ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM05DTO initNodeMap(IGDRM05DTO dto)throws BLException{
		//ר��Ԥ����ѯ��������ʲ���
		List<Map<String, Object>> soc0117List = soc0117BL.getEntityNum(dto.getRootEsyscoding());
		Hashtable<String,TreeNode> tempMap = new Hashtable<String, TreeNode>();
		Map<String,TreeNode> allNode = new HashMap<String, TreeNode>();
		for(Map<String, Object> map : soc0117List){
			TreeNode node = new TreeNode();
			node.setId(map.get("ESYSCODING").toString());
			node.setRemark(map.get("EPARCODING").toString());
			//ר��Ԥ����Ϣ��ѯ����ȡ�� 
			node.setName(map.get("ENAME").toString()+"("+map.get("ACCOUNT").toString()+")");
			
			if(allNode.get(map.get("EPARCODING").toString())==null){
				tempMap.put(map.get("ESYSCODING").toString(), node);
			} else{
				allNode.get(map.get("EPARCODING").toString()).addChildTreeNode(map.get("ESYSCODING").toString(), node);
			}
			allNode.put(map.get("ESYSCODING").toString(), node);	
		}
		dto.setNodeMap(tempMap);
		
		return dto;
	}
	
	
	

	/**
	 * ר��Ԥ���ʲ��������
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM05DTO regSpecialPlanResource(IGDRM05DTO dto)throws BLException, FileNotFoundException, IOException{
		IGDRM0501Form form = dto.getIgdrm0501Form();
		SOC0118TB soc0118tb = new SOC0118TB();
		BeanUtils.copyProperties(form, soc0118tb);
		if(soc0118tb.getEiid()==null || soc0118tb.getEiid()==0){
			//��������
			soc0118tb.setEiversion(1);
			soc0118tb.setEismallversion(0);
			soc0118tb.setEiuserid(dto.getUser().getUserid());
			soc0118tb.setEiusername(dto.getUser().getUsername());
			soc0118tb.setEiorgsyscoding(form.getEiorgsyscoding());
			SOC0118Info soc0118Info = soc0118BL.registEntityItem(soc0118tb);
			
			String[] cids = form.getCids();
			String[] civalues = form.getCivalues();
			int i = 0;
			for (String cid : cids) {
				//�������Ͷ��еĵ�ר��Ԥ������
				if(!"CI500000010001".equals(cid)&&!"CI500000010002".equals(cid)){
					
					SOC0107TB soc0107tb = new SOC0107TB();
					soc0107tb.setCid(cid);
					soc0107tb.setCiupdtime(DateUtils.getCurrentTime());
					soc0107tb.setEid(soc0118Info.getEid());
					soc0107tb.setEsyscoding(soc0118Info.getEsyscoding());
					soc0107tb.setEiid(soc0118Info.getEiid());
					soc0107tb.setCiversion(soc0118Info.getEiversion());
					soc0107tb.setCismallversion(soc0118Info.getEismallversion());
					if("ciattach".equals(civalues[i])){
						//����Ǹ���
						uploadFile(form.getFiles(),soc0107tb);
					}else{
						soc0107tb.setCivalue(civalues[i]);
					}
					soc0107BL.registSOC0107(soc0107tb);
				}else{
					//������ר��Ԥ��
					if("999050001".equals(form.getEsyscoding())){
						SOC0107TB soc0107tb = new SOC0107TB();
						soc0107tb.setCid(cid);
						soc0107tb.setCiupdtime(DateUtils.getCurrentTime());
						soc0107tb.setEid(soc0118Info.getEid());
						soc0107tb.setEsyscoding(soc0118Info.getEsyscoding());
						soc0107tb.setEiid(soc0118Info.getEiid());
						soc0107tb.setCiversion(soc0118Info.getEiversion());
						soc0107tb.setCismallversion(soc0118Info.getEismallversion());
						if("ciattach".equals(civalues[i])){
							//����Ǹ���
							uploadFile(form.getFiles(),soc0107tb);
						}else{
							soc0107tb.setCivalue(civalues[i]);
						}
						soc0107BL.registSOC0107(soc0107tb);
						
					}	
				}
				i++;
			}
			
		}else{
			//�޸Ĳ���
		}
		
		return dto;
	}
	
	
	private SOC0107TB uploadFile( FormFile file,SOC0107TB soc0107tb) throws FileNotFoundException, IOException, BLException{
		if ( file != null && file.getFileSize() > 0) {
			//�ϴ��ļ����ڵ����
			//�ϴ��ļ�·��
			StringBuffer pathBuf = new StringBuffer();
			String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
			//��Ŀ¼
			pathBuf.append(rootPath);
			//����ID
			pathBuf.append("asm"+File.separator);
			//ר��Ԥ��ID
			pathBuf.append(soc0107tb.getEiid());
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
			
			//�ļ�����Ӱ汾��
			fileName.append("_");
			fileName.append(soc0107tb.getCiversion()+"_"+soc0107tb.getCismallversion());
			//�ļ���չ��
			fileName.append(fileType);

			//�ļ��ϴ�����
			this.fileUploadBL.saveFile(file, pathBuf.toString(), fileName.toString());
			
			//�ϴ��ļ�������
			soc0107tb.setCivalue(fileName.toString());
			
			//�������Ա�ʶ
			soc0107tb.setCicurver("1");
			
		}else{
			soc0107tb.setCivalue(null);
		}
		return soc0107tb;
	}
	/**
	 * ר��Ԥ����Ϣɾ������
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 */
	public IGDRM05DTO deleteEntityItemAction(IGDRM05DTO dto) throws BLException {
		log.debug("========ר��Ԥ����Ϣɾ������ʼ========");
		for( int i=0;i<dto.getDeleteEntityItem().length;i++ ){
			String eiid = dto.getDeleteEntityItem()[i];
			
			//ɾ��ǰɾ������ר��Ԥ��ȷ��
			SOC0118Info entityItem = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(eiid));
			
			if (entityItem == null){
				throw new BLException("IGCO10000.E004","ɾ������ר��Ԥ������");
			}
			SOC0118TB soc0118tb = (SOC0118TB) SerializationUtils.clone(entityItem);
			soc0118tb.setEistatus("D");
			//ר��Ԥ���߼�ɾ��
			this.soc0118BL.updateEntityItem(soc0118tb);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006","ר��Ԥ����Ϣ"));

		log.debug("========ר��Ԥ����Ϣɾ����������========");
		return dto;
	}
	
	/**
	 * ר��Ԥ���ʲ�������Ϣ�༭����
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGDRM05DTO editEntityItemAction(IGDRM05DTO dto) throws BLException, FileNotFoundException, IOException {
		log.debug("========ר��Ԥ���ʲ�������Ϣ�༭����ʼ========");
		//�汾������
		IGDRM0504Form form = dto.getIgdrm0504Form();
		//ר��Ԥ���ʲ�������Ϣ����
		SOC0118TB entityItem = (SOC0118TB) this.soc0118BL.searchEntityItemByKey(Integer.parseInt(form.getEiid()));
		// ȡ�ð汾�Ƿ�������ʶ
		String ident = form.getIdent();
		if(StringUtils.isEmpty(ident)){
			ident = IGASM05BLImpl.SAVE_VERSION;
		}
		// �汾�ų�ʼ��
		int version = 1;
		boolean versonFlag = false;
		// �ж��Ƿ������汾��
		if(form.getCiid()!=null&&form.getCiid().length!=0){
		// =====================>> �޸� start
		if (IGASM05BLImpl.SAVE_VERSION_UP.equals(ident)) { // �����汾��
			version = form.getEiversion() + 1;
			//�����Ƿ��ϵ������ѡ���ж��ĸ��ʲ���ϵ����
			String[] cldeiids=new String[form.getCiid().length];
			int index=0;
			if(form.getIsUpgrade()!=null&&form.getIsUpgrade().length>0){
                for(int i=0;i<form.getIsUpgrade().length;i++){
                    if(form.getIsUpgrade()[i]!=null&&"1".equals(form.getIsUpgrade()[i])){
                        if(form.getEntityItemCivalue()[i].lastIndexOf("(") != -1 && form.getEntityItemCivalue()[i].lastIndexOf(")") != -1){
                            String cldeiid=form.getEntityItemCivalue()[i].substring(form.getEntityItemCivalue()[i].lastIndexOf("(")+1,
                                    form.getEntityItemCivalue()[i].lastIndexOf(")"));
                            //���ʲ�������Ϣ
                            IG013TB cldEntityItem = (IG013TB) this.soc0118BL.searchEntityItemByKey(Integer.parseInt(cldeiid));
                            if(cldEntityItem!=null){
                            	 cldeiids[index]=cldeiid+"_"+cldEntityItem.getEiversion()+"_"+cldEntityItem.getEismallversion()+"_"+form.getCiid()[i];
                            }
                        }
                        index++;
                    }
                }
            }
			
			//�ʲ���ϵ��Ϣ�汾��������
			this.soc0119BL.upgradeEntityItemRelationOne(entityItem.getEiid(), entityItem.getEiversion(), entityItem.getEismallversion(),
					version, 0,cldeiids);
			
			if (version - 1 != entityItem.getEiversion()) {
				throw new BLException("IGCO00000.E004");
			}
		} else if (IGASM05BLImpl.SAVE_VERSION.equals(ident)) { // �������汾��

			version = form.getEiversion();
			if (version != entityItem.getEiversion()) {
				throw new BLException("IGCO00000.E004");
			}

			if (form.getEiversion() == 0) { // ���Ϊ��һ��ʱ�趨�汾��Ϊ ��1��
				versonFlag = true;
				version = 1;
			}
		}
	}
		//  << =================  end
		
		//�汾
		entityItem.setEiversion(version);
		
		entityItem.setEidesc(form.getEidesc());
		entityItem.setEiname(form.getEiname());
		entityItem.setEiorgsyscoding(form.getEiorgsyscoding());
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		//����ʱ��
		entityItem.setEiupdtime(datetime);
		
		this.soc0118BL.updateEntityItem(entityItem);
		//=======���¹�ϵ��ʼ========
		if(version ==1&&versonFlag){
			SOC0119SearchCondImpl eircond1 = new SOC0119SearchCondImpl();
			//ɾ����ʶ
			eircond1.setDeleteflag("0");
			//����ʲ���صĹ�ϵ��
			eircond1.setEirrelationcode(IGASM05BLImpl.EIRRELATIONCODE);
			eircond1.setEiid(String.valueOf(entityItem.getEiid()));
			//���ʲ����еĹ�ϵ��Ϣ
			List<SOC0119Info> ig313InfoList = this.soc0119BL.searchMaxEntityItemRelation(eircond1);
			if(ig313InfoList!=null&&ig313InfoList.size()>0){
				for(SOC0119Info ig313Info:ig313InfoList){
					SOC0119TB ig313tb=new SOC0119TB();
					ig313tb.setPareiid(ig313Info.getPareiid());
					ig313tb.setPareid(ig313Info.getPareid());
					ig313tb.setParsmallversion(ig313Info.getParsmallversion());
					ig313tb.setParversion(ig313Info.getParversion());
					ig313tb.setCldeiid(ig313Info.getCldeiid());
					ig313tb.setCldeid(ig313Info.getCldeid());
					ig313tb.setCldsmallversion(ig313Info.getCldsmallversion());
					ig313tb.setCldversion(ig313Info.getCldversion());
					ig313tb.setEirdesc(ig313Info.getEirdesc());
					ig313tb.setEirinfo(ig313Info.getEirinfo());
					ig313tb.setEirrelation(ig313Info.getEirrelation());
					ig313tb.setEirrelationcode(ig313Info.getEirrelationcode());
					ig313tb.setDeleteflag(ig313Info.getDeleteflag());
					ig313tb.setEirstatus(ig313Info.getEirstatus());
					ig313tb.setEirupdtime(ig313Info.getEirupdtime());
					ig313tb.setFingerPrint(ig313tb.getFingerPrint());
					//�����ϵʱ
					if(entityItem.getEiid().equals(ig313Info.getPareiid())){
						ig313tb.setParversion(entityItem.getEiversion());
						this.soc0119BL.registEntityItemRelation(ig313tb);
					}
					//�����ϵʱ
					if(entityItem.getEiid().equals(ig313Info.getCldeiid())){
						ig313tb.setCldversion(entityItem.getEiversion());
						this.soc0119BL.registEntityItemRelation(ig313tb);
					}
				}
			}
		}
		//=======���¹�ϵ����========
		
		//���ø���BL
		
		//ר��Ԥ���ʲ�������Ϣ����
		if (form.getCiid() != null && form.getCiid().length > 0 ) {
			
			for( int i=0 ; i < form.getCiid().length; i++ ){
				SOC0107TB configItem = new SOC0107TB();
				//ר��Ԥ���ʲ�ID
				configItem.setEiid(Integer.parseInt(form.getEiid()));
				//�ʲ�����ID
				configItem.setCid(form.getCid()[i]);
				//����ID
				configItem.setEid(form.getEid()[i]);
				//���Ͳ����
				configItem.setEsyscoding(form.getEsyscoding()[i]);
				//����
				if("CI070000000011".equalsIgnoreCase(form.getCid()[i])){
					configItem.setCivalue(version+"");
				}else {
					configItem.setCivalue(form.getCivalue()[i]);
				}
				//��汾��
				configItem.setCiversion(version);
				//С�汾��
				configItem.setCismallversion(0);
				//����ʱ��
				configItem.setCiupdtime(datetime);
				
				//��ʾ���ʲ����ƣ�ʵ�ʴ�ֵ���ʲ�����(�ʲ�ID)
				if("4".equals(form.getCiattach()[i]) && StringUtils.isNotEmpty(form.getEntityItemCivalue()[i])){
					configItem.setCivalue(form.getEntityItemCivalue()[i]);
				}
				
				//����ɾ��
				if("1".equals(form.getCiattach()[i]) && "1".equals(form.getDelfile()[i])){
					configItem.setCivalue("");
				}
				
				if (StringUtils.isEmpty(form.getCiid()[i])) {
					//���±�ʶ
					if(StringUtils.isEmpty(configItem.getCivalue())) {
						configItem.setCicurver("0");
					} else {
						configItem.setCicurver("1");
					}
					configItem = (SOC0107TB) this.soc0107BL.registSOC0107(configItem);
					//�������Ϊ�ʲ�ʱ�����ӹ�����ϵ
					if("4".equals(form.getCiattach()[i]) && StringUtils.isNotEmpty(form.getCivalue()[i])){
						SOC0119TB e = new SOC0119TB();
						e.setPareid(entityItem.getEid());
						e.setPareiid(entityItem.getEiid());
						e.setParversion(entityItem.getEiversion());
						e.setParsmallversion(entityItem.getEismallversion());
						String str = form.getEntityItemCivalue()[i];
						SOC0118Info ei = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(str.substring(str.lastIndexOf("(")+1, str.length()-1)));
						e.setCldeid(ei.getEid());
						e.setCldeiid(ei.getEiid());
						e.setCldversion(ei.getEiversion());
						e.setCldsmallversion(ei.getEismallversion());
						//˫��
						String relationcode = entityItem.getEsyscoding().substring(3, 6)+"-"+ei.getEsyscoding().substring(3, 6);	
						boolean flag = true ;
						CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
						condimpl.setBusinesscode_like(relationcode);
						List<CodeDetail> cd = codeDetailBL.searchCodeDetail(condimpl, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
						if ( cd.size()==1){
							flag = false;
							e.setEirrelation(cd.get(0).getCid());
							e.setEirrelationcode(cd.get(0).getBusinesscode());
						}
						if(flag){
							condimpl.setBusinesscode_like(ei.getEsyscoding().substring(3, 6)+"-"+entityItem.getEsyscoding().substring(3, 6));
							cd = codeDetailBL.searchCodeDetail(condimpl, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
							if ( cd.size()!=1){
								throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
										"IGCO10000.E017");
							}else{
								e.setEirrelation(cd.get(0).getCid());
								e.setEirrelationcode(cd.get(0).getBusinesscode());
								flag = false;
							}
						}
						if (flag){
							throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
									"IGCO10000.E017");
						}
						e.setEirupdtime(datetime);
						//��ѯ��������
						SOC0109Info config = this.soc0109BL.searchConfigurationByKey(form.getCid()[i]);
						String cname = config.getCname();
						e.setEirdesc("�������"+cname+"����");
						//����key
						e.setEirinfo(entityItem.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid());
						//����״̬ΪC����ϵ�����в���ɾ��
						e.setEirstatus("C");
						this.soc0119BL.registEntityItemRelation(e);
					}
					log.debug("�ʲ������[�ʲ�����ID:" + form.getCid()[i] + "]���봦��ɹ���");
					
				} else {
					//���±�ʶĬ��Ϊ0
					configItem.setCicurver("0");
					if ("4".equals(form.getCiattach()[i])){
						if(!form.getCivalue_bak()[i].equals(configItem.getCivalue())){
							//�����ʲ����Ա�ʶ
							configItem.setCicurver("1");
						}
					} else if(!form.getCivalue_bak()[i].equals(configItem.getCivalue())){
						//�������Ա�ʶ
						configItem.setCicurver("1");
					}
					
					// �ж��Ƿ������汾��
					if (IGASM05BLImpl.SAVE_VERSION_UP.equals(ident)) { // �����汾��

						configItem = (SOC0107TB) this.soc0107BL.registSOC0107(configItem);

					} else if (IGASM05BLImpl.SAVE_VERSION.equals(ident)) { // �������汾��
					
						Integer ciid = Integer.valueOf(form.getCiid()[i]); 
						
						// ��ѯ��ǰ������
						SOC0107Info cfi = this.soc0107BL.searchSOC0107ByKey(ciid);
						
						// �жϵ�ǰ�������Ƿ���������
						if(configItem.getCid().equals(cfi.getCid())){ // ����������������и���
							
							configItem.setCiid(ciid);
							configItem = (SOC0107TB) this.soc0107BL
								.updateSOC0107(configItem);
							
						}else{  // �����������������
							
							configItem = (SOC0107TB) this.soc0107BL
							.registSOC0107(configItem);
							
						}
					}
					
					//�������Ϊ�ʲ�ʱ�����ӹ�����ϵ
					if("4".equals(form.getCiattach()[i]) && StringUtils.isNotEmpty(form.getCivalue()[i])){
						SOC0119TB e = new SOC0119TB();
						e.setPareid(entityItem.getEid());
						e.setPareiid(entityItem.getEiid());
						e.setParversion(entityItem.getEiversion());
						e.setParsmallversion(entityItem.getEismallversion());
						String str = form.getEntityItemCivalue()[i];			
						SOC0118Info ei = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(str.substring(str.lastIndexOf("(")+1, str.length()-1)));
				
						e.setCldeid(ei.getEid());
						e.setCldeiid(ei.getEiid());
						e.setCldversion(ei.getEiversion());
						e.setCldsmallversion(ei.getEismallversion());
						//У���ϵ�Ƿ����
						SOC0119SearchCondImpl condPar = new SOC0119SearchCondImpl();
						condPar.setPareiid(entityItem.getEiid());//�ʲ�ID
						condPar.setParversion(entityItem.getEiversion());//�ʲ���汾
						condPar.setParsmallversion(entityItem.getEismallversion());//�ʲ�С�汾
						condPar.setDeleteflag("0");
						condPar.setEirstatus("C");
						condPar.setEirinfo(entityItem.getEiid()+"_"+form.getCiid()[i]+"_"+ei.getEiid());
						
						List<SOC0119Info> eirlist = this.soc0119BL.searchEntityItemRelation(condPar);
						
						if(eirlist.isEmpty()){
							//ɾ��ԭ�����еĹ�ϵ
							SOC0119SearchCondImpl eircond = new SOC0119SearchCondImpl();
							eircond.setEirinfo(entityItem.getEiid()+"_"+form.getCiid()[i]+"_");
							eircond.setEirstatus("C");
							eircond.setDeleteflag("0");
							List<SOC0119Info> eir = this.soc0119BL.searchMaxEntityItemRelation(eircond);
							for (SOC0119Info entityItemRelation : eir) {
								this.soc0119BL.deleteEntityItemRelation(entityItemRelation);
							}
							//˫��
							String relationcode = entityItem.getEsyscoding().substring(3, 6)+"-"+ei.getEsyscoding().substring(3, 6);	
							boolean flag = true ;
							CodeDetailSearchCondImpl condimpl = new CodeDetailSearchCondImpl();
							condimpl.setBusinesscode_like(relationcode);
							List<CodeDetail> cd = codeDetailBL.searchCodeDetail(condimpl, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
							if ( cd.size()==1){
								flag = false;
								e.setEirrelation(cd.get(0).getCid());
								e.setEirrelationcode(cd.get(0).getBusinesscode());
							}
							if(flag){
								condimpl.setBusinesscode_like(ei.getEsyscoding().substring(3, 6)+"-"+entityItem.getEsyscoding().substring(3, 6));
								cd = codeDetailBL.searchCodeDetail(condimpl, CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_1);
								if ( cd.size()!=1){
									throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
											"IGCO10000.E017");
								}else{
									e.setEirrelation(cd.get(0).getCid());
									e.setEirrelationcode(cd.get(0).getBusinesscode());
									flag = false;
								}
							}
							if (flag){
								throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR,
										"IGCO10000.E017");
							}
							e.setEirupdtime(datetime);
							//��ѯ��������
							SOC0109Info config = this.soc0109BL.searchConfigurationByKey(form.getCid()[i]);
							String cname = config.getCname();
							e.setEirdesc("�������"+cname+"����");
							//����key
							e.setEirinfo(entityItem.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid());
							//����״̬ΪC����ϵ�����в���ɾ��
							e.setEirstatus("C");
							this.soc0119BL.registEntityItemRelation(e);
						} else {
							if(eirlist.size() != 1) {
								throw new BLException(BLErrorType.ENTITY_NOT_EXISTS_ERROR, "IGCO10000.E017");
							} else {
								SOC0119TB eirTB = (SOC0119TB)SerializationUtils.clone(eirlist.get(0));
								
								eirTB.setEirinfo(eirTB.getEirinfo().replaceAll("_" + form.getCiid()[i] + "_", "_" + configItem.getCiid() + "_"));
								
								this.soc0119BL.updateEntityItemRelation(eirTB);
							}
						}
					}
					
					if("4".equals(form.getCiattach()[i]) && StringUtils.isEmpty(form.getCivalue()[i])){
						//ɾ��ԭ�����еĹ�ϵ
						SOC0119SearchCondImpl eircond = new SOC0119SearchCondImpl();
						eircond.setEirinfo(entityItem.getEiid()+"_"+form.getCiid()[i]+"_");
						eircond.setEirstatus("C");
						eircond.setDeleteflag("0");
						List<SOC0119Info> eir = this.soc0119BL.searchMaxEntityItemRelation(eircond);
						for (SOC0119Info entityItemRelation : eir) {
							this.soc0119BL.deleteEntityItemRelation(entityItemRelation);
						}
					}
					log.debug("�ʲ������[�ʲ�����ID:" + form.getCid()[i] + "]���´���ɹ���");
				}
				
				//�ϴ��ļ����
				//ɾ�����ļ���У���ϴ�zyl
				if(form.getDelfile()[i]==null)
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
						//ר��Ԥ���ʲ�ID
						pathBuf.append(configItem.getEiid());
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
						
						//�ļ�����Ӱ汾��
						fileName.append("_");
						fileName.append(configItem.getCiversion());
						//�ļ���չ��
						fileName.append(fileType);

						//�ļ��ϴ�����
						this.fileUploadBL.saveFile(file, pathBuf.toString(), fileName.toString());
						
						//�ϴ��ļ�������
						configItem.setCivalue(fileName.toString());
						
						//�������Ա�ʶ
						configItem.setCicurver("1");
						
						this.soc0107BL.updateSOC0107(configItem);					
						
					}
				}
			}
			
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I005","ר��Ԥ��ά��"));
		
		log.debug("========ר��Ԥ���ʲ�������Ϣ�༭��������========");
		
		return dto;
	}
	
	

	/**
	 * ר��Ԥ���ʲ�������Ϣ�༭������ڻ�����
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 */
	public IGDRM05DTO initIGDRM0504Action(IGDRM05DTO dto) throws BLException {

		log.debug("========ר��Ԥ���ʲ�������Ϣ�༭������ڻ�����ʼ========");
		
		IGDRM0504Form form = dto.getIgdrm0504Form();
		
		//ר��Ԥ���ʲ���Ϣ����
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				Integer.parseInt(form.getEiid()));
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","ר��Ԥ���ʲ�");
		}
		
		form.setEidesc(entityItemVWInfo.getEidesc());
		String eiorgsyscoding = entityItemVWInfo.getEiorgsyscoding();
		form.setEiorgsyscoding(eiorgsyscoding);
		form.setEsyscoding_q(entityItemVWInfo.getEsyscoding());
		if(!StringUtils.isEmpty(eiorgsyscoding)){
			OrganizationSearchCondImpl OrgCond = new OrganizationSearchCondImpl();
			OrgCond.setOrgsyscoding(eiorgsyscoding);
			List<Organization> orgList = this.organizationBL.searchOrganization(OrgCond, 0, 0);
			for (int i = 0; i < orgList.size(); i++) {
				form.setEiorgname(orgList.get(0).getOrgname());
			}
		}
		dto.setEiorgname(form.getEiorgname());
		dto.setEntityItemVW(entityItemVWInfo);
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		
		//ר��Ԥ���ʲ�������Ϣ��ѯ����ȡ�� 
		int totalCount = this.soc0107BL.getConfigItemVWSearchCount(form);
		
		if (totalCount == 0) {
			log.debug("========ר��Ԥ���ʲ�������Ϣ��ѯ���ݲ�����========");
			//ר��Ԥ���ʲ�������Ϣ��ѯ���ݲ�����
//			dto.addMessage(new ActionMessage("IGCO10000.I007",0));
			return dto;
		}
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========ר��Ԥ���ʲ�������Ϣ��ѯ���ݼ�������========");
			//ר��Ԥ���ʲ�������Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//ר��Ԥ���ʲ�������Ϣȫ����ѯ
		List<SOC0129Info> configItemVWInfoList = this.soc0107BL.searchConfigItemVW(
				form, 0, 0);
		
		String[] civalue = new String[totalCount];
		String[] delfile = new String[totalCount];
		String[] entityItemCivalue = new String[totalCount];
		String[] isUpgrade=new String[totalCount];
		//��žɰ汾ֵ
		String[] civalue_bak = new String[totalCount];
		Map<String,List<SOC0129Info>> map = new LinkedHashMap<String,List<SOC0129Info>>();
		int i = 0;
		int j = 0;
		List<String> strlist = new ArrayList<String>();
		Map<String, String> cldVersionMap=new HashMap<String, String>();//���ʲ��汾����
		for(SOC0129Info e : configItemVWInfoList){
			if("4".equals(e.getCattach())){
				String value = e.getCivalue();
				if(StringUtils.isNotEmpty(value)){
					Integer cldeiid = Integer.parseInt(value.substring(value.lastIndexOf("(")+1, value.length()-1));//���ʲ�eiid
					
					SOC0119SearchCondImpl cond=new SOC0119SearchCondImpl();
					cond.setPareiid(Integer.parseInt(form.getEiid()));
					cond.setCldeiid(cldeiid);
					cond.setParversion(entityItemVWInfo.getEiversion());
					cond.setEirinfo("_"+e.getCiid()+"_");
					cond.setDeleteflag("0");
					List<SOC0119Info> ig313Info = soc0119BL.searchEntityItemRelation(cond);
					String cldversion="";
					if(ig313Info!=null&&ig313Info.size()>0){
						cldversion = String.valueOf(ig313Info.get(0).getCldversion());//���ʲ��汾
					}
					cldVersionMap.put(cldeiid.toString(), cldversion);
				}
			}
			if(!map.containsKey(e.getCcategory())){
				map.put(e.getCcategory(), new ArrayList<SOC0129Info>());
				strlist.add(e.getCcategory());
			}
			map.get(e.getCcategory()).add(e);
			if("2".equals(e.getCattach())){
				List<LabelValueBean> list = soc0151BL.searchLabelValueBeanList(e.getCoption());
				form.setSelectedListMap(j++, list);
			}
			if("5".equals(e.getCattach())){
				List<LabelValueBean> list = soc0151BL.searchLabelValueBeanList(e.getCoption());
				if(list.size() > 0){
					list.remove(0);
				}
				form.setSelectedListMap(j++, list);
			}
		}
		form.setCldVersionMap(cldVersionMap);
		for(String str : strlist){
			for(SOC0129Info e : map.get(str)){
				//��ʾ���ʲ����ƣ�ʵ�ʴ�ֵ���ʲ�����(�ʲ�ID)
				if("4".equals(e.getCattach()) && StringUtils.isNotEmpty(e.getCivalue())){
					civalue[i] = e.getCivalue().substring(0, e.getCivalue().lastIndexOf("("));
					isUpgrade[i]= e.getCivalue().substring(e.getCivalue().lastIndexOf("(")+1, e.getCivalue().lastIndexOf(")"));
					entityItemCivalue[i] = e.getCivalue();
				} else {
					civalue[i] = e.getCivalue();
				}
				civalue_bak[i] = e.getCivalue();
				i++;
			}
		}
		
		form.setCivalue(civalue);
		form.setEntityItemCivalue(entityItemCivalue);
		form.setDelfile(delfile);
		form.setCivalue_bak(civalue_bak);
		form.setIsUpgrade(isUpgrade);
		dto.setConfigItemVWInfoMap(map);

		//�����ʲ� ��ѯ ����Ӧ����Դ�ʲ� ר��
		if("999060".equals(entityItemVWInfo.getEsyscoding())){
			SOC0119SearchCondImpl cond=new SOC0119SearchCondImpl();
			cond.setPareiid(entityItemVWInfo.getEiid());
			cond.setParversion(entityItemVWInfo.getEiversion());
			cond.setDeleteflag("0");
			List<SOC0119Info> soc0119InfoLst = soc0119BL.searchEntityItemRelation(cond);
			List<SOC0118Info> soc0118InfoLst = new ArrayList<SOC0118Info>();
			for(SOC0119Info info:soc0119InfoLst){
				Integer cldEiid = info.getCldeiid();
				SOC0118Info soc118Info = soc0118BL.searchEntityItemByKey(cldEiid);
				soc0118InfoLst.add(soc118Info);
			}
			dto.setEntityItemList(soc0118InfoLst);
		}
		log.debug("========ר��Ԥ���ʲ�������Ϣ�༭������ڻ���������========");
		return dto;
	}
	/**
	 * ר��Ԥ��������Ϣ��ʷ��¼������ڻ�����
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 */
	public IGDRM05DTO initIGDRM0503Action(IGDRM05DTO dto) throws BLException {
		log.debug("========ר��Ԥ��������Ϣ��ʷ��¼������ڻ�����ʼ========");
		
		//ר��Ԥ����Ϣ����
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				dto.getIgdrm0503Form().getEiid());
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","ר��Ԥ��");
		}
		String eiorgsyscoding = entityItemVWInfo.getEiorgsyscoding();
		if(!StringUtils.isEmpty(eiorgsyscoding)){
			OrganizationSearchCondImpl OrgCond = new OrganizationSearchCondImpl();
			OrgCond.setOrgsyscoding(eiorgsyscoding);
			List<Organization> orgList = this.organizationBL.searchOrganization(OrgCond, 0, 0);
			for (int i = 0; i < orgList.size(); i++) {
				dto.setEiorgname(orgList.get(0).getOrgname());
			}
		}
		if (entityItemVWInfo.getEiversion() == 0 && entityItemVWInfo.getEismallversion() == 0) {
			dto.addMessage(new ActionMessage("IGASM0205.W001"));
		}
		
		dto.setEntityItemVWInfo(entityItemVWInfo);
		
		if (StringUtils.isEmpty(dto.getIgdrm0503Form().getCiversion()+"")) {
			dto.getIgdrm0503Form().setCiversion(String.valueOf(entityItemVWInfo.getEiversion()));
		}
		//��ȡ��ʷ�汾����ʱ��
		dto.setConfigItemVersionTime(this.soc0118BL.searchVersionUpdateTime(dto.getIgdrm0503Form().getEiid()));
		
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		log.debug("========ר��Ԥ��������Ϣ��ʷ��¼������ڻ���������========");
		return dto;
	}
	/**
	 * ������Ϣ��ʷ��¼������ڻ�����
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 */
	public IGDRM05DTO ClickVersionShow(IGDRM05DTO dto) throws BLException{
		log.debug("========������Ϣ��ʷ��¼������ڻ�����ʼ========");

		// ��Ϣ����
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(dto.getIgdrm0503Form().getEiid());

		if (entityItemVWInfo == null)
		{
			throw new BLException("IGCO10000.E004", "ר��Ԥ��ʵ��");
		}

		if (entityItemVWInfo.getEiversion() == 0 && entityItemVWInfo.getEismallversion() == 0) {
			dto.addMessage(new ActionMessage("IGASM0205.W001"));
		}

		if (StringUtils.isEmpty(dto.getIgdrm0503Form().getCiversion()+""))
		{
			dto.getIgdrm0503Form().setCiversion(String.valueOf(
					entityItemVWInfo.getEiversion()));
		}
		// �жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(),
				entityItemVWInfo);

		if (!flag)
		{
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}
		else
		{
			dto.setFlag(flag);
		}

		//SOC0107SearchCond
		SOC0107SearchCondImpl soc0107Cond = new SOC0107SearchCondImpl();
		soc0107Cond.setEiid(dto.getIgdrm0503Form().getEiid().toString());
		soc0107Cond.setCiversion(dto.getIgdrm0503Form().getCiversion());
		soc0107Cond.setCismallversion(dto.getIgdrm0503Form().getCismallversion());
		// ������Ϣ��ѯ����ȡ��
		int totalCount = this.soc0107BL.getSOC0107SearchCount(soc0107Cond);

		if (totalCount == 0)
		{
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
//			dto.addMessage(new ActionMessage("IGCO10000.I007", 0));
			return dto;
		}

		// ������Ϣȫ������

		List<SOC0107Info> configItemList = this.soc0107BL.searchSOC0107(soc0107Cond, 0, 0);
		Map<String, List<SOC0107Info>> map = new LinkedHashMap<String, List<SOC0107Info>>();
		
		Map<String, String> cldVersionMap=new HashMap<String, String>();//���ʲ��汾����
		boolean bool=false;
		for (SOC0107Info e : configItemList)
		{
			if("4".equals(e.getConfiguration().getCattach())){
				String civalue = e.getCivalue();
				if(StringUtils.isNotEmpty(civalue)){
					int cldeiid = Integer.parseInt(civalue.substring(civalue.lastIndexOf("(")+1, civalue.length()-1));//���ʲ�eiid
					
					SOC0119SearchCondImpl cond = new SOC0119SearchCondImpl();
					cond.setPareiid(dto.getIgdrm0503Form().getEiid());
					cond.setCldeiid(cldeiid);
					if(StringUtils.isNotEmpty(dto.getIgdrm0503Form().getCiversion())){
						cond.setParversion(Integer.parseInt(dto.getIgdrm0503Form().getCiversion()));
					}
					cond.setEirinfo("_"+e.getCiid()+"_");
					cond.setDeleteflag("0");
					List<SOC0119Info> soc0119Info = soc0119BL.searchEntityItemRelation(cond);
					String cldversion="";
					if(soc0119Info!=null&&soc0119Info.size()>0){
						cldversion = String.valueOf(soc0119Info.get(0).getCldversion());//���ʲ��汾
					}
					cldVersionMap.put(String.valueOf(cldeiid), cldversion);
				}
			}
			if (!map.containsKey(e.getConfiguration().getCcategory()))
			{
				map.put(e.getConfiguration().getCcategory(),
						new ArrayList<SOC0107Info>());
			}
			
			if(bool){
				continue;
			}
			map.get(e.getConfiguration().getCcategory()).add(e);
		}
		dto.getIgdrm0503Form().setCldVersionMap(cldVersionMap);
		map = new MapKeySort<List<SOC0107Info>>().sort(map);
		dto.setConfigItemMap(map);
		dto.setEntityItemVWInfo(entityItemVWInfo);
		log.debug("========������Ϣ��ʷ��¼������ڻ���������========");
		return dto;
		
	}
	/**
	 * �ʲ���������Ϣ�汾�Ƚϻ�����ڻ�����
	 * 
	 * @param dto
	 *            IGDRM05DTO
	 * @return IGDRM05DTO
	 * @throws BLException
	 */
	public IGDRM05DTO versionCompare(IGDRM05DTO dto) throws BLException
	{
		log.debug("========�ʲ���������Ϣ�汾�Ƚϻ�����ڻ�����ʼ========");
	SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(Integer.parseInt(dto.getIgdrm05031Form().getEiid()));

	if (entityItemVWInfo == null)
	{
		throw new BLException("IGCO10000.E004", "ר��Ԥ��");
	}

	if (entityItemVWInfo.getEiversion() == 0)
	{
		dto.addMessage(new ActionMessage("IGCOM0205.W001"));
	}

	dto.setEntityItemVW(entityItemVWInfo);

	// �жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
	Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(),
			entityItemVWInfo);

	if (!flag)
	{
		dto.addMessage(new ActionMessage("IGCO10000.E022"));
		dto.setFlag(flag);
		return dto;
	}
	else
	{
		dto.setFlag(flag);
	}

	// ר��Ԥ��������Ϣ��ѯ����ȡ��
	int totalCount = this.soc0107BL.getSOC0107SearchCount(dto
			.getIgdrm05031Form());

	if (totalCount == 0)
	{
		log.debug("========��ѯ���ݲ�����========");
		// ��ѯ���ݲ�����
//		dto.addMessage(new ActionMessage("IGCO10000.I007", 0));
		return dto;
	}

	// ר��Ԥ��������Ϣȫ������

	List<SOC0107Info> configItemList = this.soc0107BL.searchSOC0107(dto.getIgdrm05031Form(), 0, 0);
	dto.setEntityItemConfigurations(configItemList);

	dto.setFlag(flag);

	log.debug("========�ʲ���������Ϣ�汾�Ƚϻ�����ڻ���������========");
	return dto;
}
	/**
	 * ר��Ԥ����ϵ��������ڻ�����
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 */
	public IGDRM05DTO initIGDRM0506Action(IGDRM05DTO dto) throws BLException {
		log.debug("========ר��Ԥ����ϵ��������ڻ�����ʼ========");
		
		//ר��Ԥ����Ϣ����
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				Integer.parseInt(dto.getIgdrm0506Form().getEiid()));
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","ר��Ԥ��");
		}
		String eiorgsyscoding = entityItemVWInfo.getEiorgsyscoding();
		if(!StringUtils.isEmpty(eiorgsyscoding)){
			OrganizationSearchCondImpl OrgCond = new OrganizationSearchCondImpl();
			OrgCond.setOrgsyscoding(eiorgsyscoding);
			List<Organization> orgList = this.organizationBL.searchOrganization(OrgCond, 0, 0);
			for (int i = 0; i < orgList.size(); i++) {
				dto.setEiorgname(orgList.get(0).getOrgname());
			}
		}
		dto.setEntityItemVWInfo(entityItemVWInfo);
		
		Map<String,List<SOC0119Info>> parmap = new LinkedHashMap<String,List<SOC0119Info>>();
		//���������ϵ����
		SOC0119SearchCondImpl parcond = new SOC0119SearchCondImpl();
		if((dto.getIgdrm0506Form().getEiid())!=null)
		{parcond.setPareiid(Integer.parseInt(dto.getIgdrm0506Form().getEiid()));}
		parcond.setParversion(entityItemVWInfo.getEiversion());
		parcond.setParsmallversion(entityItemVWInfo.getEismallversion());
		parcond.setDeleteflag("0");
		//�жϵ�½�û��Ƿ��в鿴���ʲ�������Ϣ��Ȩ��
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		//ר��Ԥ����ϵ��Ϣ��ѯ����ȡ�� 
		int totalCount = this.soc0119BL.getEntityItemRelationSearchCount(parcond);
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========ר��Ԥ����ϵ��Ϣ��ѯ���ݼ�������========");
			//ר��Ԥ����ϵ��Ϣ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		if ( totalCount>0 ) {
			//ר��Ԥ����ϵ��Ϣȫ������
			List<SOC0119Info> parEntityItemRelationList = this.soc0119BL.searchEntityItemRelation(parcond);
			dto.setParCount(parEntityItemRelationList.size());
			for(SOC0119Info e : parEntityItemRelationList){
				String key = e.getEirrelationcode().split("-")[0];
				String eirrelationcode = e.getEirrelationcode();
				String ecategory = e.getParEntityItemVW().getEcategory();
				if(!"-".equals(eirrelationcode.replaceAll(ecategory, ""))){
					key = eirrelationcode.replaceAll(ecategory, "").replaceAll("-", "");
				}
					if(!parmap.containsKey(key)){
						parmap.put(key, new ArrayList<SOC0119Info>());
					}
					((SOC0119TB)e).setParflag("0");
					parmap.get(key).add(e);
				}
		}
		if(parmap.size()==0){
			parmap = null;
		}
		dto.setParEntityItemRelationMap(parmap);

		log.debug("========ר��Ԥ����ϵ��������ڻ���������========");
		return dto;
	}
	
	/**
	 * ר��Ԥ����ϵɾ������
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 */
	public IGDRM05DTO deleteEntityItemRelationAction(IGDRM05DTO dto) throws BLException {
		log.debug("========ר��Ԥ����ϵɾ������ʼ========");
		
		for( int i=0;i<dto.getDeleteEntityItemRelation().length;i++ ){
			String eirid = dto.getDeleteEntityItemRelation()[i];
			
			SOC0119Info entityItemRelation = 
				this.soc0119BL.searchEntityItemRelationByKey(Integer.parseInt(eirid));
			
			if (entityItemRelation == null){
				throw new BLException("IGCO10000.E004","ɾ������ר��Ԥ����ϵ");
			}

			this.soc0119BL.deleteEntityItemRelation(entityItemRelation);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006","ר��Ԥ����ϵ��Ϣ"));

		log.debug("========ר��Ԥ����ϵɾ����������========");
		return dto;
	}

	/**
	 * ר��Ԥ����ϵ�ǼǴ���
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 */
	public IGDRM05DTO insertEntityItemRelationAction(IGDRM05DTO dto) throws BLException {
		log.debug("========ר��Ԥ����ϵ�ǼǴ���ʼ========");
		
		IGDRM0507Form form = dto.getIgdrm0507Form();
		
		//ר��Ԥ��ID���ӣ�ȡ��
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		
		cond.setElabel(form.getElabel());
		cond.setEilabel(form.getEilabel());
		
		List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
		
		if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
			throw new BLException("IGCO10000.E004","(�ʲ����=" + form.getElabel() + ",ר��Ԥ�����=" 
					+ form.getEilabel() + ")ר��Ԥ��");
		}
		
		form.setCldeiid(entityItemVWList.get(0).getEiid());
		form.setCldeid(entityItemVWList.get(0).getEid());
		form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
		form.setCldversion(entityItemVWList.get(0).getEiversion());
		
		//ר��Ԥ��ID�������ͣ��ӣ����
		if (form.getPareiid().intValue() == form.getCldeiid().intValue()) {
			//ר��Ԥ��ID������= ���ӣ�
			throw new BLException(BLErrorType.ENTITY_ITEM_RELATION_ERROR,
					"IGCO10000.E012","ר��Ԥ��");
		}
		
		//����ʱ���趨
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		//�ʲ���ϵ�Ǽ�
		SOC0119Info ret = 
			this.soc0119BL.registEntityItemRelation(dto.getIgdrm0507Form());
		
		dto.setEntityItemRelation(ret);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "ר��Ԥ����ϵ��Ϣ") );
		
		log.debug("========ר��Ԥ����ϵ�ǼǴ�������========");
		return dto;
	}
	
	/**
	 * ר��Ԥ����ϵ�༭������ڻ�����
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 */
	public IGDRM05DTO initIGDRM0507Action(IGDRM05DTO dto) throws BLException {
		log.debug("========ר��Ԥ����ϵ�༭������ڻ�����ʼ========");
		
		IGDRM0507Form form = dto.getIgdrm0507Form();
		SOC0119TB ret = 		
			(SOC0119TB) this.soc0119BL.searchEntityItemRelationByKey(
				form.getEirid());
		
		if ( ret == null ){
			throw new BLException("IGCO10000.E004","�༭����ר��Ԥ����ϵ");
		}
		
		//��������趨
		form.setPareiname(ret.getParEntityItemVW().getEiname());
		form.setPareid(ret.getPareid());
		form.setPareiid(ret.getPareiid());
		form.setCldeid(ret.getCldeid());
		form.setCldeiid(ret.getCldeiid());
		form.setEiridStr(ret.getEirid().toString());
		form.setEirdesc(ret.getEirdesc());
		form.setEirinfo(ret.getEirinfo());
		form.setEirrelation(ret.getEirrelation());
		form.setEirrelationcode(ret.getEirrelationcode());
		form.setElabel(ret.getCldEntityItemVW().getElabel());
		form.setEilabel(ret.getCldEntityItemVW().getEilabel());
		form.setTempeirrelation(ret.getEirrelation()+"#"+ret.getEirrelationcode());
		form.setEiname(ret.getCldEntityItemVW().getEiname());
		form.setMode("1");
		
		log.debug("========ר��Ԥ����ϵ�༭������ڻ���������========");
		return dto;
	}

	/**
	 * ר��Ԥ����ϵ���������
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 */
	public IGDRM05DTO updateEntityItemRelationAction(IGDRM05DTO dto) throws BLException {
		log.debug("========ר��Ԥ����ϵ���������ʼ========");
		IGDRM0507Form form = dto.getIgdrm0507Form();

		//����ʱ���趨
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		this.soc0119BL.updateEntityItemRelation(form);

		dto.addMessage(new ActionMessage( "IGCO10000.I005", "ר��Ԥ����ϵ��Ϣ") );

		log.debug("========ר��Ԥ����ϵ�������������========");
		return dto;
	}
	
	/**
	 *	��ȡר��Ԥ��������ϵ����
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 */
	public IGDRM05DTO searchRelationListAction(IGDRM05DTO dto) throws BLException {
		log.debug("========��ȡר��Ԥ��������ϵ����ʼ========");
		List<LabelValueBean> list = this.codeDetailBL.searchLabelValueBeanList(IGDRMCONSTANTS.ENTIY_CATEGORY_DOCUMENT,CodeDefine.getCodeDefine("PLAN_CONDITIONS_RELATION").getCcid());
		dto.setRelationList(list);
		log.debug("========��ȡר��Ԥ��������ϵ��������========");
		return dto;
	}
	/**
	 * @return the �ʲ�ʵ��BL
	 */
	public SOC0118BL getSoc0118BL() {
		return soc0118BL;
	}
	/**
	 * @param soc0118bl the �ʲ�ʵ��BL to set
	 */
	public void setSoc0118BL(SOC0118BL soc0118bl) {
		soc0118BL = soc0118bl;
	}
	/**
	 * @return the �ʲ�ģ��BL
	 */
	public SOC0117BL getSoc0117BL() {
		return soc0117BL;
	}
	/**
	 * @param soc0117bl the �ʲ�ģ��BL to set
	 */
	public void setSoc0117BL(SOC0117BL soc0117bl) {
		soc0117BL = soc0117bl;
	}
	/**
	 * @return the �ʲ�ģ������BL
	 */
	public SOC0109BL getSoc0109BL() {
		return soc0109BL;
	}
	/**
	 * @param soc0109bl the �ʲ�ģ������BL to set
	 */
	public void setSoc0109BL(SOC0109BL soc0109bl) {
		soc0109BL = soc0109bl;
	}
	/**
	 * @return the �ʲ�����BL
	 */
	public SOC0107BL getSoc0107BL() {
		return soc0107BL;
	}
	/**
	 * @param soc0107bl the �ʲ�����BL to set
	 */
	public void setSoc0107BL(SOC0107BL soc0107bl) {
		soc0107BL = soc0107bl;
	}
	/**
	 * @return the �ļ��ϴ�BL
	 */
	public FileUploadBL getFileUploadBL() {
		return fileUploadBL;
	}
	/**
	 * @param �ļ��ϴ�BL the fileUploadBL to set
	 */
	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}
	/**
	 * @return the ����BL
	 */
	public OrganizationBL getOrganizationBL() {
		return organizationBL;
	}
	/**
	 * @param ����BL the organizationBL to set
	 */
	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}
	/**
	 * @return the �û���ɫ��Ȩ��ϢBL
	 */
	public UserRoleBL getUserRoleBL() {
		return userRoleBL;
	}
	/**
	 * @param �û���ɫ��Ȩ��ϢBL the userRoleBL to set
	 */
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	/**
	 * @return the �ʲ���ϵBL
	 */
	public SOC0119BL getSoc0119BL() {
		return soc0119BL;
	}
	/**
	 * @param soc0119bl the �ʲ���ϵBL to set
	 */
	public void setSoc0119BL(SOC0119BL soc0119bl) {
		soc0119BL = soc0119bl;
	}
	/**
	 * @return the �ʲ���ϵBL
	 */
	public SOC0151BL getSoc0151BL() {
		return soc0151BL;
	}
	/**
	 * @param soc0151bl the �ʲ���ϵBL to set
	 */
	public void setSoc0151BL(SOC0151BL soc0151bl) {
		soc0151BL = soc0151bl;
	}
	/**
	 * @return the ��������BL
	 */
	public CodeDetailBL getCodeDetailBL() {
		return codeDetailBL;
	}
	/**
	 * @param ��������BL the codeDetailBL to set
	 */
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}
	
	/**
	 * ��ѯ���̵���ϸ��Ϣ
	 * @param dto
	 * @return
	 */
	public IGDRM05DTO searchFlowDetail(IGDRM05DTO dto)  throws BLException {
		IG333BL ig333BL = (IG333BL) WebApplicationSupport.getBean("ig333BL");
		IG560BL ig560BL = (IG560BL) WebApplicationSupport.getBean("ig560BL");
		SOC0118VWBL soc0118VWBL = (SOC0118VWBL) WebApplicationSupport.getBean("soc0118VWBL");
		IG222BL ig222BL = (IG222BL) WebApplicationSupport.getBean("ig222BL");
		UserBL userBL = (UserBL) WebApplicationSupport.getBean("userBL");
		UserInfoSearchCondImpl userCond = new UserInfoSearchCondImpl();
		IG560SearchCondImpl ig560Cond = new IG560SearchCondImpl();
		IG333SearchCondImpl ig333Cond = new IG333SearchCondImpl();
		IG222SearchCondImpl ig222Cond = new IG222SearchCondImpl();
		SOC0118VWSearchCondImpl soc0118Cond = new SOC0118VWSearchCondImpl();
		ig333Cond.setPdid(dto.getPdid());
		//�ڵ�list
		List<IG333Info> ig333List = ig333BL.searchIG333Info(ig333Cond);
		//�����List
		Map<String,FlowDetail> flowDetailMap = new HashMap<String,FlowDetail>();
		//����ӽڵ��List
		Map<String,Map<String,FlowDetail>> childFlowDetailMap = new HashMap<String,Map<String,FlowDetail>>();
		if(ig333List!=null && ig333List.size()>0){
			for(IG333Info ig333Info:ig333List){
				FlowDetail flowDetail = new FlowDetail();
				//�洢�ڵ�
				flowDetail.setIg333Info(ig333Info);
				ig560Cond.setPsdid(ig333Info.getPsdid());
				//��ѯ560�е����ݲ���ӵ�flowDetail��
				List<IG560Info> ig560List = ig560BL.searchIG560(ig560Cond);
				if(ig560List!=null &&ig560List.size()>0){
					List<SOC0118VWInfo> soc0118List = new ArrayList<SOC0118VWInfo>();
					for(IG560Info ig560Info :ig560List){
						if(StringUtils.isNotEmpty(ig560Info.getDfvalue())){
							if(ig560Info.getPidid().contains("002")&&ig560Info.getDfvalue().split("_").length>1){
								soc0118Cond.setEiid(ig560Info.getDfvalue().split("_")[1]);
								soc0118Cond.setId(Integer.parseInt(ig560Info.getDfvalue().split("_")[0]));
								List<SOC0118VWInfo> list = soc0118VWBL.searchEntityItem(soc0118Cond);
								if(list!=null &&list.size()>0){
									soc0118List.add(list.get(0));
								}
							}else{
								flowDetail.setDuty(ig560Info.getDfvalue());
							}
						}
						
					}
					//�洢Ӧ����Դ
					flowDetail.setSoc0118List(soc0118List);
				}
				//��ѯ�����˲��洢
				Map<String,UserInfo> userMap = new HashMap<String,UserInfo>();
				ig222Cond.setPsdid(ig333Info.getPsdid());
				List<IG222Info> ig222List = ig222BL.searchIG222Info(ig222Cond);
				if(ig222List!=null && ig222List.size()>0){
					for(IG222Info ig222Info:ig222List){
						if(StringUtils.isNotEmpty(ig222Info.getUserid())){
							userCond.setUserida(ig222Info.getUserid());
							 List<UserInfo> userList = userBL.searchUserInfo(userCond);
							 if(userList!=null && userList.size()>0){
								 UserInfo user = (UserInfo) userList.get(0);
								 userMap.put(user.getUserida(), user);
							 }
						}else{
							List<UserInfo> userInfoList = userBL.searchUserByRoleId(ig222Info.getRoleid());
							if(userInfoList!=null &&userInfoList.size()>0){
								for(int i = 0;i<userInfoList.size();i++){
									UserInfoVW user = new UserInfoVW();
									BeanUtils.copyProperties(userInfoList.get(i), user);
									user.setUserida(((UserTB)userInfoList.get(i)).getUserid());
									userMap.put(user.getUserida(), user);
								}
							}
						}
					}
					flowDetail.setUserMap(userMap);
				}
				//�ж��Ƿ�Ϊ�ӽڵ�
				if(StringUtils.isNotEmpty(ig333Info.getPpsdid())){
					if(childFlowDetailMap.get(ig333Info.getPpsdid())==null){
						Map <String,FlowDetail>childStepMap = new HashMap<String, FlowDetail>();
						childStepMap.put(ig333Info.getPsdid(),flowDetail);
						childFlowDetailMap.put(ig333Info.getPpsdid(), childStepMap);
					}else{
						childFlowDetailMap.get(ig333Info.getPpsdid()).put(ig333Info.getPsdid(), flowDetail);
					}
				}else{
					flowDetailMap.put(ig333Info.getPsdid(),flowDetail);
				}
				
			}
		}
		
		//�Ը��ڵ���������
		ComputingTime computingTime = new ComputingTime();
		Map<String,String> parentStepMap = computingTime.getOrderStep(dto.getPdid(),"null");
		List<FlowDetail> parentStepList = new ArrayList<FlowDetail>();
		Integer parentIndex = 0;
		for(String key:parentStepMap.keySet()){
			parentIndex++;
			FlowDetail flowDetail = flowDetailMap.get(key);
			flowDetail.setSequence(parentIndex.toString());
			parentStepList.add(flowDetail);
		}
		//����childFlowDetailMap���ӽڵ�ŵ����ڵ��List��
		for(String ppsdid:childFlowDetailMap.keySet()){
			Map<String,String> childStepMap = computingTime.getOrderStep(dto.getPdid(), ppsdid);
			Map<String,FlowDetail> childFlowMap = childFlowDetailMap.get(ppsdid);
			List<FlowDetail> childList = new ArrayList<FlowDetail>();
			for(String psdid:childStepMap.keySet()){
				childList.add(childFlowMap.get(psdid));
			}
			for(FlowDetail parentStep:parentStepList){
				if(parentStep.getIg333Info().getPsdid().equals(ppsdid)){
					//�������̽ڵ���
					Integer childIndex = 0;
					String parentSequence = parentStep.getSequence();
					for(FlowDetail childStep:childList){
						childIndex++;
						childStep.setSequence(parentSequence+"."+childIndex);
					}
					parentStep.setChildStepList(childList);
				}
			}
		}
		
		//����ƴ�ӽ�����ʾ
		StringBuffer outPrintStr = new StringBuffer();
		for(FlowDetail flowDetail:parentStepList){
				outPrintStr.append("<table class='table_style4'>");
				appendString(outPrintStr,flowDetail,1);
				if(flowDetail.getChildStepList()!=null &&flowDetail.getChildStepList().size()>0){
					for(FlowDetail childStep:flowDetail.getChildStepList()){
						appendString(outPrintStr,childStep,0);
					}
				outPrintStr.append("</table>");
			}
			
		}
		outPrintStr.append("</table>");
		dto.setOutPrintStr(outPrintStr.toString());
		
		return dto;
	}
	
	private void appendString(StringBuffer outPrintStr,FlowDetail flowDetail,int sign){
		if(sign == 0){
			outPrintStr.append("<tr><td colspan='5' style='border-width:0px;'><table class='table_style3'>");
		}
		
		
		//��һ��
		outPrintStr.append("<tr>");
			outPrintStr.append("<td width='4%' rowspan='3' style='text-align:center'>"+flowDetail.getSequence()+"</td>");
			outPrintStr.append("<td width='10%'>�ڵ����ƣ�</td>");
			outPrintStr.append("<td width='38%' style='text-align:left;'>"+flowDetail.getIg333Info().getPsdname()+"</td>");
			outPrintStr.append("<td width='10%'>״̬˵����</td>");
			outPrintStr.append("<td width='38%' style='text-align:left;'>"+flowDetail.getIg333Info().getPsddesc()+"</td>");
		outPrintStr.append("</tr>");
		//�ڶ���
		outPrintStr.append("<tr>");
			outPrintStr.append("<td width='10%'>Ԥ�ƻָ�ʱ�䣺</td>");
			outPrintStr.append("<td width='38%' style='text-align:left;'>"+flowDetail.getIg333Info().getBysequence()+"</td>");
			outPrintStr.append("<td width='10%'>����������</td>");
			if(flowDetail.getDuty()!=null){
				outPrintStr.append("<td td width='38%' style='text-align:left;'>"+flowDetail.getDuty()+"</td>");	
			}else{
				outPrintStr.append("<td td width='38%'></td>");
			}
		outPrintStr.append("</tr>");
		//������
		outPrintStr.append("<tr>");
			outPrintStr.append("<td width='10%'>Ӧ����Դ��</td>");
			outPrintStr.append("<td width='38%' style='text-align:left;'>");
			if(flowDetail.getSoc0118List()!=null &&flowDetail.getSoc0118List().size()>0){
				for(int index = 0;index<flowDetail.getSoc0118List().size();index++){
					SOC0118VWInfo soc0118 = flowDetail.getSoc0118List().get(index);
					if(index== flowDetail.getSoc0118List().size()-1){
						outPrintStr.append("<span style='cursor: pointer;color: blue;' onclick='openSOCDetail("+soc0118.getId()+","+soc0118.getEiid()+")'>"+soc0118.getEiname()+"</span>");
					}else{
						outPrintStr.append("<span style='cursor: pointer;color: blue;' onclick='openSOCDetail("+soc0118.getId()+","+soc0118.getEiid()+")'>"+soc0118.getEiname()+"</span>,");
					}
				}
			}
			outPrintStr.append("</td>");
			
			outPrintStr.append("<td width='10%'>�����ˣ�</td>");
			outPrintStr.append("<td width='38%' style='text-align:left;'>");
			
			if(flowDetail.getUserMap()!=null && flowDetail.getUserMap().size()>0){
				int index =0;
				for(String key:flowDetail.getUserMap().keySet()){
					 index++;
					 if(index<flowDetail.getUserMap().size()){
						 outPrintStr.append(flowDetail.getUserMap().get(key).getUsername()+"��");
					 }else{
						 outPrintStr.append(flowDetail.getUserMap().get(key).getUsername());
					 }
				}
			}
			outPrintStr.append("</td>");
			outPrintStr.append("</tr>");
		if(sign == 0){
			outPrintStr.append("</table></td></tr>");
		}
	}
}
