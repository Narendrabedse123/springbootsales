$(function() {
  $.get("/bars", function (data) {
    $.each(data, function(index, item) {
      $("#bars").append("<li>Bar " + item.name + "</li>");
    });
  });
});
