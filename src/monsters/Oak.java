package monsters;
import bases.Monster;
import utils.Dice;

// オークを表現するクラス
public class Oak extends Monster {

    // コンストラクタ
    public Oak(String name, String weapon) {
        super(name, weapon);
        // ヒットポイントの値を乱数で設定（100から150の範囲）
        this.setHp(Dice.get(170, 230));
        // 攻撃力の値を乱数で設定（10から20の範囲）
        this.setOffensive(Dice.get(9, 15));
    }
}
