/*
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 */

package com.deliverik.framework.workflow.prd.bl.task;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.jdom.Element;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.utility.IGStringUtils;
import com.deliverik.framework.workflow.prd.model.IG333Info;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG333SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG333DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG333TB;

/**
 * <p>概述:流程状态定义业务逻辑实现</p>
 * <p>功能描述：1.条件检索结果件数取得</p>
 * <p>          2.主键检索处理</p>
 * <p>          3.条件检索处理</p>
 * <p>          4.全部检索处理</p>
 * <p>          5.新增处理</p>
 * <p>          6.删除处理</p>
 * <p>          7.变更处理</p>
 * <p>          8.流程状态定义信息存在检查</p>
 * <p>          9.根据状态code获取指定流程类型的状态ID</p>
 * <p>创建记录：
 */
public class IG333BLImpl extends BaseBLImpl implements IG333BL {
	
	/** 流程状态定义DAO操作 */
	protected IG333DAO ig333DAO;
	
	/** 流程定义BL操作 */
	protected IG380BL ig380BL;

	/**
	 * 流程状态定义DAO
	 * 
	 * @param ig333DAO 流程状态定义DAO
	 */
	public void setIg333DAO(
			IG333DAO ig333DAO) {
		this.ig333DAO = ig333DAO;
	}
	
	/**
	 * 流程定义BL操作
	 * @param ig380BL 流程定义BL操作
	 */
	public void setIg380BL(IG380BL ig380BL) {
		this.ig380BL = ig380BL;
	}

	/**
	 * 功能：条件检索结果件数取得
	 * 
	 * @param cond 检索条件
	 * @return 条件检索结果件数
	 */
	public int getIG333InfoSearchCount(IG333SearchCond cond) {
		return ig333DAO.getSearchCount(cond);
	}

	/**
	 * 功能：主键检索处理
	 * 
	 * @param psdid 流程状态定义ID
	 * @return 流程状态定义信息
	 * @throws BLException 
	 */
	
	public IG333Info searchIG333InfoByKey(String psdid) throws BLException {
		return checkExistIG333Info(psdid);
	}

	/**
	 * 功能：条件检索处理
	 * 
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	
	public List<IG333Info> searchIG333Info(
			IG333SearchCond cond, int start, int count) {
		return ig333DAO.findByCond(cond, start, count);
	}
	
	/**
	 * 功能：条件检索处理
	 * 
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	
	public List<IG333Info> searchIG333Info(IG333SearchCond cond){
		return ig333DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * 功能：全部检索处理
	 * 
	 * @return 检索结果列表
	 */
	
	public List<IG333Info> searchIG333InfoAll() {
		return ig333DAO.findAll();
	}

	/**
	 * 功能：新增处理
	 * 
	 * @param IG333Info 新增数据
	 * @return 资产信息
	 */
	
	public IG333Info registIG333Info(
			IG333Info ig333Info) throws BLException {
		return ig333DAO.save(ig333Info);
	}

	/**
	 * 功能：删除处理
	 * 
	 * @param psdid 删除流程状态定义主键
	 * @throws BLException 
	 */
	
	public void deleteIG333InfoByKey(String psdid) throws BLException {
		IG333Info processStatusDef = checkExistIG333Info(psdid);
		ig333DAO.delete(processStatusDef);
	}

	/**
	 * 功能：变更处理
	 * 
	 * @param ig333Info 变更数据
	 * @return 流程状态定义
	 * @throws BLException 
	 */
	
	public IG333Info updateIG333Info(
			IG333Info ig333Info) throws BLException {
		return ig333DAO.save(ig333Info);
	}
	
	/**
	 * 功能：流程状态定义信息存在检查
	 * 
	 * @param psdid 流程状态定义ID
	 * @return 流程状态定义
	 * @throws BLException 
	 */
	
	protected IG333Info checkExistIG333Info(String psdid) throws BLException{
		IG333Info info = ig333DAO.findByPK(psdid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","流程状态定义基本");
		}
		return info;
	}
	
	/**
	 * 功能：流程状态定义信息实例
	 * 
	 * @return 流程状态定义信息
	 */
	
	public IG333TB getIG333TBInstance() {
		return new IG333TB();
	}
	
	/**
	 * 功能：根据状态code获取指定流程类型的状态ID
	 * 
	 * @param pdid 流程定义ID
	 * @param psdcode 流程状态标识
	 * @return 流程状态ID
	 * @throws BLException 
	 */
	public String getIG333InfoIdByStatus(String pdid, String psdcode) throws BLException {
		if(StringUtils.isEmpty(pdid)) {
			throw new BLException("IGCO10000.E004","流程定义基本");
		}
		if(StringUtils.isEmpty(psdcode)) {
			throw new BLException("IGCO10000.E004","流程状态定义基本");
		}
		IG333SearchCondImpl cond = new IG333SearchCondImpl();
		cond.setPdid(pdid);
		cond.setPsdcode(psdcode);
		List<IG333Info> psdList = ig333DAO.findByCond(cond, 0, 0);
		if(psdList.size() != 1) {
			throw new BLException("IGCO10000.E004","流程状态定义基本");
		} else {
			return psdList.get(0).getPsdid();
		}
	}
	
