// ■クラス名（プログラム上での名称）
//     山札クラス（Deck）
// ■役割
//     山札からのカード取り出しや、残り山札の状態管理を行う。
// ■データ
//     ・card_list（カード52枚のリスト）
//     ・card_index（次に取り出すカード番号）
// ■メソッド
//     GetCard（山札からカードを1枚取り出す）
// ■他クラスとの関係
//     ゲームメインクラス、プレイヤークラスから呼び出され、カードクラスを呼び出す。

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


// カード情報
class Card {
    int suit;   // マーク (0：スペード/1：ハート/２：ダイヤ/３：クラブ)
    int no;     // 数字 (A=1/J=11/Q=12/K=13)
}

// 山札クラス
public class Deck {
    // 定数定義
    final int TOTAL_CARD = 52; //カードの総数

    // メンバ変数定義
    // カードリスト（山札） 0～51の要素を入れ、それぞれマークと数字を割り当てる
    // 0 ～12：スペードA～K / 13～25：ハートA～K / 26～38：ダイヤA～K / 39～51：クラブA～K
    private List<Integer> card_List;

    // 次に取り出すカード番号(1枚引くごとに1加算する)
    private int card_index = 0;

    // コンストラクタ(初期化処理)
    public Deck() {
        // 次に取り出すカード番号を初期化
        card_index = 0; // 1枚目

        // 山札を初期化
        card_List = new ArrayList<>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51));

        // 山札をシャッフルする
        Collections.shuffle(card_List);
    }

    // メソッド定義
    // 山札からカードを1枚取り出し、そのカードのマークと数字をリターンする。
    public Card GetCard() {
        Card card_info = new Card(); // カード情報格納用
        int card_on = 0;             // カード番号

        // カードを一枚取り出して、カード番号(0～51のいずれか)を取得
        card_on = card_List.get(card_index);    // リストの先頭要素を取り出す

        // 1枚取り出したのでカード番号を1加算
        card_index++;

        // 山札をすべて引いた場合、山札を初期化する。
        if( TOTAL_CARD <= card_index ) {
            card_index = 0;
            Collections.shuffle(card_List);
        }

        card_info.suit = card_on / 13;          //マーク = カード番号を13で割った商
        card_info.no = ( card_on % 13 ) + 1;    //数字 = カード番号を13で割った余り + 1

        return card_info;
    }
}
