//alert(1111);
function goPage(currentPage) {
	$("#currentPageInput").val(currentPage);
	$("#advanceForm").submit();
	console.debug(currentPage);
}
function changGoodsFrom(goodsFrom){
	$("#gFromNameInput").val(goodsFrom);
	$("#gnameForm").submit();
}