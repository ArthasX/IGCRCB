/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.drm.bl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.drm.bl.task.DrillplanBL;
import com.deliverik.infogovernor.drm.bl.task.DrillplanitemBL;
import com.deliverik.infogovernor.drm.dto.IGDRM06DTO;
import com.deliverik.infogovernor.drm.form.IGDRM0601Form;
import com.deliverik.infogovernor.drm.form.IGDRM0602Form;
import com.deliverik.infogovernor.drm.form.IGDRM0603Form;
import com.deliverik.infogovernor.drm.form.IGDRM0604Form;
import com.deliverik.infogovernor.drm.model.DrillplanInfo;
import com.deliverik.infogovernor.drm.model.DrillplanVWInfo;
import com.deliverik.infogovernor.drm.model.DrillplanitemInfo;
import com.deliverik.infogovernor.drm.model.condition.DrillplanSearchCondImpl;
import com.deliverik.infogovernor.drm.model.condition.DrillplanVWSearchCondImpl;
import com.deliverik.infogovernor.drm.model.condition.DrillplanitemSearchCondImpl;
import com.deliverik.infogovernor.drm.model.entity.DrillplanTB;
import com.deliverik.infogovernor.drm.model.entity.DrillplanitemTB;
import com.deliverik.infogovernor.util.DateUtils;

/**
 * �����ƻ�BL
 * 
 * @author �Ž�
 *
 * 2015-2-12 ����11:07:19
 */
public class IGDRM06BLImpl extends BaseBLImpl implements IGDRM06BL {
	
	static Log log = LogFactory.getLog(IGDRM06BLImpl.class);
	/**�����ƻ�BL*/
	private DrillplanBL  drillplanBL; 
	/**�����ƻ���ϸ��ϢBL*/
	private DrillplanitemBL  drillplanitemBL;
	
    public void setDrillplanBL(DrillplanBL drillplanBL) {
        this.drillplanBL = drillplanBL;
    }
    public void setDrillplanitemBL(DrillplanitemBL drillplanitemBL) {
        this.drillplanitemBL = drillplanitemBL;
    } 
	
