const express = require("express");
const morgan = require("morgan");
const url = require("url");
const uuidApiKey = require("uuid-apikey");
require("dotenv").config();
const env = process.env;

const app = express();
app.set("port", process.env.PORT || 8080);

// 공통 미들웨어
app.use(morgan("dev"));
app.use(express.json());
app.use(express.urlencoded({ extended: true }));

const key = {
  apiKey: env.APIKEY,
  uuid: env.UUID,
};

let boardList = []; // [{id, user_id, date, title, content}, {}, {}]
let numOfBoard = 0;

// get
app.get("/board", (req, res) => {
  res.send(boardList);
});

// post
app.post("/board", (req, res) => {
  const board = {
    id: ++numOfBoard,
    user_id: req.body.user_id,
    date: new Date(),
    title: req.body.title,
    content: req.body.content,
  };
  boardList.push(board);

  res.redirect("/board");
});

// put
app.put("/board/:id", (req, res) => {
  // 기존 데이터 삭제
  const findItem = boardList.find((item) => {
    return item.id == parseInt(req.params.id); // 문자열로 받아 오기 때문에, 문자열을 숫자로 변환해주어야 함
  });

  const idx = boardList.indexOf(findItem);
  boardList.splice(idx, 1);

  // 새롭게 데이터 추가
  const board = {
    id: parseInt(req.params.id),
    user_id: req.body.user_id,
    date: new Date(),
    title: req.body.title,
    content: req.body.content,
  };

  boardList.push(board);
  res.redirect("/board");
});

// delete
app.delete("/board/:id", (req, res) => {
  const findItem = boardList.find((item) => {
    return item.id == parseInt(req.params.id); // 문자열로 받아 오기 때문에, 문자열을 숫자로 변환해주어야 함
  });

  const idx = boardList.indexOf(findItem);
  boardList.splice(idx, 1);

  res.redirect("/board");
});

// 리스트에서 검색어 기능
app.get("/board/:apikey/:type", (req, res) => {
  let { type, apikey } = req.params;
  const queryData = url.parse(req.url, true).query;

  if (uuidApiKey.isAPIKey(apikey) && uuidApiKey.check(apikey, key.uuid)) {
    if (type === "search") { // 키워드로 게시글 검색
      const keyword = queryData.keyword;
      const result = boardList.filter((e) => {
        return e.title.includes(keyword);
      });

      res.send(result);

    } else if (type === "user") { // 닉네임으로 게시글 검색
      const user_id = queryData.user_id;
      const result = boardList.filter((e) => {
        return e.user_id === user_id;
      });

      res.send(result);

    } else {
      res.send("Wrong URL");
    }
  } else {
    res.send("Wrong API Key URL");
  }
});

app.listen(app.get("port"), () => {
  console.log("Server On");
});
