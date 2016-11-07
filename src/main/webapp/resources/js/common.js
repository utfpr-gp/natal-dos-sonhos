$(document).ready(function () {
	$(".button-collapse").sideNav();
	$('.collapsible').collapsible();
        $('#year').html(getCurrentYear());
});

function getCurrentYear(){
    return new Date().getFullYear();    
}




