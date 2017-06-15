package com.deliverik.infogovernor.taglib;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang.StringUtils;
import org.apache.struts.taglib.TagUtils;
import org.eclipse.birt.report.model.api.util.StringUtil;

import com.deliverik.framework.platform.WebApplicationSupport;
import com.deliverik.framework.workflow.prr.bl.task.IG599BL;
import com.deliverik.framework.workflow.prr.bl.task.IG899BL;
import com.deliverik.framework.workflow.prr.model.IG599Info;
import com.deliverik.framework.workflow.prr.model.IG899Info;
import com.deliverik.framework.workflow.prr.model.condition.IG599SearchCondImpl;
import com.deliverik.framework.workflow.prr.model.condition.IG899SearchCondImpl;

/**
 * BCM流程私有表单信息显示标签
 * @author Deliverik
 *
 */
public class ShowDRMProcessInfoTag extends TagSupport{

	private static final long serialVersionUID = 1L;
	
	protected String prid;
	protected String opinion;
	protected String description;
	protected String title;

	@Override
	public int doStartTag() throws JspException {

		IG899BL ig899BL = (IG899BL) WebApplicationSupport.getBean("ig899BL");
		IG599BL ig599BL = (IG599BL) WebApplicationSupport.getBean("ig599BL");
		
		Map<String, String> sugMap = new HashMap<String, String>();
		Map<String, String> desMap = new HashMap<String, String>();
		
		IG599SearchCondImpl pisugCond = new IG599SearchCondImpl();
		pisugCond.setPrid(Integer.parseInt(prid));
		pisugCond.setPivarname(StringUtils.isEmpty(opinion)?"评估意见":opinion);
		List<IG599Info> pisugList = ig599BL.searchIG599InfosByCond(pisugCond);

		if (pisugList != null && pisugList.size() > 0) {
			
			IG899SearchCondImpl cond = new IG899SearchCondImpl();
			cond.setPiid(pisugList.get(0).getPiid());
			List<IG899Info> ppiList =  ig899BL.searchIG899Info(cond);
			
			if (ppiList != null && ppiList.size() > 0) {
				for (IG899Info ppiInfo : ppiList) {
					sugMap.put(ppiInfo.getUserTB().getUsername(), ppiInfo.getPpivalue());
				}
			}
		}
		
		IG599SearchCondImpl pidesCond = new IG599SearchCondImpl();
		pidesCond.setPrid(Integer.parseInt(prid));
		pidesCond.setPivarname(StringUtil.isEmpty(description)?"意见描述":description);
		List<IG599Info> pidesList = ig599BL.searchIG599InfosByCond(pidesCond);
		
		if (pidesList != null && pidesList.size() > 0) {
			
			IG899SearchCondImpl cond = new IG899SearchCondImpl();
			cond.setPiid(pidesList.get(0).getPiid());
			List<IG899Info> ppiList =  ig899BL.searchIG899Info(cond);
			
			if (ppiList != null && ppiList.size() > 0) {
				for (IG899Info ppiInfo : ppiList) {
					desMap.put(ppiInfo.getUserTB().getUsername(), ppiInfo.getPpivalue());
				}
			}
		}
		
		StringBuffer str = new StringBuffer();
		
		if (sugMap != null && sugMap.size() > 0) {
			
			str.append("<div class=\"record_list\">")
			.append("<div class=\"title\">")
			.append("<div class=\"name\">"+(StringUtil.isEmpty(title)?"评估结果":title)+"</div>")
			.append("</div>")
			.append("<table cellspacing=\"2\" class=\"table_style\">")
			.append("<tr>")
			.append("<th width=\"15%\">处理人</th>")
			.append("<th width=\"15%\">"+(StringUtils.isEmpty(opinion)?"评估意见":opinion)+"</th>")
			.append("<th width=\"15%\">"+(StringUtil.isEmpty(description)?"意见描述":description)+"</th>")
		    .append("</tr>");
			

			Set<Entry<String, String>> entrySet = sugMap.entrySet();
			for(Iterator<Entry<String, String>> iterator = entrySet.iterator();iterator.hasNext();){
				Entry<String, String> entry = iterator.next();
				String username = entry.getKey();
				
				str.append("<tr>")
				.append("<td>")
				.append(username)
				.append("</td>")
				.append("<td>")
				.append(sugMap.get(username))
				.append("</td>")
				.append("<td>")
				.append(desMap.get(username))
				.append("</td>")
				.append("</tr>");
			}
			
			str.append("</table>")
			.append("</div>");
		}
		
		TagUtils.getInstance().write(pageContext, str.toString());
		return (EVAL_BODY_INCLUDE);
	}

	public String getPrid() {
		return prid;
	}

	public void setPrid(String prid) {
		this.prid = prid;
	}

	public String getOpinion() {
		return opinion;
	}

	public void setOpinion(String opinion) {
		this.opinion = opinion;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	

}