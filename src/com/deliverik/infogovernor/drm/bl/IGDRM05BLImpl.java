/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * 专项预案管理BL实现
 * 
 * @author zyl
 *
 * 2015-2-27 09:40:14
 */
public class IGDRM05BLImpl implements IGDRM05BL {
	
	static Log log = LogFactory.getLog(IGDRM05BLImpl.class);
	
	/** 资产实例BL */
	protected SOC0118BL soc0118BL;
	/** 资产模型BL */
	protected SOC0117BL soc0117BL;
	/** 资产模型属性BL */
	protected SOC0109BL soc0109BL;
	/** 资产属性BL */
	protected SOC0107BL soc0107BL;
	/** 文件上传BL */
	protected FileUploadBL fileUploadBL;
	/** 机构BL */
	protected OrganizationBL organizationBL;
	/** 用户角色授权信息BL */
	protected UserRoleBL userRoleBL;
	/** 资产关系BL */
	protected SOC0119BL soc0119BL;
	/** 资产关系BL */
	protected SOC0151BL soc0151BL;
	/** 基础数据BL */
	protected CodeDetailBL codeDetailBL;
	/**
	 * 初始化专项预案资产新增页面
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM05DTO init0501Action(IGDRM05DTO dto) throws BLException{
		
		log.info("==========专项预案资产登记初始化开始============");
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
		log.info("==========专项预案资产登记初始化结束============");
		
		return dto;
	}
	

	
	
	/**
	 * 专项预案最大编号
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
			
			// 查找目前数据库预案类型最大的编号
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
	 * 专项预案资产查询
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM05DTO searchSpeicalPlanResource(IGDRM05DTO dto)throws BLException{
		
		log.info("============专项预案资产列表查询开始==============");
		
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
		// 专项预案资产查询件数取得
		int totalCount = this.soc0118BL.getEntityItemSearchCount(cond);
		
		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			// 专项预案资产查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========资产域定义信息查询数据件数过多========");
			// 专项预案资产查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		
		// 分页用信息取得
		PagingDTO pDto = dto.getPagingDto();
		
		// 专项预案资产取得
		List<SOC0118Info> entitys = this.soc0118BL.searchEntityItem(cond, pDto.getFromCount(), pDto.getPageDispCount());
		
		pDto.setTotalCount(totalCount);
		
		dto.setEntityItemList(entitys);
		
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		
		log.info("============专项预案资产列表查询结束==============");
		return dto;
		
	}
	
	/**
	 * 初始化树
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM05DTO initNodeMap(IGDRM05DTO dto)throws BLException{
		//专项预案查询画面左侧资产树
		List<Map<String, Object>> soc0117List = soc0117BL.getEntityNum(dto.getRootEsyscoding());
		Hashtable<String,TreeNode> tempMap = new Hashtable<String, TreeNode>();
		Map<String,TreeNode> allNode = new HashMap<String, TreeNode>();
		for(Map<String, Object> map : soc0117List){
			TreeNode node = new TreeNode();
			node.setId(map.get("ESYSCODING").toString());
			node.setRemark(map.get("EPARCODING").toString());
			//专项预案信息查询件数取得 
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
	 * 专项预案资产保存操作
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDRM05DTO regSpecialPlanResource(IGDRM05DTO dto)throws BLException, FileNotFoundException, IOException{
		IGDRM0501Form form = dto.getIgdrm0501Form();
		SOC0118TB soc0118tb = new SOC0118TB();
		BeanUtils.copyProperties(form, soc0118tb);
		if(soc0118tb.getEiid()==null || soc0118tb.getEiid()==0){
			//新增操作
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
				//技术类型独有的的专项预案属性
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
						//如果是附件
						uploadFile(form.getFiles(),soc0107tb);
					}else{
						soc0107tb.setCivalue(civalues[i]);
					}
					soc0107BL.registSOC0107(soc0107tb);
				}else{
					//技术类专项预案
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
							//如果是附件
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
			//修改操作
		}
		
		return dto;
	}
	
	
	private SOC0107TB uploadFile( FormFile file,SOC0107TB soc0107tb) throws FileNotFoundException, IOException, BLException{
		if ( file != null && file.getFileSize() > 0) {
			//上传文件存在的情况
			//上传文件路径
			StringBuffer pathBuf = new StringBuffer();
			String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
			//根目录
			pathBuf.append(rootPath);
			//机能ID
			pathBuf.append("asm"+File.separator);
			//专项预案ID
			pathBuf.append(soc0107tb.getEiid());
			pathBuf.append(File.separator);
			
			StringBuffer fileName = new StringBuffer();
			
			//扩展名取得
			String fileType = "";
			String sFileName = file.getFileName();
			int point = sFileName.lastIndexOf(".");
			if (point != -1) {
				fileType = sFileName.substring(point);
				fileName.append(sFileName.substring(0, point));
			}
			
			//文件名后加版本号
			fileName.append("_");
			fileName.append(soc0107tb.getCiversion()+"_"+soc0107tb.getCismallversion());
			//文件扩展名
			fileName.append(fileType);

			//文件上传处理
			this.fileUploadBL.saveFile(file, pathBuf.toString(), fileName.toString());
			
			//上传文件名保存
			soc0107tb.setCivalue(fileName.toString());
			
			//更新属性标识
			soc0107tb.setCicurver("1");
			
		}else{
			soc0107tb.setCivalue(null);
		}
		return soc0107tb;
	}
	/**
	 * 专项预案信息删除处理
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 */
	public IGDRM05DTO deleteEntityItemAction(IGDRM05DTO dto) throws BLException {
		log.debug("========专项预案信息删除处理开始========");
		for( int i=0;i<dto.getDeleteEntityItem().length;i++ ){
			String eiid = dto.getDeleteEntityItem()[i];
			
			//删除前删除对象专项预案确认
			SOC0118Info entityItem = this.soc0118BL.searchEntityItemByKey(Integer.parseInt(eiid));
			
			if (entityItem == null){
				throw new BLException("IGCO10000.E004","删除对象专项预案基本");
			}
			SOC0118TB soc0118tb = (SOC0118TB) SerializationUtils.clone(entityItem);
			soc0118tb.setEistatus("D");
			//专项预案逻辑删除
			this.soc0118BL.updateEntityItem(soc0118tb);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006","专项预案信息"));

		log.debug("========专项预案信息删除处理终了========");
		return dto;
	}
	
	/**
	 * 专项预案资产配置信息编辑处理
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public IGDRM05DTO editEntityItemAction(IGDRM05DTO dto) throws BLException, FileNotFoundException, IOException {
		log.debug("========专项预案资产配置信息编辑处理开始========");
		//版本号生成
		IGDRM0504Form form = dto.getIgdrm0504Form();
		//专项预案资产基本信息更新
		SOC0118TB entityItem = (SOC0118TB) this.soc0118BL.searchEntityItemByKey(Integer.parseInt(form.getEiid()));
		// 取得版本是否升级标识
		String ident = form.getIdent();
		if(StringUtils.isEmpty(ident)){
			ident = IGASM05BLImpl.SAVE_VERSION;
		}
		// 版本号初始化
		int version = 1;
		boolean versonFlag = false;
		// 判断是否升级版本号
		if(form.getCiid()!=null&&form.getCiid().length!=0){
		// =====================>> 修改 start
		if (IGASM05BLImpl.SAVE_VERSION_UP.equals(ident)) { // 升级版本号
			version = form.getEiversion() + 1;
			//增加是否关系升级复选框，判断哪个资产关系升级
			String[] cldeiids=new String[form.getCiid().length];
			int index=0;
			if(form.getIsUpgrade()!=null&&form.getIsUpgrade().length>0){
                for(int i=0;i<form.getIsUpgrade().length;i++){
                    if(form.getIsUpgrade()[i]!=null&&"1".equals(form.getIsUpgrade()[i])){
                        if(form.getEntityItemCivalue()[i].lastIndexOf("(") != -1 && form.getEntityItemCivalue()[i].lastIndexOf(")") != -1){
                            String cldeiid=form.getEntityItemCivalue()[i].substring(form.getEntityItemCivalue()[i].lastIndexOf("(")+1,
                                    form.getEntityItemCivalue()[i].lastIndexOf(")"));
                            //子资产基本信息
                            IG013TB cldEntityItem = (IG013TB) this.soc0118BL.searchEntityItemByKey(Integer.parseInt(cldeiid));
                            if(cldEntityItem!=null){
                            	 cldeiids[index]=cldeiid+"_"+cldEntityItem.getEiversion()+"_"+cldEntityItem.getEismallversion()+"_"+form.getCiid()[i];
                            }
                        }
                        index++;
                    }
                }
            }
			
			//资产关系信息版本升级处理
			this.soc0119BL.upgradeEntityItemRelationOne(entityItem.getEiid(), entityItem.getEiversion(), entityItem.getEismallversion(),
					version, 0,cldeiids);
			
			if (version - 1 != entityItem.getEiversion()) {
				throw new BLException("IGCO00000.E004");
			}
		} else if (IGASM05BLImpl.SAVE_VERSION.equals(ident)) { // 不升级版本号

			version = form.getEiversion();
			if (version != entityItem.getEiversion()) {
				throw new BLException("IGCO00000.E004");
			}

			if (form.getEiversion() == 0) { // 如果为第一版时设定版本号为 “1”
				versonFlag = true;
				version = 1;
			}
		}
	}
		//  << =================  end
		
		//版本
		entityItem.setEiversion(version);
		
		entityItem.setEidesc(form.getEidesc());
		entityItem.setEiname(form.getEiname());
		entityItem.setEiorgsyscoding(form.getEiorgsyscoding());
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);
		//更新时间
		entityItem.setEiupdtime(datetime);
		
		this.soc0118BL.updateEntityItem(entityItem);
		//=======更新关系开始========
		if(version ==1&&versonFlag){
			SOC0119SearchCondImpl eircond1 = new SOC0119SearchCondImpl();
			//删除标识
			eircond1.setDeleteflag("0");
			//与该资产相关的关系码
			eircond1.setEirrelationcode(IGASM05BLImpl.EIRRELATIONCODE);
			eircond1.setEiid(String.valueOf(entityItem.getEiid()));
			//该资产现有的关系信息
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
					//正向关系时
					if(entityItem.getEiid().equals(ig313Info.getPareiid())){
						ig313tb.setParversion(entityItem.getEiversion());
						this.soc0119BL.registEntityItemRelation(ig313tb);
					}
					//方向关系时
					if(entityItem.getEiid().equals(ig313Info.getCldeiid())){
						ig313tb.setCldversion(entityItem.getEiversion());
						this.soc0119BL.registEntityItemRelation(ig313tb);
					}
				}
			}
		}
		//=======更新关系结束========
		
		//调用更新BL
		
		//专项预案资产配置信息更新
		if (form.getCiid() != null && form.getCiid().length > 0 ) {
			
			for( int i=0 ; i < form.getCiid().length; i++ ){
				SOC0107TB configItem = new SOC0107TB();
				//专项预案资产ID
				configItem.setEiid(Integer.parseInt(form.getEiid()));
				//资产配置ID
				configItem.setCid(form.getCid()[i]);
				//类型ID
				configItem.setEid(form.getEid()[i]);
				//类型层次码
				configItem.setEsyscoding(form.getEsyscoding()[i]);
				//内容
				if("CI070000000011".equalsIgnoreCase(form.getCid()[i])){
					configItem.setCivalue(version+"");
				}else {
					configItem.setCivalue(form.getCivalue()[i]);
				}
				//大版本号
				configItem.setCiversion(version);
				//小版本号
				configItem.setCismallversion(0);
				//更新时间
				configItem.setCiupdtime(datetime);
				
				//显示是资产名称，实际存值是资产名称(资产ID)
				if("4".equals(form.getCiattach()[i]) && StringUtils.isNotEmpty(form.getEntityItemCivalue()[i])){
					configItem.setCivalue(form.getEntityItemCivalue()[i]);
				}
				
				//附件删除
				if("1".equals(form.getCiattach()[i]) && "1".equals(form.getDelfile()[i])){
					configItem.setCivalue("");
				}
				
				if (StringUtils.isEmpty(form.getCiid()[i])) {
					//更新标识
					if(StringUtils.isEmpty(configItem.getCivalue())) {
						configItem.setCicurver("0");
					} else {
						configItem.setCicurver("1");
					}
					configItem = (SOC0107TB) this.soc0107BL.registSOC0107(configItem);
					//属性类别为资产时，增加关联关系
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
						//双向
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
						//查询属性名称
						SOC0109Info config = this.soc0109BL.searchConfigurationByKey(form.getCid()[i]);
						String cname = config.getCname();
						e.setEirdesc("由配置项："+cname+"建立");
						//增加key
						e.setEirinfo(entityItem.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid());
						//设置状态为C，关系管理中不可删除
						e.setEirstatus("C");
						this.soc0119BL.registEntityItemRelation(e);
					}
					log.debug("资产配置项：[资产配置ID:" + form.getCid()[i] + "]插入处理成功。");
					
				} else {
					//更新标识默认为0
					configItem.setCicurver("0");
					if ("4".equals(form.getCiattach()[i])){
						if(!form.getCivalue_bak()[i].equals(configItem.getCivalue())){
							//更新资产属性标识
							configItem.setCicurver("1");
						}
					} else if(!form.getCivalue_bak()[i].equals(configItem.getCivalue())){
						//更新属性标识
						configItem.setCicurver("1");
					}
					
					// 判断是否升级版本号
					if (IGASM05BLImpl.SAVE_VERSION_UP.equals(ident)) { // 升级版本号

						configItem = (SOC0107TB) this.soc0107BL.registSOC0107(configItem);

					} else if (IGASM05BLImpl.SAVE_VERSION.equals(ident)) { // 不升级版本号
					
						Integer ciid = Integer.valueOf(form.getCiid()[i]); 
						
						// 查询当前配置项
						SOC0107Info cfi = this.soc0107BL.searchSOC0107ByKey(ciid);
						
						// 判断当前配置项是否是新增的
						if(configItem.getCid().equals(cfi.getCid())){ // 不是新增配置项进行更新
							
							configItem.setCiid(ciid);
							configItem = (SOC0107TB) this.soc0107BL
								.updateSOC0107(configItem);
							
						}else{  // 新增配置项进行新增
							
							configItem = (SOC0107TB) this.soc0107BL
							.registSOC0107(configItem);
							
						}
					}
					
					//属性类别为资产时，增加关联关系
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
						//校验关系是否存在
						SOC0119SearchCondImpl condPar = new SOC0119SearchCondImpl();
						condPar.setPareiid(entityItem.getEiid());//资产ID
						condPar.setParversion(entityItem.getEiversion());//资产大版本
						condPar.setParsmallversion(entityItem.getEismallversion());//资产小版本
						condPar.setDeleteflag("0");
						condPar.setEirstatus("C");
						condPar.setEirinfo(entityItem.getEiid()+"_"+form.getCiid()[i]+"_"+ei.getEiid());
						
						List<SOC0119Info> eirlist = this.soc0119BL.searchEntityItemRelation(condPar);
						
						if(eirlist.isEmpty()){
							//删除原来已有的关系
							SOC0119SearchCondImpl eircond = new SOC0119SearchCondImpl();
							eircond.setEirinfo(entityItem.getEiid()+"_"+form.getCiid()[i]+"_");
							eircond.setEirstatus("C");
							eircond.setDeleteflag("0");
							List<SOC0119Info> eir = this.soc0119BL.searchMaxEntityItemRelation(eircond);
							for (SOC0119Info entityItemRelation : eir) {
								this.soc0119BL.deleteEntityItemRelation(entityItemRelation);
							}
							//双向
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
							//查询属性名称
							SOC0109Info config = this.soc0109BL.searchConfigurationByKey(form.getCid()[i]);
							String cname = config.getCname();
							e.setEirdesc("由配置项："+cname+"建立");
							//增加key
							e.setEirinfo(entityItem.getEiid()+"_"+configItem.getCiid()+"_"+ei.getEiid());
							//设置状态为C，关系管理中不可删除
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
						//删除原来已有的关系
						SOC0119SearchCondImpl eircond = new SOC0119SearchCondImpl();
						eircond.setEirinfo(entityItem.getEiid()+"_"+form.getCiid()[i]+"_");
						eircond.setEirstatus("C");
						eircond.setDeleteflag("0");
						List<SOC0119Info> eir = this.soc0119BL.searchMaxEntityItemRelation(eircond);
						for (SOC0119Info entityItemRelation : eir) {
							this.soc0119BL.deleteEntityItemRelation(entityItemRelation);
						}
					}
					log.debug("资产配置项：[资产配置ID:" + form.getCid()[i] + "]更新处理成功。");
				}
				
				//上传文件检测
				//删除的文件不校验上传zyl
				if(form.getDelfile()[i]==null)
				if (form.getCiattach()[i].toUpperCase().equals("1")) {
					FormFile file = form.getAttachFile(i);
					if ( file != null && file.getFileSize() > 0) {
						//上传文件存在的情况
						//上传文件路径
						String rootPath = ResourceUtility.getString("UPLOAD_FILE_ROOT_PATH");
						StringBuffer pathBuf = new StringBuffer();
						
						//根目录
						pathBuf.append(rootPath);
						//机能ID
						pathBuf.append("asm"+File.separator);
						//专项预案资产ID
						pathBuf.append(configItem.getEiid());
						pathBuf.append(File.separator);
						
						StringBuffer fileName = new StringBuffer();
						
						//扩展名取得
						String fileType = "";
						String sFileName = file.getFileName();
						int point = sFileName.lastIndexOf(".");
						if (point != -1) {
							fileType = sFileName.substring(point);
							fileName.append(sFileName.substring(0, point));
						}
						
						//文件名后加版本号
						fileName.append("_");
						fileName.append(configItem.getCiversion());
						//文件扩展名
						fileName.append(fileType);

						//文件上传处理
						this.fileUploadBL.saveFile(file, pathBuf.toString(), fileName.toString());
						
						//上传文件名保存
						configItem.setCivalue(fileName.toString());
						
						//更新属性标识
						configItem.setCicurver("1");
						
						this.soc0107BL.updateSOC0107(configItem);					
						
					}
				}
			}
			
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I005","专项预案维护"));
		
		log.debug("========专项预案资产配置信息编辑处理终了========");
		
		return dto;
	}
	
	

	/**
	 * 专项预案资产配置信息编辑画面初期化处理
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 */
	public IGDRM05DTO initIGDRM0504Action(IGDRM05DTO dto) throws BLException {

		log.debug("========专项预案资产配置信息编辑画面初期化处理开始========");
		
		IGDRM0504Form form = dto.getIgdrm0504Form();
		
		//专项预案资产信息检索
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				Integer.parseInt(form.getEiid()));
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","专项预案资产");
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
		//判断登陆用户是否有查看该资产配置信息的权限
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		
		//专项预案资产配置信息查询件数取得 
		int totalCount = this.soc0107BL.getConfigItemVWSearchCount(form);
		
		if (totalCount == 0) {
			log.debug("========专项预案资产配置信息查询数据不存在========");
			//专项预案资产配置信息查询数据不存在
//			dto.addMessage(new ActionMessage("IGCO10000.I007",0));
			return dto;
		}
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========专项预案资产配置信息查询数据件数过多========");
			//专项预案资产配置信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		//专项预案资产配置信息全件查询
		List<SOC0129Info> configItemVWInfoList = this.soc0107BL.searchConfigItemVW(
				form, 0, 0);
		
		String[] civalue = new String[totalCount];
		String[] delfile = new String[totalCount];
		String[] entityItemCivalue = new String[totalCount];
		String[] isUpgrade=new String[totalCount];
		//存放旧版本值
		String[] civalue_bak = new String[totalCount];
		Map<String,List<SOC0129Info>> map = new LinkedHashMap<String,List<SOC0129Info>>();
		int i = 0;
		int j = 0;
		List<String> strlist = new ArrayList<String>();
		Map<String, String> cldVersionMap=new HashMap<String, String>();//子资产版本集合
		for(SOC0129Info e : configItemVWInfoList){
			if("4".equals(e.getCattach())){
				String value = e.getCivalue();
				if(StringUtils.isNotEmpty(value)){
					Integer cldeiid = Integer.parseInt(value.substring(value.lastIndexOf("(")+1, value.length()-1));//子资产eiid
					
					SOC0119SearchCondImpl cond=new SOC0119SearchCondImpl();
					cond.setPareiid(Integer.parseInt(form.getEiid()));
					cond.setCldeiid(cldeiid);
					cond.setParversion(entityItemVWInfo.getEiversion());
					cond.setEirinfo("_"+e.getCiid()+"_");
					cond.setDeleteflag("0");
					List<SOC0119Info> ig313Info = soc0119BL.searchEntityItemRelation(cond);
					String cldversion="";
					if(ig313Info!=null&&ig313Info.size()>0){
						cldversion = String.valueOf(ig313Info.get(0).getCldversion());//子资产版本
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
				//显示是资产名称，实际存值是资产名称(资产ID)
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

		//场景资产 查询 关联应急资源资产 专用
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
		log.debug("========专项预案资产配置信息编辑画面初期化处理终了========");
		return dto;
	}
	/**
	 * 专项预案配置信息历史记录画面初期化处理
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 */
	public IGDRM05DTO initIGDRM0503Action(IGDRM05DTO dto) throws BLException {
		log.debug("========专项预案配置信息历史记录画面初期化处理开始========");
		
		//专项预案信息检索
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				dto.getIgdrm0503Form().getEiid());
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","专项预案");
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
		//获取历史版本更新时间
		dto.setConfigItemVersionTime(this.soc0118BL.searchVersionUpdateTime(dto.getIgdrm0503Form().getEiid()));
		
		//判断登陆用户是否有查看该资产配置信息的权限
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		
		log.debug("========专项预案配置信息历史记录画面初期化处理终了========");
		return dto;
	}
	/**
	 * 配置信息历史记录画面初期化处理
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 */
	public IGDRM05DTO ClickVersionShow(IGDRM05DTO dto) throws BLException{
		log.debug("========配置信息历史记录画面初期化处理开始========");

		// 信息检索
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(dto.getIgdrm0503Form().getEiid());

		if (entityItemVWInfo == null)
		{
			throw new BLException("IGCO10000.E004", "专项预案实例");
		}

		if (entityItemVWInfo.getEiversion() == 0 && entityItemVWInfo.getEismallversion() == 0) {
			dto.addMessage(new ActionMessage("IGASM0205.W001"));
		}

		if (StringUtils.isEmpty(dto.getIgdrm0503Form().getCiversion()+""))
		{
			dto.getIgdrm0503Form().setCiversion(String.valueOf(
					entityItemVWInfo.getEiversion()));
		}
		// 判断登陆用户是否有查看该资产配置信息的权限
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
		// 配置信息查询件数取得
		int totalCount = this.soc0107BL.getSOC0107SearchCount(soc0107Cond);

		if (totalCount == 0)
		{
			log.debug("========查询数据不存在========");
			// 查询数据不存在
//			dto.addMessage(new ActionMessage("IGCO10000.I007", 0));
			return dto;
		}

		// 配置信息全件检索

		List<SOC0107Info> configItemList = this.soc0107BL.searchSOC0107(soc0107Cond, 0, 0);
		Map<String, List<SOC0107Info>> map = new LinkedHashMap<String, List<SOC0107Info>>();
		
		Map<String, String> cldVersionMap=new HashMap<String, String>();//子资产版本集合
		boolean bool=false;
		for (SOC0107Info e : configItemList)
		{
			if("4".equals(e.getConfiguration().getCattach())){
				String civalue = e.getCivalue();
				if(StringUtils.isNotEmpty(civalue)){
					int cldeiid = Integer.parseInt(civalue.substring(civalue.lastIndexOf("(")+1, civalue.length()-1));//子资产eiid
					
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
						cldversion = String.valueOf(soc0119Info.get(0).getCldversion());//子资产版本
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
		log.debug("========配置信息历史记录画面初期化处理终了========");
		return dto;
		
	}
	/**
	 * 资产配置项信息版本比较画面初期化处理
	 * 
	 * @param dto
	 *            IGDRM05DTO
	 * @return IGDRM05DTO
	 * @throws BLException
	 */
	public IGDRM05DTO versionCompare(IGDRM05DTO dto) throws BLException
	{
		log.debug("========资产配置项信息版本比较画面初期化处理开始========");
	SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(Integer.parseInt(dto.getIgdrm05031Form().getEiid()));

	if (entityItemVWInfo == null)
	{
		throw new BLException("IGCO10000.E004", "专项预案");
	}

	if (entityItemVWInfo.getEiversion() == 0)
	{
		dto.addMessage(new ActionMessage("IGCOM0205.W001"));
	}

	dto.setEntityItemVW(entityItemVWInfo);

	// 判断登陆用户是否有查看该资产配置信息的权限
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

	// 专项预案配置信息查询件数取得
	int totalCount = this.soc0107BL.getSOC0107SearchCount(dto
			.getIgdrm05031Form());

	if (totalCount == 0)
	{
		log.debug("========查询数据不存在========");
		// 查询数据不存在
//		dto.addMessage(new ActionMessage("IGCO10000.I007", 0));
		return dto;
	}

	// 专项预案配置信息全件检索

	List<SOC0107Info> configItemList = this.soc0107BL.searchSOC0107(dto.getIgdrm05031Form(), 0, 0);
	dto.setEntityItemConfigurations(configItemList);

	dto.setFlag(flag);

	log.debug("========资产配置项信息版本比较画面初期化处理终了========");
	return dto;
}
	/**
	 * 专项预案关系管理画面初期化处理
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 */
	public IGDRM05DTO initIGDRM0506Action(IGDRM05DTO dto) throws BLException {
		log.debug("========专项预案关系管理画面初期化处理开始========");
		
		//专项预案信息检索
		SOC0124Info entityItemVWInfo = this.soc0118BL.searchEntityItemVWByKey(
				Integer.parseInt(dto.getIgdrm0506Form().getEiid()));
		
		if ( entityItemVWInfo == null ) {
			throw new BLException("IGCO10000.E004","专项预案");
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
		//正向关联关系检索
		SOC0119SearchCondImpl parcond = new SOC0119SearchCondImpl();
		if((dto.getIgdrm0506Form().getEiid())!=null)
		{parcond.setPareiid(Integer.parseInt(dto.getIgdrm0506Form().getEiid()));}
		parcond.setParversion(entityItemVWInfo.getEiversion());
		parcond.setParsmallversion(entityItemVWInfo.getEismallversion());
		parcond.setDeleteflag("0");
		//判断登陆用户是否有查看该资产配置信息的权限
		Boolean flag = this.soc0118BL.checkEntityItemDomain(dto.getUser(), entityItemVWInfo);

		if(!flag) {
			dto.addMessage(new ActionMessage("IGCO10000.E022"));
			dto.setFlag(flag);
			return dto;
		}else{
			dto.setFlag(flag);
		}
		//专项预案关系信息查询件数取得 
		int totalCount = this.soc0119BL.getEntityItemRelationSearchCount(parcond);
		
		if ( totalCount > dto.getMaxSearchCount() ) {
			log.debug("========专项预案关系信息查询数据件数过多========");
			//专项预案关系信息查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005",dto.getMaxSearchCount(),totalCount));
			return dto;
		}

		if ( totalCount>0 ) {
			//专项预案关系信息全件检索
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

		log.debug("========专项预案关系管理画面初期化处理终了========");
		return dto;
	}
	
	/**
	 * 专项预案关系删除处理
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 */
	public IGDRM05DTO deleteEntityItemRelationAction(IGDRM05DTO dto) throws BLException {
		log.debug("========专项预案关系删除处理开始========");
		
		for( int i=0;i<dto.getDeleteEntityItemRelation().length;i++ ){
			String eirid = dto.getDeleteEntityItemRelation()[i];
			
			SOC0119Info entityItemRelation = 
				this.soc0119BL.searchEntityItemRelationByKey(Integer.parseInt(eirid));
			
			if (entityItemRelation == null){
				throw new BLException("IGCO10000.E004","删除对象专项预案关系");
			}

			this.soc0119BL.deleteEntityItemRelation(entityItemRelation);
		}
		
		dto.addMessage(new ActionMessage("IGCO10000.I006","专项预案关系信息"));

		log.debug("========专项预案关系删除处理终了========");
		return dto;
	}

	/**
	 * 专项预案关系登记处理
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 */
	public IGDRM05DTO insertEntityItemRelationAction(IGDRM05DTO dto) throws BLException {
		log.debug("========专项预案关系登记处理开始========");
		
		IGDRM0507Form form = dto.getIgdrm0507Form();
		
		//专项预案ID（子）取得
		SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
		
		cond.setElabel(form.getElabel());
		cond.setEilabel(form.getEilabel());
		
		List<SOC0124Info> entityItemVWList = this.soc0118BL.searchEntityItemVW(cond, 0, 0);
		
		if ( entityItemVWList==null || entityItemVWList.size() == 0 ) {
			throw new BLException("IGCO10000.E004","(资产编号=" + form.getElabel() + ",专项预案编号=" 
					+ form.getEilabel() + ")专项预案");
		}
		
		form.setCldeiid(entityItemVWList.get(0).getEiid());
		form.setCldeid(entityItemVWList.get(0).getEid());
		form.setCldsmallversion(entityItemVWList.get(0).getEismallversion());
		form.setCldversion(entityItemVWList.get(0).getEiversion());
		
		//专项预案ID（父）和（子）检测
		if (form.getPareiid().intValue() == form.getCldeiid().intValue()) {
			//专项预案ID（父）= （子）
			throw new BLException(BLErrorType.ENTITY_ITEM_RELATION_ERROR,
					"IGCO10000.E012","专项预案");
		}
		
		//更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		//资产关系登记
		SOC0119Info ret = 
			this.soc0119BL.registEntityItemRelation(dto.getIgdrm0507Form());
		
		dto.setEntityItemRelation(ret);
		
		dto.addMessage(new ActionMessage( "IGCO10000.I004", "专项预案关系信息") );
		
		log.debug("========专项预案关系登记处理终了========");
		return dto;
	}
	
	/**
	 * 专项预案关系编辑画面初期化处理
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 */
	public IGDRM05DTO initIGDRM0507Action(IGDRM05DTO dto) throws BLException {
		log.debug("========专项预案关系编辑画面初期化处理开始========");
		
		IGDRM0507Form form = dto.getIgdrm0507Form();
		SOC0119TB ret = 		
			(SOC0119TB) this.soc0119BL.searchEntityItemRelationByKey(
				form.getEirid());
		
		if ( ret == null ){
			throw new BLException("IGCO10000.E004","编辑对象专项预案关系");
		}
		
		//检索结果设定
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
		
		log.debug("========专项预案关系编辑画面初期化处理终了========");
		return dto;
	}

	/**
	 * 专项预案关系变更处理处理
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 */
	public IGDRM05DTO updateEntityItemRelationAction(IGDRM05DTO dto) throws BLException {
		log.debug("========专项预案关系变更处理处理开始========");
		IGDRM0507Form form = dto.getIgdrm0507Form();

		//更新时间设定
		Date nowDateTime = new Date();
		String datetime = CommonDefineUtils.DATETIME_FORMAT.format(nowDateTime);

		form.setEirupdtime(datetime);
		
		this.soc0119BL.updateEntityItemRelation(form);

		dto.addMessage(new ActionMessage( "IGCO10000.I005", "专项预案关系信息") );

		log.debug("========专项预案关系变更处理处理终了========");
		return dto;
	}
	
	/**
	 *	获取专项预案关联关系处理
	 *
	 * @param dto IGDRM05DTO
	 * @return IGDRM05DTO
	 */
	public IGDRM05DTO searchRelationListAction(IGDRM05DTO dto) throws BLException {
		log.debug("========获取专项预案关联关系处理开始========");
		List<LabelValueBean> list = this.codeDetailBL.searchLabelValueBeanList(IGDRMCONSTANTS.ENTIY_CATEGORY_DOCUMENT,CodeDefine.getCodeDefine("PLAN_CONDITIONS_RELATION").getCcid());
		dto.setRelationList(list);
		log.debug("========获取专项预案关联关系处理终了========");
		return dto;
	}
	/**
	 * @return the 资产实例BL
	 */
	public SOC0118BL getSoc0118BL() {
		return soc0118BL;
	}
	/**
	 * @param soc0118bl the 资产实例BL to set
	 */
	public void setSoc0118BL(SOC0118BL soc0118bl) {
		soc0118BL = soc0118bl;
	}
	/**
	 * @return the 资产模型BL
	 */
	public SOC0117BL getSoc0117BL() {
		return soc0117BL;
	}
	/**
	 * @param soc0117bl the 资产模型BL to set
	 */
	public void setSoc0117BL(SOC0117BL soc0117bl) {
		soc0117BL = soc0117bl;
	}
	/**
	 * @return the 资产模型属性BL
	 */
	public SOC0109BL getSoc0109BL() {
		return soc0109BL;
	}
	/**
	 * @param soc0109bl the 资产模型属性BL to set
	 */
	public void setSoc0109BL(SOC0109BL soc0109bl) {
		soc0109BL = soc0109bl;
	}
	/**
	 * @return the 资产属性BL
	 */
	public SOC0107BL getSoc0107BL() {
		return soc0107BL;
	}
	/**
	 * @param soc0107bl the 资产属性BL to set
	 */
	public void setSoc0107BL(SOC0107BL soc0107bl) {
		soc0107BL = soc0107bl;
	}
	/**
	 * @return the 文件上传BL
	 */
	public FileUploadBL getFileUploadBL() {
		return fileUploadBL;
	}
	/**
	 * @param 文件上传BL the fileUploadBL to set
	 */
	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}
	/**
	 * @return the 机构BL
	 */
	public OrganizationBL getOrganizationBL() {
		return organizationBL;
	}
	/**
	 * @param 机构BL the organizationBL to set
	 */
	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}
	/**
	 * @return the 用户角色授权信息BL
	 */
	public UserRoleBL getUserRoleBL() {
		return userRoleBL;
	}
	/**
	 * @param 用户角色授权信息BL the userRoleBL to set
	 */
	public void setUserRoleBL(UserRoleBL userRoleBL) {
		this.userRoleBL = userRoleBL;
	}
	/**
	 * @return the 资产关系BL
	 */
	public SOC0119BL getSoc0119BL() {
		return soc0119BL;
	}
	/**
	 * @param soc0119bl the 资产关系BL to set
	 */
	public void setSoc0119BL(SOC0119BL soc0119bl) {
		soc0119BL = soc0119bl;
	}
	/**
	 * @return the 资产关系BL
	 */
	public SOC0151BL getSoc0151BL() {
		return soc0151BL;
	}
	/**
	 * @param soc0151bl the 资产关系BL to set
	 */
	public void setSoc0151BL(SOC0151BL soc0151bl) {
		soc0151BL = soc0151bl;
	}
	/**
	 * @return the 基础数据BL
	 */
	public CodeDetailBL getCodeDetailBL() {
		return codeDetailBL;
	}
	/**
	 * @param 基础数据BL the codeDetailBL to set
	 */
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}
	
	/**
	 * 查询流程的详细信息
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
		//节点list
		List<IG333Info> ig333List = ig333BL.searchIG333Info(ig333Cond);
		//结果集List
		Map<String,FlowDetail> flowDetailMap = new HashMap<String,FlowDetail>();
		//存放子节点的List
		Map<String,Map<String,FlowDetail>> childFlowDetailMap = new HashMap<String,Map<String,FlowDetail>>();
		if(ig333List!=null && ig333List.size()>0){
			for(IG333Info ig333Info:ig333List){
				FlowDetail flowDetail = new FlowDetail();
				//存储节点
				flowDetail.setIg333Info(ig333Info);
				ig560Cond.setPsdid(ig333Info.getPsdid());
				//查询560中的数据并添加到flowDetail中
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
					//存储应急资源
					flowDetail.setSoc0118List(soc0118List);
				}
				//查询参与人并存储
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
				//判断是否为子节点
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
		
		//对父节点流程排序
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
		//遍历childFlowDetailMap将子节点放到父节点的List中
		for(String ppsdid:childFlowDetailMap.keySet()){
			Map<String,String> childStepMap = computingTime.getOrderStep(dto.getPdid(), ppsdid);
			Map<String,FlowDetail> childFlowMap = childFlowDetailMap.get(ppsdid);
			List<FlowDetail> childList = new ArrayList<FlowDetail>();
			for(String psdid:childStepMap.keySet()){
				childList.add(childFlowMap.get(psdid));
			}
			for(FlowDetail parentStep:parentStepList){
				if(parentStep.getIg333Info().getPsdid().equals(ppsdid)){
					//给子流程节点编号
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
		
		//遍历拼接界面显示
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
		
		
		//第一行
		outPrintStr.append("<tr>");
			outPrintStr.append("<td width='4%' rowspan='3' style='text-align:center'>"+flowDetail.getSequence()+"</td>");
			outPrintStr.append("<td width='10%'>节点名称：</td>");
			outPrintStr.append("<td width='38%' style='text-align:left;'>"+flowDetail.getIg333Info().getPsdname()+"</td>");
			outPrintStr.append("<td width='10%'>状态说明：</td>");
			outPrintStr.append("<td width='38%' style='text-align:left;'>"+flowDetail.getIg333Info().getPsddesc()+"</td>");
		outPrintStr.append("</tr>");
		//第二行
		outPrintStr.append("<tr>");
			outPrintStr.append("<td width='10%'>预计恢复时间：</td>");
			outPrintStr.append("<td width='38%' style='text-align:left;'>"+flowDetail.getIg333Info().getBysequence()+"</td>");
			outPrintStr.append("<td width='10%'>任务描述：</td>");
			if(flowDetail.getDuty()!=null){
				outPrintStr.append("<td td width='38%' style='text-align:left;'>"+flowDetail.getDuty()+"</td>");	
			}else{
				outPrintStr.append("<td td width='38%'></td>");
			}
		outPrintStr.append("</tr>");
		//第三行
		outPrintStr.append("<tr>");
			outPrintStr.append("<td width='10%'>应急资源：</td>");
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
			
			outPrintStr.append("<td width='10%'>参与人：</td>");
			outPrintStr.append("<td width='38%' style='text-align:left;'>");
			
			if(flowDetail.getUserMap()!=null && flowDetail.getUserMap().size()>0){
				int index =0;
				for(String key:flowDetail.getUserMap().keySet()){
					 index++;
					 if(index<flowDetail.getUserMap().size()){
						 outPrintStr.append(flowDetail.getUserMap().get(key).getUsername()+"、");
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
