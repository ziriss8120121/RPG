package humans;
import bases.Human;
import utils.Dice;

// 魔法使いを表現するクラス
public class Wizard extends Human {

    // コンストラクタ
    public Wizard(String name, String weapon) {
        super(name, weapon);
        // ヒットポイントの値を乱数で設定
        this.setHp(Dice.get(120, 180));
        // 攻撃力の値を乱数で設定
        this.setOffensive(Dice.get(12, 18));
    }
}
