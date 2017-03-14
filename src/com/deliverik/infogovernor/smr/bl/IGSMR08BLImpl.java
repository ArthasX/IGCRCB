/*
 * 北京递蓝科信息技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.infogovernor.smr.bl;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.infogovernor.smr.bl.task.FillInQualityAssessVWBL;
import com.deliverik.infogovernor.smr.bl.task.RegulatoryReportInstanceBL;
import com.deliverik.infogovernor.smr.dto.IGSMR08DTO;
import com.deliverik.infogovernor.smr.form.IGSMR0801Form;
import com.deliverik.infogovernor.smr.form.IGSMR0803Form;
import com.deliverik.infogovernor.smr.form.IGSMR0804Form;
import com.deliverik.infogovernor.smr.model.AnnualReportVWInfo;
import com.deliverik.infogovernor.smr.model.FillInQualityAssessInfo;
import com.deliverik.infogovernor.smr.model.ReportDetailVWInfo;
import com.deliverik.infogovernor.smr.model.condition.FillInQualityAssessSearchCondImpl;
import com.deliverik.infogovernor.smr.model.condition.RegulatoryReportInstanceSearchCondImpl;
import com.deliverik.infogovernor.smr.vo.IGSMR08001VO;

/**
 * 概述:填报质量考核 
 * 功能描述：填报质量考核
 * 创建人：赵梓廷
 * 创建记录： 2013-09-02
 * 修改记录：
 */
public class IGSMR08BLImpl extends BaseBLImpl implements IGSMR08BL {
	
	static Log log = LogFactory.getLog(IGSMR08BLImpl.class);
	
	/** 报表填报实例表BL */
	protected RegulatoryReportInstanceBL regulatoryReportInstanceBL;
	
	/** 填报质量考核BL */
	protected FillInQualityAssessVWBL fillInQualityAssessVWBL;
	
	/** 流程功能查询API */
	protected FlowSearchBL flowSearchBL;
	
	public void setFillInQualityAssessVWBL(
			FillInQualityAssessVWBL fillInQualityAssessVWBL) {
		this.fillInQualityAssessVWBL = fillInQualityAssessVWBL;
	}
	
	/**
	 * 流程功能查询API设定
	 *
	 * @param flowSearchBL 流程功能查询API
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * 报表填报实例表BL设定
	 *
	 * @param regulatoryReportInstanceBL 报表填报实例表BL
	 */
	public void setRegulatoryReportInstanceBL(
			RegulatoryReportInstanceBL regulatoryReportInstanceBL) {
		this.regulatoryReportInstanceBL = regulatoryReportInstanceBL;
	}


