# 02장: 자바스크립트란?

## 2.1 자바스크립트의 탄생
1995년 Netscape Communications는 **웹 페이지의 보조적인 기능을 위해 브라우저에서 동작하는 경량 프로그래밍 언어** 도입을 결정하였고, 이때 브렌던 아이크(Brendan Eich)에 의해 개발된 언어가 **자바스크립트(JavaScript)** 다. 자바스크립트는 1996년 3월 Netscape Navigator 2에 탑재되었고 모카(Mocha), 라이브스크립트(LiveScript)를 거쳐 자바스크립트(JavaScript)라는 이름으로 최종 명명되었다.

<img src="../Image/netscape-navigator-2.png" width="650" height="100%"><br> - Netscape Navigator 2

<br>

## 2.2 자바스크립트의 표준화
1996년 8월, 마이크로소프트는 자바스크립트의 파생 버전인 JScript를 자사 OS의 기본 브라우저인 인터넷 익스플로러(Internet Explorer, IE)에 탑재했다. IE의 JScript와 Netscape의 자바스크립트가 표준화되지 못하고 적당히 호환되었고, 이로 인해 **브라우저에 따라 웹 페이지가 정상적으로 작동하지 않는 크로스 브라우징 이슈**가 발생했다.<br>
1996년 11월, Netscape에서 컴퓨터 시스템의 표준을 관리하는 기구, ECMA International에 자바스크립트 표준화를 요청하였다. 1997년 7월, ECMA-262라 불리는 **표준화된 자바스크립트 초판(ECMAScript 1)사양이 완성되었고 상표권 문제로 ECMAScript로 명명**되었다. 2015년애 공개된 ECMAScript 6(ECMAScript 2015, ES6)는 범용 프로그래밍 언어로서 갖춰야 할 기능을 대거 도입하는 큰 변화가 있었고, ES6 이후의 버전에서 비교적 작은 기능을 추가하는 수준으로 매년 공개할 것을 예고하였다.

- **ECMAScript 버젼 별 특징**

|버전|출시년도|특징|
|-----|-----|-----|
|ES1|1997|초판|
|ES2|1998|ISO/IEC 16262 국제 표준과 동일한 규격을 적용|
|ES3|1999|Regular Expression, try ... catch|
|ES5|2009|HTML5와 함께 출현한 표준안, JSON, strict mode<br>Accessors Property, Property Attribute 제어<br>향상된 배열 조작 기능(forEach, map, filter, reduce, some, every)|
|**ES6**<br>**ECMAScript 2015**|2015|Module import & export, 디스트럭처링 할당<br>Symbol, Promise, Map/Set, Iterable<br>for ... of, Generator, Proxylet/const, Class<br>Arrow Function, Template Literals, Spread Syntax, rest Parameter|
|ES7<br>ECMAScript 2016|2016|지수(**)연산자<br>Array.prototype.includes, String.prototype.includes|
|ES8<br>ECMAScript 2017|2017|async/await<br>Object Static Method(Object.value, Object.entries, Object.getOwnPropertyDescriptors)|
|ES9<br>ECMAScript 2018|2018|async generator, for await ... of<br>Object rest/spread property, Promise.prototype.finally|
|ES10<br>ECMAScript 2019|2019|Object.fromEntries, optional catch binding<br>Array.prototype.flat, Array.prototype.flatMap|
|ES11<br>ECMAScript 2020|2020|Nullish coalescing operator, optional chaining operator<br>String.prototype.matchAll, BigInt, globalThis<br>Promise.allSettled, for ... in enumeration order|

<br>

## 2.3 자바스크립트 성장의 역사
초창기 자바스크립트는 **웹 페이지의 보조적인 기능을 수행하기 위해 한정적인 용도**로 사용되었다. 이 시기에 대부분의 로직은 웹 서버에서 실행되었고, 브라우저는 서버로부터 전달받은 HTML, CSS를 단순히 렌더링하는 수준이었다.
> 렌더링(Rendering)이란 HTML, CSS, 자바스크립트로 작성된 **문서를 해석해서 브라우저에 시각적으로 출력**하는 것으로, [38장: 브라우저의 렌더링 과정](Chapter38.md)에서 자세히 살펴볼 예정이다.

