# 자동판매기 잔돈 계산 모듈

그저 반환되는 동전이 최소한이 되는 자판기 잔돈 계산 모듈을 구현해서 제공하면 충분하다.

- 최소 개수의 동전으로 잔돈을 돌려준다.

  예) 1000원 넣고 650원짜리 음료를 선택했다면, 잔돈은 100, 100, 100, 50원으로 반환한다.

- 지폐를 잔돈으로 반환하는 경우는 없다고 가정한다.

--- 

### 기능 요구 사항

- [X] 잔돈 모듈에 동전을 넣으면 얼마가 들었는지 알 수 있다.
- [X] 잔돈 모듈에 든 금액을 차감할 수 있다.
- [X] VendingMachine 의 ChangesModule로 변경한다.
- [X] 동전은 500원, 100원, 50원, 10원이 있다.
- [ ] 최소 개수의 동전으로 잔돈을 돌려준다.
- [ ] 최소 구입 금액 미만인 경우 잔돈이 반환된다.
- [ ] 반환 요청을 하는 경우 잔돈이 반환된다.



---

- ChangesModule
- ChangesModule#pop()
    - ChangesModule#withDraw(Money)
- Coin(500원, 100원, 50원, 10원)
- Change