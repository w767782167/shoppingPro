if ($.fn.pagination){
	$.fn.pagination.defaults.beforePageText = 'Strana';
	$.fn.pagination.defaults.afterPageText = 'z {pages}';
	$.fn.pagination.defaults.displayMsg = 'Zobrazuji z谩znam {from} a啪 {to} z {total}.';
}
if ($.fn.datagrid){
	$.fn.datagrid.defaults.loadMsg = 'Pracuji, 膷ekejte pros铆m鈥�;
}
if ($.fn.treegrid && $.fn.datagrid){
	$.fn.treegrid.defaults.loadMsg = $.fn.datagrid.defaults.loadMsg;
}
if ($.messager){
	$.messager.defaults.ok = 'Ok';
	$.messager.defaults.cancel = 'Zru拧it';
}
if ($.fn.validatebox){
	$.fn.validatebox.defaults.missingMessage = 'Toto pole je vy啪adov谩no.';
	$.fn.validatebox.defaults.rules.email.message = 'Zadejte, pros铆m, platnou e-mailovou adresu.';
	$.fn.validatebox.defaults.rules.url.message = 'Zadejte, pros铆m, platnou adresu URL.';
	$.fn.validatebox.defaults.rules.length.message = 'Zadejte, pros铆m, hodnotu mezi {0} a {1}.';
}
if ($.fn.numberbox){
	$.fn.numberbox.defaults.missingMessage = 'Toto pole je vy啪adov谩no.';
}
if ($.fn.combobox){
	$.fn.combobox.defaults.missingMessage = 'Toto pole je vy啪adov谩no.';
}
if ($.fn.combotree){
	$.fn.combotree.defaults.missingMessage = 'Toto pole je vy啪adov谩no.';
}
if ($.fn.combogrid){
	$.fn.combogrid.defaults.missingMessage = 'Toto pole je vy啪adov谩no.';
}
if ($.fn.calendar){
	$.fn.calendar.defaults.weeks = ['N','P','脷','S','膶','P','S']; //ned臎le pond臎l铆 煤ter媒 st艡eda 膷tvrtek p谩tek sobota
	$.fn.calendar.defaults.months = ['led', '煤nr', 'b艡e', 'dub', 'kv臎', '膷vn', '膷vc', 'srp', 'z谩艡', '艡铆j', 'lis', 'pro']; //leden 煤nor b艡ezen duben kv臎ten 膷erven 膷ervenec srpen z谩艡铆 艡铆jen listopad prosinec
}
if ($.fn.datebox){
	$.fn.datebox.defaults.currentText = 'Dnes';
	$.fn.datebox.defaults.closeText = 'Zav艡铆t';
	$.fn.datebox.defaults.okText = 'Ok';
	$.fn.datebox.defaults.missingMessage = 'Toto pole je vy啪adov谩no.';
}
if ($.fn.datetimebox && $.fn.datebox){
	$.extend($.fn.datetimebox.defaults,{
		currentText: $.fn.datebox.defaults.currentText,
		closeText: $.fn.datebox.defaults.closeText,
		okText: $.fn.datebox.defaults.okText,
		missingMessage: $.fn.datebox.defaults.missingMessage
	});
}
