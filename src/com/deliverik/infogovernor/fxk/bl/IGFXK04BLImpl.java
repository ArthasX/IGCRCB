/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.fxk.bl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.CodeDetailDefBL;
import com.deliverik.framework.igflow.api.FlowSearchBL;
import com.deliverik.framework.igflow.resultset.ProcessInfoEntityInfo;
import com.deliverik.framework.model.CodeDetailDef;
import com.deliverik.framework.model.condition.CodeDetailDefSearchCondImpl;
import com.deliverik.framework.soc.asset.bl.task.SOC0117BL;
import com.deliverik.framework.soc.asset.bl.task.SOC0118BL;
import com.deliverik.framework.soc.asset.model.SOC0117Info;
import com.deliverik.framework.soc.asset.model.SOC0118Info;
import com.deliverik.framework.soc.asset.model.SOC0124Info;
import com.deliverik.framework.soc.asset.model.condition.SOC0117SearchCondImpl;
import com.deliverik.framework.soc.asset.model.condition.SOC0124SearchCondImpl;
import com.deliverik.framework.tree.TreeNode;
import com.deliverik.framework.workflow.WorkFlowOperationBL;
import com.deliverik.infogovernor.fxk.dto.IGFXK04DTO;
import com.deliverik.infogovernor.fxk.form.IGFXK0401Form;
import com.google.gson.Gson;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ��������BLʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGFXK04BLImpl extends BaseBLImpl implements IGFXK04BL{
	
	/** ��־���� */
	private static final Log log = LogFactory.getLog(IGFXK04BLImpl.class);
	
	/** �ʲ�ģ��BL */
	protected SOC0117BL soc0117BL;
	
	/** �ʲ�ʵ��BL */
	protected SOC0118BL soc0118BL;
	
	/** ������ϸ��ϢBL */
	protected CodeDetailDefBL codeDetailDefBL;
	
	/** ���̴���BL */
	protected WorkFlowOperationBL workFlowOperationBL;
	
	/** ��ѯ��API */
	protected FlowSearchBL flowSearchBL;

	/**
	 * �ʲ�ģ��BL�趨
	 * @param soc0117BL �ʲ�ģ��BL
	 */
	public void setSoc0117BL(SOC0117BL soc0117bl) {
		soc0117BL = soc0117bl;
	}

	/**
	 * �ʲ�ʵ��BL�趨
	 * @param soc0118BL �ʲ�ʵ��BL
	 */
	public void setSoc0118BL(SOC0118BL soc0118bl) {
		soc0118BL = soc0118bl;
	}

	/**
	 * ������ϸ��ϢBL�趨
	 * @param codeDetailDefBL ������ϸ��ϢBL
	 */
	public void setCodeDetailDefBL(CodeDetailDefBL codeDetailDefBL) {
		this.codeDetailDefBL = codeDetailDefBL;
	}

	/**
	 * ���̴���BL�趨
	 * @param workFlowOperationBL ���̴���BL
	 */
	public void setWorkFlowOperationBL(WorkFlowOperationBL workFlowOperationBL) {
		this.workFlowOperationBL = workFlowOperationBL;
	}

	/**
	 * ��ѯ��API�趨
	 * @param flowSearchBL ��ѯ��API
	 */
	public void setFlowSearchBL(FlowSearchBL flowSearchBL) {
		this.flowSearchBL = flowSearchBL;
	}

	/**
	 * ģ������ѯ
	 * @param dto
	 * @return
	 */
	public IGFXK04DTO searchAsmModelTree(IGFXK04DTO dto) throws BLException {
		log.debug("=============ģ������ѯ������ʼ==============");
		//�ʲ�һ��ģ��
		String subtype = null;
		//dto����ȡ��
		if(dto.getForm() instanceof IGFXK0401Form){
			IGFXK0401Form form = (IGFXK0401Form) dto.getForm();
			subtype = form.getSubtype();
		}
		//ģ������
		Map<String,TreeNode> treeNodeMap=new LinkedHashMap<String,TreeNode>();
		//ʵ����ģ�Ͳ�ѯ����
		SOC0117SearchCondImpl soc0117cond=new SOC0117SearchCondImpl();
		soc0117cond.setSyscoding_q(subtype);
		soc0117cond.setEstatus("1");
		List<SOC0117Info> ret = soc0117BL.searchEntity(soc0117cond,0,0);
		TreeNode ptNode = new TreeNode();
		ptNode.setId(ret.get(0).getEid()+"_"+ret.get(0).getEsyscoding()+"_"+ret.get(0).getEcategory());
		ptNode.setName(ret.get(0).getEname());
		//��Ӻ��ӽ��
		int nowlen = ret.get(0).getEsyscoding().length();
		getAssetChildTree(ret,ptNode,nowlen,subtype);
		treeNodeMap.put(ptNode.getId(),ptNode);
		dto.setTreeNodeMap(treeNodeMap);
		log.debug("=============ģ������ѯ��������==============");
		return dto;
	}
	
	/**
	 * ģ������ѯZTree
	 * @param dto
	 * @return
	 */
	public String searchAsmModelZTree(IGFXK04DTO dto) throws BLException {
		log.debug("=============ģ������ѯ������ʼ==============");
		//�ʲ�һ��ģ��
		String subtype = null;
		//dto����ȡ��
		if(dto.getForm() instanceof IGFXK0401Form){
			IGFXK0401Form form = (IGFXK0401Form) dto.getForm();
			subtype = form.getSubtype();
		}
		//ģ������
		//ʵ����ģ�Ͳ�ѯ����
		SOC0117SearchCondImpl soc0117cond=new SOC0117SearchCondImpl();
		soc0117cond.setSyscoding_q(subtype);
		soc0117cond.setEstatus("1");
		List<SOC0117Info> ret = soc0117BL.searchEntity(soc0117cond,0,0);
		List<HashMap<String,Object>> list = new ArrayList<HashMap<String,Object>>(); 
		for (SOC0117Info soc0117Info : ret) {
			HashMap<String,Object> hm = new HashMap<String,Object>();
			hm.put("id", soc0117Info.getEsyscoding());	// id����  �����ݴ��� 
			if("999".equals(soc0117Info.getEparcoding())){
				hm.put("name", "�������"); 					// name���ԣ���һ���̶���ʾ"�������"
			}else{
				hm.put("name", soc0117Info.getEname()); 	// name���ԣ���ʾ�ڵ�����    
			}
            hm.put("pId", soc0117Info.getEparcoding());
            if(soc0117Info.getEparcoding().length()==6){
//            	hm.put("checked", "true");
                hm.put("open", "true"); 
            }
            list.add(hm);  
	}
		Gson gson = new Gson();
		String json = gson.toJson(list);
		log.debug("=============ģ������ѯ��������==============");
		return json;
	}
	
	/**
	 * <p>
	 * ��ѯ�ӽ��
	 * </p>
	 * @param ȫ���Ľ��LIST
	 * @param �ü������ϼ����
	 * @param �ü������ϼ�����syscoding�ĳ���
	 * @author duchong@deliverik.com
	 */
	private void getAssetChildTree(List<SOC0117Info> ret,TreeNode ptNode,int ptlen,String syscoding){
		List<SOC0117Info> nextret = getAssetNextLevelNodesOne(ret,ptlen,syscoding);//ȡ�øü�����LIST
		for(int i=0,j=nextret.size();i<j;i++){
			String syscode = nextret.get(i).getEsyscoding();
			
			TreeNode pdNode = new TreeNode();
			pdNode.setId(nextret.get(i).getEid()+"_"+nextret.get(i).getEsyscoding()+"_"+nextret.get(i).getEcategory());
			pdNode.setName(nextret.get(i).getEname());
			getAssetChildTree(ret,pdNode,syscode.length(),syscode);
			ptNode.addChildTreeNode(pdNode.getId(),pdNode);
		}
	}
	
	/**
	 * <p>
	 * ȡ��һlevel�Ľ�㼯��
	 * </p>
	 * @param ȫ���Ľ��LIST
	 * @param ��ǰ����len
	 * @param ��ǰ����syscode
	 * @throws BLException
	 * @author duchong@deliverik.com
	 */
	private List<SOC0117Info> getAssetNextLevelNodesOne(List<SOC0117Info> ret,int levellen,String syscode) {
		
		List<SOC0117Info> entitylist = new ArrayList<SOC0117Info>();
		for(int i=0,j=ret.size();i<j;i++){
			String syscoding = ret.get(i).getEsyscoding();
			if(syscoding.length()==(levellen+3) && (syscoding.substring(0,syscoding.length()-3)).equals(syscode)){
				entitylist.add(ret.get(i));
			}
			
		}
		
		return entitylist;
	}
	
	/**
	 * ���յ��ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGFXK04DTO searchAsm013Action(IGFXK04DTO dto) throws BLException {
		log.debug("=============���յ��ѯ������ʼ============");
		String ajaxResult = "";
		List<List<Map<String, String>>> dataList = new ArrayList<List<Map<String,String>>>();
		if(dto.getForm() instanceof IGFXK0401Form){
			//dto����ȡ��
			IGFXK0401Form form = (IGFXK0401Form) dto.getForm();
			String[] esyscodings = form.getEsyscoding().split("_");
			for (String esyscoding : esyscodings) {
				if(StringUtils.isNotEmpty(esyscoding)){
					dto.setEsyscoding(esyscoding);
					//��ѯ���յ���Ϣ
					dto = searchAsmAction(dto);
					List<SOC0124Info> list = dto.getEntityItemVWInfoList();
					if(list != null && list.size() > 0){
						List<Map<String, String>> tempList = new ArrayList<Map<String,String>>();
						for(SOC0124Info info:list){
							Map<String, String> map = new HashMap<String, String>();
							map.put("eiid", info.getEiid() + "");
							map.put("eiversion", info.getEiversion() + "");
							map.put("einame", info.getEiname());
							tempList.add(map);
						}
						dataList.add(tempList);
					}
				}
			}
		}
		Gson gson = new Gson();
		ajaxResult = gson.toJson(dataList);
		dto.setAjaxResult(ajaxResult);
		log.debug("=============���յ��ѯ��������============");
		return dto;
	}
	
	/**
	 * ������ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGFXK04DTO searchAsm014Action(IGFXK04DTO dto) throws BLException {
		log.debug("==============������ѯ������ʼ=============");
		String ajaxResult = "";
		List<List<Map<String, String>>> dataList = new ArrayList<List<Map<String, String>>>();
		if (dto.getForm() instanceof IGFXK0401Form) {
			// dto����ȡ��
			IGFXK0401Form form = (IGFXK0401Form) dto.getForm();
			String[] esyscodings = form.getEsyscoding().split("_");
			for (String esyscoding : esyscodings) {
				if (StringUtils.isNotEmpty(esyscoding)) {
					// ��ѯ��ϵ����
					CodeDetailDefSearchCondImpl cond = new CodeDetailDefSearchCondImpl();
					cond.setCcid("293");
					cond.setSyscoding(esyscoding);
					List<CodeDetailDef> codeList = codeDetailDefBL
							.searchCodeDetailDef(cond);
					for (CodeDetailDef code : codeList) {
						if (esyscoding.equals(code.getSyscoding())) {
							dto.setEsyscoding(code.getPsyscoding());
							break;
						}
					}
					// ��ѯ���յ���Ϣ
					dto = searchAsmAction(dto);
					List<SOC0124Info> list = dto.getEntityItemVWInfoList();
					if (list != null && list.size() > 0) {
						List<Map<String, String>> tempList = new ArrayList<Map<String, String>>();
						for (SOC0124Info info : list) {
							Map<String, String> map = new HashMap<String, String>();
							map.put("eiid", info.getEiid() + "");
							map.put("eiversion", info.getEiversion() + "");
							map.put("einame", info.getEiname());
							tempList.add(map);
						}
						dataList.add(tempList);
					}
				}

			}
		}
		Gson gson = new Gson();
		ajaxResult = gson.toJson(dataList);
		dto.setAjaxResult(ajaxResult);
		log.debug("==============������ѯ��������=============");
		return dto;
	}

	/**
	 * �ʲ���Ϣ��ѯ
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	private IGFXK04DTO searchAsmAction(IGFXK04DTO dto) throws BLException{
		log.debug("===============�ʲ���Ϣ��ѯ������ʼ================");
		if(StringUtils.isNotEmpty(dto.getEsyscoding())){
			//ʵ������ѯ����
			SOC0124SearchCondImpl cond = new SOC0124SearchCondImpl();
			cond.setEsyscoding(dto.getEsyscoding());
			List<SOC0124Info> entityItemVWInfoList = soc0118BL.searchEntityItemVW(cond, 0,0);
			dto.setEntityItemVWInfoList(entityItemVWInfoList);
		}
		log.debug("===============�ʲ���Ϣ��ѯ��������================");
		return dto;
	}
	
	/**
	 * ��ѯ��ط����嵥
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGFXK04DTO getRelationProcess(IGFXK04DTO dto) throws BLException {
		log.debug("===============��ط����嵥��ѯ������ʼ===============");
		if(dto.getForm() instanceof IGFXK0401Form){
			IGFXK0401Form form = (IGFXK0401Form) dto.getForm();
			Integer prid = form.getPrid();
			List<Map<String, String>> dataList = new ArrayList<Map<String,String>>();
			List<ProcessInfoEntityInfo> list = flowSearchBL.searchProcessEntityItem(prid, "��ط����¼�");
			if(list != null){
				for(ProcessInfoEntityInfo info:list){
					SOC0118Info sj = soc0118BL.searchEntityItemByKey(info.getEiversion());
					Map<String, String> map = new HashMap<String, String>();
					map.put("eiid", info.getEiid() + "");
					map.put("eiversion", info.getEiversion() + "");
					map.put("einame", sj.getEiname());
					dataList.add(map);
				}
			}
			Gson gson = new Gson();
			dto.setAjaxResult(gson.toJson(dataList));
		}
		log.debug("===============��ط����嵥��ѯ������ʼ===============");
		return dto;
	}
}
