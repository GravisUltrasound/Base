package ru.milandr.courses.Perepelitsyn;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.IntStream;

public class MakeList {
    public static List<Map<String, String>> makeList(ResultSet rs, List<String> fields) throws SQLException {
        List<Map<String, String>> list = new ArrayList<>();
        IntStream streamI = IntStream.range(1, rs.getRow());
        streamI.forEach(i -> {
            try {
                if (rs.next()) {
                    Map<String, String> map = new HashMap<>();
                    list.add(map);
                    IntStream streamJ = IntStream.range(1, fields.size());
                    streamJ.forEach(j -> {
                        try {
                            map.put(fields.get(j), rs.getString(j + 1));
                        } catch (SQLException e) {
                            e.printStackTrace();
                        }
                    });
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        });
        return list;
    }
}
