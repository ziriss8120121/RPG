package monsters;
import bases.Monster;
import utils.Dice;

// スライムを表現するクラス
public class Slime extends Monster {

    // コンストラクタ
    public Slime(String name, String weapon) {
        super(name, weapon);
        // ヒットポイントの値を乱数で設定（50から80の範囲）
        this.setHp(Dice.get(70, 130));
        // 攻撃力の値を乱数で設定（5から10の範囲）
        this.setOffensive(Dice.get(5, 11));
    }
}
