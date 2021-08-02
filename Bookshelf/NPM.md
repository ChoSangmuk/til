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
> 권한 관련 문제 발생 시, sudo로 해결 관리자 권한 실행(sudo)

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

## Reference
- 도움이 될만한 사전지식
  - [POSIX CLI1](https://opentutorials.org/module/3747) 수업 참고
  - [WEB2 Node.js](https://opentutorials.org/course/3332) 수업 참고