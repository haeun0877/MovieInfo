## Movie Info
일별, 주간/주말 박스오피스, 영화 목록, 영화인 목록, 영화사 목록 정보 제공하는 앱

1. **디자인 패턴** : MVVM 적용
2. **사용 언어** : kotlin
3. **사용 기술** : Live Data, View Binding, Data Binding, Coroutine, Retrofit2, Room, Hilt, Navigation <br/> <br/>

- UI **스켈레톤** 라이브러리를 사용하여 리스트를 불러와지는 동안 로딩화면 구현
    - https://velog.io/@ehusrh8380/Android-kotlin-RecyclerView%EC%97%90-%EC%8A%A4%EC%BC%88%EB%A0%88%ED%86%A4-UI-%EA%B5%AC%ED%98%84%ED%95%98%EA%B8%B0-Shimmer-%EB%9D%BC%EC%9D%B4%EB%B8%8C%EB%9F%AC%EB%A6%AC-%EC%82%AC%EC%9A%A9
- **Hilt** 사용하여 의존성 주입
    - https://velog.io/@ehusrh8380/Android-kotlin-%EC%9D%98%EC%A1%B4%EC%84%B1-%EC%A3%BC%EC%9E%85DI%EC%97%90-%EB%8C%80%ED%95%98%EC%97%AC-Hilt-%EC%82%AC%EC%9A%A9%ED%95%B4%EB%B3%B4%EA%B8%B0
- RecyclerView에 **DiffUtil**을 사용하여 효율적으로 리스트 업데이트 및 구현

### API
- 영화 진흥 위원회 오픈 API 사용 : https://kobis.or.kr/kobisopenapi/homepg/main/main.do
- retrofit 라이브러리 사용하여 RESTFul API 통신 구현<br/> <br/>

### 패키지 구조
![image](https://github.com/haeun0877/MovieInfo/assets/70643208/9dfa3903-b657-4bbe-a767-81f81039a451)
- **adapter** : recycler나 여러 종류에 사용되는 adpater 모음
- **base** : BaseActivity, BaseFragment 등 여러 클래스의 base가 되는 파일
- **di** : 의존성 주입과 관련된 파일 (hilt 사용)
- **remote** : api 호출, 원격에 있는 것들을 가져오는 retrofit 관련 파일
    - api : api 호출 파일
    - local : 내부 DB 사용 파일 (SharePreferences, Room 등이 위치)
    - model : data class 파일
- **repository** : repository 파일
- **utils** : 간편하게 사용할 수 있도록 자주 쓰이는 함수들 모아둔 파일
- **view** : view 관련 파일
    - activity : activity 파일
    - fragment : fragment 파일
- **viewmodel** : viewModel 파일

