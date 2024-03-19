# SPRING CLOUD 기반 MICROSERVICE ARCHITECTURE 프로젝트

## TECH-STACK
- Spring Cloud 2023.0.0
- Spring Cloud Gateway
- Spring Boot 3.2.2
- Netflix Eureka Server
- Spring Data JPA
- Spring Security 6.2.3
- OAuth 2.0
- Java 17
- H2 Database
- Gradle
- Lombok
- IntelliJ IDEA 2023.3.5 (Ultimate Edition)
- macOS Sonoma 14.4(23E214) 
- Apple M1

## REFERENCE
- 스프링 마이크로서비스 코딩 공작소 개정 2판 (SPRING MICROSERVICES IN ACTION 2ND ED.)
  - 존 카넬, 일러리 후알리루포 산체스 지음 | 정성권 옮김
  - 출판사 길벗
  - 스프링 부트와 스프링 클라우드를 이용한 마이크로서비스 모범 사례
  - 스프링 부트와 스프링 클라우드, 도커, 하시코프 볼트, 아파치 카프카, 키클록, 오픈 집킨, ELK 스택, 그라파나, 프로메테우스, AWS EKS, 깃허브/젠킨스 를 사용해 쿠버네티스 기반의 마이크로서비스 구축
<details>
  <summary>요약정리 상세보기 (클릭)</summary>

### 제 1장. 스프링, 클라우드와 만나다.

- 모놀리식 아키텍처에서 모든 프로세스는 강하게 결합되어 하나의 서비스로 실행된다.
- 마이크로서비스는 하나의 특정 영역을 담당하는 매우 작은 기능 부분이다.
- 스프링 부트를 사용하면 두 유형의 아키텍처를 모두 구축할 수 있다.
- 모놀리식 아키텍처는 단순하고 가벼운 애플리케이션에 이상적이며 마이크로서비스 아키텍처는 일반적으로 복잡하고 진화하는 애플리케이션에 더 작합하다. 결과저그로 소프트웨어 아키텍처의 선택은 프로젝트의 규모, 기간, 요구 사항 등 다른 요소에 전적으로 좌우된다. 스프링 부트는 REST 기반/JSON 마이크로서비스 구축을 단순화한다. 그 목표는 몇 가지 애너테이션만으로도 마이크로서비스를 신속하게 구축할 수 있게 하는 것이다.
- 마이크로서비스를 작성하는 것은 쉽지만, 실제 환경에서 완전하게 운영하려면 사전에 추가로 고려할 사항이 많다. 즉, 핵심 개발 패턴, 라우팅 패턴, 클라이언트 회복성 패턴, 보안 패턴, 애플리케이션 지표 패턴, 빌드/배포 패턴을 비롯한 여러 종류의 마이크로서비스 개발 패턴을 고려해야 한다.
- 마이크로서비스 라우팅 패턴은 마이크로서비스를 사용하려는 클라이언트 애플리케이션이 서비스 위치와 서비스로 라우팅되는 방법을 다룬다.
- 서비스 인스턴스 문제가 서비스 소비자에게 연쇄적으로 전파되는 것을 방지하려면 클라이언트 회복성 패턴을 사용하라. 이 패턴에는 실패한 서비스에 대한 호출을 피할 수 있는 회로차단기 패턴, 서비스가 실패할 때 데이터를 조회하거나 특정 작업을 수행하는 대체 경로를 만드는 폴백 패턴, 가능한 모든 병목 및 장애 시나리오 지점을 해소하고 제거하는 클라이언트 부하 분산 패턴, 다른 서비스에 악영향을 미치는 성능 낮은 서비스에 호출을 방지하도록 서비스에 대한 동시 호출 수를 제한하는 벌크헤드 패턴이 포함된다.
- OAuth 2.0 은 가장 보편적인 사용자 인가 프로토콜이며 마이크로서비스를 보호할 수 있는 탁월한 선택이다.
- 빌드/배포 패턴을 사용하면 인프라스트럭처의 구성을 빌드/배포 프로세스에 바로 통합할 수 있어 자바 WAR 나 EAR 파일 같은 산출물을 이미 실행 중인 인프라스트럭처에 배포하지 않아도 된다.

### 제 2장. 스프링 클라우드와 함께 마이크로서비스 세계 탐험

