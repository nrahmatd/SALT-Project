$(document).ready( function () {
	 var table = $('#customerTable').DataTable({
			"sAjaxSource": "/restapi/getallcustomer",
			"sAjaxDataProp": "",
			"order": [[ 0, "asc" ]],
			"aoColumns": [
			      { "mData": "id"},
		          { "mData": "nama" },
				  { "mData": "alamat" },
				  { "mData": "kota" },
				  { "mData": "provinsi" },
				  { "mData": "tgl_registrasi" },
				  { "mData": "status" }
			]
	 })
});