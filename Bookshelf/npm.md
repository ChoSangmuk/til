# npm

- [생활코딩 홈페이지(npm)](https://opentutorials.org/module/4044)
  - [Youtube divide](https://www.youtube.com/playlist?list=PLuHgQVnccGMCwEXgZ-dep4SJlGEuYip-6)
- [생활코딩 홈페이지(npm Package)](https://opentutorials.org/module/4571)
  - [Youtube divide](https://www.youtube.com/playlist?list=PLuHgQVnccGMB4krR04ug5nEXJ3sAEOWDL)

## npm 이란?
- Node Package Manager의 약자
- Package? 완성된 프로그램, Library와 같은 소프트웨어를 의미 
  - 다른 Package의 부품(Library, Module)
  - 독립된 하나의 애플리케이션, 프로그램(Package 자체가 완제품)
- npm은 CLI 특히 Node.js에서 앱스토어와 같은 역할
  - 명령어를 통해 컴퓨터를 제어하는 것을 CLI(Command Line Interface)라고함

## npm 설치, Package 검색 및 설치
- [Node.js](https://nodejs.org/ko/)를 설치하면 같이 설치되며, 설치 여부는 터미널 혹은 콘솔에서 확인 가능
```sh
# Shell
node -v ## Node.js 버젼 확인
npm -v ## npm 버젼 확인
```
- [npmjs](https://www.npmjs.com/)(npm Registry)에서 원하는 Package를 검색
- 사용 방법, 내용을 확인하여 자신에게 적합하다고 생각되는 Package를 CLI로 설치
```sh
# Shell
npm install package_name 
## Package가 현재 경로에 설치됨, 보통 부품으로서 사용되는 경우

npm install --global package_name 
## -g 옵션(--global) 사용 시, 전역 Package로 설치되며 어디서든 사용 가능
## 보통 독립적인 프로그램으로서 사용되는 경우
```
> 권한 관련 문제 발생 시, 관리자 권한 실행(sudo)

## Package 설치 목록, 업데이트, 삭제
- Package는 개발자의 필요나 상황에 따라 업데이트, 삭제가 이루어짐
```sh
# Shell
npm list ## Package 목록 확인
## 현재 프로젝트(폴더)에 설치된 Package를 보여줌 
## --depth=0 옵션 사용 시, 의존 구조 없이 직접 설치한 Package 목록을 보여줌

npm update package_name ## Package 업데이트

npm uninstll package_name ## 패키지 삭제

## 공통적으로 -g 옵션(--global) 사용 시, 전역으로 설치된 Package에 적용됨
```

## Package 생성 및 배포
1. npm init 을 통해 현재 프로젝트(폴더)가 Node.js Package 임을 명시
```sh
# Shell in provider
npm init
  package name: (provider) ## Package의 이름, @(스코프)는 범위를 정의할 때 사용
  entry point: (index.js) ## 해당 패키지의 시작점
```
2. entry point([index.js](PracticeSource/npm/provider/index.js))를 시작으로 제공할 기능을 작성
    - 소비자가 Package를 require 했을 때 module.exports 값이 전달됨
3. 작성된 Package를 npm registry에 등록하기
    - [npmjs](https://www.npmjs.com/)에 회원가입, npm publish 를 통해 npmjs(npm registry)에 등록
    - 새 버전을 배포하는 경우, package.json에서 버전 정보를 수정해야함
```sh
# Shell in provider
npm login ## Enter npmjs information
  Username:
  Password:
  Email:

npm publish --access public 
## public으로 해당 Package를 업로드
## private(유료)으로도 Package를 업로드 가능
## 새 버전을 배포하는 경우, npm publish만 입력
```
4. 독립된 프로젝트로 작동 가능하게끔 [cli.js](PracticeSource/npm/provider/cli.js) 작성
    - 실행 시, 입력 값을 사용하기위해 process.argv 를 사용
    - cli.js에 *#!/usr/bin/env node* 를 작성하여 Node.js 실행 파일임을 알림
5. [package.json](PracticeSource/npm/provider/package.json)에 bin 이라는 속성에 실행될 명령어를 작성

## Package 사용하기
1. 사용자 입장에서 앞서 작성한 Package(@chosangmuk/npm-test) 설치
    - 해당 작업 완료 시, node_modules 폴더가 생성, 설치한 Package의 내용이 생성됨
```sh
# Shell in consumer
npm install @chosangmuk/npm-test
```
2. 해당 Package의 이름으로 require하여 사용([index.js](PracticeSource/npm/consumer/index.js))
3. Package의 최신 버젼 확인 및 업데이트
    - *npm outdated* 를 사용하여 최신 버젼 정보 확인
    - consumer의 [package.json](PracticeSource/npm/consumer/package.json)에서 버전 정보 변경 후, npm update
    - 특수 문자를 사용하여 package를 자동 업데이트 할 수도 있음
```sh
# consumer/Shell
npm outdated
## 현재 프로젝트의 버젼 정보 확인
## 결과(업데이트 된 package가 없는 경우 출력 없음)
Package                   Current  Wanted  Latest  Location
@chosangmuk/npm-test    0.0.1   0.0.1   0.0.2  consumer

npm update 
## package.json에서 버전 정보 수정 후, update
```
5. 독립된 프로그램 package 실행시키기
    - Local 환경(폴더 내)에 설치, *node_module/.bin/command*로 실행
    - Global 환경(모든 폴더)에 설치, *command* 실행
    - npx를 이용하여 1회만 설치, 사용, 삭제 (실행 우선순위 Local > Global > npx)
    - npx -p 옵션 사용시 상세 명령어 입력 가능

## Reference
- 도움이 될만한 사전지식
  - [POSIX CLI1](https://opentutorials.org/module/3747) 수업 참고
  - [WEB2 Node.js](https://opentutorials.org/course/3332) 수업 참고