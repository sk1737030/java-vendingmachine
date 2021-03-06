package vendingmachine;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CoinSetTest {

    static List<Arguments> coinSet() {
        return Arrays.asList(
                Arguments.of(500, CoinSet._500_COIN),
                Arguments.of(100, CoinSet._100_COIN),
                Arguments.of(10, CoinSet._10_COIN),
                Arguments.of(50, CoinSet._50_COIN)
        );
    }

    @Test
    void 동전을_생성한다() {
        CoinSet coin = CoinSet._100_COIN;
        assertThat(coin.value).isEqualTo(100);
    }

    @Test
    void 동전() {
        CoinSet coin = CoinSet.valueOf(10);
        assertThat(coin).isEqualTo(CoinSet._10_COIN);
    }

    @Test
    void 전체_동전은_금액이_작은_순서대로_반환된다() {
        assertThat(CoinSet.highestOrder())
                .containsExactlyInAnyOrder(CoinSet._10_COIN, CoinSet._100_COIN, CoinSet._50_COIN, CoinSet._500_COIN);
    }

    @ParameterizedTest(name = "동전은_{0}원_{0}원_{0}원_{0}이_있다")
    @MethodSource("coinSet")
    void 동전은_500원_100원_50원_10원이_있다(int value, CoinSet coin) {
        assertThat(coin.value).isEqualTo(value);
    }

}