	/**
	 * 
	 *描述：按部门考核
	 *时间：2013-9-02
	 *@param dto
	 *@return
	 * @throws BLException 
	 */
	public IGSMR08DTO initSMR0801ByOrgAction(IGSMR08DTO dto) throws BLException {
		//form取得
		IGSMR0801Form form = dto.getIgsmr0801Form();
		FillInQualityAssessSearchCondImpl cond = new FillInQualityAssessSearchCondImpl();	
		cond.setAssessstartdate(form.getAssessstartdate());
		cond.setAssessoverdate(form.getAssessoverdate());
		List<FillInQualityAssessInfo> list_fiqa = fillInQualityAssessVWBL.searchFillInQualityByUser(cond);
		//新建页面结果集
		List<IGSMR08001VO> list = new ArrayList<IGSMR08001VO>();
		//遍历
		for(FillInQualityAssessInfo info:list_fiqa){
			//循环结果集，查看是否有该人的记录，如果没有则增加新的记录，如果有则修改记录
			if(list.size()!=0){
				//是否存在该人的标识
				String mark="1";
				//遍历集合添加值
				for(IGSMR08001VO vo:list){
					//判断是否有该部门的记录，如果没有则新增一条，如果有则修改记录
					if(vo.getOrgid().equals(info.getPporgid())){
						//判断该人是否填写年报
						if(StringUtils.isNotEmpty(info.getPpuserid1())){
							//判断是否有值、
							if(StringUtils.isNotEmpty(vo.getYearnum())){
								vo.setYearnum(String.valueOf(Integer.parseInt(vo.getYearnum())+1));
							}else{
								vo.setYearnum("1");
							}
						}
						//判断该人是否填写季报
						if(StringUtils.isNotEmpty(info.getPpuserid2())){
							//判断是否有值、
							if(StringUtils.isNotEmpty(vo.getQuarternum())){
								vo.setQuarternum(String.valueOf(Integer.parseInt(vo.getQuarternum())+1));
							}else{
								vo.setQuarternum("1");
							}
						}
						//判断该人是否填写不定期报表
						if(StringUtils.isNotEmpty(info.getPpuserid3())){
							//判断是否有值、
							if(StringUtils.isNotEmpty(vo.getNotimenum())){
								vo.setNotimenum(String.valueOf(Integer.parseInt(vo.getNotimenum())+1));
							}else{
								vo.setNotimenum("1");
							}
						}
						//判断年报填写的是否及时
						if("1".equals(info.getTimely1())){
							//如果该字段不为空
							if(StringUtils.isNotEmpty(vo.getYeartime())){								
								vo.setYeartime(String.valueOf(Integer.parseInt(vo.getYeartime())+1));
							}else{
								vo.setYeartime("1");
							}
						}
						//判断季报填写的是否及时
						if("1".equals(info.getTimely2())){
							//如果该字段不为空
							if(StringUtils.isNotEmpty(vo.getQuartertime())){
								vo.setQuartertime(String.valueOf(Integer.parseInt(vo.getQuartertime())+1));
							}else{
								vo.setQuartertime("1");
							}
						}
						//判断不定期报表填写的是否及时
						if("1".equals(info.getTimely3())){
							//如果该字段不为空
							if(StringUtils.isNotEmpty(vo.getNotime())){
								vo.setNotime(String.valueOf(Integer.parseInt(vo.getNotime())+1));
							}else{
								vo.setNotime("1");
							}
						}
						//判断年报填报是否准确
						if("0".equals(info.getTruely1())){
							//如果该字段不为空
							if(StringUtils.isNotEmpty(vo.getYeartrue())){
								vo.setYeartrue(String.valueOf(Integer.parseInt(vo.getYeartrue())+1));
							}else{
								vo.setYeartrue("1");
							}
						}
						//判断季报填报是否准确
						if("0".equals(info.getTruely2())){
							//如果字段不为空
							if(StringUtils.isNotEmpty(vo.getQuartertrue())){
								vo.setQuartertrue(String.valueOf(Integer.parseInt(vo.getQuartertrue())+1));
							}else{
								vo.setQuartertrue("1");
							}
						}
						//判断不定期报表填报是否准确
						if("0".equals(info.getTimely3())){
							//如果字段不为空
							if(StringUtils.isNotEmpty(vo.getNotimetrue())){
								vo.setNotimetrue(String.valueOf(Integer.parseInt(vo.getNotimetrue())+1));
							}else{
								vo.setNotimetrue("1");
							}
						}
						mark="0";
					}
				}
				if("1".equals(mark)){
					IGSMR08001VO smrvo = new IGSMR08001VO();
					//将该人部门机构码
					smrvo.setOrgid(info.getPporgid());
					//部门名称
					smrvo.setOrgname(info.getPporgname());
					//用户id
					smrvo.setUserid(info.getPpuserid());
					//用户名
					smrvo.setUsername(info.getUsername());
					//n年报填写次数
					//判断该人是否填写年报
					if(StringUtils.isNotEmpty(info.getPpuserid1())){
						smrvo.setYearnum("1");
					}
					//判断该人是否填写季报
					if(StringUtils.isNotEmpty(info.getPpuserid2())){
						smrvo.setQuarternum("1");
					}
					//判断该人是否填写不定期报表
					if(StringUtils.isNotEmpty(info.getPpuserid3())){
						smrvo.setNotimenum("1");							
					}
					//判断年报填写的是否及时
					if("1".equals(info.getTimely1())){
						smrvo.setYeartime("1");
						
					}
					//判断季报填写的是否及时
					if("1".equals(info.getTimely2())){
						smrvo.setQuartertime("1");
					}
					//判断不定期报表填写的是否及时
					if("1".equals(info.getTimely3())){
						smrvo.setNotime("1");
					}
					//判断年报填报是否准确
					if("0".equals(info.getTruely1())){					
						smrvo.setYeartrue("1");
					}
					//判断季报填报是否准确
					if("0".equals(info.getTruely2())){
						smrvo.setQuartertrue("1");
					}
					//判断不定期报表填报是否准确
					if("0".equals(info.getTimely3())){
						smrvo.setNotimetrue("1");
					}
					list.add(smrvo);											
				}
			}else{
				IGSMR08001VO smrvo = new IGSMR08001VO();
				//将该人部门机构码
				smrvo.setOrgid(info.getPporgid());
				//部门名称
				smrvo.setOrgname(info.getPporgname());
				//用户id
				smrvo.setUserid(info.getPpuserid());
				//用户名
				smrvo.setUsername(info.getUsername());
				//n年报填写次数
				//判断该人是否填写年报
				if(StringUtils.isNotEmpty(info.getPpuserid1())){
					smrvo.setYearnum("1");
				}
				//判断该人是否填写季报
				if(StringUtils.isNotEmpty(info.getPpuserid2())){
					smrvo.setQuarternum("1");
				}
				//判断该人是否填写不定期报表
				if(StringUtils.isNotEmpty(info.getPpuserid3())){
					smrvo.setNotimenum("1");							
				}
				//判断年报填写的是否及时
				if("1".equals(info.getTimely1())){
					smrvo.setYeartime("1");
					
				}
				//判断季报填写的是否及时
				if("1".equals(info.getTimely2())){
					smrvo.setQuartertime("1");
				}
				//判断不定期报表填写的是否及时
				if("1".equals(info.getTimely3())){
					smrvo.setNotime("1");
				}
				//判断年报填报是否准确
				if("0".equals(info.getTruely1())){					
					smrvo.setYeartrue("1");
				}
				//判断季报填报是否准确
				if("0".equals(info.getTruely2())){
					smrvo.setQuartertrue("1");
				}
				//判断不定期报表填报是否准确
				if("0".equals(info.getTimely3())){
					smrvo.setNotimetrue("1");
				}
				list.add(smrvo);						
			
			}
			
			
		}
		//定义计算百分比之后的集合
		List<IGSMR08001VO> list_vo = new ArrayList<IGSMR08001VO>();
		//遍历页面结果集，组成map集合
		for(IGSMR08001VO vo:list){
			    //计算该人的年报及时率和准确率
			    //设置该人年报的填报次数			   
				if(StringUtils.isNotEmpty(vo.getYearnum())){
					double a =0;
					double c =0;
					if(StringUtils.isNotEmpty(vo.getYeartime())){
						a=Double.parseDouble(vo.getYeartime());
					}
					if(StringUtils.isNotEmpty(vo.getYeartrue())){
						 c=Double.parseDouble(vo.getYeartrue());
					}
					Double b=Double.parseDouble(vo.getYearnum());
					vo.setYeartime(numformate(a,b));					
					vo.setYeartrue(numformate(c,b));
				}
				//计算该人的季报及时率和准确率
				if(StringUtils.isNotEmpty(vo.getQuarternum())){
					double a =0;
					double c =0;
					if(StringUtils.isNotEmpty(vo.getQuartertime())){
						a=Double.parseDouble(vo.getQuartertime());
					}
					if(StringUtils.isNotEmpty(vo.getQuartertrue())){
						 c=Double.parseDouble(vo.getQuartertrue());
					}
					Double b=Double.parseDouble(vo.getQuarternum());
					vo.setQuartertime(numformate(a,b));					
					vo.setQuartertrue(numformate(c,b));
				}
				//计算该人的不定期报表及时率和准确率
				if(StringUtils.isNotEmpty(vo.getNotimenum())){
					double a =0;
					double c =0;
					if(StringUtils.isNotEmpty(vo.getNotime())){
						a=Double.parseDouble(vo.getNotime());
					}
					if(StringUtils.isNotEmpty(vo.getNotimetrue())){
						 c=Double.parseDouble(vo.getNotimetrue());
					}
					Double b=Double.parseDouble(vo.getNotimenum());
					vo.setNotime(numformate(a,b));					
					vo.setNotimetrue(numformate(c,b));
				}
				
				list_vo.add(vo);
				
		}
		//计算合计的实体
	    IGSMR08001VO sumorg = new IGSMR08001VO();
		//遍历结果集
		for(FillInQualityAssessInfo fiq:list_fiqa){
			//计算年报的填报次数
			if(StringUtils.isNotEmpty(fiq.getPpuserid1())){
				if(StringUtils.isNotEmpty(sumorg.getYearnum())){
					sumorg.setYearnum(String.valueOf(Integer.parseInt(sumorg.getYearnum())+1));
				}else{
					sumorg.setYearnum("1");
				}
				
			}
			//计算年报及时次数
			if("1".equals(fiq.getTimely1())){
				if(StringUtils.isNotEmpty(sumorg.getYeartime())){
					sumorg.setYeartime(String.valueOf(Integer.parseInt(sumorg.getYeartime())+1));
				}else{
					sumorg.setYeartime("1");
				}
			}
			//计算年报准确次数
			if("0".equals(fiq.getTruely1())){
				if(StringUtils.isNotEmpty(sumorg.getYeartrue())){
					sumorg.setYeartrue(String.valueOf(Integer.parseInt(sumorg.getYeartrue())+1));											
				}else{
					sumorg.setYeartrue("1");
				}
			}
			//计算季报填报次数
			if(StringUtils.isNotEmpty(fiq.getPpuserid2())){
				if(StringUtils.isNotEmpty(sumorg.getQuarternum())){
					sumorg.setQuarternum(String.valueOf(Integer.parseInt(sumorg.getQuarternum())+1));	
				}else{
					sumorg.setQuarternum("1");
				}
			}
			//计算季报及时次数
			if("1".equals(fiq.getTimely2())){
				if(StringUtils.isNotEmpty(sumorg.getQuartertime())){
					sumorg.setQuartertime(String.valueOf(Integer.parseInt(sumorg.getQuartertime())+1));	
				}else{
					sumorg.setQuartertime("1");
				}
				
			}
			//计算季报准确次数
			if("0".equals(fiq.getTruely2())){
				if(StringUtils.isNotEmpty(sumorg.getQuartertrue())){
					sumorg.setQuartertrue(String.valueOf(Integer.parseInt(sumorg.getQuartertrue())+1));	
				}else{
					sumorg.setQuartertrue("1");
				}
			}
			//计算不定期填报次数
			if(StringUtils.isNotEmpty(fiq.getPpuserid3())){
				if(StringUtils.isNotEmpty(sumorg.getNotimenum())){
					sumorg.setNotimenum(String.valueOf(Integer.parseInt(sumorg.getNotimenum())+1));	
				}else{
					sumorg.setNotimenum("1");
				}
			}
			//计算不定期及时次数
			if("1".equals(fiq.getTimely3())){
				if(StringUtils.isNotEmpty(sumorg.getNotime())){
					sumorg.setNotime(String.valueOf(Integer.parseInt(sumorg.getNotime())+1));	
				}else{
					sumorg.setNotime("1");
				}
			}
			//计算不定期准确次数
			if("0".equals(fiq.getTruely3())){
				if(StringUtils.isNotEmpty(sumorg.getNotimetrue())){
					sumorg.setNotimetrue(String.valueOf(Integer.parseInt(sumorg.getNotimetrue())+1));	
				}else{
					sumorg.setNotimetrue("1");
				}
			}
		}
	    //计算该人的年报及时率和准确率
	    //设置该人年报的填报次数			   
		if(StringUtils.isNotEmpty(sumorg.getYearnum())){
			double a =0;
			double c =0;
			if(StringUtils.isNotEmpty(sumorg.getYeartime())){
				a=Double.parseDouble(sumorg.getYeartime());
			}
			if(StringUtils.isNotEmpty(sumorg.getYeartrue())){
				 c=Double.parseDouble(sumorg.getYeartrue());
			}
			Double b=Double.parseDouble(sumorg.getYearnum());
			sumorg.setYeartime(numformate(a,b));					
			sumorg.setYeartrue(numformate(c,b));
		}
		//计算该人的季报及时率和准确率
		if(StringUtils.isNotEmpty(sumorg.getQuarternum())){
			double a =0;
			double c =0;
			if(StringUtils.isNotEmpty(sumorg.getQuartertime())){
				a=Double.parseDouble(sumorg.getQuartertime());
			}
			if(StringUtils.isNotEmpty(sumorg.getQuartertrue())){
				 c=Double.parseDouble(sumorg.getQuartertrue());
			}
			Double b=Double.parseDouble(sumorg.getQuarternum());
			sumorg.setQuartertime(numformate(a,b));					
			sumorg.setQuartertrue(numformate(c,b));
		}
		//计算该人的不定期报表及时率和准确率
		if(StringUtils.isNotEmpty(sumorg.getNotimenum())){
			double a =0;
			double c =0;
			if(StringUtils.isNotEmpty(sumorg.getNotime())){
				a=Double.parseDouble(sumorg.getNotime());
			}
			if(StringUtils.isNotEmpty(sumorg.getNotimetrue())){
				 c=Double.parseDouble(sumorg.getNotimetrue());
			}
			Double b=Double.parseDouble(sumorg.getNotimenum());
			sumorg.setNotime(numformate(a,b));					
			sumorg.setNotimetrue(numformate(c,b));
		}
		dto.setOrgsum(sumorg);
		dto.setList(list_vo);
		return dto;
	}
	
