$(function () {
  function Questions(text, choice, answer) {
    // 객체 생성(대문자로)
    this.text = text;
    this.choice = choice;
    this.answer = answer;
  }

  var questions = [
    new Questions(
      "다음 중 최초의 사용 웹 브라우저는?",
      ["모자이크", "인터넷 익스플로러", "구글 크롬", "넷스케이프 네비게이터"],
      "넷스케이프 네비게이터"
    ),
    new Questions(
      "웹 문서에서 스타일을 작성하는 언어는?",
      ["HTML", "jQuery", "CSS", "XML"],
      "CSS"
    ),
    new Questions(
      "명령어 기반의 인터페이스를 의미하는 용어는?",
      ["GUI", "CLI", "HUD", "SI"],
      "CLI"
    ),
    new Questions(
      "CSS 속성 중 글자의 굵기를 변경하는 속성은?",
      ["font-size", "font-style", "font-weight", "font-variant"],
      "font-weight"
    ),
  ];

  function Quiz(questions) {
    this.score = 0;
    this.questions = questions;
    this.questionIndex = 0;
    this.correctAnser = function (answer) {
      return answer == this.questions[this.questionIndex].answer;
    };
  }

  var quiz = new Quiz(questions);

  function update_quiz() {
    let $question = $("#question");
    let quizNum = quiz.questionIndex + 1;
    $question.text(
      "문제" + quizNum + ") " + quiz.questions[quiz.questionIndex].text
    );

    for (i = 0; i < 4; i++) {
      let $choice = $(".btn").eq(i);
      $choice.text(quiz.questions[quiz.questionIndex].choice[i]);
    }
    progress();
  }

  function progress() {
    let $progress = $("#progress");
    $progress.text(
      "문제 " + (quiz.questionIndex + 1) + "/" + quiz.questions.length
    );
  }

  function result() {
    let $quiz = $("#quiz");
    let $total = (quiz.score * 100) / quiz.questions.length;
    let $showInfo =
      "<h1>결과 화면</h1>" +
      "<h2>당신의 점수는 : " +
      quiz.score +
      "/" +
      quiz.questions.length +
      "<br><br>" +
      $total +
      "점</h2>";
    $quiz.html($showInfo);

    if ($total < 60) {
      $showInfo += "<h2 style ='color:red'>좀더 분발하세요</h2>";
      $quiz.html($showInfo);
    } else if ($total >= 60 && $total <= 80) {
      $showInfo += "<h2 style ='color:red'>무난한 점수네요</h2>";
      $quiz.html($showInfo);
    } else if ($total > 80) {
      $showInfo += "<h2 style='color:red'>훌륭합니다</h2>";
      $quiz.html($showInfo);
    }
  }

  (function () {
    $(".btn").click(function () {
      let $answer = $(this).text(); // 내가 선택한 보기의 값
      if (quiz.correctAnser($answer)) {
        // 문제의 정답과 고른 값 비교
        alert("정답입니다.");
        quiz.score++;
      } else {
        alert("오답입니다.");
      }

      if (quiz.questionIndex < quiz.questions.length - 1) {
        quiz.questionIndex++;
        update_quiz();
      } else {
        result();
      }
    });
    update_quiz();
  })();
});
