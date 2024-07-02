package com.application.jpa.chapter04_entityRelation.basic;
/*

# enum

- 이뉴머레이션(enumeration) 또는 열거형(enums)은 자바에서 특정 상수 집합을 정의할 때 사용되는 특별한 데이터 타입이다. 
- 이뉴머레이션은 코드의 가독성과 유지보수성을 높이는 데 도움을 준다.
- 자바에서는 enum 키워드를 사용하여 이뉴머레이션을 정의한다.

[ 예시 ]

enum Day {
	SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY
}

enum CardType {
	VISA, MASTERCARD, AMERICAN_EXPRESS, DISCOVER
}

*/

public enum RoleType {

	USER, SELLER, ADMIN
}