	/**
	 * 
	 *描述：按人员考核
	 *时间：2013-9-02
	 *@param dto
	 *@return
	 * @throws BLException 
	 */
	public IGSMR08DTO initSMR0801ByUserAction(IGSMR08DTO dto)
			throws BLException {
		//form取得
		IGSMR0801Form form = dto.getIgsmr0801Form();
		FillInQualityAssessSearchCondImpl cond = new FillInQualityAssessSearchCondImpl();
		cond.setAssessstartdate(form.getAssessstartdate());
		cond.setAssessoverdate(form.getAssessoverdate());
		List<FillInQualityAssessInfo> list_fiqa = fillInQualityAssessVWBL.searchFillInQualityByUser(cond);
		//新建页面结果集
		List<IGSMR08001VO> list = new ArrayList<IGSMR08001VO>();
		//遍历
		for(FillInQualityAssessInfo info:list_fiqa){
			//循环结果集，查看是否有该人的记录，如果没有则增加新的记录，如果有则修改记录
			if(list.size()!=0){
				//是否存在该人的标识
				String mark="1";
				//遍历集合添加值
				for(IGSMR08001VO vo:list){
					//判断是否有该人的记录，如果没有则新增一条，如果有则修改记录
					if(vo.getUserid().equals(info.getPpuserid())){
						//判断该人是否填写年报
						if(StringUtils.isNotEmpty(info.getPpuserid1())){
							//判断是否有值、
							if(StringUtils.isNotEmpty(vo.getYearnum())){
								vo.setYearnum(String.valueOf(Integer.parseInt(vo.getYearnum())+1));
							}else{
								vo.setYearnum("1");
							}
						}
						//判断该人是否填写季报
						if(StringUtils.isNotEmpty(info.getPpuserid2())){
							//判断是否有值、
							if(StringUtils.isNotEmpty(vo.getQuarternum())){
								vo.setQuarternum(String.valueOf(Integer.parseInt(vo.getQuarternum())+1));
							}else{
								vo.setQuarternum("1");
							}
						}
						//判断该人是否填写不定期报表
						if(StringUtils.isNotEmpty(info.getPpuserid3())){
							//判断是否有值、
							if(StringUtils.isNotEmpty(vo.getNotimenum())){
								vo.setNotimenum(String.valueOf(Integer.parseInt(vo.getNotimenum())+1));
							}else{
								vo.setNotimenum("1");
							}
						}
						//判断年报填写的是否及时
						if("1".equals(info.getTimely1())){
							//如果该字段不为空
							if(StringUtils.isNotEmpty(vo.getYeartime())){								
								vo.setYeartime(String.valueOf(Integer.parseInt(vo.getYeartime())+1));
							}else{
								vo.setYeartime("1");
							}
						}
						//判断季报填写的是否及时
						if("1".equals(info.getTimely2())){
							//如果该字段不为空
							if(StringUtils.isNotEmpty(vo.getQuartertime())){
								vo.setQuartertime(String.valueOf(Integer.parseInt(vo.getQuartertime())+1));
							}else{
								vo.setQuartertime("1");
							}
						}
						//判断不定期报表填写的是否及时
						if("1".equals(info.getTimely3())){
							//如果该字段不为空
							if(StringUtils.isNotEmpty(vo.getNotime())){
								vo.setNotime(String.valueOf(Integer.parseInt(vo.getNotime())+1));
							}else{
								vo.setNotime("1");
							}
						}
						//判断年报填报是否准确
						if("0".equals(info.getTruely1())){
							//如果该字段不为空
							if(StringUtils.isNotEmpty(vo.getYeartrue())){
								vo.setYeartrue(String.valueOf(Integer.parseInt(vo.getYeartrue())+1));
							}else{
								vo.setYeartrue("1");
							}
						}
						//判断季报填报是否准确
						if("0".equals(info.getTruely2())){
							//如果字段不为空
							if(StringUtils.isNotEmpty(vo.getQuartertrue())){
								vo.setQuartertrue(String.valueOf(Integer.parseInt(vo.getQuartertrue())+1));
							}else{
								vo.setQuartertrue("1");
							}
						}
						//判断不定期报表填报是否准确
						if("0".equals(info.getTimely3())){
							//如果字段不为空
							if(StringUtils.isNotEmpty(vo.getNotimetrue())){
								vo.setNotimetrue(String.valueOf(Integer.parseInt(vo.getNotimetrue())+1));
							}else{
								vo.setNotimetrue("1");
							}
						}
						mark="0";
					}

				}
				if("1".equals(mark)){
					IGSMR08001VO smrvo = new IGSMR08001VO();
					//将该人部门机构码
					smrvo.setOrgid(info.getPporgid());
					//部门名称
					smrvo.setOrgname(info.getPporgname());
					//用户id
					smrvo.setUserid(info.getPpuserid());
					//用户名
					smrvo.setUsername(info.getUsername());
					//n年报填写次数
					//判断该人是否填写年报
					if(StringUtils.isNotEmpty(info.getPpuserid1())){
						smrvo.setYearnum("1");
					}
					//判断该人是否填写季报
					if(StringUtils.isNotEmpty(info.getPpuserid2())){
						smrvo.setQuarternum("1");
					}
					//判断该人是否填写不定期报表
					if(StringUtils.isNotEmpty(info.getPpuserid3())){
						smrvo.setNotimenum("1");							
					}
					//判断年报填写的是否及时
					if("1".equals(info.getTimely1())){
						smrvo.setYeartime("1");
						
					}
					//判断季报填写的是否及时
					if("1".equals(info.getTimely2())){
						smrvo.setQuartertime("1");
					}
					//判断不定期报表填写的是否及时
					if("1".equals(info.getTimely3())){
						smrvo.setNotime("1");
					}
					//判断年报填报是否准确
					if("0".equals(info.getTruely1())){					
						smrvo.setYeartrue("1");
					}
					//判断季报填报是否准确
					if("0".equals(info.getTruely2())){
						smrvo.setQuartertrue("1");
					}
					//判断不定期报表填报是否准确
					if("0".equals(info.getTimely3())){
						smrvo.setNotimetrue("1");
					}
					list.add(smrvo);											
				}
			}else{
				IGSMR08001VO smrvo = new IGSMR08001VO();
				//将该人部门机构码
				smrvo.setOrgid(info.getPporgid());
				//部门名称
				smrvo.setOrgname(info.getPporgname());
				//用户id
				smrvo.setUserid(info.getPpuserid());
				//用户名
				smrvo.setUsername(info.getUsername());
				//n年报填写次数
				//判断该人是否填写年报
				if(StringUtils.isNotEmpty(info.getPpuserid1())){
					smrvo.setYearnum("1");
				}
				//判断该人是否填写季报
				if(StringUtils.isNotEmpty(info.getPpuserid2())){
					smrvo.setQuarternum("1");
				}
				//判断该人是否填写不定期报表
				if(StringUtils.isNotEmpty(info.getPpuserid3())){
					smrvo.setNotimenum("1");							
				}
				//判断年报填写的是否及时
				if("1".equals(info.getTimely1())){
					smrvo.setYeartime("1");
					
				}
				//判断季报填写的是否及时
				if("1".equals(info.getTimely2())){
					smrvo.setQuartertime("1");
				}
				//判断不定期报表填写的是否及时
				if("1".equals(info.getTimely3())){
					smrvo.setNotime("1");
				}
				//判断年报填报是否准确
				if("0".equals(info.getTruely1())){					
					smrvo.setYeartrue("1");
				}
				//判断季报填报是否准确
				if("0".equals(info.getTruely2())){
					smrvo.setQuartertrue("1");
				}
				//判断不定期报表填报是否准确
				if("0".equals(info.getTimely3())){
					smrvo.setNotimetrue("1");
				}
				list.add(smrvo);						
			
			}
			
		}
		//组合完集合之后将集合数值修改，并将其改为以部门名为键，List为值的map集合
		//定义map集合
		Map<String,List<IGSMR08001VO>> map = new LinkedHashMap<String, List<IGSMR08001VO>>();
		//遍历页面结果集，组成map集合
		for(IGSMR08001VO vo:list){
			//判断是否有该部门集合的存在
			if(map.get(vo.getOrgname())==null){
				 //设置该人年报的填报次数			   
				if(StringUtils.isNotEmpty(vo.getYearnum())){
					double a =0;
					double c =0;
					if(StringUtils.isNotEmpty(vo.getYeartime())){
						a=Double.parseDouble(vo.getYeartime());
					}
					if(StringUtils.isNotEmpty(vo.getYeartrue())){
						 c=Double.parseDouble(vo.getYeartrue());
					}
					Double b=Double.parseDouble(vo.getYearnum());
					vo.setYeartime(numformate(a,b));					
					vo.setYeartrue(numformate(c,b));
				}
				//计算该人的季报及时率和准确率
				if(StringUtils.isNotEmpty(vo.getQuarternum())){
					double a =0;
					double c =0;
					if(StringUtils.isNotEmpty(vo.getQuartertime())){
						a=Double.parseDouble(vo.getQuartertime());
					}
					if(StringUtils.isNotEmpty(vo.getQuartertrue())){
						 c=Double.parseDouble(vo.getQuartertrue());
					}
					Double b=Double.parseDouble(vo.getQuarternum());
					vo.setQuartertime(numformate(a,b));					
					vo.setQuartertrue(numformate(c,b));
				}
				//计算该人的不定期报表及时率和准确率
				if(StringUtils.isNotEmpty(vo.getNotimenum())){
					double a =0;
					double c =0;
					if(StringUtils.isNotEmpty(vo.getNotime())){
						a=Double.parseDouble(vo.getNotime());
					}
					if(StringUtils.isNotEmpty(vo.getNotimetrue())){
						 c=Double.parseDouble(vo.getNotimetrue());
					}
					Double b=Double.parseDouble(vo.getNotimenum());
					vo.setNotime(numformate(a,b));					
					vo.setNotimetrue(numformate(c,b));
				}
				//实例二层list
				List<IGSMR08001VO> list_vo = new ArrayList<IGSMR08001VO>();
				list_vo.add(vo);
				map.put(vo.getOrgname(),list_vo );
			}else{
				 //设置该人年报的填报次数			   
				if(StringUtils.isNotEmpty(vo.getYearnum())){
					double a =0;
					double c =0;
					if(StringUtils.isNotEmpty(vo.getYeartime())){
						a=Double.parseDouble(vo.getYeartime());
					}
					if(StringUtils.isNotEmpty(vo.getYeartrue())){
						 c=Double.parseDouble(vo.getYeartrue());
					}
					Double b=Double.parseDouble(vo.getYearnum());
					vo.setYeartime(numformate(a,b));					
					vo.setYeartrue(numformate(c,b));
				}
				//计算该人的季报及时率和准确率
				if(StringUtils.isNotEmpty(vo.getQuarternum())){
					double a =0;
					double c =0;
					if(StringUtils.isNotEmpty(vo.getQuartertime())){
						a=Double.parseDouble(vo.getQuartertime());
					}
					if(StringUtils.isNotEmpty(vo.getQuartertrue())){
						 c=Double.parseDouble(vo.getQuartertrue());
					}
					Double b=Double.parseDouble(vo.getQuarternum());
					vo.setQuartertime(numformate(a,b));					
					vo.setQuartertrue(numformate(c,b));
				}
				//计算该人的不定期报表及时率和准确率
				if(StringUtils.isNotEmpty(vo.getNotimenum())){
					double a =0;
					double c =0;
					if(StringUtils.isNotEmpty(vo.getNotime())){
						a=Double.parseDouble(vo.getNotime());
					}
					if(StringUtils.isNotEmpty(vo.getNotimetrue())){
						 c=Double.parseDouble(vo.getNotimetrue());
					}
					Double b=Double.parseDouble(vo.getNotimenum());
					vo.setNotime(numformate(a,b));					
					vo.setNotimetrue(numformate(c,b));
				}
				map.get(vo.getOrgname()).add(vo);
			}				
				
		}
		//计算合计的实体
	    IGSMR08001VO sumuser = new IGSMR08001VO();
		//遍历结果集
		for(FillInQualityAssessInfo fiq:list_fiqa){
			//计算年报的填报次数
			if(StringUtils.isNotEmpty(fiq.getPpuserid1())){
				if(StringUtils.isNotEmpty(sumuser.getYearnum())){
					sumuser.setYearnum(String.valueOf(Integer.parseInt(sumuser.getYearnum())+1));
				}else{
					sumuser.setYearnum("1");
				}
				
			}
			//计算年报及时次数
			if("1".equals(fiq.getTimely1())){
				if(StringUtils.isNotEmpty(sumuser.getYeartime())){
					sumuser.setYeartime(String.valueOf(Integer.parseInt(sumuser.getYeartime())+1));
				}else{
					sumuser.setYeartime("1");
				}
			}
			//计算年报准确次数
			if("0".equals(fiq.getTruely1())){
				if(StringUtils.isNotEmpty(sumuser.getYeartrue())){
					sumuser.setYeartrue(String.valueOf(Integer.parseInt(sumuser.getYeartrue())+1));											
				}else{
					sumuser.setYeartrue("1");
				}
			}
			//计算季报填报次数
			if(StringUtils.isNotEmpty(fiq.getPpuserid2())){
				if(StringUtils.isNotEmpty(sumuser.getQuarternum())){
					sumuser.setQuarternum(String.valueOf(Integer.parseInt(sumuser.getQuarternum())+1));	
				}else{
					sumuser.setQuarternum("1");
				}
			}
			//计算季报及时次数
			if("1".equals(fiq.getTimely2())){
				if(StringUtils.isNotEmpty(sumuser.getQuartertime())){
					sumuser.setQuartertime(String.valueOf(Integer.parseInt(sumuser.getQuartertime())+1));	
				}else{
					sumuser.setQuartertime("1");
				}
				
			}
			//计算季报准确次数
			if("0".equals(fiq.getTruely2())){
				if(StringUtils.isNotEmpty(sumuser.getQuartertrue())){
					sumuser.setQuartertrue(String.valueOf(Integer.parseInt(sumuser.getQuartertrue())+1));	
				}else{
					sumuser.setQuartertrue("1");
				}
			}
			//计算不定期填报次数
			if(StringUtils.isNotEmpty(fiq.getPpuserid3())){
				if(StringUtils.isNotEmpty(sumuser.getNotimenum())){
					sumuser.setNotimenum(String.valueOf(Integer.parseInt(sumuser.getNotimenum())+1));	
				}else{
					sumuser.setNotimenum("1");
				}
			}
			//计算不定期及时次数
			if("1".equals(fiq.getTimely3())){
				if(StringUtils.isNotEmpty(sumuser.getNotime())){
					sumuser.setNotime(String.valueOf(Integer.parseInt(sumuser.getNotime())+1));	
				}else{
					sumuser.setNotime("1");
				}
			}
			//计算不定期准确次数
			if("0".equals(fiq.getTruely3())){
				if(StringUtils.isNotEmpty(sumuser.getNotimetrue())){
					sumuser.setNotimetrue(String.valueOf(Integer.parseInt(sumuser.getNotimetrue())+1));	
				}else{
					sumuser.setNotimetrue("1");
				}
			}
		}
	    //计算该人的年报及时率和准确率
	    //设置该人年报的填报次数			   
		if(StringUtils.isNotEmpty(sumuser.getYearnum())){
			double a =0;
			double c =0;
			if(StringUtils.isNotEmpty(sumuser.getYeartime())){
				a=Double.parseDouble(sumuser.getYeartime());
			}
			if(StringUtils.isNotEmpty(sumuser.getYeartrue())){
				 c=Double.parseDouble(sumuser.getYeartrue());
			}
			Double b=Double.parseDouble(sumuser.getYearnum());
			sumuser.setYeartime(numformate(a,b));					
			sumuser.setYeartrue(numformate(c,b));
		}
		//计算该人的季报及时率和准确率
		if(StringUtils.isNotEmpty(sumuser.getQuarternum())){
			double a =0;
			double c =0;
			if(StringUtils.isNotEmpty(sumuser.getQuartertime())){
				a=Double.parseDouble(sumuser.getQuartertime());
			}
			if(StringUtils.isNotEmpty(sumuser.getQuartertrue())){
				 c=Double.parseDouble(sumuser.getQuartertrue());
			}
			Double b=Double.parseDouble(sumuser.getQuarternum());
			sumuser.setQuartertime(numformate(a,b));					
			sumuser.setQuartertrue(numformate(c,b));
		}
		//计算该人的不定期报表及时率和准确率
		if(StringUtils.isNotEmpty(sumuser.getNotimenum())){
			double a =0;
			double c =0;
			if(StringUtils.isNotEmpty(sumuser.getNotime())){
				a=Double.parseDouble(sumuser.getNotime());
			}
			if(StringUtils.isNotEmpty(sumuser.getNotimetrue())){
				 c=Double.parseDouble(sumuser.getNotimetrue());
			}
			Double b=Double.parseDouble(sumuser.getNotimenum());
			sumuser.setNotime(numformate(a,b));					
			sumuser.setNotimetrue(numformate(c,b));
		}
		dto.setUsersum(sumuser);
		dto.setMap(map);
		return dto;
	}
	
