var _restUrl = location.protocol + "//" + location.host;
function filterSearch() {
	alert(1)
	var unit = $("#unit").val();
	var unitType = $("#unit_type").val();
	var data = {
		"unit" : unit,
		"unitType" : unitType,
	};
	var path = "agent_id= " + unit + "&unitType=" + unitType;
	$.ajax({
		type : "GET",
		processData : false,
		contentType : "application/json",
		url : _restUrl + '/ims/api/lease_entity/list?' + path,
		data : JSON.stringify(data),
		dataType : "json",
		success : handleSendingResult
	});
	function handleSendingResult(data) {
		var status = data.status;
		if (status == "OK") {
			alert("Success!");
			alert(data.container.obj[0].id);
		} else {
			alert("Send message fail, with error: " + data.status.message);
		}
	}
}

function unitDeail(houseId) {

}