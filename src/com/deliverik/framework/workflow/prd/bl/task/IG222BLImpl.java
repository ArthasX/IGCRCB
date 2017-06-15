/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
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
 * <p>����:����Action����Action</p>
 * <p>����������1.���������������ȡ��</p>
 * <p>          2.������������</p>
 * <p>          3.ȫ����������</p>
 * <p>          4.������������</p>
 * <p>          5.��¼����</p>
 * <p>          6.�����̲���������ɾ������</p>
 * <p>          7.ɾ������</p>
 * <p>          8.�������</p>
 * <p>          9.���̲����ߴ��ڼ��</p>
 * <p>          10.��ȡָ���û����еķ������̵Ľ�ɫ</p>
 * <p>          11.��ȡ�������̵Ľ�ɫ(��ά�ƻ���)</p>
 * <p>������¼��
 */
public class IG222BLImpl extends BaseBLImpl implements IG222BL {

	/** IG222 DAO */
	protected IG222DAO ig222DAO;
	
	/**
	 * ���̲����߶���DAO
	 * 
	 * @param ig222DAO ���̲����߶���DAO
	 */
	public void setIg222DAO(
			IG222DAO ig222DAO) {
		this.ig222DAO = ig222DAO;
	}

	/**
	 * ���ܣ���ȡ���̲����߶���ʵ��
	 * @return IG222TB
	 */
	
	public IG222TB getIG222TBInstance(){
		return new IG222TB();
	}

	/**
	 * ���ܣ����������������ȡ��
	 * 
	 * @param cond ��������
	 * @return ���������������
	 */
	public int getIG222InfoSearchCount(IG222SearchCond cond){
		
		return ig222DAO.getSearchCount(cond);
	}

	/**
	 * ���ܣ�������������
	 * 
	 * @param ppdid ���̲�����ID
	 * @return ���̲�������Ϣ
	 * @throws BLException 
	 */
	public IG222Info searchIG222InfoByKey(String ppdid) throws BLException  {
		
		return checkExistIG222Info(ppdid);
	}
	
	/**
	 * ���ܣ�ȫ����������
	 *
	 * @return ȫ�����̲�������Ϣ
	 */
	public List<IG222Info> searchIG222Info(IG222SearchCond cond){
		
		List<IG222Info> ret = ig222DAO.findByCond(cond,0,0);
		return ret;
	}

	/**
	 * ���ܣ�������������
	 * 
	 * @param cond ��������
	 * @param start ������¼��ʼ�к�
	 * @param count ������¼����
	 * @return ��������б�
	 */
	public List<IG222Info> searchIG222Info(IG222SearchCond cond, int start, int count){
		
		List<IG222Info> ret = ig222DAO.findByCond(cond,start,count);
		return ret;
	}

	/**
	 * ���ܣ���¼����
	 * 
	 * @param IG222 ��¼����
	 * @return ���̲�������Ϣ
	 * @throws BLException 
	 */
	public IG222Info registIG222Info(IG222Info processParticipantDef) throws BLException{
		
		return ig222DAO.save(processParticipantDef);
	}

	/**
	 * ���ܣ������̲���������ɾ������
	 * 
	 * @param ppdid ɾ���������̲���������
	 * @throws BLException 
	 */
	public IG222Info deleteIG222Info(String ppdid) throws BLException{

		IG222Info processParticipantDef = checkExistIG222Info(ppdid);
		
		ig222DAO.delete(processParticipantDef);
		
		return processParticipantDef;
	}
	
	/**
	 * ���ܣ�ɾ������
	 * 
	 * @param IG222 ���̲�����
	 * @throws BLException 
	 */
	public void deleteIG222Info(IG222Info processParticipantDef) throws BLException{
		IG222Info ppd = checkExistIG222Info(processParticipantDef.getPpdid());
		
		ig222DAO.delete(ppd);
	}

