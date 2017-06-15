/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.drm.bl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.upload.FormFile;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.FileUploadBL;
import com.deliverik.infogovernor.drm.bl.task.TrainmissionBL;
import com.deliverik.infogovernor.drm.bl.task.TrainplanBL;
import com.deliverik.infogovernor.drm.dto.IGDRM15DTO;
import com.deliverik.infogovernor.drm.form.IGDRM1501Form;
import com.deliverik.infogovernor.drm.form.IGDRM1512Form;
import com.deliverik.infogovernor.drm.model.TrainmissionInfo;
import com.deliverik.infogovernor.drm.model.TrainplanInfo;
import com.deliverik.infogovernor.drm.model.condition.TrainmissionSearchCondImpl;
import com.deliverik.infogovernor.drm.model.condition.TrainplanSearchCondImpl;
import com.deliverik.infogovernor.drm.model.entity.TrainmissionTB;
import com.deliverik.infogovernor.drm.model.entity.TrainplanTB;



/**
 * <p>
 * Title : InfoGovernor 信息服务管理平台
 * </p>
 * <p>
 * Description:
 * </p>
 * 
 * @author zhangying@deliverik.com
 * @version 1.0
 */
public class IGDRM15BLImpl extends BaseBLImpl implements IGDRM15BL {

	static Log log = LogFactory.getLog(IGDRM15BLImpl.class);

	/** 培训计划BL */
	private TrainplanBL trainplanBL;
	
	/** 培训任务BL */
	private TrainmissionBL trainmissionBL; 

	/**
	 * 培训计划BL取得
	 * 
	 * @param trainplanBL
	 */
	public TrainplanBL getTrainplanBL() {
		return trainplanBL;
	}
	
	/**
	 * 培训计划BL设定
	 * 
	 * @param trainplanBL
	 */
	public void setTrainplanBL(TrainplanBL trainplanBL) {
		this.trainplanBL = trainplanBL;
	}
	
	/**
	 * 培训任务BL取得
	 * 
	 * @param trainmissionBL
	 */
	public TrainmissionBL getTrainmissionBL() {
		return trainmissionBL;
	}
	
	/**
	 * 培训任务BL设定
	 * 
	 * @param trainmissionBL
	 */
	public void setTrainmissionBL(TrainmissionBL trainmissionBL) {
		this.trainmissionBL = trainmissionBL;
	}
	

