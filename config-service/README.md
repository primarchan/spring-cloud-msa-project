# Config Server

## REFERENCE
- Spring Cloud Config Server 를 사용할 때, 클라이언트 측 bootstrap.yml (또는 bootstrap.properties) 파일에 설정한 내용은 Config Server 와 통신하여 애플리케이션 설정을 동적으로 로드하는 데 사용됩니다. 
- 여기서 주어진 설정을 기반으로, Config Server 는 다음과 같은 패턴으로 설정 파일을 찾게 됩니다.

```yml
/{application}/{profile}/{label}
/{application}-{profile}.yml
/{label}/{application}-{profile}.yml
/{application}-{profile}.properties
/{label}/{application}-{profile}.properties
```