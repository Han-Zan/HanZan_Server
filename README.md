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

### 1. UserController

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

### 2. ProductController

- 주류 품목에 관한 정보를 관리합니다.

<p align="start">
          <img width="900" alt="image" src="https://user-images.githubusercontent.com/20681491/207852470-9d178977-b1c4-4286-9c9d-88cc27892845.png">
        </p>

- GET Method
    - getProduct : 한 개의 특정 주류에 대한 정보를 가져오는 API입니다. 술의 상세 정보 화면에서 사용됩니다.
    - getProductAll : 모든 주류에 대한 정보를 가져오는 API입니다. 술 선택 화면에서 모든 술을 가져올 때 사용됩니다.
    - getProductSelection : 카테고리에 따른 주류를 가져오는 API입니다. (미사용)

- POST Method
    - postProduct : 주류에 대한 정보를 기입할 때 사용이 됩니다. 데이터를 주로 관리할 때 사용이 되었으며, 만약 추후 관리자가 술에 대한 정보를 넣어야 할 시 사용이 될 예정입니다.

- DELETE Method
    - deleteProductName : 주류에 대한 정보를 삭제할 때 사용됩니다. 데이터 관리 시 사용이 되었으며, 추후 관리자가 술에 대한 정보를 삭제해야 할 경우 사용이 될 예정입니다.

- PUT Method
    - changeProductName : 술에 대한 이름을 바꿀 때 사용이 됩니다. 현재는 이름을 바꾸는 것으로 되어있으나, 추후 술에 대한 라벨이 바뀌는 경우 이를 관리할 수 있게 사진으로 바꿀 예정입니다.

### 3. FoodController
        
- 안주에 대한 정보를 관리합니다.

<p align="start">
          <img width="900" alt="image" src="https://user-images.githubusercontent.com/20681491/207852474-36d79ef0-a3c1-4cc2-9aeb-6f26182e001b.png">

- GET Method
    - getFood : 한 음식에 대한 상세정보를 가져오는 API입니다. 단일 데이터에 대한 체크와 오류에 대한 확인 용도로 사용하는 API입니다.
    - getAllFood : 모든 음식에 대한 정보를 가져오는 API입니다. 안주에 대한 선택을 하는 화면에서 사용이 됩니다.
    - getFoodByName : 이름에 따라서 안주를 가져올 수 있는 API입니다.
    
- POST Method
    - saveFood : 음식에 대한 데이터를 저장할 때 사용되었던 API입니다. 데이터에 대한 관리를 위해서 사용이 되었습니다.
   
- PUT Method
    - insertProduct : 특정 음식에 대해서 어울리는 주류 품목을 넣을 때 사용되었던 API입니다. 음식에 대한 궁합도를 측정할 때 밑바탕이 될 데이터를 구성할 때 사용되었습니다.


### 4. PreferredController

- 주류 품목의 좋아요 정보를 관리합니다.
          
<p align="start">
          <img width="900" alt="image" src="https://user-images.githubusercontent.com/20681491/207852460-0424f0ff-72d0-4f31-a984-2497136ee74b.png">

- GET Method
    - getProduct : 사용자가 좋아요를 누른 주류 품목에 대한 정보를 모두 가져오는 API입니다. 좋아요 화면에서 사용이 되었습니다.
          
- POST Method
    - saveProduct : 사용자가 좋아요를 할 때 이에 대한 정보를 저장하는 API입니다. 좋아요의 버튼에서 사용이 되었습니다.
          
- DELETE Method
    - deleteProductName : 사용자가 좋아요를 한 품목에 관하여 취소하는 API입니다. 이미 좋아요가 되어있는 경우 그 버튼을 눌렀을 시 불립니다.

### 5. CombinationController

- 조합에 관한 정보를 관리합니다.
          
<p align="start">
          <img width="900" alt="image" src="https://user-images.githubusercontent.com/20681491/207852466-418e8eb4-fde4-4661-8845-a6558f369b15.png">

