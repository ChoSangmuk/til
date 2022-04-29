# At Work

## Reference
- @JavaScript ES6 차이점 요약 http://es6-features.org/#BlockScopedVariables
- @Jeus Config [https://technet.tmaxsoft.com/ ... ](https://technet.tmaxsoft.com/upload/download/online/jeus/pver-20140203-000001/server/chapter_server_conf.html)
- @Jeus Log 정보 [http://www.igloosec.co.kr/ ... ](http://www.igloosec.co.kr/BLOG_%20%EB%A1%9C%EA%B7%B8%20%EB%AA%A8%EB%8B%88%ED%84%B0%EB%A7%81%20%EB%B0%8F%20%EB%B6%84%EC%84%9D%EB%B0%A9%EC%95%88(Webtob,%20JEUS)?searchItem=&searchWord=&bbsCateId=1&gotoPage=1)
- @Linux CLI 메일 작성 및 전달 [https://www.lesstif.com/ ... ](https://www.lesstif.com/lpt/send-mail-from-linux-command-line-24445045.html)
- @Linux GitLab CE 설치 https://uxgjs.tistory.com/161
- @Linux SSH key Pair 생성 https://thekoguryo.github.io/oci/chapter03/3/
- @Linux(@Shell), @DB(@Oracle) Shell에서 Oracle 쿼리 실행 https://www.it-note.kr/180
- @Linux 하드 용량 부족 https://blog.1day1.org/493
- @MapReduce 개념 https://12bme.tistory.com/154
- @SVN Status [https://www.ict.griffith.edu.au/ ... ](https://www.ict.griffith.edu.au/teaching/2501ICT/archive/svn-book-html-chunk/svn.ref.svn.c.status.html)
- @Webtob SSL 인증서 패스워드 자동 입력 https://javafactory.tistory.com/m/866?category=448871

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

## HttpOnly 쿠키 옵션
- @Web, @Security
- Reference
  - [https://mingzz1.github.io/ ... ](https://mingzz1.github.io/pentesting/web/2020/02/04/Web-httponly_cookie.html/)
  - https://grooveshark.tistory.com/76
  - https://sarc.io/index.php/java/271-cookie-httponly

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
- Reference [https://jaynamm.tistory.com/ ... ](https://jaynamm.tistory.com/entry/%EB%A6%AC%EB%88%85%EC%8A%A4-sort-%EB%AA%85%EB%A0%B9%EC%96%B4)

## 정규식을 통한 파일, 폴더 삭제
- @Linux(@Shell)
```sh
# find [OPTION...] [PATH] [EXPRESSION...]
$ find . -name "*20200405*" -delete
```
- Reference https://goateedev.tistory.com/103

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

## MySQL Auto Commit
- @DB(@MySQL)
```sql
SELECT @@AUTOCOMMIT;  -- Auto Commit 여부 확인
SET AUTOCOMMIT = FALSE;  -- Auto Commit 해제, 0
SET AUTOCOMMIT = TRUE;  -- Auto Commit 설정, 1
```

## SVN 설치 오류 해결 및 저장소 생성, 이관
- @SVN
- 의존성 패키지(apr-util-1.6.1.tar) 설치 중 의존성 오류 발생
```log
오류: Failed dependencies: expat = 2.1.0-12.el7 is needed by expat-devel-2.1.0-12.el7.x86_64
```
- expat-2.2.10 의존성 추가 후 재설치
```sh
# expat-2.2.10 추가
./configure --prefix=/{PATH}/expat2.2.10
make && make install

# apr-util 재설치
./configure --prefix=/{PATH}/apr-util1.6.1 --with-apr=/{PATH}/apr1.6.5 --with-expat=/{PATH}/expat2.2.10
make && make insatll
```
- SVN 저장소 생성
```sh
svnadmin create --fs-type fsfs [저장소 이름]
```
- SVN dump 생설 및 설정 백업
  - /{PATH}/[저장소 이름]/conf/authz
  - /{PATH}/[저장소 이름]/conf/passwd
  - /{PATH}/[저장소 이름]/conf/svnserve.conf
```sh
# 기존 SVN
svnadmin dump /{PATH}/[저장소 이름] > [백업 파일 이름].dump
```
- SVN 백업 반영
```sh
# 저장소 생성
svnadmin create /{NEW_PATH}/[새로운 저장소 이름]

# 덤프 복원
svnadmin load /{NEW_PATH}/[새로운 저장소 이름] < [백업 파일 이름].dump
```
- Reference
  - https://hreeman.tistory.com/m/75
  - https://shonm.tistory.com/614
    - https://github.com/libexpat/libexpat/releases
  - https://bigcode.tistory.com/4

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
git remote add ${REMOTE_REPOSITORY_NAME} ${GIT_REMOTE_REPOSITORY_URL} # 외부 저장소 명칭으로 추가
git config -l --global | grep user # 사용자 정보 확인
git config --global user.name "ChoSangmuk" # 사용자 이름 변경
git config --global user.email "tkdanr612@gmail.com" # 사용자 메일 변경
git push ${REMOTE_REPOSITORY_NAME} master # 특정 외부 저장소 지정 push
git pull ${REMOTE_REPOSITORY_NAME} master # 특정 외부 저장소 지정 pull
git remote set-url ${REMOTE_REPOSITORY_NAME} ${GIT_REMOTE_REPOSITORY_URL} # 원격저장소 주소 변경
git remote rename ${REMOTE_REPOSITORY_NAME} ${REMOTE_REPOSITORY_NEW_NAME} # 원격저장소 이름 변경
```
- Reference https://blog.nobletuna.com/2019/07/02/git1/

## 포트 상태 확인과 특정 프로세스 종료
- @Linux(@Shell), @Windows
```sh
# 포트 상태 확인
netstat -ano

# Pid 로 프로세스 종료
kill -9 ${PID}
# or
taskkill /f /pid ${PID}
```

## CSS overflow, 선택자 우선순위
- @Web(@CSS)
- overflow 
  - visible : 기본 값, 넘칠 경우 컨텐츠가 상자 밖으로 보여지게됨
  - hidden : 넘치는 부분은 잘려서 보여지지 않음
  - scroll : 스크롤바가 추가되어 스크롤할 수 있음(가로, 세로 모두 추가 가능)
  - auto : 컨텐츠 량에 따라 스크롤바를 추가할지 자동으로 결정( 필요에 따라 가로, 세로 별도로 추가될 수도 있음)
```css
overflow-x: scroll;
overflow-y: hidden;
```
- 선택자 우선순위
```
!important > 인라인 스타일 > 아이디 선택자 > 클래스/속성/가상 선택자 > 태그 선택자 > 전체 선택자
```
- Reference [http://www.devdic.com/ ... ](http://www.devdic.com/css/refer/documents/document:1806/%EC%84%A0%ED%83%9D%EC%9E%90(Selector)%EC%9D%98-%EC%9A%B0%EC%84%A0-%EC%88%9C%EC%9C%84)

## Spring Tomcat 개발, 운영 환경에 따른 설정
- @Java, @Spring, @Tomcat
- 로컬 PC에서 톰캣이 작동하지 않는 오류 발생,  mysqlDataSource를 찾지 못했다는 내용의 로그 확인
```log
Caused by: org.springframework.beans.factory.NoSuchBeanDefinitionException: No bean named 'mysqlDataSource' is defined
```
- 데이터베이스 설정 정보, 파일 시스템 위치 설정 등 환경에 따라 다른 Config를 적용해야하는 경우가 많음
  - 운영 중인 시스템에서는 XML을 이용한 설정을 사용
  - 최근에는 Java annotation 을 사용한 자동 설정과 주입 방식을 많이 사용
```xml
<beans profile="local,dev">
  <bean id="mysqlDataSource" class="org.springframework.jndi.JndiObjectFactoryBean">
    <property name="jndiName" value="java:comp/env/jdbc/MySQLDS_DEV"/>
    <property name="resourceRef" value="true"/>
  </bean>

  <bean ... />
</beans>

<beans profile="prod">
  <bean id="mysqlDataSource" class="org.springframework.jndi.JndiObjectFactoryBean">
    <property name="jndiName" value="java:comp/env/jdbc/MySQLDS_PROD"/>
    <property name="resourceRef" value="true"/>
  </bean>

  <bean ... />
</beans>
```
- Tomcat Arguments의 profile 설정하여 문제 해결
```sh
-Dspring.profiles.active="local"
```
- Reference https://hhyemi.github.io/2020/10/06/10061148.html

## 대용량 파일 다운로드 시 오류
- @Java, @Web
- 사용자가 업로드한 파일 중 대용량(1000KB이상) 파일을 다시 다운로드 받을 때, 무한 로딩 및 broken pipe 문제 발생 
- response 헤더 전송 파일 길이 지정
```java
HttpServletResponse reResponse = valueOfResponse(response, realfilename, outfilename);
File file = new File(rootPath + filePath + realfilename);
try (FileInputStream in = new FileInputStream(file);
    ServletOutputStream out = reResponse.getOutputStream()) {
  byte[] b = new byte[in.available()];
  reResponse.setContentLength(b.length); // 추가
  in.read(b);
  out.write(b);
  out.flush();
} catch (Exception e) {
  // ...
} finally {
  // ... 
}
```
- Reference https://okky.kr/article/34764

## Linux 서버 시작 시, Jenkins Tomcat 자동 시작 설정
- @Linux(@Shell), @Tomcat, @Jenkins
- /etc/rc.d/init.d/jenkins 스크립트 예시
  - JENKINS_HOME을 지정하지 않으면 시작계정의 홈디렉터리 하위에 설정파일이 생성됨
```sh
#!/bin/sh
#
# Jenkins auto-start
#
# chkconfig: 2345 90 90
# description: Auto-starts jenkins
# processname: jenkins

export JAVA_HOME=/usr
export CATALINA_HOME=/SW/jenkins/apache-tomcat-8.5.16
export JENKINS_HOME=/SW/jenkins/config
export CLASS_PATH=$JAVA_HOME/jre/lib:$JAVA_HOME/lib/tools.jar:$CATALINA_HOME/lib/jsp-api.jar:$CATALINA_HOME/lib/servlet-api.jar:$CATALINA_HOME/conf:$CATALINA_HOME/bin

case $1 in
start)
sh /SW/jenkins/apache-tomcat-8.5.16/bin/startup.sh
;;
stop)
sh /SW/jenkins/apache-tomcat-8.5.16/bin/shutdown.sh
;;
restart)
sh /SW/jenkins/apache-tomcat-8.5.16/bin/shutdown.sh
sh /SW/jenkins/apache-tomcat-8.5.16/bin/startup.sh
;;
esac
exit 0
```
- Reference
  - https://xzio.tistory.com/28
  - https://lejljs.tistory.com/13