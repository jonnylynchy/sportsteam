/*
Contains all the javascript for the game-edit page
 */
(function () {
    var window = this,
        $ = window.jQuery,
        inputs = $('.team-game').find('input');
        btnSubmit = $('button.btn-primary');


    inputs.each( function( index, element ){
        $(this).on('keyup blur',function(){
            validateSubmit();
        });
    });

    function validateSubmit() {
        // if all fields have int values...
        var count = inputs.length,
            validCount = 0;
        inputs.each( function( index, element ){
            var value = $(this).val();
            if(value !== "" && parseInt(value) && !/\D/.test(value)) {
                validCount++;
            }
        });

        if(validCount === count) {
            enableSubmit();
        } else {
            disableSubmit();
        }
    }

    function enableSubmit() {
        btnSubmit.prop('disabled', false);
        btnSubmit.removeClass('disabled');
    }

    function disableSubmit() {
        btnSubmit.prop('disabled', true);
        btnSubmit.addClass('disabled');
    }

    validateSubmit();
})();

