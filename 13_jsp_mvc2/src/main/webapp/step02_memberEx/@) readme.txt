[ 외부라이브러리 참조 메뉴얼 ]


1. 다음 주소 검색 기능 구현  

1-1) 아래의 스크립트를 import 한다.
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

1-2) 아래의 스크립트를 작성후 함수를 호출하여 사용한다.
     (주의사항) 독립적으로 <script></script>안에서 사용하여야 한다.
     
<script>
	function execDaumPostcode() {
	    new daum.Postcode({
	        oncomplete: function(data) {
	
	            var fullRoadAddr = data.roadAddress; 
	            var extraRoadAddr = ''; 
	
	            if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)){
	                extraRoadAddr += data.bname;
	            }
	            if (data.buildingName !== '' && data.apartment === 'Y'){
	               extraRoadAddr += (extraRoadAddr !== '' ? ', ' + data.buildingName : data.buildingName);
	            }
	            if (extraRoadAddr !== ''){
	                extraRoadAddr = ' (' + extraRoadAddr + ')';
	            }
	            if (fullRoadAddr !== ''){
	                fullRoadAddr += extraRoadAddr;
	            }
	
	            document.getElementById('아이디').value = data.zonecode; 				//5자리 새우편번호 사용
	            document.getElementById('아이디').value = fullRoadAddr;
	            document.getElementById('아이디').value = data.jibunAddress;
	          
	        }
	    }).open();
	}
</script>

1-3) 사용방법 레퍼런스
https://postcode.map.daum.net/guide


