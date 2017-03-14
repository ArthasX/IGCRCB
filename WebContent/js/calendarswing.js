/**
 * 北京递蓝科软件技术有限公司版权所有，保留所有权利。
 * 日历组件JS
 * wangtingzhi@deliverik.com
 */

/**
 * 日历对象组
 */
var Calendar = {};
/**
 * 定义日历对象组中的万年历对象
 * @returns {Calendar.Perpetual}
 */
Calendar.Perpetual  = function(year,month,day){
	//实例化日期对象用于取得系统当前时间
	var currentDate = new Date();
	//当前对象ID 
	this.id = '' + currentDate.getFullYear() + 
			   	   currentDate.getMonth() + 
			   	   currentDate.getDate() + 
				   currentDate.getHours() + 
				   currentDate.getMinutes() + 
				   currentDate.getSeconds() + 
				   currentDate.getMilliseconds();
	//系统年份
	this.year = (year != null ? year : currentDate.getFullYear());
	//系统月份
	this.month = (month != null ? month : currentDate.getMonth());
	//系统日期
	this.day = (day != null ? day : currentDate.getDate()); 
	//当前年份
	this.currentYear = this.year;
	//当前月份
	this.currentMonth = this.month;
	//上一月份组件按钮
	this.back = null;
	//下一月分组件按钮
	this.go = null;
	//万年历容器
	this.container = null;
	//每天的日期对象数组
	this.days = new Array();
	//日期点击执行方法
	this.dayClick = null;
};

/**
 * 计算当前月份共有多少天
 */
Calendar.Perpetual.prototype.getDayCount = function(date){
	//取得当前年份
	var y = date.getFullYear();
	//取得当前月份，因为js date对象中月份为0-12，所以+1变成正常月份
	var m = date.getMonth() + 1;
	/*
	 * 1、3、5、7、8、10、12月固定有31天
	 * 4、6、9、11月固定有30天
	 * 2月平年28天，闰年29天
	 * 算法：能被400整除或能被4整除缺不能被100整除的年份为闰年，否则为平年
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
 * 绑定上一月份按钮点击事件
 */
Calendar.Perpetual.prototype.bindBack = function(){
	//取得当前对象
	var _this = this;
	//初始化上一月分组件对象
	this.back = document.getElementById("calendarToolsback");
	//绑定上一月份组件对象点击事件
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
 * 绑定下一月份按钮点击事件
 */
Calendar.Perpetual.prototype.bindGo = function(){
	//取得当前对象
	var _this = this;
	//初始化下一月分组件对象
	this.go = document.getElementById("calendarToolsgo");
	//绑定下一月份组件对象点击事件
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
 * 绑定日期点击事件
 */
Calendar.Perpetual.prototype.bindDay = function(){
	//取得当前对象
	var _this = this;
	//取得日期组件table
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
 * 解除绑定日期点击事件
 */
Calendar.Perpetual.prototype.unbindDay = function(){
	//清空绑定事件
	this.dayClick = null;
	//重绘日历组件
	this.drow();
};

/**
 * 日历组件绘制方法
 * @param id 组件生成的容器ID
 */
Calendar.Perpetual.prototype.drow = function(id,fn){
	//取得绘制容器
	if(id){
		this.container = document.getElementById(id);
		this.container.className += " calendarcontainer";
	}
	//绑定日期点击事件要执行的方法
	if(fn){
		this.dayClick = fn;
	}
	//取得当前月1号的日期对象
	var currentDate = new Date(this.currentYear,this.currentMonth,1);
	//取得当前星期标识
	var currentWeek = currentDate.getDay();
	//取得指定月份共有多少天
	var dayCount = this.getDayCount(currentDate);
	//本月天数循环起始标识
	var index = 1;
	//绘制内容
	var str = "";
	str += '<div class="calendarTools"><div class="left">';
	str += '<span id="calendarToolsback"><<</span>&nbsp;&nbsp;';
	str += this.currentYear + '年';
	str += (this.currentMonth + 1) + '月';
	str += '&nbsp;&nbsp;<span id="calendarToolsgo">>></span>';
	str += '</div><div class="right">';
	str += this.year + '年';
	str += (this.month + 1) + '月';
	str += this.day + '日';
	str += '</div></div>';
	str += '<table id="table';
	str += this.id;
	str += '" class="calendarContent">';
	str += '<tr><th>星期日</th><th>星期一</th><th>星期二</th><th>星期三</th><th>星期四</th><th>星期五</th><th>星期六</th></tr>';
	str += '<tr>';
	/**
	 *  日历组件一个6行，每行7个单元格，共计42个单元格，循环42次，填上42个单元格内容
	 */
	for(var i=1;i<=42;i++){
		/*
		 * 补齐由于本月1号不是星期天而导致的几个空格后输出日期,截止到本月最大天数为止
		 * 由于循环标识从1开始，而星期标识从0开始，所以判断中使用 i > currentWeek
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
			//天数标识自增
			index ++;
			str += "</td>";
		}else{
			str += "<td></td>";
		}
		//如果i是7的倍数，则代表当前行结束,加上行结束标签
		if(i % 7 == 0){
			str += "</tr>";
			//如果i小鱼42，说明循环还没结束，需要加上新行标签
			if(i < 42){
				str += "<tr>";
			}
		}
	}
	str += '</table>';
	this.container.innerHTML = str;
	//绑定上一月份按钮事件
	this.bindBack();
	//绑定下一月份按钮事件
	this.bindGo();
	//绑定日期
	this.bindDay();
};