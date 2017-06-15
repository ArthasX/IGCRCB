/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * Title : InfoGovernor ��Ϣ�������ƽ̨
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

	/** ��ѵ�ƻ�BL */
	private TrainplanBL trainplanBL;
	
	/** ��ѵ����BL */
	private TrainmissionBL trainmissionBL; 

	/**
	 * ��ѵ�ƻ�BLȡ��
	 * 
	 * @param trainplanBL
	 */
	public TrainplanBL getTrainplanBL() {
		return trainplanBL;
	}
	
	/**
	 * ��ѵ�ƻ�BL�趨
	 * 
	 * @param trainplanBL
	 */
	public void setTrainplanBL(TrainplanBL trainplanBL) {
		this.trainplanBL = trainplanBL;
	}
	
	/**
	 * ��ѵ����BLȡ��
	 * 
	 * @param trainmissionBL
	 */
	public TrainmissionBL getTrainmissionBL() {
		return trainmissionBL;
	}
	
	/**
	 * ��ѵ����BL�趨
	 * 
	 * @param trainmissionBL
	 */
	public void setTrainmissionBL(TrainmissionBL trainmissionBL) {
		this.trainmissionBL = trainmissionBL;
	}
	

	/**
     * @Description: ��ѯ��ѵ�ƻ���������
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM15DTO    
     * @throws
     */
	public IGDRM15DTO searchTrainplanList(IGDRM15DTO dto) {
		
		log.debug("==============��ѵ�ƻ���ѯ��ʼ=====================");
		//ȡ��form

		//ȡ�ò�ѯ����
		TrainplanSearchCondImpl cond = new TrainplanSearchCondImpl();
		this.copyProperties(cond, dto.getIgdrm1501Form());
		//��ȡ��ҳbean
		PagingDTO pDto = dto.getPagingDto();
		//ȡ������
		int totalCount=trainplanBL.getSearchCount(cond);
		//��֤��ѯ�������Ƿ���������s
		if (totalCount == 0) {
			log.debug("========��ѯ���ݲ�����========");
			// ��ѯ���ݲ�����
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}
		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========��ѯ���ݼ�������========");
			// ��ѯ���ݼ�������
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto.getMaxSearchCount(), totalCount));
			return dto;
		}
		//��֤��ѯ�������Ƿ���������
		pDto.setTotalCount(totalCount);
		dto.setTrainplanInfoList( trainplanBL.searchTrainplan(cond,pDto.getFromCount(),pDto.getPageDispCount()));
		log.debug("==============��ѵ�ƻ���ѯ����=====================");	
		return dto;
	}
	
	/**
     * @Description: ɾ����ѵ�ƻ�һ������
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM15DTO    
     * @throws
     */
	public IGDRM15DTO deleteTrainplanAction(IGDRM15DTO dto) throws BLException {
        log.debug("============��ѵ�ƻ�ɾ����ʼ=============");
		TrainplanInfo info=trainplanBL.searchTrainplanByPK(dto.getIgdrm1501Form().getTpid());
		if(info!=null){
			trainplanBL.deleteTrainplanByPK(dto.getIgdrm1501Form().getTpid());
		}else{
			dto.addMessage(new ActionMessage("IGDRM1501.E002"));
		}
		log.debug("============��ѵ�ƻ�ɾ������=============");
		return dto;
	}
	
	/**
	 * ��ѵ�ƻ�����ɾ������
	 *
	 * @param dto IGDRM15DTO
	 * @return IGDRM15DTO
	 */
	public IGDRM15DTO deleteEntityItemAction(IGDRM15DTO dto) throws BLException {
		log.debug("===========��ѵ�ƻ�ɾ��������ʼ============");
		if(dto.getDeleteEntityItem() != null){
			for(int i=0;i<dto.getDeleteEntityItem().length;i++ ) {
				trainplanBL.deleteTrainplanByPK(Integer.valueOf(dto.getDeleteEntityItem()[i]));
			}
		}
		dto.addMessage(new ActionMessage("IGCO10000.I006", "��ѵ�ƻ�"));
		log.debug("===========��ѵ�ƻ�ɾ����������============");
		return dto;
	}
	
	/**
     * @Description: �����ѵ�ƻ�һ������
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM15DTO    
     * @throws
     *//*
	public IGDRM15DTO insertTrainplanAction(IGDRM15DTO dto) throws BLException {
		log.debug("=============��ѵ�ƻ�������ʼ=============");
		//ȡ��form
		IGDRM1501Form form = dto.getIgdrm1501Form();
		//������ѵ�ƻ�ʵ�帳ֵ
		TrainplanTB entity= new TrainplanTB();
		entity.setTpname(form.getTpname());
		entity.setTpuserid(form.getTpuserid());
		entity.setTpusername(form.getTpusername());
		entity.setTptime(form.getTptime());
        entity.setTporgid(form.getTporgid());
		entity.setTporgname(form.getTporgname());
		entity.setTpstatus(form.getTpstatus());
		trainplanBL.registTrainplan(entity);
		log.debug("============��ѵ�ƻ���������=============");
		return dto;
	}
	
	*//**
     * @Description:  ͨ��������ѯ��ѵ�ƻ�һ�����ݳ�ʼ��
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM15DTO    
     * @throws
     */
	public IGDRM15DTO updateTrainPlanMission(IGDRM15DTO dto) throws BLException {
		log.debug("============ȡ����ѵ�ƻ�һ�����ݿ�ʼ=============");
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
	
	     //ȡform����
	    //��ѵ�γ�
   	    String[] tmcourse=form.getTmcourse();
   	    //��ѵ����
   	    String[] tmorg= form.getTmorg();
   	    //��ѵʱ��
   	    String[] tmtime = form.getTmtime();
   	    //��ѵ����
   	    String[] tmtarget = form.getTmtarget();
	   	    
   	    // ������ 
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
			// ��ѵ�ƻ��ӱ�
			TrainmissionTB tb=new TrainmissionTB();
		    tb.setTpid(form.getUpTpid());
		    tb.setTmtarget(tmtarget[i]);
	        tb.setTmcourse(tmcourse[i]);
	        tb.setTmorg(tmorg[i]);
	        tb.setTmtime(tmtime[i]);
	        tb.setTmatt(fileFlag);//����KEY
	        trainmissionBL.registTrainmission(tb); 
		} 
   	    
	    //���map�ﻹ�����ݣ����ж�Ϊɾ����
	    if(map.size()>0){
	        for(java.util.Map.Entry<String, TrainmissionTB> entry:map.entrySet()){
	            trainmissionBL.deleteTrainmission(entry.getValue());
	        }
	    }
	    
	    // �����¼�ʵ�帳ֵ
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
		dto.addMessage(new ActionMessage("IGCO10000.I005","��ѵ�ƻ�"));
	    log.debug("===========��ѵ�ƻ��Ǽ�/�޸�/ɾ������===============");
		return dto;
	
	}
	
	/**
     * @Description: ������ѵ�ƻ�һ������
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM15DTO    
     * @throws
     *//*

	public IGDRM15DTO updateTrainplanAction(IGDRM15DTO dto) throws BLException {
		log.debug("============������ѵ�ƻ���ʼ=============");		
		IGDRM1603Form form =dto.getIgdrm1603Form();
		// �����¼�ʵ�帳ֵ
		TrainplanTB entity = new IGDRM15BLImpl();
		entity.setEventid(form.getUpEventid());
		entity.setEventname(form.getUpEventname());
		entity.setLabels(form.getUpLabels());
		entity.setEventdes(form.getUpEventdes());
		trainplanBL.updateEventss(entity);
		log.debug("============������ѵ�ƻ�����=============");
		return dto;
	}
	
	 *//**
     * @Description: ��ѵ�ƻ��Ǽ�/�޸�/ɾ��
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM06DTO    
     * @throws
     *//*
    public IGDRM15DTO editTrainmissionAction(IGDRM15DTO dto)throws BLException{
    	   log.debug("===========��ѵ�ƻ��Ǽ�/�޸�/ɾ����ʼ===============");
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
   	    //ȡform����
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
   	    //���map�ﻹ�����ݣ����ж�Ϊɾ����
   	    if(map.size()>0){
   	        for(Entry<String, TrainmissionTB> entry:map.entrySet()){
   	            trainmissionBL.deleteScopes(entry.getValue());
   	        }
   	    }
   	    log.debug("===========��ѵ�ƻ��Ǽ�/�޸�/ɾ������===============");
    	return dto;
    }
    
  
    *//**
     * @throws BLException 
     * @Description: ��ѯ��������
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM06DTO    
     * @throws
     *//*
    
    public IGDRM15DTO getList(IGDRM15DTO dto) throws BLException{
    	log.debug("==============�¼���ѯ��ʼ=====================");
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
		log.debug("==============�¼���ѯ����=====================");	
		return dto;
 
    }
*/
	/**
     * @Description: ��ѯ��ѵ�ƻ�һ������/��ѵ������������
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM15DTO    
     * @throws
     */
	 public IGDRM15DTO searchTrainPlanMissionAction(IGDRM15DTO dto) throws BLException{
		 log.debug("============ȡ����ѵ�ƻ�һ������/��ѵ�����������ݿ�ʼ=============");
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
			log.debug("============ȡ����ѵ�ƻ�һ������/��ѵ�����������ݽ���=============");
			return dto;
	 }

	public IGDRM15DTO insertTrainplanAction(IGDRM15DTO dto) throws BLException {
		return null;
	}
	
	
	/** ��������BL */
	protected FileUploadBL fileUploadBL;
	/**
	 * @param fileUploadBL the fileUploadBL to set
	 */
	public void setFileUploadBL(FileUploadBL fileUploadBL) {
		this.fileUploadBL = fileUploadBL;
	}
	
	
	/**
     * ������ѵ�ƻ�
     * @param dto IGSVC17DTO 
     * @return IGSVC17DTO 
     */
    public IGDRM15DTO createTrainingPlan(IGDRM15DTO dto) throws BLException {
    	IGDRM1512Form form=dto.getIgdrm1512Form();
	     
		//ȡform����
	    //��ѵ�γ�
   	    String[] tmcourse=form.getTmcourse();
   	    //��ѵ����
   	    String[] tmorg= form.getTmorg();
   	    //��ѵʱ��
   	    String[] tmtime = form.getTmtime();
   	    //��ѵ����
   	    String[] tmtarget = form.getTmtarget();
	   	    
   	    // �����¼�ʵ�帳ֵ
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
   	    // ������ 
		for (int i = 0; i < tmtarget.length; i++) {
			FormFile file = form.getFileListMap().get(i);
			String fileFlag = null;
			if(file != null && file.getFileSize() > 0){
				Map<Integer, FormFile> temp = new HashMap<Integer, FormFile>();
				temp.put(0, file);
				fileFlag = this.fileUploadBL.uploadFile(temp);
			}
			// ��ѵ�ƻ��ӱ�
			TrainmissionTB tb=new TrainmissionTB();
			tb.setTpid(info.getTpid());
			tb.setTmtarget(tmtarget[i]);
		    tb.setTmcourse(tmcourse[i]);
		    tb.setTmorg(tmorg[i]);
		    tb.setTmtime(tmtime[i]);
		    tb.setTmatt(fileFlag);//����KEY
		    trainmissionBL.registTrainmission(tb); 
		} 
   	    dto.addMessage(new ActionMessage("IGCO10000.I004","��ѵ�ƻ�"));
    	return dto;
    } 
}
