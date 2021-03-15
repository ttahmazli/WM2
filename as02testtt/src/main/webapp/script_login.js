'use strict';

const formLogin = document.querySelector('.login-form')
const emailLogInput = document.querySelector('.login-email');
const passLogInput = document.querySelector('.login-pass');
const btnLogin = document.querySelector('.btn-login');
const credentialSpan = document.querySelector('.error-credentials');

btnLogin.addEventListener('click', function() {

	let issuePresent = false;

	if (!issuePresent) formLogin.submit();
});