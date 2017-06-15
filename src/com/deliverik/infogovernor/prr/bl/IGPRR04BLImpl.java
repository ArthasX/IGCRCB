/*
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 */
package com.deliverik.infogovernor.prr.bl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.axis.utils.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.deliverik.framework.base.BLException;
import com.deliverik.framework.base.BaseBLImpl;
import com.deliverik.framework.bl.CodeDetailDefBL;
import com.deliverik.framework.model.CodeDetailDef;
import com.deliverik.framework.model.condition.CodeDetailDefSearchCondImpl;
import com.deliverik.framework.utility.CommonDefineUtils;
import com.deliverik.framework.workflow.IGPRDCONSTANTS;
import com.deliverik.framework.workflow.WorkFlowDefinitionBL;
import com.deliverik.framework.workflow.prd.bl.task.IG380BL;
import com.deliverik.framework.workflow.prd.model.IG380Info;
import com.deliverik.framework.workflow.prd.model.condition.IG380SearchCondImpl;
import com.deliverik.infogovernor.prr.dto.IGPRR04DTO;
import com.deliverik.infogovernor.prr.form.IGPRR0402Form;

/**
 * <p>
 * Title : InfoGovernor ��Ϣ�������ƽ̨
 * </p>
 * <p>
 * Description: ���̷���Ŀ¼BLʵ��
 * </p>
 * 
 * @author wangtingzhi@deliverik.com
 * @version 1.0
 */
public class IGPRR04BLImpl extends BaseBLImpl implements IGPRR04BL {
	
	/** ��־����ȡ�� */
	private static Log log = LogFactory.getLog(IGPRR04BLImpl.class);
	
	/** ���̶���BL */
	protected WorkFlowDefinitionBL workFlowDefinitionBL;
	
	/** ������ϸ��ϢBL */
	protected CodeDetailDefBL codeDetailDefBL;
	
	/** ���̶���BL */
	protected IG380BL ig380BL;

	/**
	 * ���̶���BL�趨
	 * @param workFlowDefinitionBL ���̶���BL
	 */
	public void setWorkFlowDefinitionBL(WorkFlowDefinitionBL workFlowDefinitionBL) {
		this.workFlowDefinitionBL = workFlowDefinitionBL;
	}
	
	/**
	 * ������ϸ��ϢBL�趨
	 * @param codeDetailDefBL ������ϸ��ϢBL
	 */
	public void setCodeDetailDefBL(CodeDetailDefBL codeDetailDefBL) {
		this.codeDetailDefBL = codeDetailDefBL;
	}
	
	/**
	 * ���̶���BL�趨
	 * @param ig380BL ���̶���BL
	 */
	public void setIg380BL(IG380BL ig380bl) {
		ig380BL = ig380bl;
	}

