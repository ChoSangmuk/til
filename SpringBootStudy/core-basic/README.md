# Inflearn (김영한) / 스프링 핵심 원리 - 기본편

- [Inflearn Lecture Dashboard](https://www.inflearn.com/course/%EC%8A%A4%ED%94%84%EB%A7%81-%ED%95%B5%EC%8B%AC-%EC%9B%90%EB%A6%AC-%EA%B8%B0%EB%B3%B8%ED%8E%B8/dashboard)
- 해당 강의는 유료로 저자의 저작권 보호를 위해 강의 자료 미첨부

## 섹션 1. 객체 지향 설계와 스프링
### 이야기 - 자바 진영의 추운 겨울과 스프링의 탄생
- 자바 진영의 겨울
  - 자바 진영의 표준 기술인 EJB
  - 컨테이너, 설정에 의한 트랜잭션, 분산 처리 등 고급 기술이 편하게 지원됨
  - 낮은 수준의 엔티티 빈 지원(쿼리 없이 DB에 객체를 저장하는 기술)
  - EJB에 의존적이고 코드 자체가 지저분해짐, 또한 비싸고 어렵고 느렸음
- 스프링과 JPA의 탄생
  - 간단한 객체를 사용하자는 의도에서 POJO라는 개념이 등장
  - 로드 존슨 저서의 3만줄 가량의 소스가 EJB 컨테이너 대체하며 스프링이 됨
  - 개빈 킹이 EJB 엔티티 빈 기술을 대체하는 Hibernate를 발표하면서 JPA 표준이 새롭게 정의됨

### 스프링이란?
- **스프링은 여러 기술의 모음**이며 스프링 프레임워크가 가장 중요
  - 핵심 기술 : 스프링 DI 컨테이너, AOP, 이벤트, 기타
  - 웹, 데이터 접근 기술 : 스프링 MVC, 스프링 WebFlux, 트랜잭션, JDBC, ORM 지원, XML 지원
- 스프링은 문맥에 따라 다르게 해석될 수 있음
  - 스프링 DI 컨테이너 기술 혹은 스프링 프레임워크 
  - 스프링 부트, 스프링 프레임워크 등을 모두 포함한 스프링 생태계
- **스프링 부트**는 스프링 프레임워크를 편리하게 사용할 수 있도록 지원, 최근에는 기본으로 사용 
  - 단독으로 실행할 수 있는 스프링 애플리케이션을 쉽게 생성 
  - Tomcat 같은 웹 서버를 내장해서 별도의 웹 서버를 설치하지 않아도 됨 
  - 손쉬운 빌드 구성을 위한 starter 종속성 제공 등
- 스프링을 왜 만들어 졌고, 핵심 컨셉은 무엇?
  - 단순 스프링의 API 사용법을 익히는 것이 아니라 핵심 컨셉을 이해하는 것이 중요
  - 스프링은 **자바(객체 지향) 언어 기반의 프레임워크**로 객체 지향 언어가 가진 강력한 특징을 살려내는 프레임워크

### 좋은 객체 지향 프로그래밍이란?
- 세상을 역할과 구현으로 구분하면
  - 사용자는 구현 대상 자체를 변경해도 영향을 받지 않음으로 변화에 유연하며, 변경 자체도 편리
  - 사용자는 대상의 역할만 알면 구현 대상의 내부 구조가 변경되어도 영향을 받지 않음
  - 역할에 수정이 발생하는 경우 모든 구현체를 수정해야하는 문제가 발생함으로 역할을 안정적으로 잘 설계하는 것이 가장 중요
- 세상의 역할과 구현이라는 편리한 컨셉을 자바 언어의 다형성을 통해 객체 세상으로 가져올 수 있음
  - 역할 : 인터페이스 
  - 구현 : 인터페이스를 구현한 클래스, 구현 객체 
  - 객체 설계 시 역할과 구현을 명확히 분리하고 실행 시점에 구현체를 유연하게 변경
  - 객체 설계 시 역할(인터페이스)을 먼저 부여하고, 그 역할을 수행하는 구현 객체 만들기
  - 클라이언트를 변경하지 않고, 서버의 구현 기능을 유연하게 변경할 수 있음
- 스프링의 제어의 역전(IoC), 의존관계 주입(DI)은 다형성을 활용해서 역할과 구현을 편리하게 다룰 수 있도록 지원 

### **좋은 객체 지향 설계의 5가지 원칙(SOLID)**
- **SRP: 단일 책임 원칙(single responsibility principle)**
  - **한 클래스는 하나의 책임만**
  - 중요한 기준은 변경, 변경이 있을 때 파급 효과가 적으면 단일 책임 원칙을 잘 따른 것
- **OCP: 개방-폐쇄 원칙 (Open/closed principle)**
  - 소프트웨어 요소는 **확장에는 열려 있으나 변경에는 닫혀 있어야 한다**
  - 객체를 생성하고, 연관관계를 맺어주는 별도의 조립, 설정자가 필요 -> 스프링 DI 컨테이너의 역할
```java
public class MemberService {
    /*
     private MemberRepository memberRepository = new MemoryMemberRepository();
     구현체를 변경하려면 클라이언트의 변경이 필수적임
     분명 다형성을 사용했지만 OCP 원칙을 지킬 수 없음
    */
    private MemberRepository memberRepository = new JdbcMemberRepository();
}
```
- **LSP: 리스코프 치환 원칙 (Liskov substitution principle)**
  - 다형성에서 하위 클래스는 인터페이스 규약을 지켜야 함
  - 다형성을 지원하기 위한 원칙으로 **인터페이스 구현체의 신뢰성을 보장**
- **ISP: 인터페이스 분리 원칙 (Interface segregation principle)**
  - 특정 클라이언트를 위한 인터페이스 여러 개가 범용 인터페이스 하나보다 좋음
- **DIP: 의존관계 역전 원칙 (Dependency inversion principle)**
  - **추상화(인터페이스)에 의존해야지, 구체화(구현 클래스)에 의존하면 안된다.**
  - 클라이언트가 구현체에 의존하게 되면 변경이 아주 어려워짐
  - OCP에서 설명한 MemberService는 인터페이스에 의존하지만, 구현 클래스도 동시에 의존 ->  DIP 위반
- **다형성 만으로는 OCP, DIP를 지키기 힘듬**

### 객체 지향 설계와 스프링
- 스프링은 다음 기술로 다형성 + OCP, DIP를 가능하게 지원
  - DI(Dependency Injection): 의존관계, 의존성 주입
  - DI 컨테이너 제공
- 클라이언트 코드의 변경 없이 기능 확장

## 섹션 2. 스프링 핵심 원리 이해1 - 예제 만들기
### 프로젝트 생성 및 비즈니스 요구사항과 설계
- Project 
  - 라이브러리 로드, 빌드 등을 관리하는 Tool을 명시
  - Maven, Gradle 등이 있으며, Gradle의 빈도가 증가하는 추세
  - 라이브러리는 추가적으로 의존성을 가질 수 있으며, 의존관계 역시 빌드 툴에 의해 관리됨
- no Dependencies 
  - 프로젝트에서 사용하는 라이브러리
  - 스프링이 없을 때 불편함을 경험하기 위해 의존성 추가는 하지 않음

<a href="https://start.spring.io/">
  <img src="../Image/core-basic-start-spring.png" width="600" height="50%">
</a>

- 배운 내용을 토대로 요구사항을 역할과 구현을 분리하여 순수 자바로 개발하기
- Spring Web을 포함하지 않음으로 톰캣이 실행되지 않고 종료됨
- 요구사항 변경 시, 다형성과 SOLID를 잘 지킬수 있는지 검증

<img src="../Image/core-basic-business-requirements.png" width="600" height="50%">

### 회원 도메인 설계, 개발, 실행과 테스트
- 회원 도메인에 대한 설계
  - 클라이언트는 회원 서비스를 호출함
  - 회원 서비스는 회원 가입과 조회 기능을 제공하며, 회원 저장소를 호출하여 데이터에 접근 
  - 회원 저장소는 아직 미확정 상태임으로 역할(인터페이스)을 정의하고 임시로 메모리를 이용하여 구현
  - 상황이 변함에 따라 회원 저장소 역할의 구현체를 변경

> 도메인 협력 관계 : 기획자도 볼수 있는 그림  
> 클래스 다이어그램 : 도메인 협력 관계를 바탕으로 구현을 위해 구체화한 정적 그림  
> 객체 다이어그램 : 실제 작동 시 객체 인스턴스간의 참조 관계를 나타낸 동적 그림

- 클래스 다이어그램을 참고, member 패키지에 회원과 관련된 내용을 개발
  - [Grade](src/main/java/com/example/corebasic/member/Grade.java)와 [Member](src/main/java/com/example/corebasic/member/Member.java)
  - [MemberRepository](src/main/java/com/example/corebasic/member/MemberRepository.java)
    - [MemoryMemberRepository](src/main/java/com/example/corebasic/member/MemoryMemberRepository.java)
    - 인터페이스와 구현체는 패키지를 나누는 것이 좋지만 간단한 예제를 위해 분리하지 않음
  - [MemberService](src/main/java/com/example/corebasic/member/MemberService.java)
    - [MemberServiceImpl](src/main/java/com/example/corebasic/member/MemberServiceImpl.java)
    - 인터페이스의 구현체가 1개인 경우 관례적으로 뒤에 impl 을 붙임
- 회원 도메인이 정상적으로 동작하는지 확인하는 절차
  - [MemberApp](src/main/java/com/example/corebasic/MemberApp.java)
  - [MemberServiceTest](src/test/java/com/example/corebasic/member/MemberServiceTest.java)
- 인터페이스 뿐만 아니라 구현체까지 의존하기 때문에 **DIP 원칙을 못 지킴**
- 다른 저장소로 변경할 때 OCP 원칙은 잘 준수할 수 있을까?

### 주문과 할인 도메인 설계, 개발, 실행과 테스트
- 주문과 할인 도메인에 대한 설계
  - 주문 생성 : 클라이언트는 주문 서비스에 주문 생성을 요청
  - 회원 조회 : 할인을 위해서는 회원 등급이 필요, 주문 서비스는 회원 저장소에서 회원을 조회
  - 할인 적용 : 주문 서비스는 회원 등급에 따른 할인 여부를 할인 정책에 위임
  - 주문 결과 반환 : 주문 서비스는 할인 결과를 포함한 주문 결과를 반환
  - 주문 데이터를 DB에 저장해야하지만 예제가 너무 복잡해 질 수 있어서 생략, 단순히 주문 결과를 반환
  - 상품에 대한 도메인이 필요하지만 주문 내역 안에 단순하게 포함시킴
- 클래스 다이어그램을 참고, discount 패키지에 할인과 관련된 내용을 개발
  - 할인에 대한 행위 개념을 역할과 구현으로 나눔
  - [DiscountPolicy](src/main/java/com/example/corebasic/discount/DiscountPolicy.java)
    - [FixDiscountPolicy](src/main/java/com/example/corebasic/discount/FixDiscountPolicy.java)
- 클래스 다이어그램을 참고, order 패키지에 주문과 관련된 내용을 개발
  - [Order](src/main/java/com/example/corebasic/order/Order.java)
  - [OrderService](src/main/java/com/example/corebasic/order/OrderService.java)
    - [OrderServiceImpl](src/main/java/com/example/corebasic/order/OrderServiceImpl.java)
- 주문, 할인 도메인이 정상적으로 동작하는지 확인하는 절차
  - [OrderApp](src/main/java/com/example/corebasic/OrderApp.java)
  - [OrderServiceTest](src/test/java/com/example/corebasic/order/OrderServiceTest.java)

## 섹션 3. 스프링 핵심 원리 이해2 - 객체 지향 원리 적용
### 새로운 할인 정책 개발
- 기존의 할인 정책 역할(인터페이스)를 구현하는 새로운 할인 정책(구현체) 개발
  - [RateDiscountPolicy](src/main/java/com/example/corebasic/discount/RateDiscountPolicy.java)
- 새롭게 작성한 할인 정책이 정상적으로 동작하는지 테스트
  - [RateDiscountPolicyTest](src/test/java/com/example/corebasic/discount/RateDiscountPolicyTest.java)

### 새로운 할인 정책 적용과 문제점
- 역할과 구현을 잘 분리하였음, 새로운 할인 정책의 구현은 비교적 쉽게 진행 -> **다형성은 비교적 잘 지킴**
- 주문서비스 클라이언트([OrderServiceImpl](src/main/java/com/example/corebasic/order/OrderServiceImpl.java))는 할인 정책 인터페이스뿐만 아니라 할인 정책 구현체에도 의존하고 있음 -> **DIP 원칙 위반**
- 새로운 할인 정책을 적용하기 위해서는 해당 정책을 사용하는 클라이언트에서 **직접 FixDiscountPolicy에서 RateDiscountPolicy로 변경**해 주어야함 -> **OCP 원칙 위반**
- 아무리 다형성을 잘 지켜도 DIP 원칙을 위반하면 변경이 발생할 떄, OCP 원칙을 지키기 어려움
  - DIP 원칙을 지키기 위해 구현체의 생성 부분을 삭제하면 **DIP 원칙 준수**할 수 있음
  - 그러나 구현체 없이 인터페이스만으로 로직을 실행하면 NullPointerException이 발생
- 외부에서 클라이언트(OrderServiceImpl)에 필요한 의존성(DiscountPolicy) 구현 객체를 대신 생성하고 주입하면 문제를 해결할 수 있음

### 관심사의 분리
- 공연의 배역과 이를 연기하는 배우가 존재
  - 배우가 직접 상대 배우를 섭외하게 되면 배우 본인의 역할뿐만 아니라 섭외라는 전혀 다른 작업도 해야함
  - 상대 배우가 변경되어도 공연이 가능해야하지만 그렇지 못함
  - 별도의 공연 기획자가 배우를 섭외하여 배정하는게 바람직함
- OOP에서도 마찬가지로 역할을 명시하는 인터페이스와 이를 구현하는 구현체가 존재
  - 클라이언트가 의존성을 가지는 객체를 직접 선택, 생성하게되면 클라이언트 본인의 역할뿐만 아니라 의존성 객체의 생성에도 신경써야함 
  - 의존성 객체가 변경되어도 클라이언트는 영향을 받지 않고 자신의 역할을 수행해야하지만 그렇지 못함
  - 외부에서 의존성을 주입받아서 사용하는 것이 바람직함
- 애플리케이션의 전체 동작 방식을 구성, 구현 객체를 생성 및 연결하는 책임을 가지는 별도의 설정 클래스([AppConfig](src/main/java/com/example/corebasic/AppConfig.java)) 작성
  - 클라이언트는 특정 역할(인터페이스)을 사용하겠다고 명시, 생성자 혹은 Setter를 통해 생성이 완료된 구현체를 주입(전달)받음
  - **AppConfig에서 구현체를 생성하고 클라이언트가 원하는 방식(생성자 혹은 Setter)으로 주입(전달)해줌**
  - 클라이언트는 어떤 구현체를 사용하게 될지 전혀 모르며, 오로지 외부(AppConfig)에서 결정됨
  - **클라이언트 입장에서는 의존성을 마치 주입받는 것 같다하여 DI(Dependency Injection), 의존관계 주입, 의존성 주입이라함**
- 클라이언트 의존성 생성 방식 수정
  - 의존성 객체 직접 생성 -> 의존성 주입
  - [OrderServiceImpl](src/main/java/com/example/corebasic/order/OrderServiceImpl.java)
  - [MemberServiceImpl](src/main/java/com/example/corebasic/member/MemberServiceImpl.java)
- 예제 코드 실행 방식 수정
  - 실행 객체 직접 생성 -> AppConfig로 부터 전달
  - [OrderApp](src/main/java/com/example/corebasic/OrderApp.java)와 [OrderServiceTest](src/test/java/com/example/corebasic/order/OrderServiceTest.java)
  - [MemberApp](src/main/java/com/example/corebasic/MemberApp.java)와 [MemberServiceTest](src/test/java/com/example/corebasic/member/MemberServiceTest.java)

### [AppConfig](src/main/java/com/example/corebasic/AppConfig.java) 리팩터링, 새로운 구조와 할인 정책 적용
- 중복을 줄이고 역할과 구현을 명확하게 수정
- AppConfig에서 할인 정책을 변경하면 적용 완료
- 애플리케이션을 사용 영역과 구성 영역으로 명확하게 분리
- 애플리케이션의 변경사항이 발생해도 기존 사용 영역은 영향을 받지 않음

### 전체 흐름 정리
- **새로운 할인 정책 개발**
  - 역할과 구현을 분리해 두었음으로 새로운 정책을 생성하는 데 문제가 없음
- **새로운 할인 정책 적용과 문제점**
  - 정책을 변경하고자 하면 이를 사용하는 클라이언트의 소스의 변경이 필요 -> OCP 원칙 위반
  - 클라이언트 내에서 인터페이스와 구현체 모두에 의지하고 있음 -> DIP 원칙 위반
- **관심사의 분리**
  - 클라이언트가 본래의 역할 이외에 객체를 직접 생성하는 것이 문제
  - AppConfig에게 의존성 객체를 생성하고, 필요한 부분에 의존성을 주입(연결)하는 책임을 위임
  - 클라이언트는 자신의 역할(책임)에만 집중할 수 있음
- **AppConfig 리펙터링, 새로운 구조와 할인 정책 적용**
  - AppConfig 내에서도 중복을 줄이고 구조를 명확히함
  - 구성 영역과 사용 영역을 명확하게 분리
  - AppConfig 만 수정함으로서 할인 정책을 변경, 클라이언트 코드는 수정되지 않음
  - OCP 원칙과 DIP 원칙을 모두 준수

### 좋은 객체 지향 설계의 5가지 원칙의 적용
- 3가지 (SRP, DIP, OCP) 원칙의 준수
- **SRP : 한 클래스는 하나의 책임만을 가져야 한다.**
  - 의존성 객체의 생성과 역할의 실행이라는 관심사를 AppConfig를 통해 분리
  - 클라이언트는 역할의 실행에만 책임을 가짐
  - AppConfig는 객체의 생성과 의존성 주입을 관리하는 책임을 가짐
- **DIP : 추상화에 의존해야지, 구체화에 의존하면 안된다.**
  - 클라이언트는 구현 클래스가 아닌 인터페이스에만 의존
  - 인터페이스만으로는 실행이 불가능함으로 생성자 혹은 Setter 등을 통해 외부에서 구현체를 주입받음
- **OCP : 소프트웨어 요소는 확장에는 열려 있으나 변경에는 닫혀 있어야 한다.**
  - 다형성과 DIP 원칙을 준수하면서 구성(AppConfig)과 사용 영역을 분리
  - 애플리케이션 변경(확장) 시, 구성 영역만 변경함으로 기존의 사용 영역은 변경에 닫혀있음

### IoC, DI, 그리고 컨테이너
- **IoC(Inversion of Control)**
  - 기존에는 객체가 스스로 필요한 의존성 객체를 생성하고, 연결하고, 실행하여 프로그램의 흐름을 직접 제어
  - AppConfig 등장 이후 객체는 맡은 역할만을 수행, 의존성 객체를 생성하고 연결하는 등의 프로그램 흐름은 AppConfig가 제어
  - 프로그램의 흐름을 직접 제어하는 것이 아니라 외부에서 관리하는 것을 제어의 역전(IoC)이라 함

> 프레임워크 vs 라이브러리  
>
> 프레임워크는 개발자가 작성한 코드를 제어하고 대신 실행함(JUnit)  
> 개발자가 작성한 코드가 직접 프로그램의 제어를 담당한다면 라이브러리  

- **의존관계 Dependency**
  - 정적인 클래스 의존관계 : 클래스 다이어그램
    - 클래스가 사용하는 import 코드만 보고 의존관계를 쉽게 판단할 수 있음
    - 애플리케이션을 실행하지 않아도 분석할 수 있지만 실제 어떤 객체 인스턴스가 주입될지 알 수 없음
  - 동적인 객체 인스턴스 의존 관계 : 객체 다이어그램
    - 애플리케이션 실행 시점(런타임)에 생성되는 객체 인스턴스들간의 관계
- **의존관계 주입 DI(Dependency Injection)**
  - 외부에서 의존성 객체를 생성하고 필요한 객체에 전달(주입)해서 의존관계를 연결하는 것
  - 의존관계 주입을 사용하면
    - 클라이언트 코드를 변경하지 않고, 클라이언트가 호출하는 대상의 타입 인스턴스를 변경할 수 있음
    - 정적인 클래스 의존관계를 변경하지 않고, 동적인 객체 인스턴스 의존관계를 쉽게 변경할 수 있음
- **IoC 컨테이너** 혹은 **DI 컨테이너**
  - AppConfig 처럼 **객체를 생성하고 관리하면서 의존관계를 연결해 주는 것**
  - 의존관계 주입에 초점을 맞추어 최근에는 주로 DI 컨테이너라 함
  - 또는 어샘블러, 오브젝트 팩토리 등으로 불리기도 함

### 스프링으로 전환하기
- 스프링이 없던 순수 자바 DI 코드를 스프링(스프링 컨테이너)이 제공하는 DI 방식으로 변경
- AppConfig DI 방식 수정
  - 순수 자바 코드 -> 스프링 기반 DI
  - [AppConfig](src/main/java/com/example/corebasic/AppConfig.java)
- 예제 코드 실행 방식 수정
  - 실행 객체 직접 생성 -> AppConfig로 부터 전달 -> 스프링 컨테이너로 부터 전달
  - [OrderApp](src/main/java/com/example/corebasic/OrderApp.java)
  - [MemberApp](src/main/java/com/example/corebasic/MemberApp.java)
- 스프링 사용을 위해 등록된 빈이 로그에 출력된 것 이외의 결과는 동일
  - 코드가 약간 더 복잡해진 것 같은데, 스프링 컨테이너를 사용하면 어떤 장점이 있을까? -> 앞으로의 강의 내용

## 섹션 4. 스프링 컨테이너와 스프링 빈
### 스프링 컨테이너 생성
```java
ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
```
- ApplicationContext 는 인터페이스이며, 스프링 컨테이너라고 이야기함
  - 개발자의 의도에 따라 여러 형태의 구현체(xml, java)가 존재
  - 최근에는 대부분 java 어노테이션을 사용

> 정확히는 스프링 컨테이너를 부를 때 BeanFactory, ApplicationContext 로 구분  
> BeanFactory 를 직접 사용하는 경우는 거의 없으므로 일반적으로 ApplicationContext 를 스프링 컨테이너라 함

**스프링 컨테이너의 생성 과정**

- 스프링 컨테이너 생성 시, 필요한 구성 정보(AppConfig)를 지정하면 Bean 저장소를 만들어 채움
  - @Bean이 존재하는 모든 메소드를 실행
  - 메소드 이름과 반환 객체를 key - value 로 매핑하여 저장
  - 임의로 빈 명칭을 변경할 수도 있음 @Bean(name="memberService2")

> 빈 이름은 항상 다른 이름을 부여해야 함, 같은 이름을 부여하면 다른 빈이 무시되거나 기존 빈을 덮어버리거나 설정에 따라 오류가 발생함  
> 초기 설계에서 그러한 상황이 발생하지 않게끔 잘 설계하는 것이 중요

- 빈을 생성한 후, 스프링 컨테이너가 설정 정보를 참고해서 동적인 의존관계를 주입(DI)
  - 단순히 자바 코드를 순서에 맞게 실행하는 것이 아님!
  - 추가 학습 예정임으로 단순 자바 코드 실행이 아니라는 것만 확인 

> 스프링은 빈을 생성하고, 의존관계를 주입하는 단계가 나누어져 있음  
> But, 자바 코드로 스프링 빈을 등록하면 생성자를 호출하면서 의존관계 주입도 한번에 처리되지만 이해를 돕기 위해 개념적으로 나누어 설명

- 스프링 컨테이너를 생성하고, 설정(구성) 정보를 참고하여 스프링 빈 등록, 의존관계도 설정함
  - 의도한 설정 정보대로 등록되었는지 확인 필요

### 컨테이너에 등록된 모든 빈 조회
- [ApplicationContextInfoTest](src/test/java/com/example/corebasic/beanfind/ApplicationContextInfoTest.java)
- 개발자가 작성한 빈(AppConfig 포함) 이외에도 스프링이 기본적으로 사용하는 빈이 자동으로 등록됨
- 개발자가 작성한 빈과 스프링이 등록한 빈을 구분하기 위해 빈의 정보(BeanDefinition)를 사용
  - ROLE_APPLICATION: 직접 등록한 애플리케이션 빈
  - ROLE_INFRASTRUCTURE: 스프링이 내부에서 사용하는 빈
- JUnit5 부터는 접근자(public)를 지정하지 않아도 됨

### 스프링 빈 조회 - 기본
- [ApplicationContextBasicFindTest](src/test/java/com/example/corebasic/beanfind/ApplicationContextBasicFindTest.java)
- 빈을 조회하는 기본적인 방식
  - getBean(빈 이름, 타입) : 이름과 타입으로 조회
  - getBean(타입) : 타입으로만 조회
- 반환 타입이 아닌 스프링 빈에 등록된 인스턴스 타입으로 검색하기 때문에 구현체 타입으로 적어도됨
  - But, 인터페이스가 아닌 구현체에 의지하게 되며 변경에 유연성이 떨어짐으로 추천하지 않음
- 조회 대상 스프링 빈이 없으면 예외 발생
  - NoSuchBeanDefinitionException: No bean named 'xxxxx' available

### 스프링 빈 조회 - 동일한 타입이 둘 이상
- [ApplicationContextSameBeanFindTest](src/test/java/com/example/corebasic/beanfind/ApplicationContextSameBeanFindTest.java)
- 같은 타입이 2개 이상 인 경우, 오류가 발생 
  - NoUniqueBeanDefinitionException: No qualifying bean of type 'com.example.corebasic.member.MemberRepository' available
  - 빈 이름을 지정하여 해결
- **자동의존 관계 주입 시에도 적용됨(no unique)**

### 스프링 빈 조회 - 상속 관계
- [ApplicationContextExtendsFindTest](src/test/java/com/example/corebasic/beanfind/ApplicationContextExtendsFindTest.java)
- 스프링 빈을 타입으로만 조회 시, 상속 관계가 있다면 하위 클래스는 전부 검색됨
  - 이를 방지하기 위해 빈 이름을 추가하여 검색
  - 혹은, 구현체 타입을 명확히 지정하여 해결(추천하지 않음)
  - Object 는 모든 클래스의 상위 클래스임으로 Object 타입으로 조회하면 스프링의 모든 빈이 검색됨
- 실제 테스트에선 출력은 제외하는 것을 권장

### 중간 정리
- 스프링 빈을 조회하는 기본적인 방법을 살펴봄
- 개발자가 ApplicationContext에서 직접 getBean할 일이 별로 없음
  - 기본 기능이기도 하며, 아주 드물게 순수 자바 애플리케이션에서 스프링 컨테이너를 가져다 쓸때 사용
  - 그 외에 일반적인 경우 스프링 컨테이너가 자동으로 의존관계 주입을 사용하거나 @Bean을 통해 설정함

### BeanFactory와 ApplicationContext
- BeanFactory는 스프링 컨테이너의 최상위 인터페이스
  - 스프링 빈을 관리하고 조회(getBean)하는 역할을 담당
- ApplicationContext는 BeanFactory을 상속받아 부가 기능을 추가한 인터페이스
  - 메시지 소스를 활용한 국제화 기능 : 한글, 영어 등의 언어에 관한 설정 지원
  - 환경변수 : 로컬, 개발, 운영등을 구분 처리
  - 애플리케이션 이벤트 : 이벤트를 발행하고 구독하는 모델을 편리하게 지원
  - 편리한 리소스 조회 : 파일, 클래스패스, 외부 등에서 리소스를 편리하게 조회
- BeanFactory를 직접 사용할 일은 거의 없으며, 부가 기능이 포함된 ApplicationContext를 사용
- BeanFactory나 ApplicationContext를 스프링 컨테이너라 함

### 다양한 설정 형식 지원 - 자바 코드, XML
- 스프링은 Java이외에도 XML과 같은 다양한 형식으로 설정 정보를 지정할 수 있게끔 유연하게 설계
- XmlAppConfig 사용 자바 코드
  - [XmlAppContextTest.java](src/test/java/com/example/corebasic/xml/XmlAppContextTest.java)
- XML 기반의 스프링 빈 설정 정보
  - [appConfig.xml](src/main/resources/appConfig.xml)
  - 설정 방법은 어노테이션 기반 자바(AppConfig.java)와 거의 비슷
  - Java 소스 파일 이외에 나머지 파일은 resources에 생성
- 많은 레거시 프로젝트에 XML기반 설정이 남아 있으며, 컴파일 없이 빈 설정 정보를 변경할 수 있는 장점도 있으므로 사용법 정도만 익혀두기
  - [스프링 공식 레퍼런스 문서](https://spring.io/projects/spring-framework) 확인

### 스프링 빈 설정 메타 정보 - BeanDefinition
- 스프링 빈의 정보를 나타내는 파일은 형식이 자유로움
  - 스프링은 설정 파일(XML, Java)에 직접 의존하는 것이 아니라 BeanDefinition이라는 추상화(인터페이스)에만 의존하고 있음
  - 스프링 컨테이너가는 BeanDefinition의 빈 설정 메타 정보를 기반으로 스프링 빈(인스턴스)을 생성
  - 설정 파일에 형식에 상관없이 BeanDefinition의 구현체를 만들어 사용하면 됨
- ApplicationContext 인터페이스를 구현한 구현체(XXXXXApplicationContext) 내부에 XXXBeanDefinitionReader가 설정 파일을 읽고 BeanDefinition을 생성
  - AnnotationConfigApplicationContext에서는 AnnotatedBeanDefinitionReader가 설정 정보를 읽어 BeanDefinition을 생성
  - GenericXmlApplicationContext에서는 XmlBeanDefinitionReader가 설정 정보를 읽어 BeanDefinition을 생성
- BeanDefinition 정보 ([BeanDefinitionTest](src/test/java/com/example/corebasic/beandefinition/BeanDefinitionTest.java))
  - Scope: 싱글톤(기본값)
  - lazyInit: 스프링 컨테이너를 생성할 때 빈을 생성하는 것이 아니라, 실제 빈을 사용할 때 까지 최대한 생성을 지연처리 하는지 여부
  - BeanClassName: 생성할 빈의 클래스 명(자바 설정 처럼 팩토리 역할의 빈을 사용하면 null)
  - factoryBeanName: 팩토리 역할의 빈을 사용할 경우 이름, 예) appConfig
  - factoryMethodName: 빈을 생성할 팩토리 메서드 지정, 예) memberService
  - InitMethodName: 빈을 생성하고, 의존관계를 적용한 뒤에 호출되는 초기화 메서드 명
  - DestroyMethodName: 빈의 생명주기가 끝나서 제거하기 직전에 호출되는 메서드 명
  - Constructor arguments, Properties: 의존관계 주입에서 사용한다. (자바 설정 처럼 팩토리 역할의 빈을 사용하면 null)
