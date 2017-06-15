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
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.prd.model.IG725Info;
import com.deliverik.framework.workflow.prd.model.condition.IG725SearchCond;
import com.deliverik.framework.workflow.prd.model.condition.IG725SearchCondImpl;
import com.deliverik.framework.workflow.prd.model.dao.IG725DAO;
import com.deliverik.framework.workflow.prd.model.entity.IG725TB;

/**
  * 概述: 缺省参与者按钮定义表业务逻辑实现
  * 功能描述: 缺省参与者按钮定义表业务逻辑实现
  * 创建记录: 2012/04/18
  * 修改记录: 
  */
public class IG725BLImpl extends BaseBLImpl implements
		IG725BL {

	/** 缺省参与者按钮定义表DAO接口 */
	protected IG725DAO ig725DAO;
	
	/**
	 * 缺省参与者按钮定义表DAO接口设定
	 *
	 * @param ig725DAO 缺省参与者按钮定义表DAO接口
	 */
	public void setIg725DAO(IG725DAO ig725DAO) {
		this.ig725DAO = ig725DAO;
	}

	/**
	 * 缺省参与者按钮定义表实例取得
	 *
	 * @return 缺省参与者按钮定义表实例
	 */
	public IG725TB getIG725TBInstance() {
		return new IG725TB();
	}

	/**
	 * 全件检索
	 *
	 * @return 检索结果集
	 */
	public List<IG725Info> searchIG725Info() {
		return ig725DAO.findAll();
	}

	/**
	 * 主键检索处理
	 *
	 * @param pk 主键
	 * @return 检索结果
	 */
	public IG725Info searchIG725InfoByPK(String pk)
		throws BLException {
		return checkExistInstance(pk);
	}

	/**
	 * 条件检索结果件数取得
	 *
	 * @param cond 检索条件
	 * @return 检索结果件数
	 */
	public int getSearchCount(IG725SearchCond cond) {
		return ig725DAO.getSearchCount(cond);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @return 检索结果列表
	 */
	public List<IG725Info> searchIG725Info(
			IG725SearchCond cond) {
		return ig725DAO.findByCond(cond, 0, 0);
	}

	/**
	 * 条件检索处理
	 *
	 * @param cond 检索条件
	 * @param start 检索记录起始行号
	 * @param count 检索记录件数
	 * @return 检索结果列表
	 */
	public List<IG725Info> searchIG725Info(
			IG725SearchCond cond, int start,
			int count) {
		return ig725DAO.findByCond(cond, start, count);
	}

	/**
	 * 新增处理
	 *
	 * @param instance 新增实例
	 * @return 新增实例
	 */
	public IG725Info registIG725Info(IG725Info instance)
		throws BLException {
		return ig725DAO.save(instance);
	}

	/**
	 * 修改处理
	 *
	 * @param instance 修改实例
	 * @return 修改实例
	 */
	public IG725Info updateIG725Info(IG725Info instance)
		throws BLException {
		checkExistInstance(instance.getPdbdid());
		return ig725DAO.save(instance);
	}

	/**
	 * 删除处理
	 *
	 * @param pk 主键
	 */
	public void deleteIG725InfoByPK(String pk)
		throws BLException {
		ig725DAO.delete(checkExistInstance(pk));
	}

	/**
	 * 删除处理
	 *
	 * @param instance 删除实例
	 */
	public void deleteIG725Info(IG725Info instance)
		throws BLException {
		ig725DAO.delete(instance);
	}

	/**
	 * 实例存在检查处理
	 *
	 * @param pk 主键
	 * @return 实例
	 */
	public IG725Info checkExistInstance(String pk)
		throws BLException {
		IG725Info instance = ig725DAO.findByPK(pk);
		if (instance == null) {
			throw new BLException("IGCO10000.E004", "实例基本");
		}
		return instance;
	}
	
	/**
	 * PSDID主键值取得
	 * 
	 * @param 流程定义ID
	 * @return PSDID主键值
	 */
	public String getPdbdidSequenceNextValue(String psdid) {
		return ig725DAO.getPdbdidSequenceNextValue(psdid);
	}
	
	/**
	 * 新增确认按钮处理
	 *
	 * @param psdid 流程状态ID
	 */
	public void registConfirmButton(String psdid) throws BLException {
		IG725SearchCondImpl cond = new IG725SearchCondImpl();
		cond.setPsdid(psdid);
		cond.setPbdid(IGPRDCONSTANTS.BUTTON_CONFIRM);
		List<IG725Info> lst_pdbd = this.searchIG725Info(cond);
		if(lst_pdbd.isEmpty()) {
			IG725TB pdbd = this.getIG725TBInstance();
			pdbd.setPdbdid(this.getPdbdidSequenceNextValue(psdid));//主键
			pdbd.setPsdid(psdid);//状态ID
			pdbd.setPbdid(IGPRDCONSTANTS.BUTTON_CONFIRM);//按钮ID
			pdbd.setPdbdname("确认");//按钮名称
			pdbd.setPdbddesc("确认");//按钮描述
			pdbd.setPdbdauth(null);//提交权限
			this.registIG725Info(pdbd);
		}
	}
	
	/**
	 * 删除确认按钮处理
	 *
	 * @param psdid 流程状态ID
	 */
	public void deleteConfirmButton(String psdid) throws BLException {
		IG725SearchCondImpl cond = new IG725SearchCondImpl();
		cond.setPsdid(psdid);
		cond.setPbdid(IGPRDCONSTANTS.BUTTON_CONFIRM);
		List<IG725Info> lst_pdbd = this.searchIG725Info(cond);
		for(IG725Info pdbd : lst_pdbd) {
			this.deleteIG725Info(pdbd);
		}
	}
	
	/**
	 * XML脚本导出处理
	 *
	 * @param pdid 流程定义ID
	 * @return XML脚本
	 */
	public StringBuffer exportXML(String pdid) throws BLException {
		IG725SearchCondImpl cond = new IG725SearchCondImpl();
		cond.setPdbdid_like(pdid);
		List<IG725Info> lst_IG725Info = this.searchIG725Info(cond);
		StringBuffer sbf_xml = new StringBuffer("");
		sbf_xml.append("<IG725>");
		sbf_xml.append("<DATALIST>");
		if(lst_IG725Info != null) {
			for(IG725Info info : lst_IG725Info) {
				sbf_xml.append("<DATA>");
				sbf_xml.append("<PDBDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPdbdid()) ? "" : IGStringUtils.filterXMLStr(info.getPdbdid()));
				sbf_xml.append("</PDBDID>");
				sbf_xml.append("<PSDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPsdid()) ? "" : IGStringUtils.filterXMLStr(info.getPsdid()));
				sbf_xml.append("</PSDID>");
				sbf_xml.append("<PBDID>");
				sbf_xml.append(StringUtils.isEmpty(info.getPbdid()) ? "" : IGStringUtils.filterXMLStr(info.getPbdid()));
				sbf_xml.append("</PBDID>");
				sbf_xml.append("<PDBDNAME>");
				sbf_xml.append(StringUtils.isEmpty(info.getPdbdname()) ? "" : IGStringUtils.filterXMLStr(info.getPdbdname()));
				sbf_xml.append("</PDBDNAME>");
				sbf_xml.append("<PDBDDESC>");
				sbf_xml.append(StringUtils.isEmpty(info.getPdbddesc()) ? "" : IGStringUtils.filterXMLStr(info.getPdbddesc()));
				sbf_xml.append("</PDBDDESC>");
				sbf_xml.append("<PDBDAUTH>");
				sbf_xml.append(StringUtils.isEmpty(info.getPdbdauth()) ? "" : IGStringUtils.filterXMLStr(info.getPdbdauth()));
				sbf_xml.append("</PDBDAUTH>");
				sbf_xml.append("<CHECKREQUIRED>");
				sbf_xml.append(StringUtils.isEmpty(info.getCheckrequired()) ? "" : IGStringUtils.filterXMLStr(info.getCheckrequired()));
				sbf_xml.append("</CHECKREQUIRED>");
				sbf_xml.append("<CHECKRECORD>");
				sbf_xml.append(StringUtils.isEmpty(info.getCheckrecord()) ? "" : IGStringUtils.filterXMLStr(info.getCheckrecord()));
				sbf_xml.append("</CHECKRECORD>");
				sbf_xml.append("<ACTURL>");
				sbf_xml.append(StringUtils.isEmpty(info.getActurl()) ? "" : IGStringUtils.filterXMLStr(info.getActurl()));
				sbf_xml.append("</ACTURL>");
				sbf_xml.append("<FINGERPRINT>");
				sbf_xml.append(StringUtils.isEmpty(info.getFingerPrint()) ? "" : IGStringUtils.filterXMLStr(info.getFingerPrint()));
				sbf_xml.append("</FINGERPRINT>");
				sbf_xml.append("</DATA>");
			}
		}
		sbf_xml.append("</DATALIST>");
		sbf_xml.append("</IG725>");
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
		List<IG725Info> lst_IG725 = new ArrayList<IG725Info>();
		IG725TB entity = null;
		for(Element e : dataList) {
			entity = this.getIG725TBInstance();
			entity.setPdbdid(e.getChildText("PDBDID"));
			entity.setPsdid(e.getChildText("PSDID"));
			entity.setPbdid(e.getChildText("PBDID"));
			entity.setPdbdname(e.getChildText("PDBDNAME"));
			entity.setPdbddesc(e.getChildText("PDBDDESC"));
			entity.setPdbdauth(e.getChildText("PDBDAUTH"));
			entity.setCheckrequired(e.getChildText("CHECKREQUIRED"));
			entity.setCheckrecord(e.getChildText("CHECKRECORD"));
			entity.setActurl(e.getChildText("ACTURL"));
			entity.setFingerPrint(e.getChildText("FINGERPRINT"));
			lst_IG725.add(entity);
		}
		this.ig725DAO.saveOrUpdateAll(lst_IG725);
	}
}