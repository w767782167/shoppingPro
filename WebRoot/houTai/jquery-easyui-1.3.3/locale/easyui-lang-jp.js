if ($.fn.pagination){
	$.fn.pagination.defaults.beforePageText = '銉氥兗銈�;
	$.fn.pagination.defaults.afterPageText = '{pages} 涓�;
	$.fn.pagination.defaults.displayMsg = '鍏�{total} 銈偆銉嗐儬涓�{from} 銇嬨倝 {to} 銈掕〃绀轰腑';
}
if ($.fn.datagrid){
	$.fn.datagrid.defaults.loadMsg = '鍑︾悊涓仹銇欍�灏戙�銇婂緟銇°亸銇犮仌銇�..';
}
if ($.fn.treegrid && $.fn.datagrid){
	$.fn.treegrid.defaults.loadMsg = $.fn.datagrid.defaults.loadMsg;
}
if ($.messager){
	$.messager.defaults.ok = 'OK';
	$.messager.defaults.cancel = '銈儯銉炽偦銉�;
}
if ($.fn.validatebox){
	$.fn.validatebox.defaults.missingMessage = '鍏ュ姏銇繀闋堛仹銇欍�';
	$.fn.validatebox.defaults.rules.email.message = '姝ｃ仐銇勩儭銉笺儷銈儔銉偣銈掑叆鍔涖仐銇︺亸銇犮仌銇勩�';
	$.fn.validatebox.defaults.rules.url.message = '姝ｃ仐銇刄RL銈掑叆鍔涖仐銇︺亸銇犮仌銇勩�';
	$.fn.validatebox.defaults.rules.length.message = '{0} 銇嬨倝 {1} 銇瘎鍥层伄姝ｃ仐銇勫�銈掑叆鍔涖仐銇︺亸銇犮仌銇勩�';
	$.fn.validatebox.defaults.rules.remote.message = '銇撱伄銉曘偅銉笺儷銉夈倰淇銇椼仸銇忋仩銇曘亜銆�;
}
if ($.fn.numberbox){
	$.fn.numberbox.defaults.missingMessage = '鍏ュ姏銇繀闋堛仹銇欍�';
}
if ($.fn.combobox){
	$.fn.combobox.defaults.missingMessage = '鍏ュ姏銇繀闋堛仹銇欍�';
}
if ($.fn.combotree){
	$.fn.combotree.defaults.missingMessage = '鍏ュ姏銇繀闋堛仹銇欍�';
}
if ($.fn.combogrid){
	$.fn.combogrid.defaults.missingMessage = '鍏ュ姏銇繀闋堛仹銇欍�';
}
if ($.fn.calendar){
	$.fn.calendar.defaults.weeks = ['鏃�,'鏈�,'鐏�,'姘�,'鏈�,'閲�,'鍦�];
	$.fn.calendar.defaults.months = ['1鏈�, '2鏈�, '3鏈�, '4鏈�, '5鏈�, '6鏈�, '7鏈�, '8鏈�, '9鏈�, '10鏈�, '11鏈�, '12鏈�];
}
if ($.fn.datebox){
	$.fn.datebox.defaults.currentText = '浠婃棩';
	$.fn.datebox.defaults.closeText = '闁夈仒銈�;
	$.fn.datebox.defaults.okText = 'OK';
	$.fn.datebox.defaults.missingMessage = '鍏ュ姏銇繀闋堛仹銇欍�';
}
if ($.fn.datetimebox && $.fn.datebox){
	$.extend($.fn.datetimebox.defaults,{
		currentText: $.fn.datebox.defaults.currentText,
		closeText: $.fn.datebox.defaults.closeText,
		okText: $.fn.datebox.defaults.okText,
		missingMessage: $.fn.datebox.defaults.missingMessage
	});
}
