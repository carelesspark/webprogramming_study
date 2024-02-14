const express = require('express');
const axios = require('axios');
const morgan = require('morgan');
require('dotenv').config();
const env = process.env;

const app = express();
app.set('port',process.env.PORT || 8080);


// 공통 미들웨어
app.use(express.json());
app.use(morgan('dev'));
app.use(express.urlencoded({ extended: true }));

// 라우터 설정
app.get('/airkorea', async (req, res) => {
     const serviceKey = env.SERVICE_KEY;
     const airUrl = env.AIR_URL;

    let params = encodeURI('serviceKey') + '=' + serviceKey;
    params += '&' + encodeURI('numOfRows') + '=' + encodeURI('1');
    params += '&' + encodeURI('pageNo') + '=' + encodeURI('1');
    params += '&' + encodeURI('dataTerm') + '=' + encodeURI('DAILY');
    params += '&' + encodeURI('ver') + '=' + encodeURI('1.3');
    params += '&' + encodeURI('stationName') + '=' + encodeURI('마포구');
    params += '&' + encodeURI('returnType') + '=' + encodeURI('json')

    const url = airUrl + params;

    try {
        const result = await axios.get(url);
        //res.json(result.data); // .data

        const airItem = {
            location: '마포구', //locaition을 직접 명시
            time: result.data.response.body.items[0]['dataTime'], // 시간대
            pm10: result.data.response.body.items[0]['pm10Value'], // pm10 수치
            pm25: result.data.response.body.items[0]['pm25Value'], // pm25 수치
        };

        const badAir = [];
        // pm10은 미세먼지 수치
        if (airItem.pm10 <= 30) {
            badAir.push("좋음😀");
        } else if (airItem.pm10 > 30 && airItem.pm10 <= 80) {
            badAir.push("보통😐");
        } else {
            badAir.push("나쁨😡");
        }

        //pm25는 초미세먼지 수치
        if (airItem.pm25 <= 15) {
            badAir.push("좋음😀");
        } else if (airItem.pm25 > 15 && airItem.pm10 <= 35) {
            badAir.push("보통😐");
        } else {
            badAir.push("나쁨😡");
        }

        res.send(`관측 지역: ${airItem.location} / 관측 시간: ${airItem.time} <br>
        미세먼지 ${badAir[0]} 초미세먼지 ${badAir[1]} 입니다.`);

    } catch (error) {
        console.log(error);
    }
});


app.listen(app.get('port'),() => 
    console.log('8080포트에서 서버 실행중')
);