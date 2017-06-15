/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */
package com.deliverik.framework.workflow.prd.bl.task;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.util.LabelValueBean;
import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.model.IG222Info;
import com.deliverik.framework.workflow.prd.model.IG309Info;
import com.deliverik.framework.workflow.prd.model.condition.IG222SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG222SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG222DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG222TB;

/**
 * <p>概述:流程Action处理Action</p>
 * <p>功能描述：1.条件检索结果件数取得</p>
 * <p>          2.主键检索处理</p>
 * <p>          3.全部检索处理</p>
 * <p>          4.条件检索处理</p>
 * <p>          5.登录处理</p>
 * <p>          6.按流程参与者主键删除处理</p>
 * <p>          7.删除处理</p>
 * <p>          8.变更处理</p>
 * <p>          9.流程参与者存在检查</p>
 * <p>          10.获取指定用户具有的发起流程的角色</p>
 * <p>          11.获取发起流程的角色(运维计划用)</p>
 * <p>创建记录：
 */
public class IG222BLImpl extends BaseBLImpl implements IG222BL {

	/** IG222 DAO */
	protected IG222DAO ig222DAO;
	
	/**
	 * 流程参与者定义DAO
	 * 
	 * @param ig222DAO 流程参与者定义DAO
	 */
	public void setIg222DAO(
			IG222DAO ig222DAO) {
		this.ig222DAO = ig222DAO;
	}

	/**
	 * 功能：获取流程参与者定义实例
	 * @return IG222TB
	 */
	
	public IG222TB getIG222TBInstance(){
		return new IG222TB();
	}

	/**
	 * 功能：条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getIG222InfoSearchCount(IG222SearchCond cond){
		
		return ig222DAO.getSearchCount(cond);
	}

	/**
	 * 功能：主键检索处理
	 * 
	 * @param ppdid 流程参与者ID
	 * @return 流程参与者信息
	 * @throws BLException 
	 */
	public IG222Info searchIG222InfoByKey(String ppdid) throws BLException  {
		
		return checkExistIG222Info(ppdid);
	}
	
	/**
	 * 功能：全部检索处理
	 *
	 * @return 全部流程参与者信息
	 */
	public List<IG222Info> searchIG222Info(IG222SearchCond cond){
		
		List<IG222Info> ret = ig222DAO.findByCond(cond,0,0);
		return ret;
	}

	/**
	 * 功能：条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG222Info> searchIG222Info(IG222SearchCond cond, int start, int count){
		
		List<IG222Info> ret = ig222DAO.findByCond(cond,start,count);
		return ret;
	}

	/**
	 * 功能：登录处理
	 * 
	 * @param IG222 登录数据
	 * @return 流程参与者信息
	 * @throws BLException 
	 */
	public IG222Info registIG222Info(IG222Info processParticipantDef) throws BLException{
		
		return ig222DAO.save(processParticipantDef);
	}

	/**
	 * 功能：按流程参与者主键删除处理
	 * 
	 * @param ppdid 删除对象流程参与者主键
	 * @throws BLException 
	 */
	public IG222Info deleteIG222Info(String ppdid) throws BLException{

		IG222Info processParticipantDef = checkExistIG222Info(ppdid);
		
		ig222DAO.delete(processParticipantDef);
		
		return processParticipantDef;
	}
	
	/**
	 * 功能：删除处理
	 * 
	 * @param IG222 流程参与者
	 * @throws BLException 
	 */
	public void deleteIG222Info(IG222Info processParticipantDef) throws BLException{
		IG222Info ppd = checkExistIG222Info(processParticipantDef.getPpdid());
		
		ig222DAO.delete(ppd);
	}

	/**
	 * 功能：变更处理
	 * 
	 * @param IG222 变更数据
	 * @return 流程参与者信息
	 * @throws BLException 
	 */
	public IG222Info updateIG222Info(IG222Info processParticipantDef) throws BLException{
		
		checkExistIG222Info(processParticipantDef.getPpdid());
		
		return ig222DAO.save(processParticipantDef);
	}
	
	/**
	 * 功能：流程参与者存在检查
	 * 
	 * @param ppdid 流程参与者ID
	 * @return 流程参与者信息
	 * @throws BLException 
	 */
	protected IG222Info checkExistIG222Info(String ppdid) throws BLException{
		IG222Info info = ig222DAO.findByPK(ppdid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","流程参与者基本");
		}
		return info;
	}
	
	/**
	 * 功能：获取指定用户具有的发起流程的角色
	 * @param userid 用户ID
	 * @param pdid 流程定义ID
	 * @return 发起角色下拉列表
	 */
	public List<LabelValueBean> searchInitProcessParticipantRole(String userid, String pdid){
		return ig222DAO.searchInitProcessParticipantRole(userid, pdid);
	}
	
	/**
	 * 功能：获取发起流程的角色
	 * @param userid 用户ID
	 * @param pdid 流程定义ID
	 * @return 发起角色下拉列表
	 */
	public List<LabelValueBean> searchInitProcessParticipantRoleAll(String pdid){
		return ig222DAO.searchInitProcessParticipantRoleAll(pdid);
	}
	
