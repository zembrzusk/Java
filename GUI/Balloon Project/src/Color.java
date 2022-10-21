import java.util.Random;

public enum Color {
    //CZERWIENIE
    INDIAN_RED(new java.awt.Color(205,92,92)),
    LIGHT_CORAL(new java.awt.Color(240, 128, 128)),

    //RÓŻE
    PINK(new java.awt.Color(255, 192, 193)),
    LIGHT_PINK(new java.awt.Color(255, 182, 193)),
    PALE_VIOLET_RED(new java.awt.Color(219, 112, 147)),

    //POMARAŃCZE
    LIGHT_SALMON(new java.awt.Color(255, 160, 122)),
    CORAL(new java.awt.Color(255, 127, 80)),

    //ŻÓŁCIE
    GOLD(new java.awt.Color(255, 215, 0)),
    LEMON_CHIFFON(new java.awt.Color(255, 250, 205)),
    PAPAYA_WHIP(new java.awt.Color(255, 239, 213)),
    MOCCASIN(new java.awt.Color(255, 228, 181)),
    PEACH_PUFF(new java.awt.Color(255, 218, 185)),

    //FIOLETY
    LAVENDER(new java.awt.Color(230, 230, 250)),
    PLUM(new java.awt.Color(221, 160, 221)),
    ORCHID(new java.awt.Color(218,112, 214)),

    //ZIELENIE
    PALE_GREEN(new java.awt.Color(152, 251, 152)),
    MEDIUM_AQUAMARINE(new java.awt.Color(102, 205, 170)),

    //BŁEKITY
    PALE_TURQUOISE(new java.awt.Color(175, 238, 238)),
    LIGHT_STEEL_BLUE(new java.awt.Color(176, 196, 222)),
    LIGHT_SKY_BLUE(new java.awt.Color(135, 206, 250)),
    ROYAL_BLUE(new java.awt.Color(65, 105, 225));

    java.awt.Color col;

    Color(java.awt.Color c) {
        this.col = c;
    }

    static Color[] array = values();
    public static Color randomColor() {
        return array[new Random().nextInt(array.length)];
    }
}
