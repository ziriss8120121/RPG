package humans;
import bases.Human;
import utils.Dice;

// 闘士を表現するクラス
public class Fighter extends Human {

    // コンストラクタ
    public Fighter(String name, String weapon) {
        super(name, weapon);
        // ヒットポイントの値を乱数で設定
        this.setHp(Dice.get(240, 300));
        // 攻撃力の値を乱数で設定
        this.setOffensive(Dice.get(17, 23));
    }
}
