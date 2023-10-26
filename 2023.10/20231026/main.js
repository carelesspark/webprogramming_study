var $banner = $("#banner"),
  $img = $banner.find("img"),
  $toggle = $("#toggle"),
  $sound = $("#sound_btn");

var $banner_height = $banner.css("height");
var cast = [];

function set_balloon(num) {
  var x = Math.floor(Math.random() * (500 - 10) + 10);
  var y = Math.floor(Math.random() * (400 - 120) + 120);
  var size = Math.floor(Math.random() * (200 - 100) + 100);
  var angle = Math.floor(Math.random() * (360 - 0) + 0);
  var speed = Math.random() * (5 - 0) + 0;

  cast[num] = {
    x,
    y: -y,
    size,
    angle,
    speed,
  };
}

function balloon_init() {
  $img.each(function (i) {
    set_balloon(i);
    $img.eq(i).css("left", "-9999px").css("top", "-9999px"); // 풍선의 시작 x, y 좌표
  });
}

function animate_balloon() {
  $img.each(function (i) {
    $img
      .eq(i)
      .css("left", cast[i].x + "px")
      .css("top", cast[i].y + "px")
      .css("transform", "rotate(" + cast[i].angle + "deg)");
    if (cast[i].y < parseInt($banner_height)) {
      cast[i].y += cast[i].speed;
      cast[i].angle += cast[i].speed;
    } else {
      set_balloon(i);
    }
  });
}

balloon_init();
setInterval(function () {
  animate_balloon();
}, 1000 / 30);

$toggle.click(function () {
  var attr = $banner.attr("class");
  if (attr == "active") {
    $banner.removeAttr("class");
    $(this).text("배너 열기");
    return false;
  } else {
    $banner.attr("class", "active");
    $(this).text("배너 닫기");
    return false;
  }
});
