# Spring Boot Study

- [Spring Boot 공식 홈페이지](https://spring.io/projects/spring-boot)
  - [Spring Quick start Guide](quick-start)
  - [Building a RESTful Web Service](basic-rest-service)
- 도서
  - [React.js, 스프링 부트, AWS로 배우는 웹 개발 101 Todo](todo-101)
- [Inflearn (김영한)](https://www.inflearn.com/users/@yh)
  - [스프링 입문 - 코드로 배우는 스프링 부트, 웹 MVC, DB 접근 기술](introduction)
  - [스프링 핵심 원리 - 기본편(66.1%)](core-basic)

## Docker 개발 환경 사용하기
### install OpenJDK 11 on Ubuntu
```sh
docker run -it ubuntu
  apt-get update && apt-get upgrade -y
  apt-get install -y openjdk-11-jdk
docker commit -m "openjdk 11 installed" thirsty_brattain openjdk11:0.1
docker run -p 8080:8080 -v /Users/chosangmuk/Documents:/workspace -it openjdk11:0.1  
```
### install AdoptOpenJDK 11, HotSpot on Ubuntu
```sh
docker run -it ubuntu
  apt-get update && apt-get upgrade -y 
  apt-get install -y wget apt-transport-https gnupg sudo software-properties-common
  wget -qO - https://adoptopenjdk.jfrog.io/adoptopenjdk/api/gpg/key/public | sudo apt-key add -
  sudo add-apt-repository --yes https://adoptopenjdk.jfrog.io/adoptopenjdk/deb/
  apt-get install -y adoptopenjdk-11-hotspot
docker commit -m "adoptopenjdk 11, hotspot installed" angry_greider adoptopenjdk11:0.1
docker run -p 8080:8080 -v /Users/chosangmuk/Documents:/workspace -it adoptopenjdk11:0.1  
```

## Reference
- install OpenJDK 11 on Ubuntu
  - https://codechacha.com/ko/ubuntu-install-open-jdk11/
- install AdoptOpenJDK 11, HotSpot on Ubuntu
  - https://adoptopenjdk.net/installation.html#linux-pkg
  - https://medium.com/adoptopenjdk/adoptopenjdk-rpm-and-deb-files-7003ba38144e
- JUnit 참고
  - https://mangkyu.tistory.com/143 
  - https://mangkyu.tistory.com/144
  - https://mangkyu.tistory.com/145
  - https://www.nextree.co.kr/p11104/
  - https://goddaehee.tistory.com/210
  - https://gracelove91.tistory.com/107
  - https://epthffh.tistory.com/entry/Junit을-이용한-단위테스트
  - http://junit.sourceforge.net/javadoc/org/junit/Assert.html