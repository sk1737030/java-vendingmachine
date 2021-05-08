package vendingmachine;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalStateException;

/**
 * Red(질문) -> Green(응답) -> Refactor(정제)
 */


class ChangesModuleTest {

    @Test
    void 자판기_생성() {
        ChangesModule vendingMachine = new ChangesModule();
        assertThat(vendingMachine).isNotNull();
    }

    @ParameterizedTest(name = "자판기에 {0}원을 넣으면 {0}원이 들어있음을 알 수 있다")
    @ValueSource(ints = {500, 1000})
    void 자판기에_n원을_넣으면_n원이_들어있음을_알_수있다(int changes) {
        ChangesModule changesModule = new ChangesModule();
        changesModule.put(changes);
        assertThat(changesModule.getChanges()).isEqualTo(changes);
    }

    @Test
    void _1000원이_들어가있는_자판기에_500원_넣으면_1500원이_들어있음을_알_수_있다() {
        ChangesModule changesModule = new ChangesModule(1000);
        changesModule.put(500);
        assertThat(changesModule.getChanges()).isEqualTo(1500);
    }

    @Test
    void _500원이_들어있는_자판기에_500원을_차감하면_0원이_된다() {
        ChangesModule changesModule = new ChangesModule(500);
        changesModule.withdraw(500);
        assertThat(changesModule.getChanges()).isEqualTo(0);
    }

    @Test
    void _0원이_들어있는_자판기에_500원을_차감_할_수_없다() {
        ChangesModule changesModule = new ChangesModule(0);
        assertThatIllegalStateException()
                .isThrownBy(() -> changesModule.withdraw(500));
    }

    @Test
    void 최소_구입_금액_미만인_경우_잔돈이_반환된다() {
        ChangesModule changesModule = new ChangesModule(0);
        assertThatIllegalStateException()
                .isThrownBy(() -> changesModule.withdraw(500));
    }

    @Test
    void 최소_개수의_동전으로_잔돈을_돌려준다() {

    }
}