# Webpack

- [생활코딩 홈페이지](https://opentutorials.org/module/4566)
- [Youtube divide](https://www.youtube.com/playlist?list=PLuHgQVnccGMChcT9IKopFDoAIoTA-03DA)

## 1. 수업소개
- [WEB2 JavaScript](https://opentutorials.org/module/3180) 수업 참고
  - [학습 내용 정리](./JavaScriptOpentutorials.md)
- [npm](https://opentutorials.org/module/4044) 수업 참고
  - [학습 내용 정리](./npm.md)

<br>![concept](Image/Webpack/concept.png)<br>

- [Webpack](https://webpack.kr/) 
  - 브라우저에서 웹 페이지를 동적으로 제어하는 기술인 **JavaScript를 더 잘다루기 위한 기술**
  - Webpack을 이용하여 하나의 JavaScript 파일에 JS, CSS, 이미지와 같은 여러 모듈들을 모을 수 있고, 필요하다면 다시 분리할 수 있음
- 웹에 요구사항이 점점 더 다양하고 복잡해짐에 따라 점점 더 많은 파일이 필요, 이로 인해 서버와의 통신이 여러번 반복되며 자원이 낭비됨
- 다양한 JavaScript Package를 사용할 경우, 서로 다른 Package에서 서로 같은 이름의 변수나 함수를 사용할 수 있음. 이는 예상하지 못한 충돌, 의도하지 않은 결과를 발생시킴
- 이러한 문제를 해결하기 위해 등장한 도구를 **Bundler**라고 함
  - Bundle(묶음) 즉, 여러 개의 파일을 묶어주는 도구
  - Webpack, Browserify, Parcel 등이 이에 속함

## 2. 웹팩이전의 세계와 모듈의 개념
- JS로 HTML의 화면을 그려주는 간단한 예제 작성, module의 유무에 따른 차이 비교
- 파일 시스템으로는 실행이 불가능하니 VS Code Live Server 플러그인 이용
- withoutModule
  - [index.html](PracticeSource/Webpack/withoutModule/index.html), [hello.js](PracticeSource/Webpack/withoutModule/source/hello.js), [world.js](PracticeSource/Webpack/withoutModule/source/world.js)
  - 서로 같은 이름의 변수를 사용하기 때문에 의도치 않는 결과가 생성될 가능성이 있음
- withModule
  - [index.html](PracticeSource/Webpack/withModule/index.html), [hello.js](PracticeSource/Webpack/withModule/source/hello.js), [world.js](PracticeSource/Webpack/withModule/source/world.js)
  - 모듈을 사용하고 싶은 script 태그의 type을 module로 설정
  - 전통적인 script 호출 방법 대신 script 태그 내부에서 **import A from 'path'** 키워드 사용
  - 호출 대상이 되는 script 파일에서는 **export** 키워드로 외부에서 사용될 변수, 함수를 정의
  - module은 비교적 최신 기능이기 때문에 브라우저간 호환성 문제가 있으며, module이 많아질수록 더 많은 자원과 시간을 요구함
- 이러한 요구와 문제를 해결하기위해 **Bundler**라는 도구가 생겨남

## 3. 웹팩의 도입
- Webpack 도입 시, refactoring 효과를 기대할 수 있음
- refactoring : 구동되는 방법은 그대로 유지하며, 내부의 코드를 더 효율적으로 바꾸는 과정
- [앞서 작성한 코드](PracticeSource/Webpack/withModule/index.html)의 기능은 유지, 구형 브라우저에서 사용 가능하며 여러 개의 파일을 하나의 파일(Bundle)로 제공
- Webpack을 사용하기 위해 프로젝트를 Node.js Package로 설정하고 Webpack 설치
```sh
# Shell
npm init -y # Node.js Package로 설정
npm install --save-dev webpack webpack-cli # webpack 설치
```
- 소스코드 수정 [index.html](PracticeSource/Webpack/startWebpack/index.html), [index.js](PracticeSource/Webpack/startWebpack/source/index.js), [hello.js](PracticeSource/Webpack/startWebpack/source/hello.js), [world.js](PracticeSource/Webpack/startWebpack/source/world.js)
- Application의 entry(기입, 시작) file은 index.js
- Webpack을 사용하여 index.js을 Bundling. 이때, index.js에서 사용하는 하위 파일도 포함됨
- Bundling 결과를 public 폴더에 [index_bundle.js](PracticeSource/Webpack/startWebpack/public/index_bundle.js)로 저장
```sh
# Shell
npx webpack --mode development --entry ./source/index.js --output-path ./public --output-filename index_bundle.js
```

## 4. 설정파일 도입
- Webpack으로 Bundling 진행 시 사용되는 명령어는 프로젝트가 커질수록 별도의 관리가 필요
- 가독성과 재사용성을 증가시킬 방법으로 설정 파일(webpack.config.js)을 만들고, 해당 파일에 Webpack 실행 명령어를 정리
- [공식 홈페이지 Config 문서](https://webpack.kr/configuration/) 참고
  - __dirname는 현재 파일의 경로를 알려주는 Node.js/path 변수
```js
// webpack.config.js
const path = require('path');

module.exports = {
  mode: "development", // "production" | "development" | "none"
  // Chosen mode tells webpack to use its built-in optimizations accordingly.
  entry: "./source/index.js", // string | object | array
  // defaults to ./src
  // Here the application starts executing
  // and webpack starts bundling
  output: {
    // options related to how webpack emits results
    path: path.resolve(__dirname, "public"), // string (default)
    // the target directory for all output files
    // must be an absolute path (use the Node.js path module)
    filename: "index_bundle.js" // string (default)
    // the filename template for entry chunks
  }
}
```
- 설정 파일을 바탕으로 Webpack Bundling 진행
- config 파일 명으로 default 값(webpack.config.js)을 사용했다면 옵션을 주지 않아도됨
```sh
# Shell
npx webpack --config webpack.config.js
npx webpack 
```

## 5. 모드의 도입
- Webpack은 굉장히 많은 설정을 가지기 때문에 기본적인 설정값을 가짐
- mode 옵션은 기본 설정값 중 하나이며, 기본값은 production로 설정됨
  - none, development, production 값을 가질 수 있음
- 시스템 환경 변수와 조건문을 통해 webpack.config.js 내부에서 설정을 변경하는 것도 가능
- [공식 홈페이지 Mode 문서](https://webpack.kr/configuration/mode/#root) 참고

## 6. 로더의 도입
- 기존의 HTML에서 CSS를 사용하고 싶다면 link Tag를 통해 해당 파일을 불러옴
- CSS도 Webpack에서 제공하는 Loader(style-loader, css-loader)를 통해 Bundling이 가능
- CSS를 Bundling 해주는 Loader를 설치
```sh
# Shell
npm install --save-dev style-loader css-loader
```
- webpack.config.js 수정 
  - module, test의 정규표현식에 해당하는 자원은 use에 작성된 loader를 **역순으로 통과** 시킴
  - css-loader가 CSS파일을 JavaScript의 형태로 Bundling해서 Webpack으로 가져옴 
```js
// webpack.config.js
const path = require('path');

module.exports = {
  mode: "development",
  entry: "./source/index.js",
  output: {/* */},
  module: {
    rules: [
      {
        test: /\.css$/,
        use: ['style-loader', 'css-loader'],
      },
    ],
  },
}
```
- Bundling된 CSS를 사용할 때는 entry 파일에서 해당 CSS를 import
  - style-loader가 JavaScript의 형태로 주입된 CSS를 자동으로 head tag 안에 style 태그로 주입해줌
```js
// index.js
import hello_word from './hello';
import world_word from './world';
import css from './style.css'; // CSS import
document.querySelector('#root').innerHTML = hello_word + " " + world_word;
```
- [공식 홈페이지 Asset Management 문서](https://webpack.kr/guides/asset-management/) 참고
- [공식 홈페이지 Loaders 문서](https://webpack.kr/loaders/) 참고

## 7. output 설정
- 각각의 페이지(index.html, about.html)에서 서로 다른 Bundle을 사용하는 경우의 Bundling 설정
- webpack.config.js의 entry 속성을 객체 형태{}로 변경, entry 파일 경로에 이름을 지정
- entry 속성에 정의된 파일을 전부 Bundling, filename에 \[name\]을 사용하면 entry에 설정한 이름으로 Bundling됨
  - 결과물 : public/index_bundle.js, public/about_bundle.js
```js
// webpack.config.js
const path = require('path');

module.exports = {
  mode: "development",
  entry: {
    index: "./source/index.js", 
    about: "./source/about.js"
  },
  output: {
    path: path.resolve(__dirname, "public"),
    filename: "[name]_bundle.js"
  },
  module: {/* */},
}
```
- [공식 홈페이지 Output 문서](https://webpack.kr/configuration/output/) 참고

## 8. 플러그인의 도입
## 9. 선물
## 10. npm 패키지 사용
## 11. 수업을 마치며
## Reference