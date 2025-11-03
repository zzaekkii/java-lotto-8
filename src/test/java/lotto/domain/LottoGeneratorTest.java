package lotto.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class LottoGeneratorTest {

    @Test
    void 구매_금액만큼_로또_생성() {
        List<Lotto> lottos = LottoGenerator.purchase(5000);
        assertThat(lottos.size()).isEqualTo(5);
    }

    @Test
    void 각_로또는_6개_번호로_구성() {
        Lotto lotto = LottoGenerator.purchase(1000).getFirst();
        assertThat(lotto.getNumbers().size()).isEqualTo(6);
    }

    @Test
    void 로또_번호_오름차순_정렬() {
        Lotto lotto = LottoGenerator.purchase(1000).getFirst();
        assertThat(lotto.getNumbers()).isSorted();
    }

    @Test
    void 로또_번호는_1에서_45_사이() {
        Lotto lotto = LottoGenerator.purchase(1000).getFirst();
        assertThat(lotto.getNumbers())
            .allMatch(x -> x >= 1 && x <=45);
    }
}