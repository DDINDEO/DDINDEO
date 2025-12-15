# 알고리즘 성능 비교 분석 (Algorithm Performance Analysis)

## Description
**'Give Me Some Credit'** 데이터셋을 활용하여 개인 신용 파산 여부를 예측하는 머신러닝 모델 성능 비교 프로젝트.

데이터의 클래스 불균형 문제를 해결하기 위해 **SMOTE(Synthetic Minority Over-sampling Technique)** 기법을 적용하였으며, 주요 알고리즘 3가지를 비교 분석하여 최적의 모델을 선정.

* **Dataset:** Give Me Some Credit (150,000개 샘플, 9개 변수)
* **Problem:** Class Imbalance, Binary Classification
* **Solution:** SMOTE Oversampling

### 성능 비교 그래프(AUC)
<img width="1087" height="539" alt="image" src="https://github.com/user-attachments/assets/7693b898-7d21-4e25-b51e-832aa7650954" />
<br>

### 성능 비교 그래프(Classification report)
<img width="350" height="143" alt="image" src="https://github.com/user-attachments/assets/212f6d7b-b167-48b8-b479-0dfdd22a9d43" />
<img width="344" height="141" alt="image" src="https://github.com/user-attachments/assets/8fd29c75-a122-45a0-bcc9-698271663ce6" />
<img width="340" height="139" alt="image" src="https://github.com/user-attachments/assets/97d1d7a3-3d9a-4213-99c9-7a9e8097388d" />


<br>

## Key Results
SMOTE 적용 후 각 모델별 **AUC 점수**와 **Recall(재현율)** 비교 결과, **MLP (Multi-Layer Perceptron)** 모델이 가장 우수한 성능을 보임.

| Rank | Model | AUC Score (Std) | Recall |
| :---: | :--- | :--- | :--- |
| **1** | **MLP** | **84.3%** (±0.002) | **0.78** |
| 2 | Logistic Regression | 80.2% (±0.002) | 0.67 |
| 3 | Random Forest | 79.9% (±0.005) | 0.54 |

 **분석 결론:** MLP 모델이 AUC와 Recall 모든 지표에서 가장 높은 성능을 기록하여 최종 모델로 선정함.

## Tech Stack
* **Language:** Python 3.x
* **Libraries:**
    * `Scikit-learn`: 모델 학습 및 평가
    * `Pandas`: 데이터 전처리 및 분석
    * `Imbalanced-learn`: SMOTE 적용

## How to Run
이 프로젝트는 Google Colab 환경에서 작성되었습니다.

1. 저장소를 클론(Clone)합니다.
   ```bash
   git clone [algoritm/algorithm project/notebooks/모델비교.ipynb]

2. 데이터셋을 넣은후에 실행
