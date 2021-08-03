# NPM

- [생활코딩 홈페이지(NPM)](https://opentutorials.org/module/4044)
  - [Youtube divide](https://www.youtube.com/playlist?list=PLuHgQVnccGMCwEXgZ-dep4SJlGEuYip-6)
- [생활코딩 홈페이지(NPM Package)](https://opentutorials.org/module/4571)
  - [Youtube divide](https://www.youtube.com/playlist?list=PLuHgQVnccGMB4krR04ug5nEXJ3sAEOWDL)

## npm 이란?
- Node Package Manager의 약자
- Package? 완성된 프로그램, Library와 같은 소프트웨어를 의미 
  - 다른 Package의 부품(Library, Module)
  - 독립된 하나의 애플리케이션, 프로그램(Package 자체가 완제품)
- NPM은 CLI 특히 Node.js에서 앱스토어와 같은 역할
  - 명령어를 통해 컴퓨터를 제어하는 것을 CLI(Command Line Interface)라고함

## npm 설치
- [Node.js](https://nodejs.org/ko/)를 설치하면 같이 설치되며, 설치 여부는 터미널 혹은 콘솔에서 확인 가능
```sh
# Shell
## Node.js 버젼 확인
node -v

## npm 버젼 확인
npm -v
```

## npm Package 검색 및 설치
- [npmjs](https://www.npmjs.com/)에서 원하는 패키지를 검색
- 인기도, 다운로드 수, 사용 방법, 내용을 확인하여 자신에게 적합하다고 생각되는 내용 설치
- Package는 크게 2가지로 분류될 수 있음 
  - 독립적으로 실행 가능한 CLI 프로그램(패키지)
  - 일종의 부품으로 다른 프로그램의 일부로 사용되는 패키지
- npm Registry에서 Package 다운 & 설치
```sh
# Shell
npm install package_name 
## Package가 현재 경로에 설치됨(보통 부품으로서 사용되는 경우)
## -g 옵션(global) 사용 시, 전역 Package로 설치되어 사용자의 폴더 어디서든 사용 가능(보통 독립적인 프로그램으로서 사용되는 경우)
```
> 권한 관련 문제 발생 시, 관리자 권한 실행(sudo)

## Package 설치 목록, 업데이트, 삭제
- Package는 사용자의 필요나 상황에 따라 업데이트, 삭제가 이루어짐
```sh
# Package 목록
npm list # 현재 디렉토리에 설치된 패키지를 보여줌 
## -g 옵션(global) 사용 시, 전역 Package로 설치된 목록을 보여줌
## --depth=0 옵션 사용 시, 의존 구조 없이 직접 설치한 Package 목록을 보여줌

# Package 업데이트
npm update package_name
## 전역 패키지의 경우 -g 추가

# 패키지 삭제
npm uninstll package_name
## 전역 패키지의 경우 -g 추가
```

## npm Package 생성 및 배포
1. provider 폴더 생성, npm init 을 통해 Node.js패키지 임을 명시, Package를 만들기 위한 기본 정보 설정
    - 입력을 마치면 [package.json](PracticeSource/NPM/provider/package.json)이 생성되고, 입력한 내용이 저장됨
```sh
# provider/Shell
mkdir provider

npm init
  package name: (npm) ## Package의 이름, @(스코프)는 범위를 정의할 때 사용
  entry point: (index.js) ## 해당 패키지의 시작점
```
2. entry point(시작 파일 - [index.js](PracticeSource/NPM/provider/index.js))에 제공할 기능을 작성
    - Package를 사용할 수 있게 export 해줌
    - Package를 require 했을 때 export 값이 전달됨
3. 작성된 provider Package를 npm registry에 등록하기
    - [npmjs](https://www.npmjs.com/)에 회원가입
    - npm publish 를 통해 npm registry에 등록, npmjs에서 확인 가능
    - 수정하여 업로드 하는 경우, package.json에서 버전 정보를 수정해야함
```sh
# provider/Shell
npm login 
  Username: ## npmjs ID
  Password: ## npmjs PW
  Email: ## npmjs Email
npm publish --access public 
## public으로 해당 Package를 업로드
## private(유료)으로도 Package를 업로드 가능
## 수정 업로드(버전) 업데이트의 경우, npm publish만 입력
```

## npm Package 사용하기
1. consumer 폴더 생성, npm init 을 통해 Node.js패키지 임을 명시, Package를 만들기 위한 기본 정보 설정
```sh
# consumer/Shell
mkdir consumer

npm init -y
## -y 옵션 사용 시, 기본값으로 Package가 생성됨
```
2. 앞서 작성한 Package(@chosangmuk/npm-practice) 설치
    - 해당 작업 완료 시, consumer에 node_modules 폴더가 생성
    - node_modules에 provider Package의 내용이 생성됨
    - [package.json](PracticeSource/NPM/consumer/package.json)에 dependencies가 추가됨
```sh
# consumer/Shell
npm install @chosangmuk/npm-practice
```
3. consumer의 임의의 파일([index.js](PracticeSource/NPM/consumer/index.js))에서 require하여 사용
4. provider package의 버젼이 수정(업데이트) 되는 경우
    - consumer에서 outdated 를 사용하여 최신 버젼 정보 확인
    - consumer의 [package.json](PracticeSource/NPM/consumer/package.json)에서 버전 정보 변경 후, npm update
    - 특수 문자를 사용하여 package를 자동 업데이트 할 수도 있음
```sh
# consumer/Shell
npm outdated
## 결과(업데이트 된 package가 없는 경우 출력 없음)
Package                   Current  Wanted  Latest  Location
@chosangmuk/npm-practice    0.0.1   0.0.1   0.0.2  consumer

npm update 
```

## Reference
- 도움이 될만한 사전지식
  - [POSIX CLI1](https://opentutorials.org/module/3747) 수업 참고
  - [WEB2 Node.js](https://opentutorials.org/course/3332) 수업 참고