    /**
     * @Description: �����ƻ���ʾ 
     * @param dto
     * @return
     * @throws BLException    
     * IGDRM06DTO    
     * @throws
     */
	public IGDRM06DTO initIGDRM0601Action(IGDRM06DTO dto)throws BLException{
	    IGDRM0601Form form= (IGDRM0601Form)dto.getForm();
	    if(form.getDid()!=null&&0!=form.getDid().intValue()){
	        DrillplanInfo info=drillplanBL.searchDrillplanByPK(form.getDid());
	        this.copyProperties(form, info);
	        DrillplanitemSearchCondImpl cond= new DrillplanitemSearchCondImpl();
	        cond.setDid(form.getDid());
	        List<DrillplanitemInfo> list = drillplanitemBL.searchDrillplanitem(cond);
	        dto.setDrillItemList(list);
	    }
	    return dto;
	}
	/**
	 * @Description: �����ƻ���ѯ
	 * @param dto
	 * @return
	 * @throws BLException    
	 * IGDRM06DTO    
	 * @throws
	 */
	public IGDRM06DTO searchIGDRM0602Action(IGDRM06DTO dto)throws BLException{
	    log.info("===========�����ƻ���ѯ����ʼ===============");
	    IGDRM0602Form form = (IGDRM0602Form)dto.getForm();
	    DrillplanSearchCondImpl cond= new DrillplanSearchCondImpl();
	    this.copyProperties(cond, form);
	    // ��ѯ��¼����
	    cond.setJudgestatus_ne("D");
        //int totalCount = this.drillplanBL.searchDrilledPlanByCond(cond, dto.getPagingDto().getFromCount(), dto.getPagingDto().getPageDispCount()).size();
        
        int totalCount = this.drillplanBL.getSearchCount(cond);
        if (totalCount == 0) {
            log.debug("========��ѯ���ݲ�����========");
            // ��ѯ���ݲ�����
            dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
            return dto;
        }
        if (totalCount > dto.getMaxSearchCount()) {
            log.debug("========��ѯ���ݼ�������========");
            // ��ѯ���ݼ�������
            dto.addMessage(new ActionMessage("IGCO00000.E005", dto
                    .getMaxSearchCount(), totalCount));
            return dto;
        }
        dto.getPagingDto().setTotalCount(totalCount);
        List<Map<String, Object>> searchDrillplanMap = this.drillplanBL.searchDrilledPlanByCond(cond, dto.getPagingDto().getFromCount(), dto.getPagingDto().getPageDispCount());
	    dto.setSearchDrillplanMap(searchDrillplanMap);
        log.info("===========�����ƻ���ѯ�������===============");
	    return dto;
	}
	/**
	 * @Description: �����ƻ�����
	 * @param dto
	 * @return
	 * @throws BLException    
	 * IGDRM06DTO    
	 * @throws
	 */
	public IGDRM06DTO drillplanToJudgeAction(IGDRM06DTO dto)throws BLException{
	    log.info("===========�����ƻ����������===============");
	    IGDRM0602Form form = (IGDRM0602Form)dto.getForm();
	    DrillplanInfo info=this.drillplanBL.searchDrillplanByPK(form.getDid());
	    if(info!=null){
	        DrillplanTB tb = (DrillplanTB)SerializationUtils.clone(info);
	        if("#".equals(tb.getJudgestatus())||"f".equals(tb.getJudgestatus())){
	            tb.setJudgestatus("a");//������״̬
	            drillplanBL.updateDrillplan(tb);
	        }
	    }else{
	        throw new BLException("IGFLOW0000.E000","�����ƻ������ڣ�");
	    }
	    log.info("===========�����ƻ����������===============");
	    return dto;
	}
	/**
	 * @Description: �����ƻ�����
	 * @param dto
	 * @return
	 * @throws BLException    
	 * IGDRM06DTO    
	 * @throws
	 */
	public IGDRM06DTO drillplanJudgeAction(IGDRM06DTO dto)throws BLException{
	    log.info("===========�����ƻ���������ʼ===============");
	    IGDRM0602Form form = (IGDRM0602Form)dto.getForm();
        DrillplanInfo info=this.drillplanBL.searchDrillplanByPK(form.getDid());
	    //�Ƿ�����ͨ�� T/F
	    String status = dto.getJudgestatus();
	    //�������
	    String opinion = dto.getJudgeopinion();
	    if(info!=null){
            DrillplanTB tb = (DrillplanTB)SerializationUtils.clone(info);
            if("a".equals(tb.getJudgestatus())){
                tb.setJudgestatus(status.toLowerCase());//������״̬
                tb.setDopinion(opinion);
                tb.setJudgeuserid(dto.getUser().getUserid());
                tb.setJudgeusername(dto.getUser().getUsername());
                tb.setJudgetime(IGStringUtils.getCurrentDate());
                drillplanBL.updateDrillplan(tb);
            }
        }else{
            throw new BLException("IGFLOW0000.E000","�����ƻ������ڣ�");
        }
	    log.info("===========�����ƻ������������===============");
	    return dto;
	}
	
