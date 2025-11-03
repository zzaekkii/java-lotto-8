package lotto.domain;

public enum Rank {
    FIRST(6, 2_000_000_000, false),
    SECOND(5, 30_000_000, true),
    THIRD(5, 1_500_000, false),
    FOURTH(4, 50_000,  false),
    FIFTH(3, 5_000, false),
    MISS(0, 0, false);

    private final int matchCount;
    private final int reward;
    private final boolean bonusMatch;

    Rank(int matchCount, int reward, boolean bonusMatch) {
        this.matchCount = matchCount;
        this.reward = reward;
        this.bonusMatch = bonusMatch;
    }

    public int getMatchCount() {
        return matchCount;
    }

    public int getReward() {
        return reward;
    }

    public static Rank valueOf(int matchCount, boolean bonusMatch) {
        for (Rank rank : values()) {
            if (rank.isSame(matchCount, bonusMatch)) {
                return rank;
            }
        }
        return MISS;
    }

    private boolean isSame(int matchCount, boolean bonusMatch) {
        if (this == MISS) return false;
        if (this.matchCount != matchCount) return false;
        if (!this.bonusMatch) return true;

        return bonusMatch;
    }
}
