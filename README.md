# 🍸 한잔

![Thumbnail](https://user-images.githubusercontent.com/70252417/207075561-af129ca9-fc0f-4256-9395-7c0fd92c683f.png)

---

## 😊 Project

**캡스톤 디자인 프로젝트에서 한 학기 동안 진행한 프로젝트**로 2022.9.1 부터 2022.12.9까지 진행하였습니다.

- Spring Boot | 2.7.7
- MariaDB | 10.6.10
- Java Version 1.7.10

---

## 👻 Stack

| Component | Content |
| --- | --- |
| Architecture | Layered Architecture |
| Dependency | Swagger, Lombok, Hibernate, Security, Jpa |
---

## 📃 Description

해당 ReadMe는 모든 API 리스트들을 열거합니다.
- AWS MariaDB를 이용하였으며 EC2 컴퓨팅을 이용하여 리눅스 서버에 배포를 완료하였습니다.

1. UserController
    - 사용자에 관한 정보를 관리를 하는 API 입니다.

        <p align="start">
          <img width="900" alt="image" src="https://user-images.githubusercontent.com/20681491/207852470-9d178977-b1c4-4286-9c9d-88cc27892845.png">
        </p>

- GET Method
    - getUser : 사용자에 대한 전반적인 정보를 불러옵니다. 홈 화면, 사진 변경, 닉네임 변경 및 유저별 정보를 조회하기 위한 필수적인 데이터를 제공합니다.
- POST Method
    - postUserInfo : 사용자에 대한 정보를 기입합니다. 회원 가입 시 사용이 되며, 데이터베이스에 유저에 대한 정보를 기입합니다.
- DELETE Mehhod
    - deleteUser : 사용자의 회원 탈퇴 시 사용이 되는 API입니다.
- PUT Method
    - changeUserNickName : 사용자의 이름을 변경할 때 사용되는 API입니다.
    - changeUserProfile : 사용자의 프로필 사진을 변경할 때 사용이 되는 API입니다.
    - changeUserSBTI : 사용자의 술BTI를 바꿀 때 사용이 되는 API입니다.
    - (임시) insertfood : 사용자가 먹었던 음식에 대해서 저장합니다. (미사용)

2. 메뉴판을 촬영하여 궁합을 분석할 수 있어요!
    - 메뉴판에 있는 술과 안주를 카메라로 인식하세요

        구글 ML API로 글자를 인식한 후 자체적으로 개발한 자연어 처리 알고리즘으로 DB에 있는 술과 이름을 알아냅니다.



    - 궁합 분석하기 버튼을 눌러 가장 어울리는 술과 안주의 궁합을 확인해보세요!



3. 자신이 먹은 궁합을 평가할 수 있어요!
    - 궁합을 선택하고 다음날 평가해주세요!


    - 해당 데이터는 궁합 분석에 스마트 추천으로 반영됩니다!



4. 술과 안주를 둘러보며 자유롭게 궁합을 분석할 수 있어요!
    - 술과 안주 리스트를 둘러볼 수 있어요!



    - 술과 안주를 고르고 궁합도를 분석 해보세요!


5. 즐겨찾기를 하고 찜 해둘 수 있어요!
    - 내가 찜한 조합과 술을 확인하고 관리해보세요!


6. 내 주변 검색으로 주위의 술집들을 둘러볼 수 있어요!
    - 내 주변 술집을 찾아보고 정보를 확인해 보세요!

7. 프로필을 꾸며보세요!
    - 원하는 닉네임과 프로필 사진으로 설정해 보세요!
