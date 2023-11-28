##  1.８回目の課題　目次
- JDBC
- O/Rマッパー
- MyBatis
- Read処理

## 2.作成したファイルの内容<br>
Makeupテーブルを作成し、検索条件（始まり、終わり、中に含まれる文字）を指定してURL（Carlコマンド）から中のデータを表示できるようにしました。
ポストマンでの動作確認の一例です。
![image](https://github.com/hiro903/Kadai8/assets/145466271/82971041-5875-4be8-9e26-df7c7bc06a13)

![image](https://github.com/hiro903/Kadai8/assets/145466271/d623785f-633b-4228-872a-acb27ef42611)
![image](https://github.com/hiro903/Kadai8/assets/145466271/0bcf3983-82e4-49c5-b2b4-8f5dc2da59ab)
## 3.つまづいたところ<br>

- テーブルの表示はできたがPostmanでURLを入力したら、エラーコード500（サーバー側に発生した問題によって、リクエストが処理されなかったことを示す）が出てきてしまった。IntelliJの赤字エラーは解決していたのでどこで間違えているのか見つけられなかった。

- Mapperインターフェースにおいて、エラーが出た際IntelliJの補完機能をいじっていたら、List<Name>findAll();のあと｛return
null｝が追記されてしまい、意図せずnullが返ってきてしまった。
- 初めて出てくるアノテーションやSQL文の扱い


## 4.解決方法
質問所で質問しそれぞれアドバイスを頂き解決した方法を学習記録も兼ねて記載します。

1.Postmanでエラーコードが表示されたら、SpringBootのログを確認しExceptionのログを確認する。

2.今回はmakeup_databaseのmakeupテーブルが存在しないというエラー。

3.ターミナルにて、**データベースを選択**　`use
   makeup_database;`<br>**テーブル一覧を表示**　 `show
   tables;`入力してテーブルがあるかと、綴りの確認をする。

4.大文字始まりでテーブル名をつけていたので小文字に直す。テーブル名はスネークケース。

5.各アノテーションやメソッド、O/RマッパーやMyBatic、Dockerやデータベースなどの意味などが途中で分からなくなり、使い方や意味を調べた

## 5.学習した内容まとめ

1.**JDBCとは**<br>JavaアプリからDBにアクセスするためのAPI。JavaとDBを繋ぐ通訳みたいな役割、インターフェース。

2.**O/Rマッパーとは**<br>JDBCのコードの冗長化などの問題を解決するツール。Javaのオブジェクトとリレーショナルデータベース（RDB）の間でデータ形式の相互変換を行ってくれる。

3.**MyBatisとは**<br>Javaで利用可能なXMLまたはアノテーションを用いてSQL文をオブジェクトと紐づけるフレームワーク。プログラムからDBを利用する際の処理を簡略化し、O/Rマッパーの機能をもつ

4.**Spring InitializrからREST
APIのプロジェクトを作る。**<br>依存関係の追加が必要。今回は「Spring
Web」「MySQL Driver」「MyBatis
Framework」を追加。依存関係を追加する際は記述を追加するだけでなく追加したライブラリをダウンロードする必要がある。

5.**データベースの構築をする。**<br>ファイル直下にDockerfileなどを配置する。

6.`sql/001-create-table-and-load-data.sql`にはテーブルのデータが記載されている。

7.`docker-compose.yml`　にはデータベースにアクセスするためのPWやデータベース名などが記載されている。データベース名は扱うものに合わせた名前にする。

8.**ターミナルでDockerを起動。**`docker-compose up -d`

9.次に**Spring
   BootからMySQLに接続するための設定をする**<br>src/main/resources
   ディレクトリ配下にある `application.properties`
   へ、{port番号}、{database名}、{ユーザー名}、{パスワード}を`docker-compose.yml`を参考に入力。

10.**MyBatisを使ったファイルを作成する。**<br>ファイル名は扱いたいリソース名 +
Mapperとする。＠MapperアノテーションにDBにどのような操作をするのかメソッドで表現する。クラスではなくインターフェースにすること。SQL文でDBに対する処理を書く。※アノテーション+SQL文ではなく、XMLで記載する場合は、.xmlファイルにすること。

11.**Mapperの戻り値にした（List）のクラスを作る。**<br>今回はDBのレコードに対応したものに定義

12.**Read処理の実装**<br>NameMapperを利用してテーブルからデータを読み取る処理、コントローラーの実装をする。<br>ControllerからMapperを呼び出すようにするには、Mapperをフィールドに持たせる。コンストラクタを作成し、Mapperを引数として受け取るようにする。

13.**@GetMappingはメソッドとGETの処理を行うURLを紐づける役割。**<br>（）内にURLのアクセスコードを書く。<br>メソッド内でDBのどのデータを取ってくるか記載する。

14.List とすることで、レスポンスボディにJSON配列が返却される。<br>findAll
   はメソッド名。（スネークケースにする）

15.**動作確認**<br>Spring Bootを起動し、`$ curl
   localhost:8080/names`でJSONコードが返ってくればOK。

16.次に、**クエリ文字列を指定して検索するAPIを実装。**<br>作ったMapperに追加でメソッドを作成する。前方一致で検索するために、SQLのLIKE句を使う。<br>

17.`@Select("SELECT* FROM names WHERE name LIKE CONCAT(#{name}, '%')")`<br>SELECT * FROM
  names　……names　テーブルのすべてのデータの<br>WHERE name
　……nameカラムから<br>LIKE ……曖昧検索<br>CONCAT(#{name},
  '%')　……複数の文字列を指定された文字列で連結させたもの

18.コントローラーを作成する。@RequestParamアノテーションを付与することで受け取ることができる。メソッド名をfindByNamesとしNameMapperの呼び出すメソッドをfindAllからfindByNameStartingWith
に変更する。

19.検索条件が複数ある場合は、クエリ文字列用のクラスを作成し（NameSearchRequest）Controllerの引
数に指定することもできる。


## 6.今後の課題、気を付けること
DB、Mapper、コントローラーのどこの部分でデータが渡っているの流れ、各アノテーションの役割や書き方・使い方などが曖昧なのでイメージできるようにする。<br>
メソッド名、変数名、引数名などの大文字・小文字・スペルミスなど気を付ける。<br>
変数名はスネークケースにするのが一般的。

## 7.SQL文

|                     SQLクエリ<br/>                     |         意味         |
|:---------------------------------------------------:|:------------------:|
|                SELECT 列名 FROM テーブル名;                |   テーブルから特定の列を抽出    |
|                SELECT * FROM テーブル名;                 |  テーブルのすべてのデータを選択   |
|           SELECT 列名 FROM テーブル名 WHERE 条件;            | 特定の条件を満たすレコードのみを抽出 |
| INSERT INTO テーブル名 (列名1, 列名2, …) VALUES (値1, 値2, …); |   テーブルに新しい行を追加する   |
|             DELETE FROM テーブル名 WHERE 条件;             |    テーブルから行を削除する    |