	/**
	 * ��ʼ������Ŀ¼��ʾҳ��
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR04DTO initServiceCatelogAction(IGPRR04DTO dto) throws BLException{
		log.debug("===========����Ŀ¼ҳ���ʼ��������ʼ=============");
		//��ѯ��������
		IG380SearchCondImpl pdcond = new IG380SearchCondImpl();
		List<IG380Info> pdList = workFlowDefinitionBL.searchLastProcessDefinition(pdcond,0,0);
		//��ѯ����Ŀ¼һ������
		CodeDetailDefSearchCondImpl cdcond = new CodeDetailDefSearchCondImpl();
		cdcond.setCcid(IGPRR04BLType.SERVICE_CATALOG_FIRST_CLASSIFY_CCID);
		List<CodeDetailDef> first = codeDetailDefBL.searchCodeDetailDef(cdcond,CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_0);
		//��ѯ����Ŀ¼��������
		cdcond.setCcid(IGPRR04BLType.SERVICE_CATALOG_SECOND_CLASSIFY_CCID);
		List<CodeDetailDef> second = codeDetailDefBL.searchCodeDetailDef(cdcond,CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_0);
		//�������̶�����Ϣ
		Map<String, List<IG380Info>> pdMap = new LinkedHashMap<String, List<IG380Info>>();
		for(IG380Info pd:pdList){
			if(pdMap.get(pd.getPdservicecatalog()) == null){
				List<IG380Info> temp = new ArrayList<IG380Info>();
				temp.add(pd);
				pdMap.put(pd.getPdservicecatalog(), temp);
			}else{
				pdMap.get(pd.getPdservicecatalog()).add(pd);
			}
		}
		//�����������
		Map<String, List<CodeDetailDef>> secondMap = new LinkedHashMap<String, List<CodeDetailDef>>();
		for(CodeDetailDef cd:second){
			if(secondMap.get(cd.getPcid()) == null){
				List<CodeDetailDef> temp = new ArrayList<CodeDetailDef>();
				temp.add(cd);
				secondMap.put(cd.getPcid(), temp);
			}else{
				secondMap.get(cd.getPcid()).add(cd);
			}
		}
		//�������
		Map<String, List<Map<CodeDetailDef, List<IG380Info>>>> serviceCatalogMap = new LinkedHashMap<String, List<Map<CodeDetailDef,List<IG380Info>>>>();
		for(CodeDetailDef cd:first){
			List<Map<CodeDetailDef, List<IG380Info>>> list = new ArrayList<Map<CodeDetailDef,List<IG380Info>>>();
			List<CodeDetailDef> secondList = secondMap.get(cd.getCid());
			if(secondList != null){
				for(CodeDetailDef two:secondList){
					Map<CodeDetailDef, List<IG380Info>> temp = new LinkedHashMap<CodeDetailDef, List<IG380Info>>();
					temp.put(two, pdMap.get(two.getSyscoding()));
					list.add(temp);
				}
			}
			serviceCatalogMap.put(cd.getSyscoding(), list);
		}
		dto.setServiceCatalogMap(serviceCatalogMap);
		dto.setServiceCatalogFirstClassify(first);
		log.debug("===========����Ŀ¼ҳ���ʼ����������=============");
		return dto;
	}
	
	/**
	 * һ���˵��µķ���Ŀ¼��ѯ����
	 * @param dto
	 * @return
	 * @throws BLException
	 */
	public IGPRR04DTO searchFirstActionServiceCatalog(IGPRR04DTO dto) throws BLException{
		log.debug("============һ���˵��µķ���Ŀ¼��ѯ������ʼ============");
		//dto����ȡ��
		IGPRR0402Form form = dto.getIgprr0402Form();
		//��ѯ��������
		IG380SearchCondImpl pdcond = new IG380SearchCondImpl();
		List<IG380Info> pdList = workFlowDefinitionBL.searchLastProcessDefinition(pdcond,0,0);
		//�������̶�����Ϣ
		Map<String, List<IG380Info>> pdMap = new LinkedHashMap<String, List<IG380Info>>();
		for(IG380Info pd:pdList){
			if(pdMap.get(pd.getPdservicecatalog()) == null){
				List<IG380Info> temp = new ArrayList<IG380Info>();
				temp.add(pd);
				pdMap.put(pd.getPdservicecatalog(), temp);
			}else{
				pdMap.get(pd.getPdservicecatalog()).add(pd);
			}
		}
		//��ѯ����Ŀ¼һ������
		CodeDetailDefSearchCondImpl cdcond = new CodeDetailDefSearchCondImpl();
		cdcond.setCcid(IGPRR04BLType.SERVICE_CATALOG_FIRST_CLASSIFY_CCID);
		cdcond.setSyscoding(form.getSyscoding());
		if(StringUtils.isEmpty(form.getSyscoding())){
			cdcond.setSyscoding("###");
		}
		List<CodeDetailDef> first = codeDetailDefBL.searchCodeDetailDef(cdcond,CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_0);
		//��ѯ����Ŀ¼��������
		cdcond.setCcid(IGPRR04BLType.SERVICE_CATALOG_SECOND_CLASSIFY_CCID);
		cdcond.setSyscoding(null);
		cdcond.setSyscoding_q(form.getSyscoding());
		List<CodeDetailDef> second = codeDetailDefBL.searchCodeDetailDef(cdcond,CommonDefineUtils.CODE_DETAIL_ORDER_BY_MODE_0);
		//�����������
		Map<String, List<CodeDetailDef>> secondMap = new LinkedHashMap<String, List<CodeDetailDef>>();
		for(CodeDetailDef cd:second){
			if(secondMap.get(cd.getPcid()) == null){
				List<CodeDetailDef> temp = new ArrayList<CodeDetailDef>();
				temp.add(cd);
				secondMap.put(cd.getPcid(), temp);
			}else{
				secondMap.get(cd.getPcid()).add(cd);
			}
		}
		//�������
		Map<String, List<Map<CodeDetailDef, List<IG380Info>>>> serviceCatalogMap = new LinkedHashMap<String, List<Map<CodeDetailDef,List<IG380Info>>>>();
		for(CodeDetailDef cd:first){
			List<Map<CodeDetailDef, List<IG380Info>>> list = new ArrayList<Map<CodeDetailDef,List<IG380Info>>>();
			List<CodeDetailDef> secondList = secondMap.get(cd.getCid());
			if(secondList != null){
				for(CodeDetailDef two:secondList){
					Map<CodeDetailDef, List<IG380Info>> temp = new LinkedHashMap<CodeDetailDef, List<IG380Info>>();
					temp.put(two, pdMap.get(two.getSyscoding()));
					list.add(temp);
				}
			}
			serviceCatalogMap.put(cd.getSyscoding(), list);
		}
		dto.setServiceCatalogMap(serviceCatalogMap);
		//�ɷ������̲�ѯ
		dto.setPdList(ig380BL.findSelfDefinitionByUserId(dto.getUser().getUserid(),IGPRDCONSTANTS.PD_STATUS_ENABLE));
		log.debug("============һ���˵��µķ���Ŀ¼��ѯ��������============");
		return dto;
	}
}
