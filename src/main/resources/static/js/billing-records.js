$(function() {

	$('#create-flat-fee-record').submit(function(e) {
		e.preventDefault();

		let record = {
			amount : $('#flat-fee-amount').val(),
			description : $('#flat-fee-description').val(),
			client : {
				id : $('#flat-fee-client').val()
			}
		};
		console.log(record);

		let headers = {
			'X-CSRF-TOKEN' : $('#flat-fee-csrf').val()
		};

		let settings = {
			url : '/api/flatfees',
			headers : headers,
			data : JSON.stringify(record),
			contentType : 'application/json'
		};
		$.post(settings).done(function(data) {
			 
			 $('#billing-record-list')
			 .append(
				`<tr>
					 <td>${ data.createdBy.username }</td>
					 <td>${ data.description }</td>
					 <td>${ data.client.name }</td>
					 <td>$${ data.amount }</td>
					 <td><td>
					 <td><td>
					 <td>$${ data.total }</td>
			 </tr>`);
			 $('#flat-fee-amount').val('');
			 $('#flat-fee-description').val('');
			 $('#flat-fee-client').val('');
		})
	});

	$('#create-rate-based-record').submit(function(e) {
		e.preventDefault();

		let record = {
			rate : $('#rate-based-rate').val(),
			quantity : $('#rate-based-quantity').val(),
			client : {
				id : $('#rate-based-client').val(),
			},
			description : $('#rate-based-description').val()
		};

		let headers = {
			'X-CSRF-TOKEN' : $('#flat-fee-csrf').val()
		};

		let settings = {
			url : '/api/ratefees',
			headers : headers,
			data : JSON.stringify(record),
			contentType : 'application/json'
		};

		$.post(settings).done(function(data) {
			 $('#billing-record-list')
			 .append(
				`<tr>
					 <td>${data.createdBy.username}</td>
					 <td>${data.description}</td>
					 <td>${data.client.name}</td>
					 <td>$</td>
					 <td>$${data.rate}</td>
					 <td>${data.quantity}</td>
					 <td>$${data.total}</td>
			 </tr>`);
			 $('#rate-based-rate').val('');
			 $('#rate-based-quantity').val('');
			 $('#rate-based-client').val('');
			 $('#rate-based-description').val('');
		})
	});

});