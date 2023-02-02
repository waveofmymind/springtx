## 스프링 트랜잭션 연습을 위한 저장소입니다.

## 스프링 트랜잭션이란?

ORM이 변경되면, 기술마다 쓰이는 트랜잭션 방법이 다르기 때문에 코드를 번거롭게 수정해야하는 상황이 발생한다.

이를 해결하기 위해 스프링에서는 스프링 트랜잭션 추상화 인터페이스를 제공한다.

## 트랜잭션 적용되는지 확인하기

@Transactional은 트랜잭션을 간편하게 사용할 수 있도록 도와주지만, AOP를 기반으로 적용되기에 확인하기 어렵다.

### 테스트에서 Lombok 사용하기

dependencies 내에 추가

```
testCompileOnly 'org.projectlombok:lombok'
testAnnotationProcessor 'org.projectlombok:lombok'
```






