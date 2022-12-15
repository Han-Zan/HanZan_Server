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
    -- getUser : 사용자에 대한 전반적인 정보를 불러옵니다. 홈 화면, 사진 변경, 닉네임 변경 및 유저별 정보를 조회하기 위한 필수적인 데이터를 제공합니다.
    - 결과를 확인하고 친구에게 공유를 해보세요!

    - 회원가입을 완료하고 당신의 한잔을 만나보세요!


2. 메뉴판을 촬영하여 궁합을 분석할 수 있어요!
    - 메뉴판에 있는 술과 안주를 카메라로 인식하세요

        구글 ML API로 글자를 인식한 후 자체적으로 개발한 자연어 처리 알고리즘으로 DB에 있는 술과 이름을 알아냅니다.

        <p align="start">
          <img width="300" alt="image" src="https://user-images.githubusercontent.com/70252417/207078697-b2f181ed-a44a-49e6-93f0-92fc24494547.png">
          <img width="20">
          <img width="300" alt="image" src="https://user-images.githubusercontent.com/70252417/207078801-69d4f3d0-0ebd-4c3c-8ef0-6cef4c5698bf.png">
        </p>


    - 궁합 분석하기 버튼을 눌러 가장 어울리는 술과 안주의 궁합을 확인해보세요!
        <p align="start">
          <img width="300" alt="%E1%84%89%E1%85%B3%E1%84%8F%E1%85%B3%E1%84%85%E1%85%B5%E1%86%AB%E1%84%89%E1%85%A3%E1%86%BA_2022-12-08_%E1%84%8B%E1%85%A9%E1%84%92%E1%85%AE_5 43 26" src="https://user-images.githubusercontent.com/70252417/207201714-efa95569-400b-4703-be3f-83f7dc3af6d4.png">
        </p>


3. 자신이 먹은 궁합을 평가할 수 있어요!
    - 궁합을 선택하고 다음날 평가해주세요!

         <p align="start">
          <img width="300" alt="image" src ="https://user-images.githubusercontent.com/70252417/207201989-b94457ac-175b-4d5a-bb54-38495ae4aa44.png">
         </p>

    - 해당 데이터는 궁합 분석에 스마트 추천으로 반영됩니다!

        <p align="start">
          <img width="300" alt="image" src ="https://user-images.githubusercontent.com/70252417/207202217-d53950d8-d596-4d3a-a3a1-c125412738c6.png">
         </p>


4. 술과 안주를 둘러보며 자유롭게 궁합을 분석할 수 있어요!
    - 술과 안주 리스트를 둘러볼 수 있어요!
        <p align="start">
          <img width="300" alt="image" src="https://user-images.githubusercontent.com/70252417/207202353-4826a348-b84e-4ad1-8ff9-e45adb51602b.png">
          <img width="20">
          <img width="300" alt="image" src="https://user-images.githubusercontent.com/70252417/207202367-eaa235ef-3d39-4e50-ac42-32bc0d4df31b.png">
        </p>

        <p align="start">
          <img width="300" alt="image" src="https://user-images.githubusercontent.com/70252417/207203147-50252d65-63dd-40cf-8aa6-f3a050b7daba.png">
          <img width="20">
          <img width="300" alt="image" src="https://user-images.githubusercontent.com/70252417/207203153-42539cd4-9a6f-4155-8ba2-e45a38533166.png">
        </p>


    - 술과 안주를 고르고 궁합도를 분석 해보세요!
        <p align="start">
          <img width="300" alt="image" src="https://user-images.githubusercontent.com/70252417/207211135-37ef5b41-3801-4086-96ab-a07885b320e0.png">
          <img width="20">
          <img width="300" alt="image" src="https://user-images.githubusercontent.com/70252417/207211143-ec43c98e-af46-4984-8ca1-eeb34ea0861d.png">
        </p>

5. 즐겨찾기를 하고 찜 해둘 수 있어요!
    - 내가 찜한 조합과 술을 확인하고 관리해보세요!
        <p align="start">
          <img width="300" alt="image" src="https://user-images.githubusercontent.com/70252417/207211261-3677fa33-6ea6-45ef-8d76-0d4fdb3fe708.png">
          <img width="20">
          <img width="300" alt="image" src="https://user-images.githubusercontent.com/70252417/207211274-0a3fad9a-991b-460c-bee2-e299cae5404c.png">
        </p>

6. 내 주변 검색으로 주위의 술집들을 둘러볼 수 있어요!
    - 내 주변 술집을 찾아보고 정보를 확인해 보세요!
        <p align="start">
          <img width="300" alt="image" src="https://user-images.githubusercontent.com/70252417/207211285-9d66887a-ca0a-4eb3-b2d9-f04a8810c511.png">
          <img width="20">
          <img width="300" alt="image" src="https://user-images.githubusercontent.com/70252417/207211298-14f005d7-1fd4-4ddd-8755-0c66d5b5cb59.png">
        </p>

7. 프로필을 꾸며보세요!
    - 원하는 닉네임과 프로필 사진으로 설정해 보세요!
        <p align="start">
          <img width="300" alt="image" src="https://user-images.githubusercontent.com/70252417/207211327-e03d9ee7-994a-4fee-a7da-a8781d1ca712.png">
          <img width="20">
          <img width="300" alt="image" src="https://user-images.githubusercontent.com/70252417/207211370-d3502224-e510-464a-975c-f7753c84f5df.png">
        </p>
