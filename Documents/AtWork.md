# At Work

## SVN Status
- @SVN
- Reference [https://www.ict.griffith.edu.au/teaching/2501ICT ... ](https://www.ict.griffith.edu.au/teaching/2501ICT/archive/svn-book-html-chunk/svn.ref.svn.c.status.html)

## MapReduce 개념
- @MapReduce
- Reference https://12bme.tistory.com/154

## Shell에서 Oracle SQL문 실행
- @Linux(@Shell), @DB(@Oracle)
- Reference https://www.it-note.kr/180

## MongoDB Query
- @DB(@MongoDB)
- db.coll_name.find({},{}).sort({}) 형태로 사용
- Reference https://velopert.com/479

## ELK stack Filebeat 설치
- @Linux, @ELK(@FileBeat, @Logstash, @Elasticsearch, @Kibana)
- Reference
  - [https://blog.naver.com/PostView.nhn?blogId=wideeyed ... ](https://blog.naver.com/PostView.nhn?blogId=wideeyed&logNo=221299924317&redirect=Dlog&widgetTypeCall=true&directAccess=false)
  - [https://github.com/higee/elastic/wiki/ ... ](https://github.com/higee/elastic/wiki/Elastic-Stack-%EC%84%A4%EC%B9%98-%EB%B0%8F-%ED%99%98%EA%B2%BD-%EC%84%A4%EC%A0%95.#install_logstash)

## 로그인 쉘(Login shell), 논 로그인 쉘의 실행 절차
- @Linux(@Shell)
- Reference
  - https://infosecguide.tistory.com/106 
  - https://hippogrammer.tistory.com/57

## VSCode - SVN 연동
- @IDE(@VSCode), @SVN
- Reference
  - https://meyouus.tistory.com/266
  - https://dzzienki.tistory.com/64

## Oracle 대용량 데이터 삽입
- @DB(@Oracle(@insert))
- CTAS(Create Table As Select)
- Oracle 대용량 데이터 업데이트의 경우, UnDo, ReDo 내역 저장으로 인해 시간이 오래걸림, 이를 해결하기위해 테이블을 생성하면서 업데이트

## Qmail tcp.smtp 수정 후 반영
- @Linux, @Qmail
```sh
tcprules /etc/tcp.smtp.cdb /etc/tcp.smtp.tmp < /etc/tcp.smtp
```
- Reference https://sysdocu.tistory.com/450?category=486804
  
## label 태그 for 속성
- @Web(@HTML)
- label for 속성으로 input 태그와 label 태그간 연관 관계 설정하여 의미있는 마크업과 넓은 클릭 영역을 제공
  - label 클릭 시, 연관된 input 태그가 활성화
- type이 checkbox 일 경우 label 클릭 시, 체크박스 선택
```html
<label for="subject">제목</label>
<input id="subject" name="subject" type="text" />
```
- Reference
  - https://escane.tistory.com/130
  - http://www.w3schools.com/tags/tag_label.asp

## 파일 내용 정렬 및 중복 제거
- @Linux(@Shell)
- sort 명령어 사용 방법
```
# sort [옵션] ... [파일명] ...

[자주 사용하는 옵션]
-r, --reverse : 역순으로 정렬한다.
-k, --key=POS1 : 정해진 필드를 기준으로 정렬한다. ex) sort -k2 : 2번째 필드로 정렬
-u, --unique : 정렬 후 중복된 내용을 제거한다.
-t, --field-separator=SEP : 필드 구분자를 지정, -k 옵션으로 필드를 지정해서 사용할 때 좋다.
-f, --ignore-case : 대소문자를 구분하지 않고 정렬한다.
```
```sh
cat sample.txt | grep something | sort -u > output.txt
```
- Reference https://jaynamm.tistory.com/entry/%EB%A6%AC%EB%88%85%EC%8A%A4-sort-%EB%AA%85%EB%A0%B9%EC%96%B4

## window.showModalDialog 변경
- @Web(@HTML, @JavaScript)
- 달력 팝업이 IE에서만 작동

### 문제 코드를 단순하게 표현
- index.html
```html
<html>

<head>
  <script type='text/javascript' src='index.js'></script>
  <script>
    function popItemCalendar(obj) {
      var dt = getCalendar();
      if (dt == null) return;
      obj.value = dt;
    }
    // 팝업에서 선택된 날짜 값 리턴 -> callback 함수 실행
    function popItemCalendar(obj) {
      getCalendar(function (dt) {
        if (dt == null) return;
        obj.value = dt;
      });
    }
  </script>
</head>

<body>
  <input id='write_dt' type='text' value='' readonly>
  <a href='javascript:popCalendar(write_dt)'><button>popCalendar</button></a>
  <br>
  <input id='buy_dt' type='text' value='' readonly>
  <a href='javascript:popItemCalendar(buy_dt)'><button>popItemCalendar</button></a>
</body>

</html>
```
- index.js
```js
function popCalendar(obj) {
  var Str_re = getCalendar();
  if (Str_re == null) obj.value = "";
  else obj.value = Str_re;
}
function getCalendar() {
  var set = 'dialogHeight:300px; dialogWidth:255px; scroll:0; status:0; resizable:0;';
  var Str_re = window.showModalDialog('child.html', 'popup', set);
  return Str_re;
}
// 팝업에서 선택된 날짜 값 리턴 -> callback 함수 실행
function popCalendar(obj) {
  getCalendar(function (Str_re) {
    if (Str_re == null) obj.value = "";
    else obj.value = Str_re;
  });
}
function getCalendar(callback) {
  if (!window.showModalDialog) {
    // showModalDialog는 크롬, edge에서 실행이 불가능함으로 open으로 대체
    var popupWidth = 250;
    var popupHeight = 246;
    var popupX = (window.screen.width / 2) - (popupWidth / 2);
    var popupY = (window.screen.height / 2) - (popupHeight / 2);
    var set = 'toolbar=no, location=no, directories=no, status=no, menubar=no, scrollbars=no, resizable=no, copyhistory=no, height=' + popupHeight + ', width=' + popupWidth + ', left=' + popupX + ', top=' + popupY;
    var Str_re = window.open('child.html', 'popup', set);
    Str_re.onbeforeunload = function () {
      callback(Str_re.returnValue)
    };
  } else {
    var set = "dialogHeight:246px; dialogWidth:250px; scroll:0; status:0; resizable:0;";
    var Str_re = window.showModalDialog('child.html', 'popup', set);
    callback(Str_re);
  }
}
```
- child.html
```js
<html>

<head>
  <script>
    function winClose() {
      window.returnValue = '2022-02-18';
      window.close();
    }
  </script>
</head>

<body>
  <a href="javascript:winClose()">
    <button>go</button>
  </a>
</body>

</html>
```
- Reference https://mebadong.tistory.com/39

## Jenkins curl 실행
- @Jenkins, @Linux(@Shell(@curl))
```sh
# 1. Job 실행
curl -X post "http://${JENKINS_ID}:${JENKINS_PW}@${JENKINS_IP}:${JENKINS_PORT}/jenkins/job/${JOB_NAME}/build?token=${JOB_NAME}"

# 2. console log 혹은 결과 확인
curl "http://${JENKINS_ID}:${JENKINS_PW}@${JENKINS_IP}:${JENKINS_PORT}/jenkins/job/${JOB_NAME}/lastBuild/consoleText"
```
- Reference http://confluence.augkorea.org/pages/viewpage.action?pageId=19629608 - discarded

## Telegram Bot API
- @TelegramAPI, @Linux(@Shell(@curl))
- 텔레그램 봇 생성 및 설정 필요
- Jenkins에 연계하여 사용할 경우, 플러그인([Telegram Notification](https://plugins.jenkins.io/telegram-notifications)) 추가
- Telegram Bot curl Message
```sh
curl "https://api.telegram.org/${HTTP_API}/sendMessage?chat_id=${CHAT_ID}&text=Hello"
```
- Reference https://krksap.tistory.com/836

## MySQL 상태
- @DB(@MySQL)
- Aborted_clients : 클라이언트가 연결을 적절히 닫지않아서 죽었기때문에 끊어진 연결수
- Aborted_connects : 연결실패된 mysql서버에 연결시도 수.
- Bytes_received : 모든 클라이언트로 부터 받은 바이트 수
- Bytes_sent : 모든 클라이언트에게 보낸 바이트수
- Connections : mysql서버에 연결시도한 수
- Max_used_connections : 동시사용 연결 최대수
- Questions : 서버에서 보낸 쿼리수
- Threads_cached : 스레드 캐시에서 쓰레드 수
- Threads_connected : 현재 오픈된 연결수
- Threads_created : 연결을 다루기위해 생성된 쓰레드 수
- Threads_running : sleeping하지 않는 쓰레드 수
- Uptime : 서버가 스타트된 후로 지금까지의 시
- Questions/Uptime = 초당 쿼리수를 나타낸다
- Connections / Uptime = 초당 연결수를 알 수 있다
- Questions / Connections = 연결당 쿼리 처리수를 알 수 있다

## SVN -> Git migration
- @SVN, @Git
- SVN -> Git migration command
```sh
git svn clone svn://${SVN_IP}/${PROJECT_NAME} --username ${SVN_ID} --no-metadata -A ${USER_PROFILE} ./${PROJECT_NAME}
```
- USER_PROFILE
```txt
SVN_ID = GIT_NAME <GIT_MAIL>
```
- Git clone 명령어는 git svn init 과, git svn fetch를 순서대로 실행하는 것과 같음
- -r 옵션을 통해서, revision 범위를 설정
  - git svn clone -s -r1:HEAD [svn repository 주소] ( revision 1 ~ HEAD 까지 복사 )
- 최초 가져올 때, 특정 revision 을 가져올 경우에는
  - git init [svn repository 주소]
  - git fetch -r [시작:끝] 
- Reference
  - https://onestepcloser.tistory.com/149
  - https://gist.github.com/ikaruce/9c8dc57849e003df6fdc

## Git 설정 정보 변경
- @Git
```sh
git remote -v # 외부 저장소 목록 확인
git remote remove origin # 외부 저장소 연결 해제
git remote add origin ${GIT_REMOTE_REPOSITORY_URL} # 외부 저장소 추가
git config -l --global | grep user # 사용자 정보 확인
git config --global user.name "ChoSangmuk" # 사용자 이름 변경
git config --global user.email "tkdanr612@gmail.com" # 사용자 메일 변경
```