- 스프링 클라우드는 넷플릭스와 하시코프와 같은 회사의 오픈 소스 기술 집합이다. 이 기술은 서비스의 설정과 구성을 단순화하기 위해 스프링 애너테이션으로 포장(Wrap) 한다.
- 클라우드 네이티브 애플리케이션은 컨테이너 같은 확장 가능한 컴포넌트로 구축되어 마이크로서비스로 배포되고, 지속적 전달 워크플로로 된 데브옵스 프로세스를 통해 가상 인프라스트럭처에서 관리된다.
- 데브옵스는 개발(Dev) 과 운영(Ops) 에 대한 약어다. 소프트웨어 개발자와 IT 운영자 간 의사 소통, 협업, 통합에 중점을 둔 소프트웨어 개발 방법론을 의미한다. 주요 목표는 소프트웨어 전달 및 인프라스트럭처 변경 과정을 저비용으로 자동화하는 것이다.
- 헤로쿠(Heroku) 에서 체계화된 12 팩터 애플리케이션 선언문은 클라우드 네이티 마이크로서비스를 구축할 때 구현해야 하는 모범 사례를 제공한다.
- 12 팩터 애플리케이션 선언문의 모범 사례에는 코드베이스, 의존성, 구성 정보, 백엔드 서비스, 빌드/릴리스 실행, 프로세스, 포트 바인딩, 동시성, 폐기 기능, 개발/운영 환경 일치, 로그, 관리 프로세스 주제가 포함되어 있다.
- Spring Initializer 를 사용하면 수많은 의존성 목록에서 원하는 의존성을 선택하면서 스프링 부트 프로젝트를 생성할 수 있다.
- 스프링 부트는 몇 가지 간단한 애너테이션만으로도 REST 기반 JSON 서비스를 구축할 수 있기 때문에 마이크로서비스를 구축하는 이상적 프레임워크다.

### 제 3장. 스프링 부트로 마이크로서비스 구축하기

- 마이크로서비스의 성공을 위해 아키텍트, 소프트웨어 개발자, 데브옵스 이 세 팀의 관점을 통합해야 한다.
- 마이크로서비스는 강력한 아키텍처 패러다임이지만 장단점이 있다. 모든 애플리케이션이 마이크로서비스 애플리케이션일 필요는 없다.
- 아키텍트 관점에서 마이크로 서비스는 작고 독립적이며 분산되어 있다. 마이크로서비스는 그 경계가 좁고 소규모 데이터를 관리해야 한다.
- 개발자 관점에서 마이크로서비스는 일반적으로 REST 스타일 디자인을 사용해서 구축되고 데이터를 주고받을 수 있는 페이로드로 JSON을 사용한다.
- 국제화의 주요 목표는 다양한 형식과 언어로 콘텐츠를 제공하는 애플리케이션을 개발하는 것이다.
- HATEOAS 는 애플리케이션 상태 엔진인 하이퍼미디어(Hypermedia As The Engine Of Application State) 의 줄임말이다. 스프링 HATEOAS 는 HATEOAS 원칙(주어진 리소스에 대한 관련 링크를 표시)을 따르는 API를 생성할 수 있는 작은 프로젝트다.
- 데브옵스 관점에서 마이크로서비스를 패키징, 배포, 모니터링하는 방법은 매우 중요하다. 스프링 부트를 사용하면 추가 모듈의 설치 없이 기본적으로 서비스를 실행 가능한 하나의 JAR 파일로 제공할 수 있다. 이렇게 생성된 JAR 파일에 포하묀 톰캣(Tomcat) 서버가 서비스를 호스팅한다.
- 스프링 부트 프레임워크에 포함된 스프링 엑추에이터는 서비스의 런타임 정보와 함께 서비스의 운영 상태 정보도 제공한다.

### 제 4장. 도커 (Docker)

- 컨테이너를 사용하면 개발자 컴퓨터부터 물리 또는 가상의 엔터프라이즈 서버까지 모든 환경에서 개발 중인 소프트웨어를 성공적으로 실행할 수 있다.
- 가상 머신(VM) 을 사용하면 다른 컴퓨터에서 다른 컴퓨터의 동작을 에뮬레이션할 수 있다. 이것은 물리 머신을 완전히 모방하는 하이퍼바이저에 기반을 두며 요구되는 양의 시스템 메모리, 프로세서 코어, 디스크 스토리지나 PCI 추가 기능 등 다른 리소스를 할당한다.
- 컨테이너는 격리되고 독립적인 환경에서 의존 요소와 애플리케이션을 포함해서 실행할 수 있는 운영 체제(OS) 가상화 방법 중 하나다.
- 컨테이너를 사용하면 실행 프로세스의 속도를 높이는 경량의 VM 을 만들어 일반 비용을 줄여 각 프로젝트의 비용을 절감할 수 있다.
- 도커는 리눅스 컨테이너를 기반으로 하는 인기 있는 오픈 소스 컨테이너 엔진으로, 2013년 dotCloud 설립자인 솔로몬 하익스가 개발했다.
- 도커는 도커 엔진, 클라이언트, 레지스트리, 이미지, 컨테이너, 볼륨, 네트워크라는 요소로 구성되어 있다.
- Dockerfile 은 도커 클라이언트가 이미지를 생성허고 준비하고자 호출하는 지시와 명령어가 포함된 단순한 텍스트 파일이다. 이 파일은 이미지 생성 과정을 자동ㅇ화한다. Dockerfile 에 사용된 명령은 리눅스 명령과 유사해서 이해하기 쉽다.
- 도커 컴포즈는 서비스를 그룹으로 정의하고 단일 단위로 함께 시작할 수 있게 해 주는 서비스 오케스트레이션 도구다.
- 도커 컴포즈는 도커 설치 과정의 일부로 설치된다.
- Dockerfile 메이븐 플러그인은 메이븐과 도커를 통합한다.