- BeanDefinition을 직접 작성하여 인스턴스를 생성할 수도 있지만 거의 안함

## 섹션 5. 싱글톤 컨테이너
### 웹 애플리케이션과 싱글톤
- 스프링은 태생이 웹 애플리케이션으로 동시에 다수 사용자의 요청을 처리
- 스프링 컨테이너(ApplicationContext)를 이용하지 않는 순수한 DI 컨테이너(AppConfig) 테스트
  - [SingletonTest/pureContainer](src/test/java/com/example/corebasic/singleton/SingletonTest.java)
  - AppConfig는 요청 시 마다 새로운 객체(의존성 객체 포함)를 생성하여 반환함
  - 동일한 기능을 하는 객체는 1개만 생성하여 공유하는 것이 효율적

### 싱글톤 패턴
- 클래스의 인스턴스가 딱 1개만 생성되는 것을 보장하는 디자인 패턴
  - make constructor to private, so can't new operation
  - make method Singleton Class getInstance(), so can access of use singleton class
```java
public class Single{
  // Simplest and safest way to pre-create objects
  private static Single instance = new Single();
  private Single(){}
  public static Single getInstance(){
    return instance;
  }
}
/* or */
public class Single{
  // Lazy creation of objects when requested
  private static Single instance;
  private Single(){}
  public static Single getInstance(){
    if(single == null) this.instance = new Single();
    return instance;
  }
}
```
- 싱글톤 객체 클래스 작성
  - [SingletonService](src/test/java/com/example/corebasic/singleton/SingletonService.java)
