/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 
 */

package com.deliverik.infogovernor.crc.bl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.user.bl.task.OrganizationBL;
import com.deliverik.framework.user.model.Organization;
import com.deliverik.framework.user.model.condition.OrganizationSearchCondImpl;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.infogovernor.crc.bl.task.IGCRC2101BL;
import com.deliverik.infogovernor.crc.dto.IGCRC2101DTO;
import com.deliverik.infogovernor.crc.form.IGCRC2101Form;
import com.deliverik.infogovernor.crc.model.IGCRC2101VWInfo;
import com.deliverik.infogovernor.crc.model.IGCRC2102VWInfo;
import com.deliverik.infogovernor.crc.model.condition.IGCRC2101CondImpl;
import com.deliverik.infogovernor.crc.model.entity.IGCRC2101VW;
import com.deliverik.infogovernor.crc.model.entity.IGCRC2102VW;
import com.deliverik.infogovernor.crc.vo.IGCRC2102VO;

/**	
 * 概述:人员工作统计查询业务逻辑实现	
 * 创建记录：yukexin    2014-8-15 下午2:24:00	
 * 修改记录：
 */	
public class IGCRC21BLImpl implements IGCRC21BL {
	//日志对象取得
	static Log log = LogFactory.getLog(IGCRC21BLImpl.class);
	
	/** 人员工作统计信息BL */
	protected IGCRC2101BL igcrc2101BL;
	
	/** 机构BL */
	protected OrganizationBL organizationBL;

	public void setIgcrc2101BL(IGCRC2101BL igcrc2101bl) {
		this.igcrc2101BL = igcrc2101bl;
	}
	
	public void setOrganizationBL(OrganizationBL organizationBL) {
		this.organizationBL = organizationBL;
	}

	/**
	 * 人员工作信息查询处理
	 *
	 * @param dto IGCRC2101DTO
	 * @return IGCRC2101DTO
	 */
	public IGCRC2101DTO searchEntityItemAction(IGCRC2101DTO dto)
			throws BLException {
		log.debug("========人员工作统计信息查询处理开始========");
		//获取form
		IGCRC2101Form form = dto.getIgcrc2101Form();
		//实例化cond
		IGCRC2101CondImpl cond = new IGCRC2101CondImpl();
		//获取年
		String year=form.getYear();
		//获取月
		String month=form.getMonth();
		String propentime=null;
		//判断年月是否为空
		if(year==null&&month==null){
			propentime="%";
		}else{
			propentime=year+"/"+month+"%";
		}
		//拼接的年月赋值
		cond.setPropentime(propentime);
		//赋值
		cond = copyProperties(form, cond);
		//获取数据
		List<IGCRC2101VWInfo> crList = igcrc2101BL.searchIGCRC2101(cond);
		// 带合计的数据
		List<IGCRC2102VO> igcrc2102voList = new ArrayList<IGCRC2102VO>();
		// 分项合计数据
		List<Integer> listSum = new ArrayList<Integer>();

		// 统计每个人员的统计
		if (null != crList && crList.size() != 0) {
			IGCRC2101VW igcrc2101VW = null;
			Integer incidentNum = 0;
			Integer problemNum = 0;
			Integer changeNum = 0;
			Integer serviceNum = 0;
			Integer developNum = 0;
			Integer total = 0;
			//遍历数据并计算合计
			for (IGCRC2101VWInfo vw : crList) {
				igcrc2101VW = (IGCRC2101VW)vw;
				//如果查询的是空值,设为0
				if(igcrc2101VW.getIncidentNum() == null){
					igcrc2101VW.setIncidentNum(0);
				}
				if(igcrc2101VW.getProblemNum() == null){
					igcrc2101VW.setProblemNum(0);
				}
				if(igcrc2101VW.getChangeNum() == null){
					igcrc2101VW.setChangeNum(0);
				}
				if(igcrc2101VW.getServiceNum() == null){
					igcrc2101VW.setServiceNum(0);
				}
				if(igcrc2101VW.getDevelopNum() == null){
					igcrc2101VW.setDevelopNum(0);
				}
				// 计算每个人员使用的总数
				int sum = (igcrc2101VW.getIncidentNum() + igcrc2101VW.getProblemNum() + igcrc2101VW.getChangeNum()
						+ igcrc2101VW.getServiceNum() + igcrc2101VW.getDevelopNum());
				// 累加每项合计
				incidentNum += igcrc2101VW.getIncidentNum();
				problemNum += igcrc2101VW.getProblemNum();
				changeNum += igcrc2101VW.getChangeNum();
				serviceNum += igcrc2101VW.getServiceNum();
				developNum += igcrc2101VW.getDevelopNum();
				total += sum;
				// 将视图数据bean和合计添加到新的bean中并创建集合
				igcrc2102voList.add(new IGCRC2102VO(igcrc2101VW, sum));
			}
			listSum.add(incidentNum);
			listSum.add(problemNum);
			listSum.add(changeNum);
			listSum.add(serviceNum);
			listSum.add(developNum);
			listSum.add(total);
		} else {
			// 没有数据的时候 合计各项置0  6列
			for (int i = 0; i < 6; i++) {
				listSum.add(0);
			}
		}
		//数据存入dto
		dto.setListSum(listSum);
		dto.setIgcrc2102voList(igcrc2102voList);
		log.debug("========人员工作信息查询处理终了========");
		return dto;
	}
	
	/**	
	 * 功能：将form中的查询条件赋给cond
	 * @param form 页面查询条件
	 * @param cond 检索条件
	 * @return
	 * 修改记录：
	 */	
	private IGCRC2101CondImpl copyProperties(IGCRC2101Form form, IGCRC2101CondImpl cond){
		//年
		cond.setYear(form.getYear());
		//月
		cond.setMonth(form.getMonth());
		//部门
		cond.setDepartment(form.getDepartment());
		return cond;
	}

	/**	
	 * 功能：查询部门下拉列表
	 * @param dto
	 * @return IGCRC2101DTO
	 * @throws BLException
	 * 修改记录：null
	 */	
	public IGCRC2101DTO searchDepartmentBeanList(IGCRC2101DTO dto)
			throws BLException {
		
		OrganizationSearchCondImpl organizationSearchCond = new OrganizationSearchCondImpl();
		organizationSearchCond.setIs_in_use("1");
		organizationSearchCond.setOrgpar("0002001017");//信息科技部
		organizationSearchCond.setSortType(CommonDefineUtils.SORT_BY_ORGSYSCODING);
		List<Organization> ret = organizationBL.searchOrganization(organizationSearchCond);//查1级机构
		List<IGCRC2102VWInfo> departmentBeanList = new ArrayList<IGCRC2102VWInfo>();
		for (Organization organization : ret) {
			IGCRC2102VW igcrc2102vw = new IGCRC2102VW();
			igcrc2102vw.setId(organization.getOrgid().toString());
			String[] orgnames = organization.getOrgname().split("-");
			int orgslen = orgnames.length - 1;
			igcrc2102vw.setLabel(orgnames[orgslen]);
			igcrc2102vw.setValue(organization.getOrgsyscoding());
			departmentBeanList.add(igcrc2102vw);
		}
		//获取数据
//		List<IGCRC2102VWInfo> departmentBeanList = igcrc2101BL.searchDepartmentBeanList();
		//存置
		dto.setDepartmentBeanList(departmentBeanList);
		return dto;
	}
}
