# 알고리즘 성능 비교 분석 (Algorithm Performance Analysis)

## Description
**'Give Me Some Credit'** 데이터셋을 활용하여 개인 신용 파산 여부를 예측하는 머신러닝 모델 성능 비교 프로젝트.

데이터의 클래스 불균형 문제를 해결하기 위해 **SMOTE(Synthetic Minority Over-sampling Technique)** 기법을 적용하였으며, 주요 알고리즘 3가지를 비교 분석하여 최적의 모델을 선정하였습니다.

* **Dataset:** Give Me Some Credit (Kaggle)
* **Problem:** Class Imbalance, Binary Classification
* **Solution:** SMOTE Oversampling

## Key Results
SMOTE 적용 후 각 모델별 **AUC 점수**와 **Recall(재현율)** 비교 결과, **MLP (Multi-Layer Perceptron)** 모델이 가장 우수한 성능을 보였습니다.

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
   git clone [레포지토리 주소]