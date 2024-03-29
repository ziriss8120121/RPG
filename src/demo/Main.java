package demo;

import java.util.ArrayList;
import java.util.List;

import bases.Human;
import bases.Monster;
import humans.Brave;
import humans.Fighter;
import humans.Wizard;
import monsters.Dragon;
import monsters.Oak;
import monsters.Slime;
import utils.Dice;

public class Main {
    public static void main(String[] args) {

        System.out.println("★★ ==== 戦いの開始だ！！ ==== ★★");

        // Brave（勇者）, Fighter（戦士）, Wizard（魔法使い）クラスの各インスタンスを生成
        Brave brave = new Brave("沖田総司", "剣");
        Fighter fighter = new Fighter("金太郎", "斧");
        Wizard wizard = new Wizard("安倍晴明", "魔法");

        // 人間グループのリストを空で生成
        List<Human> humans = new ArrayList<>();
        
        // 勇者、戦士、魔法使いを人間グループのリストに追加
        humans.add(brave);
        humans.add(fighter);
        humans.add(wizard);

        // Slime（スライム）, Oak（オーク）, Dragon（ドラゴン）クラスの各インスタンスを生成
        Slime slime = new Slime("キングスライム", "体当たり");
        Oak oak = new Oak("オークキング", "槍");
        Dragon dragon = new Dragon("紅龍", "炎");

        // モンスターグループのリストを空で生成
        List<Monster> monsters = new ArrayList<>();
		
        // スライム、オーク、ドラゴンをモンスターグループのリストに追加
        monsters.add(slime);
        monsters.add(oak);
        monsters.add(dragon);

        // 現在の各グループの状態を一覧表示
        showGroupInfos(humans, monsters);

        // 第何回戦かを示すカウンター変数
        int count = 1;
		
        // 勝敗がつくまで無限ループ
        while (true) {

            System.out.printf("\n★ 第%d回戦 ==========\n", count);

            System.out.println("\n[人間のターン！]\n");

            // 人間グループから1人選択
            Human chosenHuman = choiceHuman(humans);
			
            // モンスターグループから1人選択
            Monster chosenMonster = choiceMonster(monsters);
            
            // 選ばれた人間が、選ばれたモンスターを攻撃
            chosenHuman.attack(chosenMonster);

            // モンスターのHPが0以下になれば、モンスターは倒れ、そのモンスターをモンスターグループから削除
            if (chosenMonster.getHp() <= 0) {
                monsters.remove(chosenMonster);
                if (monsters.isEmpty()) {
                    System.out.println("モンスターグループに誰もいなくなりました。人間グループの勝利！");
                    break;
                }
            }

            System.out.println("\n[モンスターのターン！]\n");
			
            // 人間グループから1人選択
            chosenHuman = choiceHuman(humans);
			
            // モンスターグループから1人選択
            chosenMonster = choiceMonster(monsters);
			
            // 選ばれたモンスターが、選ばれた人間を攻撃
            chosenMonster.attack(chosenHuman);

            // 人間のHPが0以下になれば、人間は倒れ、その人間をモンスターグループから削除
            if (chosenHuman.getHp() <= 0) {
                humans.remove(chosenHuman);
                if (humans.isEmpty()) {
                    System.out.println("人間グループに誰もいなくなりました。モンスターグループの勝利！");
                    break;
                }
            }

            // 現在の各グループの状態を一覧表示
            showGroupInfos(humans, monsters);
			
            // ループ変数を1増やす
            count++;
        }

        // 最後に各グループの状態を一覧表示してプログラム終了
        showGroupInfos(humans, monsters);
    }

    // 引数でもらった人間グループリストからランダムに1人を選択し、その結果を戻り値とするメソッド
    public static Human choiceHuman(List<Human> humans) {
        Human human = humans.get(Dice.get(0, humans.size() - 1));
        System.out.printf("人間グループから 「%s」 のお出ましだ！\n", human.getName());
        return human;
    }

    // 引数でもらったモンスターグループリストからランダムに1人を選択し、その結果を戻り値とするメソッド
    public static Monster choiceMonster(List<Monster> monsters) {
        Monster monster = monsters.get(Dice.get(0, monsters.size() - 1));
        System.out.printf("モンスターグループから 「%s」 のお出ましだ！\n", monster.getName());
        return monster;
    }

    // 引数でもらった人間グループリストとモンスターグループリストのそれぞれの情報一覧を表示するメソッド
    public static void showGroupInfos(List<Human> humans, List<Monster> monsters) {

        System.out.println("\n## === グループ情報 === ##");
        System.out.printf("# [人間グループ]: %d人\n", humans.size());
        for (Human human : humans) {
            System.out.println(human);
        }

        System.out.printf("\n# [モンスターグループ]: %d人\n", monsters.size());
        for (Monster monster : monsters) {
            System.out.println(monster);
        }
    }

}
