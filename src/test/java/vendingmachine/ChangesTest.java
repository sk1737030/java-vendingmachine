package vendingmachine;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Red(질문) -> Green(대답) -> Refactor(정제)
 */
class ChangesTest {

    @ParameterizedTest
    @CsvSource({"10, _10_COIN", "50, _50_COIN", "100, _100_COIN", "500, _500_COIN"})
    void _n원이_남아_있다면_n원_짜리_동전_1개_를_돌려_준다(int amount, CoinSet coin) {
        Changes changes = new Changes(amount);
        List<CoinSet> coinSet = changes.coin();
        assertThat(coinSet).containsExactlyInAnyOrder(coin);
    }

    @Test
    @DisplayName("1000원이 남아 있다면 500원 동전 2개를 돌려준다")
    void _1() {
        Changes changes = new Changes(1000);
        List<CoinSet> coinSet = changes.coin();
        assertThat(coinSet).containsExactlyInAnyOrder(CoinSet._500_COIN, CoinSet._500_COIN);
    }

    @DisplayName("20원이 남아 있다면 10원 동전 2개를 돌려준다")
    @Test
    void _2() {
        Changes changes = new Changes(20);
        List<CoinSet> coinSet = changes.coin();
        assertThat(coinSet).containsExactlyInAnyOrder(CoinSet._10_COIN, CoinSet._10_COIN);
    }

    @DisplayName("600원이 남아 있다면 500원, 100원 동전 1개 씩 돌려준다")
    @Test
    void _3() {
        Changes changes = new Changes(600);
        List<CoinSet> coinSet = changes.coin();
        assertThat(coinSet).containsExactlyInAnyOrder(CoinSet._500_COIN, CoinSet._100_COIN);
    }

    @DisplayName("650원이 남아 있다면 500원, 100원, 50원 동전 각각 1개 씩 돌려준다")
    @Test
    void _4() {
        Changes changes = new Changes(650);
        List<CoinSet> coinSet = changes.coin();
        assertThat(coinSet).containsExactlyInAnyOrder(CoinSet._500_COIN, CoinSet._100_COIN, CoinSet._50_COIN);
    }

    @DisplayName("동전으로 잔돈을 거슬러 줄 수 없는 경우에도 최소 개수의 동전을 잔돈으로 반환한다")
    @Test
    void _5() {
        Changes changes = new Changes(1);
        List<CoinSet> coinSet = changes.coin();
        assertThat(coinSet).isEmpty();

        changes = new Changes(652);
        coinSet = changes.coin();
        assertThat(coinSet).containsExactlyInAnyOrder(CoinSet._500_COIN, CoinSet._100_COIN, CoinSet._50_COIN);
    }


}