- 싱글톤 패턴 사용 테스트
  - [SingletonTest/singletonServiceTest](src/test/java/com/example/corebasic/singleton/SingletonTest.java)
- 싱글톤은 하나의 객체 생성을 보장한다는 장점이 있지만 단점도 매우 많음
  - 싱글톤 패턴을 구현하는 코드 자체가 필요
  - 의존관계상 클라이언트가 구체 클래스에 의존 -> DIP 원칙 위반 -> OCP 원칙 위반 가능성 증가
  - private 생성자로 자식 클래스를 만들기 어려움
  - 결론적으로 유연성이 감소하며 안티패턴으로 분류되기도 함
- 스프링 컨테이너(싱글톤 컨테이너)는 싱글톤 패턴이 가지는 단점은 제거하며 객체를 싱글톤으로 관리해줌

### 싱글톤 컨테이너
- 스프링 컨테이너는 싱글톤 컨테이너(레지스트리) 역할을 하며 싱글톤 패턴의 문제점을 해결
  - [SingletonTest/springContainer](src/test/java/com/example/corebasic/singleton/SingletonTest.java)
  - 싱글톤 패턴을 위한 지저분한 코드가 들어가지 않음
  - DIP, OCP, 테스트, private 생성자로 부터 자유롭게 싱글톤을 사용