	private String numformate(double a,double b){
		if(b==0){
			 return (a*100)+"%";
		}
		BigDecimal b1 = new BigDecimal(Double.toString(a));
	    BigDecimal b2 = new BigDecimal(Double.toString(b));
	    double fen=b1.divide(b2,2,BigDecimal.ROUND_HALF_UP).doubleValue();
	    DecimalFormat df1 = new DecimalFormat("##%");    //##%   百分比格式
	    String baifenbi= df1.format(fen);  
	    return baifenbi;
		
	}
	
	
	
	
	
	/**
	 * 监控报表详细页 信息查询
	 * @param dto
	 * @return
	 */
	public IGSMR08DTO searchListForDetailAction(IGSMR08DTO dto) throws BLException{
		log.debug("================监控报表详细页 信息查询操作开始================");
		
		//查询form取得
		IGSMR0803Form form = dto.getIgsmr0803Form();
		
		//封装查询条件对象设定
		FillInQualityAssessSearchCondImpl cond = new FillInQualityAssessSearchCondImpl();
		
		//封装查询条件(人员ID)
		cond.setUserid(form.getUserid());
		
		//封装查询条件(机构ID)
		cond.setOrgid(form.getOrgid());
		
		//调用taskBL查询
		List<ReportDetailVWInfo> detailList = fillInQualityAssessVWBL.searchListForDetailByUser(cond);
		
		//声明一个map key为userid value为detailList 合并单元格用
		Map<String,List<ReportDetailVWInfo>> map = new LinkedHashMap<String,List<ReportDetailVWInfo>>();
		
		//遍历详细信息集合
		for(ReportDetailVWInfo info : detailList){
			
			//判断map集合中key是否存在 即重复 要合并
			if(map.get(info.getUserid()) == null){
				
				//声明用来封装重复主键的List
				List<ReportDetailVWInfo> list_dou = new ArrayList<ReportDetailVWInfo>();
				
				//封装value值
				list_dou.add(info);
				
				//封装到map中供页面显示
				map.put(info.getUserid(),list_dou );
				
			}else{
				
				//如map中存在重复key 则向value中的List封装一条信息
				map.get(info.getUserid()).add(info);
			}
		}
			
		//再把查询结果封装到dto中去
		dto.setDetailMap(map);
		
		log.debug("================监控报表详细页 信息查询操作结束================");
		return dto;
	}	