	/**
	 * @Description: �����ƻ��Ǽ�
	 * @param dto
	 * @return
	 * @throws BLException    
	 * IGDRM06DTO    
	 * @throws
	 */
	public IGDRM06DTO insertDrillplanAction(IGDRM06DTO dto)throws BLException{
	    log.info("===============�����ƻ��Ǽ�/�޸Ŀ�ʼ===================");
	    
		// �����ƻ��Ǽ�/�޸�
		IGDRM0601Form form = (IGDRM0601Form) dto.getForm();
		User user = dto.getUser();
		DrillplanInfo returninfo = null;

		// �����ƻ��޸�
		if (form.getDid() != null && 0 != form.getDid().intValue()) {
			DrillplanInfo info = drillplanBL.searchDrillplanByPK(form.getDid());
			DrillplanTB tb = (DrillplanTB) SerializationUtils.clone(info);
			tb.setDname(form.getDname());
			tb.setDepict(form.getDepict());
			returninfo = drillplanBL.updateDrillplan(tb);
		} else { // �����ƻ��Ǽ�
					// ���
			String serialnumber = this.createSerial(dto);
			DrillplanTB tb = new DrillplanTB();
			this.copyProperties(tb, form);
			tb.setCrttime(IGStringUtils.getCurrentDate());
			tb.setDuserid(user.getUserid());
			tb.setDusername(user.getUsername());
			tb.setDserial(serialnumber);
			// �༭״̬
			tb.setJudgestatus("#");
			returninfo = this.drillplanBL.registDrillplan(tb);
		}

		// ����Ѿ����ڵ�������Ϣ
		DrillplanitemSearchCondImpl cond = new DrillplanitemSearchCondImpl();
		cond.setDid(returninfo.getDid());
		List<DrillplanitemInfo> list = drillplanitemBL.searchDrillplanitem(cond);
		Map<String, DrillplanitemTB> map = new HashMap<String, DrillplanitemTB>();
		if (list != null && list.size() > 0) {
			for (DrillplanitemInfo info : list) {
				DrillplanitemTB tb = (DrillplanitemTB) SerializationUtils.clone(info);
				map.put(tb.getDiid().toString(), tb);
			}
		}
	  	   
		// ������Ϣ�Ǽ�/�޸�
		// ȡform����
		String[] expecttime = form.getExpecttime();
		String[] diid = form.getDiid();
		String[] dicontant = form.getDicontant();
		String[] didutyorg = form.getDidutyorg();
		String[] diname = form.getDiname();
		String[] partorg = form.getPartorg();
		for (int i = 0; i < diid.length - 1; i++) {
			DrillplanitemTB tb = null;
			if (map.containsKey(diid[i].toString())) {
				tb = map.get(diid[i].toString());
				map.remove(diid[i].toString());
			} else {
				tb = new DrillplanitemTB();
			}
			tb.setExpecttime(expecttime[i]);
			tb.setDicontant(dicontant[i]);
			tb.setDidutyorg(didutyorg[i]);
			tb.setDiname(diname[i]);
			tb.setPartorg(partorg[i]);
			tb.setDid(returninfo.getDid());
			drillplanitemBL.registDrillplanitem(tb);
		}

		// ���map�ﻹ�����ݣ����ж�Ϊɾ����
		if (map.size() > 0) {
			for (Entry<String, DrillplanitemTB> entry : map.entrySet()) {
				drillplanitemBL.deleteDrillplanitem(entry.getValue());
			}
		}
	 	    
	    dto.setDrillplanInfo(returninfo);
	    log.info("===============�����ƻ��Ǽ�/�޸Ľ���===================");
	    return dto;
	}
	/** 
     * @Title: createSerial 
     * @param dto
     * @return    
     * String    
     * @throws 
     */
    private String createSerial(IGDRM06DTO dto) {
    	String serial = "PTPL-"+DateUtils.getCurrentYear()+DateUtils.getCurrentMonth();
    	DrillplanSearchCondImpl cond = new DrillplanSearchCondImpl();
    	cond.setDserial(serial);
    	List<DrillplanInfo> list  = drillplanBL.searchDrillplan(cond);
    	if(list.size()>0){
    		return "PTPL-"+(Integer.valueOf(list.get(0).getDserial().substring(5))+1);
    	}else{
    		return serial+"01";
    	}
    }
    /**
	 * @Description: �����ƻ�ɾ��
	 * @param dto
	 * @return
	 * @throws BLException    
	 * IGDRM06DTO    
	 * @throws
	 */
	public IGDRM06DTO deleteDrillplanAction(IGDRM06DTO dto)throws BLException{
	    log.info("===========�����ƻ�ɾ����ʼ===============");
        IGDRM0602Form form = (IGDRM0602Form)dto.getForm();
        DrillplanInfo info=this.drillplanBL.searchDrillplanByPK(form.getDid());
        if(info!=null){
        	// ������ɾ���޸�Ϊ�߼�ɾ����״̬Ϊ"D"
//            drillplanBL.deleteDrillplan(info);
            DrillplanTB tb = (DrillplanTB) SerializationUtils.clone(info);
			tb.setJudgestatus("D");
			drillplanBL.updateDrillplan(tb);
        }
		dto.addMessage(new ActionMessage("IGCO10000.I006", "�����ƻ�"));
        log.info("===========�����ƻ�ɾ���������===============");
        return dto;
	}
	/**
	 * @Description: �����ƻ���Ŀ��ʼ��
	 * @param dto
	 * @return
	 * @throws BLException    
	 * IGDRM06DTO    
	 * @throws
	 */
	public IGDRM06DTO initDrillPlanItemAction(IGDRM06DTO dto)throws BLException{
	    log.info("===========�����ƻ���Ŀ��ʼ����ʼ===============");
	    IGDRM0603Form form = (IGDRM0603Form)dto.getForm();
	    DrillplanitemSearchCondImpl cond= new DrillplanitemSearchCondImpl();
	    cond.setDid(form.getDid());
	    List<DrillplanitemInfo> list = drillplanitemBL.searchDrillplanitem(cond);
	    DrillplanInfo info= drillplanBL.searchDrillplanByPK(form.getDid());
	    dto.setDrillplanInfo(info);
	    dto.setDrillItemList(list);
	    log.info("===========�����ƻ���Ŀ��ʼ������===============");
	    return dto;
	}
	