- 스프링 빈의 기본 동작 방식은 싱글톤이며 싱글톤이 아니어야할 경우, 스코프를 조정하여 변경 가능

### 싱글톤 방식의 주의점
- 1개의 객체만 생성되어 모두가 공용으로 사용하기에 **변경 가능한 상태 값을 가지거나 의존적으로 설계해서는 안됨**
  - **스프링 빈은 항상 무상태(stateless)로 설계**
  - 특정 클라이언트에 의존적인 필드 혹은 특정 클라이언트가 값을 변경할 수 있는 필드가 있어서는 안됨
  - 가급적 클래스 필드는 읽기만 가능하게 하며, 자바에서 공유되지 않는, 지역변수, 파라미터, ThreadLocal 등을 사용
  - 스프링 빈의 필드에 공유 값을 설정하면 정말 큰 장애가 발생할 가능성이 있음
- 상태(price)를 유지하는 클래스와 문제 발생 테스트
  - [StatefulService](src/test/java/com/example/corebasic/singleton/StatefulService.java)
  - [StatefulServiceTest](src/test/java/com/example/corebasic/singleton/StatefulServiceTest.java)

### @Configuration과 싱글톤
- @Configuration는 싱글톤을 위해 존재한다고 봐도 무방함
- AppConfig에서 new MemoryMemberRepository()는 3번 호출되는데 과연 싱글톤을 보장할까?
  - [MemberServiceImpl](src/main/java/com/example/corebasic/member/MemberServiceImpl.java)의 MemberRepository와 [OrderServiceImpl](src/main/java/com/example/corebasic/order/OrderServiceImpl.java)의 MemberRepository를 비교
  - [ConfigurationSingletonTest/configurationTest](src/test/java/com/example/corebasic/singleton/ConfigurationSingletonTest.java)
  - 3개 모두 같은 객체 정보, 싱글톤을 보장하고 있음
