package com.deliverik.infogovernor.drm.dto;

import java.io.OutputStream;
import java.io.Serializable;
import java.util.Hashtable;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.apache.struts.util.LabelValueBean;

import com.deliverik.framework.base.BaseDTO;
import com.deliverik.framework.base.PagingDTO;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0118VWInfo;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.user.model.User;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.IG731Info;
import com.deliverik.infogovernor.drm.form.IGDRM0101Form;
import com.deliverik.infogovernor.drm.form.IGDRM0104Form;
import com.deliverik.infogovernor.drm.form.IGDRM0108Form;
import com.deliverik.infogovernor.drm.model.PlanInfo;
import com.deliverik.infogovernor.drm.model.ResponseStrategyInfo;
import com.deliverik.infogovernor.drm.util.FlowDetail;


/**
 * ��������������DTO
 * 
 */
@SuppressWarnings("serial")
public class IGDRM01DTO extends BaseDTO implements Serializable{

	/** ���������� */
	protected int maxSearchCount;

	/** ��ҳ��DTO */
	protected PagingDTO pagingDto;
	
	/** ���̶�����Ϣ��������� */
	protected List<IG380Info> processDefinitionList;
	
	protected IGDRM0108Form igdrm0108Form;

	/** ajax��� */
	protected String ajaxResult;

	/** ajax��� */
	private List<LabelValueBean> planTypeValues;
	
	/** ������Ϣ */
	protected PlanInfo planInfo;

	/** �����е�pdid */
	protected String pdid;

	/** �����html */
	protected String outPrintStr;

	/***
	 * Ӧ����Դ����
	 * */
	protected List<SOC0118VWInfo> zyList;

	/** ������Ӧ���Լ��� */
	protected List<ResponseStrategyInfo> responseStrategyList;

	protected ResponseStrategyInfo responseStrategyInfo;

	/**
	 * Ԥ�ڻָ�ʱ��
	 */
	protected String maxTime;
	/**
	 * ����л�������ť��ķ����ַ���
	 */
	protected String result;
	/**
	 * ������prid
	 */
	protected Integer prid;
	
	/** �ļ������ */
	protected OutputStream ops;
	
	/**������ϸ��Ϣ*/
	protected List<FlowDetail> parentStepList;
	
	public OutputStream getOps() {
		return ops;
	}

	public void setOps(OutputStream ops) {
		this.ops = ops;
	}

	/**  
	 * ��ȡmaxTime  
	 * @return maxTime 
	 */
	public String getMaxTime() {
		return maxTime;
	}

	/**  
	 * ����maxTime  
	 * @param maxTime
	 */
	
	public void setMaxTime(String maxTime) {
		this.maxTime = maxTime;
	}

	public Integer getPrid() {
		return prid;
	}

	public void setPrid(Integer prid) {
		this.prid = prid;
	}

	public List<SOC0118VWInfo> getZyList() {
		return zyList;
	}

	public void setZyList(List<SOC0118VWInfo> zyList) {
		this.zyList = zyList;
	}

	public String getOutPrintStr() {
		return outPrintStr;
	}

	public void setOutPrintStr(String outPrintStr) {
		this.outPrintStr = outPrintStr;
	}

	public String getPdid() {
		return pdid;
	}

	public void setPdid(String pdid) {
		this.pdid = pdid;
	}

	public PlanInfo getPlanInfo() {
		return planInfo;
	}

	public void setPlanInfo(PlanInfo planInfo) {
		this.planInfo = planInfo;
	}

	private List<SOC0117Info> entityList;

	public List<SOC0117Info> getEntityList() {
		return entityList;
	}

	public void setEntityList(List<SOC0117Info> entityList) {
		this.entityList = entityList;
	}

	/** �Ƿ���Ҫ��ʾ���� */
	private boolean countNum;

	public boolean isCountNum() {
		return countNum;
	}

	public void setCountNum(boolean countNum) {
		this.countNum = countNum;
	}

	/**
	 * */
	protected IGDRM0101Form igdrm0101Form ;
	

	public IGDRM0101Form getIgdrm0101Form() {
		return igdrm0101Form;
	}

