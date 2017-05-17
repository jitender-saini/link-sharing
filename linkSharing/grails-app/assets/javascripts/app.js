/**
 * Created by jitender on 16/5/17.
 */
function makeAjaxcall(url, data, element, callback) {
    element.parent().prepend($("#ajaxSpinnerImage"));
    $.ajax({
        url: url,
        data: data,
        success: function (response) {
            console.log(response);
            callback(response)
        }
    });
}

if (typeof jQuery !== 'undefined') {
    (function ($) {
        $(document).ajaxStart(function () {
            $('#spinner').fadeIn();
        }).ajaxStop(function () {
            $('#spinner').fadeOut();
        });
    })(jQuery);
}

function updateSeriousness(topicId, seriousness) {
    $.ajax({
        url: "/subscription/update?topicId=" + topicId + "&seriousness=" + seriousness,
        type: 'GET',
        success: function (result) {
            location.reload();
            var id = "#updateTextOfSeriousness" + topicId
            $(id).html(result)
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert("error in updating status")
        }
    })
}

function deleteResource(resourceId) {
    if (confirm("Are you sure you want to delete this resource ?") == true) {
        $.ajax({
            url: "/resource/delete?resourceId=" + resourceId,
            type: 'GET',
            success: function (result) {
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert("resource deletion failed!!!")
            }
        })
    }
}

function deleteTopic(topicId) {
    if (confirm("Are you sure, you want to delete this topic?") == true) {
        $.ajax({
            url: "/topic/delete?topicId=" + topicId,
            type: 'GET',
            success: function (result) {
            },
            error: function (jqXHR, textStatus, errorThrown) {
                alert("Topic deletion failed!!!")
            }
        })
    }
}

function insertRating(resourceId, rating) {
    $.ajax({
        url: "/resource/rating?resourceId=" + resourceId + "&rating=" + rating,
        type: 'GET',
        success: function (result) {
            var id = "#ratingUpdationMessage" + resourceId;
            $(id).html("Ratings Updated");
            $("#ratings").load();
        },
        error: function (jqXHR, textStatus, errorThrown) {
            alert("error in updating status");
        }
    })
}

function editResource(resourceId) {
    var id = "#description" + resourceId
    $(id).show()
}

function editTopic(topicId) {
    var id = ".topicId" + topicId
    $(id).show()
}