	/**
	 * 核心网络系统运行情况统计初始化查询
	 * 
	 * @param dto
	 * @return
	 * @throws BLException 
	 */
	@SuppressWarnings("unchecked")
	public IGSMR08DTO searchIGSMR0804Action(IGSMR08DTO dto) throws BLException{
		
		log.debug("================核心网络系统运行情况统计初始化查询方法开始================");
		IGSMR0804Form form = dto.getIgsmr0804Form();
		int pagesize = form.getPagesize();
		int report_count = 0;
		int report_start = 0;
		int lst_size = 0;
		
		//查询季报1信息
		String pdid = IGSMRDBMCONSTANT.PDID_TQ1;
		RegulatoryReportInstanceSearchCondImpl rrcond = new RegulatoryReportInstanceSearchCondImpl();
		rrcond.setPrpdid_like(pdid);
		rrcond.setPrstatus(IGPRDCONSTANTS.PROCESS_END_STATUS);
		if ("0".equals(form.getSelect_flag())) {
			rrcond.setYear(form.getYear());
		}else{
			rrcond.setYear_GtEq(form.getYear());
		}
		rrcond.setOrderby_quarter(IGSMR08BLType.REPORT_T_Q_1_ORDER);
//		rrcond.setOrderby("DESC");
		List<AnnualReportVWInfo> lst_lookatFillIn = this.regulatoryReportInstanceBL.lookatFillIn(rrcond);
		
		//记录报表展示数据的map
		Map<String, List<String[]>> map_report = new LinkedHashMap<String, List<String[]>>();

		//记录季报1总数
		report_count = lst_lookatFillIn.size();
		dto.setCountall(report_count);	
		
		//获取查询报表个数
		if(report_count >= IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE){
			if(report_count - (pagesize+1) * IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE > 0){
				report_start = report_count - (pagesize+1) * IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE;
			}else{
				report_start = 0;
			}
//			if(report_count - pagesize * IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE >= IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE ){
//				report_start = pagesize * pagesize;
////				report_count = report_count - pagesize * pagesize;
//			}else{
//				report_start = report_count - IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE;
//			}
		}
		
		//循环季度报表，获取各报表中的指定表格式表单
		for (int i = report_start; i < report_count; i++) {
			
			//记录前一季度的数据
			Map<String, String> map_next = new LinkedHashMap<String, String>();
				
			//查询当前季度报表的上季度报表信息
			//获取当前季度报表的上报年份
			String year_next = lst_lookatFillIn.get(i).getYear();
			//获取当前季度报表的上报季度
			String quarter_next = lst_lookatFillIn.get(i).getQuarter();
			//当前季度减一季度等于0时，将季度指定为四，年份减一；否则年份不变，季度减一；
			if(Integer.valueOf(quarter_next) - 1 == 0){
				year_next = String.valueOf(Integer.valueOf(year_next) - 1);
				quarter_next = "4";
			}else{
				quarter_next = String.valueOf(Integer.valueOf(quarter_next) - 1);
			}
			rrcond.setYear(year_next);
			rrcond.setQuarter(quarter_next);
			rrcond.setYear_GtEq(null);
			List<AnnualReportVWInfo> lst_next = this.regulatoryReportInstanceBL.lookatFillIn(rrcond);
			//当当前季度报表的上季度报表有信息时，记录上季度报表的信息
			if(lst_next != null && lst_next.size() > 0){//if start 1
				
				//表格式表单值
				List<Map<String, List<Map<String, String>>>> tableValue_next = (List<Map<String, List<Map<String, String>>>>)this.flowSearchBL
					.searchPublicTableValue(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK, lst_next.get(0).getPrid(), null);
				//循环查询到的表格式表单
				for (Map<String, List<Map<String, String>>> mapTable_next1 : tableValue_next) {
					Set<String> keySet_next = mapTable_next1.keySet();
					for (String keystr : keySet_next) {
						List<Map<String, String>> lstTableValue_next = mapTable_next1.get(keystr);
						for (Map<String, String> mapTable_next2 : lstTableValue_next) {
							map_next.put(mapTable_next2.get(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_NUM),
									mapTable_next2.get(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_COUNT));
						}
						
					}
				}
				
			}//if end 1
				
			
			//获取季度报表
			AnnualReportVWInfo info = lst_lookatFillIn.get(i);
			List<String[]> lstInfo = new ArrayList<String[]>();
			//表格式表单值
			List<Map<String, List<Map<String, String>>>> tableValue = (List<Map<String, List<Map<String, String>>>>)this.flowSearchBL
				.searchPublicTableValue(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK, info.getPrid(), null);
		
			
			//循环查询到的表格式表单
			for (Map<String, List<Map<String, String>>> mapTable1 : tableValue) {
				Set<String> keySet = mapTable1.keySet();
				for (String keystr : keySet) {
					List<Map<String, String>> lstTableValue = mapTable1.get(keystr);
					for (Map<String, String> mapTable2 : lstTableValue) {
						//封装数组
						String[] objectTable = new String[3];
						objectTable[0] = mapTable2.get(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_INDEX);
						objectTable[1] = mapTable2.get(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_COUNT);
						if(map_next != null && map_next.size() > 0){
							String string = map_next.get(mapTable2.get(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_NUM));
							if(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_VALUE_4.equals(objectTable[1]) || string.equals(objectTable[1])){
								objectTable[2] = "0";
							}else if(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_VALUE_1.equals(string)){
								objectTable[2] = "2";
							}else if(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_VALUE_3.equals(string)){
								objectTable[2] = "1";
							}else if(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_VALUE_2.equals(string) 
									&& IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_VALUE_1.equals(objectTable[1])){
								objectTable[2] = "1";
							}else if(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_VALUE_2.equals(string) 
									&& IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_VALUE_3.equals(objectTable[1])){
								objectTable[2] = "2";
							}
						}else{
							objectTable[2] = "3";
						}
						
						lstInfo.add(objectTable);
					}
					
				}
			}
			//封装map
			StringBuffer reportname = new StringBuffer();
			reportname.append(info.getYear()).append("年").append(info.getQuarter()).append("季度");
			map_report.put(reportname.toString(), lstInfo);
			if(lst_size < lstInfo.size()){
				lst_size = lstInfo.size();
			}
			//显示季报满4个时，退出循环
			if(map_report.size() == IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE ){
				break;
			}
		}

		//不足四张季报的补全
		if(lst_lookatFillIn.size() < IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE){
			for (int i = 0; i < IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE - lst_lookatFillIn.size(); i++) {
				List<String[]> lstInfo = new ArrayList<String[]>();
				for (int j = 0; j < lst_size; j++) {
					//封装数组
					String[] objectTable = new String[3];
					objectTable[0] = "";
					objectTable[1] = "";
					objectTable[2] = "";
					lstInfo.add(objectTable);
				}
				//封装map
				map_report.put("tab"+i, lstInfo);
			}
			
		}
		
		dto.setMap_report(map_report);
		log.debug("================核心网络系统运行情况统计初始化查询方法结束================");
		
		return dto;
	}
	