### 제 5장. 스프링 클라우드 컨피그 서버로 구성 관리

- 스프링 클라우드 구성 서버(컨피그 서버로 알려진) 를 사용하며 애플리케이션 프로퍼티 값을 환경별로 설정할 수 있다.
- 스프링은 서비스 시작할 때 프로파일을 사용하여 스프링 클라우드 컨피그 서비스에서 조회할 환경 프로퍼티들을 결정한다.
- 스프링 클라우드 컨피그 서비스는 파일 또는 깃, 볼트 기반의 애플리케이션 구성 저장소를 사용하여 애플리케이션 프로퍼티를 저장할 수 있다.
- 스프링 클라우드 컨피그 서비스는 대칭 및 비대칭 암호화를 사용하여 중요한 정보를 암호화할 수 있다.

### 제 6장. 서비스 디스커버리

- 서비스 디스커버리 패턴을 사용하여 서비스의 물리적 위치를 추상화한다.
- 유레카같은 서비스 디스커버리 엔진은 서비스 클라이언트에 영향을 주지 않고 해당 환경에서 서비스 인스턴스를 원활하게 추가하고 삭제할 수 있다.
- 클라이언트 측 로드 밸런싱을 사용하면 서비스 호출을 수행하는 클라이언트에서 서비스의 물리적 위치를 캐싱하여 더 높은 성능 및 회복성을 제공할 수 있다.
- 유레카는 스프링 클라우드와 함께 사용할 때 쉽게 구축하고 구성할 수 있는 넷플릭스 프로젝트다.
- 스프링 클라우드와 넷플릭스 유레카에서 서비스를 호출하는 데 다음 세 가지 다른 메커니즘을 사용할 수 있다.
  - 스프링 클라우드 Discovery Client
  - 스프링 클라우드 로드 밸런서를 지원하는 RestTemplate
  - 넷플릭스 Feign 클라이언트

### 7장. 나쁜 상황에 대비한 스프링 클라우드와 Resilience4j 를 사용한 회복성 패턴

- 마이크로서비스처럼 고도로 분산된 애플리케이션을 설계할 때는 클라이언트 회복성을 고려해야 한다.
- 서비스의 전면 장애는 쉽게 탐지하고 처리할 수 있다.
- 성능이 낮은 서비스 하나가 자원을 소진하는 연쇄 효과를 유발할 수 있다. 서비스가 작업을 완료할 때까지 기다리는 동안 호출하는 클라이언트의 스레드가 블로킹되기 때문이다.
- 세 가지 핵심 클라이언트 회복성 패턴은 회로 차단기 패턴, 폴백 패턴, 벌크헤드 패턴이다.
- 회로 차단기 패턴은 느리게 수행되고 저하된 시스템 호출을 제거해서 이러한 호출은 빨리 실패하고, 자원 소진을 막는다. 폴백 패턴은 원격 서비스 호출이 실패하거나 회로 차단기가 실패한경우에 대체 코드 경로를 정의할 수 있다.
- 벑크헤드 패턴은 원격 자원에 대한 호출을 자체 스레드 풀로 격리해서 원격 자원 호출을 서로 분리한다. 한 종류의 서비스 호출이 실패하면 이 실패 때문에 애플리케이션 컨테이너의 모든 자원이 소진되지 않도록 해야한다.
- 속도 제한기 패턴은 주어진 시간 동안 총 호출 수를 제한한다.
- Resilience4j 를 사룡하면 여러 패턴을 동시에 사용할 수 있다.
- 재시도 패턴은 서비스가 일시적으로 실패했을 때 시도하는 역할을 한다.
- 벌크헤드 패턴과 속도 제한기 패턴의 주요 차이점은 벌크헤드는 한 번에 동시 호출 수를 제한하는 역할을 한다.
- 스프링 클라우드와 Resilience4j 라이브러리는 회로 차단기, 폴백, 속도 제한기, 벌크헤드 패턴에 대한 구현을 제공한다.
- Resilience4j 라이브러리는 구성이 용이하며 전역, 클래스 및 스레드 풀 레벨로 설정할 수 있다.

### 8장. 스프링 클라우드 게이트웨이를 이용한 서비스 라우팅

- 스프링 클라우드를 사용하면 서비스 게이트웨이를 쉽게 구축할 수 있다.
- 스프링 클라우드 게이트웨이에는 서술자(predicate) 와 Filter Factories 가 내장되어 있다.
- 서술자는 주어진 조건 집합을 충족하는지 확인할 수 있는 객체다.
- 필터를 사용하면 들어오고 나가는 HTTP 요청과 응답을 수정할 수 있다.
- 스프링 클라우드 게이트웨이는 넷플릭스 유레카 서버와 통합되며, 유레카에 등록된 서비스를 자동으로 경로에 매핑할 수 있다.
- 스프링 클라우드 게이트웨이를 사용하면 필터로 사용자가 정의한 비즈니스 로직을 구현할 수 있다. 스프링 클라우드 게이트웨이를 사용하여 사전 및 사후 필터를 생성할 수 있다.

### 9장. 마이킄로 서비스 보안
- 

</details>