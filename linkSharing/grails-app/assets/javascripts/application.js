// This is a manifest file that'll be compiled into application.js.
//
// Any JavaScript file within this directory can be referenced here using a relative path.
//
// You're free to add application-wide JavaScript to this file, but it's generally better
// to create separate JavaScript files as needed.
//
//= require jquery-2.2.0.min
//= require bootstrap
//= require login
// srequire jquery
// srequire jquery.validate
//  srequire_tree .
//= require_self

if (typeof jQuery !== 'undefined') {
    (function($) {
        $(document).ajaxStart(function() {
            $('#spinner').fadeIn();
        }).ajaxStop(function() {
            $('#spinner').fadeOut();
        });
    })(jQuery);
}

function updateSeriousness(topicId, seriousness) {
    $.ajax({
        url: "/subscription/update?topicId=" + topicId + "&seriousness=" + seriousness,
        type: 'GET',
        success: function (result) {
// alert("resource deleted!")
// location.reload();
            var id = "#updateTextOfSeriousness" + topicId
            $(id).html(result)
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert("error in updating status")
        }
    })
}