- GET Method
    - getCombination : 하나의 조합에 관한 정보를 가져오는 API입니다. 궁합에 대한 점수 반환 및 궁합에 대한 데이터 관리에서 사용이 되었습니다.
    - listall : 모든 궁합에 관한 정보를 불러오는 API입니다. 궁합을 모두 보여주는 화면에 관하여 사용이 되었습니다.

- POST Method
    - saveCombination : 조합에 대한 정보를 저장하는 API입니다. 궁합에 대한 주요 적인 데이터 관리에서 사용되었습니다.
          

### 6. PreferredCombController

- 조합의 좋아요 정보를 관리합니다.
          
<p align="start">
          <img width="900" alt="image" src="https://user-images.githubusercontent.com/20681491/207852457-d90ad707-d6fd-46dc-9d46-750c7e79c2a1.png"> 
          
- GET Method
    - getPreferred : 사용자에 대한 모든 좋아요를 가져오는 API입니다. 사용자의 좋아요를 보는데 사용이 되었습니다.

- POST Method
    - savePref : 사용자가 좋아요를 누를 시 사용되는 API입니다.
          
- DELETE
    - deletepref : 이미 좋아요가 되어있는 좋아요에서 다시 눌렀을 시 취소가 되게끔 하는 API입니다.  
          
### 7. StoreController

- 가게 정보를 관리합니다.
          
<p align="start">
          <img width="900" alt="image" src="https://user-images.githubusercontent.com/20681491/207852455-b37a4bfa-9894-49e7-ae12-e5574c039d50.png"> 
          
- GET Method
    - getStores : 가게에 대한 상세정보를 가져올 때 사용되는 API입니다. 카카오톡에서 존재하는 데이터로 이미 존재하는 술집이 있을 시, 추가 생성없이 접근이 가능합니다.
          
- POST Method
    - insertStores : 가게에 대한 정보를 최초로 접근할 시 사용되는 API입니다. 카카오톡에 존재하는 데이터로 생성을 합니다.
          
- PUT Method
    - updateCombination : 가게에 대한 추천 궁합을 넣을 때 사용이 되는 API입니다.
    - updateImgLink : 가게에 대한 메뉴판을 넣을 때 사용이 되는 API입니다. 메뉴판 업로드 시 사용이 됩니다.
          
### 8. SignController

<p align="start">
          <img width="900" alt="image" src="https://user-images.githubusercontent.com/20681491/207852453-ea006d1d-6140-40c1-8d98-5bd71b581c7d.png">  

- POST Method
    - Signin : 정보에 대한 기입을 마쳤을 때 회원가입을 완료하게 하는 API입니다. 기본적인 회원 가입을 할 때 사용이 됩니다.
    - NickNameCheck : 만약 중복되는 이름이 존재하는 경우 이를 막아주는 API입니다. 닉네임에 대한 중복 검사가 이루어집니다.
    - SignCheck : 카카오에서 제공되는 유저의 고유 ID에 관하여 조사하며 만약 존재한다면, 즉시 로그인을 하고 없다면 즉시 회원가입 페이지로 넘어가게 하는 API입니다.
          
- 모든 sign의 경우에서는 JWT 토큰이 사용이 됩니다. 해당 JWT 토큰을 이용하여, 다른 API를 사용할 수 있도록 만들어 내었습니다
          
### 8. CamController

- 메뉴판 촬영 과정을 관리합니다.

<p align="start">
          <img width="900" alt="image" src="https://user-images.githubusercontent.com/20681491/207852452-27f3a551-d971-44bd-bc11-49c1027b938c.png">  

- POST Method
    - camPost , camPostD, camPostF : 문자열로 사진을 찍었을 시 출력되는 모든 데이터를 인자로 받아 Flask 서버에서 DB에 존재하는 아이템의 이름과 유사도 검사를 한 뒤 이에 맞는 이름들을 출력해주는 API입니다 .
    - 메뉴판 촬영 시 활용이 되었습니다.
          