<br>

### 2.3.1 Ajax
<img src="../Image/ajax.png" width="200" height="100%"><br>
1999년, 자바스크립트를 이용해 서버와 클라이언트(브라우저)가 비동기 방식으로 데이터를 교환할 수 있는 통신 기능인 Ajax(Asynchronous JavaScript and XML)가 등장했다.<br>
이전의 브라우저는 완성된 HTML 파일을 서버로부터 전달받아 렌더링했는데, 사소한 화면 변경에도 서버로부터 새로운 HTML 파일을 전달받아 다시 랜더링했기 때문에 성능면에서 불리하였다. Ajax의 등장 이후 서버로부터 전체 HTML 파일이 아닌 필요한 데이터만 전달받아 변경이 필요한 부분만 랜더링하는 방식이 가능해졌다. 이로 인해 웹 브라우저에서도 빠른 성능과 부드러운 화면 전환이 가능해졌다.

<br>

### 2.3.2 jQuery
<img src="../Image/jquery.png" width="250" height="100%"><br>
2006년, jQuery의 등장으로 다소 번거롭고 논란이 있던 DOM(Document Object Model)을 더욱 쉽게 제어할 수 있게 되었고 크로스 브라우징 이슈도 어느 정도 해결되었다. 

<br>

### 2.3.3 V8 자바스크립트 엔진
<img src="../Image/v8.png" width="100" height="100%"><br>
자바스크립트를 이용하여 웹 어플리케이션을 만드는 것이 가능함을 확인하자 빠르게 동작하는 자바스크립트 엔진의 필요성이 대두 되었다.<br>
2008년, 구글의 V8 자바스크립트 엔진은 이러한 요구에 부합하는 빠른 성능을 보여주었고, 웹 서버에서 수행되던 로직들이 대거 클라이언트(브라우저)로 이동하면서 웹 개발 영역에서 Front-end 영역이 주목받게 되는 계기가 되었다. 

<br>

### 2.3.4 Node.js
<img src="../Image/nodejs.svg" width="250" height="100%"><br>
2009년, 라이언 달(Ryan Dahl)이 발표한 Node.js는 구글의 V8 자바스크립트 엔진을 이용하여 브라우저 이외의 환경에서도 동작할 수 있도록 독립시킨 **자바스크립트 실행(런타임)환경**이다.<br>
다양한 플랫폼(크로스 플랫폼)에 적용 가능하지만 주로 서버 사이드 애플리케이션에 사용되며, 이에 필요한 모듈, 파일 시스템, HTTP, 빌트인 API를 제공한다. 또한, 비동기 I/O를 지원하며 단일 스레드 이벤트 루프 기반으로 동작함으로써 요청처리 성능이 좋고 I/O가 빈번하게 발생하는 SPA에 적합하다.

<br>

### 2.3.5 SPA(Single Page Application) 프레임워크
<img src="../Image/spa.png" width="250" height="100%"><br>
모던 웹 애플리케이션은 데스크탑 애플리케이션과 비교해도 손색없는 성능과 사용자 경험을 제공하는 것이 필수가 됨에 따라 개발 규모와 복잡도가 상승하였는데, 많은 라이브러리와 개발 패턴이 등장했지만 유연성과 확장성을 만족시키기에는 부족하였다.<br>
이러한 요구에 발맞춰 CBD(Component Based Development)방법론을 기반으로 하는 SPA(Single Page Application) 프레임워크/라이브러리(Angular, React, Vue 등)가 대중화 되었다. 

<br>