- 스프링은 어떻게 싱글톤을 보장하는 것이 가능할까? 함수 자체가 실행되지 않는걸까?
  - [AppConfig](src/main/java/com/example/corebasic/AppConfig.java) 수정 후 테스트
  - 자바 코드에서 3번의 Call AppConfig.memberRepository 가 출력되어야 하지만 1번만 출력
  - 함수 자체가 실행되지 않음을 의미

### @Configuration과 바이트코드 조작의 마법
- 스프링은 싱글톤을 보장해야 하지만 자바 코드 자체를 수정할 수는 없음
- @Configuration 이 사용된 AppConfig를 자세히 확인
  - [ConfigurationSingletonTest/configurationDeep](src/test/java/com/example/corebasic/singleton/ConfigurationSingletonTest.java)
  - AppConfig 뒤에 EnhancerBySpringCGLIB 가 더 붙음 
- 스프링은 클래스의 바이트코드를 조작하는 라이브러리(CGLIB)를 사용하여 싱글톤을 보장
  - 내가 작성한 클래스가 아닌 이를 상속받는 클래스를 스프링 빈으로 등록
  - @Bean 메서드를 실행하면서 이미 빈이 존재하면 존재하는 빈을 반환, 빈이 없으면 생성해서 스프링 빈으로 등록하고 반환하는 코드가 동적으로 생성됨
  - 상속을 받아 생성한 임시 객체임으로 검색이 가능
