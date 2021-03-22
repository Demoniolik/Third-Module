$("#getResult").click(element => {
    element.preventDefault();
    $.ajax({
        url: "/getImdbData",
        type: "GET",
        success: function (result) {
            console.log(result);
            $(".result_container").text(result);
        }
    });
});