	/**
	 * 网上银行系统运行情况统计初始化查询
	 * 
	 * @param dto
	 * @return
	 * @throws BLException 
	 */
	@SuppressWarnings("unchecked")
	public IGSMR08DTO searchIGSMR0805Action(IGSMR08DTO dto) throws BLException{
		
		log.debug("================网上银行系统运行情况统计初始化查询方法开始================");
		IGSMR0804Form form = dto.getIgsmr0804Form();
		int pagesize = form.getPagesize();
		int report_count = 0;
		int report_start = 0;
		int lst_size = 0;
		
		//查询季报1信息
		String pdid = IGSMRDBMCONSTANT.PDID_TQ1;
		RegulatoryReportInstanceSearchCondImpl rrcond = new RegulatoryReportInstanceSearchCondImpl();
		rrcond.setPrpdid_like(pdid);
		if ("0".equals(form.getSelect_flag())) {
			rrcond.setYear(form.getYear());
		}else{
			rrcond.setYear_GtEq(form.getYear());
		}
		rrcond.setPrstatus(IGPRDCONSTANTS.PROCESS_END_STATUS);
		rrcond.setOrderby_quarter(IGSMR08BLType.REPORT_T_Q_1_ORDER);
		List<AnnualReportVWInfo> lst_lookatFillIn = this.regulatoryReportInstanceBL.lookatFillIn(rrcond);
		
		//记录报表展示数据的map
		Map<String, List<String[]>> map_report = new LinkedHashMap<String, List<String[]>>();
		
		//记录季报1总数
		report_count = lst_lookatFillIn.size();
		dto.setCountall(report_count);	
		
		//获取查询报表个数
		if(report_count >= IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE){
			if(report_count - (pagesize+1) * IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE > 0){
				report_start = report_count - (pagesize+1) * IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE;
			}else{
				report_start = 0;
			}
//			if(report_count - pagesize * IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE >= IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE ){
//				report_start = pagesize * pagesize;
////				report_count = report_count - pagesize * pagesize;
//			}else{
//				report_start = report_count - IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE;
//			}
		}
		
		//循环季度报表，获取各报表中的指定表格式表单
		for (int i = report_start; i < report_count; i++) {
			
			//记录前一季度的数据
			Map<String, String> map_next = new LinkedHashMap<String, String>();

			//查询当前季度报表的上季度报表信息
			//获取当前季度报表的上报年份
			String year_next = lst_lookatFillIn.get(i).getYear();
			//获取当前季度报表的上报季度
			String quarter_next = lst_lookatFillIn.get(i).getQuarter();
			//当前季度减一季度等于0时，将季度指定为四，年份减一；否则年份不变，季度减一；
			if(Integer.valueOf(quarter_next) - 1 == 0){
				year_next = String.valueOf(Integer.valueOf(year_next) - 1);
				quarter_next = "4";
			}else{
				quarter_next = String.valueOf(Integer.valueOf(quarter_next) - 1);
			}
			rrcond.setYear(year_next);
			rrcond.setQuarter(quarter_next);
			rrcond.setYear_GtEq(null);
			List<AnnualReportVWInfo> lst_next = this.regulatoryReportInstanceBL.lookatFillIn(rrcond);
			//当当前季度报表的上季度报表有信息时，记录上季度报表的信息
			if(lst_next != null && lst_next.size() > 0){//if start 1
				
				//表格式表单值
				List<Map<String, List<Map<String, String>>>> tableValue_next = (List<Map<String, List<Map<String, String>>>>)this.flowSearchBL
					.searchPublicTableValue(IGSMR08BLType.REPORT_T_Q_1_ONLINE, lst_next.get(0).getPrid(), null);
				//循环查询到的表格式表单
				for (Map<String, List<Map<String, String>>> mapTable_next1 : tableValue_next) {
					Set<String> keySet_next = mapTable_next1.keySet();
					for (String keystr : keySet_next) {
						List<Map<String, String>> lstTableValue_next = mapTable_next1.get(keystr);
						for (Map<String, String> mapTable_next2 : lstTableValue_next) {
							map_next.put(mapTable_next2.get(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_NUM),
									mapTable_next2.get(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_COUNT));
						}
						
					}
				}
				
			}//if end 1
				
			
			//获取季度报表
			AnnualReportVWInfo info = lst_lookatFillIn.get(i);
			List<String[]> lstInfo = new ArrayList<String[]>();
			//表格式表单值
			List<Map<String, List<Map<String, String>>>> tableValue = (List<Map<String, List<Map<String, String>>>>)this.flowSearchBL
				.searchPublicTableValue(IGSMR08BLType.REPORT_T_Q_1_ONLINE, info.getPrid(), null);
		
			
			//循环查询到的表格式表单
			for (Map<String, List<Map<String, String>>> mapTable1 : tableValue) {
				Set<String> keySet = mapTable1.keySet();
				for (String keystr : keySet) {
					List<Map<String, String>> lstTableValue = mapTable1.get(keystr);
					for (Map<String, String> mapTable2 : lstTableValue) {
						//封装数组
						String[] objectTable = new String[3];
						objectTable[0] = mapTable2.get(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_INDEX);
						objectTable[1] = mapTable2.get(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_COUNT);
						if(map_next != null && map_next.size() > 0){
							String string = map_next.get(mapTable2.get(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_NUM));
							//将指标数量转换为数值类型进行比较
							Double valueOf1 = Double.valueOf(string);//上个季度的指标数
							Double valueOf2 = Double.valueOf(objectTable[1]);//当前季度的指标数
							if(valueOf1.compareTo(valueOf2) == 0){
								objectTable[2] = "0";
							}else if(valueOf1.compareTo(valueOf2)  < 0){
								objectTable[2] = "2";
							}else if(valueOf1.compareTo(valueOf2)  >  0){
								objectTable[2] = "1";
							}
						}else{
							objectTable[2] = "3";
						}
						
						lstInfo.add(objectTable);
					}
					
				}
			}
			//封装map
			StringBuffer reportname = new StringBuffer();
			reportname.append(info.getYear()).append("年").append(info.getQuarter()).append("季度");
			map_report.put(reportname.toString(), lstInfo);
			if(lst_size < lstInfo.size()){
				lst_size = lstInfo.size();
			}
			//显示季报满4个时，退出循环
			if(map_report.size() == IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE ){
				break;
			}
		}
		
		//不足四张季报的补全
		if(lst_lookatFillIn.size() < IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE){
			for (int i = 0; i < IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE - lst_lookatFillIn.size(); i++) {
				List<String[]> lstInfo = new ArrayList<String[]>();
				for (int j = 0; j < lst_size; j++) {
					//封装数组
					String[] objectTable = new String[3];
					objectTable[0] = "";
					objectTable[1] = "";
					objectTable[2] = "";
					lstInfo.add(objectTable);
				}
				//封装map
				map_report.put("tab"+i, lstInfo);
			}
			
		}
		
		dto.setMap_report(map_report);
		log.debug("================网上银行系统运行情况统计初始化查询方法结束================");
		
		return dto;
	}
	
