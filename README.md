# DDINDEO's Project Archive

**개발 프로젝트 모음입니다.**
이 저장소는 학부 과정 및 개인적으로 진행한 프로젝트들을 정리해둔 공간입니다.

---

## 📂 Projects Overview

| No. | Project Name | Category | Description | Tech Stack | Status |
| :---: | :--- | :---: | :--- | :--- | :---: |
| **01** | [**LCK 경기 일정 관리 시스템**](java/LCKscheduleApp) | 🖥️ App | LCK 팬들을 위한 일정 조회 및 소통 앱 | `Java`, `MySQL` |  Done |
| **02** | [**알고리즘 성능 비교 분석**](python/Algorithm_Performance_Analysis) | 📊 AI/ML | 신용 파산 예측 모델 성능 비교 (SMOTE) | `Python`, `Sklearn` |  Done |
| **03** | [**cafeManager**](python/cafeManager) | 🖥️ App | 카페 주문 및 재고/매출 통합 관리 시스템 | `Python`, `MySQL` | in progress |

---

## 🚀 Featured Projects

### 1. LCK 경기 일정 조회 및 관리 시스템 (LCK App)
> **LoL Champions Korea 팬들을 위한 일정 조회 및 소통 플랫폼** 

* **개발 기간**: 2025년 5월 ~ 7월
* **주요 내용**:
    * **User**: 경기 일정 리스트 확인, 상세 정보 조회, 응원 댓글 작성 기능
    * **Admin**: 경기 정보 데이터(DB) 수정 및 업데이트, 악성 댓글 관리 패널 제공
    * `Java Swing`을 활용한 GUI 구성 및 `MySQL` 연동
* **바로가기**: [👉 LCK 프로젝트 폴더로 이동](java/LCKscheduleApp)

<br>

### 2. 알고리즘 성능 비교 분석 (Algorithm Performance Analysis)
> **'Give Me Some Credit' 데이터셋을 활용한 개인 신용 파산 여부 예측 및 모델 비교**

* **프로젝트 개요**:
    * **Dataset**: Give Me Some Credit (150,000 samples, 9 features)
    * **Problem**: 클래스 불균형(Class Imbalance)이 존재하는 이진 분류 문제
    * **Solution**: **SMOTE**(Synthetic Minority Over-sampling Technique) 기법을 적용하여 데이터 불균형 해소 후 주요 알고리즘 성능 비교
* **주요 성과 (Key Results)**:
    * SMOTE 적용 후 3가지 모델(MLP, Logistic Regression, Random Forest)의 **AUC**와 **Recall** 비교
    * **최종 결과**: **MLP 모델**이 모든 지표에서 가장 우수한 성능을 보여 최종 모델로 선정

| Rank | Model | AUC Score | Recall |
| :---: | :--- | :---: | :---: |
| 🥇 | **MLP (Multi-Layer Perceptron)** | **84.3%** (±0.002) | **0.78** |
| 🥈 | Logistic Regression | 80.2% (±0.002) | 0.67 |
| 🥉 | Random Forest | 79.9% (±0.005) | 0.54 |

* **Tech Stack**:
    * **Language**: Python 3.x
    * **Libraries**: `Scikit-learn` (모델링), `Pandas` (전처리), `Imbalanced-learn` (SMOTE)
* **바로가기**: [👉 알고리즘 프로젝트 폴더로 이동](python/Algorithm_Performance_Analysis) 

<br>

### 3. 카페 주문 및 재고/매출 통합 관리 시스템 (cafeManager)
> **데이터 기반의 카페 주문 및 재고/매출 통합 관리 시스템**

* **개발 기간**: 2025년 12월 17일 ~ 진행중
* **주요 내용**:
    * **User**: 상품 주문, 실시간 재고 연동, 주문 데이터 생성
    * **Admin**: 신규 메뉴 등록, 가격 수정, 재고 입고, 매출 리포팅
    *  `python`과 `MySQL` 연동
* **바로가기**: [👉 cafeManager 폴더로 이동](python/cafeManager)

---

## 🛠️ Skills & Tools

### Languages
![Java](https://img.shields.io/badge/Java-007396?style=flat-square&logo=java&logoColor=white)
![Python](https://img.shields.io/badge/Python-3776AB?style=flat-square&logo=python&logoColor=white)

---

## 👤 Developer Info
* **Name**: 김진서 (Jinseo Kim)

---
Copyright © 2025 Jinseo Kim. All rights reserved.
