/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
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
 * 演练计划BL
 * 
 * @author 张剑
 *
 * 2015-2-12 上午11:07:19
 */
public class IGDRM06BLImpl extends BaseBLImpl implements IGDRM06BL {
	
	static Log log = LogFactory.getLog(IGDRM06BLImpl.class);
	/**演练计划BL*/
	private DrillplanBL  drillplanBL; 
	/**演练计划详细信息BL*/
	private DrillplanitemBL  drillplanitemBL;
	
    public void setDrillplanBL(DrillplanBL drillplanBL) {
        this.drillplanBL = drillplanBL;
    }
    public void setDrillplanitemBL(DrillplanitemBL drillplanitemBL) {
        this.drillplanitemBL = drillplanitemBL;
    } 
	
    /**
     * @Description: 演练计划显示 
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
	 * @Description: 演练计划查询
	 * @param dto
	 * @return
	 * @throws BLException    
	 * IGDRM06DTO    
	 * @throws
	 */
	public IGDRM06DTO searchIGDRM0602Action(IGDRM06DTO dto)throws BLException{
	    log.info("===========演练计划查询处理开始===============");
	    IGDRM0602Form form = (IGDRM0602Form)dto.getForm();
	    DrillplanSearchCondImpl cond= new DrillplanSearchCondImpl();
	    this.copyProperties(cond, form);
	    // 查询记录总数
	    cond.setJudgestatus_ne("D");
        //int totalCount = this.drillplanBL.searchDrilledPlanByCond(cond, dto.getPagingDto().getFromCount(), dto.getPagingDto().getPageDispCount()).size();
        
        int totalCount = this.drillplanBL.getSearchCount(cond);
        if (totalCount == 0) {
            log.debug("========查询数据不存在========");
            // 查询数据不存在
            dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
            return dto;
        }
        if (totalCount > dto.getMaxSearchCount()) {
            log.debug("========查询数据件数过多========");
            // 查询数据件数过多
            dto.addMessage(new ActionMessage("IGCO00000.E005", dto
                    .getMaxSearchCount(), totalCount));
            return dto;
        }
        dto.getPagingDto().setTotalCount(totalCount);
        List<Map<String, Object>> searchDrillplanMap = this.drillplanBL.searchDrilledPlanByCond(cond, dto.getPagingDto().getFromCount(), dto.getPagingDto().getPageDispCount());
	    dto.setSearchDrillplanMap(searchDrillplanMap);
        log.info("===========演练计划查询处理结束===============");
	    return dto;
	}
	/**
	 * @Description: 演练计划送审
	 * @param dto
	 * @return
	 * @throws BLException    
	 * IGDRM06DTO    
	 * @throws
	 */
	public IGDRM06DTO drillplanToJudgeAction(IGDRM06DTO dto)throws BLException{
	    log.info("===========演练计划送审处理结束===============");
	    IGDRM0602Form form = (IGDRM0602Form)dto.getForm();
	    DrillplanInfo info=this.drillplanBL.searchDrillplanByPK(form.getDid());
	    if(info!=null){
	        DrillplanTB tb = (DrillplanTB)SerializationUtils.clone(info);
	        if("#".equals(tb.getJudgestatus())||"f".equals(tb.getJudgestatus())){
	            tb.setJudgestatus("a");//待审批状态
	            drillplanBL.updateDrillplan(tb);
	        }
	    }else{
	        throw new BLException("IGFLOW0000.E000","演练计划不存在！");
	    }
	    log.info("===========演练计划送审处理结束===============");
	    return dto;
	}
	/**
	 * @Description: 演练计划审批
	 * @param dto
	 * @return
	 * @throws BLException    
	 * IGDRM06DTO    
	 * @throws
	 */
	public IGDRM06DTO drillplanJudgeAction(IGDRM06DTO dto)throws BLException{
	    log.info("===========演练计划审批处理开始===============");
	    IGDRM0602Form form = (IGDRM0602Form)dto.getForm();
        DrillplanInfo info=this.drillplanBL.searchDrillplanByPK(form.getDid());
	    //是否审批通过 T/F
	    String status = dto.getJudgestatus();
	    //审批意见
	    String opinion = dto.getJudgeopinion();
	    if(info!=null){
            DrillplanTB tb = (DrillplanTB)SerializationUtils.clone(info);
            if("a".equals(tb.getJudgestatus())){
                tb.setJudgestatus(status.toLowerCase());//待审批状态
                tb.setDopinion(opinion);
                tb.setJudgeuserid(dto.getUser().getUserid());
                tb.setJudgeusername(dto.getUser().getUsername());
                tb.setJudgetime(IGStringUtils.getCurrentDate());
                drillplanBL.updateDrillplan(tb);
            }
        }else{
            throw new BLException("IGFLOW0000.E000","演练计划不存在！");
        }
	    log.info("===========演练计划审批处理结束===============");
	    return dto;
	}
	
