/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * <p>����:����״̬����ҵ���߼�ʵ��</p>
 * <p>����������1.���������������ȡ��</p>
 * <p>          2.������������</p>
 * <p>          3.������������</p>
 * <p>          4.ȫ����������</p>
 * <p>          5.��������</p>
 * <p>          6.ɾ������</p>
 * <p>          7.�������</p>
 * <p>          8.����״̬������Ϣ���ڼ��</p>
 * <p>          9.����״̬code��ȡָ���������͵�״̬ID</p>
 * <p>������¼��
 */
public class IG333BLImpl extends BaseBLImpl implements IG333BL {
	
	/** ����״̬����DAO���� */
	protected IG333DAO ig333DAO;
	
	/** ���̶���BL���� */
	protected IG380BL ig380BL;

	/**
	 * ����״̬����DAO
	 * 
	 * @param ig333DAO ����״̬����DAO
	 */
	public void setIg333DAO(
			IG333DAO ig333DAO) {
		this.ig333DAO = ig333DAO;
	}
	
	/**
	 * ���̶���BL����
	 * @param ig380BL ���̶���BL����
	 */
	public void setIg380BL(IG380BL ig380BL) {
		this.ig380BL = ig380BL;
	}

	/**
	 * ���ܣ����������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getIG333InfoSearchCount(IG333SearchCond cond) {
		return ig333DAO.getSearchCount(cond);
	}

	/**
	 * ���ܣ�������������
	 * 
	 * @param psdid ����״̬����ID
	 * @return ����״̬������Ϣ
	 * @throws BLException 
	 */
	
	public IG333Info searchIG333InfoByKey(String psdid) throws BLException {
		return checkExistIG333Info(psdid);
	}

	/**
	 * ���ܣ�������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	
	public List<IG333Info> searchIG333Info(
			IG333SearchCond cond, int start, int count) {
		return ig333DAO.findByCond(cond, start, count);
	}
	
	/**
	 * ���ܣ�������������
	 * 
	 * @param cond ��������
	 * @return ��������б�
	 */
	
	public List<IG333Info> searchIG333Info(IG333SearchCond cond){
		return ig333DAO.findByCond(cond, 0, 0);
	}
	
	/**
	 * ���ܣ�ȫ����������
	 * 
	 * @return ��������б�
	 */
	
	public List<IG333Info> searchIG333InfoAll() {
		return ig333DAO.findAll();
	}

	/**
	 * ���ܣ���������
	 * 
	 * @param IG333Info ��������
	 * @return �ʲ���Ϣ
	 */
	
	public IG333Info registIG333Info(
			IG333Info ig333Info) throws BLException {
		return ig333DAO.save(ig333Info);
	}

	/**
	 * ���ܣ�ɾ������
	 * 
	 * @param psdid ɾ������״̬��������
	 * @throws BLException 
	 */
	
	public void deleteIG333InfoByKey(String psdid) throws BLException {
		IG333Info processStatusDef = checkExistIG333Info(psdid);
		ig333DAO.delete(processStatusDef);
	}

	/**
	 * ���ܣ��������
	 * 
	 * @param ig333Info �������
	 * @return ����״̬����
	 * @throws BLException 
	 */
	
	public IG333Info updateIG333Info(
			IG333Info ig333Info) throws BLException {
		return ig333DAO.save(ig333Info);
	}
	
	/**
	 * ���ܣ�����״̬������Ϣ���ڼ��
	 * 
	 * @param psdid ����״̬����ID
	 * @return ����״̬����
	 * @throws BLException 
	 */
	
	protected IG333Info checkExistIG333Info(String psdid) throws BLException{
		IG333Info info = ig333DAO.findByPK(psdid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","����״̬�������");
		}
		return info;
	}
	
	/**
	 * ���ܣ�����״̬������Ϣʵ��
	 * 
	 * @return ����״̬������Ϣ
	 */
	
	public IG333TB getIG333TBInstance() {
		return new IG333TB();
	}
	
	/**
	 * ���ܣ�����״̬code��ȡָ���������͵�״̬ID
	 * 
	 * @param pdid ���̶���ID
	 * @param psdcode ����״̬��ʶ
	 * @return ����״̬ID
	 * @throws BLException 
	 */
	public String getIG333InfoIdByStatus(String pdid, String psdcode) throws BLException {
		if(StringUtils.isEmpty(pdid)) {
			throw new BLException("IGCO10000.E004","���̶������");
		}
		if(StringUtils.isEmpty(psdcode)) {
			throw new BLException("IGCO10000.E004","����״̬�������");
		}
		IG333SearchCondImpl cond = new IG333SearchCondImpl();
		cond.setPdid(pdid);
		cond.setPsdcode(psdcode);
		List<IG333Info> psdList = ig333DAO.findByCond(cond, 0, 0);
		if(psdList.size() != 1) {
			throw new BLException("IGCO10000.E004","����״̬�������");
		} else {
			return psdList.get(0).getPsdid();
		}
	}
	
	/**
	 * PSDID����ֵȡ��
	 * 
	 * @param ���̶���ID
	 * @return PSDID����ֵ
	 */
	public String getPsdidSequenceNextValue(String pdid) {
		return ig333DAO.getPsdidSequenceNextValue(pdid);
	}
	
	/**
	 * ���ݷ���״̬�ͷ��ɰ�ť��ѯ�����ɽڵ㼯��
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
	 * ָ��״̬�����Ŀɵ��������ߵ�״̬����ȡ��
	 *
	 * @param psdid ״̬ID
	 * @return ״̬����
	 */
	public List<IG333Info> searchAdjustStatus(String psdid) {
		return ig333DAO.searchAdjustStatus(psdid);
	}
	
	/**
	 * XML�ű���������
	 *
	 * @param pdid ���̶���ID
	 * @return XML�ű�
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
	 * XML�ű����봦��
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
