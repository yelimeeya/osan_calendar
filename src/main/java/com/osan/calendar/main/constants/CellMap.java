package com.osan.calendar.main.constants;

import java.util.HashMap;
import java.util.Map;

public class CellMap {
    public static final Map<String, CellInfo> CELL_MAP = new HashMap<>();

    static {
        CELL_MAP.put("기본역량셀", new CellInfo("#F4F5EF"));
        CELL_MAP.put("핵심인재셀", new CellInfo("#EBE4F7"));
        CELL_MAP.put("전문역량셀", new CellInfo("#C6EAFF"));
        CELL_MAP.put("PA셀", new CellInfo("#EEF3DC"));
        CELL_MAP.put("그룹사", new CellInfo("#FFCEA1"));
        CELL_MAP.put("지주", new CellInfo("#FDBCE8"));
        CELL_MAP.put("HRD기획셀", new CellInfo("#FFFF9F"));
        CELL_MAP.put("기타", new CellInfo("#F0F0F0"));
        // ... 나머지도 추가
    }

    public static CellInfo getCellInfo(String reservedCell) {
        return CELL_MAP.get(reservedCell);
    }

    // 내부 static 클래스 (또는 별도 파일로 분리 가능)
    public static class CellInfo {
        public final String backgroundColor;

        public CellInfo(String backgroundColor) {
            this.backgroundColor = backgroundColor;
        }
    }
}