	/**
	 * @Description: 演练计划登记
	 * @param dto
	 * @return
	 * @throws BLException    
	 * IGDRM06DTO    
	 * @throws
	 */
	public IGDRM06DTO insertDrillplanAction(IGDRM06DTO dto)throws BLException{
	    log.info("===============演练计划登记/修改开始===================");
	    
		// 演练计划登记/修改
		IGDRM0601Form form = (IGDRM0601Form) dto.getForm();
		User user = dto.getUser();
		DrillplanInfo returninfo = null;

		// 演练计划修改
		if (form.getDid() != null && 0 != form.getDid().intValue()) {
			DrillplanInfo info = drillplanBL.searchDrillplanByPK(form.getDid());
			DrillplanTB tb = (DrillplanTB) SerializationUtils.clone(info);
			tb.setDname(form.getDname());
			tb.setDepict(form.getDepict());
			returninfo = drillplanBL.updateDrillplan(tb);
		} else { // 演练计划登记
					// 编号
			String serialnumber = this.createSerial(dto);
			DrillplanTB tb = new DrillplanTB();
			this.copyProperties(tb, form);
			tb.setCrttime(IGStringUtils.getCurrentDate());
			tb.setDuserid(user.getUserid());
			tb.setDusername(user.getUsername());
			tb.setDserial(serialnumber);
			// 编辑状态
			tb.setJudgestatus("#");
			returninfo = this.drillplanBL.registDrillplan(tb);
		}

		// 获得已经存在的演练信息
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
	  	   
		// 演练信息登记/修改
		// 取form集合
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

		// 如果map里还有内容，则判断为删除的
		if (map.size() > 0) {
			for (Entry<String, DrillplanitemTB> entry : map.entrySet()) {
				drillplanitemBL.deleteDrillplanitem(entry.getValue());
			}
		}
	 	    
	    dto.setDrillplanInfo(returninfo);
	    log.info("===============演练计划登记/修改结束===================");
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
	 * @Description: 演练计划删除
	 * @param dto
	 * @return
	 * @throws BLException    
	 * IGDRM06DTO    
	 * @throws
	 */
	public IGDRM06DTO deleteDrillplanAction(IGDRM06DTO dto)throws BLException{
	    log.info("===========演练计划删除理开始===============");
        IGDRM0602Form form = (IGDRM0602Form)dto.getForm();
        DrillplanInfo info=this.drillplanBL.searchDrillplanByPK(form.getDid());
        if(info!=null){
        	// 由物理删除修改为逻辑删除，状态为"D"
//            drillplanBL.deleteDrillplan(info);
            DrillplanTB tb = (DrillplanTB) SerializationUtils.clone(info);
			tb.setJudgestatus("D");
			drillplanBL.updateDrillplan(tb);
        }
		dto.addMessage(new ActionMessage("IGCO10000.I006", "演练计划"));
        log.info("===========演练计划删除处理结束===============");
        return dto;
	}
	/**
	 * @Description: 演练计划条目初始化
	 * @param dto
	 * @return
	 * @throws BLException    
	 * IGDRM06DTO    
	 * @throws
	 */
	public IGDRM06DTO initDrillPlanItemAction(IGDRM06DTO dto)throws BLException{
	    log.info("===========演练计划条目初始化开始===============");
	    IGDRM0603Form form = (IGDRM0603Form)dto.getForm();
	    DrillplanitemSearchCondImpl cond= new DrillplanitemSearchCondImpl();
	    cond.setDid(form.getDid());
	    List<DrillplanitemInfo> list = drillplanitemBL.searchDrillplanitem(cond);
	    DrillplanInfo info= drillplanBL.searchDrillplanByPK(form.getDid());
	    dto.setDrillplanInfo(info);
	    dto.setDrillItemList(list);
	    log.info("===========演练计划条目初始化结束===============");
	    return dto;
	}
	
	/**
	 * @Description: 演练计划条登记/修改/删除
	 * @param dto
	 * @return
	 * @throws BLException    
	 * IGDRM06DTO    
	 * @throws
	 */
	public IGDRM06DTO editDrillPlanItemAction(IGDRM06DTO dto)throws BLException{
	    log.info("===========演练计划条目修改/登记开始===============");
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
	    //取form集合
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
	    //如果map里还有内容，则判断为删除的
	    if(map.size()>0){
	        for(Entry<String, DrillplanitemTB> entry:map.entrySet()){
	            drillplanitemBL.deleteDrillplanitem(entry.getValue());
	        }
	    }
	    log.info("===========演练计划条目修改/登记结束===============");
	    return dto;
	}
	
	/**
	 * @Description: 演练计划条目视图查询 （用于流程显示）
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
        log.info("===========演练计划查询处理开始===============");
        IGDRM0604Form form = (IGDRM0604Form)dto.getForm();
        DrillplanVWSearchCondImpl cond= new DrillplanVWSearchCondImpl();
        this.copyProperties(cond, form);
        // 查询记录总数
	    cond.setJudgestatus_ne("D");
        int totalCount = this.drillplanBL.getDrillPlanVWCount(cond);
        if (totalCount == 0) {
            log.debug("========查询数据不存在========");
            // 查询数据不存在
            dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
            return dto;
        }
        if (totalCount > dto.getMaxSearchCount()) {
            log.debug("========查询数据件数过多========");
            // 查询数据件数过多
            dto.addMessage(new ActionMessage("IGCO00000.E005", dto
                    .getMaxSearchCount(), totalCount));
            return dto;
        }
        dto.getPagingDto().setTotalCount(totalCount);
        List<DrillplanVWInfo> searchDrillplan = this.drillplanBL.getDrillPlanVW(cond, dto.getPagingDto().getFromCount(), dto.getPagingDto().getPageDispCount());
        dto.setDrillplanVWlist(searchDrillplan);
        log.info("===========演练计划查询处理结束===============");
        return dto;
    }

}
