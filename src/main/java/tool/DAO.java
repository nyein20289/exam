package tool;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * DAOクラス
 *
 * DB接続を行う共通クラス
 *
 * 各DAOクラスは
 * このDAOクラスを継承して使用する
 */
public class DAO {

    /*
     * DB接続メソッド
     *
     * H2 Databaseへ接続する
     */
    public Connection getConnection()
            throws Exception {

        // H2 Driver読み込み
        Class.forName("org.h2.Driver");

        // DB接続
        return DriverManager.getConnection(
            "jdbc:h2:~/scoremanager;AUTO_SERVER=TRUE",
            "sa",
            ""
        );
    }
}