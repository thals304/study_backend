package com.application.jpa.chapter03_persistenceQueries.JPQL;

public interface JpqlRepositoryQuestion{

	// 1) 상품의 productId , productNm , price를 조회하는 쿼리를 작성하시오.
	public Object question01();

	// 2) 배송비가 0원인 상품의 전체 컬럼을 조회하는 쿼리를 작성하시오. (파라메타를 전달받아서 구현)
	public Object question02();

	// 3) 가격이 높은 순서대로 상품의 전체컬럼을 조회하시오.
	public Object question03();

	// 4) 상품의 평균 price를 조회하시오.
	public Object question04();

	// 5) 2021년에 등록된 상품의 개수를 조회하시오. (파라메타를 전달받아서 구현)
	public Object question05();

	// 6) 사용중(activeYn = 'Y')인 브랜드의 전체컬럼을 조회하시오. (파라메타를 전달받아서 구현)
	public Object question06();

	// 7) 사용중(activeYn = 'Y')인 브랜드의 brandNm과 해당 브랜드의 productNm컬럼을 조회하시오. (파라메타를 전달받아서 구현)
	public Object question07();

	// 8) 'samsung' 브랜드의 상품개수를 조회하시오. (파라메타를 전달받아서 구현)
	public Object question08();

	// 9) 'lg' 브랜드의 상품 productNm을 조회하시오. (파라메타를 전달받아서 구현)
	public Object question09();

	// 10) '2021년 1사분기(1월~3월)에 입점한 브랜드 상품의 평균 가격을 조회하시오. (파라메타를 전달받아서 구현)
	public Object question10();

}
