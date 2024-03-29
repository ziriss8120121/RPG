package monsters;
import bases.Monster;
import utils.Dice;

// ドラゴンを表現するクラス
public class Dragon extends Monster {

    // コンストラクタ
    public Dragon(String name, String weapon) {
        super(name, weapon);
        // ヒットポイントの値を乱数で設定
        this.setHp(Dice.get(270, 330));
        // 攻撃力の値を乱数で設定
        this.setOffensive(Dice.get(12, 18));
    }
}
