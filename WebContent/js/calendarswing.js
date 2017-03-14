/**
 * ��������������������޹�˾��Ȩ���У���������Ȩ����
 * �������JS
 * wangtingzhi@deliverik.com
 */

/**
 * ����������
 */
var Calendar = {};
/**
 * ���������������е�����������
 * @returns {Calendar.Perpetual}
 */
Calendar.Perpetual  = function(year,month,day){
	//ʵ�������ڶ�������ȡ��ϵͳ��ǰʱ��
	var currentDate = new Date();
	//��ǰ����ID 
	this.id = '' + currentDate.getFullYear() + 
			   	   currentDate.getMonth() + 
			   	   currentDate.getDate() + 
				   currentDate.getHours() + 
				   currentDate.getMinutes() + 
				   currentDate.getSeconds() + 
				   currentDate.getMilliseconds();
	//ϵͳ���
	this.year = (year != null ? year : currentDate.getFullYear());
	//ϵͳ�·�
	this.month = (month != null ? month : currentDate.getMonth());
	//ϵͳ����
	this.day = (day != null ? day : currentDate.getDate()); 
	//��ǰ���
	this.currentYear = this.year;
	//��ǰ�·�
	this.currentMonth = this.month;
	//��һ�·������ť
	this.back = null;
	//��һ�·������ť
	this.go = null;
	//����������
	this.container = null;
	//ÿ������ڶ�������
	this.days = new Array();
	//���ڵ��ִ�з���
	this.dayClick = null;
};

/**
 * ���㵱ǰ�·ݹ��ж�����
 */
Calendar.Perpetual.prototype.getDayCount = function(date){
	//ȡ�õ�ǰ���
	var y = date.getFullYear();
	//ȡ�õ�ǰ�·ݣ���Ϊjs date�������·�Ϊ0-12������+1��������·�
	var m = date.getMonth() + 1;
	/*
	 * 1��3��5��7��8��10��12�¹̶���31��
	 * 4��6��9��11�¹̶���30��
	 * 2��ƽ��28�죬����29��
	 * �㷨���ܱ�400�������ܱ�4����ȱ���ܱ�100���������Ϊ���꣬����Ϊƽ��
	 */
	if(m == 1 || m == 3 || m == 5 || m == 7 || m == 8 || m == 10 || m == 12){
		return 31;
	}else if(m == 4 || m == 6 || m == 9 || m == 11){
		return 30;
	}else if(m == 2){
		if(y % 400 == 0 || (y % 100 > 0 && y % 4 == 0)){
			return 29;
		}else{
			return 28;
		}
	}else{
		return 0;
	}
};

/**
 * ����һ�·ݰ�ť����¼�
 */
Calendar.Perpetual.prototype.bindBack = function(){
	//ȡ�õ�ǰ����
	var _this = this;
	//��ʼ����һ�·��������
	this.back = document.getElementById("calendarToolsback");
	//����һ�·�����������¼�
	this.back.onclick = function(){
		if(_this.currentMonth === 0){
			_this.currentYear --;
			_this.currentMonth = 11;
		}else{
			_this.currentMonth --;
		}
		_this.drow();
	};
};

/**
 * ����һ�·ݰ�ť����¼�
 */
Calendar.Perpetual.prototype.bindGo = function(){
	//ȡ�õ�ǰ����
	var _this = this;
	//��ʼ����һ�·��������
	this.go = document.getElementById("calendarToolsgo");
	//����һ�·�����������¼�
	this.go.onclick = function(){
		if(_this.currentMonth === 11){
			_this.currentYear ++;
			_this.currentMonth = 0;
		}else{
			_this.currentMonth ++;
		}
		_this.drow();
	};
};

/**
 * �����ڵ���¼�
 */
Calendar.Perpetual.prototype.bindDay = function(){
	//ȡ�õ�ǰ����
	var _this = this;
	//ȡ���������table
	var tb = document.getElementById("table" + this.id);
	for(var i=1;i<tb.rows.length;i++){
		for(var j=0;j<tb.rows[i].cells.length;j++){
			var cell = tb.rows[i].cells[j];
			if(cell.innerHTML != ""){
				cell.onclick = _this.dayClick;
			}
		}
	}
};
/**
 * ��������ڵ���¼�
 */
Calendar.Perpetual.prototype.unbindDay = function(){
	//��հ��¼�
	this.dayClick = null;
	//�ػ��������
	this.drow();
};

/**
 * ����������Ʒ���
 * @param id ������ɵ�����ID
 */
Calendar.Perpetual.prototype.drow = function(id,fn){
	//ȡ�û�������
	if(id){
		this.container = document.getElementById(id);
		this.container.className += " calendarcontainer";
	}
	//�����ڵ���¼�Ҫִ�еķ���
	if(fn){
		this.dayClick = fn;
	}
	//ȡ�õ�ǰ��1�ŵ����ڶ���
	var currentDate = new Date(this.currentYear,this.currentMonth,1);
	//ȡ�õ�ǰ���ڱ�ʶ
	var currentWeek = currentDate.getDay();
	//ȡ��ָ���·ݹ��ж�����
	var dayCount = this.getDayCount(currentDate);
	//��������ѭ����ʼ��ʶ
	var index = 1;
	//��������
	var str = "";
	str += '<div class="calendarTools"><div class="left">';
	str += '<span id="calendarToolsback"><<</span>&nbsp;&nbsp;';
	str += this.currentYear + '��';
	str += (this.currentMonth + 1) + '��';
	str += '&nbsp;&nbsp;<span id="calendarToolsgo">>></span>';
	str += '</div><div class="right">';
	str += this.year + '��';
	str += (this.month + 1) + '��';
	str += this.day + '��';
	str += '</div></div>';
	str += '<table id="table';
	str += this.id;
	str += '" class="calendarContent">';
	str += '<tr><th>������</th><th>����һ</th><th>���ڶ�</th><th>������</th><th>������</th><th>������</th><th>������</th></tr>';
	str += '<tr>';
	/**
	 *  �������һ��6�У�ÿ��7����Ԫ�񣬹���42����Ԫ��ѭ��42�Σ�����42����Ԫ������
	 */
	for(var i=1;i<=42;i++){
		/*
		 * �������ڱ���1�Ų�������������µļ����ո���������,��ֹ�������������Ϊֹ
		 * ����ѭ����ʶ��1��ʼ�������ڱ�ʶ��0��ʼ�������ж���ʹ�� i > currentWeek
		 */
		if(i > currentWeek && index <= dayCount){
			str += "<td style='";
			if(i % 7 == 1 || i % 7 == 0){
				str += "color:red;";
			}
			if(this.currentYear == this.year && this.currentMonth == this.month && this.day == index){
				str += "background-color:#adf795;";
			}
			str += "'>";
			str += index + "";
			//������ʶ����
			index ++;
			str += "</td>";
		}else{
			str += "<td></td>";
		}
		//���i��7�ı����������ǰ�н���,�����н�����ǩ
		if(i % 7 == 0){
			str += "</tr>";
			//���iС��42��˵��ѭ����û��������Ҫ�������б�ǩ
			if(i < 42){
				str += "<tr>";
			}
		}
	}
	str += '</table>';
	this.container.innerHTML = str;
	//����һ�·ݰ�ť�¼�
	this.bindBack();
	//����һ�·ݰ�ť�¼�
	this.bindGo();
	//������
	this.bindDay();
};