	/**
	 * 功能：全部检索处理
	 *
	 * @return 全部流程参与者信息
	 */
	public List<IG222Info> searchIG222InfoAll(){
		return ig222DAO.findAll();
	}
	
	/**
	 * PPDID主键值取得
	 * 
	 * @param 流程状态ID
	 * @return PPDID主键值
	 */
	public String getPpdidSequenceNextValue(String psdid) {
		return ig222DAO.getPpdidSequenceNextValue(psdid);
	}
	
	/**
	 * 参与者可视按钮查询
	 * 
	 * @param psdid 状态ID
	 * @param roleid 角色ID
	 * @return 可视按钮列表
	 */
	public List<IG309Info> searchVisibleButton(String psdid, Integer roleid) {
		List<IG309Info> lst_button = ig222DAO.searchVisibleButton(psdid, roleid);
		List<IG309Info> lst_defaultbutton = ig222DAO.searchDefaultVisibleButton(psdid);
		if(lst_button.isEmpty()) {
			return lst_defaultbutton;
		} else {
			//查找是否有确认按钮
			for(IG309Info bean : lst_defaultbutton) {
				if(IGPRDCONSTANTS.BUTTON_CONFIRM.equals(bean.getVbid())) {
					lst_button.add(bean);
					break;
				}
			}
			return lst_button;
		}
	}
	
	/**
	 * 同角色所有人提交跃迁按钮查询（普通权限）
	 * 
	 * @param psdid 状态ID
	 * @return 按钮列表
	 */
	public Map<String, String> searchRoleCommitNormalAuth(String psdid){
		return ig222DAO.searchRoleCommitNormalAuth(psdid);
	}
	
	/**
	 * 同角色所有人提交跃迁按钮查询（缺省权限）
	 * 
	 * @param psdid 状态ID
	 * @return 按钮列表
	 */
	public List<String> searchRoleCommitDefaultAuth(String psdid){
		return ig222DAO.searchRoleCommitDefaultAuth(psdid);
	}
	
	/**
	 * 全部检索处理
	 *
	 * @return 全部流程参与者信息
	 */
	public List<IG222Info> searchIG222InfoRun(IG222SearchCond cond){
		
		List<IG222Info> ret = ig222DAO.findByCondRun(cond);
		return ret;
	}
	
	/**
	 * XML脚本导出处理
	 *
	 * @param pdid 流程定义ID
	 * @return XML脚本
	 */
	public StringBuffer exportXML(String pdid) throws BLException {
		IG222SearchCondImpl cond = new IG222SearchCondImpl();
		cond.setPpdid_like(pdid);
		List<IG222Info> lst_IG222Info = this.searchIG222Info(cond);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG222>");
		sbf_xml.append("<DATALIST>");
		if(lst_IG222Info != null) {
			for(IG222Info info : lst_IG222Info) {
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PPDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPpdid()) ? "" : IGStringUtils.filterXMLStr(info.getPpdid()));
				sbf_xml.append("</PPDID>");
				sbf_xml.append("<PSDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsdid()) ? "" : IGStringUtils.filterXMLStr(info.getPsdid()));
				sbf_xml.append("</PSDID>");
				sbf_xml.append("<ROLEID>");
				sbf_xml.append(info.getRoleid() == null ? "" : "&roleid_" + info.getRoleid() + ";");
				sbf_xml.append("</ROLEID>");
				sbf_xml.append("<ORGID>");
				sbf_xml.append(StringUtils.isEmpty(info.getOrgid())? "" : "&orgid_" + info.getOrgid() + ";");
				sbf_xml.append("</ORGID>");
				sbf_xml.append("<USERID>");
				sbf_xml.append(StringUtils.isEmpty(info.getUserid()) ? "" : "&userid_" + info.getUserid() + ";");
				sbf_xml.append("</USERID>");
				sbf_xml.append("<PPDSUPER>");
				sbf_xml.append(StringUtils.isEmpty(info.getPpdsuper()) ? "" : IGStringUtils.filterXMLStr(info.getPpdsuper()));
				sbf_xml.append("</PPDSUPER>");
				sbf_xml.append("<FINGERPRINT>");
				sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
				sbf_xml.append("</FINGERPRINT>");
				sbf_xml.append("</DATA>");
			}
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG222>");
		return sbf_xml;
	}
	
	/**
	 * XML脚本导入处理
	 *
	 * @param element Element
	 * @throws BLException
	 */
	@SuppressWarnings("unchecked")
	public void importXML(Element element) throws BLException {
		Element data = element.getChild("DATALIST");
		List<Element> dataList = data.getChildren();
		List<IG222Info> lst_IG222 = new ArrayList<IG222Info>();
		IG222TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG222TBInstance();
			entity.setPpdid(e.getChildText("PPDID"));
			entity.setPsdid(e.getChildText("PSDID"));
			entity.setRoleid(StringUtils.isEmpty(e.getChildText("ROLEID")) ? null : new Integer(e.getChildText("ROLEID")));
			entity.setOrgid(e.getChildText("ORGID"));
			entity.setUserid(e.getChildText("USERID"));
			entity.setPpdsuper(e.getChildText("PPDSUPER"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			lst_IG222.add(entity);
		}
		this.ig222DAO.saveOrUpdateAll(lst_IG222);
	}
	
}