	/**
	 * @Description: �����ƻ����Ǽ�/�޸�/ɾ��
	 * @param dto
	 * @return
	 * @throws BLException    
	 * IGDRM06DTO    
	 * @throws
	 */
	public IGDRM06DTO editDrillPlanItemAction(IGDRM06DTO dto)throws BLException{
	    log.info("===========�����ƻ���Ŀ�޸�/�Ǽǿ�ʼ===============");
	    IGDRM0603Form form = (IGDRM0603Form)dto.getForm();
	    DrillplanitemSearchCondImpl cond= new DrillplanitemSearchCondImpl();
	    cond.setDid(form.getDid());
	    List<DrillplanitemInfo> list = drillplanitemBL.searchDrillplanitem(cond);
	    Map<String,DrillplanitemTB> map = new HashMap<String, DrillplanitemTB>();
	    if(list!=null&&list.size()>0){
	        for(DrillplanitemInfo info:list){
	            DrillplanitemTB tb = (DrillplanitemTB)SerializationUtils.clone(info);
	            map.put(tb.getDiid().toString(), tb);
	        }
	    }
	    //ȡform����
	    String[] expecttime=form.getExpecttime();
	    String[] diid= form.getDiid();
	    String[] dicontant = form.getDicontant();
//	    String[] didestination = form.getDidestination();
	    String[] didutyorg = form.getDidutyorg();
	    String[] diname = form.getDiname();
//	    String[] discene = form.getDiscene();
//	    String[] discope = form.getDiscope();
	    String[] partorg= form.getPartorg();
	    for(int i=0;i<diid.length-1;i++){
	        DrillplanitemTB tb=null;
	        if(map.containsKey(diid[i].toString())){
	            tb=map.get(diid[i].toString());
	            map.remove(diid[i].toString());
	        }else{
	            tb=new DrillplanitemTB();
	        }
	        tb.setExpecttime(expecttime[i]);
            tb.setDicontant(dicontant[i]);
//            tb.setDidestination(didestination[i]);
            tb.setDidutyorg(didutyorg[i]);
            tb.setDiname(diname[i]);
//            tb.setDiscene(discene[i]);
            tb.setPartorg(partorg[i]);
            tb.setDid(form.getDid());
//            tb.setDiscope(discope[i]);
            //saveorupdate
            drillplanitemBL.registDrillplanitem(tb);
	    }//end for
	    //���map�ﻹ�����ݣ����ж�Ϊɾ����
	    if(map.size()>0){
	        for(Entry<String, DrillplanitemTB> entry:map.entrySet()){
	            drillplanitemBL.deleteDrillplanitem(entry.getValue());
	        }
	    }
	    log.info("===========�����ƻ���Ŀ�޸�/�Ǽǽ���===============");
	    return dto;
	}
	
	/**
	 * @Description: �����ƻ���Ŀ��ͼ��ѯ ������������ʾ��
	 * @param dto
	 * @return
	 * @throws BLException    
	 * IGDRM06DTO    
	 * @throws
	 */
	public IGDRM06DTO searchDrillPlanItemVWAction(IGDRM06DTO dto)throws BLException{
	    return null;
	}
    /** 
     * @Title: searchDrillPlanVWAction 
     * @param dto
     * @return    
     * IGDRM06DTO    
     * @throws 
     */
    public IGDRM06DTO searchDrillPlanVWAction(IGDRM06DTO dto)throws BLException{
        log.info("===========�����ƻ���ѯ����ʼ===============");
        IGDRM0604Form form = (IGDRM0604Form)dto.getForm();
        DrillplanVWSearchCondImpl cond= new DrillplanVWSearchCondImpl();
        this.copyProperties(cond, form);
        // ��ѯ��¼����
	    cond.setJudgestatus_ne("D");
        int totalCount = this.drillplanBL.getDrillPlanVWCount(cond);
        if (totalCount == 0) {
            log.debug("========��ѯ���ݲ�����========");
            // ��ѯ���ݲ�����
            dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
            return dto;
        }
        if (totalCount > dto.getMaxSearchCount()) {
            log.debug("========��ѯ���ݼ�������========");
            // ��ѯ���ݼ�������
            dto.addMessage(new ActionMessage("IGCO00000.E005", dto
                    .getMaxSearchCount(), totalCount));
            return dto;
        }
        dto.getPagingDto().setTotalCount(totalCount);
        List<DrillplanVWInfo> searchDrillplan = this.drillplanBL.getDrillPlanVW(cond, dto.getPagingDto().getFromCount(), dto.getPagingDto().getPageDispCount());
        dto.setDrillplanVWlist(searchDrillplan);
        log.info("===========�����ƻ���ѯ�������===============");
        return dto;
    }

}