- @Configuration이 없이 @Bean만 사용하면
  - 사용자가 작성한 순수한 클래스가 빈으로 등록됨
  - 스프링 빈도 다 정상적으로 등록되지만, 싱글톤은 보장하지 않음

## 섹션 6. 컴포넌트 스캔
### 컴포넌트 스캔과 의존관계 자동 주입 시작하기
- 지금까지 자바 코드의 @Bean이나 XML의 \<bean\> 등 설정 정보에 스프링 빈을 직접 명시
  - 등록해야 할 스프링 빈이 증가하게되면 설정 정보도 커지고, 누락하는 문제도 발생
  - 개발자가 일일히 설정 정보를 명시하지 않아도 자동으로 스프링 빈을 등록할 수 있게 지원하는 **컴포넌트 스캔**이 존재
  - **의존관계도 자동으로 주입**(지정)할 수 있게끔 **@Autowired** 라는 기능도 제공
- 기존 AppConfig는 학습을 위해 유지, 컴포넌트 스캔 학습을 위한 새로운 AutoAppConfig.java 작성
  - [AutoAppConfig](src/main/java/com/example/corebasic/AutoAppConfig.java)
  - @ComponentScan 을 설정 정보에 추가하면 스프링이 제공하는 컴포넌트 스캔을 사용할 수 있음
  - 기존의 AppConfig와는 다르게 @Bean으로 등록한 클래스는 물론이고 아무 내용이 없음
    - 어떻게 빈이 될 클래스를 지정할 것인가? -> @Component
    - 어떻게 의존관계를 주입해야 할까? -> @Autowired
- @Component 를 추가하면 컴포넌트 스캔의 대상이 되어 스프링 빈으로 등록됨
  - [MemoryMemberRepository](src/main/java/com/example/corebasic/member/MemoryMemberRepository.java)
  - [RateDiscountPolicy](src/main/java/com/example/corebasic/discount/RateDiscountPolicy.java)
- @ComponentScan 사용 시 설정 정보(@Bean)가 없기 때문에, 의존관계 주입도 각 클래스 안에서 해결해야 함
- @Autowired 를 추가하면 스프링이 의존관계를 자동으로 주입해줌
  - [OrderServiceImpl](src/main/java/com/example/corebasic/order/OrderServiceImpl.java)
  - [MemberServiceImpl](src/main/java/com/example/corebasic/member/MemberServiceImpl.java)
- ComponentScan 테스트 코드
  - [AutoAppConfigTest](src/test/java/com/example/corebasic/scan/AutoAppConfigTest.java)
  - AnnotationConfigApplicationContext 를 사용하는 것은 기존과 동일하며, 설정 정보로 AutoAppConfig 클래스를 전달
  - 로그 정보를 통해 컴포넌트 스캔이 잘 동작하는 것을 확인할 수 있음
```log
ClassPathBeanDefinitionScanner - Identified candidate component class: file [.. RateDiscountPolicy.class]
ClassPathBeanDefinitionScanner - Identified candidate component class: file [.. MemberServiceImpl.class]
ClassPathBeanDefinitionScanner - Identified candidate component class: file [.. MemoryMemberRepository.class]
ClassPathBeanDefinitionScanner - Identified candidate component class: file [.. OrderServiceImpl.class]
// ...
DefaultListableBeanFactory - Creating shared instance of singleton bean 'autoAppConfig'
DefaultListableBeanFactory - Creating shared instance of singleton bean 'rateDiscountPolicy'
DefaultListableBeanFactory - Creating shared instance of singleton bean 'memberServiceImpl'
DefaultListableBeanFactory - Creating shared instance of singleton bean 'memoryMemberRepository'
DefaultListableBeanFactory - Autowiring by type from bean name 'memberServiceImpl' via constructor to bean named 'memoryMemberRepository'
DefaultListableBeanFactory - Creating shared instance of singleton bean 'orderServiceImpl'
DefaultListableBeanFactory - Autowiring by type from bean name 'orderServiceImpl' via constructor to bean named 'memoryMemberRepository'
DefaultListableBeanFactory - Autowiring by type from bean name 'orderServiceImpl' via constructor to bean named 'rateDiscountPolicy'
```

**요약**  

- @ComponentScan 스프링 빈 등록
  - @Component 가 붙은 클래스를 스프링 빈으로 등록
  - 스프링 빈의 기본 이름은 클래스명을 사용하되 맨 앞글자만 소문자를 사용
    - 빈 이름 기본 전략 : MemberServiceImpl 클래스 -> memberServiceImpl
    - 빈 이름 직접 지정 : 스프링 빈의 이름을 직접 지정하는 경우, @Component("memberService2")로 이름을 부여