	public void setIgdrm0101Form(IGDRM0101Form igdrm0101Form) {
		this.igdrm0101Form = igdrm0101Form;
	}

	
	/**
	 * ����������ȡ��
	 * @return maxSearchCount ����������
	 */
	public int getMaxSearchCount() {
		return maxSearchCount;
	}

	/**
	 * �����������趨
	 * @param maxSearchCount ����������
	 */
	public void setMaxSearchCount(int maxSearchCount) {
		this.maxSearchCount = maxSearchCount;
	}

	/**
	 * ��ҳ��DTOȡ��
	 * @return pagingDto ��ҳ��DTO
	 */
	public PagingDTO getPagingDto() {
		return pagingDto;
	}

	/**
	 * ��ҳ��DTO�趨
	 * @param pagingDto ��ҳ��DTO
	 */
	public void setPagingDto(PagingDTO pagingDto) {
		this.pagingDto = pagingDto;
	}

	/**
	 * ���̶�����Ϣ���������ȡ��
	 * @return processDefinitionList ���̶�����Ϣ���������
	 */
	public List<IG380Info> getProcessDefinitionList() {
		return processDefinitionList;
	}

	/**
	 * ���̶�����Ϣ����������趨
	 * @param processDefinitionList ���̶�����Ϣ���������
	 */
	public void setProcessDefinitionList(List<IG380Info> processDefinitionList) {
		this.processDefinitionList = processDefinitionList;
	}

	/**
	 * ajax���ȡ��
	 * @return ajaxResult ajax���
	 */
	public String getAjaxResult() {
		return ajaxResult;
	}

	/**
	 * ajax����趨
	 * @param ajaxResult ajax���
	 */
	public void setAjaxResult(String ajaxResult) {
		this.ajaxResult = ajaxResult;
	}

	public List<LabelValueBean> getPlanTypeValues() {
		return planTypeValues;
	}

	public void setPlanTypeValues(List<LabelValueBean> planTypeValues) {
		this.planTypeValues = planTypeValues;
	}
	
	private User loginUser;
	private Hashtable<String,TreeNode>  nodeMap;
	private List<PlanInfo> planList;
	private IGDRM0104Form igdrm0104Form;
	private Locale locale;
	
	public User getLoginUser() {
		return loginUser;
	}

	public void setLoginUser(User loginUser) {
		this.loginUser = loginUser;
	}

	public Hashtable<String, TreeNode> getNodeMap() {
		return nodeMap;
	}

	public void setNodeMap(Hashtable<String, TreeNode> nodeMap) {
		this.nodeMap = nodeMap;
	}

	public List<PlanInfo> getPlanList() {
		return planList;
	}

	public void setPlanList(List<PlanInfo> planList) {
		this.planList = planList;
	}

	public IGDRM0104Form getIgdrm0104Form() {
		return igdrm0104Form;
	}
	public void setIgdrm0104Form(IGDRM0104Form igdrm0104Form) {
		this.igdrm0104Form = igdrm0104Form;
	}
	public Locale getLocale() {
		return locale;
	}
	public void setLocale(Locale locale) {
		this.locale = locale;
	}

	public IGDRM0108Form getIgdrm0108Form() {
		return igdrm0108Form;
	}

	public void setIgdrm0108Form(IGDRM0108Form igdrm0108Form) {
		this.igdrm0108Form = igdrm0108Form;
	}
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
	public List<ResponseStrategyInfo> getResponseStrategyList() {
		return responseStrategyList;
	}

	public void setResponseStrategyList(List<ResponseStrategyInfo> responseStrategyList) {
		this.responseStrategyList = responseStrategyList;
	}

	public ResponseStrategyInfo getResponseStrategyInfo() {
		return responseStrategyInfo;
	}

	public void setResponseStrategyInfo(ResponseStrategyInfo responseStrategyInfo) {
		this.responseStrategyInfo = responseStrategyInfo;
	}

	public List<FlowDetail> getParentStepList() {
		return parentStepList;
	}

	public void setParentStepList(List<FlowDetail> parentStepList) {
		this.parentStepList = parentStepList;
	}


	
}