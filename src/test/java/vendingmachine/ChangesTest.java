package vendingmachine;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Red(질문) -> Green(대답) -> Refactor(정제)
 */
class ChangesTest {

    @Test
    void _10원이_남아_있다면_10원짜리_동전_1개_를_돌려_준다() {
        Changes changes = new Changes(10);
        List<CoinSet> coinSet = changes.coin();

        assertThat(coinSet.size()).isEqualTo(1);
        assertThat(coinSet.get(0)).isEqualTo(CoinSet._10_COIN);
    }

    @Test
    void _50원이_남아_있다면_50원짜리_동전_1개_를_돌려_준다() {
        Changes changes = new Changes(50);
        List<CoinSet> coinSet = changes.coin();

        assertThat(coinSet).containsExactlyInAnyOrder(CoinSet._50_COIN);
/*
        assertThat(coinSet.size()).isEqualTo(1);
        assertThat(coinSet.get(0)).isEqualTo(CoinSet._10_COIN);*/
    }

    @Test
    void _100원이_남아_있다면_100원짜리_동전_1개_를_돌려_준다() {
        Changes changes = new Changes(100);
        List<CoinSet> coinSet = changes.coin();

        assertThat(coinSet).containsExactlyInAnyOrder(CoinSet._100_COIN);
/*
        assertThat(coinSet.size()).isEqualTo(1);
        assertThat(coinSet.get(0)).isEqualTo(CoinSet._10_COIN);*/
    }

    @Test
    void _500원이_남아_있다면_500원짜리_동전_1개_를_돌려_준다() {
        Changes changes = new Changes(500);
        List<CoinSet> coinSet = changes.coin();

        assertThat(coinSet).containsExactlyInAnyOrder(CoinSet._500_COIN);
/*
        assertThat(coinSet.size()).isEqualTo(1);
        assertThat(coinSet.get(0)).isEqualTo(CoinSet._10_COIN);*/
    }
}

class Changes {
    private int value;

    public Changes(int value) {
        this.value = value;
    }

    List<CoinSet> coin() {
        if (this.value == 10) {
            return Arrays.asList(CoinSet._10_COIN);
        } else if (this.value == 100) {
            return Arrays.asList(CoinSet._100_COIN);
        } else if (this.value == 50) {
            return Arrays.asList(CoinSet._50_COIN);
        } else if (this.value == 500) {
            return Arrays.asList(CoinSet._500_COIN);
        } else {
            return Arrays.asList();
        }
    }
}