	/**
	 * 银行卡系统运行情况统计初始化查询
	 * 
	 * @param dto
	 * @return
	 * @throws BLException 
	 */
	@SuppressWarnings("unchecked")
	public IGSMR08DTO searchIGSMR0806Action(IGSMR08DTO dto) throws BLException{
		
		log.debug("================银行卡系统运行情况统计初始化查询方法开始================");
		IGSMR0804Form form = dto.getIgsmr0804Form();
		int pagesize = form.getPagesize();
		int report_count = 0;
		int report_start = 0;
		int lst_size = 0;
		
		//查询季报1信息
		String pdid = IGSMRDBMCONSTANT.PDID_TQ1;
		RegulatoryReportInstanceSearchCondImpl rrcond = new RegulatoryReportInstanceSearchCondImpl();
		rrcond.setPrpdid_like(pdid);
		if ("0".equals(form.getSelect_flag())) {
			rrcond.setYear(form.getYear());
		}else{
			rrcond.setYear_GtEq(form.getYear());
		}
		rrcond.setPrstatus(IGPRDCONSTANTS.PROCESS_END_STATUS);
		rrcond.setOrderby_quarter(IGSMR08BLType.REPORT_T_Q_1_ORDER);
		List<AnnualReportVWInfo> lst_lookatFillIn = this.regulatoryReportInstanceBL.lookatFillIn(rrcond);
		
		//记录报表展示数据的map
		Map<String, List<String[]>> map_report = new LinkedHashMap<String, List<String[]>>();
		
		//记录季报1总数
		report_count = lst_lookatFillIn.size();
		dto.setCountall(report_count);	
		
		//获取查询报表个数
		if(report_count >= IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE){
			if(report_count - (pagesize+1) * IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE > 0){
				report_start = report_count - (pagesize+1) * IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE;
			}else{
				report_start = 0;
			}
//			if(report_count - pagesize * IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE >= IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE ){
//				report_start = pagesize * pagesize;
////				report_count = report_count - pagesize * pagesize;
//			}else{
//				report_start = report_count - IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE;
//			}
		}
		
		//循环季度报表，获取各报表中的指定表格式表单
		for (int i = report_start; i < report_count; i++) {
			
			//记录前一季度的数据
			Map<String, String> map_next = new LinkedHashMap<String, String>();
				
			//查询当前季度报表的上季度报表信息
			//获取当前季度报表的上报年份
			String year_next = lst_lookatFillIn.get(i).getYear();
			//获取当前季度报表的上报季度
			String quarter_next = lst_lookatFillIn.get(i).getQuarter();
			//当前季度减一季度等于0时，将季度指定为四，年份减一；否则年份不变，季度减一；
			if(Integer.valueOf(quarter_next) - 1 == 0){
				year_next = String.valueOf(Integer.valueOf(year_next) - 1);
				quarter_next = "4";
			}else{
				quarter_next = String.valueOf(Integer.valueOf(quarter_next) - 1);
			}
			rrcond.setYear(year_next);
			rrcond.setQuarter(quarter_next);
			rrcond.setYear_GtEq(null);
			List<AnnualReportVWInfo> lst_next = this.regulatoryReportInstanceBL.lookatFillIn(rrcond);
			//当当前季度报表的上季度报表有信息时，记录上季度报表的信息
			if(lst_next != null && lst_next.size() > 0){//if start 1
				
				//表格式表单值
				List<Map<String, List<Map<String, String>>>> tableValue_next = (List<Map<String, List<Map<String, String>>>>)this.flowSearchBL
					.searchPublicTableValue(IGSMR08BLType.REPORT_T_Q_1_BANKCARD, lst_next.get(0).getPrid(), null);
				//循环查询到的表格式表单
				for (Map<String, List<Map<String, String>>> mapTable_next1 : tableValue_next) {
					Set<String> keySet_next = mapTable_next1.keySet();
					for (String keystr : keySet_next) {
						List<Map<String, String>> lstTableValue_next = mapTable_next1.get(keystr);
						for (Map<String, String> mapTable_next2 : lstTableValue_next) {
							map_next.put(mapTable_next2.get(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_NUM),
									mapTable_next2.get(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_COUNT));
						}
						
					}
				}
				
			}//if end 1
				
			
			//获取季度报表
			AnnualReportVWInfo info = lst_lookatFillIn.get(i);
			List<String[]> lstInfo = new ArrayList<String[]>();
			//表格式表单值
			List<Map<String, List<Map<String, String>>>> tableValue = (List<Map<String, List<Map<String, String>>>>)this.flowSearchBL
				.searchPublicTableValue(IGSMR08BLType.REPORT_T_Q_1_BANKCARD, info.getPrid(), null);
		
			
			//循环查询到的表格式表单
			for (Map<String, List<Map<String, String>>> mapTable1 : tableValue) {
				Set<String> keySet = mapTable1.keySet();
				for (String keystr : keySet) {
					List<Map<String, String>> lstTableValue = mapTable1.get(keystr);
					for (Map<String, String> mapTable2 : lstTableValue) {
						//封装数组
						String[] objectTable = new String[3];
						objectTable[0] = mapTable2.get(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_INDEX);
						objectTable[1] = mapTable2.get(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_COUNT);
						if(map_next != null && map_next.size() > 0){
							String string = map_next.get(mapTable2.get(IGSMR08BLType.REPORT_T_Q_1_CORENETWORK_NUM));
							//将指标数量转换为数值类型进行比较
							Double valueOf1 = Double.valueOf(string);//上个季度的指标数
							Double valueOf2 = Double.valueOf(objectTable[1]);//当前季度的指标数
							if(valueOf1.compareTo(valueOf2) == 0){
								objectTable[2] = "0";
							}else if(valueOf1.compareTo(valueOf2)  < 0){
								objectTable[2] = "2";
							}else if(valueOf1.compareTo(valueOf2)  >  0){
								objectTable[2] = "1";
							}
						}else{
							objectTable[2] = "3";
						}
						
						lstInfo.add(objectTable);
					}
					
				}
			}
			//封装map
			StringBuffer reportname = new StringBuffer();
			reportname.append(info.getYear()).append("年").append(info.getQuarter()).append("季度");
			map_report.put(reportname.toString(), lstInfo);
			if(lst_size < lstInfo.size()){
				lst_size = lstInfo.size();
			}
			//显示季报满4个时，退出循环
			if(map_report.size() == IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE ){
				break;
			}
		}
		
		//不足四张季报的补全
		if(lst_lookatFillIn.size() < IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE){
			for (int i = 0; i < IGSMR08BLType.REPORT_T_Q_1_COUNT_PAGE - lst_lookatFillIn.size(); i++) {
				List<String[]> lstInfo = new ArrayList<String[]>();
				for (int j = 0; j < lst_size; j++) {
					//封装数组
					String[] objectTable = new String[3];
					objectTable[0] = "";
					objectTable[1] = "";
					objectTable[2] = "";
					lstInfo.add(objectTable);
				}
				//封装map
				map_report.put("tab"+i, lstInfo);
			}
			
		}
		
		dto.setMap_report(map_report);
		log.debug("================网上银行系统运行情况统计初始化查询方法结束================");
		
		return dto;
	}
}
