package vendingmachine;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;


class CoinTest {
    @Test
    void 동전을_생성한다() {
        Coin coin = new Coin(100);
        assertThat(coin).isNotNull();
    }

    @ParameterizedTest(name = "동전은_{1}원_{2}원_{3}원_{4}이_있다")
    @ValueSource(ints = {Coin._500, Coin._100, Coin._50, Coin._10})
    void 동전은_500원_100원_50원_10원이_있다(int value) {
        Coin coin = new Coin(value);
        assertThat(coin).isEqualTo(new Coin(value));

    }

    @ParameterizedTest
    @ValueSource(ints = {499, 9, 11, 999})
    void 존재하지_않는_동전을_정의한다(int value) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Coin(value));

    }
}