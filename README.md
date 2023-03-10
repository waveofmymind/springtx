## 스프링 트랜잭션 연습을 위한 저장소입니다.

## 스프링 트랜잭션이란?

ORM이 변경되면, 기술마다 쓰이는 트랜잭션 방법이 다르기 때문에 코드를 번거롭게 수정해야하는 상황이 발생한다.

이를 해결하기 위해 스프링에서는 스프링 트랜잭션 추상화 인터페이스를 제공한다.

## [트랜잭션 적용되는지 확인하기](https://waveofymymind.tistory.com/53)

@Transactional은 트랜잭션을 간편하게 사용할 수 있도록 도와주지만, AOP를 기반으로 적용되기에 확인하기 어렵다.

## 트랜잭션 적용 범위

@Transactional은 클래스, 메서드 둘다 선언할 수 있는데, 더 자세한 것이 항상 우선순위를 가진다.

즉, 메서드가 더 우선순위를 가지게 된다.

## 프록시 내부 호출 문제

트랜잭션을 선언하지 않은 메서드 내에서 트랜잭션 메서드를 선언할 경우, 자신의 인스턴스의 메서드를 호출하기 때문에 프록시를 거치지 않아 트랜잭션이 적용되지 않는다.

트랜잭션 메서드를 이용할 경우, 클래스를 분리해서 사용해야한다.

[프록시 내부 호출 문제 발생](https://waveofymymind.tistory.com/54)

[프록시 내부 호출 문제 ](https://waveofymymind.tistory.com/55)

## 초기화 시점에서는 트랜잭션이 적용되지 않는다.

@PostConstruct과 @Transactional을 함께 사용할 경우, 초기화 코드가 먼저 호출되기 때문이다.

해결 방법은 @EventListner(ApplicationReadyEvent.class)로 초기화가 끝난 다음 호출하도록 해야한다.

## 트랜잭션 전파(Propagation)

한 트랜잭션이 수행중, 내부 로직에 의해 새로운 트랜잭션이 수행되어야 할 경우 처리 방법에 대한 개념

이때 보통 두 트랜잭션을 하나의 트랜잭션으로 묶는다.
묶은 하나의 트랜잭션을 **물리 트랜잭션**, 각각의 트랜잭션을 **논리 트랜잭션**이라고 한다.

이때의 원칙
- **모든 논리 트랜잭션이 커밋되어야 물리 트랜잭션을 DB에 커밋한다.**
- **하나의 논리 트랜잭션이라도 롤백되면 물리 트랜잭션을 롤백시킨다.**

[스프링 트랜잭션 전파 - 1](https://waveofmymind.tistory.com/59)

[스프링 트랜잭션 전파 - 2](https://waveofmymind.tistory.com/60)

*PROPAGATION_REQUIRES_NEW* 옵션을 사용하면, 논리 트랜잭션을 독립적으로 사용할 수 있다.

외부 트랜잭션 수행중, 내부 트랜잭션이 수행되어져야 할 경우, 외부 트랜잭션을 잠시 미뤄두고 내부 트랜잭션 먼저 수행한다.(인터셉트와 개념이 유사하다.)

## 트랜잭션 전파 옵션 - REQUIRES_NEW

> @Transactional(propagation=Propagation.REQUIRES_NEW)

해당 옵션을 사용하면, 논리 트랜잭션을 분리해서 수행할 수 있다.

[트랜잭션 전파 옵션 - REQUIRES_NEW](https://waveofmymind.tistory.com/61)






## 테스트에서 Lombok 사용하기

dependencies 내에 추가

```
testCompileOnly 'org.projectlombok:lombok'
testAnnotationProcessor 'org.projectlombok:lombok'
```