- @Autowired 의존관계 자동 주입
  - 생성자에 @Autowired 를 지정하면 스프링 컨테이너가 자동으로 해당 스프링 빈을 찾아서 주입
  - 기본 조회 전략은 **타입이 같은 빈을 찾아서 주입**
  - getBean(MemberRepository.class) 와 동일하다고 이해하면 편함
  - 생성자에 파라미터가 많아도 다 찾아서 자동으로 주입

### 탐색 위치와 기본 스캔 대상
- 모든 클래스를 컴포넌트 스캔하면 시간이 오래 걸림으로 컴포넌트 스캔의 시작 위치를 지정하여 필요한 클래스만 스캔할 수 있음
```java
@ComponentScan(
        // basePackages 로 탐색할 패키지의 시작 위치를 지정
        // 해당 패키지를 포함해서 하위 패키지를 모두 탐색
        basePackages = "com.example.corebasic",

        // 여러 시작 위치 지정하는 경우
        basePackages = {"com.example.corebasic.member", "com.example.corebasic.order"},

        // 지정한 클래스의 패키지를 탐색 시작 위치로 지정하는 경우
        basePackageClasses = AutoAppConfig.class,

        // basePackages 혹은 basePackageClasses 미 지정시,
        // @ComponentScan 이 붙은 설정 정보 클래스의 패키지를 탐색 시작 위치로 지정
}
```
- 패키지 위치를 지정하지 않고, 설정 정보 클래스의 위치를 프로젝트 최상단에 두는 것을 권장
  - 프로젝트 메인 설정 정보는 프로젝트를 대표하는 정보이기 때문에 프로젝트 시작 루트 위치에 두는 것을 권장
  - 최근 스프링 부트도 이 방법을 기본으로 제공
    - 스프링 부트의 대표 시작 정보인 @SpringBootApplication 를 프로젝트 시작 루트 위치에 두는 것이 관례
    - 해당 애노테이션 안에 @ComponentScan이 포함 됨
- 다음 애노테이션들은 내부적으로 @Component 를 포함하기 때문에 컴포넌트 스캔의 대상에 포함되며, 스프링에 의해 부가 기능을 수행
  - @Component : 컴포넌트 스캔에서 사용
  - @Controller : 스프링 MVC 컨트롤러에서 사용, 인식 됨
  - @Service : 스프링 비즈니스 로직에서 사용, 개발자에게 핵심 비즈니스 계층을 인식하는데 도움을 주는 것 이외에 특별한 처리를 하지 않음, 보통의 경우 트랜잭션의 시작과 종료 위치
  - @Repository : 스프링 데이터 접근 계층에서 사용, 인식되며 데이터 계층의 예외를 스프링 예외로 추상화하여 변환
  - @Configuration : 스프링 설정 정보에서 사용, 인식되며 스프링 빈이 싱글톤을 유지하도록 추가 처리

> 애노테이션에는 상속관계라는 것이 없음  
> 애노테이션이 특정 애노테이션을 들고 있는 것을 인식할 수 있는 것은 자바가 아닌 스프링이 지원하는 기능  
>
> useDefaultFilters 옵션은 기본으로 켜져있는데, 이 옵션을 끄면 기본 스캔 대상들이 제외됨  

### 필터
- ComponentScan의 Filter 설정을 통해 스캔 대상을 지정할 수 있음
  - includeFilters : 컴포넌트 스캔 대상을 추가로 지정
  - excludeFilters : 컴포넌트 스캔에서 제외할 대상을 지정
- 컴포넌트 스캔 대상에 추가할 애노테이션과 클래스
  - [MyIncludeComponent](src/test/java/com/example/corebasic/scan/filter/MyIncludeComponent.java)
  - [BeanInclude](src/test/java/com/example/corebasic/scan/filter/BeanInclude.java)
- 컴포넌트 스캔 대상에서 제외할 애노테이션과 클래스
  - [MyExcludeComponent](src/test/java/com/example/corebasic/scan/filter/MyExcludeComponent.java)
  - [BeanExclude](src/test/java/com/example/corebasic/scan/filter/BeanExclude.java)
- 설정 정보와 전체 테스트 코드
  - [ComponentFilterAppConfigTest](src/test/java/com/example/corebasic/scan/filter/ComponentFilterAppConfigTest.java)
  - includeFilters 에 MyIncludeComponent 애노테이션을 추가해서 BeanInclude가 스프링 빈에 등록됨
  - excludeFilters 에 MyExcludeComponent 애노테이션을 추가해서 BeanExclude가 스프링 빈에 등록되지 않음

> @Component 면 충분하기 때문에 includeFilters 를 사용할 일은 거의 없으며, excludeFilters 는 여러가지 이유로 간혹 사용할 때가 있지만 많지는 않음  
> 스프링 부트는 컴포넌트 스캔을 기본으로 제공하는데, 옵션을 변경하여 사용하기 보다는 스프링의 기본 설정에 최대한 맞추어 사용하는 것을 권장

### 중복 등록과 충돌
- 컴포넌트 스캔 시, 빈 이름을 중복 등록하는 문제
- @Component 자동 빈 등록 vs @Component 자동 빈 등록
  - 컴포넌트 스캔에 의해 자동으로 스프링 빈이 등록될 때, 빈 이름이 중복되는 경우 스프링은 오류를 발생시킴
    - ConflictingBeanDefinitionException
- @Bean 수동 빈 등록 vs @Component 자동 빈 등록
  - [AutoAppConfig](src/main/java/com/example/corebasic/AutoAppConfig.java) 수정 후 테스트 시, 작동 가능
    - Overriding bean definition for bean 'memoryMemberRepository' with a different definition: replacing
  - 빈 이름 중복 등록 시, 수동 빈 등록이 우선권을 가지며, 수동 빈이 자동 빈을 오버라이딩 해버림
  - 개발자가 의도적으로 사용한다면 우선권을 주는게 올바른 설계, But 실제로는 여러 설정들이 꼬여서 결과가 우연히 만들어지는 경우가 대부분
- 최근 스프링 부트에서는 수동 빈 등록과 자동 빈 등록이 충돌나면 오류가 발생하도록 기본 값을 변경
  - Consider renaming one of the beans or enabling overriding by setting spring.main.allow-bean-definition-overriding=true

## 섹션 7. 의존관계 자동 주입
### 다양한 의존관계 주입 방법
#### 생성자 주입
- 생성자를 통해서 의존 관계를 주입받는 방법
- 생성자 호출 시점에 딱 1번만 호출되는 것을 보장함으로 **불변, 필수 의존관계에 사용**
- 생성자가 딱 1개만 있으면 @Autowired를 생략해도 자동 주입됨
```java
@Component
public class OrderServiceImpl implements OrderService {
    private final MemberRepository memberRepository;
    private final DiscountPolicy discountPolicy;
    
    @Autowired // 생략 가능
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
}
```

#### 수정자 주입(setter 주입)
- setter라 불리는 자바빈 프로퍼티 규약의 수정자 메서드를 통해 필드의 값을 변경하여 의존관계를 주입하는 방법
- 의존 관계의 변경이 가능함으로 **선택, 변경 가능성이 있는 의존관계에 사용**
```java
@Component
public class OrderServiceImpl implements OrderService {
    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;
    
    @Autowired
    public void setMemberRepository(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Autowired
    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
        this.discountPolicy = discountPolicy;
    }
}
```