## 2.4 자바스크립트와 ECMAScript
ECMAScrippt는 자바스크립트 표준 사양인 ECMA-262를 말하며, 프로그래밍 언어의 값, 타입, 객체와 프로퍼티, 함수 등 핵심 문법을 규정한다. 각 브라우저 제조사는 ECMAScript 사양을 따르는 자바스크립트 엔진을 구현한다.<br>
**자바스크립트는 일반적으로 언어의 기본 뼈대를 ECMAScript로 하여 브라우저가 별도로 지원하는 클라이언트 사이드 Web API(DOM, BOM 등)를 아우르는 상위 호환의 개념**이며, 클라리어언트 사이드 Web API는 ECMAScript와 별도로 W3C에서 별도 사양으로 관리하고 있다.

<br>

## 2.5 자바스크립트의 특징
웹의 구성요소 중 하나로 **웹 브라우저에서 동작하는 유일한 프로그래밍 언어**이다.<br>
다른 프로그래밍 언어와 마찬가지로 기존의 프로그래밍 언어에서 많은 영향을 받아 기본 문법은 C, Java와 유사하고, Self에서는 프로토타입 기반 상속을, Scheme에서는 일급 함수의 개념을 차용했다. <br>

자바스크립트는 기본적으로 개발자가 별도의 컴파일을 하지 않는 **인터프리터 언어**이다. 하지만 대부분의 모던 자바스크립트 엔진은 인터프리터 언어와 컴파일러 언어의 장점을 결합해 비교적 처리 속도가 느린 인터프리터의 단점을 해결하며 인터프리터 언어의 장점인 동적 기능 지원을 그대로 유지하였다. 또한, 자바스크립트는 명령형, 함수형, 프로토타입 기반 객체지향 프로그래밍을 지원하는 **멀티 패러다임 프로그래밍 언어**다.

<br>

## 2.6 ES6 브라우저 지원 현황
인터넷 익스플로러를 제외한 대부분의 모던 브라우저는 ES6를 지원하지만 100% 지원하고 있지는 않으며, Node.js는 v4 부터 ES6를 지원하기 시작했다.
아직 지원하지 않는 브라우저에서 최신 기능을 사용하거나 구형 브라우저를 고려해야한다면 바벨(Babel)과 같은 트랜스파일러를 사용할 필요가 있다. 이에 대해서는 [49장: Babel과 Webpack을 이용한 ES6+/ES.NEXT 개발 환경 구축](Chapter49.md)에서 자세히 살표볼 예정이다.

<br>

## Summary
- 자바스크립트의 시작은 웹 페이지의 보조적인 기능을 위해 브라우저에서 동작하는 경량 프로그래밍 언어였다.
- 초기에 표준화 되지 않은 상황에서 크로스 브라우징 이슈가 존재했었고, 이에 따라 ECMA International에 의해 ECMAScript로 명명되어 관리되고있다. 2015년 ES6로 인해 범용 프로그래밍 언어로서의 역할을 할 수 있게끔 큰 변화를 거쳤다.  
- 단순 렌더링의 용도 부터 시작하여 Ajax, jQuery를 통해 사용성이 증가하였고, V8엔진을 통해 더 빠른 속도를 지원할 수 있게되었다. Node.js의 등장으로 인해 단순 브라우저에서만 동작하는 언어가 아닌 크로스 플랫폼을 지원하는 언어로 한 단계 발전할 수 있었으며, 웹 페이지에 대한 사용자의 요구 사항이 데스크탑 애플리케이션 만큼 다양하고 커지면서 SPA 프레임워크, 라이브러리가 대중화 되었다. 
- 자바스크립트는 ECMAScript의 구현체이며 클라리어언트 사이드 Web API가 추가된 것으로 볼수 있다. Web API에 대한 사양은 ECMAScript와 별도로 W3C에서 별도 사양으로 관리하고 있다. 자바스크립트는 기본적으로 인터프리터 언어이지만, 각 브라우저의 자바스크립트 엔진이 컴파일러의 장점을 결합해 실행 시 더 빠르게 작동하게끔 지원한다.
- 자바스크립트는 여러 패러다임의 프로그래밍이 가능하게끔 지원하는 멀티 패러다임 프로그래밍 언어이다.

<br>

-----
### [< 이전](Chapter1.md) | [목차](../README.md) | [다음 >](Chapter3.md)