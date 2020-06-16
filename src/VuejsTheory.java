
/*
 	===== ES6 =====
 	
 	JSError
 	- var를 사용하면 지역변수 선언과 동일.
 	- var없이 변수를 선언하면 전역변수. 따라서	script영역 전체에서 접근이 가능.
 	- for문이나 if문의 블럭을 벗어나도 변수는 소멸되지 않음.
 	
 	- var를 통해 변수를 선언하면 해당 변수는 호이스팅됨.
 		(호이스팅 : 정의된 변수가 해당스코프의 최상단으로 끌어올려지는 것)
 	- var로 선언한 변수는 재정의가 가능함.
 		※ 일반적인 언어에서는 에러이나, ES6에서는 정상동작함.
 		
 	ECMAScript(ES6)
 	- 변수의 선언(JAVA와 동일한 스코프를 가짐)
 		1. const : 상수처럼 선언 후 값이 바뀌지 않는경우 사용.
 		2. let : 일반적인 변수 선언시 사용. 
 	- ES6의 Arrow Function(화살표 함수)
 		-> JAVA의 람다식과 비슷하다. 기존의 함수에서 function이 제거되고 괄호사이에
 			=> 와 같은 화살표를 삽입한다.
 		-> 형식]
 			let 함수명 = (파라미터) => {
 				함수의 내용
 			}
 		ex) 
 			1. 기존 JS의 함수
		 		var hello1 = function (val){
					return "Hello1";
		        }            
      
        	2-1. JS6의 함수
	         	let hello2 = (val) => {
					return "Hello2";
	            }
	            
 			2-2. 화살표함수에서 실행문장이 한줄인 경우 중괄호 생략가능. return키워드도 생략가능.
 				let hello3 = (val) => "Hello3" + val;
 				
 	===== Vue =====
 	기본형식 
 	- Vue는 MVVM패턴의 방식을 사용.
 		1. Model : Vue에서의 데이터처리를 담당.
 		2. View Model : Vue객체를 인스턴스화하여 처리하는 부분.
 		3. View : body하위나 compenent화면에 대한 대상을 지정.
 			주로 selector(id, class, tag)로 선언.
 	
 	- new Vue ({속성: 속성값, ....});
 		-> 속성1. el : view에 대한 선택자 선언
 		-> 속성2. data : model에 대한 선언
 		ex)	
	 		var vue = new Vue({
	            el : '#app',
	            data : {title : 'Hello Vuejs'}
	        });
        
	        - el : 뷰 인스턴스가 표시될 지점(DOM요소)을 지정
	        - data : 출력할 문자열을 지정
	        
	Mustache(콧수염괄호)
	- 뷰 인스턴스의 데이터를 html태그에 연결(= 화면출력)하는 가장 기본적인 텍스트방식
	
	속성설정 directive
	- DOM객체의 속성을 model데이터와 연동하기 위해 directive를 사용.
	- v-bind : HTML속성에 값을 설정할 때 사용
		형식1]
			v-bind:HTML속성 = "모델속성"
			
		형식2]
			:HTML속성 = "모델속성"
			
	- v-text : DOM하위에 모델데이터를 랜더링없이 그대로 출력할 때 사용. {{}}와 동일한 역할
		형식]
			v-text = "모델속성"
			
	- v-model : 모델데이터를 입력하거나 선택하는 form하위요소에 따라 모델데이터가 양방향으로 변경 처리.
				즉 사용자가 입력한 내용이 모델데이터에 실시간 반영됨.
		형식]
			v-model = "모델명"		
		※ v-model="배열모델"은 순서에 따라 checkbox의 value값과 연동된다.
	
	- v-html : 하위에 데이터를 포함하는 DOM객체에 모델데이터와 연동을 해주는 속성으로
				모델속성과 연결되는 값이 출력.
				
	※ isNaN() : Not a Number 즉 인자로 주어진 데이터가 숫자가 아니면 true
		Number() : JS에서 문자열을 숫자로 변환하는 함수
		
	- v-if : 조건에 부합되는 DOM요소만 랜더링하고, 아니면 랜더링 않함.
		형식]
			v-if="model의 boolean값"
			v-else-if ....
			v-else ....
			
	- v-show : 일단 DOM요소를 랜더링한 후 조건에 만족하는 경우에만 노출. 평소엔 hidden
 
	- v-for
		1. v-for의 배열처리(model 데이터가 배열로 선언된 경우)
			v-for = "(단위객체, index) in 모델배열"
		2. v-for의 객체처리
			v-for = "(value, key, index) in 모델객체"
			
	※ 비교연산의 ==은 단순 값 비교, ===은 값은 물론 데이터형까지 일치여부 비교
 	
	- template : tag자체를 포함하는 반복처리할 때 활용(id속성과 함께 사용)
		
	- v-pre : 랜더링 없이 directive내용을 그대로 보여줌.
	
	- v-once : 초기에 랜더링되어 출력된 모델데이터를 홀드시킴.
	
	- computed : 연산되거나 프로세스가 처리된 결과데이터를 return 받고
		화면에 함수명으로 호출해서 출력할 때 사용.
		
	- filter() : 배열내에서 true를 반환할떄의 요소들만으로 필터링하여 반환할떄의
		(= 즉, true를 반환하는 요소들만 모아서 반환하겠다.)
		형식]
			배열.filter(function(단위객체, 인덱스){
				return조건에 의해 boolean값으로 filtering처리
			});
			
	Vue의 method 속성
	- 기본적인 사용법은 computed와 동일하다.
		단, {{}}에서 사용시 함수호출문장처럼 "메소드명()"으로 기술해야한다.
		
	- method vs computed
		: 선언과 호출방법은 거의 동일.
		단, 모든상황에서 재실행이 필요하다면 method를, 
		참조하는 변수의 변경에만 재실행되게 하려면 computed를 사용하는것이 좋다.
 
	Vue의 watch 속성
	- model데이터의 변경에 따른 특정한 프로세스가 필요한 경우에 사용하는 속성1
	- 형식]
		watch : {
			모델데이터명 : function(입력한값) {
				처리내용;
			}
		}
		
	Vue 이벤트
	- v-on디렉티브 : DOM요소에 이벤트를 적용할떄 사용하는 디렉티브
		형식1]
			v-on:이벤트명='처리할 명령 혹은 함수호출'
			
		형식2]
			@이벤트명='처리할 명령 혹은 함수호출'
			
	- 이벤트에서만큼은 methods(함수)만 호출가능
		(computed는 호출불가)
		
	※ push() : JS에서 배열에 객체 혹은 데이터를 추가할때 사용함.
	
	- v-on:contextmenu.prevent="함수명"
		1. 전체화면에서 우클릭시, 호출할 함수 정의 (대게 우클릭 방지시 사용)
		
	- preventDefault()
		: 요소객체가 가지고 있는 내장된 기능을 방지처리
		a태그의 경우 페이지이동 처리가 되는것을 방지한다.
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 */
