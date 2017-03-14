/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.dut.bl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.struts.action.ActionMessage;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.bl.CodeDetailBL;
import com.deliverik.framework.model.CodeDetail;
import com.deliverik.framework.model.condition.CodeDetailSearchCondImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.infogovernor.dut.bl.task.DelayBL;
import com.deliverik.infogovernor.dut.bl.task.DutyPlanBL;
import com.deliverik.infogovernor.dut.bl.task.DutyResultBL;
import com.deliverik.infogovernor.dut.bl.task.OnDutyPersonRecordBL;
import com.deliverik.infogovernor.dut.dto.IGDUT03DTO;
import com.deliverik.infogovernor.dut.form.IGDUT0302Form;
import com.deliverik.infogovernor.dut.form.IGDUT0304Form;
import com.deliverik.infogovernor.dut.model.DelayInfo;
import com.deliverik.infogovernor.dut.model.DutyPlan;
import com.deliverik.infogovernor.dut.model.DutyResult;
import com.deliverik.infogovernor.dut.model.OnDutyPersonRecordInfo;
import com.deliverik.infogovernor.dut.model.condition.DelaySearchCondImpl;
import com.deliverik.infogovernor.dut.model.condition.DutyPlanSearchCondImpl;
import com.deliverik.infogovernor.dut.model.condition.DutyResultSearchCondImpl;
import com.deliverik.infogovernor.dut.model.entity.DutyResultTB;

/**
 * 值班情况汇总BL实现
 */
public class IGDUT03BLImpl extends BaseBLImpl implements IGDUT03BL {

	static Log log = LogFactory.getLog(IGDUT03BLImpl.class);

	/** 值班情况汇总BL */
	protected DutyResultBL dutyResultBL;

	/** 值班计划BL */
	protected DutyPlanBL dutyPlanBL;

	/** 维修表BL */
	protected OnDutyPersonRecordBL onDutyPersonRecordBL;

	/***/
	protected CodeDetailBL codeDetailBL;

	/** 延时解锁BL */
	protected DelayBL delayBL;

	/**
	 * 延时解锁BL设定
	 * 
	 * @param delayBL
	 */
	public void setDelayBL(DelayBL delayBL) {
		this.delayBL = delayBL;
	}

	/**
	 * 设定
	 * 
	 * @param codeDetailBL
	 */
	public void setCodeDetailBL(CodeDetailBL codeDetailBL) {
		this.codeDetailBL = codeDetailBL;
	}

	/**
	 * 值班情况汇总BL设定
	 * 
	 * @param dutyResultBL
	 *            值班情况汇总BL
	 */
	public void setDutyResultBL(DutyResultBL dutyResultBL) {
		this.dutyResultBL = dutyResultBL;
	}

	/**
	 * 值班检查计划BL设定
	 * 
	 * @param dutyPlanBL
	 *            值班检查计划BL
	 */
	public void setDutyPlanBL(DutyPlanBL dutyPlanBL) {
		this.dutyPlanBL = dutyPlanBL;
	}

