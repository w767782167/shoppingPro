if ($.fn.pagination){
	$.fn.pagination.defaults.beforePageText = '绗�;
	$.fn.pagination.defaults.afterPageText = '鍏眥pages}椤�;
	$.fn.pagination.defaults.displayMsg = '鏄剧ず{from}鍒皗to},鍏眥total}璁板綍';
}
if ($.fn.datagrid){
	$.fn.datagrid.defaults.loadMsg = '姝ｅ湪澶勭悊锛岃绋嶅緟銆傘�銆�;
}
if ($.fn.treegrid && $.fn.datagrid){
	$.fn.treegrid.defaults.loadMsg = $.fn.datagrid.defaults.loadMsg;
}
if ($.messager){
	$.messager.defaults.ok = '纭畾';
	$.messager.defaults.cancel = '鍙栨秷';
}
if ($.fn.validatebox){
	$.fn.validatebox.defaults.missingMessage = '璇ヨ緭鍏ラ」涓哄繀杈撻」';
	$.fn.validatebox.defaults.rules.email.message = '璇疯緭鍏ユ湁鏁堢殑鐢靛瓙閭欢鍦板潃';
	$.fn.validatebox.defaults.rules.url.message = '璇疯緭鍏ユ湁鏁堢殑URL鍦板潃';
	$.fn.validatebox.defaults.rules.length.message = '杈撳叆鍐呭闀垮害蹇呴』浠嬩簬{0}鍜寋1}涔嬮棿';
	$.fn.validatebox.defaults.rules.remote.message = '璇蜂慨姝ｈ瀛楁';
}
if ($.fn.numberbox){
	$.fn.numberbox.defaults.missingMessage = '璇ヨ緭鍏ラ」涓哄繀杈撻」';
}
if ($.fn.combobox){
	$.fn.combobox.defaults.missingMessage = '璇ヨ緭鍏ラ」涓哄繀杈撻」';
}
if ($.fn.combotree){
	$.fn.combotree.defaults.missingMessage = '璇ヨ緭鍏ラ」涓哄繀杈撻」';
}
if ($.fn.combogrid){
	$.fn.combogrid.defaults.missingMessage = '璇ヨ緭鍏ラ」涓哄繀杈撻」';
}
if ($.fn.calendar){
	$.fn.calendar.defaults.weeks = ['鏃�,'涓�,'浜�,'涓�,'鍥�,'浜�,'鍏�];
	$.fn.calendar.defaults.months = ['涓�湀','浜屾湀','涓夋湀','鍥涙湀','浜旀湀','鍏湀','涓冩湀','鍏湀','涔濇湀','鍗佹湀','鍗佷竴鏈�,'鍗佷簩鏈�];
}
if ($.fn.datebox){
	$.fn.datebox.defaults.currentText = '浠婂ぉ';
	$.fn.datebox.defaults.closeText = '鍏抽棴';
	$.fn.datebox.defaults.okText = '纭畾';
	$.fn.datebox.defaults.missingMessage = '璇ヨ緭鍏ラ」涓哄繀杈撻」';
	$.fn.datebox.defaults.formatter = function(date){
		var y = date.getFullYear();
		var m = date.getMonth()+1;
		var d = date.getDate();
		return y+'-'+(m<10?('0'+m):m)+'-'+(d<10?('0'+d):d);
	};
	$.fn.datebox.defaults.parser = function(s){
		if (!s) return new Date();
		var ss = s.split('-');
		var y = parseInt(ss[0],10);
		var m = parseInt(ss[1],10);
		var d = parseInt(ss[2],10);
		if (!isNaN(y) && !isNaN(m) && !isNaN(d)){
			return new Date(y,m-1,d);
		} else {
			return new Date();
		}
	};
}
if ($.fn.datetimebox && $.fn.datebox){
	$.extend($.fn.datetimebox.defaults,{
		currentText: $.fn.datebox.defaults.currentText,
		closeText: $.fn.datebox.defaults.closeText,
		okText: $.fn.datebox.defaults.okText,
		missingMessage: $.fn.datebox.defaults.missingMessage
	});
}
