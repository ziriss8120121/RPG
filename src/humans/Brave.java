package humans;
import bases.Human;
import utils.Dice;

// 勇敢な戦士を表現するクラス
public class Brave extends Human {

    // コンストラクタ
    public Brave(String name, String weapon) {
        super(name, weapon);
        // ヒットポイントの値を乱数で設定
        this.setHp(Dice.get(170, 230));
        // 攻撃力の値を乱数で設定（10から20の範囲）
        this.setOffensive(Dice.get(7, 13));
    }
}
