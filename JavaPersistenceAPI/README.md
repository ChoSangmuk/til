# 자바 ORM 표준 JPA 프로그래밍

<a href="http://www.kyobobook.co.kr/product/detailViewKor.laf?ejkGb=KOR&mallGb=KOR&barcode=9788960777330&orderClick=LAG&Kc=">
  <img src="./Image/Java ORM Standard JPA Programing cover.jpeg" width="250" height="50%">
</a>

## H2 데이터베이스 설치
- [H2 Database 2015.04.10 다운로드](https://h2database.com/h2-2015-04-10.zip) (클릭 시 해당 도서에서 사용하는 버전으로 다운로드)
- 압축 해제 후, Shell Script에 실행 권한 부여 및 실행
```sh
# 폴더 이동
cd h2/bin

# Mac을 사용하는 경우 실행 권한 부여
chmod 755 h2.sh

# H2 Database 실행
./h2.sh
``` 
- [웹 화면](http://localhost:8082/)에서 DataBase 파일 생성 및 접근
```
jdbc:h2:~/Documents/twil/JavaPersistenceAPI/database/example
-> .../database 에 example.mv.db 가 생성됨 (스프링 프로젝트의 -를 _로 변경하여 이름으로 사용) 

jdbc:h2:tcp://localhost/~/Documents/twil/JavaPersistenceAPI/database/example
-> 파일 시스템이 아닌 tcp 소켓으로 접근, JDBC가 사용해야할 정보
```

## Reference
- [JPA 요약 자료](https://ultrakain.gitbooks.io/jpa/content/)
- [Gradle persistence.xml With MySql](https://krksap.tistory.com/806)