	/**
	 * 值班情况汇总查询处理
	 * 
	 * @param dto
	 *            IGDUT03DTO
	 * @return IGDUT03DTO
	 */
	public IGDUT03DTO searchDutyResultAction(IGDUT03DTO dto) throws BLException {

		log.debug("========值班情况汇总查询处理开始========");

		// 值班情况汇总查询件数取得
		int totalCount = this.dutyResultBL.getSearchCount(dto
				.getDutyResultSearchCond());

		if (totalCount == 0) {
			log.debug("========值班情况汇总查询数据不存在========");
			// 值班情况汇总查询数据不存在
			dto.addMessage(new ActionMessage("IGCO10000.I002", 0));
			return dto;
		}

		if (totalCount > dto.getMaxSearchCount()) {
			log.debug("========值班情况汇总查询数据件数过多========");
			// 值班情况汇总查询数据件数过多
			dto.addMessage(new ActionMessage("IGCO00000.E005", dto
					.getMaxSearchCount(), totalCount));
			return dto;
		}

		// 分页用信息取得
		PagingDTO pDto = dto.getPagingDto();

		// 当前页信息取得
		List<DutyResult> dutyResultList = this.dutyResultBL.searchDutyResult(
				dto.getDutyResultSearchCond(), pDto.getFromCount(), pDto
						.getPageDispCount());

		pDto.setTotalCount(totalCount);

		dto.setDutyResultList(dutyResultList);

		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));

		log.debug("========值班情况汇总查询处理终了========");
		return dto;
	}

	/**
	 * 值班情况汇总查询处理
	 * 
	 * @param dto
	 *            IGDUT03DTO
	 * @return IGDUT03DTO
	 */
	public IGDUT03DTO searchAllDutyResultAction(IGDUT03DTO dto)
			throws BLException {

		log.debug("========值班情况汇总查询处理开始========");

		// 当前页信息取得
		List<DutyResult> dutyResultList = this.dutyResultBL.searchDutyResult(
				dto.getDutyResultSearchCond(), 0, 0);

		dto.setDutyResultList(dutyResultList);

		if (dutyResultList.size() > 0) {
			DutyPlanSearchCondImpl cond = new DutyPlanSearchCondImpl();
			cond.setDptime(dto.getDutyResultSearchCond().getDptime());
			List<DutyPlan> dpList = this.dutyPlanBL.searchDutyPlan(cond, 0, 0);
			for (DutyPlan dp : dpList) {
				if (IGDUTCONSTANTS.DAY_SHIFT.equals(dp.getDptype())) {
					dto.setDutyPlanAM(dp);
				} else if (IGDUTCONSTANTS.NIGHT_SHIFT.equals(dp.getDptype())) {
					dto.setDutyPlanPM(dp);
				}
			}
		}

		log.debug("========值班情况汇总查询处理终了========");
		return dto;
	}

	public IGDUT03DTO initIGDUT0301Action(IGDUT03DTO dto) throws BLException {
		int showYear = dto.getCalendarYear();
		int showMonth = dto.getCalendarMonth() + 1;
		Map<String, Integer> dutyResultMap = new HashMap<String, Integer>();
		String beginDate = showYear + "/" + appendZero(showMonth) + "/00";
		if (showMonth == 12) {
			showYear = showYear + 1;
			showMonth = 1;
		} else {
			showMonth++;
		}
		String endDate = showYear + "/" + appendZero(showMonth) + "/00";
		DutyResultSearchCondImpl dutyResultCond = new DutyResultSearchCondImpl();
		dutyResultCond.setDptime_ge(beginDate);
		dutyResultCond.setDptime_le(endDate);
		dutyResultCond.setDadcategory(dto.getDadcategory());
		List<DutyResult> dutyResultList = dutyResultBL.searchDutyResult(
				dutyResultCond, 0, 0);
		for (DutyResult dutyResult : dutyResultList) {
			String key = dutyResult.getDptime();
			String drcontent = dutyResult.getDrcontent();
			String drcretime = dutyResult.getDrcretime();
			// if(null == drcretime || (null != drcretime &&
			// dutyResult.getDrlimdtime().compareTo(drcretime)<0)){
			// dutyResultMap.put(key + "time", 1);
			// }
			if (null != drcretime
					&& dutyResult.getDrlimdtime().compareTo(drcretime) < 0) {
				dutyResultMap.put(key + "time", 1);
			} else if (("".equals(drcretime) || null == drcretime)
					&& dutyResult.getDrlimdtime().compareTo(
							IGStringUtils.getCurrentDateTime()) < 0) {
				dutyResultMap.put(key, 1); // 异常
			}
			if (dutyResultMap.containsKey(key) && dutyResultMap.get(key) == 1) {
				continue;
			}
			if (IGDUTCONSTANTS.DUTY_RESULT_NORMAL.equals(drcontent)) {
				dutyResultMap.put(key, 0);
			} else {
				dutyResultMap.put(key, 1); // 异常
			}
		}
		dto.setDutyResultMap(dutyResultMap);

		// 解锁
		Map<String, Integer> delayMap = new HashMap<String, Integer>();
		DelaySearchCondImpl delayCond = new DelaySearchCondImpl();
		delayCond.setDatetime_from(beginDate);
		delayCond.setDatetime_to(endDate);
		delayCond.setTitle_like(IGDUTCONSTANTS.DELAY_TITLE);
		List<DelayInfo> delayList = delayBL.searchDelay(delayCond);
		for (DelayInfo delayInfo : delayList) {
			String key = delayInfo.getDatetime().substring(0, 10);
			delayMap.put(key, 1);
		}
		dto.setDelayMap(delayMap);
		return dto;
	}

	private String appendZero(int arg) {
		if (arg < 10) {
			return "0" + arg;
		}
		return String.valueOf(arg);
	}

	/**
	 * 维修表BL设定
	 * 
	 * @param onDutyPersonRecordBL
	 *            维修表BL
	 */
	public void setOnDutyPersonRecordBL(
			OnDutyPersonRecordBL onDutyPersonRecordBL) {
		this.onDutyPersonRecordBL = onDutyPersonRecordBL;
	}

	/**
	 * 维修表添加&更新功能动作
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDUT03DTO registOnDutyPersonRecordAction(IGDUT03DTO dto)
			throws BLException {
		IGDUT0304Form form = dto.getIgDUT0304Form();
		// 判断是添加还是更新
		if (form.getOdprid() == null) {
			dto.addMessage(new ActionMessage("IGDUT0304.I001", "日常维护登记"));
		} else {
			dto.addMessage(new ActionMessage("IGDUT0304.I001", "日常维护更新"));
		}
		//设置进入区域变量
		String odprarea = "";
		//判断用户是否选中checkbox(进入区域)
		if (form.getOdprareas() != null) {
			String[] odprareas = form.getOdprareas();
			//遍历组合成string准备存入DB
			for (String odprareaTemp : odprareas) {
				odprarea = odprarea + odprareaTemp;
			}
		}
		//设置进入区域
		form.setOdprarea(odprarea);
		//保存|更新
		OnDutyPersonRecordInfo info = onDutyPersonRecordBL
				.registOnDutyPersonRecord(form);
		dto.setOnDutyPersonRecordInfo(info);
		return dto;
	}

	/**
	 * 维修表删除功能动作
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 * 
	 */
	public IGDUT03DTO deleteOnDutyPersonRecordAction(IGDUT03DTO dto)
			throws BLException {
		//临时主键定义
		Integer id=0;
		//判断用户是否选中checkbox(删除)
		if(dto.getIgDUT0305Form().getDelall()!=null){
			//checkbox(删除)取得
  			String[]arg_i=dto.getIgDUT0305Form().getDelall();
  			//遍历删除
  			for (int i = 0; i < arg_i.length; i++) {
  				
  				//主键赋值设定
          		id=Integer.parseInt(arg_i[i]);
          		dto.getIgDUT0305Form().setOdprid_eq(id);
          		//调用相应BL方法
          		onDutyPersonRecordBL.deleteOnDutyPersonRecordByPK(dto
          				.getOnDutyPersonRecordSearchCond().getOdprid_eq());
  			}
  			//置空主键查询条件
  			dto.getIgDUT0305Form().setOdprid_eq(null);
  			dto.addMessage(new ActionMessage("IGDUT0304.I001", "删除"));
		}
		return dto;

	}

	/**
	 * 维修表更新动作
	 * 
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGDUT03DTO updateOnDutyPersonRecordAction(IGDUT03DTO dto)
			throws BLException {
		//获得实例
		OnDutyPersonRecordInfo info = dto.getOnDutyPersonRecordInfo();
		
		//更新实例
		OnDutyPersonRecordInfo info_new = onDutyPersonRecordBL
				.updateOnDutyPersonRecord(info);
		//存入dto
		dto.setOnDutyPersonRecordInfo(info_new);
		return dto;
	}

	/**
	 * 维修表条件检索
	 * 
	 * @param dto
	 * @return IGDUT03DTO
	 * @throws BLException
	 */
	public IGDUT03DTO searchOnDutyPersonRecord(IGDUT03DTO dto)
			throws BLException {
		List<OnDutyPersonRecordInfo> list = onDutyPersonRecordBL
				.searchOnDutyPersonRecord(dto.getOnDutyPersonRecordSearchCond());
		dto.setOnDutyPersonRecordList(list);
		return dto;
	}

	/**
	 * 分页检索
	 * 
	 * @param dto
	 * @return IGDUT03DTO
	 */
	public IGDUT03DTO searchODPRAction(IGDUT03DTO dto) throws BLException {
		log.debug("========查询处理开始========");
		// 查询记录总数
		int totalCount = onDutyPersonRecordBL.getSearchCount(dto
				.getOnDutyPersonRecordSearchCond());
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
		// 获取分页bean
		PagingDTO pDto = dto.getPagingDto();
		// 调用DAO接口查询
		List<OnDutyPersonRecordInfo> odprList = onDutyPersonRecordBL
				.searchOnDutyPersonRecord(
						dto.getOnDutyPersonRecordSearchCond(), pDto
								.getFromCount(), pDto.getPageDispCount());
		pDto.setTotalCount(totalCount);
		dto.setOnDutyPersonRecordList(odprList);
		dto.addMessage(new ActionMessage("IGCO10000.I002", totalCount));
		log.debug("========查询处理终了========");
		return dto;
	}

	/** 
	 * 初始化更新页
	 */
	public IGDUT03DTO initIGDUT0304Action(IGDUT03DTO dto) throws BLException {
		//获取表单
		IGDUT0304Form form = dto.getIgDUT0304Form();
		//按主键检索
		OnDutyPersonRecordInfo info = onDutyPersonRecordBL
				.searchOnDutyPersonRecordByPK(form.getOdprid());
		//为表单元素赋值
		form.setOdprid(info.getOdprid());
		//来访人员
		form.setOdprguest(info.getOdprguest());
		//来访人员单位
		form.setOdprguestorg(info.getOdprguestorg());
		//来访人员身份证明
		form.setOdprguestidnum(info.getOdprguestidnum());
		//进入区域
		form.setOdprarea(info.getOdprarea());
		//进入区域临时变量
		String[] odprareas = new String[info.getOdprarea().length()];
		for (int i = 0; i < info.getOdprarea().length(); i++) {
			odprareas[i] = info.getOdprarea().substring(i, i + 1);
		}
		//为页面设定checkbox
		form.setOdprareas(odprareas);
		//来访时候设定
		form.setOdprctime(info.getOdprctime());
		//离开时间设定
		form.setOdprltime(info.getOdprltime());
		//操作人设定
		form.setOdpropter(info.getOdpropter());
		//批准人设定
		form.setOdpracter(info.getOdpracter());
		//记录人
		form.setOdprusername(info.getOdprusername());
		//操作目标
		form.setOdprtarget(info.getOdprtarget());
		//操作记录
		form.setOdprrecord(info.getOdprrecord());
		//录入时间
		form.setOdprinserttime(info.getOdprinserttime());
		//存入dto
		dto.setIgDUT0304Form(form);

		return dto;

	}

	/**
	 * 查询进入区域Checkbox List
	 * 
	 * @return
	 */
	public IGDUT03DTO searchOnDutyPersonRecordArea(IGDUT03DTO dto)
			throws BLException {
		//初始化检索条件
		CodeDetailSearchCondImpl cond = new CodeDetailSearchCondImpl();
		//ODPRAREA_LIST_KEY 为 进入区域的检索条件常量
		cond.setCcid(IGDUTCONSTANTS.ODPRAREA_LIST_KEY);
		//检索出进入区域基础数据
		List<CodeDetail> list = codeDetailBL.searchCodeDetail(cond, 0);
		//存入dto
		dto.setCodeDetailList(list);
		return dto;
	}
	
    /**
     * 值班结果说明修改处理
     * @param dto
     * @return
     * @throws BLException
     */
	public IGDUT03DTO changeDrresultAction(IGDUT03DTO dto) throws BLException {
		log.debug("========值班结果说明修改处理开始========");
		//Form取得
		IGDUT0302Form form=dto.getIgDUT0302Form();
		//值班结果drid检索值班结果
		DutyResult dutyResult=this.dutyResultBL.searchDutyResultByKey(form.getDrid());
		if(dutyResult!=null){
			DutyResultTB dutyResultTB=(DutyResultTB) SerializationUtils.clone(dutyResult);
			dutyResultTB.setDrresult(form.getDrresult());
			this.dutyResultBL.registDutyResult(dutyResultTB);
		}
		log.debug("========值班结果说明修改处理终了========");
		return dto;
	}
}