> @Autowired 의 기본 동작은 주입할 대상이 없으면 오류가 발생  
> 주입할 대상이 없어도 동작하게 하려면 @Autowired(required = false) 로 지정

#### 필드 주입
- 의존성 필드에 바로 주입하는 방법
- 편의성은 높지만 외부에서 변경이 불가능해서 테스트하기 힘들다는 치명적인 단점이 존재하며 DI 프레임워크가 없으면 아무것도 할 수 없음
- 다음의 경우에 **사용을 고려하고 그 외에는 사용하지 말것**
  - 애플리케이션의 실제 코드와 관계 없는 테스트 코드
  - 스프링 설정을 목적으로 하는 @Configuration 같은 곳에서 특별한 용도로 사용
```java
@Component
public class OrderServiceImpl implements OrderService {
    @Autowired private MemberRepository memberRepository;
    @Autowired private DiscountPolicy discountPolicy;
}
```

> 순수한 자바 테스트 코드에는 당연히 @Autowired가 동작하지 않으며 @SpringBootTest 처럼 스프링 컨테이너를 테스트에 통합한 경우에만 가능  

#### 일반 메서드 주입
- 일반 메서드를 통해서 의존성을 주입받는 방법
- 한번에 여러 필드를 주입 받을 수 있지만 **일반적으로 잘 사용하지 않음**
```java
@Component
public class OrderServiceImpl implements OrderService {
    private MemberRepository memberRepository;
    private DiscountPolicy discountPolicy;

    @Autowired
    public void init(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }
}
```

> 의존관계 자동 주입은 스프링 컨테이너가 관리하는 스프링 빈이어야 동작  
> 스프링 빈이 아닌 Member 같은 클래스에서 @Autowired 코드를 적용해도 아무 기능도 동작하지 않음

### 옵션 처리
- 의존성 객체가 스프링 빈에 등록되지 않아도 동작해야 할 때가 있는 경우
  - @Autowired 만 사용하면 required 옵션의 기본값이 true 임으로 자동 주입 대상이 없으면 오류가 발생
- 자동 주입 대상을 옵션으로 처리하는 방법
  - @Autowired(required=false) : 자동 주입할 대상이 없으면 수정자 메서드 자체가 호출 안됨
  - org.springframework.lang.@Nullable : 자동 주입할 대상이 없으면 null이 입력
  - Optional<> : 자동 주입할 대상이 없으면  Optional.empty 가 입력
  - [AutowiredTest](src/test/java/com/example/corebasic/autowired/AutowiredTest.java)

> @Nullable, Optional은 스프링 전반에 걸쳐서 지원됨, 따라서 생성자 자동 주입에서 특정 필드에만 사용할 수 있음

### 생성자 주입을 선택해라!
#### 불변
- 의존관계는 한번 결정되면 애플리케이션 종료 시점까지 변경할 일이 거의 없으며, 변경해서는 안되는 경우가 더 많음
- 수정자 주입은 setXxx 메서드를 public으로 설정함으로 누군가 실수로 변경할 가능성이 있음
  - 변경하면 안되는 메서드를 열어두는 것은 좋은 설계가 아님
- 생성자 주입은 객체를 생성할 때 1번만 호출하는 것을 보장함으로 불변하게 설계할 수 있음

#### 누락
- [OrderServiceImplTest](src/test/java/com/example/corebasic/order/OrderServiceImplTest.java)
- 수정자 주입의 경우 의존관계(memberRepository, discountPolicy) 주입이 누락되었기 때문에 실행 시, Null Point Exception이 발생
- 생성자 주입을 사용하면 주입 데이터를 누락했을 때 IDE에서 바로 어떤 값을 필수로 주입해야 하는지 확인할 수 있으며 실행 시, 컴파일 오류가 발생

#### final 키워드
- final 멤버 변수는 선언 시 값을 지정하거나 생성자를 통해서만 값을 할당할 수 있음
- 생성자 주입 방식만이 필드에 final 키워드를 사용할 수 있으며, 생성자에서 혹시라도 값이 할당되지 않는 경우 컴파일 오류가 발생
  - 생성자 주입을 제외한 나머지 주입 방식은 모두 생성자 이후에 호출되므로, 필드에 final 키워드를 사용할 수 없음

#### 정리
- 생성자 주입 방식은 프레임워크에 의존하지 않고, 순수한 자바 언어의 특징을 잘 살리는 방법
- 기본으로 생성자 주입을 사용하고, 필수 값이 아닌 경우에는 수정자 주입 방식을 옵션으로 부여
- 필드 주입은 프레임워크가 없이는 테스트를 할 수 없음으로 사용하지 않는게 좋음

### 롬복과 최신 트랜드
- 생성자 주입, Setter, Getter 작성은 무엇을 해야할지 명확한 단순 반복
- Lombok 라이브러리가 제공하는 @RequiredArgsConstructor 기능을 사용하면 final이 붙은 필드를 모아서 생성자를 자동으로 작성해줌
  - 자바의 애노테이션 프로세서라는 기능을 이용해서 컴파일 시점에 생성자 코드를 자동으로 생성
  - class 파일 확인하면 실제 코드가 추가된 것을 확인할 수 있음
- @RequiredArgsConstructor
  - [OrderServiceImpl](src/main/java/com/example/corebasic/order/OrderServiceImpl.java)
  - [MemberServiceImpl](src/main/java/com/example/corebasic/member/MemberServiceImpl.java)
- @Getter, @Setter
  - [Order](src/main/java/com/example/corebasic/order/Order.java)
  - [Member](src/main/java/com/example/corebasic/member/Member.java)

### 조회 빈이 2개 이상 - 문제
### @Autowired 필드 명, @Qualifier, @Primary
### 애노테이션 직접 만들기
### 조회한 빈이 모두 필요할 때, List, Map
### 자동, 수동의 올바른 실무 운영 기준

## 섹션 8. 빈 생명주기 콜백
### 빈 생명주기 콜백 시작
### 인터페이스 InitializingBean, DisposableBean
### 빈 등록 초기화, 소멸 메서드
### 애노테이션 @PostConstruct, @PreDestroy

## 섹션 9. 빈 스코프
### 빈 스코프란?
### 프로토타입 스코프
### 프로토타입 스코프 - 싱글톤 빈과 함께 사용시 문제점
### 프로토타입 스코프 - 싱글톤 빈과 함께 사용시 Provider로 문제 해결
### 웹 스코프
### request 스코프 예제 만들기
### 스코프와 Provider
### 스코프와 프록시

## 섹션 10. 다음으로
### 다음으로

## Reference
- [Java Enum](https://honbabzone.com/java/java-enum/)
- [Java Static Import](https://offbyone.tistory.com/283)
- [섹션 4. 스프링 컨테이너와 스프링 빈 정리 자료](https://jihyunhillpark.github.io/springframework/spring-fundamental4/) 