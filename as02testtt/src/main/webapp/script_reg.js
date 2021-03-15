'use strict';

const formReg = document.querySelector('.reg-form')
const emailInput = document.querySelector('.email');
const passInput = document.querySelector('.pass');
const btnReg = document.querySelector('.btn-reg');
const emailSpan = document.querySelector('.error-mail');
const passSpan = document.querySelector('.error-pass');


function validateEmail(email) {
	const re = /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/;
	return re.test(email);
}

btnReg.addEventListener('click', function() {

	let issuePresent = false;

	if (passInput.value.length > 3) 
		passSpan.classList.add('hidden');
	else {
		issuePresent = true;
		passSpan.classList.remove('hidden');
	}

	if (validateEmail(emailInput.value)) {
		emailSpan.classList.add('hidden');
	} else {
		emailSpan.classList.remove('hidden');
	}

	issuePresent = !validateEmail(emailInput.value);

	if (!issuePresent) formReg.submit();
});