	/**
     * @Description: 查询培训计划所有数据
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM15DTO    
     * @throws
     */
	public IGDRM15DTO searchTrainplanList(IGDRM15DTO dto) {
		
		log.debug("==============培训计划查询开始=====================");
		//取得form

		//取得查询条件
		TrainplanSearchCondImpl cond = new TrainplanSearchCondImpl();
		this.copyProperties(cond, dto.getIgdrm1501Form());
		//获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		//取得总数
		int totalCount=trainplanBL.getSearchCount(cond);
		//验证查询的数量是否满足条件s
		if (totalCount == 0) {
			log.debug("========查询数据不存在========");
			// 查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========查询数据件数过多========");
			// 查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		//验证查询的数量是否满足条件
		pDto.setTotalCount(totalCount);
		dto.setTrainplanInfoList( trainplanBL.searchTrainplan(cond,pDto.getFromCount(),pDto.getPageDispCount()));
		log.debug("==============培训计划查询结束=====================");	
		return dto;
	}
	
	/**
     * @Description: 删除培训计划一条数据
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM15DTO    
     * @throws
     */
	public IGDRM15DTO deleteTrainplanAction(IGDRM15DTO dto) throws BLException {
        log.debug("============培训计划删除开始=============");
		TrainplanInfo info=trainplanBL.searchTrainplanByPK(dto.getIgdrm1501Form().getTpid());
		if(info!=null){
			trainplanBL.deleteTrainplanByPK(dto.getIgdrm1501Form().getTpid());
		}else{
			dto.addMessage(new ActionMessage("IGDRM1501.E002"));
		}
		log.debug("============培训计划删除结束=============");
		return dto;
	}
	
	/**
	 * 培训计划批量删除处理
	 *
	 * @param dto IGDRM15DTO
	 * @return IGDRM15DTO
	 */
	public IGDRM15DTO deleteEntityItemAction(IGDRM15DTO dto) throws BLException {
		log.debug("===========培训计划删除操作开始============");
		if(dto.getDeleteEntityItem() != null){
			for(int i=0;i<dto.getDeleteEntityItem().length;i++ ) {
				trainplanBL.deleteTrainplanByPK(Integer.valueOf(dto.getDeleteEntityItem()[i]));
			}
		}
		dto.addMessage(new ActionMessage("IGCO10000.I006", "培训计划"));
		log.debug("===========培训计划删除操作结束============");
		return dto;
	}
	
	/**
     * @Description: 添加培训计划一条数据
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM15DTO    
     * @throws
     *//*
	public IGDRM15DTO insertTrainplanAction(IGDRM15DTO dto) throws BLException {
		log.debug("=============培训计划新增开始=============");
		//取得form
		IGDRM1501Form form = dto.getIgdrm1501Form();
		//创建培训计划实体赋值
		TrainplanTB entity= new TrainplanTB();
		entity.setTpname(form.getTpname());
		entity.setTpuserid(form.getTpuserid());
		entity.setTpusername(form.getTpusername());
		entity.setTptime(form.getTptime());
        entity.setTporgid(form.getTporgid());
		entity.setTporgname(form.getTporgname());
		entity.setTpstatus(form.getTpstatus());
		trainplanBL.registTrainplan(entity);
		log.debug("============培训计划新增结束=============");
		return dto;
	}
	
	*//**
     * @Description:  通过主键查询培训计划一条数据初始化
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM15DTO    
     * @throws
     */
	public IGDRM15DTO updateTrainPlanMission(IGDRM15DTO dto) throws BLException {
		log.debug("============取得培训计划一条数据开始=============");
		IGDRM1512Form form=dto.getIgdrm1512Form();
		//Integer tpid = (form==null?dto.getIgdrm1511Form().getTpid():form.getUpTpid());
		Integer tpid = form.getUpTpid();
		TrainmissionSearchCondImpl cond = new TrainmissionSearchCondImpl();
		//TrainplanInfo info=trainplanBL.searchTrainplanByPK(tpid);
		cond.setTpid(tpid);
		List<TrainmissionInfo> tmlist = trainmissionBL.searchTrainmission(cond);

		Map<String,TrainmissionTB> map = new HashMap<String, TrainmissionTB>();
	    if(tmlist!=null&&tmlist.size()>0){
	        for(TrainmissionInfo tminfo:tmlist){
	        	TrainmissionTB tb = (TrainmissionTB)SerializationUtils.clone(tminfo);
	            map.put(tb.getTmid().toString(), tb);
	        }
	    }
	
	     //取form集合
	    //培训课程
   	    String[] tmcourse=form.getTmcourse();
   	    //培训机构
   	    String[] tmorg= form.getTmorg();
   	    //培训时间
   	    String[] tmtime = form.getTmtime();
   	    //培训对象
   	    String[] tmtarget = form.getTmtarget();
	   	    
   	    // 处理附件 
		for (int i = 0; i < tmtarget.length; i++) {
			FormFile file = form.getFileListMap().get(i);
			String fileFlag = null;
			if(file != null && file.getFileSize() > 0){
				Map<Integer, FormFile> temp = new HashMap<Integer, FormFile>();
				temp.put(0, file);
				fileFlag = this.fileUploadBL.uploadFile(temp);
			}else{
				fileFlag = form.getAttkeys()[i];
			}
			// 培训计划从表
			TrainmissionTB tb=new TrainmissionTB();
		    tb.setTpid(form.getUpTpid());
		    tb.setTmtarget(tmtarget[i]);
	        tb.setTmcourse(tmcourse[i]);
	        tb.setTmorg(tmorg[i]);
	        tb.setTmtime(tmtime[i]);
	        tb.setTmatt(fileFlag);//附件KEY
	        trainmissionBL.registTrainmission(tb); 
		} 
   	    
	    //如果map里还有内容，则判断为删除的
	    if(map.size()>0){
	        for(java.util.Map.Entry<String, TrainmissionTB> entry:map.entrySet()){
	            trainmissionBL.deleteTrainmission(entry.getValue());
	        }
	    }
	    
	    // 创建事件实体赋值
	    TrainplanTB entity = new TrainplanTB();
		entity.setTpid(form.getUpTpid());
		entity.setTpname(form.getUpTpname());
		entity.setTpuserid(form.getUpTpuserid());
		entity.setTpusername(form.getUpTpusername());
		entity.setTporgname(form.getUpTporgname());
		entity.setPtorgid(form.getUpTporgid());
		entity.setTpstatus(form.getUpTstatus());
		entity.setTptime(form.getUpTptime());
		trainplanBL.updateTrainplan(entity);
		dto.addMessage(new ActionMessage("IGCO10000.I005","培训计划"));
	    log.debug("===========培训计划登记/修改/删除结束===============");
		return dto;
	
	}
	
	/**
     * @Description: 更新培训计划一条数据
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM15DTO    
     * @throws
     *//*

	public IGDRM15DTO updateTrainplanAction(IGDRM15DTO dto) throws BLException {
		log.debug("============更新培训计划开始=============");		
		IGDRM1603Form form =dto.getIgdrm1603Form();
		// 创建事件实体赋值
		TrainplanTB entity = new IGDRM15BLImpl();
		entity.setEventid(form.getUpEventid());
		entity.setEventname(form.getUpEventname());
		entity.setLabels(form.getUpLabels());
		entity.setEventdes(form.getUpEventdes());
		trainplanBL.updateEventss(entity);
		log.debug("============更新培训计划结束=============");
		return dto;
	}
	
	 *//**
     * @Description: 培训计划登记/修改/删除
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM06DTO    
     * @throws
     *//*
    public IGDRM15DTO editTrainmissionAction(IGDRM15DTO dto)throws BLException{
    	   log.debug("===========培训计划登记/修改/删除开始===============");
   	    IGDRM1604Form form = dto.getIgdrm1604Form();
   	    ScopesSearchCondImpl cond= new ScopesSearchCondImpl();
   	    cond.setEventid(form.getUpEventid());
	    List<TrainmissionInfo> list = trainmissionBL.searchScopes(cond);
	    Map<String,TrainmissionTB> map = new HashMap<String, TrainmissionTB>();
	    if(list!=null&&list.size()>0){
	        for(TrainmissionInfo info:list){
	        	TrainmissionTB tb = (TrainmissionTB)SerializationUtils.clone(info);
	            map.put(tb.getScopeid().toString(), tb);
	        }
	    }
   	    //取form集合
   	    String[] impscope=form.getImpscope();
   	    String[] impbus= form.getImpbus();
   	    String[] imptime = form.getImptime();
   	    for(int i=0;i<impscope.length-1;i++){
   	       TrainmissionTB tb=new TrainmissionTB();
   	      tb.setImpscope(impscope[i]);
   	      tb.setImpbus(impbus[i]);
   	      tb.setImptime(imptime[i]);
   	      tb.setEventid(form.getUpEventid());
   	      trainmissionBL.registScopes(tb);    
   	    }
   	    //如果map里还有内容，则判断为删除的
   	    if(map.size()>0){
   	        for(Entry<String, TrainmissionTB> entry:map.entrySet()){
   	            trainmissionBL.deleteScopes(entry.getValue());
   	        }
   	    }
   	    log.debug("===========培训计划登记/修改/删除结束===============");
    	return dto;
    }
    
  
    *//**
     * @throws BLException 
     * @Description: 查询所有数据
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM06DTO    
     * @throws
     *//*
    
    public IGDRM15DTO getList(IGDRM15DTO dto) throws BLException{
    	log.debug("==============事件查询开始=====================");
    	//IGDRM1604Form form = dto.getIgdrm1604Form();   	    	
    	List<TrainplanInfo> eList=trainplanBL.searchTrainplan();
    	Map<String,List<TrainmissionInfo>> eventssScopesMap = new HashMap<String, List<TrainmissionInfo>>();
    	 ScopesSearchCondImpl cond= new ScopesSearchCondImpl();
    	for(int i=0;i<eList.size();i++){  		
    		cond.setEventid(eList.get(i).getEventid());
    		List<TrainmissionInfo> TrainmissionInfoList = trainmissionBL.searchScopes(cond);
    		eventssScopesMap.put(eList.get(i).getEventname()+"_"+eList.get(i).getEventid()+"_"+eList.get(i).getEventdes(), TrainmissionInfoList);
    	}	
    	dto.setEventssScopesMap(eventssScopesMap);
		log.debug("==============事件查询结束=====================");	
		return dto;
 
    }
*/
	/**
     * @Description: 查询培训计划一条数据/培训任务所有数据
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM15DTO    
     * @throws
     */
	 public IGDRM15DTO searchTrainPlanMissionAction(IGDRM15DTO dto) throws BLException{
		 log.debug("============取得培训计划一条数据/培训任务所有数据开始=============");
			IGDRM1501Form form=dto.getIgdrm1501Form();
			Integer tpid = form.getTpid();
			TrainmissionSearchCondImpl cond = new TrainmissionSearchCondImpl();
			TrainplanInfo info=trainplanBL.searchTrainplanByPK(tpid);
			cond.setTpid(tpid);
			List<TrainmissionInfo> tiLst = trainmissionBL.searchTrainmission(cond);
			form.setResultList(this.trainmissionBL.getListByRid(form.getTpid().toString()));
			dto.setTrainmissionInfoList(tiLst);
			dto.setTrainplanInfo(info);
			dto.setResultList(form.getResultList());
			log.debug("============取得培训计划一条数据/培训任务所有数据结束=============");
			return dto;
	 }

	public IGDRM15DTO insertTrainplanAction(IGDRM15DTO dto) throws BLException {
		return null;
	}
	
	
	/** 附件操作BL */
	protected FileUploadBL fileUploadBL;
	/**
	 * @param fileUploadBL the fileUploadBL to set
	 */
	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}
	
	
	/**
     * 新增培训计划
     * @param dto IGSVC17DTO 
     * @return IGSVC17DTO 
     */
    public IGDRM15DTO createTrainingPlan(IGDRM15DTO dto) throws BLException {
    	IGDRM1512Form form=dto.getIgdrm1512Form();
	     
		//取form集合
	    //培训课程
   	    String[] tmcourse=form.getTmcourse();
   	    //培训机构
   	    String[] tmorg= form.getTmorg();
   	    //培训时间
   	    String[] tmtime = form.getTmtime();
   	    //培训对象
   	    String[] tmtarget = form.getTmtarget();
	   	    
   	    // 创建事件实体赋值
	    TrainplanTB entity = new TrainplanTB();
		entity.setTpname(form.getUpTpname());
		entity.setTpuserid(form.getUpTpuserid());
		entity.setTpusername(form.getUpTpusername());
		entity.setTporgname(form.getUpTporgname());
		entity.setPtorgid(form.getUpTporgid());
//		entity.setTpstatus(form.getUpTstatus());
		entity.setTptime(form.getUpTptime());
		TrainplanInfo info = trainplanBL.registTrainplan(entity);
		form.setUpTpid(info.getTpid());
   	    // 处理附件 
		for (int i = 0; i < tmtarget.length; i++) {
			FormFile file = form.getFileListMap().get(i);
			String fileFlag = null;
			if(file != null && file.getFileSize() > 0){
				Map<Integer, FormFile> temp = new HashMap<Integer, FormFile>();
				temp.put(0, file);
				fileFlag = this.fileUploadBL.uploadFile(temp);
			}
			// 培训计划从表
			TrainmissionTB tb=new TrainmissionTB();
			tb.setTpid(info.getTpid());
			tb.setTmtarget(tmtarget[i]);
		    tb.setTmcourse(tmcourse[i]);
		    tb.setTmorg(tmorg[i]);
		    tb.setTmtime(tmtime[i]);
		    tb.setTmatt(fileFlag);//附件KEY
		    trainmissionBL.registTrainmission(tb); 
		} 
   	    dto.addMessage(new ActionMessage("IGCO10000.I004","培训计划"));
    	return dto;
    } 
}