	/**
	 * PSDID主键值取得
	 * 
	 * @param 流程定义ID
	 * @return PSDID主键值
	 */
	public String getPsdidSequenceNextValue(String pdid) {
		return ig333DAO.getPsdidSequenceNextValue(pdid);
	}
	
	/**
	 * 根据分派状态和分派按钮查询被分派节点集合
	 */
	public List<IG333Info> searchAssignedStatusDef(String psdid, String pbdid) {
		if(StringUtils.isEmpty(pbdid)||StringUtils.isEmpty(psdid)){
			return null;
		}else{
			IG333SearchCondImpl cond = new IG333SearchCondImpl();
			cond.setAssignpsdid(psdid);
			cond.setAssignpbdid(pbdid);
			return this.ig333DAO.findByAssign(cond);
		}
	}
	
	/**
	 * 指定状态关联的可调整参与者的状态集合取得
	 *
	 * @param psdid 状态ID
	 * @return 状态集合
	 */
	public List<IG333Info> searchAdjustStatus(String psdid) {
		return ig333DAO.searchAdjustStatus(psdid);
	}
	
	/**
	 * XML脚本导出处理
	 *
	 * @param pdid 流程定义ID
	 * @return XML脚本
	 */
	public StringBuffer exportXML(String pdid) throws BLException {
		IG333SearchCondImpl cond = new IG333SearchCondImpl();
		cond.setPsdid_like(pdid);
		List<IG333Info> lst_IG333Info = this.searchIG333Info(cond);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG333>");
		sbf_xml.append("<DATALIST>");
		if(lst_IG333Info != null) {
			for(IG333Info info : lst_IG333Info) {
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PSDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsdid()) ? "" : IGStringUtils.filterXMLStr(info.getPsdid()));
				sbf_xml.append("</PSDID>");
				sbf_xml.append("<PDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPdid()) ? "" : IGStringUtils.filterXMLStr(info.getPdid()));
				sbf_xml.append("</PDID>");
				sbf_xml.append("<PSDNAME>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsdname()) ? "" : IGStringUtils.filterXMLStr(info.getPsdname()));
				sbf_xml.append("</PSDNAME>");
				sbf_xml.append("<PSDDESC>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsddesc()) ? "" : IGStringUtils.filterXMLStr(info.getPsddesc()));
				sbf_xml.append("</PSDDESC>");
				sbf_xml.append("<PSDCODE>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsdcode()) ? "" : IGStringUtils.filterXMLStr(info.getPsdcode()));
				sbf_xml.append("</PSDCODE>");
				sbf_xml.append("<FINGERPRINT>");
				sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
				sbf_xml.append("</FINGERPRINT>");
				sbf_xml.append("<PSDTYPE>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsdtype()) ? "" : IGStringUtils.filterXMLStr(info.getPsdtype()));
				sbf_xml.append("</PSDTYPE>");
				sbf_xml.append("<PSDMODE>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsdmode()) ? "" : IGStringUtils.filterXMLStr(info.getPsdmode()));
				sbf_xml.append("</PSDMODE>");
				sbf_xml.append("<PSDFLAG>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsdflag()) ? "" : IGStringUtils.filterXMLStr(info.getPsdflag()));
				sbf_xml.append("</PSDFLAG>");
				sbf_xml.append("<PSDASSIGN>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsdassign()) ? "" : IGStringUtils.filterXMLStr(info.getPsdassign()));
				sbf_xml.append("</PSDASSIGN>");
				sbf_xml.append("<PSDORG>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsdorg()) ? "" : IGStringUtils.filterXMLStr(info.getPsdorg()));
				sbf_xml.append("</PSDORG>");
				sbf_xml.append("<PSDCONFIRM>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsdconfirm()) ? "" : IGStringUtils.filterXMLStr(info.getPsdconfirm()));
				sbf_xml.append("</PSDCONFIRM>");
				sbf_xml.append("<ASSIGNPSDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getAssignpsdid()) ? "" : IGStringUtils.filterXMLStr(info.getAssignpsdid()));
				sbf_xml.append("</ASSIGNPSDID>");
				sbf_xml.append("<ASSIGNPBDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getAssignpbdid()) ? "" : IGStringUtils.filterXMLStr(info.getAssignpbdid()));
				sbf_xml.append("</ASSIGNPBDID>");
				sbf_xml.append("<ASSIGNFLAG>");
				sbf_xml.append(StringUtils.isEmpty(info.getAssignflag()) ? "" : IGStringUtils.filterXMLStr(info.getAssignflag()));
				sbf_xml.append("</ASSIGNFLAG>");
				sbf_xml.append("<PARTICIPANTCHANGE>");
				sbf_xml.append(StringUtils.isEmpty(info.getParticipantchange()) ? "" : IGStringUtils.filterXMLStr(info.getParticipantchange()));
				sbf_xml.append("</PARTICIPANTCHANGE>");				
				sbf_xml.append("<FORMGLOBALCONTROL>");
				sbf_xml.append(StringUtils.isEmpty(info.getFormGlobalControl()) ? "" : IGStringUtils.filterXMLStr(info.getFormGlobalControl()));
				sbf_xml.append("</FORMGLOBALCONTROL>");
				sbf_xml.append("<JSFUNCTION>");
				sbf_xml.append(StringUtils.isEmpty(info.getJsfunction()) ? "" : IGStringUtils.filterXMLStr(info.getJsfunction()));
				sbf_xml.append("</JSFUNCTION>");
				sbf_xml.append("<ASSIGNPAGETYPE>");
				sbf_xml.append(StringUtils.isEmpty(info.getAssignPageType()) ? "" : IGStringUtils.filterXMLStr(info.getAssignPageType()));
				sbf_xml.append("</ASSIGNPAGETYPE>");
				sbf_xml.append("<BYSEQUENCE>");
				sbf_xml.append(StringUtils.isEmpty(info.getBysequence()) ? "" : IGStringUtils.filterXMLStr(info.getBysequence()));
				sbf_xml.append("</BYSEQUENCE>");
				sbf_xml.append("<PPSDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPpsdid()) ? "" : IGStringUtils.filterXMLStr(info.getPpsdid()));
				sbf_xml.append("</PPSDID>");
				sbf_xml.append("<PSDXML>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsdxml()) ? "" : info.getPsdxml());
				sbf_xml.append("</PSDXML>");
				sbf_xml.append("<BRANCHCOND>");
				sbf_xml.append(StringUtils.isEmpty(info.getBranchcond()) ? "" : IGStringUtils.filterXMLStr(info.getBranchcond()));
				sbf_xml.append("</BRANCHCOND>");
				sbf_xml.append("<REPLACEDISPOSE>");
				sbf_xml.append(StringUtils.isEmpty(info.getReplaceDispose()) ? "" : IGStringUtils.filterXMLStr(info.getReplaceDispose()));
				sbf_xml.append("</REPLACEDISPOSE>");
				sbf_xml.append("</DATA>");
			}
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG333>");
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
		List<IG333Info> lst_IG333 = new ArrayList<IG333Info>();
		IG333TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG333TBInstance();
			entity.setPsdid(e.getChildText("PSDID"));
			entity.setPdid(e.getChildText("PDID"));
			entity.setPsdname(e.getChildText("PSDNAME"));
			entity.setPsddesc(e.getChildText("PSDDESC"));
			entity.setPsdcode(e.getChildText("PSDCODE"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			entity.setPsdtype(e.getChildText("PSDTYPE"));
			entity.setPsdmode(e.getChildText("PSDMODE"));
			entity.setPsdflag(e.getChildText("PSDFLAG"));
			entity.setPsdassign(e.getChildText("PSDASSIGN"));
			entity.setPsdorg(e.getChildText("PSDORG"));
			entity.setPsdconfirm(e.getChildText("PSDCONFIRM"));
			entity.setAssignpsdid(e.getChildText("ASSIGNPSDID"));
			entity.setAssignpbdid(e.getChildText("ASSIGNPBDID"));
			entity.setAssignflag(e.getChildText("ASSIGNFLAG"));
			entity.setParticipantchange(e.getChildText("PARTICIPANTCHANGE"));
			entity.setFormGlobalControl(e.getChildText("FORMGLOBALCONTROL"));
			entity.setJsfunction(e.getChildText("JSFUNCTION"));
			entity.setAssignPageType(e.getChildText("ASSIGNPAGETYPE"));
			entity.setBysequence(e.getChildText("BYSEQUENCE"));
			entity.setPpsdid("".equals(e.getChildText("PPSDID"))?null:e.getChildText("PPSDID"));
			entity.setReplaceDispose(e.getChildText("REPLACEDISPOSE"));
			StringBuffer psdxml = new StringBuffer();
			if(e.getChild("PSDXML")!=null) {
				this.ig380BL.display(e.getChild("PSDXML").getChild("WebFlow"), psdxml);
			}
			if(psdxml.length() > 1) {
				entity.setPsdxml(psdxml.toString());
			}
			entity.setBranchcond(e.getChildText("BRANCHCOND"));
			lst_IG333.add(entity);
		}
		this.ig333DAO.saveOrUpdateAll(lst_IG333);
	}

}
