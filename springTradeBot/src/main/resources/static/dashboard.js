function myFunction() {
	var x = document.getElementById("currency").value;
	if (x == 'USDT') {
		document.getElementById("greeting").innerHTML = "Ah! USDT";
	} else {
		document.getElementById("greeting").innerHTML = "Ah! BUSD";
	}
	fire_ajax_submit();
}




function fire_ajax_submit() {

	var currency = $("#currency").val();
	$.ajax({
		type: "POST",
		contentType: "application/json",
		url: "/fetchCurrencies",
		data: currency,
		dataType: 'json',
		cache: false,
		timeout: 600000,
		success: function(data) {

			var json = "<h4>Ajax Response"
				+ JSON.stringify(data, null, 4);
			$('#feedback').html(json);
			console.log("SUCCESS : ", data);
			contstructCheckboxes(data);

		},
		error: function(e) {

			var json = "<h4>Ajax Response</h4>&lt;pre&gt;"
				+ e.responseText + "&lt;/pre&gt;";
			$('#feedback').html(json);

			console.log("ERROR : ", e);

		}
	});

}

function contstructCheckboxes(currencies) {
	var x = document.getElementById("currency").value;
	var eleInit = '<input type="checkbox" name="pairs" onchange="toggleSubmitButton()" value="';
				var eleMid1 = '">';
				var eleEnd = '</input>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;';
				var eleFinal1 = '';
	for(var ind in currencies) {
				var curr = currencies[ind];
				var eleFinal = eleInit+curr+x+eleMid1+curr+eleEnd;
				eleFinal1 = eleFinal1.concat(eleFinal);
				console .log(eleFinal);
			}
	$('#listOfcurrencies').html(eleFinal1);
}

function toggleSubmitButton() {
var pairs = document.getElementsByName('pairs');
var isMinOnePairSelected = false;
for(var pair of pairs) {
if(pair.checked) {
isMinOnePairSelected = true;
}
}
if(isMinOnePairSelected) {
$("#submitButton").prop( "disabled", false );
} else {
$("#submitButton").prop( "disabled", 'disabled' );
}
}