### 9.Rating Controller
          
- 별점 정보를 관리합니다.
          
<p align="start">
          <img width="900" alt="image" src="https://user-images.githubusercontent.com/20681491/207852448-774e783d-5806-4426-9404-e399aa506c61.png"> 

- GET Method
    - getRating : 특정 Item에 관하여 사용자가 매긴 별점을 가져올 수 있습니다.
    - getUserRating : 특정 사용자가 매긴 모든 별점의 리스트를 가져오는 API입니다.
    
    2개의 API의 경우 추후 사용자가 데이터를 관리할 수 있을 때, 사용이 될 예정입니다.
    
- POST Method
    - insertRating : 사용자로 하여금 별점을 매길 수 있게 끔 만든 API입니다. 궁합에 관한 별점을 매길 때 사용이 됩니다.
          
- DELETE Method
    - deleteRating : 추후 사용자가 자신의 별점에 관해서 관리를 할 수 있게 된다면, 이를 삭제할 수 있게 만들게 하는 API입니다.
          
### 10. RecommandController
          
- 사용자에게 궁합도를 계산하여 추천할 수 있는 함수를 포함하는 API입니다.
          
<p align="start">
          <img width="900" alt="image" src="https://user-images.githubusercontent.com/20681491/207852445-87a390d7-04a7-4d71-b6de-7eb9e66e9c25.png"> 
          
- GET Method
    - recommandation : 메뉴판을 찍어서가 아니라 따로 메뉴에 대한 탐색을 통해서, 직접 궁합을 매길 수 있도록 하는 API입니다.
          
- POST Method
    - recommandations : 메뉴판을 찍은 뒤, 처리된 문자열을 기반으로 하여 각 메뉴에 대한 궁합도를 측정하는데 사용되는 API입니다.
          
- 궁합도는 일반적으로 같은 주종끼리는 같은 음식이 잘 어울리는 것과, 탄산감이 있을 시 같은 탄산감이 있는 제품들과 어울리는 안주와 어울리는 것과 뿐더러 알코올의 경우 같은 당도 탄산이라 할 지라도 다르게 느껴지게 할 수 있기 때문에 다음과 같은 통념을 기반으로 하여 목적 함수를 구현하였다.
    s = sour / b = bitter / sw = sweet / sp = sparkle / alc = alcohol
          
<p align="start">
          <img width="900" alt="image" src="https://user-images.githubusercontent.com/20681491/207853204-7e622251-1821-48cb-a16d-bace8c774074.PNG"> 
          
- 해당 목적함수를 기반으로 하여 최종적인 궁합의 측정 방식은 다음과 같다.
          
<p align="start">
          <img width="900" alt="image" src="https://user-images.githubusercontent.com/20681491/207853205-61b15826-7b50-4793-b46d-b5d41c2a2e69.PNG">
          
- 추가로 사용자에 대한 좋아요의 데이터를 반영하기 위해서 다음과 같은 수식을 추가하여 최종적인 궁합의 Score을 만들어 내었다.
          
<p align="start">
          <img width="900" alt="image" src="https://user-images.githubusercontent.com/20681491/207853206-6ec84366-f558-4491-8892-ee18a897b046.PNG">
          
- C_pnum의 경우 궁합에 관해 사람들이 좋아한 횟수를 의미하며, Total_pnum의 경우 모든 사람들이 좋아요를 누른 횟수를 의미한다.

### 11. HomeController
- 홈화면 정보 조회 과정을 관리합니다.

<p align="start">
          <img width="900" alt="image" src="https://user-images.githubusercontent.com/20681491/207852439-4e1d4697-b5a7-4bb1-8e28-eae00394c4e7.png">
          
- GET Method
    - GetAll : 유저에 대한 정보와 뿐더러, 홈화면에서 등장하는 궁합 순위를 반환해주는 API입니다. 여기서 Repository를 이용하여 Top3를 뽑아내었습니다.