	/**
	 * ���ܣ��������
	 * 
	 * @param IG222 �������
	 * @return ���̲�������Ϣ
	 * @throws BLException 
	 */
	public IG222Info updateIG222Info(IG222Info processParticipantDef) throws BLException{
		
		checkExistIG222Info(processParticipantDef.getPpdid());
		
		return ig222DAO.save(processParticipantDef);
	}
	
	/**
	 * ���ܣ����̲����ߴ��ڼ��
	 * 
	 * @param ppdid ���̲�����ID
	 * @return ���̲�������Ϣ
	 * @throws BLException 
	 */
	protected IG222Info checkExistIG222Info(String ppdid) throws BLException{
		IG222Info info = ig222DAO.findByPK(ppdid);
		if( info == null) {
			throw new BLException("IGCO10000.E004","���̲����߻���");
		}
		return info;
	}
	
	/**
	 * ���ܣ���ȡָ���û����еķ������̵Ľ�ɫ
	 * @param userid �û�ID
	 * @param pdid ���̶���ID
	 * @return �����ɫ�����б�
	 */
	public List<LabelValueBean> searchInitProcessParticipantRole(String userid, String pdid){
		return ig222DAO.searchInitProcessParticipantRole(userid, pdid);
	}
	
	/**
	 * ���ܣ���ȡ�������̵Ľ�ɫ
	 * @param userid �û�ID
	 * @param pdid ���̶���ID
	 * @return �����ɫ�����б�
	 */
	public List<LabelValueBean> searchInitProcessParticipantRoleAll(String pdid){
		return ig222DAO.searchInitProcessParticipantRoleAll(pdid);
	}
	
	/**
	 * ���ܣ�ȫ����������
	 *
	 * @return ȫ�����̲�������Ϣ
	 */
	public List<IG222Info> searchIG222InfoAll(){
		return ig222DAO.findAll();
	}
	
	/**
	 * PPDID����ֵȡ��
	 * 
	 * @param ����״̬ID
	 * @return PPDID����ֵ
	 */
	public String getPpdidSequenceNextValue(String psdid) {
		return ig222DAO.getPpdidSequenceNextValue(psdid);
	}
	
	/**
	 * �����߿��Ӱ�ť��ѯ
	 * 
	 * @param psdid ״̬ID
	 * @param roleid ��ɫID
	 * @return ���Ӱ�ť�б�
	 */
	public List<IG309Info> searchVisibleButton(String psdid, Integer roleid) {
		List<IG309Info> lst_button = ig222DAO.searchVisibleButton(psdid, roleid);
		List<IG309Info> lst_defaultbutton = ig222DAO.searchDefaultVisibleButton(psdid);
		if(lst_button.isEmpty()) {
			return lst_defaultbutton;
		} else {
			//�����Ƿ���ȷ�ϰ�ť
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
	 * ͬ��ɫ�������ύԾǨ��ť��ѯ����ͨȨ�ޣ�
	 * 
	 * @param psdid ״̬ID
	 * @return ��ť�б�
	 */
	public Map<String, String> searchRoleCommitNormalAuth(String psdid){
		return ig222DAO.searchRoleCommitNormalAuth(psdid);
	}
	
	/**
	 * ͬ��ɫ�������ύԾǨ��ť��ѯ��ȱʡȨ�ޣ�
	 * 
	 * @param psdid ״̬ID
	 * @return ��ť�б�
	 */
	public List<String> searchRoleCommitDefaultAuth(String psdid){
		return ig222DAO.searchRoleCommitDefaultAuth(psdid);
	}
	
	/**
	 * ȫ����������
	 *
	 * @return ȫ�����̲�������Ϣ
	 */
	public List<IG222Info> searchIG222InfoRun(IG222SearchCond cond){
		
		List<IG222Info> ret = ig222DAO.findByCondRun(cond);
		return ret;
	}
	
	/**
	 * XML�ű���������
	 *
	 * @param pdid ���̶���ID
	 * @return XML�ű�
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
	 * XML�ű����봦��
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
