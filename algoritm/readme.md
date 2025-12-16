# 📊 Algorithm & Machine Learning Projects

**Python을 활용한 데이터 분석 및 머신러닝 알고리즘 성능 비교 프로젝트 모음입니다.**
데이터 전처리(Preprocessing), 클래스 불균형 해결(SMOTE), 그리고 다양한 분류 모델의 성능 평가를 수행한 결과물들이 포함되어 있습니다.

---

## 📂 Project List

| No. | Project Name | Topic | Tech Stack | Folder Link |
| :---: | :--- | :--- | :--- | :---: |
| **01** | [**알고리즘 성능 비교 분석**](Algorithm_Performance_Analysis) | 신용 파산 예측 & 모델 비교 | `Python`, `Scikit-learn` | [이동하기](Algorithm_Performance_Analysis) |
| **02** | *(Next Project)* | *(추후 업데이트 예정)* | - | - |

---

## 🚀 Projects Detail

### 1. 알고리즘 성능 비교 분석 (Algorithm Performance Analysis)
> **'Give Me Some Credit' 데이터셋을 활용한 신용 파산 예측 모델링**

이 프로젝트는 금융 데이터의 **클래스 불균형(Class Imbalance)** 문제를 해결하고, 주요 머신러닝 알고리즘의 성능을 비교 분석하여 최적의 모델을 도출하는 과정을 담고 있습니다.

* **Dataset**: Give Me Some Credit (150,000개 샘플, 9개 변수)
* **Problem**: 전체 데이터 중 파산자 비율이 매우 낮은 불균형 문제 존재
* **Solution**: **SMOTE**(Synthetic Minority Over-sampling Technique) 기법을 적용하여 소수 클래스 데이터를 증강

#### 📈 Key Results (성능 비교 결과)
SMOTE 적용 후 3가지 주요 모델의 **AUC(곡선 아래 면적)** 와 **Recall(재현율)** 을 비교한 결과입니다.

| Rank | Model | AUC Score | Recall | 비고 |
| :---: | :--- | :---: | :---: | :--- |
| 🥇 | **MLP (Multi-Layer Perceptron)** | **84.3%** (±0.002) | **0.78** | **최종 선정** |
| 🥈 | Logistic Regression | 80.2% (±0.002) | 0.67 | |
| 🥉 | Random Forest | 79.9% (±0.005) | 0.54 | |

> **결론**: MLP 모델이 AUC와 Recall 모든 지표에서 가장 우수한 성능을 보여 최종 모델로 선정되었습니다.

#### 💻 How to Run
Python 환경에서 아래 절차를 따르십시오.

1. **라이브러리 설치**
    
        pip install pandas scikit-learn imbalanced-learn matplotlib

2. **코드 실행**
   * Jupyter Notebook(`*.ipynb`) 파일인 경우: 모든 셀 실행
   * Python Script(`*.py`) 파일인 경우:

        python main.py

---

## 🛠️ Development Environment

이 폴더 내의 프로젝트들은 주로 아래 환경에서 수행되었습니다.

* **Language**: Python 3.x
* **Core Libraries**:
    * `Scikit-learn`: 모델 학습 및 평가
    * `Pandas`: 데이터 전처리 및 분석
    * `Imbalanced-learn`: SMOTE(오버샘플링) 적용
    * `Matplotlib / Seaborn`: 데이터 시각화

---
**[⬅️ 메인으로 돌아가기](../README.md)**