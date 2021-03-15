'use strict';

const formUpdate = document.querySelector('.update-form')
const btnUpdate = document.querySelector('.btn-update');
const ageInput = document.querySelector('.age');

function fixNumber(ageInput) {
		ageInput.value = ageInput.value.replace(/\D/g, '');
}

btnUpdate.addEventListener('click', function() {

	let issuePresent = false;
	
	fixNumber(ageInput);

	if (!issuePresent) formUpdate.submit();
});